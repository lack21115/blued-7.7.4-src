package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FastParser<T extends FastJsonResponse> {
  private static final char[] zaf = new char[] { 'u', 'l', 'l' };
  
  private static final char[] zag = new char[] { 'r', 'u', 'e' };
  
  private static final char[] zah = new char[] { 'r', 'u', 'e', '"' };
  
  private static final char[] zai = new char[] { 'a', 'l', 's', 'e' };
  
  private static final char[] zaj = new char[] { 'a', 'l', 's', 'e', '"' };
  
  private static final char[] zak = new char[] { '\n' };
  
  private static final zaa<Integer> zam = new zaa();
  
  private static final zaa<Long> zan = new zac();
  
  private static final zaa<Float> zao = new zab();
  
  private static final zaa<Double> zap = new zae();
  
  private static final zaa<Boolean> zaq = new zad();
  
  private static final zaa<String> zar = new zag();
  
  private static final zaa<BigInteger> zas = new zaf();
  
  private static final zaa<BigDecimal> zat = new zah();
  
  private final char[] zaa = new char[1];
  
  private final char[] zab = new char[32];
  
  private final char[] zac = new char[1024];
  
  private final StringBuilder zad = new StringBuilder(32);
  
  private final StringBuilder zae = new StringBuilder(1024);
  
  private final Stack<Integer> zal = new Stack<Integer>();
  
  private final int zaa(BufferedReader paramBufferedReader, char[] paramArrayOfchar) throws ParseException, IOException {
    char c = zaj(paramBufferedReader);
    if (c != '\000') {
      if (c != ',') {
        int i;
        if (c == 'n') {
          zab(paramBufferedReader, zaf);
          return 0;
        } 
        paramBufferedReader.mark(1024);
        if (c == '"') {
          int j = 0;
          int k = 0;
          while (true) {
            i = j;
            if (j < paramArrayOfchar.length) {
              i = j;
              if (paramBufferedReader.read(paramArrayOfchar, j, 1) != -1) {
                c = paramArrayOfchar[j];
                if (!Character.isISOControl(c)) {
                  if (c == '"' && !k) {
                    paramBufferedReader.reset();
                    paramBufferedReader.skip((j + 1));
                    return j;
                  } 
                  if (c == '\\') {
                    k ^= 0x1;
                  } else {
                    k = 0;
                  } 
                  j++;
                  continue;
                } 
                throw new ParseException("Unexpected control character while reading string");
              } 
            } 
            break;
          } 
        } else {
          paramArrayOfchar[0] = c;
          int j = 1;
          while (true) {
            i = j;
            if (j < paramArrayOfchar.length) {
              i = j;
              if (paramBufferedReader.read(paramArrayOfchar, j, 1) != -1) {
                if (paramArrayOfchar[j] == '}' || paramArrayOfchar[j] == ',' || Character.isWhitespace(paramArrayOfchar[j]) || paramArrayOfchar[j] == ']') {
                  paramBufferedReader.reset();
                  paramBufferedReader.skip((j - 1));
                  paramArrayOfchar[j] = Character.MIN_VALUE;
                  return j;
                } 
                j++;
                continue;
              } 
            } 
            break;
          } 
        } 
        if (i == paramArrayOfchar.length)
          throw new ParseException("Absurdly long value"); 
        throw new ParseException("Unexpected EOF");
      } 
      throw new ParseException("Missing value");
    } 
    throw new ParseException("Unexpected EOF");
  }
  
  private final String zaa(BufferedReader paramBufferedReader) throws ParseException, IOException {
    StringBuilder stringBuilder;
    this.zal.push(Integer.valueOf(2));
    char c = zaj(paramBufferedReader);
    if (c != '"') {
      if (c != ']') {
        if (c == '}') {
          zaa(2);
          return null;
        } 
        stringBuilder = new StringBuilder(19);
        stringBuilder.append("Unexpected token: ");
        stringBuilder.append(c);
        throw new ParseException(stringBuilder.toString());
      } 
      zaa(2);
      zaa(1);
      zaa(5);
      return null;
    } 
    this.zal.push(Integer.valueOf(3));
    String str = zab((BufferedReader)stringBuilder, this.zab, this.zad, null);
    zaa(3);
    if (zaj((BufferedReader)stringBuilder) == ':')
      return str; 
    throw new ParseException("Expected key/value separator");
  }
  
  private final String zaa(BufferedReader paramBufferedReader, char[] paramArrayOfchar1, StringBuilder paramStringBuilder, char[] paramArrayOfchar2) throws ParseException, IOException {
    char c = zaj(paramBufferedReader);
    if (c != '"') {
      if (c == 'n') {
        zab(paramBufferedReader, zaf);
        return null;
      } 
      throw new ParseException("Expected string");
    } 
    return zab(paramBufferedReader, paramArrayOfchar1, paramStringBuilder, paramArrayOfchar2);
  }
  
  private final <T extends FastJsonResponse> ArrayList<T> zaa(BufferedReader paramBufferedReader, FastJsonResponse.Field<?, ?> paramField) throws ParseException, IOException {
    ArrayList<FastJsonResponse> arrayList = new ArrayList();
    char c = zaj(paramBufferedReader);
    if (c != ']') {
      StringBuilder stringBuilder;
      if (c != 'n') {
        if (c == '{') {
          this.zal.push(Integer.valueOf(1));
          try {
            while (true) {
              FastJsonResponse fastJsonResponse = paramField.zac();
              if (zaa(paramBufferedReader, fastJsonResponse)) {
                StringBuilder stringBuilder1;
                arrayList.add(fastJsonResponse);
                c = zaj(paramBufferedReader);
                if (c != ',') {
                  if (c == ']') {
                    zaa(5);
                    return (ArrayList)arrayList;
                  } 
                  stringBuilder1 = new StringBuilder(19);
                  stringBuilder1.append("Unexpected token: ");
                  stringBuilder1.append(c);
                  throw new ParseException(stringBuilder1.toString());
                } 
                if (zaj((BufferedReader)stringBuilder1) == '{') {
                  this.zal.push(Integer.valueOf(1));
                  continue;
                } 
                throw new ParseException("Expected start of next object in array");
              } 
              return (ArrayList)arrayList;
            } 
          } catch (InstantiationException instantiationException) {
            throw new ParseException("Error instantiating inner object", instantiationException);
          } catch (IllegalAccessException illegalAccessException) {
            throw new ParseException("Error instantiating inner object", illegalAccessException);
          } 
        } 
        stringBuilder = new StringBuilder(19);
        stringBuilder.append("Unexpected token: ");
        stringBuilder.append(c);
        throw new ParseException(stringBuilder.toString());
      } 
      zab((BufferedReader)stringBuilder, zaf);
      zaa(5);
      return null;
    } 
    zaa(5);
    return (ArrayList)arrayList;
  }
  
  private final <O> ArrayList<O> zaa(BufferedReader paramBufferedReader, zaa<O> paramzaa) throws ParseException, IOException {
    char c = zaj(paramBufferedReader);
    if (c == 'n') {
      zab(paramBufferedReader, zaf);
      return null;
    } 
    if (c == '[') {
      this.zal.push(Integer.valueOf(5));
      ArrayList<O> arrayList = new ArrayList();
      while (true) {
        paramBufferedReader.mark(1024);
        c = zaj(paramBufferedReader);
        if (c != '\000') {
          if (c != ',') {
            if (c != ']') {
              paramBufferedReader.reset();
              arrayList.add(paramzaa.zaa(this, paramBufferedReader));
              continue;
            } 
            zaa(5);
            return arrayList;
          } 
          continue;
        } 
        throw new ParseException("Unexpected EOF");
      } 
    } 
    throw new ParseException("Expected start of array");
  }
  
  private final void zaa(int paramInt) throws ParseException {
    if (!this.zal.isEmpty()) {
      int i = ((Integer)this.zal.pop()).intValue();
      if (i == paramInt)
        return; 
      StringBuilder stringBuilder1 = new StringBuilder(46);
      stringBuilder1.append("Expected state ");
      stringBuilder1.append(paramInt);
      stringBuilder1.append(" but had ");
      stringBuilder1.append(i);
      throw new ParseException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder(46);
    stringBuilder.append("Expected state ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" but had empty stack");
    throw new ParseException(stringBuilder.toString());
  }
  
  private final boolean zaa(BufferedReader paramBufferedReader, FastJsonResponse paramFastJsonResponse) throws ParseException, IOException {
    Map<String, FastJsonResponse.Field<?, ?>> map = paramFastJsonResponse.getFieldMappings();
    String str = zaa(paramBufferedReader);
    Integer integer = Integer.valueOf(1);
    if (str == null) {
      zaa(1);
      return false;
    } 
    while (str != null) {
      StringBuilder stringBuilder2;
      StringBuilder stringBuilder1;
      int i;
      HashMap<Object, Object> hashMap;
      FastJsonResponse.Field<?, ?> field = map.get(str);
      if (field == null) {
        str = zab(paramBufferedReader);
        continue;
      } 
      this.zal.push(Integer.valueOf(4));
      switch (field.zaa) {
        default:
          i = field.zaa;
          stringBuilder2 = new StringBuilder(30);
          stringBuilder2.append("Invalid field type ");
          stringBuilder2.append(i);
          throw new ParseException(stringBuilder2.toString());
        case 11:
          if (field.zab) {
            i = zaj((BufferedReader)stringBuilder2);
            if (i == 110) {
              zab((BufferedReader)stringBuilder2, zaf);
              paramFastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, null);
              break;
            } 
            this.zal.push(Integer.valueOf(5));
            if (i == 91) {
              paramFastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, zaa((BufferedReader)stringBuilder2, field));
              break;
            } 
            throw new ParseException("Expected array start");
          } 
          i = zaj((BufferedReader)stringBuilder2);
          if (i == 110) {
            zab((BufferedReader)stringBuilder2, zaf);
            paramFastJsonResponse.addConcreteTypeInternal(field, field.zae, null);
            break;
          } 
          this.zal.push(integer);
          if (i == 123) {
            try {
              FastJsonResponse fastJsonResponse = field.zac();
              zaa((BufferedReader)stringBuilder2, fastJsonResponse);
              paramFastJsonResponse.addConcreteTypeInternal(field, field.zae, fastJsonResponse);
            } catch (InstantiationException instantiationException) {
              throw new ParseException("Error instantiating inner object", instantiationException);
            } catch (IllegalAccessException illegalAccessException) {
              throw new ParseException("Error instantiating inner object", illegalAccessException);
            } 
            break;
          } 
          throw new ParseException("Expected start of object");
        case 10:
          i = zaj((BufferedReader)illegalAccessException);
          if (i == 110) {
            zab((BufferedReader)illegalAccessException, zaf);
            str = null;
          } else {
            if (i == 123) {
              this.zal.push(integer);
              hashMap = new HashMap<Object, Object>();
              while (true) {
                i = zaj((BufferedReader)illegalAccessException);
                if (i != 0) {
                  String str2;
                  if (i != 34) {
                    if (i != 125)
                      continue; 
                    zaa(1);
                    continue;
                  } 
                  String str3 = zab((BufferedReader)illegalAccessException, this.zab, this.zad, null);
                  if (zaj((BufferedReader)illegalAccessException) != ':') {
                    str2 = String.valueOf(str3);
                    if (str2.length() != 0) {
                      str2 = "No map value found for key ".concat(str2);
                    } else {
                      str2 = new String("No map value found for key ");
                    } 
                    throw new ParseException(str2);
                  } 
                  if (zaj((BufferedReader)str2) != '"') {
                    str2 = String.valueOf(str3);
                    if (str2.length() != 0) {
                      str2 = "Expected String value for key ".concat(str2);
                    } else {
                      str2 = new String("Expected String value for key ");
                    } 
                    throw new ParseException(str2);
                  } 
                  hashMap.put(str3, zab((BufferedReader)str2, this.zab, this.zad, null));
                  char c1 = zaj((BufferedReader)str2);
                  if (c1 != ',') {
                    if (c1 == '}') {
                      zaa(1);
                    } else {
                      stringBuilder1 = new StringBuilder(48);
                      stringBuilder1.append("Unexpected character while parsing string map: ");
                      stringBuilder1.append(c1);
                      throw new ParseException(stringBuilder1.toString());
                    } 
                  } else {
                    continue;
                  } 
                } else {
                  throw new ParseException("Unexpected EOF");
                } 
                paramFastJsonResponse.zaa((FastJsonResponse.Field)field, (Map)hashMap);
                break;
              } 
            } 
            throw new ParseException("Expected start of a map object");
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, (Map)hashMap);
          break;
        case 9:
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, Base64Utils.decodeUrlSafe(zaa((BufferedReader)stringBuilder1, this.zac, this.zae, zak)));
          break;
        case 8:
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, Base64Utils.decode(zaa((BufferedReader)stringBuilder1, this.zac, this.zae, zak)));
          break;
        case 7:
          if (field.zab) {
            paramFastJsonResponse.zah((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zar));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zac((BufferedReader)stringBuilder1));
          break;
        case 6:
          if (field.zab) {
            paramFastJsonResponse.zag((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zaq));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, false));
          break;
        case 5:
          if (field.zab) {
            paramFastJsonResponse.zaf((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zat));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zai((BufferedReader)stringBuilder1));
          break;
        case 4:
          if (field.zab) {
            paramFastJsonResponse.zae((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zap));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zah((BufferedReader)stringBuilder1));
          break;
        case 3:
          if (field.zab) {
            paramFastJsonResponse.zad((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zao));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zag((BufferedReader)stringBuilder1));
          break;
        case 2:
          if (field.zab) {
            paramFastJsonResponse.zac((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zan));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zae((BufferedReader)stringBuilder1));
          break;
        case 1:
          if (field.zab) {
            paramFastJsonResponse.zab((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zas));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zaf((BufferedReader)stringBuilder1));
          break;
        case 0:
          if (field.zab) {
            paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zaa((BufferedReader)stringBuilder1, zam));
            break;
          } 
          paramFastJsonResponse.zaa((FastJsonResponse.Field)field, zad((BufferedReader)stringBuilder1));
          break;
      } 
      zaa(4);
      zaa(2);
      char c = zaj((BufferedReader)stringBuilder1);
      if (c != ',') {
        if (c == '}') {
          hashMap = null;
          continue;
        } 
        stringBuilder1 = new StringBuilder(55);
        stringBuilder1.append("Expected end of object or field separator, but found: ");
        stringBuilder1.append(c);
        throw new ParseException(stringBuilder1.toString());
      } 
      String str1 = zaa((BufferedReader)stringBuilder1);
    } 
    zaa(1);
    return true;
  }
  
  private final boolean zaa(BufferedReader paramBufferedReader, boolean paramBoolean) throws ParseException, IOException {
    while (true) {
      char c = zaj(paramBufferedReader);
      if (c != '"') {
        StringBuilder stringBuilder;
        char[] arrayOfChar;
        if (c != 'f') {
          if (c != 'n') {
            if (c == 't') {
              if (paramBoolean) {
                arrayOfChar = zah;
              } else {
                arrayOfChar = zag;
              } 
              zab(paramBufferedReader, arrayOfChar);
              return true;
            } 
            stringBuilder = new StringBuilder(19);
            stringBuilder.append("Unexpected token: ");
            stringBuilder.append(c);
            throw new ParseException(stringBuilder.toString());
          } 
          zab((BufferedReader)stringBuilder, zaf);
          return false;
        } 
        if (paramBoolean) {
          arrayOfChar = zaj;
        } else {
          arrayOfChar = zai;
        } 
        zab((BufferedReader)stringBuilder, arrayOfChar);
        return false;
      } 
      if (!paramBoolean) {
        paramBoolean = true;
        continue;
      } 
      throw new ParseException("No boolean value found in string");
    } 
  }
  
  private final String zab(BufferedReader paramBufferedReader) throws ParseException, IOException {
    // Byte code:
    //   0: aload_1
    //   1: sipush #1024
    //   4: invokevirtual mark : (I)V
    //   7: aload_0
    //   8: aload_1
    //   9: invokespecial zaj : (Ljava/io/BufferedReader;)C
    //   12: istore_3
    //   13: iload_3
    //   14: bipush #34
    //   16: if_icmpeq -> 375
    //   19: iload_3
    //   20: bipush #44
    //   22: if_icmpeq -> 365
    //   25: iconst_1
    //   26: istore #4
    //   28: iload_3
    //   29: bipush #91
    //   31: if_icmpeq -> 163
    //   34: iload_3
    //   35: bipush #123
    //   37: if_icmpeq -> 57
    //   40: aload_1
    //   41: invokevirtual reset : ()V
    //   44: aload_0
    //   45: aload_1
    //   46: aload_0
    //   47: getfield zac : [C
    //   50: invokespecial zaa : (Ljava/io/BufferedReader;[C)I
    //   53: pop
    //   54: goto -> 411
    //   57: aload_0
    //   58: getfield zal : Ljava/util/Stack;
    //   61: iconst_1
    //   62: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   65: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   68: pop
    //   69: aload_1
    //   70: bipush #32
    //   72: invokevirtual mark : (I)V
    //   75: aload_0
    //   76: aload_1
    //   77: invokespecial zaj : (Ljava/io/BufferedReader;)C
    //   80: istore_2
    //   81: iload_2
    //   82: bipush #125
    //   84: if_icmpne -> 95
    //   87: aload_0
    //   88: iconst_1
    //   89: invokespecial zaa : (I)V
    //   92: goto -> 411
    //   95: iload_2
    //   96: bipush #34
    //   98: if_icmpne -> 127
    //   101: aload_1
    //   102: invokevirtual reset : ()V
    //   105: aload_0
    //   106: aload_1
    //   107: invokespecial zaa : (Ljava/io/BufferedReader;)Ljava/lang/String;
    //   110: pop
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial zab : (Ljava/io/BufferedReader;)Ljava/lang/String;
    //   116: ifnonnull -> 111
    //   119: aload_0
    //   120: iconst_1
    //   121: invokespecial zaa : (I)V
    //   124: goto -> 411
    //   127: new java/lang/StringBuilder
    //   130: dup
    //   131: bipush #18
    //   133: invokespecial <init> : (I)V
    //   136: astore_1
    //   137: aload_1
    //   138: ldc_w 'Unexpected token '
    //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_1
    //   146: iload_2
    //   147: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   154: dup
    //   155: aload_1
    //   156: invokevirtual toString : ()Ljava/lang/String;
    //   159: invokespecial <init> : (Ljava/lang/String;)V
    //   162: athrow
    //   163: aload_0
    //   164: getfield zal : Ljava/util/Stack;
    //   167: iconst_5
    //   168: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   171: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   174: pop
    //   175: aload_1
    //   176: bipush #32
    //   178: invokevirtual mark : (I)V
    //   181: aload_0
    //   182: aload_1
    //   183: invokespecial zaj : (Ljava/io/BufferedReader;)C
    //   186: bipush #93
    //   188: if_icmpne -> 199
    //   191: aload_0
    //   192: iconst_5
    //   193: invokespecial zaa : (I)V
    //   196: goto -> 411
    //   199: aload_1
    //   200: invokevirtual reset : ()V
    //   203: iconst_0
    //   204: istore_3
    //   205: iconst_0
    //   206: istore #5
    //   208: iload #4
    //   210: ifle -> 357
    //   213: aload_0
    //   214: aload_1
    //   215: invokespecial zaj : (Ljava/io/BufferedReader;)C
    //   218: istore_2
    //   219: iload_2
    //   220: ifeq -> 346
    //   223: iload_2
    //   224: invokestatic isISOControl : (C)Z
    //   227: ifne -> 335
    //   230: iload #5
    //   232: istore #6
    //   234: iload_2
    //   235: bipush #34
    //   237: if_icmpne -> 254
    //   240: iload #5
    //   242: istore #6
    //   244: iload_3
    //   245: ifne -> 254
    //   248: iload #5
    //   250: iconst_1
    //   251: ixor
    //   252: istore #6
    //   254: iload #4
    //   256: istore #5
    //   258: iload_2
    //   259: bipush #91
    //   261: if_icmpne -> 279
    //   264: iload #4
    //   266: istore #5
    //   268: iload #6
    //   270: ifne -> 279
    //   273: iload #4
    //   275: iconst_1
    //   276: iadd
    //   277: istore #5
    //   279: iload #5
    //   281: istore #4
    //   283: iload_2
    //   284: bipush #93
    //   286: if_icmpne -> 304
    //   289: iload #5
    //   291: istore #4
    //   293: iload #6
    //   295: ifne -> 304
    //   298: iload #5
    //   300: iconst_1
    //   301: isub
    //   302: istore #4
    //   304: iload_2
    //   305: bipush #92
    //   307: if_icmpne -> 326
    //   310: iload #6
    //   312: ifeq -> 326
    //   315: iload_3
    //   316: iconst_1
    //   317: ixor
    //   318: istore_3
    //   319: iload #6
    //   321: istore #5
    //   323: goto -> 208
    //   326: iconst_0
    //   327: istore_3
    //   328: iload #6
    //   330: istore #5
    //   332: goto -> 208
    //   335: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   338: dup
    //   339: ldc_w 'Unexpected control character while reading array'
    //   342: invokespecial <init> : (Ljava/lang/String;)V
    //   345: athrow
    //   346: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   349: dup
    //   350: ldc_w 'Unexpected EOF while parsing array'
    //   353: invokespecial <init> : (Ljava/lang/String;)V
    //   356: athrow
    //   357: aload_0
    //   358: iconst_5
    //   359: invokespecial zaa : (I)V
    //   362: goto -> 411
    //   365: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   368: dup
    //   369: ldc 'Missing value'
    //   371: invokespecial <init> : (Ljava/lang/String;)V
    //   374: athrow
    //   375: aload_1
    //   376: aload_0
    //   377: getfield zaa : [C
    //   380: invokevirtual read : ([C)I
    //   383: iconst_m1
    //   384: if_icmpeq -> 552
    //   387: aload_0
    //   388: getfield zaa : [C
    //   391: iconst_0
    //   392: caload
    //   393: istore #4
    //   395: iconst_0
    //   396: istore_3
    //   397: iload #4
    //   399: bipush #34
    //   401: if_icmpne -> 483
    //   404: iload_3
    //   405: ifeq -> 411
    //   408: goto -> 483
    //   411: aload_0
    //   412: aload_1
    //   413: invokespecial zaj : (Ljava/io/BufferedReader;)C
    //   416: istore_2
    //   417: iload_2
    //   418: bipush #44
    //   420: if_icmpeq -> 472
    //   423: iload_2
    //   424: bipush #125
    //   426: if_icmpne -> 436
    //   429: aload_0
    //   430: iconst_2
    //   431: invokespecial zaa : (I)V
    //   434: aconst_null
    //   435: areturn
    //   436: new java/lang/StringBuilder
    //   439: dup
    //   440: bipush #18
    //   442: invokespecial <init> : (I)V
    //   445: astore_1
    //   446: aload_1
    //   447: ldc_w 'Unexpected token '
    //   450: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: aload_1
    //   455: iload_2
    //   456: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   463: dup
    //   464: aload_1
    //   465: invokevirtual toString : ()Ljava/lang/String;
    //   468: invokespecial <init> : (Ljava/lang/String;)V
    //   471: athrow
    //   472: aload_0
    //   473: iconst_2
    //   474: invokespecial zaa : (I)V
    //   477: aload_0
    //   478: aload_1
    //   479: invokespecial zaa : (Ljava/io/BufferedReader;)Ljava/lang/String;
    //   482: areturn
    //   483: iload #4
    //   485: bipush #92
    //   487: if_icmpne -> 497
    //   490: iload_3
    //   491: iconst_1
    //   492: ixor
    //   493: istore_3
    //   494: goto -> 499
    //   497: iconst_0
    //   498: istore_3
    //   499: aload_1
    //   500: aload_0
    //   501: getfield zaa : [C
    //   504: invokevirtual read : ([C)I
    //   507: iconst_m1
    //   508: if_icmpeq -> 541
    //   511: aload_0
    //   512: getfield zaa : [C
    //   515: iconst_0
    //   516: caload
    //   517: istore_2
    //   518: iload_2
    //   519: invokestatic isISOControl : (C)Z
    //   522: ifne -> 531
    //   525: iload_2
    //   526: istore #4
    //   528: goto -> 397
    //   531: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   534: dup
    //   535: ldc 'Unexpected control character while reading string'
    //   537: invokespecial <init> : (Ljava/lang/String;)V
    //   540: athrow
    //   541: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   544: dup
    //   545: ldc_w 'Unexpected EOF while parsing string'
    //   548: invokespecial <init> : (Ljava/lang/String;)V
    //   551: athrow
    //   552: new com/google/android/gms/common/server/response/FastParser$ParseException
    //   555: dup
    //   556: ldc_w 'Unexpected EOF while parsing string'
    //   559: invokespecial <init> : (Ljava/lang/String;)V
    //   562: athrow
  }
  
  private static String zab(BufferedReader paramBufferedReader, char[] paramArrayOfchar1, StringBuilder paramStringBuilder, char[] paramArrayOfchar2) throws ParseException, IOException {
    paramStringBuilder.setLength(0);
    paramBufferedReader.mark(paramArrayOfchar1.length);
    int i = 0;
    int j = 0;
    while (true) {
      int k = paramBufferedReader.read(paramArrayOfchar1);
      if (k != -1) {
        int m = i;
        int n = 0;
        i = j;
        j = m;
        label37: for (m = n; m < k; m++) {
          char c = paramArrayOfchar1[m];
          if (Character.isISOControl(c)) {
            if (paramArrayOfchar2 != null)
              for (n = 0; n < paramArrayOfchar2.length; n++) {
                if (paramArrayOfchar2[n] == c) {
                  n = 1;
                  continue label37;
                } 
              }  
            n = 0;
            if (n == 0)
              throw new ParseException("Unexpected control character while reading string"); 
          } 
          if (c == '"' && j == 0) {
            paramStringBuilder.append(paramArrayOfchar1, 0, m);
            paramBufferedReader.reset();
            paramBufferedReader.skip((m + 1));
            return (i != 0) ? JsonUtils.unescapeString(paramStringBuilder.toString()) : paramStringBuilder.toString();
          } 
          if (c == '\\') {
            j ^= 0x1;
            i = 1;
          } else {
            j = 0;
          } 
        } 
        paramStringBuilder.append(paramArrayOfchar1, 0, k);
        paramBufferedReader.mark(paramArrayOfchar1.length);
        m = i;
        i = j;
        j = m;
        continue;
      } 
      throw new ParseException("Unexpected EOF while parsing string");
    } 
  }
  
  private final void zab(BufferedReader paramBufferedReader, char[] paramArrayOfchar) throws ParseException, IOException {
    int i = 0;
    while (i < paramArrayOfchar.length) {
      int j = paramBufferedReader.read(this.zab, 0, paramArrayOfchar.length - i);
      if (j != -1) {
        int k = 0;
        while (k < j) {
          if (paramArrayOfchar[k + i] == this.zab[k]) {
            k++;
            continue;
          } 
          throw new ParseException("Unexpected character");
        } 
        i += j;
        continue;
      } 
      throw new ParseException("Unexpected EOF");
    } 
  }
  
  private final String zac(BufferedReader paramBufferedReader) throws ParseException, IOException {
    return zaa(paramBufferedReader, this.zab, this.zad, null);
  }
  
  private final int zad(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zac);
    if (i == 0)
      return 0; 
    char[] arrayOfChar = this.zac;
    if (i > 0) {
      int j;
      int k;
      boolean bool;
      int m;
      if (arrayOfChar[0] == '-') {
        j = 1;
        bool = true;
        m = Integer.MIN_VALUE;
      } else {
        j = 0;
        bool = false;
        m = -2147483647;
      } 
      if (j < i) {
        k = j + 1;
        j = Character.digit(arrayOfChar[j], 10);
        if (j >= 0) {
          int n = -j;
          j = k;
          k = n;
        } else {
          throw new ParseException("Unexpected non-digit character");
        } 
      } else {
        k = 0;
      } 
      while (j < i) {
        int n = Character.digit(arrayOfChar[j], 10);
        if (n >= 0) {
          if (k >= -214748364) {
            k *= 10;
            if (k >= m + n) {
              k -= n;
              j++;
              continue;
            } 
            throw new ParseException("Number too large");
          } 
          throw new ParseException("Number too large");
        } 
        throw new ParseException("Unexpected non-digit character");
      } 
      if (bool) {
        if (j > 1)
          return k; 
        throw new ParseException("No digits to parse");
      } 
      return -k;
    } 
    throw new ParseException("No number to parse");
  }
  
  private final long zae(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zac);
    if (i == 0)
      return 0L; 
    char[] arrayOfChar = this.zac;
    if (i > 0) {
      boolean bool;
      long l1;
      long l2;
      int j = 0;
      if (arrayOfChar[0] == '-') {
        l2 = Long.MIN_VALUE;
        j = 1;
        bool = true;
      } else {
        l2 = -9223372036854775807L;
        bool = false;
      } 
      if (j < i) {
        int k = j + 1;
        j = Character.digit(arrayOfChar[j], 10);
        if (j >= 0) {
          l1 = -j;
          j = k;
        } else {
          throw new ParseException("Unexpected non-digit character");
        } 
      } else {
        l1 = 0L;
      } 
      while (j < i) {
        int k = Character.digit(arrayOfChar[j], 10);
        if (k >= 0) {
          if (l1 >= -922337203685477580L) {
            l1 *= 10L;
            long l = k;
            if (l1 >= l2 + l) {
              l1 -= l;
              j++;
              continue;
            } 
            throw new ParseException("Number too large");
          } 
          throw new ParseException("Number too large");
        } 
        throw new ParseException("Unexpected non-digit character");
      } 
      if (bool) {
        if (j > 1)
          return l1; 
        throw new ParseException("No digits to parse");
      } 
      return -l1;
    } 
    throw new ParseException("No number to parse");
  }
  
  private final BigInteger zaf(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zac);
    return (i == 0) ? null : new BigInteger(new String(this.zac, 0, i));
  }
  
  private final float zag(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zac);
    return (i == 0) ? 0.0F : Float.parseFloat(new String(this.zac, 0, i));
  }
  
  private final double zah(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zac);
    return (i == 0) ? 0.0D : Double.parseDouble(new String(this.zac, 0, i));
  }
  
  private final BigDecimal zai(BufferedReader paramBufferedReader) throws ParseException, IOException {
    int i = zaa(paramBufferedReader, this.zac);
    return (i == 0) ? null : new BigDecimal(new String(this.zac, 0, i));
  }
  
  private final char zaj(BufferedReader paramBufferedReader) throws ParseException, IOException {
    if (paramBufferedReader.read(this.zaa) == -1)
      return Character.MIN_VALUE; 
    while (Character.isWhitespace(this.zaa[0])) {
      if (paramBufferedReader.read(this.zaa) == -1)
        return Character.MIN_VALUE; 
    } 
    return this.zaa[0];
  }
  
  public void parse(InputStream paramInputStream, T paramT) throws ParseException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(paramInputStream), 1024);
    try {
      this.zal.push(Integer.valueOf(0));
      char c = zaj(bufferedReader);
      if (c != '\000') {
        StringBuilder stringBuilder;
        if (c != '[') {
          if (c == '{') {
            this.zal.push(Integer.valueOf(1));
            zaa(bufferedReader, (FastJsonResponse)paramT);
          } else {
            stringBuilder = new StringBuilder(19);
            stringBuilder.append("Unexpected token: ");
            stringBuilder.append(c);
            throw new ParseException(stringBuilder.toString());
          } 
        } else {
          this.zal.push(Integer.valueOf(5));
          Map<String, FastJsonResponse.Field<?, ?>> map = stringBuilder.getFieldMappings();
          if (map.size() == 1) {
            FastJsonResponse.Field<?, ?> field = (FastJsonResponse.Field)((Map.Entry)map.entrySet().iterator().next()).getValue();
            ArrayList<FastJsonResponse> arrayList = zaa(bufferedReader, field);
            stringBuilder.addConcreteTypeArrayInternal(field, field.zae, arrayList);
          } else {
            throw new ParseException("Object array response class must have a single Field");
          } 
        } 
        zaa(0);
        try {
          bufferedReader.close();
          return;
        } catch (IOException iOException) {
          Log.w("FastParser", "Failed to close reader while parsing.");
          return;
        } 
      } 
      throw new ParseException("No data to parse");
    } catch (IOException iOException1) {
      throw new ParseException(iOException1);
    } finally {}
    try {
      iOException.close();
    } catch (IOException iOException1) {
      Log.w("FastParser", "Failed to close reader while parsing.");
    } 
    throw paramT;
  }
  
  public static class ParseException extends Exception {
    public ParseException(String param1String) {
      super(param1String);
    }
    
    public ParseException(String param1String, Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
    
    public ParseException(Throwable param1Throwable) {
      super(param1Throwable);
    }
  }
  
  static interface zaa<O> {
    O zaa(FastParser param1FastParser, BufferedReader param1BufferedReader) throws FastParser.ParseException, IOException;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\server\response\FastParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */