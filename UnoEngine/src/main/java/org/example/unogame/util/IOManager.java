package org.example.unogame.util;

import java.io.*;

public class IOManager {
    private static IOManager instance;
    private BufferedReader reader;
    private BufferedWriter writer;

    private IOManager() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
        } catch (Exception e) {
            throw new RuntimeException("Error initializing IOManager", e);
        }
    }

    public static IOManager getInstance() {
        if (instance == null) {
            synchronized (IOManager.class) {
                if (instance == null) {
                    instance = new IOManager();
                }
            }
        }
        return instance;
    }

    public BufferedReader getReader() {
        return reader;
    }

    public BufferedWriter getWriter() {
        return writer;
    }

    public void close() {
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
