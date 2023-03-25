package br.com.escolasystem.escola.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document
public class Escola {

    private String id;
    @NotBlank(message = "O nome da escola deve ser preenchido!")
    @NotNull(message = "O nome da escola deve ser preenchido!")
    private String nome;
    @NotBlank(message = "O endereço da escola deve ser preenchido!")
    @NotNull(message = "O endereço da escola deve ser preenchido!")
    private String endereco;
    private String diretor;
    private String secretaria;
    private String coordenador;
    private int salaQuantid;
    private List<String> salas;
    private int alunosQuantid;
    private List<String> alunos;
    
    public int getSalaQuantid() {
        return salaQuantid;
    }
    public void setSalaQuantid(int salaQuantid) {
        this.salaQuantid = salaQuantid;
    }
    
    public List<String> getAlunos() {
        return alunos;
    }
    public void setAlunos(List<String> alunos) {
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
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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
