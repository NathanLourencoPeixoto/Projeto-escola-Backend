package br.com.theschoolprofessores.professores.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Professor {

    private String id;
    private String materia;
    private String escolaId;
    
    public String getEscolaId() {
        return escolaId;
    }
    public void setEscolaId(String escolaId) {
        this.escolaId = escolaId;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
