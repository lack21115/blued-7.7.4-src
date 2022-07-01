package butterknife;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface BindFont {
  int style() default 0;
  
  int value();
  
  public static @interface TypefaceStyle {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\butterknife\BindFont.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */