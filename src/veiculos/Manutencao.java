package veiculos;

import java.util.Scanner;

public class Manutencao {
    private int numero;
    private double custo;
    private String descricao;
    private int tempoParado;
    public Manutencao(){
        Scanner in = new Scanner(System.in);
        System.out.print("Número da manutenção: ");
        this.numero = in.nextInt();
        in.nextLine();
        System.out.print("Custo de manutenção: ");
        this.custo = in.nextDouble();
        in.nextLine();
        System.out.print("Descrição: ");
        this.descricao = in.nextLine();
        System.out.print("Duração: ");
        this.tempoParado = in.nextInt();
        in.nextLine();
    }

    public double custoMedioDiario(){
        return this.getCusto()/this.getTempoParado();
    }

    //GETTERS E SETTERS

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTempoParado() {
        return tempoParado;
    }

    public void setTempoParado(int tempoParado) {
        this.tempoParado = tempoParado;
    }
}
