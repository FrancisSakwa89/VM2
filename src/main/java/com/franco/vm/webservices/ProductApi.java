package com.franco.vm.webservices;
import com.franco.vm.bean.ProductBeanI;
import com.franco.vm.model.Product;
import com.franco.vm.webservices.webservicesfilters.Authenticate;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Authenticate
@Path("/products")
public class ProductApi {

    @EJB
    private ProductBeanI productBeanI;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response createProduct(String json){
        Gson gson = new Gson();
        Product product = gson.fromJson(json, Product.class);

        return Response.ok().entity(productBeanI.create(product)).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}/read")
    public Response getProducts(@PathParam("id") int id){

        Product product = new Product();
        product.setId(id);

        return Response.ok().entity(productBeanI.read(product)).build();
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/delete")
    public Response deleteProduct(@PathParam("id") int id){

        Product product = new Product();
        product.setId(id);
        System.out.println("deleted successfully"+" id: "+ product.getId()+" "+product.getName());
        return Response.ok().entity(productBeanI.delete(product)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}/update")
    public Response updateProduct(@PathParam("id") int id, String json){


        Product product = new Product();
        product.setId(id);
        System.out.println("updated successfully"+" id: "+ product.getId()+" "+product.getName());
        return Response.ok().entity(productBeanI.update(product)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/all")
    public Response getAllProducts() throws SQLException {
        return Response.ok().entity(productBeanI.readAll()).build();
    }

}
