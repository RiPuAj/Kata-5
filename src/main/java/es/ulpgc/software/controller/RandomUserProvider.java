package es.ulpgc.software.controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import es.ulpgc.software.controller.pojo.RandomUserResponse;
import es.ulpgc.software.model.User;
import org.jsoup.Jsoup;

import java.io.IOException;

public class RandomUserProvider implements UserProvider {
    private final String RANDOM_USER_API = "https://randomuser.me/api";

    @Override
    public User provideNew() throws IOException {
        try {
            RandomUserAdapter randomUserAdapter = new RandomUserAdapter();
            String json = Jsoup.connect(RANDOM_USER_API).ignoreContentType(true).get().text();
            Gson gson = new Gson();

            return randomUserAdapter.adapt(gson.fromJson(json, RandomUserResponse.class));
        } catch (IOException | JsonSyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
