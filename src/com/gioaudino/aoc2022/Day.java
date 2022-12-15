package com.gioaudino.aoc2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Day {
    public Object runFirst() {
        return this.runFirst(this.getClass().getSimpleName());
    }

    public Object runSecond() {
        return this.runSecond(this.getClass().getSimpleName());
    }

    public abstract Object runFirst(String filename);

    public abstract Object runSecond(String filename);

    protected String buildFilename(String basename) {
        return System.getProperty("user.dir") + "/inputs/" + basename + ".txt";
    }

    protected String getFilename(String basename) {
        return basename != null ? basename : this.getClass().getSimpleName();
    }

    protected Scanner openFile(String filename) {
        try {
            return new Scanner(new File(this.buildFilename(getFilename(filename))));
        } catch (FileNotFoundException e) {
            System.err.println("File not found:" + e.getMessage());
        }
        return null;
    }
}
