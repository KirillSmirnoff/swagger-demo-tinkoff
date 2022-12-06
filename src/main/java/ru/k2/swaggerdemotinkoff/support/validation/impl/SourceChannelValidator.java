package ru.k2.swaggerdemotinkoff.support.validation.impl;

import ru.k2.swaggerdemotinkoff.support.validation.SourceChannel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class SourceChannelValidator implements ConstraintValidator<SourceChannel, String> {

   public void initialize(SourceChannel constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return Arrays.stream(SourceChannel.values())
              .anyMatch(v -> v.value.equals(obj));
   }

   public enum SourceChannel {
      INTERNET_BANK("INT"),
      MOBILE_BANK("MOB");

      private final String value;

      SourceChannel(String value) {
         this.value = value;
      }

      public String getValue() {
         return value;
      }

   }
}
