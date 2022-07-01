package android.support.v4.content;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import java.io.File;

public class ContextCompat {
  private static final Object sLock = new Object();
  
  private static TypedValue sTempValue;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private static File createFilesDir(File paramFile) {
    // Byte code:
    //   0: ldc android/support/v4/content/ContextCompat
    //   2: monitorenter
    //   3: aload_0
    //   4: invokevirtual exists : ()Z
    //   7: ifne -> 65
    //   10: aload_0
    //   11: invokevirtual mkdirs : ()Z
    //   14: ifne -> 65
    //   17: aload_0
    //   18: invokevirtual exists : ()Z
    //   21: istore_1
    //   22: iload_1
    //   23: ifeq -> 31
    //   26: ldc android/support/v4/content/ContextCompat
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: new java/lang/StringBuilder
    //   34: dup
    //   35: ldc 'Unable to create files subdir '
    //   37: invokespecial <init> : (Ljava/lang/String;)V
    //   40: astore_2
    //   41: aload_2
    //   42: aload_0
    //   43: invokevirtual getPath : ()Ljava/lang/String;
    //   46: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: ldc 'ContextCompat'
    //   52: aload_2
    //   53: invokevirtual toString : ()Ljava/lang/String;
    //   56: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   59: pop
    //   60: ldc android/support/v4/content/ContextCompat
    //   62: monitorexit
    //   63: aconst_null
    //   64: areturn
    //   65: ldc android/support/v4/content/ContextCompat
    //   67: monitorexit
    //   68: aload_0
    //   69: areturn
    //   70: astore_0
    //   71: ldc android/support/v4/content/ContextCompat
    //   73: monitorexit
    //   74: aload_0
    //   75: athrow
    // Exception table:
    //   from	to	target	type
    //   3	22	70	finally
    //   31	60	70	finally
  }
  
  public static File getCodeCacheDir(Context paramContext) {
    return (Build.VERSION.SDK_INT >= 21) ? paramContext.getCodeCacheDir() : createFilesDir(new File((paramContext.getApplicationInfo()).dataDir, "code_cache"));
  }
  
  public static final ColorStateList getColorStateList(Context paramContext, int paramInt) {
    return (Build.VERSION.SDK_INT >= 23) ? paramContext.getColorStateList(paramInt) : paramContext.getResources().getColorStateList(paramInt);
  }
  
  public static final Drawable getDrawable(Context paramContext, int paramInt) {
    if (Build.VERSION.SDK_INT >= 21)
      return paramContext.getDrawable(paramInt); 
    if (Build.VERSION.SDK_INT >= 16)
      return paramContext.getResources().getDrawable(paramInt); 
    synchronized (sLock) {
      if (sTempValue == null)
        sTempValue = new TypedValue(); 
      paramContext.getResources().getValue(paramInt, sTempValue, true);
      paramInt = sTempValue.resourceId;
      return paramContext.getResources().getDrawable(paramInt);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\content\ContextCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */