package com.amap.api.col.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.List;

public final class bu {
  public static final String a = bs.c("SU2hhcmVkUHJlZmVyZW5jZUFkaXU");
  
  private static bu f;
  
  private List<String> b;
  
  private String c;
  
  private final Context d;
  
  private final Handler e;
  
  private bu(Context paramContext) {
    this.d = paramContext.getApplicationContext();
    if (Looper.myLooper() == null) {
      this.e = new a(Looper.getMainLooper(), this);
      return;
    } 
    this.e = new a(this);
  }
  
  public static bu a(Context paramContext) {
    // Byte code:
    //   0: getstatic com/amap/api/col/s/bu.f : Lcom/amap/api/col/s/bu;
    //   3: ifnonnull -> 38
    //   6: ldc com/amap/api/col/s/bu
    //   8: monitorenter
    //   9: getstatic com/amap/api/col/s/bu.f : Lcom/amap/api/col/s/bu;
    //   12: ifnonnull -> 26
    //   15: new com/amap/api/col/s/bu
    //   18: dup
    //   19: aload_0
    //   20: invokespecial <init> : (Landroid/content/Context;)V
    //   23: putstatic com/amap/api/col/s/bu.f : Lcom/amap/api/col/s/bu;
    //   26: ldc com/amap/api/col/s/bu
    //   28: monitorexit
    //   29: goto -> 38
    //   32: astore_0
    //   33: ldc com/amap/api/col/s/bu
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    //   38: getstatic com/amap/api/col/s/bu.f : Lcom/amap/api/col/s/bu;
    //   41: areturn
    // Exception table:
    //   from	to	target	type
    //   9	26	32	finally
    //   26	29	32	finally
    //   33	36	32	finally
  }
  
  private void a(String paramString, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic myLooper : ()Landroid/os/Looper;
    //   5: invokestatic getMainLooper : ()Landroid/os/Looper;
    //   8: if_acmpne -> 27
    //   11: new com/amap/api/col/s/bu$1
    //   14: dup
    //   15: aload_0
    //   16: aload_1
    //   17: iload_2
    //   18: invokespecial <init> : (Lcom/amap/api/col/s/bu;Ljava/lang/String;I)V
    //   21: invokevirtual start : ()V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_1
    //   28: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
    //   31: astore_1
    //   32: aload_1
    //   33: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   36: istore_3
    //   37: iload_3
    //   38: ifne -> 177
    //   41: iload_2
    //   42: iconst_1
    //   43: iand
    //   44: ifle -> 93
    //   47: getstatic android/os/Build$VERSION.SDK_INT : I
    //   50: bipush #23
    //   52: if_icmplt -> 74
    //   55: aload_0
    //   56: getfield d : Landroid/content/Context;
    //   59: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   62: aload_0
    //   63: getfield c : Ljava/lang/String;
    //   66: aload_1
    //   67: invokestatic putString : (Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    //   70: pop
    //   71: goto -> 93
    //   74: aload_0
    //   75: getfield d : Landroid/content/Context;
    //   78: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   81: aload_0
    //   82: getfield c : Ljava/lang/String;
    //   85: aload_1
    //   86: invokestatic putString : (Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Z
    //   89: pop
    //   90: goto -> 93
    //   93: iload_2
    //   94: bipush #16
    //   96: iand
    //   97: ifle -> 112
    //   100: aload_0
    //   101: getfield d : Landroid/content/Context;
    //   104: aload_0
    //   105: getfield c : Ljava/lang/String;
    //   108: aload_1
    //   109: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   112: iload_2
    //   113: sipush #256
    //   116: iand
    //   117: ifle -> 177
    //   120: aload_0
    //   121: getfield d : Landroid/content/Context;
    //   124: getstatic com/amap/api/col/s/bu.a : Ljava/lang/String;
    //   127: iconst_0
    //   128: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   131: invokeinterface edit : ()Landroid/content/SharedPreferences$Editor;
    //   136: astore #4
    //   138: aload #4
    //   140: aload_0
    //   141: getfield c : Ljava/lang/String;
    //   144: aload_1
    //   145: invokeinterface putString : (Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
    //   150: pop
    //   151: getstatic android/os/Build$VERSION.SDK_INT : I
    //   154: bipush #9
    //   156: if_icmplt -> 169
    //   159: aload #4
    //   161: invokeinterface apply : ()V
    //   166: aload_0
    //   167: monitorexit
    //   168: return
    //   169: aload #4
    //   171: invokeinterface commit : ()Z
    //   176: pop
    //   177: aload_0
    //   178: monitorexit
    //   179: return
    //   180: astore_1
    //   181: aload_0
    //   182: monitorexit
    //   183: aload_1
    //   184: athrow
    //   185: astore #4
    //   187: goto -> 93
    // Exception table:
    //   from	to	target	type
    //   2	24	180	finally
    //   27	37	180	finally
    //   47	71	185	java/lang/Exception
    //   47	71	180	finally
    //   74	90	185	java/lang/Exception
    //   74	90	180	finally
    //   100	112	180	finally
    //   120	166	180	finally
    //   169	177	180	finally
  }
  
  public final void a(String paramString) {
    this.c = paramString;
  }
  
  public final void b(String paramString) {
    List<String> list = this.b;
    if (list != null) {
      list.clear();
      this.b.add(paramString);
    } 
    a(paramString, 273);
  }
  
  static final class a extends Handler {
    private final WeakReference<bu> a;
    
    a(Looper param1Looper, bu param1bu) {
      super(param1Looper);
      this.a = new WeakReference<bu>(param1bu);
    }
    
    a(bu param1bu) {
      this.a = new WeakReference<bu>(param1bu);
    }
    
    public final void handleMessage(Message param1Message) {
      bu bu = this.a.get();
      if (bu == null)
        return; 
      if (param1Message != null) {
        if (param1Message.obj == null)
          return; 
        bu.a(bu, (String)param1Message.obj, param1Message.what);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */