package GamesLabb1;

import java.sql.SQLOutput;
import java.util.*;

public class GamesLabb1 {
   public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){


        printmenu();

        Scanner textScanner = new Scanner(System.in);
        String textInput = textScanner.nextLine();

        while (true) {

            switch (textInput) {
                case "1":
                    System.out.println("Excellent! you picked up and down!");
                    System.out.println("Instructions:");
                    System.out.println("-------------");
                    System.out.println("Pick minimum of three words or numbers.");
                    System.out.println("After writing each word or number press Enter.");
                    System.out.println("After the last word or numbers press Enter and type the word END and press Enter again to see what the words or number will do");
                    System.out.println("After the game is finished you are going to get returned to the main menu");
                    upandown();
                    break;
                case "2":
                    System.out.println("Good choice! You picked Min Max!");
                    System.out.println("Instructions:");
                    System.out.println("-------------");
                    System.out.println("Pick five numbers randomly that are high and low and type them in on each row by pressing enter. ");
                    System.out.println("Keep do that until you have reached five numbers to see the outcome. ");
                    System.out.println("After the game is finished you are going to get returned to the main menu");
                    minMax();
                    break;
                case "3":
                    System.out.println("Brilliant choice! Let the challenge begin!");
                    System.out.println("instructions:");
                    System.out.println("-------------");
                    System.out.println("You have to type in one of the following alternatives 'Rock' 'Paper' or 'Scissor'. ");
                    System.out.println("The computer will also randomly select 'Rock' 'Paper' or 'Scissor' ");
                    System.out.println("Paper wins over rock and loses against scissor. Rock wins over scissor and loses against paper. " +
                                    "Scissor wins over paper and loses against rock. ");
                    System.out.println("Equal choice results in ties. best out of 3 will win the whole game! ");
                    System.out.println("After the game is finished you are going to get returned to the main menu");
                    rockPaperScissors();
                    break;
                case"e":
                case"E":
                    return;
                default:
                    System.out.println("Not a valid choice, pleas try again or press E to quit");
                    break;

            }
            printmenu();
            textInput = textScanner.nextLine();
        }


    }


    public static void upandown() {

        ArrayList<String> arrlist = new ArrayList<>();

        String choice = "END";

        while (true)
        {

            String text = sc.nextLine();
            if(text.equals(choice))
                break;

            arrlist.add(text);

        }

        Collections.reverse(arrlist);
        System.out.println(arrlist);
        Collections.sort(arrlist);

    }

    public static void minMax() {

        int[] array = new int [5];
        int counter = 0;
        while(counter<5) {
            int text = sc.nextInt();

            array[counter] = text;
            counter++;
        }

        Arrays.sort(array);
        System.out.println("Min Value = " + array[0]);
        System.out.println("Max Value = " + array[array.length-1]);

    }

    private static void rockPaperScissors() {

       while(true) {
           int wins = 0;
           int loss = 0;
           int round = 0;
           int Player = 0;


           System.out.println("Please type in your move now ('Rock' 'Paper' or 'Scissor' and then press Enter");


           while(round < 3) {

               Random cpuRandom = new Random();
               int computer = cpuRandom.nextInt(3);

               int Rock, Paper, Scissor;
               Rock = 1;
               Paper = 2;
               Scissor = 3;



               String userInput = sc.next();
               if (userInput.equals("Rock")) {
                   Player = 1;
               }
               if (userInput.equals("Paper")) {
                   Player = 2;
               }
               if (userInput.equals("Scissor")) {
                   Player = 3;
               }



               if (Player == computer) {
                   if (Player == Scissor) {
                       System.out.println("Both picked Scissor, its a tie! ");
                       round++;
                   }
                   if (Player == Rock) {
                       System.out.println("Both picked Rock, its a tie! ");
                       round++;
                   }
                   if (Player == Paper) {
                       System.out.println("Both picked Paper, its a tie! ");
                       round++;
                   }
                   System.out.println("You have won " + wins + " times and the computer has won " + loss + " times ");

               }

               if (Player == Scissor)
                   if (computer == Paper) {
                       System.out.println("The computer picked Paper, you win! ");
                       wins++;
                       round++;
                       System.out.println("You have won " + wins + " times and computer has " + loss + " times ");
                   } else if (computer == Rock) {
                       System.out.println("The computer picked Rock, you loose");
                       loss++;
                       round++;
                       System.out.println("You have won " + wins + " times and the computer has won " + loss + " times ");
                   }
               if (Player == Rock)
                   if (computer == Scissor) {
                       System.out.println("The computer picked Scissor, you win! ");
                       wins++;
                       round++;
                       System.out.println("You have won " + wins + " times and the computer has won " + loss + " times ");
                   } else if (computer == Paper) {
                       System.out.println("The computer picked paper, you loose! ");
                       loss++;
                       round++;
                       System.out.println("You have won " + wins + " times and the computer has won " + loss + " times ");
                   }
               if (Player == Paper)
                   if (computer == Rock) {
                       System.out.println("The computer picked Rock, you win!");
                       wins++;
                       round++;
                       System.out.println("You have won " + wins + " times and the computer has won " + loss + " times ");
                   } else if (computer == Scissor) {
                       System.out.println("The computer picked Scissor, you loose!");
                       wins++;
                       round++;
                       System.out.println("You have won " + wins + " times and the computer has won " + loss + " times ");
                   }

           }
           if (wins > loss) {
               System.out.println("Congratulations you have won the tournament best out of 3 wins on Rock, Paper and Scissor ");
           }
           if (loss > wins) {
               System.out.println("You lost against the computer. Sorry, hope that you get better luck next time! ");
           }
           break;

       }
    }


    private static void printmenu(){


        System.out.println("--------------------------------------------");
        System.out.println("|              Welcome!                    |");
        System.out.println("| Please choose a game from the main menu  |");
        System.out.println("--------------------------------------------");

        System.out.println("               ");

        System.out.println("1. Up and down");
        System.out.println("2. Min Max");
        System.out.println("3. Rock Paper Scissor");
        System.out.println("E. Exit");


    }


}