package LebahGanteng;

public class classSelSort {
    public static void selSortDesc(classGetSet[] isiData) {
        int n = isiData.length;
        for (int i = 0; i < n - 1; i++) {
            int terkecil = i;
            for (int j = i + 1; j < n; j++) {
                if (isiData[j].getnim() > isiData[terkecil].getnim()) {
                    terkecil = j;
                }
            }
            // Tukar elemen
            classGetSet tukar = isiData[i];
            isiData[i] = isiData[terkecil];
            isiData[terkecil] = tukar;
        }
    }

    public static void selSortAsc(classGetSet[] isiData) {
        int n = isiData.length;
        for (int i = 0; i < n - 1; i++) {
            int terkecil = i;
            for (int j = i + 1; j < n; j++) {
                if (isiData[j].getnim() < isiData[terkecil].getnim()) {
                    terkecil = j;
                }
            }
            // Tukar elemen
            classGetSet tukar = isiData[i];
            isiData[i] = isiData[terkecil];
            isiData[terkecil] = tukar;
        }
    }

    public static void selSortAscByNilai(classGetSet[] isiData) {
        int terkecil;
        classGetSet tukar;

        for (int iawal = 0; iawal < isiData.length; iawal++) {
            terkecil = iawal;
            for (int iLanjut = iawal + 1; iLanjut < isiData.length; iLanjut++) {
                if (isiData[iLanjut].getnilai() < isiData[terkecil].getnilai()) {
                    terkecil = iLanjut;
                }
            }
            tukar = isiData[iawal];
            isiData[iawal] = isiData[terkecil];
            isiData[terkecil] = tukar;
        }
    }

    public static void selSortDescByNilai(classGetSet[] isiData) {
        int terkecil;
        classGetSet tukar;

        for (int iawal = 0; iawal < isiData.length; iawal++) {
            terkecil = iawal;
            for (int iLanjut = iawal + 1; iLanjut < isiData.length; iLanjut++) {
                if (isiData[iLanjut].getnilai() > isiData[terkecil].getnilai()) {
                    terkecil = iLanjut;
                }
            }
            tukar = isiData[iawal];
            isiData[iawal] = isiData[terkecil];
            isiData[terkecil] = tukar;
        }
    }

    public static void sortByAllAngkatan(classGetSet[] isiData) {
        for (int i = 0; i < isiData.length - 1; i++) {
            int allIndeks = i;
            for (int j = i + 1; j < isiData.length; j++) {
                if (isiData[j].getnim() < isiData[allIndeks].getnim()) {
                    allIndeks = j;
                }
            }
            classGetSet tukar = isiData[allIndeks];
            isiData[allIndeks] = isiData[i];
            isiData[i] = tukar;
        }
    }
    
    

}
