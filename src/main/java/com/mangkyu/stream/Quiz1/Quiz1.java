package com.mangkyu.stream.Quiz1;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Quiz1 {

    // 1.1 각 취미를 선호하는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz1() throws IOException {
        List<String[]> csvLines = readCsvLines();
        Map<String, Integer> map = new HashMap<>();
        csvLines.stream()
                .map(line -> line[1].replaceAll("\\s", ""))
                .map(word -> word.split(":"))
                .flatMap(Arrays::stream)
                .forEach(word -> {
                    if (map.get(word) == null) {
                        map.put(word, 1);
                    } else {
                        Integer val = map.get(word);
                        map.put(word, val + 1);
                    }
                });
        return map;
//        Map<String, Integer> map = new HashMap<>();
//        for (String[] s : csvLines) {
//            String[] split = s[1].split(":");
//            for (String str : split) {
//                String trim = str.trim();
//                if (map.get(trim) == null) {
//                    map.put(trim, 1);
//                } else {
//                    Integer value = map.get(trim);
//                    value = 1 + value;
//                    map.put(trim, value);
//                }
//                System.out.println(trim);
//            }
//        }
//        return map;
//        return new HashMap<>();
    }

    // 1.2 각 취미를 선호하는 정씨 성을 갖는 인원이 몇 명인지 계산하여라.
    public Map<String, Integer> quiz2() throws IOException {
        List<String[]> csvLines = readCsvLines();

        return csvLines.stream()
                .filter(line -> line[0].split("")[0].equals("정"))
                .map(line -> line[1].replaceAll("\\s", ""))
//                .forEach(System.out::println);
                .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                .collect(Collectors.toMap(
                        hobby -> hobby,
                        hobby -> 1,
                        (oldVal, newVal) -> newVal += oldVal));
//        return result;
//        return new HashMap<>();
    }

    // 1.3 소개 내용에 '좋아'가 몇번 등장하는지 계산하여라.
    public int quiz3() throws IOException {
        // arr[2]에 소개에서 "좋아" 를 탐색
        // "좋아"가 몇번 나오는지 계산
        List<String[]> csvLines = readCsvLines();
        List<String> list = new ArrayList<>();
//        for (String[] s : csvLines) {
//            list.add(s[2]);
//        }
//        System.out.println("list: " + list);
//        int count = 0;
//        for (String s : list) {
//            if (s.contains("좋아")) {
//                count++;
//            }
//        }
//        csvLines.stream()
//                .map(line -> line[2])
//                .flatMap(line -> {
//                    if (line.contains("좋아")) {
//                        char[] chars = line.toCharArray();
//                        for (int i = 0; i < chars.length; i++) {
//                            if (chars[i] == '좋' && chars[i + 1] == '아') {
//                                count++;
//                            }
//                        }
//                        return count;
//                    } else {
//                        return 0;
//                    }
//                })
//                .filter()
//        Integer 좋아 = csvLines.stream()
//                .map(line -> line[2])
//                .map(string -> {
//                    if (string.contains("좋아")) {
//                        char[] chars = string.toCharArray();
//                        int count = 0;
//                        for (int i = 0; i < chars.length; i++) {
//                            if (chars[i] == '좋' && chars[i + 1] == '아') {
//                                count++;
//                            }
//                        }
//                        return count;
//                    } else {
//                        return 0;
//                    }
//                })
//                .reduce(0, Integer::sum);
//        return 좋아;
        return csvLines.stream()
                .map(line -> countContains(line[2], 0))
                .reduce(0, Integer::sum);
    }
    private int countContains(String src, int fromIndex) {
        int index = src.indexOf("좋아", fromIndex);
        if (index >= 0) {
            return 1 + countContains(src, index + "좋아".length());
        }
        return 0;
    }

    private List<String[]> readCsvLines() throws IOException {
        CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/user.csv").getFile()));
        csvReader.readNext();
        return csvReader.readAll();
    }

}
