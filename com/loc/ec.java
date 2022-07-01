package com.loc;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ec {
  public static int a = 1;
  
  public static int b = 2;
  
  private static ec e;
  
  private long c = 0L;
  
  private boolean d = false;
  
  private ArrayList<String> f = new ArrayList<String>();
  
  private dq g = new dq();
  
  private dq h = new dq();
  
  private long i = 120000L;
  
  private Context j;
  
  private String k;
  
  private boolean l = false;
  
  private ec(Context paramContext) {
    this.j = paramContext;
  }
  
  public static ec a(Context paramContext) {
    // Byte code:
    //   0: ldc com/loc/ec
    //   2: monitorenter
    //   3: getstatic com/loc/ec.e : Lcom/loc/ec;
    //   6: ifnonnull -> 20
    //   9: new com/loc/ec
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/loc/ec.e : Lcom/loc/ec;
    //   20: getstatic com/loc/ec.e : Lcom/loc/ec;
    //   23: astore_0
    //   24: ldc com/loc/ec
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/loc/ec
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  private dq b(int paramInt) {
    return (paramInt == b) ? this.h : this.g;
  }
  
  private void b(boolean paramBoolean, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_1
    //   3: ifne -> 24
    //   6: invokestatic o : ()Z
    //   9: ifne -> 24
    //   12: aload_0
    //   13: getfield l : Z
    //   16: istore_1
    //   17: iload_1
    //   18: ifeq -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield c : J
    //   28: lconst_0
    //   29: lcmp
    //   30: ifeq -> 85
    //   33: invokestatic currentTimeMillis : ()J
    //   36: lstore #5
    //   38: aload_0
    //   39: getfield c : J
    //   42: lstore #7
    //   44: aload_0
    //   45: getfield i : J
    //   48: lstore #9
    //   50: lload #5
    //   52: lload #7
    //   54: lsub
    //   55: lload #9
    //   57: lcmp
    //   58: ifge -> 64
    //   61: aload_0
    //   62: monitorexit
    //   63: return
    //   64: aload_0
    //   65: getfield c : J
    //   68: lstore #7
    //   70: lload #5
    //   72: lload #7
    //   74: lsub
    //   75: ldc2_w 60000
    //   78: lcmp
    //   79: ifge -> 85
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_0
    //   86: invokestatic currentTimeMillis : ()J
    //   89: putfield c : J
    //   92: aload_0
    //   93: iconst_1
    //   94: putfield l : Z
    //   97: invokestatic currentThread : ()Ljava/lang/Thread;
    //   100: invokevirtual getStackTrace : ()[Ljava/lang/StackTraceElement;
    //   103: astore #11
    //   105: new java/lang/StringBuffer
    //   108: dup
    //   109: invokespecial <init> : ()V
    //   112: astore #12
    //   114: aload #11
    //   116: arraylength
    //   117: istore #4
    //   119: iconst_0
    //   120: istore_3
    //   121: iload_3
    //   122: iload #4
    //   124: if_icmpge -> 217
    //   127: aload #11
    //   129: iload_3
    //   130: aaload
    //   131: astore #13
    //   133: new java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial <init> : ()V
    //   140: astore #14
    //   142: aload #14
    //   144: aload #13
    //   146: invokevirtual getClassName : ()Ljava/lang/String;
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload #14
    //   155: ldc '('
    //   157: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload #14
    //   163: aload #13
    //   165: invokevirtual getMethodName : ()Ljava/lang/String;
    //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload #14
    //   174: ldc ':'
    //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload #14
    //   182: aload #13
    //   184: invokevirtual getLineNumber : ()I
    //   187: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload #14
    //   193: ldc '),'
    //   195: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload #12
    //   201: aload #14
    //   203: invokevirtual toString : ()Ljava/lang/String;
    //   206: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   209: pop
    //   210: iload_3
    //   211: iconst_1
    //   212: iadd
    //   213: istore_3
    //   214: goto -> 121
    //   217: invokestatic d : ()Ljava/util/concurrent/ExecutorService;
    //   220: new com/loc/ec$1
    //   223: dup
    //   224: aload_0
    //   225: iload_2
    //   226: invokespecial <init> : (Lcom/loc/ec;I)V
    //   229: invokeinterface submit : (Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    //   234: pop
    //   235: aload_0
    //   236: monitorexit
    //   237: return
    //   238: astore #11
    //   240: aload_0
    //   241: monitorexit
    //   242: aload #11
    //   244: athrow
    // Exception table:
    //   from	to	target	type
    //   6	17	238	finally
    //   24	50	238	finally
    //   64	70	238	finally
    //   85	119	238	finally
    //   133	210	238	finally
    //   217	235	238	finally
  }
  
  private static String c(int paramInt) {
    return (paramInt == b) ? "last_ip_6" : "last_ip_4";
  }
  
  private void d(int paramInt) {
    if (b(paramInt).d()) {
      SharedPreferences.Editor editor = eo.a(this.j, "cbG9jaXA");
      eo.a(editor, c(paramInt));
      eo.a(editor);
      b(paramInt).a(false);
    } 
  }
  
  private String e(int paramInt) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: iconst_0
    //   4: iload_1
    //   5: invokespecial b : (ZI)V
    //   8: aload_0
    //   9: iload_1
    //   10: invokespecial b : (I)Lcom/loc/dq;
    //   13: invokevirtual a : ()[Ljava/lang/String;
    //   16: astore #5
    //   18: aload #5
    //   20: ifnull -> 92
    //   23: aload #5
    //   25: arraylength
    //   26: ifle -> 92
    //   29: aload #5
    //   31: arraylength
    //   32: istore_3
    //   33: iload_2
    //   34: iload_3
    //   35: if_icmpge -> 66
    //   38: aload #5
    //   40: iload_2
    //   41: aaload
    //   42: astore #4
    //   44: aload_0
    //   45: getfield f : Ljava/util/ArrayList;
    //   48: aload #4
    //   50: invokevirtual contains : (Ljava/lang/Object;)Z
    //   53: ifne -> 59
    //   56: goto -> 69
    //   59: iload_2
    //   60: iconst_1
    //   61: iadd
    //   62: istore_2
    //   63: goto -> 33
    //   66: aconst_null
    //   67: astore #4
    //   69: aload #4
    //   71: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   74: ifeq -> 79
    //   77: aconst_null
    //   78: areturn
    //   79: aload_0
    //   80: iload_1
    //   81: invokespecial b : (I)Lcom/loc/dq;
    //   84: aload #4
    //   86: invokevirtual a : (Ljava/lang/String;)V
    //   89: aload #4
    //   91: areturn
    //   92: aload_0
    //   93: getfield j : Landroid/content/Context;
    //   96: ldc 'cbG9jaXA'
    //   98: iload_1
    //   99: invokestatic c : (I)Ljava/lang/String;
    //   102: aconst_null
    //   103: invokestatic a : (Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   106: astore #4
    //   108: aload #4
    //   110: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   113: ifne -> 157
    //   116: aload_0
    //   117: getfield f : Ljava/util/ArrayList;
    //   120: aload #4
    //   122: invokevirtual contains : (Ljava/lang/Object;)Z
    //   125: ifne -> 157
    //   128: aload_0
    //   129: iload_1
    //   130: invokespecial b : (I)Lcom/loc/dq;
    //   133: aload #4
    //   135: invokevirtual a : (Ljava/lang/String;)V
    //   138: aload_0
    //   139: iload_1
    //   140: invokespecial b : (I)Lcom/loc/dq;
    //   143: aload #4
    //   145: invokevirtual b : (Ljava/lang/String;)V
    //   148: aload_0
    //   149: iload_1
    //   150: invokespecial b : (I)Lcom/loc/dq;
    //   153: iconst_1
    //   154: invokevirtual a : (Z)V
    //   157: aload_0
    //   158: iload_1
    //   159: invokespecial b : (I)Lcom/loc/dq;
    //   162: invokevirtual b : ()Ljava/lang/String;
    //   165: areturn
  }
  
  public final String a(ef paramef, int paramInt) {
    try {
      if (!ei.p())
        return null; 
      return null;
    } finally {
      paramef = null;
    } 
  }
  
  public final void a(int paramInt) {
    if (!b(paramInt).e()) {
      this.f.add(b(paramInt).b());
      d(paramInt);
      b(true, paramInt);
      return;
    } 
    d(paramInt);
  }
  
  public final void a(boolean paramBoolean, int paramInt) {
    b(paramInt).b(paramBoolean);
    if (paramBoolean) {
      String str2 = b(paramInt).c();
      String str1 = b(paramInt).b();
      if (!TextUtils.isEmpty(str1) && !str1.equals(str2)) {
        SharedPreferences.Editor editor = eo.a(this.j, "cbG9jaXA");
        eo.a(editor, c(paramInt), str1);
        eo.a(editor);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\ec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */