/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goldrush;

import java.util.ArrayList;
import java.util.Random;

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
}

