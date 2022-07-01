package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.ANNOTATION_TYPE})
public @interface LongDef {
  boolean flag() default false;
  
  boolean open() default false;
  
  long[] value() default {};
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\annotation\LongDef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */