import java.util.HashMap;
import java.util.*;
public class Weapons {
    //objects for weapons choices. paper, rock, scissors, lizard, spock, nuke
    // objects should have comparator rankings, attached win/loss statements, and be included in a map that
    //ties each throwable to a numbered key (1=rock, 2=paper, etc)
    public static final String readyChant= "PAPER! ROCK! SCISSORS! LIZARD! SPOCK!"; //add time delay so words appear in 1/2 second increments

    public static String getWeaponName(int choice){
        Map<Integer, String> weaponMap = new HashMap<>();

        weaponMap.put(1, "rock");
        weaponMap.put(2, "paper");
        weaponMap.put(3, "scissors");
        weaponMap.put(4, "lizard");
        weaponMap.put(5, "Spock");
        weaponMap.put(6, "NUKE");
        {
            return weaponMap.get(choice);
        }
    }
    public static final String theRules = "\n*THE RULES*"+
            "\nScissors cuts Paper, Paper covers Rock, " +
            "\nRock crushes Lizard, Lizard poisons Spock,"+
            "\nSpock smashes Scissors, Scissors decapitates Lizard,"+
            "\nLizard eats Paper, Paper disproves Spock,"+
            "\nSpock vaporizes Rock, (and as it always has) Rock crushes Scissors";

    public static String getResults(int weapon1, int weapon2){
        String results="";
        if (weapon1==weapon2){
            results = "It's a tie! Oh no!";
        }else if (((weapon1==1)&&(weapon2==2))||((weapon1==2 && weapon2==1))){ //1vs2
            results = "Paper covers Rock.";
        }else if (((weapon1==3)&&(weapon2==2))||((weapon1==2 && weapon2==3))){ //2vs3
            results = "Scissors cuts Paper.";
        }else if (((weapon1==1)&&(weapon2==3))||((weapon1==3 && weapon2==1))){ //1vs3
            results = "...and as it always has, Rock crushes Scissors.";
        }else if (((weapon1==3)&&(weapon2==4))||((weapon1==4 && weapon2==3))){ //3vs4
            results = "Scissors decapitates lizard.";
        }else if (((weapon1==1)&&(weapon2==4))||((weapon1==4 && weapon2==1))){ //1vs4
            results = "Rock smashes Lizard.";
        }else if (((weapon1==4)&&(weapon2==2))||((weapon1==2 && weapon2==4))){ //2vs4
            results = "Lizard eats Paper.";
        }else if (((weapon1==1)&&(weapon2==5))||((weapon1==5 && weapon2==1))){ //1vs5
            results = "Spock vaporizes Rock.";
        }else if (((weapon1==2)&&(weapon2==5))||((weapon1==5 && weapon2==2))){ //2vs5
            results = "Paper disproves Spock.";
        }else if (((weapon1==3)&&(weapon2==5))||((weapon1==5 && weapon2==3))){ //3vs5
            results = "Spock smashes Scissors.";
        }else if (((weapon1==4)&&(weapon2==5))||((weapon1==5 && weapon2==4))) { //4vs5
            results = "Lizard poisons Spock.";
        }else if (weapon1==6){ //playable, but will not show up by random
            results = "...Nuke? Really? You've doomed us all." +
                    "\nNobody wins, and we have to wait for civilization to rebuild to play again. Shame on you.";
        }
        return results;
    }
    public static Boolean getWinLoss(int playerWeapon, int opponentWeapon){
        if ((playerWeapon==1)&&((opponentWeapon==3)||(opponentWeapon==4))){ //player wins with rock
            return true;
        }else if ((playerWeapon==2)&&((opponentWeapon==5)||(opponentWeapon==1))){//player wins with paper
            return true;
        }else if ((playerWeapon==3)&&((opponentWeapon==2)||(opponentWeapon==4))){//player wins with scissors
            return true;
        }else if ((playerWeapon==4)&&((opponentWeapon==2)||(opponentWeapon==5))){//player wins with lizard
            return true;
        }else if ((playerWeapon==5)&&((opponentWeapon==1)||(opponentWeapon==3))) {//player wins with spock
            return true;
        }else return false;
    }

}