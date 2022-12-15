package com.gioaudino.aoc2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Day03 extends Day {
    @Override
    public Object runFirst(String filename) {
        Scanner input = this.openFile(filename);
        int sum = 0;
        while (input.hasNextLine()) {
            char[] line = input.nextLine().toCharArray();
            Set<Character> items1 = new HashSet<>();
            Set<Character> items2 = new HashSet<>();
            for (int i = 0; i < line.length / 2; i++) {
                items1.add(line[i]);
                items2.add(line[i + line.length / 2]);
            }
            char commonElement = items1.stream().filter(items2::contains).toList().get(0);
            int v = Character.isUpperCase(commonElement) ? 27 + (commonElement - 'A') : 1 + (commonElement - 'a');
            sum += v;

        }
        return sum;
    }

    @Override
    public Object runSecond(String filename) {
        Scanner input = this.openFile(filename);
        int sum = 0;
        while (input.hasNextLine()) {
            Set<Character> elf = new HashSet<>();
            Set<Character> otherElf = new HashSet<>();
            Set<Character> thirdElf = new HashSet<>();

            input.nextLine().chars().mapToObj(ch -> (char) ch).forEach(elf::add);
            input.nextLine().chars().mapToObj(ch -> (char) ch).forEach(otherElf::add);
            input.nextLine().chars().mapToObj(ch -> (char) ch).forEach(thirdElf::add);

            char commonElement = elf.stream().filter(e -> otherElf.contains(e) && thirdElf.contains(e)).toList().get(0);
            int v = Character.isUpperCase(commonElement) ? 27 + (commonElement - 'A') : 1 + (commonElement - 'a');
            sum += v;

        }
        return sum;
    }
}
