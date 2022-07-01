package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.bytedance.sdk.openadsdk.multipro.e;

public class a {
  public static int a(Context paramContext, String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   2: monitorenter
    //   3: aload_2
    //   4: ifnull -> 90
    //   7: aload_1
    //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   11: istore #6
    //   13: iload #6
    //   15: ifeq -> 21
    //   18: goto -> 90
    //   21: aload_0
    //   22: invokestatic a : (Landroid/content/Context;)Landroid/content/ContentResolver;
    //   25: astore_0
    //   26: aload_0
    //   27: ifnull -> 79
    //   30: new java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: astore #7
    //   39: aload #7
    //   41: invokestatic a : ()Ljava/lang/String;
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload #7
    //   50: aload_1
    //   51: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_0
    //   56: aload #7
    //   58: invokevirtual toString : ()Ljava/lang/String;
    //   61: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   64: aload_2
    //   65: aload_3
    //   66: aload #4
    //   68: invokevirtual update : (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   71: istore #5
    //   73: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   75: monitorexit
    //   76: iload #5
    //   78: ireturn
    //   79: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   81: monitorexit
    //   82: iconst_0
    //   83: ireturn
    //   84: astore_0
    //   85: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   87: monitorexit
    //   88: aload_0
    //   89: athrow
    //   90: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   92: monitorexit
    //   93: iconst_0
    //   94: ireturn
    //   95: astore_0
    //   96: goto -> 79
    // Exception table:
    //   from	to	target	type
    //   7	13	84	finally
    //   21	26	95	finally
    //   30	73	95	finally
  }
  
  public static int a(Context paramContext, String paramString1, String paramString2, String[] paramArrayOfString) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: istore #5
    //   9: iload #5
    //   11: ifeq -> 19
    //   14: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   16: monitorexit
    //   17: iconst_0
    //   18: ireturn
    //   19: aload_0
    //   20: invokestatic a : (Landroid/content/Context;)Landroid/content/ContentResolver;
    //   23: astore_0
    //   24: aload_0
    //   25: ifnull -> 75
    //   28: new java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore #6
    //   37: aload #6
    //   39: invokestatic a : ()Ljava/lang/String;
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #6
    //   48: aload_1
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_0
    //   54: aload #6
    //   56: invokevirtual toString : ()Ljava/lang/String;
    //   59: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   62: aload_2
    //   63: aload_3
    //   64: invokevirtual delete : (Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   67: istore #4
    //   69: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   71: monitorexit
    //   72: iload #4
    //   74: ireturn
    //   75: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   77: monitorexit
    //   78: iconst_0
    //   79: ireturn
    //   80: astore_0
    //   81: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   83: monitorexit
    //   84: aload_0
    //   85: athrow
    //   86: astore_0
    //   87: goto -> 75
    // Exception table:
    //   from	to	target	type
    //   3	9	80	finally
    //   19	24	86	finally
    //   28	69	86	finally
  }
  
  private static ContentResolver a(Context paramContext) {
    Context context = paramContext;
    if (paramContext == null)
      try {
        return context.getContentResolver();
      } finally {
        paramContext = null;
      }  
    return context.getContentResolver();
  }
  
  public static Cursor a(Context paramContext, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: istore #8
    //   9: iload #8
    //   11: ifeq -> 19
    //   14: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   16: monitorexit
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: invokestatic a : (Landroid/content/Context;)Landroid/content/ContentResolver;
    //   23: astore_0
    //   24: aload_0
    //   25: ifnull -> 77
    //   28: new java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore #5
    //   37: aload #5
    //   39: invokestatic a : ()Ljava/lang/String;
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #5
    //   48: aload_1
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_0
    //   54: aload #5
    //   56: invokevirtual toString : ()Ljava/lang/String;
    //   59: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   62: aload_2
    //   63: aload_3
    //   64: aload #4
    //   66: aload #7
    //   68: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   71: astore_0
    //   72: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   74: monitorexit
    //   75: aload_0
    //   76: areturn
    //   77: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   79: monitorexit
    //   80: aconst_null
    //   81: areturn
    //   82: astore_0
    //   83: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   85: monitorexit
    //   86: aload_0
    //   87: athrow
    //   88: astore_0
    //   89: goto -> 77
    // Exception table:
    //   from	to	target	type
    //   3	9	82	finally
    //   19	24	88	finally
    //   28	72	88	finally
  }
  
  private static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e.b);
    stringBuilder.append("/");
    stringBuilder.append("t_db");
    stringBuilder.append("/");
    stringBuilder.append("ttopensdk.db");
    stringBuilder.append("/");
    return stringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   2: monitorenter
    //   3: aload_1
    //   4: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   7: istore_2
    //   8: iload_2
    //   9: ifeq -> 16
    //   12: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: invokestatic a : (Landroid/content/Context;)Landroid/content/ContentResolver;
    //   20: astore_0
    //   21: aload_0
    //   22: ifnull -> 87
    //   25: new java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial <init> : ()V
    //   32: astore_3
    //   33: aload_3
    //   34: invokestatic a : ()Ljava/lang/String;
    //   37: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: ldc 'unknown'
    //   44: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload_3
    //   49: ldc '/'
    //   51: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_3
    //   56: ldc 'execSQL'
    //   58: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_3
    //   63: ldc '?sql='
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: aload_1
    //   71: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_0
    //   76: aload_3
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   83: invokevirtual getType : (Landroid/net/Uri;)Ljava/lang/String;
    //   86: pop
    //   87: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   89: monitorexit
    //   90: return
    //   91: astore_0
    //   92: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   94: monitorexit
    //   95: aload_0
    //   96: athrow
    //   97: astore_0
    //   98: goto -> 87
    // Exception table:
    //   from	to	target	type
    //   3	8	91	finally
    //   16	21	97	finally
    //   25	87	97	finally
  }
  
  public static void a(Context paramContext, String paramString, ContentValues paramContentValues) {
    // Byte code:
    //   0: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   2: monitorenter
    //   3: aload_2
    //   4: ifnull -> 77
    //   7: aload_1
    //   8: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   11: istore_3
    //   12: iload_3
    //   13: ifeq -> 19
    //   16: goto -> 77
    //   19: aload_0
    //   20: invokestatic a : (Landroid/content/Context;)Landroid/content/ContentResolver;
    //   23: astore_0
    //   24: aload_0
    //   25: ifnull -> 67
    //   28: new java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial <init> : ()V
    //   35: astore #4
    //   37: aload #4
    //   39: invokestatic a : ()Ljava/lang/String;
    //   42: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload #4
    //   48: aload_1
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_0
    //   54: aload #4
    //   56: invokevirtual toString : ()Ljava/lang/String;
    //   59: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   62: aload_2
    //   63: invokevirtual insert : (Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   66: pop
    //   67: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   69: monitorexit
    //   70: return
    //   71: astore_0
    //   72: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   74: monitorexit
    //   75: aload_0
    //   76: athrow
    //   77: ldc com/bytedance/sdk/openadsdk/multipro/a/a
    //   79: monitorexit
    //   80: return
    //   81: astore_0
    //   82: goto -> 67
    // Exception table:
    //   from	to	target	type
    //   7	12	71	finally
    //   19	24	81	finally
    //   28	67	81	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\multipro\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */