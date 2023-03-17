import com.sun.tools.javac.Main;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.Scanner;

//ToDo:
//  better spacing between lines (score results, color coded?)
// optimize code - use better methods for repeated blocks

public class PaperRockScissorsV2 {
    public static int playerChoice = 0;
    public static int opponentChoice = 0;
    public static int winRecord=0;
    public static int tieRecord=0;
    public static int lossRecord=0;
    public static void main(String[] arg) throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        boolean playing = true;
        boolean tryAgain=true;
        Scanner input = new Scanner(System.in);
        //boolean tryAgain= true;
        System.out.println("\nWelcome to the Paper/Rock/Scissors Simulator Version 2 - now with the 'Lizard/Spock' Expansion!");
        System.out.println(Weapons.theRules);

        while (playing) {


            System.out.println("\nWho would you like to play against?");
            System.out.println("0. *RANDOM* \t 3. Howard");
            System.out.println("1. Stuart \t\t 4. Raj");
            System.out.println("2. Sheldon \t\t 5. Leonard");

            System.out.println("\nEnter an opponent's number:");

                validateOpponent();

                if (opponentChoice == 0) {
                    opponentChoice = (int) (Math.random() * 8) + 1;
                    System.out.println("You chose a random opponent.");

            }

            System.out.println("You will be playing against " + Opponents.getPlayerName(opponentChoice) + ".");

            System.out.println("\nPlease choose your weapon:");
            System.out.println("1. Rock \t\t 4. Lizard");
            System.out.println("2. Paper \t\t 5. Spock");
            System.out.println("3. Scissors \t 0. Random");
            System.out.println("\nEnter a number:");

            validateWeapon();

            if (playerChoice == 0) {
                playerChoice = (int) (Math.random() * 5) + 1;
                System.out.println("You chose a random weapon to throw.");
            }
            System.out.println("\nIt's on! "+Opponents.getPlayerName(opponentChoice)+", are you ready?\n");


            if (opponentChoice == 1) {
                Opponents.playStuart(playerChoice);
                System.out.println(Weapons.readyChant);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", " + Opponents.getPlayerName(opponentChoice) + " played " +
                        Weapons.getWeaponName(Opponents.stuartChoice) + ".");
                System.out.println(Weapons.getResults(playerChoice, Opponents.stuartChoice));
                if (playerChoice != 6) {
                    System.out.println("You win!");
                    winRecord=winRecord+1;
                    Sounds.playSound("happynoise.wav");
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                }else {
                    System.out.println("You lose!");
                    Sounds.playSound("sadnoise.wav");
                    lossRecord=lossRecord+1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                }
            }

