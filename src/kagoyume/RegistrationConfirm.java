package kagoyume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationConfirm
 */

public class RegistrationConfirm extends HttpServlet {
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

			// UserDataBeansのインスタンス化
			UserData userData = new UserData();

			userData.setUserName(request.getParameter("userName"));
			userData.setPassword(request.getParameter("password"));
			userData.chkRePassword(request.getParameter("rePassword"));
			userData.setEmail(request.getParameter("email"));
			userData.setAddress(request.getParameter("address"));

			// セッションにユーザー情報を追加
			session.setAttribute(SessionNameSet.UserData, userData);

			// 入力に不備がある場合、入力画面に戻る
			if (userData.chkProperties().size() > 0) {
				request.getRequestDispatcher("/registration.jsp").forward(request, response);
				return;
			}

			request.getRequestDispatcher("/registrationconfirm.jsp").forward(request, response);
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
