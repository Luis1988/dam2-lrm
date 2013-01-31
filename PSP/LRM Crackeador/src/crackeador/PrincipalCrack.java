package crackeador;

public class PrincipalCrack {
	
	public static void main(String[] args){
		CrackDiccionario cd;
		if(args.length < 2){
			cd = new CrackDiccionario("listaUsuarios.txt", "listaPasswords.txt");
		}
		else if(args.length == 2){
			cd = new CrackDiccionario(args[0], args[1]);
		}
		else if(args.length == 3){
			cd = new CrackDiccionario(args[0], args[1], args[2]);
		}
		else if(args.length == 4){
			cd = new CrackDiccionario(args[0], Integer.parseInt(args[1]), args[2], args[3]);
		}
		else if(args.length == 5){
			cd = new CrackDiccionario(args[0], Integer.parseInt(args[1]), args[2], args[3], args[4]); 
		}
	}

}
