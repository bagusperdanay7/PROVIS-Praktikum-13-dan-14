
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bagus Perdana
 */
public class FUpdateMahasiswa extends JDialog {
    public JLabel lnim,lnama,ljk,ltinggi;
    public JTextField tnim,tnama,tjk,ttinggi;
    public JButton tblsimpan,tblbatal;
    private Database db;
    public FUpdateMahasiswa(JFrame parent){
        super(parent,"Update Mahasiswa",true);// true = dialog modal
        setSize(350,250);
        setLayout(null);
        lnim=new JLabel("NIM : ",JLabel.RIGHT);
        lnim.setBounds(10,10,90,27);
        lnama=new JLabel("Nama : ",JLabel.RIGHT);
        lnama.setBounds(10,40,90,27);
        ljk=new JLabel("Jenis Kelamin : ",JLabel.RIGHT);
        ljk.setBounds(10,70,90,27);
        ltinggi=new JLabel("Tinggi : ",JLabel.RIGHT);
        ltinggi.setBounds(10,100,90,27);
        tnim=new JTextField();tnim.setBounds(110,10,90,27);
        tnama=new JTextField();tnama.setBounds(110,40,150,27);
        tjk=new JTextField();tjk.setBounds(110,70,30,27);
        ttinggi=new JTextField();ttinggi.setBounds(110,100,60,27);
        tblsimpan=new JButton("Simpan");tblsimpan.setBounds(110,130,80,27);
        tblbatal=new JButton("Batal");tblbatal.setBounds(200,130,80,27);
            add(lnim);
            add(lnama);
            add(ljk);
            add(ltinggi);
            add(tnim);
            add(tnama);
            add(tjk);
            add(ttinggi);
            add(tblsimpan);
            add(tblbatal);
            tblbatal.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            }
            });
          tblsimpan.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
             db=new Database();
             db.update_mahasiswa(new
             mahasiswa(tnim.getText(),tnama.getText(),tjk.getText(),Integer.parseInt(ttinggi.getText())));
                setVisible(false);
            }
        });
    }

  
    
    public void setForm(mahasiswa m)
    {
       tnim.setText(m.getNim());
       tnama.setText(m.getNama());
       tjk.setText(m.getJenisKelamin());
       ttinggi.setText(String.valueOf(m.getTinggi()));
    } 
           
    private void tblSimpanActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO add your handling code here;
        db = new Database();
        db.update_mahasiswa(new mahasiswa(tnim.getText(),tnama.getText(),tjk.getText(),Integer.valueOf(ttinggi.getText())));
        setVisible(false);
    
    }
    
    private void tblBatalActionPerformed(java.awt.event.ActionEvent evt) {
        //TODO add your handling code here;
        setVisible(false);
    
    }
    
}    