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

        // Create a Timer with a delay of 3 seconds (3000 milliseconds)
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dispose the JDialog
                dialog.dispose();
            }
        });

        boolean keluar = false;
        int count = 0;

        // Start the Timer and display the JDialog
        timer.setRepeats(false);
        timer.start();
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
                variabel Input di parse ke Integer variabel count
                 */
                count = Integer.parseInt(input);
                if (count <= 0){
                    JOptionPane.showMessageDialog(null, "Data yang dimasukkan tidak boleh nol atau kurang!");
                } else
                    keluar = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Masukkan data berupa angka. Silakan coba lagi.");
            }
        }


















        // Menu GUI
//        JOptionPane.showMessageDialog(null, "Selamat Datang!");


    }
}
