package kagoyume;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.buf.UEncoder;

/**
 * Servlet implementation class BuyComplete
 */
@WebServlet("/BuyComplete")
public class BuyComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		try {
			// セッションの作成
			HttpSession session = request.getSession();
			//アクセスルートチェック
	        String accesschk = request.getParameter("ac");
	        if(accesschk ==null || (Integer)session.getAttribute("ac")!=Integer.parseInt(accesschk)){
	            throw new Exception("不正なアクセスです");
	        }
			// フォームからtypeを取得
			int type = Integer.parseInt(request.getParameter("type"));

			// セッションからカート情報を取得
			ArrayList<ItemData> items =
				(ArrayList<ItemData>)session.getAttribute(SessionNameSet.CartItems);

			// ユーザーIDの取得
			int userID = (Integer)session.getAttribute(SessionNameSet.LoginUserID);
			// 購入商品を追加
			ItemDataDAO.getInstance().insertItems(items, userID, type);
			// 購入金額を計算
			int total = KagoyumeHelper.getInstance().calcTotal(items);
			// ユーザーの総購入金額を更新
			UserDataDAO.getInstance().updateTotal(userID, total);

			// カート情報を削除
			session.removeAttribute(SessionNameSet.CartItems);

			// ページ遷移
			request.getRequestDispatcher("/buycomplete.jsp").forward(request, response);
		} catch (Exception e) {
			// 何かしらエラーが出た場合、エラーページに遷移
			request.setAttribute("error", e.getMessage());
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
