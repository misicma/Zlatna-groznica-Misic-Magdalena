/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package goldrush;

/**
 *
 * @author magdalena
 */

//Tool klasa se poziva jer je Pan dijete klasa od roditeljak klase Tool
public class Pan extends Tool {
    
    //Konstruktor - Sito pocinje sa 100% durabilitty
    public Pan() {
        super(100); //poziva konstruktor iz Tool klase
    }
    
    //Svaki alat mora imati svoju verziju
    @Override //koristimo metodu iz klase roditelja
    public int useTool() {
        //Sito zaraduje izmedju $0-$60 sedmicno
        int salary = rnd.nextInt(61); // 0-60
        //zarada neka bude random broj izmedju 0-60
        
        
        System.out.println("With pan our sallary is: " + salary);
        //kao print u python-u
        
        return salary;
    } 
}
