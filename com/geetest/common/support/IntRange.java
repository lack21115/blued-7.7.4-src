package com.geetest.common.support;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
public @interface IntRange {
  long from() default -9223372036854775808L;
  
  long to() default 9223372036854775807L;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\geetest\common\support\IntRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */