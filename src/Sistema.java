import java.util.ArrayList;

public class Sistema {

	private int dia;
	private int horaAtual;
	private int minutoAtual;
	private ArrayList<Sala> listaSalas;
	private Agenda agenda;
	
	public Sistema(){
		dia = 2;
		horaAtual = 00;
		minutoAtual = 00;
		listaSalas = new ArrayList<Sala>();
		agenda = new Agenda();
	}
	
	public void addSala(Sala sala){
		listaSalas.add(sala);
	}
	
	public void montarAgenda(){
		agenda = new Agenda();
		for(Sala sala : listaSalas){
			for(Agendamento agendamento : sala.getListaAgendamentos()){
				agenda.adicionarAgendamento(agendamento);
			}
		}
	}
	
	public void passarMeiaHora(){
		minutoAtual += 30;
		if(minutoAtual >= 60){
			minutoAtual %= 60;
			horaAtual++;
		}
		if(horaAtual == 24){
			horaAtual = 0;
			dia++;
		}
		if(dia == 7){
			dia = 0;
		}
	}
	
	public void passarCincoMinutos(){
		minutoAtual += 5;
		if(minutoAtual >= 60){
			minutoAtual %= 60;
			horaAtual++;
		}
		if(horaAtual == 24){
			horaAtual = 0;
			dia++;
		}
		if(dia == 7){
			dia = 0;
		}
	}
	
	public String getDia(){
		String diaSemana = "";
		if(dia == 0 ){
			diaSemana = "Sábado";
		} else if (dia == 1){
			diaSemana = "Domingo";
		} else if (dia == 2){
			diaSemana = "Segunda";
		} else if (dia == 3){
			diaSemana = "Terça";
		} else if (dia == 4){
			diaSemana = "Quarta";
		} else if (dia == 5){
			diaSemana = "Quinta";
		} else if (dia == 6){
			diaSemana = "Sexta";
		}
		
		return diaSemana;
	}
	
	public String getHorario(){
		return "" + String.format("%02d", horaAtual) + ":" + String.format("%02d", minutoAtual);
	}
}
