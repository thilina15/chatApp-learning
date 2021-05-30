package com.company.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{

    private Socket client;
    private boolean autoChat;


    public ClientHandler(Socket socket , boolean autoChat)
    {
        this.client = socket;
        this.autoChat = autoChat;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000); // wait 30 seconds

            //get data from client
            InputStream inputStream = client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            String serverInput ="";

            //continuous reading data from client
            String inputData;
            while ((inputData=bufferedReader.readLine())!=null){

                System.out.println("Client:- "+inputData);


                if (autoChat){
                    //auto chat bot
                    switch (inputData){
                        case "hello from the client":
                            outputStream.writeBytes("hello from the server..\n");
                            break;
                        case "how are you":
                            outputStream.writeBytes("im fine, and how are you..\n");
                            break;
                        case "i'm fine":
                            outputStream.writeBytes("okay good to know..\n");
                            break;
                        case "thank you":
                            outputStream.writeBytes("you are welcome..\n");
                            break;
                        case "exit":
                            outputStream.writeBytes("good bye..\n");
                            break;
                        default:
                            outputStream.writeBytes("I didn't understand you\n");
                    }
                }else {
                    //using scanner class
                    System.out.println("enter message..");
                    serverInput = scanner.nextLine();
                    outputStream.writeBytes(serverInput+"\n");
                }

                if (inputData.equals("exit")){
                    break;
                }
            }
            this.client.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }
}
