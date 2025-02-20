package rhenao112.demos.hooks;

import io.cucumber.java.DataTableType;
import rhenao112.demos.models.User;

import java.util.List;

public class Convertir {

    @DataTableType
    public User aUsuario(List<String> values) {
        return new User(values.get(0), values.get(1));
    }



}
