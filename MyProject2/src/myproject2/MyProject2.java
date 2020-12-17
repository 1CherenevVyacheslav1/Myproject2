/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myproject2;

import javafx.application.Application;import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.*;

public class Myproject2 extends JFrame 
{
    private int balans = 0;
    private JLabel countLabel;
    private JLabel prognoz;
    private JButton calc;
    private JTextField text1;
    private JTextField text2;

    public Myproject2() 
    {
       super("счетчик финансов"); // конструктор базового класса
       /* Подготавливаем компоненты объекта */
       countLabel = new JLabel("бюджет: " + balans + "     ");
       prognoz = new JLabel("прогноз на следующий месяц: " + balans);
       calc = new JButton("посчитать");
       text1 = new JTextField("введите доход",20);
       text2 = new JTextField("введите расходы",20);
       /* Подготавливаем временные компоненты */
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

 private void initListeners()
 {
  // Добавляем listener для кнопки acalc
  // У объекта нет имени, поскольку используется только один раз.
  calc.addActionListener(new ActionListener()
  // У класса также нет имени - анонимный внутренний класс.
   {
       public void actionPerformed(ActionEvent e) {
           int x = 0, y = 0;
           try 
           {
               y = Integer.parseInt(text2.getText());
               x = Integer.parseInt(text1.getText());
           }
           catch (NumberFormatException e1) 
           {
               JOptionPane.showMessageDialog(countLabel, "Некорректный ввод!");
           }
           balans = x - y ;
           updatechetchik();
       }
   }
  );
 }
//Обновляем бюджет
 private void updatechetchik() 
 {
     countLabel.setText("бюджет: " + balans+"     ");
     prognoz.setText("прогноз на следующий месяц:  " + balans * 1.01 );
 }
 public static void main(String[] args) throws IOException 
 {
     Myproject2 app = new Myproject2();
     app.setVisible(true);
     app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     app.pack(); /* оптим. размер в завис. от содержимого окна */
    /* File file = new File("ballanc.txt");
      if(!file.exists())
     {
         file.createNewFile();
        System.out.println("ФАЙЛ СОЗДАН");
         FileWriter filewr = new FileWriter(file);
         filewr.write(x);
     }
     else
     {
        System.out.println("ФАЙЛ существует");

     }*/
 }
}
   
