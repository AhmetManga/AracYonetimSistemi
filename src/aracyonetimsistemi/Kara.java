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
public abstract class Kara extends Arac{
    
    private int tekerlek;
    
      public Kara(){
        super();
        tekerlek = 0;        
    }
    
    public Kara(String m, String r, int h, int y, int u, int t){
        super(m,r,h,y,u);
        tekerlek = t;
    }
    
  
    public int getTekerlek(){
        return tekerlek;
    }
    

    public void setTekerlek(int t){
        tekerlek = t;
    }
    
    
}
