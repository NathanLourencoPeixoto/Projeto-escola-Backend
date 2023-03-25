package br.com.escolasystem.escola.Shared.Escola;

public class EscolaIncompletoDto {
    private String id;
    private String nome;
    private String endereco;
    private String diretor;
    private int salaQuantid;
    private int alunosQuantid;
    
    public int getSalaQuantid() {
        return salaQuantid;
    }
    public void setSalaQuantid(int salaQuantid) {
        this.salaQuantid = salaQuantid;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getAlunosQuantid() {
        return alunosQuantid;
    }
    public void setAlunosQuantid(int alunosQuantid) {
        this.alunosQuantid = alunosQuantid;
    }
    public String getDiretor() {
        return diretor;
    }
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
