package com.company.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static boolean autoChant = false;

    public static void main(String[] args) throws IOException{
        System.out.println("server is running..");

        //set or disable auto chat
        System.out.printf("Do you want to Enable auto chat mode? .. (type 'yes' to enable, leave it to disable auto chat..)");
        Scanner scanner = new Scanner(System.in);
        String serverReturn = scanner.nextLine();
        if(serverReturn.equals("yes")){
            autoChant = true;
        }

        //creating the server
        ServerSocket serverSocket = new ServerSocket(6000);
        System.out.println("server socket created...");

        //running forever
        while (true){
            Socket client = serverSocket.accept();//wait until a client connects
            System.out.println("server accepted a client..");

            ClientHandler clientHandler = new ClientHandler(client,autoChant);
            Thread thread = new Thread(clientHandler);
            thread.start();

        }


    }
}
