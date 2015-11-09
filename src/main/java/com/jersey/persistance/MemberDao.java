package com.jersey.persistance;

import com.jersey.entity.daoEntity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<MemberEntity, Long> {
}