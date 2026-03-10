import org.example.Funcionario;

public class FuncionarioCLT extends Funcionario {

    public FuncionarioCLT(String nome, String cpf, double salario) {
        super(nome, cpf, salario);

    }
    @Override
    public double salarioFinal() {
        return salario * 0.9;
    }
    @Override
    public String getTipo(){
        return "ClT";
    }

}