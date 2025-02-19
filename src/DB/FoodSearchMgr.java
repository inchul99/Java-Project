package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class FoodSearchMgr {

	private static DBConnectionMgr pool = DBConnectionMgr.getInstance();
	
	public static Vector<String[]> searchFood(String keyword){
		Vector<String[]> result = new Vector<String[]>();
		
		//DB연결 객체 선언
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		try {
			con = pool.getConnection();
			
			sql = "SELECT food_name, food_Kcal, carb, protein, fat FROM food_table WHERE food_name LIKE ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%"+ keyword + "%");// Like 검색 적용

			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String[] foodData = new String[5];
				foodData[0] = rs.getString("food_name"); 
				foodData[1] = rs.getBigDecimal("food_Kcal") + "kcal";
				foodData[2] = rs.getBigDecimal("carb") + "g";
				foodData[3] = rs.getBigDecimal("protein") + "g";
				foodData[4] = rs.getBigDecimal("fat") + "g";
				
				result.add(foodData);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return result;
	}
}
