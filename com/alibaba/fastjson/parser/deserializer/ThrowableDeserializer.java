package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class ThrowableDeserializer extends JavaBeanDeserializer {
  public ThrowableDeserializer(ParserConfig paramParserConfig, Class<?> paramClass) {
    super(paramParserConfig, paramClass, paramClass);
  }
  
  private Throwable createException(String paramString, Throwable paramThrowable, Class<?> paramClass) throws Exception {
    Constructor<Throwable> constructor;
    Constructor[] arrayOfConstructor = (Constructor[])paramClass.getConstructors();
    int j = arrayOfConstructor.length;
    Class clazz = null;
    paramClass = clazz;
    Class<?> clazz1 = paramClass;
    int i = 0;
    Class<?> clazz2 = paramClass;
    while (i < j) {
      Constructor<Throwable> constructor2;
      Class<?> clazz3;
      Class<?> clazz4;
      Constructor<Throwable> constructor1 = arrayOfConstructor[i];
      Class[] arrayOfClass = constructor1.getParameterTypes();
      if (arrayOfClass.length == 0) {
        Class clazz5 = clazz;
        clazz3 = clazz2;
        Constructor<Throwable> constructor3 = constructor1;
      } else if (arrayOfClass.length == 1 && arrayOfClass[0] == String.class) {
        Class clazz5 = clazz;
        Constructor<Throwable> constructor3 = constructor1;
        clazz4 = clazz1;
      } else {
        Class clazz5 = clazz;
        clazz3 = clazz2;
        clazz4 = clazz1;
        if (arrayOfClass.length == 2) {
          clazz5 = clazz;
          clazz3 = clazz2;
          clazz4 = clazz1;
          if (arrayOfClass[0] == String.class) {
            clazz5 = clazz;
            clazz3 = clazz2;
            clazz4 = clazz1;
            if (arrayOfClass[1] == Throwable.class) {
              clazz4 = clazz1;
              clazz3 = clazz2;
              constructor2 = constructor1;
            } 
          } 
        } 
      } 
      i++;
      constructor = constructor2;
      clazz2 = clazz3;
      clazz1 = clazz4;
    } 
    return (constructor != null) ? constructor.newInstance(new Object[] { paramString, paramThrowable }) : ((clazz2 != null) ? (Throwable)clazz2.newInstance(new Object[] { paramString }) : ((clazz1 != null) ? (Throwable)clazz1.newInstance(new Object[0]) : null));
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    // Byte code:
    //   0: aload_1
    //   1: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   4: astore #10
    //   6: aload #10
    //   8: invokeinterface token : ()I
    //   13: bipush #8
    //   15: if_icmpne -> 27
    //   18: aload #10
    //   20: invokeinterface nextToken : ()V
    //   25: aconst_null
    //   26: areturn
    //   27: aload_1
    //   28: invokevirtual getResolveStatus : ()I
    //   31: iconst_2
    //   32: if_icmpne -> 43
    //   35: aload_1
    //   36: iconst_0
    //   37: invokevirtual setResolveStatus : (I)V
    //   40: goto -> 55
    //   43: aload #10
    //   45: invokeinterface token : ()I
    //   50: bipush #12
    //   52: if_icmpne -> 555
    //   55: aload_2
    //   56: ifnull -> 83
    //   59: aload_2
    //   60: instanceof java/lang/Class
    //   63: ifeq -> 83
    //   66: aload_2
    //   67: checkcast java/lang/Class
    //   70: astore_2
    //   71: ldc java/lang/Throwable
    //   73: aload_2
    //   74: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   77: ifeq -> 83
    //   80: goto -> 85
    //   83: aconst_null
    //   84: astore_2
    //   85: new java/util/HashMap
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: astore #11
    //   94: aload_2
    //   95: astore #4
    //   97: aconst_null
    //   98: astore_2
    //   99: aload_2
    //   100: astore #5
    //   102: aload #5
    //   104: astore_3
    //   105: aload #10
    //   107: aload_1
    //   108: invokevirtual getSymbolTable : ()Lcom/alibaba/fastjson/parser/SymbolTable;
    //   111: invokeinterface scanSymbol : (Lcom/alibaba/fastjson/parser/SymbolTable;)Ljava/lang/String;
    //   116: astore #6
    //   118: aload #6
    //   120: ifnonnull -> 175
    //   123: aload #10
    //   125: invokeinterface token : ()I
    //   130: bipush #13
    //   132: if_icmpne -> 147
    //   135: aload #10
    //   137: bipush #16
    //   139: invokeinterface nextToken : (I)V
    //   144: goto -> 483
    //   147: aload #10
    //   149: invokeinterface token : ()I
    //   154: bipush #16
    //   156: if_icmpne -> 175
    //   159: aload #10
    //   161: getstatic com/alibaba/fastjson/parser/Feature.AllowArbitraryCommas : Lcom/alibaba/fastjson/parser/Feature;
    //   164: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   169: ifeq -> 175
    //   172: goto -> 105
    //   175: aload #10
    //   177: iconst_4
    //   178: invokeinterface nextTokenWithColon : (I)V
    //   183: getstatic com/alibaba/fastjson/JSON.DEFAULT_TYPE_KEY : Ljava/lang/String;
    //   186: aload #6
    //   188: invokevirtual equals : (Ljava/lang/Object;)Z
    //   191: ifeq -> 256
    //   194: aload #10
    //   196: invokeinterface token : ()I
    //   201: iconst_4
    //   202: if_icmpne -> 246
    //   205: aload #10
    //   207: invokeinterface stringVal : ()Ljava/lang/String;
    //   212: aload_1
    //   213: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   216: invokevirtual getDefaultClassLoader : ()Ljava/lang/ClassLoader;
    //   219: invokestatic loadClass : (Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class;
    //   222: astore #6
    //   224: aload #10
    //   226: bipush #16
    //   228: invokeinterface nextToken : (I)V
    //   233: aload #5
    //   235: astore #7
    //   237: aload_3
    //   238: astore #8
    //   240: aload_2
    //   241: astore #9
    //   243: goto -> 434
    //   246: new com/alibaba/fastjson/JSONException
    //   249: dup
    //   250: ldc 'syntax error'
    //   252: invokespecial <init> : (Ljava/lang/String;)V
    //   255: athrow
    //   256: ldc 'message'
    //   258: aload #6
    //   260: invokevirtual equals : (Ljava/lang/Object;)Z
    //   263: ifeq -> 334
    //   266: aload #10
    //   268: invokeinterface token : ()I
    //   273: bipush #8
    //   275: if_icmpne -> 284
    //   278: aconst_null
    //   279: astore #7
    //   281: goto -> 304
    //   284: aload #10
    //   286: invokeinterface token : ()I
    //   291: iconst_4
    //   292: if_icmpne -> 324
    //   295: aload #10
    //   297: invokeinterface stringVal : ()Ljava/lang/String;
    //   302: astore #7
    //   304: aload #10
    //   306: invokeinterface nextToken : ()V
    //   311: aload #4
    //   313: astore #6
    //   315: aload_3
    //   316: astore #8
    //   318: aload_2
    //   319: astore #9
    //   321: goto -> 434
    //   324: new com/alibaba/fastjson/JSONException
    //   327: dup
    //   328: ldc 'syntax error'
    //   330: invokespecial <init> : (Ljava/lang/String;)V
    //   333: athrow
    //   334: ldc 'cause'
    //   336: aload #6
    //   338: invokevirtual equals : (Ljava/lang/Object;)Z
    //   341: ifeq -> 371
    //   344: aload_0
    //   345: aload_1
    //   346: aconst_null
    //   347: ldc 'cause'
    //   349: invokevirtual deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   352: checkcast java/lang/Throwable
    //   355: astore #9
    //   357: aload #4
    //   359: astore #6
    //   361: aload #5
    //   363: astore #7
    //   365: aload_3
    //   366: astore #8
    //   368: goto -> 434
    //   371: ldc 'stackTrace'
    //   373: aload #6
    //   375: invokevirtual equals : (Ljava/lang/Object;)Z
    //   378: ifeq -> 406
    //   381: aload_1
    //   382: ldc [Ljava/lang/StackTraceElement;
    //   384: invokevirtual parseObject : (Ljava/lang/Class;)Ljava/lang/Object;
    //   387: checkcast [Ljava/lang/StackTraceElement;
    //   390: astore #8
    //   392: aload #4
    //   394: astore #6
    //   396: aload #5
    //   398: astore #7
    //   400: aload_2
    //   401: astore #9
    //   403: goto -> 434
    //   406: aload #11
    //   408: aload #6
    //   410: aload_1
    //   411: invokevirtual parse : ()Ljava/lang/Object;
    //   414: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   419: pop
    //   420: aload_2
    //   421: astore #9
    //   423: aload_3
    //   424: astore #8
    //   426: aload #5
    //   428: astore #7
    //   430: aload #4
    //   432: astore #6
    //   434: aload #6
    //   436: astore #4
    //   438: aload #7
    //   440: astore #5
    //   442: aload #8
    //   444: astore_3
    //   445: aload #9
    //   447: astore_2
    //   448: aload #10
    //   450: invokeinterface token : ()I
    //   455: bipush #13
    //   457: if_icmpne -> 105
    //   460: aload #10
    //   462: bipush #16
    //   464: invokeinterface nextToken : (I)V
    //   469: aload #9
    //   471: astore_2
    //   472: aload #8
    //   474: astore_3
    //   475: aload #7
    //   477: astore #5
    //   479: aload #6
    //   481: astore #4
    //   483: aload #4
    //   485: ifnonnull -> 502
    //   488: new java/lang/Exception
    //   491: dup
    //   492: aload #5
    //   494: aload_2
    //   495: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   498: astore_1
    //   499: goto -> 532
    //   502: aload_0
    //   503: aload #5
    //   505: aload_2
    //   506: aload #4
    //   508: invokespecial createException : (Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/Class;)Ljava/lang/Throwable;
    //   511: astore #4
    //   513: aload #4
    //   515: astore_1
    //   516: aload #4
    //   518: ifnonnull -> 532
    //   521: new java/lang/Exception
    //   524: dup
    //   525: aload #5
    //   527: aload_2
    //   528: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   531: astore_1
    //   532: aload_3
    //   533: ifnull -> 541
    //   536: aload_1
    //   537: aload_3
    //   538: invokevirtual setStackTrace : ([Ljava/lang/StackTraceElement;)V
    //   541: aload_1
    //   542: areturn
    //   543: astore_1
    //   544: new com/alibaba/fastjson/JSONException
    //   547: dup
    //   548: ldc 'create instance error'
    //   550: aload_1
    //   551: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   554: athrow
    //   555: new com/alibaba/fastjson/JSONException
    //   558: dup
    //   559: ldc 'syntax error'
    //   561: invokespecial <init> : (Ljava/lang/String;)V
    //   564: athrow
    // Exception table:
    //   from	to	target	type
    //   502	513	543	java/lang/Exception
    //   521	532	543	java/lang/Exception
  }
  
  public int getFastMatchToken() {
    return 12;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\ThrowableDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */