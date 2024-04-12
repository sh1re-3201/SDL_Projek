package LebahGanteng;

public class classGetSet {
    private int nim;
    private String nama;
    private double nilai; // Total nilai Alpro

    public classGetSet() {
        
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



    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
}