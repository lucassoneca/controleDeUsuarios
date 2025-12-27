public class Usuarios {

    static int contador = 0;
    int id;
    String nome;
    String email;

    public Usuarios(String nome, String email) {
        this.id = contador++;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nome: " + nome + ", Email: " + email;
    }
}
