package org.example.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Validators implements Validator {
    @Autowired
    private List<Validator> validators;
    @Override
    public void validate(String email, String password, String name) {
        for (var validator: validators) {
            validator.validate(email, password, name);
        }
    }
}
