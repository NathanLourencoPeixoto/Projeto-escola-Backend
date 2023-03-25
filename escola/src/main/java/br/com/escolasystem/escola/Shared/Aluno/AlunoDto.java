package br.com.escolasystem.escola.Shared.Aluno;

import java.util.List;

public class AlunoDto {
    private String id;
    private String name;
    private String responsavelId;
    private String sala;
    private int numeroDeFaltas;
    private Double mediaGeral;
    private List<String> dependencias;
    
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
    public String getResponsavelId() {
        return responsavelId;
    }
    public void setResponsavelId(String responsavelId) {
        this.responsavelId = responsavelId;
    }
    public String getSala() {
        return sala;
    }
    public void setSala(String sala) {
        this.sala = sala;
    }
    public int getNumeroDeFaltas() {
        return numeroDeFaltas;
    }
    public void setNumeroDeFaltas(int numeroDeFaltas) {
        this.numeroDeFaltas = numeroDeFaltas;
    }
    public Double getMediaGeral() {
        return mediaGeral;
    }
    public void setMediaGeral(Double mediaGeral) {
        this.mediaGeral = mediaGeral;
    }
    public List<String> getDependencias() {
        return dependencias;
    }
    public void setDependencias(List<String> dependencias) {
        this.dependencias = dependencias;
    }
}
