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
		double shopXTmp = Double.parseDouble(request.getParameter("shopX"));
		double shopYTmp = Double.parseDouble(request.getParameter("shopY"));
		int shopCode = Integer.parseInt(request.getParameter("shopCode"));
		String chkDupl = request.getParameter("chkDupl"); // 새롭게 생성되는지 아니면 업데이트되는지 여부를 판단하는 변수
		int masterCode = Integer.parseInt(request.getParameter("masterCode"));
		
		// test
		System.out.println("chkDupl : " + chkDupl);
		
		String shopName = (String) request.getParameter("shopName");
		String shopCategory = (String) request.getParameter("shopCategory");
		String shopPic = (String) request.getParameter("shopPic");
		String shopPhone = (String) request.getParameter("shopPhone");
		String shopContents = (String) request.getParameter("shopContents");
		
		// 얻어온 좌표를 6자리까지만 자른다
		double shopX = Double.parseDouble(String.format("%.6f", shopXTmp));
		double shopY = Double.parseDouble(String.format("%.6f", shopYTmp));
		
		// test
		System.out.println("address : "+ address);
		System.out.println("shopX : " + shopX);
		System.out.println("shopY : " + shopY);

		
		// 좌표와 주소값을 업데이트함
		shopDAO shopdao = shopDAO.getInstance();
		if (chkDupl.equals("true")) {
			shopDTO shopDTO = new shopDTO(shopCode, shopName, shopCategory, address, shopPic, shopPhone, shopContents, shopX, shopY);
			shopdao.updateShopInfo(shopDTO);
		} else {
			shopDTO shopDTO = new shopDTO(shopCode, masterCode, shopName, shopCategory, address, shopPic, shopPhone, shopContents, 0, 0, shopX, shopY);
			shopdao.createShopDTO(shopDTO);
		}
		
		
		// 이동
		request.getRequestDispatcher("index").forward(request, response);
	}

}
