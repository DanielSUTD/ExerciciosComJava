package model;

public class Operador extends Funcionario{

    public Operador(String nome, double salario, String cargo) {
        super(nome, salario);
        this.cargo = "Operador";
    }

    @Override
    public String toString() {
        return "|Nome: " +nome+ "|Cargo: " +cargo+ "|Salário: " +salario;
    }

    @Override
    public double calcularBonus() {
        return salario * 0.20;
    }
}
