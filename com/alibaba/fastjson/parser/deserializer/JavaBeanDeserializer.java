package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.JavaBeanInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Map;

public class JavaBeanDeserializer implements ObjectDeserializer {
  public final JavaBeanInfo beanInfo;
  
  protected final Class<?> clazz;
  
  private final FieldDeserializer[] fieldDeserializers;
  
  protected final FieldDeserializer[] sortedFieldDeserializers;
  
  public JavaBeanDeserializer(ParserConfig paramParserConfig, Class<?> paramClass, Type paramType) {
    this.clazz = paramClass;
    this.beanInfo = JavaBeanInfo.build(paramClass, paramType);
    this.sortedFieldDeserializers = new FieldDeserializer[this.beanInfo.sortedFields.length];
    int j = this.beanInfo.sortedFields.length;
    boolean bool = false;
    int i;
    for (i = 0; i < j; i++) {
      FieldInfo fieldInfo = this.beanInfo.sortedFields[i];
      FieldDeserializer fieldDeserializer = paramParserConfig.createFieldDeserializer(paramParserConfig, this.beanInfo, fieldInfo);
      this.sortedFieldDeserializers[i] = fieldDeserializer;
    } 
    this.fieldDeserializers = new FieldDeserializer[this.beanInfo.fields.length];
    j = this.beanInfo.fields.length;
    for (i = bool; i < j; i++) {
      FieldDeserializer fieldDeserializer = getFieldDeserializer((this.beanInfo.fields[i]).name);
      this.fieldDeserializers[i] = fieldDeserializer;
    } 
  }
  
  public Object createInstance(DefaultJSONParser paramDefaultJSONParser, Type paramType) {
    Class clazz;
    boolean bool = paramType instanceof Class;
    int i = 0;
    if (bool && this.clazz.isInterface()) {
      clazz = (Class)paramType;
      ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
      JSONObject jSONObject = new JSONObject();
      return Proxy.newProxyInstance(classLoader, new Class[] { clazz }, (InvocationHandler)jSONObject);
    } 
    if (this.beanInfo.defaultConstructor == null)
      return null; 
    try {
      StringBuilder stringBuilder;
      Constructor<Constructor> constructor = this.beanInfo.defaultConstructor;
      if (this.beanInfo.defaultConstructorParameterSize == 0) {
        constructor = constructor.newInstance(new Object[0]);
      } else {
        constructor = constructor.newInstance(new Object[] { (clazz.getContext()).object });
      } 
      if (clazz != null && ((DefaultJSONParser)clazz).lexer.isEnabled(Feature.InitStringFieldAsEmpty)) {
        FieldInfo[] arrayOfFieldInfo = this.beanInfo.fields;
        int j = arrayOfFieldInfo.length;
        while (i < j) {
          FieldInfo fieldInfo = arrayOfFieldInfo[i];
          if (fieldInfo.fieldClass == String.class)
            try {
              fieldInfo.set(constructor, "");
            } catch (Exception exception) {
              stringBuilder = new StringBuilder();
              stringBuilder.append("create instance error, class ");
              stringBuilder.append(this.clazz.getName());
              throw new JSONException(stringBuilder.toString(), exception);
            }  
          i++;
        } 
      } 
      return stringBuilder;
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("create instance error, class ");
      stringBuilder.append(this.clazz.getName());
      throw new JSONException(stringBuilder.toString(), exception);
    } 
  }
  
