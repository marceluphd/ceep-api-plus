package br.com.alura.ceepapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Entity
public class Feedback {

    @Id
    @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
    private String id;
    @Pattern(regexp = ".*@.*\\..*", message = "E-mail inválido")
    private String email;
    @Length(min = 20, message = "Conteúdo deve ter no mínimo 20 caracteres")
    private String conteudo;

    public Feedback() {
        id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

}
