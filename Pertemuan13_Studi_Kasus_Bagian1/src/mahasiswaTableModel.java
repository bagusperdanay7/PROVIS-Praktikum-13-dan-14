
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bagus Perdana
 */
public class mahasiswaTableModel extends AbstractTableModel {
    
    private ArrayList<mahasiswa> data;
    private String[] namaField ={"NIM","Nama","Jenis Kelamin","Tinggi"};
    
    public void setData(ArrayList<mahasiswa> dt)
    {
        this.data=dt;
    }
    
    public int getColumnCount() {
        return namaField.length;
    }
    public int getRowCount() {
        return data.size();
    }
    public Object getValueAt(int baris, int kolom) {
    mahasiswa m = data.get(baris);
    switch(kolom)
    {
        case 0 : return m.getNim();
        case 1 : return m.getNama();
        case 2 : return m.getJenisKelamin();
        case 3 : return m.getTinggi();
        default : return null;
    }
        
    }
    public String getColumnName(int column) {
        return namaField[column];
    }
    
   
}
