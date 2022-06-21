import veiculos.Manutencao;
import veiculos.Veiculo;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static ArrayList<Veiculo> veiculos = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("----GERENCIAMENTO DE VEÍCULOS----");
        while (true) {
            System.out.println("(1) CADASTRAR NOVO VEÍCULO");
            System.out.println("(2) ANOTAR MANUTENÇÃO");
            System.out.println("(3) COMPARAR SUCATEAMENTO");
            System.out.println("(4) REPETIÇÃO DE SERVIÇO");
            System.out.println("(5) INDICE DE SUCATEAMENTO");
            System.out.println("(6) CUSTO MEDIO DE MANUTENÇÃO");
            System.out.println("(7) SAIR");
            System.out.print("Escolha: ");
            int escolha = in.nextInt();
            in.nextLine();
            switch (escolha) {
                case 1:
                    veiculos.add(new Veiculo());
                    break;
                case 2:
                    System.out.print("Informe a placa do veículo (ABC-1234): ");
                    String placa = in.nextLine();
                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                            veiculo.getManutencoes().add(new Manutencao());
                        }
                    }
                    break;
                case 3:
                    System.out.print("Digite a placa do primeiro veículo: ");
                    String placa2 = in.nextLine();
                    for (Veiculo veiculo : veiculos) {
                        if (veiculo.getPlaca().equalsIgnoreCase(placa2)) {
                            if (comparaSucateamento(veiculo) == 1) {
                                System.out.println("O primeiro veículo está menos sucateado!");
                            } else if (comparaSucateamento(veiculo) == 0) {
                                System.out.println("Ambos estão igualmente sucateados!");
                            } else if (comparaSucateamento(veiculo) == -1) {
                                System.out.println("O segundo veículo está menos sucateado!");
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Em qual veículo deseja pesquisar a repetição?: ");
                    String placaRepete = in.nextLine();
                    for (Veiculo veiculo:veiculos) {
                        if (veiculo.getPlaca().equalsIgnoreCase(placaRepete)) {
                            System.out.print("Informe a descrição da manutenção: ");
                            String descricao = in.nextLine();
                            System.out.println("O serviço '" + descricao + "' foi realizado " + veiculo.repeteServico(descricao) + " vezes");
                        }
                    }
                case 5:
                    System.out.println("Deseja pesquisar o índice de sucateamento de qual veículo?: ");
                    String placaSucateamento = in.nextLine();
                    for (Veiculo veiculo:veiculos) {
                        if (veiculo.getPlaca().equalsIgnoreCase(placaSucateamento)) {
                            System.out.println("O índice de sucateamento do veículo com placa "+veiculo.getPlaca()+"" +
                                    " é de: "+veiculo.indiceSucateamento()+"!");
                        }
                    }
                case 6:
                    System.out.println("Em qual veículo deseja pesquisar o custo médio de manutenção?: ");
                    String placaMedioManutencao = in.nextLine();
                    for (Veiculo veiculo:veiculos) {
                        if (veiculo.getPlaca().equalsIgnoreCase(placaMedioManutencao)) {
                            System.out.println("O custo médio de manutenção é de: R$"+veiculo.custoMedioManutencoes()+"!");
                        }
                    }
                case 7:
                    break;
            }
            if(escolha==7){
                break;
            }
        }
        System.out.println("-----Fim de execução!-----");
    }
    public static int comparaSucateamento(Veiculo veiculo){
        System.out.print("Digite a placa do segundo veículo: ");
        String placa = in.nextLine();
        double condicao2 = 0;
        for (Veiculo veiculo2:veiculos) {
            if(veiculo2.getPlaca().equalsIgnoreCase(placa)){
                if(veiculo.indiceSucateamento()>veiculo2.indiceSucateamento()){
                    return -1;
                } else if (veiculo.indiceSucateamento()==veiculo2.indiceSucateamento()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        return 10;
    }
}