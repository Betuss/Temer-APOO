/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temer;

import java.util.ArrayList;

/**
 *
 * 
 */
public class Sistema {
    
    private int dia;
    private int horaAtual;
    private int minutoAtual;
    private ArrayList<Sala> listaSalas;
    private Agenda agenda;
    private boolean ligado;
    private int novaHora;
    private int novoMinuto;

    public Sistema(){
            dia = 2;
            horaAtual = 00;
            minutoAtual = 00;
            listaSalas = new ArrayList<Sala>();
            agenda = new Agenda();
            ligado = false;
    }

    public void ligar(){
        if(ligado == false){
            ligado = true;
        }
    }

    public void desligar(){
        if(ligado == true){
            ligado = false;
        }
    }

    public boolean isLigado(){
        return ligado;
    }

    public void addSala(Sala sala){
            listaSalas.add(sala);
    }
    
    public ArrayList<Sala> getListaSalas(){
        return listaSalas;
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

    public void setPrimeiroHorario(){
        ArrayList<Agendamento> agendamentosDoDia = agenda.getAgendamentos(dia);
        int menorHora = 23;
        int menorMinuto = 59;
        int horaAgendamento;
        int minutoAgendamento;
        for(Agendamento agendamento : agendamentosDoDia){
            horaAgendamento = agendamento.getHoraInicio();
            minutoAgendamento = agendamento.getMinutoInicio();
            if(horaAgendamento < menorHora){
                if(minutoAgendamento < menorMinuto){
                    menorHora = horaAgendamento;
                    menorMinuto = minutoAgendamento;
                }
            }
        }
        // Primeiro horário
        novaHora = menorHora;
        novoMinuto = menorMinuto;

        // Subtrair 30 minutos

        if(novoMinuto >= 30){
            novoMinuto -= 30;
        } else {
            novoMinuto += 30;
            novaHora -= 1;
        }
        
        // Arredondar para baixo em intervalos fechados de 30 minutos
        if(novoMinuto >= 30){
            novoMinuto = 30;
        } else {
            novoMinuto = 0;
        }
    }

    public ArrayList<Sala> getSalasDoDia(){
        ArrayList<Agendamento> agendamentosDoDia = agenda.getAgendamentos(dia);
        ArrayList<Sala> listaRetorno = new ArrayList<>();
        
        for(Agendamento agendamento : agendamentosDoDia){
            if(!listaRetorno.contains(agendamento.getSala())){
                listaRetorno.add(agendamento.getSala());
            }
        }
        return listaRetorno;
    }
    
    public ArrayList<Sala> getSalasProx30Minutos(){
        ArrayList<Agendamento> agendamentosDoDia = agenda.getAgendamentos(dia);
        ArrayList<Sala> listaRetorno = new ArrayList<>();
        
        //System.out.println("Tamanho lista: " + agendamentosDoDia.size() + "\n");
        
        for(Agendamento agendamento : agendamentosDoDia){
            if(isProx30Minutos(agendamento.getHoraInicio(), agendamento.getMinutoInicio())){
                listaRetorno.add(agendamento.getSala());
            }
        }
        //System.out.println("Retornei lista com tamanho: " + listaRetorno.size() + "\n");
        return listaRetorno;
    }
    
    public boolean isProx30Minutos(int horaAgendamento, int minutoAgendamento){
        if(horaAgendamento == horaAtual){
            if(minutoAgendamento - minutoAtual <= 30){
                return true;
            } else {
                return false;
            }
        } else {
            if(horaAtual == horaAgendamento - 1 && minutoAtual - minutoAgendamento >= 30){
                return true;
            } else {
                return false;
            }
        }
    }
    
    public void novoHorarioRecebe30Minutos(){
            novoMinuto += 30;
            if(novoMinuto >= 60){
                    novoMinuto %= 60;
                    novaHora++;
            }
            if(novaHora == 24){
                    novaHora = 0;
            }
    }
    
    public ArrayList<Sala> getSalasAresLigados(){
        ArrayList<Sala> listaRetorno = new ArrayList<>();
        
        for(Sala sala : listaSalas){
            if(sala.isAresLigados()){
                listaRetorno.add(sala);
            }
        }
        return listaRetorno;
    }

    public int getHoraAtual() {
        return horaAtual;
    }

    public void setHoraAtual(int horaAtual) {
        this.horaAtual = horaAtual;
    }

    public int getMinutoAtual() {
        return minutoAtual;
    }

    public int getNovaHora() {
        return novaHora;
    }

    public int getNovoMinuto() {
        return novoMinuto;
    }
    
    
}
