package kagoyume;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cart
 */
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String pageName = "/cart.jsp";

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
		HttpSession session = request.getSession();

		String action = request.getParameter("action");
		if (action != null) {
			switch (action) {
			case "delete" :
				int id = Integer.parseInt(request.getParameter("id"));
				ArrayList<ItemData> cartItems =
					(ArrayList<ItemData>)session.getAttribute(SessionNameSet.CartItems);
				// カートの商品をidから削除
				cartItems.remove(id);
				// セッションを更新
				session.setAttribute(SessionNameSet.CartItems, cartItems);

				break;
			case "allDelete" :
				// セッションからカートの情報を削除
				session.removeAttribute(SessionNameSet.CartItems);
				break;
			}
		}

		// ログインから戻る際にアクセスするページをセッションに保存
		session.setAttribute(SessionNameSet.PageURI, pageName);

		session.setAttribute("ac", (int) (Math.random() * 1000));

		// カート画面に遷移
		request.getRequestDispatcher(pageName).forward(request, response);
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
