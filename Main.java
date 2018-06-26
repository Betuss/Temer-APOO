/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temer;

import java.util.Random;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * 
 */
public class Main {

    
    /**
     * @param args the command line arguments
     */
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
        
        Tela tela = new Tela(); 
        tela.setVisible(true);
        Random gerador = new Random();
        Sistema sistema = new Sistema();
        Sala sala;
        
        for(int i = 0; i < 5; i++){
            sala = new Sala(i, 25 - i, 1 + (i%2));
            
            if(i == 0){
                sala.adicionarAgendamento(Dia.TERCA.getDia(), 14, 55, 16, 35);
                sala.adicionarAgendamento(Dia.QUINTA.getDia(), 14, 55, 16, 35);
            } else if (i == 1){
                sala.adicionarAgendamento(Dia.TERCA.getDia(), 16, 50, 18, 30);
                sala.adicionarAgendamento(Dia.QUINTA.getDia(), 16, 50, 18, 30);
            } else if (i == 2){
                sala.adicionarAgendamento(Dia.SEGUNDA.getDia(), 13, 00, 14, 40);
                sala.adicionarAgendamento(Dia.QUARTA.getDia(), 13, 00, 14, 40);
            } else if (i == 3){
                sala.adicionarAgendamento(Dia.SEGUNDA.getDia(), 14, 55, 16, 35);
                sala.adicionarAgendamento(Dia.QUARTA.getDia(), 14, 55, 16, 35);
            } else if (i == 4){
                sala.adicionarAgendamento(Dia.SEXTA.getDia(), 8, 55, 12, 30);
            }
            
            sistema.addSala(sala);
        }	
		
        ArrayList<Sala> salasProx30Minutos;
        ArrayList<Sala> salasAresLigados;
        sistema.ligar();
        sistema.setHoraAtual(12);

        while(sistema.isLigado()){
            sistema.montarAgenda();
            if(sistema.getNovaHora() == 0 && sistema.getNovoMinuto() == 0){
                sistema.setPrimeiroHorario();
            }
            
            if(sistema.getHoraAtual() == sistema.getNovaHora()
                && sistema.getMinutoAtual() == sistema.getNovoMinuto()){
                
                sistema.novoHorarioRecebe30Minutos();
                
                salasProx30Minutos = sistema.getSalasProx30Minutos();
                for(Sala salaAux : salasProx30Minutos){
                    salaAux.ligarAres();
                }
                
                salasAresLigados = sistema.getSalasAresLigados();
                for(Sala salaAux : salasAresLigados){
                    if(salaAux.getQuantidadePessoas() < 10 &&
                        !salaAux.temAgendamentoProx30Minutos(sistema.getHoraAtual(), sistema.getMinutoAtual())){
                        salaAux.desligarAres();
                    }
                }
            }
            for(Sala salaAux : sistema.getListaSalas()){
                System.out.println(salaAux + "Dia: " + sistema.getDia() + " | Hora: " + sistema.getHorario());
                if(salaAux.isAresLigados()){
                    salaAux.entrarPessoas(gerador.nextInt(4));
                    salaAux.sairPessoas(gerador.nextInt(3));
                    salaAux.esvaziarCasoTenhaTerminado(sistema.getHoraAtual(), sistema.getMinutoAtual());
                    salaAux.popularAoComecar(sistema.getHoraAtual(), sistema.getMinutoAtual());
                }
            }
            System.out.println("\n");

            tela.jhora.setText(sistema.getHorario());

            String identificadorJ = Integer.toString(sistema.getListaSalas().get(0).getIdentificador());
            tela.JidSala.setText(identificadorJ);

            //String temperaturaIdealJ = Integer.toString(sala.getTemperaturaIdeal());
            //tela.jtempIdeal.setText(temperaturaIdealJ);

            String temperaturaAtualJ = Integer.toString(sistema.getListaSalas().get(0).getTemperaturaAtual());
            tela.jtemperatura.setText(temperaturaAtualJ);

            try { 
                Thread.sleep (500); // Espera 0,5s para dar as saídas, fica melhor pra enxergar as mudanças
            } catch (InterruptedException ex) {
               System.out.println("Erro");
            }
            
            sistema.passarCincoMinutos();
        }
    }
    
}