  public Object createInstance(Map<String, Object> paramMap, ParserConfig paramParserConfig) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
    Constructor constructor = this.beanInfo.creatorConstructor;
    int i = 0;
    if (constructor == null && this.beanInfo.buildMethod == null) {
      Object object = createInstance((DefaultJSONParser)null, this.clazz);
      for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
        String str = (String)entry.getKey();
        entry = (Map.Entry<String, Object>)entry.getValue();
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str);
        if (fieldDeserializer == null)
          continue; 
        Method method = fieldDeserializer.fieldInfo.method;
        if (method != null) {
          method.invoke(object, new Object[] { TypeUtils.cast(entry, method.getGenericParameterTypes()[0], paramParserConfig) });
          continue;
        } 
        fieldDeserializer.fieldInfo.field.set(object, TypeUtils.cast(entry, fieldDeserializer.fieldInfo.fieldType, paramParserConfig));
      } 
      return object;
    } 
    FieldInfo[] arrayOfFieldInfo = this.beanInfo.fields;
    int j = arrayOfFieldInfo.length;
    Object[] arrayOfObject = new Object[j];
    while (i < j) {
      arrayOfObject[i] = paramMap.get((arrayOfFieldInfo[i]).name);
      i++;
    } 
    if (this.beanInfo.creatorConstructor != null)
      try {
        return this.beanInfo.creatorConstructor.newInstance(arrayOfObject);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create instance error, ");
        stringBuilder.append(this.beanInfo.creatorConstructor.toGenericString());
        throw new JSONException(stringBuilder.toString(), exception);
      }  
    if (this.beanInfo.factoryMethod != null)
      try {
        return this.beanInfo.factoryMethod.invoke(null, arrayOfObject);
      } catch (Exception exception) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create factory method error, ");
        stringBuilder.append(this.beanInfo.factoryMethod.toString());
        throw new JSONException(stringBuilder.toString(), exception);
      }  
    return null;
  }
  
  public <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject) {
    return deserialze(paramDefaultJSONParser, paramType, paramObject, null);
  }
  
  protected <T> T deserialze(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w com/alibaba/fastjson/JSON
    //   4: if_acmpeq -> 2514
    //   7: aload_2
    //   8: ldc com/alibaba/fastjson/JSONObject
    //   10: if_acmpne -> 16
    //   13: goto -> 2514
    //   16: aload_1
    //   17: getfield lexer : Lcom/alibaba/fastjson/parser/JSONLexer;
    //   20: checkcast com/alibaba/fastjson/parser/JSONLexerBase
    //   23: astore #21
    //   25: aload #21
    //   27: invokevirtual token : ()I
    //   30: istore #6
    //   32: aconst_null
    //   33: astore #10
    //   35: iload #6
    //   37: bipush #8
    //   39: if_icmpne -> 51
    //   42: aload #21
    //   44: bipush #16
    //   46: invokevirtual nextToken : (I)V
    //   49: aconst_null
    //   50: areturn
    //   51: aload_1
    //   52: invokevirtual getContext : ()Lcom/alibaba/fastjson/parser/ParseContext;
    //   55: astore #11
    //   57: aload #11
    //   59: astore #14
    //   61: aload #4
    //   63: ifnull -> 82
    //   66: aload #11
    //   68: astore #14
    //   70: aload #11
    //   72: ifnull -> 82
    //   75: aload #11
    //   77: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   80: astore #14
    //   82: iload #6
    //   84: bipush #13
    //   86: if_icmpne -> 138
    //   89: aload #21
    //   91: bipush #16
    //   93: invokevirtual nextToken : (I)V
    //   96: aload #4
    //   98: ifnonnull -> 114
    //   101: aload_0
    //   102: aload_1
    //   103: aload_2
    //   104: invokevirtual createInstance : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   107: astore_2
    //   108: aload_2
    //   109: astore #4
    //   111: goto -> 114
    //   114: aload_1
    //   115: aload #14
    //   117: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   120: aload #4
    //   122: areturn
    //   123: astore_2
    //   124: aload #4
    //   126: astore_3
    //   127: aload #10
    //   129: astore #4
    //   131: aload #4
    //   133: astore #11
    //   135: goto -> 2495
    //   138: iload #6
    //   140: bipush #14
    //   142: if_icmpne -> 199
    //   145: aload_0
    //   146: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   149: getfield parserFeatures : I
    //   152: getstatic com/alibaba/fastjson/parser/Feature.SupportArrayToBean : Lcom/alibaba/fastjson/parser/Feature;
    //   155: getfield mask : I
    //   158: iand
    //   159: ifne -> 2525
    //   162: aload #21
    //   164: getstatic com/alibaba/fastjson/parser/Feature.SupportArrayToBean : Lcom/alibaba/fastjson/parser/Feature;
    //   167: invokevirtual isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   170: ifeq -> 2519
    //   173: goto -> 2525
    //   176: iload #5
    //   178: ifeq -> 199
    //   181: aload_0
    //   182: aload_1
    //   183: aload_2
    //   184: aload_3
    //   185: aload #4
    //   187: invokevirtual deserialzeArrayMapping : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   190: astore_2
    //   191: aload_1
    //   192: aload #14
    //   194: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   197: aload_2
    //   198: areturn
    //   199: iload #6
    //   201: bipush #12
    //   203: if_icmpeq -> 340
    //   206: iload #6
    //   208: bipush #16
    //   210: if_icmpeq -> 340
    //   213: aload #21
    //   215: invokevirtual isBlankInput : ()Z
    //   218: istore #9
    //   220: iload #9
    //   222: ifeq -> 233
    //   225: aload_1
    //   226: aload #14
    //   228: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   231: aconst_null
    //   232: areturn
    //   233: iload #6
    //   235: iconst_4
    //   236: if_icmpne -> 263
    //   239: aload #21
    //   241: invokevirtual stringVal : ()Ljava/lang/String;
    //   244: invokevirtual length : ()I
    //   247: ifne -> 263
    //   250: aload #21
    //   252: invokevirtual nextToken : ()V
    //   255: aload_1
    //   256: aload #14
    //   258: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   261: aconst_null
    //   262: areturn
    //   263: new java/lang/StringBuffer
    //   266: dup
    //   267: invokespecial <init> : ()V
    //   270: astore_2
    //   271: aload_2
    //   272: ldc_w 'syntax error, expect {, actual '
    //   275: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   278: pop
    //   279: aload_2
    //   280: aload #21
    //   282: invokevirtual tokenName : ()Ljava/lang/String;
    //   285: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   288: pop
    //   289: aload_2
    //   290: ldc_w ', pos '
    //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   296: pop
    //   297: aload_2
    //   298: aload #21
    //   300: invokevirtual pos : ()I
    //   303: invokevirtual append : (I)Ljava/lang/StringBuffer;
    //   306: pop
    //   307: aload_3
    //   308: instanceof java/lang/String
    //   311: ifeq -> 328
    //   314: aload_2
    //   315: ldc_w ', fieldName '
    //   318: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   321: pop
    //   322: aload_2
    //   323: aload_3
    //   324: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuffer;
    //   327: pop
    //   328: new com/alibaba/fastjson/JSONException
    //   331: dup
    //   332: aload_2
    //   333: invokevirtual toString : ()Ljava/lang/String;
    //   336: invokespecial <init> : (Ljava/lang/String;)V
    //   339: athrow
    //   340: aload_1
    //   341: getfield resolveStatus : I
    //   344: istore #5
    //   346: iload #5
    //   348: iconst_2
    //   349: if_icmpne -> 357
    //   352: aload_1
    //   353: iconst_0
    //   354: putfield resolveStatus : I
    //   357: aconst_null
    //   358: astore #11
    //   360: aload #11
    //   362: astore #12
    //   364: iconst_0
    //   365: istore #5
    //   367: aload #4
    //   369: astore #10
    //   371: aload #10
    //   373: astore #13
    //   375: iload #5
    //   377: aload_0
    //   378: getfield sortedFieldDeserializers : [Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   381: arraylength
    //   382: if_icmpge -> 2531
    //   385: aload #10
    //   387: astore #13
    //   389: aload_0
    //   390: getfield sortedFieldDeserializers : [Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   393: iload #5
    //   395: aaload
    //   396: astore #17
    //   398: aload #10
    //   400: astore #13
    //   402: aload #17
    //   404: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   407: astore #16
    //   409: aload #10
    //   411: astore #13
    //   413: aload #16
    //   415: getfield fieldClass : Ljava/lang/Class;
    //   418: astore #15
    //   420: goto -> 423
    //   423: aload #17
    //   425: ifnull -> 2564
    //   428: aload #10
    //   430: astore #13
    //   432: aload #16
    //   434: getfield name_chars : [C
    //   437: astore #4
    //   439: aload #10
    //   441: astore #13
    //   443: aload #15
    //   445: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   448: if_acmpeq -> 911
    //   451: aload #15
    //   453: ldc_w java/lang/Integer
    //   456: if_acmpne -> 462
    //   459: goto -> 911
    //   462: aload #10
    //   464: astore #13
    //   466: aload #15
    //   468: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   471: if_acmpeq -> 863
    //   474: aload #15
    //   476: ldc_w java/lang/Long
    //   479: if_acmpne -> 485
    //   482: goto -> 863
    //   485: aload #15
    //   487: ldc java/lang/String
    //   489: if_acmpne -> 537
    //   492: aload #10
    //   494: astore #13
    //   496: aload #21
    //   498: aload #4
    //   500: invokevirtual scanFieldString : ([C)Ljava/lang/String;
    //   503: astore #4
    //   505: aload #10
    //   507: astore #13
    //   509: aload #21
    //   511: getfield matchStat : I
    //   514: ifle -> 520
    //   517: goto -> 2543
    //   520: aload #10
    //   522: astore #13
    //   524: aload #21
    //   526: getfield matchStat : I
    //   529: bipush #-2
    //   531: if_icmpne -> 2555
    //   534: goto -> 2552
    //   537: aload #10
    //   539: astore #13
    //   541: aload #15
    //   543: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   546: if_acmpeq -> 815
    //   549: aload #15
    //   551: ldc_w java/lang/Boolean
    //   554: if_acmpne -> 560
    //   557: goto -> 815
    //   560: aload #10
    //   562: astore #13
    //   564: aload #15
    //   566: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
    //   569: if_acmpeq -> 767
    //   572: aload #15
    //   574: ldc_w java/lang/Float
    //   577: if_acmpne -> 583
    //   580: goto -> 767
    //   583: aload #10
    //   585: astore #13
    //   587: aload #15
    //   589: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
    //   592: if_acmpeq -> 719
    //   595: aload #15
    //   597: ldc_w java/lang/Double
    //   600: if_acmpne -> 606
    //   603: goto -> 719
    //   606: aload #10
    //   608: astore #13
    //   610: aload #15
    //   612: invokevirtual isEnum : ()Z
    //   615: ifeq -> 699
    //   618: aload #10
    //   620: astore #13
    //   622: aload_1
    //   623: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   626: aload #15
    //   628: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   631: instanceof com/alibaba/fastjson/parser/deserializer/EnumDeserializer
    //   634: ifeq -> 699
    //   637: aload #10
    //   639: astore #13
    //   641: aload #21
    //   643: aload #4
    //   645: aload_1
    //   646: getfield symbolTable : Lcom/alibaba/fastjson/parser/SymbolTable;
    //   649: invokevirtual scanFieldSymbol : ([CLcom/alibaba/fastjson/parser/SymbolTable;)Ljava/lang/String;
    //   652: astore #4
    //   654: aload #10
    //   656: astore #13
    //   658: aload #21
    //   660: getfield matchStat : I
    //   663: ifle -> 682
    //   666: aload #10
    //   668: astore #13
    //   670: aload #15
    //   672: aload #4
    //   674: invokestatic valueOf : (Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;
    //   677: astore #4
    //   679: goto -> 2543
    //   682: aload #10
    //   684: astore #13
    //   686: aload #21
    //   688: getfield matchStat : I
    //   691: bipush #-2
    //   693: if_icmpne -> 2564
    //   696: goto -> 2552
    //   699: aload #10
    //   701: astore #13
    //   703: aload #21
    //   705: aload #4
    //   707: invokevirtual matchField : ([C)Z
    //   710: ifeq -> 2552
    //   713: iconst_1
    //   714: istore #6
    //   716: goto -> 2567
    //   719: aload #10
    //   721: astore #13
    //   723: aload #21
    //   725: aload #4
    //   727: invokevirtual scanFieldDouble : ([C)D
    //   730: invokestatic valueOf : (D)Ljava/lang/Double;
    //   733: astore #4
    //   735: aload #10
    //   737: astore #13
    //   739: aload #21
    //   741: getfield matchStat : I
    //   744: ifle -> 750
    //   747: goto -> 2543
    //   750: aload #10
    //   752: astore #13
    //   754: aload #21
    //   756: getfield matchStat : I
    //   759: bipush #-2
    //   761: if_icmpne -> 2555
    //   764: goto -> 2552
    //   767: aload #10
    //   769: astore #13
    //   771: aload #21
    //   773: aload #4
    //   775: invokevirtual scanFieldFloat : ([C)F
    //   778: invokestatic valueOf : (F)Ljava/lang/Float;
    //   781: astore #4
    //   783: aload #10
    //   785: astore #13
    //   787: aload #21
    //   789: getfield matchStat : I
    //   792: ifle -> 798
    //   795: goto -> 2543
    //   798: aload #10
    //   800: astore #13
    //   802: aload #21
    //   804: getfield matchStat : I
    //   807: bipush #-2
    //   809: if_icmpne -> 2555
    //   812: goto -> 2552
    //   815: aload #10
    //   817: astore #13
    //   819: aload #21
    //   821: aload #4
    //   823: invokevirtual scanFieldBoolean : ([C)Z
    //   826: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   829: astore #4
    //   831: aload #10
    //   833: astore #13
    //   835: aload #21
    //   837: getfield matchStat : I
    //   840: ifle -> 846
    //   843: goto -> 2543
    //   846: aload #10
    //   848: astore #13
    //   850: aload #21
    //   852: getfield matchStat : I
    //   855: bipush #-2
    //   857: if_icmpne -> 2555
    //   860: goto -> 2552
    //   863: aload #10
    //   865: astore #13
    //   867: aload #21
    //   869: aload #4
    //   871: invokevirtual scanFieldLong : ([C)J
    //   874: invokestatic valueOf : (J)Ljava/lang/Long;
    //   877: astore #4
    //   879: aload #10
    //   881: astore #13
    //   883: aload #21
    //   885: getfield matchStat : I
    //   888: ifle -> 894
    //   891: goto -> 2543
    //   894: aload #10
    //   896: astore #13
    //   898: aload #21
    //   900: getfield matchStat : I
    //   903: bipush #-2
    //   905: if_icmpne -> 2555
    //   908: goto -> 2552
    //   911: aload #10
    //   913: astore #13
    //   915: aload #21
    //   917: aload #4
    //   919: invokevirtual scanFieldInt : ([C)I
    //   922: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   925: astore #4
    //   927: aload #10
    //   929: astore #13
    //   931: aload #21
    //   933: getfield matchStat : I
    //   936: ifle -> 942
    //   939: goto -> 2543
    //   942: aload #10
    //   944: astore #13
    //   946: aload #21
    //   948: getfield matchStat : I
    //   951: bipush #-2
    //   953: if_icmpne -> 2555
    //   956: goto -> 2552
    //   959: iload #6
    //   961: ifne -> 2597
    //   964: aload #10
    //   966: astore #13
    //   968: aload #21
    //   970: aload_1
    //   971: getfield symbolTable : Lcom/alibaba/fastjson/parser/SymbolTable;
    //   974: invokevirtual scanSymbol : (Lcom/alibaba/fastjson/parser/SymbolTable;)Ljava/lang/String;
    //   977: astore #19
    //   979: aload #19
    //   981: ifnonnull -> 2576
    //   984: aload #10
    //   986: astore #13
    //   988: aload #21
    //   990: invokevirtual token : ()I
    //   993: istore #8
    //   995: iload #8
    //   997: bipush #13
    //   999: if_icmpne -> 1016
    //   1002: aload #10
    //   1004: astore #13
    //   1006: aload #21
    //   1008: bipush #16
    //   1010: invokevirtual nextToken : (I)V
    //   1013: goto -> 2579
    //   1016: iload #8
    //   1018: bipush #16
    //   1020: if_icmpne -> 1041
    //   1023: aload #10
    //   1025: astore #13
    //   1027: aload #21
    //   1029: getstatic com/alibaba/fastjson/parser/Feature.AllowArbitraryCommas : Lcom/alibaba/fastjson/parser/Feature;
    //   1032: invokevirtual isEnabled : (Lcom/alibaba/fastjson/parser/Feature;)Z
    //   1035: ifeq -> 1041
    //   1038: goto -> 2552
    //   1041: ldc_w '$ref'
    //   1044: aload #19
    //   1046: if_acmpne -> 1458
    //   1049: aload #10
    //   1051: astore #13
    //   1053: aload #21
    //   1055: iconst_4
    //   1056: invokevirtual nextTokenWithColon : (I)V
    //   1059: aload #10
    //   1061: astore #13
    //   1063: aload #21
    //   1065: invokevirtual token : ()I
    //   1068: istore #5
    //   1070: iload #5
    //   1072: iconst_4
    //   1073: if_icmpne -> 1404
    //   1076: aload #10
    //   1078: astore #13
    //   1080: aload #21
    //   1082: invokevirtual stringVal : ()Ljava/lang/String;
    //   1085: astore #4
    //   1087: aload #10
    //   1089: astore #13
    //   1091: ldc_w '@'
    //   1094: aload #4
    //   1096: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1099: ifeq -> 1116
    //   1102: aload #10
    //   1104: astore #13
    //   1106: aload #14
    //   1108: getfield object : Ljava/lang/Object;
    //   1111: astore #10
    //   1113: goto -> 1318
    //   1116: aload #10
    //   1118: astore #13
    //   1120: ldc_w '..'
    //   1123: aload #4
    //   1125: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1128: ifeq -> 1195
    //   1131: aload #10
    //   1133: astore #13
    //   1135: aload #14
    //   1137: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1140: astore_2
    //   1141: aload #10
    //   1143: astore #13
    //   1145: aload_2
    //   1146: getfield object : Ljava/lang/Object;
    //   1149: ifnull -> 1165
    //   1152: aload #10
    //   1154: astore #13
    //   1156: aload_2
    //   1157: getfield object : Ljava/lang/Object;
    //   1160: astore #10
    //   1162: goto -> 1318
    //   1165: aload #10
    //   1167: astore #13
    //   1169: aload_1
    //   1170: new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1173: dup
    //   1174: aload_2
    //   1175: aload #4
    //   1177: invokespecial <init> : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1180: invokevirtual addResolveTask : (Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1183: aload #10
    //   1185: astore #13
    //   1187: aload_1
    //   1188: iconst_1
    //   1189: putfield resolveStatus : I
    //   1192: goto -> 1318
    //   1195: aload #10
    //   1197: astore #13
    //   1199: ldc_w '$'
    //   1202: aload #4
    //   1204: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1207: ifeq -> 1290
    //   1210: aload #14
    //   1212: astore_2
    //   1213: aload #10
    //   1215: astore #13
    //   1217: aload_2
    //   1218: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1221: ifnull -> 1236
    //   1224: aload #10
    //   1226: astore #13
    //   1228: aload_2
    //   1229: getfield parent : Lcom/alibaba/fastjson/parser/ParseContext;
    //   1232: astore_2
    //   1233: goto -> 1213
    //   1236: aload #10
    //   1238: astore #13
    //   1240: aload_2
    //   1241: getfield object : Ljava/lang/Object;
    //   1244: ifnull -> 1260
    //   1247: aload #10
    //   1249: astore #13
    //   1251: aload_2
    //   1252: getfield object : Ljava/lang/Object;
    //   1255: astore #10
    //   1257: goto -> 1318
    //   1260: aload #10
    //   1262: astore #13
    //   1264: aload_1
    //   1265: new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1268: dup
    //   1269: aload_2
    //   1270: aload #4
    //   1272: invokespecial <init> : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1275: invokevirtual addResolveTask : (Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1278: aload #10
    //   1280: astore #13
    //   1282: aload_1
    //   1283: iconst_1
    //   1284: putfield resolveStatus : I
    //   1287: goto -> 1318
    //   1290: aload #10
    //   1292: astore #13
    //   1294: aload_1
    //   1295: new com/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask
    //   1298: dup
    //   1299: aload #14
    //   1301: aload #4
    //   1303: invokespecial <init> : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/String;)V
    //   1306: invokevirtual addResolveTask : (Lcom/alibaba/fastjson/parser/DefaultJSONParser$ResolveTask;)V
    //   1309: aload #10
    //   1311: astore #13
    //   1313: aload_1
    //   1314: iconst_1
    //   1315: putfield resolveStatus : I
    //   1318: aload #10
    //   1320: astore #13
    //   1322: aload #21
    //   1324: bipush #13
    //   1326: invokevirtual nextToken : (I)V
    //   1329: aload #10
    //   1331: astore #13
    //   1333: aload #21
    //   1335: invokevirtual token : ()I
    //   1338: bipush #13
    //   1340: if_icmpne -> 1389
    //   1343: aload #10
    //   1345: astore #13
    //   1347: aload #21
    //   1349: bipush #16
    //   1351: invokevirtual nextToken : (I)V
    //   1354: aload #10
    //   1356: astore #13
    //   1358: aload_1
    //   1359: aload #14
    //   1361: aload #10
    //   1363: aload_3
    //   1364: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   1367: pop
    //   1368: aload #11
    //   1370: ifnull -> 1380
    //   1373: aload #11
    //   1375: aload #10
    //   1377: putfield object : Ljava/lang/Object;
    //   1380: aload_1
    //   1381: aload #14
    //   1383: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   1386: aload #10
    //   1388: areturn
    //   1389: aload #10
    //   1391: astore #13
    //   1393: new com/alibaba/fastjson/JSONException
    //   1396: dup
    //   1397: ldc_w 'illegal ref'
    //   1400: invokespecial <init> : (Ljava/lang/String;)V
    //   1403: athrow
    //   1404: aload #10
    //   1406: astore #13
    //   1408: new java/lang/StringBuilder
    //   1411: dup
    //   1412: invokespecial <init> : ()V
    //   1415: astore_2
    //   1416: aload #10
    //   1418: astore #13
    //   1420: aload_2
    //   1421: ldc_w 'illegal ref, '
    //   1424: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1427: pop
    //   1428: aload #10
    //   1430: astore #13
    //   1432: aload_2
    //   1433: iload #5
    //   1435: invokestatic name : (I)Ljava/lang/String;
    //   1438: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1441: pop
    //   1442: aload #10
    //   1444: astore #13
    //   1446: new com/alibaba/fastjson/JSONException
    //   1449: dup
    //   1450: aload_2
    //   1451: invokevirtual toString : ()Ljava/lang/String;
    //   1454: invokespecial <init> : (Ljava/lang/String;)V
    //   1457: athrow
    //   1458: aload #19
    //   1460: astore #18
    //   1462: aload #10
    //   1464: astore #13
    //   1466: getstatic com/alibaba/fastjson/JSON.DEFAULT_TYPE_KEY : Ljava/lang/String;
    //   1469: aload #19
    //   1471: if_acmpne -> 1648
    //   1474: aload #10
    //   1476: astore #13
    //   1478: aload #21
    //   1480: iconst_4
    //   1481: invokevirtual nextTokenWithColon : (I)V
    //   1484: aload #10
    //   1486: astore #13
    //   1488: aload #21
    //   1490: invokevirtual token : ()I
    //   1493: iconst_4
    //   1494: if_icmpne -> 1633
    //   1497: aload #10
    //   1499: astore #13
    //   1501: aload #21
    //   1503: invokevirtual stringVal : ()Ljava/lang/String;
    //   1506: astore #4
    //   1508: aload #10
    //   1510: astore #13
    //   1512: aload #21
    //   1514: bipush #16
    //   1516: invokevirtual nextToken : (I)V
    //   1519: aload #10
    //   1521: astore #13
    //   1523: aload_2
    //   1524: instanceof java/lang/Class
    //   1527: ifeq -> 1575
    //   1530: aload #10
    //   1532: astore #13
    //   1534: aload #4
    //   1536: aload_2
    //   1537: checkcast java/lang/Class
    //   1540: invokevirtual getName : ()Ljava/lang/String;
    //   1543: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1546: ifeq -> 1575
    //   1549: aload #10
    //   1551: astore #13
    //   1553: aload #21
    //   1555: invokevirtual token : ()I
    //   1558: bipush #13
    //   1560: if_icmpne -> 2590
    //   1563: aload #10
    //   1565: astore #13
    //   1567: aload #21
    //   1569: invokevirtual nextToken : ()V
    //   1572: goto -> 2579
    //   1575: aload #10
    //   1577: astore #13
    //   1579: aload #4
    //   1581: aload_1
    //   1582: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   1585: invokevirtual getDefaultClassLoader : ()Ljava/lang/ClassLoader;
    //   1588: invokestatic loadClass : (Ljava/lang/String;Ljava/lang/ClassLoader;)Ljava/lang/Class;
    //   1591: astore_2
    //   1592: aload #10
    //   1594: astore #13
    //   1596: aload_1
    //   1597: invokevirtual getConfig : ()Lcom/alibaba/fastjson/parser/ParserConfig;
    //   1600: aload_2
    //   1601: invokevirtual getDeserializer : (Ljava/lang/reflect/Type;)Lcom/alibaba/fastjson/parser/deserializer/ObjectDeserializer;
    //   1604: aload_1
    //   1605: aload_2
    //   1606: aload_3
    //   1607: invokeinterface deserialze : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;
    //   1612: astore_2
    //   1613: aload #11
    //   1615: ifnull -> 1625
    //   1618: aload #11
    //   1620: aload #10
    //   1622: putfield object : Ljava/lang/Object;
    //   1625: aload_1
    //   1626: aload #14
    //   1628: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   1631: aload_2
    //   1632: areturn
    //   1633: aload #10
    //   1635: astore #13
    //   1637: new com/alibaba/fastjson/JSONException
    //   1640: dup
    //   1641: ldc_w 'syntax error'
    //   1644: invokespecial <init> : (Ljava/lang/String;)V
    //   1647: athrow
    //   1648: aload #4
    //   1650: astore #19
    //   1652: aload #15
    //   1654: astore #20
    //   1656: aload #10
    //   1658: astore #15
    //   1660: aload #11
    //   1662: astore #13
    //   1664: aload #12
    //   1666: astore #4
    //   1668: aload #10
    //   1670: ifnonnull -> 1748
    //   1673: aload #10
    //   1675: astore #15
    //   1677: aload #11
    //   1679: astore #13
    //   1681: aload #12
    //   1683: astore #4
    //   1685: aload #12
    //   1687: ifnonnull -> 1748
    //   1690: aload #10
    //   1692: astore #13
    //   1694: aload_0
    //   1695: aload_1
    //   1696: aload_2
    //   1697: invokevirtual createInstance : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   1700: astore #15
    //   1702: aload #12
    //   1704: astore #4
    //   1706: aload #15
    //   1708: ifnonnull -> 1729
    //   1711: aload #15
    //   1713: astore #13
    //   1715: new java/util/HashMap
    //   1718: dup
    //   1719: aload_0
    //   1720: getfield fieldDeserializers : [Lcom/alibaba/fastjson/parser/deserializer/FieldDeserializer;
    //   1723: arraylength
    //   1724: invokespecial <init> : (I)V
    //   1727: astore #4
    //   1729: aload #15
    //   1731: astore #13
    //   1733: aload_1
    //   1734: aload #14
    //   1736: aload #15
    //   1738: aload_3
    //   1739: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   1742: astore #10
    //   1744: aload #10
    //   1746: astore #13
    //   1748: aload #15
    //   1750: astore #10
    //   1752: aload #13
    //   1754: astore #11
    //   1756: iload #6
    //   1758: ifeq -> 1881
    //   1761: iload #7
    //   1763: ifne -> 1780
    //   1766: aload #17
    //   1768: aload_1
    //   1769: aload #10
    //   1771: aload_2
    //   1772: aload #4
    //   1774: invokevirtual parseField : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/util/Map;)V
    //   1777: goto -> 2603
    //   1780: aload #10
    //   1782: ifnonnull -> 1803
    //   1785: aload #4
    //   1787: aload #16
    //   1789: getfield name : Ljava/lang/String;
    //   1792: aload #19
    //   1794: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1799: pop
    //   1800: goto -> 1869
    //   1803: aload #19
    //   1805: ifnonnull -> 1860
    //   1808: aload #20
    //   1810: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   1813: if_acmpeq -> 1869
    //   1816: aload #20
    //   1818: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   1821: if_acmpeq -> 1869
    //   1824: aload #20
    //   1826: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
    //   1829: if_acmpeq -> 1869
    //   1832: aload #20
    //   1834: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
    //   1837: if_acmpeq -> 1869
    //   1840: aload #20
    //   1842: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   1845: if_acmpeq -> 1869
    //   1848: aload #17
    //   1850: aload #10
    //   1852: aload #19
    //   1854: invokevirtual setValue : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   1857: goto -> 1869
    //   1860: aload #17
    //   1862: aload #10
    //   1864: aload #19
    //   1866: invokevirtual setValue : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   1869: aload #21
    //   1871: getfield matchStat : I
    //   1874: iconst_4
    //   1875: if_icmpne -> 2603
    //   1878: goto -> 1952
    //   1881: aload_0
    //   1882: aload_1
    //   1883: aload #18
    //   1885: aload #10
    //   1887: aload_2
    //   1888: aload #4
    //   1890: invokevirtual parseField : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/reflect/Type;Ljava/util/Map;)Z
    //   1893: ifne -> 1914
    //   1896: aload #21
    //   1898: invokevirtual token : ()I
    //   1901: bipush #13
    //   1903: if_icmpne -> 2606
    //   1906: aload #21
    //   1908: invokevirtual nextToken : ()V
    //   1911: goto -> 1952
    //   1914: iload #5
    //   1916: istore #6
    //   1918: aload #4
    //   1920: astore #12
    //   1922: aload #21
    //   1924: invokevirtual token : ()I
    //   1927: bipush #16
    //   1929: if_icmpne -> 1935
    //   1932: goto -> 2606
    //   1935: aload #21
    //   1937: invokevirtual token : ()I
    //   1940: bipush #13
    //   1942: if_icmpne -> 2403
    //   1945: aload #21
    //   1947: bipush #16
    //   1949: invokevirtual nextToken : (I)V
    //   1952: aload #4
    //   1954: astore #13
    //   1956: aload #11
    //   1958: astore #4
    //   1960: aload #10
    //   1962: astore #12
    //   1964: aload #10
    //   1966: ifnonnull -> 2303
    //   1969: aload #13
    //   1971: ifnonnull -> 2033
    //   1974: aload #10
    //   1976: astore #11
    //   1978: aload_0
    //   1979: aload_1
    //   1980: aload_2
    //   1981: invokevirtual createInstance : (Lcom/alibaba/fastjson/parser/DefaultJSONParser;Ljava/lang/reflect/Type;)Ljava/lang/Object;
    //   1984: astore #10
    //   1986: aload #4
    //   1988: astore_2
    //   1989: aload #4
    //   1991: ifnonnull -> 2014
    //   1994: aload_1
    //   1995: aload #14
    //   1997: aload #10
    //   1999: aload_3
    //   2000: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;Ljava/lang/Object;Ljava/lang/Object;)Lcom/alibaba/fastjson/parser/ParseContext;
    //   2003: astore_2
    //   2004: goto -> 2014
    //   2007: astore_2
    //   2008: aload #10
    //   2010: astore_3
    //   2011: goto -> 131
    //   2014: aload_2
    //   2015: ifnull -> 2024
    //   2018: aload_2
    //   2019: aload #10
    //   2021: putfield object : Ljava/lang/Object;
    //   2024: aload_1
    //   2025: aload #14
    //   2027: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2030: aload #10
    //   2032: areturn
    //   2033: aload #10
    //   2035: astore #11
    //   2037: aload_0
    //   2038: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2041: getfield fields : [Lcom/alibaba/fastjson/util/FieldInfo;
    //   2044: astore_3
    //   2045: aload #10
    //   2047: astore #11
    //   2049: aload_3
    //   2050: arraylength
    //   2051: istore #6
    //   2053: aload #10
    //   2055: astore #11
    //   2057: iload #6
    //   2059: anewarray java/lang/Object
    //   2062: astore_2
    //   2063: iconst_0
    //   2064: istore #5
    //   2066: iload #5
    //   2068: iload #6
    //   2070: if_icmpge -> 2104
    //   2073: aload #10
    //   2075: astore #11
    //   2077: aload_2
    //   2078: iload #5
    //   2080: aload #13
    //   2082: aload_3
    //   2083: iload #5
    //   2085: aaload
    //   2086: getfield name : Ljava/lang/String;
    //   2089: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   2094: aastore
    //   2095: iload #5
    //   2097: iconst_1
    //   2098: iadd
    //   2099: istore #5
    //   2101: goto -> 2066
    //   2104: aload #10
    //   2106: astore #11
    //   2108: aload_0
    //   2109: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2112: getfield creatorConstructor : Ljava/lang/reflect/Constructor;
    //   2115: astore_3
    //   2116: aload_3
    //   2117: ifnull -> 2202
    //   2120: aload #10
    //   2122: astore #11
    //   2124: aload_0
    //   2125: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2128: getfield creatorConstructor : Ljava/lang/reflect/Constructor;
    //   2131: aload_2
    //   2132: invokevirtual newInstance : ([Ljava/lang/Object;)Ljava/lang/Object;
    //   2135: astore_2
    //   2136: aload_2
    //   2137: astore #12
    //   2139: goto -> 2303
    //   2142: astore_2
    //   2143: aload #10
    //   2145: astore #11
    //   2147: new java/lang/StringBuilder
    //   2150: dup
    //   2151: invokespecial <init> : ()V
    //   2154: astore_3
    //   2155: aload #10
    //   2157: astore #11
    //   2159: aload_3
    //   2160: ldc 'create instance error, '
    //   2162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2165: pop
    //   2166: aload #10
    //   2168: astore #11
    //   2170: aload_3
    //   2171: aload_0
    //   2172: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2175: getfield creatorConstructor : Ljava/lang/reflect/Constructor;
    //   2178: invokevirtual toGenericString : ()Ljava/lang/String;
    //   2181: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2184: pop
    //   2185: aload #10
    //   2187: astore #11
    //   2189: new com/alibaba/fastjson/JSONException
    //   2192: dup
    //   2193: aload_3
    //   2194: invokevirtual toString : ()Ljava/lang/String;
    //   2197: aload_2
    //   2198: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2201: athrow
    //   2202: aload #10
    //   2204: astore #11
    //   2206: aload_0
    //   2207: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2210: getfield factoryMethod : Ljava/lang/reflect/Method;
    //   2213: astore_3
    //   2214: aload #10
    //   2216: astore #12
    //   2218: aload_3
    //   2219: ifnull -> 2303
    //   2222: aload #10
    //   2224: astore #11
    //   2226: aload_0
    //   2227: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2230: getfield factoryMethod : Ljava/lang/reflect/Method;
    //   2233: aconst_null
    //   2234: aload_2
    //   2235: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2238: astore_2
    //   2239: goto -> 2136
    //   2242: astore_2
    //   2243: aload #10
    //   2245: astore #11
    //   2247: new java/lang/StringBuilder
    //   2250: dup
    //   2251: invokespecial <init> : ()V
    //   2254: astore_3
    //   2255: aload #10
    //   2257: astore #11
    //   2259: aload_3
    //   2260: ldc_w 'create factory method error, '
    //   2263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2266: pop
    //   2267: aload #10
    //   2269: astore #11
    //   2271: aload_3
    //   2272: aload_0
    //   2273: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2276: getfield factoryMethod : Ljava/lang/reflect/Method;
    //   2279: invokevirtual toString : ()Ljava/lang/String;
    //   2282: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2285: pop
    //   2286: aload #10
    //   2288: astore #11
    //   2290: new com/alibaba/fastjson/JSONException
    //   2293: dup
    //   2294: aload_3
    //   2295: invokevirtual toString : ()Ljava/lang/String;
    //   2298: aload_2
    //   2299: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2302: athrow
    //   2303: aload #12
    //   2305: astore #11
    //   2307: aload_0
    //   2308: getfield beanInfo : Lcom/alibaba/fastjson/util/JavaBeanInfo;
    //   2311: getfield buildMethod : Ljava/lang/reflect/Method;
    //   2314: astore_2
    //   2315: aload_2
    //   2316: ifnonnull -> 2340
    //   2319: aload #4
    //   2321: ifnull -> 2331
    //   2324: aload #4
    //   2326: aload #12
    //   2328: putfield object : Ljava/lang/Object;
    //   2331: aload_1
    //   2332: aload #14
    //   2334: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2337: aload #12
    //   2339: areturn
    //   2340: aload #12
    //   2342: astore #11
    //   2344: aload_2
    //   2345: aload #12
    //   2347: iconst_0
    //   2348: anewarray java/lang/Object
    //   2351: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   2354: astore_2
    //   2355: aload #4
    //   2357: ifnull -> 2367
    //   2360: aload #4
    //   2362: aload #12
    //   2364: putfield object : Ljava/lang/Object;
    //   2367: aload_1
    //   2368: aload #14
    //   2370: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2373: aload_2
    //   2374: areturn
    //   2375: astore_2
    //   2376: aload #12
    //   2378: astore #11
    //   2380: new com/alibaba/fastjson/JSONException
    //   2383: dup
    //   2384: ldc_w 'build object error'
    //   2387: aload_2
    //   2388: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2391: athrow
    //   2392: astore_2
    //   2393: aload #11
    //   2395: astore_3
    //   2396: aload #4
    //   2398: astore #11
    //   2400: goto -> 2495
    //   2403: aload #21
    //   2405: invokevirtual token : ()I
    //   2408: bipush #18
    //   2410: if_icmpeq -> 2433
    //   2413: aload #21
    //   2415: invokevirtual token : ()I
    //   2418: iconst_1
    //   2419: if_icmpeq -> 2433
    //   2422: aload #12
    //   2424: astore #4
    //   2426: iload #6
    //   2428: istore #5
    //   2430: goto -> 2606
    //   2433: new java/lang/StringBuilder
    //   2436: dup
    //   2437: invokespecial <init> : ()V
    //   2440: astore_2
    //   2441: aload_2
    //   2442: ldc_w 'syntax error, unexpect token '
    //   2445: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2448: pop
    //   2449: aload_2
    //   2450: aload #21
    //   2452: invokevirtual token : ()I
    //   2455: invokestatic name : (I)Ljava/lang/String;
    //   2458: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2461: pop
    //   2462: new com/alibaba/fastjson/JSONException
    //   2465: dup
    //   2466: aload_2
    //   2467: invokevirtual toString : ()Ljava/lang/String;
    //   2470: invokespecial <init> : (Ljava/lang/String;)V
    //   2473: athrow
    //   2474: astore_2
    //   2475: aload #10
    //   2477: astore_3
    //   2478: goto -> 2495
    //   2481: astore_2
    //   2482: aload #13
    //   2484: astore_3
    //   2485: goto -> 2495
    //   2488: astore_2
    //   2489: aconst_null
    //   2490: astore #11
    //   2492: aload #4
    //   2494: astore_3
    //   2495: aload #11
    //   2497: ifnull -> 2506
    //   2500: aload #11
    //   2502: aload_3
    //   2503: putfield object : Ljava/lang/Object;
    //   2506: aload_1
    //   2507: aload #14
    //   2509: invokevirtual setContext : (Lcom/alibaba/fastjson/parser/ParseContext;)V
    //   2512: aload_2
    //   2513: athrow
    //   2514: aload_1
    //   2515: invokevirtual parse : ()Ljava/lang/Object;
    //   2518: areturn
    //   2519: iconst_0
    //   2520: istore #5
    //   2522: goto -> 176
    //   2525: iconst_1
    //   2526: istore #5
    //   2528: goto -> 176
    //   2531: aconst_null
    //   2532: astore #15
    //   2534: aconst_null
    //   2535: astore #16
    //   2537: aconst_null
    //   2538: astore #17
    //   2540: goto -> 423
    //   2543: iconst_1
    //   2544: istore #6
    //   2546: iconst_1
    //   2547: istore #7
    //   2549: goto -> 959
    //   2552: goto -> 2590
    //   2555: iconst_0
    //   2556: istore #6
    //   2558: iconst_0
    //   2559: istore #7
    //   2561: goto -> 959
    //   2564: iconst_0
    //   2565: istore #6
    //   2567: iconst_0
    //   2568: istore #7
    //   2570: aconst_null
    //   2571: astore #4
    //   2573: goto -> 959
    //   2576: goto -> 1041
    //   2579: aload #11
    //   2581: astore #4
    //   2583: aload #12
    //   2585: astore #13
    //   2587: goto -> 1960
    //   2590: aload #12
    //   2592: astore #4
    //   2594: goto -> 2606
    //   2597: aconst_null
    //   2598: astore #18
    //   2600: goto -> 1648
    //   2603: goto -> 1914
    //   2606: iload #5
    //   2608: iconst_1
    //   2609: iadd
    //   2610: istore #5
    //   2612: aload #4
    //   2614: astore #12
    //   2616: goto -> 371
    // Exception table:
    //   from	to	target	type
    //   89	96	123	finally
    //   101	108	123	finally
    //   145	173	123	finally
    //   181	191	123	finally
    //   213	220	123	finally
    //   239	255	123	finally
    //   263	328	123	finally
    //   328	340	123	finally
    //   340	346	2488	finally
    //   352	357	123	finally
    //   375	385	2481	finally
    //   389	398	2481	finally
    //   402	409	2481	finally
    //   413	420	2481	finally
    //   432	439	2481	finally
    //   443	451	2481	finally
    //   466	474	2481	finally
    //   496	505	2481	finally
    //   509	517	2481	finally
    //   524	534	2481	finally
    //   541	549	2481	finally
    //   564	572	2481	finally
    //   587	595	2481	finally
    //   610	618	2481	finally
    //   622	637	2481	finally
    //   641	654	2481	finally
    //   658	666	2481	finally
    //   670	679	2481	finally
    //   686	696	2481	finally
    //   703	713	2481	finally
    //   723	735	2481	finally
    //   739	747	2481	finally
    //   754	764	2481	finally
    //   771	783	2481	finally
    //   787	795	2481	finally
    //   802	812	2481	finally
    //   819	831	2481	finally
    //   835	843	2481	finally
    //   850	860	2481	finally
    //   867	879	2481	finally
    //   883	891	2481	finally
    //   898	908	2481	finally
    //   915	927	2481	finally
    //   931	939	2481	finally
    //   946	956	2481	finally
    //   968	979	2481	finally
    //   988	995	2481	finally
    //   1006	1013	2481	finally
    //   1027	1038	2481	finally
    //   1053	1059	2481	finally
    //   1063	1070	2481	finally
    //   1080	1087	2481	finally
    //   1091	1102	2481	finally
    //   1106	1113	2481	finally
    //   1120	1131	2481	finally
    //   1135	1141	2481	finally
    //   1145	1152	2481	finally
    //   1156	1162	2481	finally
    //   1169	1183	2481	finally
    //   1187	1192	2481	finally
    //   1199	1210	2481	finally
    //   1217	1224	2481	finally
    //   1228	1233	2481	finally
    //   1240	1247	2481	finally
    //   1251	1257	2481	finally
    //   1264	1278	2481	finally
    //   1282	1287	2481	finally
    //   1294	1309	2481	finally
    //   1313	1318	2481	finally
    //   1322	1329	2481	finally
    //   1333	1343	2481	finally
    //   1347	1354	2481	finally
    //   1358	1368	2481	finally
    //   1393	1404	2481	finally
    //   1408	1416	2481	finally
    //   1420	1428	2481	finally
    //   1432	1442	2481	finally
    //   1446	1458	2481	finally
    //   1466	1474	2481	finally
    //   1478	1484	2481	finally
    //   1488	1497	2481	finally
    //   1501	1508	2481	finally
    //   1512	1519	2481	finally
    //   1523	1530	2481	finally
    //   1534	1549	2481	finally
    //   1553	1563	2481	finally
    //   1567	1572	2481	finally
    //   1579	1592	2481	finally
    //   1596	1613	2481	finally
    //   1637	1648	2481	finally
    //   1694	1702	2481	finally
    //   1715	1729	2481	finally
    //   1733	1744	2481	finally
    //   1766	1777	2474	finally
    //   1785	1800	2474	finally
    //   1808	1857	2474	finally
    //   1860	1869	2474	finally
    //   1869	1878	2474	finally
    //   1881	1911	2474	finally
    //   1922	1932	2474	finally
    //   1935	1952	2474	finally
    //   1978	1986	2392	finally
    //   1994	2004	2007	finally
    //   2037	2045	2392	finally
    //   2049	2053	2392	finally
    //   2057	2063	2392	finally
    //   2077	2095	2392	finally
    //   2108	2116	2392	finally
    //   2124	2136	2142	java/lang/Exception
    //   2124	2136	2392	finally
    //   2147	2155	2392	finally
    //   2159	2166	2392	finally
    //   2170	2185	2392	finally
    //   2189	2202	2392	finally
    //   2206	2214	2392	finally
    //   2226	2239	2242	java/lang/Exception
    //   2226	2239	2392	finally
    //   2247	2255	2392	finally
    //   2259	2267	2392	finally
    //   2271	2286	2392	finally
    //   2290	2303	2392	finally
    //   2307	2315	2392	finally
    //   2344	2355	2375	java/lang/Exception
    //   2344	2355	2392	finally
    //   2380	2392	2392	finally
    //   2403	2422	2474	finally
    //   2433	2474	2474	finally
  }
  
  public <T> T deserialzeArrayMapping(DefaultJSONParser paramDefaultJSONParser, Type paramType, Object paramObject1, Object paramObject2) {
    paramObject1 = paramDefaultJSONParser.lexer;
    if (paramObject1.token() == 14) {
      Object object = createInstance(paramDefaultJSONParser, paramType);
      int i = 0;
      int j = this.sortedFieldDeserializers.length;
      while (i < j) {
        byte b;
        if (i == j - 1) {
          b = 93;
        } else {
          b = 44;
        } 
        paramObject2 = this.sortedFieldDeserializers[i];
        Class<int> clazz = ((FieldDeserializer)paramObject2).fieldInfo.fieldClass;
        if (clazz == int.class) {
          paramObject2.setValue(object, paramObject1.scanInt(b));
        } else if (clazz == String.class) {
          paramObject2.setValue(object, paramObject1.scanString(b));
        } else if (clazz == long.class) {
          paramObject2.setValue(object, paramObject1.scanLong(b));
        } else if (clazz.isEnum()) {
          paramObject2.setValue(object, paramObject1.scanEnum(clazz, paramDefaultJSONParser.getSymbolTable(), b));
        } else {
          paramObject1.nextToken(14);
          paramObject2.setValue(object, paramDefaultJSONParser.parseObject(((FieldDeserializer)paramObject2).fieldInfo.fieldType));
          if (b == 93) {
            if (paramObject1.token() == 15) {
              paramObject1.nextToken(16);
            } else {
              throw new JSONException("syntax error");
            } 
          } else if (b == 44 && paramObject1.token() != 16) {
            throw new JSONException("syntax error");
          } 
        } 
        i++;
      } 
      paramObject1.nextToken(16);
      return (T)object;
    } 
    throw new JSONException("error");
  }
  
  public int getFastMatchToken() {
    return 12;
  }
  
  public FieldDeserializer getFieldDeserializer(String paramString) {
    if (paramString == null)
      return null; 
    int j = 0;
    int i = this.sortedFieldDeserializers.length - 1;
    while (j <= i) {
      int k = j + i >>> 1;
      int m = (this.sortedFieldDeserializers[k]).fieldInfo.name.compareTo(paramString);
      if (m < 0) {
        j = k + 1;
        continue;
      } 
      if (m > 0) {
        i = k - 1;
        continue;
      } 
      return this.sortedFieldDeserializers[k];
    } 
    return null;
  }
  
  public final boolean isSupportArrayToBean(JSONLexer paramJSONLexer) {
    return (Feature.isEnabled(this.beanInfo.parserFeatures, Feature.SupportArrayToBean) || paramJSONLexer.isEnabled(Feature.SupportArrayToBean));
  }
  
  public boolean parseField(DefaultJSONParser paramDefaultJSONParser, String paramString, Object paramObject, Type paramType, Map<String, Object> paramMap) {
    StringBuilder stringBuilder;
    JSONLexer jSONLexer = paramDefaultJSONParser.lexer;
    FieldDeserializer fieldDeserializer = smartMatch(paramString);
    if (fieldDeserializer == null) {
      if (jSONLexer.isEnabled(Feature.IgnoreNotMatch)) {
        paramDefaultJSONParser.parseExtra(paramObject, paramString);
        return false;
      } 
      stringBuilder = new StringBuilder();
      stringBuilder.append("setter not found, class ");
      stringBuilder.append(this.clazz.getName());
      stringBuilder.append(", property ");
      stringBuilder.append(paramString);
      throw new JSONException(stringBuilder.toString());
    } 
    jSONLexer.nextTokenWithColon(fieldDeserializer.getFastMatchToken());
    fieldDeserializer.parseField((DefaultJSONParser)stringBuilder, paramObject, paramType, paramMap);
    return true;
  }
  
  public FieldDeserializer smartMatch(String paramString) {
    if (paramString == null)
      return null; 
    FieldDeserializer fieldDeserializer2 = getFieldDeserializer(paramString);
    byte b = 0;
    FieldDeserializer fieldDeserializer1 = fieldDeserializer2;
    if (fieldDeserializer2 == null) {
      boolean bool = paramString.startsWith("is");
      FieldDeserializer[] arrayOfFieldDeserializer = this.sortedFieldDeserializers;
      int j = arrayOfFieldDeserializer.length;
      int i = 0;
      while (true) {
        fieldDeserializer1 = fieldDeserializer2;
        if (i < j) {
          fieldDeserializer1 = arrayOfFieldDeserializer[i];
          FieldInfo fieldInfo = fieldDeserializer1.fieldInfo;
          Class<boolean> clazz = fieldInfo.fieldClass;
          String str = fieldInfo.name;
          if (str.equalsIgnoreCase(paramString) || (bool && (clazz == boolean.class || clazz == Boolean.class) && str.equalsIgnoreCase(paramString.substring(2))))
            break; 
          i++;
          continue;
        } 
        break;
      } 
    } 
    fieldDeserializer2 = fieldDeserializer1;
    if (fieldDeserializer1 == null) {
      fieldDeserializer2 = fieldDeserializer1;
      if (paramString.indexOf('_') != -1) {
        String str = paramString.replaceAll("_", "");
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str);
        fieldDeserializer2 = fieldDeserializer;
        if (fieldDeserializer == null) {
          FieldDeserializer[] arrayOfFieldDeserializer = this.sortedFieldDeserializers;
          int j = arrayOfFieldDeserializer.length;
          int i = b;
          while (true) {
            fieldDeserializer2 = fieldDeserializer;
            if (i < j) {
              fieldDeserializer2 = arrayOfFieldDeserializer[i];
              if (fieldDeserializer2.fieldInfo.name.equalsIgnoreCase(str))
                return fieldDeserializer2; 
              i++;
              continue;
            } 
            break;
          } 
        } 
      } 
    } 
    return fieldDeserializer2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\deserializer\JavaBeanDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */