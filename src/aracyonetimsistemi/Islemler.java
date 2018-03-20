/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aracyonetimsistemi;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmet
 */
public class Islemler {

    /**
     * @param args the command line arguments
     */
    public int secim = 0, katman = 0;
    public Scanner sc = new Scanner(System.in);
    public String veriID;
    String marka,renk,yakit;
    int hiz,yolcuSayisi,uretimYili,tekerlek;
    Otomobil yeniOtomobil;
    Bisiklet yeniBisiklet;
    Gemi yeniGemi;
    Ucak yeniUcak;
    UcanGemi yeniUcanGemi;
    
    public Islemler(){
        baslat();
    }
    
    public void baslat(){
        if(secim == 0){
            if(katman == 0){
            baslangicMenusu();
            }else if(katman == 1){
                baslangicMenusu();
            }
        }else if(secim == 1){
            veriGirisi();
        }else if(secim == 2){
            veriListele();
        }else if(secim == 3){
            veriGuncelle();
        }else if(secim == -1){
            System.out.println("Program kapatıldı.");
            System.exit(0);
        }else if(secim == 4){
            otomobilEkle();
        }else if(secim == 5){
            bisikletEkle();
        }else if(secim == 6){
            gemiEkle();
        }else if(secim == 7){
            ucakEkle();
        }else if(secim == 8){
            ucanGemiEkle();
        }else if(secim == 9){
            karaTasitlariListele();
        }else if(secim == 10){
            denizTasitlariListele();
        }else if(secim == 11){
            havaTasitlariListele();
        }
    }
    public void baslangicMenusu(){
        System.out.println("-----------------------");
        System.out.println("Yapmak İstediğiniz İşlemi Seçin");
        System.out.println("1. Veri Girişinde Bulun");
        System.out.println("2. Veri Listele");
        System.out.println("3. Veri Güncelle");
        System.out.println("Çıkış (-1)");
        katman = 0;
        secimOku(true);
    }
    
    public void veriGirisi(){
        System.out.println("Veri girişinde bulunacağınız aracı seçiniz");
        System.out.println("1. Otomobil");
        System.out.println("2. Bisiklet");
        System.out.println("3. Gemi");
        System.out.println("4. Uçak");
        System.out.println("5. Uçan Gemi");
        System.out.println("Bir önceki menüye geri dön - 0");
        System.out.println("Çıkış (-1)");
        katman = 1;
        secim = sc.nextInt();
        if(secim != 0 && secim != -1) secim += 3;
        secimOku(false);
    }
    
    public void veriListele(){
        System.out.println("Listelemek İstediğiniz Veri Tipini Seçiniz");
        System.out.println("1. Kara Taşıtları");
        System.out.println("2. Deniz Taşıtları");
        System.out.println("3. Hava Taşıtları");
        System.out.println("Bir önceki menüye geri dön - 0");
        System.out.println("Çıkış (-1)");
        katman = 1;
        secim = sc.nextInt();
        if(secim != 0 && secim != -1) secim += 8;
        secimOku(false);
    }
    
    public void veriGuncelle(){
        System.out.println("Güncellemek istediğiniz verinin ID ' sini girin:");
        veriID = sc.next();
        guncellemeIslemleri();
    }
    
    public void otomobilEkle(){
        eklemeIslemleri("Otomobil");
        yeniOtomobil = new Otomobil(marka,renk,hiz,yolcuSayisi,uretimYili,tekerlek,yakit,"0");
        yeniOtomobil = (Otomobil) aracHizDuzenle(yeniOtomobil);
        yeniOtomobil.dosyaEkle(); basaDon();
    }
    
    public void bisikletEkle(){
        eklemeIslemleri("Bisiklet");
        yeniBisiklet = new Bisiklet(marka,renk,hiz,uretimYili,yolcuSayisi,tekerlek,"0");
        yeniBisiklet = (Bisiklet) aracHizDuzenle(yeniBisiklet);
        yeniBisiklet.dosyaEkle(); basaDon();
    }
    
