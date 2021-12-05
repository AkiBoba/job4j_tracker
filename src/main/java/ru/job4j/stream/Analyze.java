package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Vladimir Likhachev
 */
public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                 .flatMap(x -> x.getSubjects().stream())
                .map(Subject::getScore)
                .mapToInt(s -> s)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(x -> new Tuple(x.getName(), x.getSubjects().stream().map(Subject::getScore)
                        .mapToInt(s -> s)
                        .average()
                        .orElse(0D)))
                        .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        Stream<Subject> sub = stream.flatMap(x -> x.getSubjects().stream());
        Map<String, Double> res = sub
                .collect(
                        Collectors.groupingBy(Subject::getName,
                                Collectors.averagingDouble(Subject::getScore)));
        return res
                .entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        Comparator<Tuple> comparator = Comparator.comparing(Tuple::getScore);
        return stream
                        .map(x -> new Tuple(x.getName(), x.getSubjects()
                                .stream().map(Subject::getScore)
                                .mapToInt(s -> s)
                                .sum()))
                        .max(comparator)
                        .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        Comparator<Tuple> comparator = Comparator.comparing(Tuple::getScore);
        Stream<Subject> sub = stream.flatMap(x -> x.getSubjects().stream());
        Map<String, Double> res = sub
                .collect(
                        Collectors.groupingBy(Subject::getName,
                                Collectors.summingDouble(Subject::getScore)));
        return res
                .entrySet()
                .stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .max(comparator)
                .orElse(null);
    }
}
