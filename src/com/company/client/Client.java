package com.company.client;

import java.net.Socket;
import java.io.*;

public class Client {

    private DataOutputStream outputStream;
    private BufferedReader bufferedReader;

    public Client() throws IOException {
        System.out.println("client is running");
        Socket socket = new Socket("localhost",6000);

        this.outputStream = new DataOutputStream(socket.getOutputStream());
        InputStream inputStream = socket.getInputStream();
        this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
    }

    //sending and read messages
    public void sendMessage(String message) throws IOException{
        System.out.println("Client: "+ message);
        this.outputStream.writeBytes(message+"\n");
        String dataFromServer = this.bufferedReader.readLine();
        System.out.println("server: "+dataFromServer);
    }
}
