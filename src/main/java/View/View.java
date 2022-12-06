/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Animal;
import Model.AnimalDAO;
import Model.Cliente;
import Model.ClienteDAO;
import Model.Consulta;
import Model.ConsultaDAO;
import Model.Especie;
import Model.EspecieDAO;
import Model.Exame;
import Model.ExameDAO;
import Model.Tratamento;
import Model.TratamentoDAO;
import Model.Veterinario;
import Model.VeterinarioDAO;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bruno
 */
public class View extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    DefaultTableModel model3 = new DefaultTableModel();
    DefaultTableModel model4 = new DefaultTableModel();
    DefaultTableModel model5 = new DefaultTableModel();
    DefaultTableModel model6 = new DefaultTableModel();
    DefaultTableModel model7 = new DefaultTableModel();
    DefaultTableModel model8 = new DefaultTableModel();

    /**
     * Creates new form TelaTeste
     */
    public View() {

        initComponents();
        initFields();
        populateTable();
        getVet();
        getEsp();
        getExa();
        getConsulta();
        getTratamento();
        getCliente();
        getAnimal();
        getAnimal2();

    }

    public void populateTable() {

        model.addColumn("id");
        model.addColumn("nome");
        model.addColumn("endereco");
        model.addColumn("cep");
        model.addColumn("email");
        model.addColumn("telefone");
        jTable3.setModel(model);

        model2.addColumn("id");
        model2.addColumn("nome");
        model2.addColumn("sexo");
        model2.addColumn("idade");
        model2.addColumn("idEspecie");
        model2.addColumn("idCliente");
        jTable4.setModel(model2);

        model3.addColumn("id");
        model3.addColumn("nome");
        model3.addColumn("email");
        model3.addColumn("telefone");
        jTable1.setModel(model3);

        model4.addColumn("id");
        model4.addColumn("nome");
        jTable2.setModel(model4);

        model5.addColumn("id");
        model5.addColumn("descricao");
        model5.addColumn("idConsulta");
        jTable5.setModel(model5);

        model6.addColumn("id");
        model6.addColumn("data");
        model6.addColumn("historico");
        model6.addColumn("idVet");
        model6.addColumn("idTratamento");
        model6.addColumn("idAnimal");
        model6.addColumn("terminou");
        model6.addColumn("hora");
        jTable6.setModel(model6);

        model7.addColumn("id");
        model7.addColumn("nome");
        model7.addColumn("data inicial");
        model7.addColumn("data final");
        model7.addColumn("idAnimal");
        model7.addColumn("terminou");
        jTable7.setModel(model7);

        model8.addColumn("Data");
        model8.addColumn("Cliente");
        model8.addColumn("Animal");
        model8.addColumn("Veterinário");
        // jTable8.setModel(model8);

    }

    private void initFields() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        jTextField13.setText("");
        jTextArea2.setText("");
      //  jTextField15.setText("");
        jTextArea1.setText("");
        jTextField14.setText("");
        jTextField18.setText("");
        jTextField19.setText("");
      //  jTextField20.setText("");
      //  jTextField21.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField22.setText("");
        jTextField23.setText("");

        jTable3.getModel().addTableModelListener(jTable3);
    }

    // get data
    private void getVet() {
        String [] s1= new String [100];
        
        DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Veterinario> veterinarios = VeterinarioDAO.getInstance().retrieveAll();
        for (Veterinario v : veterinarios) {
            model3.addRow(new Object[]{v.getId(), v.getNome(), v.getEmail(), v.getTelefone()});
            jComboBox5.addItem(v.getId() + "-" + v.getNome());
           s1[v.getId()]=v.getNome();
           
           // jComboBox5.add(v.getNome(), v.getId());
         //    jComboBox5.addItem(new ComboItem(0, "orange"));
        }
        DefaultComboBoxModel model1 = new DefaultComboBoxModel(s1);
        jComboBox5.setModel(model1);
    }

    private void getEsp() {
        Object s1[] = {};
        DefaultComboBoxModel model1 = new DefaultComboBoxModel(s1);
        jComboBox2.setModel(model1);

        DefaultTableModel dm = (DefaultTableModel) jTable2.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Especie> especies = EspecieDAO.getInstance().retrieveAll();
        for (Especie e : especies) {
            model4.addRow(new Object[]{e.getId(), e.getNome()});
            jComboBox2.addItem(e.getId() + "-" + e.getNome());
        }

    }

    private void getExa() {
        DefaultTableModel dm = (DefaultTableModel) jTable5.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Exame> exames = ExameDAO.getInstance().retrieveAll();
        for (Exame e : exames) {
            model5.addRow(new Object[]{e.getId(), e.getDescricao(), e.getIdConsulta()});
        }
    }

    private void getConsulta() {

        Object s1[] = {};
        DefaultComboBoxModel model1 = new DefaultComboBoxModel(s1);
        jComboBox3.setModel(model1);

        DefaultTableModel dm = (DefaultTableModel) jTable6.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Consulta> consultas = ConsultaDAO.getInstance().retrieveAll();
        for (Consulta c : consultas) {
            model6.addRow(new Object[]{c.getId(), c.getData(), c.getHistorico(), c.getIdVet(), c.getIdTratamento(), c.getIdAnimal(), c.isTerminou(), c.getHora()});
            jComboBox3.addItem(c.getId() + "-" + c.getHistorico());
        }
    }

    private void getTratamento() {

        Object s1[] = {};

        DefaultComboBoxModel model1 = new DefaultComboBoxModel(s1);
        jComboBox6.setModel(model1);
        DefaultTableModel dm = (DefaultTableModel) jTable7.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Tratamento> tratamentos = TratamentoDAO.getInstance().retrieveAll();
        for (Tratamento t : tratamentos) {
            model7.addRow(new Object[]{t.getId(), t.getNome(), t.getData_ini(), t.getData_final(), t.getIdAnimal(), t.isTerminou()});
            jComboBox6.addItem(t.getId() + "-" + t.getNome());
        }
    }

    private void getAnimal2() {
        DefaultTableModel dm = (DefaultTableModel) jTable4.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Animal> animais = AnimalDAO.getInstance().retrieveAll();
        for (Animal a : animais) {
            model2.addRow(new Object[]{a.getId(), a.getNome(), a.getSexo(), a.getIdade(), a.getIdEspecie(), a.getIdCliente()});
        }
    }

    private void getCliente() {
        Object s1[] = {};

        DefaultComboBoxModel model1 = new DefaultComboBoxModel(s1);
        jComboBox1.setModel(model1);

        DefaultTableModel dm = (DefaultTableModel) jTable3.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Cliente> clientes = ClienteDAO.getInstance().retrieveAll();
        for (Cliente c : clientes) {
            model.addRow(new Object[]{c.getId(), c.getNome(), c.getEndereco(), c.getCep(), c.getEmail(), c.getTelefone()});
            jComboBox1.addItem(c.getId() + "-" + c.getNome());
        }

    }

    private void getAnimal() {
        Object s1[] = {};

        DefaultComboBoxModel model1 = new DefaultComboBoxModel(s1);
//jComboBox3.setModel(model1); 

        Object s11[] = {};

        DefaultComboBoxModel model11 = new DefaultComboBoxModel(s11);
        jComboBox4.setModel(model11);

        Object s2[] = {};

        DefaultComboBoxModel model2 = new DefaultComboBoxModel(s2);
        jComboBox7.setModel(model2);

        //  DefaultTableModel dm = (DefaultTableModel) jTable3.getModel();
        // dm.getDataVector().removeAllElements();
        // dm.fireTableDataChanged();
        List<Animal> animais = AnimalDAO.getInstance().retrieveAll();
        for (Animal a : animais) {
            //  model.addRow(new Object[]{c.getId(), c.getNome(), c.getEndereco(), c.getCep(), c.getEmail(), c.getTelefone()});
            // jComboBox3.addItem(a.getId()+"-"+a.getNome());
            jComboBox4.addItem(a.getId() + "-" + a.getNome());
            jComboBox7.addItem(a.getId() + "-" + a.getNome());

        }

    }

    private void getProximas() {
        // DefaultTableModel dm = (DefaultTableModel) jTable8.getModel();
        // dm.getDataVector().removeAllElements();
        // dm.fireTableDataChanged();

        // List<Exame> exames = ExameDAO.getInstance().retrieveAll();
        //  for (Exame e : exames) {
        //     model8.addRow(new Object[]{e.getId(), e.getDescricao(), e.getIdConsulta()});
        // }
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
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jTextField14 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField16 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField23 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jCalendar3 = new com.toedter.calendar.JCalendar();
        jCalendar4 = new com.toedter.calendar.JCalendar();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("Nome: ");

        jLabel8.setText("Sexo:");

        jLabel9.setText("Cliente:");

        jTextField7.setText("jTextField7");

        jTextField8.setText("jTextField7");

        jTextField9.setText("jTextField7");

        jButton5.setText("Cadastrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel23.setText("Idade:");

        jLabel24.setText("Espécie:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable4MouseEntered(evt);
            }
        });
        jTable4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable4KeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jTextField14.setText("jTextField1");
        jTextField14.setToolTipText("");
        jTextField14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField14ActionPerformed(evt);
            }
        });

        jLabel28.setText("Busca");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel24)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(979, 979, 979))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel23)
                            .addGap(29, 29, 29))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addGap(27, 27, 27)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(178, 178, 178)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(207, 207, 207)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(16, 16, 16)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24))
                        .addGap(27, 27, 27)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Animal", jPanel3);

        jLabel10.setText("Nome:");

        jLabel11.setText("Email:");

        jLabel12.setText("Telefone:");

        jTextField10.setText("jTextField10");

        jTextField11.setText("jTextField10");

        jTextField12.setText("jTextField10");

        jButton6.setText("Cadastrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextField16.setText("jTextField10");
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        jLabel29.setText("Busca:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(235, 235, 235))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jButton6))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Veterinario", jPanel4);

        jLabel13.setText("Nome:");

        jTextField13.setText("jTextField13");

        jButton7.setText("Cadastrar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel30.setText("Busca");

        jTextField17.setText("jTextField1");
        jTextField17.setToolTipText("");
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(112, 112, 112)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Especie", jPanel5);

        jLabel2.setText("Nome:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("CEP:");

        jLabel5.setText("E-mail:");

        jLabel6.setText("Telefone:");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField2");

        jTextField4.setText("jTextField2");

        jTextField5.setText("jTextField2");

        jTextField6.setText("jTextField2");

        jButton4.setText("Cadastrar");

        jButton3.setText("Cadastrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Busca");

        jTextField1.setText("jTextField1");
        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable3MousePressed(evt);
            }
        });
        jTable3.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable3InputMethodTextChanged(evt);
            }
        });
        jTable3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable3KeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(28, 28, 28)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(36, 36, 36)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(122, 122, 122)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(296, 296, 296)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cliente", jPanel2);

        jLabel15.setText("Data:");

        jLabel16.setText("Histórico:");

        jLabel18.setText("Hora:");

        jTextField18.setText("jTextField15");

        jButton9.setText("Cadastrar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Terminou");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel22.setText("Veterinário: ");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel25.setText("Tratamento:");

        jLabel27.setText("Animal:");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable6MouseClicked(evt);
            }
        });
        jTable6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable6KeyPressed(evt);
            }
        });
        jScrollPane6.setViewportView(jTable6);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane8.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel15)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel25)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(199, 199, 199))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(jLabel27)
                                    .addGap(29, 29, 29)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jRadioButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jButton9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(183, 183, 183)
                        .addComponent(jButton9))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2)
                            .addComponent(jLabel16))))
                .addContainerGap(161, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consulta", jPanel7);

        jLabel14.setText("Descrição:");

        jButton8.setText("Cadastrar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel17.setText("Consulta:");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jTable5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable5KeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane9.setViewportView(jTextArea2);

        jTextField23.setText("jTextField1");
        jTextField23.setToolTipText("");
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });

        jLabel32.setText("Busca");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(246, 246, 246))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGap(29, 29, 29)
                        .addComponent(jButton8)
                        .addGap(158, 158, 158))))
        );

        jTabbedPane1.addTab("Exame", jPanel6);

        jLabel19.setText("Nome:");

        jTextField19.setText("jTextField19");

        jLabel20.setText("Data inicial:");

        jLabel21.setText("Data final:");

        jButton10.setText("Cadastrar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel26.setText("Animal:");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jRadioButton1.setText("Terminou");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
        });
        jTable7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable7KeyPressed(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);

        jLabel31.setText("Busca");

        jTextField22.setText("jTextField1");
        jTextField22.setToolTipText("");
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(28, 28, 28)
                        .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jCalendar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jCalendar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addGap(32, 32, 32)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jRadioButton1))
                    .addComponent(jButton10))
                .addGap(99, 99, 99)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(jCalendar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel20))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(jRadioButton1)))
                                .addGap(47, 47, 47)
                                .addComponent(jButton10)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCalendar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(169, 169, 169))))
        );

        jTabbedPane1.addTab("Tratamento", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1)
                    .addComponent(jTabbedPane2))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //get cliente data from textfield

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        DefaultTableModel dm = (DefaultTableModel) jTable3.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Cliente> clientes = ClienteDAO.getInstance().retrieveBySimilarName(jTextField1.getText());
        for (Cliente c : clientes) {
            model.addRow(new Object[]{c.getId(), c.getNome(), c.getEndereco(), c.getCep(), c.getEmail(), c.getTelefone()});
        }
    }//GEN-LAST:event_jTextField1ActionPerformed

    // cadastro de dados 
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        String nomeCliente = jComboBox1.getSelectedItem().toString();

        String array[] = new String[3];

        array = nomeCliente.split("-");

        String nomeEspecie = jComboBox2.getSelectedItem().toString();

        String array2[] = new String[3];

        array2 = nomeEspecie.split("-");

        System.out.println(array[0]);

        int idCliente = parseInt(array[0]);
        int idEspecie = parseInt(array2[0]);

        AnimalDAO.getInstance().create(jTextField7.getText(), jTextField8.getText(), parseInt(jTextField9.getText()), idEspecie, idCliente);
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        JOptionPane.showMessageDialog(null, "Animal cadastrado com sucesso!");
        getAnimal2();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ClienteDAO.getInstance().create(jTextField2.getText(), jTextField4.getText(), jTextField3.getText(), jTextField5.getText(), jTextField6.getText());
        jTextField2.setText("");
        jTextField4.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        getCliente();
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        VeterinarioDAO.getInstance().create(jTextField10.getText(), jTextField11.getText(), jTextField12.getText());
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("");
        getVet();
        JOptionPane.showMessageDialog(null, "Veterinario cadastrado com sucesso!");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        EspecieDAO.getInstance().create(jTextField13.getText());
        jTextField13.setText("");
        JOptionPane.showMessageDialog(null, "Especie cadastrada com sucesso!");
        getEsp();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        String nomeConsulta = jComboBox3.getSelectedItem().toString();

        String array[] = new String[3];

        array = nomeConsulta.split("-");

        ExameDAO.getInstance().create(jTextArea2.getText(), parseInt(array[0]));
        jTextArea2.setText("");
        getExa();
        JOptionPane.showMessageDialog(null, "Exame cadastrado com sucesso!");// TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        String nomeVet = jComboBox5.getSelectedItem().toString();

        String array[] = new String[3];

        array = nomeVet.split("-");

        String nomeTrat = jComboBox6.getSelectedItem().toString();

        String array2[] = new String[3];

        array2 = nomeTrat.split("-");

        String nomeAni = jComboBox7.getSelectedItem().toString();

        String array3[] = new String[3];

        array3 = nomeAni.split("-");

        boolean terminou = false;

        if (jRadioButton2.isSelected()) {
            terminou = true;

        }
        
          int dia = jCalendar2.getDayChooser().getDay();
       int mes = jCalendar2.getMonthChooser().getMonth() +1;
        int ano = jCalendar2.getYearChooser().getYear();

        ConsultaDAO.getInstance().create(""+dia+"/"+mes+"/"+ano+"", jTextArea1.getText(), jComboBox5.getSelectedIndex(), parseInt(array2[0]), parseInt(array3[0]), terminou, parseInt(jTextField18.getText()));
      //  jTextField15.setText("");
        jTextArea1.setText("");
        //  jTextField17.setText("");
        jTextField18.setText("");
        getConsulta();
        JOptionPane.showMessageDialog(null, "Consulta cadastrada com sucesso!");
        
      
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        String nomeAnimal = jComboBox4.getSelectedItem().toString();
        String array[] = new String[3];
        array = nomeAnimal.split("-");
        boolean terminou = false;
        
        

        if (jRadioButton1.isSelected()) {
            terminou = true;

        }
        
          int dia = jCalendar4.getDayChooser().getDay();
       int mes = jCalendar4.getMonthChooser().getMonth() +1;
        int ano = jCalendar4.getYearChooser().getYear();
        
        int dia1 = jCalendar3.getDayChooser().getDay();
       int mes1 = jCalendar3.getMonthChooser().getMonth() +1;
        int ano1 = jCalendar3.getYearChooser().getYear();


        TratamentoDAO.getInstance().create(jTextField19.getText(), ""+dia+"/"+mes+"/"+ano+"", ""+dia1+"/"+mes1+"/"+ano1+"", parseInt(array[0]), terminou);
        jTextField19.setText("");
      //  jTextField20.setText("");
     //   jTextField21.setText("");
        getTratamento();
        JOptionPane.showMessageDialog(null, "Tratamento cadastrada com sucesso!"); // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jTable3InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable3InputMethodTextChanged

    }//GEN-LAST:event_jTable3InputMethodTextChanged

    private void jTable3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MousePressed

    }//GEN-LAST:event_jTable3MousePressed

    //update de dados 
    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        int row = jTable3.getSelectedRow();
        int idCliente = (int) jTable3.getValueAt(row, 0);
        Cliente cliente = new Cliente(idCliente, (String) jTable3.getValueAt(row, 1), (String) jTable3.getValueAt(row, 2), (String) jTable3.getValueAt(row, 3), (String) jTable3.getValueAt(row, 4), (String) jTable3.getValueAt(row, 5));
        ClienteDAO.getInstance().update(cliente);
        
       // DatePicker dp = new DatePicker();
    }//GEN-LAST:event_jTable3MouseClicked

    //delete data
    private void jTable3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable3KeyPressed
        if (evt.getKeyCode() == 127) {
            int input = JOptionPane.showConfirmDialog(null,
                    "Você realmente deseja excluir esse registro?", "Selecione uma opção...", JOptionPane.YES_NO_OPTION);
            // 0=yes, 1=no, 2=cancel
            if (input == 0) {
                int row = jTable3.getSelectedRow();
                int idCliente = (int) jTable3.getValueAt(row, 0);

                //delCli(jTable3,idCliente)
                Cliente cliente = new Cliente(idCliente, (String) jTable3.getValueAt(row, 1), (String) jTable3.getValueAt(row, 2), (String) jTable3.getValueAt(row, 3), (String) jTable3.getValueAt(row, 4), (String) jTable3.getValueAt(row, 5));
                ClienteDAO.getInstance().delete(cliente);
                getCliente();
            }
        }
    }//GEN-LAST:event_jTable3KeyPressed

    //delete data
    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        if (evt.getKeyCode() == 127) {
            int input = JOptionPane.showConfirmDialog(null,
                    "Você realmente deseja excluir esse registro?", "Selecione uma opção...", JOptionPane.YES_NO_OPTION);
            // 0=yes, 1=no, 2=cancel
            if (input == 0) {
                int row = jTable2.getSelectedRow();
                int idEspecie = (int) jTable2.getValueAt(row, 0);
                Especie especie = new Especie(idEspecie, (String) jTable2.getValueAt(row, 1));
                EspecieDAO.getInstance().delete(especie);
                getEsp();
            }
        }
    }//GEN-LAST:event_jTable2KeyPressed

    //update especie
    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int row = jTable2.getSelectedRow();
        int idEspecie = (int) jTable2.getValueAt(row, 0);
        Especie especie = new Especie(idEspecie, (String) jTable2.getValueAt(row, 1));
        EspecieDAO.getInstance().update(especie);
    }//GEN-LAST:event_jTable2MouseClicked

    //delete data
    private void jTable5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable5KeyPressed
        if (evt.getKeyCode() == 127) {
            int input = JOptionPane.showConfirmDialog(null,
                    "Você realmente deseja excluir esse registro?", "Selecione uma opção...", JOptionPane.YES_NO_OPTION);
            // 0=yes, 1=no, 2=cancel
            if (input == 0) {
                int row = jTable5.getSelectedRow();
                int idExame = (int) jTable5.getValueAt(row, 0);
                Exame exame = new Exame(idExame, (String) jTable5.getValueAt(row, 1), 1);
                ExameDAO.getInstance().delete(exame);
                getExa();
            }
    }//GEN-LAST:event_jTable5KeyPressed

        //update exame
    }
    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        int row = jTable5.getSelectedRow();
        int idExame = (int) jTable5.getValueAt(row, 0);
        Exame exame = new Exame(idExame, (String) jTable5.getValueAt(row, 1), parseInt(jTable5.getValueAt(row, 2).toString()));
        ExameDAO.getInstance().update(exame);
    }//GEN-LAST:event_jTable5MouseClicked


    private void jTable4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseEntered
