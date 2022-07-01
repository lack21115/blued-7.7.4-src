package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JavaBeanSerializer implements ObjectSerializer {
  private static final char[] false_chars;
  
  private static final char[] true_chars = new char[] { 't', 'r', 'u', 'e' };
  
  protected final Class<?> beanType;
  
  protected int features;
  
  private final FieldSerializer[] getters;
  
  protected final FieldSerializer[] sortedGetters;
  
  static {
    false_chars = new char[] { 'f', 'a', 'l', 's', 'e' };
  }
  
  public JavaBeanSerializer(Class<?> paramClass) {
    this(paramClass, (Map<String, String>)null);
  }
  
  public JavaBeanSerializer(Class<?> paramClass, Map<String, String> paramMap) {
    this(paramClass, paramMap, TypeUtils.getSerializeFeatures(paramClass));
  }
  
  public JavaBeanSerializer(Class<?> paramClass, Map<String, String> paramMap, int paramInt) {
    String[] arrayOfString;
    this.features = 0;
    this.features = paramInt;
    this.beanType = paramClass;
    JSONType jSONType = paramClass.<JSONType>getAnnotation(JSONType.class);
    if (jSONType != null)
      SerializerFeature.of(jSONType.serialzeFeatures()); 
    ArrayList<FieldSerializer> arrayList = new ArrayList();
    Iterator<FieldInfo> iterator = TypeUtils.computeGetters(paramClass, jSONType, paramMap, false).iterator();
    while (iterator.hasNext())
      arrayList.add(new FieldSerializer(paramClass, iterator.next())); 
    this.getters = arrayList.<FieldSerializer>toArray(new FieldSerializer[arrayList.size()]);
    arrayList = null;
    if (jSONType != null)
      arrayOfString = jSONType.orders(); 
    if (arrayOfString != null && arrayOfString.length != 0) {
      List list = TypeUtils.computeGetters(paramClass, jSONType, paramMap, true);
      ArrayList<FieldSerializer> arrayList1 = new ArrayList();
      Iterator<FieldInfo> iterator1 = list.iterator();
      while (iterator1.hasNext())
        arrayList1.add(new FieldSerializer(paramClass, iterator1.next())); 
      this.sortedGetters = arrayList1.<FieldSerializer>toArray(new FieldSerializer[arrayList1.size()]);
      return;
    } 
    FieldSerializer[] arrayOfFieldSerializer1 = this.getters;
    FieldSerializer[] arrayOfFieldSerializer2 = new FieldSerializer[arrayOfFieldSerializer1.length];
    System.arraycopy(arrayOfFieldSerializer1, 0, arrayOfFieldSerializer2, 0, arrayOfFieldSerializer1.length);
    Arrays.sort((Object[])arrayOfFieldSerializer2);
    if (Arrays.equals((Object[])arrayOfFieldSerializer2, (Object[])this.getters)) {
      this.sortedGetters = this.getters;
      return;
    } 
    this.sortedGetters = arrayOfFieldSerializer2;
  }
  
  public JavaBeanSerializer(Class<?> paramClass, String... paramVarArgs) {
    this(paramClass, createAliasMap(paramVarArgs));
  }
  
  static Map<String, String> createAliasMap(String... paramVarArgs) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int j = paramVarArgs.length;
    for (int i = 0; i < j; i++) {
      String str = paramVarArgs[i];
      hashMap.put(str, str);
    } 
    return (Map)hashMap;
  }
  
  public FieldSerializer getFieldSerializer(String paramString) {
    if (paramString == null)
      return null; 
    int j = 0;
    int i = this.sortedGetters.length - 1;
    while (j <= i) {
      int k = j + i >>> 1;
      int m = (this.sortedGetters[k]).fieldInfo.name.compareTo(paramString);
      if (m < 0) {
        j = k + 1;
        continue;
      } 
      if (m > 0) {
        i = k - 1;
        continue;
      } 
      return this.sortedGetters[k];
    } 
    return null;
  }
  
  public List<Object> getFieldValues(Object paramObject) throws Exception {
    ArrayList<Object> arrayList = new ArrayList(this.sortedGetters.length);
    FieldSerializer[] arrayOfFieldSerializer = this.sortedGetters;
    int j = arrayOfFieldSerializer.length;
    for (int i = 0; i < j; i++)
      arrayList.add(arrayOfFieldSerializer[i].getPropertyValue(paramObject)); 
    return arrayList;
  }
  
  public boolean isWriteAsArray(JSONSerializer paramJSONSerializer) {
    return ((this.features & SerializerFeature.BeanToArray.mask) != 0 || paramJSONSerializer.out.beanToArray);
  }
  
  public void write(JSONSerializer paramJSONSerializer, Object paramObject1, Object paramObject2, Type paramType, int paramInt) throws IOException {
    // Byte code:
    //   0: aload_1
    //   1: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   4: astore #33
    //   6: aload_2
    //   7: ifnonnull -> 16
    //   10: aload #33
    //   12: invokevirtual writeNull : ()V
    //   15: return
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: iload #5
    //   21: invokevirtual writeReference : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;I)Z
    //   24: ifeq -> 28
    //   27: return
    //   28: aload #33
    //   30: getfield sortField : Z
    //   33: ifeq -> 45
    //   36: aload_0
    //   37: getfield sortedGetters : [Lcom/alibaba/fastjson/serializer/FieldSerializer;
    //   40: astore #20
    //   42: goto -> 51
    //   45: aload_0
    //   46: getfield getters : [Lcom/alibaba/fastjson/serializer/FieldSerializer;
    //   49: astore #20
    //   51: aload_1
    //   52: getfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   55: astore #32
    //   57: aload_1
    //   58: aload #32
    //   60: aload_2
    //   61: aload_3
    //   62: aload_0
    //   63: getfield features : I
    //   66: iload #5
    //   68: invokevirtual setContext : (Lcom/alibaba/fastjson/serializer/SerialContext;Ljava/lang/Object;Ljava/lang/Object;II)V
    //   71: aload_0
    //   72: aload_1
    //   73: invokevirtual isWriteAsArray : (Lcom/alibaba/fastjson/serializer/JSONSerializer;)Z
    //   76: istore #17
    //   78: iload #17
    //   80: ifeq -> 90
    //   83: bipush #91
    //   85: istore #7
    //   87: goto -> 94
    //   90: bipush #123
    //   92: istore #7
    //   94: iload #17
    //   96: ifeq -> 106
    //   99: bipush #93
    //   101: istore #6
    //   103: goto -> 110
    //   106: bipush #125
    //   108: istore #6
    //   110: aload #33
    //   112: iload #7
    //   114: invokevirtual append : (C)Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   117: pop
    //   118: aload #20
    //   120: arraylength
    //   121: ifle -> 140
    //   124: aload #33
    //   126: getfield prettyFormat : Z
    //   129: ifeq -> 140
    //   132: aload_1
    //   133: invokevirtual incrementIndent : ()V
    //   136: aload_1
    //   137: invokevirtual println : ()V
    //   140: aload_0
    //   141: getfield features : I
    //   144: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteClassName : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   147: getfield mask : I
    //   150: iand
    //   151: ifne -> 164
    //   154: aload_1
    //   155: aload #4
    //   157: aload_2
    //   158: invokevirtual isWriteClassName : (Ljava/lang/reflect/Type;Ljava/lang/Object;)Z
    //   161: ifeq -> 2057
    //   164: aload_2
    //   165: invokevirtual getClass : ()Ljava/lang/Class;
    //   168: aload #4
    //   170: if_acmpeq -> 2057
    //   173: aload #33
    //   175: getstatic com/alibaba/fastjson/JSON.DEFAULT_TYPE_KEY : Ljava/lang/String;
    //   178: iconst_0
    //   179: invokevirtual writeFieldName : (Ljava/lang/String;Z)V
    //   182: aload_1
    //   183: aload_2
    //   184: invokevirtual getClass : ()Ljava/lang/Class;
    //   187: invokevirtual write : (Ljava/lang/Object;)V
    //   190: iconst_1
    //   191: istore #5
    //   193: goto -> 2060
    //   196: aload #33
    //   198: getfield quoteFieldNames : Z
    //   201: ifeq -> 2078
    //   204: aload #33
    //   206: getfield useSingleQuotes : Z
    //   209: ifne -> 2078
    //   212: iconst_1
    //   213: istore #5
    //   215: goto -> 218
    //   218: aload_1
    //   219: aload_2
    //   220: iload #7
    //   222: invokevirtual writeBefore : (Ljava/lang/Object;C)C
    //   225: bipush #44
    //   227: if_icmpne -> 2084
    //   230: iconst_1
    //   231: istore #8
    //   233: goto -> 236
    //   236: aload #33
    //   238: getfield skipTransientField : Z
    //   241: istore #16
    //   243: aload #33
    //   245: getfield ignoreNonFieldGetter : Z
    //   248: istore #15
    //   250: aload_1
    //   251: getfield labelFilters : Ljava/util/List;
    //   254: astore #26
    //   256: aload_1
    //   257: getfield propertyFilters : Ljava/util/List;
    //   260: astore #22
    //   262: aload_1
    //   263: getfield nameFilters : Ljava/util/List;
    //   266: astore #28
    //   268: aload_1
    //   269: getfield valueFilters : Ljava/util/List;
    //   272: astore #27
    //   274: aload_1
    //   275: getfield contextValueFilters : Ljava/util/List;
    //   278: astore #4
    //   280: aload_1
    //   281: getfield propertyPreFilters : Ljava/util/List;
    //   284: astore #21
    //   286: iconst_0
    //   287: istore #10
    //   289: iload #8
    //   291: istore #11
    //   293: aload #20
    //   295: astore #29
    //   297: iload #5
    //   299: istore #9
    //   301: aload #22
    //   303: astore #20
    //   305: iload #10
    //   307: aload #29
    //   309: arraylength
    //   310: if_icmpge -> 2317
    //   313: aload #29
    //   315: iload #10
    //   317: aaload
    //   318: astore #34
    //   320: aload #34
    //   322: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   325: getfield field : Ljava/lang/reflect/Field;
    //   328: astore #22
    //   330: aload #34
    //   332: getfield fieldInfo : Lcom/alibaba/fastjson/util/FieldInfo;
    //   335: astore #35
    //   337: aload #35
    //   339: getfield name : Ljava/lang/String;
    //   342: astore #30
    //   344: aload #35
    //   346: getfield fieldClass : Ljava/lang/Class;
    //   349: astore #36
    //   351: iload #16
    //   353: ifeq -> 2090
    //   356: aload #22
    //   358: ifnull -> 2090
    //   361: aload #35
    //   363: getfield fieldTransient : Z
    //   366: ifeq -> 2090
    //   369: goto -> 2100
    //   372: aload #21
    //   374: astore #22
    //   376: aload #21
    //   378: ifnull -> 2106
    //   381: aload #21
    //   383: invokeinterface iterator : ()Ljava/util/Iterator;
    //   388: astore #23
    //   390: aload #21
    //   392: astore #22
    //   394: aload #23
    //   396: invokeinterface hasNext : ()Z
    //   401: ifeq -> 2106
    //   404: aload #23
    //   406: invokeinterface next : ()Ljava/lang/Object;
    //   411: checkcast com/alibaba/fastjson/serializer/PropertyPreFilter
    //   414: astore #22
    //   416: aload #22
    //   418: aload_1
    //   419: aload_2
    //   420: aload #35
    //   422: getfield name : Ljava/lang/String;
    //   425: invokeinterface apply : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;Ljava/lang/String;)Z
    //   430: ifne -> 2103
    //   433: iconst_0
    //   434: istore #5
    //   436: goto -> 2113
    //   439: aload #26
    //   441: ifnull -> 2121
    //   444: aload #26
    //   446: invokeinterface iterator : ()Ljava/util/Iterator;
    //   451: astore #22
    //   453: aload #22
    //   455: invokeinterface hasNext : ()Z
    //   460: ifeq -> 2121
    //   463: aload #22
    //   465: invokeinterface next : ()Ljava/lang/Object;
    //   470: checkcast com/alibaba/fastjson/serializer/LabelFilter
    //   473: aload #35
    //   475: getfield label : Ljava/lang/String;
    //   478: invokeinterface apply : (Ljava/lang/String;)Z
    //   483: ifne -> 453
    //   486: iconst_0
    //   487: istore #5
    //   489: goto -> 2124
    //   492: aload #35
    //   494: getfield fieldAccess : Z
    //   497: ifeq -> 592
    //   500: aload #36
    //   502: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   505: if_acmpne -> 525
    //   508: aload #35
    //   510: getfield field : Ljava/lang/reflect/Field;
    //   513: aload_2
    //   514: invokevirtual getInt : (Ljava/lang/Object;)I
    //   517: istore #5
    //   519: lconst_0
    //   520: lstore #18
    //   522: goto -> 2132
    //   525: aload #36
    //   527: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   530: if_acmpne -> 550
    //   533: aload #35
    //   535: getfield field : Ljava/lang/reflect/Field;
    //   538: aload_2
    //   539: invokevirtual getLong : (Ljava/lang/Object;)J
    //   542: lstore #18
    //   544: iconst_0
    //   545: istore #5
    //   547: goto -> 2132
    //   550: aload #36
    //   552: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   555: if_acmpne -> 578
    //   558: aload #35
    //   560: getfield field : Ljava/lang/reflect/Field;
    //   563: aload_2
    //   564: invokevirtual getBoolean : (Ljava/lang/Object;)Z
    //   567: istore #14
    //   569: lconst_0
    //   570: lstore #18
    //   572: iconst_0
    //   573: istore #5
    //   575: goto -> 2135
    //   578: aload #35
    //   580: getfield field : Ljava/lang/reflect/Field;
    //   583: aload_2
    //   584: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   587: astore #22
    //   589: goto -> 2155
    //   592: aload #34
    //   594: aload_2
    //   595: invokevirtual getPropertyValue : (Ljava/lang/Object;)Ljava/lang/Object;
    //   598: astore #22
    //   600: goto -> 2155
    //   603: aload #20
    //   605: ifnull -> 2188
    //   608: iload #12
    //   610: ifeq -> 2179
    //   613: aload #36
    //   615: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   618: if_acmpne -> 631
    //   621: iload #13
    //   623: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   626: astore #22
    //   628: goto -> 2173
    //   631: aload #36
    //   633: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   636: if_acmpne -> 649
    //   639: lload #18
    //   641: invokestatic valueOf : (J)Ljava/lang/Long;
    //   644: astore #22
    //   646: goto -> 2173
    //   649: aload #36
    //   651: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   654: if_acmpne -> 2179
    //   657: iload #14
    //   659: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   662: astore #22
    //   664: goto -> 2173
    //   667: aload #20
    //   669: invokeinterface iterator : ()Ljava/util/Iterator;
    //   674: astore #23
    //   676: aload #23
    //   678: invokeinterface hasNext : ()Z
    //   683: ifeq -> 2185
    //   686: aload #23
    //   688: invokeinterface next : ()Ljava/lang/Object;
    //   693: astore #24
    //   695: aload #24
    //   697: checkcast com/alibaba/fastjson/serializer/PropertyFilter
    //   700: aload_2
    //   701: aload #30
    //   703: aload #22
    //   705: invokeinterface apply : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Z
    //   710: ifne -> 2182
    //   713: iconst_0
    //   714: istore #8
    //   716: goto -> 2191
    //   719: aload #28
    //   721: ifnull -> 2215
    //   724: iload #12
    //   726: ifeq -> 2205
    //   729: iload #5
    //   731: ifne -> 2205
    //   734: aload #36
    //   736: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   739: if_acmpne -> 752
    //   742: iload #13
    //   744: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   747: astore #22
    //   749: goto -> 2199
    //   752: aload #36
    //   754: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   757: if_acmpne -> 770
    //   760: lload #18
    //   762: invokestatic valueOf : (J)Ljava/lang/Long;
    //   765: astore #22
    //   767: goto -> 2199
    //   770: aload #36
    //   772: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   775: if_acmpne -> 2205
    //   778: iload #14
    //   780: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   783: astore #22
    //   785: goto -> 2199
    //   788: aload #28
    //   790: invokeinterface iterator : ()Ljava/util/Iterator;
    //   795: astore #24
    //   797: aload #30
    //   799: astore #23
    //   801: aload #24
    //   803: invokeinterface hasNext : ()Z
    //   808: ifeq -> 2208
    //   811: aload #24
    //   813: invokeinterface next : ()Ljava/lang/Object;
    //   818: checkcast com/alibaba/fastjson/serializer/NameFilter
    //   821: aload_2
    //   822: aload #23
    //   824: aload #22
    //   826: invokeinterface process : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   831: astore #23
    //   833: goto -> 801
    //   836: aload #22
    //   838: astore #23
    //   840: aload #33
    //   842: getfield writeNonStringValueAsString : Z
    //   845: ifeq -> 2239
    //   848: aload #36
    //   850: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   853: if_acmpne -> 866
    //   856: iload #13
    //   858: invokestatic toString : (I)Ljava/lang/String;
    //   861: astore #22
    //   863: goto -> 2222
    //   866: aload #36
    //   868: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   871: if_acmpne -> 884
    //   874: lload #18
    //   876: invokestatic toString : (J)Ljava/lang/String;
    //   879: astore #22
    //   881: goto -> 2222
    //   884: aload #36
    //   886: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   889: if_acmpne -> 2228
    //   892: iload #14
    //   894: invokestatic toString : (Z)Ljava/lang/String;
    //   897: astore #22
    //   899: goto -> 2222
    //   902: aload #22
    //   904: instanceof java/lang/Number
    //   907: ifne -> 922
    //   910: aload #22
    //   912: astore #23
    //   914: aload #22
    //   916: instanceof java/lang/Boolean
    //   919: ifeq -> 2239
    //   922: aload #22
    //   924: invokevirtual toString : ()Ljava/lang/String;
    //   927: astore #23
    //   929: goto -> 2239
    //   932: aload #27
    //   934: ifnull -> 2258
    //   937: iload #12
    //   939: ifeq -> 2252
    //   942: iload #5
    //   944: ifne -> 2252
    //   947: aload #36
    //   949: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   952: if_acmpne -> 965
    //   955: iload #13
    //   957: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   960: astore #22
    //   962: goto -> 2246
    //   965: aload #36
    //   967: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   970: if_acmpne -> 983
    //   973: lload #18
    //   975: invokestatic valueOf : (J)Ljava/lang/Long;
    //   978: astore #22
    //   980: goto -> 2246
    //   983: aload #36
    //   985: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   988: if_acmpne -> 2252
    //   991: iload #14
    //   993: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   996: astore #22
    //   998: goto -> 2246
    //   1001: aload #27
    //   1003: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1008: astore #25
    //   1010: aload #22
    //   1012: astore #24
    //   1014: aload #22
    //   1016: astore #23
    //   1018: aload #24
    //   1020: astore #22
    //   1022: aload #25
    //   1024: invokeinterface hasNext : ()Z
    //   1029: ifeq -> 2255
    //   1032: aload #25
    //   1034: invokeinterface next : ()Ljava/lang/Object;
    //   1039: checkcast com/alibaba/fastjson/serializer/ValueFilter
    //   1042: aload_2
    //   1043: aload #30
    //   1045: aload #22
    //   1047: invokeinterface process : (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1052: astore #22
    //   1054: goto -> 1022
    //   1057: aload #4
    //   1059: ifnull -> 2290
    //   1062: iload #5
    //   1064: istore #8
    //   1066: aload #22
    //   1068: astore #25
    //   1070: aload #23
    //   1072: astore #24
    //   1074: iload #12
    //   1076: ifeq -> 1162
    //   1079: iload #5
    //   1081: istore #8
    //   1083: aload #22
    //   1085: astore #25
    //   1087: aload #23
    //   1089: astore #24
    //   1091: iload #5
    //   1093: ifne -> 1162
    //   1096: aload #36
    //   1098: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   1101: if_acmpne -> 1114
    //   1104: iload #13
    //   1106: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1109: astore #22
    //   1111: goto -> 2265
    //   1114: aload #36
    //   1116: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   1119: if_acmpne -> 1132
    //   1122: lload #18
    //   1124: invokestatic valueOf : (J)Ljava/lang/Long;
    //   1127: astore #22
    //   1129: goto -> 2265
    //   1132: iload #5
    //   1134: istore #8
    //   1136: aload #22
    //   1138: astore #25
    //   1140: aload #23
    //   1142: astore #24
    //   1144: aload #36
    //   1146: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   1149: if_acmpne -> 1162
    //   1152: iload #14
    //   1154: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   1157: astore #22
    //   1159: goto -> 2265
    //   1162: aload #4
    //   1164: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1169: astore #23
    //   1171: aload #25
    //   1173: astore #22
    //   1175: aload #23
    //   1177: invokeinterface hasNext : ()Z
    //   1182: ifeq -> 2279
    //   1185: aload #23
    //   1187: invokeinterface next : ()Ljava/lang/Object;
    //   1192: checkcast com/alibaba/fastjson/serializer/ContextValueFilter
    //   1195: aload #34
    //   1197: getfield fieldContext : Lcom/alibaba/fastjson/serializer/BeanContext;
    //   1200: aload_2
    //   1201: aload #30
    //   1203: aload #22
    //   1205: invokeinterface process : (Lcom/alibaba/fastjson/serializer/BeanContext;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1210: astore #22
    //   1212: goto -> 1175
    //   1215: iload #5
    //   1217: ifeq -> 1249
    //   1220: aload #22
    //   1222: ifnonnull -> 1249
    //   1225: iload #17
    //   1227: ifne -> 1249
    //   1230: aload #34
    //   1232: getfield writeNull : Z
    //   1235: ifne -> 1249
    //   1238: aload #33
    //   1240: getfield writeMapNullValue : Z
    //   1243: ifne -> 1249
    //   1246: goto -> 2100
    //   1249: aload #22
    //   1251: ifnull -> 2296
    //   1254: aload #33
    //   1256: getfield notWriteDefaultValue : Z
    //   1259: ifeq -> 2296
    //   1262: aload #35
    //   1264: getfield fieldClass : Ljava/lang/Class;
    //   1267: astore #24
    //   1269: aload #24
    //   1271: getstatic java/lang/Byte.TYPE : Ljava/lang/Class;
    //   1274: if_acmpne -> 1299
    //   1277: aload #22
    //   1279: instanceof java/lang/Byte
    //   1282: ifeq -> 1299
    //   1285: aload #22
    //   1287: checkcast java/lang/Byte
    //   1290: invokevirtual byteValue : ()B
    //   1293: ifne -> 1299
    //   1296: goto -> 2293
    //   1299: aload #24
    //   1301: getstatic java/lang/Short.TYPE : Ljava/lang/Class;
    //   1304: if_acmpne -> 1329
    //   1307: aload #22
    //   1309: instanceof java/lang/Short
    //   1312: ifeq -> 1329
    //   1315: aload #22
    //   1317: checkcast java/lang/Short
    //   1320: invokevirtual shortValue : ()S
    //   1323: ifne -> 1329
    //   1326: goto -> 2293
    //   1329: aload #24
    //   1331: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   1334: if_acmpne -> 1359
    //   1337: aload #22
    //   1339: instanceof java/lang/Integer
    //   1342: ifeq -> 1359
    //   1345: aload #22
    //   1347: checkcast java/lang/Integer
    //   1350: invokevirtual intValue : ()I
    //   1353: ifne -> 1359
    //   1356: goto -> 2293
    //   1359: aload #24
    //   1361: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   1364: if_acmpne -> 1391
    //   1367: aload #22
    //   1369: instanceof java/lang/Long
    //   1372: ifeq -> 1391
    //   1375: aload #22
    //   1377: checkcast java/lang/Long
    //   1380: invokevirtual longValue : ()J
    //   1383: lconst_0
    //   1384: lcmp
    //   1385: ifne -> 1391
    //   1388: goto -> 2293
    //   1391: aload #24
    //   1393: getstatic java/lang/Float.TYPE : Ljava/lang/Class;
    //   1396: if_acmpne -> 1423
    //   1399: aload #22
    //   1401: instanceof java/lang/Float
    //   1404: ifeq -> 1423
    //   1407: aload #22
    //   1409: checkcast java/lang/Float
    //   1412: invokevirtual floatValue : ()F
    //   1415: fconst_0
    //   1416: fcmpl
    //   1417: ifne -> 1423
    //   1420: goto -> 2293
    //   1423: aload #24
    //   1425: getstatic java/lang/Double.TYPE : Ljava/lang/Class;
    //   1428: if_acmpne -> 1455
    //   1431: aload #22
    //   1433: instanceof java/lang/Double
    //   1436: ifeq -> 1455
    //   1439: aload #22
    //   1441: checkcast java/lang/Double
    //   1444: invokevirtual doubleValue : ()D
    //   1447: dconst_0
    //   1448: dcmpl
    //   1449: ifne -> 1455
    //   1452: goto -> 2293
    //   1455: aload #24
    //   1457: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   1460: if_acmpne -> 1485
    //   1463: aload #22
    //   1465: instanceof java/lang/Boolean
    //   1468: ifeq -> 1485
    //   1471: aload #22
    //   1473: checkcast java/lang/Boolean
    //   1476: invokevirtual booleanValue : ()Z
    //   1479: ifne -> 1485
    //   1482: goto -> 2293
    //   1485: iload #11
    //   1487: ifeq -> 2299
    //   1490: aload #33
    //   1492: bipush #44
    //   1494: invokevirtual write : (I)V
    //   1497: aload #33
    //   1499: getfield prettyFormat : Z
    //   1502: ifeq -> 1512
    //   1505: aload_1
    //   1506: invokevirtual println : ()V
    //   1509: goto -> 1512
    //   1512: aload #31
    //   1514: aload #30
    //   1516: if_acmpeq -> 1544
    //   1519: iload #17
    //   1521: ifne -> 2302
    //   1524: aload #33
    //   1526: aload #31
    //   1528: iconst_1
    //   1529: invokevirtual writeFieldName : (Ljava/lang/String;Z)V
    //   1532: goto -> 1535
    //   1535: aload_1
    //   1536: aload #22
    //   1538: invokevirtual write : (Ljava/lang/Object;)V
    //   1541: goto -> 2305
    //   1544: aload #23
    //   1546: aload #22
    //   1548: if_acmpeq -> 1571
    //   1551: iload #17
    //   1553: ifne -> 1562
    //   1556: aload #34
    //   1558: aload_1
    //   1559: invokevirtual writePrefix : (Lcom/alibaba/fastjson/serializer/JSONSerializer;)V
    //   1562: aload_1
    //   1563: aload #22
    //   1565: invokevirtual write : (Ljava/lang/Object;)V
    //   1568: goto -> 2305
    //   1571: iload #17
    //   1573: ifne -> 1607
    //   1576: iload #9
    //   1578: ifeq -> 1601
    //   1581: aload #33
    //   1583: aload #35
    //   1585: getfield name_chars : [C
    //   1588: iconst_0
    //   1589: aload #35
    //   1591: getfield name_chars : [C
    //   1594: arraylength
    //   1595: invokevirtual write : ([CII)V
    //   1598: goto -> 1607
    //   1601: aload #34
    //   1603: aload_1
    //   1604: invokevirtual writePrefix : (Lcom/alibaba/fastjson/serializer/JSONSerializer;)V
    //   1607: iload #12
    //   1609: ifeq -> 1706
    //   1612: iload #5
    //   1614: ifne -> 1706
    //   1617: aload #36
    //   1619: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   1622: if_acmpne -> 1637
    //   1625: aload_1
    //   1626: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   1629: iload #13
    //   1631: invokevirtual writeInt : (I)V
    //   1634: goto -> 2305
    //   1637: aload #36
    //   1639: getstatic java/lang/Long.TYPE : Ljava/lang/Class;
    //   1642: if_acmpne -> 1657
    //   1645: aload_1
    //   1646: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   1649: lload #18
    //   1651: invokevirtual writeLong : (J)V
    //   1654: goto -> 2305
    //   1657: aload #36
    //   1659: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   1662: if_acmpne -> 2305
    //   1665: iload #14
    //   1667: ifeq -> 1688
    //   1670: aload_1
    //   1671: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   1674: getstatic com/alibaba/fastjson/serializer/JavaBeanSerializer.true_chars : [C
    //   1677: iconst_0
    //   1678: getstatic com/alibaba/fastjson/serializer/JavaBeanSerializer.true_chars : [C
    //   1681: arraylength
    //   1682: invokevirtual write : ([CII)V
    //   1685: goto -> 2305
    //   1688: aload_1
    //   1689: getfield out : Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   1692: getstatic com/alibaba/fastjson/serializer/JavaBeanSerializer.false_chars : [C
    //   1695: iconst_0
    //   1696: getstatic com/alibaba/fastjson/serializer/JavaBeanSerializer.false_chars : [C
    //   1699: arraylength
    //   1700: invokevirtual write : ([CII)V
    //   1703: goto -> 2305
    //   1706: iload #17
    //   1708: ifne -> 1822
    //   1711: aload #36
    //   1713: ldc java/lang/String
    //   1715: if_acmpne -> 1811
    //   1718: aload #22
    //   1720: ifnonnull -> 1775
    //   1723: aload #33
    //   1725: getfield features : I
    //   1728: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNullStringAsEmpty : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1731: getfield mask : I
    //   1734: iand
    //   1735: ifne -> 1764
    //   1738: aload #34
    //   1740: getfield features : I
    //   1743: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNullStringAsEmpty : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1746: getfield mask : I
    //   1749: iand
    //   1750: ifeq -> 1756
    //   1753: goto -> 1764
    //   1756: aload #33
    //   1758: invokevirtual writeNull : ()V
    //   1761: goto -> 2305
    //   1764: aload #33
    //   1766: ldc_w ''
    //   1769: invokevirtual writeString : (Ljava/lang/String;)V
    //   1772: goto -> 2305
    //   1775: aload #22
    //   1777: checkcast java/lang/String
    //   1780: astore #22
    //   1782: aload #33
    //   1784: getfield useSingleQuotes : Z
    //   1787: ifeq -> 1800
    //   1790: aload #33
    //   1792: aload #22
    //   1794: invokevirtual writeStringWithSingleQuote : (Ljava/lang/String;)V
    //   1797: goto -> 2305
    //   1800: aload #33
    //   1802: aload #22
    //   1804: iconst_0
    //   1805: invokevirtual writeStringWithDoubleQuote : (Ljava/lang/String;C)V
    //   1808: goto -> 2305
    //   1811: aload #34
    //   1813: aload_1
    //   1814: aload #22
    //   1816: invokevirtual writeValue : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;)V
    //   1819: goto -> 2305
    //   1822: aload #34
    //   1824: aload_1
    //   1825: aload #22
    //   1827: invokevirtual writeValue : (Lcom/alibaba/fastjson/serializer/JSONSerializer;Ljava/lang/Object;)V
    //   1830: goto -> 2305
    //   1833: aload_1
    //   1834: aload_2
    //   1835: iload #7
    //   1837: invokevirtual writeAfter : (Ljava/lang/Object;C)C
    //   1840: pop
    //   1841: aload #29
    //   1843: arraylength
    //   1844: ifle -> 1863
    //   1847: aload #33
    //   1849: getfield prettyFormat : Z
    //   1852: ifeq -> 1863
    //   1855: aload_1
    //   1856: invokevirtual decrementIdent : ()V
    //   1859: aload_1
    //   1860: invokevirtual println : ()V
    //   1863: aload #33
    //   1865: iload #6
    //   1867: invokevirtual append : (C)Lcom/alibaba/fastjson/serializer/SerializeWriter;
    //   1870: pop
    //   1871: aload_1
    //   1872: aload #32
    //   1874: putfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   1877: return
    //   1878: astore_2
    //   1879: goto -> 2049
    //   1882: astore #20
    //   1884: goto -> 1893
    //   1887: astore_2
    //   1888: goto -> 2049
    //   1891: astore #20
    //   1893: ldc_w 'write javaBean error'
    //   1896: astore #4
    //   1898: aload_2
    //   1899: ifnull -> 1949
    //   1902: new java/lang/StringBuilder
    //   1905: dup
    //   1906: invokespecial <init> : ()V
    //   1909: astore #4
    //   1911: aload #4
    //   1913: ldc_w 'write javaBean error'
    //   1916: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: pop
    //   1920: aload #4
    //   1922: ldc_w ', class '
    //   1925: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1928: pop
    //   1929: aload #4
    //   1931: aload_2
    //   1932: invokevirtual getClass : ()Ljava/lang/Class;
    //   1935: invokevirtual getName : ()Ljava/lang/String;
    //   1938: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: pop
    //   1942: aload #4
    //   1944: invokevirtual toString : ()Ljava/lang/String;
    //   1947: astore #4
    //   1949: aload #4
    //   1951: astore_2
    //   1952: aload_3
    //   1953: ifnull -> 1990
    //   1956: new java/lang/StringBuilder
    //   1959: dup
    //   1960: invokespecial <init> : ()V
    //   1963: astore_2
    //   1964: aload_2
    //   1965: aload #4
    //   1967: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1970: pop
    //   1971: aload_2
    //   1972: ldc_w ', fieldName : '
    //   1975: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1978: pop
    //   1979: aload_2
    //   1980: aload_3
    //   1981: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1984: pop
    //   1985: aload_2
    //   1986: invokevirtual toString : ()Ljava/lang/String;
    //   1989: astore_2
    //   1990: aload_2
    //   1991: astore_3
    //   1992: aload #20
    //   1994: invokevirtual getMessage : ()Ljava/lang/String;
    //   1997: ifnull -> 2037
    //   2000: new java/lang/StringBuilder
    //   2003: dup
    //   2004: invokespecial <init> : ()V
    //   2007: astore_3
    //   2008: aload_3
    //   2009: aload_2
    //   2010: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2013: pop
    //   2014: aload_3
    //   2015: ldc_w ', '
    //   2018: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: pop
    //   2022: aload_3
    //   2023: aload #20
    //   2025: invokevirtual getMessage : ()Ljava/lang/String;
    //   2028: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2031: pop
    //   2032: aload_3
    //   2033: invokevirtual toString : ()Ljava/lang/String;
    //   2036: astore_3
    //   2037: new com/alibaba/fastjson/JSONException
    //   2040: dup
    //   2041: aload_3
    //   2042: aload #20
    //   2044: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   2047: athrow
    //   2048: astore_2
    //   2049: aload_1
    //   2050: aload #32
    //   2052: putfield context : Lcom/alibaba/fastjson/serializer/SerialContext;
    //   2055: aload_2
    //   2056: athrow
    //   2057: iconst_0
    //   2058: istore #5
    //   2060: iload #5
    //   2062: ifeq -> 2072
    //   2065: bipush #44
    //   2067: istore #7
    //   2069: goto -> 196
    //   2072: iconst_0
    //   2073: istore #7
    //   2075: goto -> 196
    //   2078: iconst_0
    //   2079: istore #5
    //   2081: goto -> 218
    //   2084: iconst_0
    //   2085: istore #8
    //   2087: goto -> 236
    //   2090: iload #15
    //   2092: ifeq -> 372
    //   2095: aload #22
    //   2097: ifnonnull -> 372
    //   2100: goto -> 2293
    //   2103: goto -> 390
    //   2106: aload #22
    //   2108: astore #21
    //   2110: iconst_1
    //   2111: istore #5
    //   2113: iload #5
    //   2115: ifne -> 439
    //   2118: goto -> 2100
    //   2121: iconst_1
    //   2122: istore #5
    //   2124: iload #5
    //   2126: ifne -> 492
    //   2129: goto -> 2118
    //   2132: iconst_0
    //   2133: istore #14
    //   2135: aconst_null
    //   2136: astore #22
    //   2138: iconst_1
    //   2139: istore #12
    //   2141: iconst_0
    //   2142: istore #8
    //   2144: iload #5
    //   2146: istore #13
    //   2148: iload #8
    //   2150: istore #5
    //   2152: goto -> 603
    //   2155: lconst_0
    //   2156: lstore #18
    //   2158: iconst_0
    //   2159: istore #12
    //   2161: iconst_0
    //   2162: istore #13
    //   2164: iconst_0
    //   2165: istore #14
    //   2167: iconst_1
    //   2168: istore #5
    //   2170: goto -> 603
    //   2173: iconst_1
    //   2174: istore #5
    //   2176: goto -> 667
    //   2179: goto -> 667
    //   2182: goto -> 676
    //   2185: goto -> 2188
    //   2188: iconst_1
    //   2189: istore #8
    //   2191: iload #8
    //   2193: ifne -> 719
    //   2196: goto -> 2100
    //   2199: iconst_1
    //   2200: istore #5
    //   2202: goto -> 788
    //   2205: goto -> 788
    //   2208: aload #23
    //   2210: astore #31
    //   2212: goto -> 836
    //   2215: aload #30
    //   2217: astore #31
    //   2219: goto -> 836
    //   2222: iconst_1
    //   2223: istore #5
    //   2225: goto -> 932
    //   2228: aload #36
    //   2230: ldc java/lang/String
    //   2232: if_acmpne -> 902
    //   2235: aload #22
    //   2237: astore #23
    //   2239: aload #23
    //   2241: astore #22
    //   2243: goto -> 932
    //   2246: iconst_1
    //   2247: istore #5
    //   2249: goto -> 1001
    //   2252: goto -> 1001
    //   2255: goto -> 1057
    //   2258: aload #22
    //   2260: astore #23
    //   2262: goto -> 1057
    //   2265: aload #22
    //   2267: astore #24
    //   2269: iconst_1
    //   2270: istore #8
    //   2272: aload #22
    //   2274: astore #25
    //   2276: goto -> 1162
    //   2279: iload #8
    //   2281: istore #5
    //   2283: aload #24
    //   2285: astore #23
    //   2287: goto -> 1215
    //   2290: goto -> 1215
    //   2293: goto -> 2308
    //   2296: goto -> 1485
    //   2299: goto -> 1512
    //   2302: goto -> 1535
    //   2305: iconst_1
    //   2306: istore #11
    //   2308: iload #10
    //   2310: iconst_1
    //   2311: iadd
    //   2312: istore #10
    //   2314: goto -> 305
    //   2317: iconst_0
    //   2318: istore #7
    //   2320: iload #11
    //   2322: ifeq -> 1833
    //   2325: bipush #44
    //   2327: istore #7
    //   2329: goto -> 1833
    // Exception table:
    //   from	to	target	type
    //   110	140	1891	java/lang/Exception
    //   110	140	1887	finally
    //   140	164	1891	java/lang/Exception
    //   140	164	1887	finally
    //   164	190	1891	java/lang/Exception
    //   164	190	1887	finally
    //   196	212	1891	java/lang/Exception
    //   196	212	1887	finally
    //   218	230	1891	java/lang/Exception
    //   218	230	1887	finally
    //   236	268	1891	java/lang/Exception
    //   236	268	1887	finally
    //   268	286	1891	java/lang/Exception
    //   268	286	1887	finally
    //   305	313	1882	java/lang/Exception
    //   305	313	1878	finally
    //   320	351	1882	java/lang/Exception
    //   320	351	1878	finally
    //   361	369	1882	java/lang/Exception
    //   361	369	1878	finally
    //   381	390	1882	java/lang/Exception
    //   381	390	1878	finally
    //   394	416	1882	java/lang/Exception
    //   394	416	1878	finally
    //   416	433	1882	java/lang/Exception
    //   416	433	1878	finally
    //   444	453	1882	java/lang/Exception
    //   444	453	1878	finally
    //   453	486	1882	java/lang/Exception
    //   453	486	1878	finally
    //   492	519	1882	java/lang/Exception
    //   492	519	1878	finally
    //   525	544	1882	java/lang/Exception
    //   525	544	1878	finally
    //   550	569	1882	java/lang/Exception
    //   550	569	1878	finally
    //   578	589	1882	java/lang/Exception
    //   578	589	1878	finally
    //   592	600	1882	java/lang/Exception
    //   592	600	1878	finally
    //   613	628	1882	java/lang/Exception
    //   613	628	1878	finally
    //   631	646	1882	java/lang/Exception
    //   631	646	1878	finally
    //   649	664	1882	java/lang/Exception
    //   649	664	1878	finally
    //   667	676	1882	java/lang/Exception
    //   667	676	1878	finally
    //   676	695	1882	java/lang/Exception
    //   676	695	1878	finally
    //   695	713	1882	java/lang/Exception
    //   695	713	1878	finally
    //   734	749	1882	java/lang/Exception
    //   734	749	1878	finally
    //   752	767	1882	java/lang/Exception
    //   752	767	1878	finally
    //   770	785	1882	java/lang/Exception
    //   770	785	1878	finally
    //   788	797	1882	java/lang/Exception
    //   788	797	1878	finally
    //   801	833	1882	java/lang/Exception
    //   801	833	1878	finally
    //   840	863	1882	java/lang/Exception
    //   840	863	1878	finally
    //   866	881	1882	java/lang/Exception
    //   866	881	1878	finally
    //   884	899	1882	java/lang/Exception
    //   884	899	1878	finally
    //   902	910	1882	java/lang/Exception
    //   902	910	1878	finally
    //   914	922	1882	java/lang/Exception
    //   914	922	1878	finally
    //   922	929	1882	java/lang/Exception
    //   922	929	1878	finally
    //   947	962	1882	java/lang/Exception
    //   947	962	1878	finally
    //   965	980	1882	java/lang/Exception
    //   965	980	1878	finally
    //   983	998	1882	java/lang/Exception
    //   983	998	1878	finally
    //   1001	1010	1882	java/lang/Exception
    //   1001	1010	1878	finally
    //   1022	1054	1882	java/lang/Exception
    //   1022	1054	1878	finally
    //   1096	1111	1882	java/lang/Exception
    //   1096	1111	1878	finally
    //   1114	1129	1882	java/lang/Exception
    //   1114	1129	1878	finally
    //   1144	1159	1882	java/lang/Exception
    //   1144	1159	1878	finally
    //   1162	1171	1882	java/lang/Exception
    //   1162	1171	1878	finally
    //   1175	1212	1882	java/lang/Exception
    //   1175	1212	1878	finally
    //   1230	1246	1882	java/lang/Exception
    //   1230	1246	1878	finally
    //   1254	1296	1882	java/lang/Exception
    //   1254	1296	1878	finally
    //   1299	1326	1882	java/lang/Exception
    //   1299	1326	1878	finally
    //   1329	1356	1882	java/lang/Exception
    //   1329	1356	1878	finally
    //   1359	1388	1882	java/lang/Exception
    //   1359	1388	1878	finally
    //   1391	1420	1882	java/lang/Exception
    //   1391	1420	1878	finally
    //   1423	1452	1882	java/lang/Exception
    //   1423	1452	1878	finally
    //   1455	1482	1882	java/lang/Exception
    //   1455	1482	1878	finally
    //   1490	1509	1882	java/lang/Exception
    //   1490	1509	1878	finally
    //   1524	1532	1882	java/lang/Exception
    //   1524	1532	1878	finally
    //   1535	1541	1882	java/lang/Exception
    //   1535	1541	1878	finally
    //   1556	1562	1882	java/lang/Exception
    //   1556	1562	1878	finally
    //   1562	1568	1882	java/lang/Exception
    //   1562	1568	1878	finally
    //   1581	1598	1882	java/lang/Exception
    //   1581	1598	1878	finally
    //   1601	1607	1882	java/lang/Exception
    //   1601	1607	1878	finally
    //   1617	1634	1882	java/lang/Exception
    //   1617	1634	1878	finally
    //   1637	1654	1882	java/lang/Exception
    //   1637	1654	1878	finally
    //   1657	1665	1882	java/lang/Exception
    //   1657	1665	1878	finally
    //   1670	1685	1882	java/lang/Exception
    //   1670	1685	1878	finally
    //   1688	1703	1882	java/lang/Exception
    //   1688	1703	1878	finally
    //   1723	1753	1882	java/lang/Exception
    //   1723	1753	1878	finally
    //   1756	1761	1882	java/lang/Exception
    //   1756	1761	1878	finally
    //   1764	1772	1882	java/lang/Exception
    //   1764	1772	1878	finally
    //   1775	1797	1882	java/lang/Exception
    //   1775	1797	1878	finally
    //   1800	1808	1882	java/lang/Exception
    //   1800	1808	1878	finally
    //   1811	1819	1882	java/lang/Exception
    //   1811	1819	1878	finally
    //   1822	1830	1882	java/lang/Exception
    //   1822	1830	1878	finally
    //   1833	1863	1882	java/lang/Exception
    //   1833	1863	1878	finally
    //   1863	1871	1882	java/lang/Exception
    //   1863	1871	1878	finally
    //   1902	1949	2048	finally
    //   1956	1990	2048	finally
    //   1992	2037	2048	finally
    //   2037	2048	2048	finally
  }
  
  public boolean writeReference(JSONSerializer paramJSONSerializer, Object paramObject, int paramInt) {
    SerialContext serialContext = paramJSONSerializer.context;
    int i = SerializerFeature.DisableCircularReferenceDetect.mask;
    if (serialContext != null && ((serialContext.features & i) != 0 || (paramInt & i) != 0))
      return false; 
    if (paramJSONSerializer.references != null && paramJSONSerializer.references.containsKey(paramObject)) {
      paramJSONSerializer.writeReference(paramObject);
      return true;
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\JavaBeanSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */