package LebahGanteng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;

public class MainBro {
    public static void main(String[] args) {
        // Objek dan Manggil Kelas
        JOptionPane optionPane = new JOptionPane("Selamat Datang!", JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
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
        for (int i = 0; i < isiData.length; ) {
            isiData[i] = new classGetSet();

            String namaFinal;
            String namaMhs;
            String nimMhs;
            String nilaiTotal = null;
            long nimFinal = 0;
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
                    nimFinal = Long.parseLong(nimMhs);
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
        JPanel headerBalik = new JPanel();
        JLabel confirmationLabel = new JLabel("APAKAH ANDA YAKIN DENGAN DATA YANG ANDA MASUKKAN?");
        confirmationLabel.setForeground(Color.RED); // Set the text color to red
        headerBalik.add(confirmationLabel);

        // Add the confirmation panel to the frame
        frame.add(headerBalik, BorderLayout.NORTH);

        // Set up the table
        String[] columnNames = {"Nama", "NIM", "Nilai"};
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
                sortingPertipe(data);
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

    //Segmen progrsm untuk menanyakan user mau menyortir perangakatan atau keseluruhan dan pernilai
    public static void sortingPertipe(classGetSet[] isiData) {

        JFrame frame = new JFrame("Sorting Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 350);
        frame.setLayout(new GridLayout(6, 1));

        JPanel headerBalik = new JPanel();
        JLabel confirmationLabel = new JLabel("PILIH TIPE PENYORTIRAN ANDA");
        confirmationLabel.setForeground(Color.BLACK); // Set the text color to red
        headerBalik.add(confirmationLabel);

        // Add the confirmation panel to the frame
        frame.add(headerBalik, BorderLayout.NORTH);

        JButton button1 = new JButton("Per-Angkatan 21");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sortOrder = askSortOrder();

                // Sort the data based on the user's choice
                if (sortOrder == JOptionPane.YES_OPTION) {
                    classSelSort.selSortAsc(isiData);
                } else {
                    classSelSort.selSortDesc(isiData);
                }

                // Display the sorted data
                classGetSet.displayByAngkatan(isiData, 21);

                frame.dispose();
            }
        });

        JButton button2 = new JButton("Per-Angkatan 22");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sortOrder = askSortOrder();

                // Sort the data based on the user's choice
                if (sortOrder == JOptionPane.YES_OPTION) {
                    classSelSort.selSortAsc(isiData);
                } else {
                    classSelSort.selSortDesc(isiData);
                }

                // Display the sorted data
                classGetSet.displayByAngkatan(isiData, 22);

                frame.dispose();
            }
        });

        JButton button3 = new JButton("Per-Angkatan 23");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sortOrder = askSortOrder();

                // Sort the data based on the user's choice
                if (sortOrder == JOptionPane.YES_OPTION) {
                    classSelSort.selSortAsc(isiData);
                } else {
                    classSelSort.selSortDesc(isiData);
                }

                // Display the sorted data
                classGetSet.displayByAngkatan(isiData, 23);

                frame.dispose();
            }
        });

        JButton button4 = new JButton("Seluruh Angkatan");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sortOrder = askSortOrder();

                // Sort the data based on the user's choice
                if (sortOrder == JOptionPane.YES_OPTION) {
                    classSelSort.selSortAsc(isiData);
                } else {
                    classSelSort.selSortDesc(isiData);
                }
                displaySortedData(isiData);
                frame.dispose();
            }
        });

        JButton button5 = new JButton("Nilai Total");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int sortOrder = askSortOrder();

                // Sort the data based on the user's choice
                if (sortOrder == JOptionPane.YES_OPTION) {
                    classSelSort.selSortAscByNilai(isiData);
                } else {
                    classSelSort.selSortDescByNilai(isiData);
                }
                displaySortedData(isiData);
                frame.dispose();
            }
        });

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(button5);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    //Segemn untuk menampilkan menu untuk menanyakan user mau tipe sortiran ascending atau descending
    public static int askSortOrder() {
        // Ask the user for the sort order
        int sortOrder = JOptionPane.showOptionDialog(null, "Choose sort order:", "Sort Order",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                new String[]{"Ascending", "Descending"}, "Ascending");
        return sortOrder;
    }

    public static void displaySortedData(classGetSet[] sortedData) {
        // Create a new JFrame
        JFrame frame = new JFrame("Sorted Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Define column names for the JTable
        String[] columnNames = {"NIM", "Nama", "Nilai"};

        // Create a 2D array to hold the data for the JTable
        Object[][] data = new Object[sortedData.length][3];
        for (int i = 0; i < sortedData.length; i++) {
            data[i][0] = sortedData[i].getnim();
            data[i][1] = sortedData[i].getnama();
            data[i][2] = sortedData[i].getnilai();
        }

        // Create a new JTable and add it to a JScrollPane
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the JScrollPane to the JFrame
        frame.add(scrollPane, BorderLayout.CENTER);

        // Set up the buttons
        JPanel buttonPanel = new JPanel();
        JLabel promptLabel = new JLabel("APAKAH ANDA INGIN KEMBALI KE MENU SEBELUMNYA?");
        buttonPanel.add(promptLabel);
        JButton yesButton = new JButton("Ya");
        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sortingPertipe(sortedData);
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
                System.exit(0);
            }
        });
        buttonPanel.add(noButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Display the frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
