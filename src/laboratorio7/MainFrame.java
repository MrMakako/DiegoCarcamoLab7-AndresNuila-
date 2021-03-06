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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    
    Simulacion sim;
    
    
    Editar Editor;

    
    ///COmmit funcional
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
        
        
        sim = new Simulacion(ListaEquipos);

        
        
        
        
    }
    
    
    public void OrdenarEquipos(){
    
        for(int i =0;i<ListaEquipos.size()-1;i++){
        
            for(int x= 0 ;x<ListaEquipos.size()-1;x++){
            
                Equipo Actual= ListaEquipos.get(x);
                
                Equipo Siguiente= ListaEquipos.get(x+1);
                
                
                if(Actual.getPuntos()<Siguiente.getPuntos()){
                    ListaEquipos.set(x,Siguiente);
                    
                    ListaEquipos.set(x+1,Actual);
                
                    
                
                
                
                }
                
            
            
            
            
            }
        
        
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
                new Object[]{"Nombre", "PJ","PG","PE", "PP", "GF", "GC","DG","Puntos"}
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

        jToggleButton2 = new javax.swing.JToggleButton();
        Cargar = new javax.swing.JButton();
        Simulacion = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jToggleButton2.setText("jToggleButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        Cargar.setText("CargarEquipo");
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        Simulacion.setText("Simular");
        Simulacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SimulacionMouseClicked(evt);
            }
        });
        Simulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimulacionActionPerformed(evt);
            }
        });

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

        jMenuItem1.setText("Agregar Equipo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Editar Equipos");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(Simulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(320, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addComponent(Simulacion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
       
        
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

        
        
        
    }//GEN-LAST:event_jMenu1MouseClicked

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        // TODO add your handling code here:
        JFileChooser selector= new JFileChooser();
        JOptionPane.showMessageDialog(null, selector, "Elija la ruta",JOptionPane.YES_NO_OPTION);
      
       if( selector.getSelectedFile()==null){
           Arhivo= selector.getSelectedFile();
       
       
       
       }
        
        
        
    }//GEN-LAST:event_CargarActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        
        OrdenarEquipos();
        
        GenerarTabla(TablaPartidos.getTablaPartidos());
        
        
        JOptionPane.showMessageDialog(null,TablaPartidos,"Partidos",JOptionPane.PLAIN_MESSAGE);
        
        
        System.out.println("Abriendo tabal de partidos");
        
        
        
        
    }//GEN-LAST:event_jMenu2MouseClicked

    private void SimulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimulacionActionPerformed
        // TODO add your handling code here:
        for(Equipo item: ListaEquipos){
            
            sim.getBox1().addItem(item);
            sim.getBox2().addItem(item);
        
        
        
        }
        
        JOptionPane.showMessageDialog(null,sim,"Simulacion",JOptionPane.PLAIN_MESSAGE);
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_SimulacionActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        
        GuardarArhcivo();
    }//GEN-LAST:event_formWindowClosed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        
           
         JTextField Nombre = new JTextField();
        
        JOptionPane.showInternalMessageDialog(null,Nombre,"Nombre del equipo", JOptionPane.OK_CANCEL_OPTION);
        String Entrada= Nombre.getText();
        System.out.println(Entrada);
        if(BuscarEquipo(Entrada)==null){
             ListaEquipos.add(new Equipo(Entrada,0,0,0,0,0,0,0,0));
             System.out.println("Creando");
  
        }
        
        GuardarArhcivo();
        
       
        
        
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        // TODO add your handling code here:
        
     
        
        
        
        
        
        
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void SimulacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SimulacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SimulacionMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
         System.out.println("Editar");
         
         
         
        
        Editar Editor= new Editar(ListaEquipos);
        
        
         JOptionPane.showMessageDialog(null, Editor, "Editar",JOptionPane.PLAIN_MESSAGE);
        
        
       Equipo seleccionado= BuscarEquipo(((Equipo)Editor.getBoxEquipos().getSelectedItem()).getNombre());
        if(Editor.getBtnEliminar().isSelected()){
            ListaEquipos.remove(seleccionado);
            
            
        
        }else{
            
           if(BuscarEquipo(Editor.getNombre().getText())==null){
               seleccionado.setNombre(Editor.getNombre().getText());
           
           
           }else{
           
               System.out.println("No se pudo cambiar nombre , Quiza otros cambiso tambien se allan realizado");
               
               
               
               
               
               
               
               
               
           }
           
           
           
      
           
           
           
          
        
            
        
        
        }
        
             GuardarArhcivo();
        
        
        
        
        
       
        
        
      
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cargar;
    private javax.swing.JButton Simulacion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
