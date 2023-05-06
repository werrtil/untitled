
public class Main {
    public static int bossHealth = 700;

    public static int bossDamage = 50;
    public static int[] heroesHealth = {150, 270, 260, 250};
    public static int[] heroesDamage = {0, 25, 20, 15,};
    public static String[] heroesAttackType = {"Medic", "Physical", "Magical", "Telepathic"};
    public static String bossDefenceType;
    public static int round = 0;



    public static void main(String[] args) {
        printStatistics();
        while (!isGameFinished()) {
            round();
            medic();
        }
    }

    public static void bossHits() {
        for (int i = 0; i < heroesAttackType.length; i++) {
            heroesHealth[i] = heroesHealth[i] - bossDamage;

        }
    }

    public static void heroesHits() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] >0 && bossHealth >0) {
                if (heroesAttackType[i] == bossDefenceType) {

                }
            }



        }
    }

    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes WON!!!");
            return true;
        }
        for (int i = 0; i < heroesAttackType.length; i++) {
            if (heroesHealth[i] > 0) {
                return false;

            } else {
                System.out.println("Boss WON!!!");
                return true;
            }
        }
        return false;
    }


    public static void round() {
        round++;
        if (bossHealth >0){
            bossHits();
        }
        heroesHits();
        printStatistics();
    }

    public static void printStatistics() {
        System.out.println("----------------");
        System.out.println(round + "Boss health: " + bossHealth +
                "{" + bossDamage + "}");
        for (int i = 0; i < heroesAttackType.length; i++) {
            if (i == 0) {
                System.out.println("Hero: " + heroesAttackType[0] + " " + heroesHealth[0] + "{" + heroesDamage[0] + "}");
            } else {
                System.out.println("Hero: " + heroesAttackType[i] + " " + heroesHealth[i] +
                        "{" + heroesDamage[i] + "}");
            }
        }
    }

    public static void medic() {
        int index = 0;
        int help = 50;
        for (String name : heroesAttackType) {
            if (name.equals("Medic")) {
                for (int i = 0; i < heroesHealth.length; i++) {
                    if (heroesHealth[i] < 100 && heroesHealth[i] > 0 && heroesHealth[i] != heroesHealth[index] && heroesHealth[index] > 0){
                        heroesHealth [i] +=help;
                        System.out.println("Medic help = "+heroesAttackType [i]);
                        break;
                    }
                }
            }
            index++;
        }
    }
}