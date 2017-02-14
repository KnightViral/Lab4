import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner in = new Scanner(System.in);
        Integer num;
        Squad squad1 = new Squad();
        System.out.println("************************");
        Squad squad2 = null;
        loop: while (true) {
            System.out.println("1. Создать копию отряда. \n2. Создать новый отряд.");
            num = in.nextInt();
            switch (num) {
                case 1:
                    squad2 = squad1.clone();
                    break loop;
                case 2:
                    squad2 = new Squad();
                    break loop;
                default:
                    System.out.println("ОШИБКА:<Нет такого номера.> \n**********************");
                    break;
            }
        }
        new Battle(squad1,squad2);
    }


}
