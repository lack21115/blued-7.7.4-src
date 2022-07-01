package com.ishumei.l111l11111lIl.l111l11111lIl;

import android.content.SharedPreferences;
import com.ishumei.l111l1111llIl.l111l1111llIl;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class l1111l111111Il {
  private static final String l1111l111111Il = "fc_times";
  
  private static final String l111l11111I1l = "n";
  
  private static final String l111l11111Il = "t";
  
  private static final String l111l11111lIl = "l";
  
  private static final int l111l1111l1Il = 20;
  
  private static final int l111l1111llIl = -1048576;
  
  private SharedPreferences l111l1111lI1l;
  
  private List<String> l111l1111lIl = null;
  
  private l1111l111111Il() {
    try {
      return;
    } finally {
      Exception exception = null;
    } 
  }
  
  private static int l1111l111111Il(int paramInt) {
    int i = Math.abs(paramInt & 0xFFFFF);
    paramInt = i;
    if (i > 2880)
      paramInt = 2880; 
    return paramInt;
  }
  
  public static l1111l111111Il l1111l111111Il() {
    return l1111l111111Il.l1111l111111Il();
  }
  
  private void l111l11111Il() {
    HashSet<String> hashSet = new HashSet(this.l111l1111lI1l.getStringSet("t", new HashSet()));
    hashSet.add(String.valueOf(System.currentTimeMillis()));
    l111l1111llIl.l1111l111111Il(this.l111l1111lI1l, "t", hashSet);
  }
  
  private static int l111l11111lIl(int paramInt) {
    int i = paramInt >> 20;
    paramInt = i;
    if (i > 100)
      paramInt = 100; 
    return paramInt;
  }
  
  private static int l111l11111lIl(int paramInt1, int paramInt2) {
    return (paramInt2 << 20) + paramInt1;
  }
  
  private void l111l1111l1Il() {
    try {
      this.l111l1111lIl = new ArrayList<String>(this.l111l1111lI1l.getStringSet("t", new HashSet()));
      l111l1111llIl.l1111l111111Il(this.l111l1111lI1l, "l", System.currentTimeMillis());
      l111l1111llIl.l1111l111111Il(this.l111l1111lI1l, "t", new HashSet());
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  public final void l1111l111111Il(int paramInt1, int paramInt2) {
    /* monitor enter ThisExpression{ObjectType{com/ishumei/l111l11111lIl/l111l11111lIl/l1111l111111Il}} */
    try {
      SharedPreferences sharedPreferences = this.l111l1111lI1l;
      if (sharedPreferences == null) {
        /* monitor exit ThisExpression{ObjectType{com/ishumei/l111l11111lIl/l111l11111lIl/l1111l111111Il}} */
        return;
      } 
      if (paramInt1 <= 0 || paramInt2 <= 0) {
        l111l1111llIl.l1111l111111Il(this.l111l1111lI1l, "n", 0);
      } else {
        l111l1111llIl.l1111l111111Il(this.l111l1111lI1l, "n", (paramInt2 << 20) + paramInt1);
        /* monitor exit ThisExpression{ObjectType{com/ishumei/l111l11111lIl/l111l11111lIl/l1111l111111Il}} */
        return;
      } 
    } finally {
      Exception exception;
    } 
    /* monitor exit ThisExpression{ObjectType{com/ishumei/l111l11111lIl/l111l11111lIl/l1111l111111Il}} */
  }
  
  public final List<String> l111l11111I1l() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/util/ArrayList
    //   5: dup
    //   6: invokespecial <init> : ()V
    //   9: astore_1
    //   10: aload_0
    //   11: getfield l111l1111lIl : Ljava/util/List;
    //   14: astore_2
    //   15: aload_2
    //   16: ifnonnull -> 23
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_1
    //   22: areturn
    //   23: aload_1
    //   24: aload_0
    //   25: getfield l111l1111lIl : Ljava/util/List;
    //   28: invokeinterface addAll : (Ljava/util/Collection;)Z
    //   33: pop
    //   34: aload_0
    //   35: aconst_null
    //   36: putfield l111l1111lIl : Ljava/util/List;
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: areturn
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	43	finally
    //   23	39	43	finally
  }
  
  public final boolean l111l11111lIl() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield l111l1111lI1l : Landroid/content/SharedPreferences;
    //   6: astore #7
    //   8: aload #7
    //   10: ifnonnull -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iconst_1
    //   16: ireturn
    //   17: aload_0
    //   18: getfield l111l1111lI1l : Landroid/content/SharedPreferences;
    //   21: ldc 'n'
    //   23: iconst_0
    //   24: invokeinterface getInt : (Ljava/lang/String;I)I
    //   29: istore_3
    //   30: iload_3
    //   31: ifne -> 42
    //   34: aload_0
    //   35: invokespecial l111l1111l1Il : ()V
    //   38: aload_0
    //   39: monitorexit
    //   40: iconst_1
    //   41: ireturn
    //   42: aload_0
    //   43: getfield l111l1111lI1l : Landroid/content/SharedPreferences;
    //   46: ldc 'l'
    //   48: lconst_0
    //   49: invokeinterface getLong : (Ljava/lang/String;J)J
    //   54: lstore #5
    //   56: ldc 1048575
    //   58: iload_3
    //   59: iand
    //   60: invokestatic abs : (I)I
    //   63: istore_2
    //   64: iload_2
    //   65: istore_1
    //   66: iload_2
    //   67: sipush #2880
    //   70: if_icmple -> 77
    //   73: sipush #2880
    //   76: istore_1
    //   77: iload_1
    //   78: i2l
    //   79: ldc2_w 60000
    //   82: lmul
    //   83: invokestatic currentTimeMillis : ()J
    //   86: lload #5
    //   88: lsub
    //   89: invokestatic abs : (J)J
    //   92: lcmp
    //   93: ifge -> 104
    //   96: aload_0
    //   97: invokespecial l111l1111l1Il : ()V
    //   100: aload_0
    //   101: monitorexit
    //   102: iconst_1
    //   103: ireturn
    //   104: aload_0
    //   105: getfield l111l1111lI1l : Landroid/content/SharedPreferences;
    //   108: ldc 't'
    //   110: new java/util/HashSet
    //   113: dup
    //   114: invokespecial <init> : ()V
    //   117: invokeinterface getStringSet : (Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;
    //   122: invokeinterface size : ()I
    //   127: istore #4
    //   129: iload_3
    //   130: bipush #20
    //   132: ishr
    //   133: istore_2
    //   134: iload_2
    //   135: istore_1
    //   136: iload_2
    //   137: bipush #100
    //   139: if_icmple -> 145
    //   142: bipush #100
    //   144: istore_1
    //   145: iload #4
    //   147: iload_1
    //   148: if_icmplt -> 159
    //   151: aload_0
    //   152: invokespecial l111l1111l1Il : ()V
    //   155: aload_0
    //   156: monitorexit
    //   157: iconst_1
    //   158: ireturn
    //   159: new java/util/HashSet
    //   162: dup
    //   163: aload_0
    //   164: getfield l111l1111lI1l : Landroid/content/SharedPreferences;
    //   167: ldc 't'
    //   169: new java/util/HashSet
    //   172: dup
    //   173: invokespecial <init> : ()V
    //   176: invokeinterface getStringSet : (Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;
    //   181: invokespecial <init> : (Ljava/util/Collection;)V
    //   184: astore #7
    //   186: aload #7
    //   188: invokestatic currentTimeMillis : ()J
    //   191: invokestatic valueOf : (J)Ljava/lang/String;
    //   194: invokeinterface add : (Ljava/lang/Object;)Z
    //   199: pop
    //   200: aload_0
    //   201: getfield l111l1111lI1l : Landroid/content/SharedPreferences;
    //   204: ldc 't'
    //   206: aload #7
    //   208: invokestatic l1111l111111Il : (Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/util/Set;)V
    //   211: aload_0
    //   212: monitorexit
    //   213: iconst_0
    //   214: ireturn
    //   215: aload_0
    //   216: invokespecial l111l1111l1Il : ()V
    //   219: aload_0
    //   220: monitorexit
    //   221: iconst_1
    //   222: ireturn
    //   223: astore #7
    //   225: aload_0
    //   226: monitorexit
    //   227: aload #7
    //   229: athrow
    //   230: astore #7
    //   232: goto -> 215
    // Exception table:
    //   from	to	target	type
    //   2	8	230	finally
    //   17	30	230	finally
    //   34	38	230	finally
    //   42	64	230	finally
    //   77	100	230	finally
    //   104	129	230	finally
    //   151	155	230	finally
    //   159	211	230	finally
    //   215	219	223	finally
  }
  
  static final class l1111l111111Il {
    private static final l1111l111111Il l1111l111111Il = new l1111l111111Il((byte)0);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\ishumei\l111l11111lIl\l111l11111lIl\l1111l111111Il.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */