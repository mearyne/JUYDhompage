package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import menu.menuDAO;
import menu.menuDTO;

public class DeleteMenuAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		menuDTO dto;
		menuDAO dao= menuDAO.getInstance();
		
		int menuCode = Integer.parseInt(request.getParameter("menucode"));
		
		System.out.println("menucodemenucodemenucodemenucodemenucodemenucode : " + menuCode);
		String logCode = request.getParameter("logCode");
		
		boolean chk = dao.deletemunu(menuCode);
		if(chk)
			System.out.println("성공");
		
		if (chk) {
			request.setAttribute("chkDel",1);
		} else {
			request.setAttribute("chkDel",-1);
		}
		request.getRequestDispatcher("./menuView?logCode="+logCode).forward(request, response);
		
	}

}
