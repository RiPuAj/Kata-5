package es.ulpgc.software.model;

public record User(String name, String lastName, String email, Gender gender, byte[] photo ) {
    public enum Gender{Male, Female};
}
