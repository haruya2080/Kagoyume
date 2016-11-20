package kagoyume;

import java.util.ArrayList;

public class UserData {
	private String userName;
	private String password;
	private String email;
	private String address;
	private boolean notMatchPass;

	/**
	 * コンストラクタ
	 */
	public UserData () {
		this.userName = "";
		this.password = "";
		this.email = "";
		this.address = "";
		this.notMatchPass = false;
	}

	/**
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName セットする userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	/**
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email セットする email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return notMatchPass
	 */
	public boolean isNotMatchPass() {
		return notMatchPass;
	}

	/**
	 * 再入力パスワードが一致しているか
	 * @param rePassword
	 */
	public void chkRePassword (String rePassword) {
		// 再入力パスワードとパスワードが一致しているか
		notMatchPass = !(this.password.equals(rePassword));
	}

	/**
	 * DTOへマッピング
	 * @param dto
	 */
	public void mappingToDTO (UserDataDTO dto) {
		dto.setName(this.userName);
		dto.setPassword(this.password);
		dto.setMail(this.email);
		dto.setAddress(this.address);
	}

	/**
	 * DTOからマッピング
	 * @param dto
	 */
	public void mappingFromDTO (UserDataDTO dto) {
		this.userName = dto.getName();
		this.password = dto.getPassword();
		this.email = dto.getMail();
		this.address = dto.getAddress();
	}

	public ArrayList<String> chkProperties () {
		ArrayList<String> chkList = new ArrayList<String>();

		if (userName.isEmpty()) {
			chkList.add("userName");
		}

		if (password.isEmpty()) {
			chkList.add("password");
		}

		if (notMatchPass) {
			chkList.add("notMatchPass");
		}

		if (email.isEmpty()) {
			chkList.add("email");
		}

		if (address.isEmpty()) {
			chkList.add("address");
		}

		return chkList;
	}
}
