package interfaz;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import clases.Sesion;

public class frm_servidor extends JPanel {
    
	  
	static JFrame frame;
	private JTextField fieldservidor;
	private JButton jButtonconectar;
    private  JRadioButton b1; 
    private JRadioButton b2;
    private String server = "127.0.0.1";
    private boolean servidor = false;
    private static JDialog d1;
    private SwingApp s1;
    private JMenuItem servidorItem;
    JLabel jlbPicture;
    private boolean servidorActivo;
    private frm_servidor a;
    private Sesion sesion;
    private login nuevo_user;
    RadioListener myListener = null;
    public frm_servidor() {
     	// Create the radio buttons and assign Keyboard shortcuts using Mnemonics

        b1 = new JRadioButton("Servidor Local");
        GroupLayout b1Layout = new GroupLayout((JComponent)b1);
        b1.setLayout(b1Layout);
        b1Layout.setHorizontalGroup(b1Layout.createSequentialGroup());
        b1Layout.setVerticalGroup(b1Layout.createSequentialGroup());
        b1.setActionCommand("local");

        b2 = new JRadioButton("Servidor Externo");
        GroupLayout b2Layout = new GroupLayout((JComponent)b2);
        b2.setLayout(b2Layout);
        b2Layout.setHorizontalGroup(b2Layout.createSequentialGroup());
        b2Layout.setVerticalGroup(b2Layout.createSequentialGroup());
        b2.setActionCommand("server");

        // Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(b2);
        group.add(b1);

        // Register an action listener for the radio buttons.
        myListener = new RadioListener();
        b1.addActionListener(myListener);
        b2.addActionListener(myListener);


        // Set up the picture label
        GroupLayout thisLayout = new GroupLayout((JComponent)this);
        this.setLayout(thisLayout);
        jlbPicture = new JLabel(new ImageIcon(""+"numbers" + ".png"));			//Set the Default Image

        // Put the radio buttons in a column in a panel
        JPanel jplRadio = new JPanel();
        GroupLayout jplRadioLayout = new GroupLayout((JComponent)jplRadio);
        jplRadio.setLayout(jplRadioLayout);
        	jplRadioLayout.setVerticalGroup(jplRadioLayout.createSequentialGroup()
        		.addContainerGap()
        		.addComponent(b1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        		.addComponent(b2, 0, 25, Short.MAX_VALUE));
        	jplRadioLayout.setHorizontalGroup(jplRadioLayout.createParallelGroup()
        		.addComponent(b1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
        		.addComponent(b2, GroupLayout.Alignment.LEADING, 0, 207, Short.MAX_VALUE));

        jlbPicture.setSize(120, 120);
        {
        	jButtonconectar = new JButton();
        	jButtonconectar.setText("Conectar");
        	jButtonconectar.setEnabled(false);
        	jButtonconectar.addActionListener(new ActionListener() {
        		public void actionPerformed(ActionEvent evt) {
        			jButtonconectarActionPerformed(evt);
        		}
        	});
        }
        {
        	fieldservidor = new JTextField();
        	fieldservidor.setText("www.talk.google.com");
        	fieldservidor.setEnabled(false);
        }
        thisLayout.setVerticalGroup(thisLayout.createParallelGroup()
        	.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
        	    .addComponent(jlbPicture, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
        	    .addGap(0, 11, Short.MAX_VALUE))
        	.addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
        	    .addComponent(jplRadio, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
        	    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        	    .addComponent(fieldservidor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        	    .addGap(20)
        	    .addComponent(jButtonconectar, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)));
        thisLayout.setHorizontalGroup(thisLayout.createSequentialGroup()
        	.addContainerGap()
        	.addGroup(thisLayout.createParallelGroup()
        	    .addComponent(jplRadio, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
        	    .addGroup(thisLayout.createSequentialGroup()
        	        .addGap(23)
        	        .addGroup(thisLayout.createParallelGroup()
        	            .addComponent(fieldservidor, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
        	            .addGroup(GroupLayout.Alignment.LEADING, thisLayout.createSequentialGroup()
        	                .addComponent(jButtonconectar, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
        	                .addGap(48)))))
        	.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
        	.addComponent(jlbPicture, 0, 133, Short.MAX_VALUE));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    //    this.setPreferredSize(new java.awt.Dimension(410, 160));
        
        
        
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);
    }

    /** Listens to the radio buttons. */
    class RadioListener implements ActionListener { 
        public void actionPerformed(ActionEvent e) {
        	jButtonconectar.setEnabled(true);
        	jlbPicture.setIcon(new ImageIcon(""+e.getActionCommand() 
                    + ".png"));
        	if (e.getActionCommand() == "local"){
        	    accion1();
        	}else{accion2();}
            
        }
    }
    public void accion1(){
    	fieldservidor.setEnabled(false);
    	server = "127.0.0.1";
    	servidor = false;
    
    }
    public void accion2(){
    	fieldservidor.setEnabled(true);    	
    	servidor = true;
    }
    public static void main(String s[]) {
    	
    	
    	/*System.out.print("dddddd");
    	 frm_servidor a = new frm_servidor();
		 a.show(true);

		 d1 = new JDialog();
		 d1.add(a);
		 d1.setSize(486, 262);
		 d1.setTitle("Servidor");
	     d1.show();*/
   //      frm_servidor frame = new frm_servidor();
    //     frame.addWindowListener(new WindowAdapter() {
     //        public void windowClosing(WindowEvent e) {System.exit(0);}
       //  });
     //    JDialog d1 = new JDialog();
 //   	JFrame d1 = new JFrame();
     //    frame.getContentPane().add(new frm_servidor(), BorderLayout.CENTER);
      //   frame.pack();
   //      frame.setVisible(true);
   //      d1.add(frame);
     //    frame.setTitle("Servidores");
     //    d1.show();
    }
    
    private void jButtonconectarActionPerformed(ActionEvent evt) {

    	if(servidor){server = fieldservidor.getText();}
    	sesion = new Sesion(server);
    	if(sesion.isConectado()){
    		JOptionPane.showMessageDialog(d1, "Conexion Realizada con Exito!!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    		d1.dispose();
    		servidorActivo =  true;
    		
		}else{
			JOptionPane.showMessageDialog(d1, "El servidor no puede responder a su solicitud..", "Error", JOptionPane.ERROR_MESSAGE);
			servidorActivo = false;
		}
		
		
		
	//	sesion = frm_servidor.getSesion();
		// System.out.println("sesion4: "+sesion);
	//	 nuevo_user =  new login(sesion);									 
	//	 nuevo_user.show();
	//	nuevo_user = new login(sesion);
	//	nuevo_user.show();
	//	d1.remove(a);
	//	d1.add(nuevo_user);
    }
    
    
    public void nuevo(){
      //    a = new frm_servidor();
 //   	  nuevo_user = new login(sesion);
          this.setVisible(true);          
	 	  d1 = new JDialog();
	 	  d1.add(this);
	//	  d1.add(nuevo_user);
	 	  d1.setSize(486, 262);
		  d1.setTitle("Servidor");
	      d1.show(true);
    }
    public Sesion getSesion(){
    	System.out.print("sesion: "+sesion);
    	return sesion;
    }
	public void setServidorActivo(boolean servidorActivo) {
		this.servidorActivo = servidorActivo;
	}
	public boolean isServidorActivo() {
		return servidorActivo;
	}
}

