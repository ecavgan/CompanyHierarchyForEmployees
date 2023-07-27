/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbproject;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class MaliyetHesaplaTest 
{
    Direktor d1 = new Direktor("D", "Mustafa Turksever", 5000, "Root");
    Direktor d2 = new Direktor("D", "Halil Sengonca", 4000, "Mustafa");
    Direktor d3 = new Direktor("D", "Ugur Guclu", 3500, "Halil");
    Memur m1 = new Memur("M", "Emre Kosar", 700, "Ugur");
    Memur m2 = new Memur("M", "Ahmet Egeli", 700, "Ugur");
    
    @Test
    void Test1_CalisansizDurum()
    {
        assertEquals(5000, d1.maliyetHesapla()); // 5000
    }
    
    @Test
    void Test2_DirektorEklenmesi()
    {
        d1.calisanEkle(d2);
        assertEquals(9000, d1.maliyetHesapla()); // 5000 + 4000
    }
    
    @Test
    void Test3_MemurEklenmesi()
    {
        d3.calisanEkle(m1);
        assertEquals(4200, d3.maliyetHesapla()); // 3500 + 700
    }
    
    @Test
    void Test4_ToplamMaliyetinHesaplanması()
    {
        d1.calisanEkle(d3);
        d3.calisanEkle(m2);
        assertEquals(13900, d1.maliyetHesapla()); // 5000 + 4000 + 3500 + 700 + 700
    }
        
}
