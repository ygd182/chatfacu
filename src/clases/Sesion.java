package clases;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;

public class Sesion {
	private XMPPConnection conexion;
	private String servidor;
	private Usuario usuario;
	
	public Sesion(String ser)
	{
		servidor = ser;
		conexion = new XMPPConnection(servidor);
		try {
			conexion.connect();
			System.out.println("Conectado al servidor");

		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void acceder(Usuario usu){
		String nombre = usu.getNombre();
//		usuario = new Usuario(nombre,nombre);
		try {
			conexion.getAccountManager().createAccount (nombre,nombre);
			System.out.println("Usuario creado");
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		System.out.println("Usuario ok");
		System.out.print("Accediendo...");

		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 99999999; j++);
				System.out.print("."+(5-i));
		}
		try {
			conexion.login(nombre,nombre);
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		System.out.println("");

		System.out.println("Usuario accedido");
	}
		
	public void salir(){
		try {
			conexion.getAccountManager().deleteAccount();
			System.out.println("Usuario borrado");

		} catch (XMPPException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void unirSala(String nom)
	{
		Sala sala = new SalaPublica(nom,conexion);
		for (int i = 0; i < 10; i++){
			for (int j = 0; j < 99999999; j++);
				System.out.print(".");
		}
		try {
			sala.unir(usuario.getNombre(),nom,"", conexion);
		} catch (XMPPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
