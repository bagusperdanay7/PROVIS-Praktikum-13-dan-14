/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bagus Perdana
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Database {
    public final String driver = "com.mysql.jdbc.Driver";
    public final String url = "jdbc:mysql://localhost/dbmahasiswa";
    public final String user = "root";
    public final String pass = "";

//tampilkan semua data
    
    public ArrayList <mahasiswa> tampil_semua_mahasiswa()
    {
        ArrayList<mahasiswa> list = new ArrayList<mahasiswa>();
        Connection conn = null;
        Statement stmt = null;
        try
        {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
            stmt = conn.createStatement();
            String sql;
            sql="SELECT * FROM mahasiswa";
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
            {
                list.add(new mahasiswa(rs.getString("NIM"),rs.getString("Nama")
                ,rs.getString("JenisKelamin"),rs.getInt("Tinggi")));
            }
            rs.close();
        }
        catch (Exception e)
        {
            System.out.println("Error : "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            }
            catch (Exception e) {}
            try
            {
                conn.close();
            }
            catch(Exception e) {}
        }
        return list;       
    }
    
    //tambah data mahasiswa
    
    public void tambah_mahasiswa(mahasiswa m)
    {
        Connection conn = null;
        Statement stmt = null;
        try
        {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="INSERT INTO MAHASISWA VALUES ('"+m.getNim()+"','"
                    +m.getNama()+"','"+m.getJenisKelamin()+"',"+m.getTinggi()
                    +")";
                    stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            } catch (Exception e) {}
            try
            {
                conn.close();
            } catch (Exception e) {}
            
        }
    }
    
    public void hapus_mahasiswa(String nim)
    {
        Connection conn = null;
        Statement stmt = null;
        try
        {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="DELETE FROM mahasiswa WHERE nim='"+nim+"'";
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            } catch (Exception e) {}
            try
            {
                conn.close();
            } catch (Exception e) {}
            
        }
    }
    
    public void update_mahasiswa(mahasiswa m)
    {
        Connection conn = null;
        Statement stmt = null;
        try
        {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="UPDATE mahasiswa SET nama='"+m.getNama()+"',"
                    + "JenisKelamin = '"+m.getJenisKelamin()+"',"
                    + "Tinggi = '"+m.getTinggi()+"' WHERE nim = '"
                    +m.getNim()+"'";
            stmt.executeUpdate(sql);
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            } catch (Exception e) {}
            try
            {
                conn.close();
            } catch (Exception e) {}
            
        }
    }
    
    public mahasiswa pilih_mahasiswa(String nim)
    {
        mahasiswa m = null;
        Connection conn = null;
        Statement stmt = null;
        try
        {
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,pass);
            stmt=conn.createStatement();
            String sql="SELECT * FROM mahasiswa WHERE nim='"+nim+"'";
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next())
            {
                m = new mahasiswa(rs.getString("NIM"),rs.getString("Nama"),
                        rs.getString("JenisKelamin"),rs.getInt("Tinggi"));
            }
            else
                m=null;
            rs.close();
        }
        catch(Exception e)
        {
            System.out.println("Error : "+e.getMessage());
        }
        finally
        {
            try
            {
                stmt.close();
            } catch (Exception e) {}
            try
            {
                conn.close();
            } catch (Exception e) {}
            
        }
        return m;
    }
    
    //membuat filter mahasiswa
    public ArrayList<mahasiswa> filter_mahasiswa(String katakunci)
    {
     ArrayList<mahasiswa> listmahasiswa = new ArrayList<mahasiswa>();
     Connection conn = null;
     Statement stmt = null;
     try
     {
         Class.forName(driver);
         conn=DriverManager.getConnection(url,user,pass);
         stmt=conn.createStatement();
         String sql ="SELECT * FROM mahasiswa WHERE Nama LIKE'%"+katakunci+"%'";
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next())
         {
             listmahasiswa.add(new mahasiswa(rs.getString("NIM"),
                rs.getString("Nama"),rs.getString("JenisKelamin"),
                rs.getInt("Tinggi")));
         }
         rs.close();
     }
     catch(Exception e)
     {
         System.out.println("Error : " +e.getMessage());
     }
     finally
     {
         try
         {
             stmt.close();
         } catch (Exception E) {}
         try
         {
             conn.close();
         }catch (Exception e) {}
     }
     return listmahasiswa;
    }
}
