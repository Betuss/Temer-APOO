import java.util.Random;

public class Main {
	
	public enum Dia{
		SABADO(0), DOMINGO(1), SEGUNDA(2), TERCA(3), QUARTA(4), QUINTA(5), SEXTA(6);
		private int dia;
		
		Dia(int dia){
			this.dia = dia;
		}
		
		public int getDia(){
			return dia;
		}
	}

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		
        Sala sala = new Sala(1, 23, 2);
        sala.adicionarAgendamento(Dia.TERCA.getDia(), 14, 55, 16, 35);
		sistema.addSala(sala);
		
		Random gerador = new Random();
		
		sala.ligarAres();
		
		for(int i = 0; i < 100; i++){
			System.out.println("\n" + sala + "Dia: " + sistema.getDia() + " | Hora: " + sistema.getHorario() +  "\n");
			sala.entrarPessoas(gerador.nextInt(3));
			if(i % 2 == 0){
				sala.sairPessoas(gerador.nextInt(4));
			}
			if(i % 5 == 0){
				sistema.passarMeiaHora();
			}
			sistema.passarCincoMinutos();
		}
    }
}
