package kagoyume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

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
     * ユーザーが存在するか
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー
     * @return ユーザーの存在有無
     */
    public boolean existUser(String userName, String password) throws SQLException{
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

            return rs.next();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){ con.close(); }
        }
    }
}
