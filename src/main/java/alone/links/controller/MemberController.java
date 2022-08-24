package alone.links.controller;

import alone.links.form.MemberForm;
import alone.links.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String login_process(MemberForm memberForm, Model model){
        String login_result = memberService.login(memberForm);
        model.addAttribute("login_result", login_result);
        System.out.println("login_result = " + login_result);
        return "redirect:/";
    }
}
