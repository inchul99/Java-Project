package UIutils;

import java.util.regex.Pattern;

public class ValidationUtils {
    // 아이디 양식 검사
    public static boolean isValidUserId(String userId) {
        // 영문 대소문자, 숫자, 특수문자 중 하나 이상 포함된 6~20자의 아이디
        return Pattern.matches("^[A-Za-z0-9@#$%^&+=*!?]{6,20}$", userId);
    }
    
    //비밀번호 양식검사
    public static boolean isCreateUserPw(String userPw) {
        // 영문 대소문자와 특수문자가 반드시 포함된 6~20자의 아이디
        return Pattern.matches("^(?=.*[A-Za-z])(?=.*[@#$%^&+=*!?])[A-Za-z0-9@#$%^&+=*!?]{6,20}$", userPw);
    }
    
    //이메일 양식검사
    public static boolean isValidEmail(String email) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailPattern, email);
    }
    
    public static boolean isValidPhone(String phone) {
    	String phonePattern = "^010-\\d{4}-\\d{4}$";
        return Pattern.matches(phonePattern, phone);
    }
}
