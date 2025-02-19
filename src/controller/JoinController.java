package controller;

import DB.JoinDAO;
import model.UserBean;
import ui_n_utils.*;


import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JoinController {
    private static final Logger LOGGER = Logger.getLogger(JoinController.class.getName());

    private final JoinDAO joinDAO;

    public JoinController() {
        this.joinDAO = new JoinDAO();
    }

    public boolean registerUser(JFrame parent, UserBean user) {
        try {
            if (user.getUser_id().isEmpty() || user.getUser_pwd().isEmpty() ||
                user.getUser_name().isEmpty() || user.getUser_phone().isEmpty() ||
                user.getUser_email().isEmpty()) {
                CustomDialog.showDialog(parent, "모든 필수 입력 사항을 입력해주세요.", "회원가입 오류");
                return false;
            }

            // 아이디 유효성 검사
            if (!ValidationUtils.isValidUserId(user.getUser_id())) {
                CustomDialog.showDialog(parent, "아이디는 6~20자의 영문, 숫자, 특수문자 조합이어야 합니다.", "회원가입 오류");
                return false;
            }
            
            
            
            // 비밀번호 유효성 검사
            if (!ValidationUtils.isCreateUserPw(user.getUser_pwd())) {
                CustomDialog.showDialog(parent, "비밀번호는 영문(대소문자) + 특수문자를 포함한 6~20자여야 합니다.", "회원가입 오류");
                return false;
            }

            // 이메일 형식 검사
            if (!ValidationUtils.isValidEmail(user.getUser_email())) {
                CustomDialog.showDialog(parent, "이메일 양식이 올바르지 않습니다.", "회원가입 오류");
                return false;
            }

            // 전화번호 형식 검사
            if (!ValidationUtils.isValidPhone(user.getUser_phone())) {
                CustomDialog.showDialog(parent, "올바른 전화번호 형식을 입력하세요. 예) 010-1234-5678", "회원가입 오류");
                return false;
            }

            // 아이디 중복 확인
            if (joinDAO.isUserIdExists(user.getUser_id())) {
                CustomDialog.showDialog(parent, "이미 사용 중인 아이디입니다.", "회원가입 오류");
                return false;
            }

            // 회원가입 처리
            boolean isJoinSuccess = joinDAO.joinUser(user);
            if (isJoinSuccess) {
                CustomDialog.showDialog(parent, user.getUser_id() + "님 환영합니다! 회원가입이 완료되었습니다!", "회원가입 완료");
                return true;
            } else {
                CustomDialog.showDialog(parent, "회원가입에 실패했습니다. 다시 시도해주세요.", "회원가입 오류");
                return false;
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "회원가입 중 오류 발생", e);
            CustomDialog.showDialog(parent, "예기치 않은 오류가 발생했습니다.", "회원가입 오류");
            return false;
        }
    }
}
