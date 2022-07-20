package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import menu.menuDAO;
import menu.menuDTO;

public class AddMenuAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		menuDTO dto;
		menuDAO dao= menuDAO.getInstance();
		int menuCode = dao.menusize();
		int shopCode = Integer.parseInt(request.getParameter("shopCode"));
		String menuname = request.getParameter("name");
		int menuprice = Integer.parseInt(request.getParameter("price"));
		String  contents = request.getParameter("contents");
		String pic = request.getParameter("picture");
		dto = new menuDTO(menuCode, shopCode, menuprice, menuname, pic, contents);
		if(dao.addmenu(dto)) {
			System.out.println("완");
		} else
			System.out.println("실패");
		
		request.getRequestDispatcher("./menuView?shopCode="+shopCode).forward(request, response);
		
	}
	

}
