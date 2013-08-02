/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Dao.AtividadeGrupoHibernateDao;
import Dao.AtividadeHibernateDao;
import entidades.Atividade;
import entidades.AtividadeGrupo;
import entidades.Recurso;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

 


/**
 *
 * @author dgsantos
 */
public class RecursoPopup extends javax.swing.JPanel {
    private final Recurso recurso;

    /**
     * Creates new form RecursoPopup
     */
    public RecursoPopup(Recurso recurso) {
        
        this.recurso  = recurso;
        
        
    }
    
    
    public ArrayList<Atividade> buscarAtividades(){
        ArrayList<Atividade> listaAtividade  = new ArrayList<>();
         final RecursoPopupView p = new RecursoPopupView(recurso);
            JOptionPane jop = new JOptionPane(p, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
          JDialog dialog = jop.createDialog(p, "As atividade");
          jop.setBackground(Color.WHITE);
            jop.setForeground(Color.WHITE);


            dialog.setBackground(Color.WHITE);
            dialog.setVisible(true);



            addComponentListener(new ComponentAdapter() {

                @Override
                public void componentShown(ComponentEvent e) {
                    SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            p.requestFocusInWindow();

                        }
                    });
                }
            });
            dialog.dispose();
            
            if(jop.getValue()!=null){
                int result = (Integer) jop.getValue();
            if (result == JOptionPane.YES_OPTION) {
                listaAtividade = p.getSelecionada();
                return listaAtividade;

            }
            }
              
        
        
        
        
        
        return null;
    }
    

    
    
    
}
 class RecursoPopupView extends JPanel{
    private final Recurso recurso;
    private ArrayList<AtividadeGrupo> listaGrupo;
    private int MODE_RECURSO;
    private ArrayList<Atividade> listaAtividade;


     
     public RecursoPopupView(Recurso recurso){
         this.recurso = recurso;
         initComponents();
         setup();
         buscarAtividades();
         
     }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        comboGrupo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nome:");

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Grupo:");

        comboGrupo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Atividade", "Grupo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(comboGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addComponent(txtPesquisa)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox comboGrupo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables

      private void setup() {
        this.listaGrupo = new AtividadeGrupoHibernateDao().buscarRecursos();

        
        
        comboGrupo.removeAllItems();
        comboGrupo.addItem(null);
        for (AtividadeGrupo grupo : listaGrupo) {
            comboGrupo.addItem(grupo.getNome());
        
        }
        comboGrupo.setSelectedIndex(0);
        
        
        if(recurso!=null){
            this.MODE_RECURSO = 1;
        }
        
        
        
        
        
        
        
        
    }

    private void buscarAtividades() {
        
        
        
        Atividade atividade = new Atividade();
        
        if(comboGrupo.getSelectedIndex()!=-1){
            atividade.setGrupoId(listaGrupo.get(comboGrupo.getSelectedIndex()-1));
        }
        
        listaAtividade =  new AtividadeHibernateDao().findByGroup(atividade,recurso);
        
        
        DefaultTableModel mdl = (DefaultTableModel) jTable1.getModel();
        mdl.setNumRows(0);
        for(Atividade temp: listaAtividade){
            
            
            mdl.addRow(new Object[]{temp.getId(),temp.getNome(),temp.getGrupoId().getNome()});
            
        }
        
        
    }

    ArrayList<Atividade> getSelecionada() {
       
        
        int rows[] = jTable1.getSelectedRows();
        
        ArrayList<Atividade> retorno = new ArrayList<>();
        for(int i = 0 ; i <rows.length;i++){
            Atividade atividade = listaAtividade.get(rows[i]);
            retorno.add(atividade);
        }
        
        
        
        return retorno;
        
    }
}
