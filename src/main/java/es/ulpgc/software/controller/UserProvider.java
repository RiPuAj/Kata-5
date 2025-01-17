package es.ulpgc.software.controller;

import es.ulpgc.software.model.User;

import java.io.IOException;

public interface UserProvider {
    User provideNew() throws IOException;
}
