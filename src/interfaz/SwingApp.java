package interfaz;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import clases.Sesion;


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
public class SwingApp extends javax.swing.JFrame {

	private JMenuItem helpMenuItem;
	private JMenu jMenu5;
	private JPanel jPanel1;
	private JMenuItem deleteMenuItem;
	private JSeparator jSeparator1;
	private JMenuItem pasteMenuItem;
	private JMenuItem copyMenuItem;
	private JMenuItem cutMenuItem;
	private JMenu jMenu4;
	private JMenuItem exitMenuItem;
	private JSeparator jSeparator2;
	private JMenuItem closeFileMenuItem;
	private JMenuItem logoutItem;
	private JMenuItem loginItem;
	private JMenuItem servidorItem;
	private JMenu jMenu3;
	private JMenuBar jMenuBar1;
	private frm_servidor frm_servidor;
	private login user;
	private JDialog d1;
	private Sesion sesion;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SwingApp inst = new SwingApp();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
				inst.setPreferredSize(new java.awt.Dimension(450, 450));
				inst.setTitle("ProChat2010");
			}
		});
	}
	
	public SwingApp() {
		super();
		initGUI();
	//	frm_servidor = new frm_servidor();
		
	}
	
	private void initGUI() {
		try {
			{
				this.setPreferredSize(new java.awt.Dimension(450, 250));
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, BorderLayout.CENTER);
			}
			{
				jMenuBar1 = new JMenuBar();
				setJMenuBar(jMenuBar1);
				{
					jMenu3 = new JMenu();
					jMenuBar1.add(jMenu3);
					jMenu3.setText("Menu");
				
					{
						servidorItem = new JMenuItem();
						jMenu3.add(servidorItem);
						servidorItem.setText("Servidor");
						
					}
					{
						loginItem = new JMenuItem();
						jMenu3.add(loginItem);
						loginItem.setText("LogIn");
					}
					{
						logoutItem = new JMenuItem();
						jMenu3.add(logoutItem);
						logoutItem.setText("LogOut");
						logoutItem.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								logoutItemActionPerformed(evt);
							}
						});
					}
					{
						closeFileMenuItem = new JMenuItem();
						jMenu3.add(closeFileMenuItem);
						closeFileMenuItem.setText("Close");
					}
					{
						jSeparator2 = new JSeparator();
						jMenu3.add(jSeparator2);
					}
					{
						exitMenuItem = new JMenuItem();
						jMenu3.add(exitMenuItem);
						exitMenuItem.setText("Exit");
					}
					servidorItem.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e)
								{
									 frm_servidor = new frm_servidor();									 
									 frm_servidor.nuevo();
					//				 if(frm_servidor.isServidorActivo()){
						//				 servidorItem.setEnabled(false);
							//			 loginItem.setEnabled(true);
								//	 }
							//		 frm_servidor.nuevo();
									
						
								}
							}
						);
					
					loginItem.addActionListener(
							new ActionListener(){
								public void actionPerformed(ActionEvent e)
								{
									 sesion = frm_servidor.getSesion();
									 System.out.println("sesion4: "+sesion);
									 user =  new login(sesion);									 
									 user.show();
						
								}
							}
						);
				}
				{
					jMenu4 = new JMenu();
					jMenuBar1.add(jMenu4);
					jMenu4.setText("Edit");
					{
						cutMenuItem = new JMenuItem();
						jMenu4.add(cutMenuItem);
						cutMenuItem.setText("Cut");
					}
					{
						copyMenuItem = new JMenuItem();
						jMenu4.add(copyMenuItem);
						copyMenuItem.setText("Copy");
					}
					{
						pasteMenuItem = new JMenuItem();
						jMenu4.add(pasteMenuItem);
						pasteMenuItem.setText("Paste");
					}
					{
						jSeparator1 = new JSeparator();
						jMenu4.add(jSeparator1);
					}
					{
						deleteMenuItem = new JMenuItem();
						jMenu4.add(deleteMenuItem);
						deleteMenuItem.setText("Delete");
					}
				}
				{
					jMenu5 = new JMenu();
					jMenuBar1.add(jMenu5);
					jMenu5.setText("Help");
					{
						helpMenuItem = new JMenuItem();
						jMenu5.add(helpMenuItem);
						helpMenuItem.setText("Help");
					}
				}
			}
			iniciar_Itemns();
			pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public JDialog getDialog(){
    	return d1;
    }
	
	private void logoutItemActionPerformed(ActionEvent evt) {
	//	if(JOptionPane.showConfirmDialog(null, "El usuario: " ++ " abandonara el chat", "Roseindia.net", JOptionPane.OK_CANCEL_OPTION) == 0){
	//			          JOptionPane.showMessageDialog(null, "Gracias por usar ChatPro2010",
	//			 "Confirmacion", 1);
				        
		sesion.salir();
		//}
	}
    private void iniciar_Itemns(){
    //	loginItem.setEnabled(false);
    //	logoutItem.setEnabled(false);
    	
    }
    
    public void actualizar_menu() {
    	if(servidorItem.isEnabled()== false){
    		loginItem.setEnabled(true);
        	logoutItem.setEnabled(true);
    	}
    	
    }
}
