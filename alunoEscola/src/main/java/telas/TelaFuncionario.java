package telas;

import alunoEscola.Funcionario;
import servico.FuncionServico;

import java.time.LocalDate;
import java.util.Scanner;

public class TelaFuncionario {
    public static void executar(Scanner scanner) {
        FuncionServico servico = new FuncionServico();
        System.out.println("Funcionarios Cadastrados:");
        var funcionarios = servico.listarTodos();
        for (var funcionario : funcionarios) {
            System.out.println(funcionario.getId() + " - " + funcionario.getNome());
        }


        System.out.println("Selecione uma Opção:");
        System.out.println("1 - Inserir");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
        System.out.println("0 - Voltar ao Menu Inicial");
        var opcao = scanner.nextLine();
        switch (opcao) {
            case "1":
                inserir(scanner, servico);
                break;
            case "2":
                alterar(scanner, servico);
                break;
            case "3":
                excluir(scanner, servico);
                break;
            case "0":
                break;
            default:
                System.out.println("Opcao Invalida!");
        }

    }

    private static void inserir(Scanner scanner, FuncionServico servico) {
        System.out.println("Nome:");
        var nome = scanner.nextLine();
        System.out.println("CPF:");
        var cpf = scanner.nextLine();
        System.out.println("Data Nascimento:");
        var dataNascimento = LocalDate.parse(scanner.nextLine());
        System.out.println("Telefone:");
        var telefone = scanner.nextLine();
        System.out.println("E-mail:");
        var email = scanner.nextLine();
        System.out.println("Endereço:");
        var endereco = scanner.nextLine();
        var funcionario = new Funcionario();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setDataNascimento(dataNascimento);
        funcionario.setTelefone(telefone);
        funcionario.setEmail(email);
        funcionario.setEndereco(endereco);
        servico.inserir(funcionario);
    }
    private static void alterar(Scanner scanner, FuncionServico servico) {
        System.out.println("Digite o ID do Funcionario que deseja alterar:");
        var id = Long.parseLong(scanner.nextLine());
        var funcionario = servico.encontrarFuncionario(id);
        System.out.println("Nome:[" + funcionario.getNome() + "]");
        var nome = scanner.nextLine();
        System.out.println("CPF:[" + funcionario.getCpf() + "]");
        var cpf = scanner.nextLine();
        System.out.println("DataNascimento:[" + funcionario.getDataNascimento() + "]");
        var dataNascimento = LocalDate.parse(scanner.nextLine());
        System.out.println("Telefone:[" + funcionario.getTelefone() + "]");
        var telefone = scanner.nextLine();
        System.out.println("E-mail:[" + funcionario.getEmail() + "]");
        var email = scanner.nextLine();
        System.out.println("Endereco:[" + funcionario.getEndereco() + "]");
        var endereco = scanner.nextLine();
        funcionario.setNome(nome);
        funcionario.setCpf(cpf);
        funcionario.setDataNascimento(dataNascimento);
        funcionario.setTelefone(telefone);
        funcionario.setEmail(email);
        funcionario.setEndereco(endereco);
        servico.alterar(funcionario);
    }
    private static void excluir(Scanner scanner, FuncionServico servico) {
        System.out.println("Digite o ID do Funcionario que deseja Excluir:");
        var id = Long.parseLong(scanner.nextLine());
        servico.excluir(id);
    }
}
