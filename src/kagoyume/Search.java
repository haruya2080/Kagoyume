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
	private final String pageName = "/search.jsp";

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
			// 検索ワードをトップから取得
			String keyword = request.getParameter("keyword");
			// System.out.println("keyword : " + keyword);

			String pageTxt = request.getParameter("page");

			int page = 0;
			if (pageTxt != null) {
				page = Integer.parseInt(pageTxt);
			}

			// YahooAPIで指定したキーワードを検索
			SearchResultData searchResult = YahooAPIManager.searchItems(keyword, page);

			// 現在のページを保存
			searchResult.setPage(page);

			// セッションの作成
			HttpSession session = request.getSession(true);

			// セッションに商品を格納
			session.setAttribute(SessionNameSet.SearchResult, searchResult);
			// 検索キーワードをセッションに保存
			session.setAttribute(SessionNameSet.SearchKeyword, keyword);
			// ログインから戻る際にアクセスするページをセッションに保存
			session.setAttribute(SessionNameSet.PageURI, pageName);
			// jspファイルに遷移
			request.getRequestDispatcher(pageName).forward(request, response);
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
