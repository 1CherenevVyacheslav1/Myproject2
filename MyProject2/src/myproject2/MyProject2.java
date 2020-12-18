
package myproject2;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
        
public class Myproject2 extends JFrame {
 int balans = 0;
 int bal = 0;
  int i =0;
  int f = 0;
  
    private JLabel countLabel;
    private JLabel prognoz;
    private JButton calc;
    private JTextField text1;
    private JTextField text2;
    

public Frame() throws IOException {
super("счетчик финансов"); // конструктор базового класса
/* Подготавливаем компоненты объекта  */
 countLabel = new JLabel("бюджет: " + balans + "     ");
 prognoz = new JLabel("прогноз на следующий месяц: " + balans);
 calc = new JButton("посчитать");
 text1 = new JTextField("введите доход",20);
 text2 = new JTextField("введите расходы",20);    
/* Подготавливаем временные компоненты  */
  JPanel buttonsPanel = new JPanel(new FlowLayout());
        JPanel TextField = new JPanel(new FlowLayout());
       JPanel label = new JPanel(new FlowLayout());
       /* Расставляем компоненты по местам */
 label.add(countLabel);
 label.add(prognoz);
 add(label, BorderLayout.NORTH);
 buttonsPanel.add(calc);
 add(buttonsPanel, BorderLayout.SOUTH);
       TextField.add(text1);
       TextField.add(text2);
 add(TextField, BorderLayout.CENTER);
    
 initListeners();
    }

public void initListeners() {
// Добавляем listener для кнопки addCrow
// У объекта нет имени, поскольку используется только один раз.
      calc.addActionListener(new ActionListener()
// У класса также нет имени - анонимный внутренний класс.
{
@SuppressWarnings("empty-statement")
public void actionPerformed(ActionEvent e) {
   
    FileWriter fw = null;
    
        try {
            FileWriter filewr = null;
            
        int x = 0, y = 0;
        try {
            y = Integer.parseInt(text2.getText());
            x = Integer.parseInt(text1.getText());
        } catch (NumberFormatException e1) {
            JOptionPane.showMessageDialog(countLabel, "Некорректный ввод!");
        }
        balans = x - y ;
        // Возьмите файл
        File f = new File("ballans1.txt");
        fw = new FileWriter(f,true);
       FileReader fr = new FileReader(f);
        try {
            //Создайте новый файл
            // Убедитесь, что он не существует
            if (f.createNewFile())
                System.out.println("File created");
            else
            {
                System.out.println("File already exists");
                String str1 = Integer.toString(balans);
                fw.write(str1);
                fw.write("\n");
                fw.flush();
                fw.close();

                 BufferedReader bufr = new BufferedReader(fr);
                while(bufr.ready()){
                        int bal = Integer.parseInt(bufr.readLine());
                        i=i+bal;
                        updatechetchik(i,bal);
 
            }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null,ex);
        } finally {
        try {
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        }
       
       
    
              
}
);
}

//Обновляем chetcik
private void updatechetchik(int i,int bal) 
 {

       System.out.println(bal);
 countLabel.setText("бюджет: " + balans +"     ");
 prognoz.setText("прогноз на следующий месяц: " + balans * 1.01 );
 }
public static void main(String[] args) throws IOException {
Frame app = new Frame();
app.setVisible(true);
app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
app.pack(); 


}

} 
