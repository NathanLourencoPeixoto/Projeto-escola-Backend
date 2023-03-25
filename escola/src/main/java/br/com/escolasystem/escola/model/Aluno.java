package br.com.escolasystem.escola.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Document
public class Aluno {

    private String id;
    @NotBlank(message = "Deve se informar o nome!")
    @NotEmpty(message = "Deve se informar o nome!")
    private String name;
    @Positive(message = "A idade deve ser um número positivo!")
    private int idade;
    private String escolaId;
    @NotBlank(message = "O id do responsavel deve ser preenchido!")
    @NotEmpty(message = "O id do responsavel deve ser preenchido!")
    private String responsavelId;
    @NotBlank(message = "O endereço deve ser preenchido!")
    @NotEmpty(message = "O endereço deve ser preenchido!")
    private String endereco;
    @NotBlank(message = "O telefone deve ser preenchido!")
    @NotEmpty(message = "O telefone deve ser preenchido!")
    private String telefone;
    @NotBlank(message = "O id da sala deve ser preenchido!")
    @NotEmpty(message = "O id da sala deve ser preenchido!")
    private String salaId;
    @PositiveOrZero(message = "O número de faltas não pode ser negativo!")
    private int numeroDeFaltas;
    private Double mediaGeral;
    private List<String> dependencias;
    private List<Double> notas;
    
    public String getEscolaId() {
        return escolaId;
    }
    public void setEscolaId(String escolaId) {
        this.escolaId = escolaId;
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
    public String getResponsavelId() {
        return responsavelId;
    }
    public void setResponsavelId(String responsavelId) {
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
