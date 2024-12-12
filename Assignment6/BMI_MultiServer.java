/*
 * Author: Charles J. Walker
 * Date: 12/11/24
 * File Name: BMI_Server.java 
 * Purpose: This program is part 2 of 3 for Assignment 6 in SE320. It is designed to create a server that 
 * will create threads for multiple clients to connect to and recieve their calculated BMIs.
 */
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class BMI_MultiServer extends JFrame {
    //For displaying contents 
    private JTextArea jta = new JTextArea();

    public static void main(String[] args) {
        new BMI_MultiServer();
    }

    public BMI_MultiServer(){
        //Places text area on the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JScrollPane(jta), BorderLayout.CENTER);

        //Information used for the server's window
        setTitle("BMI_MultiServer");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        try {
            //Creates the server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            jta.append("Server started at " + new Date() + "\n");


            while (true) { //This loop contains the portion that creates new threads for each client. 
                Socket socket = serverSocket.accept();
                Server_Thread thread = new Server_Thread(socket);
                thread.start();
            }
            } catch (IOException e) {

                synchronized (jta) {
                    jta.append(e.getMessage());
                }

            } catch (IllegalThreadStateException te){
                synchronized (jta) {
                    jta.append(te.getMessage());
                }
        }

    }
    class Server_Thread extends Thread{
        private Socket socket;
    
        public Server_Thread(Socket socket){
    
            this.socket = socket;
    
        }
    
        @Override
        public void run(){
            try {
                //Creates the data input and output streams
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
    
                while (true) { //This loop contains the portion that executes on the recieved information from the client. 
                    //Get the weght and height from the client
                    synchronized (jta) {
                        jta.append("New client connected at "+ new Date() +"\n");
                    }
                    double height = inputFromClient.readDouble();
                    double weight = inputFromClient.readDouble();
                    //Compute BMI
                    double bmi = weight / (height * height);
                    //Send back the BMI result in a string form
                    outputToClient.writeUTF("The BMI result of height "+ height +"m and weight "+ weight +"kg is %"+ bmi +" \n");
    
                    synchronized (jta){

                        jta.append("The weight received from the client: "+ weight +"\nThe height received from the client: "+ height +"\nThe BMI is: "+ bmi +"\n");

                    }
                    //Close the streams and sockets once the thread has finished its task.
                    inputFromClient.close();
                    outputToClient.close();
                    socket.close();
                }
            } catch (IOException e) {

                System.err.println(e);

            }
        }
    
    }
}





