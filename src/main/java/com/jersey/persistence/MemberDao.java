package com.jersey.persistence;

import com.jersey.representations.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<Member, Long> {
}