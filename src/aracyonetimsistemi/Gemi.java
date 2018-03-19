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
public class Gemi extends Deniz {
    
    private String gemiID;
    private static int gemiSayisi = 0;
    
    public Gemi(){
        super();
        setID();
        dosyaEkle();
    }
    
    public Gemi(String m, String r, int h, int y, int u, String id){
        super(m,r,h,y,u);      
        if(id == "0"){ setID(); dosyaEkle(); }else{ gemiID = id; }
    }
    
    @Override
    public void dosyaEkle(){
        super.DosyayaEkle(gemiID + " " + super.getMarka() + " " + super.getRenk() + " " + super.getHiz() + " " + super.getYolcuSayisi() + " " + super.getUretimYili());
    }
    
    @Override
    public void setID(){
        gemiSayisi++;
        gemiID = "Gemi_" + gemiSayisi;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getID(){
        return gemiID;
    }
    
}
