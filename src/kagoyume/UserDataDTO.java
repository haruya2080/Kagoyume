package kagoyume;

import java.sql.Timestamp;

public class UserDataDTO {
	private String name;
	private String password;
	private String mail;
	private String address;
	private int total;
	private Timestamp newDate;
	private boolean deleteFlag;
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail セットする mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
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
	 * @return total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total セットする total
	 */
	public void setTotal(int total) {
		this.total = total;
	}
	/**
	 * @return newDate
	 */
	public Timestamp getNewDate() {
		return newDate;
	}
	/**
	 * @param newDate セットする newDate
	 */
	public void setNewDate(Timestamp newDate) {
		this.newDate = newDate;
	}
	/**
	 * @return deleteFlag
	 */
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	/**
	 * @param deleteFlag セットする deleteFlag
	 */
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


}
