package org.example;

public abstract class Funcionario {
    protected String nome;
    protected String cpf;
    protected double salario;

    public Funcionario(String nome, String cpf, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }

    public abstract double salarioFinal();
    public abstract String getTipo();

    public String getNome() {
        return nome; }
    public String getCpf() {
        return cpf; }
    public double getSalario() {
        return salario; }
}