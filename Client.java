import java.net.*;
import java.io.*;
import java.util.*;

class Client{
	public static void main(String args[]){
		try{
			Scanner sc=new Scanner(System.in);
			Socket s=new Socket("localhost",1234);
			System.out.println("Connected to server:\nEnter Message:");
			DataOutputStream dos=new DataOutputStream(s.getOutputStream());
			
			String a=sc.nextLine();
			dos.writeBytes(a);
			System.out.println("Message Sent");
			dos.close();
			s.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
}