package Sýralama;

public class QuickSort {

	 // dizideki iki elemanï¿½n yerini deï¿½iï¿½tiren fonksiyon
    static void swap(int[] dizi, int i, int j)
    {
        int temp = dizi[i];
        dizi[i] = dizi[j];
        dizi[j] = temp;
    }
 
    // Bu fonksiyon son elemanï¿½ pivot olarak alï¿½r, pivot elemanï¿½nï¿½ sï¿½ralanmï¿½ï¿½ dizide doï¿½ru konuma yerleï¿½tirir 
    //ve tï¿½m kï¿½ï¿½ï¿½k elemanlarï¿½ pivotun soluna ve tï¿½m bï¿½yï¿½k elemanlarï¿½ pivotun saï¿½ï¿½na yerleï¿½tirir.
    
    static int partition(int[] dizi, int ilkIndeks, int sonIndeks)
    {
        // pivotu seï¿½me
        int pivot = dizi[sonIndeks];
 
        // Daha kï¿½ï¿½ï¿½k ï¿½ï¿½enin dizini ve ï¿½u ana kadar bulunan pivotun doï¿½ru konumunu gï¿½sterir
        int i = (ilkIndeks - 1);
 
        for (int j = ilkIndeks; j <= sonIndeks - 1; j++) {
 
            // mevcut eleman pivottan kï¿½ï¿½ï¿½kse yer deï¿½iï¿½me yap
            if (dizi[j] < pivot) {
 
                // kï¿½ï¿½ï¿½k elemanï¿½n indeksini bir arttï¿½r ve yer deï¿½iï¿½
                i++;
                swap(dizi, i, j);
            }
        }
        swap(dizi, i + 1, sonIndeks);
        return (i + 1);
    }
 
    // Quick Sort'un ana fonksiyonu
    // dizi[] --> sï¿½ralanacak dizi,
    // ilkIndeks --> baï¿½lama indeksi,
    // sonIndeks --> bitiï¿½ indeksi
    static void quickSort(int[] dizi, int ilkIndeks, int sonIndeks)
    {
        if (ilkIndeks < sonIndeks) {
 
            // pi dizi[p] nin bï¿½lï¿½mleme (potrition) indeksidir.
        	
            int pi = partition(dizi, ilkIndeks, sonIndeks);
 
            // ï¿½ï¿½eleri bï¿½lï¿½mden (pi) ï¿½nce ve bï¿½lï¿½mden sonra ayrï¿½ ayrï¿½ sï¿½ralayï¿½n
            
            quickSort(dizi, ilkIndeks, pi - 1);
            quickSort(dizi, pi + 1, sonIndeks);
        }
    }
    // dizi yazdï¿½rma
    public static void printdizi(int[] dizi)
    {
        for (int i = 0; i < dizi.length; i++) {
            System.out.print(dizi[i] + " ");
        }
    }
 
    public static void main(String[] args)
    {
        int[] dizi = { 10, 7, 8, 9, 1, 5 };
        int N = dizi.length;
 
        // fonksiyon ï¿½aï¿½ï¿½rma
        quickSort(dizi, 0, N - 1);
        System.out.println("Sorted diziay:");
        printdizi(dizi);
    }

}
