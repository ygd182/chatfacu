import java.util.Iterator;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.Form;
import org.jivesoftware.smackx.muc.MultiUserChat;


public class SalaPublica extends Sala {

	
	public SalaPublica(String nombreSala, XMPPConnection con){
		super (nombreSala, con);
	}
	@Override
	public void unir(String apodo, String nombreSala, String password, XMPPConnection conexion) throws XMPPException {
		// TODO Auto-generated method stub
		muc = new MultiUserChat(conexion, nombreSala+"@conference.servidorchatpoo");
		//solo se envía el nombre de la sala para unirse
		if(!existeSala(nombreSala)){
		    muc.create("fer@conference.servidorChatPoo");
		    Form form = muc.getConfigurationForm();
		    Form submitForm = form.createAnswerForm();
		    submitForm.setAnswer("muc#roomconfig_membersonly", false);
		    submitForm.setAnswer("muc#roomconfig_publicroom", true);
		    muc.sendConfigurationForm(submitForm);
		    System.out.println("sala no existia, creada");
		    
		}
		
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 99999999; j++);
		}
		
        //Iterator<String> i = muc.getOccupants();
        //System.out.print(i);

       // this.chatroomsDictionary.put(room, chatRoom);
        muc.join(apodo);        
       // getConfigFormRoom(muc);
    	//String a = chatRoom.getRoom();		
		//System.out.print(a); 
	    }


}