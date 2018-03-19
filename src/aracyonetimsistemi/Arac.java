package aracyonetimsistemi;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmet
 */
abstract class Arac {
    private String marka,renk;
    private int hiz,yolcuSayisi,uretimYili;
    
    public Arac(){
        hiz = 0; yolcuSayisi = 0; uretimYili = 2018; marka = "Kocaeli"; renk = "Siyah";
    }
    
    public Arac(String m, String r, int h, int y, int u){
        marka = m; renk = r; hiz = h; yolcuSayisi = y; uretimYili = u;
    }
    
    public String getMarka(){
        return marka;
    }
    
    public void setMarka(String m){
        marka = m;
    }
    
    public String getRenk(){
        return renk;
    }
    
    public void setRenk(String r){
        renk = r;
    }
    
    public int getHiz(){
        return hiz;
    }
    
    public void setHiz(int h){
        if(h < 0){
            System.out.println("Araç hızı sıfırdan küçük olamaz.");
        }else{
            hiz = h;
        }
    }
    
    public int hizArttir(int h){
        hiz += h; return hiz;
    }
    public int hizAzalt(int h){
        if(hiz-h < 0){
            System.out.println("Araç hızı sıfırdan küçük olamaz");
        }else{
            hiz -= h; 
        }
        return hiz;
    }
    
    public void aracDurdur(){
        hiz = 0;
    }
    
    public int getYolcuSayisi(){
        return yolcuSayisi;
    }
    
    public void setYolcuSayisi(int y){
        if(yolcuSayisi < 0) yolcuSayisi = 0; else yolcuSayisi = y;
    }
    
    public int getUretimYili(){
        return uretimYili;
    }
    
    public void setUretimyili(int u){
        uretimYili = u;           
    }
     /*
         Kaynak : https://netdeveload.wordpress.com/2013/04/01/java-metin-belgesine-alt-alta-yazdirma/
         Kod başlangıç
         */
     protected void DosyayaEkle(String metin){
         File dosya;
         FileWriter yazici;
         BufferedWriter yaz = null;
            try{
                  dosya = new File("AracKayit.txt");
                  yazici = new FileWriter(dosya,true);
                  yaz = new BufferedWriter(yazici);
                  PrintWriter satirYaz = new PrintWriter(yaz);
                  satirYaz.println("\n" + metin);
                  satirYaz.close();
                  System.out.println("Ekleme İşlemi Başarılı");
            }
            catch (Exception hata){
                  hata.printStackTrace();
            }finally{
            try {
                yaz.close();
            } catch (IOException ex) {
                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
      }
     /* kod bitiş */
    
    
    public abstract void setID();
    
    public abstract String getID();
    
    public abstract void dosyaEkle();
    
}
