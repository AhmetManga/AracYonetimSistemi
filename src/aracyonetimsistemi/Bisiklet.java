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
public class Bisiklet extends Kara {
    
    private String bisikletID;
    private static int bisikletSayisi;
    
    public Bisiklet(){
        super();
        setID();
       dosyaEkle();
    }
    public Bisiklet(String m, String r, int h, int y, int u, int t,String id){
        super(m,r,h,y,u,t);
        setID();
        if(id == "0"){ setID(); }else{ bisikletID = id; }
    }
    @Override
    public void dosyaEkle(){
         super.DosyayaEkle(bisikletID + " " + super.getMarka() + " " + super.getRenk() + " " + super.getHiz() + " " + super.getYolcuSayisi() + " " + super.getUretimYili() + " " + super.getTekerlek());
    }
    @Override
    public void setID(){
        bisikletSayisi++;
        bisikletID = "Bisiklet_" + bisikletSayisi;
    } 
    
    @Override
    public String getID(){
        return bisikletID;
    }
}
