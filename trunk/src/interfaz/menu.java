package interfaz;
import clases.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListModel;


import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterGroup;
import org.jivesoftware.smack.RosterListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.FormField;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.Occupant;

//import clases.usuario;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class menu extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel("com.jgoodies.looks.plastic.Plastic3DLookAndFeel");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private JButton conectar;
	private JButton desconectar;
	private JList listasalas;
	private JScrollPane barrasalas;
	private JPanel salas;
	private JTextField apodo;
	private JButton sala;
	private JLabel lbl_usuario;
	private JTextField usuario;
	private JList liscontactos;
	private JScrollPane barradesplazamiento;
	private JPanel contenedorcontactos;
	private JButton unir;
	private JTextField salafield;
	private JProgressBar conectando;
	private Usuario us1;
	private Sesion sesion;
	private String userID;
    private Roster roster;
  //  private sala sala1;
    //private manejadorSalas sala2;
   // private Room sala3;
	private Vector<contacto> vectorContactos;
    //private observadorEventos obsEventos;
	//private ventanasAbiertas ventanas;
    
	private Vector<String> lisSalasActivas;
	private String[] groups= new String[1];

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				menu inst = new menu();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public menu() {
		super();
		initGUI();
	//	ventanas = new ventanasAbiertas();
		
		
	}
	
	private void initGUI() {
		try {
			GroupLayout thisLayout = new GroupLayout((JComponent)getContentPane());
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("el chat mas poronga del mundo!!!");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosed(WindowEvent evt) {
					thisWindowClosed(evt);
				}
			});

			{
				conectar = new JButton();
				conectar.setText("conectar");
				conectar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						conectarActionPerformed(evt);
					}
				});

			}
			{
				conectando = new JProgressBar();
				conectando.setDoubleBuffered(true);
				conectando.setVisible(false);
			}
			{
				lbl_usuario = new JLabel();
				lbl_usuario.setText("Usuario");
				lbl_usuario.setFont(new java.awt.Font("Segoe UI",1,12));
			}
			{
				usuario = new JTextField();
				usuario.setText("");//aca el mail
			}

			{
				desconectar = new JButton();
				desconectar.setText("desconectar");
				desconectar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						desconectarActionPerformed(evt);
					}
				});

			}
			{
				unir = new JButton();
				unir.setText("unir");
				unir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						unirActionPerformed(evt);
					}
				});
			}
			{
				salafield = new JTextField();
				salafield.setText("sala");
			}
			{
				salas = new JPanel();
				{
					barrasalas = new JScrollPane();
					salas.add(barrasalas);
					barrasalas.setPreferredSize(new java.awt.Dimension(253, 156));
					{
						ListModel listasalasModel = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
						listasalas = new JList();
						barrasalas.setViewportView(listasalas);
						listasalas.setModel(listasalasModel);
						listasalas.setPreferredSize(new java.awt.Dimension(244, 153));
					}
				}
			}
			{
				apodo = new JTextField();
				apodo.setText("apodo");
			}
			{
				sala = new JButton();
				sala.setText("sala");
				sala.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						salaActionPerformed(evt);
					}
				});
			}
			{
				contenedorcontactos = new JPanel();
				contenedorcontactos.setBorder(BorderFactory.createCompoundBorder(
						null, 
						null));
				contenedorcontactos.setSize(300, 600);
				{
					barradesplazamiento = new JScrollPane();
					contenedorcontactos.add(barradesplazamiento);
					barradesplazamiento.setSize(750, 450);
					barradesplazamiento.setPreferredSize(new java.awt.Dimension(506, 382));
					{
						ListModel liscontactosModel = 
							new DefaultComboBoxModel(
									new String[] { "Item One", "Item Two" });
						liscontactos = new JList();
						barradesplazamiento.setViewportView(liscontactos);
						liscontactos.setModel(liscontactosModel);
						liscontactos.setSize(750, 450);
						liscontactos.setPreferredSize(new java.awt.Dimension(348, 332));
					}
				}
			}
			thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGroup(thisLayout.createParallelGroup()
				            .addComponent(usuario, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(conectar, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
				                .addGap(118))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addGroup(thisLayout.createParallelGroup()
				                    .addComponent(apodo, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				                    .addComponent(sala, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))
				                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				                .addComponent(salafield, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
				                .addGap(82))
				            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				                .addComponent(lbl_usuario, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
				                .addGap(135)))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(unir, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 6, Short.MAX_VALUE))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(conectando, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
				        .addGap(0, 31, Short.MAX_VALUE))
				    .addComponent(salas, GroupLayout.Alignment.LEADING, 0, 279, Short.MAX_VALUE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(contenedorcontactos, GroupLayout.PREFERRED_SIZE, 508, GroupLayout.PREFERRED_SIZE)
				        .addGap(23))
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addGap(401)
				        .addComponent(desconectar, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))));
			thisLayout.setVerticalGroup(thisLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				    .addComponent(lbl_usuario, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				    .addComponent(desconectar, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(thisLayout.createParallelGroup()
				    .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
				        .addComponent(usuario, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 92, GroupLayout.PREFERRED_SIZE)
				        .addComponent(conectar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(conectando, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addComponent(apodo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
				        .addGroup(thisLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(salafield, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(sala, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
				            .addComponent(unir, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				        .addComponent(salas, 0, 159, Short.MAX_VALUE))
				    .addComponent(contenedorcontactos, GroupLayout.Alignment.LEADING, 0, 388, Short.MAX_VALUE))
				.addContainerGap());
			pack();
			pack();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	

	
	
private void desconectarActionPerformed(ActionEvent evt) {
		conectar.setEnabled(true);
		contenedorcontactos.setVisible(false);
		sesion.salir();
		//us1.logout();
	}
	
	/*
private estadocontacto[] generarVistaContactos(Vector<contacto> lisCon){
	estadocontacto[] lisImagen= new estadocontacto[lisCon.size()];
	contacto a;
	 for (int i = 0; i < lisCon.size(); i++) {
	   a = lisCon.get(i);	
	   if (a.getColor()==1){
		   lisImagen[i]=new estadocontacto(a.getUser(),"conectado.png");
 	       }
	   else{
		   if (a.getColor()==2){
			   lisImagen[i]=new estadocontacto(a.getUser(),"ocupado.png");
	  	       }
		   else{
			   lisImagen[i]=new estadocontacto(a.getUser(),"desconectado.png");
		      }
		   }
	   }
	 return lisImagen;
}
		*/

private void conectarActionPerformed(ActionEvent evt) {
	
	conectando.setVisible(true);
	contenedorcontactos.setVisible(true);
	
	Thread t = new Thread(new Runnable() {
		public void run(){
	    try{
			conectar.setEnabled(false);
	    }
	    catch (Exception e){
	    	System.out.print("error de conexion");
	    }
			conectando.setIndeterminate(true);
			
	//		vectorContactos = new Vector<contacto>();
			lisSalasActivas = new Vector<String>();
			String server = "127.0.0.1";
			String user = usuario.getText();//"martinvizzolini@gmail.com";
	//		String pass = password.getText();//"";			
			userID = getUserId(user,"@");
			sesion = new Sesion(server);
			Usuario usu = new Usuario("fer","fer");
			sesion.acceder(usu);
	//		us1 = new Usuario(user,pass);			
	//		us1.loguin();
         	
		//	vectorContactos = us1.reloadPresencias();//necesito los contactos para el observador de eventos		
	//		roster = conexion.getRoster();
			
			
			//Create a Presence packet
			Presence presence = new Presence(Presence.Type.available);
			presence.setMode(Presence.Mode.available);
		  
			//Set a short message
			presence.setStatus("I'm all ears");
		
	
			
			/*roster.addRosterListener(new RosterListener(){

				@Override
				  public void entriesAdded(Collection addresses) {
	/*		          for (Iterator it = addresses.iterator(); it.hasNext();) {
			               String address = (String) it.next();
			               RosterEntry entry = conexion.getXMPP().getRoster().getEntry(address);
			               //When the entry is only from the other user, then send a subscription request
		//	               if (entry != null && entry.getType() == RosterPacket.ItemType.FROM) {
			                    try {
			                         System.out.println("Creating entry to: " + entry.getUser());
			                         conexion.getXMPP().getRoster().createEntry(entry.getUser(), entry.getUser(), new String[0]);
			                    } catch (XMPPException e) {
			                         e.printStackTrace();
			                    }
			//               }
			          }
			     }


				@Override
				public void entriesDeleted(Collection<String> arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void entriesUpdated(Collection<String> arg0) {
					// TODO Auto-generated method stub
					
				}
	

				@Override
				public void presenceChanged(Presence arg0) {
					System.out.print("dddddddddddd");
					// TODO Auto-generated method stub
		//			vectorContactos = us1.reloadPresencias();
				//	System.out.print(vectorContactos);
					
//					estadocontacto lisImagen[]=generarVistaContactos(vectorContactos);// = new estadocontacto[4];
	//			    liscontactos = new JList(lisImagen);
	//				liscontactos.setCellRenderer(new colorListEstados());
					barradesplazamiento.setViewportView(liscontactos);	
					liscontactos.setVisibleRowCount(4);
					liscontactos.setPreferredSize(new java.awt.Dimension(50, 290));
				    int max = vectorContactos.size();
			//		obsEventos = new observadorEventos(us1, ventanas); 
	//				obsEventos.crearObservador(vectorContactos, max);//crea un listener para q los contactos me hablen
					
					liscontactos.addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent evt) {
							if(evt.getClickCount()== 2){
								String destino = liscontactos.getSelectedValue().toString();//mail del destinatario
								String userDestino = getUserId(destino,"@");								
	//			 				nuevaVentana(userID,destino,userDestino);
						}	
					}
				  });	
				}
			}
	);*/
			//new chat(this,ventanasAbiertas,us1);
			conectando.setIndeterminate(false);
			conectando.setVisible(false);
		
			
		}}
	, "Thread Conectando");
	t.start();
}

@SuppressWarnings("deprecation")
/*public void nuevaVentana(String origen,String destino,String userDestino){
	chat v;
	if(ventanas.getVentana(userDestino)==null) {	
	      v = new chat(us1,origen,destino,userDestino,ventanas);
	   //	  ventanasAbiertas.add(userVentana);//agrego ventana al vector
	   	//  ventanas.put(userVentana,v);//agrego ventana a la hash
	  	  String titulo = destino;	
	  	  v.setTitle(titulo);	  	  
	  	  v.show();	  		       
          
	}
	else{
		v =  ventanas.getVentana(userDestino);
	  	v.show();
	}
}
*/

private String getUserId(String mailUser,String corte){
	String resul;
	String str=mailUser;
	if(str.contains(corte)){
		int pos=str.indexOf(corte);
		resul = str.substring(0,pos);
	}
	else{
		resul = mailUser;
	}
	return resul;
}


public void unirSala(String nombreSala) throws XMPPException{
	
//     sala3 = new Room(nombreSala,apodo.getText(),conexion.getXMPP());	
	// sala3.createRoom(apodo.getText());
	
	
}





	/************************************************************/

/*	sala2 = new manejadorSalas(conexion.getXMPP());
	    if(!sala2.RoomExist(nombreSala)){
	    	sala2.createRoom(nombreSala, false,false);
//	    	sala2.joinRoom(apodo.getText(), nombreSala);
	    }else{
	    	sala2.joinRoom(apodo.getText(), nombreSala);
	    }}
	*/
	/************************************************************/
		//sala1.join(apodo.getText(),99999999);
//	sala2 = new manejadorSalas(conexion.getXMPP());
//	sala2.createRoom(salafield.getText(),false,false);
	//Collection a = sala2.getRoomParticipants(nombreSala);
	//System.out.print(a);
	
	

	   /*
		try {
		//	sala1.join(apodo.getText(), 99999999);
		sala1.createRoom(apodo.getText());
		
		   }
		catch (XMPPException e) {
	/*		try {
				sala1.createRoom(nombreSala);
			} catch (XMPPException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			lisSalasActivas.add(nombreSala);
			cargarSalas();
			e.printStackTrace();		
	}*/
	
	
	
/*
	
MultiUserChat muc = new MultiUserChat(conexion.getXMPP(), nombreSala+"@conference.panther-pc");


if(!muc.isJoined())
{

try {
	muc.join(nombreSala);
} catch (XMPPException e) {
	muc.create(apodo.getText());
	// TODO Auto-generated catch block
	e.printStackTrace();
}               
}
/*
org.jivesoftware.smackx.Form form = muc.getConfigurationForm();
org.jivesoftware.smackx.Form submitForm = form.createAnswerForm();
for (Iterator fields = form.getFields(); fields.hasNext();) {
 FormField field = (FormField) fields.next();
 if (!FormField.TYPE_HIDDEN.equals(field.getType()) && field.getVariable() != null) {
   // Sets the default value as the answer
      submitForm.setDefaultAnswer(field.getVariable());
  }
}



submitForm.setAnswer("muc#roomconfig_persistentroom", true);
/*
try {
	muc.sendConfigurationForm(submitForm);
} catch (XMPPException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
*/
/*
if(subject != null)
{
muc.changeSubject(subject);
logger.debug("Changed room subject to " + subject);
}
*/	


private void cargarSalas(){
	
	/*vectorContactos = us1.reloadPresencias();
	estadocontacto lisImagen[]=generarVistaContactos(vectorContactos);// = new estadocontacto[4];
    liscontactos = new JList(lisImagen);
	liscontactos.setCellRenderer(new colorListEstados());
	barradesplazamiento.setViewportView(liscontactos);	
	liscontactos.setVisibleRowCount(4);
	liscontactos.setPreferredSize(new java.awt.Dimension(50, 290));
	
    */
	
	
//	String lisMostrar[]=lisSalasActivas;
	listasalas = new JList(lisSalasActivas);
	barrasalas.setViewportView(listasalas);
//	listasalas.setModel(listaSalasActivas);
	listasalas.setSize(750, 450);
	listasalas.setPreferredSize(new java.awt.Dimension(348, 332));
}

private void salaActionPerformed(ActionEvent evt){
//	System.out.println("sala.actionPerformed, event="+evt);
	try {
		unirSala(salafield.getText());
	//	Collection<Occupant> a = sala1.getParticipants();
		//System.out.print(a);
	} catch (XMPPException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private void unirActionPerformed(ActionEvent evt) {
	
/*	try {
		sala3 = new Room(salafield.getText(),apodo.getText(),conexion.getXMPP());	
		sala3.joinRoom(apodo.getText());
	} catch (XMPPException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	sala2 = new manejadorSalas(conexion.getXMPP());
	MultiUserChat muc = new MultiUserChat(conexion.getXMPP(), "sala@conference.panther-pc");
    try {
    	System.out.print("unirrrrr");
		sala2.getConfigFormRoom(muc);
	} catch (XMPPException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/

}

private void thisWindowClosed(WindowEvent evt) {
	System.out.println("this.windowClosed, event="+evt);
	//TODO add your code for this.windowClosed
	sesion.salir();
}

}




	