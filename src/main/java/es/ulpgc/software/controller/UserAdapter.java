package es.ulpgc.software.controller;

import es.ulpgc.software.model.User;

public interface UserAdapter<T> {
    User adapt(T t);
}
