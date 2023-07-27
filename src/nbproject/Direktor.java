package nbproject;

public class Direktor implements ICalisan, IKoleksiyon
{
    private String calisanTipi;
    private String adSoyad;
    private int maas;
    private String calisaninUstu;
    private ICalisan[] calisanDizisi = new ICalisan[100]; // 100, yeterli olacağı düşünülerek yazıldı
    private int calisanDizisiInd = 0; // calisanListesi'ne çalışan eklemek için kullanılan indeks
    
    Iterator cIterator = iteratorOlustur();
    static int tab = 0;

    public Direktor(String calisanTipi, String adSoyad, int maas, String calisaninUstu) 
    {
        this.calisanTipi = calisanTipi;
        this.adSoyad = adSoyad;
        this.maas = maas;
        this.calisaninUstu = calisaninUstu;
    }
    
    @Override
    public String getCalisanTipi()
    {
        return calisanTipi;
    }
    
    public String getAd()
    {
        return adSoyad.split(" ")[0];
    }

    @Override
    public String getAdSoyad() 
    {
        return adSoyad;
    }
    
    @Override
    public int getMaas() 
    {
        return maas;
    }
    
    @Override
    public String getCalisaninUstu()
    {
        return calisaninUstu;
    }

    public void calisanEkle(ICalisan cal)
    {
        calisanDizisi[calisanDizisiInd++] = cal;
    }
    
    @Override
    public void calisanListele() 
    {
        cIterator.reset();
        tab++;
        
        System.out.println(calisanTipi + ", " + adSoyad + ", " + maas);
                
        while (cIterator.hasNext())
        {
            for (int i = 0; i < tab; i++)
                System.out.print("     ");
            
            cIterator.next().calisanListele();
        }
        
        tab--;
    }

    @Override
    public int maliyetHesapla() 
    {
        cIterator.reset();

        int maliyet = 0;
        maliyet += maas;

        while (cIterator.hasNext())
            maliyet += cIterator.next().maliyetHesapla();
        
        return maliyet;
    }
    
    @Override
    public Iterator iteratorOlustur()
    {
        return new CalisanIteratoru(calisanDizisi);
    }
}
