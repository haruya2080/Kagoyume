package kagoyume;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Search
 */

public class Search extends HttpServlet {
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

		// 検索ワードをトップから取得
		String keyword = request.getParameter("keyword");
		// System.out.println("keyword : " + keyword);

		// YahooAPIで指定したキーワードを検索
		ArrayList<ItemData> items = YahooAPIManager.searchItems(keyword);

		// セッションの作成
		HttpSession session = request.getSession(true);

		// セッションに商品を格納
		session.setAttribute(SessionNameSet.SearchItems, items);
		// ログインから戻る際にアクセスするページをセッションに保存
		session.setAttribute(SessionNameSet.PageURI, "/search.jsp");

		// jspファイルに遷移
		request.getRequestDispatcher("/search.jsp").forward(request, response);
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
