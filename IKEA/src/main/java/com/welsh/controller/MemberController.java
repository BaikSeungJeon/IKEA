package com.welsh.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.welsh.model.MemberDao;
import com.welsh.model.MemberDto;
import com.welsh.utils.ScriptWriterUtil;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemberController {

	@Autowired
	MemberDto loggedMember;
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping("/LoginForm.do")
	public String loginForm() {
		return "login";
	}
	
	@RequestMapping("/Login.do")
	public String login(MemberDto memberDto,HttpSession session,HttpServletResponse response) throws IOException {
		loggedMember=memberDao.getLoggedMember(memberDto);
		String role=loggedMember.getUserRole();
		
		if(loggedMember!=null) {
			session.setAttribute("loggedMember", loggedMember);
			if(role.equals("admin"))
			ScriptWriterUtil.alertAndNext(response, "관리자로 로그인 하였습니다.", "AdminPage.do");
			else {
			ScriptWriterUtil.alertAndNext(response, "로그인 하였습니다.", "/welsh/");
			}
			
		} else {
			ScriptWriterUtil.alertAndBack(response, "다시 시도하세요");
		}
		
		return null;
	}
	
	@RequestMapping("/RegisterForm.do")
	public String registerForm() {
		return "register";
	}
	
}
