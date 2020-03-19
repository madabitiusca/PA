package com.company;

public class InvalidCatalogException extends Exception {

    public InvalidCatalogException(InvalidCatalogException ex) {
        super("Invalid catalog file.", ex);
    }

    public InvalidCatalogException(String path) {

    }


    public void loadObject(String path) {
    }
}
