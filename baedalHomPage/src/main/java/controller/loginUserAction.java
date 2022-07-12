package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.userDAO;

/**
 * Servlet implementation class loginAction
 */
//@WebServlet("/loginUserAction")
public class loginUserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginUserAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// 로그인이 작동됨
		// 데이터를 넘겨받음. request로 받을 수 있음
		// 받은 아이디와 패스워드를 이용해서 메소드에 대입시킴.
		// checkUserLogin(id, pw);
		// return boolean
		// true라면 로그인이 됨 -> (sesseion에 저장하기) -> index페이지로 이동시키기
		// false라면 로그인 안됨 -> 다시 login페이지로 이동시키기

		userDAO dao = new userDAO();

		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("inputId");
		String pw = request.getParameter("inputPw");

		System.out.println("id : " + id);
		System.out.println("pw : " + pw);

		boolean log = dao.checkUserLogin(id, pw);

		String url;
		if (log == true) {
			System.out.println("로그인됨");
			url = "index";
		} else {
			System.out.println("로그인 실패");
			url = "loginUser";
		}

		request.getRequestDispatcher(url).forward(request, response);


		HttpSession session = request.getSession();
		session.setAttribute("log", id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
