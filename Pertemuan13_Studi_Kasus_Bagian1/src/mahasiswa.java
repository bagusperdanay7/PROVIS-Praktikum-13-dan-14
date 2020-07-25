/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bagus Perdana
 */

public class mahasiswa {
    private String NIM;
    private String Nama;
    private String JenisKelamin;
    private int Tinggi;
    
    public void setNIM (String nm)
    {
        NIM = nm;
    }
    
    public void setNama (String na)
    {
        Nama = na;
    }
    
    public void setJenisKelamin(String jk)
    {
        JenisKelamin = jk;
    }
    
    public void setTinggi (int t)
    {
        Tinggi = t;
    }
    
    public String getNim()
    {
        return NIM;
    }
    
    public String getNama()
    {
        return Nama;
    }
    
    public String getJenisKelamin()
    {
        return JenisKelamin;
    }
    
    public int getTinggi()
    {
        return Tinggi;
    }
    
    public mahasiswa(String nm, String na, String jk, int t)
    {
        setNIM(nm);
        setNama(na);
        setJenisKelamin(jk);
        setTinggi(t);
    }
    
}
