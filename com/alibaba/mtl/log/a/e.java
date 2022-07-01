package com.alibaba.mtl.log.a;

import android.text.TextUtils;
import com.alibaba.mtl.log.c.c;
import org.json.JSONObject;

public class e {
  public static int f() {
    String str = a.f();
    boolean bool = TextUtils.isEmpty(str);
    byte b = 0;
    int i = b;
    if (!bool)
      try {
        JSONObject jSONObject = new JSONObject(str);
        i = b;
        return i;
      } finally {
        str = null;
      }  
    return i;
  }
  
  public static void i(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifne -> 318
    //   7: new org/json/JSONObject
    //   10: dup
    //   11: aload_0
    //   12: invokespecial <init> : (Ljava/lang/String;)V
    //   15: astore_2
    //   16: aload_2
    //   17: ldc 'SYSTEM'
    //   19: invokevirtual has : (Ljava/lang/String;)Z
    //   22: ifeq -> 318
    //   25: ldc 'SystemConfig'
    //   27: iconst_2
    //   28: anewarray java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: ldc 'server system config '
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: aload_0
    //   39: aastore
    //   40: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aload_2
    //   44: ldc 'SYSTEM'
    //   46: invokevirtual optJSONObject : (Ljava/lang/String;)Lorg/json/JSONObject;
    //   49: astore_0
    //   50: aload_0
    //   51: ifnull -> 318
    //   54: aload_0
    //   55: ldc 'bg_interval'
    //   57: invokevirtual has : (Ljava/lang/String;)Z
    //   60: ifeq -> 96
    //   63: new java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial <init> : ()V
    //   70: astore_2
    //   71: aload_2
    //   72: aload_0
    //   73: ldc 'bg_interval'
    //   75: invokevirtual getInt : (Ljava/lang/String;)I
    //   78: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_2
    //   83: ldc ''
    //   85: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_2
    //   90: invokevirtual toString : ()Ljava/lang/String;
    //   93: invokestatic f : (Ljava/lang/String;)V
    //   96: aload_0
    //   97: ldc 'fg_interval'
    //   99: invokevirtual has : (Ljava/lang/String;)Z
    //   102: ifeq -> 138
    //   105: new java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial <init> : ()V
    //   112: astore_2
    //   113: aload_2
    //   114: aload_0
    //   115: ldc 'fg_interval'
    //   117: invokevirtual getInt : (Ljava/lang/String;)I
    //   120: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_2
    //   125: ldc ''
    //   127: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_2
    //   132: invokevirtual toString : ()Ljava/lang/String;
    //   135: invokestatic g : (Ljava/lang/String;)V
    //   138: ldc 'SystemConfig'
    //   140: iconst_2
    //   141: anewarray java/lang/Object
    //   144: dup
    //   145: iconst_0
    //   146: ldc 'UTDC.bSendToNewLogStore:'
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: getstatic com/alibaba/mtl/log/a.r : Z
    //   154: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   157: aastore
    //   158: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: ldc 'SystemConfig'
    //   163: iconst_2
    //   164: anewarray java/lang/Object
    //   167: dup
    //   168: iconst_0
    //   169: ldc 'Config.BACKGROUND_PERIOD:'
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: invokestatic b : ()J
    //   177: invokestatic valueOf : (J)Ljava/lang/Long;
    //   180: aastore
    //   181: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   184: ldc 'SystemConfig'
    //   186: iconst_2
    //   187: anewarray java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: ldc 'Config.FOREGROUND_PERIOD:'
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: invokestatic a : ()J
    //   200: invokestatic valueOf : (J)Ljava/lang/Long;
    //   203: aastore
    //   204: invokestatic a : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: aload_0
    //   208: ldc 'discard'
    //   210: invokevirtual has : (Ljava/lang/String;)Z
    //   213: ifeq -> 258
    //   216: aload_0
    //   217: ldc 'discard'
    //   219: invokevirtual getInt : (Ljava/lang/String;)I
    //   222: istore_1
    //   223: iload_1
    //   224: iconst_1
    //   225: if_icmpne -> 241
    //   228: iconst_1
    //   229: putstatic com/alibaba/mtl/log/a/a.A : Z
    //   232: invokestatic a : ()Lcom/alibaba/mtl/log/d/a;
    //   235: invokevirtual stop : ()V
    //   238: goto -> 274
    //   241: iload_1
    //   242: ifne -> 274
    //   245: iconst_0
    //   246: putstatic com/alibaba/mtl/log/a/a.A : Z
    //   249: invokestatic a : ()Lcom/alibaba/mtl/log/d/a;
    //   252: invokevirtual start : ()V
    //   255: goto -> 274
    //   258: getstatic com/alibaba/mtl/log/a/a.A : Z
    //   261: ifeq -> 274
    //   264: iconst_0
    //   265: putstatic com/alibaba/mtl/log/a/a.A : Z
    //   268: invokestatic a : ()Lcom/alibaba/mtl/log/d/a;
    //   271: invokevirtual start : ()V
    //   274: aload_0
    //   275: ldc 'cdb'
    //   277: invokevirtual has : (Ljava/lang/String;)Z
    //   280: ifeq -> 318
    //   283: aload_0
    //   284: ldc 'cdb'
    //   286: invokevirtual getInt : (Ljava/lang/String;)I
    //   289: invokestatic f : ()I
    //   292: if_icmple -> 318
    //   295: invokestatic a : ()Lcom/alibaba/mtl/log/e/r;
    //   298: new com/alibaba/mtl/log/a/e$1
    //   301: dup
    //   302: invokespecial <init> : ()V
    //   305: invokevirtual b : (Ljava/lang/Runnable;)V
    //   308: return
    //   309: astore_0
    //   310: ldc 'SystemConfig'
    //   312: ldc 'updateconfig'
    //   314: aload_0
    //   315: invokestatic a : (Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    //   318: return
    //   319: astore_2
    //   320: goto -> 96
    //   323: astore_2
    //   324: goto -> 138
    //   327: astore_2
    //   328: goto -> 274
    //   331: astore_0
    //   332: return
    // Exception table:
    //   from	to	target	type
    //   7	50	309	finally
    //   54	96	319	finally
    //   96	138	323	finally
    //   138	207	309	finally
    //   207	223	327	finally
    //   228	238	327	finally
    //   245	255	327	finally
    //   258	274	327	finally
    //   274	308	331	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */