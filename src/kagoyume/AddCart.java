package kagoyume;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/AddCart")
public class AddCart extends HttpServlet {
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

		// セッションの作成
		HttpSession session = request.getSession(true);
		// 現在、選択中の商品を取得
		ItemData selectItem = (ItemData)session.getAttribute(SessionNameSet.SelectItem);
		// カートの商品を取得
		ArrayList<ItemData> cartItems =
			(ArrayList<ItemData>)session.getAttribute(SessionNameSet.CartItems);

		// カートがnullのときに新たにインスタンスを生成
		if (cartItems == null) { cartItems = new ArrayList<ItemData>(); }

		// 選択中の商品をカートに追加
		cartItems.add(selectItem);
		// セッションを更新
		session.setAttribute(SessionNameSet.CartItems, cartItems);
		// カートページに遷移
		request.getRequestDispatcher("/add.jsp").forward(request, response);
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
