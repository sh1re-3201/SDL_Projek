package LebahGanteng;

public class classGetSet {
    private int nim;
    private String nama;
    private double nilai; // Total nilai Alpro

    public classGetSet() {
        
    }

    @Override
public String toString() {
    return "Nama: " + nama + ", NIM: " + nim + ", Nilai: " + nilai;
}


    public void setnim(int nim){
        this.nim = nim;
    }

    public void setnama(String nama){
        this.nama = nama;
    }

    public void setnilai(double nilai){
        this.nilai = nilai;
    }

    public int getnim() {
        return nim;
    }

    public String getnama() {
        return nama;
    }

    public double getnilai() {
        return nilai;
    }

    public static void sortByAngkatan(classGetSet[] isiData, int angkatan) {
        for (int i = 0; i < isiData.length - 1; i++) {
            int duaIndeksA = i;
            for (int j = i + 1; j < isiData.length; j++) {
                int angkatanNIM = Integer.parseInt(String.valueOf(isiData[j].getnim()).substring(0, 2)); // fungsi SubString untuk mengambil 2 digit pertama dari NIM
                if (angkatanNIM == angkatan) {
                    if (isiData[j].getnim() < isiData[duaIndeksA].getnim()) {
                        duaIndeksA = j;
                    }
                }
            }
            classGetSet tukar = isiData[duaIndeksA];
            isiData[duaIndeksA] = isiData[i];
            isiData[i] = tukar;
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

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
}