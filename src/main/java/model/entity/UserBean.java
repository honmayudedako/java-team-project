package model.entity;

import java.io.Serializable;

public class UserBean implements Serializable {
	/**
	 * ユーザID
	 */
	private String userId;

	/**
	 * パスワード
	 */
	private String password;

	private boolean authenticated = false;

	private String authorityCode;

	/**
	 * デフォルトコンストラクタ
	 */
	public UserBean() {

	}

	/**
	 * @return userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId セットする userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAuthenticated() {
		return this.authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getAuthorityCode() {
		return authorityCode;
	}

	public void setAuthorityCode(String authorityCode) {
		this.authorityCode = authorityCode;
	}
}
