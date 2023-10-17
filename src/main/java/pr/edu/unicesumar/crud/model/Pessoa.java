package pr.edu.unicesumar.crud.model;

public class Pessoa {
    private Long id;
    private String nome;
    private String documento;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public Pessoa(Long id, String nome, String documento) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
    }
}
