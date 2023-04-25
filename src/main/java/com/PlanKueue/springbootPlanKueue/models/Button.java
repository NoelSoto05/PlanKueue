
package com.PlanKueue.springbootPlanKueue.models;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Button extends Frame {
private Button button;

   public Button() {
      setLayout(new FlowLayout());

      button = new Button();
      add(button);

      button.addComponentListener((ComponentListener) new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               String text = "This is the content of the file.";
               String filename = "example.txt";
               File file = new File(filename);
               FileWriter writer = new FileWriter(file);
               writer.write(text);
               writer.close();
               Runtime.getRuntime().exec("notepad.exe " + file.getAbsolutePath());
            } catch (IOException ex) {
               ex.printStackTrace();
            }
         }
      });

      setTitle("Button Example");
      setSize(300, 200);
      setVisible(true);
   }

   public static void main(String[] args) {
      new Button();
   }
}