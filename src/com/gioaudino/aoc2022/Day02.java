package com.gioaudino.aoc2022;

import java.util.*;


public class Day02 extends Day {


    public Day02() {

    }

    @Override
    public Object runFirst(String filename) {
        final Map<String, Integer> scores = new HashMap<>();
        final Map<String, String> winner = new HashMap<>();
        final Set<Map.Entry<String, String>> ties = new HashSet<>();
        scores.put("X", 1);
        scores.put("Y", 2);
        scores.put("Z", 3);

        winner.put("A", "Y");
        winner.put("B", "Z");
        winner.put("C", "X");

        ties.add(new AbstractMap.SimpleEntry<>("A", "X"));
        ties.add(new AbstractMap.SimpleEntry<>("B", "Y"));
        ties.add(new AbstractMap.SimpleEntry<>("C", "Z"));
        Scanner input = this.openFile(filename);
        int score = 0;
        while (input.hasNextLine()) {
            String[] line = input.nextLine().split(" ");
            if (ties.contains(new AbstractMap.SimpleEntry<>(line[0], line[1]))) {
                score += 3;
            } else if (winner.get(line[0]).equals(line[1])) {
                score += 6;
            }
            score += scores.get(line[1]);
        }
        return score;
    }

    @Override
    public Object runSecond(String filename) {
        final Map<String, Integer> choiceScores = new HashMap<>();
        choiceScores.put("A", 1);
        choiceScores.put("B", 2);
        choiceScores.put("C", 3);

        final Map<String, Integer> resultScores = new HashMap<>();
        resultScores.put("X", 0);
        resultScores.put("Y", 3);
        resultScores.put("Z", 6);

        final Map<String, Map<String, String>> whatToDo = new HashMap<>();

        Map<String, String> a = new HashMap<>();
        a.put("X", "C");
        a.put("Y", "A");
        a.put("Z", "B");

        Map<String, String> b = new HashMap<>();
        b.put("X", "A");
        b.put("Y", "B");
        b.put("Z", "C");

        Map<String, String> c = new HashMap<>();
        c.put("X", "B");
        c.put("Y", "C");
        c.put("Z", "A");

        whatToDo.put("A", a);
        whatToDo.put("B", b);
        whatToDo.put("C", c);

        Scanner input = this.openFile(filename);
        int score = 0;
        while (input.hasNextLine()) {
            String[] line = input.nextLine().split(" ");
            score += choiceScores.get(whatToDo.get(line[0]).get(line[1]));
            score += resultScores.get(line[1]);
        }
        return score;
    }
}
