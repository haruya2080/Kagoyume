package kagoyume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationResult
 */
@WebServlet("/RegistrationResult")
public class RegistrationResult extends HttpServlet {
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

			// ユーザー情報をセッションから取得
			UserData userData = (UserData)session.getAttribute(SessionNameSet.UserData);

			if (userData != null) {
				UserDataDTO dto = new UserDataDTO();
				// DTOにマッピング
				userData.mappingToDTO(dto);
				// ユーザー情報をSQLにインサート
				UserDataDAO.getInstance().insertUser(dto);
				// セッションからユーザー情報を削除
				session.removeAttribute(SessionNameSet.UserData);
			}
			// 結果ページに表示するユーザー名をjspに送る
			request.setAttribute("userName", userData.getUserName());
			// 結果ページに遷移
			request.getRequestDispatcher("/registrationresult.jsp").forward(request, response);
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
