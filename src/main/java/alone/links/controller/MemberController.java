package alone.links.controller;

import alone.links.domain.Member;
import alone.links.form.MemberForm;
import alone.links.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/members/login")
    public String login(){return "login";}


    @GetMapping("/members/signup")
    public String signup(){return "signup";}

    @PostMapping("/members/signup")
    public String signup_process(MemberForm memberForm){
        memberService.signUp(memberForm);
        return "redirect:/";
    }

    @PostMapping("/members/login")
    public String login_process(MemberForm memberForm, Model model, HttpSession session){
        String id  = memberService.login(memberForm);

        if(Objects.equals(id, "failed")){ // 로그인 실패
            session.setAttribute("name", "null");
            model.addAttribute("msg", "false");
//            model.addAttribute("name", "null");
            return "login";
        }else{  // 로그인 성공
            System.out.println("id = " + id);
            Member member = memberService.selectById(id);
            session.setAttribute("name", member.getName());
            model.addAttribute("msg", "true");
//            model.addAttribute("name", member.getName());
            return "home";
        }

    }
}
