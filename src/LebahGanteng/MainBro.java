package LebahGanteng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainBro {
    public static void main(String[] args) {
        // Objek dan Manggil Kelas
        JOptionPane optionPane = new JOptionPane("Selamat Datang!", JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[] {}, null);
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
            String input = JOptionPane.showInputDialog(null,
                    "Masukkan jumlah mahasiswa yang ingin anda masukkan nilainya.");

            if (input == null) {// If statement ini berfungsi untuk keluar dari program jika user mengklik
                                // tombol X(silang) pada jendela
                return;
            }
            try {
                /*
                 * Karena penerimaan input dari JOptionPane secara default berupa String
                 * maka agar inputan dari user dapat dipakai menjadi jumlah panjang array,
                 * variabel Input di parse ke Integer variabel jumlahMhs
                 */
                jumlahMhs = Integer.parseInt(input);
                if (jumlahMhs <= 0) {
                    JOptionPane.showMessageDialog(null, "Data yang dimasukkan tidak boleh nol atau kurang!");
                } else
                    keluar = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Masukkan data berupa angka. Silakan coba lagi.");
            }
        }

        // Array of Objek
        classGetSet[] isiData = new classGetSet[jumlahMhs];
        memintaInput(isiData);

    }

    // Method untuk meminta input
    private static void memintaInput(classGetSet[] isiData) {
        for (int i = 0; i < isiData.length;) {
            isiData[i] = new classGetSet();

            String namaFinal;
            String namaMhs;
            String nimMhs;
            String nilaiTotal = null;
            int nimFinal = 0;
            double nilaiFinal = 0;
            boolean validInput = false;

            do {
                namaMhs = JOptionPane.showInputDialog(null, "Masukkan nama mahasiswa " + (i + 1));
                if (namaMhs == null) {
                    return;
                }

                nimMhs = JOptionPane.showInputDialog(null, "Masukkan nim mahasiswa " + namaMhs);
                if (nimMhs == null) {
                    return;
                }

                try {
                    nimFinal = Integer.parseInt(nimMhs);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "NIM harus berupa angka. Silakan coba lagi.");
                    continue;
                }

                nilaiTotal = JOptionPane.showInputDialog(null, "Masukkan nilai Total dari : " + namaMhs);
                if (nilaiTotal == null) {
                    return;
                }

                try {
                    nilaiFinal = Double.parseDouble(nilaiTotal);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, """
                            Masukkan data berupa angka.
                            Untuk bilangan desimal masukkan dengan menggunakan titik sebagai pemisah bukan koma
                            Silakan coba lagi.""");
                    continue;
                }
                validInput = true;
            } while (!validInput);

            if (namaMhs.isEmpty() || nimMhs.isEmpty() || nilaiTotal.isEmpty()) {

            }
            isiData[i] = new classGetSet();
            isiData[i].setnama(namaMhs);
            isiData[i].setnim(nimFinal);
            isiData[i].setnilai(nilaiFinal);
            i++;
        }
        mengonfirmasi(isiData);
    }

    private static void mengonfirmasi(classGetSet[] data) {
        // Set up the frame
        JFrame frame = new JFrame("");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 350);

        // Set up the confirmation panel
        JPanel confirmationPanel = new JPanel();
        JLabel confirmationLabel = new JLabel("APAKAH ANDA YAKIN DENGAN DATA YANG ANDA MASUKKAN?");
        confirmationLabel.setForeground(Color.RED); // Set the text color to red
        confirmationPanel.add(confirmationLabel);

        // Add the confirmation panel to the frame
        frame.add(confirmationPanel, BorderLayout.NORTH);

        // Set up the table
        String[] columnNames = { "Nama", "NIM", "Nilai" };
        Object[][] tableData = new Object[data.length][3];
        for (int i = 0; i < data.length; i++) {
            tableData[i][0] = data[i].getnama();
            tableData[i][1] = data[i].getnim();
            tableData[i][2] = data[i].getnilai();
        }
        JTable table = new JTable(tableData, columnNames);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Set up the buttons
        JPanel buttonPanel = new JPanel();
        JButton yesButton = new JButton("Ya");
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        buttonPanel.add(yesButton);
        JButton noButton = new JButton("Tidak");
        noButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ask for the data again and overwrite the old data
                frame.dispose();
                for (classGetSet data : data) {
                    data.setnama(null);
                    data.setnim(0);
                    data.setnilai(0.0);
                }
                memintaInput(data);
                mengonfirmasi(data);
            }
        });
        buttonPanel.add(noButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Display the frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void sortingPertipe(classGetSet[] isiData) {
        boolean ulang = true;
        
        while (ulang) {
            int guiTipe = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Apakah anda ingin Mensorting berdasarkan : \n1.Per-Angkatan 21 \n2.Per-Angkatan 22 \n3.Per-Angkatan 23 \n4.Seluruh Angkatan"));

            if (guiTipe >= 1 && guiTipe <= 4) {
                if (guiTipe == 1) {
                    classGetSet.sortByAngkatan(isiData, 21);
                } else if (guiTipe == 2) {
                    classGetSet.sortByAngkatan(isiData, 22);
                } else if (guiTipe == 3) {
                    classGetSet.sortByAngkatan(isiData, 23);
                } else if (guiTipe == 4) {
                    classGetSet.sortByAllAngkatan(isiData);
                }

                // Menampilkan submenu untuk pilihan ascending atau descending
                boolean ascending = menuAscDesc();

                // Menampilkan hasil sorting
                if (ascending) {
                    classSelSort.selSortAsc(isiData); // Sorting ascending
                } else {
                    classSelSort.selSortDesc(isiData); // Sorting descending
                }


                //Buat Program untuk menampilkan hasilnya disini bang 


                
            } else {
                JOptionPane.showMessageDialog(null, "Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }

    private static boolean menuAscDesc() {
        int pilihan = JOptionPane.showOptionDialog(null, "Pilih jenis sorting:", "Sorting",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[] { "Ascending", "Descending" }, "Ascending");

        return pilihan == JOptionPane.YES_OPTION;
    }

}
