package controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Action;
import user.masterDAO;
import user.masterDTO;

public class ChangePwMasterAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String masterCode = (String) session.getAttribute("logCode");
		masterCode = masterCode.substring(1);

		System.out.println("masterCode:::::::" + masterCode);

		System.out.println(masterCode);
		masterDAO dao = masterDAO.getInstance();
		masterDTO user = dao.getData(Integer.parseInt(masterCode));

		String pw = request.getParameter("pw");
		String chPw = request.getParameter("changePw");
		String doubleChkPw = request.getParameter("douChkPw");

		System.out.println("pw " + pw);
		System.out.println("chPw " + chPw);
		System.out.println("doubleChkPw " + doubleChkPw);

//		String uCode = (String) session.getAttribute("userCode");	

		System.out.println("masterCode" + masterCode);

		String url = "";
//		String uCode=String.valueOf(userCode);

		if (dao.updateMasterPw(masterCode, pw, chPw, doubleChkPw)) {
			url = "mypage_master";
		} else {
			url = "index";
		}
		response.sendRedirect(url);

	}

}
