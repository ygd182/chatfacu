package clases;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.jivesoftware.smackx.muc.RoomInfo;



public abstract class Sala {
	protected MultiUserChat muc;
	protected XMPPConnection conexion = null;
	protected String nombre;
	
	protected boolean existeSala(String nombreSala){
		RoomInfo info = null;
		try {
			info = MultiUserChat.getRoomInfo(conexion, nombreSala+"@conference.servidorchatpoo");
		} catch (XMPPException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		if (info==null)
			return false;
		else
			return true;
	}
	
	
	
	public Sala(String nombreSala, XMPPConnection con){
		conexion = con;
		nombre = nombreSala;
		muc = new MultiUserChat(conexion,nombre);
	}
	//método abstracto, si es pública solo necesita el nombre, si no necesitará el passwotd también
	public abstract void unir(String apodo, String nombreSala, String password, XMPPConnection conexion) throws XMPPException;

}
