package com.franco.vm.webservices.webservicesfilters;

import javax.servlet.ServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Authenticate
@Provider
public class WSFilter extends Rest implements ContainerRequestFilter {
    @Context
    ResourceInfo resourceInfo;

    @Context
    ServletRequest servletRequest;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println("Request filter...");
        System.out.println(resourceInfo.getResourceClass());
//        throw  new NotAuthorizedException("You are not authenticated...");
//        containerRequestContext.abortWith(this.);

    }
}
