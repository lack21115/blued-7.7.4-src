package cn.com.chinatelecom.account.api.a;

import java.io.UnsupportedEncodingException;

public class a {
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
    try {
      return b(paramString);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      unsupportedEncodingException.printStackTrace();
      return new byte[0];
    } 
  }
  
  private static byte[] b(String paramString) {
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
    //   23: if_icmpge -> 155
    //   26: iload_1
    //   27: istore_2
    //   28: getstatic cn/com/chinatelecom/account/api/a/a.b : [B
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
    //   64: iload_1
    //   65: istore_2
    //   66: iload #5
    //   68: iconst_m1
    //   69: if_icmpne -> 75
    //   72: goto -> 155
    //   75: getstatic cn/com/chinatelecom/account/api/a/a.b : [B
    //   78: astore #7
    //   80: iload_2
    //   81: iconst_1
    //   82: iadd
    //   83: istore_1
    //   84: aload #7
    //   86: aload_0
    //   87: iload_2
    //   88: baload
    //   89: baload
    //   90: istore #4
    //   92: iload_1
    //   93: iload_3
    //   94: if_icmpge -> 111
    //   97: iload #4
    //   99: iconst_m1
    //   100: if_icmpeq -> 106
    //   103: goto -> 111
    //   106: iload_1
    //   107: istore_2
    //   108: goto -> 75
    //   111: iload #4
    //   113: iconst_m1
    //   114: if_icmpne -> 120
    //   117: goto -> 155
    //   120: aload #6
    //   122: iload #5
    //   124: iconst_2
    //   125: ishl
    //   126: iload #4
    //   128: bipush #48
    //   130: iand
    //   131: iconst_4
    //   132: iushr
    //   133: ior
    //   134: i2c
    //   135: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   138: pop
    //   139: iload_1
    //   140: istore_2
    //   141: iload_2
    //   142: iconst_1
    //   143: iadd
    //   144: istore_1
    //   145: aload_0
    //   146: iload_2
    //   147: baload
    //   148: istore_2
    //   149: iload_2
    //   150: bipush #61
    //   152: if_icmpne -> 166
    //   155: aload #6
    //   157: invokevirtual toString : ()Ljava/lang/String;
    //   160: ldc 'iso8859-1'
    //   162: invokevirtual getBytes : (Ljava/lang/String;)[B
    //   165: areturn
    //   166: getstatic cn/com/chinatelecom/account/api/a/a.b : [B
    //   169: iload_2
    //   170: baload
    //   171: istore #5
    //   173: iload_1
    //   174: iload_3
    //   175: if_icmpge -> 192
    //   178: iload #5
    //   180: iconst_m1
    //   181: if_icmpeq -> 187
    //   184: goto -> 192
    //   187: iload_1
    //   188: istore_2
    //   189: goto -> 141
    //   192: iload #5
    //   194: iconst_m1
    //   195: if_icmpne -> 201
    //   198: goto -> 155
    //   201: aload #6
    //   203: iload #4
    //   205: bipush #15
    //   207: iand
    //   208: iconst_4
    //   209: ishl
    //   210: iload #5
    //   212: bipush #60
    //   214: iand
    //   215: iconst_2
    //   216: iushr
    //   217: ior
    //   218: i2c
    //   219: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   222: pop
    //   223: iload_1
    //   224: istore_2
    //   225: iload_2
    //   226: iconst_1
    //   227: iadd
    //   228: istore_1
    //   229: aload_0
    //   230: iload_2
    //   231: baload
    //   232: istore_2
    //   233: iload_2
    //   234: bipush #61
    //   236: if_icmpne -> 242
    //   239: goto -> 155
    //   242: getstatic cn/com/chinatelecom/account/api/a/a.b : [B
    //   245: iload_2
    //   246: baload
    //   247: istore_2
    //   248: iload_1
    //   249: iload_3
    //   250: if_icmpge -> 266
    //   253: iload_2
    //   254: iconst_m1
    //   255: if_icmpeq -> 261
    //   258: goto -> 266
    //   261: iload_1
    //   262: istore_2
    //   263: goto -> 225
    //   266: iload_2
    //   267: iconst_m1
    //   268: if_icmpne -> 274
    //   271: goto -> 155
    //   274: aload #6
    //   276: iload_2
    //   277: iload #5
    //   279: iconst_3
    //   280: iand
    //   281: bipush #6
    //   283: ishl
    //   284: ior
    //   285: i2c
    //   286: invokevirtual append : (C)Ljava/lang/StringBuffer;
    //   289: pop
    //   290: goto -> 21
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\com\chinatelecom\account\api\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */