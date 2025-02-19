package login;

import java.util.Date;

public class LoginBean {
	
	
	private String user_id;        // 회원아이디
    private String user_pwd;       // 회원비밀번호
    private String user_name;      // 이름
    private String user_phone;     // 전화번호
    private String user_email;     // 이메일
    private Date user_createdtime; // 생성시간
	
    public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public Date getUser_createdtime() {
		return user_createdtime;
	}
	public void setUser_createdtime(Date user_createdtime) {
		this.user_createdtime = user_createdtime;
	}
    
    
}
