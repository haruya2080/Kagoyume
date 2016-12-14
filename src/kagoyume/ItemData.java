package kagoyume;

import java.io.Serializable;

public class ItemData implements Serializable {
	private String name;
	private String itemCode;
	private String description;
	private int value;
	private String imageURI;
	private int count;

	/**
	 * コンストラクタ
	 */
	public ItemData () {
		this.name = "";
		this.itemCode = "";
		this.description = "";
		this.value = -1;
		this.imageURI = "";
	}

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
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description セットする description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return value
	 */
	public int getValue() {
		return value;
	}
	/**
	 * @param value セットする value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 *
	 * @param value
	 */
	public void setValue (String value) {
		try {
			this.value = Integer.parseInt(value);
		} catch (Exception e) {
			System.out.print(e.toString());
		}
	}
	/**
	 * @return imageURI
	 */
	public String getImageURI() {
		return imageURI;
	}
	/**
	 * @param imageURI セットする imageURI
	 */
	public void setImageURI(String imageURI) {
		this.imageURI = imageURI;
	}

	/**
	 * @return count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count セットする count
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
