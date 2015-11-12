package com.jersey.services;

import com.google.common.collect.Lists;
import com.jersey.entity.boEntity.Member;
import com.jersey.entity.daoEntity.MemberEntity;
import com.jersey.persistance.MemberDao;
import com.jersey.persistance.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class MembersService {
    private final MemberDao memberDao;
    private final ProductDao productDao;

    @Autowired
    public MembersService(MemberDao memberDao, ProductDao productDao) {
        this.memberDao = memberDao;
        this.productDao = productDao;
    }

    public List<Member> getAll(){
        return Lists.transform(this.memberDao.findAll(),Member.memberTransform());
    }

    public Member getAllProductsForMember(long id) {
        MemberEntity memberEntity = memberDao.findOne(id);
        return new Member(memberEntity);
    }

    public Member save(Member member){
        return new Member(memberDao.save(new MemberEntity(member)));
    }

    public Member getMember(long id) {
        MemberEntity memberEntity = memberDao.findOne(id);
        return new Member(memberEntity);
    }
}
