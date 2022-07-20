package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import qna.QnaDAO;
import qna.QnaDTO;

public class QnaDeleteAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		int no = Integer.parseInt(request.getParameter("no"));

		QnaDAO dao = QnaDAO.getInstance();

		int chk = dao.delete(no);
		if (chk == 1) {
			System.out.println("삭제 완료료료료료료료료료료료");
			
		} else {
			System.out.println("삭제 실패패패패ㅐ패패패패패패패ㅐ");
		}
		String url = "QA";
		response.sendRedirect(url);

	}

}
