package ru.k2.swaggerdemotinkoff.support.validation;

import ru.k2.swaggerdemotinkoff.support.validation.impl.SourceChannelValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SourceChannelValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface SourceChannel {

    String message() default "Недопустимое значение параметра \"sourceChannel\". Допустимые значения: INT, MOB";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
