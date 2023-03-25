package br.com.escolasystem.escola.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document
public class Sala {
    @Id
    private String id;
    @NotBlank(message = "O nome da sala deve ser preenchido!")
    @NotNull(message = "O nome da escola deve ser preenchido!")
    private String name;
    private int alunosQuantid;
    private List<String> alunos;
    private String escolaId;
    
    public String getEscolaId() {
        return escolaId;
    }
    public void setEscolaId(String escolaId) {
        this.escolaId = escolaId;
    }
    public List<String> getAlunos() {
        return alunos;
    }
    public void setAlunos(List<String> alunos) {
        this.alunos = alunos;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAlunosQuantid() {
        return alunosQuantid;
    }
    public void setAlunosQuantid(int alunosQuantid) {
        this.alunosQuantid = alunosQuantid;
    }
}
