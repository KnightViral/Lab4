import java.io.Serializable;
import java.util.Scanner;

public class Archer implements Warrior, Cloneable, Serializable {
    int health=60;
    String squadName;
    String warriorName;
    String className="Лучник";

    Archer(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя бойца:");
        this.warriorName = in.nextLine();
    }

    Archer(String name){
        this.warriorName = name;
    }

    @Override
    public int attack() {
        System.out.println(toString()+" атакует.");
        return ((int) (Math.random() * 20)+40);
    }

    @Override
    public void takeDamage(int damage) {
        this.health=this.health-damage;
        System.out.println(toString()+" получил "+damage+" единиц урона, его здоровье: "+this.health);
        if(!isAlive()) System.out.println(toString()+ " погибает.");
    }

    @Override
    public boolean isAlive() {
        if (this.health>0) return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return className+" "+warriorName+" из отряда "+squadName;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health=health;
    }

    public String getSquadName(){
        return squadName;
    }

    @Override
    public void setSquadName(String squadName){
        this.squadName=squadName;
    }

    public String getWarriorName(){
        return warriorName;
    }

    public void setWarriorName(String warriorName){
        this.warriorName=warriorName;
    }

    @Override
    public Archer clone() throws CloneNotSupportedException {
        return (Archer) super.clone();
    }


}