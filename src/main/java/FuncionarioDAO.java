import org.example.FuncionarioPJ;
import org.example.Funcionario;

import javax.xml.transform.Result;
import java.lang.module.ResolutionException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuncionarioDAO {
    private Connection connection;

    public FuncionarioDAO() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/banco",
                    "root",
                    "Senha"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void save(Funcionario f) {

        String sql = """
                 INSERT INTO funcionarios\s
                 (Nome_Funcionarios, Cpf_Funcionarios, Salario_Funcionarios, Tipo_Funcionarios)
                 VALUES (?, ?, ?, ?)
                \s""";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.setDouble(3, f.getSalario());
            stmt.setString(4, f.getTipo());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro a salvar ", e);
        }

    }

    public List<Funcionario> listar() {
        List<Funcionario> funcionario = new ArrayList<>();

        String sql = "SELECT * FROM funcionarios";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet Result = stmt.executeQuery()) {

            while (Result.next()) {
                String nome = Result.getString("Nome_Funcionarios");
                String cpf = Result.getString("Cpf_Funcionarios");
                double salario = Result.getDouble("Salario_Funcionarios");
                String tipo = Result.getString("Tipo_Funcionarios");
                Funcionario f;

                if (tipo.equalsIgnoreCase("clt")) {
                    f = new FuncionarioCLT(nome, cpf, salario);
                } else {
                    f = new FuncionarioPJ(nome, cpf, salario);
                }
                funcionario.add(f);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return funcionario;
    }

public void update(String cpf, double novosalario){

        String sql = """
                UPDATE funcionarios
                SET Salario_Funcionarios = ?
                WHERE Cpf_Funcionarios = ?
                """;

    try(PreparedStatement stmt = connection.prepareStatement(sql)){

        stmt.setDouble(1, novosalario);
        stmt.setString(2, cpf);

        int linha = stmt.executeUpdate();


        if (linha > 0){
            System.out.println("Salario cadastrado com sucesso");
        }
        else {
            System.out.println("Não tem funcionarios cadastrados");

        }

    } catch (SQLException e){
        throw new RuntimeException(e);
    }
    }
    public void delete(String cpf) {
        String sql = """
                DELETE FROM funcionarios
                WHERE Cpf_funcionarios = ?
                """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);

            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0 ){
                System.out.println("Funcionario deletado com sucesso. Agradecemos seus serviços.");
            }
            else {
                System.out.println("Não tem funcionarios cadastrados ");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}