// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package Server;

import java.io.*;
import java.util.Vector;

import logic.Reservation;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */

public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  //final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   * 
   */
	 
	mysqlConnection msq = new mysqlConnection();
	Reservation [] res = new Reservation [4];
  public EchoServer(int port) 
  {
    super(port);
  }

  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   * @param 
   */
  public void handleMessageFromClient  (Object msg,ConnectionToClient client)
  {
	 System.out.println("Message received: " + msg+" from " + client);
	 String st;
	 st=msg.toString();
	 String[] result = st.split("\\s");
	 msq.setMsg(result[0]);
	 msq.setMsg1(result[1]);
	 msq.getDetails();
	 res = msq.getres();
	 int flag=0;
	    for(int  i=0;i<4;i++) {
			if(res[i].getReservation_num().equals(result[0]))
			{ 
				System.out.println("Server Found");
				this.sendToAllClients(res[i].toString());
				flag=1;
			}
		
		}
	    if (flag!=1) {
			System.out.println("Not Found");
			this.sendToAllClients("Error");
		}        
	 }
   
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
	  System.out.println("Server listening for connections on port " + getPort());
     
  }
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()  {
    System.out.println ("Server has stopped listening for connections.");
  }  
}
//End of EchoServer class
