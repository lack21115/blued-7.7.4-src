package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat {
  private static Field a;
  
  private static boolean b;
  
  private static void a(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2) {
    if (!b) {
      try {
        a = LayoutInflater.class.getDeclaredField("mFactory2");
        a.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("forceSetFactory2 Could not find field 'mFactory2' on class ");
        stringBuilder.append(LayoutInflater.class.getName());
        stringBuilder.append("; inflation may have unexpected results.");
        Log.e("LayoutInflaterCompatHC", stringBuilder.toString(), noSuchFieldException);
      } 
      b = true;
    } 
    Field field = a;
    if (field != null)
      try {
        field.set(paramLayoutInflater, paramFactory2);
        return;
      } catch (IllegalAccessException illegalAccessException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
        stringBuilder.append(paramLayoutInflater);
        stringBuilder.append("; inflation may have unexpected results.");
        Log.e("LayoutInflaterCompatHC", stringBuilder.toString(), illegalAccessException);
      }  
  }
  
  @Deprecated
  public static LayoutInflaterFactory getFactory(LayoutInflater paramLayoutInflater) {
    LayoutInflater.Factory factory = paramLayoutInflater.getFactory();
    return (factory instanceof Factory2Wrapper) ? ((Factory2Wrapper)factory).a : null;
  }
  
  @Deprecated
  public static void setFactory(LayoutInflater paramLayoutInflater, LayoutInflaterFactory paramLayoutInflaterFactory) {
    int i = Build.VERSION.SDK_INT;
    Factory2Wrapper factory2Wrapper2 = null;
    Factory2Wrapper factory2Wrapper1 = null;
    if (i >= 21) {
      if (paramLayoutInflaterFactory != null)
        factory2Wrapper1 = new Factory2Wrapper(paramLayoutInflaterFactory); 
      paramLayoutInflater.setFactory2(factory2Wrapper1);
      return;
    } 
    factory2Wrapper1 = factory2Wrapper2;
    if (paramLayoutInflaterFactory != null)
      factory2Wrapper1 = new Factory2Wrapper(paramLayoutInflaterFactory); 
    paramLayoutInflater.setFactory2(factory2Wrapper1);
    LayoutInflater.Factory factory = paramLayoutInflater.getFactory();
    if (factory instanceof LayoutInflater.Factory2) {
      a(paramLayoutInflater, (LayoutInflater.Factory2)factory);
      return;
    } 
    a(paramLayoutInflater, factory2Wrapper1);
  }
  
  public static void setFactory2(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2) {
    paramLayoutInflater.setFactory2(paramFactory2);
    if (Build.VERSION.SDK_INT < 21) {
      LayoutInflater.Factory factory = paramLayoutInflater.getFactory();
      if (factory instanceof LayoutInflater.Factory2) {
        a(paramLayoutInflater, (LayoutInflater.Factory2)factory);
        return;
      } 
      a(paramLayoutInflater, paramFactory2);
    } 
  }
  
  static class Factory2Wrapper implements LayoutInflater.Factory2 {
    final LayoutInflaterFactory a;
    
    Factory2Wrapper(LayoutInflaterFactory param1LayoutInflaterFactory) {
      this.a = param1LayoutInflaterFactory;
    }
    
    public View onCreateView(View param1View, String param1String, Context param1Context, AttributeSet param1AttributeSet) {
      return this.a.onCreateView(param1View, param1String, param1Context, param1AttributeSet);
    }
    
    public View onCreateView(String param1String, Context param1Context, AttributeSet param1AttributeSet) {
      return this.a.onCreateView(null, param1String, param1Context, param1AttributeSet);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(getClass().getName());
      stringBuilder.append("{");
      stringBuilder.append(this.a);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\LayoutInflaterCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */