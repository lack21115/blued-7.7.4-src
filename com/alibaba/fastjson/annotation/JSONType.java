package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface JSONType {
  boolean alphabetic() default true;
  
  boolean asm() default true;
  
  Class<?> builder() default Void.class;
  
  String[] ignores() default {};
  
  String[] includes() default {};
  
  Class<?> mappingTo() default Void.class;
  
  String[] orders() default {};
  
  Feature[] parseFeatures() default {};
  
  SerializerFeature[] serialzeFeatures() default {};
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\annotation\JSONType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */