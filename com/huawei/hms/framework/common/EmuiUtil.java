package com.huawei.hms.framework.common;

public class EmuiUtil {
  public static final String BUILDEX_VERSION = "com.huawei.android.os.BuildEx$VERSION";
  
  private static final int EMUI_3_0 = 7;
  
  private static final int EMUI_3_1 = 8;
  
  private static final int EMUI_4_0 = 9;
  
  private static final int EMUI_4_1 = 10;
  
  private static final int EMUI_5_0 = 11;
  
  private static final int EMUI_6_0 = 14;
  
  private static final int EMUI_8_0_1 = 15;
  
  private static final int EMUI_9_0 = 17;
  
  public static final String EMUI_SDK_INT = "EMUI_SDK_INT";
  
  private static final int EMUI_TYPE_UNKOWN = -1;
  
  public static final String GET_PRIMARY_COLOR = "getPrimaryColor";
  
  public static final String GET_SUGGESTION_FOR_GROUND_COLOR_STYLE = "getSuggestionForgroundColorStyle";
  
  public static final String IMMERSION_STYLE = "com.huawei.android.immersion.ImmersionStyle";
  
  private static final String TAG = "KPMS_Util_Emui";
  
  private static final int TYPE_EMUI_30 = 30;
  
  private static final int TYPE_EMUI_31 = 31;
  
  private static final int TYPE_EMUI_40 = 40;
  
  private static final int TYPE_EMUI_41 = 41;
  
  private static final int TYPE_EMUI_50 = 50;
  
  private static final int TYPE_EMUI_60 = 60;
  
  private static final int TYPE_EMUI_801 = 81;
  
  private static final int TYPE_EMUI_90 = 90;
  
  private static int emuiType = -1;
  
  private static int emuiVersionCode;
  
  static {
    initEmuiType();
  }
  
  private static int getEMUIVersionCode() {
    Object object = ReflectionUtils.getStaticFieldObj("com.huawei.android.os.BuildEx$VERSION", "EMUI_SDK_INT");
    if (object != null) {
      boolean bool1;
      try {
        bool1 = ((Integer)object).intValue();
      } catch (ClassCastException classCastException) {
        Logger.e("KPMS_Util_Emui", "getEMUIVersionCode ClassCastException:", classCastException);
        bool1 = false;
      } 
      object = new StringBuilder();
      object.append("the emui version code is::");
      object.append(bool1);
      Logger.d("KPMS_Util_Emui", object.toString());
      return bool1;
    } 
    boolean bool = false;
  }
  
  private static void initEmuiType() {
    // Byte code:
    //   0: invokestatic getEMUIVersionCode : ()I
    //   3: putstatic com/huawei/hms/framework/common/EmuiUtil.emuiVersionCode : I
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore_1
    //   14: aload_1
    //   15: ldc 'getEmuiType emuiVersionCode='
    //   17: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_1
    //   22: getstatic com/huawei/hms/framework/common/EmuiUtil.emuiVersionCode : I
    //   25: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: ldc 'KPMS_Util_Emui'
    //   31: aload_1
    //   32: invokevirtual toString : ()Ljava/lang/String;
    //   35: invokestatic d : (Ljava/lang/String;Ljava/lang/Object;)V
    //   38: getstatic com/huawei/hms/framework/common/EmuiUtil.emuiVersionCode : I
    //   41: istore_0
    //   42: iload_0
    //   43: bipush #17
    //   45: if_icmplt -> 58
    //   48: bipush #90
    //   50: istore_0
    //   51: iload_0
    //   52: putstatic com/huawei/hms/framework/common/EmuiUtil.emuiType : I
    //   55: goto -> 142
    //   58: iload_0
    //   59: bipush #15
    //   61: if_icmplt -> 70
    //   64: bipush #81
    //   66: istore_0
    //   67: goto -> 51
    //   70: iload_0
    //   71: bipush #14
    //   73: if_icmplt -> 82
    //   76: bipush #60
    //   78: istore_0
    //   79: goto -> 51
    //   82: iload_0
    //   83: bipush #11
    //   85: if_icmplt -> 94
    //   88: bipush #50
    //   90: istore_0
    //   91: goto -> 51
    //   94: iload_0
    //   95: bipush #10
    //   97: if_icmplt -> 106
    //   100: bipush #41
    //   102: istore_0
    //   103: goto -> 51
    //   106: iload_0
    //   107: bipush #9
    //   109: if_icmplt -> 118
    //   112: bipush #40
    //   114: istore_0
    //   115: goto -> 51
    //   118: iload_0
    //   119: bipush #8
    //   121: if_icmplt -> 130
    //   124: bipush #31
    //   126: istore_0
    //   127: goto -> 51
    //   130: iload_0
    //   131: bipush #7
    //   133: if_icmplt -> 142
    //   136: bipush #30
    //   138: istore_0
    //   139: goto -> 51
    //   142: getstatic com/huawei/hms/framework/common/EmuiUtil.emuiType : I
    //   145: iconst_m1
    //   146: if_icmpne -> 156
    //   149: ldc 'KPMS_Util_Emui'
    //   151: ldc 'emuiType is unkown'
    //   153: invokestatic i : (Ljava/lang/String;Ljava/lang/Object;)V
    //   156: return
  }
  
  public static boolean isEMUI() {
    return (-1 != emuiType);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\EmuiUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */