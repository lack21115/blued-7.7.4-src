package com.soft.blued.customview.selectabletextview;

import android.content.Context;
import android.text.Layout;
import android.widget.TextView;

public class TextLayoutUtil {
  public static int a(Context paramContext) {
    return (paramContext.getResources().getDisplayMetrics()).widthPixels;
  }
  
  public static int a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getLayout : ()Landroid/text/Layout;
    //   4: astore #9
    //   6: aload #9
    //   8: ifnonnull -> 13
    //   11: iconst_m1
    //   12: ireturn
    //   13: aload #9
    //   15: iload_2
    //   16: invokevirtual getLineForVertical : (I)I
    //   19: istore #5
    //   21: iload_3
    //   22: istore #4
    //   24: aload #9
    //   26: iload_3
    //   27: invokestatic a : (Landroid/text/Layout;I)Z
    //   30: ifeq -> 76
    //   33: aload #9
    //   35: iload_3
    //   36: iconst_1
    //   37: isub
    //   38: invokevirtual getPrimaryHorizontal : (I)F
    //   41: f2i
    //   42: istore #6
    //   44: aload #9
    //   46: iload #5
    //   48: invokevirtual getLineRight : (I)F
    //   51: f2i
    //   52: istore #7
    //   54: iload_3
    //   55: istore #4
    //   57: iload_1
    //   58: iload #7
    //   60: iload #7
    //   62: iload #6
    //   64: isub
    //   65: iconst_2
    //   66: idiv
    //   67: isub
    //   68: if_icmple -> 76
    //   71: iload_3
    //   72: iconst_1
    //   73: isub
    //   74: istore #4
    //   76: aload #9
    //   78: iload #4
    //   80: invokevirtual getLineForOffset : (I)I
    //   83: istore #4
    //   85: aload #9
    //   87: iload #4
    //   89: invokevirtual getLineTop : (I)I
    //   92: istore #6
    //   94: aload #9
    //   96: iload #4
    //   98: invokevirtual getLineBottom : (I)I
    //   101: istore #7
    //   103: iload #7
    //   105: iload #6
    //   107: isub
    //   108: iconst_2
    //   109: idiv
    //   110: istore #8
    //   112: iload #5
    //   114: iload #4
    //   116: iconst_1
    //   117: iadd
    //   118: if_icmpne -> 133
    //   121: iload #4
    //   123: istore_3
    //   124: iload_2
    //   125: iload #7
    //   127: isub
    //   128: iload #8
    //   130: if_icmplt -> 160
    //   133: iload #5
    //   135: iload #4
    //   137: iconst_1
    //   138: isub
    //   139: if_icmpne -> 157
    //   142: iload #6
    //   144: iload_2
    //   145: isub
    //   146: iload #8
    //   148: if_icmpge -> 157
    //   151: iload #4
    //   153: istore_3
    //   154: goto -> 160
    //   157: iload #5
    //   159: istore_3
    //   160: aload #9
    //   162: iload_3
    //   163: iload_1
    //   164: i2f
    //   165: invokevirtual getOffsetForHorizontal : (IF)I
    //   168: istore #4
    //   170: iload #4
    //   172: istore_2
    //   173: iload #4
    //   175: aload_0
    //   176: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   179: invokeinterface length : ()I
    //   184: iconst_1
    //   185: isub
    //   186: if_icmpge -> 244
    //   189: iload #4
    //   191: iconst_1
    //   192: iadd
    //   193: istore #5
    //   195: iload #4
    //   197: istore_2
    //   198: aload #9
    //   200: iload #5
    //   202: invokestatic a : (Landroid/text/Layout;I)Z
    //   205: ifeq -> 244
    //   208: aload #9
    //   210: iload #4
    //   212: invokevirtual getPrimaryHorizontal : (I)F
    //   215: f2i
    //   216: istore #6
    //   218: aload #9
    //   220: iload_3
    //   221: invokevirtual getLineRight : (I)F
    //   224: f2i
    //   225: istore_3
    //   226: iload #4
    //   228: istore_2
    //   229: iload_1
    //   230: iload_3
    //   231: iload_3
    //   232: iload #6
    //   234: isub
    //   235: iconst_2
    //   236: idiv
    //   237: isub
    //   238: if_icmple -> 244
    //   241: iload #5
    //   243: istore_2
    //   244: iload_2
    //   245: istore_1
    //   246: iload_2
    //   247: aload_0
    //   248: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   251: invokeinterface length : ()I
    //   256: if_icmple -> 269
    //   259: aload_0
    //   260: invokevirtual getText : ()Ljava/lang/CharSequence;
    //   263: invokeinterface length : ()I
    //   268: istore_1
    //   269: iload_1
    //   270: ireturn
  }
  
  private static boolean a(Layout paramLayout, int paramInt) {
    return (paramInt > 0 && paramLayout.getLineForOffset(paramInt) == paramLayout.getLineForOffset(paramInt - 1) + 1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\selectabletextview\TextLayoutUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */