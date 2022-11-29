import java.util.ArrayList;
import java.util.Random;

public class Jogador {
	private String nome; 
	private ArrayList<Integer> tentativa = new ArrayList<>();

	
	public Jogador(String n, ArrayList<Integer> tentativas) {
		nome = n;
		setTentativa(tentativa);
		this.tentativa = tentativa;
	}
	public Jogador() {
		
	}
	
	

	public ArrayList<Integer> getTentativa() {
		return tentativa;
	}
	public void setTentativa(ArrayList<Integer> tentativa) {
		this.tentativa = tentativa;
	}
	Random aleatorio = new Random();
	public String criaNome() {
		String n = "";
        char l;
        int num;
        num = aleatorio.nextInt(26)+ 65;
        l = (char)num;
        n += l;
        for(int i = 0; i < 19; i++) {
            num = aleatorio.nextInt(26) + 97;
            l = (char)num;
            n += l;
        }
        nome = n;
        return nome;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
} 