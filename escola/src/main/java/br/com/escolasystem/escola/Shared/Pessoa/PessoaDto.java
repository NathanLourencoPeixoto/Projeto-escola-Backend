package br.com.escolasystem.escola.Shared.Pessoa;

import java.util.List;

public class PessoaDto {
    private String nome;
    private String endereco;
    private String diretor;
    private String secretaria;
    private String coordenador;
    private List<String> salas;
    private int alunosQuantid;
    private String escola;
    
    public String getEscola() {
        return escola;
    }
    public void setEscola(String escola) {
        this.escola = escola;
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

    public List<String> getSalas() {
        return salas;
    }
    public void setSalas(List<String> salas) {
        this.salas = salas;
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
    public String getSecretaria() {
        return secretaria;
    }
    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }
    public String getCoordenador() {
        return coordenador;
    }
    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }
}
