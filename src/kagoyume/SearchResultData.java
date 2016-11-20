package kagoyume;

import java.util.ArrayList;

public class SearchResultData {
	private String keyword;
	private int count;
	private ArrayList<ItemData> items;

	/**
	 * コンストラクタ
	 */
	public SearchResultData () {
		this.keyword = "";
		this.count = 0;
		this.items = new ArrayList<ItemData>();
	}

	/**
	 * 商品を追加する
	 * @param item
	 */
	public void addItem (ItemData item) {
		items.add(item);
	}

	/**
	 * 商品をidから取得する
	 * @param id
	 * @return item 商品
	 */
	public ItemData getItem (int id) {
		return items.get(id);
	}

	/**
	 * @return keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword セットする keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return items
	 */
	public ArrayList<ItemData> getItems() {
		return items;
	}

	/**
	 * @param items セットする items
	 */
	public void setItems(ArrayList<ItemData> items) {
		this.items = items;
	}

	/**
	 * @return count
	 */
	public String getCountTxt() {
		return String.valueOf(count);
	}

	/**
	 *
	 * @return count
	 */
	public int getCount () {
		return count;
	}

	/**
	 * @param count セットする count
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 *
	 * @param count
	 */
	public void setCount(String count) {
		try {
			this.count = Integer.parseInt(count);
		} catch (NumberFormatException e) {
			System.out.println(e.toString());
		}
	}
}
