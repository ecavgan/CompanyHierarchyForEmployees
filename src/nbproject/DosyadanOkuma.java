package nbproject;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DosyadanOkuma implements IVeriOkuyucu
{
    private ArrayList<String[]> calisanOzAL = new ArrayList<>();

    @Override
    public ArrayList<String[]> cozumle()
    {

        try
        {    
            File dosya = new File("girdi.txt");
            Scanner okuyucu = new Scanner(dosya); // 'reader'

            while (okuyucu.hasNextLine()) // satır satır okuma işlemi
            {
                // satırların virgüllerden ayrılması
                String satir = okuyucu.nextLine();
                String[] satir_arr = satir.split(",");
                
                // D, Mustafa Türksever, 5000, Root
                // calisanTipi, calisanAdiSoyadi, maas, calisaninUstu
                String[] calisanOzArr = { satir_arr[0], satir_arr[1], satir_arr[2], satir_arr[3] };
                
                calisanOzAL.add(calisanOzArr);
            }
            okuyucu.close();
            
            return calisanOzAL;
        }
        catch(Exception e)
        {
            System.out.println("Dosya okunurken bir hata oluştu. Kontrol edip tekrar deneyiniz.");
            System.exit(0);
        }
        
        return null;
    }
}
