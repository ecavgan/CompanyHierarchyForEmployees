package nbproject;

import java.util.ArrayList;

public class Deneme 
{
    public static void main(String[] args)
    {
        // çalışan nesnelerini tutan arraylist, foreach ile dönülerek çalışan ekleme işlemi gerçekleştirilecek
        ArrayList<ICalisan> calisanAL = new ArrayList<>();
        
        // 'Strategy pattern'ine göre tasarlandığı için txt dosyası dışından veri çekmek isteyen birinin
        // yapması gerek tek şey, eşittir'in sağındaki kısım için sınıf yazmasıdır
        IVeriOkuyucu veri = new DosyadanOkuma();
        // calisanTipi, calisaninAdiSoyadi, maas, calisaninUstu formatındaki dizileri taşıyan arraylist
        ArrayList<String[]> calisanOzAL = veri.cozumle();
        
        String calisanTipi;
        String calisanAdiSoyadi;
        int maas;
        String calisaninUstu;
        
        // nesnelerin oluşturulup arraylist'e eklenmesi
        for(String[] calisanOz: calisanOzAL)
        {
            calisanTipi = calisanOz[0];
            calisanAdiSoyadi = calisanOz[1];
            maas = Integer.parseInt(calisanOz[2]);
            calisaninUstu = calisanOz[3];
            
            ICalisan c;
            if (calisanTipi.equals("D"))
                c = new Direktor(calisanTipi, calisanAdiSoyadi, maas, calisaninUstu);
            else
                c = new Memur(calisanTipi, calisanAdiSoyadi, maas, calisaninUstu);
            
            calisanAL.add(c);
        }
        
        // arraylist'te dönerek direktörlere çalışan eklenmesi
        for (ICalisan c : calisanAL) 
        { 
            if (c instanceof Memur)
                continue;
            
            Direktor d = (Direktor) c; // direktör
            for (ICalisan c2 : calisanAL) 
                if (d.getAd().equals(c2.getCalisaninUstu()))
                    d.calisanEkle(c2);
        }
        
        // pdf'de bizden istenen bilgilerin yazdırılması
        System.out.println("--------------------------------");
        for (ICalisan c : calisanAL) 
        {
            if (c.getAdSoyad().equals("Mustafa Turksever") && c.getCalisanTipi().equals("D") ||
                c.getAdSoyad().equals("Oguz Demir") && c.getCalisanTipi().equals("D") || 
                c.getAdSoyad().equals("Ahmet Egeli") && c.getCalisanTipi().equals("M"))
            {
                c.calisanListele();
                System.out.println("Toplam maliyet: " + c.maliyetHesapla());
                System.out.println("--------------------------------");
            }
        }
    }
}