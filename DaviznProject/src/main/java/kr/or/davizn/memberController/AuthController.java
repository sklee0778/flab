package kr.or.davizn.memberController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.davizn.memberService.AuthorityService;

@Controller
@RequestMapping("/auth/")
public class AuthController {
/*<<<<<<< HEAD*/
	
	@Autowired
	private AuthorityService service;
	
	//권한 부여
	@RequestMapping("grantAuth.dvn")
	public String grantAuth(@RequestParam String userid){
		String view = null;
		String newStrgname = "저장소이름";
		int result = service.grantAuth(userid);
		if(result > 0){
			System.out.println("회원가입 완료 // 저장소 추가하러 출발");
			view = "redirect:/join/newStorage.dvn?userid="+userid;
		}else{
			view = "joinus.signup";
		}
		return view;
	}
}