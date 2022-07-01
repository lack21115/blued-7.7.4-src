package a.a.l.a;

import a.a.o.j;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class a {
  public static final ThreadLocal<TypedValue> a = new ThreadLocal<TypedValue>();
  
  public static final WeakHashMap<Context, SparseArray<a>> b = new WeakHashMap<Context, SparseArray<a>>(0);
  
  public static final Object c = new Object();
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static ColorStateList a(Context paramContext, int paramInt) {
    synchronized (c) {
      WeakHashMap<Context, SparseArray<a>> weakHashMap = b;
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public static void a(Context paramContext, int paramInt, ColorStateList paramColorStateList) {
    synchronized (c) {
      WeakHashMap<Context, SparseArray<a>> weakHashMap = b;
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public static ColorStateList b(Context paramContext, int paramInt) {
    if (Build.VERSION.SDK_INT >= 23)
      throw new VerifyError("bad dex opcode"); 
    ColorStateList colorStateList = a(paramContext, paramInt);
    if (colorStateList != null)
      return colorStateList; 
    throw new VerifyError("bad dex opcode");
  }
  
  public static Drawable c(Context paramContext, int paramInt) {
    return j.a().c(paramContext, paramInt);
  }
  
  public static class a {
    public final ColorStateList a;
    
    public final Configuration b;
    
    public a(ColorStateList param1ColorStateList, Configuration param1Configuration) {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\a\l\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */