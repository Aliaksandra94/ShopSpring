package project.moroz.model.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TypeIntValidator.class)
public @interface TypeInt {
    String message() default "{Age should be a number}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

