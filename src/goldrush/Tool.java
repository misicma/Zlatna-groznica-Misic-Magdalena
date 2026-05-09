/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goldrush;

import java.util.Random; //kao u python-u import random
//klasa za generisanje slucajnih brojeva

/**
 *
 * @author magdalena
 */

//Univerzalno generisanje razlicitih vrsta alata - sito/kolijevka/lijevak
//Iz abstract klasa ne mozemo dobiti nista konkretno kao npr klasu za alat
//Zato je potrebno da napravimo jos dodatne klase za svaki alat pojedinacno
public abstract class Tool {
    
    //Atributi klase alata - Tool
    protected int durability;
    protected Random rnd;
    //protected govori da druge klase ovo mogu koristiti
    
    //Nesto slicno kao def __init__(self,startingDurability):
    public Tool(int startingDurability){
        this.durability = startingDurability;
        this.rnd = new Random();
    }
    
    //Getter
    public int getDurability(){
        return  durability;
    }
    
    public void setDurability(int durability){
        this.durability = durability;
    }
    
    public abstract int useTool();
    
    
}

//abstract znaci - 