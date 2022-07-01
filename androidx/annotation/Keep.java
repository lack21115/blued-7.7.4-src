package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({ElementType.PACKAGE, ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.FIELD})
public @interface Keep {}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\annotation\Keep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */