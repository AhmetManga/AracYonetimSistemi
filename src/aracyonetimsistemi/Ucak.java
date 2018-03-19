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
public class Ucak extends Hava {
    
    private String ucakID;
    private static int ucakSayisi = 0;

    public Ucak(){
        super();
        setID();
        dosyaEkle();
    }
    
    public Ucak(String m, String r, int h, int y, int u, String id){
        super(m,r,h,y,u);
        if(id == "0"){ setID(); dosyaEkle(); }else{ ucakID = id; }
    }
    
    @Override
    public void dosyaEkle(){
        super.DosyayaEkle(ucakID + " " + super.getMarka() + " " + super.getRenk() + " " + super.getHiz() + " " + super.getYolcuSayisi() + " " + super.getUretimYili());
    }
    
    @Override
    public void setID(){
        ucakSayisi++;
        ucakID = "Ucak_" + ucakSayisi;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getID(){
        return ucakID;
    }
}
