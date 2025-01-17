package es.ulpgc.software.controller;

import es.ulpgc.software.controller.pojo.RandomUser;
import es.ulpgc.software.controller.pojo.RandomUserResponse;
import es.ulpgc.software.model.User;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class RandomUserAdapter implements UserAdapter<RandomUserResponse> {

    @Override
    public User adapt(RandomUserResponse randomUserResponse) {
        RandomUser user = randomUserResponse.getResults().getFirst();
        return new User(
                user.getName().first(),
                user.getName().last(),
                user.getEmail(),
                User.Gender.valueOf(capitalize(user.getGender())),
                downloadPhoto(user.getPicture().medium())
        );
    }

    public byte[] downloadPhoto(String urlPhoto){
        try(InputStream is = new URL(urlPhoto).openStream()){
            return is.readAllBytes();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private String capitalize(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
