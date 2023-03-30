package br.com.escolasystem.professores.Shared;

public class ProfessorIncomplatoDto {
    
    private String id;
    private String nome;
    private String cpf;
    private String materia;
    private String escolaId;

    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEscolaId() {
        return escolaId;
    }
    public void setEscolaId(String escolaId) {
        this.escolaId = escolaId;
    }

}
