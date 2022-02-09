/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileTransfer;



import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Farah Z
 */
public class FileClient {
    
     private static Socket sock;
    private static String fileName;
    private static String fileToSave;
    private static BufferedReader stdin;
    private static PrintStream os;
    
    
    public static void runClient (int selection, String filename, String fileToSave) throws IOException{
//           while(true) {
        try {
            sock = new Socket("localhost", 25444);
            stdin = new BufferedReader(new InputStreamReader(System.in));
            
             os = new PrintStream(sock.getOutputStream());
             
              if ( selection == 1)
            {
                 os.println("1");
                sendFile(filename);
            }
            else {
                if( selection == 2)
                {
                    os.println("2");
                     os.println(filename);
                       receiveFile(filename,fileToSave);
                }
            }
              
              
        } catch (Exception e) {
            System.err.println("Cannot connect to the server, try again later.");
           // System.exit(1);
        }

       
//        this.fileName = filename;
//        this.fileToSave = fileToSave;


//            if ( selection == 1)
//            {
//                 os.println("1");
//                sendFile(filename);
//            }
//            else {
//                if( selection == 2)
//                {
//                    os.println("2");
//                     os.println(filename);
//                       receiveFile(filename,fileToSave);
//                }
//            }
//        try {
//              switch (selection) {
//            case 1:
//                os.println("1");
//                sendFile(filename);
//                break;
////                continue;
//            case 2:
//                os.println("2");
////                System.out.print("Enter file name: ");
////                fileName = stdin.readLine();
//                os.println(filename);
//                receiveFile(filename,fileToSave);
////                continue;
//	   case 3:
//		 sock.close();
//		//System.exit(0);
//        }
//        } catch (Exception e) {
//            System.err.println("not valid input "+e);
//        }
//    }

}
    
    
//    public static int  start(int selection, String fileName, String fileToSave ) throws IOException
//    {
//        
//
//        os = new PrintStream(sock.getOutputStream());
//
//        try {
//              switch (selection) {
//            case 1:
//                os.println("1");
//                int i  =sendFile(fileName,fileToSave);
//                if(i == -1) return -1;
//                //else return 1;
//                
////                sock.close();
//		//System.exit(1);
//            case 2:
//                os.println("2");
////                System.out.print("Enter file name: ");
////                fileName = stdin.readLine();
//                os.println(fileName);
//                int j = receiveFile(fileName,fileToSave);
//                if(j == -1) return -1;
//                //else return 1;
////                sock.close();
//	   case 3:
//		 sock.close();
//		//System.exit(1);
//        }
//        } catch (Exception e) {
//            System.err.println("not valid input");
//        }
//        return 1 ;
//
//    }



    public static int sendFile(String fileName) throws IOException {
        
            try {
                    System.out.print("Enter file name: ");
                    //fileName = stdin.readLine();

                    File myFile = new File(fileName);
                    byte[] mybytearray = new byte[(int) myFile.length()];
                    if(!myFile.exists()) {
                        System.out.println("File does not exist..");
                        return -1 ;
                    }

            FileInputStream fis = new FileInputStream(myFile);
            BufferedInputStream bis = new BufferedInputStream(fis);
            //bis.read(mybytearray, 0, mybytearray.length);

            DataInputStream dis = new DataInputStream(bis);
            dis.readFully(mybytearray, 0, mybytearray.length);
		
            OutputStream os = sock.getOutputStream();

            //Sending file name and file size to the server
            DataOutputStream dos = new DataOutputStream(os);
//            System.out.println(myFile.getName());
            dos.writeUTF(myFile.getName());
            dos.writeLong(mybytearray.length);
            dos.write(mybytearray, 0, mybytearray.length);
            dos.flush();
//            fis.close();
//            dos.close();
            System.out.println("File "+fileName+" sent to Server.");
        } catch (Exception e) {
            System.out.println("Exceptionnnn: "+e);
            //return 1;
        }

//                    try { 
//                    File myFile = new File(fileName);
//                    byte[] mybytearray = new byte[(int) myFile.length()];
//                    //System.out.println(fileToSave);
//                    if(!myFile.exists()) {
//                        System.out.println("File does not exist..");
//                        return -1;
//                    }
//
//            FileInputStream fis = new FileInputStream(myFile);
//            BufferedInputStream bis = new BufferedInputStream(fis);
//            //bis.read(mybytearray, 0, mybytearray.length);
//
//            DataInputStream dis = new DataInputStream(bis);
//            dis.readFully(mybytearray, 0, mybytearray.length);
//		
//            OutputStream os = sock.getOutputStream();
//
//            //Sending file name and file size to the server
//            DataOutputStream dos = new DataOutputStream(os);
//            
//            System.out.println(myFile.getName());
//            dos.writeUTF(myFile.getName());
//            //dos.writeUTF(fileToSave);
//            dos.writeLong(mybytearray.length);
//            dos.write(mybytearray, 0, mybytearray.length);
//            dos.flush();
//            System.out.println("File "+fileName+" sent to Server.");
//            
//            
//            dos.close();
//            fis.close();
////            sock.close();
//            return 1;
//        } catch (Exception e) {
//            System.err.println("Exceptionnnn: "+e);
//            return -1;
//        }
        return 1;
    }


    public static int receiveFile(String fileName, String fileToSave) throws IOException{

        try {
            int bytesRead;
            InputStream in = sock.getInputStream();

            DataInputStream clientData = new DataInputStream(in);

            fileName = clientData.readUTF();
            
            OutputStream output = new FileOutputStream(fileToSave);
            long size = clientData.readLong();
            byte[] buffer = new byte[1024];
            while (size > 0 && (bytesRead = clientData.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
                output.write(buffer, 0, bytesRead);
                size -= bytesRead;
            }

            output.close();
            in.close();
            clientData.close();
//            sock.close();

            System.out.println("File "+fileName+" received from Server.");
            return 1;
        } catch (IOException ex) {
		System.out.println("Exception: "+ex);
                return -1;
         }
}
    
}
    

