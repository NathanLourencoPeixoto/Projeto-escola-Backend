package br.com.escolasystem.escola.Shared.Aluno;

import java.util.List;

import br.com.escolasystem.escola.model.Pessoa;

public class AlunoCompletoDto {
    private String id;
    private String name;
    private int idade;
    private Pessoa responsavelId;
    private String endereco;
    private String telefone;
    private String salaId;
    private String salaNome;
    private int numeroDeFaltas;
    private Double mediaGeral;
    private List<String> dependencias;
    private List<Double> notas;
    
    public String getSalaNome() {
        return salaNome;
    }
    public void setSalaNome(String salaNome) {
        this.salaNome = salaNome;
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
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public Pessoa getResponsavelId() {
        return responsavelId;
    }
    public void setResponsavelId(Pessoa responsavelId) {
        this.responsavelId = responsavelId;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSalaId() {
        return salaId;
    }
    public void setSalaId(String salaId) {
        this.salaId = salaId;
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
    public List<Double> getNotas() {
        return notas;
    }
    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
}
