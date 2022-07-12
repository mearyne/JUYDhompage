package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import user.masterDAO;

public class LoginMasterAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// checkMasterLogin(id, pw);

		masterDAO dao = new masterDAO();

		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("inputId");
		String pw = request.getParameter("inputPw");

		System.out.println("id : " + id);
		System.out.println("pw : " + pw);

		boolean log = dao.checkMasterLogin(id, pw);

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

}
