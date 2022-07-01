package com.ishumei.l1111l111111Il;

import android.content.Context;
import android.content.SharedPreferences;
import com.ishumei.l111l11111I1l.l111l11111lIl;
import com.ishumei.l111l1111llIl.l111l1111lI1l;
import java.io.IOException;

public class l111l1111l1Il {
  private static final String l1111l111111Il = "sm";
  
  private static final String l111l11111lIl = "seq";
  
  private static l111l1111l1Il l111l1111l1Il;
  
  private int l111l11111I1l = 0;
  
  private Context l111l11111Il = null;
  
  private l111l11111lIl l111l1111llIl = new l111l11111lIl(this, true, 7) {
      public final void run() {
        try {
          l111l1111l1Il l111l1111l1Il1 = this.l111l11111lIl;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(l111l1111l1Il.l1111l111111Il(this.l111l11111lIl));
          return;
        } finally {
          Exception exception = null;
        } 
      }
    };
  
  private l111l1111l1Il() {
    this.l111l11111Il = l111l1111llIl.l1111l111111Il.l111l11111Il;
  }
  
  public static l111l1111l1Il l1111l111111Il() {
    // Byte code:
    //   0: getstatic com/ishumei/l1111l111111Il/l111l1111l1Il.l111l1111l1Il : Lcom/ishumei/l1111l111111Il/l111l1111l1Il;
    //   3: ifnonnull -> 37
    //   6: ldc com/ishumei/l1111l111111Il/l111l1111l1Il
    //   8: monitorenter
    //   9: getstatic com/ishumei/l1111l111111Il/l111l1111l1Il.l111l1111l1Il : Lcom/ishumei/l1111l111111Il/l111l1111l1Il;
    //   12: ifnonnull -> 25
    //   15: new com/ishumei/l1111l111111Il/l111l1111l1Il
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/ishumei/l1111l111111Il/l111l1111l1Il.l111l1111l1Il : Lcom/ishumei/l1111l111111Il/l111l1111l1Il;
    //   25: ldc com/ishumei/l1111l111111Il/l111l1111l1Il
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/ishumei/l1111l111111Il/l111l1111l1Il
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/ishumei/l1111l111111Il/l111l1111l1Il.l111l1111l1Il : Lcom/ishumei/l1111l111111Il/l111l1111l1Il;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private void l1111l111111Il(String paramString) {
    try {
      if (this.l111l11111Il != null) {
        SharedPreferences.Editor editor = this.l111l11111Il.getSharedPreferences("seq", 0).edit();
        editor.putString("seq", paramString);
        if (editor.commit())
          return; 
        throw new IOException("editor commit failed");
      } 
      throw new Exception("mContext == null");
    } catch (Exception exception) {
      throw new Exception(exception);
    } 
  }
  
  private String l111l11111I1l() {
    try {
      if (this.l111l11111Il != null) {
        String str = this.l111l11111Il.getSharedPreferences("seq", 0).getString("seq", null);
        if (!l111l1111lI1l.l1111l111111Il(str))
          return str; 
        throw new Exception("from shared preference empty id");
      } 
      throw new Exception("mContext == null");
    } catch (Exception exception) {
      throw new Exception(exception);
    } 
  }
  
  private String l111l11111Il() {
    try {
      String str = l111l11111I1l();
      try {
        boolean bool = l111l1111lI1l.l111l11111lIl(str);
        String str1 = str;
        return bool ? str : str1;
      } catch (Exception null) {
        return str;
      } 
    } catch (Exception exception) {
      exception = null;
    } 
    return (String)exception;
  }
  
  public final String l111l11111lIl() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l111l11111I1l : I
    //   6: istore_1
    //   7: iload_1
    //   8: ifne -> 39
    //   11: aconst_null
    //   12: astore_3
    //   13: aload_0
    //   14: invokespecial l111l11111Il : ()Ljava/lang/String;
    //   17: astore #4
    //   19: aload #4
    //   21: astore_3
    //   22: aload_3
    //   23: invokestatic l111l11111lIl : (Ljava/lang/String;)Z
    //   26: istore_2
    //   27: iload_2
    //   28: ifeq -> 39
    //   31: aload_0
    //   32: aload_3
    //   33: invokestatic parseInt : (Ljava/lang/String;)I
    //   36: putfield l111l11111I1l : I
    //   39: aload_0
    //   40: aload_0
    //   41: getfield l111l11111I1l : I
    //   44: iconst_1
    //   45: iadd
    //   46: putfield l111l11111I1l : I
    //   49: aload_0
    //   50: getfield l111l1111llIl : Lcom/ishumei/l111l11111I1l/l111l11111lIl;
    //   53: invokevirtual l1111l111111Il : ()V
    //   56: new java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: astore_3
    //   64: aload_3
    //   65: aload_0
    //   66: getfield l111l11111I1l : I
    //   69: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_3
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: astore_3
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_3
    //   81: areturn
    //   82: astore_3
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_3
    //   86: athrow
    //   87: astore #4
    //   89: goto -> 22
    //   92: astore_3
    //   93: goto -> 39
    // Exception table:
    //   from	to	target	type
    //   2	7	82	finally
    //   13	19	87	java/lang/Exception
    //   13	19	82	finally
    //   22	27	82	finally
    //   31	39	92	java/lang/Exception
    //   31	39	82	finally
    //   39	78	82	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l1111l111111Il\l111l1111l1Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */