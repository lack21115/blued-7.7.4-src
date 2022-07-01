package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class ArrayListTypeFieldDeserializer extends FieldDeserializer {
  private ObjectDeserializer deserializer;
  
  private int itemFastMatchToken;
  
  private final Type itemType;
  
  public ArrayListTypeFieldDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, FieldInfo paramFieldInfo) {
    super(paramClass, paramFieldInfo);
    if (paramFieldInfo.fieldType instanceof ParameterizedType) {
      this.itemType = ((ParameterizedType)paramFieldInfo.fieldType).getActualTypeArguments()[0];
      return;
    } 
    this.itemType = Object.class;
  }
  
  public int getFastMatchToken() {
    return 14;
  }
  
  public final void parseArray(DefaultJSONParser paramDefaultJSONParser, Type paramType, Collection paramCollection) {
    // Byte code:
    //   0: aload_0
    //   1: getfield itemType : Ljava/lang/reflect/Type;
    //   4: astore #11
    //   6: aload_0
    //   7: getfield deserializer : Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   10: astore #10
    //   12: aload #11
    //   14: instanceof java/lang/reflect/TypeVariable
    //   17: istore #7
    //   19: iconst_0
    //   20: istore #5
    //   22: aload #11
    //   24: astore #9
    //   26: aload #10
    //   28: astore #8
    //   30: iload #7
    //   32: ifeq -> 216
    //   35: aload #11
    //   37: astore #9
    //   39: aload #10
    //   41: astore #8
    //   43: aload_2
    //   44: instanceof java/lang/reflect/ParameterizedType
    //   47: ifeq -> 216
    //   50: aload #11
    //   52: checkcast java/lang/reflect/TypeVariable
    //   55: astore #9
    //   57: aload_2
    //   58: checkcast java/lang/reflect/ParameterizedType
    //   61: astore #12
    //   63: aconst_null
    //   64: astore #8
    //   66: aload #12
    //   68: invokeinterface getRawType : ()Ljava/lang/reflect/Type;
    //   73: instanceof java/lang/Class
    //   76: ifeq -> 91
    //   79: aload #12
    //   81: invokeinterface getRawType : ()Ljava/lang/reflect/Type;
    //   86: checkcast java/lang/Class
    //   89: astore #8
    //   91: aload #8
    //   93: ifnull -> 152
    //   96: aload #8
    //   98: invokevirtual getTypeParameters : ()[Ljava/lang/reflect/TypeVariable;
    //   101: arraylength
    //   102: istore #6
    //   104: iconst_0
    //   105: istore #4
    //   107: iload #4
    //   109: iload #6
    //   111: if_icmpge -> 152
    //   114: aload #8
    //   116: invokevirtual getTypeParameters : ()[Ljava/lang/reflect/TypeVariable;
    //   119: iload #4
    //   121: aaload
    //   122: invokeinterface getName : ()Ljava/lang/String;
    //   127: aload #9
    //   129: invokeinterface getName : ()Ljava/lang/String;
    //   134: invokevirtual equals : (Ljava/lang/Object;)Z
    //   137: ifeq -> 143
    //   140: goto -> 155
    //   143: iload #4
    //   145: iconst_1
    //   146: iadd
    //   147: istore #4
    //   149: goto -> 107
    //   152: iconst_m1
    //   153: istore #4
    //   155: aload #11
    //   157: astore #9
    //   159: aload #10
    //   161: astore #8
    //   163: iload #4
    //   165: iconst_m1
    //   166: if_icmpeq -> 216
    //   169: aload #12
    //   171: invokeinterface getActualTypeArguments : ()[Ljava/lang/reflect/Type;
    //   176: iload #4
    //   178: aaload
    //   179: astore #11
    //   181: aload #11
    //   183: astore #9
    //   185: aload #10
    //   187: astore #8
    //   189: aload #11
    //   191: aload_0
    //   192: getfield itemType : Ljava/lang/reflect/Type;
    //   195: invokevirtual equals : (Ljava/lang/Object;)Z
    //   198: ifne -> 216
    //   201: aload_1
    //   202: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   205: aload #11
    //   207: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   210: astore #8
    //   212: aload #11
    //   214: astore #9
    //   216: aload_1
    //   217: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   220: astore #10
    //   222: aload #10
    //   224: invokeinterface token : ()I
    //   229: bipush #14
    //   231: if_icmpeq -> 316
    //   234: new java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial <init> : ()V
    //   241: astore_1
    //   242: aload_1
    //   243: ldc 'exepct '[', but '
    //   245: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: aload_1
    //   250: aload #10
    //   252: invokeinterface token : ()I
    //   257: invokestatic name : (I)Ljava/lang/String;
    //   260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: aload_1
    //   265: invokevirtual toString : ()Ljava/lang/String;
    //   268: astore_3
    //   269: aload_3
    //   270: astore_1
    //   271: aload_2
    //   272: ifnull -> 307
    //   275: new java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial <init> : ()V
    //   282: astore_1
    //   283: aload_1
    //   284: aload_3
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_1
    //   290: ldc ', type : '
    //   292: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload_1
    //   297: aload_2
    //   298: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload_1
    //   303: invokevirtual toString : ()Ljava/lang/String;
    //   306: astore_1
    //   307: new com/alibaba/fastjson/JSONException
    //   310: dup
    //   311: aload_1
    //   312: invokespecial <init> : (Ljava/lang/String;)V
    //   315: athrow
    //   316: aload #8
    //   318: astore_2
    //   319: aload #8
    //   321: ifnonnull -> 352
    //   324: aload_1
    //   325: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   328: aload #9
    //   330: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   333: astore_2
    //   334: aload_0
    //   335: aload_2
    //   336: putfield deserializer : Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   339: aload_0
    //   340: aload_0
    //   341: getfield deserializer : Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   344: invokeinterface getFastMatchToken : ()I
    //   349: putfield itemFastMatchToken : I
    //   352: aload #10
    //   354: aload_0
    //   355: getfield itemFastMatchToken : I
    //   358: invokeinterface nextToken : (I)V
    //   363: iload #5
    //   365: istore #4
    //   367: aload #10
    //   369: getstatic com/alibaba/fastjson/parser/Feature.AllowArbitraryCommas : Lcom/alibaba/fastjson/parser/Feature;
    //   372: invokeinterface isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   377: ifeq -> 402
    //   380: aload #10
    //   382: invokeinterface token : ()I
    //   387: bipush #16
    //   389: if_icmpne -> 402
    //   392: aload #10
    //   394: invokeinterface nextToken : ()V
    //   399: goto -> 380
    //   402: aload #10
    //   404: invokeinterface token : ()I
    //   409: bipush #15
    //   411: if_icmpne -> 424
    //   414: aload #10
    //   416: bipush #16
    //   418: invokeinterface nextToken : (I)V
    //   423: return
    //   424: aload_3
    //   425: aload_2
    //   426: aload_1
    //   427: aload #9
    //   429: iload #4
    //   431: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   434: invokeinterface deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   439: invokeinterface add : (Ljava/lang/Object;)Z
    //   444: pop
    //   445: aload_1
    //   446: aload_3
    //   447: invokevirtual checkListResolve : (Ljava/util/Collection;)V
    //   450: aload #10
    //   452: invokeinterface token : ()I
    //   457: bipush #16
    //   459: if_icmpne -> 473
    //   462: aload #10
    //   464: aload_0
    //   465: getfield itemFastMatchToken : I
    //   468: invokeinterface nextToken : (I)V
    //   473: iload #4
    //   475: iconst_1
    //   476: iadd
    //   477: istore #4
    //   479: goto -> 367
  }
  
  public void parseField(DefaultJSONParser paramDefaultJSONParser, Object paramObject, Type paramType, Map<String, Object> paramMap) {
    if (paramDefaultJSONParser.lexer.token() == 8) {
      setValue(paramObject, (String)null);
      return;
    } 
    ArrayList arrayList = new ArrayList();
    ParseContext parseContext = paramDefaultJSONParser.getContext();
    paramDefaultJSONParser.setContext(parseContext, paramObject, this.fieldInfo.name);
    parseArray(paramDefaultJSONParser, paramType, arrayList);
    paramDefaultJSONParser.setContext(parseContext);
    if (paramObject == null) {
      paramMap.put(this.fieldInfo.name, arrayList);
      return;
    } 
    setValue(paramObject, arrayList);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\ArrayListTypeFieldDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */