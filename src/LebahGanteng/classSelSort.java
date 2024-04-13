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
        int n = isiData.length;
        for (int i = 0; i < n - 1; i++) {
            int terkecil = i;
            for (int j = i + 1; j < n; j++) {
                if (isiData[j].getnilai() < isiData[terkecil].getnilai()) {
                    terkecil = j;
                }
            }
            classGetSet tukar = isiData[i];
            isiData[i] = isiData[terkecil];
            isiData[terkecil] = tukar;
        }
    }
    
    public static void selSortDescByNilai(classGetSet[] isiData) {
        int n = isiData.length;
        for (int i = 0; i < n - 1; i++) {
            int terbesar = i;
            for (int j = i + 1; j < n; j++) {
                if (isiData[j].getnilai() > isiData[terbesar].getnilai()) {
                    terbesar = j;
                }
            }
            classGetSet tukar = isiData[i];
            isiData[i] = isiData[terbesar];
            isiData[terbesar] = tukar;
        }
}
}
