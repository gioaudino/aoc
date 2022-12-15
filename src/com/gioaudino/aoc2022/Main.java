package com.gioaudino.aoc2022;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.impl.Arguments;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ArgumentParserException {
        ArgumentParser parser = ArgumentParsers.newFor("AoC").build();
        parser.addArgument("day").nargs("?").type(String.class);
        parser.addArgument("--sample").nargs("?").type(Boolean.class).setDefault(false).action(Arguments.storeTrue());
        Namespace nargs = parser.parseArgs(args);

        String filename = null;

        if (nargs.getBoolean("sample")) {
            System.out.println("Using sample file");
            filename = "sample";
        }

        final String dayarg = nargs.getString("day");

        if (dayarg != null && !dayarg.isBlank()) {
            Day day;
            try {
                day = (Day) Class.forName("com.gioaudino.aoc2022.Day" + nargs.getString("day")).getDeclaredConstructor().newInstance();
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            System.out.println(day.getClass().getSimpleName() + "/1 -> " + day.runFirst(filename));
            System.out.println(day.getClass().getSimpleName() + "/2 -> " + day.runSecond(filename));
            System.out.println();
            return;
        }

        final Day[] days = {
                new Day01(),
                new Day02(),
                new Day03(),
                new Day04(),
                new Day05(),
        };

        for (Day day : days) {
            System.out.println(day.getClass().getSimpleName() + "/1 -> " + day.runFirst());
            System.out.println(day.getClass().getSimpleName() + "/2 -> " + day.runSecond());
            System.out.println();
        }
    }
}