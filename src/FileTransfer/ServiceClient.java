/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileTransfer;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;
/**
 *
 * @author Farah Z
 */
public class ServiceClient implements Runnable {
    
    private Socket clientSocket;
    private BufferedReader in = null;

    public ServiceClient(Socket client) {
        this.clientSocket = client;
    }

    @Override
    public void run() {
        System.out.println("Hello from services");
        try {
            in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));
            String clientSelection;
            
            while ((clientSelection = in.readLine()) != null) {
                switch (clientSelection) {
                    case "1":
                        System.out.println("case 1");
                        receiveFile();
                        continue;
                    case "2":
                        System.out.println("case 2");
                        String outGoingFileName;
                        while ((outGoingFileName = in.readLine()) != null) {
                            sendFile(outGoingFileName);
                        }
			continue;
		    case "3":
			System.exit(1);	

                       break;
                    default:
                        System.out.println("Incorrect command received.");
                        break;
                }
               
            }

        } catch (IOException ex) {
          
        }
    }

    public void receiveFile() {
        try {
            int bytesRead;
             System.out.println("hello from receive");
            DataInputStream clientData = new DataInputStream(clientSocket.getInputStream());
            String fileName = clientData.readUTF();
            System.out.println("File name from received: "+fileName);
            FileOutputStream output = new FileOutputStream("C:\\Users\\Farah Z\\Desktop\\courses\\Third year 2020_2021\\OOP2\\Project\\DataReceived\\"+fileName);
            long size = clientData.readLong();
            byte[] buffer = new byte[1024];
            while (size > 0 && (bytesRead = clientData.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
                output.write(buffer, 0, bytesRead);
                size -= bytesRead;
            }

            output.close();
            clientData.close();

            System.out.println("File "+fileName+" received from client.");
        } catch (IOException ex) {
            System.err.println("Client error. Connection closed." +ex);
        }
    }

    public void sendFile(String fileName) {
        try {
           
            File myFile = new File(fileName);  //handle file reading
            byte[] mybytearray = new byte[(int) myFile.length()];

            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            DataInputStream dis = new DataInputStream(bis);
            dis.readFully(mybytearray, 0, mybytearray.length);

           
            OutputStream os = clientSocket.getOutputStream();  //handle file send over socket

            DataOutputStream dos = new DataOutputStream(os); //Sending file name and file size to the server
            dos.writeUTF(myFile.getName());
            dos.writeLong(mybytearray.length);
            dos.write(mybytearray, 0, mybytearray.length);
            dos.flush();
            System.out.println("File "+fileName+" sent to client.");
        } catch (Exception e) {
            System.err.println("File does not exist!");
        } 
    }
    
}
