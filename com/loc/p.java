package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;

public final class p {
  private volatile b a = new b((byte)0);
  
  private x b = new x("HttpsDecisionUtil");
  
  public static p a() {
    return a.a;
  }
  
  public static String a(String paramString) {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.startsWith("https"))
        return paramString; 
      try {
        Uri.Builder builder = Uri.parse(paramString).buildUpon();
        return builder.build().toString();
      } finally {
        str = null;
      } 
    } 
    return str;
  }
  
  public static void b(Context paramContext) {
    b(paramContext, true);
  }
  
  private static void b(Context paramContext, boolean paramBoolean) {
    SharedPreferences.Editor editor = x.b(paramContext, "open_common");
    x.a(editor, "a3", paramBoolean);
    x.a(editor);
  }
  
  public static boolean b() {
    return (Build.VERSION.SDK_INT == 19);
  }
  
  public final void a(Context paramContext) {
    if (this.a == null)
      this.a = new b((byte)0); 
    this.a.a(x.a(paramContext, "open_common", "a3", true));
    this.a.a(paramContext);
  }
  
  final void a(Context paramContext, boolean paramBoolean) {
    if (this.a == null)
      this.a = new b((byte)0); 
    b(paramContext, paramBoolean);
    this.a.a(paramBoolean);
  }
  
  public final void a(boolean paramBoolean) {
    if (this.a == null)
      this.a = new b((byte)0); 
    this.a.b(paramBoolean);
  }
  
  public final boolean b(boolean paramBoolean) {
    if (b())
      return false; 
    if (!paramBoolean) {
      if (this.a == null)
        this.a = new b((byte)0); 
      if (!this.a.a())
        return false; 
    } 
    return true;
  }
  
  static final class a {
    static p a = new p();
  }
  
  static final class b {
    protected boolean a = true;
    
    private int b = 0;
    
    private final boolean c = true;
    
    private boolean d = false;
    
    private b() {}
    
    public final void a(Context param1Context) {
      if (param1Context == null)
        return; 
      if (this.b <= 0 && Build.VERSION.SDK_INT >= 4)
        this.b = (param1Context.getApplicationContext().getApplicationInfo()).targetSdkVersion; 
    }
    
    public final void a(boolean param1Boolean) {
      this.a = param1Boolean;
    }
    
    public final boolean a() {
      // Byte code:
      //   0: aload_0
      //   1: getfield d : Z
      //   4: ifne -> 93
      //   7: getstatic android/os/Build$VERSION.SDK_INT : I
      //   10: bipush #28
      //   12: if_icmplt -> 20
      //   15: iconst_1
      //   16: istore_1
      //   17: goto -> 22
      //   20: iconst_0
      //   21: istore_1
      //   22: aload_0
      //   23: getfield a : Z
      //   26: ifeq -> 68
      //   29: aload_0
      //   30: getfield b : I
      //   33: istore_3
      //   34: iload_3
      //   35: istore_2
      //   36: iload_3
      //   37: ifgt -> 43
      //   40: bipush #28
      //   42: istore_2
      //   43: iload_2
      //   44: bipush #28
      //   46: if_icmplt -> 54
      //   49: iconst_1
      //   50: istore_2
      //   51: goto -> 56
      //   54: iconst_0
      //   55: istore_2
      //   56: iload_2
      //   57: ifeq -> 63
      //   60: goto -> 68
      //   63: iconst_0
      //   64: istore_2
      //   65: goto -> 70
      //   68: iconst_1
      //   69: istore_2
      //   70: iload_1
      //   71: ifeq -> 83
      //   74: iload_2
      //   75: ifeq -> 83
      //   78: iconst_1
      //   79: istore_1
      //   80: goto -> 85
      //   83: iconst_0
      //   84: istore_1
      //   85: iload_1
      //   86: ifeq -> 91
      //   89: iconst_1
      //   90: ireturn
      //   91: iconst_0
      //   92: ireturn
      //   93: iconst_1
      //   94: ireturn
    }
    
    public final void b(boolean param1Boolean) {
      this.d = param1Boolean;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */