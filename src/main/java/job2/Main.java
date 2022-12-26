package job2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Напишите метод, который принимает на вход строку (String) и определяет является ли строка " +
                "палиндромом (возвращает boolean значение).\n");
        ex1();
        System.out.println("\nНапишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод, " +
                "который запишет эту строку в простой текстовый файл, обработайте исключения.\n");
        ex2();

    }



    public static void ex1() {
        System.out.print("Введите строки через пробел: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arrStr = str.split(" ");
        for (String s : arrStr) {
            if (polindrom(s)) {
                System.out.printf("%s - полиндром \n", s);
            }else {
                System.out.printf("%s - не полиндром \n", s);
            }
        }

    }
    private static boolean polindrom(String s) {
        if (s.length() == 1)
            return true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.toLowerCase().charAt(i) != s.toLowerCase().charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }
    private static void ex2() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("TEST ");
        }
        File file = new File("src/main/resources/files/text_file.txt");
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(sb.toString());
            System.out.println("Запись в файл успешно завершена");
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }

    }






}
