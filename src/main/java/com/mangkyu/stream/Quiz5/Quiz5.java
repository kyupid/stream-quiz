package com.mangkyu.stream.Quiz5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Quiz5 {

    private static final String[] STRING_ARR = {"aaa", "bb", "c", "dddd"};

    // 5.1 모든 문자열의 길이를 더한 결과를 출력하여라.
    public int quiz1() {
        return 0;
    }

    // 5.2 문자열 중에서 가장 긴 것의 길이를 출력하시오.
    public int quiz2() {
        return 0;
    }

    // 5.3 임의의 로또번호(1~45)를 정렬해서 출력하시오.
    public List<Integer> quiz3() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add((int) (Math.random() * 45) + 1);
        }
        return list;
    }

    public static void main(String[] args) {
        IntStream ints = new Random().ints(1, 46);

        // 1,2,3,4,5,6, .....46
        new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .forEach(System.out::println);

    }


    // 5.4 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
    public List<Integer[]> quiz4() {
        return Collections.emptyList();
    }

}
