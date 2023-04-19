package com.jjcompany.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
public String loginOk(HttpServletRequest request, Model model) {
	
	String mid = request.getParameter("id");
	String mpw = request.getParameter("pw");
	
	model.addAttribute("memberId", mid);
	model.addAttribute("memberPw", mpw);
	
	System.out.println("포스트 방식");
	
	return "loginOk";
	
}
@RequestMapping(value = "/loginOk", method = RequestMethod.GET)
public String loginOkGet(HttpServletRequest request, Model model) {
	
	String mid = request.getParameter("id");
	String mpw = request.getParameter("pw");
	
	model.addAttribute("memberId", mid);
	model.addAttribute("memberPw", mpw);
	
	System.out.println("겟 방식");
	
	return "loginOk";
	
}

@RequestMapping(value="/student/{sid}")
	public String sudentId(@PathVariable String sid, Model model) {
		
		model.addAttribute("studentNum", sid);	
	
		return "studentView";
	}


@RequestMapping(value="/studentTest")
public String StudentTest(@ModelAttribute("dto") MemberDto memberDto) {
	
	return "studentTest";
}

@RequestMapping(value = "/join2")
public String join2(HttpServletRequest request, Model model) {

	return "join2";
		
}


	
	
}
