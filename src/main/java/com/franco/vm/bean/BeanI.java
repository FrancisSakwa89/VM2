package com.franco.vm.bean;

import javax.ejb.Local;
@Local
public interface BeanI<T> {
    T create(T t);
    T read(T t);
    T update(T t);
    boolean delete(T t);
}
