package com.j256.ormlite.table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface DatabaseTable {
  Class<?> daoClass() default Void.class;
  
  String tableName() default "";
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\table\DatabaseTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */