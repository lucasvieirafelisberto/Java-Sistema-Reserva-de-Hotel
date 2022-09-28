package Dados;

import java.util.ArrayList;
import java.util.List;

public class Reserva {

    private int quantidadePessoas;
    private int quantidadeDias;
    private Suite suite;

    List<Hospede> hospede = new ArrayList<>();

    public Reserva() {
    }

    public Reserva(int quantidadePessoas, int quantidadeDias, Suite suite) {
        this.quantidadePessoas = quantidadePessoas;
        this.quantidadeDias = quantidadeDias;
        this.suite = suite;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas(int quantidadePessoas) {
        this.quantidadePessoas = quantidadePessoas;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public Suite getSuite() {
        return suite;
    }

    public void setSuite(Suite suite) {
        this.suite = suite;
    }

    public List<Hospede> getHospede() {
        return hospede;
    }

    public void setHospede(List<Hospede> hospede) {
        this.hospede = hospede;
    }

    public void cadastrarHospede(Hospede add) {
        hospede.add(add);

    }

    public boolean verificarCapacidade() {

        if (quantidadePessoas <= suite.getCapacidade()) {
            return true;
        } else {
            System.out.print("CAPACIDADE ACIMA DO LIMITE !");
            return false;
        }
    }

    public double calcularDesconto() {
        double aux1;
        aux1 = calculaDiaria() - (calculaDiaria() * 0.1);
        return aux1;
    }

    public double calculaDiaria() {

        return quantidadeDias * suite.getValorDiaria();

    }

    @Override
    public String toString() {
        return 
                 "\nQUANTIDADE DE DIAS: " + quantidadeDias;
    }

}
