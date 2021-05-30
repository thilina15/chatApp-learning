package com.company.client;

import java.io.IOException;
import java.util.Scanner;

public class ChatClient3 {
    public static void main(String[] args) throws IOException {

        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        String clientInput="";

        //getting client inputs

        while (true){
            System.out.println("enter the message..");
            clientInput = scanner.nextLine();
            client.sendMessage(clientInput);
            if(clientInput.equals("exit")){
                break;
            }
        }
        System.out.println("application exit.");
    }
}
