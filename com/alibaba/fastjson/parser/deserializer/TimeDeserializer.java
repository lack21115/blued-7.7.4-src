package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import java.lang.reflect.Type;

public class TimeDeserializer implements ObjectDeserializer {
  public static final TimeDeserializer instance = new TimeDeserializer();
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    // Byte code:
    //   0: aload_1
    //   1: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   4: astore_2
    //   5: aload_2
    //   6: invokeinterface token : ()I
    //   11: bipush #16
    //   13: if_icmpne -> 125
    //   16: aload_2
    //   17: iconst_4
    //   18: invokeinterface nextToken : (I)V
    //   23: aload_2
    //   24: invokeinterface token : ()I
    //   29: iconst_4
    //   30: if_icmpne -> 115
    //   33: aload_2
    //   34: iconst_2
    //   35: invokeinterface nextTokenWithColon : (I)V
    //   40: aload_2
    //   41: invokeinterface token : ()I
    //   46: iconst_2
    //   47: if_icmpne -> 105
    //   50: aload_2
    //   51: invokeinterface longValue : ()J
    //   56: lstore #8
    //   58: aload_2
    //   59: bipush #13
    //   61: invokeinterface nextToken : (I)V
    //   66: aload_2
    //   67: invokeinterface token : ()I
    //   72: bipush #13
    //   74: if_icmpne -> 95
    //   77: aload_2
    //   78: bipush #16
    //   80: invokeinterface nextToken : (I)V
    //   85: new java/sql/Time
    //   88: dup
    //   89: lload #8
    //   91: invokespecial <init> : (J)V
    //   94: areturn
    //   95: new com/alibaba/fastjson/JSONException
    //   98: dup
    //   99: ldc 'syntax error'
    //   101: invokespecial <init> : (Ljava/lang/String;)V
    //   104: athrow
    //   105: new com/alibaba/fastjson/JSONException
    //   108: dup
    //   109: ldc 'syntax error'
    //   111: invokespecial <init> : (Ljava/lang/String;)V
    //   114: athrow
    //   115: new com/alibaba/fastjson/JSONException
    //   118: dup
    //   119: ldc 'syntax error'
    //   121: invokespecial <init> : (Ljava/lang/String;)V
    //   124: athrow
    //   125: aload_1
    //   126: invokevirtual parse : ()Ljava/lang/Object;
    //   129: astore_1
    //   130: aload_1
    //   131: ifnonnull -> 136
    //   134: aconst_null
    //   135: areturn
    //   136: aload_1
    //   137: instanceof java/sql/Time
    //   140: ifeq -> 145
    //   143: aload_1
    //   144: areturn
    //   145: aload_1
    //   146: instanceof java/lang/Number
    //   149: ifeq -> 167
    //   152: new java/sql/Time
    //   155: dup
    //   156: aload_1
    //   157: checkcast java/lang/Number
    //   160: invokevirtual longValue : ()J
    //   163: invokespecial <init> : (J)V
    //   166: areturn
    //   167: aload_1
    //   168: instanceof java/lang/String
    //   171: ifeq -> 310
    //   174: aload_1
    //   175: checkcast java/lang/String
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual length : ()I
    //   183: ifne -> 188
    //   186: aconst_null
    //   187: areturn
    //   188: new com/alibaba/fastjson/parser/JSONScanner
    //   191: dup
    //   192: aload_1
    //   193: invokespecial <init> : (Ljava/lang/String;)V
    //   196: astore_2
    //   197: aload_2
    //   198: invokevirtual scanISO8601DateIfMatch : ()Z
    //   201: ifeq -> 216
    //   204: aload_2
    //   205: invokevirtual getCalendar : ()Ljava/util/Calendar;
    //   208: invokevirtual getTimeInMillis : ()J
    //   211: lstore #8
    //   213: goto -> 296
    //   216: iconst_0
    //   217: istore #6
    //   219: iconst_0
    //   220: istore #4
    //   222: iload #4
    //   224: aload_1
    //   225: invokevirtual length : ()I
    //   228: if_icmpge -> 273
    //   231: aload_1
    //   232: iload #4
    //   234: invokevirtual charAt : (I)C
    //   237: istore #7
    //   239: iload #6
    //   241: istore #5
    //   243: iload #7
    //   245: bipush #48
    //   247: if_icmplt -> 276
    //   250: iload #7
    //   252: bipush #57
    //   254: if_icmple -> 264
    //   257: iload #6
    //   259: istore #5
    //   261: goto -> 276
    //   264: iload #4
    //   266: iconst_1
    //   267: iadd
    //   268: istore #4
    //   270: goto -> 222
    //   273: iconst_1
    //   274: istore #5
    //   276: iload #5
    //   278: ifne -> 290
    //   281: aload_2
    //   282: invokevirtual close : ()V
    //   285: aload_1
    //   286: invokestatic valueOf : (Ljava/lang/String;)Ljava/sql/Time;
    //   289: areturn
    //   290: aload_1
    //   291: invokestatic parseLong : (Ljava/lang/String;)J
    //   294: lstore #8
    //   296: aload_2
    //   297: invokevirtual close : ()V
    //   300: new java/sql/Time
    //   303: dup
    //   304: lload #8
    //   306: invokespecial <init> : (J)V
    //   309: areturn
    //   310: new com/alibaba/fastjson/JSONException
    //   313: dup
    //   314: ldc 'parse error'
    //   316: invokespecial <init> : (Ljava/lang/String;)V
    //   319: athrow
  }
  
  public int getFastMatchToken() {
    return 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\TimeDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */