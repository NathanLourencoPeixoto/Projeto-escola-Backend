package br.com.theschool.Shared.Escola;

import java.util.List;

import br.com.theschool.model.Aluno;
import br.com.theschool.model.Sala;

public class EscolaCompletoDto {
    private String nome;
    private String endereco;
    private String diretor;
    private String secretaria;
    private String coordenador;
    private int salaQuantid;
    private List<Sala> salas;
    private int alunosQuantid;
    private List<Aluno> alunos;
    
    public int getSalaQuantid() {
        return salaQuantid;
    }
    public void setSalaQuantid(int salaQuantid) {
        this.salaQuantid = salaQuantid;
    }
    public List<Aluno> getAlunos() {
        return alunos;
    }
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
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

    public List<Sala> getSalas() {
        return salas;
    }
    public void setSalas(List<Sala> salas) {
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
