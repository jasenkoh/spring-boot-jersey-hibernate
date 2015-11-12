package com.jersey.resources;


import com.jersey.entity.boEntity.Member;
import com.jersey.services.MembersService;
import com.jersey.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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