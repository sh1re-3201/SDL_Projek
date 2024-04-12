package LebahGanteng;

public class classGetSet {
    private int nim;
    private String nama;
    private int nilai; // Total nilai Alpro

    public classGetSet(int nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }

    public int nim() {
        return nim;
    }

    public String nama() {
        return nama;
    }

    public int nilai() {
        return nilai;
    }
}