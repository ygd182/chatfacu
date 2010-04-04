

public class main {
//comentario del vizzo
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sesion ses = new Sesion("127.0.0.1");
		Usuario usu = new Usuario("fer","fer");
		ses.acceder(usu);
		for (int i = 0; i < 5; i++){
			for (int j = 0; j < 99999999; j++);
		}
		ses.unirSala("salon");
		for (int i = 0; i < 1089000; i++);
		System.out.print("Unido a salon...");
		for (int i = 0; i < 100; i++){
			for (int j = 0; j < 639999999; j++);
				System.out.print(100-i);
				System.out.print(".");
		}
		ses.salir();
		
	
		
		
		
		System.out.println("Fin de ejecución");
	}

}
