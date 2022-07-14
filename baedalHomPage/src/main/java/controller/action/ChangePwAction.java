package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import user.masterDAO;
import user.userDAO;
import user.userDTO;

public class ChangePwAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
//		int userCode = Integer.parseInt((String) request.getAttribute("userCode")); // 유저코드
		int userCode = 1239; // 유저코드
		System.out.println(userCode);
		userDAO dao = userDAO.getInstance();
		userDTO user = dao.getData(userCode);
		
		String pw = request.getParameter("pw");
		String chPw = request.getParameter("changePw");
		String doubleChkPw = request.getParameter("douChkPw");
		
		System.out.println("pw "+pw);
		System.out.println("chPw "+chPw);
		System.out.println("doubleChkPw "+doubleChkPw);
		
//		String uCode = (String) session.getAttribute("userCode");	
		
		System.out.println("userCode"+userCode);
		
		String url ="";
		String uCode=String.valueOf(userCode);
		
		if(dao.updatePw(uCode,pw,chPw,doubleChkPw)) {
			url="mypage";
		}else {
			url="index.jsp";
		}


		response.sendRedirect(url);
		
	}

}
