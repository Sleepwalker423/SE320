/*
 * Author: Charles J. Walker
 * Date: 12/11/24
 * File Name: BMI_Server.java 
 * Purpose: This program is part 1 of 3 for Assignment 6 in SE320. It is designed to create a server that 
 * will recieve the height and weight of a client and return the calculated BMI.
 */
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class BMI_Server extends JFrame{
    //For displaying contents 
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) {
        new BMI_Server();
    }

    public BMI_Server(){
        //Places text area on the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        //Information used for the server's window
        setTitle("BMI Server");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            //Creates the server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("Server started at " + new Date() + "\n");
            
            //Listen for the connection request
            Socket socket = serverSocket.accept();

            //Creates the data input and output streams
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            while (true) { //This loop contains the portion that executes on the recieved information from the client. 
                //Get the weght and height from the client
                double height = inputFromClient.readDouble();
                double weight = inputFromClient.readDouble();
                //Compute BMI
                double bmi = weight / (height * height);
                //Send back the BMI result in a string form
                outputToClient.writeUTF("The BMI result of height "+ height +"m and weight "+ weight +"kg is %"+ bmi +" \n");

                jta.append("The weight received from the client: "+ weight +"\nThe height received from the client: "+ height +"\nThe BMI is: "+ bmi);

            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}