package kagoyume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import base.DBManager;

public class UserDataDAO {
	//インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }

	/**
	 * データの挿入処理を行う。現在時刻は挿入直前に生成
	 *
	 * @param ud
	 *            対応したデータを保持しているJavaBeans
	 * @throws SQLException
	 *             呼び出し元にcatchさせるためにスロー
	 */
	public void insertUser (UserDataDTO ud) throws SQLException {
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = DBManager.getConnection();
			st = con.prepareStatement(
					"INSERT INTO user_t(name,password,mail,address,total,newDate) VALUES(?,?,?,?,?,?)");
			st.setString(1, ud.getName());
			st.setString(2, ud.getPassword());
			st.setString(3, ud.getMail());
			st.setString(4, ud.getAddress());
			st.setInt(5, 0);
			st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
			st.executeUpdate();
			System.out.println("insert completed");
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
     * ユーザーが存在する場合、そのIDを返す。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return ユーザーの存在有無
     */
    public int getUserID(String userName, String password) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();

            String sql = "SELECT * FROM user_t WHERE name = ? AND password = ?";

            st =  con.prepareStatement(sql);
            st.setString(1, userName);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();

            System.out.println("searchByID completed");

            //System.out.println("ExistResultSetNext : " + rs.next());

            while (rs.next()) {
            	// 削除フラグがないユーザーに限定
            	if (rs.getInt("deleteFlag") == 0) {
            		return rs.getInt("userID");
            	}
            }

            // ユーザーが見つからなかった場合、-1を返す
            return -1;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){ con.close(); }
        }
    }

    /**
     * データの検索処理を行う。
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> search() throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();

            //
            String sql = "SELECT * FROM user_t";
            st =  con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            // 複数の結果を格納するリスト
            ArrayList<UserDataDTO> resultDatas = new ArrayList<UserDataDTO>();
            while (rs.next()) {
            	UserDataDTO resultUd = new UserDataDTO();
                resultUd.setName(rs.getString(2));
                resultUd.setPassword(rs.getString(3));
                resultUd.setMail(rs.getString(4));
                resultUd.setAddress(rs.getString(5));
                resultUd.setTotal(rs.getInt(6));
                resultUd.setNewDate(rs.getTimestamp(7));
                resultUd.setDeleteFlag(rs.getInt(8) != 0);

                resultDatas.add(resultUd);
            }

            System.out.println("search completed");

            return resultDatas;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){ con.close(); }
        }
    }

    public UserDataDTO searchByUserID (int userID) throws SQLException {
    	Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();

            //
            String sql = "SELECT * FROM user_t where userID = ?";
            st =  con.prepareStatement(sql);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();

            // 複数の結果を格納するリスト
            UserDataDTO resultData = new UserDataDTO();
            rs.next();
            resultData.setName(rs.getString(2));
            resultData.setPassword(rs.getString(3));
            resultData.setMail(rs.getString(4));
            resultData.setAddress(rs.getString(5));
            resultData.setTotal(rs.getInt(6));
            resultData.setNewDate(rs.getTimestamp(7));
            resultData.setDeleteFlag(rs.getInt(8) != 0);

            System.out.println("search completed");

            return resultData;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){ con.close(); }
        }
    }

    /**
     * データの更新処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     */
    public void update(UserDataDTO ud, int userID) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "UPDATE user_t SET "
            		+ "name = ?, "
            		+ "password = ?, "
            		+ "mail = ?, "
            		+ "address = ?, "
            		+ "newDate = ? "
            		+ "WHERE userID = ?";

            st = con.prepareStatement(sql);

            st.setString(1, ud.getName());
            st.setString(2, ud.getPassword());
            st.setString(3, ud.getMail());
            st.setString(4, ud.getAddress());
            st.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            st.setInt(6, userID);

            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){ con.close(); }
        }
    }

    /**
     * ユーザーIDの総購入金額を更新
     * @param userID
     * @param total
     */
    public void updateTotal (int userID, int total) throws SQLException {
    	Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "UPDATE user_t SET "
            		+ "total = total + ? "
            		+ "WHERE userID = ?";

            st = con.prepareStatement(sql);

            st.setInt(1, total);
            st.setInt(2, userID);

            st.executeUpdate();
            System.out.println("update total completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){ con.close(); }
        }
    }

    /**
     * IDで指定したユーザーにデリートフラグをセット
     * @param userID
     */
    public void setDeleteFlag (int userID) throws SQLException {
    	Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            String sql = "UPDATE user_t SET "
            		+ "deleteFlag = 1 "
            		+ "WHERE userID = ?";

            st = con.prepareStatement(sql);
            st.setInt(1, userID);

            st.executeUpdate();
            System.out.println("update deleteFlag completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){ con.close(); }
        }
    }
}
