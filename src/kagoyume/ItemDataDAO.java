package kagoyume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import base.DBManager;

public class ItemDataDAO {
	//インスタンスオブジェクトを返却させてコードの簡略化
    public static ItemDataDAO getInstance(){
        return new ItemDataDAO();
    }

	/**
	 * データの挿入処理を行う。現在時刻は挿入直前に生成
	 *
	 * @param ud
	 *            対応したデータを保持しているJavaBeans
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public void insertItems (ArrayList<ItemData> items, int userID, int type) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			for (ItemData item : items) {
				st = con.prepareStatement(
						"INSERT INTO buy_t(userID,itemCode,type,buyDate) VALUES(?,?,?,?)");
				st.setInt(1, userID);
				st.setString(2, item.getItemCode());
				st.setInt(3, type);
				st.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				st.executeUpdate();
			}
			System.out.println("insert items completed");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new SQLException(e);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}


	 /**
     * ユーザーIDによる商品の検索処理を行う。
     * @param userID UserID
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
	public ArrayList<ItemDataDTO> getItemsByUserID (int userID) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();

            String sql = "SELECT * FROM buy_t WHERE userID = ?";

            st =  con.prepareStatement(sql);
            st.setInt(1, userID);

            ResultSet rs = st.executeQuery();

            ArrayList<ItemDataDTO> items = new ArrayList<ItemDataDTO>();

            while (rs.next()) {
            	ItemDataDTO item = new ItemDataDTO();
                item.setItemCode(rs.getString(3));
                item.setType(rs.getInt(4));
                item.setBuyDate(rs.getTimestamp(5));

                items.add(item);
            }

            System.out.println("searchByID completed");

            return items;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){ con.close(); }
        }
	}
}
