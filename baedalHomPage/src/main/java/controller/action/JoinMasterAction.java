package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import user.masterDAO;
import user.masterDTO;

public class JoinMasterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		masterDAO dao = masterDAO.getInstance();
		masterDTO user = null;

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int code = dao.chkCode();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");

		String url = "";

		user = new masterDTO(code, 0, name, id, pw, mobile);

		if (dao.addUser(user)) {
			url = "loginMaster";
			request.setAttribute("chkJoin", "true");
		} else {
			url = "joinMaster";
			request.setAttribute("chkJoin", "false");
		}

		request.getRequestDispatcher(url).forward(request, response);

	}

}
