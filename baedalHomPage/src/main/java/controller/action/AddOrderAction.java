package controller.action;

import java.io.IOException;
import java.security.Timestamp;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import order.orderDAO;
import order.orderDTO;

public class AddOrderAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		orderDAO dao = orderDAO.getInstance();
		orderDTO dto =null;
		
		int code = dao.ordersize()+1;
		int userCode = Integer.parseInt(request.getParameter("usercode")) ;
		int shopCode = Integer.parseInt(request.getParameter("shopcode")) ;
		int year = Integer.parseInt(request.getParameter("year"));
		int month = Integer.parseInt(request.getParameter("month"));
		int day = Integer.parseInt(request.getParameter("date")) ;
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		
		
		dto = new orderDTO(code, userCode, shopCode, year,month,day);
		if(dao.addOrder(dto)) {
			System.out.println("주문 완료");
		}else
			System.out.println("주문 실패");
		
		
		request.getRequestDispatcher("./shop?shopCode="+shopCode).forward(request, response);
		
		
	}

}
