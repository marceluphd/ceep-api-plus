package br.com.alura.ceepapi.model;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.*;

public class Erro {

    private final Map<String, String> erros;

    public Erro() {
        erros = new HashMap<>();
    }

    public Erro(List<ObjectError> allErrors) {
        this();
        for (ObjectError error :
                allErrors) {
            add((FieldError) error);
        }
    }

    public Map<String, String> getErros() {
        return Collections.unmodifiableMap(erros);
    }

    public void add(FieldError error) {
        erros.put(error.getField(), error.getDefaultMessage());
    }
}