    public void gemiEkle(){
        eklemeIslemleri("Gemi");
        yeniGemi = new Gemi(marka,renk,hiz,uretimYili,yolcuSayisi,"0");
        yeniGemi = (Gemi) aracHizDuzenle(yeniGemi);
        yeniGemi.dosyaEkle(); basaDon();
    }
    
    public void ucakEkle(){
        eklemeIslemleri("Uçak");
        yeniUcak = new Ucak(marka,renk,hiz,uretimYili,yolcuSayisi,"0");
        yeniUcak = (Ucak) aracHizDuzenle(yeniUcak);
        yeniUcak.dosyaEkle(); basaDon();
    }
    
    public void ucanGemiEkle(){
        eklemeIslemleri("Uçan Gemi");
        yeniUcanGemi = new UcanGemi(marka,renk,hiz,uretimYili,yolcuSayisi,"0");
        yeniUcanGemi = (UcanGemi) aracHizDuzenle(yeniUcanGemi);
        yeniUcanGemi.dosyaEkle(); basaDon();
    }
 
    public void eklemeIslemleri(String tur){
        System.out.println("------------------");
        System.out.println(tur + " Ekleniyor");
        System.out.print("Markasını Girin: ");
        marka = sc.next();
        System.out.print("Rengini Girin: ");
        renk = sc.next();
        System.out.print("Hızını Girin: "); 
        hiz = sc.nextInt();
        System.out.print("Yolcu Sayisini Girin: ");
        yolcuSayisi = sc.nextInt();
        System.out.print("Üretim Yılını Girin: ");
        uretimYili = sc.nextInt();
        if(tur == "Otomobil" || tur == "Bisiklet"){
        System.out.print("Tekerlek Sayısını Girin: ");
        tekerlek = sc.nextInt();
        }
        if(tur == "Otomobil"){
        System.out.print("Yakıt Türünü Girin: ");
        yakit = sc.next();
        }
    }
    
    public void basaDon(){
        secim = 0; katman = 0; baslat();
    }
    
    public void secimOku(boolean okuma){
       if(okuma) secim = sc.nextInt();
       baslat();
    }
    
    public void karaTasitlariListele(){
       String[] karaTasitlari = { "Otomobil", "Bisiklet" };
       tasitListele(karaTasitlari,"Kara");
       basaDon();
    }
    
     public void havaTasitlariListele(){
       String[] havaTasitlari = { "Ucak", "UcanGemi" };
       tasitListele(havaTasitlari,"Hava");
       basaDon();
    }
     
      public void denizTasitlariListele(){
       String[] denizTasitlari = { "Gemi", "UcanGemi" };
       tasitListele(denizTasitlari,"Deniz");
       basaDon();
    }
    
