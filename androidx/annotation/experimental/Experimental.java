package androidx.annotation.experimental;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.ANNOTATION_TYPE})
public @interface Experimental {
  Level level() default Level.ERROR;
  
  public enum Level {
    ERROR, WARNING;
    
    static {
    
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\annotation\experimental\Experimental.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */