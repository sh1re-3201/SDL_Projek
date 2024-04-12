package LebahGanteng;

public class classGetSet {
    private int nim;
    private String nama;
    private int nilai; // Total nilai Alpro

    public classGetSet() {
        
    }

    

    public void setnim(int nim){
        this.nim = nim;
    }

    public void setnama(String nama){
        this.nama = nama;
    }

    public void setnilai(int nilai){
        this.nilai = nilai;
    }

    public int getnim() {
        return nim;
    }

    public String getnama() {
        return nama;
    }

    public int getnilai() {
        return nilai;
    }



    public boolean isEmpty() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmpty'");
    }
}