package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import user.userDAO;
import user.userDTO;

public class JoinUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		userDAO dao= userDAO.getInstance();
		userDTO user = null;
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int code = dao.chkCode();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name =request.getParameter("name");
		String mobile = request.getParameter("mobile");
		user = new userDTO(code,name,id,pw,mobile);
		String url ="";
		
		if(dao.addUser(user)) {
			url="loginUser";
		}else
		{
			url="join_user.jsp";
		}
		response.sendRedirect(url);
	}
	

}
