package HomeWork3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


/**
 * Пусть дан произвольный список целых чисел, удалить из него чётные числа
 * hw03_2
 */
public class hw03_2 {


    public static void main(String[] args) {
        deletEvenNum(getRandomList());
    }
    public static List<Integer> getRandomList() {
        Random random = new Random();
        int size = 20;
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        System.out.println(list.toString());
        return list;
    }

    public static List<Integer> deletEvenNum(List<Integer> list) {

        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }

        }
        System.out.println(list.toString());
        return list;
    }

   
}