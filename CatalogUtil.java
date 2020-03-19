package com.company;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CatalogUtil {
    public static void save(Catalog catalog)
        throws IOException {
        try (var oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static  Catalog load(String path) {

    }

    public static void view(Document doc) {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(doc);

    }
}
