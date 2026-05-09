/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goldrush;

/**
 *
 * @author magdalena
 */
//Klasa Kolijevka
//Kod kolijevke je 20% sansi da se ona pri svakoj upotrebi pokvari
//Sto znaci da joj tada durability odmah otpada na 0%
public class Cradle extends Tool {
    
    //Konstruktor - Kolijevka pocinje sa 100%
    public Cradle() {
        super(100);
    }
    
    @Override
    public int useTool() {
        //Ako je pokvarena, nema zarade
        if (durability <= 0) {
            System.out.println("Cradle is broken! No sallary.");
            return 0;
        }
        
        //Salary $0-$30
        int sallary = rnd.nextInt(31);
        
        //20% sanse da se pokvari 
        //Imitiramo random situaciju kada ce se pokvariti kolijevka 
        if (rnd.nextInt(100) < 20) {
            durability = 0;
            System.out.println("With cradle your sallary till now is " + sallary + " ,but it's broken!");
        }
        else {
            System.out.println("With cradle your sallary is " + sallary + " .Cradle works for now!");
        }
        
        return sallary;
    }
    
    public boolean isBroken() {
        return durability <= 0;
    }
}
