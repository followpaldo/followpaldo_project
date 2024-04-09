package jjon.gangsan.model;


import org.apache.ibatis.type.Alias;

//import lombok.Data;
//
//@Data

@Alias("member")
public class MemberVo {
	private String userId;
	private String userPw;
	private String userPhone;
	private String userName;
	private String userJumin;
	private String userEmail;
	private String userGender;
	private int kakao;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserJumin() {
		return userJumin;
	}
	public void setUserJumin(String userJumin) {
		this.userJumin = userJumin;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public int getKakao() {
		return kakao;
	}
	public void setKakao(int kakao) {
		this.kakao = kakao;
	}
	
	
	
}
