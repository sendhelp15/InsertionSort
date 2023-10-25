import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============");
        System.out.println("insertion sort");
        System.out.println("==============");

        System.out.println();
        System.out.println("Wybór:");
        System.out.println("1 - wylosuj tabelę");
        System.out.println("2 - stwórz własną tabelę");

        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();

        if (choice == 1) {
            int length = 10;
            double[] table;
            table = new double[length];
            for (int i = 0; i < length; i++) {
                table[i] = (double) (int) (Math.random() * 100);
                System.out.print(table[i] + ", ");
            }
            System.out.println();
            insertionSort(table);
        } else if (choice == 2) {
            System.out.println("Wybierz długość tabeli:");
            int length = scan.nextInt();
            double[] table;
            table = new double[length];
            for (int i = 0; i < length; i++) {
                System.out.println("Podaj liczbę " + (i + 1));
                table[i] = scan.nextDouble();
                scan.nextLine();
            }
            for (double itr : table) System.out.print(itr + ", ");
            System.out.println();
            insertionSort(table);
        }
    }

    public static void insertionSort(double[] doubleArray) {
        double temp = 0;
        int n = doubleArray.length;
        for (int i = 1; i < n; i++) {
            temp = doubleArray[i];
            for (int j = i - 1; j >= 0; j--) {
                if (doubleArray[j] > temp) {
                    doubleArray[j + 1] = doubleArray[j];
                    doubleArray[j] = temp;
                }
            }
        }
        for (double v : doubleArray) {
            System.out.print(v + ", ");
        }
    }

    public static double loadNumber(Scanner scanner) {
        String strNumber = scanner.nextLine();
        boolean isNum = true;
        for (int i = 0; i < strNumber.length(); i++) {
            if (strNumber.charAt(i) < 48 || strNumber.charAt(i) > 57) {
                System.out.println("To nie jest liczba.");
                isNum = false;
                break;
            }


        }
        if (isNum) {
            return parseDouble(strNumber);
        } else return loadNumber(scanner);
    }
}