package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface JSONField {
  boolean deserialize() default true;
  
  String format() default "";
  
  String label() default "";
  
  String name() default "";
  
  int ordinal() default 0;
  
  Feature[] parseFeatures() default {};
  
  boolean serialize() default true;
  
  SerializerFeature[] serialzeFeatures() default {};
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\annotation\JSONField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */