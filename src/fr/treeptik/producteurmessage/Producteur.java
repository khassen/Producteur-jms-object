package fr.treeptik.producteurmessage;

import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.InitialContext;

public class Producteur {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {

//		il va lire dans le fichier properties, aprés il va chercher dans la jndi le fil de message
		
		InitialContext context = new InitialContext();
		Queue queue = (Queue) context.lookup("queue/test");
		
		QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("ConnectionFactory");
//		par defaut ici pas securisé , pas de user et password
		QueueConnection connection =  factory.createQueueConnection();
		QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
//		ici on a creer un sender avec session. mais on peut creer aussi un consomateur
		QueueSender sender = session.createSender(queue);
		
//       on envoi un message text, ca peut etre de xml
//		TextMessage message = session.createTextMessage("Hello JMS");
//		sender.send(message);
		
		
		Produit produit = new Produit(1, "produit1","produitdesc");
		
		ObjectMessage message = session.createObjectMessage(produit);
		sender.send(message);
		
		session.close();
		connection.close();
		System.out.println("Message envoyé");
	}

}
