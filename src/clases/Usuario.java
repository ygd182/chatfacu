package clases;
import java.io.IOException;
import java.util.Vector;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;


public class Usuario {
	private String nombre;
	private String password;
	private XMPPConnection conexion;
	private String user;
	private String pass;
//	private Conversacion conversacion;
	//private Chat chat;
	//private Vector<contacto> vectorContactos;
	//private Roster roster;

	public Usuario(String nom, String pas){

		nombre = nom;
		password = pas;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	public String getPassowrd() {
		// TODO Auto-generated method stub
		return password;
	}
/*

public usuario(conexion conexion,String user, String pass){
	this.conexion = conexion;
	this.user = user;
	this.pass = pass;
	//vectorContactos = new Vector<contacto>();
	conversacion = new conversacion(this,chat);//cada vez que habra una ventana con un nuevo contacto deberia crearse este nuevo chat, ahora lo puse en el constructor
   }
*/
	/*
public void loguin(){
		try {
				conexion.login(user, pass);
			} catch (XMPPException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}
public void logout(){
	conexion.disconnect();
}*/
public String getUserMail(){
	return user;
}
/*
public void addContact(String nombreUsuario){
	if (conexion.isConected()) {				
		Roster lista = conexion.getRoster();	
		lista.setSubscriptionMode(Roster.SubscriptionMode.accept_all);
		try {
			lista.createEntry(nombreUsuario, "Mi Colega", new String[]{"Amigos"});
		} catch (XMPPException e) {
			e.printStackTrace();
		}
	}
}
public void mostrarListaContactos(){
	Roster lista = conexion.getRoster();
//	for (Collection<RosterEntry> i=lista.getEntries(); i.iterator().hasNext(); ) {
	//    System.out.println(i.iterator());

	System.out.println(lista);
  }


public String getRespuesta(){
	return conversacion.getRecibido();
}
public usuario getUser(){
	return this;
}


@SuppressWarnings("unchecked")
public Vector<contacto> reloadPresencias(){
	roster = conexion.getXMPP().getRoster();	
	vectorContactos = new Vector<contacto>();
	Collection<?> entries = roster.getEntries();
	Iterator i1 = entries.iterator();
    Presence p;
    contacto c;
	while(i1.hasNext())
	{
		c = new contacto();
		RosterEntry r = (RosterEntry) i1.next();
		p=roster.getPresence(r.getUser().toString());
		c.setName(r.getName());
		c.setUser(r.getUser());
		
		if(p.isAway()){
		
					c.setColor(2);
			        vectorContactos.add(c);
				}
		else{
		if(p.isAvailable()){
		
           c.setColor(1);
           vectorContactos.add(c);
   	}
		else{
		
			c.setColor(3);
	        vectorContactos.add(c);
		  }
		}
	}
//Collections.sort(vectorContactos);	
	
return vectorContactos;
}


@SuppressWarnings("unchecked")
public Collection getContactos() {
  
	   roster = conexion.getRoster();
	   Collection entries = roster.getEntries();

	 //  System.out.println("\n\n" + entries.size() + " contactos:");
	   Iterator i = entries.iterator();

	   while(i.hasNext())
	   {
		   RosterEntry r = (RosterEntry) i.next();
		   System.out.println(r.getUser());
		  
	   }

	return entries;

}
*/
}