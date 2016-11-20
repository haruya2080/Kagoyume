package kagoyume;

import java.util.ArrayList;

/**
 * 画面系の処理や表示を簡略化するためのヘルパークラス。定数なども保存されます
 * @author hayashi-s
 */
public class KagoyumeHelper {
    //トップへのリンクを定数として設定
    private final String homeURL = "top.jsp";

    public static KagoyumeHelper getInstance(){
        return new KagoyumeHelper();
    }

    //トップへのリンクを返却
    public String home(){
        return "<a href=\""+homeURL+"\">トップへ戻る</a>";
    }
    /**
     * ログインボタンをヘッダーに表示する必要があるかチェック
     * @param pageName
     * @return
     */
    public boolean checkHeaderLoginBtn (String pageName) {
    	if (pageName == null) { return true; }
    	if (pageName.equals("login")) { return false; }
    	if (pageName.equals("registration")) { return false; }
    	if (pageName.equals("registrationConfirm")) { return false; }
    	return true;
    }

    /**
     * 新規登録ボタンをヘッダーに表示する必要があるかチェック
     * @param pageName
     * @return
     */
    public boolean checkHeaderRegistrationBtn (String pageName) {
    	if (pageName == null) { return true; }
    	if (pageName.equals("login")) { return false; }
    	if (pageName.equals("registration")) { return false; }
    	if (pageName.equals("registrationConfirm")) { return false; }

    	return true;
    }

    /**
     * 商品の合計金額を算出する
     * @param items
     * @return total
     */
    public int calcTotal (ArrayList<ItemData> items) {
    	int total = 0;
    	for (ItemData item : items) {
    		total += item.getValue();
    	}

    	return total;
    }

    /**
     * ユーザー名の未入力チェック
     * @param chkList
     * @return
     */
    public String chkUserName (ArrayList<String> chkList) {
    	return (chkList.contains("userName")) ? "※ユーザー名が入力されていません" : "";
    }

    /**
     * パスワードの未入力チェック
     * @param chkList
     * @return
     */
    public String chkPassword (ArrayList<String> chkList) {
    	return (chkList.contains("password")) ? "※パスワードが入力されていません" : "";
    }

    /**
     * 確認パスワードの一致チェック
     * @param chkList
     * @return
     */
    public String chkRePassword (ArrayList<String> chkList) {
    	return (chkList.contains("notMatchPass")) ? "※確認パスワードが一致しません" : "";
    }

    /**
     * メールアドレスの未入力チェック
     * @param chkList
     * @return
     */
    public String chkEmail (ArrayList<String> chkList) {
    	return (chkList.contains("email")) ? "※メールアドレスが入力されていません" : "";
    }

    /**
     * 住所の未入力チェック
     * @param chkList
     * @return
     */
    public String chkAddress (ArrayList<String> chkList) {
    	return (chkList.contains("address")) ? "※住所が入力されていません" : "";
    }

    /**
     * 配送方法を数値から変換
     * @param type
     * @return
     */
    public String exShippingType (int type) {
    	switch (type) {
    	case 1 :
    		return "宅配便";
    	case 2 :
    		return "コンビニ受け取り";
    	}

    	return "その他";
    }
}
