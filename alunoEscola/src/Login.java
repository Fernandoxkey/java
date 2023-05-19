import java.util.Scanner;

public class Login {
    private static final String LOGIN_PADRAO = "usuario";
    private static final String SENHA_PADRAO = "senha123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de login!");
        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        if (validarLogin(login, senha)) {
            System.out.println("Login realizado com sucesso!");
            // Continuar com a lógica do sistema após o login bem-sucedido
        } else {
            System.out.println("Login ou senha inválidos. Deseja redefinir a senha? (s/n)");
            String opcao = scanner.nextLine();

            if (opcao.equalsIgnoreCase("s")) {
                redefinirSenha();
            } else {
                System.out.println("Saindo do sistema de login...");
            }
        }
    }

    private static boolean validarLogin(String login, String senha) {
        return login.equals(LOGIN_PADRAO) && senha.equals(SENHA_PADRAO);
    }

    private static void redefinirSenha() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o login: ");
        String login = scanner.nextLine();

        if (login.equals(LOGIN_PADRAO)) {
            System.out.print("Digite a nova senha: ");
            String novaSenha = scanner.nextLine();
            SENHA_PADRAO = novaSenha; // Atualiza a senha padrão com a nova senha digitada
            System.out.println("Senha redefinida com sucesso!");
        } else {
            System.out.println("Login inválido. Não é possível redefinir a senha.");
        }
    }

}