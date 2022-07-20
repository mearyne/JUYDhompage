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
		int chkorder = dao.addOrder(dto); // 추가를 성공하면 1, 실패하면 -1 반환
		
		if(chkorder == 1) {
			System.out.println("주문 완료");
		}else
			System.out.println("주문 실패");
		
		request.setAttribute("chkorder", chkorder);
		request.getRequestDispatcher("./shop?shopCode="+shopCode).forward(request, response);
		
		
	}

}
