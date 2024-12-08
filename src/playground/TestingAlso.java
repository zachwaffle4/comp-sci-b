import playground.Animal;

import java.util.Arrays;
import java.util.List;

void main() {
    System.out.println("wow im not in a class omg");
    Integer[] ints = {1,2,3,4,5,6,7,8,9,10};

    List<Integer> list = Arrays.asList(ints);
    List<Integer> list2 = list.stream().map(this::addOne).toList();

    System.out.println(list2);
}

int addOne(int i) {
    return i + 1;
}