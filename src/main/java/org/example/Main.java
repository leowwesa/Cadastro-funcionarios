package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<org.example.Funcionarios> funcionarios = new ArrayList<>();

        System.out.println("Bem vindo ao BB (Banco Batman)");
        System.out.println("==================================");
        int opcao = -1;
        do {
            System.out.println("Selecione a opção desejada");
            System.out.println("1 - Cadastrar Funcionarios \n2 - Listar Funcionarios \n3 - Atualizar Salario \n4 - Deletar Funcionario \n0 - Sair");
            opcao = scan.nextInt();
            scan.nextLine();


            switch (opcao) {
                case 1:
                    System.out.println("É um funcionario CLT ou PJ ? ");
                    String change = scan.nextLine();

                    if (change.equalsIgnoreCase("PJ")) {
                        org.example.FuncionarioPJ pj = new org.example.FuncionarioPJ();
                        System.out.println("Digite o nome do funcionario PJ: ");
                        pj.setNome_funcionario(scan.nextLine());
                        System.out.println("Digite o CPF do funcionario PJ: ");
                        pj.setCpf(scan.nextLine());
                        System.out.println("Digite o Salario do funcionario PJ sem os descontos: ");
                        pj.setSalario(scan.nextDouble());
                        scan.nextLine();
                        funcionarios.add(pj);

                    } else if (change.equalsIgnoreCase("CLT")) {
                        org.example.FuncionarioCLT clt = new org.example.FuncionarioCLT();
                        System.out.println("Digite o nome do funcionario CLT: ");
                        clt.setNome_funcionario(scan.nextLine());
                        System.out.println("Digite o CPF do funcionario CLT: ");
                        clt.setCpf(scan.nextLine());
                        System.out.println("Digite o Salario do funcionario CLT sem os descontos: ");
                        clt.setSalario(scan.nextDouble());
                        scan.nextLine();
                        funcionarios.add(clt);
                    }
                    break;
                case 2:
                    for (org.example.Funcionarios f : funcionarios) System.out.println(f.getNome_funcionario() + " - " + f.getCpf() + " - " + f.salarioFinal());
                    if (funcionarios.isEmpty()){
                        System.out.println("Não tem funcionarios cadastrados");
                    }
                    break;

                case 3:
                    if (funcionarios.isEmpty()){
                        System.out.println("Não tem funcionarios cadastrados");
                    }else {
                        System.out.println("Digite o cpf do cliente que deseja alterar o salario: ");
                        String cpfProcurado = scan.nextLine();
                        Boolean encontrado = false;
                        for (org.example.Funcionarios f : funcionarios){
                            if(f.getCpf().equals(cpfProcurado)){
                                System.out.println("Digite o novo salario: ");
                                double novoSalario = scan.nextDouble();
                                scan.nextLine();

                                f.setSalario(novoSalario);
                                System.out.println("Salario atualizado com sucesso!");
                                encontrado = true;
                                break;
                            }

                        }
                        if (!encontrado){
                            System.out.println("Funcionario não encontrado");
                        }
                        break;
                    }
                case 4:
                    if (funcionarios.isEmpty()){
                        System.out.println("Sem funcionarios cadastrados");
                    }else {
                        System.out.println("Digite o cpf do cliente que deseja remover do sistema: ");
                        String cpfProcurado = scan.nextLine();
                        boolean encontrado = false;

                        for (org.example.Funcionarios f : funcionarios) {
                            if (f.getCpf().equals(cpfProcurado)) {
                                funcionarios.remove(f);
                                System.out.println("Funcionario deletado");
                                break;
                            }
                        }

                    }
                default:
                    System.out.println("número invalido");
                    break;
            }
        } while (opcao != 0);
        System.out.println("Muito obrigado por utilizar");
    }
}