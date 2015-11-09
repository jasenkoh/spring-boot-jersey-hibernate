package com.jersey.resources;


import com.jersey.entity.boEntity.Member;
import com.jersey.entity.daoEntity.MemberEntity;
import com.jersey.persistance.MemberDao;
import com.jersey.persistance.ProductDao;
import com.jersey.service.MembersService;
import com.jersey.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class MembersResource {
    private final MembersService membersService;
    private final ProductsService productService;

    @Autowired
    public MembersResource(MembersService membersService, ProductsService productService) {
        this.membersService = membersService;
        this.productService = productService;
    }
    @GET
    public List<Member> getAll(){
        return this.membersService.getAll();
    }

    @GET
    @Path("{id}/products")
    public Member getAllProductsForMember(@PathParam("id")long id) {
        Member member = membersService.getMember(id);
        return member;
    }

    @POST
    public Member save(Member member){
        return membersService.save(member);
    }

    @GET
    @Path("{id}")
    public Member getMember(@PathParam("id")long id) {
        Member member = membersService.getMember(id);
        return member;
    }
}