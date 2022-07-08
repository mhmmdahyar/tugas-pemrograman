package com.ayar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class MainScreen extends JFrame{
    private JPanel PanelMain;
    private JButton filterButton;
    private JTextField txtFilter;
    private JList jListMahasiswa;
    private JTextField txtNim;
    private JTextField txtNama;
    private JTextField txtIpk;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton clearButton;

    private List<Mahasiswa> arrayListMahasiswa = new ArrayList<>();

    private DefaultListModel defaultListModel = new DefaultListModel();
    class Mahasiswa{
        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }

        public float getIpk() {
            return ipk;
        }

        public void setIpk(float ipk) {
            this.ipk = ipk;
        }

        public String nama;
        public String nim;
        public float ipk;
    }

    public MainScreen(){
        super("Data Mahasiswa");
        this.setContentPane(PanelMain);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText();
                String nim = txtNim.getText();
                float ipk = Float.parseFloat(txtIpk.getText());

                Mahasiswa mahasiswa = new Mahasiswa();

                mahasiswa.setNama(nama);
                mahasiswa.setNim(nim);
                mahasiswa.setIpk(ipk);

                arrayListMahasiswa.add(mahasiswa);
                clearForm();
               fromListMahasiswaToListModel();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        jListMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int index = jListMahasiswa.getSelectedIndex();

                if (index < 0 )
                    return;

                String nama = jListMahasiswa.getSelectedValue().toString();

                for (int i = 0;i<arrayListMahasiswa.size(); i++){
                    if (arrayListMahasiswa.get(i).getNama().equals(nama)){
                        Mahasiswa mahasiswa = arrayListMahasiswa.get(i);
                        txtNama.setText(mahasiswa.getNama());
                        txtNim.setText(mahasiswa.getNim());
                        txtIpk.setText(String.valueOf(mahasiswa.getIpk()));
                        break;
                    }
                }
                clearForm();

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = jListMahasiswa.getSelectedIndex();

                if (index < 0)
                    return;

                String nama = jListMahasiswa.getSelectedValue().toString();

                for (int i = 0; i < arrayListMahasiswa.size() ; i++) {
                    if (arrayListMahasiswa.get(i).getNama().equals(nama)) {
                        arrayListMahasiswa.remove(i);
                    }
                }
                clearForm();
                fromListMahasiswaToListModel();
            }
        });
        filterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String keyword = txtFilter.getText();

                List<String> filter = new ArrayList<>();

                for (int i = 0; i < arrayListMahasiswa.size(); i++) {
                    if (arrayListMahasiswa.get(i).getNama().contains(keyword)){
                        filter.add(arrayListMahasiswa.get(i).getNama());
                    }
                }
                refreshListModel(filter);
            }
        });
    }
    public void clearForm(){
        txtNama.setText("");
        txtNim.setText("");
        txtIpk.setText("");
    }

    public void fromListMahasiswaToListModel(){
        List <String> listNamaMahasiswa = new ArrayList<>();

        for (int i = 0 ; i <arrayListMahasiswa.size(); i++){
            listNamaMahasiswa.add(arrayListMahasiswa.get(i).getNama());
        };
        refreshListModel(listNamaMahasiswa);
    }


    public void refreshListModel(List<String>list){
        defaultListModel.clear();
        defaultListModel.addAll(list);
        jListMahasiswa.setModel(defaultListModel);
    }



    public static void main(String[]args){
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible(true);


    }
}
