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

		int log = dao.checkMasterLogin(id, pw);

		String url;
		HttpSession session = request.getSession();
		if (log != -1) {
			System.out.println("로그인됨");
			session.setAttribute("logCode", "m"+log); // "u1111" 형태로 저장이 된다
			request.setAttribute("chkLogin", "1"); // 메인페이지에서 alert를 띄우는데 쓰인다
			url = "index";
		} else {
			System.out.println("로그인 실패");
			session.setAttribute("logCode", log); // -1이 저장된다
			url = "loginMaster";
		}

		request.getRequestDispatcher(url).forward(request, response);

		// session.setAttribute("log", id); // 이건 어디에 쓰이지?
	}

}
