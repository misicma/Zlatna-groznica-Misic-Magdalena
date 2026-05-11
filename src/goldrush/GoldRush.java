/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goldrush;

import java.util.Scanner;

/**
 *
 * @author magdalena
 */
public class GoldRush {
    private FortyNiner fortyNiner;
    
    public GoldRush() {
        this.fortyNiner = new FortyNiner();
    }
    
    public void survive() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Gold Rush!");
        System.out.println("Game works for the 20 weeks, The goal is to get a lot of money.");
        
        for (int week = 1; week<=20;week++) {
            System.out.println("\n----------------------------");
            System.out.println("         WEEK "+week+" /20----");
            System.out.println("\n----------------------------");
            
            //1.Week - rest and choices
            fortyNiner.itIsSundayAgain();
            
            //2.Pitaj za kupovinu kolijevki
            System.out.println("Do you want to buy a cradle? (yes/no)");
            String answer = scanner.next(); //ocitavanje odgovora
            
            if(answer.equalsIgnoreCase("yes")) {
                System.out.println("How much of cradles do you want to buy? (One costs $30)");
                int howMany = scanner.nextInt();
                
                for (int i=0;i<howMany; i++) {
                    if(fortyNiner.getMoney() >= 30) {
                        fortyNiner.getTools().add(new Cradle());
                        fortyNiner.setMoney(fortyNiner.getMoney()-30);
                        System.out.println("A cradle is bought! The remaining money is $ "+fortyNiner.getMoney());
                    }
                    else {
                        System.out.println("You dont have enough money for buying a cradle!");
                        break;
                    }
                        
                }
            }
            
            //3.Week - Radna sedmica - zarada
            System.out.println("\n----Work week----");
            fortyNiner.useTools();
            
            //4.Costs 
            System.out.println("\n----Costs----");
            fortyNiner.buyFood();
            fortyNiner.loseEndurance();
            
            //5.Checking the state
            if (fortyNiner.getMoney() < 0) {
                System.out.println("You are in debt! Your balance: $ "+fortyNiner.getMoney());
            }
            
            //Pause between a weeks
            if (week < 20) {
                System.out.println("\nPress the enter for continuing...");
                scanner.nextLine(); //cisti bafer
                scanner.nextLine(); //ceka Enter
            }
        }
        
        //End of the game
        System.out.println("\n--------------------------");
        System.out.println("      END OF GAME! ");
        System.out.println("\n--------------------------");
        System.out.println("Your total sum of money on end of the game is: $ "+fortyNiner.getMoney());
        System.out.println("Endurance on the end " +fortyNiner.getEndurance() + " %");
        
        if (fortyNiner.getMoney() > 100) {
            System.out.println("CONGRATS! You successfully went through Gold Rush!");
        }
        else {
            System.out.println("Unfortunately, you didnt get rich. More luck next time!");
        }
    }
}
