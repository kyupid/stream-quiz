package com.mangkyu.stream.Quiz5;

import java.util.*;
import java.util.stream.*;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    // 5.1 모든 문자열의 길이를 더한 결과를 출력하여라.
    public int quiz1() {
        return Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .sum();
    }

    // 5.2 문자열 중에서 가장 긴 것의 길이를 출력하시오.
    public int quiz2() {
        return Arrays.stream(STRING_ARR)
                .mapToInt(String::length)
                .max().orElse(0);
    }

    // 5.3 임의의 로또번호(1~45)를 정렬해서 출력하시오.
    public List<Integer> quiz3() {
        List<Integer> list = lottoNumbers();
        list.sort(Integer::compare);
        return list;
    }

    private List<Integer> lottoNumbers() {
        return new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toList());
//        Set<Integer> set = new HashSet<>();
//        while (set.size() < 6) {
//            int lottoNumber = (int) (Math.random() * 45) + 1;
//            set.add(lottoNumber);
//        }
//        return new ArrayList<>(set);
    }

    // 5.4 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
    public List<Integer[]> quiz4() {
        int[] dice = new int[]{1, 2, 3, 4, 5, 6};
        Set<Integer[]> result = new LinkedHashSet<>();
        for (int i = 0; i < dice.length; i++) {
            for (int j = 0; j < dice.length; j++) {
                if (dice[i] + dice[j] == 6) {
                    System.out.println("i: " + dice[i] + ", j: " + dice[j]);
                    result.add(new Integer[]{dice[i], dice[j]});
                }
            }
        }
        result.stream()
                .forEach(i -> System.out.println(Arrays.toString(i)));
        return new ArrayList<>(result);
//        IntStream.rangeClosed(1, 6)
//                .boxed()
//                .flatMap(i -> IntStream.rangeClosed(1, 6)
//                        .boxed()
//                        .map(j -> new Integer[]{i, j}))
//                .filter(arr -> arr[0] + arr[1] == 6)
//                .collect(Collectors.toList())
//                .forEach(i -> System.out.println(Arrays.toString(i)));
//        return Collections.emptyList();

//        return collect;
//        return integers;
    }

}
