package org.example;

public class FuncionarioPJ extends org.example.Funcionarios {

    @Override
    public double salarioFinal() {
        double descontoPJ = getSalario() * 0.15;
        return getSalario() - descontoPJ;
    }

}
