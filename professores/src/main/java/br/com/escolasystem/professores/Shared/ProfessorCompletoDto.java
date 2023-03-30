package br.com.theschoolprofessores.professores.Shared;

public class ProfessorCompletoDto {
    
    private String id;
    private String nome;
    private int idade;
    private String cpf;
    private String materia;
    private String escolaId;
    private String escolaName;
    
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
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
    public String getEscolaId() {
        return escolaId;
    }
    public void setEscolaId(String escolaId) {
        this.escolaId = escolaId;
    }
    public String getEscolaName() {
        return escolaName;
    }
    public void setEscolaName(String escolaName) {
        this.escolaName = escolaName;
    }

}
