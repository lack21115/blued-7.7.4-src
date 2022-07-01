package com.bytedance.sdk.openadsdk.downloadnew.a.a;

import android.content.Context;
import com.bytedance.sdk.adnet.b.j;
import com.bytedance.sdk.adnet.core.n;
import com.bytedance.sdk.adnet.err.a;
import com.ss.android.a.a.a.f;
import com.ss.android.a.a.a.m;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class c implements f {
  private final WeakReference<Context> a;
  
  public c(Context paramContext) {
    this.a = new WeakReference<Context>(paramContext);
  }
  
  public void a(String paramString1, String paramString2, Map<String, Object> paramMap, m paramm) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual hashCode : ()I
    //   4: istore #5
    //   6: iconst_0
    //   7: istore #6
    //   9: iload #5
    //   11: ldc 70454
    //   13: if_icmpeq -> 41
    //   16: iload #5
    //   18: ldc 2461856
    //   20: if_icmpeq -> 26
    //   23: goto -> 56
    //   26: aload_1
    //   27: ldc 'POST'
    //   29: invokevirtual equals : (Ljava/lang/Object;)Z
    //   32: ifeq -> 56
    //   35: iconst_1
    //   36: istore #5
    //   38: goto -> 59
    //   41: aload_1
    //   42: ldc 'GET'
    //   44: invokevirtual equals : (Ljava/lang/Object;)Z
    //   47: ifeq -> 56
    //   50: iconst_0
    //   51: istore #5
    //   53: goto -> 59
    //   56: iconst_m1
    //   57: istore #5
    //   59: iload #5
    //   61: ifeq -> 70
    //   64: iload #5
    //   66: iconst_1
    //   67: if_icmpeq -> 76
    //   70: iconst_0
    //   71: istore #5
    //   73: goto -> 79
    //   76: iconst_1
    //   77: istore #5
    //   79: invokestatic a : ()Lcom/bytedance/sdk/adnet/b/i;
    //   82: astore_1
    //   83: new com/bytedance/sdk/openadsdk/downloadnew/a/a/c$1
    //   86: dup
    //   87: aload_0
    //   88: iload #5
    //   90: aload_2
    //   91: aload_1
    //   92: aload_3
    //   93: invokespecial <init> : (Lcom/bytedance/sdk/openadsdk/downloadnew/a/a/c;ILjava/lang/String;Lcom/bytedance/sdk/adnet/core/n$a;Ljava/util/Map;)V
    //   96: invokestatic a : ()Landroid/content/Context;
    //   99: invokestatic a : (Landroid/content/Context;)Lcom/bytedance/sdk/openadsdk/g/e;
    //   102: invokevirtual d : ()Lcom/bytedance/sdk/adnet/core/m;
    //   105: invokevirtual build : (Lcom/bytedance/sdk/adnet/core/m;)V
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_1
    //   111: invokevirtual b : ()Lcom/bytedance/sdk/adnet/core/n;
    //   114: astore_1
    //   115: goto -> 120
    //   118: aconst_null
    //   119: astore_1
    //   120: aload_1
    //   121: ifnull -> 151
    //   124: aload_1
    //   125: invokevirtual a : ()Z
    //   128: ifeq -> 151
    //   131: aload #4
    //   133: ifnull -> 248
    //   136: aload #4
    //   138: aload_1
    //   139: getfield a : Ljava/lang/Object;
    //   142: checkcast java/lang/String
    //   145: invokeinterface a : (Ljava/lang/String;)V
    //   150: return
    //   151: iload #6
    //   153: istore #5
    //   155: aload_1
    //   156: ifnull -> 173
    //   159: iload #6
    //   161: istore #5
    //   163: aload_1
    //   164: getfield c : Lcom/bytedance/sdk/adnet/err/VAdError;
    //   167: ifnull -> 173
    //   170: iconst_1
    //   171: istore #5
    //   173: iload #5
    //   175: ifeq -> 186
    //   178: aload_1
    //   179: getfield c : Lcom/bytedance/sdk/adnet/err/VAdError;
    //   182: invokevirtual getMessage : ()Ljava/lang/String;
    //   185: astore_2
    //   186: aload_2
    //   187: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   190: istore #7
    //   192: aload #4
    //   194: ifnull -> 248
    //   197: iload #7
    //   199: iconst_1
    //   200: ixor
    //   201: ifeq -> 215
    //   204: aload_1
    //   205: getfield c : Lcom/bytedance/sdk/adnet/err/VAdError;
    //   208: invokevirtual getMessage : ()Ljava/lang/String;
    //   211: astore_1
    //   212: goto -> 233
    //   215: aload_1
    //   216: ifnull -> 230
    //   219: aload_1
    //   220: getfield h : J
    //   223: invokestatic valueOf : (J)Ljava/lang/String;
    //   226: astore_1
    //   227: goto -> 233
    //   230: ldc ''
    //   232: astore_1
    //   233: aload #4
    //   235: new java/lang/Exception
    //   238: dup
    //   239: aload_1
    //   240: invokespecial <init> : (Ljava/lang/String;)V
    //   243: invokeinterface a : (Ljava/lang/Throwable;)V
    //   248: return
    //   249: astore_1
    //   250: goto -> 118
    // Exception table:
    //   from	to	target	type
    //   110	115	249	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\a\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */