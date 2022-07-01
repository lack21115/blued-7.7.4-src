package org.chromium.ui.display;

import android.annotation.TargetApi;
import android.view.Display;
import org.chromium.base.CommandLine;
import org.chromium.base.Log;

class PhysicalDisplayAndroid extends DisplayAndroid {
  private static Float sForcedDIPScale;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  PhysicalDisplayAndroid(Display paramDisplay) {
    super(paramDisplay.getDisplayId());
  }
  
  private static boolean hasForcedDIPScale() {
    if (sForcedDIPScale == null) {
      String str = CommandLine.getInstance().getSwitchValue("force-device-scale-factor");
      if (str == null) {
        sForcedDIPScale = Float.valueOf(0.0F);
      } else {
        boolean bool;
        try {
          Float float_ = Float.valueOf(str);
          sForcedDIPScale = float_;
          float f = float_.floatValue();
          if (f <= 0.0F) {
            bool = true;
          } else {
            bool = false;
          } 
        } catch (NumberFormatException numberFormatException) {
          bool = true;
        } 
        if (bool) {
          StringBuilder stringBuilder = new StringBuilder("Ignoring invalid forced DIP scale '");
          stringBuilder.append(str);
          stringBuilder.append("'");
          Log.w("DisplayAndroid", stringBuilder.toString(), new Object[0]);
          sForcedDIPScale = Float.valueOf(0.0F);
        } 
      } 
    } 
    return (sForcedDIPScale.floatValue() > 0.0F);
  }
  
  @TargetApi(17)
  final void updateFromDisplay(Display paramDisplay) {
    // Byte code:
    //   0: new android/graphics/Point
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #7
    //   9: new android/util/DisplayMetrics
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #8
    //   18: getstatic android/os/Build$VERSION.SDK_INT : I
    //   21: bipush #17
    //   23: if_icmplt -> 41
    //   26: aload_1
    //   27: aload #7
    //   29: invokevirtual getRealSize : (Landroid/graphics/Point;)V
    //   32: aload_1
    //   33: aload #8
    //   35: invokevirtual getRealMetrics : (Landroid/util/DisplayMetrics;)V
    //   38: goto -> 53
    //   41: aload_1
    //   42: aload #7
    //   44: invokevirtual getSize : (Landroid/graphics/Point;)V
    //   47: aload_1
    //   48: aload #8
    //   50: invokevirtual getMetrics : (Landroid/util/DisplayMetrics;)V
    //   53: invokestatic hasForcedDIPScale : ()Z
    //   56: ifeq -> 70
    //   59: aload #8
    //   61: getstatic org/chromium/ui/display/PhysicalDisplayAndroid.sForcedDIPScale : Ljava/lang/Float;
    //   64: invokevirtual floatValue : ()F
    //   67: putfield density : F
    //   70: getstatic android/os/Build$VERSION.SDK_INT : I
    //   73: istore_3
    //   74: iconst_0
    //   75: istore #5
    //   77: iload_3
    //   78: bipush #26
    //   80: if_icmplt -> 92
    //   83: aload_1
    //   84: invokevirtual isWideColorGamut : ()Z
    //   87: istore #6
    //   89: goto -> 95
    //   92: iconst_0
    //   93: istore #6
    //   95: getstatic android/os/Build$VERSION.SDK_INT : I
    //   98: bipush #17
    //   100: if_icmpge -> 112
    //   103: aload_1
    //   104: invokevirtual getPixelFormat : ()I
    //   107: istore #4
    //   109: goto -> 115
    //   112: iconst_1
    //   113: istore #4
    //   115: aload #8
    //   117: getfield density : F
    //   120: fstore_2
    //   121: iload #4
    //   123: iconst_1
    //   124: if_icmpeq -> 234
    //   127: new android/graphics/PixelFormat
    //   130: dup
    //   131: invokespecial <init> : ()V
    //   134: astore #8
    //   136: iload #4
    //   138: aload #8
    //   140: invokestatic getPixelFormatInfo : (ILandroid/graphics/PixelFormat;)V
    //   143: iload #4
    //   145: invokestatic formatHasAlpha : (I)Z
    //   148: ifne -> 160
    //   151: aload #8
    //   153: getfield bitsPerPixel : I
    //   156: istore_3
    //   157: goto -> 237
    //   160: iload #4
    //   162: iconst_1
    //   163: if_icmpeq -> 217
    //   166: iload #4
    //   168: bipush #43
    //   170: if_icmpeq -> 211
    //   173: iload #4
    //   175: tableswitch default -> 196, 6 -> 205, 7 -> 199
    //   196: goto -> 234
    //   199: bipush #12
    //   201: istore_3
    //   202: goto -> 237
    //   205: bipush #15
    //   207: istore_3
    //   208: goto -> 237
    //   211: bipush #30
    //   213: istore_3
    //   214: goto -> 237
    //   217: getstatic org/chromium/ui/display/PhysicalDisplayAndroid.$assertionsDisabled : Z
    //   220: ifeq -> 226
    //   223: goto -> 234
    //   226: new java/lang/AssertionError
    //   229: dup
    //   230: invokespecial <init> : ()V
    //   233: athrow
    //   234: bipush #24
    //   236: istore_3
    //   237: iload #4
    //   239: tableswitch default -> 296, 1 -> 331, 2 -> 331, 3 -> 331, 4 -> 325, 5 -> 296, 6 -> 322, 7 -> 316, 8 -> 309, 9 -> 309, 10 -> 309, 11 -> 303
    //   296: bipush #8
    //   298: istore #4
    //   300: goto -> 334
    //   303: iconst_2
    //   304: istore #4
    //   306: goto -> 334
    //   309: iload #5
    //   311: istore #4
    //   313: goto -> 334
    //   316: iconst_4
    //   317: istore #4
    //   319: goto -> 334
    //   322: goto -> 325
    //   325: iconst_5
    //   326: istore #4
    //   328: goto -> 334
    //   331: goto -> 296
    //   334: aload_0
    //   335: aload #7
    //   337: fload_2
    //   338: invokestatic valueOf : (F)Ljava/lang/Float;
    //   341: iload_3
    //   342: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   345: iload #4
    //   347: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   350: aload_1
    //   351: invokevirtual getRotation : ()I
    //   354: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   357: iload #6
    //   359: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   362: aconst_null
    //   363: invokespecial update : (Landroid/graphics/Point;Ljava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Boolean;)V
    //   366: new java/lang/VerifyError
    //   369: dup
    //   370: ldc 'bad dex opcode'
    //   372: invokespecial <init> : (Ljava/lang/String;)V
    //   375: athrow
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromiu\\ui\display\PhysicalDisplayAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */