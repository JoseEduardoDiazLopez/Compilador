
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

   
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "LEARN++";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".Learn");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        Functions.setLineNumberOnJTextComponent(jtpCode);
        timerKeyReleased = new Timer((int) (1000 * 0.01), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        rootPanel.setBackground(new java.awt.Color(102, 102, 102));

        jtpCode.setBackground(new java.awt.Color(51, 51, 51));
        jtpCode.setForeground(new java.awt.Color(255, 255, 255));
        jtpCode.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jtpCode);

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(51, 51, 51));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setForeground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setBackground(new java.awt.Color(51, 51, 51));
        tblTokens.setForeground(new java.awt.Color(255, 255, 255));
        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Componente l??xico", "Entrada", "[R, C]"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTokens.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblTokens);

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
                .addContainerGap())
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );

        getContentPane().add(rootPanel);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/20x20.jpg"))); // NOI18N
        jMenu5.setMaximumSize(new java.awt.Dimension(40, 40));
        jMenuBar1.add(jMenu5);
        jMenu5.setFocusPainted(false);
        jMenu5.setFocusable(false);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/2.jpg"))); // NOI18N
        jMenu1.setText("Abrir");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/4.png"))); // NOI18N
        jMenu2.setText("Nuevo");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1.png"))); // NOI18N
        jMenu3.setText("Guardar");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/3.jpg"))); // NOI18N
        jMenu4.setText("Guardar Como");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu6.setText("                                    ");
        jMenu6.setEnabled(false);
        jMenu6.setFocusable(false);
        jMenuBar1.add(jMenu6);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/231.png"))); // NOI18N
        jMenu7.setText("Analizar");
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
    
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
          directorio.New();
        clearFields();
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
          if (directorio.Open()) {
            colorAnalysis();
            clearFields();
        }
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
         if (directorio.Save()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
         if (directorio.SaveAs()) {
            clearFields();
        }
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        if (getTitle().contains("*") || getTitle().equals(title)) {
            if (directorio.Save()) {
                compile();
            }
        } else {
            compile();
        }
    }//GEN-LAST:event_jMenu7MouseClicked

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no Existe " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error Al Guardar " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);
          /* Eliminar errores */
          gramatica.delete(new String[]{"ERROR_1","ERROR_2","ERROR_3"},1);
            /* agrupar valores */
          gramatica.group("VALORES","(NUMERO | COLOR | VERDADERO | FALSO)",true);
           /* declarar variable */
           gramatica.group("VARIABLE","TIPO_DE_DATO IDENTIFICADOR OPERADOR_ASIGNACION VALORES FIN_DE_SENTENCIA",true);
           //No !
           gramatica.group("VARIABLE","TIPO_DE_DATO IDENTIFICADOR OPERADOR_ASIGNACION VALORES ",true,
                   2,"Error sint??ctico {}: falta ! en la declaracion de variable (Linea: # )");
           // no identificador
           gramatica.group("VARIABLE","TIPO_DE_DATO OPERADOR_ASIGNACION VALORES FIN_DE_SENTENCIA",true,
                   3,"Error sint??ctico {}: falta identificador en la declaracion (Linea: # )");
           //no valor
           gramatica.group("VARIABLE","TIPO_DE_DATO IDENTIFICADOR OPERADOR_ASIGNACION FIN_DE_SENTENCIA",true,
                   4,"Error sint??ctico {}: falta VALOR en la declaracion (Linea: # )");
           //no op asignacion
           gramatica.group("VARIABLE","TIPO_DE_DATO IDENTIFICADOR VALORES FIN_DE_SENTENCIA",true,
                   5,"Error sint??ctico {}: falta operador de asignacion en la declaracion (Linea: # )");
           //NO TIPO DE DATO
           gramatica.group("VARIABLE","IDENTIFICADOR OPERADOR_ASIGNACION VALORES FIN_DE_SENTENCIA",true,
                   6,"Error sint??ctico {}: falta tipo de dato en la declaracion (Linea: # )");
           
           /* agrupar identificadores y parametros */
            gramatica.group("VALORES", "IDENTIFICADOR");
           gramatica.group("PARAMETROS", "VALORES (COMA VALORES)+");
           
           //ARITMETRICA
           gramatica.group("OPERACION_ARITMETRICA", 
                   "VALORES (OPERADOR_MAS | OPERADOR_MENOS | OPERADOR_MULTIPLICAR | OPERADOR_DIVIDIR) VALORES",true);
           
           gramatica.group("OPERACION_ARITMETRICA", 
                   "VALORES (OPERADOR_MAS | OPERADOR_MENOS | OPERADOR_MULTIPLICAR | OPERADOR_DIVIDIR) ",true,9,
                   "Error sint??ctico {}: falta un valor en la operacion de la (Linea: # )");
           
           gramatica.group("OPERACION_ARITMETRICA", 
                   "(OPERADOR_MAS | OPERADOR_MENOS | OPERADOR_MULTIPLICAR | OPERADOR_DIVIDIR) VALORES",true,10,
                   "Error sint??ctico {}: falta un valor en la operacion de la (Linea: # )");
           //LOGICAA
           gramatica.group("VALORESL","VERDADERO FALSO",true);
           
           gramatica.group("OPERACION_LOGICA", 
                   "VALORESL (OPERADOR_ADN | OPERADOR_OR | OPERADOR_DIFERENTEQUE) VALORESL",true);
           gramatica.group("OPERACION_LOGICA", 
                   "VALORESL (OPERADOR_ADN | OPERADOR_OR | OPERADOR_DIFERENTEQUE)",true,11,
                   "Error sint??ctico {}: falta un valor en la operacion de la (Linea: # )");
           
           gramatica.group("OPERACION_LOGICA", 
                   "(OPERADOR_ADN | OPERADOR_OR | OPERADOR_DIFERENTEQUE) VALORESL)",true,12,
                   "Error sint??ctico {}: falta un valor en la operacion de la (Linea: # )");
           
            gramatica.group("OPERACION_LOGICA", 
                   "(VALORES OPERADOR_ADN | OPERADOR_OR | OPERADOR_DIFERENTEQUE) VALORES)",true,12,
                   "Error sint??ctico {}: solo valores logicos para esta operacion (Linea: # )");
            gramatica.group("OPERACION_LOGICA", 
                   "(VALORES OPERADOR_ADN | OPERADOR_OR | OPERADOR_DIFERENTEQUE) VALORESL)",true,13,
                   "Error sint??ctico {}: solo valores logicos para esta operacion (Linea: # )");
            
             gramatica.group("OPERACION_LOGICA", 
                   "(VALORESL OPERADOR_ADN | OPERADOR_OR | OPERADOR_DIFERENTEQUE) VALORES)",true,14,
                   "Error sint??ctico {}: solo valores logicos para esta operacion (Linea: # )");
      
           
           
           
           //FUNCIONES
           gramatica.group("FUNCIONES", "FUNCION ABRE_PARENTESIS (VALORES | PARAMETROS)? CIERRA_PARENTESIS",true);
           //parentesis abrir
           gramatica.group("FUNCIONES", "FUNCION (VALORES | PARAMETROS)? CIERRA_PARENTESIS",true,
                   7,"Error sint??ctico {}: falta abrir parentesis  (Linea: # )");
           //parentesis cerrar 
           gramatica.group("FUNCIONES", " FUNCION ABRE_PARENTESIS(VALORES | PARAMETROS)? ",true,
                   8,"Error sint??ctico {}: falta cerrar parentesis  (Linea: # )");
           
           
           //ESTRUCTURAS DE CONTROL
           gramatica.group("ESTRUCTURA_CONTROL","(INICIO_CONDICIONAL | CICLO_FOR)");
           
 gramatica.group("ESTRUCTURA_CONTROL_COMP","ESTRUCTURA_CONTROL ABRE_PARENTESIS (VALORES | PARAMETROS ) CIERRA_PARENTESIS ",true);
          
     gramatica.group("ESTRUCTURA_CONTROL_COMP","ESTRUCTURA_CONTROL ABRE_PARENTESIS (VALORES | PARAMETROS )  ",true,
     15,"Error sint??ctico {}: falta cerrar parentesis  (Linea: # )"); 
      gramatica.group("ESTRUCTURA_CONTROL_COMP","ESTRUCTURA_CONTROL (VALORES | PARAMETROS ) CIERRA_PARENTESIS",true,
     16,"Error sint??ctico {}: falta abrir parentesis  (Linea: # )"); 
     gramatica.group("ESTRUCTURA_CONTROL_COMP","ESTRUCTURA_CONTROL",true,
     17,"Error sint??ctico {}: faltan  parentesis ()  (Linea: # )"); 
     gramatica.group("ESTRUCTURA_CONTROL_COMP","ESTRUCTURA_CONTROL ABRE_PARENTESIS CIERRA_PARENTESIS",true,
     18,"Error sint??ctico {}: faltan parametros o valores  (Linea: # )"); 
          
           
        /* Mostrar gram??ticas */
        gramatica.show();
    }

    private void semanticAnalysis() {
    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexerColor;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexerColor = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexerColor.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no Existe " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error Al guardar " + ex.getMessage());
        } 
        
        
        Functions.colorTextPane(textsColor, jtpCode, new Color(255, 255, 255));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), "[" + token.getLine() + ", " + token.getColumn() + "]"};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilaci??n lista\n" + strErrors + "\n La compilaci??n termin?? con ERRORES...");
        } else {
            jtaOutputConsole.setText("Compilaci??n sin errores\n");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}
