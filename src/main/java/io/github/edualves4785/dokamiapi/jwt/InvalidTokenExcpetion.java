package io.github.edualves4785.dokamiapi.jwt;

public class InvalidTokenExcpetion extends RuntimeException {
    public InvalidTokenExcpetion(String message) {
        super(message);
    }
}
