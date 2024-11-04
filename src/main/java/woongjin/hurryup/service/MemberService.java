package woongjin.hurryup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import woongjin.hurryup.DTO.LoginRequestDTO; // 로그인 DTO
import woongjin.hurryup.DTO.ModifyRequestDTO;
import woongjin.hurryup.DTO.SignupRequestDTO; // 회원가입 DTO
import woongjin.hurryup.entity.Member;
import woongjin.hurryup.repository.MemberRepository;

import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // 회원가입 기능
    public boolean signup(SignupRequestDTO signupRequest) {
        if (checkDuplicateId(signupRequest.getMemberId())) {
            return false; // ID 중복
        }
        if (checkDuplicateNickname(signupRequest.getNickname())) {
            return false; // 닉네임 중복
        }

        Member newMember = new Member();
        newMember.setMemberId(signupRequest.getMemberId());
        newMember.setPassword(signupRequest.getPassword());
        newMember.setNickname(signupRequest.getNickname());
        newMember.setPhone(signupRequest.getPhone());
        memberRepository.save(newMember);

        return true; // 회원가입 성공
    }

    // ID 중복 확인
    public boolean checkDuplicateId(String memberId) {
        return memberRepository.findByMemberId(memberId).isPresent();
    }

    // 닉네임 중복 확인
    public boolean checkDuplicateNickname(String nickname) {
        return memberRepository.findByNickname(nickname).isPresent();
    }

    // 로그인 기능
    public boolean login(LoginRequestDTO loginRequest) {
        Optional<Member> memberOptional = memberRepository.findByMemberId(loginRequest.getMemberId());
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            return member.getPassword().equals(loginRequest.getPassword()); // 비밀번호 비교
        }
        return false; // 사용자가 존재하지 않음
    }

    // ID로 멤버 조회
    public Optional<Member> getMemberById(String memberId) {
        return memberRepository.findByMemberId(memberId);
    }

    // 사용자 정보 조회
    public Optional<Member> getMemberInfo(String id) {
        return memberRepository.findByMemberId(id); // 사용자 정보를 Optional로 반환
    }

    // 회원 정보 수정
    public boolean modify(ModifyRequestDTO modifyRequest) {
        Optional<Member> memberOptional = memberRepository.findByMemberId(modifyRequest.getMemberId());
        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            member.setNickname(modifyRequest.getNewNickname()); // 새 닉네임으로 수정
            member.setPassword(modifyRequest.getNewPassword()); // 새 비밀번호로 수정
            memberRepository.save(member); // 변경된 정보 저장
            return true; // 수정 성공
        }
        return false; // 회원이 존재하지 않을 경우
    }
}
