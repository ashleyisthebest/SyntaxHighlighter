package syntaxhighlighter;

public class MainWindow extends javax.swing.JFrame {

    public MainWindow() {
        initComponents();
        rowsText.setFont(mainText.getFont());

        int i;
        for (i = 1; i <= 1000; i++) {
            rowsText.append(Integer.toString(i) + "\n");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JScrollPane();
        mainText = new javax.swing.JTextPane();
        rowsPane = new javax.swing.JScrollPane();
        rowsText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Syntax Highlighter");
        setIconImages(null);

        mainPane.setAutoscrolls(true);

        mainText.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 4, 1, 1));
        mainText.setFont(new java.awt.Font("Ubuntu Light", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rowsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPane)
                    .addComponent(rowsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainTextKeyTyped

        // Scrolls at the same pace
        rowsPane.setVerticalScrollBar(mainPane.getVerticalScrollBar());

        // To make the numbers relative.
//    int countLine = mainText.getText().split("\n").length;
//    int i;
//    for(i=1;i<=countLine;i++){
//        rowsText.append(Integer.toString(i)+ "\n");
//    }
        // TODO add your handling code here:
    }//GEN-LAST:event_mainTextKeyTyped

    private void autoScroll(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_autoScroll

    }//GEN-LAST:event_autoScroll

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane mainPane;
    private javax.swing.JTextPane mainText;
    private javax.swing.JScrollPane rowsPane;
    private javax.swing.JTextArea rowsText;
    // End of variables declaration//GEN-END:variables
}
