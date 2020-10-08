package com.company;

import java.io.*;
import java.util.ArrayList;

public class FileOfObjects<T extends Serializable> {
    private final File file;

    public FileOfObjects(String name) throws IOException {
        file = new File(name);
        file.createNewFile();
    }

    public void write(ArrayList<T> objects) throws IOException {
        try (var outStream = new ObjectOutputStream(new FileOutputStream(file))) {
            for (var object : objects)
                outStream.writeObject(object);
        }
    }

    public ArrayList<T> read() throws IOException, ClassNotFoundException {
        var objects = new ArrayList<T>();
        try (var inStream = new ObjectInputStream(new FileInputStream(file))) {
            while (true)
                objects.add((T)inStream.readObject());
        }
        catch (EOFException exception) {
            return objects;
        }
    }
}
