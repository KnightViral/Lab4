import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Squad implements Cloneable{
    String squadName;
    Warrior[] squadArray;

    Squad() {
        Scanner in = new Scanner(System.in);
        Integer num;
        System.out.println("Введите название отряда:");
        squadName = in.nextLine();
        loop: while (true) {
            System.out.println("Создание отряда: \n1. Создать отряд самому. \n2. Создать случайный отряд.");
            num = in.nextInt();
            switch (num) {
                case 1:
                    System.out.println("Введите количество бойцов в отряде:");
                    num = in.nextInt();
                    squadArray = new Warrior[num];
                    for (int i = 0; i < squadArray.length; ) {
                        System.out.println("Выберите класс бойца: \n1. Ополченец \n2. Копейщик \n3. Лучник \n4. Мечник \n5. Рыцарь");
                        num = in.nextInt();
                        switch (num) {
                            case 1:
                                squadArray[i] = new Peasant();
                                squadArray[i].setSquadName(squadName);
                                i++;
                                break;
                            case 2:
                                squadArray[i] = new Lancer();
                                squadArray[i].setSquadName(squadName);
                                i++;
                                break;
                            case 3:
                                squadArray[i] = new Archer();
                                squadArray[i].setSquadName(squadName);
                                i++;
                                break;
                            case 4:
                                squadArray[i] = new Footman();
                                squadArray[i].setSquadName(squadName);
                                i++;
                                break;
                            case 5:
                                squadArray[i] = new Knight();
                                squadArray[i].setSquadName(squadName);
                                i++;
                                break;
                            default:
                                System.out.println("ОШИБКА:<Нет бойца под таким номером.> \n**********************");
                                break;
                        }
                    }
                    System.out.println("Полученный отряд:");
                    for (int i = 0; i < squadArray.length; i++) {
                        System.out.println(squadArray[i].toString());
                    }
                    break loop;
                case 2:
                    System.out.println("Введите количество бойцов в отряде:");
                    num = in.nextInt();
                    squadArray = new Warrior[num];
                    for (int i = 0; i < squadArray.length; ) {
                        switch (((int) (Math.random() * 4) + 1)) {
                            case 1:
                                squadArray[i] = new Peasant(randomName());
                                squadArray[i].setSquadName(squadName);
                                i++;
                                break;
                            case 2:
                                squadArray[i] = new Lancer(randomName());
                                squadArray[i].setSquadName(squadName);
                                i++;
                                break;
                            case 3:
                                squadArray[i] = new Archer(randomName());
                                squadArray[i].setSquadName(squadName);
                                i++;
                                break;
                            case 4:
                                squadArray[i] = new Footman(randomName());
                                squadArray[i].setSquadName(squadName);
                                i++;
                                break;
                            case 5:
                                squadArray[i] = new Knight(randomName());
                                squadArray[i].setSquadName(squadName);
                                i++;
                                break;
                            default:
                                System.out.println("ОШИБКА:<Нет бойца под таким номером.> \n**********************");
                                break;
                        }
                    }
                    System.out.println("Полученный отряд:");
                    for (int i = 0; i < squadArray.length; i++) {
                        System.out.println(squadArray[i].toString());
                    }
                    break loop;
                    default:
                        System.out.println("ОШИБКА:<Нет такого номера.> \n**********************");
                    break;
            }
        }
    }

    public Squad(String squadName, Warrior[] squadArray) {
    }

    public Warrior[] copySquad(Warrior[] otherSquad) throws IOException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(otherSquad);
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (Warrior[]) ois.readObject();
        }
        catch (Exception e) {
            System.out.println("copySquad");
            e.printStackTrace();
            return null;
        }
    }

    public Warrior getRandomWarrior(){
        int rand=0;
        if(hasAliveWarriors()) {
            while (true) {
                rand = ((int) (Math.random() * squadArray.length));
                if (squadArray[rand].isAlive()) {
                    break;
                }
            }
        }
        return squadArray[rand];
    }

    public boolean hasAliveWarriors() {
        boolean isAlive=false;
        for (int i=0; i<squadArray.length;i++){
            if (squadArray[i].isAlive()!=false) isAlive=true;
        }
        return isAlive;
    }

    public void showAliveWarriors() {
        boolean isAlive=false;
        for (int i=0; i<squadArray.length;i++){
            if (squadArray[i].isAlive()!=false) System.out.println(squadArray[i].toString()+" выжил, его здоровье: "+squadArray[i].getHealth());
        }
    }

    public String randomName(){
        String warriorName = new String();
        switch (((int) (Math.random() * 6)+1)){
            case 1:
                warriorName ="Иван";
            break;
            case 2:
                warriorName = "Илья";
            break;
            case 3:
                warriorName = "Анатолий";
            break;
            case 4:
                warriorName = "Александр";
            break;
            case 5:
                warriorName = "Андрей";
            break;
            case 6:
                warriorName = "Владислав";
            break;
            case 7:
                warriorName = "Дмитрий";
            break;

        }
        return warriorName;
    }

    @Override
    public String toString(){
        return "Отряд "+squadName;
    }

    @Override
    protected Squad clone() throws CloneNotSupportedException {
        Scanner in = new Scanner(System.in);
        Squad squad2 = new Squad(null,null);
        squad2.squadArray = new Warrior[squadArray.length];
        try {
            squad2.squadArray = copySquad(squadArray);
        } catch (IOException e) {
            System.out.println("clone");
            e.printStackTrace();
        }
        System.out.println("Введите название отряда:");
        squad2.squadName = in.nextLine();
        for(int i=0;i<squadArray.length;i++){
            squadArray[i].setSquadName(squad2.squadName);
        }

        return squad2;
    }
}

