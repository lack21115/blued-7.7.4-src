package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PACKAGE})
public @interface RestrictTo {
  Scope[] value();
  
  public enum Scope {
    GROUP_ID, LIBRARY, LIBRARY_GROUP, LIBRARY_GROUP_PREFIX, SUBCLASSES, TESTS;
    
    static {
      SUBCLASSES = new Scope("SUBCLASSES", 5);
      a = new Scope[] { LIBRARY, LIBRARY_GROUP, LIBRARY_GROUP_PREFIX, GROUP_ID, TESTS, SUBCLASSES };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\annotation\RestrictTo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */