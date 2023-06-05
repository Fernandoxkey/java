package telas;

import alunoEscola.Aluno;
import servico.AlunoServico;

import java.time.LocalDate;
import java.util.Scanner;

public class TelaAluno {

    public static void executar(Scanner scanner) {
        AlunoServico servico = new AlunoServico();
        System.out.println("Alunos Cadastrados:");
        var alunos = servico.listarTodos();
        for (var aluno : alunos) {
            System.out.println(aluno.getId() + " - " + aluno.getNome());
        }

        System.out.println("Selecione uma Opção:");
        System.out.println("1 - Inserir");
        System.out.println("2 - Alterar");
        System.out.println("3 - Excluir");
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
            default:
                System.out.println("Opcao Invalida!");
        }

    }

    private static void inserir(Scanner scanner, AlunoServico servico) {
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
        var aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setDataNascimento(dataNascimento);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
        aluno.setEndereco(endereco);
        servico.inserir(aluno);
    }
    private static void alterar(Scanner scanner, AlunoServico servico) {
        System.out.println("Digite o ID do Aluno que deseja alterar:");
        var id = Long.parseLong(scanner.nextLine());
        var aluno = servico.encontrarAluno(id);
        if (aluno != null) {
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
            aluno.setNome(nome);
            aluno.setCpf(cpf);
            aluno.setDataNascimento(dataNascimento);
            aluno.setTelefone(telefone);
            aluno.setEmail(email);
            aluno.setEndereco(endereco);
            servico.alterar(aluno);
        }
    }
    private static void excluir(Scanner scanner, AlunoServico servico) {
        System.out.println("Digite o ID da Aluno que deseja Excluir:");
        var id = Long.parseLong(scanner.nextLine());
        servico.excluir(id);
    }
}