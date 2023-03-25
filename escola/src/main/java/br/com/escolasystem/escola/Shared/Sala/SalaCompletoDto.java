package br.com.theschool.Shared.Sala;

import java.util.List;

import br.com.theschool.model.Aluno;

public class SalaCompletoDto {
    private String id;
    private String name;
    private int alunosQuantid;
    private List<Aluno> alunos;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<Aluno> getAlunos() {
        return alunos;
    }
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
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
