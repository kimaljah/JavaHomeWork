package HomeWork2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;


/**К калькулятору из предыдущего дз добавить логирование.
 * hw02_3
 */
public class hw02_3 {

    public static Scanner iScanner = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException{

        Logger logs = Logger.getLogger(hw02_3.class.getName());
        FileHandler fh = new FileHandler("HomeWork2\\LoggerCalculator.log");
        logs.addHandler(fh);
        fh.setFormatter(new SimpleFormatter()); {
        System.out.printf("Введите первое число: ");
        int num1 = scanNumber();
        logs.setLevel(Level.INFO);
        logs.log(Level.INFO, String.format("Enter first diggit = " + num1));
        System.out.println("Введите оператор: '-' '+' '*' '/'");
        String operations = scanOperations();
        logs.setLevel(Level.INFO);
        logs.log(Level.INFO, String.format("Enter operations diggit = " + operations));
        System.out.printf("Введите второе число: ");
        int num2 = scanNumber();
        logs.setLevel(Level.INFO);
        logs.log(Level.INFO, String.format("Enter second diggit = " + num2));
        int result = getResult(operations, num1, num2);
        System.out.printf("%d %s %d = %d", num1, operations, num2, result);

        }
    }
    public static int scanNumber() {
        int number = iScanner.nextInt();
        return number;

    }
    public static String scanOperations() {
        Scanner iScanner = new Scanner(System.in);
            String operations = iScanner.nextLine();
            return operations;     
    }
    
public static int getResult(String opr, int num1, int num2) {
    int result = 0;
    switch (opr) {
        case "+":
            result = num1 + num2;
            break;
        case "-":
            result = num1 - num2;
            break;
        case "*":
            result = num1 * num2;
            break;
        case "/":
            result = num1 / num2;

        default:
            System.out.println("Введите оператор: -, +, *, /");
            break;
    }
    return result;
}
   
}