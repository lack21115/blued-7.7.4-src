package com.google.errorprone.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.CONSTRUCTOR, ElementType.METHOD})
public @interface RestrictedApi {
  String allowedOnPath() default "";
  
  String checkerName() default "RestrictedApi";
  
  String explanation();
  
  String link();
  
  Class<? extends Annotation>[] whitelistAnnotations() default {};
  
  Class<? extends Annotation>[] whitelistWithWarningAnnotations() default {};
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\errorprone\annotations\RestrictedApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */