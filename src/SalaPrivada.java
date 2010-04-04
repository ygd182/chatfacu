import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;


public class SalaPrivada extends Sala {
	private String password;
	public SalaPrivada(String nombreSala, XMPPConnection con, String pass){
		super(nombreSala,con);
		password = pass;
	}

	@Override
	public void unir(String apodo, String nombreSala, String password, XMPPConnection conexion)
			throws XMPPException {
		// TODO Auto-generated method stub
		
	}

}
