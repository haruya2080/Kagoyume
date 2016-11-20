package kagoyume;

import java.sql.Timestamp;

public class ItemDataDTO {
	private int userID;
	private String itemCode;
	private int type;
	private Timestamp buyDate;
	/**
	 * @return userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID セットする userID
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return itemCode
	 */
	public String getItemCode() {
		return itemCode;
	}
	/**
	 * @param itemCode セットする itemCode
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	/**
	 * @return type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type セットする type
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return buyDate
	 */
	public Timestamp getBuyDate() {
		return buyDate;
	}
	/**
	 * @param buyDate セットする buyDate
	 */
	public void setBuyDate(Timestamp buyDate) {
		this.buyDate = buyDate;
	}


}
