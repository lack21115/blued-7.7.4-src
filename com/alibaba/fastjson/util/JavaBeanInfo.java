package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class JavaBeanInfo {
  public final Method buildMethod;
  
  public final Class<?> builderClass;
  
  public final Class<?> clazz;
  
  public final Constructor<?> creatorConstructor;
  
  public final Constructor<?> defaultConstructor;
  
  public final int defaultConstructorParameterSize;
  
  public final Method factoryMethod;
  
  public final FieldInfo[] fields;
  
  public final JSONType jsonType;
  
  public final int parserFeatures;
  
  public final FieldInfo[] sortedFields;
  
  public JavaBeanInfo(Class<?> paramClass1, Class<?> paramClass2, Constructor<?> paramConstructor1, Constructor<?> paramConstructor2, Method paramMethod1, Method paramMethod2, JSONType paramJSONType, List<FieldInfo> paramList) {
    this.clazz = paramClass1;
    this.builderClass = paramClass2;
    this.defaultConstructor = paramConstructor1;
    this.creatorConstructor = paramConstructor2;
    this.factoryMethod = paramMethod1;
    this.parserFeatures = TypeUtils.getParserFeatures(paramClass1);
    this.buildMethod = paramMethod2;
    this.jsonType = paramJSONType;
    this.fields = new FieldInfo[paramList.size()];
    paramList.toArray(this.fields);
    FieldInfo[] arrayOfFieldInfo1 = this.fields;
    FieldInfo[] arrayOfFieldInfo2 = new FieldInfo[arrayOfFieldInfo1.length];
    int j = arrayOfFieldInfo1.length;
    int i = 0;
    System.arraycopy(arrayOfFieldInfo1, 0, arrayOfFieldInfo2, 0, j);
    Arrays.sort((Object[])arrayOfFieldInfo2);
    arrayOfFieldInfo1 = arrayOfFieldInfo2;
    if (Arrays.equals((Object[])this.fields, (Object[])arrayOfFieldInfo2))
      arrayOfFieldInfo1 = this.fields; 
    this.sortedFields = arrayOfFieldInfo1;
    if (paramConstructor1 != null)
      i = (paramConstructor1.getParameterTypes()).length; 
    this.defaultConstructorParameterSize = i;
  }
  
  static boolean add(List<FieldInfo> paramList, FieldInfo paramFieldInfo) {
    int i = paramList.size() - 1;
    while (i >= 0) {
      FieldInfo fieldInfo = paramList.get(i);
      if (!fieldInfo.name.equals(paramFieldInfo.name) || (fieldInfo.getOnly && !paramFieldInfo.getOnly)) {
        i--;
        continue;
      } 
      if (fieldInfo.fieldClass.isAssignableFrom(paramFieldInfo.fieldClass)) {
        paramList.remove(i);
        break;
      } 
      if (fieldInfo.compareTo(paramFieldInfo) < 0) {
        paramList.remove(i);
        break;
      } 
      return false;
    } 
    paramList.add(paramFieldInfo);
    return true;
  }
  
  public static JavaBeanInfo build(Class<?> paramClass, Type paramType) {
    // Byte code:
    //   0: aload_0
    //   1: astore #9
    //   3: aload #9
    //   5: ldc com/alibaba/fastjson/annotation/JSONType
    //   7: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   10: checkcast com/alibaba/fastjson/annotation/JSONType
    //   13: astore #10
    //   15: aload #10
    //   17: invokestatic getBuilderClass : (Lcom/alibaba/fastjson/annotation/JSONType;)Ljava/lang/Class;
    //   20: astore #15
    //   22: aload_0
    //   23: invokevirtual getDeclaredFields : ()[Ljava/lang/reflect/Field;
    //   26: astore #7
    //   28: aload_0
    //   29: invokevirtual getMethods : ()[Ljava/lang/reflect/Method;
    //   32: astore #19
    //   34: aload #15
    //   36: ifnonnull -> 46
    //   39: aload #9
    //   41: astore #8
    //   43: goto -> 50
    //   46: aload #15
    //   48: astore #8
    //   50: aload #8
    //   52: invokestatic getDefaultConstructor : (Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   55: astore #18
    //   57: new java/util/ArrayList
    //   60: dup
    //   61: invokespecial <init> : ()V
    //   64: astore #11
    //   66: aload #18
    //   68: ifnonnull -> 585
    //   71: aload_0
    //   72: invokevirtual isInterface : ()Z
    //   75: ifne -> 585
    //   78: aload_0
    //   79: invokevirtual getModifiers : ()I
    //   82: invokestatic isAbstract : (I)Z
    //   85: ifne -> 585
    //   88: aload_0
    //   89: invokestatic getCreatorConstructor : (Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   92: astore #12
    //   94: ldc 'illegal json creator'
    //   96: astore_1
    //   97: aload #12
    //   99: ifnull -> 318
    //   102: aload #12
    //   104: invokestatic setAccessible : (Ljava/lang/reflect/AccessibleObject;)V
    //   107: aload #12
    //   109: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   112: astore #13
    //   114: aload #13
    //   116: arraylength
    //   117: ifle -> 298
    //   120: aload #12
    //   122: invokevirtual getParameterAnnotations : ()[[Ljava/lang/annotation/Annotation;
    //   125: astore #14
    //   127: iconst_0
    //   128: istore_3
    //   129: iload_3
    //   130: aload #13
    //   132: arraylength
    //   133: if_icmpge -> 298
    //   136: aload #14
    //   138: iload_3
    //   139: aaload
    //   140: astore #8
    //   142: aload #8
    //   144: arraylength
    //   145: istore #5
    //   147: iconst_0
    //   148: istore #4
    //   150: iload #4
    //   152: iload #5
    //   154: if_icmpge -> 191
    //   157: aload #8
    //   159: iload #4
    //   161: aaload
    //   162: astore #16
    //   164: aload #16
    //   166: instanceof com/alibaba/fastjson/annotation/JSONField
    //   169: ifeq -> 182
    //   172: aload #16
    //   174: checkcast com/alibaba/fastjson/annotation/JSONField
    //   177: astore #8
    //   179: goto -> 194
    //   182: iload #4
    //   184: iconst_1
    //   185: iadd
    //   186: istore #4
    //   188: goto -> 150
    //   191: aconst_null
    //   192: astore #8
    //   194: aload #8
    //   196: ifnull -> 289
    //   199: aload #13
    //   201: iload_3
    //   202: aaload
    //   203: astore #16
    //   205: aload #12
    //   207: invokevirtual getGenericParameterTypes : ()[Ljava/lang/reflect/Type;
    //   210: iload_3
    //   211: aaload
    //   212: astore #17
    //   214: aload #9
    //   216: aload #8
    //   218: invokeinterface name : ()Ljava/lang/String;
    //   223: aload #7
    //   225: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   228: astore #18
    //   230: aload #8
    //   232: invokeinterface ordinal : ()I
    //   237: istore #4
    //   239: aload #8
    //   241: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   246: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   249: istore #5
    //   251: aload #11
    //   253: new com/alibaba/fastjson/util/FieldInfo
    //   256: dup
    //   257: aload #8
    //   259: invokeinterface name : ()Ljava/lang/String;
    //   264: aload_0
    //   265: aload #16
    //   267: aload #17
    //   269: aload #18
    //   271: iload #4
    //   273: iload #5
    //   275: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/lang/reflect/Field;II)V
    //   278: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   281: pop
    //   282: iload_3
    //   283: iconst_1
    //   284: iadd
    //   285: istore_3
    //   286: goto -> 129
    //   289: new com/alibaba/fastjson/JSONException
    //   292: dup
    //   293: aload_1
    //   294: invokespecial <init> : (Ljava/lang/String;)V
    //   297: athrow
    //   298: new com/alibaba/fastjson/util/JavaBeanInfo
    //   301: dup
    //   302: aload_0
    //   303: aload #15
    //   305: aconst_null
    //   306: aload #12
    //   308: aconst_null
    //   309: aconst_null
    //   310: aload #10
    //   312: aload #11
    //   314: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/alibaba/fastjson/annotation/JSONType;Ljava/util/List;)V
    //   317: areturn
    //   318: aload #7
    //   320: astore_1
    //   321: aload #9
    //   323: aload #19
    //   325: invokestatic getFactoryMethod : (Ljava/lang/Class;[Ljava/lang/reflect/Method;)Ljava/lang/reflect/Method;
    //   328: astore #12
    //   330: aload #12
    //   332: ifnull -> 551
    //   335: aload #12
    //   337: invokestatic setAccessible : (Ljava/lang/reflect/AccessibleObject;)V
    //   340: aload #12
    //   342: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   345: astore #7
    //   347: aload #7
    //   349: arraylength
    //   350: ifle -> 531
    //   353: aload #12
    //   355: invokevirtual getParameterAnnotations : ()[[Ljava/lang/annotation/Annotation;
    //   358: astore #13
    //   360: iconst_0
    //   361: istore_3
    //   362: iload_3
    //   363: aload #7
    //   365: arraylength
    //   366: if_icmpge -> 531
    //   369: aload #13
    //   371: iload_3
    //   372: aaload
    //   373: astore #8
    //   375: aload #8
    //   377: arraylength
    //   378: istore #5
    //   380: iconst_0
    //   381: istore #4
    //   383: iload #4
    //   385: iload #5
    //   387: if_icmpge -> 424
    //   390: aload #8
    //   392: iload #4
    //   394: aaload
    //   395: astore #14
    //   397: aload #14
    //   399: instanceof com/alibaba/fastjson/annotation/JSONField
    //   402: ifeq -> 415
    //   405: aload #14
    //   407: checkcast com/alibaba/fastjson/annotation/JSONField
    //   410: astore #8
    //   412: goto -> 427
    //   415: iload #4
    //   417: iconst_1
    //   418: iadd
    //   419: istore #4
    //   421: goto -> 383
    //   424: aconst_null
    //   425: astore #8
    //   427: aload #8
    //   429: ifnull -> 521
    //   432: aload #7
    //   434: iload_3
    //   435: aaload
    //   436: astore #14
    //   438: aload #12
    //   440: invokevirtual getGenericParameterTypes : ()[Ljava/lang/reflect/Type;
    //   443: iload_3
    //   444: aaload
    //   445: astore #16
    //   447: aload #9
    //   449: aload #8
    //   451: invokeinterface name : ()Ljava/lang/String;
    //   456: aload_1
    //   457: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   460: astore #17
    //   462: aload #8
    //   464: invokeinterface ordinal : ()I
    //   469: istore #4
    //   471: aload #8
    //   473: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   478: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   481: istore #5
    //   483: aload #11
    //   485: new com/alibaba/fastjson/util/FieldInfo
    //   488: dup
    //   489: aload #8
    //   491: invokeinterface name : ()Ljava/lang/String;
    //   496: aload_0
    //   497: aload #14
    //   499: aload #16
    //   501: aload #17
    //   503: iload #4
    //   505: iload #5
    //   507: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/lang/reflect/Field;II)V
    //   510: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   513: pop
    //   514: iload_3
    //   515: iconst_1
    //   516: iadd
    //   517: istore_3
    //   518: goto -> 362
    //   521: new com/alibaba/fastjson/JSONException
    //   524: dup
    //   525: ldc 'illegal json creator'
    //   527: invokespecial <init> : (Ljava/lang/String;)V
    //   530: athrow
    //   531: new com/alibaba/fastjson/util/JavaBeanInfo
    //   534: dup
    //   535: aload_0
    //   536: aload #15
    //   538: aconst_null
    //   539: aconst_null
    //   540: aload #12
    //   542: aconst_null
    //   543: aload #10
    //   545: aload #11
    //   547: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/alibaba/fastjson/annotation/JSONType;Ljava/util/List;)V
    //   550: areturn
    //   551: new java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial <init> : ()V
    //   558: astore_0
    //   559: aload_0
    //   560: ldc 'default constructor not found. '
    //   562: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload_0
    //   567: aload #9
    //   569: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: new com/alibaba/fastjson/JSONException
    //   576: dup
    //   577: aload_0
    //   578: invokevirtual toString : ()Ljava/lang/String;
    //   581: invokespecial <init> : (Ljava/lang/String;)V
    //   584: athrow
    //   585: aload #7
    //   587: astore #13
    //   589: aload #18
    //   591: ifnull -> 599
    //   594: aload #18
    //   596: invokestatic setAccessible : (Ljava/lang/reflect/AccessibleObject;)V
    //   599: aload #15
    //   601: ifnull -> 1132
    //   604: aload #15
    //   606: ldc com/alibaba/fastjson/annotation/JSONPOJOBuilder
    //   608: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   611: checkcast com/alibaba/fastjson/annotation/JSONPOJOBuilder
    //   614: astore #7
    //   616: aload #7
    //   618: ifnull -> 633
    //   621: aload #7
    //   623: invokeinterface withPrefix : ()Ljava/lang/String;
    //   628: astore #7
    //   630: goto -> 636
    //   633: aconst_null
    //   634: astore #7
    //   636: aload #7
    //   638: ifnull -> 653
    //   641: aload #7
    //   643: astore #8
    //   645: aload #7
    //   647: invokevirtual length : ()I
    //   650: ifne -> 658
    //   653: ldc_w 'with'
    //   656: astore #8
    //   658: aload #15
    //   660: invokevirtual getMethods : ()[Ljava/lang/reflect/Method;
    //   663: astore #14
    //   665: aload #14
    //   667: arraylength
    //   668: istore_3
    //   669: iconst_0
    //   670: istore #4
    //   672: aload #8
    //   674: astore #12
    //   676: aload #10
    //   678: astore #7
    //   680: aload #11
    //   682: astore #8
    //   684: aload #14
    //   686: astore #10
    //   688: iload #4
    //   690: iload_3
    //   691: if_icmpge -> 984
    //   694: aload #10
    //   696: iload #4
    //   698: aaload
    //   699: astore #16
    //   701: aload #16
    //   703: invokevirtual getModifiers : ()I
    //   706: invokestatic isStatic : (I)Z
    //   709: ifeq -> 715
    //   712: goto -> 975
    //   715: aload #16
    //   717: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   720: aload #15
    //   722: invokevirtual equals : (Ljava/lang/Object;)Z
    //   725: ifne -> 731
    //   728: goto -> 712
    //   731: aload #16
    //   733: ldc com/alibaba/fastjson/annotation/JSONField
    //   735: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   738: checkcast com/alibaba/fastjson/annotation/JSONField
    //   741: astore #14
    //   743: aload #14
    //   745: astore #11
    //   747: aload #14
    //   749: ifnonnull -> 761
    //   752: aload #9
    //   754: aload #16
    //   756: invokestatic getSupperMethodAnnotation : (Ljava/lang/Class;Ljava/lang/reflect/Method;)Lcom/alibaba/fastjson/annotation/JSONField;
    //   759: astore #11
    //   761: aload #11
    //   763: ifnull -> 852
    //   766: aload #11
    //   768: invokeinterface deserialize : ()Z
    //   773: ifne -> 779
    //   776: goto -> 712
    //   779: aload #11
    //   781: invokeinterface ordinal : ()I
    //   786: istore #6
    //   788: aload #11
    //   790: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   795: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   798: istore #5
    //   800: aload #11
    //   802: invokeinterface name : ()Ljava/lang/String;
    //   807: invokevirtual length : ()I
    //   810: ifeq -> 849
    //   813: aload #8
    //   815: new com/alibaba/fastjson/util/FieldInfo
    //   818: dup
    //   819: aload #11
    //   821: invokeinterface name : ()Ljava/lang/String;
    //   826: aload #16
    //   828: aconst_null
    //   829: aload_0
    //   830: aload_1
    //   831: iload #6
    //   833: iload #5
    //   835: aload #11
    //   837: aconst_null
    //   838: aconst_null
    //   839: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   842: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   845: pop
    //   846: goto -> 875
    //   849: goto -> 858
    //   852: iconst_0
    //   853: istore #6
    //   855: iconst_0
    //   856: istore #5
    //   858: aload #16
    //   860: invokevirtual getName : ()Ljava/lang/String;
    //   863: astore #14
    //   865: aload #14
    //   867: aload #12
    //   869: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   872: ifne -> 878
    //   875: goto -> 975
    //   878: aload #14
    //   880: invokevirtual length : ()I
    //   883: aload #12
    //   885: invokevirtual length : ()I
    //   888: if_icmpgt -> 894
    //   891: goto -> 875
    //   894: aload #14
    //   896: aload #12
    //   898: invokevirtual length : ()I
    //   901: invokevirtual charAt : (I)C
    //   904: istore_2
    //   905: iload_2
    //   906: invokestatic isUpperCase : (C)Z
    //   909: ifne -> 915
    //   912: goto -> 875
    //   915: new java/lang/StringBuilder
    //   918: dup
    //   919: aload #14
    //   921: aload #12
    //   923: invokevirtual length : ()I
    //   926: invokevirtual substring : (I)Ljava/lang/String;
    //   929: invokespecial <init> : (Ljava/lang/String;)V
    //   932: astore #14
    //   934: aload #14
    //   936: iconst_0
    //   937: iload_2
    //   938: invokestatic toLowerCase : (C)C
    //   941: invokevirtual setCharAt : (IC)V
    //   944: aload #8
    //   946: new com/alibaba/fastjson/util/FieldInfo
    //   949: dup
    //   950: aload #14
    //   952: invokevirtual toString : ()Ljava/lang/String;
    //   955: aload #16
    //   957: aconst_null
    //   958: aload_0
    //   959: aload_1
    //   960: iload #6
    //   962: iload #5
    //   964: aload #11
    //   966: aconst_null
    //   967: aconst_null
    //   968: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   971: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   974: pop
    //   975: iload #4
    //   977: iconst_1
    //   978: iadd
    //   979: istore #4
    //   981: goto -> 688
    //   984: aload #8
    //   986: astore #9
    //   988: aload #7
    //   990: astore #10
    //   992: aload #15
    //   994: ifnull -> 1136
    //   997: aload #15
    //   999: ldc com/alibaba/fastjson/annotation/JSONPOJOBuilder
    //   1001: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1004: checkcast com/alibaba/fastjson/annotation/JSONPOJOBuilder
    //   1007: astore #9
    //   1009: aload #9
    //   1011: ifnull -> 1026
    //   1014: aload #9
    //   1016: invokeinterface buildMethod : ()Ljava/lang/String;
    //   1021: astore #9
    //   1023: goto -> 1029
    //   1026: aconst_null
    //   1027: astore #9
    //   1029: aload #9
    //   1031: ifnull -> 1046
    //   1034: aload #9
    //   1036: astore #10
    //   1038: aload #9
    //   1040: invokevirtual length : ()I
    //   1043: ifne -> 1051
    //   1046: ldc_w 'build'
    //   1049: astore #10
    //   1051: aload #15
    //   1053: aload #10
    //   1055: iconst_0
    //   1056: anewarray java/lang/Class
    //   1059: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1062: astore #9
    //   1064: goto -> 1070
    //   1067: aconst_null
    //   1068: astore #9
    //   1070: aload #9
    //   1072: astore #10
    //   1074: aload #9
    //   1076: ifnonnull -> 1096
    //   1079: aload #15
    //   1081: ldc_w 'create'
    //   1084: iconst_0
    //   1085: anewarray java/lang/Class
    //   1088: invokevirtual getMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1091: astore #10
    //   1093: goto -> 1096
    //   1096: aload #10
    //   1098: ifnull -> 1121
    //   1101: aload #10
    //   1103: invokestatic setAccessible : (Ljava/lang/reflect/AccessibleObject;)V
    //   1106: aload #10
    //   1108: astore #11
    //   1110: aload #8
    //   1112: astore #10
    //   1114: aload #7
    //   1116: astore #12
    //   1118: goto -> 1147
    //   1121: new com/alibaba/fastjson/JSONException
    //   1124: dup
    //   1125: ldc_w 'buildMethod not found.'
    //   1128: invokespecial <init> : (Ljava/lang/String;)V
    //   1131: athrow
    //   1132: aload #11
    //   1134: astore #9
    //   1136: aconst_null
    //   1137: astore #11
    //   1139: aload #10
    //   1141: astore #12
    //   1143: aload #9
    //   1145: astore #10
    //   1147: aload #19
    //   1149: arraylength
    //   1150: istore #5
    //   1152: iconst_0
    //   1153: istore #6
    //   1155: aload #13
    //   1157: astore #8
    //   1159: aload_0
    //   1160: astore #9
    //   1162: iload #6
    //   1164: iload #5
    //   1166: if_icmpge -> 1786
    //   1169: aload #19
    //   1171: iload #6
    //   1173: aaload
    //   1174: astore #20
    //   1176: aload #20
    //   1178: invokevirtual getName : ()Ljava/lang/String;
    //   1181: astore #14
    //   1183: aload #14
    //   1185: invokevirtual length : ()I
    //   1188: iconst_4
    //   1189: if_icmpge -> 1195
    //   1192: goto -> 1777
    //   1195: aload #20
    //   1197: invokevirtual getModifiers : ()I
    //   1200: invokestatic isStatic : (I)Z
    //   1203: ifeq -> 1209
    //   1206: goto -> 1192
    //   1209: aload #20
    //   1211: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   1214: getstatic java/lang/Void.TYPE : Ljava/lang/Class;
    //   1217: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1220: ifne -> 1239
    //   1223: aload #20
    //   1225: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   1228: aload #9
    //   1230: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1233: ifne -> 1239
    //   1236: goto -> 1192
    //   1239: aload #20
    //   1241: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   1244: astore #21
    //   1246: aload #21
    //   1248: arraylength
    //   1249: iconst_1
    //   1250: if_icmpeq -> 1256
    //   1253: goto -> 1192
    //   1256: aload #20
    //   1258: ldc com/alibaba/fastjson/annotation/JSONField
    //   1260: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1263: checkcast com/alibaba/fastjson/annotation/JSONField
    //   1266: astore #7
    //   1268: aload #7
    //   1270: astore #13
    //   1272: aload #7
    //   1274: ifnonnull -> 1286
    //   1277: aload #9
    //   1279: aload #20
    //   1281: invokestatic getSupperMethodAnnotation : (Ljava/lang/Class;Ljava/lang/reflect/Method;)Lcom/alibaba/fastjson/annotation/JSONField;
    //   1284: astore #13
    //   1286: aload #13
    //   1288: ifnull -> 1375
    //   1291: aload #13
    //   1293: invokeinterface deserialize : ()Z
    //   1298: ifne -> 1304
    //   1301: goto -> 1192
    //   1304: aload #13
    //   1306: invokeinterface ordinal : ()I
    //   1311: istore #4
    //   1313: aload #13
    //   1315: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1320: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   1323: istore_3
    //   1324: aload #13
    //   1326: invokeinterface name : ()Ljava/lang/String;
    //   1331: invokevirtual length : ()I
    //   1334: ifeq -> 1372
    //   1337: aload #10
    //   1339: new com/alibaba/fastjson/util/FieldInfo
    //   1342: dup
    //   1343: aload #13
    //   1345: invokeinterface name : ()Ljava/lang/String;
    //   1350: aload #20
    //   1352: aconst_null
    //   1353: aload_0
    //   1354: aload_1
    //   1355: iload #4
    //   1357: iload_3
    //   1358: aload #13
    //   1360: aconst_null
    //   1361: aconst_null
    //   1362: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1365: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   1368: pop
    //   1369: goto -> 1192
    //   1372: goto -> 1380
    //   1375: iconst_0
    //   1376: istore #4
    //   1378: iconst_0
    //   1379: istore_3
    //   1380: aload #14
    //   1382: ldc_w 'set'
    //   1385: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   1388: ifne -> 1394
    //   1391: goto -> 1192
    //   1394: aload #14
    //   1396: iconst_3
    //   1397: invokevirtual charAt : (I)C
    //   1400: istore_2
    //   1401: iload_2
    //   1402: invokestatic isUpperCase : (C)Z
    //   1405: ifne -> 1487
    //   1408: iload_2
    //   1409: sipush #512
    //   1412: if_icmple -> 1418
    //   1415: goto -> 1487
    //   1418: iload_2
    //   1419: bipush #95
    //   1421: if_icmpne -> 1435
    //   1424: aload #14
    //   1426: iconst_4
    //   1427: invokevirtual substring : (I)Ljava/lang/String;
    //   1430: astore #7
    //   1432: goto -> 1550
    //   1435: iload_2
    //   1436: bipush #102
    //   1438: if_icmpne -> 1452
    //   1441: aload #14
    //   1443: iconst_3
    //   1444: invokevirtual substring : (I)Ljava/lang/String;
    //   1447: astore #7
    //   1449: goto -> 1550
    //   1452: aload #14
    //   1454: invokevirtual length : ()I
    //   1457: iconst_5
    //   1458: if_icmplt -> 1192
    //   1461: aload #14
    //   1463: iconst_4
    //   1464: invokevirtual charAt : (I)C
    //   1467: invokestatic isUpperCase : (C)Z
    //   1470: ifeq -> 1192
    //   1473: aload #14
    //   1475: iconst_3
    //   1476: invokevirtual substring : (I)Ljava/lang/String;
    //   1479: invokestatic decapitalize : (Ljava/lang/String;)Ljava/lang/String;
    //   1482: astore #7
    //   1484: goto -> 1550
    //   1487: getstatic com/alibaba/fastjson/util/TypeUtils.compatibleWithJavaBean : Z
    //   1490: ifeq -> 1507
    //   1493: aload #14
    //   1495: iconst_3
    //   1496: invokevirtual substring : (I)Ljava/lang/String;
    //   1499: invokestatic decapitalize : (Ljava/lang/String;)Ljava/lang/String;
    //   1502: astore #7
    //   1504: goto -> 1550
    //   1507: new java/lang/StringBuilder
    //   1510: dup
    //   1511: invokespecial <init> : ()V
    //   1514: astore #7
    //   1516: aload #7
    //   1518: aload #14
    //   1520: iconst_3
    //   1521: invokevirtual charAt : (I)C
    //   1524: invokestatic toLowerCase : (C)C
    //   1527: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1530: pop
    //   1531: aload #7
    //   1533: aload #14
    //   1535: iconst_4
    //   1536: invokevirtual substring : (I)Ljava/lang/String;
    //   1539: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1542: pop
    //   1543: aload #7
    //   1545: invokevirtual toString : ()Ljava/lang/String;
    //   1548: astore #7
    //   1550: aload #8
    //   1552: astore #16
    //   1554: aload #9
    //   1556: aload #7
    //   1558: aload #16
    //   1560: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   1563: astore #17
    //   1565: aload #17
    //   1567: astore #14
    //   1569: aload #17
    //   1571: ifnonnull -> 1647
    //   1574: aload #17
    //   1576: astore #14
    //   1578: aload #21
    //   1580: iconst_0
    //   1581: aaload
    //   1582: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   1585: if_acmpne -> 1647
    //   1588: new java/lang/StringBuilder
    //   1591: dup
    //   1592: invokespecial <init> : ()V
    //   1595: astore #14
    //   1597: aload #14
    //   1599: ldc_w 'is'
    //   1602: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1605: pop
    //   1606: aload #14
    //   1608: aload #7
    //   1610: iconst_0
    //   1611: invokevirtual charAt : (I)C
    //   1614: invokestatic toUpperCase : (C)C
    //   1617: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   1620: pop
    //   1621: aload #14
    //   1623: aload #7
    //   1625: iconst_1
    //   1626: invokevirtual substring : (I)Ljava/lang/String;
    //   1629: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1632: pop
    //   1633: aload #9
    //   1635: aload #14
    //   1637: invokevirtual toString : ()Ljava/lang/String;
    //   1640: aload #16
    //   1642: invokestatic getField : (Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/reflect/Field;)Ljava/lang/reflect/Field;
    //   1645: astore #14
    //   1647: aload #14
    //   1649: ifnull -> 1745
    //   1652: aload #14
    //   1654: ldc com/alibaba/fastjson/annotation/JSONField
    //   1656: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1659: checkcast com/alibaba/fastjson/annotation/JSONField
    //   1662: astore #9
    //   1664: aload #9
    //   1666: ifnull -> 1742
    //   1669: aload #9
    //   1671: invokeinterface ordinal : ()I
    //   1676: istore #4
    //   1678: aload #9
    //   1680: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1685: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   1688: istore_3
    //   1689: aload #9
    //   1691: invokeinterface name : ()Ljava/lang/String;
    //   1696: invokevirtual length : ()I
    //   1699: ifeq -> 1739
    //   1702: aload #10
    //   1704: new com/alibaba/fastjson/util/FieldInfo
    //   1707: dup
    //   1708: aload #9
    //   1710: invokeinterface name : ()Ljava/lang/String;
    //   1715: aload #20
    //   1717: aload #14
    //   1719: aload_0
    //   1720: aload_1
    //   1721: iload #4
    //   1723: iload_3
    //   1724: aload #13
    //   1726: aload #9
    //   1728: aconst_null
    //   1729: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1732: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   1735: pop
    //   1736: goto -> 1777
    //   1739: goto -> 1748
    //   1742: goto -> 1748
    //   1745: aconst_null
    //   1746: astore #9
    //   1748: aload #10
    //   1750: new com/alibaba/fastjson/util/FieldInfo
    //   1753: dup
    //   1754: aload #7
    //   1756: aload #20
    //   1758: aload #14
    //   1760: aload_0
    //   1761: aload_1
    //   1762: iload #4
    //   1764: iload_3
    //   1765: aload #13
    //   1767: aload #9
    //   1769: aconst_null
    //   1770: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1773: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   1776: pop
    //   1777: iload #6
    //   1779: iconst_1
    //   1780: iadd
    //   1781: istore #6
    //   1783: goto -> 1159
    //   1786: aload_0
    //   1787: invokevirtual getFields : ()[Ljava/lang/reflect/Field;
    //   1790: astore #8
    //   1792: aload #8
    //   1794: arraylength
    //   1795: istore #6
    //   1797: iconst_0
    //   1798: istore_3
    //   1799: iload_3
    //   1800: iload #6
    //   1802: if_icmpge -> 1996
    //   1805: aload #8
    //   1807: iload_3
    //   1808: aaload
    //   1809: astore #9
    //   1811: aload #9
    //   1813: invokevirtual getModifiers : ()I
    //   1816: invokestatic isStatic : (I)Z
    //   1819: ifeq -> 1825
    //   1822: goto -> 1989
    //   1825: aload #10
    //   1827: invokeinterface iterator : ()Ljava/util/Iterator;
    //   1832: astore #7
    //   1834: aload #7
    //   1836: invokeinterface hasNext : ()Z
    //   1841: ifeq -> 1874
    //   1844: aload #7
    //   1846: invokeinterface next : ()Ljava/lang/Object;
    //   1851: checkcast com/alibaba/fastjson/util/FieldInfo
    //   1854: getfield name : Ljava/lang/String;
    //   1857: aload #9
    //   1859: invokevirtual getName : ()Ljava/lang/String;
    //   1862: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1865: ifeq -> 1834
    //   1868: iconst_1
    //   1869: istore #4
    //   1871: goto -> 1877
    //   1874: iconst_0
    //   1875: istore #4
    //   1877: iload #4
    //   1879: ifeq -> 1885
    //   1882: goto -> 1822
    //   1885: aload #9
    //   1887: invokevirtual getName : ()Ljava/lang/String;
    //   1890: astore #7
    //   1892: aload #9
    //   1894: ldc com/alibaba/fastjson/annotation/JSONField
    //   1896: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   1899: checkcast com/alibaba/fastjson/annotation/JSONField
    //   1902: astore #13
    //   1904: aload #13
    //   1906: ifnull -> 1955
    //   1909: aload #13
    //   1911: invokeinterface ordinal : ()I
    //   1916: istore #4
    //   1918: aload #13
    //   1920: invokeinterface serialzeFeatures : ()[Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1925: invokestatic of : ([Lcom/alibaba/fastjson/serializer/SerializerFeature;)I
    //   1928: istore #5
    //   1930: aload #13
    //   1932: invokeinterface name : ()Ljava/lang/String;
    //   1937: invokevirtual length : ()I
    //   1940: ifeq -> 1952
    //   1943: aload #13
    //   1945: invokeinterface name : ()Ljava/lang/String;
    //   1950: astore #7
    //   1952: goto -> 1961
    //   1955: iconst_0
    //   1956: istore #4
    //   1958: iconst_0
    //   1959: istore #5
    //   1961: aload #10
    //   1963: new com/alibaba/fastjson/util/FieldInfo
    //   1966: dup
    //   1967: aload #7
    //   1969: aconst_null
    //   1970: aload #9
    //   1972: aload_0
    //   1973: aload_1
    //   1974: iload #4
    //   1976: iload #5
    //   1978: aconst_null
    //   1979: aload #13
    //   1981: aconst_null
    //   1982: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   1985: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   1988: pop
    //   1989: iload_3
    //   1990: iconst_1
    //   1991: iadd
    //   1992: istore_3
    //   1993: goto -> 1799
    //   1996: aload_0
    //   1997: invokevirtual getMethods : ()[Ljava/lang/reflect/Method;
    //   2000: astore #8
    //   2002: aload #8
    //   2004: arraylength
    //   2005: istore #4
    //   2007: iconst_0
    //   2008: istore_3
    //   2009: iload_3
    //   2010: iload #4
    //   2012: if_icmpge -> 2281
    //   2015: aload #8
    //   2017: iload_3
    //   2018: aaload
    //   2019: astore #9
    //   2021: aload #9
    //   2023: invokevirtual getName : ()Ljava/lang/String;
    //   2026: astore #7
    //   2028: aload #7
    //   2030: invokevirtual length : ()I
    //   2033: iconst_4
    //   2034: if_icmpge -> 2040
    //   2037: goto -> 2274
    //   2040: aload #9
    //   2042: invokevirtual getModifiers : ()I
    //   2045: invokestatic isStatic : (I)Z
    //   2048: ifeq -> 2054
    //   2051: goto -> 2037
    //   2054: aload #7
    //   2056: ldc_w 'get'
    //   2059: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   2062: ifeq -> 2037
    //   2065: aload #7
    //   2067: iconst_3
    //   2068: invokevirtual charAt : (I)C
    //   2071: invokestatic isUpperCase : (C)Z
    //   2074: ifeq -> 2037
    //   2077: aload #9
    //   2079: invokevirtual getParameterTypes : ()[Ljava/lang/Class;
    //   2082: arraylength
    //   2083: ifeq -> 2089
    //   2086: goto -> 2037
    //   2089: ldc_w java/util/Collection
    //   2092: aload #9
    //   2094: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   2097: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   2100: ifne -> 2150
    //   2103: ldc_w java/util/Map
    //   2106: aload #9
    //   2108: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   2111: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   2114: ifne -> 2150
    //   2117: ldc_w java/util/concurrent/atomic/AtomicBoolean
    //   2120: aload #9
    //   2122: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   2125: if_acmpeq -> 2150
    //   2128: ldc_w java/util/concurrent/atomic/AtomicInteger
    //   2131: aload #9
    //   2133: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   2136: if_acmpeq -> 2150
    //   2139: ldc_w java/util/concurrent/atomic/AtomicLong
    //   2142: aload #9
    //   2144: invokevirtual getReturnType : ()Ljava/lang/Class;
    //   2147: if_acmpne -> 2037
    //   2150: aload #9
    //   2152: ldc com/alibaba/fastjson/annotation/JSONField
    //   2154: invokevirtual getAnnotation : (Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
    //   2157: checkcast com/alibaba/fastjson/annotation/JSONField
    //   2160: astore #13
    //   2162: aload #13
    //   2164: ifnull -> 2192
    //   2167: aload #13
    //   2169: invokeinterface name : ()Ljava/lang/String;
    //   2174: invokevirtual length : ()I
    //   2177: ifle -> 2192
    //   2180: aload #13
    //   2182: invokeinterface name : ()Ljava/lang/String;
    //   2187: astore #7
    //   2189: goto -> 2235
    //   2192: new java/lang/StringBuilder
    //   2195: dup
    //   2196: invokespecial <init> : ()V
    //   2199: astore #14
    //   2201: aload #14
    //   2203: aload #7
    //   2205: iconst_3
    //   2206: invokevirtual charAt : (I)C
    //   2209: invokestatic toLowerCase : (C)C
    //   2212: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   2215: pop
    //   2216: aload #14
    //   2218: aload #7
    //   2220: iconst_4
    //   2221: invokevirtual substring : (I)Ljava/lang/String;
    //   2224: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2227: pop
    //   2228: aload #14
    //   2230: invokevirtual toString : ()Ljava/lang/String;
    //   2233: astore #7
    //   2235: aload #10
    //   2237: aload #7
    //   2239: invokestatic getField : (Ljava/util/List;Ljava/lang/String;)Lcom/alibaba/fastjson/util/FieldInfo;
    //   2242: ifnull -> 2248
    //   2245: goto -> 2037
    //   2248: aload #10
    //   2250: new com/alibaba/fastjson/util/FieldInfo
    //   2253: dup
    //   2254: aload #7
    //   2256: aload #9
    //   2258: aconst_null
    //   2259: aload_0
    //   2260: aload_1
    //   2261: iconst_0
    //   2262: iconst_0
    //   2263: aload #13
    //   2265: aconst_null
    //   2266: aconst_null
    //   2267: invokespecial <init> : (Ljava/lang/String;Ljava/lang/reflect/Method;Ljava/lang/reflect/Field;Ljava/lang/Class;Ljava/lang/reflect/Type;IILcom/alibaba/fastjson/annotation/JSONField;Lcom/alibaba/fastjson/annotation/JSONField;Ljava/lang/String;)V
    //   2270: invokestatic add : (Ljava/util/List;Lcom/alibaba/fastjson/util/FieldInfo;)Z
    //   2273: pop
    //   2274: iload_3
    //   2275: iconst_1
    //   2276: iadd
    //   2277: istore_3
    //   2278: goto -> 2009
    //   2281: new com/alibaba/fastjson/util/JavaBeanInfo
    //   2284: dup
    //   2285: aload_0
    //   2286: aload #15
    //   2288: aload #18
    //   2290: aconst_null
    //   2291: aconst_null
    //   2292: aload #11
    //   2294: aload #12
    //   2296: aload #10
    //   2298: invokespecial <init> : (Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Constructor;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Lcom/alibaba/fastjson/annotation/JSONType;Ljava/util/List;)V
    //   2301: areturn
    //   2302: astore #9
    //   2304: goto -> 1067
    //   2307: astore #10
    //   2309: aload #9
    //   2311: astore #10
    //   2313: goto -> 1096
    // Exception table:
    //   from	to	target	type
    //   1051	1064	2302	java/lang/NoSuchMethodException
    //   1051	1064	2302	java/lang/SecurityException
    //   1079	1093	2307	java/lang/NoSuchMethodException
    //   1079	1093	2307	java/lang/SecurityException
  }
  
  public static Class<?> getBuilderClass(JSONType paramJSONType) {
    if (paramJSONType == null)
      return null; 
    Class<Void> clazz = paramJSONType.builder();
    return (clazz == Void.class) ? null : clazz;
  }
  
  public static Constructor<?> getCreatorConstructor(Class<?> paramClass) {
    Constructor<JSONCreator> constructor;
    Constructor[] arrayOfConstructor = (Constructor[])paramClass.getDeclaredConstructors();
    int j = arrayOfConstructor.length;
    paramClass = null;
    int i = 0;
    while (i < j) {
      Constructor<JSONCreator> constructor1;
      Constructor<JSONCreator> constructor2 = arrayOfConstructor[i];
      Class<?> clazz = paramClass;
      if ((JSONCreator)constructor2.<JSONCreator>getAnnotation(JSONCreator.class) != null)
        if (paramClass == null) {
          constructor1 = constructor2;
        } else {
          throw new JSONException("multi-JSONCreator");
        }  
      i++;
      constructor = constructor1;
    } 
    return constructor;
  }
  
  static Constructor<?> getDefaultConstructor(Class<?> paramClass) {
    Constructor<?> constructor1;
    boolean bool = Modifier.isAbstract(paramClass.getModifiers());
    Constructor<?> constructor2 = null;
    if (bool)
      return null; 
    Constructor[] arrayOfConstructor = (Constructor[])paramClass.getDeclaredConstructors();
    int j = arrayOfConstructor.length;
    int i = 0;
    while (true) {
      constructor1 = constructor2;
      if (i < j) {
        constructor1 = arrayOfConstructor[i];
        if ((constructor1.getParameterTypes()).length == 0)
          break; 
        i++;
        continue;
      } 
      break;
    } 
    if (constructor1 == null && paramClass.isMemberClass() && !Modifier.isStatic(paramClass.getModifiers())) {
      j = arrayOfConstructor.length;
      for (i = 0; i < j; i++) {
        constructor2 = arrayOfConstructor[i];
        Class[] arrayOfClass = constructor2.getParameterTypes();
        if (arrayOfClass.length == 1 && arrayOfClass[0].equals(paramClass.getDeclaringClass()))
          return constructor2; 
      } 
    } 
    return constructor1;
  }
  
  private static Method getFactoryMethod(Class<?> paramClass, Method[] paramArrayOfMethod) {
    int j = paramArrayOfMethod.length;
    Method method = null;
    int i = 0;
    while (i < j) {
      Method method1;
      Method method2 = paramArrayOfMethod[i];
      if (!Modifier.isStatic(method2.getModifiers())) {
        method1 = method;
      } else if (!paramClass.isAssignableFrom(method2.getReturnType())) {
        method1 = method;
      } else {
        method1 = method;
        if ((JSONCreator)method2.<JSONCreator>getAnnotation(JSONCreator.class) != null)
          if (method == null) {
            method1 = method2;
          } else {
            throw new JSONException("multi-JSONCreator");
          }  
      } 
      i++;
      method = method1;
    } 
    return method;
  }
  
  private static FieldInfo getField(List<FieldInfo> paramList, String paramString) {
    for (FieldInfo fieldInfo : paramList) {
      if (fieldInfo.name.equals(paramString))
        return fieldInfo; 
    } 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjso\\util\JavaBeanInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */