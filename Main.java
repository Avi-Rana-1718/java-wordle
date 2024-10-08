import java.util.*;
import javax.swing.*;

class Main {

       static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("***WORDLE***\n");
    }
    
    static int guess(String key, String guessWord) {
        clearScreen();
        int count=0;
            for(int i=0;i<5;i++) {
                if(key.charAt(i)==guessWord.charAt(i)) {
                    System.out.print("\u001B[42m" + guessWord.charAt(i) + "\u001b[0m");
                    count++;
                } else if(key.indexOf(guessWord.charAt(i))!=-1) {
                    System.out.print("\u001B[43m" + guessWord.charAt(i) + "\u001b[0m");
                } else {
                    System.out.print("\u001B[41m" + guessWord.charAt(i) + "\u001b[0m");
                }
            }
            System.out.println("");
        
        return count;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        JFrame frame = new JFrame();
        JLabel title = new JLabel("**WORDLE**");
        JTextField input new JTextField();
        JButton btn = new JButton("Click");

       // btn.setBounds(130, 100, 100, 40);
        title.setBounds(10,30, 200,200);
        frame.add(title);
        frame.add(btn);
        frame.setSize(width, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        clearScreen();
        System.out.println("This program implements the popular word game Wordle. After each guess, the game provides feedback on the correctness of each letter.");
        System.out.println("Enter your first guess!");
        //Key
        String key = "HEART";

        if(key.length()!=5) {
            System.out.println("Invalid key (Key must be of exactly 5 letters!)");
            return;
        }
        
        int tries=6;
        while(tries>0) {
            String guessWord=sc.nextLine().toUpperCase();
            int correctLetters = guess(key, guessWord);

            if(correctLetters==5) {
                System.out.println("You guessed correctly! The word was indeed " + key);
                return;
            }

            tries--;
            System.out.println(tries + " tries remaining.");
            System.out.println("Try again!");
        }
        
        clearScreen();
        System.out.println("You were unable to guess the word. It was " + key);
        
    }
}