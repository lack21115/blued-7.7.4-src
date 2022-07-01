package com.blued.android.framework.urlroute;

import java.util.Map;

public class BluedUrlParser {
  private String a;
  
  private Map<String, String> b;
  
  private BluedUrlParser(String paramString) {
    this.a = paramString;
  }
  
  public static BluedUrlParser a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: istore #5
    //   6: aconst_null
    //   7: astore #6
    //   9: iload #5
    //   11: ifeq -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: invokestatic a : ()Lcom/blued/android/framework/urlroute/BluedURIRouter;
    //   19: invokevirtual c : ()Ljava/lang/String;
    //   22: astore #7
    //   24: aload #7
    //   26: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   29: ifne -> 44
    //   32: aload_0
    //   33: aload #7
    //   35: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   38: ifeq -> 44
    //   41: goto -> 123
    //   44: new java/net/URL
    //   47: dup
    //   48: aload_0
    //   49: invokespecial <init> : (Ljava/lang/String;)V
    //   52: astore #7
    //   54: invokestatic a : ()Lcom/blued/android/framework/urlroute/BluedURIRouter;
    //   57: invokevirtual d : ()[Ljava/lang/String;
    //   60: astore #8
    //   62: iconst_0
    //   63: istore_3
    //   64: iload_3
    //   65: istore_2
    //   66: aload #8
    //   68: ifnull -> 117
    //   71: aload #8
    //   73: arraylength
    //   74: istore #4
    //   76: iconst_0
    //   77: istore_1
    //   78: iload_3
    //   79: istore_2
    //   80: iload_1
    //   81: iload #4
    //   83: if_icmpge -> 117
    //   86: aload #8
    //   88: iload_1
    //   89: aaload
    //   90: aload #7
    //   92: invokevirtual getHost : ()Ljava/lang/String;
    //   95: invokevirtual equalsIgnoreCase : (Ljava/lang/String;)Z
    //   98: istore #5
    //   100: iload #5
    //   102: ifeq -> 110
    //   105: iconst_1
    //   106: istore_2
    //   107: goto -> 117
    //   110: iload_1
    //   111: iconst_1
    //   112: iadd
    //   113: istore_1
    //   114: goto -> 78
    //   117: iload_2
    //   118: ifne -> 123
    //   121: aconst_null
    //   122: areturn
    //   123: aload_0
    //   124: invokestatic a : (Ljava/lang/String;)Ljava/util/Map;
    //   127: astore #7
    //   129: aload #6
    //   131: astore_0
    //   132: aload #7
    //   134: ifnull -> 191
    //   137: aload #6
    //   139: astore_0
    //   140: aload #7
    //   142: invokeinterface size : ()I
    //   147: ifle -> 191
    //   150: aload #7
    //   152: ldc 'action'
    //   154: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   159: checkcast java/lang/String
    //   162: astore #8
    //   164: aload #6
    //   166: astore_0
    //   167: aload #8
    //   169: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   172: ifne -> 191
    //   175: new com/blued/android/framework/urlroute/BluedUrlParser
    //   178: dup
    //   179: aload #8
    //   181: invokespecial <init> : (Ljava/lang/String;)V
    //   184: astore_0
    //   185: aload_0
    //   186: aload #7
    //   188: invokevirtual a : (Ljava/util/Map;)V
    //   191: aload_0
    //   192: areturn
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual printStackTrace : ()V
    //   198: aconst_null
    //   199: areturn
    // Exception table:
    //   from	to	target	type
    //   44	62	193	java/net/MalformedURLException
    //   71	76	193	java/net/MalformedURLException
    //   86	100	193	java/net/MalformedURLException
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(Map<String, String> paramMap) {
    this.b = paramMap;
  }
  
  public Map<String, String> b() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framewor\\urlroute\BluedUrlParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */