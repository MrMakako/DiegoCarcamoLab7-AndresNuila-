/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package laboratorio7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Diego Carcamo
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    ArrayList<Equipo> ListaEquipos;
    ///Equipos del arhico de texto

    File Arhivo;
    
    PanelPartidos TablaPartidos;

    public MainFrame() {
        
        ListaEquipos= new ArrayList<>();
        
        
        TablaPartidos= new PanelPartidos();
         

        initComponents();

        Arhivo = new File("Equipos.txt");
        
        if(Arhivo.exists()){
            try{
                 CargarArchivo();
            }catch(IOException e){
            
            
            }
           
        
        
        }else{
           GuardarArhcivo();
        
        }

        
        
        
        
    }

   
    
    public void CargarEquipos(){
        try{
            
            CargarArchivo();
            
        }catch(IOException e){
            
            
    
    
        }finally{
            
            //general tabla
            
        
        
        
        }
    
    
    }
    
    
    public Object[][] Elemtos(){
        
        Object Campos[][]= new String [ListaEquipos.size()][9];
        
        for(int i=0; i<ListaEquipos.size();i++){
            
            
            Campos[i][0]=ListaEquipos.get(i).getNombre();
            Campos[i][1]=ListaEquipos.get(i).getPartJ()+"";
            Campos[i][2]=ListaEquipos.get(i).getPartG()+"";
            Campos[i][3]=ListaEquipos.get(i).getPartE()+"";
            Campos[i][4]=ListaEquipos.get(i).getPartP()+"";
            Campos[i][5]=ListaEquipos.get(i).getGolesF()+"";
            Campos[i][6]=ListaEquipos.get(i).getGolesC()+"";
            Campos[i][7]= ListaEquipos.get(i).getGolesD()+"";
            Campos[i][8]= ListaEquipos.get(i).getPuntos()+"";
            
     
        
        
        }
        
        return Campos;
        
    
    
    }
    
    private void GenerarTabla(JTable tabla){
        
        
        //Investigar referencias 
        

        DefaultTableModel model = new DefaultTableModel(
                Elemtos(),
                new Object[]{"Nombre", "PJ", "PE", "PP", "GF", "GC","DG","Puntos"}
        ) {

            public boolean isCellEditable(int row, int column) {
                return false;

            }

        };

        tabla.setModel(model);
    
    
    
    
    
    
    }
    
    

    private  void CargarArchivo() throws FileNotFoundException {

        if (Arhivo.exists()) {

            //Leer el arhcivo 
            FileReader leer = new FileReader(Arhivo);

            Scanner sc = new Scanner(Arhivo);

          //  ListaEquipos = new ArrayList<>();

            String campos[];
            
            ListaEquipos= new ArrayList<>();

            while (sc.hasNext()) {

                String equipo = sc.nextLine();
                campos = equipo.split(";");
                
                
                ListaEquipos.add(new Equipo(campos[0],parse(campos[1]),parse(campos[2]),parse(campos[3]),parse(campos[4]),parse(campos[5]),parse(campos[6]),parse(campos[7]),parse(campos[8])));
                
                

            }

            //  ListaEquipos.add(new Equipo(equipo, WIDTH, WIDTH, WIDTH, WIDTH, NORMAL, NORMAL, NORMAL, WIDTH))
        }

    }
    
    
    
    public int parse(String num){
        
        return Integer.parseInt(num);
    
    
    
    }



public Equipo BuscarEquipo(String nombre){
        for(Equipo item:ListaEquipos){
            if(nombre.equals(item.getNombre())){
                
                
                return item;
            
            
            }
        
        
        
        }
        return null;
        
    
    
    
    }

    public void GuardarArhcivo() {
        try {

            if (Arhivo.exists()) {
                
                
                System.out.println("Arhcivo exitenre ");
                
                
               
               //Queremos sobre escribir el arhvio
                FileWriter escr= new FileWriter(Arhivo);
                
                BufferedWriter Escribir= new BufferedWriter(escr);
                
                String Info="";
                
                
                
                for(Equipo item: ListaEquipos){
                    
                    
                    Info+=item.getNombre()+";"+item.getPartJ()+";"+item.getPartG()
                            +";"+item.getPartE()+";"+item.getPartP()+";"+item.getGolesF()
                            +";"+item.getGolesC()+";"+item.getGolesD()+";"+item.getPuntos()+"\n";
                    
                    
                    System.out.println(Info);
                    
                    
                    
                    
                
                
                
                }
                
                
               
                
                
                Escribir.write(Info);
                Escribir.close();
                
           
               
               
          
                

            } else {

                Arhivo.createNewFile();

            }

        } catch (IOException e) {

        }finally{
            ///Acccion final 
             System.out.println("Listo");
             try{
                 
                     CargarArchivo();
                      CargarEquipos();
             
             }catch(Exception e){
             
             
             }
         
          
    
    
    
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Cargar = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Cargar.setText("CargarEquipo");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Simular");

        jMenu1.setText("Equipos");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Partido");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(275, 275, 275)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)))
                .addContainerGap(289, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
   
         JTextField Nombre = new JTextField();
        
        JOptionPane.showInternalMessageDialog(null,Nombre,"Nombre del equipo", JOptionPane.OK_CANCEL_OPTION);
        String Entrada= Nombre.getText();
        System.out.println(Entrada);
        if(BuscarEquipo(Entrada)==null){
             ListaEquipos.add(new Equipo(Entrada,0,0,0,0,0,0,0,0));
             System.out.println("Creando");
  
        }
        
        GuardarArhcivo();
        
       
        
        
        
        
        
        
        
    }//GEN-LAST:event_jMenu1MouseClicked

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        // TODO add your handling code here:
        JFileChooser selector= new JFileChooser();
        JOptionPane.showMessageDialog(null, selector, "Elija la ruta",JOptionPane.OK_CANCEL_OPTION);
        
        Arhivo= selector.getSelectedFile();
        
        
        
    }//GEN-LAST:event_CargarActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        GenerarTabla(TablaPartidos.getTablaPartidos());
        
        
        JOptionPane.showMessageDialog(null,TablaPartidos,"Partidos",JOptionPane.PLAIN_MESSAGE);
        
        
        System.out.println("Abriendo tabal de partidos");
        
        
        
        
    }//GEN-LAST:event_jMenu2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

}
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);

} catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class  

.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cargar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
