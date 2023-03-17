import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

public class Opponents {
    /*characters to play against.
    Stuart (option 1)- always loses
    Sheldon (option 2)- always plays spock
    Howard (option 3)- sticks to paper/rock/scissors
    Raj (option 4)- plays p,r,s and spock
    Leonard (option 5)- plays anything but "nuke"
    Penny - hidden character (option 6), only shows up if "random" is chosen, only plays "nuke"
    "traveler" Wil Wheaton (option 7)- only shows if random is picked, always wins
    Joshua - hidden character, always ties
    */
    public static int stuartChoice = 0;
    public static int wilChoice = 0;
    public static int sheldonChoice = 5;
    public static int pennyChoice=6;
    public static int leonardChoice = 0;
    public static int rajChoice = 0;
    public static int howardChoice = 0;
    public static int joshuaChoice = 0;
    public static int playStuart(int playerInput) { // only plays p/r/s, always loses
        String intro = "Stuart shuffles over and half-heartedly prepares to play.";
        System.out.println(intro);
        if ((playerInput == 2) || (playerInput == 5)) {
            stuartChoice = 1; //plays rock to lose against paper or spock
        } else if ((playerInput == 3) || (playerInput == 4)) {
            stuartChoice = 2; //plays paper to lose against scissors or lizard
        } else if (playerInput == 1) {
            stuartChoice = 3; //plays scissors to lose against rock
        } else if (playerInput == 6) {
            stuartChoice = 4; //plays lizard because nothing matters against Nuke

        }
        return stuartChoice;
    }

    public static int playWil(int playerInput) { // always wins
        String intro = "Wil Wheaton beams in and smiles warmly. 'Let's play more games!'";
        System.out.println(intro);
        if ((playerInput == 1) || (playerInput == 3)) {
            wilChoice = 5; //plays Spock to win against rock or scissors
        } else if ((playerInput == 2) || (playerInput == 5)) {
            wilChoice = 4; //plays lizard to win against paper or Spock
        } else if (playerInput == 4) {
            wilChoice = 3; //plays scissors to win against lizard
        } else if (playerInput == 6) {
            wilChoice = 1; //plays paper because nothing matters against Nuke
        }
        return wilChoice;
    }
    public static int playSheldon() { // only plays spock
        String intro = "Sheldon looks smug and eager to play.";
        System.out.println(intro);
        return sheldonChoice;
    }
    public static int playPenny() { // cheats, only plays nuke
        String intro = "Penny doesn't want to play, but rolls her eyes and prepares to humiliate you. \nEr, HUMOR you.";
        System.out.println(intro);
        return pennyChoice;
    }
    public static int playRaj(int playerInput) {//plays p,r,s,l
        String intro = "Raj nods and says, 'You're going DOWN!'";
        System.out.println(intro);
        rajChoice = (int) (Math.random() * 4)+1;
        return rajChoice;
    }
    public static int playLeonard(int playerInput) {//plays all 5
        String intro = "Leonard smiles and says, 'This'll be fun!'";
        System.out.println(intro);
        leonardChoice = (int) (Math.random() * 5)+1;
        return leonardChoice;
    }
    public static int playHoward(int playerInput) {//plays p,r,s,
        String intro = "Howard smirks and says, 'Don't worry, I'll go easy on ya.'";
        System.out.println(intro);
        howardChoice = (int) (Math.random() * 3)+1;
        return howardChoice;
    }
    public static int playJoshua(int playerInput) { // only ties
        String intro = "'Greetings Professor Falken. Would you like to play a game?'";
        System.out.println(intro);
        joshuaChoice=playerInput;
        return joshuaChoice;
    }
    public static String getPlayerName(int choice){
        Map<Integer, String> playerMap = new HashMap<>();

        playerMap.put(1, "Stuart");
        playerMap.put(2, "Sheldon");
        playerMap.put(3, "Howard");
        playerMap.put(4, "Raj");
        playerMap.put(5, "Leonard");
        playerMap.put(6, "Penny");
        playerMap.put(7, "Wil Wheaton");
        playerMap.put(8, "Joshua");
        {
            return playerMap.get(choice).toString();
        }
    }
}