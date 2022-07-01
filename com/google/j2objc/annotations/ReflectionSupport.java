package com.google.j2objc.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE, ElementType.PACKAGE})
public @interface ReflectionSupport {
  Level value();
  
  public enum Level {
    a, b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\j2objc\annotations\ReflectionSupport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */