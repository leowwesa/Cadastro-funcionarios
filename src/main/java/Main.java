import org.example.FuncionarioPJ;
import org.example.Funcionario;
import java.util.List;
import java.util.Scanner;


        public class Main {
            public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);

                    System.out.println("Bem vindo ao sistema de cadastro");
                    System.out.println("==================================");
                    int opcao = -1;
                    do {
                        System.out.println("Selecione a opção desejada");
                        System.out.println("1 - Cadastrar Funcionarios \n2 - Listar Funcionarios \n3 - Atualizar Salario \n4 - Deletar Funcionario \n0 - Sair");
                        opcao = scan.nextInt();
                        scan.nextLine();

                        switch (opcao) {
                            case 1:
                                System.out.println("É um funcionario CLT ou pj ?: ");
                                String tipo = scan.nextLine();

                                if(tipo.equalsIgnoreCase("PJ")) {
                                    System.out.println("Digite o nome do Funcionario PJ: ");
                                    String nome = scan.nextLine();
                                    System.out.println("Digite o Cpf do funcionario PJ: ");
                                    String cpf = scan.nextLine();
                                    System.out.println("Digite o salario do funcionario: ");
                                    double salario = scan.nextDouble();
                                    FuncionarioPJ pj = new FuncionarioPJ(nome, cpf, salario);
                                    FuncionarioDAO dao = new FuncionarioDAO();
                                    dao.save(pj);
                                    System.out.println("Funcionario cadastrado");
                                    break;

                                } else if (tipo.equalsIgnoreCase("CLT")) {

                                    System.out.println("Digite o nome do funcionario CLT: ");
                                    String nome = scan.nextLine();
                                    System.out.println("Digite o cpf do funcionario CLT: ");
                                    String cpf = scan.nextLine();
                                    System.out.println("Digite o salario do funcionario: ");
                                    double salario = scan.nextDouble();
                                    FuncionarioCLT clt = new FuncionarioCLT(nome, cpf, salario);
                                    FuncionarioDAO dao = new FuncionarioDAO();
                                    dao.save(clt);
                                    System.out.println("Funcionario cadastrado");

                                }
                                break;

                            case 2:
                                FuncionarioDAO dao = new FuncionarioDAO();
                                List<Funcionario> lista = dao.listar();

                                for (Funcionario f : lista){
                                    System.out.println(
                                            f.getNome() + " | " +
                                            f.getCpf()  + " | " +
                                            f.getSalario() + " | " +
                                            f.getTipo() + " | "
                                    );
                                }
                            break;

                            case 3:
                                System.out.println("Digite o cpf do funcionario qual deseja alterar o salario: ");
                                String cpf = scan.nextLine();
                                System.out.println("Digite o novo salario: ");
                                double novosalario = scan.nextDouble();
                                FuncionarioDAO Dao = new FuncionarioDAO();
                                Dao.update(cpf, novosalario);
                                break;

                            case 4:
                                System.out.println("Digite o cpf do Funcionario que você deseja deletar: ");
                                String Cpf = scan.nextLine();

                                FuncionarioDAO dao1 = new FuncionarioDAO();
                                dao1.delete(Cpf);

                            default:
                                System.out.println("opção inexistente");
                        }
                    }while(opcao != 0);
                        System.out.println("Obrigado por utilizar o sistema ❤");

            }
        }
