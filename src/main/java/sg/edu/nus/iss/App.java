package sg.edu.nus.iss;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {
        String portNumber="";
        String fileName = "";
            if (args.length>0){
                portNumber = args[0];
                fileName = args[1];
            }else{
                System.out.println("You have not entered any arguments so port 12345 and cookie.txt will be used by default");
                portNumber = "12345";
                fileName = "cookie.txt";
            }

        //test the cookie class
        Cookie cookie = new Cookie();
        cookie.readCookieFile(fileName);
        String myCookie = cookie.getRandomCookie();
        System.out.println(myCookie);
        

        ServerSocket server = new ServerSocket(Integer.parseInt(portNumber));
        Socket socket = server.accept();

        //store message sent from client, e.g. get-cookie
        String msgReceived = "";
        
        try (InputStream is = socket.getInputStream()){
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            String line = dis.readUTF();

            while (!msgReceived.equals("close")){
                //instantiate cookie.java
                //get a random cookie

                String randomCookie = cookie.RandomCookie();

            }
        }


    }
}
