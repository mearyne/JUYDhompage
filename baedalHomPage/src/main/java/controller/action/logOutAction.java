package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;

public class logOutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("로그아웃이 실행되었습니다");
		HttpSession session = request.getSession();
		session.removeAttribute("logCode");
		request.getRequestDispatcher("./index").forward(request, response);
	}

}
