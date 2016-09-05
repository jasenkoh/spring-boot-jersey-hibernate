package com.jersey.resources;

import com.jersey.persistence.ProductDao;
import com.jersey.representations.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@Component
public class ProductsResource {
    private ProductDao productDao;
    @Inject
    public ProductsResource(ProductDao productDao){
        this.productDao = productDao;
    }

    /**
     * Get all Products
     * @return products
     */
    @GET
    public List<Product> getAll(){
        List<Product> products = this.productDao.findAll();
        return products;
    }

    /**
     * Get single Product
     * @param id
     * @return product
     */
    @GET
    @Path("{id}")
    public Product getOne(@PathParam("id")long id) {
        Product product = productDao.findOne(id);
        if(product == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            return product;
        }
    }

    /**
     * Create new Product
     * @param product
     * @return new product
     */
    @POST
    public Product save(@Valid Product product) {
        return productDao.save(product);
    }

    /**
     * Update existing Product
     * @param id
     * @param product
     * @return updated product
     */
    @PUT
    @Path("{id}")
    public Product update(@PathParam("id")long id, @Valid Product product) {
        if(productDao.findOne(id) == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            product.setId(id);
            return productDao.save(product);
        }
    }

    /**
     * Delete product
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")long id) {
        Product product = productDao.findOne(id);
        if(product == null){
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }else {
            productDao.delete(product);
        }
    }
}