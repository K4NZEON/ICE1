/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cardtrickice1;

import java.util.Random;
import java.util.Scanner;

/**
 * step1 : generate 7 random cards and store in array - how step 2: take any
 * card input from user suit,number step 3: user card is in the array 'card is
 * found'
 *
 * @author evansk, June 8th
 */
public class CardTrickICE1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Card[] magicHand = new Card[7]; //Array of object
        Scanner input = new Scanner(System.in);
        Random rdm = new Random();
        boolean hiddencard = true;
        Card luckyCard = new Card();
        luckyCard.setValue(8);
        luckyCard.setSuits("diamonds");
        
        for (int i = 0; i < magicHand.length; i++) {
            Card c1 = new Card();
            int randomcard = rdm.nextInt(12-1) + 1;
            c1.setValue(randomcard);
            int randomsuit = rdm.nextInt(4-1) + 1;

            switch (randomsuit) {
                case 1:
                    c1.setSuits("diamonds");
                    break;
                case 2:
                    c1.setSuits("clubs");
                    break;
                case 3:
                    c1.setSuits("spades");
                    break;
                case 4:
                    c1.setSuits("hearts");
                    break;
                default:
                    break;
            }
            
            magicHand[i] = c1;
        }
        //step 2:take input 
        System.out.println("Pick a Card, any card (1-12): ");
        int num = input.nextInt();

        System.out.println("Pick a Suit (1-4): \n1.Diamonds\n2.Clubs\n3.Spades\n4.Hearts");
        int suit = input.nextInt();

        //step 3: match with array 
        for (int count = 0; count < magicHand.length; count++) {
            int CardValue = magicHand[count].getValue();
            String CardSuit = magicHand[count].getSuits();
            String suitguess = "";
            
            switch (suit) {
                case 1:
                    suitguess = ("diamonds");
                    break;
                case 2:
                    suitguess = ("clubs");
                    break;
                case 3:
                    suitguess = ("spades");
                    break;
                case 4:
                    suitguess = ("hearts");
                    break;
                default:
                    break;
            }
            System.out.println(CardValue+" of "+CardSuit);
            
            if (num == CardValue && suitguess.equalsIgnoreCase(CardSuit)){
                hiddencard = false;
                System.out.println("Card was found in deck, Congratulations!");
            }
        }
        
        if (hiddencard){
            System.out.println("Card was not found in deck, Better luck next time...");
        }
    }

}
