package com.franco.vm.webservices.webservicesfilters;


import javax.ws.rs.NameBinding;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@NameBinding
@Target({ElementType.TYPE,ElementType.FIELD,METHOD,PARAMETER,CONSTRUCTOR})
@Retention(RUNTIME)
public @interface Authenticate {

}
