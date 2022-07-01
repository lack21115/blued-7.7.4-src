package com.qq.e.comm.plugin.rewardvideo.a;

import android.view.View;
import com.qq.e.comm.plugin.ab.c.f;
import com.qq.e.comm.plugin.ab.f.a.c;
import com.qq.e.comm.plugin.ab.f.e;
import com.qq.e.comm.plugin.rewardvideo.g;

public class a extends c {
  private g a;
  
  public a(g paramg) {
    this.a = paramg;
  }
  
  public f<String> a(e parame, View paramView, String paramString1, String paramString2, String paramString3, String paramString4) {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc 'RewardPageHandler handleAction , service : '
    //   11: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_2
    //   16: aload_3
    //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_2
    //   22: ldc ' ,action : '
    //   24: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: aload #4
    //   31: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_2
    //   36: ldc ' ,param : '
    //   38: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: aload #5
    //   45: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: invokevirtual toString : ()Ljava/lang/String;
    //   53: invokestatic d : (Ljava/lang/String;)V
    //   56: new org/json/JSONObject
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: astore #9
    //   65: iconst_0
    //   66: istore #7
    //   68: new com/qq/e/comm/plugin/ab/b/d
    //   71: dup
    //   72: aload #4
    //   74: aload_3
    //   75: aload #6
    //   77: new org/json/JSONObject
    //   80: dup
    //   81: aload #5
    //   83: invokespecial <init> : (Ljava/lang/String;)V
    //   86: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V
    //   89: astore_2
    //   90: new org/json/JSONObject
    //   93: dup
    //   94: invokespecial <init> : ()V
    //   97: astore_3
    //   98: aload_3
    //   99: ldc 'action'
    //   101: aload #4
    //   103: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   106: pop
    //   107: aload #9
    //   109: ldc 'data'
    //   111: aload_3
    //   112: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload #9
    //   118: ldc 'code'
    //   120: iconst_0
    //   121: invokevirtual put : (Ljava/lang/String;I)Lorg/json/JSONObject;
    //   124: pop
    //   125: goto -> 155
    //   128: goto -> 133
    //   131: aconst_null
    //   132: astore_2
    //   133: aload_2
    //   134: ifnull -> 316
    //   137: aload_1
    //   138: new com/qq/e/comm/plugin/ab/b/e
    //   141: dup
    //   142: aload_2
    //   143: getstatic com/qq/e/comm/plugin/ab/b/e$a.b : Lcom/qq/e/comm/plugin/ab/b/e$a;
    //   146: aload #9
    //   148: iconst_1
    //   149: invokespecial <init> : (Lcom/qq/e/comm/plugin/ab/b/d;Lcom/qq/e/comm/plugin/ab/b/e$a;Lorg/json/JSONObject;I)V
    //   152: invokevirtual a : (Lcom/qq/e/comm/plugin/ab/b/e;)V
    //   155: new com/qq/e/comm/plugin/ab/b/e
    //   158: dup
    //   159: aload_2
    //   160: getstatic com/qq/e/comm/plugin/ab/b/e$a.a : Lcom/qq/e/comm/plugin/ab/b/e$a;
    //   163: aload #9
    //   165: invokespecial <init> : (Lcom/qq/e/comm/plugin/ab/b/d;Lcom/qq/e/comm/plugin/ab/b/e$a;Lorg/json/JSONObject;)V
    //   168: astore_3
    //   169: aload #4
    //   171: invokevirtual hashCode : ()I
    //   174: istore #8
    //   176: iload #8
    //   178: ldc -1143973754
    //   180: if_icmpeq -> 232
    //   183: iload #8
    //   185: ldc 996930575
    //   187: if_icmpeq -> 216
    //   190: iload #8
    //   192: ldc 1595925293
    //   194: if_icmpeq -> 200
    //   197: goto -> 245
    //   200: aload #4
    //   202: ldc 'reportExposureRewardAd'
    //   204: invokevirtual equals : (Ljava/lang/Object;)Z
    //   207: ifeq -> 245
    //   210: iconst_2
    //   211: istore #7
    //   213: goto -> 248
    //   216: aload #4
    //   218: ldc 'startCountDown'
    //   220: invokevirtual equals : (Ljava/lang/Object;)Z
    //   223: ifeq -> 245
    //   226: iconst_1
    //   227: istore #7
    //   229: goto -> 248
    //   232: aload #4
    //   234: ldc 'reportClickRewardAd'
    //   236: invokevirtual equals : (Ljava/lang/Object;)Z
    //   239: ifeq -> 245
    //   242: goto -> 248
    //   245: iconst_m1
    //   246: istore #7
    //   248: iload #7
    //   250: ifeq -> 304
    //   253: iload #7
    //   255: iconst_1
    //   256: if_icmpeq -> 294
    //   259: iload #7
    //   261: iconst_2
    //   262: if_icmpeq -> 284
    //   265: aload_1
    //   266: new com/qq/e/comm/plugin/ab/b/e
    //   269: dup
    //   270: aload_2
    //   271: getstatic com/qq/e/comm/plugin/ab/b/e$a.b : Lcom/qq/e/comm/plugin/ab/b/e$a;
    //   274: ldc 'unSupport action'
    //   276: invokespecial <init> : (Lcom/qq/e/comm/plugin/ab/b/d;Lcom/qq/e/comm/plugin/ab/b/e$a;Ljava/lang/String;)V
    //   279: invokevirtual a : (Lcom/qq/e/comm/plugin/ab/b/e;)V
    //   282: aconst_null
    //   283: areturn
    //   284: aload_0
    //   285: getfield a : Lcom/qq/e/comm/plugin/rewardvideo/g;
    //   288: invokevirtual b : ()V
    //   291: goto -> 311
    //   294: aload_0
    //   295: getfield a : Lcom/qq/e/comm/plugin/rewardvideo/g;
    //   298: invokevirtual d : ()V
    //   301: goto -> 311
    //   304: aload_0
    //   305: getfield a : Lcom/qq/e/comm/plugin/rewardvideo/g;
    //   308: invokevirtual c : ()V
    //   311: aload_1
    //   312: aload_3
    //   313: invokevirtual a : (Lcom/qq/e/comm/plugin/ab/b/e;)V
    //   316: aconst_null
    //   317: areturn
    //   318: astore_2
    //   319: goto -> 131
    //   322: astore_3
    //   323: goto -> 128
    // Exception table:
    //   from	to	target	type
    //   68	90	318	org/json/JSONException
    //   90	125	322	org/json/JSONException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\rewardvideo\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */