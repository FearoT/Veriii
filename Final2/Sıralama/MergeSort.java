package Sýralama;


public class MergeSort {
		 
    // dizi[] iï¿½indeki iki alt diziyi birleï¿½tirir.
    // Birinci alt dizi: dizi[sol..orta]
    // ikinci alt dizi: dizi[orta+1..sag]
    void birlestir(int dizi[], int sol, int orta, int sag)
    {
        // Birleï¿½tirilecek iki alt dizinin boyutlarï¿½nï¿½ bul
        int n1 = orta - sol + 1;
        int n2 = sag - orta;
 
        // Create temp arrays
        int SOL[] = new int[n1];
        int SAG[] = new int[n2];
 
        // Geï¿½ici dizilere alt dizileri kopyala
        for (int i = 0; i < n1; ++i)
            SOL[i] = dizi[sol + i];
        for (int j = 0; j < n2; ++j)
            SAG[j] = dizi[orta + 1 + j];
 
        // geï¿½ici dizileri sï¿½rala 
 
        // Birinci ve ikinci alt dizilerin baï¿½langï¿½ï¿½ indeksleri
        int i = 0, j = 0;
 
        // Birleï¿½tirilmiï¿½ alt dizi dizisinin baï¿½langï¿½ï¿½ indeksi
        int k = sol;
        while (i < n1 && j < n2) {
            if (SOL[i] <= SAG[j]) {
                dizi[k] = SOL[i];
                i++;
            }
            else {
                dizi[k] = SAG[j];
                j++;
            }
            k++;
        }
 
        // Varsa SOL[]'un kalan elemanlarï¿½nï¿½ kopyala
        while (i < n1) {
            dizi[k] = SOL[i];
            i++;
            k++;
        }
 
        // Varsa SAG[]'ï¿½nn kalan elemanlarï¿½nï¿½ kopyala
        while (j < n2) {
            dizi[k] = SAG[j];
            j++;
            k++;
        }
    }
 
    // birlestir() metodunu kullanarak dizi[sol..sag] dizisini sï¿½ralayan fonksiyon 
    
    void sirala(int dizi[], int sol, int sag)
    {
        if (sol < sag) {
 
            // orta noktayï¿½ bul
            int orta = sol + (sag - sol) / 2;
 
            // Birinci ve ikinci alt dizi parï¿½alarï¿½nï¿½ sï¿½ralayï¿½n
            sirala(dizi, sol, orta);
            sirala(dizi, orta + 1, sag);
 
            // sï¿½ralanmï¿½ï¿½ alt dizileri birleï¿½tir
            birlestir(dizi, sol, orta, sag);
        }
    }
 
    // A utility function to print array of size n
    static void diziYazdir(int dizi[])
    {
        int n = dizi.length;
        for (int i = 0; i < n; ++i)
            System.out.print(dizi[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[])
    {
        int dizi[] = { 12, 11, 13, 5, 6, 7 };
 
        System.out.println("Given array is");
        diziYazdir(dizi);
 
        MergeSort ob = new MergeSort();
        ob.sirala(dizi, 0, dizi.length - 1);
 
        System.out.println("\n sï¿½ralanmï¿½ï¿½ dizi");
        diziYazdir(dizi);
    }
}

