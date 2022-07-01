package c.t.maploc.lite.tsa;

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import java.util.List;

final class ag extends PhoneStateListener {
  ag(af paramaf) {}
  
  public final void onCellInfoChanged(List paramList) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onCellInfoChanged : (Ljava/util/List;)V
    //   5: aload_1
    //   6: ifnull -> 158
    //   9: aload_1
    //   10: invokeinterface size : ()I
    //   15: ifle -> 158
    //   18: new java/util/ArrayList
    //   21: dup
    //   22: invokespecial <init> : ()V
    //   25: astore_3
    //   26: aload_1
    //   27: invokeinterface iterator : ()Ljava/util/Iterator;
    //   32: astore_1
    //   33: aload_1
    //   34: invokeinterface hasNext : ()Z
    //   39: ifeq -> 140
    //   42: aload_1
    //   43: invokeinterface next : ()Ljava/lang/Object;
    //   48: checkcast android/telephony/CellInfo
    //   51: astore #4
    //   53: aload #4
    //   55: invokevirtual isRegistered : ()Z
    //   58: ifeq -> 33
    //   61: aload_0
    //   62: getfield a : Lc/t/maploc/lite/tsa/af;
    //   65: getfield g : Lc/t/maploc/lite/tsa/j;
    //   68: getfield e : Landroid/telephony/TelephonyManager;
    //   71: aload #4
    //   73: invokestatic a : (Landroid/telephony/TelephonyManager;Landroid/telephony/CellInfo;)Lc/t/maploc/lite/tsa/m;
    //   76: astore #4
    //   78: aload #4
    //   80: ifnull -> 33
    //   83: aload #4
    //   85: getfield b : I
    //   88: iflt -> 288
    //   91: aload #4
    //   93: getfield c : I
    //   96: iflt -> 288
    //   99: aload #4
    //   101: getfield b : I
    //   104: sipush #535
    //   107: if_icmpeq -> 288
    //   110: aload #4
    //   112: getfield c : I
    //   115: sipush #535
    //   118: if_icmpne -> 283
    //   121: goto -> 288
    //   124: iload_2
    //   125: ifeq -> 33
    //   128: aload_3
    //   129: aload #4
    //   131: invokeinterface add : (Ljava/lang/Object;)Z
    //   136: pop
    //   137: goto -> 33
    //   140: aload_3
    //   141: invokeinterface size : ()I
    //   146: ifle -> 158
    //   149: aload_0
    //   150: getfield a : Lc/t/maploc/lite/tsa/af;
    //   153: aload_3
    //   154: invokestatic a : (Lc/t/maploc/lite/tsa/af;Ljava/util/List;)V
    //   157: return
    //   158: aload_0
    //   159: getfield a : Lc/t/maploc/lite/tsa/af;
    //   162: getfield g : Lc/t/maploc/lite/tsa/j;
    //   165: getfield a : Landroid/content/Context;
    //   168: invokestatic a : (Landroid/content/Context;)Landroid/telephony/CellLocation;
    //   171: astore_3
    //   172: aload_3
    //   173: ifnull -> 223
    //   176: new java/util/ArrayList
    //   179: dup
    //   180: invokespecial <init> : ()V
    //   183: astore_1
    //   184: aload_0
    //   185: getfield a : Lc/t/maploc/lite/tsa/af;
    //   188: getfield g : Lc/t/maploc/lite/tsa/j;
    //   191: getfield e : Landroid/telephony/TelephonyManager;
    //   194: aload_3
    //   195: aconst_null
    //   196: invokestatic a : (Landroid/telephony/TelephonyManager;Landroid/telephony/CellLocation;Landroid/telephony/SignalStrength;)Lc/t/maploc/lite/tsa/m;
    //   199: astore_3
    //   200: aload_3
    //   201: ifnull -> 212
    //   204: aload_1
    //   205: aload_3
    //   206: invokeinterface add : (Ljava/lang/Object;)Z
    //   211: pop
    //   212: aload_0
    //   213: getfield a : Lc/t/maploc/lite/tsa/af;
    //   216: aload_1
    //   217: invokestatic a : (Lc/t/maploc/lite/tsa/af;Ljava/util/List;)V
    //   220: goto -> 263
    //   223: aload_0
    //   224: getfield a : Lc/t/maploc/lite/tsa/af;
    //   227: getfield b : Lc/t/maploc/lite/tsa/m;
    //   230: ifnull -> 263
    //   233: new java/util/ArrayList
    //   236: dup
    //   237: invokespecial <init> : ()V
    //   240: astore_1
    //   241: aload_1
    //   242: aload_0
    //   243: getfield a : Lc/t/maploc/lite/tsa/af;
    //   246: getfield b : Lc/t/maploc/lite/tsa/m;
    //   249: invokeinterface add : (Ljava/lang/Object;)Z
    //   254: pop
    //   255: aload_0
    //   256: getfield a : Lc/t/maploc/lite/tsa/af;
    //   259: aload_1
    //   260: invokestatic a : (Lc/t/maploc/lite/tsa/af;Ljava/util/List;)V
    //   263: aload_0
    //   264: getfield a : Lc/t/maploc/lite/tsa/af;
    //   267: getfield d : Z
    //   270: ifne -> 280
    //   273: aload_0
    //   274: getfield a : Lc/t/maploc/lite/tsa/af;
    //   277: invokestatic a : (Lc/t/maploc/lite/tsa/af;)V
    //   280: return
    //   281: astore_1
    //   282: return
    //   283: iconst_1
    //   284: istore_2
    //   285: goto -> 124
    //   288: iconst_0
    //   289: istore_2
    //   290: goto -> 124
    // Exception table:
    //   from	to	target	type
    //   9	33	281	finally
    //   33	78	281	finally
    //   83	121	281	finally
    //   128	137	281	finally
    //   140	157	281	finally
    //   158	172	281	finally
    //   176	200	281	finally
    //   204	212	281	finally
    //   212	220	281	finally
    //   223	263	281	finally
    //   263	280	281	finally
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState) {
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null)
      return; 
    try {
      ServiceState serviceState = this.a.c;
      return;
    } finally {
      paramServiceState = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\c\t\maploc\lite\tsa\ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */