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
public class AracYonetimSistemi {

    /**
     * @param args the command line arguments
     */
    public static int secim = 0, katman = 0;
    public static Scanner sc = new Scanner(System.in);
    public static String veriID;
    static String marka,renk,yakit;
    static int hiz,yolcuSayisi,uretimYili,tekerlek;
    static Otomobil yeniOtomobil;
    static Bisiklet yeniBisiklet;
    static Gemi yeniGemi;
    static Ucak yeniUcak;
    static UcanGemi yeniUcanGemi;
    
    
    public static void main(String[] args) {
        baslat();
    }
    public static void baslat(){
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
    public static void baslangicMenusu(){
        System.out.println("-----------------------");
        System.out.println("Yapmak İstediğiniz İşlemi Seçin");
        System.out.println("1. Veri Girişinde Bulun");
        System.out.println("2. Veri Listele");
        System.out.println("3. Veri Güncelle");
        System.out.println("Çıkış (-1)");
        katman = 0;
        secimOku(true);
    }
    
    public static void veriGirisi(){
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
    
    public static void veriListele(){
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
    
    public static void veriGuncelle(){
        System.out.println("Güncellemek istediğiniz verinin ID ' sini girin:");
        veriID = sc.next();
        guncellemeIslemleri();
    }
    
    public static void otomobilEkle(){
        eklemeIslemleri("Otomobil");
        yeniOtomobil = new Otomobil(marka,renk,hiz,yolcuSayisi,uretimYili,tekerlek,yakit,"0");
        basaDon();
    }
    
    public static void bisikletEkle(){
        eklemeIslemleri("Bisiklet");
        yeniBisiklet = new Bisiklet(marka,renk,hiz,uretimYili,yolcuSayisi,tekerlek,"0");
        basaDon();
    }
    
    public static void gemiEkle(){
        eklemeIslemleri("Gemi");
        yeniGemi = new Gemi(marka,renk,hiz,uretimYili,yolcuSayisi,"0");
        basaDon();
    }
    
    public static void ucakEkle(){
        eklemeIslemleri("Uçak");
        yeniUcak = new Ucak(marka,renk,hiz,uretimYili,yolcuSayisi,"0");
        basaDon();
    }
    
    public static void ucanGemiEkle(){
        eklemeIslemleri("Uçan Gemi");
        yeniUcanGemi = new UcanGemi(marka,renk,hiz,uretimYili,yolcuSayisi,"0");
        basaDon();
    }
 
    public static void eklemeIslemleri(String tur){
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
    
    public static void basaDon(){
        secim = 0; katman = 0; baslat();
    }
    
    public static void secimOku(boolean okuma){
       if(okuma) secim = sc.nextInt();
       baslat();
    }
    
    public static void karaTasitlariListele(){
       String[] karaTasitlari = { "Otomobil", "Bisiklet" };
       tasitListele(karaTasitlari,"Kara");
       basaDon();
    }
    
     public static void havaTasitlariListele(){
       String[] havaTasitlari = { "Ucak", "UcanGem" };
       tasitListele(havaTasitlari,"Hava");
       basaDon();
    }
     
      public static void denizTasitlariListele(){
       String[] denizTasitlari = { "Gemi", "UcanGem" };
       tasitListele(denizTasitlari,"Deniz");
       basaDon();
    }
    
    public static void tasitListele(String[] tasitTurleri, String tur){
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
    static ArrayList<String> dosyaVerileri = new ArrayList<String>();
    public static void guncellemeIslemleri(){
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
                            ucanGemiGuncelle();
                        }else if(veriID.contains("Gemi")){
                            yeniGemi = new Gemi(parcala[1],parcala[2],Integer.parseInt(parcala[3]),Integer.parseInt(parcala[4]),Integer.parseInt(parcala[5]),parcala[0]);
                            gemiGuncelle();
                        }else if(veriID.contains("Ucak")){
                            yeniUcak = new Ucak(parcala[1],parcala[2],Integer.parseInt(parcala[3]),Integer.parseInt(parcala[4]),Integer.parseInt(parcala[5]),parcala[0]);
                            ucakGuncelle();
                        }
        }else{
            System.out.println("Araç bulunamadı!");
            basaDon();
        }
         
    }
    
    public static void otomobilGuncelle(){
        
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
    
     public static void bisikletGuncelle(){
        
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
     
      public static void gemiGuncelle(){
        
        int satir = 0;
        while(satir >= 0){
            System.out.println(" ------ Gemi Bilgileri ------- ");
        System.out.println("ID: " + yeniGemi.getID());
        System.out.println("1- Marka: " + yeniGemi.getMarka() + "\n2- Renk: " + yeniGemi.getRenk());
        System.out.println("3- Hız: " + yeniGemi.getHiz() + "\n4- Yolcu Sayısı: " + yeniGemi.getYolcuSayisi());
        System.out.println("5- Üretim Yılı: " + yeniGemi.getUretimYili());
        System.out.println("Düzenleyeceğiniz satırı belirtin: ");
        System.out.println("Hız Arttırmak için - 10\nHız Azaltmak için - 11\nAracı Durdurmak için: 12\nKayıt Edip Geri Dönmek için (-1): ");
        satir = sc.nextInt();
        if(satir == -1) break;
        
        if(satir < 10){
            System.out.print("Yeni Değeri Girin: ");
        String yeniDeger = sc.next();
        if(satir == 1){
            yeniGemi.setMarka(yeniDeger);
        }else if(satir == 2){
            yeniGemi.setRenk(yeniDeger);
        }else if(satir == 3){
           yeniGemi.setHiz(Integer.parseInt(yeniDeger));
        }else if(satir == 4){
            yeniGemi.setYolcuSayisi(Integer.parseInt(yeniDeger));
        }else if(satir == 5){
            yeniGemi.setUretimyili(Integer.parseInt(yeniDeger));
        }
        }else{
            if(satir == 10){
                System.out.print("Arttırılacak Miktarı Girin: ");
                yeniGemi.hizArttir(sc.nextInt());
            }else if(satir == 11){
                System.out.print("Azaltılacak Miktarı Girin: ");
                yeniGemi.hizAzalt(sc.nextInt());
            }else if(satir == 12){
                yeniGemi.aracDurdur();
            }
        }
        }
        yenidenYaz();
        yeniGemi.dosyaEkle();
        basaDon();
    }
    
   
      public static void ucakGuncelle(){
        
        int satir = 0;
        while(satir >= 0){
            System.out.println(" ------ Uçak Bilgileri ------- ");
        System.out.println("ID: " + yeniUcak.getID());
        System.out.println("1- Marka: " + yeniUcak.getMarka() + "\n2- Renk: " + yeniUcak.getRenk());
        System.out.println("3- Hız: " + yeniUcak.getHiz() + "\n4- Yolcu Sayısı: " + yeniUcak.getYolcuSayisi());
        System.out.println("5- Üretim Yılı: " + yeniUcak.getUretimYili());
        System.out.println("Düzenleyeceğiniz satırı belirtin: ");
        System.out.println("Hız Arttırmak için - 10\nHız Azaltmak için - 11\nAracı Durdurmak için: 12\nKayıt Edip Geri Dönmek için (-1): ");
        satir = sc.nextInt();
        if(satir == -1) break;
        
        if(satir < 10){
            System.out.print("Yeni Değeri Girin: ");
        String yeniDeger = sc.next();
        if(satir == 1){
            yeniUcak.setMarka(yeniDeger);
        }else if(satir == 2){
            yeniUcak.setRenk(yeniDeger);
        }else if(satir == 3){
           yeniUcak.setHiz(Integer.parseInt(yeniDeger));
        }else if(satir == 4){
            yeniUcak.setYolcuSayisi(Integer.parseInt(yeniDeger));
        }else if(satir == 5){
            yeniUcak.setUretimyili(Integer.parseInt(yeniDeger));
        }
        }else{
            if(satir == 10){
                System.out.print("Arttırılacak Miktarı Girin: ");
                yeniUcak.hizArttir(sc.nextInt());
            }else if(satir == 11){
                System.out.print("Azaltılacak Miktarı Girin: ");
                yeniUcak.hizAzalt(sc.nextInt());
            }else if(satir == 12){
                yeniUcak.aracDurdur();
            }
        }
        }
        yenidenYaz();
        yeniUcak.dosyaEkle();
        basaDon();
    }
       
       public static void ucanGemiGuncelle(){
        
        int satir = 0;
        while(satir >= 0){
            System.out.println(" ------ Uçan Gemi Bilgileri ------- ");
        System.out.println("ID: " + yeniUcanGemi.getID());
        System.out.println("1- Marka: " + yeniUcanGemi.getMarka() + "\n2- Renk: " + yeniUcanGemi.getRenk());
        System.out.println("3- Hız: " + yeniUcanGemi.getHiz() + "\n4- Yolcu Sayısı: " + yeniUcanGemi.getYolcuSayisi());
        System.out.println("5- Üretim Yılı: " + yeniUcanGemi.getUretimYili());
        System.out.println("Düzenleyeceğiniz satırı belirtin: ");
        System.out.println("Hız Arttırmak için - 10\nHız Azaltmak için - 11\nAracı Durdurmak için: 12\nKayıt Edip Geri Dönmek için (-1): ");
        satir = sc.nextInt();
        if(satir == -1) break;
        
        if(satir < 10){
            System.out.print("Yeni Değeri Girin: ");
        String yeniDeger = sc.next();
        if(satir == 1){
            yeniUcanGemi.setMarka(yeniDeger);
        }else if(satir == 2){
            yeniUcanGemi.setRenk(yeniDeger);
        }else if(satir == 3){
           yeniUcanGemi.setHiz(Integer.parseInt(yeniDeger));
        }else if(satir == 4){
            yeniUcanGemi.setYolcuSayisi(Integer.parseInt(yeniDeger));
        }else if(satir == 5){
            yeniUcanGemi.setUretimyili(Integer.parseInt(yeniDeger));
        }
        }else{
            if(satir == 10){
                System.out.print("Arttırılacak Miktarı Girin: ");
                yeniUcanGemi.hizArttir(sc.nextInt());
            }else if(satir == 11){
                System.out.print("Azaltılacak Miktarı Girin: ");
                yeniUcanGemi.hizAzalt(sc.nextInt());
            }else if(satir == 12){
                yeniUcanGemi.aracDurdur();
            }
        }
        }
        yenidenYaz();
        yeniUcanGemi.dosyaEkle();
        basaDon();
    }  
    
    public static void yenidenYaz(){
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
    
}
