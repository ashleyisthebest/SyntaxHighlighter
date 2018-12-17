package syntaxhighlighter;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();

        //Load Icon
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("icon.png"));
        } catch (IOException ex) {
            System.out.println("Error loading icon:" + ex);
        }
        setIconImage(im);

        //Allows both text boxes to scroll at same time
        rowsText.setFont(mainText.getFont());
        rowsPane.setVerticalScrollBar(mainPane.getVerticalScrollBar());

        //Sets the total number of displayed lines to 1000 then generates the lines.
        int i;
        for (i = 1; i <= 1000; i++) {
            rowsText.append(Integer.toString(i) + "\n");
        }

        //Sets focus of the window to the main text box.
        mainText.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JScrollPane();
        mainText = new javax.swing.JTextPane();
        rowsPane = new javax.swing.JScrollPane();
        rowsText = new javax.swing.JTextArea();
        languageBox = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Syntax Highlighter");
        setIconImages(null);

        mainPane.setAutoscrolls(true);

        mainText.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 4, 1, 1));
        mainText.setFont(new java.awt.Font("Ubuntu Light", 0, 14)); // NOI18N
        mainText.setSelectionColor(new java.awt.Color(0, 255, 102));
        mainText.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                autoScroll(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        mainText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mainTextKeyTyped(evt);
            }
        });
        mainPane.setViewportView(mainText);

        rowsPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        rowsPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        rowsPane.setAutoscrolls(true);

        rowsText.setEditable(false);
        rowsText.setColumns(20);
        rowsText.setForeground(new java.awt.Color(0, 102, 51));
        rowsText.setRows(5);
        rowsText.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 4, 1, 1));
        rowsPane.setViewportView(rowsText);

        languageBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Python", "HTML", "C++" }));
        languageBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        languageBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageBoxActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rowsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(languageBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(languageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPane)
                    .addComponent(rowsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainTextKeyTyped
        //Checks language
        if (languageBox.getSelectedItem().equals("Python")) {
            System.out.println("Python Selected");
            python();
        } else if (languageBox.getSelectedItem().equals("HTML")) {
            System.out.println("HTML Selected");
        } else if (languageBox.getSelectedItem().equals("C++")) {
            System.out.println("C++ Selected");
        }

        // To make the numbers relative.
        //    int countLine = mainText.getText().split("\n").length;
        //    int i;
        //    for(i=1;i<=countLine;i++){
        //        rowsText.append(Integer.toString(i)+ "\n");
        //    }

    }//GEN-LAST:event_mainTextKeyTyped

    public void python() {

        String text = mainText.getText();
        int i;

        // Sets default as black
        SimpleAttributeSet black = new SimpleAttributeSet();
        StyleConstants.setForeground(black, Color.BLACK);
        StyledDocument mdoc = mainText.getStyledDocument();
        mdoc.setCharacterAttributes(0, text.length(), black, false);

        //Print
        List<Integer> print = WordIndexer.findWord(text, "print");

        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.blue);

        StyledDocument bluedoc = mainText.getStyledDocument();

        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 5, blueattr, false);
        }

        // Sets Print to blue


    }

    private void autoScroll(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_autoScroll

    }//GEN-LAST:event_autoScroll

    private void languageBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageBoxActionPerformed

    }//GEN-LAST:event_languageBoxActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JComboBox<String> languageBox;
    private javax.swing.JScrollPane mainPane;
    private javax.swing.JTextPane mainText;
    private javax.swing.JScrollPane rowsPane;
    private javax.swing.JTextArea rowsText;
    // End of variables declaration//GEN-END:variables
}
