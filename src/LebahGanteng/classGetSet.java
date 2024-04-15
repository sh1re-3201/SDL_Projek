package LebahGanteng;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Tugas SDL

import static LebahGanteng.MainBro.sortingPertipe;

public class classGetSet {
    private long nim;
    private String nama;
    private double nilai; // Total nilai Alpro

    public classGetSet() {
        
    }

    @Override
public String toString() {
    return "Nama: " + nama + ", NIM: " + nim + ", Nilai: " + nilai;
}


    public void setnim(long nim){
        this.nim = nim;
    }

    public void setnama(String nama){
        this.nama = nama;
    }

    public void setnilai(double nilai){
        this.nilai = nilai;
    }

    public long getnim() {
        return nim;
    }

    public String getnama() {
        return nama;
    }

    public double getnilai() {
        return nilai;
    }

    public static void displayByAngkatan(classGetSet[] isiData, int angkatan) {
        // Create a new JFrame
        JFrame frame = new JFrame("Data by Angkatan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Define column names for the JTable
        String[] columnNames = {"NIM", "Nama", "Nilai"};

        // Create a 2D array to hold the data for the JTable
        Object[][] data = new Object[isiData.length][3];
        int index = 0;

        for (classGetSet dataItem : isiData) {
            int angkatanNIM = Integer.parseInt(String.valueOf(dataItem.getnim()).substring(0, 2));
            if (angkatanNIM == angkatan) {
                data[index][0] = dataItem.getnim();
                data[index][1] = dataItem.getnama();
                data[index][2] = dataItem.getnilai();
                index++;
            }
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
                sortingPertipe(isiData);
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

        // Make the JFrame visible
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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
