package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action;
import shop.shopDAO;
import shop.shopDTO;

public class UpdateShopAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 업데이트에 필요한 값을 받아옴
		String address = (String) request.getParameter("address");
		double shopXTmp = Double.parseDouble((String) request.getParameter("shopX"));
		double shopYTmp = Double.parseDouble((String) request.getParameter("shopY"));
		int shopCode = Integer.parseInt((String) request.getParameter("shopCode"));
		
		// 얻어온 좌표를 6자리까지만 자른다
		double shopX = Double.parseDouble(String.format("%.6f", shopXTmp));
		double shopY = Double.parseDouble(String.format("%.6f", shopYTmp));
		
		// test
		System.out.println("address : "+ address);
		System.out.println("shopX : " + shopX);
		System.out.println("shopY : " + shopY);
	
		// 좌표와 주소값을 업데이트함
		shopDAO shopdao = shopDAO.getInstance();
		shopdao.updateShopInfo(shopCode, address, shopX, shopY);
		
		// 이동
		request.getRequestDispatcher("index").forward(request, response);
	}

}
