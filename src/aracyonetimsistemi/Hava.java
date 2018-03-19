package aracyonetimsistemi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmet
 */
public abstract class Hava extends Arac{
    
     
    
    public Hava(){
        super();
               
    }
    
    public Hava(String m, String r, int h, int y, int u){
        super(m,r,h,y,u);
       
    }
    
    public boolean inisDurumu(){
        return getHiz() == 0;
    }
    
    @Override
    public void aracDurdur(){
        if(inisDurumu()) setHiz(0); else System.out.println("---------------\nAraç iniş yapmadığı için durdurulamadı.\n");
    }
    
}