//        DefaultTableModel dm = (DefaultTableModel) jTable4.getModel();
        //       dm.getDataVector().removeAllElements();
        //      dm.fireTableDataChanged();
        //     int row = jTable3.getSelectedRow();
        //    int idCliente = (int) jTable3.getValueAt(row, 0);
        //   List<Animal> animais = AnimalDAO.getInstance().retrieveByIdCliente(idCliente);
        //  for (Animal a : animais) {
        //     model2.addRow(new Object[]{a.getId(), a.getNome(), a.getSexo(), a.getIdade(), a.getIdEspecie(), a.getIdCliente()});
        //}
    }//GEN-LAST:event_jTable4MouseEntered

    //delete data
    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        if (evt.getKeyCode() == 127) {
            int input = JOptionPane.showConfirmDialog(null,
                    "Você realmente deseja excluir esse registro?", "Selecione uma opção...", JOptionPane.YES_NO_OPTION);
            // 0=yes, 1=no, 2=cancel
            if (input == 0) {
                int row = jTable1.getSelectedRow();
                int idVet = (int) jTable1.getValueAt(row, 0);
                Veterinario vet = new Veterinario(idVet, (String) jTable1.getValueAt(row, 1), (String) jTable1.getValueAt(row, 2), (String) jTable1.getValueAt(row, 3));
                VeterinarioDAO.getInstance().delete(vet);
                getVet();
            }
    }//GEN-LAST:event_jTable1KeyPressed
    }

    //update veterinario
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int row = jTable1.getSelectedRow();
        int idVet = (int) jTable1.getValueAt(row, 0);
        Veterinario vet = new Veterinario(idVet, (String) jTable1.getValueAt(row, 1), (String) jTable1.getValueAt(row, 2), (String) jTable1.getValueAt(row, 3));
        VeterinarioDAO.getInstance().update(vet);
    }//GEN-LAST:event_jTable1MouseClicked

    //delete data
    private void jTable7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable7KeyPressed
        if (evt.getKeyCode() == 127) {
            int input = JOptionPane.showConfirmDialog(null,
                    "Você realmente deseja excluir esse registro?", "Selecione uma opção...", JOptionPane.YES_NO_OPTION);
            // 0=yes, 1=no, 2=cancel
            if (input == 0) {
                int row = jTable7.getSelectedRow();
                int idTra = (int) jTable7.getValueAt(row, 0);
                Tratamento tra = new Tratamento(idTra, (String) jTable7.getValueAt(row, 1), (String) jTable7.getValueAt(row, 2), (String) jTable7.getValueAt(row, 3), 1, true);
                TratamentoDAO.getInstance().delete(tra);
                getTratamento();
            }
    }//GEN-LAST:event_jTable7KeyPressed
    }

    //update tratamento
    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
        int row = jTable7.getSelectedRow();
        int idTra = (int) jTable7.getValueAt(row, 0);

        String terminou = jTable7.getValueAt(row, 6).toString();
        boolean terminouBo = Boolean.parseBoolean(terminou);

        Tratamento tra = new Tratamento(idTra, (String) jTable7.getValueAt(row, 1), (String) jTable7.getValueAt(row, 2), (String) jTable7.getValueAt(row, 3), parseInt(jTable7.getValueAt(row, 4).toString()), terminouBo);
        TratamentoDAO.getInstance().update(tra);
    }//GEN-LAST:event_jTable7MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    //cadastro cliente
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ClienteDAO.getInstance().create(jTextField2.getText(), jTextField4.getText(), jTextField3.getText(), jTextField5.getText(), jTextField6.getText());
        jTextField2.setText("");
        jTextField4.setText("");
        jTextField3.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        getCliente();
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
    }//GEN-LAST:event_jButton1ActionPerformed

    //delete data
    private void jTable4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable4KeyPressed
        if (evt.getKeyCode() == 127) {
            int input = JOptionPane.showConfirmDialog(null,
                    "Você realmente deseja excluir esse registro?", "Selecione uma opção...", JOptionPane.YES_NO_OPTION);
            // 0=yes, 1=no, 2=cancel
            if (input == 0) {
                int row = jTable4.getSelectedRow();
                int idAnimal = (int) jTable4.getValueAt(row, 0);
                Animal animal = new Animal(idAnimal, (String) jTable4.getValueAt(row, 1), (String) jTable4.getValueAt(row, 2), parseInt(jTable4.getValueAt(row, 3).toString()), parseInt(jTable4.getValueAt(row, 4).toString()), parseInt(jTable4.getValueAt(row, 5).toString()));
                AnimalDAO.getInstance().delete(animal);
                getAnimal2();
            }
        }
    }//GEN-LAST:event_jTable4KeyPressed

    //delete data
    private void jTable6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable6KeyPressed
        if (evt.getKeyCode() == 127) {
            int input = JOptionPane.showConfirmDialog(null,
                    "Você realmente deseja excluir esse registro?", "Selecione uma opção...", JOptionPane.YES_NO_OPTION);
            // 0=yes, 1=no, 2=cancel
            if (input == 0) {
                int row = jTable6.getSelectedRow();
                int idConsulta = (int) jTable6.getValueAt(row, 0);
                Consulta consulta = new Consulta(idConsulta, (String) jTable6.getValueAt(row, 1), (String) jTable6.getValueAt(row, 2), parseInt(jTable6.getValueAt(row, 3).toString()), parseInt(jTable6.getValueAt(row, 4).toString()), parseInt(jTable6.getValueAt(row, 5).toString()), false, parseInt(jTable6.getValueAt(row, 7).toString()));
                ConsultaDAO.getInstance().delete(consulta);
                getConsulta();
            }
        }
    }//GEN-LAST:event_jTable6KeyPressed

    //update data
    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        int row = jTable4.getSelectedRow();
        int idAnimal = (int) jTable4.getValueAt(row, 0);
        Animal ani = new Animal(idAnimal, (String) jTable4.getValueAt(row, 1), (String) jTable4.getValueAt(row, 2), parseInt(jTable4.getValueAt(row, 3).toString()), parseInt(jTable4.getValueAt(row, 4).toString()), parseInt(jTable4.getValueAt(row, 5).toString()));
        AnimalDAO.getInstance().update(ani);
    }//GEN-LAST:event_jTable4MouseClicked
    //update data
    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        int row = jTable6.getSelectedRow();
        int idConsulta = (int) jTable6.getValueAt(row, 0);

        String terminou = jTable6.getValueAt(row, 6).toString();
        boolean terminouBo = Boolean.parseBoolean(terminou);

        Consulta cons = new Consulta(idConsulta, (String) jTable6.getValueAt(row, 1), (String) jTable6.getValueAt(row, 2), parseInt(jTable6.getValueAt(row, 3).toString()), parseInt(jTable6.getValueAt(row, 4).toString()), parseInt(jTable6.getValueAt(row, 5).toString()), terminouBo, parseInt(jTable6.getValueAt(row, 7).toString()));
        ConsultaDAO.getInstance().update(cons);
    }//GEN-LAST:event_jTable6MouseClicked

    private void jTextField14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField14ActionPerformed
         DefaultTableModel dm = (DefaultTableModel) jTable4.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Animal> animais = AnimalDAO.getInstance().retrieveBySimilarName(jTextField14.getText());
        for (Animal a : animais) {
            model2.addRow(new Object[]{a.getId(), a.getNome(), a.getSexo(), a.getIdade(), a.getIdEspecie(), a.getIdCliente()});
        }
    }//GEN-LAST:event_jTextField14ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
      DefaultTableModel dm = (DefaultTableModel) jTable1.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Veterinario> vets = VeterinarioDAO.getInstance().retrieveBySimilarName(jTextField16.getText());
        for (Veterinario a : vets) {
            model3.addRow(new Object[]{a.getId(), a.getNome(), a.getEmail(), a.getTelefone()});
        }
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        DefaultTableModel dm = (DefaultTableModel) jTable2.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Especie> esp = EspecieDAO.getInstance().retrieveBySimilarName(jTextField17.getText());
        for (Especie e : esp) {
            model4.addRow(new Object[]{e.getId(), e.getNome()});
        }
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
         DefaultTableModel dm = (DefaultTableModel) jTable7.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Tratamento> tra = TratamentoDAO.getInstance().retrieveBySimilarName(jTextField22.getText());
        for (Tratamento t : tra) {
            model7.addRow(new Object[]{t.getId(),t.getNome(),t.getData_ini(),t.getData_final(),t.getIdAnimal(),t.isTerminou()});
        }
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        DefaultTableModel dm = (DefaultTableModel) jTable5.getModel();
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        List<Exame> exa = ExameDAO.getInstance().retrieveBySimilarName(jTextField23.getText());
        for (Exame e : exa) {
            model5.addRow(new Object[]{e.getId(),e.getDescricao(),e.getIdConsulta()});
        }
    }//GEN-LAST:event_jTextField23ActionPerformed

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JCalendar jCalendar2;
    private com.toedter.calendar.JCalendar jCalendar3;
    private com.toedter.calendar.JCalendar jCalendar4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
