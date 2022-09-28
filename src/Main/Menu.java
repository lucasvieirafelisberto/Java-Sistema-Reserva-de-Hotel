package Main;

import Dados.Hospede;
import Dados.Reserva;
import Dados.Suite;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Reserva reserva;
        Hospede aux;
        System.out.println("######## HOTE LUAR DE AGOSTOS - SISTEMAS CADASTRO #########");
        System.out.println();

        System.out.println("#CADASTRO SUITE#");
        System.out.print("NUMERO: ");
        int numero = sc.nextInt();
        System.out.print("TIPO(Luxo/Economica): ");
        sc.nextLine();
        String tipo = sc.nextLine();

        System.out.print("CAPACIDADE: ");
        int capacidade = sc.nextInt();
        System.out.print("VALOR DIARIA: ");
        double diaria = sc.nextDouble();

        Suite suite = new Suite(numero, tipo, capacidade, diaria);
        System.out.print("QUANTIDADE DIAS: ");
        int qtdDias = sc.nextInt();

        do {
            System.out.print("QUANTIDADE PESSOAS: ");
            int qtdPessoas = sc.nextInt();
            reserva = new Reserva(qtdPessoas, qtdDias, suite);

            if (reserva.getQuantidadePessoas() > suite.getCapacidade()) {
                System.out.println("QUANTIDADE PESSOAS ACIMA DA CAPACIDADE,INSIRA UM VALOR VALIDO! ");
            } else {
                System.out.println();
                System.out.println("RESERVA DE SUITE CONCLUIDA! ");
            }

        } while (reserva.getQuantidadePessoas() > suite.getCapacidade());
        System.out.println();

        int cont = 0;
        int cont1 = 0;
        if (reserva.verificarCapacidade()) {
            System.out.println("#CADASTRO DE HOSPEDE#");
            do {
                sc.nextLine();
                System.out.print("CODIGO: ");
                int cod = sc.nextInt();
                System.out.print("NOME: ");
                sc.nextLine();
                String nome = sc.nextLine();
                System.out.print("ENDEREÇO: ");
                String endereco = sc.nextLine();
                System.out.print("IDADE: ");
                int idade = sc.nextInt();
                if (idade > 2) {
                    cont++;
                } else {
                    cont1++;
                }
                System.out.println();
                aux = new Hospede(cod, nome, endereco, idade);
                reserva.cadastrarHospede(aux);
            } while (cont < reserva.getQuantidadePessoas());
        }

                    
        System.out.print("MENORES DE 02 ANOS DE IDADE: " + cont1);
        System.out.println(reserva);

        if (reserva.getQuantidadeDias() <= 7) {
            System.out.println("VALOR TOTAL DAS DIARIAS: " + reserva.calculaDiaria());
            System.out.println("VALOR A SER PAGO: " + reserva.calculaDiaria());

        } else if (reserva.getQuantidadeDias() > 7) {
            System.out.println("VALOR TOTAL DAS DIARIAS: " + reserva.calculaDiaria());
            System.out.println("VALOR A SER PAGO COM 10% DESCONTO: " + reserva.calcularDesconto());
        }
        System.out.println();
        System.out.print("----#HOSPEDES#----");
        for (Hospede aux1 : reserva.getHospede()) {
            System.out.println(aux1);
        }

        sc.close();
    }

}
