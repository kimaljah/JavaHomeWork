
package HomeWork1;

import java.util.Scanner;

/**
 * hw01_1
 * // Вычислить n-ое треугольного число (сумма чисел от 1 до n), 
 */
public class hw01_1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите первое число: ");
        int n = iScanner.nextInt();
        System.out.printf("Треугольное число: %s ", treugchislo(n));
        iScanner.close();
}

    public static int treugchislo(int n) {
    return (n * (n - 1)) /2 ;
}
}