package com.alipay.security.mobile.module.a.a;

public final class a {
  private static char[] a = new char[] { 
      'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 
      'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 
      'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 
      'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 
      'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 
      'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', 
      '8', '9', '+', '/' };
  
  private static byte[] b = new byte[] { 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
      -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
      54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
      -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
      5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
      15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
      25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
      29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
      39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
      49, 50, 51, -1, -1, -1, -1, -1 };
  
  public static byte[] a(String paramString) {
    // Byte code:
    //   0: new java/lang/StringBuffer
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #6
    //   9: aload_0
    //   10: ldc 'US-ASCII'
    //   12: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   15: astore_0
    //   16: aload_0
    //   17: arraylength
    //   18: istore_3
    //   19: iconst_0
    //   20: istore_1
    //   21: iload_1
    //   22: iload_3
    //   23: if_icmpge -> 149
    //   26: iload_1
    //   27: istore_2
    //   28: getstatic com/alipay/security/mobile/module/a/a/a.b : [B
    //   31: astore #7
    //   33: iload_2
    //   34: iconst_1
    //   35: iadd
    //   36: istore_1
    //   37: aload #7
    //   39: aload_0
    //   40: iload_2
    //   41: baload
    //   42: baload
    //   43: istore #5
    //   45: iload_1
    //   46: iload_3
    //   47: if_icmpge -> 64
    //   50: iload #5
    //   52: iconst_m1
    //   53: if_icmpeq -> 59
    //   56: goto -> 64
    //   59: iload_1
    //   60: istore_2
    //   61: goto -> 28
    //   64: iload #5
    //   66: iconst_m1
    //   67: if_icmpeq -> 149
    //   70: iload_1
    //   71: istore_2
    //   72: getstatic com/alipay/security/mobile/module/a/a/a.b : [B
    //   75: astore #7
    //   77: iload_2
    //   78: iconst_1
    //   79: iadd
    //   80: istore_1
    //   81: aload #7
    //   83: aload_0
    //   84: iload_2
    //   85: baload
    //   86: baload
    //   87: istore #4
    //   89: iload_1
    //   90: iload_3
    //   91: if_icmpge -> 108
    //   94: iload #4
    //   96: iconst_m1
    //   97: if_icmpeq -> 103
    //   100: goto -> 108
    //   103: iload_1
    //   104: istore_2
    //   105: goto -> 72
    //   108: iload #4
    //   110: iconst_m1
    //   111: if_icmpeq -> 149
    //   114: aload #6
    //   116: iload #5
    //   118: iconst_2
    //   119: ishl
    //   120: iload #4
    //   122: bipush #48
    //   124: iand
    //   125: iconst_4
    //   126: iushr
    //   127: ior
    //   128: i2c
    //   129: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   132: pop
    //   133: iload_1
    //   134: istore_2
    //   135: iload_2
    //   136: iconst_1
    //   137: iadd
    //   138: istore_1
    //   139: aload_0
    //   140: iload_2
    //   141: baload
    //   142: istore_2
    //   143: iload_2
    //   144: bipush #61
    //   146: if_icmpne -> 160
    //   149: aload #6
    //   151: invokevirtual toString : ()Ljava/lang/String;
    //   154: ldc 'iso8859-1'
    //   156: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   159: areturn
    //   160: getstatic com/alipay/security/mobile/module/a/a/a.b : [B
    //   163: iload_2
    //   164: baload
    //   165: istore #5
    //   167: iload_1
    //   168: iload_3
    //   169: if_icmpge -> 186
    //   172: iload #5
    //   174: iconst_m1
    //   175: if_icmpeq -> 181
    //   178: goto -> 186
    //   181: iload_1
    //   182: istore_2
    //   183: goto -> 135
    //   186: iload #5
    //   188: iconst_m1
    //   189: if_icmpeq -> 149
    //   192: aload #6
    //   194: iload #4
    //   196: bipush #15
    //   198: iand
    //   199: iconst_4
    //   200: ishl
    //   201: iload #5
    //   203: bipush #60
    //   205: iand
    //   206: iconst_2
    //   207: iushr
    //   208: ior
    //   209: i2c
    //   210: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   213: pop
    //   214: iload_1
    //   215: istore_2
    //   216: iload_2
    //   217: iconst_1
    //   218: iadd
    //   219: istore_1
    //   220: aload_0
    //   221: iload_2
    //   222: baload
    //   223: istore_2
    //   224: iload_2
    //   225: bipush #61
    //   227: if_icmpne -> 233
    //   230: goto -> 149
    //   233: getstatic com/alipay/security/mobile/module/a/a/a.b : [B
    //   236: iload_2
    //   237: baload
    //   238: istore_2
    //   239: iload_1
    //   240: iload_3
    //   241: if_icmpge -> 257
    //   244: iload_2
    //   245: iconst_m1
    //   246: if_icmpeq -> 252
    //   249: goto -> 257
    //   252: iload_1
    //   253: istore_2
    //   254: goto -> 216
    //   257: iload_2
    //   258: iconst_m1
    //   259: if_icmpeq -> 149
    //   262: aload #6
    //   264: iload_2
    //   265: iload #5
    //   267: iconst_3
    //   268: iand
    //   269: bipush #6
    //   271: ishl
    //   272: ior
    //   273: i2c
    //   274: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   277: pop
    //   278: goto -> 21
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\security\mobile\module\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */