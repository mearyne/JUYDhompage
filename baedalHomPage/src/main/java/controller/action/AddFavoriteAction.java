package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import favorite.favoriteDAO;
import favorite.favoriteDTO;

public class AddFavoriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		favoriteDTO dto ;
		favoriteDAO dao  = favoriteDAO.getInstance();
		
		int favoriteCode = dao.favoritesize()+1;
		int userCode = Integer.parseInt(request.getParameter("usercode")) ;
		int shopCode = Integer.parseInt(request.getParameter("shopcode")) ;
		
		dto = new favoriteDTO(favoriteCode, userCode, shopCode);
		
		int chkfavo = dao.chkfav(shopCode, userCode); // 등록에 실패하면 1, 등록에 성공하면 -1
		
		if(chkfavo != 1) { // 이미 찜 상태가 아니다
			dao.addfavorite(dto);
			System.out.println("찜 추가!");
		} else {
			System.out.println("이미 있습니다.");
		}
		// test 
		System.out.println("chkfavo : " + chkfavo);
		
		request.setAttribute("chkfavo", chkfavo);
		request.getRequestDispatcher("./shop?shopCode="+shopCode).forward(request, response);
		
	}

}
