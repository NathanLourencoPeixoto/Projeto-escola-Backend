package br.com.theschool.Shared.Sala;

public class SalaDto {
    private String id;
    private String name;
    private int alunosQuantid;
    
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
