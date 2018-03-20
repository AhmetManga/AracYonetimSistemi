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
import java.io.*;
public class Otomobil extends Kara{
    private static int aracSayisi = 0;
    private String aracID,yakit;
    
    public Otomobil(){
        super();
        yakit = " - ";
        setID();
       dosyaEkle();
    }
    
    public Otomobil(String m, String r, int h, int y, int u, int t, String ykt, String id){
        super(m,r,h,y,u,t);
        yakit = ykt;
        if(id == "0"){ setID(); }else{ aracID = id; }
        
        }
    
    @Override
    public void dosyaEkle(){
        super.DosyayaEkle(aracID + " " + super.getMarka() + " " + super.getRenk() + " " + super.getHiz() + " " + super.getYolcuSayisi() + " " + super.getUretimYili() + " " + super.getTekerlek() + " " + getYakit());
    }
    
    public String getYakit(){
        return yakit;
    }
    
    public void setYakit(String y){
        yakit = y;
    }
    
    @Override
    public void setID(){
        aracSayisi++;
        aracID = "Otomobil_" + aracSayisi; 
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getID(){
        return aracID;
    }
    
   
    
}
