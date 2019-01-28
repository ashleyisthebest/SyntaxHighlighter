package syntaxhighlighter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MainWindow extends javax.swing.JFrame {

    public String text;
    public boolean fileOpen = false;
    public String filePathString;
    public int fontSize = 18;

    public MainWindow() {

        initComponents();
        loadIcon();

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

    public void loadIcon() {
        //Load Icon
        Image im = null;
        try {
            im = ImageIO.read(getClass().getResource("icon.png"));
        } catch (IOException ex) {
            System.out.println("Error loading icon:" + ex);
        }
        setIconImage(im);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPane = new javax.swing.JScrollPane();
        mainText = new javax.swing.JTextPane();
        rowsPane = new javax.swing.JScrollPane();
        rowsText = new javax.swing.JTextArea();
        languageBox = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        ZoomIn = new javax.swing.JMenuItem();
        ZoomOut = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Syntax Highlighter");
        setIconImages(null);

        mainPane.setAutoscrolls(true);

        mainText.setBackground(new java.awt.Color(153, 153, 153));
        mainText.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 4, 1, 1));
        mainText.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
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

        languageBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Python", "HTML", "C++" }));
        languageBox.setToolTipText("Select Language");
        languageBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        languageBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                languageBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Chars:");

        jLabel2.setText("Lines:");

        jMenu1.setText("File");
        jMenu1.setName(""); // NOI18N

        Open.setText("Open");
        Open.setPreferredSize(new java.awt.Dimension(150, 22));
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu1.add(Open);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jMenu1.add(Save);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("View");

        ZoomIn.setLabel("Zoom In");
        ZoomIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZoomInActionPerformed(evt);
            }
        });
        jMenu3.add(ZoomIn);

        ZoomOut.setText("Zoom Out");
        ZoomOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZoomOutActionPerformed(evt);
            }
        });
        jMenu3.add(ZoomOut);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rowsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(languageBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(languageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPane)
                    .addComponent(rowsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mainTextKeyTyped
        //Everything in here will execute every time a key is pressed.
        checkLanguage();
        charCount();
        lineCount();
    }//GEN-LAST:event_mainTextKeyTyped

    public void lineCount() {
        text = mainText.getText();
        int numOfLines = countLines(text);
        jLabel2.setText("Lines: " + numOfLines);
    }

    private static int countLines(String str) {
        String[] lines = str.split("\r\n|\r|\n");
        return lines.length;
    }

    public void charCount() {
        text = mainText.getText();
        int numOfChars = text.length();
        jLabel1.setText("Chars: " + numOfChars);
    }

    public void checkLanguage() {
        //Checks language
        if (languageBox.getSelectedItem().equals("Python")) {
            System.out.println("Python Selected");
            python();
        } else if (languageBox.getSelectedItem().equals("HTML")) {
            System.out.println("HTML Selected");
        } else if (languageBox.getSelectedItem().equals("C++")) {
            System.out.println("C++ Selected");
        }

        //    To make the numbers relative.
        //    int countLine = mainText.getText().split("\n").length;
        //    int i;
        //    for(i=1;i<=countLine;i++){
        //        rowsText.append(Integer.toString(i)+ "\n");
        //    }
    }

    public void python() {

        // Turns all user text into string
        text = mainText.getText();

        // Sets default as black
        setToBlack();

        // Finding key terms
        // Symbols
        pyLBracket();
        pyRBracket();
        pyLSQBracket();
        pyRSQBracket();
        pyQuotationMark();
        pyFullstop();
        pyColon();
        pyLCurly();
        pyRCurly();
        pyDollar();
        pyComma();
        pyPlus();
        pyMinus();
        pyStar();
        pyDivide();
        pyPercent();
        pyEquals();

        // 2 Letters
        pyIf();
        pyIn();

        // 3 Letters
        pyInt();
        pyDef();
        pyFor();
        pyNot();

        // 4 Letters
        pyElif();
        pyFrom();
        pyTrue();

        // 5 Letters
        pyPrint();
        pyInput();
        pyWhile();

        // 6 Letters
        pyString();
        pyReturn();
        pyImport();
        pyFormat();

    }

    public void setToBlack() {
        // Sets default as black
        SimpleAttributeSet black = new SimpleAttributeSet();
        StyleConstants.setForeground(black, Color.BLACK);
        StyledDocument mdoc = mainText.getStyledDocument();
        mdoc.setCharacterAttributes(0, text.length(), black, false);
    }

    public void pyPrint() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "print");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.blue);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 5, blueattr, false);
        }
    }

    public void pyInt() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "int");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 3, blueattr, false);
        }
    }

    public void pyString() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "string");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 6, blueattr, false);
        }
    }

    public void pyDef() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "def");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 3, blueattr, false);
        }
    }

    public void pyReturn() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "return");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 6, blueattr, false);
        }
    }

    public void pyIf() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "if ");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 3, blueattr, false);
        }
    }

    public void pyElif() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "elif ");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 5, blueattr, false);
        }
    }

    public void pyFor() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "for ");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 4, blueattr, false);
        }
    }

    public void pyNot() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, " not ");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 5, blueattr, false);
        }
    }

    public void pyIn() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, " in ");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 4, blueattr, false);
        }
    }

    public void pyInput() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "input");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 5, blueattr, false);
        }
    }

    public void pyFrom() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "from ");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 5, blueattr, false);
        }
    }

    public void pyImport() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "import ");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 7, blueattr, false);
        }
    }

    public void pyFormat() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "format");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.blue);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 6, blueattr, false);
        }
    }

    public void pyWhile() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "while ");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.GREEN);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 6, blueattr, false);
        }
    }

    public void pyTrue() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "True");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.blue);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 4, blueattr, false);
        }
    }

    public void pyLBracket() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "(");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.MAGENTA);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyRBracket() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, ")");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.MAGENTA);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyLSQBracket() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "[");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.MAGENTA);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyRSQBracket() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "]");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.MAGENTA);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyQuotationMark() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, Character.toString((char) 34));

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.MAGENTA);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyFullstop() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, ".");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.MAGENTA);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyColon() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, ":");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.MAGENTA);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyLCurly() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "{");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.MAGENTA);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyRCurly() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "}");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.MAGENTA);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyDollar() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "$");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.MAGENTA);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyComma() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, ",");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.MAGENTA);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyPlus() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "+");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.cyan);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyMinus() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "-");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.cyan);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyStar() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "*");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.cyan);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyDivide() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "/");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.cyan);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyPercent() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "%");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.cyan);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    public void pyEquals() {
        //Finds print
        List<Integer> print = WordIndexer.findWord(text, "=");

        //Sets print to blue
        SimpleAttributeSet blueattr = new SimpleAttributeSet();
        StyleConstants.setForeground(blueattr, Color.cyan);
        StyledDocument bluedoc = mainText.getStyledDocument();

        //Applies setting to all instances
        int i;
        for (i = 0; i < print.size(); i++) {
            bluedoc.setCharacterAttributes(print.get(i), 1, blueattr, false);
        }
    }

    private void autoScroll(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_autoScroll

    }//GEN-LAST:event_autoScroll

    private void languageBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_languageBoxActionPerformed

    }//GEN-LAST:event_languageBoxActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed

        // Opens File
        OpenFile of = new OpenFile();
        try {
            of.Open();
            this.setTitle(of.file + " - Syntax Highlighter");
            mainText.setText(of.sb.toString());
            fileOpen = true;
            filePathString = of.file.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Refresh so it highlights all the code again
        if (languageBox.getSelectedItem().equals("Python")) {
            System.out.println("Python Selected");
            python();
        } else if (languageBox.getSelectedItem().equals("HTML")) {
            System.out.println("HTML Selected");
        } else if (languageBox.getSelectedItem().equals("C++")) {
            System.out.println("C++ Selected");
        }

    }//GEN-LAST:event_OpenActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed

        OpenFile of = new OpenFile();

        try {
            if (fileOpen == true) {
                // Gets all content to save
                String fileContent = mainText.getText();
                // Creates new path with the file location
                Path path = Paths.get(filePathString);
                // Writes the file
                Files.write(path, fileContent.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_SaveActionPerformed

    private void ZoomInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZoomInActionPerformed
        fontSize += 10;
        mainText.setFont(new Font("Courier New", Font.PLAIN, fontSize));
        rowsText.setFont(new Font("Courier New", Font.PLAIN, fontSize));
    }//GEN-LAST:event_ZoomInActionPerformed

    private void ZoomOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZoomOutActionPerformed
        fontSize -= 10;
        mainText.setFont(new Font("Courier New", Font.PLAIN, fontSize));
        rowsText.setFont(new Font("Courier New", Font.PLAIN, fontSize));
    }//GEN-LAST:event_ZoomOutActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem ZoomIn;
    private javax.swing.JMenuItem ZoomOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JComboBox<String> languageBox;
    private javax.swing.JScrollPane mainPane;
    private javax.swing.JTextPane mainText;
    private javax.swing.JScrollPane rowsPane;
    private javax.swing.JTextArea rowsText;
    // End of variables declaration//GEN-END:variables
}
