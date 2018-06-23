import java.util.ArrayList;

public class Sala {

	private int identificador;
	private int quantidadePessoas;
	private int temperaturaIdeal;
	private int temperaturaAtual;
	private int quantidadeAr;
	private ArrayList<ArCondicionado> listaAr;
	
	public Sala(int identificador, int temperatura, int quantidadeAr) {
		super();
		this.identificador = identificador;
		this.quantidadePessoas = 0;
		this.temperaturaIdeal = temperatura;
		this.temperaturaAtual = 0;
		listaAr = new ArrayList<ArCondicionado>();
		for(int i = 1; i <= quantidadeAr; i++){
			listaAr.add(new ArCondicionado(i));
		}
	}
	
	public String toString(){
		String retorno = "";
		
		retorno += "[ID da sala: " + identificador + " | Temperatura ideal: " + temperaturaIdeal + "] ";
		retorno += "Quantidade de pessoas: " + String.format("%02d",quantidadePessoas) + " | ";
		for(ArCondicionado ar : listaAr){
			retorno += ar;
		}
		
		return retorno;
	}
	
	public void ligarAres(){
		for(ArCondicionado ar : listaAr){
			ar.ligar(temperaturaIdeal);
		}
		temperaturaAtual = temperaturaIdeal;
	}
	
	public void entrarPessoas(int quantidade){
		quantidadePessoas += quantidade;
		calcularNovaTemperatura();
	}
	
	public void sairPessoas(int quantidade){
		quantidadePessoas -= quantidade;
		calcularNovaTemperatura();
	}
	
	public int calcularNovaTemperatura(){
		
		int quociente = quantidadePessoas / 10;
		int novaTemperatura = temperaturaIdeal - quociente;
		if(!(novaTemperatura == temperaturaAtual)){
			for(ArCondicionado ar : listaAr){
				ar.ajustarTemperatura(novaTemperatura);
			}
			temperaturaAtual = novaTemperatura;
		}
		
		return 1;
	}
	
	public int getIdentificador(){
		return identificador;
	}
	
	public int getQuantidadePessoas() {
		return quantidadePessoas;
	}
	
	public void setQuantidadePessoas(int quantidadePessoas) {
		this.quantidadePessoas = quantidadePessoas;
	}
	
	public int getTemperaturaIdeal() {
		return temperaturaIdeal;
	}
	
	public void setTemperaturaIdeal(int temperatura) {
		this.temperaturaIdeal = temperatura;
	}
	
	public int getQuantidadeAr() {
		return quantidadeAr;
	}

	public void setQuantidadeAr(int quantidadeAr) {
		this.quantidadeAr = quantidadeAr;
	}

	public ArrayList<ArCondicionado> getListaAr() {
		return listaAr;
	}
	
	public void setListaAr(ArrayList<ArCondicionado> listaAr) {
		this.listaAr = listaAr;
	}
	
	
}
