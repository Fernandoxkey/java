package alunoEscola;

import servico.HibernateUtil;
import telas.*;

import java.util.Scanner;

public class Login {
    private static final String LOGIN_PADRAO = "usuario";
    private static final String SENHA_PADRAO = "senha123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de login!");
        boolean tentarLogin = true;
        while (tentarLogin) {
            System.out.print("Login: ");
            String login = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            if (validarLogin(login, senha)) {
                exibirMenu(scanner);
                break;
            } else {
                System.out.println("Usuario ou senha invalidos. Deseja tentar novamente? [s/n]");
                var opcao = scanner.nextLine();
                if (!opcao.toLowerCase().equals("s")) {
                    tentarLogin = false;
                }
            }
        }
        HibernateUtil.fecharFectory();
    }

    private static void exibirMenu(Scanner scanner) {
        System.out.println("Selecione opção desejada:");
        System.out.println("1 - Cadastro de Aluno");
        System.out.println("2 - Cadastro de Funcionarios");
        System.out.println("3 - Cadastro de Curso");
        System.out.println("4 - Cadastro de Materia");
        System.out.println("5 - Cadastro de Semestre");
        System.out.println("6 - Cadastro de Turma");
        var opcao = scanner.nextLine();
        switch (opcao) {
            case "1":
                TelaAluno.executar(scanner);
                break;
            case "2":
                TelaFuncionario.executar(scanner);
                break;
            case "3":
                TelaCurso.executar(scanner);
                break;
            case "4":
                TelaMateria.executar(scanner);
                break;
            case "5":
                TelaSemestre.executar(scanner);
                break;
            case "6":
                TelaTurma.executar(scanner);
                break;
            default:
                System.out.println("Opcao Invalida!");
        }
    }

    private static boolean validarLogin(String login, String senha) {
        return login.equals(LOGIN_PADRAO) && senha.equals(SENHA_PADRAO);
    }


}
