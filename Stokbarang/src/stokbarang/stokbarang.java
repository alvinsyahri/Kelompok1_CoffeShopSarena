package stokbarang;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import stokbarang.DBKoneksi;
import com.mysql.jdbc.Statement;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moch. Arif S.
 */
public class stokbarang extends javax.swing.JFrame {
  
DBKoneksi koneksi;
    Statement statement;
    ResultSet resultSet;
    
    /**
     * Creates new form StokBarang
     */
    public stokbarang () {
        initComponents();
        setTitle("STOK BARANG");
        koneksi = new DBKoneksi();
    }

    
    private void select(String sql){ 
         
        String header[]={"ID_BARANG","KATEGORI","NAMA_BARANG","JUMLAH STOK"}; 
        DefaultTableModel defaultTableModel=new DefaultTableModel(null, header); 
        jTable1.setModel(defaultTableModel); 
         
        for (int i = 0; i < jTable1.getRowCount(); i++) { 
            defaultTableModel.removeRow(i); 
        } 
         
          try {  
            resultSet=statement.executeQuery(sql); 
             
            while (resultSet.next()) { 
                String id_barang=resultSet.getString(1); 
                String kategori=resultSet.getString(2); 
                String nama_barang=resultSet.getString(3); 
                int stok=resultSet.getInt(4); 
                 
                Object baris[]={id_barang,kategori,nama_barang,stok}; 
                defaultTableModel.addRow(baris); 
            } 
        } catch (Exception e) { 
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
 