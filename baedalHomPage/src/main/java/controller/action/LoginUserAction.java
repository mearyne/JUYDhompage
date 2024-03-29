package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import user.userDAO;

public class LoginUserAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		int log = dao.checkUserLogin(id, pw); // 로그인에 성공하면 1, 실패하면 -1을 반환받는다

		String url;
		HttpSession session = request.getSession();
		if (log != -1) {
			System.out.println("로그인됨");
			session.setAttribute("logCode", "u" + log); // "u1111" 형태로 저장이 된다
			request.setAttribute("chkLogin", "1"); // 메인페이지에서 alert를 띄우는데 쓰인다
			url = "index";
		} else {
			System.out.println("로그인 실패");
			session.setAttribute("logCode", log); // -1로 저장이 된다
			url = "loginUser";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
