package com.jjcompany.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jjcompany.member.dto.MemberDto;

@Controller
public class MemberController {
	
@RequestMapping(value = "/login")
public String login(HttpServletRequest request, Model model) {

	return "login";
		
}

@RequestMapping(value = "/login2")
public String login2(HttpServletRequest request, Model model) {

	return "login2";
		
}

@RequestMapping(value = "/join")
public String join(HttpServletRequest request, Model model) {

	return "join";
		
}

@RequestMapping(value = "/joinOk")
public String joinOk(MemberDto memberDto, Model model) {

	//System.out.println(memberDto.getName());
	
	model.addAttribute("memberDto", memberDto);
	
	return "joinOk";
		
}

@RequestMapping(value = "/loginOk2")
public String loginOk2(@RequestParam("id") String mid, @RequestParam("pw") String mpw, Model model) {
	
	model.addAttribute("memberId", mid);
	
	return "loginOk";
	
}
	// login >  loginOk,jsp 출력 RequestMapping
	// id : tiger pw: 12345 파라미터 전송
@RequestMapping(value = "/loginOk")
public String loginOk(HttpServletRequest request, Model model) {
	
	String mid = request.getParameter("id");
	String mpw = request.getParameter("pw");
	
	model.addAttribute("memberId", mid);
	model.addAttribute("memberPw", mpw);
	
	return "loginOk";
	
}

@RequestMapping(value="/student/{sid}")
	public String sudentId(@PathVariable String sid, Model model) {
		
		model.addAttribute("studentNum", sid);	
	
		return "studentView";
	}







	
	
}
