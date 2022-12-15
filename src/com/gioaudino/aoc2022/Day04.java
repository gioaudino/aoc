package com.gioaudino.aoc2022;

import java.util.Arrays;
import java.util.Scanner;

public class Day04 extends Day {
    @Override
    public Object runFirst(String filename) {
        Scanner input = this.openFile(filename);
        int count = 0;
        while (input.hasNextLine()) {
            String[] elves = input.nextLine().split(",");
            int[] elf1 = Arrays.stream(elves[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] elf2 = Arrays.stream(elves[1].split("-")).mapToInt(Integer::parseInt).toArray();
            if (elf1[0] <= elf2[0] && elf1[1] >= elf2[1] || elf2[0] <= elf1[0] && elf2[1] >= elf1[1]) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Object runSecond(String filename) {
        Scanner input = this.openFile(filename);
        int count = 0;
        while (input.hasNextLine()) {
            String[] elves = input.nextLine().split(",");
            int[] elf1 = Arrays.stream(elves[0].split("-")).mapToInt(Integer::parseInt).toArray();
            int[] elf2 = Arrays.stream(elves[1].split("-")).mapToInt(Integer::parseInt).toArray();
            if (
                    elf1[0] <= elf2[0] && elf1[1] >= elf2[0]
                        || elf1[0] <= elf2[1] && elf1[1] >= elf2[1]
                        || elf2[0] <= elf1[0] && elf2[1] >= elf1[0]
                        || elf2[0] <= elf1[1] && elf2[1] >= elf1[1]
            ) {
                count++;
            }
        }
        return count;
    }
}
