package nbproject;

public class CalisanIteratoru implements Iterator
{
    private ICalisan[] calisanDizisi; // koleksiyonun diziyle gerçekleştirimi
    private int i = 0;
    
    public CalisanIteratoru(ICalisan[] calisanList)
    {
        this.calisanDizisi = calisanList;
    }
    
    @Override
    public ICalisan next()
    {
        return calisanDizisi[i++];
    }
    
    @Override
    public boolean hasNext()
    {
        return !(i >= calisanDizisi.length || calisanDizisi[i] == null);
    }

    @Override
    public void reset()
    {
        i = 0;
    }
}
