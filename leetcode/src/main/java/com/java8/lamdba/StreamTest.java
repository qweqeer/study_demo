package com.java8.lamdba;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author: zhoux
 * @Email: zhouxiang@souche.com
 * @CreateDate: 2018/2/2
 * @Description:
 * @Modify :
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs =
            numbers1.stream()
                .flatMap(i ->
                    numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());
        IntStream twos = IntStream.generate(new IntSupplier(){
            public int getAsInt(){
                return 2;
            }
        });
    }



}
@Setter
@Getter
@ToString
class Car{
    private String color;

    private String brandName;

    private Integer year;

    public Car() {
    }

}
