package LebahGanteng;

public class classSelSort {
    public static void selSort(int[] larik) {
        int terkecil;
        int tukar;

        for (int iawal = 0; iawal < larik.length; iawal++) {
            terkecil = iawal;
            for (int iLanjut = iawal + 1; iLanjut < larik.length; iLanjut++) {
                if (larik[terkecil] > larik[iLanjut]) {
                    terkecil = iLanjut;
                }
            }
            tukar = larik[iawal];
            larik[iawal] = larik[terkecil];
            larik[terkecil] = tukar;
        }
    }
}
