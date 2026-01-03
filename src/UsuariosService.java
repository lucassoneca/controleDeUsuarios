import java.util.ArrayList;
import java.util.Scanner;

public class UsuariosService implements UsuarioServiceInterface {
    Scanner cadastrar = new Scanner(System.in);
    ArrayList<Usuarios> usuarios = new ArrayList<>();

    //cadastrar usuario
    @Override
    public void cadastrarUsuario(String nome, String email) {
        do {
            System.out.print("Digite o nome do usuário que deseja cadastrar: ");
            nome = cadastrar.nextLine().trim();

            if (nome.isEmpty()) {
                System.out.println("Erro: o nome não pode ficar vazio.");
            }
        } while (nome.isEmpty());

        do {
            System.out.print("Digite o email do usuário: ");
            email = cadastrar.nextLine().trim();

            if (email.isEmpty()) {
                System.out.println("Erro: o email não pode ficar vazio.");
            }
        } while (email.isEmpty());

        Usuarios novoUsuario = new Usuarios(nome, email);
        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso! ID gerado");
        System.out.println("ID: " + novoUsuario.getId());
        System.out.println("Nome: " + novoUsuario.getNome());
        System.out.println("Email: " + novoUsuario.getEmail());
    }

    //listar usuarios
    @Override
    public void listarUsuarios() {
        for (Usuarios i : usuarios) {
            System.out.println(i);
        }
        if (usuarios.isEmpty()) {
            System.out.println("A lista está vazia");
        }
    }

    //busca por id
    @Override
    public void buscarPorId(int id) {
        System.out.println("Digite o id do usuário que você deseja buscar: ");
        int idbuscar = cadastrar.nextInt();
        cadastrar.nextLine();
        if (idbuscar <= 0) {
            System.out.println("Isso não é um número inteiro");
        }
        if (usuarios.isEmpty()) {
            System.out.println("Esse ID não existe na lista");
        } else {
            System.out.println(usuarios.get(idbuscar));
        }
    }

    //atualizar usuario
    @Override
    public void atualizarUsuario(int id, String novoNome, String novoEmail) {
        System.out.println("Digite o id do usuário que você deseja atualizar os dados: ");
        int buscarID = cadastrar.nextInt();
        cadastrar.nextLine();

        Usuarios usuarioEncontrado = null;

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == buscarID) {
                usuarioEncontrado = usuarios.get(i);
                break;
            }
        }

        if (usuarioEncontrado == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("Deseja atualizar os dados de: " + usuarios.get(buscarID) + "?");
        System.out.println("digite 1 para Sim");
        System.out.println("digite 2 para Não");
        int escolha = cadastrar.nextInt();
        cadastrar.nextLine();
        if (escolha == 1) {
            System.out.println("Digite o novo nome: ");
            String nome = cadastrar.nextLine();
            System.out.println("Digite o novo email: ");
            String email = cadastrar.nextLine();

            System.out.println("Novo nome e email cadastrados: ");
            usuarioEncontrado.setNome(nome);
            usuarioEncontrado.setEmail(email);

            System.out.println("Usuário atualizado com sucesso!");
            System.out.println(usuarios.set(buscarID, usuarioEncontrado));
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    //remover usuario
    @Override
    public void removerUsuario(int id) {
        System.out.println("Digite o id de usuário que você deseja remover: ");
        int removerUsuario = cadastrar.nextInt();
        cadastrar.nextLine();
        id = removerUsuario;

        //verifica se o usuário existe
        Usuarios usuarioEncontrado = null;

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarioEncontrado = usuarios.get(i);
                usuarios.remove(i);
                System.out.println("Usuário removido com sucesso!");
                break;
            }
        }

        //se não existir = não encontrado
        if (usuarioEncontrado == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

    }

    @Override
    public String toString() {
        return "Usuarios: " + usuarios;
    }
}
