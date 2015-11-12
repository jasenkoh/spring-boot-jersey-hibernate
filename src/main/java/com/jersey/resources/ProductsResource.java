package com.jersey.resources;

import com.jersey.entity.boEntity.Product;
import com.jersey.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class ProductsResource {
    private ProductsService productService;
    @Autowired
    public ProductsResource(ProductsService productService){
        this.productService = productService;
    }

    /**
     * Get all Products
     * @return products
     */
    @GET
    public List<Product> getAll(){
        List<Product> product = this.productService.getAll();
        return product;
    }

    /**
     * Get single Product
     * @param id
     * @return product
     */
    @GET
    @Path("{id}")
    public Product getOne(@PathParam("id")long id) {
        Product Product = productService.getOne(id);
        if(Product == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return Product;
        }
    }

    /**
     * Create new Product
     * @param Product
     * @return new product
     */
    @POST
    public Product save(@Valid Product Product) {
        return productService.save(Product);
    }

    /**
     * Update existing Product
     * @param id
     * @param Product
     * @return updated product
     */
    @PUT
    @Path("{id}")
    public Product update(@PathParam("id")long id, @Valid Product Product) {
        if(productService.getOne(id) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            Product.setId(id);
            return productService.save(Product);
        }
    }

    /**
     * Delete product
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")long id) {
        Product product = productService.getOne(id);
        if(product == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            productService.delete(product.getId());
        }
    }
}