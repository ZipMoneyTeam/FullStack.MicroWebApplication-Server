package mainApp.services;

import mainApp.entities.Member;
import mainApp.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;
    public Member create(Member member) {
        return memberRepository.save(member);
    }

    public Member read(Long id){
        return memberRepository.findById(id).get();
    }

    public Iterable<Member> readAll() {
        return memberRepository.findAll();
    }
    public Member update(Long id,Member newData){
        Member member =read(id);
        member.setEmailId(newData.getEmailId());
       member.setPassword(newData.getPassword());
        memberRepository.save(newData);
        return newData;
    }
    public Member delete(Member member) {
        memberRepository.delete(member);
        return member;
    }

    public Member delete(Long id){

        return delete(read(id));
    }

}
