```java
public class Main {

    private static final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static final List<Integer> numbers2 = Arrays.asList(3, 4);

    public int version1() {
        return numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> j * i))
                .max((n1, n2) -> Integer.compare(n2, n1)).orElse(0);
    }

    public int version2() {
        return numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> j * i))
                .max((n1, n2) -> Integer.compare(n1, n2)).orElse(0);
    }
}
```

me: in above example code, version1 and version2 have not the same result, why is that?

gpt: In version1, the max() method is passed a comparator that compares n2 and n1, which means that the largest element
will be the one with the highest value of n2. In version2, the comparator compares n1 and n2, which means that the
largest element will be the one with the highest value of n1. Since n1 and n2 are the two elements being compared in the
comparator, the behavior of the max() method will be different depending on the order in which they are passed.
Therefore, version1 and version2 return different results.

me: How can I always get the largest number no matter what values come in n1,n2?

gpt: You can use the built-in Integer.compare(int a, int b) method to compare n1 and n2 and always return the largest
number. The method returns a negative number if a is less than b, 0 if a equals b, and a positive number if a is greater
than b.

Here is an example of how you can use this method to always get the largest number:

```java
public int getLargestNumber(int n1,int n2){
        return Integer.compare(n1,n2)>0?n1:n2;
        }
```

You can then use this method to compare the elements while finding the max in the stream,

```java
public int getLargest(){
        return numbers1.stream()
        .flatMap(i->numbers2.stream()
        .map(j->j*i))
        .max((n1,n2)->Integer.compare(getLargestNumber(n1,n2),getLargestNumber(n2,n1))).orElse(0);
        }
```

This way it will always return the largest number no matter what values come in n1,n2.
