package nbproject;

public class Memur implements ICalisan
{
    private String calisanTipi;
    private String adSoyad;
    private int maas;
    private String calisaninUstu;
    
    public Memur(String calisanTipi, String adSoyad, int maas, String calisaninUstu)
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

    @Override
    public String getAdSoyad() 
    {
        return adSoyad;
    }
    
    public String getAd()
    {
        return adSoyad.split(" ")[0];
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

    @Override
    public void calisanListele() 
    {
        System.out.println(calisanTipi + ", " + adSoyad + ", " + maas);
    }

    @Override
    public int maliyetHesapla() 
    {
        return getMaas();
    }
}
