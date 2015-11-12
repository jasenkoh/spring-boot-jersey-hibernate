package com.jersey.entity.boEntity;

import com.google.common.base.Function;
import com.jersey.entity.daoEntity.MemberEntity;

public class Member {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public Member() {
    }

    public Member(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Member(MemberEntity entity){
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.email = entity.getEmail();
    }

    public static Function<MemberEntity,Member> memberTransform() {
        return new Function<MemberEntity, Member>() {
            public Member apply(MemberEntity entity) {
                return new Member(entity);
            }
        };
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
