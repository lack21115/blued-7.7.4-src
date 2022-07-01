package android.support.v4.view;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat {
  private static LayoutInflaterCompat$LayoutInflaterCompatBaseImpl IMPL = new LayoutInflaterCompat$LayoutInflaterCompatBaseImpl();
  
  private static boolean sCheckedField;
  
  private static Field sLayoutInflaterFactory2Field;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  static void forceSetFactory2(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2) {
    if (!sCheckedField) {
      try {
        Field field = LayoutInflater.class.getDeclaredField("mFactory2");
        sLayoutInflaterFactory2Field = field;
        field.setAccessible(true);
      } catch (NoSuchFieldException noSuchFieldException) {
        StringBuilder stringBuilder = new StringBuilder("forceSetFactory2 Could not find field 'mFactory2' on class ");
        stringBuilder.append(LayoutInflater.class.getName());
        stringBuilder.append("; inflation may have unexpected results.");
        Log.e("LayoutInflaterCompatHC", stringBuilder.toString(), noSuchFieldException);
      } 
      sCheckedField = true;
    } 
    if (sLayoutInflaterFactory2Field != null)
      try {
        sLayoutInflaterFactory2Field.set(paramLayoutInflater, paramFactory2);
        return;
      } catch (IllegalAccessException illegalAccessException) {
        StringBuilder stringBuilder = new StringBuilder("forceSetFactory2 could not set the Factory2 on LayoutInflater ");
        stringBuilder.append(paramLayoutInflater);
        stringBuilder.append("; inflation may have unexpected results.");
        Log.e("LayoutInflaterCompatHC", stringBuilder.toString(), illegalAccessException);
      }  
  }
  
  public static void setFactory2(LayoutInflater paramLayoutInflater, LayoutInflater.Factory2 paramFactory2) {
    IMPL.setFactory2(paramLayoutInflater, paramFactory2);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 21) {
      IMPL = new LayoutInflaterCompat$LayoutInflaterCompatApi21Impl();
      throw new VerifyError("bad dex opcode");
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\view\LayoutInflaterCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */