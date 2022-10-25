package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.Action;
import com.controller.ActionForward;
import com.model.LoginDAO;
import com.model.pmemberDTO;
import com.model.userTokenDTO;

public class tokenCheckOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 유저가 입력한 인증코드를 비교하는 클래스
		HttpSession session = request.getSession();
//		String user = request.getParameter("email");
//		int sysToken = Integer.parseInt(request.getParameter("token"));
		userTokenDTO save = (userTokenDTO)session.getAttribute("user"); 
		int inPutToken = Integer.parseInt(request.getParameter("inputToken"));
		
		//session.setMaxInactiveInterval(3*60); 세션 3분 후에 종료
		
		PrintWriter out = response.getWriter();
		ActionForward forward = new ActionForward();
		System.out.println("user: " + save);
		System.out.println("Token: " + inPutToken);
		if(save.getToken() != inPutToken) {
			out.println("<script>"
					+ "alert('인증번호가 일치하지 않습니다.');"
					+ "history.back();"
					+ "</script>");
		} else if(save.getToken() == inPutToken) {
			LoginDAO loginDB = LoginDAO.getInstance();
			int memberCheck = loginDB.MemberCheck(save.getEmail());
			
			if(memberCheck == 1) { // 로그인
				pmemberDTO signIn = new pmemberDTO();
				
				request.setAttribute("sign", signIn);
				
				forward.setRedirect(false);
				forward.setPath(""); // 로그인시 메인 >> 회원등급 판단도 해야함
			} else if(memberCheck == 0) { // 회원가입
				forward.setRedirect(true);
				forward.setPath("view/memberSignUp.jsp");
			}
		}
		
		return forward;
	}
}
