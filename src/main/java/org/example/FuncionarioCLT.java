package org.example;


public class FuncionarioCLT extends org.example.Funcionarios {

    public double salarioFinal() {
        double desconto = getSalario() * 0.10;
        return getSalario() - desconto;

    }

}