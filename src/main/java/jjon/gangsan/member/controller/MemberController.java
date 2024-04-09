package jjon.gangsan.member.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jjon.gangsan.member.service.MemberServiceImpl;
import jjon.gangsan.model.MemberVo;


@Controller
public class MemberController {
	
	@Autowired
	private MemberServiceImpl memberService;
	
	//회원가입폼
	@RequestMapping("/member_join")
	public String member_join() {
		return "member_join";
	}
	
	//로그인폼
	@RequestMapping("/member_login")
	public String member_login() {
		return "member_login";
	}
	
	//회원수정폼
	@RequestMapping("/member_edit")
	public String member_edit(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		
		MemberVo editm = memberService.user_check(id);
		model.addAttribute("editm", editm);
		
		return "member_edit";
	}
	
	
	//회원삭제 폼
	@RequestMapping("/member_delete")
	public String member_delete(HttpSession session, Model model) {
		
		String id = (String) session.getAttribute("id");
		MemberVo member = memberService.user_check(id);
		
		return "member_delete";
	}
	
	//회원가입
	@RequestMapping("/member_join_go")
	public String member_join_go(MemberVo member){
		System.out.println("controller in");
		
		int result = memberService.member_join_go(member);
		if(result == 1) System.out.println("회원가입 성공");
		
		return "member_join_result";
	}
	
	//회원가입 id 중복체크
	@RequestMapping("/member_idchek")
	@ResponseBody
	public Integer member_idcheck(@RequestParam("memid") String userId) {
		System.out.println("id : "+ userId);
		
		int result = memberService.user_id_check(userId);
		System.out.println("result :"+result);
		return result;
	}
	
	//로그인
	@RequestMapping("/member_login_go")
	public String member_login_go(@RequestParam("userId") String userId,
								  @RequestParam("userPw") String userPw,
								  HttpSession session,
								  HttpServletResponse response,
								  Model model) {
		
		int result = 0;	
		MemberVo member =  memberService.user_check(userId);
		System.out.println("확인 : "+member.getUserId());
		
		if(member == null) {//등록 x회원일 때
			result = 1;
			return "member_login";
		}
		else {				// 등록된 회원일때
			if (member.getUserPw().equals(userPw)) {			// 비번이 같을때
				
				// 세션 설정
				session.setAttribute("id", userId);     
				
				System.out.println(userId); //id 잘넘어왓나 확인
				String user_name = member.getUserName(); //view로 넘어갈 name

				//model객체 : controller -> view로 갈때 한번만 springboot에서 자체적으로 사용하는 인터페이스
				model.addAttribute("user_name", user_name);;
				
				return "mypage";
				
			} else {									// 비번이 다를때
				result = 2;
				model.addAttribute("result", result);
				
				return "member_login";				
			}
		}
	}
	
	//회원정보수정
	@RequestMapping("/member_edit_go")
	public String member_edit_go(
								MemberVo member,
								HttpSession session, 
								HttpServletRequest request, 
								Model model	) {
		
		String id = (String) session.getAttribute("id");
		member.setUserId(id);
		
		
		//update sql문
		memberService.member_edit_go(member);
		
		model.addAttribute("user_name", member.getUserName());
		
		return "mypage";
	}
	
	
	//회원정보 삭제
	@RequestMapping("/member_delete_go")
	public String member_delete_go(@RequestParam("userPw") String userPw,
									HttpSession session) {
		
		String id = (String) session.getAttribute("id");
		MemberVo member = memberService.user_check(id);
		
		if(!member.getUserPw().equals(userPw)) { //비번 불일치시
			return "delete_result";
		}else { //비번 일치시
			MemberVo db = new MemberVo();
			db.setUserId(id);
			
			//delete sql문
			memberService.member_delete_go(db);
			
			//세션삭제
			session.invalidate();
			
			return "member_login";
		}
		
	}
	
	
	
	//로그아웃
	@RequestMapping("member_logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "member_logout";
	}
	
	
}
