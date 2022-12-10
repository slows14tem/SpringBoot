package edu.pnu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Members;

public interface MemberRepository extends JpaRepository<Members, String> {

}
