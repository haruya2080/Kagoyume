package kagoyume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class YahooAPIManager {
	private static final String BASE_URI = "http://shopping.yahooapis.jp/ShoppingWebService/V1/json/itemSearch";
	private static final String APP_ID = "dj0zaiZpPUF6OFExZWEyenFHVyZzPWNvbnN1bWVyc2VjcmV0Jng9MGQ-";

	/**
	 * 商品をキーワードから検索
	 * @param searchWord 検索キーワード
	 * @return 商品データの配列
	 * @throws IOException
	 */
	public static SearchResultData searchItems (String searchWord)
			throws IOException {
		String json = getJsonFromAPI(searchWord);

		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(json);

		SearchResultData resultData = new SearchResultData();

		// "ResultSet"をノードとして取得
		JsonNode resultSetNode = rootNode.get("ResultSet");

		// 検索結果数を取得
		String countTxt = resultSetNode.get("totalResultsAvailable").asText();
		resultData.setCount(countTxt);
		resultData.setKeyword(searchWord);

		// 検索結果が存在しない場合
		if (countTxt.equals("0")) { return resultData; }

		// "ResultSet.0.Result"をノードとして取得
		JsonNode resultNode = resultSetNode.get("0").get("Result");

		for (int i=0; i<20; i++) {
			JsonNode itemNode = resultNode.get(String.valueOf(i));

			ItemData itemData = new ItemData();
			itemData.setName(itemNode.get("Name").asText());
			itemData.setItemCode(itemNode.get("Code").asText());
			itemData.setDescription(itemNode.get("Description").asText());
			itemData.setValue(itemNode.get("Price").get("_value").asText());
			itemData.setImageURI(itemNode.get("Image").get("Medium").asText());
			// 検索結果にアイテムを追加
			resultData.addItem(itemData);


		}

		return resultData;
	}

	/**
	 * APIからJson文字列を取得
	 * @param keyword 検索キーワード
	 * @return json文字列
	 */
	private static String getJsonFromAPI (String keyword) {
		try {
			URL url = new URL(BASE_URI + "?appid=" + APP_ID + "&query=" + keyword + "&hits=20");
			HttpURLConnection urlConn = (HttpURLConnection)url.openConnection();

			urlConn.setRequestMethod("GET");
			urlConn.setInstanceFollowRedirects(false);

			// ここで繋げられる
			urlConn.connect();

			BufferedReader reader =
				new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

			StringBuffer responseBuffer = new StringBuffer();
			while (true) {
				String line = reader.readLine();
				if ( line == null ){
					break;
				}
				responseBuffer.append(line);
			}

			reader.close();
			urlConn.disconnect();

			return responseBuffer.toString();
		} catch (Exception e) {
			// エラー文の表示s
			System.out.println("YahooAPI取得でエラー：" + e.toString());
		}
		return null;
	}
}
