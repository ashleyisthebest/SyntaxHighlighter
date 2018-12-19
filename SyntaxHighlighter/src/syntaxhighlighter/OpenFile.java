
package syntaxhighlighter;

import java.util.Scanner;

import javax.swing.JFileChooser;

public class OpenFile {
 
 // Declare Variable
 java.io.File file;
 JFileChooser fileChooser = new JFileChooser();
 StringBuilder sb = new StringBuilder();
 
 public void Open() throws Exception{
  
  if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
   
   // Get the file
   file = fileChooser.getSelectedFile();
   
   // Create a scanner for the file
   Scanner input = new Scanner(file);
   
   // Read text from file
   while(input.hasNext()){
    sb.append(input.nextLine());
    sb.append("\n");;
   }
   input.close();
  }
  else{

  }
 }

}