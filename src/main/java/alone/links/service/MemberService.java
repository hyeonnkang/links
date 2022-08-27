package alone.links.service;

import alone.links.domain.Member;
import alone.links.form.MemberForm;
import alone.links.form.MemberForm;
import alone.links.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public String signUp(MemberForm memberForm){
        Member member = new Member(memberForm.getName(), memberForm.getId(), memberForm.getPwd());
        memberRepository.insert(member);
        return member.getName();
    }

    public String login(MemberForm memberForm){
        String id = memberForm.getId();
        String pwd = memberForm.getPwd();

        if(memberRepository.findById(id).isPresent()){
            Member member = memberRepository.findById(id).get();
            if(pwd.equals(member.getPwd())){
                return id;
            }
        }
        return "failed";
    }

    public Member selectById(String id){
        if(memberRepository.findById(id).isPresent()){
            return memberRepository.findById(id).get();
        }
        return null;
    }
}
