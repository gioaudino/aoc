package com.gioaudino.aoc2022;

import java.util.Scanner;
import java.util.TreeSet;

public class Day01 extends Day {
    @Override
    public Object runFirst(String filename) {
        Scanner input = this.openFile(filename);
        int max = 0, currentSum = 0;

        while (input.hasNextLine()){
            String line = input.nextLine();
            if(line.trim().length() > 0) {
                currentSum += Integer.parseInt(line.trim());
            } else {
                max = Math.max(max, currentSum);
                currentSum = 0;
            }
        }
        return max;
    }

    @Override
    public Object runSecond(String filename) {
        Scanner input = this.openFile(filename);
        TreeSet<Integer> elves = new TreeSet<>();
        int currentSum = 0;
        while (input.hasNextLine()){
            String line = input.nextLine();
            if(line.trim().length() > 0) {
                currentSum += Integer.parseInt(line.trim());
            } else {
                elves.add(currentSum);
                currentSum = 0;
            }
        }
        int sum = 0, i=0;
        for(int elf: elves.descendingSet()){
            if(i++==3) {
                return sum;
            }
            sum += elf;
        }
        return 78;
    }
}
