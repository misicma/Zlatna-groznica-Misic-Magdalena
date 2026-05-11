/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goldrush;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner; //kako bismo dozvolili unos igraca

/**
 *
 * @author magdalena
 */
public class FortyNiner {
    private int endurance;
    private int money;
    private ArrayList<Tool> tools;
    private Random rnd;
    
    public FortyNiner() {
        this.endurance = 100;
        this.money = 100;
        this.tools = new ArrayList<>();
        this.rnd = new Random();
        
        tools.add(new Pan());
        tools.add(new Sluice());
    }
    
    //Getteri
    public int getEndurance() {
        return endurance;
    }
    
    public int getMoney() {
        return money;
    }
    
    public ArrayList<Tool> getTools() {
        return tools;
    }
    
    //Setteri
    public void setEndurance(int endurance) {
        this.endurance = Math.max(0, Math.min(100,endurance));
    }
    
    public void setMoney(int money) {
        this.money = money;
    }
    
    public void setTools(ArrayList<Tool> tools) {
        this.tools = tools;
    }
        
    public int useTools() {
        int totalSalary = 0;
        
        //Go through all tools
        for(int i=0; i<tools.size(); i++) {
            Tool t = tools.get(i);
            
            //Ako je endurance(snaga), ne moze se raditi
            if(endurance <= 0) {
                System.out.println("You are too exhausted! You cannot use tools for this week!");
                
                return 0;
            }
            
            int salary = t.useTool();
            totalSalary += salary;
            money += salary;
            
            //Ako je kolijevka pokvarena ukloni je
            if (t instanceof Cradle && t.getDurability() <= 0) {
                tools.remove(i);
                i--;
                System.out.println("Cradle is BROKEN!");
            }
        }
        
        System.out.println("Total week sallary is $ "+ totalSalary);
        System.out.println("Current state " + money);
        
        return totalSalary;
        
    }
    
    public void buyFood() {
        //Generisanje troska hrane 30-50 dolara sedmicno
        int foodCost = 30 + new Random().nextInt(21); //30-50
        
        money -= foodCost;
        
        System.out.println("Food costs $ " + foodCost);
        System.out.println("The remaining money is $ " + money);
    }
    
    public void loseEndurance() {
        //Generisanje smanjenja 10-25%
        int decrease = 10 + rnd.nextInt(16); //vraca 0-15
        
        int oldEndurance = endurance;
        endurance -= decrease;
        
        //Ne dozvoli da padne ispod 0
        if(endurance < 0) {
            endurance = 0;
        }
        
        System.out.println("Endurance (power): "+oldEndurance+"% "+endurance+" % (decreased for "+decrease+" %");
        
        if (endurance <= 0)
        {
            System.out.println("WARNING! You are exhausted! Next week you cannot work!");
        }
    } 
    
    public void goToTown() {
        //Trosak 50-200 dolara
        int cost = 50 + rnd.nextInt(151); //50-200
        
        //Povecanje endurance 5-50%
        int increase = 5 + rnd.nextInt(46); //5-50
        
        int oldEndurance = endurance;
        endurance += increase;
        
        //Endurance (snaga) ne moze preskociti 100
        if (endurance > 100)
        {
            endurance = 100;
        }
        
        //Oduzmi novac
        money -= cost;
        
        System.out.println("Going out in the town");
        System.out.println("Costs $ "+cost);
        System.out.println("Endurance (power): "+oldEndurance+ "%, " + endurance + "% (+"+increase + "%)");
        System.out.println("The remaining money is $ "+money);
    }
    
    public void fixSluice() {
        //Pronadji lijevak u listi alata
        for(Tool t: tools) {
            if (t instanceof Sluice) {
                Sluice sluice = (Sluice) t;
                sluice.repair();
                money -= 100;
                System.out.println("Fixing of the sluice costs 100$");
                System.out.println("The remaining money is $ "+money);
                return;
            }
        }
        
        System.out.println("You dont have the sluice for fixing!");
    }
    
    public void itIsSundayAgain() {
        System.out.println("\n SUNDAY - day of resting");
        System.out.println("\n Current endurance (power) "+endurance+" %");
        System.out.println("\n Current money: $ "+money);
        System.out.println("\n What you want to do?");
        System.out.println("\n 1.I dont want to do anything!");
        System.out.println("\n 2.Fix the sluice (-$100)");
        System.out.println("\n 3.Go to town (-$50-200, +5-50$ of endurance)");
        System.out.println("Choice (1-3) ");
        
        //Kasnije cemo unijeti jos jednu metodu
        //Sada se samo ispisuju opcije
        
    }
    
} 

