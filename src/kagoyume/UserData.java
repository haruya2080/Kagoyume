package kagoyume;

public class UserData {
	private String userName;
	private String password;
	private String email;
	private String address;

	/**
	 * コンストラクタ
	 */
	public UserData () {
		this.userName = "";
		this.password = "";
		this.email = "";
		this.address = "";
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
}
