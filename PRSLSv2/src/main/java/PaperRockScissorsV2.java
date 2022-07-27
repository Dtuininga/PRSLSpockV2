import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class PaperRockScissorsV2 {
    public static int playerChoice = 0;
    public static int opponentChoice = 0;

    public static void main(String[] arg) {

        //add play again, change ints to objects, make random weapon 4th choice
        int playerChoice;
        System.out.println("\nWelcome to the Paper/Rock/Scissors Simulator Version 2 - now with the 'Lizard/Spock Expansion!" );

        System.out.println("\nWho would you like to play against?");
        System.out.println("1. Stuart \t 4. Raj");
        System.out.println("2. Sheldon \t 5. Leonard");
        System.out.println("3. Howard \t 0. *RANDOM*");
        Scanner input = new Scanner(System.in);
        try {
            opponentChoice = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("You didn't enter a valid choice, so an opponent will be randomly assigned!");
            opponentChoice = (int) (Math.random() * 8) + 1;
        }
        if (opponentChoice<0 || opponentChoice>8){
            System.out.println("You didn't enter a valid choice, so an opponent will be randomly assigned!");
            opponentChoice = (int) (Math.random() * 8) + 1;
        }
        if (opponentChoice == 0) {
            opponentChoice = (int) (Math.random() * 8) + 1;
            System.out.println("You chose a random opponent.");

        }
        System.out.println("You will be playing against " + Opponents.getPlayerName(opponentChoice)+".");


        System.out.println("\n1. Rock \t\t 4. Lizard");
        System.out.println("2. Paper \t\t 5. Spock");
        System.out.println("3. Scissors \t 0. Random");
        System.out.println("Please choose your weapon:");
        Scanner input2 = new Scanner(System.in);
        try {
            playerChoice = Integer.parseInt(input.nextLine());
        } catch (NumberFormatException nfe) {
            System.out.println("You didn't enter a valid choice, so your weapon will be randomly assigned!");
            playerChoice = (int) (Math.random() * 5) + 1;
        }
        if (playerChoice<0 || playerChoice>6){
            System.out.println("You didn't enter a valid choice, so your weapon will be randomly assigned!");
            playerChoice = (int) (Math.random() * 5) + 1;
        }
        if (playerChoice == 0) {
            playerChoice = (int) (Math.random() * 5) + 1;
            System.out.println("You chose a random weapon.");
        }


        if (opponentChoice == 1) {
            Opponents.playStuart(playerChoice);
            System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                    ", "+Opponents.getPlayerName(opponentChoice)+" played " +
                    Weapons.getWeaponName(Opponents.stuartChoice) + ".");
            System.out.println(Weapons.getResults(playerChoice,Opponents.stuartChoice));
            if (playerChoice!=6){
                System.out.println("You win!");
            }
        }

        if (opponentChoice == 2) {
            Opponents.playSheldon();
            System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                    ", "+Opponents.getPlayerName(opponentChoice)+" played " +
                    Weapons.getWeaponName(Opponents.sheldonChoice) + ".");
            System.out.println(Weapons.getResults(playerChoice,Opponents.sheldonChoice));
            if ((playerChoice!=Opponents.sheldonChoice)&&(Weapons.getWinLoss(playerChoice,Opponents.sheldonChoice))){
                System.out.println("You win!");
            }else if ((playerChoice!=Opponents.sheldonChoice)){
                System.out.println("You lose! BAZINGA!!");
            }
        }
            if (opponentChoice == 3) {
                Opponents.playHoward(playerChoice);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", "+Opponents.getPlayerName(opponentChoice)+" played " +
                        Weapons.getWeaponName(Opponents.howardChoice) + ".");
                System.out.println(Weapons.getResults(playerChoice,Opponents.howardChoice));
                if ((playerChoice!=Opponents.howardChoice)&&(Weapons.getWinLoss(playerChoice,Opponents.howardChoice))) {
                    System.out.println("You win!");
                }else if ((playerChoice!=Opponents.howardChoice)){
                    System.out.println("You lose!");
                }
            }
            if (opponentChoice == 4) {
                Opponents.playRaj(playerChoice);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", "+Opponents.getPlayerName(opponentChoice)+" played " +
                        Weapons.getWeaponName(Opponents.rajChoice) + ".");
                System.out.println(Weapons.getResults(playerChoice,Opponents.rajChoice));
                if ((playerChoice!=Opponents.rajChoice)&&(Weapons.getWinLoss(playerChoice,Opponents.rajChoice))){
                    System.out.println("You win!");
                }else if ((playerChoice!=Opponents.rajChoice)){
                    System.out.println("You lose!");
                }
            }
            if (opponentChoice == 5) {
                Opponents.playLeonard(playerChoice);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", "+Opponents.getPlayerName(opponentChoice)+" played " +
                        Weapons.getWeaponName(Opponents.leonardChoice) + ".");
                System.out.println(Weapons.getResults(playerChoice,Opponents.leonardChoice));
                if ((playerChoice!=Opponents.leonardChoice)&&(Weapons.getWinLoss(playerChoice,Opponents.leonardChoice))){
                    System.out.println("You win!");
                }else if ((playerChoice!=Opponents.howardChoice)){
                    System.out.println("You lose!");
                }
            }
            if (opponentChoice == 6) {
                Opponents.playPenny();
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", "+Opponents.getPlayerName(opponentChoice)+" played " +
                        Weapons.getWeaponName(Opponents.pennyChoice) + ".");
                System.out.println("You lose!  Really, when nuclear weapons get involved, we ALL lose.");
            }
            if (opponentChoice == 7) {
                Opponents.playWil(playerChoice);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", "+Opponents.getPlayerName(opponentChoice)+" played " +
                        Weapons.getWeaponName(Opponents.wilChoice) + ".");
                System.out.println(Weapons.getResults(playerChoice,Opponents.wilChoice));
                if (playerChoice==6){
                    System.out.println("You lose! Really, when nuclear weapons get involved, we ALL lose.");
                }else System.out.println("You lose! ...WHEEEEAAAATOOOON!!!!");
            }
            if (opponentChoice == 8) {
                Opponents.playJoshua(playerChoice);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", "+Opponents.getPlayerName(opponentChoice)+" played " +
                        Weapons.getWeaponName(Opponents.joshuaChoice) + ".");
                System.out.println("You tied! ...a strange game. The only winning move is not to play.");
            }
        }
}
