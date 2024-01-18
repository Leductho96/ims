package com.example.interviewmanagementsystem.util.validation.checkUserPassword;

import com.example.interviewmanagementsystem.util.dto.user.UserDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.time.LocalDate;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, UserDTO> {

    private static final SpelExpressionParser PARSER = new SpelExpressionParser();
    private String[] fields;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        fields = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext context) {
        if (userDTO == null) {
            return true;
        }
        final BeanWrapperImpl beanWrapper = new BeanWrapperImpl(userDTO);

        LocalDate password = (LocalDate) beanWrapper.getPropertyValue(fields[0]);
        LocalDate confirmPassword = (LocalDate) beanWrapper.getPropertyValue(fields[1]);

        if( password == confirmPassword ){
            return true;
        }else{
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addPropertyNode(fields[fields.length-1]).addConstraintViolation();
            return false;
        }
    }

}

