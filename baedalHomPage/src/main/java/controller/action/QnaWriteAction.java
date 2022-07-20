package controller.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import qna.QnaDAO;
import qna.QnaDTO;

public class QnaWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		QnaDAO dao = QnaDAO.getInstance();
		QnaDTO Qna = null;
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<QnaDTO> data = QnaDAO.getInstance().getQnaData();
		int no = data.size() + 1;
		
		HttpSession session = request.getSession();
		String userCodeString = (String) session.getAttribute("logCode"); // u0000
		userCodeString = userCodeString.substring(1); // 0000 문자열
		int userCode = Integer.parseInt(userCodeString); // 0000 숫자
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
				
		Qna = new QnaDTO(no, userCode, title, contents);
		boolean chk = dao.addQnaData(Qna);
		
		String url = "";
		
		url = "QA";
		
		response.sendRedirect(url);
	}


}
