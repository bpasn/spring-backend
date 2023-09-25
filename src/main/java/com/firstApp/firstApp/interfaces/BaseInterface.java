package com.firstApp.firstApp.interfaces;

public interface BaseInterface<T> {
    @Deprecated
    <S extends T> S getAll();
}
