package kagoyume;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
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
			boolean islogin = (session.getAttribute(SessionNameSet.LoginUser) != null);

			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");

			if (islogin) {
				// 既にログインしているので、ログアウトする
				// ログイン情報を削除
				session.removeAttribute(SessionNameSet.LoginUser);
				session.removeAttribute(SessionNameSet.LoginUserID);
				// カート情報を削除
				session.removeAttribute(SessionNameSet.CartItems);
			} else {
				// まだログインしていないので、ログインする
				String password = request.getParameter("password");
				String userName = request.getParameter("userName");

				if (userName != null && password != null) {
					int userID = UserDataDAO.getInstance().getUserID(userName, password);
					if (userID >= 0) {
						session.setAttribute(SessionNameSet.LoginUser, userName);
						session.setAttribute(SessionNameSet.LoginUserID, userID);

						String pageURI = (String)session.getAttribute(SessionNameSet.PageURI);
						if (pageURI != null) {
							// ページURIに応じたrdを指定
							rd = request.getRequestDispatcher(pageURI);
						} else {
							// トップページに移動
							rd = request.getRequestDispatcher("/top.jsp");
						}
					} else {
						request.setAttribute("status", "notExist");
					}
				} else {
					// nullが出た場合、statusにnullを入れて遷移先で
					request.setAttribute("status", "null");
				}
			}

			// ページ遷移
			rd.forward(request, response);
		} catch(Exception e) {
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
