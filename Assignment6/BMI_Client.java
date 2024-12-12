/*
 * Author: Charles J. Walker
 * Date: 12/11/24
 * File Name: BMI_Client.java 
 * Purpose: This program is part 1 & 2 of 3 for Assignment 6 in SE320. It is designed to create a client program that requests
 * the users height and weight, sends it to the server, and then displays the BMI results.
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class BMI_Client extends JFrame implements ActionListener {
    //Text field for receiving BMI
    private JTextField jtf = new JTextField();

    //Text area to display contents
    private JTextArea jta = new JTextArea();

    //IO Streams
    private DataOutputStream outputToServer;
    private DataInputStream inputFromServer;

    public static void main(String[] args) {
        new BMI_Client();
    }

    public BMI_Client(){
        //Panel p holds the label and text field
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(new JLabel("Press enter to be prompted for you height and weight."), BorderLayout.WEST);
        p.add(jtf, BorderLayout.CENTER);
        jtf.setHorizontalAlignment(JTextField.RIGHT);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(p, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        jtf.addActionListener(this);//Register the listener

        setTitle("BMI_Client");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);//This is needed to show the frame

        try {
            //Creates the socket to connect to the server
            Socket socket = new Socket("192.168.1.94", 8000);
            //Create an input stream to receive data from the server
            inputFromServer = new DataInputStream(socket.getInputStream());

            //Create an output stream to send data to the server
            outputToServer = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            jta.append(e.toString() + "\n");
        }
    }
    public void actionPerformed(ActionEvent ae){
        String actionCommand = ae.getActionCommand();
        if (ae.getSource() instanceof JTextField) {
            try {
                //get the height and weight from the client
                //Each JOptionPane.showInputDialog will prompt the user for the height and weight through a dialog box
                //This was done to work around the the need for multiple text fields.
                double height = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter your height in meters:", "Input height", JOptionPane.QUESTION_MESSAGE));
                double weight = Double.parseDouble(JOptionPane.showInputDialog(this, "Enter your weight in kilograms:", "Input weight", JOptionPane.QUESTION_MESSAGE));

                //Send the height and weight to the server
                outputToServer.writeDouble(height);
                outputToServer.flush();//This flush clears the buffer for the next write
                outputToServer.writeDouble(weight);

                //Get BMI string from server
                String results = inputFromServer.readUTF();

                //Display the results in the test area
                jta.append(results + "\n");

            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}


