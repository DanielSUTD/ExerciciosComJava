package model;

public class Gerente extends Funcionario{

    public Gerente(String nome, double salario, String cargo) {
        super(nome, salario);
        this.cargo = "Gerente";
    }

    @Override
    public String toString() {
        return "|Nome: " +nome+ "|Cargo: " +cargo+ "|Salário: " +salario;
    }

    @Override
    public double calcularBonus() {
        return salario * 0.10;
    }

}