    public void tasitListele(String[] tasitTurleri, String tur){
        if(tur == "Kara"){
            System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s\n","ID","Marka","Renk","Hız","Yolcu","Üretim","Tekerlek","Yakıt");
        }else{
             System.out.printf("%10s %10s %10s %10s %10s %10s\n","ID","Marka","Renk","Hız","Yolcu","Üretim");
        }
        boolean durum = false;
        File file;
        BufferedReader reader = null;
        try{
            file = new File("AracKayit.txt");
            reader = new BufferedReader(new FileReader(file));
            String satir = reader.readLine();
            while (satir!=null) {
                durum = false;
                for(int i = 0; i< tasitTurleri.length; i++){
                    if(satir.contains(tasitTurleri[i])){
                        durum = true; break;
                    }
                }
                if(durum){
                    String[] parcala = satir.split(" ");
                    int boyut = parcala.length;
                    if(boyut < 8){
                        parcala = Arrays.copyOf(parcala,8);
                        for(int i = boyut; i<8; i++){
                            parcala[i] = " ";
                        }
                    }
                    System.out.printf("%10s %10s %10s %10s %10s %10s %10s %10s\n",parcala[0],parcala[1],parcala[2],parcala[3],parcala[4],parcala[5],parcala[6],parcala[7]);
                }
                
                
                satir = reader.readLine();
            }
       }catch(IOException e){
           System.out.println(e.getMessage());
       }finally{
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
    ArrayList<String> dosyaVerileri = new ArrayList<String>();
    
    public void guncellemeIslemleri(){
        dosyaVerileri.clear();
        String[] parcala = null;
        boolean durum = false;
        File file = null;
        BufferedReader  reader = null;
         try{
             file = new File("AracKayit.txt");
            reader = new BufferedReader(new FileReader(file));
            String satir = reader.readLine();
            
            while (satir!=null) {
                dosyaVerileri.add(satir);
                satir = reader.readLine();
            }
         }catch(IOException e){
           System.out.println(e.getMessage());
       }finally{
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        int sayac = 0;
         try{
             file = new File("AracKayit.txt");
            reader = new BufferedReader(new FileReader(file));
            String satir = reader.readLine();
            
            while (satir!=null) {
                parcala = satir.split(" ");
                
                if(parcala[0].equals(veriID)){
                    durum = true;
                   break;
                }
                
                satir = reader.readLine();
                sayac++;
            }
         }catch(IOException e){
           System.out.println(e.getMessage());
       }finally{
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        if(durum){
                
                Path path;
                path = Paths.get("AracKayit.txt");
            try {
                Files.delete(path);
            } catch (IOException ex) {
                Logger.getLogger(AracYonetimSistemi.class.getName()).log(Level.SEVERE, null, ex);
            }
                dosyaVerileri.remove(sayac);
                 File file2=new File("AracKayit.txt");
		  file2.delete();
                       if(veriID.contains("Otomobil")){
                            yeniOtomobil = new Otomobil(parcala[1],parcala[2],Integer.parseInt(parcala[3]),Integer.parseInt(parcala[4]),Integer.parseInt(parcala[5]),Integer.parseInt(parcala[6]),parcala[7],parcala[0]);
                            otomobilGuncelle();
                        }else if(veriID.contains("Bisiklet")){
                            yeniBisiklet = new Bisiklet(parcala[1],parcala[2],Integer.parseInt(parcala[3]),Integer.parseInt(parcala[4]),Integer.parseInt(parcala[5]),Integer.parseInt(parcala[6]),parcala[0]);
                            bisikletGuncelle();
                        }else if(veriID.contains("UcanGemi")){
                            yeniUcanGemi = new UcanGemi(parcala[1],parcala[2],Integer.parseInt(parcala[3]),Integer.parseInt(parcala[4]),Integer.parseInt(parcala[5]),parcala[0]);
                            yeniUcanGemi = (UcanGemi) havaDenizGuncelle(yeniUcanGemi);
                            yeniUcanGemi.dosyaEkle(); basaDon();
                        }else if(veriID.contains("Gemi")){
                            yeniGemi = new Gemi(parcala[1],parcala[2],Integer.parseInt(parcala[3]),Integer.parseInt(parcala[4]),Integer.parseInt(parcala[5]),parcala[0]);
                            yeniGemi = (Gemi) havaDenizGuncelle(yeniGemi);
                            yeniGemi.dosyaEkle(); basaDon();
                        }else if(veriID.contains("Ucak")){
                            yeniUcak = new Ucak(parcala[1],parcala[2],Integer.parseInt(parcala[3]),Integer.parseInt(parcala[4]),Integer.parseInt(parcala[5]),parcala[0]);
                            yeniUcak = (Ucak) havaDenizGuncelle(yeniUcak);
                            yeniUcak.dosyaEkle(); basaDon();
                        }
        }else{
            System.out.println("Araç bulunamadı!");
            basaDon();
        }
         
    }
    
    public void otomobilGuncelle(){
        
        int satir = 0;
        while(satir >= 0){
            System.out.println(" ------ Otomobil Bilgileri ------- ");
        System.out.println("ID: " + yeniOtomobil.getID());
        System.out.println("1- Marka: " + yeniOtomobil.getMarka() + "\n2- Renk: " + yeniOtomobil.getRenk());
        System.out.println("3- Hız: " + yeniOtomobil.getHiz() + "\n4- Yolcu Sayısı: " + yeniOtomobil.getYolcuSayisi());
        System.out.println("5- Üretim Yılı: " + yeniOtomobil.getUretimYili() + "\n6- Tekerlek: " + yeniOtomobil.getTekerlek() + "\n7- Yakıt: " + yeniOtomobil.getYakit());
        System.out.println("Düzenleyeceğiniz satırı belirtin: ");
        System.out.println("Hız Arttırmak için - 10\nHız Azaltmak için - 11\nAracı Durdurmak için: 12\nKayıt Edip Geri Dönmek için (-1): ");
        satir = sc.nextInt();
        if(satir == -1) break;
        
        if(satir < 10){
            System.out.print("Yeni Değeri Girin: ");
        String yeniDeger = sc.next();
        if(satir == 1){
            yeniOtomobil.setMarka(yeniDeger);
        }else if(satir == 2){
            yeniOtomobil.setRenk(yeniDeger);
        }else if(satir == 3){
            yeniOtomobil.setHiz(Integer.parseInt(yeniDeger));
        }else if(satir == 4){
            yeniOtomobil.setYolcuSayisi(Integer.parseInt(yeniDeger));
        }else if(satir == 5){
            yeniOtomobil.setUretimyili(Integer.parseInt(yeniDeger));
        }else if(satir == 6){
            yeniOtomobil.setTekerlek(Integer.parseInt(yeniDeger));
        }else if(satir == 7){
            yeniOtomobil.setYakit(yeniDeger);
        }
        }else{
            if(satir == 10){
                System.out.print("Arttırılacak Miktarı Girin: ");
                yeniOtomobil.hizArttir(sc.nextInt());
            }else if(satir == 11){
                System.out.print("Azaltılacak Miktarı Girin: ");
                yeniOtomobil.hizAzalt(sc.nextInt());
            }else if(satir == 12){
                yeniOtomobil.aracDurdur();
            }
        }
        }
        yenidenYaz();
        yeniOtomobil.dosyaEkle();
        basaDon();
    }
    
     public void bisikletGuncelle(){
        
        int satir = 0;
        while(satir >= 0){
            System.out.println(" ------ Bisiklet Bilgileri ------- ");
        System.out.println("ID: " + yeniBisiklet.getID());
        System.out.println("1- Marka: " + yeniBisiklet.getMarka() + "\n2- Renk: " + yeniBisiklet.getRenk());
        System.out.println("3- Hız: " + yeniBisiklet.getHiz() + "\n4- Yolcu Sayısı: " + yeniBisiklet.getYolcuSayisi());
        System.out.println("5- Üretim Yılı: " + yeniBisiklet.getUretimYili() + "\n6- Tekerlek: " + yeniBisiklet.getTekerlek());
        System.out.println("Düzenleyeceğiniz satırı belirtin: ");
        System.out.println("Hız Arttırmak için - 10\nHız Azaltmak için - 11\nAracı Durdurmak için: 12\nKayıt Edip Geri Dönmek için (-1): ");
        satir = sc.nextInt();
        if(satir == -1) break;
        
        if(satir < 10){
            System.out.print("Yeni Değeri Girin: ");
        String yeniDeger = sc.next();
        if(satir == 1){
            yeniBisiklet.setMarka(yeniDeger);
        }else if(satir == 2){
            yeniBisiklet.setRenk(yeniDeger);
        }else if(satir == 3){
            yeniBisiklet.setHiz(Integer.parseInt(yeniDeger));
        }else if(satir == 4){
            yeniBisiklet.setYolcuSayisi(Integer.parseInt(yeniDeger));
        }else if(satir == 5){
            yeniBisiklet.setUretimyili(Integer.parseInt(yeniDeger));
        }else if(satir == 6){
            yeniBisiklet.setTekerlek(Integer.parseInt(yeniDeger));
        }
        }else{
            if(satir == 10){
                System.out.print("Arttırılacak Miktarı Girin: ");
                yeniBisiklet.hizArttir(sc.nextInt());
            }else if(satir == 11){
                System.out.print("Azaltılacak Miktarı Girin: ");
                yeniBisiklet.hizAzalt(sc.nextInt());
            }else if(satir == 12){
                yeniBisiklet.aracDurdur();
            }
        }
        }
        yenidenYaz();
        yeniBisiklet.dosyaEkle();
        basaDon();
    }
       
       public Arac havaDenizGuncelle(Arac a){
        
        int satir = 0;
        while(satir >= 0){
            System.out.println(" ------ Araç Bilgileri ------- ");
        System.out.println("ID: " + a.getID());
        System.out.println("1- Marka: " + a.getMarka() + "\n2- Renk: " + a.getRenk());
        System.out.println("3- Hız: " + a.getHiz() + "\n4- Yolcu Sayısı: " + a.getYolcuSayisi());
        System.out.println("5- Üretim Yılı: " + a.getUretimYili());
        System.out.println("Düzenleyeceğiniz satırı belirtin: ");
        System.out.println("Hız Arttırmak için - 10\nHız Azaltmak için - 11\nAracı Durdurmak için: 12\nKayıt Edip Geri Dönmek için (-1): ");
        satir = sc.nextInt();
        if(satir == -1) break;
        
        if(satir < 10){
            System.out.print("Yeni Değeri Girin: ");
        String yeniDeger = sc.next();
        if(satir == 1){
            a.setMarka(yeniDeger);
        }else if(satir == 2){
            a.setRenk(yeniDeger);
        }else if(satir == 3){
           a.setHiz(Integer.parseInt(yeniDeger));
        }else if(satir == 4){
            a.setYolcuSayisi(Integer.parseInt(yeniDeger));
        }else if(satir == 5){
            a.setUretimyili(Integer.parseInt(yeniDeger));
        }
        }else{
            if(satir == 10){
                System.out.print("Arttırılacak Miktarı Girin: ");
                a.hizArttir(sc.nextInt());
            }else if(satir == 11){
                System.out.print("Azaltılacak Miktarı Girin: ");
                a.hizAzalt(sc.nextInt());
            }else if(satir == 12){
                a.aracDurdur();
            }
        }
        }
        yenidenYaz();
        return a;
    }  
    
    public void yenidenYaz(){
        File dosya;
        FileWriter yazici;
        BufferedWriter yaz = null;
         try{
                  dosya = new File("AracKayit.txt");
                  yazici = new FileWriter(dosya,true);
                  yaz = new BufferedWriter(yazici);
                  PrintWriter satirYaz = new PrintWriter(yaz);
                  
                  for(int i = 0; i< dosyaVerileri.size(); i++){
                     if(!dosyaVerileri.get(i).isEmpty()){
                          satirYaz.println(dosyaVerileri.get(i));
                     }
                  }
                  satirYaz.print("\n");
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
      
    public Arac aracHizDuzenle(Arac a){
         int secim = 0;
        
        while(secim != -1){
            System.out.println("Hız: " + a.getHiz());
            System.out.println("Hız Arttırmak İçin - 10\nHız Azaltmak İçin - 11\nDurdurmak İçin 12\nKayıt etmek için (-1)");
            secim = sc.nextInt();
            if(secim == 10){
                a.hizArttir(sc.nextInt());
            }else if(secim == 11){
                a.hizAzalt(sc.nextInt());
            }else if(secim == 12){
                a.aracDurdur();
            }
        }
       return a; 
    }      
}

