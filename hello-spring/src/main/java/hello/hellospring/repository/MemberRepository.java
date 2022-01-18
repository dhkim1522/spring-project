package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    /*
        Optional Java8에 나온 Wrapper 클래스로 Null처리를 위한
        메서드들을 제공해준다. Null이 들어올 수 있는 객체나 메서드를 감싸준다.
    */
    List<Member> findAll();
}
