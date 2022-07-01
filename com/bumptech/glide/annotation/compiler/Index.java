package com.bumptech.glide.annotation.compiler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.TYPE})
@interface Index {
  String[] extensions() default {};
  
  String[] modules() default {};
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bumptech\glide\annotation\compiler\Index.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */