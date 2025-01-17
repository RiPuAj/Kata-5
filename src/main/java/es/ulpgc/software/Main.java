package es.ulpgc.software;

import es.ulpgc.software.controller.RandomUserProvider;
import es.ulpgc.software.model.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        RandomUserProvider randomUserProvider = new RandomUserProvider();
        User user = randomUserProvider.provideNew();
        System.out.println(user);
    }
}
