package br.com.escolasystem.professores.model;

public class Pessoa {
    private String id;
    private String nome;
    private int idade;
    private String cpf;
    private String cargo;
    private String trabalho;
    
    public String getTrabalho() {
        return trabalho;
    }
    public void setTrabalho(String trabalho) {
        this.trabalho = trabalho;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
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

}
