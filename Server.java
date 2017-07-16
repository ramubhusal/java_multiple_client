import java.net.*;
import java.io.*;

class Thrd extends Thread{
	Socket s=null;
	public Thrd(Socket ss){
		s=ss;
	}
	public void run(){
		try{
			DataInputStream dis=new DataInputStream(s.getInputStream());
			int i;
			System.out.println("Message");
			while((i=dis.read())!=-1){
				System.out.print((char)i);
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}

class Server{
	public static void main(String args[]){
		try{
			ServerSocket ss=new ServerSocket(1234);
			System.out.println("Waiting:");
			while(true){
				Socket s=ss.accept();
				System.out.println("\nConnected To Client:");
				Thrd th=new Thrd(s);
				th.start();
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}