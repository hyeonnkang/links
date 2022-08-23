package alone.links.service;

import alone.links.domain.Member;
import alone.links.form.MemberForm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {
    @Autowired
    MemberService memberService;

    @Test
    @DisplayName("회원가입")
    public void signup(){
        MemberForm memberForm = new MemberForm("ididid", "pwpwpwpwpw", "baaabo");
        String name = memberService.signUp(memberForm);
        Assertions.assertThat(name).isEqualTo("baaabo");
    }

    @Test
    @DisplayName("로그인")
    public void login(){
        MemberForm memberForm = new MemberForm("아이디1", "비번1", "이름1");
        String name = memberService.signUp(memberForm);

        String result = memberService.login(memberForm);
        Assertions.assertThat(result).isEqualTo("로그인 성공");
    }
}
