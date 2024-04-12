package LebahGanteng;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainBro{
    public static void main(String[] args) {
        //Objek dan Manggil Kelas
        JOptionPane optionPane = new JOptionPane("Selamat Datang!", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = optionPane.createDialog(null);

        // Membuat timer 3 seconds (3000 milliseconds)
        Timer lama = new Timer(3000, new ActionListener() {

            // Masih belajar yang ini
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dispose the JDialog
                dialog.dispose();
            }
        });

        boolean keluar = false;
        int jumlahMhs = 0;

        // Start the Timer and display the JDialog
        lama.setRepeats(false);
        lama.start();
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setVisible(true);

        while (!keluar) {
            String input = JOptionPane.showInputDialog(null, "Masukkan jumlah mahasiswa yang ingin anda masukkan nilainya.");

            if (input == null) {// If statement ini berfungsi untuk keluar dari program jika user mengklik tombol X(silang) pada jendela
                return;
            }
            try {
                /*
                Karena penerimaan input dari JOptionPane secara default berupa String
                maka agar inputan dari user dapat dipakai menjadi jumlah panjang array,
                variabel Input di parse ke Integer variabel jumlahMhs
                 */
                jumlahMhs = Integer.parseInt(input);
                if (jumlahMhs <= 0){
                    JOptionPane.showMessageDialog(null, "Data yang dimasukkan tidak boleh nol atau kurang!");
                } else
                    keluar = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Masukkan data berupa angka. Silakan coba lagi.");
            }
        }

        // Array of Objek
        classGetSet[] isiData = new classGetSet[jumlahMhs];
        // Bagian kode untuk meminta identitas mahasiswa
        // laporan diganti sesuai dengan nama array yang dipilih
        for (int i = 0; i < isiData.length;) {
            String namaMhs = null;
            int nimFinal = 0;
            boolean validInput = false;

            do {
                namaMhs = JOptionPane.showInputDialog(null, "Masukkan nama mahasiswa " + (i + 1));
                if (namaMhs == null || namaMhs.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nama tidak boleh kosong. Silakan coba lagi.");
                    continue;
                }

                String nimMhs = JOptionPane.showInputDialog(null, "Masukkan nim mahasiswa " + namaMhs);
                if (nimMhs == null) {
                    return;
                }

                try {
                    nimFinal = Integer.parseInt(nimMhs);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "NIM harus berupa angka. Silakan coba lagi.");
                    continue;
                }



                validInput = true;
            } while (!validInput);

            isiData[i] = new classGetSet();
            isiData[i].setnama(namaMhs);
            isiData[i].setnim(nimFinal);
            i++;
        }

        boolean boolNilai = false;
        while (!boolNilai){
            boolNilai = true;
            for (int j = 0; j < isiData.length; j++) {
                String nilaiTotal = JOptionPane.showInputDialog(null, "Masukkan nilai Total dari : " + isiData[j].getnama());
                if (nilaiTotal == null) {
                    return;
                }

                try {
                    isiData[j].setnilai(Double.parseDouble(nilaiTotal));

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, """
                Masukkan data berupa angka.
                Untuk bilangan desimal masukkan dengan menggunakan titik sebagai pemisah bukan koma
                Silakan coba lagi.""");
                    boolNilai = false;
                    break;
                    }
                }
            }
        }
















        // Menu GUI



}
