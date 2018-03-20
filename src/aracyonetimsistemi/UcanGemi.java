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
public class UcanGemi extends Hava{
    private String ucanGemiID;
    private static int ucanGemiSayisi = 0;  
    
    public UcanGemi(){
        super();
        setID();
        dosyaEkle();
    }
    
    public UcanGemi(String m, String r, int h, int y, int u, String id){
        super(m,r,h,y,u);
       if(id == "0"){ setID(); }else{ ucanGemiID = id; } 
    }
    
    @Override
    public void dosyaEkle(){
        super.DosyayaEkle(ucanGemiID + " " + super.getMarka() + " " + super.getRenk() + " " + super.getHiz() + " " + super.getYolcuSayisi() + " " + super.getUretimYili());
    }
    
    @Override
    public void setID() {
       ucanGemiSayisi++;
       ucanGemiID = "UcanGemi_" + ucanGemiSayisi;
    }

    @Override
    public String getID() {
        return ucanGemiID;
    }
    
}