            if (opponentChoice == 2) {
                Opponents.playSheldon();
                System.out.println(Weapons.readyChant);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", " + Opponents.getPlayerName(opponentChoice) + " played " +
                        Weapons.getWeaponName(Opponents.sheldonChoice) + ".");
                System.out.println(Weapons.getResults(playerChoice, Opponents.sheldonChoice));
                if (playerChoice==Opponents.sheldonChoice){
                    Sounds.playSound("tienoise.wav");
                    tieRecord=tieRecord+1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");

                }else if ((playerChoice != Opponents.sheldonChoice) && (Weapons.getWinLoss(playerChoice, Opponents.sheldonChoice))) {
                    System.out.println("You win!");
                    Sounds.playSound("happynoise.wav");
                    winRecord=winRecord+1;
                    wrapUp();
                } else if ((playerChoice != Opponents.sheldonChoice)) {
                    System.out.println("You lose! BAZINGA!!");
                    Sounds.playSound("BAZINGA.wav");
                    lossRecord=lossRecord+1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                }

            }
            if (opponentChoice == 3) {
                Opponents.playHoward(playerChoice);
                System.out.println(Weapons.readyChant);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", " + Opponents.getPlayerName(opponentChoice) + " played " +
                        Weapons.getWeaponName(Opponents.howardChoice) + ".");
                System.out.println(Weapons.getResults(playerChoice, Opponents.howardChoice));
                if (playerChoice==Opponents.howardChoice) {
                    Sounds.playSound("tienoise.wav");
                    tieRecord = tieRecord + 1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                }else if ((playerChoice != Opponents.howardChoice) && (Weapons.getWinLoss(playerChoice, Opponents.howardChoice))) {
                    System.out.println("You win!");
                    Sounds.playSound("happynoise.wav");
                    winRecord=winRecord+1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                } else if ((playerChoice != Opponents.howardChoice)) {
                    System.out.println("You lose!");
                    Sounds.playSound("sadnoise.wav");
                    lossRecord=lossRecord+1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                }
            }
            if (opponentChoice == 4) {
                Opponents.playRaj(playerChoice);
                System.out.println(Weapons.readyChant);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", " + Opponents.getPlayerName(opponentChoice) + " played " +
                        Weapons.getWeaponName(Opponents.rajChoice) + ".");
                System.out.println(Weapons.getResults(playerChoice, Opponents.rajChoice));
                if (playerChoice==Opponents.rajChoice) {
                    Sounds.playSound("tienoise.wav");
                    tieRecord = tieRecord + 1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                }else if ((playerChoice != Opponents.rajChoice) && (Weapons.getWinLoss(playerChoice, Opponents.rajChoice))) {
                    System.out.println("You win!");
                    Sounds.playSound("happynoise.wav");
                    winRecord=winRecord+1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                } else if ((playerChoice != Opponents.rajChoice)) {
                    System.out.println("You lose!");
                    Sounds.playSound("sadnoise.wav");
                    lossRecord=lossRecord+1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                }
            }
            if (opponentChoice == 5) {
                Opponents.playLeonard(playerChoice);
                System.out.println(Weapons.readyChant);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", " + Opponents.getPlayerName(opponentChoice) + " played " +
                        Weapons.getWeaponName(Opponents.leonardChoice) + ".");
                System.out.println(Weapons.getResults(playerChoice, Opponents.leonardChoice));
                if (playerChoice==Opponents.leonardChoice) {
                    Sounds.playSound("tienoise.wav");
                    tieRecord = tieRecord + 1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                }else if ((playerChoice != Opponents.leonardChoice) && (Weapons.getWinLoss(playerChoice, Opponents.leonardChoice))) {
                    System.out.println("You win!");
                    Sounds.playSound("happynoise.wav");
                    winRecord=winRecord+1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                } else if ((playerChoice != Opponents.howardChoice)) {
                    System.out.println("You lose!");
                    Sounds.playSound("sadnoise.wav");
                    lossRecord=lossRecord+1;
                    wrapUp();
                    String answer = input.nextLine();
                    playing = answer.equalsIgnoreCase("y");
                }
            }
            if (opponentChoice == 6) {
                Opponents.playPenny();
                System.out.println(Weapons.readyChant);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", " + Opponents.getPlayerName(opponentChoice) + " played " +
                        Weapons.getWeaponName(Opponents.pennyChoice) + ".");
                System.out.println("You lose!  (Really, when nuclear weapons get involved, we ALL lose.)");
                Sounds.playSound("sadnoise.wav");
                lossRecord=lossRecord+1;
                wrapUp();
                String answer = input.nextLine();
                playing = answer.equalsIgnoreCase("y");
            }
            if (opponentChoice == 7) {
                Opponents.playWil(playerChoice);
                System.out.println(Weapons.readyChant);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", " + Opponents.getPlayerName(opponentChoice) + " played " +
                        Weapons.getWeaponName(Opponents.wilChoice) + ".");
                System.out.println(Weapons.getResults(playerChoice, Opponents.wilChoice));
                if (playerChoice == 6) {
                    System.out.println("You lose! (Really, when nuclear weapons get involved, we ALL lose.)");
                } else System.out.println("You lose! ...WHEEEEAAAATOOOON!!!!");
                Sounds.playSound("sadnoise.wav");
                lossRecord=lossRecord+1;
                wrapUp();
                String answer = input.nextLine();
                playing = answer.equalsIgnoreCase("y");
            }
            if (opponentChoice == 8) {
                Opponents.playJoshua(playerChoice);
                System.out.println(Weapons.readyChant);
                System.out.println("\nYou played " + Weapons.getWeaponName(playerChoice) +
                        ", " + Opponents.getPlayerName(opponentChoice) + " played " +
                        Weapons.getWeaponName(Opponents.joshuaChoice) + ".");
                System.out.println("You tied! 'A strange game. The only winning move is not to play.'");
                Sounds.playSound("tienoise.wav");
                tieRecord=tieRecord+1;
                wrapUp();
                String answer = input.nextLine();
                playing = answer.equalsIgnoreCase("y");
            }

        }
        System.out.println("Thanks for playing! Have a great day!");
        System.out.println("Your final record for this session is: "+winRecord+" Wins, "+tieRecord+" Ties, and "+lossRecord+" Losses");
        System.out.println("This game built by Don Tuininga, Copyright 2022");

    }
    public static void wrapUp(){
        System.out.println("Your current record is: "+winRecord+" Wins, "+tieRecord+" Ties, and "+lossRecord+" Losses");
        System.out.println("Do you wish to play again? Y/N");

    }
    public static int validateOpponent(){
        boolean tryAgain=true;
        while (tryAgain) {

            try {
                Scanner input = new Scanner(System.in);
                opponentChoice = Integer.parseInt(input.nextLine());

            }catch (NumberFormatException exception) {
                System.out.println("Your entry wasn't valid, Please enter a single digit NUMBER.");
                System.out.println("Please enter a number:");
                validateOpponent();
            }
                if (opponentChoice < 0 || opponentChoice > 8) {
                    System.out.println("That number was outside the range of available options, please try again.");

                }else if (opponentChoice>=0 &&opponentChoice<9){
                    tryAgain=false;
                }
        }return opponentChoice;
    }
    public static int validateWeapon() {
        boolean tryAgain = true;
        while (tryAgain) {

            try {
                Scanner input = new Scanner(System.in);
                playerChoice = Integer.parseInt(input.nextLine());

            } catch (NumberFormatException exception) {
                System.out.println("Your entry wasn't valid, Please enter a single digit NUMBER.");
                System.out.println("Please enter a number:");
                validateOpponent();
            }
            if (playerChoice < 0 || playerChoice > 6) {
                System.out.println("That number was outside the range of available options, please try again.");

            } else if (playerChoice >= 0 && playerChoice < 7) {
                tryAgain = false;
            }
        }
        return playerChoice;
    }
}