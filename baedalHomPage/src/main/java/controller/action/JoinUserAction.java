package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import user.userDAO;
import user.userDTO;

public class JoinUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		userDAO dao = userDAO.getInstance();
		userDTO user = null;

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int code = dao.chkCode();
		if (code != -1) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String name = request.getParameter("name");
			String mobile = request.getParameter("mobile");
			user = new userDTO(code, name, id, pw, mobile);
			String url = "";
			
			if (dao.chkDuplId(id) && dao.addUser(user)) {
				url = "loginUser";
				request.setAttribute("chkJoin", "true");
			} else {
				url = "joinUser";
				request.setAttribute("chkJoin", "false");
			}

			request.getRequestDispatcher(url).forward(request, response);
			
		} else
			System.out.println("중복코드");
	}

	

}
