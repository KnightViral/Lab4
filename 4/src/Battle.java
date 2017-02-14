public class Battle {

    Battle(Squad squad1,Squad squad2){
        DateHelper Date = new DateHelper();
        System.out.println("\n***************************************************** \nДата начала боя: "+Date.getFormattedStartDate()+"\n*****************************************************");
        while(true) {
            squad2.getRandomWarrior().takeDamage(squad1.getRandomWarrior().attack());
            Date.skipTime();
            if (!squad2.hasAliveWarriors()){
                System.out.println("\n******************* \nПобедил отряд: "+ squad1+"\n*******************");
                squad1.showAliveWarriors();
                break;
            }
            squad1.getRandomWarrior().takeDamage(squad2.getRandomWarrior().attack());
            Date.skipTime();
            if (!squad1.hasAliveWarriors()){
                System.out.println("\n******************* \nПобедил отряд: "+ squad2+"\n*******************");
                squad2.showAliveWarriors();
                break;
            }
        }
        System.out.println("************************");
        System.out.println(Date.getFormattedDiff());
    }
}
