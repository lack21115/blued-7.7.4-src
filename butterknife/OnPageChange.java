package butterknife;

import butterknife.internal.ListenerClass;
import butterknife.internal.ListenerMethod;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(callbacks = OnPageChange.Callback.class, remover = "removeOnPageChangeListener", setter = "addOnPageChangeListener", targetType = "androidx.viewpager.widget.ViewPager", type = "androidx.viewpager.widget.ViewPager.OnPageChangeListener")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface OnPageChange {
  Callback callback() default Callback.PAGE_SELECTED;
  
  int[] value() default {-1};
  
  public enum Callback {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\butterknife\OnPageChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */