import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class Controle {
	private int interI, interF, numSorteado;
	Random r = new Random();
	public Controle( int ii, int inf) {
		
		interI = ii;
		interF = inf;  
	}
    
	public void iniciaJogo() {
		try (Scanner dado = new Scanner(System.in)) {
			int qtdJogador = 0, interInicial = 0, interFinal = 0, tentativa = 0;
			
			ArrayList < Jogador > lista = new  ArrayList <>();
			ArrayList < Integer > lista1 = new  ArrayList <>();
			String s = null;
			do {
				try{
					s = JOptionPane.showInputDialog(null, "informe a quantidade de jogadores > 3:", "entrada de dados", 1);
					qtdJogador = Integer.valueOf(s);
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Erro!", "entrada de dados", 1);
				}
				
			}while(qtdJogador < 3 && s != null);
			
			do {
				try{
					s = JOptionPane.showInputDialog(null, "informe o intervalo inicial:", "entrada de dados", 1);
					
					interInicial = Integer.valueOf(s);
					s = JOptionPane.showInputDialog(null, "informe o intervalo final:", "entrada de dados", 1);
					
					interFinal = Integer.valueOf(s);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Erro!", "entrada de dados", 1);
				}
				
			}while(interInicial > interFinal && (interInicial - interFinal) < 50 && s != null);
			
			do {
				try{
					s = JOptionPane.showInputDialog(null, "informe a quantidade de tentativas > 1 <= 4", "entrada de dados", 1);
					tentativa = Integer.valueOf(s);
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Erro!", "entrada de dados", 1);
				}
				
			}while((tentativa < 1 || tentativa > 4) && s != null);
			Random r = new Random();
			
			Controle c = new Controle(interInicial, interFinal);
			int salva = 0;
			String nomeAux;
			for(int i = 0; i < qtdJogador; i++) {
				
				Jogador j = new Jogador();
				nomeAux = j.criaNome();
				j.setNome(nomeAux);
				lista.add(j);
				
				int tent =0;
				for(int x = 0; x < tentativa; x++) {
					do{
						tent = r.nextInt((interFinal-interInicial+1))+interInicial;
						
					}while(tent < interInicial || tent > interFinal);
					
					lista1.add(tent);
					salva++;
				}
				//Jogador jogador = new Jogador(nomeAux, lista1);
				/*nome = j.getNome();
				Jogador obj = new Jogador(nome);
				tentativas[i] = obj;*/
			}
			String somaString = "";
			salva = 0;
			for(int i = 0; i < qtdJogador; i++) {
				somaString += "\nJogador: "+lista.get(i).getNome();
				for(int x = 0; x < tentativa; x++) {
					somaString += "\n";
					somaString += "       Tentativas "+(x+1)+": "+ lista1.get(salva)/*qtdTent[salva]*/;
					salva++;
				}
			}
			
			String status = "";
			int x= 0, nomeP = 0;
			int i = 0;
			
			for(;i < (qtdJogador * tentativa) ; i++, x++) {
				
				if(x == qtdJogador) {
					nomeP++;
					x = 0;
				}
				if(c.testaPalpite(lista1.get(i), i)) {
					somaString += "\num jogador ganhou";
					break;
				}
				
			}
			if(i == (qtdJogador * tentativa)) {
				somaString += "\n nimguem acertou"+"\n Numero da sorte: "+c.getNumSorteado();
			}else {
				somaString += "\n"+status+ "  "+lista.get(nomeP).getNome()+" "+c.getNumSorteado();
			}
			try{
				JOptionPane.showMessageDialog(null, somaString, "entrada de dados", 1);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "Erro!", "saida de dados", 1);
			}
			dado.close();
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	
	
	public boolean testaPalpite(Integer tentativas, int i) {
		if(i == 0) {
			numSorteado = r.nextInt((interF-interI+1))+interI;
		}
        if(tentativas == getNumSorteado()) {
        	return true;
        }else {
        	return false;
        }
	}
	
	

	public int getNumSorteado() {
		return numSorteado;
	}
	public void setNumSorteado(int numSorteado) {
		this.numSorteado = numSorteado;
	}
	public int getInterI() {
		return interI;
	}

	public void setInterI(int interI) {
		this.interI = interI;
	}

	public int getInterF() {
		return interF;
	}

	public void setInterFinal(int interF) {
		this.interF = interF;
	}
    
}
