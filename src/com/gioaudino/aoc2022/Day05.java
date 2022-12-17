package com.gioaudino.aoc2022;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day05 extends Day{
    @Override
    public Object runFirst(String filename) {
        Scanner input = this.openFile(filename);
        List<Stack<Character>> crates = new ArrayList<>();
        for(String line = input.nextLine(); line.trim().length() > 0; line = input.nextLine()){
            Stack<Character> tower = new Stack<>();
            line.chars().mapToObj(ch -> (char)ch).forEach(tower::push);
            crates.add(tower);
        }
        final Pattern pattern = Pattern.compile("move (?<count>\\d+) from (?<from>\\d+) to (?<to>\\d+)");
        while(input.hasNextLine()){
            Matcher matcher = pattern.matcher(input.nextLine());
            matcher.matches();
            int count = Integer.parseInt(matcher.group("count"));
            int from = Integer.parseInt(matcher.group("from"));
            int to = Integer.parseInt(matcher.group("to"));
            while(count >0){
                crates.get(to-1).push(crates.get(from-1).pop());
                --count;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Stack<Character> tower: crates){
            sb.append(tower.peek());
        }
        return sb.toString();
    }

    @Override
    public Object runSecond(String filename) {
        Scanner input = this.openFile(filename);
        List<Stack<Character>> crates = new ArrayList<>();
        for(String line = input.nextLine(); line.trim().length() > 0; line = input.nextLine()){
            Stack<Character> tower = new Stack<>();
            line.chars().mapToObj(ch -> (char)ch).forEach(tower::push);
            crates.add(tower);
        }
        final Pattern pattern = Pattern.compile("move (?<count>\\d+) from (?<from>\\d+) to (?<to>\\d+)");
        while(input.hasNextLine()) {
            Matcher matcher = pattern.matcher(input.nextLine());
            matcher.matches();
            int count = Integer.parseInt(matcher.group("count"));
            int from = Integer.parseInt(matcher.group("from"));
            int to = Integer.parseInt(matcher.group("to"));
            Stack<Character> tmp = new Stack<>();
            while(count >0){
                tmp.push(crates.get(from-1).pop());
                --count;
            }
            while(!tmp.isEmpty()){
                crates.get(to-1).push(tmp.pop());
            }

        }
        StringBuilder sb = new StringBuilder();
        for(Stack<Character> tower: crates){
            sb.append(tower.peek());
        }
        return sb.toString();
    }
}
