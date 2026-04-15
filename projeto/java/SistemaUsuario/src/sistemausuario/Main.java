package sistemausuario;

import sistemausuario.DAO.UsuarioDAO;
import sistemausuario.model.Usuario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE USUARIOS ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Deletar");
            System.out.println("5 - Buscar por nome");
            System.out.println("6 - Buscar por email");
            System.out.println("7 - Buscar Ordenada");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    dao.salvar(new Usuario(nome, email));
                    break;

                case 2:
                    dao.listar();
                    break;

                case 3:
                    System.out.print("ID do usuario: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    System.out.print("Novo email: ");
                    String novoEmail = sc.nextLine();

                    dao.atualizar(idUpdate, new Usuario(novoNome, novoEmail));
                    break;

                case 4:
                    System.out.print("ID do usuario: ");
                    int idDelete = sc.nextInt();

                    dao.deletar(idDelete);
                    break;

                case 5:
                    System.out.print("Nome para busca: ");
                    String buscaNome = sc.nextLine();

                    dao.buscarPorNome(buscaNome);
                    break;

                case 6:
                    System.out.print("Email para busca: ");
                    String buscaEmail = sc.nextLine();

                    dao.buscarPorEmail(buscaEmail);
                    break;

                case 7:
                    System.out.println("Ordenar por:");
                    System.out.println("1 - Nome");
                    System.out.println("2 - Email");
                    int campoOpcao = sc.nextInt();
                    sc.nextLine();

                    String campo = (campoOpcao == 1) ? "nome" : "email";

                    System.out.println("Direção:");
                    System.out.println("1 - Crescente (ASC)");
                    System.out.println("2 - Decrescente (DESC)");
                    int dirOpcao = sc.nextInt();
                    sc.nextLine();

                    String direcao = (dirOpcao == 1) ? "ASC" : "DESC";

                    dao.listarOrdenado(campo, direcao);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
