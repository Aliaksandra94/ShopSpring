package project.moroz.model.annotation;

import project.moroz.model.annotation.TypeInt;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TypeIntValidator implements ConstraintValidator<TypeInt, Integer> {
    @Override
    public boolean isValid(Integer age, ConstraintValidatorContext constraintValidatorContext) {
        return (age instanceof Integer);
    }
}
