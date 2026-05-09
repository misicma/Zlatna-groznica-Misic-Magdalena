/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goldrush;

/**
 *
 * @author magdalena
 */
//Lijevak
public class Sluice extends Tool {
    
    //Konstruktor - Lijevak pocinje sa 100%
    public Sluice() {
        super(100); //pocinjemo sa durability = 100
    }
    
    //Drugi konstruktor - za ucitavanje iz fajla
    public Sluice(int startingDurability) {
        super(startingDurability);
    }
    
    @Override
    public int useTool() {
        if (durability <= 0) {
            System.out.println("Sluice is broken! No more sallary. You need to fix it!");
            
            return 0;
        }
        
        //Sallary $0-$500
        int sallary = rnd.nextInt(501);
        
        //Durability decreased for 20% - 50%
        int oldDurability = durability;
        int decrease = 20 + rnd.nextInt(31); //20-50%
        durability = durability - decrease;
        
        //Do not allow for durability to decrease under 0
        if(durability < 0) {
            durability = 0;
        }
        
        System.out.println("With sluice you sallary is " + sallary);
        System.out.println("Old durability was " + oldDurability+ " and newest one is "+ durability + " ,decreased for "+ decrease + "%");
    
        return sallary;
    }
    
    //Vracanje durability na 100% - ako je popravljen lijevak
    //Lijevak u nedelju
    public void repair() {
        int oldDurability = durability;
        durability = 100;
        System.out.println("Sluice is FIXED! Durability: "+oldDurability+ "%");
    }
}
