package com.qq.e.comm.plugin.n;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.ad.g;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.ak;
import com.qq.e.comm.plugin.y.c;

public class d {
  public static h a(Context paramContext, a parama, g paramg, String paramString, int paramInt, c paramc) {
    j j;
    if (parama instanceof i) {
      i i = (i)parama;
      if (a(i)) {
        ak.a("EndCardFactory", "create LandingPageView");
        j = new j(paramContext, paramg, paramc);
        b(i);
        return j;
      } 
      ak.a("EndCardFactory", "create EndCardView");
      return new f((Context)j, paramString, paramInt, parama.Z(), paramc);
    } 
    ak.a("EndCardFactory", "create EndCardView");
    return new f((Context)j, paramString, paramInt, parama.Z(), paramc);
  }
  
  private static boolean a(i parami) {
    // Byte code:
    //   0: invokestatic getInstance : ()Lcom/qq/e/comm/managers/GDTADManager;
    //   3: invokevirtual getSM : ()Lcom/qq/e/comm/managers/setting/SM;
    //   6: ldc 'rewardEndCardLandingPage'
    //   8: iconst_1
    //   9: invokevirtual getInteger : (Ljava/lang/String;I)I
    //   12: istore_1
    //   13: iconst_0
    //   14: istore_3
    //   15: iload_1
    //   16: ifne -> 28
    //   19: ldc 'EndCardFactory'
    //   21: ldc 'rewardEndCardLandingPage feature, switch off.'
    //   23: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: invokeinterface a : ()Ljava/lang/String;
    //   34: astore #6
    //   36: aload_0
    //   37: invokeinterface a_ : ()I
    //   42: istore_1
    //   43: aload_0
    //   44: invokeinterface e : ()Ljava/lang/String;
    //   49: astore #7
    //   51: aload_0
    //   52: invokeinterface k_ : ()Z
    //   57: iconst_1
    //   58: ixor
    //   59: istore #4
    //   61: aload_0
    //   62: invokeinterface l_ : ()Lorg/json/JSONObject;
    //   67: invokestatic g : (Lorg/json/JSONObject;)Z
    //   70: istore #5
    //   72: new java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: astore_0
    //   80: aload_0
    //   81: ldc 'showLandingPage ? landingPage : '
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_0
    //   88: aload #6
    //   90: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_0
    //   95: ldc ' ,productType : '
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_0
    //   102: iload_1
    //   103: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_0
    //   108: ldc ' ,dlUrl : '
    //   110: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_0
    //   115: aload #7
    //   117: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_0
    //   122: ldc ' ,demoGame : '
    //   124: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload_0
    //   129: iload #4
    //   131: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload_0
    //   136: ldc ' ,WXMiniProgram : '
    //   138: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_0
    //   143: iload #5
    //   145: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: ldc 'EndCardFactory'
    //   151: aload_0
    //   152: invokevirtual toString : ()Ljava/lang/String;
    //   155: invokestatic a : (Ljava/lang/String;Ljava/lang/String;)V
    //   158: iload_3
    //   159: istore_2
    //   160: aload #6
    //   162: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   165: ifne -> 215
    //   168: iload_1
    //   169: bipush #12
    //   171: if_icmpeq -> 189
    //   174: iload_1
    //   175: sipush #1000
    //   178: if_icmpeq -> 189
    //   181: iload_3
    //   182: istore_2
    //   183: iload_1
    //   184: bipush #38
    //   186: if_icmpne -> 215
    //   189: iload_3
    //   190: istore_2
    //   191: aload #7
    //   193: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   196: ifeq -> 215
    //   199: iload_3
    //   200: istore_2
    //   201: iload #4
    //   203: ifne -> 215
    //   206: iload_3
    //   207: istore_2
    //   208: iload #5
    //   210: ifne -> 215
    //   213: iconst_1
    //   214: istore_2
    //   215: iload_2
    //   216: ireturn
  }
  
  private static void b(i parami) {
    if (TextUtils.isEmpty(parami.a()))
      return; 
    ak.a("EndCardFactory", "show landing page, replace endCard url to landingPage url.");
    parami.a(parami.a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\n\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */