package com.google.android.gms.common.util;

public final class HexDumpUtils {
  public static String dump(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    // Byte code:
    //   0: aload_0
    //   1: ifnull -> 390
    //   4: aload_0
    //   5: arraylength
    //   6: ifeq -> 390
    //   9: iload_1
    //   10: iflt -> 390
    //   13: iload_2
    //   14: ifle -> 390
    //   17: iload_1
    //   18: iload_2
    //   19: iadd
    //   20: aload_0
    //   21: arraylength
    //   22: if_icmple -> 28
    //   25: goto -> 390
    //   28: bipush #57
    //   30: istore #5
    //   32: iload_3
    //   33: ifeq -> 40
    //   36: bipush #75
    //   38: istore #5
    //   40: new java/lang/StringBuilder
    //   43: dup
    //   44: iload #5
    //   46: iload_2
    //   47: bipush #16
    //   49: iadd
    //   50: iconst_1
    //   51: isub
    //   52: bipush #16
    //   54: idiv
    //   55: imul
    //   56: invokespecial <init> : (I)V
    //   59: astore #10
    //   61: iload_2
    //   62: istore #5
    //   64: iconst_0
    //   65: istore #7
    //   67: iconst_0
    //   68: istore #8
    //   70: iload #5
    //   72: ifle -> 384
    //   75: iload #7
    //   77: ifne -> 139
    //   80: iload_2
    //   81: ldc 65536
    //   83: if_icmpge -> 111
    //   86: aload #10
    //   88: ldc '%04X:'
    //   90: iconst_1
    //   91: anewarray java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: iload_1
    //   97: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   100: aastore
    //   101: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: goto -> 133
    //   111: aload #10
    //   113: ldc '%08X:'
    //   115: iconst_1
    //   116: anewarray java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: iload_1
    //   122: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   125: aastore
    //   126: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   129: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: iload_1
    //   134: istore #6
    //   136: goto -> 162
    //   139: iload #8
    //   141: istore #6
    //   143: iload #7
    //   145: bipush #8
    //   147: if_icmpne -> 162
    //   150: aload #10
    //   152: ldc ' -'
    //   154: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: iload #8
    //   160: istore #6
    //   162: aload #10
    //   164: ldc ' %02X'
    //   166: iconst_1
    //   167: anewarray java/lang/Object
    //   170: dup
    //   171: iconst_0
    //   172: aload_0
    //   173: iload_1
    //   174: baload
    //   175: sipush #255
    //   178: iand
    //   179: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   182: aastore
    //   183: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: iload #5
    //   192: iconst_1
    //   193: isub
    //   194: istore #9
    //   196: iload #7
    //   198: iconst_1
    //   199: iadd
    //   200: istore #7
    //   202: iload_3
    //   203: ifeq -> 338
    //   206: iload #7
    //   208: bipush #16
    //   210: if_icmpeq -> 218
    //   213: iload #9
    //   215: ifne -> 338
    //   218: bipush #16
    //   220: iload #7
    //   222: isub
    //   223: istore #8
    //   225: iload #8
    //   227: ifle -> 257
    //   230: iconst_0
    //   231: istore #5
    //   233: iload #5
    //   235: iload #8
    //   237: if_icmpge -> 257
    //   240: aload #10
    //   242: ldc '   '
    //   244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: iload #5
    //   250: iconst_1
    //   251: iadd
    //   252: istore #5
    //   254: goto -> 233
    //   257: iload #8
    //   259: bipush #8
    //   261: if_icmplt -> 272
    //   264: aload #10
    //   266: ldc '  '
    //   268: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload #10
    //   274: ldc '  '
    //   276: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: iconst_0
    //   281: istore #5
    //   283: iload #5
    //   285: iload #7
    //   287: if_icmpge -> 338
    //   290: aload_0
    //   291: iload #6
    //   293: iload #5
    //   295: iadd
    //   296: baload
    //   297: i2c
    //   298: istore #4
    //   300: iload #4
    //   302: bipush #32
    //   304: if_icmplt -> 317
    //   307: iload #4
    //   309: bipush #126
    //   311: if_icmpgt -> 317
    //   314: goto -> 321
    //   317: bipush #46
    //   319: istore #4
    //   321: aload #10
    //   323: iload #4
    //   325: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: iload #5
    //   331: iconst_1
    //   332: iadd
    //   333: istore #5
    //   335: goto -> 283
    //   338: iload #7
    //   340: bipush #16
    //   342: if_icmpeq -> 354
    //   345: iload #7
    //   347: istore #5
    //   349: iload #9
    //   351: ifne -> 365
    //   354: aload #10
    //   356: bipush #10
    //   358: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: iconst_0
    //   363: istore #5
    //   365: iload_1
    //   366: iconst_1
    //   367: iadd
    //   368: istore_1
    //   369: iload #5
    //   371: istore #7
    //   373: iload #6
    //   375: istore #8
    //   377: iload #9
    //   379: istore #5
    //   381: goto -> 70
    //   384: aload #10
    //   386: invokevirtual toString : ()Ljava/lang/String;
    //   389: areturn
    //   390: aconst_null
    //   391: areturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\commo\\util\HexDumpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */