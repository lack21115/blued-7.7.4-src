package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.nio.charset.Charset;

public final class SerializeWriter extends Writer {
  private static final ThreadLocal<SoftReference<char[]>> bufLocal = new ThreadLocal<SoftReference<char[]>>();
  
  protected boolean beanToArray;
  
  protected boolean browserCompatible;
  
  protected boolean browserSecure;
  
  protected char[] buf;
  
  protected SoftReference<char[]> bufLocalRef;
  
  protected int count;
  
  protected boolean disableCheckSpecialChar;
  
  protected boolean disableCircularReferenceDetect;
  
  protected int features;
  
  protected boolean ignoreNonFieldGetter;
  
  protected char keySeperator;
  
  protected boolean notWriteDefaultValue;
  
  protected boolean notWriteRootClassName;
  
  protected boolean prettyFormat;
  
  protected boolean quoteFieldNames;
  
  protected boolean skipTransientField;
  
  protected boolean sortField;
  
  protected boolean useSingleQuotes;
  
  protected boolean writeClassName;
  
  protected boolean writeDirect;
  
  protected boolean writeEnumUsingName;
  
  protected boolean writeEnumUsingToString;
  
  protected boolean writeMapNullValue;
  
  protected boolean writeNonStringValueAsString;
  
  private final Writer writer;
  
  public SerializeWriter() {
    this((Writer)null);
  }
  
  public SerializeWriter(int paramInt) {
    this((Writer)null, paramInt);
  }
  
  public SerializeWriter(Writer paramWriter) {
    this.writer = paramWriter;
    this.features = JSON.DEFAULT_GENERATE_FEATURE;
    computeFeatures();
    this.bufLocalRef = bufLocal.get();
    SoftReference<char[]> softReference = this.bufLocalRef;
    if (softReference != null) {
      this.buf = softReference.get();
      bufLocal.set(null);
    } 
    if (this.buf == null)
      this.buf = new char[1024]; 
  }
  
  public SerializeWriter(Writer paramWriter, int paramInt) {
    this.writer = paramWriter;
    if (paramInt > 0) {
      this.buf = new char[paramInt];
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Negative initial size: ");
    stringBuilder.append(paramInt);
    throw new IllegalArgumentException(stringBuilder.toString());
  }
  
  public SerializeWriter(Writer paramWriter, int paramInt, SerializerFeature... paramVarArgs) {
    this.writer = paramWriter;
    this.bufLocalRef = bufLocal.get();
    SoftReference<char[]> softReference = this.bufLocalRef;
    if (softReference != null) {
      this.buf = softReference.get();
      bufLocal.set(null);
    } 
    if (this.buf == null)
      this.buf = new char[1024]; 
    int j = paramVarArgs.length;
    boolean bool = false;
    int i = paramInt;
    for (paramInt = bool; paramInt < j; paramInt++)
      i |= paramVarArgs[paramInt].getMask(); 
    this.features = i;
    computeFeatures();
  }
  
  public SerializeWriter(Writer paramWriter, SerializerFeature... paramVarArgs) {
    this(paramWriter, 0, paramVarArgs);
  }
  
  public SerializeWriter(SerializerFeature... paramVarArgs) {
    this((Writer)null, paramVarArgs);
  }
  
  static boolean isSpecial(char paramChar, int paramInt) {
    boolean bool = false;
    if (paramChar == ' ')
      return false; 
    if (paramChar == '/') {
      if ((SerializerFeature.WriteSlashAsSpecial.mask & paramInt) != 0)
        bool = true; 
      return bool;
    } 
    return (paramChar > '#' && paramChar != '\\') ? false : ((paramChar > '\037' && paramChar != '\\') ? ((paramChar == '"')) : true);
  }
  
  private void writeEnumFieldValue(char paramChar, String paramString1, String paramString2) {
    if (this.useSingleQuotes) {
      writeFieldValue(paramChar, paramString1, paramString2);
      return;
    } 
    writeFieldValueStringWithDoubleQuote(paramChar, paramString1, paramString2);
  }
  
  private void writeEnumValue(String paramString, char paramChar) {
    if (isEnabled(SerializerFeature.UseSingleQuotes)) {
      write(39);
      write(paramString);
      write(39);
      write(paramChar);
      return;
    } 
    write(34);
    write(paramString);
    write(34);
    write(paramChar);
  }
  
  private void writeKeyWithSingleQuoteIfHasSpecial(String paramString) {
    char[] arrayOfChar;
    byte[] arrayOfByte = IOUtils.specicalFlags_singleQuotes;
    int i1 = paramString.length();
    int i = this.count;
    int j = 1;
    int m = i + i1 + 1;
    i = this.buf.length;
    int k = 0;
    if (m > i) {
      if (this.writer != null) {
        if (i1 == 0) {
          write(39);
          write(39);
          write(58);
          return;
        } 
        i = 0;
        while (true) {
          if (i < i1) {
            m = paramString.charAt(i);
            if (m < arrayOfByte.length && arrayOfByte[m] != 0) {
              i = j;
              break;
            } 
            i++;
            continue;
          } 
          i = 0;
          break;
        } 
        j = k;
        if (i != 0) {
          write(39);
          j = k;
        } 
        while (j < i1) {
          k = paramString.charAt(j);
          if (k < arrayOfByte.length && arrayOfByte[k] != 0) {
            write(92);
            write(IOUtils.replaceChars[k]);
          } else {
            write(k);
          } 
          j++;
        } 
        if (i != 0)
          write(39); 
        write(58);
        return;
      } 
      expandCapacity(m);
    } 
    if (i1 == 0) {
      i = this.count;
      if (i + 3 > this.buf.length)
        expandCapacity(i + 3); 
      arrayOfChar = this.buf;
      i = this.count;
      this.count = i + 1;
      arrayOfChar[i] = '\'';
      i = this.count;
      this.count = i + 1;
      arrayOfChar[i] = '\'';
      i = this.count;
      this.count = i + 1;
      arrayOfChar[i] = ':';
      return;
    } 
    int n = this.count;
    k = n + i1;
    arrayOfChar.getChars(0, i1, this.buf, n);
    this.count = m;
    i = n;
    i1 = 0;
    j = m;
    m = i1;
    while (i < k) {
      arrayOfChar = this.buf;
      char c = arrayOfChar[i];
      if (c < arrayOfByte.length && arrayOfByte[c] != 0)
        if (m == 0) {
          j += 3;
          if (j > arrayOfChar.length)
            expandCapacity(j); 
          this.count = j;
          arrayOfChar = this.buf;
          m = i + 1;
          System.arraycopy(arrayOfChar, m, arrayOfChar, i + 3, k - i - 1);
          arrayOfChar = this.buf;
          System.arraycopy(arrayOfChar, 0, arrayOfChar, 1, i);
          arrayOfChar = this.buf;
          arrayOfChar[n] = '\'';
          arrayOfChar[m] = '\\';
          i = m + 1;
          arrayOfChar[i] = IOUtils.replaceChars[c];
          k += 2;
          this.buf[this.count - 2] = '\'';
          m = 1;
        } else {
          if (++j > arrayOfChar.length)
            expandCapacity(j); 
          this.count = j;
          arrayOfChar = this.buf;
          i1 = i + 1;
          System.arraycopy(arrayOfChar, i1, arrayOfChar, i + 2, k - i);
          arrayOfChar = this.buf;
          arrayOfChar[i] = '\\';
          arrayOfChar[i1] = IOUtils.replaceChars[c];
          k++;
          i = i1;
        }  
      i++;
    } 
    this.buf[j - 1] = ':';
  }
  
  public SerializeWriter append(char paramChar) {
    write(paramChar);
    return this;
  }
  
  public SerializeWriter append(CharSequence paramCharSequence) {
    if (paramCharSequence == null) {
      paramCharSequence = "null";
    } else {
      paramCharSequence = paramCharSequence.toString();
    } 
    write((String)paramCharSequence, 0, paramCharSequence.length());
    return this;
  }
  
  public SerializeWriter append(CharSequence paramCharSequence, int paramInt1, int paramInt2) {
    CharSequence charSequence = paramCharSequence;
    if (paramCharSequence == null)
      charSequence = "null"; 
    paramCharSequence = charSequence.subSequence(paramInt1, paramInt2).toString();
    write((String)paramCharSequence, 0, paramCharSequence.length());
    return this;
  }
  
  public void close() {
    if (this.writer != null && this.count > 0)
      flush(); 
    if (this.buf.length <= 8192) {
      SoftReference<char[]> softReference = this.bufLocalRef;
      if (softReference == null || softReference.get() != this.buf) {
        softReference = (SoftReference)new SoftReference<char>(this.buf);
      } else {
        softReference = this.bufLocalRef;
      } 
      bufLocal.set(softReference);
    } 
    this.buf = null;
  }
  
  protected void computeFeatures() {
    // Byte code:
    //   0: aload_0
    //   1: getfield features : I
    //   4: istore_2
    //   5: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BrowserSecure : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   8: getfield mask : I
    //   11: istore_3
    //   12: iconst_1
    //   13: istore #5
    //   15: iload_2
    //   16: iload_3
    //   17: iand
    //   18: ifeq -> 27
    //   21: iconst_1
    //   22: istore #4
    //   24: goto -> 30
    //   27: iconst_0
    //   28: istore #4
    //   30: aload_0
    //   31: iload #4
    //   33: putfield browserSecure : Z
    //   36: aload_0
    //   37: getfield features : I
    //   40: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BrowserCompatible : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   43: getfield mask : I
    //   46: iand
    //   47: ifeq -> 56
    //   50: iconst_1
    //   51: istore #4
    //   53: goto -> 59
    //   56: iconst_0
    //   57: istore #4
    //   59: aload_0
    //   60: iload #4
    //   62: putfield browserCompatible : Z
    //   65: aload_0
    //   66: getfield features : I
    //   69: getstatic com/alibaba/fastjson/serializer/SerializerFeature.QuoteFieldNames : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   72: getfield mask : I
    //   75: iand
    //   76: ifeq -> 85
    //   79: iconst_1
    //   80: istore #4
    //   82: goto -> 88
    //   85: iconst_0
    //   86: istore #4
    //   88: aload_0
    //   89: iload #4
    //   91: putfield quoteFieldNames : Z
    //   94: aload_0
    //   95: getfield features : I
    //   98: getstatic com/alibaba/fastjson/serializer/SerializerFeature.UseSingleQuotes : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   101: getfield mask : I
    //   104: iand
    //   105: ifeq -> 114
    //   108: iconst_1
    //   109: istore #4
    //   111: goto -> 117
    //   114: iconst_0
    //   115: istore #4
    //   117: aload_0
    //   118: iload #4
    //   120: putfield useSingleQuotes : Z
    //   123: aload_0
    //   124: getfield features : I
    //   127: getstatic com/alibaba/fastjson/serializer/SerializerFeature.SortField : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   130: getfield mask : I
    //   133: iand
    //   134: ifeq -> 143
    //   137: iconst_1
    //   138: istore #4
    //   140: goto -> 146
    //   143: iconst_0
    //   144: istore #4
    //   146: aload_0
    //   147: iload #4
    //   149: putfield sortField : Z
    //   152: aload_0
    //   153: getfield features : I
    //   156: getstatic com/alibaba/fastjson/serializer/SerializerFeature.DisableCircularReferenceDetect : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   159: getfield mask : I
    //   162: iand
    //   163: ifeq -> 172
    //   166: iconst_1
    //   167: istore #4
    //   169: goto -> 175
    //   172: iconst_0
    //   173: istore #4
    //   175: aload_0
    //   176: iload #4
    //   178: putfield disableCircularReferenceDetect : Z
    //   181: aload_0
    //   182: getfield features : I
    //   185: getstatic com/alibaba/fastjson/serializer/SerializerFeature.BeanToArray : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   188: getfield mask : I
    //   191: iand
    //   192: ifeq -> 201
    //   195: iconst_1
    //   196: istore #4
    //   198: goto -> 204
    //   201: iconst_0
    //   202: istore #4
    //   204: aload_0
    //   205: iload #4
    //   207: putfield beanToArray : Z
    //   210: aload_0
    //   211: getfield features : I
    //   214: getstatic com/alibaba/fastjson/serializer/SerializerFeature.PrettyFormat : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   217: getfield mask : I
    //   220: iand
    //   221: ifeq -> 230
    //   224: iconst_1
    //   225: istore #4
    //   227: goto -> 233
    //   230: iconst_0
    //   231: istore #4
    //   233: aload_0
    //   234: iload #4
    //   236: putfield prettyFormat : Z
    //   239: aload_0
    //   240: getfield features : I
    //   243: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteClassName : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   246: getfield mask : I
    //   249: iand
    //   250: ifeq -> 259
    //   253: iconst_1
    //   254: istore #4
    //   256: goto -> 262
    //   259: iconst_0
    //   260: istore #4
    //   262: aload_0
    //   263: iload #4
    //   265: putfield writeClassName : Z
    //   268: aload_0
    //   269: getfield features : I
    //   272: getstatic com/alibaba/fastjson/serializer/SerializerFeature.NotWriteRootClassName : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   275: getfield mask : I
    //   278: iand
    //   279: ifeq -> 288
    //   282: iconst_1
    //   283: istore #4
    //   285: goto -> 291
    //   288: iconst_0
    //   289: istore #4
    //   291: aload_0
    //   292: iload #4
    //   294: putfield notWriteRootClassName : Z
    //   297: aload_0
    //   298: getfield features : I
    //   301: getstatic com/alibaba/fastjson/serializer/SerializerFeature.SkipTransientField : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   304: getfield mask : I
    //   307: iand
    //   308: ifeq -> 317
    //   311: iconst_1
    //   312: istore #4
    //   314: goto -> 320
    //   317: iconst_0
    //   318: istore #4
    //   320: aload_0
    //   321: iload #4
    //   323: putfield skipTransientField : Z
    //   326: aload_0
    //   327: getfield features : I
    //   330: getstatic com/alibaba/fastjson/serializer/SerializerFeature.IgnoreNonFieldGetter : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   333: getfield mask : I
    //   336: iand
    //   337: ifeq -> 346
    //   340: iconst_1
    //   341: istore #4
    //   343: goto -> 349
    //   346: iconst_0
    //   347: istore #4
    //   349: aload_0
    //   350: iload #4
    //   352: putfield ignoreNonFieldGetter : Z
    //   355: aload_0
    //   356: getfield features : I
    //   359: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteNonStringValueAsString : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   362: getfield mask : I
    //   365: iand
    //   366: ifeq -> 375
    //   369: iconst_1
    //   370: istore #4
    //   372: goto -> 378
    //   375: iconst_0
    //   376: istore #4
    //   378: aload_0
    //   379: iload #4
    //   381: putfield writeNonStringValueAsString : Z
    //   384: aload_0
    //   385: getfield features : I
    //   388: getstatic com/alibaba/fastjson/serializer/SerializerFeature.NotWriteDefaultValue : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   391: getfield mask : I
    //   394: iand
    //   395: ifeq -> 404
    //   398: iconst_1
    //   399: istore #4
    //   401: goto -> 407
    //   404: iconst_0
    //   405: istore #4
    //   407: aload_0
    //   408: iload #4
    //   410: putfield notWriteDefaultValue : Z
    //   413: aload_0
    //   414: getfield features : I
    //   417: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteEnumUsingName : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   420: getfield mask : I
    //   423: iand
    //   424: ifeq -> 433
    //   427: iconst_1
    //   428: istore #4
    //   430: goto -> 436
    //   433: iconst_0
    //   434: istore #4
    //   436: aload_0
    //   437: iload #4
    //   439: putfield writeEnumUsingName : Z
    //   442: aload_0
    //   443: getfield features : I
    //   446: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteEnumUsingToString : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   449: getfield mask : I
    //   452: iand
    //   453: ifeq -> 462
    //   456: iconst_1
    //   457: istore #4
    //   459: goto -> 465
    //   462: iconst_0
    //   463: istore #4
    //   465: aload_0
    //   466: iload #4
    //   468: putfield writeEnumUsingToString : Z
    //   471: aload_0
    //   472: getfield features : I
    //   475: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteMapNullValue : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   478: getfield mask : I
    //   481: iand
    //   482: ifeq -> 491
    //   485: iconst_1
    //   486: istore #4
    //   488: goto -> 494
    //   491: iconst_0
    //   492: istore #4
    //   494: aload_0
    //   495: iload #4
    //   497: putfield writeMapNullValue : Z
    //   500: aload_0
    //   501: getfield features : I
    //   504: getstatic com/alibaba/fastjson/serializer/SerializerFeature.DisableCheckSpecialChar : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   507: getfield mask : I
    //   510: iand
    //   511: ifeq -> 520
    //   514: iconst_1
    //   515: istore #4
    //   517: goto -> 523
    //   520: iconst_0
    //   521: istore #4
    //   523: aload_0
    //   524: iload #4
    //   526: putfield disableCheckSpecialChar : Z
    //   529: aload_0
    //   530: getfield quoteFieldNames : Z
    //   533: ifeq -> 608
    //   536: aload_0
    //   537: getfield useSingleQuotes : Z
    //   540: ifne -> 608
    //   543: aload_0
    //   544: getfield browserCompatible : Z
    //   547: istore #4
    //   549: iload #4
    //   551: ifne -> 608
    //   554: aload_0
    //   555: getfield browserSecure : Z
    //   558: ifne -> 608
    //   561: iload #4
    //   563: ifne -> 608
    //   566: aload_0
    //   567: getfield writeEnumUsingName : Z
    //   570: ifeq -> 608
    //   573: aload_0
    //   574: getfield writeEnumUsingToString : Z
    //   577: ifne -> 608
    //   580: aload_0
    //   581: getfield writeNonStringValueAsString : Z
    //   584: ifne -> 608
    //   587: aload_0
    //   588: getfield features : I
    //   591: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   594: getfield mask : I
    //   597: iand
    //   598: ifne -> 608
    //   601: iload #5
    //   603: istore #4
    //   605: goto -> 611
    //   608: iconst_0
    //   609: istore #4
    //   611: aload_0
    //   612: iload #4
    //   614: putfield writeDirect : Z
    //   617: aload_0
    //   618: getfield useSingleQuotes : Z
    //   621: ifeq -> 630
    //   624: bipush #39
    //   626: istore_1
    //   627: goto -> 633
    //   630: bipush #34
    //   632: istore_1
    //   633: aload_0
    //   634: iload_1
    //   635: putfield keySeperator : C
    //   638: return
  }
  
  public void config(SerializerFeature paramSerializerFeature, boolean paramBoolean) {
    if (paramBoolean) {
      this.features |= paramSerializerFeature.getMask();
      if (paramSerializerFeature == SerializerFeature.WriteEnumUsingToString) {
        this.features &= SerializerFeature.WriteEnumUsingName.getMask();
      } else if (paramSerializerFeature == SerializerFeature.WriteEnumUsingName) {
        this.features &= SerializerFeature.WriteEnumUsingToString.getMask();
      } 
    } else {
      int i = this.features;
      this.features = paramSerializerFeature.getMask() & i;
    } 
    computeFeatures();
  }
  
  public void expandCapacity(int paramInt) {
    int i = this.buf.length * 3 / 2 + 1;
    if (i >= paramInt)
      paramInt = i; 
    char[] arrayOfChar = new char[paramInt];
    System.arraycopy(this.buf, 0, arrayOfChar, 0, this.count);
    this.buf = arrayOfChar;
  }
  
  public void flush() {
    Writer writer = this.writer;
    if (writer == null)
      return; 
    try {
      writer.write(this.buf, 0, this.count);
      this.writer.flush();
      this.count = 0;
      return;
    } catch (IOException iOException) {
      throw new JSONException(iOException.getMessage(), iOException);
    } 
  }
  
  public int getBufferLength() {
    return this.buf.length;
  }
  
  public boolean isEnabled(SerializerFeature paramSerializerFeature) {
    int i = this.features;
    return ((paramSerializerFeature.mask & i) != 0);
  }
  
  public boolean isIgnoreNonFieldGetter() {
    return this.ignoreNonFieldGetter;
  }
  
  public boolean isNotWriteDefaultValue() {
    return this.notWriteDefaultValue;
  }
  
  public boolean isPrettyFormat() {
    return this.prettyFormat;
  }
  
  public boolean isSkipTransientField() {
    return this.skipTransientField;
  }
  
  public boolean isSortField() {
    return this.sortField;
  }
  
  public boolean isWriteMapNullValue() {
    return this.writeMapNullValue;
  }
  
  public void reset() {
    this.count = 0;
  }
  
  public int size() {
    return this.count;
  }
  
  public byte[] toBytes(String paramString) {
    if (this.writer == null) {
      String str = paramString;
      if (paramString == null)
        str = "UTF-8"; 
      return (new SerialWriterStringEncoder(Charset.forName(str))).encode(this.buf, 0, this.count);
    } 
    throw new UnsupportedOperationException("writer not null");
  }
  
  public char[] toCharArray() {
    if (this.writer == null) {
      int i = this.count;
      char[] arrayOfChar = new char[i];
      System.arraycopy(this.buf, 0, arrayOfChar, 0, i);
      return arrayOfChar;
    } 
    throw new UnsupportedOperationException("writer not null");
  }
  
  public String toString() {
    return new String(this.buf, 0, this.count);
  }
  
  public void write(int paramInt) {
    int j = this.count + 1;
    int i = j;
    if (j > this.buf.length)
      if (this.writer == null) {
        expandCapacity(j);
        i = j;
      } else {
        flush();
        i = 1;
      }  
    this.buf[this.count] = (char)paramInt;
    this.count = i;
  }
  
  public void write(String paramString) {
    if (paramString == null) {
      writeNull();
      return;
    } 
    write(paramString, 0, paramString.length());
  }
  
  public void write(String paramString, int paramInt1, int paramInt2) {
    int m = this.count + paramInt2;
    int i = m;
    int j = paramInt1;
    int k = paramInt2;
    if (m > this.buf.length) {
      i = paramInt1;
      j = paramInt2;
      if (this.writer == null) {
        expandCapacity(m);
        i = m;
        j = paramInt1;
        k = paramInt2;
      } else {
        while (true) {
          char[] arrayOfChar = this.buf;
          paramInt2 = arrayOfChar.length;
          paramInt1 = this.count;
          k = paramInt2 - paramInt1;
          paramInt2 = i + k;
          paramString.getChars(i, paramInt2, arrayOfChar, paramInt1);
          this.count = this.buf.length;
          flush();
          paramInt1 = j - k;
          if (paramInt1 <= this.buf.length) {
            i = paramInt1;
            j = paramInt2;
            k = paramInt1;
            break;
          } 
          i = paramInt2;
          j = paramInt1;
        } 
      } 
    } 
    paramString.getChars(j, k + j, this.buf, this.count);
    this.count = i;
  }
  
  public void write(boolean paramBoolean) {
    if (paramBoolean) {
      write("true");
      return;
    } 
    write("false");
  }
  
  public void write(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    if (paramInt1 >= 0 && paramInt1 <= paramArrayOfchar.length && paramInt2 >= 0) {
      int i = paramInt1 + paramInt2;
      if (i <= paramArrayOfchar.length && i >= 0) {
        if (paramInt2 == 0)
          return; 
        int m = this.count + paramInt2;
        int k = m;
        int j = paramInt1;
        i = paramInt2;
        if (m > this.buf.length) {
          i = paramInt1;
          j = paramInt2;
          if (this.writer == null) {
            expandCapacity(m);
            k = m;
            j = paramInt1;
            i = paramInt2;
          } else {
            while (true) {
              char[] arrayOfChar = this.buf;
              paramInt2 = arrayOfChar.length;
              paramInt1 = this.count;
              paramInt2 -= paramInt1;
              System.arraycopy(paramArrayOfchar, i, arrayOfChar, paramInt1, paramInt2);
              this.count = this.buf.length;
              flush();
              paramInt1 = j - paramInt2;
              paramInt2 = i + paramInt2;
              i = paramInt2;
              j = paramInt1;
              if (paramInt1 <= this.buf.length) {
                k = paramInt1;
                i = paramInt1;
                j = paramInt2;
                break;
              } 
            } 
          } 
        } 
        System.arraycopy(paramArrayOfchar, j, this.buf, this.count, i);
        this.count = k;
        return;
      } 
    } 
    throw new IndexOutOfBoundsException();
  }
  
  public void writeBooleanAndChar(boolean paramBoolean, char paramChar) {
    if (paramBoolean) {
      if (paramChar == ',') {
        write("true,");
        return;
      } 
      if (paramChar == ']') {
        write("true]");
        return;
      } 
      write("true");
      write(paramChar);
      return;
    } 
    if (paramChar == ',') {
      write("false,");
      return;
    } 
    if (paramChar == ']') {
      write("false]");
      return;
    } 
    write("false");
    write(paramChar);
  }
  
  public void writeByteArray(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aload_1
    //   1: arraylength
    //   2: istore #9
    //   4: aload_0
    //   5: getfield useSingleQuotes : Z
    //   8: ifeq -> 17
    //   11: bipush #39
    //   13: istore_2
    //   14: goto -> 20
    //   17: bipush #34
    //   19: istore_2
    //   20: iload #9
    //   22: ifne -> 49
    //   25: aload_0
    //   26: getfield useSingleQuotes : Z
    //   29: ifeq -> 39
    //   32: ldc_w ''''
    //   35: astore_1
    //   36: goto -> 43
    //   39: ldc_w '""'
    //   42: astore_1
    //   43: aload_0
    //   44: aload_1
    //   45: invokevirtual write : (Ljava/lang/String;)V
    //   48: return
    //   49: getstatic com/alibaba/fastjson/util/IOUtils.CA : [C
    //   52: astore #13
    //   54: iload #9
    //   56: iconst_3
    //   57: idiv
    //   58: iconst_3
    //   59: imul
    //   60: istore #8
    //   62: iload #9
    //   64: iconst_1
    //   65: isub
    //   66: istore #7
    //   68: iload #7
    //   70: iconst_3
    //   71: idiv
    //   72: istore #4
    //   74: aload_0
    //   75: getfield count : I
    //   78: istore #11
    //   80: iload #4
    //   82: iconst_1
    //   83: iadd
    //   84: iconst_2
    //   85: ishl
    //   86: iload #11
    //   88: iadd
    //   89: iconst_2
    //   90: iadd
    //   91: istore #10
    //   93: aload_0
    //   94: getfield buf : [C
    //   97: arraylength
    //   98: istore #4
    //   100: iconst_0
    //   101: istore #6
    //   103: iconst_0
    //   104: istore #5
    //   106: iload #10
    //   108: iload #4
    //   110: if_icmple -> 379
    //   113: aload_0
    //   114: getfield writer : Ljava/io/Writer;
    //   117: ifnull -> 373
    //   120: aload_0
    //   121: iload_2
    //   122: invokevirtual write : (I)V
    //   125: iconst_0
    //   126: istore #4
    //   128: iload #4
    //   130: iload #8
    //   132: if_icmpge -> 251
    //   135: iload #4
    //   137: iconst_1
    //   138: iadd
    //   139: istore #6
    //   141: aload_1
    //   142: iload #4
    //   144: baload
    //   145: istore #10
    //   147: iload #6
    //   149: iconst_1
    //   150: iadd
    //   151: istore #4
    //   153: iload #10
    //   155: sipush #255
    //   158: iand
    //   159: bipush #16
    //   161: ishl
    //   162: aload_1
    //   163: iload #6
    //   165: baload
    //   166: sipush #255
    //   169: iand
    //   170: bipush #8
    //   172: ishl
    //   173: ior
    //   174: aload_1
    //   175: iload #4
    //   177: baload
    //   178: sipush #255
    //   181: iand
    //   182: ior
    //   183: istore #6
    //   185: aload_0
    //   186: aload #13
    //   188: iload #6
    //   190: bipush #18
    //   192: iushr
    //   193: bipush #63
    //   195: iand
    //   196: caload
    //   197: invokevirtual write : (I)V
    //   200: aload_0
    //   201: aload #13
    //   203: iload #6
    //   205: bipush #12
    //   207: iushr
    //   208: bipush #63
    //   210: iand
    //   211: caload
    //   212: invokevirtual write : (I)V
    //   215: aload_0
    //   216: aload #13
    //   218: iload #6
    //   220: bipush #6
    //   222: iushr
    //   223: bipush #63
    //   225: iand
    //   226: caload
    //   227: invokevirtual write : (I)V
    //   230: aload_0
    //   231: aload #13
    //   233: iload #6
    //   235: bipush #63
    //   237: iand
    //   238: caload
    //   239: invokevirtual write : (I)V
    //   242: iload #4
    //   244: iconst_1
    //   245: iadd
    //   246: istore #4
    //   248: goto -> 128
    //   251: iload #9
    //   253: iload #8
    //   255: isub
    //   256: istore #6
    //   258: iload #6
    //   260: ifle -> 367
    //   263: aload_1
    //   264: iload #8
    //   266: baload
    //   267: istore #8
    //   269: iload #5
    //   271: istore #4
    //   273: iload #6
    //   275: iconst_2
    //   276: if_icmpne -> 291
    //   279: aload_1
    //   280: iload #7
    //   282: baload
    //   283: sipush #255
    //   286: iand
    //   287: iconst_2
    //   288: ishl
    //   289: istore #4
    //   291: iload #8
    //   293: sipush #255
    //   296: iand
    //   297: bipush #10
    //   299: ishl
    //   300: iload #4
    //   302: ior
    //   303: istore #4
    //   305: aload_0
    //   306: aload #13
    //   308: iload #4
    //   310: bipush #12
    //   312: ishr
    //   313: caload
    //   314: invokevirtual write : (I)V
    //   317: aload_0
    //   318: aload #13
    //   320: iload #4
    //   322: bipush #6
    //   324: iushr
    //   325: bipush #63
    //   327: iand
    //   328: caload
    //   329: invokevirtual write : (I)V
    //   332: iload #6
    //   334: iconst_2
    //   335: if_icmpne -> 351
    //   338: aload #13
    //   340: iload #4
    //   342: bipush #63
    //   344: iand
    //   345: caload
    //   346: istore #4
    //   348: goto -> 355
    //   351: bipush #61
    //   353: istore #4
    //   355: aload_0
    //   356: iload #4
    //   358: invokevirtual write : (I)V
    //   361: aload_0
    //   362: bipush #61
    //   364: invokevirtual write : (I)V
    //   367: aload_0
    //   368: iload_2
    //   369: invokevirtual write : (I)V
    //   372: return
    //   373: aload_0
    //   374: iload #10
    //   376: invokevirtual expandCapacity : (I)V
    //   379: aload_0
    //   380: iload #10
    //   382: putfield count : I
    //   385: aload_0
    //   386: getfield buf : [C
    //   389: astore #14
    //   391: iload #11
    //   393: iconst_1
    //   394: iadd
    //   395: istore #4
    //   397: aload #14
    //   399: iload #11
    //   401: iload_2
    //   402: castore
    //   403: iconst_0
    //   404: istore #5
    //   406: iload #5
    //   408: iload #8
    //   410: if_icmpge -> 563
    //   413: iload #5
    //   415: iconst_1
    //   416: iadd
    //   417: istore #11
    //   419: aload_1
    //   420: iload #5
    //   422: baload
    //   423: istore #12
    //   425: iload #11
    //   427: iconst_1
    //   428: iadd
    //   429: istore #5
    //   431: iload #12
    //   433: sipush #255
    //   436: iand
    //   437: bipush #16
    //   439: ishl
    //   440: aload_1
    //   441: iload #11
    //   443: baload
    //   444: sipush #255
    //   447: iand
    //   448: bipush #8
    //   450: ishl
    //   451: ior
    //   452: aload_1
    //   453: iload #5
    //   455: baload
    //   456: sipush #255
    //   459: iand
    //   460: ior
    //   461: istore #11
    //   463: aload_0
    //   464: getfield buf : [C
    //   467: astore #14
    //   469: iload #4
    //   471: iconst_1
    //   472: iadd
    //   473: istore #12
    //   475: aload #14
    //   477: iload #4
    //   479: aload #13
    //   481: iload #11
    //   483: bipush #18
    //   485: iushr
    //   486: bipush #63
    //   488: iand
    //   489: caload
    //   490: castore
    //   491: iload #12
    //   493: iconst_1
    //   494: iadd
    //   495: istore #4
    //   497: aload #14
    //   499: iload #12
    //   501: aload #13
    //   503: iload #11
    //   505: bipush #12
    //   507: iushr
    //   508: bipush #63
    //   510: iand
    //   511: caload
    //   512: castore
    //   513: iload #4
    //   515: iconst_1
    //   516: iadd
    //   517: istore #12
    //   519: aload #14
    //   521: iload #4
    //   523: aload #13
    //   525: iload #11
    //   527: bipush #6
    //   529: iushr
    //   530: bipush #63
    //   532: iand
    //   533: caload
    //   534: castore
    //   535: iload #12
    //   537: iconst_1
    //   538: iadd
    //   539: istore #4
    //   541: aload #14
    //   543: iload #12
    //   545: aload #13
    //   547: iload #11
    //   549: bipush #63
    //   551: iand
    //   552: caload
    //   553: castore
    //   554: iload #5
    //   556: iconst_1
    //   557: iadd
    //   558: istore #5
    //   560: goto -> 406
    //   563: iload #9
    //   565: iload #8
    //   567: isub
    //   568: istore #5
    //   570: iload #5
    //   572: ifle -> 692
    //   575: aload_1
    //   576: iload #8
    //   578: baload
    //   579: istore #8
    //   581: iload #6
    //   583: istore #4
    //   585: iload #5
    //   587: iconst_2
    //   588: if_icmpne -> 603
    //   591: aload_1
    //   592: iload #7
    //   594: baload
    //   595: sipush #255
    //   598: iand
    //   599: iconst_2
    //   600: ishl
    //   601: istore #4
    //   603: iload #8
    //   605: sipush #255
    //   608: iand
    //   609: bipush #10
    //   611: ishl
    //   612: iload #4
    //   614: ior
    //   615: istore #4
    //   617: aload_0
    //   618: getfield buf : [C
    //   621: astore_1
    //   622: aload_1
    //   623: iload #10
    //   625: iconst_5
    //   626: isub
    //   627: aload #13
    //   629: iload #4
    //   631: bipush #12
    //   633: ishr
    //   634: caload
    //   635: castore
    //   636: aload_1
    //   637: iload #10
    //   639: iconst_4
    //   640: isub
    //   641: aload #13
    //   643: iload #4
    //   645: bipush #6
    //   647: iushr
    //   648: bipush #63
    //   650: iand
    //   651: caload
    //   652: castore
    //   653: iload #5
    //   655: iconst_2
    //   656: if_icmpne -> 671
    //   659: aload #13
    //   661: iload #4
    //   663: bipush #63
    //   665: iand
    //   666: caload
    //   667: istore_3
    //   668: goto -> 674
    //   671: bipush #61
    //   673: istore_3
    //   674: aload_1
    //   675: iload #10
    //   677: iconst_3
    //   678: isub
    //   679: iload_3
    //   680: castore
    //   681: aload_0
    //   682: getfield buf : [C
    //   685: iload #10
    //   687: iconst_2
    //   688: isub
    //   689: bipush #61
    //   691: castore
    //   692: aload_0
    //   693: getfield buf : [C
    //   696: iload #10
    //   698: iconst_1
    //   699: isub
    //   700: iload_2
    //   701: castore
    //   702: return
  }
  
  public void writeCharacterAndChar(char paramChar1, char paramChar2) {
    writeString(Character.toString(paramChar1));
    write(paramChar2);
  }
  
  public void writeDoubleAndChar(double paramDouble, char paramChar) {
    String str2 = Double.toString(paramDouble);
    String str1 = str2;
    if (str2.endsWith(".0"))
      str1 = str2.substring(0, str2.length() - 2); 
    write(str1);
    write(paramChar);
  }
  
  public void writeEnum(Enum<?> paramEnum, char paramChar) {
    if (paramEnum == null) {
      writeNull();
      write(44);
      return;
    } 
    if (isEnabled(SerializerFeature.WriteEnumUsingName)) {
      writeEnumValue(paramEnum.name(), paramChar);
      return;
    } 
    if (isEnabled(SerializerFeature.WriteEnumUsingToString)) {
      writeEnumValue(paramEnum.toString(), paramChar);
      return;
    } 
    writeIntAndChar(paramEnum.ordinal(), paramChar);
  }
  
  public void writeFieldEmptyList(char paramChar, String paramString) {
    write(paramChar);
    writeFieldName(paramString);
    write("[]");
  }
  
  public void writeFieldName(String paramString) {
    writeFieldName(paramString, false);
  }
  
  public void writeFieldName(String paramString, boolean paramBoolean) {
    boolean bool1;
    boolean bool2;
    if (paramString == null) {
      write("null:");
      return;
    } 
    if (this.useSingleQuotes) {
      if (this.quoteFieldNames) {
        writeStringWithSingleQuote(paramString);
        write(58);
        return;
      } 
      writeKeyWithSingleQuoteIfHasSpecial(paramString);
      return;
    } 
    if (this.quoteFieldNames) {
      writeStringWithDoubleQuote(paramString, ':');
      return;
    } 
    if (paramString.length() == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    int i = 0;
    while (true) {
      bool2 = bool1;
      if (i < paramString.length()) {
        if (isSpecial(paramString.charAt(i), 0)) {
          bool2 = true;
          break;
        } 
        i++;
        continue;
      } 
      break;
    } 
    if (bool2) {
      writeStringWithDoubleQuote(paramString, ':');
      return;
    } 
    write(paramString);
    write(58);
  }
  
  public void writeFieldNull(char paramChar, String paramString) {
    write(paramChar);
    writeFieldName(paramString);
    writeNull();
  }
  
  public void writeFieldNullBoolean(char paramChar, String paramString) {
    write(paramChar);
    writeFieldName(paramString);
    if (isEnabled(SerializerFeature.WriteNullBooleanAsFalse)) {
      write("false");
      return;
    } 
    writeNull();
  }
  
  public void writeFieldNullList(char paramChar, String paramString) {
    write(paramChar);
    writeFieldName(paramString);
    if (isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
      write("[]");
      return;
    } 
    writeNull();
  }
  
  public void writeFieldNullNumber(char paramChar, String paramString) {
    write(paramChar);
    writeFieldName(paramString);
    if (isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
      write(48);
      return;
    } 
    writeNull();
  }
  
  public void writeFieldNullString(char paramChar, String paramString) {
    write(paramChar);
    writeFieldName(paramString);
    if (isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
      writeString("");
      return;
    } 
    writeNull();
  }
  
  public void writeFieldValue(char paramChar1, String paramString, char paramChar2) {
    write(paramChar1);
    writeFieldName(paramString);
    if (paramChar2 == '\000') {
      writeString("\000");
      return;
    } 
    writeString(Character.toString(paramChar2));
  }
  
  public void writeFieldValue(char paramChar, String paramString, double paramDouble) {
    write(paramChar);
    writeFieldName(paramString);
    if (paramDouble == 0.0D) {
      write(48);
      return;
    } 
    if (Double.isNaN(paramDouble)) {
      writeNull();
      return;
    } 
    if (Double.isInfinite(paramDouble)) {
      writeNull();
      return;
    } 
    String str = Double.toString(paramDouble);
    paramString = str;
    if (str.endsWith(".0"))
      paramString = str.substring(0, str.length() - 2); 
    write(paramString);
  }
  
  public void writeFieldValue(char paramChar, String paramString, float paramFloat) {
    write(paramChar);
    writeFieldName(paramString);
    if (paramFloat == 0.0F) {
      write(48);
      return;
    } 
    if (Float.isNaN(paramFloat)) {
      writeNull();
      return;
    } 
    if (Float.isInfinite(paramFloat)) {
      writeNull();
      return;
    } 
    String str = Float.toString(paramFloat);
    paramString = str;
    if (str.endsWith(".0"))
      paramString = str.substring(0, str.length() - 2); 
    write(paramString);
  }
  
  public void writeFieldValue(char paramChar, String paramString, int paramInt) {
    if (paramInt == Integer.MIN_VALUE || !this.quoteFieldNames) {
      writeFieldValue1(paramChar, paramString, paramInt);
      return;
    } 
    if (paramInt < 0) {
      i = IOUtils.stringSize(-paramInt) + 1;
    } else {
      i = IOUtils.stringSize(paramInt);
    } 
    int j = paramString.length();
    int k = this.count + j + 4 + i;
    if (k > this.buf.length) {
      if (this.writer != null) {
        writeFieldValue1(paramChar, paramString, paramInt);
        return;
      } 
      expandCapacity(k);
    } 
    int i = this.count;
    this.count = k;
    char[] arrayOfChar2 = this.buf;
    arrayOfChar2[i] = paramChar;
    k = i + j + 1;
    arrayOfChar2[i + 1] = this.keySeperator;
    paramString.getChars(0, j, arrayOfChar2, i + 2);
    char[] arrayOfChar1 = this.buf;
    arrayOfChar1[k + 1] = this.keySeperator;
    arrayOfChar1[k + 2] = ':';
    IOUtils.getChars(paramInt, this.count, arrayOfChar1);
  }
  
  public void writeFieldValue(char paramChar, String paramString, long paramLong) {
    if (paramLong == Long.MIN_VALUE || !this.quoteFieldNames) {
      writeFieldValue1(paramChar, paramString, paramLong);
      return;
    } 
    if (paramLong < 0L) {
      i = IOUtils.stringSize(-paramLong) + 1;
    } else {
      i = IOUtils.stringSize(paramLong);
    } 
    int j = paramString.length();
    int k = this.count + j + 4 + i;
    if (k > this.buf.length) {
      if (this.writer != null) {
        write(paramChar);
        writeFieldName(paramString);
        writeLong(paramLong);
        return;
      } 
      expandCapacity(k);
    } 
    int i = this.count;
    this.count = k;
    char[] arrayOfChar2 = this.buf;
    arrayOfChar2[i] = paramChar;
    k = i + j + 1;
    arrayOfChar2[i + 1] = this.keySeperator;
    paramString.getChars(0, j, arrayOfChar2, i + 2);
    char[] arrayOfChar1 = this.buf;
    arrayOfChar1[k + 1] = this.keySeperator;
    arrayOfChar1[k + 2] = ':';
    IOUtils.getChars(paramLong, this.count, arrayOfChar1);
  }
  
  public void writeFieldValue(char paramChar, String paramString, Enum<?> paramEnum) {
    if (paramEnum == null) {
      write(paramChar);
      writeFieldName(paramString);
      writeNull();
      return;
    } 
    if (this.writeEnumUsingName && !this.writeEnumUsingToString) {
      writeEnumFieldValue(paramChar, paramString, paramEnum.name());
      return;
    } 
    if (this.writeEnumUsingToString) {
      writeEnumFieldValue(paramChar, paramString, paramEnum.toString());
      return;
    } 
    writeFieldValue(paramChar, paramString, paramEnum.ordinal());
  }
  
  public void writeFieldValue(char paramChar, String paramString1, String paramString2) {
    if (this.quoteFieldNames) {
      if (this.useSingleQuotes) {
        write(paramChar);
        writeFieldName(paramString1);
        if (paramString2 == null) {
          writeNull();
          return;
        } 
        writeString(paramString2);
        return;
      } 
      if (this.browserSecure) {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, false);
        return;
      } 
      if (this.browserCompatible) {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, false);
        return;
      } 
      writeFieldValueStringWithDoubleQuoteCheck(paramChar, paramString1, paramString2);
      return;
    } 
    write(paramChar);
    writeFieldName(paramString1);
    if (paramString2 == null) {
      writeNull();
      return;
    } 
    writeString(paramString2);
  }
  
  public void writeFieldValue(char paramChar, String paramString, BigDecimal paramBigDecimal) {
    write(paramChar);
    writeFieldName(paramString);
    if (paramBigDecimal == null) {
      writeNull();
      return;
    } 
    write(paramBigDecimal.toString());
  }
  
  public void writeFieldValue(char paramChar, String paramString, boolean paramBoolean) {
    if (paramBoolean) {
      i = 4;
    } else {
      i = 5;
    } 
    int j = paramString.length();
    int k = this.count + j + 4 + i;
    if (k > this.buf.length) {
      if (this.writer != null) {
        write(paramChar);
        writeString(paramString);
        write(58);
        write(paramBoolean);
        return;
      } 
      expandCapacity(k);
    } 
    int i = this.count;
    this.count = k;
    char[] arrayOfChar = this.buf;
    arrayOfChar[i] = paramChar;
    k = i + j + 1;
    arrayOfChar[i + 1] = this.keySeperator;
    paramString.getChars(0, j, arrayOfChar, i + 2);
    this.buf[k + 1] = this.keySeperator;
    if (paramBoolean) {
      System.arraycopy(":true".toCharArray(), 0, this.buf, k + 2, 5);
      return;
    } 
    System.arraycopy(":false".toCharArray(), 0, this.buf, k + 2, 6);
  }
  
  public void writeFieldValue1(char paramChar, String paramString, int paramInt) {
    write(paramChar);
    writeFieldName(paramString);
    writeInt(paramInt);
  }
  
  public void writeFieldValue1(char paramChar, String paramString, long paramLong) {
    write(paramChar);
    writeFieldName(paramString);
    writeLong(paramLong);
  }
  
  public void writeFieldValueStringWithDoubleQuote(char paramChar, String paramString1, String paramString2) {
    int i;
    int k = paramString1.length();
    int m = this.count;
    if (paramString2 == null) {
      i = 4;
      j = k + 8;
    } else {
      i = paramString2.length();
      j = k + i + 6;
    } 
    int j = m + j;
    if (j > this.buf.length) {
      if (this.writer != null) {
        write(paramChar);
        writeStringWithDoubleQuote(paramString1, ':');
        writeStringWithDoubleQuote(paramString2, false);
        return;
      } 
      expandCapacity(j);
    } 
    char[] arrayOfChar2 = this.buf;
    m = this.count;
    arrayOfChar2[m] = paramChar;
    int n = m + 2;
    int i1 = n + k;
    arrayOfChar2[m + 1] = '"';
    paramString1.getChars(0, k, arrayOfChar2, n);
    this.count = j;
    char[] arrayOfChar1 = this.buf;
    arrayOfChar1[i1] = '"';
    k = i1 + 1;
    j = k + 1;
    arrayOfChar1[k] = ':';
    if (paramString2 == null) {
      i = j + 1;
      arrayOfChar1[j] = 'n';
      j = i + 1;
      arrayOfChar1[i] = 'u';
      arrayOfChar1[j] = 'l';
      arrayOfChar1[j + 1] = 'l';
      return;
    } 
    arrayOfChar1[j] = '"';
    paramString2.getChars(0, i, arrayOfChar1, j + 1);
    this.buf[this.count - 1] = '"';
  }
  
  public void writeFieldValueStringWithDoubleQuoteCheck(char paramChar, String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual length : ()I
    //   4: istore #6
    //   6: aload_0
    //   7: getfield count : I
    //   10: istore #4
    //   12: aload_3
    //   13: ifnonnull -> 32
    //   16: iload #4
    //   18: iload #6
    //   20: bipush #8
    //   22: iadd
    //   23: iadd
    //   24: istore #4
    //   26: iconst_4
    //   27: istore #5
    //   29: goto -> 51
    //   32: aload_3
    //   33: invokevirtual length : ()I
    //   36: istore #5
    //   38: iload #4
    //   40: iload #6
    //   42: iload #5
    //   44: iadd
    //   45: bipush #6
    //   47: iadd
    //   48: iadd
    //   49: istore #4
    //   51: aload_0
    //   52: getfield buf : [C
    //   55: arraylength
    //   56: istore #7
    //   58: iconst_0
    //   59: istore #9
    //   61: iload #4
    //   63: iload #7
    //   65: if_icmple -> 100
    //   68: aload_0
    //   69: getfield writer : Ljava/io/Writer;
    //   72: ifnull -> 94
    //   75: aload_0
    //   76: iload_1
    //   77: invokevirtual write : (I)V
    //   80: aload_0
    //   81: aload_2
    //   82: bipush #58
    //   84: invokevirtual writeStringWithDoubleQuote : (Ljava/lang/String;C)V
    //   87: aload_0
    //   88: aload_3
    //   89: iconst_0
    //   90: invokevirtual writeStringWithDoubleQuote : (Ljava/lang/String;C)V
    //   93: return
    //   94: aload_0
    //   95: iload #4
    //   97: invokevirtual expandCapacity : (I)V
    //   100: aload_0
    //   101: getfield buf : [C
    //   104: astore #17
    //   106: aload_0
    //   107: getfield count : I
    //   110: istore #7
    //   112: aload #17
    //   114: iload #7
    //   116: iload_1
    //   117: castore
    //   118: iload #7
    //   120: iconst_2
    //   121: iadd
    //   122: istore #8
    //   124: iload #8
    //   126: iload #6
    //   128: iadd
    //   129: istore #10
    //   131: aload #17
    //   133: iload #7
    //   135: iconst_1
    //   136: iadd
    //   137: bipush #34
    //   139: castore
    //   140: aload_2
    //   141: iconst_0
    //   142: iload #6
    //   144: aload #17
    //   146: iload #8
    //   148: invokevirtual getChars : (II[CI)V
    //   151: aload_0
    //   152: iload #4
    //   154: putfield count : I
    //   157: aload_0
    //   158: getfield buf : [C
    //   161: astore_2
    //   162: aload_2
    //   163: iload #10
    //   165: bipush #34
    //   167: castore
    //   168: iload #10
    //   170: iconst_1
    //   171: iadd
    //   172: istore #7
    //   174: iload #7
    //   176: iconst_1
    //   177: iadd
    //   178: istore #6
    //   180: aload_2
    //   181: iload #7
    //   183: bipush #58
    //   185: castore
    //   186: aload_3
    //   187: ifnonnull -> 229
    //   190: iload #6
    //   192: iconst_1
    //   193: iadd
    //   194: istore #4
    //   196: aload_2
    //   197: iload #6
    //   199: bipush #110
    //   201: castore
    //   202: iload #4
    //   204: iconst_1
    //   205: iadd
    //   206: istore #5
    //   208: aload_2
    //   209: iload #4
    //   211: bipush #117
    //   213: castore
    //   214: aload_2
    //   215: iload #5
    //   217: bipush #108
    //   219: castore
    //   220: aload_2
    //   221: iload #5
    //   223: iconst_1
    //   224: iadd
    //   225: bipush #108
    //   227: castore
    //   228: return
    //   229: iload #6
    //   231: iconst_1
    //   232: iadd
    //   233: istore #15
    //   235: aload_2
    //   236: iload #6
    //   238: bipush #34
    //   240: castore
    //   241: iload #15
    //   243: iload #5
    //   245: iadd
    //   246: istore #16
    //   248: aload_3
    //   249: iconst_0
    //   250: iload #5
    //   252: aload_2
    //   253: iload #15
    //   255: invokevirtual getChars : (II[CI)V
    //   258: aload_0
    //   259: getfield disableCheckSpecialChar : Z
    //   262: ifne -> 1292
    //   265: iload #4
    //   267: istore #7
    //   269: iload #15
    //   271: istore #4
    //   273: iconst_0
    //   274: istore #6
    //   276: iconst_m1
    //   277: istore #5
    //   279: iconst_m1
    //   280: istore #8
    //   282: iload #4
    //   284: iload #16
    //   286: if_icmpge -> 549
    //   289: aload_0
    //   290: getfield buf : [C
    //   293: iload #4
    //   295: caload
    //   296: istore_1
    //   297: iload_1
    //   298: bipush #93
    //   300: if_icmplt -> 396
    //   303: iload #7
    //   305: istore #14
    //   307: iload #9
    //   309: istore #13
    //   311: iload #6
    //   313: istore #12
    //   315: iload #5
    //   317: istore #11
    //   319: iload #8
    //   321: istore #10
    //   323: iload_1
    //   324: bipush #127
    //   326: if_icmplt -> 520
    //   329: iload_1
    //   330: sipush #8232
    //   333: if_icmpeq -> 363
    //   336: iload #7
    //   338: istore #14
    //   340: iload #9
    //   342: istore #13
    //   344: iload #6
    //   346: istore #12
    //   348: iload #5
    //   350: istore #11
    //   352: iload #8
    //   354: istore #10
    //   356: iload_1
    //   357: sipush #160
    //   360: if_icmpgt -> 520
    //   363: iload #5
    //   365: istore #6
    //   367: iload #5
    //   369: iconst_m1
    //   370: if_icmpne -> 377
    //   373: iload #4
    //   375: istore #6
    //   377: iload #9
    //   379: iconst_1
    //   380: iadd
    //   381: istore #8
    //   383: iload #7
    //   385: iconst_4
    //   386: iadd
    //   387: istore #7
    //   389: iload #6
    //   391: istore #9
    //   393: goto -> 493
    //   396: iload #7
    //   398: istore #14
    //   400: iload #9
    //   402: istore #13
    //   404: iload #6
    //   406: istore #12
    //   408: iload #5
    //   410: istore #11
    //   412: iload #8
    //   414: istore #10
    //   416: iload_1
    //   417: aload_0
    //   418: getfield features : I
    //   421: invokestatic isSpecial : (CI)Z
    //   424: ifeq -> 520
    //   427: iload #9
    //   429: iconst_1
    //   430: iadd
    //   431: istore #10
    //   433: iload #7
    //   435: istore #6
    //   437: iload_1
    //   438: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   441: arraylength
    //   442: if_icmpge -> 464
    //   445: iload #7
    //   447: istore #6
    //   449: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   452: iload_1
    //   453: baload
    //   454: iconst_4
    //   455: if_icmpne -> 464
    //   458: iload #7
    //   460: iconst_4
    //   461: iadd
    //   462: istore #6
    //   464: iload #6
    //   466: istore #7
    //   468: iload #10
    //   470: istore #8
    //   472: iload #5
    //   474: istore #9
    //   476: iload #5
    //   478: iconst_m1
    //   479: if_icmpne -> 493
    //   482: iload #4
    //   484: istore #9
    //   486: iload #10
    //   488: istore #5
    //   490: goto -> 501
    //   493: iload #8
    //   495: istore #5
    //   497: iload #7
    //   499: istore #6
    //   501: iload #4
    //   503: istore #10
    //   505: iload_1
    //   506: istore #12
    //   508: iload #9
    //   510: istore #11
    //   512: iload #5
    //   514: istore #13
    //   516: iload #6
    //   518: istore #14
    //   520: iload #4
    //   522: iconst_1
    //   523: iadd
    //   524: istore #4
    //   526: iload #14
    //   528: istore #7
    //   530: iload #13
    //   532: istore #9
    //   534: iload #12
    //   536: istore #6
    //   538: iload #11
    //   540: istore #5
    //   542: iload #10
    //   544: istore #8
    //   546: goto -> 282
    //   549: iload #9
    //   551: ifle -> 1292
    //   554: iload #7
    //   556: iload #9
    //   558: iadd
    //   559: istore #4
    //   561: iload #4
    //   563: aload_0
    //   564: getfield buf : [C
    //   567: arraylength
    //   568: if_icmple -> 577
    //   571: aload_0
    //   572: iload #4
    //   574: invokevirtual expandCapacity : (I)V
    //   577: aload_0
    //   578: iload #4
    //   580: putfield count : I
    //   583: iload #9
    //   585: iconst_1
    //   586: if_icmpne -> 904
    //   589: iload #6
    //   591: sipush #8232
    //   594: if_icmpne -> 691
    //   597: iload #8
    //   599: iconst_1
    //   600: iadd
    //   601: istore #4
    //   603: aload_0
    //   604: getfield buf : [C
    //   607: astore_2
    //   608: aload_2
    //   609: iload #4
    //   611: aload_2
    //   612: iload #8
    //   614: bipush #6
    //   616: iadd
    //   617: iload #16
    //   619: iload #8
    //   621: isub
    //   622: iconst_1
    //   623: isub
    //   624: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   627: aload_0
    //   628: getfield buf : [C
    //   631: astore_2
    //   632: aload_2
    //   633: iload #8
    //   635: bipush #92
    //   637: castore
    //   638: aload_2
    //   639: iload #4
    //   641: bipush #117
    //   643: castore
    //   644: iload #4
    //   646: iconst_1
    //   647: iadd
    //   648: istore #4
    //   650: aload_2
    //   651: iload #4
    //   653: bipush #50
    //   655: castore
    //   656: iload #4
    //   658: iconst_1
    //   659: iadd
    //   660: istore #4
    //   662: aload_2
    //   663: iload #4
    //   665: bipush #48
    //   667: castore
    //   668: iload #4
    //   670: iconst_1
    //   671: iadd
    //   672: istore #4
    //   674: aload_2
    //   675: iload #4
    //   677: bipush #50
    //   679: castore
    //   680: aload_2
    //   681: iload #4
    //   683: iconst_1
    //   684: iadd
    //   685: bipush #56
    //   687: castore
    //   688: goto -> 1292
    //   691: iload #6
    //   693: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   696: arraylength
    //   697: if_icmpge -> 851
    //   700: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   703: iload #6
    //   705: baload
    //   706: iconst_4
    //   707: if_icmpne -> 851
    //   710: iload #8
    //   712: iconst_1
    //   713: iadd
    //   714: istore #4
    //   716: aload_0
    //   717: getfield buf : [C
    //   720: astore_2
    //   721: aload_2
    //   722: iload #4
    //   724: aload_2
    //   725: iload #8
    //   727: bipush #6
    //   729: iadd
    //   730: iload #16
    //   732: iload #8
    //   734: isub
    //   735: iconst_1
    //   736: isub
    //   737: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   740: aload_0
    //   741: getfield buf : [C
    //   744: astore_2
    //   745: aload_2
    //   746: iload #8
    //   748: bipush #92
    //   750: castore
    //   751: iload #4
    //   753: iconst_1
    //   754: iadd
    //   755: istore #5
    //   757: aload_2
    //   758: iload #4
    //   760: bipush #117
    //   762: castore
    //   763: iload #5
    //   765: iconst_1
    //   766: iadd
    //   767: istore #4
    //   769: aload_2
    //   770: iload #5
    //   772: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   775: iload #6
    //   777: bipush #12
    //   779: iushr
    //   780: bipush #15
    //   782: iand
    //   783: caload
    //   784: castore
    //   785: aload_0
    //   786: getfield buf : [C
    //   789: astore_2
    //   790: iload #4
    //   792: iconst_1
    //   793: iadd
    //   794: istore #5
    //   796: aload_2
    //   797: iload #4
    //   799: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   802: iload #6
    //   804: bipush #8
    //   806: iushr
    //   807: bipush #15
    //   809: iand
    //   810: caload
    //   811: castore
    //   812: aload_0
    //   813: getfield buf : [C
    //   816: iload #5
    //   818: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   821: iload #6
    //   823: iconst_4
    //   824: iushr
    //   825: bipush #15
    //   827: iand
    //   828: caload
    //   829: castore
    //   830: aload_0
    //   831: getfield buf : [C
    //   834: iload #5
    //   836: iconst_1
    //   837: iadd
    //   838: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   841: iload #6
    //   843: bipush #15
    //   845: iand
    //   846: caload
    //   847: castore
    //   848: goto -> 1292
    //   851: iload #8
    //   853: iconst_1
    //   854: iadd
    //   855: istore #4
    //   857: aload_0
    //   858: getfield buf : [C
    //   861: astore_2
    //   862: aload_2
    //   863: iload #4
    //   865: aload_2
    //   866: iload #8
    //   868: iconst_2
    //   869: iadd
    //   870: iload #16
    //   872: iload #8
    //   874: isub
    //   875: iconst_1
    //   876: isub
    //   877: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   880: aload_0
    //   881: getfield buf : [C
    //   884: astore_2
    //   885: aload_2
    //   886: iload #8
    //   888: bipush #92
    //   890: castore
    //   891: aload_2
    //   892: iload #4
    //   894: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   897: iload #6
    //   899: caload
    //   900: castore
    //   901: goto -> 1292
    //   904: iload #9
    //   906: iconst_1
    //   907: if_icmple -> 1292
    //   910: iload #5
    //   912: iload #15
    //   914: isub
    //   915: istore #6
    //   917: iload #5
    //   919: istore #4
    //   921: iload #6
    //   923: istore #5
    //   925: iload #5
    //   927: aload_3
    //   928: invokevirtual length : ()I
    //   931: if_icmpge -> 1292
    //   934: aload_3
    //   935: iload #5
    //   937: invokevirtual charAt : (I)C
    //   940: istore_1
    //   941: iload_1
    //   942: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   945: arraylength
    //   946: if_icmpge -> 957
    //   949: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   952: iload_1
    //   953: baload
    //   954: ifne -> 973
    //   957: iload_1
    //   958: bipush #47
    //   960: if_icmpne -> 1137
    //   963: aload_0
    //   964: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   967: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   970: ifeq -> 1137
    //   973: aload_0
    //   974: getfield buf : [C
    //   977: astore_2
    //   978: iload #4
    //   980: iconst_1
    //   981: iadd
    //   982: istore #6
    //   984: aload_2
    //   985: iload #4
    //   987: bipush #92
    //   989: castore
    //   990: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   993: iload_1
    //   994: baload
    //   995: iconst_4
    //   996: if_icmpne -> 1114
    //   999: aload_0
    //   1000: getfield buf : [C
    //   1003: astore_2
    //   1004: iload #6
    //   1006: iconst_1
    //   1007: iadd
    //   1008: istore #4
    //   1010: aload_2
    //   1011: iload #6
    //   1013: bipush #117
    //   1015: castore
    //   1016: iload #4
    //   1018: iconst_1
    //   1019: iadd
    //   1020: istore #6
    //   1022: aload_2
    //   1023: iload #4
    //   1025: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1028: iload_1
    //   1029: bipush #12
    //   1031: iushr
    //   1032: bipush #15
    //   1034: iand
    //   1035: caload
    //   1036: castore
    //   1037: aload_0
    //   1038: getfield buf : [C
    //   1041: astore_2
    //   1042: iload #6
    //   1044: iconst_1
    //   1045: iadd
    //   1046: istore #4
    //   1048: aload_2
    //   1049: iload #6
    //   1051: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1054: iload_1
    //   1055: bipush #8
    //   1057: iushr
    //   1058: bipush #15
    //   1060: iand
    //   1061: caload
    //   1062: castore
    //   1063: aload_0
    //   1064: getfield buf : [C
    //   1067: astore_2
    //   1068: iload #4
    //   1070: iconst_1
    //   1071: iadd
    //   1072: istore #6
    //   1074: aload_2
    //   1075: iload #4
    //   1077: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1080: iload_1
    //   1081: iconst_4
    //   1082: iushr
    //   1083: bipush #15
    //   1085: iand
    //   1086: caload
    //   1087: castore
    //   1088: aload_0
    //   1089: getfield buf : [C
    //   1092: astore_2
    //   1093: iload #6
    //   1095: iconst_1
    //   1096: iadd
    //   1097: istore #4
    //   1099: aload_2
    //   1100: iload #6
    //   1102: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1105: iload_1
    //   1106: bipush #15
    //   1108: iand
    //   1109: caload
    //   1110: castore
    //   1111: goto -> 1134
    //   1114: aload_0
    //   1115: getfield buf : [C
    //   1118: astore_2
    //   1119: iload #6
    //   1121: iconst_1
    //   1122: iadd
    //   1123: istore #4
    //   1125: aload_2
    //   1126: iload #6
    //   1128: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   1131: iload_1
    //   1132: caload
    //   1133: castore
    //   1134: goto -> 1283
    //   1137: iload_1
    //   1138: sipush #8232
    //   1141: if_icmpne -> 1269
    //   1144: aload_0
    //   1145: getfield buf : [C
    //   1148: astore_2
    //   1149: iload #4
    //   1151: iconst_1
    //   1152: iadd
    //   1153: istore #6
    //   1155: aload_2
    //   1156: iload #4
    //   1158: bipush #92
    //   1160: castore
    //   1161: iload #6
    //   1163: iconst_1
    //   1164: iadd
    //   1165: istore #4
    //   1167: aload_2
    //   1168: iload #6
    //   1170: bipush #117
    //   1172: castore
    //   1173: iload #4
    //   1175: iconst_1
    //   1176: iadd
    //   1177: istore #6
    //   1179: aload_2
    //   1180: iload #4
    //   1182: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1185: iload_1
    //   1186: bipush #12
    //   1188: iushr
    //   1189: bipush #15
    //   1191: iand
    //   1192: caload
    //   1193: castore
    //   1194: aload_0
    //   1195: getfield buf : [C
    //   1198: astore_2
    //   1199: iload #6
    //   1201: iconst_1
    //   1202: iadd
    //   1203: istore #4
    //   1205: aload_2
    //   1206: iload #6
    //   1208: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1211: iload_1
    //   1212: bipush #8
    //   1214: iushr
    //   1215: bipush #15
    //   1217: iand
    //   1218: caload
    //   1219: castore
    //   1220: aload_0
    //   1221: getfield buf : [C
    //   1224: astore_2
    //   1225: iload #4
    //   1227: iconst_1
    //   1228: iadd
    //   1229: istore #6
    //   1231: aload_2
    //   1232: iload #4
    //   1234: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1237: iload_1
    //   1238: iconst_4
    //   1239: iushr
    //   1240: bipush #15
    //   1242: iand
    //   1243: caload
    //   1244: castore
    //   1245: aload_0
    //   1246: getfield buf : [C
    //   1249: iload #6
    //   1251: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1254: iload_1
    //   1255: bipush #15
    //   1257: iand
    //   1258: caload
    //   1259: castore
    //   1260: iload #6
    //   1262: iconst_1
    //   1263: iadd
    //   1264: istore #4
    //   1266: goto -> 1283
    //   1269: aload_0
    //   1270: getfield buf : [C
    //   1273: iload #4
    //   1275: iload_1
    //   1276: castore
    //   1277: iload #4
    //   1279: iconst_1
    //   1280: iadd
    //   1281: istore #4
    //   1283: iload #5
    //   1285: iconst_1
    //   1286: iadd
    //   1287: istore #5
    //   1289: goto -> 925
    //   1292: aload_0
    //   1293: getfield buf : [C
    //   1296: aload_0
    //   1297: getfield count : I
    //   1300: iconst_1
    //   1301: isub
    //   1302: bipush #34
    //   1304: castore
    //   1305: return
  }
  
  public void writeFloatAndChar(float paramFloat, char paramChar) {
    String str2 = Float.toString(paramFloat);
    String str1 = str2;
    if (str2.endsWith(".0"))
      str1 = str2.substring(0, str2.length() - 2); 
    write(str1);
    write(paramChar);
  }
  
  public void writeInt(int paramInt) {
    int i;
    if (paramInt == Integer.MIN_VALUE) {
      write("-2147483648");
      return;
    } 
    if (paramInt < 0) {
      i = IOUtils.stringSize(-paramInt) + 1;
    } else {
      i = IOUtils.stringSize(paramInt);
    } 
    int j = this.count + i;
    if (j > this.buf.length)
      if (this.writer == null) {
        expandCapacity(j);
      } else {
        char[] arrayOfChar = new char[i];
        IOUtils.getChars(paramInt, i, arrayOfChar);
        write(arrayOfChar, 0, arrayOfChar.length);
        return;
      }  
    IOUtils.getChars(paramInt, j, this.buf);
    this.count = j;
  }
  
  public void writeIntAndChar(int paramInt, char paramChar) {
    if (paramInt == Integer.MIN_VALUE) {
      write("-2147483648");
      write(paramChar);
      return;
    } 
    if (paramInt < 0) {
      i = IOUtils.stringSize(-paramInt) + 1;
    } else {
      i = IOUtils.stringSize(paramInt);
    } 
    int i = this.count + i;
    int j = i + 1;
    if (j > this.buf.length) {
      if (this.writer != null) {
        writeInt(paramInt);
        write(paramChar);
        return;
      } 
      expandCapacity(j);
    } 
    IOUtils.getChars(paramInt, i, this.buf);
    this.buf[i] = paramChar;
    this.count = j;
  }
  
  public void writeLong(long paramLong) {
    int i;
    int j;
    if (this.browserCompatible && !isEnabled(SerializerFeature.WriteClassName) && (paramLong > 9007199254740991L || paramLong < -9007199254740991L)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramLong == Long.MIN_VALUE) {
      if (i) {
        write("\"-9223372036854775808\"");
        return;
      } 
      write("-9223372036854775808");
      return;
    } 
    if (paramLong < 0L) {
      j = IOUtils.stringSize(-paramLong) + 1;
    } else {
      j = IOUtils.stringSize(paramLong);
    } 
    int m = this.count + j;
    int k = m;
    if (i)
      k = m + 2; 
    if (k > this.buf.length)
      if (this.writer == null) {
        expandCapacity(k);
      } else {
        char[] arrayOfChar = new char[j];
        IOUtils.getChars(paramLong, j, arrayOfChar);
        if (i) {
          write(34);
          write(arrayOfChar, 0, arrayOfChar.length);
          write(34);
          return;
        } 
        write(arrayOfChar, 0, arrayOfChar.length);
        return;
      }  
    if (i) {
      char[] arrayOfChar = this.buf;
      arrayOfChar[this.count] = '"';
      i = k - 1;
      IOUtils.getChars(paramLong, i, arrayOfChar);
      this.buf[i] = '"';
    } else {
      IOUtils.getChars(paramLong, k, this.buf);
    } 
    this.count = k;
  }
  
  public void writeLongAndChar(long paramLong, char paramChar) throws IOException {
    int i;
    if (this.browserCompatible && !isEnabled(SerializerFeature.WriteClassName) && (paramLong > 9007199254740991L || paramLong < -9007199254740991L)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (paramLong == Long.MIN_VALUE) {
      if (i) {
        write("\"-9223372036854775808\"");
      } else {
        write("-9223372036854775808");
      } 
      write(paramChar);
      return;
    } 
    if (paramLong < 0L) {
      j = IOUtils.stringSize(-paramLong) + 1;
    } else {
      j = IOUtils.stringSize(paramLong);
    } 
    int k = this.count + j;
    int j = k;
    if (i)
      j = k + 2; 
    k = j + 1;
    if (k > this.buf.length) {
      if (this.writer != null) {
        writeLong(paramLong);
        write(paramChar);
        return;
      } 
      expandCapacity(k);
    } 
    if (i) {
      char[] arrayOfChar = this.buf;
      arrayOfChar[this.count] = '"';
      i = j - 1;
      IOUtils.getChars(paramLong, i, arrayOfChar);
      this.buf[i] = '"';
    } else {
      IOUtils.getChars(paramLong, j, this.buf);
    } 
    this.buf[j] = paramChar;
    this.count = k;
  }
  
  public void writeNull() {
    write("null");
  }
  
  public void writeString(String paramString) {
    if (this.useSingleQuotes) {
      writeStringWithSingleQuote(paramString);
      return;
    } 
    writeStringWithDoubleQuote(paramString, false);
  }
  
  public void writeString(String paramString, char paramChar) {
    if (this.useSingleQuotes) {
      writeStringWithSingleQuote(paramString);
      write(paramChar);
      return;
    } 
    writeStringWithDoubleQuote(paramString, paramChar);
  }
  
  public void writeStringWithDoubleQuote(String paramString, char paramChar) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 18
    //   4: aload_0
    //   5: invokevirtual writeNull : ()V
    //   8: iload_2
    //   9: ifeq -> 17
    //   12: aload_0
    //   13: iload_2
    //   14: invokevirtual write : (I)V
    //   17: return
    //   18: aload_1
    //   19: invokevirtual length : ()I
    //   22: istore #6
    //   24: aload_0
    //   25: getfield count : I
    //   28: iload #6
    //   30: iadd
    //   31: iconst_2
    //   32: iadd
    //   33: istore #5
    //   35: iload #5
    //   37: istore #4
    //   39: iload_2
    //   40: ifeq -> 49
    //   43: iload #5
    //   45: iconst_1
    //   46: iadd
    //   47: istore #4
    //   49: aload_0
    //   50: getfield buf : [C
    //   53: arraylength
    //   54: istore #7
    //   56: iconst_0
    //   57: istore #12
    //   59: iconst_0
    //   60: istore #5
    //   62: iload #4
    //   64: iload #7
    //   66: if_icmple -> 651
    //   69: aload_0
    //   70: getfield writer : Ljava/io/Writer;
    //   73: ifnull -> 645
    //   76: aload_0
    //   77: bipush #34
    //   79: invokevirtual write : (I)V
    //   82: iload #5
    //   84: istore #4
    //   86: iload #4
    //   88: aload_1
    //   89: invokevirtual length : ()I
    //   92: if_icmpge -> 629
    //   95: aload_1
    //   96: iload #4
    //   98: invokevirtual charAt : (I)C
    //   101: istore #5
    //   103: aload_0
    //   104: getfield browserSecure : Z
    //   107: ifeq -> 248
    //   110: iload #5
    //   112: bipush #48
    //   114: if_icmplt -> 124
    //   117: iload #5
    //   119: bipush #57
    //   121: if_icmple -> 614
    //   124: iload #5
    //   126: bipush #97
    //   128: if_icmplt -> 138
    //   131: iload #5
    //   133: bipush #122
    //   135: if_icmple -> 614
    //   138: iload #5
    //   140: bipush #65
    //   142: if_icmplt -> 152
    //   145: iload #5
    //   147: bipush #90
    //   149: if_icmple -> 614
    //   152: iload #5
    //   154: bipush #44
    //   156: if_icmpeq -> 614
    //   159: iload #5
    //   161: bipush #46
    //   163: if_icmpeq -> 614
    //   166: iload #5
    //   168: bipush #95
    //   170: if_icmpeq -> 614
    //   173: aload_0
    //   174: bipush #92
    //   176: invokevirtual write : (I)V
    //   179: aload_0
    //   180: bipush #117
    //   182: invokevirtual write : (I)V
    //   185: aload_0
    //   186: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   189: iload #5
    //   191: bipush #12
    //   193: iushr
    //   194: bipush #15
    //   196: iand
    //   197: caload
    //   198: invokevirtual write : (I)V
    //   201: aload_0
    //   202: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   205: iload #5
    //   207: bipush #8
    //   209: iushr
    //   210: bipush #15
    //   212: iand
    //   213: caload
    //   214: invokevirtual write : (I)V
    //   217: aload_0
    //   218: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   221: iload #5
    //   223: iconst_4
    //   224: iushr
    //   225: bipush #15
    //   227: iand
    //   228: caload
    //   229: invokevirtual write : (I)V
    //   232: aload_0
    //   233: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   236: iload #5
    //   238: bipush #15
    //   240: iand
    //   241: caload
    //   242: invokevirtual write : (I)V
    //   245: goto -> 620
    //   248: aload_0
    //   249: getfield browserCompatible : Z
    //   252: ifeq -> 481
    //   255: iload #5
    //   257: bipush #8
    //   259: if_icmpeq -> 462
    //   262: iload #5
    //   264: bipush #12
    //   266: if_icmpeq -> 462
    //   269: iload #5
    //   271: bipush #10
    //   273: if_icmpeq -> 462
    //   276: iload #5
    //   278: bipush #13
    //   280: if_icmpeq -> 462
    //   283: iload #5
    //   285: bipush #9
    //   287: if_icmpeq -> 462
    //   290: iload #5
    //   292: bipush #34
    //   294: if_icmpeq -> 462
    //   297: iload #5
    //   299: bipush #47
    //   301: if_icmpeq -> 462
    //   304: iload #5
    //   306: bipush #92
    //   308: if_icmpne -> 314
    //   311: goto -> 462
    //   314: iload #5
    //   316: bipush #32
    //   318: if_icmpge -> 380
    //   321: aload_0
    //   322: bipush #92
    //   324: invokevirtual write : (I)V
    //   327: aload_0
    //   328: bipush #117
    //   330: invokevirtual write : (I)V
    //   333: aload_0
    //   334: bipush #48
    //   336: invokevirtual write : (I)V
    //   339: aload_0
    //   340: bipush #48
    //   342: invokevirtual write : (I)V
    //   345: getstatic com/alibaba/fastjson/util/IOUtils.ASCII_CHARS : [C
    //   348: astore #18
    //   350: iload #5
    //   352: iconst_2
    //   353: imul
    //   354: istore #5
    //   356: aload_0
    //   357: aload #18
    //   359: iload #5
    //   361: caload
    //   362: invokevirtual write : (I)V
    //   365: aload_0
    //   366: getstatic com/alibaba/fastjson/util/IOUtils.ASCII_CHARS : [C
    //   369: iload #5
    //   371: iconst_1
    //   372: iadd
    //   373: caload
    //   374: invokevirtual write : (I)V
    //   377: goto -> 620
    //   380: iload #5
    //   382: bipush #127
    //   384: if_icmplt -> 614
    //   387: aload_0
    //   388: bipush #92
    //   390: invokevirtual write : (I)V
    //   393: aload_0
    //   394: bipush #117
    //   396: invokevirtual write : (I)V
    //   399: aload_0
    //   400: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   403: iload #5
    //   405: bipush #12
    //   407: iushr
    //   408: bipush #15
    //   410: iand
    //   411: caload
    //   412: invokevirtual write : (I)V
    //   415: aload_0
    //   416: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   419: iload #5
    //   421: bipush #8
    //   423: iushr
    //   424: bipush #15
    //   426: iand
    //   427: caload
    //   428: invokevirtual write : (I)V
    //   431: aload_0
    //   432: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   435: iload #5
    //   437: iconst_4
    //   438: iushr
    //   439: bipush #15
    //   441: iand
    //   442: caload
    //   443: invokevirtual write : (I)V
    //   446: aload_0
    //   447: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   450: iload #5
    //   452: bipush #15
    //   454: iand
    //   455: caload
    //   456: invokevirtual write : (I)V
    //   459: goto -> 620
    //   462: aload_0
    //   463: bipush #92
    //   465: invokevirtual write : (I)V
    //   468: aload_0
    //   469: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   472: iload #5
    //   474: caload
    //   475: invokevirtual write : (I)V
    //   478: goto -> 620
    //   481: iload #5
    //   483: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   486: arraylength
    //   487: if_icmpge -> 499
    //   490: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   493: iload #5
    //   495: baload
    //   496: ifne -> 516
    //   499: iload #5
    //   501: bipush #47
    //   503: if_icmpne -> 614
    //   506: aload_0
    //   507: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   510: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   513: ifeq -> 614
    //   516: aload_0
    //   517: bipush #92
    //   519: invokevirtual write : (I)V
    //   522: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   525: iload #5
    //   527: baload
    //   528: iconst_4
    //   529: if_icmpne -> 601
    //   532: aload_0
    //   533: bipush #117
    //   535: invokevirtual write : (I)V
    //   538: aload_0
    //   539: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   542: iload #5
    //   544: bipush #12
    //   546: iushr
    //   547: bipush #15
    //   549: iand
    //   550: caload
    //   551: invokevirtual write : (I)V
    //   554: aload_0
    //   555: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   558: iload #5
    //   560: bipush #8
    //   562: iushr
    //   563: bipush #15
    //   565: iand
    //   566: caload
    //   567: invokevirtual write : (I)V
    //   570: aload_0
    //   571: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   574: iload #5
    //   576: iconst_4
    //   577: iushr
    //   578: bipush #15
    //   580: iand
    //   581: caload
    //   582: invokevirtual write : (I)V
    //   585: aload_0
    //   586: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   589: iload #5
    //   591: bipush #15
    //   593: iand
    //   594: caload
    //   595: invokevirtual write : (I)V
    //   598: goto -> 620
    //   601: aload_0
    //   602: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   605: iload #5
    //   607: caload
    //   608: invokevirtual write : (I)V
    //   611: goto -> 620
    //   614: aload_0
    //   615: iload #5
    //   617: invokevirtual write : (I)V
    //   620: iload #4
    //   622: iconst_1
    //   623: iadd
    //   624: istore #4
    //   626: goto -> 86
    //   629: aload_0
    //   630: bipush #34
    //   632: invokevirtual write : (I)V
    //   635: iload_2
    //   636: ifeq -> 644
    //   639: aload_0
    //   640: iload_2
    //   641: invokevirtual write : (I)V
    //   644: return
    //   645: aload_0
    //   646: iload #4
    //   648: invokevirtual expandCapacity : (I)V
    //   651: aload_0
    //   652: getfield count : I
    //   655: istore #5
    //   657: iload #5
    //   659: iconst_1
    //   660: iadd
    //   661: istore #9
    //   663: iload #9
    //   665: iload #6
    //   667: iadd
    //   668: istore #11
    //   670: aload_0
    //   671: getfield buf : [C
    //   674: astore #18
    //   676: aload #18
    //   678: iload #5
    //   680: bipush #34
    //   682: castore
    //   683: aload_1
    //   684: iconst_0
    //   685: iload #6
    //   687: aload #18
    //   689: iload #9
    //   691: invokevirtual getChars : (II[CI)V
    //   694: aload_0
    //   695: iload #4
    //   697: putfield count : I
    //   700: aload_0
    //   701: getfield browserSecure : Z
    //   704: istore #17
    //   706: iconst_m1
    //   707: istore #5
    //   709: iload #17
    //   711: ifeq -> 1193
    //   714: iload #9
    //   716: istore #6
    //   718: iload #4
    //   720: istore #7
    //   722: iload #6
    //   724: istore #4
    //   726: iload #4
    //   728: iload #11
    //   730: if_icmpge -> 880
    //   733: aload_0
    //   734: getfield buf : [C
    //   737: iload #4
    //   739: caload
    //   740: istore #10
    //   742: iload #10
    //   744: bipush #48
    //   746: if_icmplt -> 764
    //   749: iload #7
    //   751: istore #8
    //   753: iload #5
    //   755: istore #6
    //   757: iload #10
    //   759: bipush #57
    //   761: if_icmple -> 863
    //   764: iload #10
    //   766: bipush #97
    //   768: if_icmplt -> 786
    //   771: iload #7
    //   773: istore #8
    //   775: iload #5
    //   777: istore #6
    //   779: iload #10
    //   781: bipush #122
    //   783: if_icmple -> 863
    //   786: iload #10
    //   788: bipush #65
    //   790: if_icmplt -> 808
    //   793: iload #7
    //   795: istore #8
    //   797: iload #5
    //   799: istore #6
    //   801: iload #10
    //   803: bipush #90
    //   805: if_icmple -> 863
    //   808: iload #7
    //   810: istore #8
    //   812: iload #5
    //   814: istore #6
    //   816: iload #10
    //   818: bipush #44
    //   820: if_icmpeq -> 863
    //   823: iload #7
    //   825: istore #8
    //   827: iload #5
    //   829: istore #6
    //   831: iload #10
    //   833: bipush #46
    //   835: if_icmpeq -> 863
    //   838: iload #7
    //   840: istore #8
    //   842: iload #5
    //   844: istore #6
    //   846: iload #10
    //   848: bipush #95
    //   850: if_icmpeq -> 863
    //   853: iload #7
    //   855: iconst_5
    //   856: iadd
    //   857: istore #8
    //   859: iload #4
    //   861: istore #6
    //   863: iload #4
    //   865: iconst_1
    //   866: iadd
    //   867: istore #4
    //   869: iload #8
    //   871: istore #7
    //   873: iload #6
    //   875: istore #5
    //   877: goto -> 726
    //   880: iload #7
    //   882: aload_0
    //   883: getfield buf : [C
    //   886: arraylength
    //   887: if_icmple -> 896
    //   890: aload_0
    //   891: iload #7
    //   893: invokevirtual expandCapacity : (I)V
    //   896: aload_0
    //   897: iload #7
    //   899: putfield count : I
    //   902: iload #5
    //   904: iload #9
    //   906: if_icmplt -> 1148
    //   909: aload_0
    //   910: getfield buf : [C
    //   913: iload #5
    //   915: caload
    //   916: istore #6
    //   918: iload #6
    //   920: bipush #48
    //   922: if_icmplt -> 936
    //   925: iload #11
    //   927: istore #4
    //   929: iload #6
    //   931: bipush #57
    //   933: if_icmple -> 1135
    //   936: iload #6
    //   938: bipush #97
    //   940: if_icmplt -> 954
    //   943: iload #11
    //   945: istore #4
    //   947: iload #6
    //   949: bipush #122
    //   951: if_icmple -> 1135
    //   954: iload #6
    //   956: bipush #65
    //   958: if_icmplt -> 972
    //   961: iload #11
    //   963: istore #4
    //   965: iload #6
    //   967: bipush #90
    //   969: if_icmple -> 1135
    //   972: iload #11
    //   974: istore #4
    //   976: iload #6
    //   978: bipush #44
    //   980: if_icmpeq -> 1135
    //   983: iload #11
    //   985: istore #4
    //   987: iload #6
    //   989: bipush #46
    //   991: if_icmpeq -> 1135
    //   994: iload #11
    //   996: istore #4
    //   998: iload #6
    //   1000: bipush #95
    //   1002: if_icmpeq -> 1135
    //   1005: aload_0
    //   1006: getfield buf : [C
    //   1009: astore_1
    //   1010: iload #5
    //   1012: iconst_1
    //   1013: iadd
    //   1014: istore #4
    //   1016: aload_1
    //   1017: iload #4
    //   1019: aload_1
    //   1020: iload #5
    //   1022: bipush #6
    //   1024: iadd
    //   1025: iload #11
    //   1027: iload #5
    //   1029: isub
    //   1030: iconst_1
    //   1031: isub
    //   1032: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1035: aload_0
    //   1036: getfield buf : [C
    //   1039: astore_1
    //   1040: aload_1
    //   1041: iload #5
    //   1043: bipush #92
    //   1045: castore
    //   1046: aload_1
    //   1047: iload #4
    //   1049: bipush #117
    //   1051: castore
    //   1052: aload_1
    //   1053: iload #5
    //   1055: iconst_2
    //   1056: iadd
    //   1057: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1060: iload #6
    //   1062: bipush #12
    //   1064: iushr
    //   1065: bipush #15
    //   1067: iand
    //   1068: caload
    //   1069: castore
    //   1070: aload_0
    //   1071: getfield buf : [C
    //   1074: iload #5
    //   1076: iconst_3
    //   1077: iadd
    //   1078: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1081: iload #6
    //   1083: bipush #8
    //   1085: iushr
    //   1086: bipush #15
    //   1088: iand
    //   1089: caload
    //   1090: castore
    //   1091: aload_0
    //   1092: getfield buf : [C
    //   1095: iload #5
    //   1097: iconst_4
    //   1098: iadd
    //   1099: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1102: iload #6
    //   1104: iconst_4
    //   1105: iushr
    //   1106: bipush #15
    //   1108: iand
    //   1109: caload
    //   1110: castore
    //   1111: aload_0
    //   1112: getfield buf : [C
    //   1115: iload #5
    //   1117: iconst_5
    //   1118: iadd
    //   1119: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1122: iload #6
    //   1124: bipush #15
    //   1126: iand
    //   1127: caload
    //   1128: castore
    //   1129: iload #11
    //   1131: iconst_5
    //   1132: iadd
    //   1133: istore #4
    //   1135: iload #5
    //   1137: iconst_1
    //   1138: isub
    //   1139: istore #5
    //   1141: iload #4
    //   1143: istore #11
    //   1145: goto -> 902
    //   1148: iload_2
    //   1149: ifeq -> 1179
    //   1152: aload_0
    //   1153: getfield buf : [C
    //   1156: astore_1
    //   1157: aload_0
    //   1158: getfield count : I
    //   1161: istore #4
    //   1163: aload_1
    //   1164: iload #4
    //   1166: iconst_2
    //   1167: isub
    //   1168: bipush #34
    //   1170: castore
    //   1171: aload_1
    //   1172: iload #4
    //   1174: iconst_1
    //   1175: isub
    //   1176: iload_2
    //   1177: castore
    //   1178: return
    //   1179: aload_0
    //   1180: getfield buf : [C
    //   1183: aload_0
    //   1184: getfield count : I
    //   1187: iconst_1
    //   1188: isub
    //   1189: bipush #34
    //   1191: castore
    //   1192: return
    //   1193: aload_0
    //   1194: getfield browserCompatible : Z
    //   1197: ifeq -> 1848
    //   1200: iload #9
    //   1202: istore #7
    //   1204: iload #4
    //   1206: istore #6
    //   1208: iload #7
    //   1210: istore #4
    //   1212: iload #4
    //   1214: iload #11
    //   1216: if_icmpge -> 1355
    //   1219: aload_0
    //   1220: getfield buf : [C
    //   1223: iload #4
    //   1225: caload
    //   1226: istore #10
    //   1228: iload #10
    //   1230: bipush #34
    //   1232: if_icmpeq -> 1324
    //   1235: iload #10
    //   1237: bipush #47
    //   1239: if_icmpeq -> 1324
    //   1242: iload #10
    //   1244: bipush #92
    //   1246: if_icmpne -> 1252
    //   1249: goto -> 1324
    //   1252: iload #10
    //   1254: bipush #8
    //   1256: if_icmpeq -> 1324
    //   1259: iload #10
    //   1261: bipush #12
    //   1263: if_icmpeq -> 1324
    //   1266: iload #10
    //   1268: bipush #10
    //   1270: if_icmpeq -> 1324
    //   1273: iload #10
    //   1275: bipush #13
    //   1277: if_icmpeq -> 1324
    //   1280: iload #10
    //   1282: bipush #9
    //   1284: if_icmpne -> 1290
    //   1287: goto -> 1324
    //   1290: iload #10
    //   1292: bipush #32
    //   1294: if_icmpge -> 1306
    //   1297: iload #6
    //   1299: iconst_5
    //   1300: iadd
    //   1301: istore #5
    //   1303: goto -> 1330
    //   1306: iload #6
    //   1308: istore #7
    //   1310: iload #5
    //   1312: istore #8
    //   1314: iload #10
    //   1316: bipush #127
    //   1318: if_icmplt -> 1338
    //   1321: goto -> 1297
    //   1324: iload #6
    //   1326: iconst_1
    //   1327: iadd
    //   1328: istore #5
    //   1330: iload #4
    //   1332: istore #8
    //   1334: iload #5
    //   1336: istore #7
    //   1338: iload #4
    //   1340: iconst_1
    //   1341: iadd
    //   1342: istore #4
    //   1344: iload #7
    //   1346: istore #6
    //   1348: iload #8
    //   1350: istore #5
    //   1352: goto -> 1212
    //   1355: iload #6
    //   1357: aload_0
    //   1358: getfield buf : [C
    //   1361: arraylength
    //   1362: if_icmple -> 1371
    //   1365: aload_0
    //   1366: iload #6
    //   1368: invokevirtual expandCapacity : (I)V
    //   1371: aload_0
    //   1372: iload #6
    //   1374: putfield count : I
    //   1377: iload #5
    //   1379: iload #9
    //   1381: if_icmplt -> 1803
    //   1384: aload_0
    //   1385: getfield buf : [C
    //   1388: astore_1
    //   1389: aload_1
    //   1390: iload #5
    //   1392: caload
    //   1393: istore_3
    //   1394: iload_3
    //   1395: bipush #8
    //   1397: if_icmpeq -> 1735
    //   1400: iload_3
    //   1401: bipush #12
    //   1403: if_icmpeq -> 1735
    //   1406: iload_3
    //   1407: bipush #10
    //   1409: if_icmpeq -> 1735
    //   1412: iload_3
    //   1413: bipush #13
    //   1415: if_icmpeq -> 1735
    //   1418: iload_3
    //   1419: bipush #9
    //   1421: if_icmpne -> 1427
    //   1424: goto -> 1735
    //   1427: iload_3
    //   1428: bipush #34
    //   1430: if_icmpeq -> 1687
    //   1433: iload_3
    //   1434: bipush #47
    //   1436: if_icmpeq -> 1687
    //   1439: iload_3
    //   1440: bipush #92
    //   1442: if_icmpne -> 1448
    //   1445: goto -> 1687
    //   1448: iload_3
    //   1449: bipush #32
    //   1451: if_icmpge -> 1559
    //   1454: iload #5
    //   1456: iconst_1
    //   1457: iadd
    //   1458: istore #4
    //   1460: aload_1
    //   1461: iload #4
    //   1463: aload_1
    //   1464: iload #5
    //   1466: bipush #6
    //   1468: iadd
    //   1469: iload #11
    //   1471: iload #5
    //   1473: isub
    //   1474: iconst_1
    //   1475: isub
    //   1476: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1479: aload_0
    //   1480: getfield buf : [C
    //   1483: astore_1
    //   1484: aload_1
    //   1485: iload #5
    //   1487: bipush #92
    //   1489: castore
    //   1490: aload_1
    //   1491: iload #4
    //   1493: bipush #117
    //   1495: castore
    //   1496: aload_1
    //   1497: iload #5
    //   1499: iconst_2
    //   1500: iadd
    //   1501: bipush #48
    //   1503: castore
    //   1504: aload_1
    //   1505: iload #5
    //   1507: iconst_3
    //   1508: iadd
    //   1509: bipush #48
    //   1511: castore
    //   1512: getstatic com/alibaba/fastjson/util/IOUtils.ASCII_CHARS : [C
    //   1515: astore #18
    //   1517: iload_3
    //   1518: iconst_2
    //   1519: imul
    //   1520: istore #4
    //   1522: aload_1
    //   1523: iload #5
    //   1525: iconst_4
    //   1526: iadd
    //   1527: aload #18
    //   1529: iload #4
    //   1531: caload
    //   1532: castore
    //   1533: aload_0
    //   1534: getfield buf : [C
    //   1537: iload #5
    //   1539: iconst_5
    //   1540: iadd
    //   1541: getstatic com/alibaba/fastjson/util/IOUtils.ASCII_CHARS : [C
    //   1544: iload #4
    //   1546: iconst_1
    //   1547: iadd
    //   1548: caload
    //   1549: castore
    //   1550: iload #11
    //   1552: iconst_5
    //   1553: iadd
    //   1554: istore #4
    //   1556: goto -> 1790
    //   1559: iload #11
    //   1561: istore #4
    //   1563: iload_3
    //   1564: bipush #127
    //   1566: if_icmplt -> 1790
    //   1569: iload #5
    //   1571: iconst_1
    //   1572: iadd
    //   1573: istore #4
    //   1575: aload_1
    //   1576: iload #4
    //   1578: aload_1
    //   1579: iload #5
    //   1581: bipush #6
    //   1583: iadd
    //   1584: iload #11
    //   1586: iload #5
    //   1588: isub
    //   1589: iconst_1
    //   1590: isub
    //   1591: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1594: aload_0
    //   1595: getfield buf : [C
    //   1598: astore_1
    //   1599: aload_1
    //   1600: iload #5
    //   1602: bipush #92
    //   1604: castore
    //   1605: aload_1
    //   1606: iload #4
    //   1608: bipush #117
    //   1610: castore
    //   1611: aload_1
    //   1612: iload #5
    //   1614: iconst_2
    //   1615: iadd
    //   1616: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1619: iload_3
    //   1620: bipush #12
    //   1622: iushr
    //   1623: bipush #15
    //   1625: iand
    //   1626: caload
    //   1627: castore
    //   1628: aload_0
    //   1629: getfield buf : [C
    //   1632: iload #5
    //   1634: iconst_3
    //   1635: iadd
    //   1636: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1639: iload_3
    //   1640: bipush #8
    //   1642: iushr
    //   1643: bipush #15
    //   1645: iand
    //   1646: caload
    //   1647: castore
    //   1648: aload_0
    //   1649: getfield buf : [C
    //   1652: iload #5
    //   1654: iconst_4
    //   1655: iadd
    //   1656: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1659: iload_3
    //   1660: iconst_4
    //   1661: iushr
    //   1662: bipush #15
    //   1664: iand
    //   1665: caload
    //   1666: castore
    //   1667: aload_0
    //   1668: getfield buf : [C
    //   1671: iload #5
    //   1673: iconst_5
    //   1674: iadd
    //   1675: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1678: iload_3
    //   1679: bipush #15
    //   1681: iand
    //   1682: caload
    //   1683: castore
    //   1684: goto -> 1550
    //   1687: aload_0
    //   1688: getfield buf : [C
    //   1691: astore_1
    //   1692: iload #5
    //   1694: iconst_1
    //   1695: iadd
    //   1696: istore #4
    //   1698: aload_1
    //   1699: iload #4
    //   1701: aload_1
    //   1702: iload #5
    //   1704: iconst_2
    //   1705: iadd
    //   1706: iload #11
    //   1708: iload #5
    //   1710: isub
    //   1711: iconst_1
    //   1712: isub
    //   1713: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1716: aload_0
    //   1717: getfield buf : [C
    //   1720: astore_1
    //   1721: aload_1
    //   1722: iload #5
    //   1724: bipush #92
    //   1726: castore
    //   1727: aload_1
    //   1728: iload #4
    //   1730: iload_3
    //   1731: castore
    //   1732: goto -> 1784
    //   1735: aload_0
    //   1736: getfield buf : [C
    //   1739: astore_1
    //   1740: iload #5
    //   1742: iconst_1
    //   1743: iadd
    //   1744: istore #4
    //   1746: aload_1
    //   1747: iload #4
    //   1749: aload_1
    //   1750: iload #5
    //   1752: iconst_2
    //   1753: iadd
    //   1754: iload #11
    //   1756: iload #5
    //   1758: isub
    //   1759: iconst_1
    //   1760: isub
    //   1761: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1764: aload_0
    //   1765: getfield buf : [C
    //   1768: astore_1
    //   1769: aload_1
    //   1770: iload #5
    //   1772: bipush #92
    //   1774: castore
    //   1775: aload_1
    //   1776: iload #4
    //   1778: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   1781: iload_3
    //   1782: caload
    //   1783: castore
    //   1784: iload #11
    //   1786: iconst_1
    //   1787: iadd
    //   1788: istore #4
    //   1790: iload #5
    //   1792: iconst_1
    //   1793: isub
    //   1794: istore #5
    //   1796: iload #4
    //   1798: istore #11
    //   1800: goto -> 1377
    //   1803: iload_2
    //   1804: ifeq -> 1834
    //   1807: aload_0
    //   1808: getfield buf : [C
    //   1811: astore_1
    //   1812: aload_0
    //   1813: getfield count : I
    //   1816: istore #4
    //   1818: aload_1
    //   1819: iload #4
    //   1821: iconst_2
    //   1822: isub
    //   1823: bipush #34
    //   1825: castore
    //   1826: aload_1
    //   1827: iload #4
    //   1829: iconst_1
    //   1830: isub
    //   1831: iload_2
    //   1832: castore
    //   1833: return
    //   1834: aload_0
    //   1835: getfield buf : [C
    //   1838: aload_0
    //   1839: getfield count : I
    //   1842: iconst_1
    //   1843: isub
    //   1844: bipush #34
    //   1846: castore
    //   1847: return
    //   1848: iload #9
    //   1850: istore #10
    //   1852: iconst_m1
    //   1853: istore #5
    //   1855: iconst_0
    //   1856: istore #7
    //   1858: iconst_m1
    //   1859: istore #8
    //   1861: iload #4
    //   1863: istore #6
    //   1865: iload #10
    //   1867: istore #4
    //   1869: iload #4
    //   1871: iload #11
    //   1873: if_icmpge -> 2176
    //   1876: aload_0
    //   1877: getfield buf : [C
    //   1880: iload #4
    //   1882: caload
    //   1883: istore_3
    //   1884: iload_3
    //   1885: sipush #8232
    //   1888: if_icmpne -> 1962
    //   1891: iload #12
    //   1893: iconst_1
    //   1894: iadd
    //   1895: istore #8
    //   1897: iload #6
    //   1899: iconst_4
    //   1900: iadd
    //   1901: istore #12
    //   1903: iload #12
    //   1905: istore #6
    //   1907: iload #8
    //   1909: istore #7
    //   1911: iload #5
    //   1913: istore #10
    //   1915: iload #5
    //   1917: iconst_m1
    //   1918: if_icmpne -> 1936
    //   1921: iload #8
    //   1923: istore #7
    //   1925: iload #12
    //   1927: istore #6
    //   1929: iload #4
    //   1931: istore #5
    //   1933: goto -> 1940
    //   1936: iload #10
    //   1938: istore #5
    //   1940: iload #4
    //   1942: istore #16
    //   1944: iload_3
    //   1945: istore #15
    //   1947: iload #6
    //   1949: istore #10
    //   1951: iload #7
    //   1953: istore #13
    //   1955: iload #5
    //   1957: istore #14
    //   1959: goto -> 2147
    //   1962: iload_3
    //   1963: bipush #93
    //   1965: if_icmplt -> 2050
    //   1968: iload #6
    //   1970: istore #10
    //   1972: iload #12
    //   1974: istore #13
    //   1976: iload #5
    //   1978: istore #14
    //   1980: iload #7
    //   1982: istore #15
    //   1984: iload #8
    //   1986: istore #16
    //   1988: iload_3
    //   1989: bipush #127
    //   1991: if_icmplt -> 2147
    //   1994: iload #6
    //   1996: istore #10
    //   1998: iload #12
    //   2000: istore #13
    //   2002: iload #5
    //   2004: istore #14
    //   2006: iload #7
    //   2008: istore #15
    //   2010: iload #8
    //   2012: istore #16
    //   2014: iload_3
    //   2015: sipush #160
    //   2018: if_icmpgt -> 2147
    //   2021: iload #5
    //   2023: istore #10
    //   2025: iload #5
    //   2027: iconst_m1
    //   2028: if_icmpne -> 2035
    //   2031: iload #4
    //   2033: istore #10
    //   2035: iload #12
    //   2037: iconst_1
    //   2038: iadd
    //   2039: istore #7
    //   2041: iload #6
    //   2043: iconst_4
    //   2044: iadd
    //   2045: istore #6
    //   2047: goto -> 1936
    //   2050: iload #6
    //   2052: istore #10
    //   2054: iload #12
    //   2056: istore #13
    //   2058: iload #5
    //   2060: istore #14
    //   2062: iload #7
    //   2064: istore #15
    //   2066: iload #8
    //   2068: istore #16
    //   2070: iload_3
    //   2071: aload_0
    //   2072: getfield features : I
    //   2075: invokestatic isSpecial : (CI)Z
    //   2078: ifeq -> 2147
    //   2081: iload #12
    //   2083: iconst_1
    //   2084: iadd
    //   2085: istore #12
    //   2087: iload #6
    //   2089: istore #8
    //   2091: iload_3
    //   2092: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2095: arraylength
    //   2096: if_icmpge -> 2118
    //   2099: iload #6
    //   2101: istore #8
    //   2103: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2106: iload_3
    //   2107: baload
    //   2108: iconst_4
    //   2109: if_icmpne -> 2118
    //   2112: iload #6
    //   2114: iconst_4
    //   2115: iadd
    //   2116: istore #8
    //   2118: iload #8
    //   2120: istore #6
    //   2122: iload #12
    //   2124: istore #7
    //   2126: iload #5
    //   2128: istore #10
    //   2130: iload #5
    //   2132: iconst_m1
    //   2133: if_icmpne -> 1936
    //   2136: iload #8
    //   2138: istore #6
    //   2140: iload #12
    //   2142: istore #7
    //   2144: goto -> 1929
    //   2147: iload #4
    //   2149: iconst_1
    //   2150: iadd
    //   2151: istore #4
    //   2153: iload #10
    //   2155: istore #6
    //   2157: iload #13
    //   2159: istore #12
    //   2161: iload #14
    //   2163: istore #5
    //   2165: iload #15
    //   2167: istore #7
    //   2169: iload #16
    //   2171: istore #8
    //   2173: goto -> 1869
    //   2176: iload #12
    //   2178: ifle -> 2950
    //   2181: iload #6
    //   2183: iload #12
    //   2185: iadd
    //   2186: istore #4
    //   2188: iload #4
    //   2190: aload_0
    //   2191: getfield buf : [C
    //   2194: arraylength
    //   2195: if_icmple -> 2204
    //   2198: aload_0
    //   2199: iload #4
    //   2201: invokevirtual expandCapacity : (I)V
    //   2204: aload_0
    //   2205: iload #4
    //   2207: putfield count : I
    //   2210: iload #12
    //   2212: iconst_1
    //   2213: if_icmpne -> 2531
    //   2216: iload #7
    //   2218: sipush #8232
    //   2221: if_icmpne -> 2318
    //   2224: iload #8
    //   2226: iconst_1
    //   2227: iadd
    //   2228: istore #4
    //   2230: aload_0
    //   2231: getfield buf : [C
    //   2234: astore_1
    //   2235: aload_1
    //   2236: iload #4
    //   2238: aload_1
    //   2239: iload #8
    //   2241: bipush #6
    //   2243: iadd
    //   2244: iload #11
    //   2246: iload #8
    //   2248: isub
    //   2249: iconst_1
    //   2250: isub
    //   2251: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2254: aload_0
    //   2255: getfield buf : [C
    //   2258: astore_1
    //   2259: aload_1
    //   2260: iload #8
    //   2262: bipush #92
    //   2264: castore
    //   2265: aload_1
    //   2266: iload #4
    //   2268: bipush #117
    //   2270: castore
    //   2271: iload #4
    //   2273: iconst_1
    //   2274: iadd
    //   2275: istore #4
    //   2277: aload_1
    //   2278: iload #4
    //   2280: bipush #50
    //   2282: castore
    //   2283: iload #4
    //   2285: iconst_1
    //   2286: iadd
    //   2287: istore #4
    //   2289: aload_1
    //   2290: iload #4
    //   2292: bipush #48
    //   2294: castore
    //   2295: iload #4
    //   2297: iconst_1
    //   2298: iadd
    //   2299: istore #4
    //   2301: aload_1
    //   2302: iload #4
    //   2304: bipush #50
    //   2306: castore
    //   2307: aload_1
    //   2308: iload #4
    //   2310: iconst_1
    //   2311: iadd
    //   2312: bipush #56
    //   2314: castore
    //   2315: goto -> 2950
    //   2318: iload #7
    //   2320: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2323: arraylength
    //   2324: if_icmpge -> 2478
    //   2327: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2330: iload #7
    //   2332: baload
    //   2333: iconst_4
    //   2334: if_icmpne -> 2478
    //   2337: iload #8
    //   2339: iconst_1
    //   2340: iadd
    //   2341: istore #4
    //   2343: aload_0
    //   2344: getfield buf : [C
    //   2347: astore_1
    //   2348: aload_1
    //   2349: iload #4
    //   2351: aload_1
    //   2352: iload #8
    //   2354: bipush #6
    //   2356: iadd
    //   2357: iload #11
    //   2359: iload #8
    //   2361: isub
    //   2362: iconst_1
    //   2363: isub
    //   2364: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2367: aload_0
    //   2368: getfield buf : [C
    //   2371: astore_1
    //   2372: aload_1
    //   2373: iload #8
    //   2375: bipush #92
    //   2377: castore
    //   2378: iload #4
    //   2380: iconst_1
    //   2381: iadd
    //   2382: istore #5
    //   2384: aload_1
    //   2385: iload #4
    //   2387: bipush #117
    //   2389: castore
    //   2390: iload #5
    //   2392: iconst_1
    //   2393: iadd
    //   2394: istore #4
    //   2396: aload_1
    //   2397: iload #5
    //   2399: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2402: iload #7
    //   2404: bipush #12
    //   2406: iushr
    //   2407: bipush #15
    //   2409: iand
    //   2410: caload
    //   2411: castore
    //   2412: aload_0
    //   2413: getfield buf : [C
    //   2416: astore_1
    //   2417: iload #4
    //   2419: iconst_1
    //   2420: iadd
    //   2421: istore #5
    //   2423: aload_1
    //   2424: iload #4
    //   2426: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2429: iload #7
    //   2431: bipush #8
    //   2433: iushr
    //   2434: bipush #15
    //   2436: iand
    //   2437: caload
    //   2438: castore
    //   2439: aload_0
    //   2440: getfield buf : [C
    //   2443: iload #5
    //   2445: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2448: iload #7
    //   2450: iconst_4
    //   2451: iushr
    //   2452: bipush #15
    //   2454: iand
    //   2455: caload
    //   2456: castore
    //   2457: aload_0
    //   2458: getfield buf : [C
    //   2461: iload #5
    //   2463: iconst_1
    //   2464: iadd
    //   2465: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2468: iload #7
    //   2470: bipush #15
    //   2472: iand
    //   2473: caload
    //   2474: castore
    //   2475: goto -> 2950
    //   2478: iload #8
    //   2480: iconst_1
    //   2481: iadd
    //   2482: istore #4
    //   2484: aload_0
    //   2485: getfield buf : [C
    //   2488: astore_1
    //   2489: aload_1
    //   2490: iload #4
    //   2492: aload_1
    //   2493: iload #8
    //   2495: iconst_2
    //   2496: iadd
    //   2497: iload #11
    //   2499: iload #8
    //   2501: isub
    //   2502: iconst_1
    //   2503: isub
    //   2504: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2507: aload_0
    //   2508: getfield buf : [C
    //   2511: astore_1
    //   2512: aload_1
    //   2513: iload #8
    //   2515: bipush #92
    //   2517: castore
    //   2518: aload_1
    //   2519: iload #4
    //   2521: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   2524: iload #7
    //   2526: caload
    //   2527: castore
    //   2528: goto -> 2950
    //   2531: iload #12
    //   2533: iconst_1
    //   2534: if_icmple -> 2950
    //   2537: iload #5
    //   2539: iload #9
    //   2541: isub
    //   2542: istore #6
    //   2544: iload #5
    //   2546: istore #4
    //   2548: iload #6
    //   2550: istore #5
    //   2552: iload #5
    //   2554: aload_1
    //   2555: invokevirtual length : ()I
    //   2558: if_icmpge -> 2950
    //   2561: aload_1
    //   2562: iload #5
    //   2564: invokevirtual charAt : (I)C
    //   2567: istore_3
    //   2568: iload_3
    //   2569: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2572: arraylength
    //   2573: if_icmpge -> 2590
    //   2576: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2579: iload_3
    //   2580: baload
    //   2581: ifne -> 2587
    //   2584: goto -> 2590
    //   2587: goto -> 2606
    //   2590: iload_3
    //   2591: bipush #47
    //   2593: if_icmpne -> 2783
    //   2596: aload_0
    //   2597: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   2600: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   2603: ifeq -> 2783
    //   2606: aload_0
    //   2607: getfield buf : [C
    //   2610: astore #18
    //   2612: iload #4
    //   2614: iconst_1
    //   2615: iadd
    //   2616: istore #6
    //   2618: aload #18
    //   2620: iload #4
    //   2622: bipush #92
    //   2624: castore
    //   2625: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   2628: iload_3
    //   2629: baload
    //   2630: iconst_4
    //   2631: if_icmpne -> 2758
    //   2634: aload_0
    //   2635: getfield buf : [C
    //   2638: astore #18
    //   2640: iload #6
    //   2642: iconst_1
    //   2643: iadd
    //   2644: istore #4
    //   2646: aload #18
    //   2648: iload #6
    //   2650: bipush #117
    //   2652: castore
    //   2653: iload #4
    //   2655: iconst_1
    //   2656: iadd
    //   2657: istore #6
    //   2659: aload #18
    //   2661: iload #4
    //   2663: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2666: iload_3
    //   2667: bipush #12
    //   2669: iushr
    //   2670: bipush #15
    //   2672: iand
    //   2673: caload
    //   2674: castore
    //   2675: aload_0
    //   2676: getfield buf : [C
    //   2679: astore #18
    //   2681: iload #6
    //   2683: iconst_1
    //   2684: iadd
    //   2685: istore #4
    //   2687: aload #18
    //   2689: iload #6
    //   2691: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2694: iload_3
    //   2695: bipush #8
    //   2697: iushr
    //   2698: bipush #15
    //   2700: iand
    //   2701: caload
    //   2702: castore
    //   2703: aload_0
    //   2704: getfield buf : [C
    //   2707: astore #18
    //   2709: iload #4
    //   2711: iconst_1
    //   2712: iadd
    //   2713: istore #6
    //   2715: aload #18
    //   2717: iload #4
    //   2719: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2722: iload_3
    //   2723: iconst_4
    //   2724: iushr
    //   2725: bipush #15
    //   2727: iand
    //   2728: caload
    //   2729: castore
    //   2730: aload_0
    //   2731: getfield buf : [C
    //   2734: astore #18
    //   2736: iload #6
    //   2738: iconst_1
    //   2739: iadd
    //   2740: istore #4
    //   2742: aload #18
    //   2744: iload #6
    //   2746: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2749: iload_3
    //   2750: bipush #15
    //   2752: iand
    //   2753: caload
    //   2754: castore
    //   2755: goto -> 2924
    //   2758: aload_0
    //   2759: getfield buf : [C
    //   2762: astore #18
    //   2764: iload #6
    //   2766: iconst_1
    //   2767: iadd
    //   2768: istore #4
    //   2770: aload #18
    //   2772: iload #6
    //   2774: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   2777: iload_3
    //   2778: caload
    //   2779: castore
    //   2780: goto -> 2924
    //   2783: iload_3
    //   2784: sipush #8232
    //   2787: if_icmpne -> 2927
    //   2790: aload_0
    //   2791: getfield buf : [C
    //   2794: astore #18
    //   2796: iload #4
    //   2798: iconst_1
    //   2799: iadd
    //   2800: istore #6
    //   2802: aload #18
    //   2804: iload #4
    //   2806: bipush #92
    //   2808: castore
    //   2809: iload #6
    //   2811: iconst_1
    //   2812: iadd
    //   2813: istore #4
    //   2815: aload #18
    //   2817: iload #6
    //   2819: bipush #117
    //   2821: castore
    //   2822: iload #4
    //   2824: iconst_1
    //   2825: iadd
    //   2826: istore #6
    //   2828: aload #18
    //   2830: iload #4
    //   2832: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2835: iload_3
    //   2836: bipush #12
    //   2838: iushr
    //   2839: bipush #15
    //   2841: iand
    //   2842: caload
    //   2843: castore
    //   2844: aload_0
    //   2845: getfield buf : [C
    //   2848: astore #18
    //   2850: iload #6
    //   2852: iconst_1
    //   2853: iadd
    //   2854: istore #4
    //   2856: aload #18
    //   2858: iload #6
    //   2860: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2863: iload_3
    //   2864: bipush #8
    //   2866: iushr
    //   2867: bipush #15
    //   2869: iand
    //   2870: caload
    //   2871: castore
    //   2872: aload_0
    //   2873: getfield buf : [C
    //   2876: astore #18
    //   2878: iload #4
    //   2880: iconst_1
    //   2881: iadd
    //   2882: istore #6
    //   2884: aload #18
    //   2886: iload #4
    //   2888: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2891: iload_3
    //   2892: iconst_4
    //   2893: iushr
    //   2894: bipush #15
    //   2896: iand
    //   2897: caload
    //   2898: castore
    //   2899: aload_0
    //   2900: getfield buf : [C
    //   2903: astore #18
    //   2905: iload #6
    //   2907: iconst_1
    //   2908: iadd
    //   2909: istore #4
    //   2911: aload #18
    //   2913: iload #6
    //   2915: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   2918: iload_3
    //   2919: bipush #15
    //   2921: iand
    //   2922: caload
    //   2923: castore
    //   2924: goto -> 2941
    //   2927: aload_0
    //   2928: getfield buf : [C
    //   2931: iload #4
    //   2933: iload_3
    //   2934: castore
    //   2935: iload #4
    //   2937: iconst_1
    //   2938: iadd
    //   2939: istore #4
    //   2941: iload #5
    //   2943: iconst_1
    //   2944: iadd
    //   2945: istore #5
    //   2947: goto -> 2552
    //   2950: iload_2
    //   2951: ifeq -> 2981
    //   2954: aload_0
    //   2955: getfield buf : [C
    //   2958: astore_1
    //   2959: aload_0
    //   2960: getfield count : I
    //   2963: istore #4
    //   2965: aload_1
    //   2966: iload #4
    //   2968: iconst_2
    //   2969: isub
    //   2970: bipush #34
    //   2972: castore
    //   2973: aload_1
    //   2974: iload #4
    //   2976: iconst_1
    //   2977: isub
    //   2978: iload_2
    //   2979: castore
    //   2980: return
    //   2981: aload_0
    //   2982: getfield buf : [C
    //   2985: aload_0
    //   2986: getfield count : I
    //   2989: iconst_1
    //   2990: isub
    //   2991: bipush #34
    //   2993: castore
    //   2994: return
  }
  
  public void writeStringWithDoubleQuoteDirect(String paramString, char paramChar) {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull -> 18
    //   4: aload_0
    //   5: invokevirtual writeNull : ()V
    //   8: iload_2
    //   9: ifeq -> 17
    //   12: aload_0
    //   13: iload_2
    //   14: invokevirtual write : (I)V
    //   17: return
    //   18: aload_1
    //   19: invokevirtual length : ()I
    //   22: istore #6
    //   24: aload_0
    //   25: getfield count : I
    //   28: iload #6
    //   30: iadd
    //   31: iconst_2
    //   32: iadd
    //   33: istore #5
    //   35: iload #5
    //   37: istore #4
    //   39: iload_2
    //   40: ifeq -> 49
    //   43: iload #5
    //   45: iconst_1
    //   46: iadd
    //   47: istore #4
    //   49: aload_0
    //   50: getfield buf : [C
    //   53: arraylength
    //   54: istore #7
    //   56: iconst_0
    //   57: istore #5
    //   59: iload #4
    //   61: iload #7
    //   63: if_icmple -> 253
    //   66: aload_0
    //   67: getfield writer : Ljava/io/Writer;
    //   70: ifnull -> 247
    //   73: aload_0
    //   74: bipush #34
    //   76: invokevirtual write : (I)V
    //   79: iload #5
    //   81: istore #4
    //   83: iload #4
    //   85: aload_1
    //   86: invokevirtual length : ()I
    //   89: if_icmpge -> 231
    //   92: aload_1
    //   93: iload #4
    //   95: invokevirtual charAt : (I)C
    //   98: istore #5
    //   100: iload #5
    //   102: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   105: arraylength
    //   106: if_icmpge -> 216
    //   109: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   112: iload #5
    //   114: baload
    //   115: ifeq -> 216
    //   118: aload_0
    //   119: bipush #92
    //   121: invokevirtual write : (I)V
    //   124: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   127: iload #5
    //   129: baload
    //   130: iconst_4
    //   131: if_icmpne -> 203
    //   134: aload_0
    //   135: bipush #117
    //   137: invokevirtual write : (I)V
    //   140: aload_0
    //   141: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   144: iload #5
    //   146: bipush #12
    //   148: iushr
    //   149: bipush #15
    //   151: iand
    //   152: caload
    //   153: invokevirtual write : (I)V
    //   156: aload_0
    //   157: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   160: iload #5
    //   162: bipush #8
    //   164: iushr
    //   165: bipush #15
    //   167: iand
    //   168: caload
    //   169: invokevirtual write : (I)V
    //   172: aload_0
    //   173: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   176: iload #5
    //   178: iconst_4
    //   179: iushr
    //   180: bipush #15
    //   182: iand
    //   183: caload
    //   184: invokevirtual write : (I)V
    //   187: aload_0
    //   188: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   191: iload #5
    //   193: bipush #15
    //   195: iand
    //   196: caload
    //   197: invokevirtual write : (I)V
    //   200: goto -> 222
    //   203: aload_0
    //   204: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   207: iload #5
    //   209: caload
    //   210: invokevirtual write : (I)V
    //   213: goto -> 222
    //   216: aload_0
    //   217: iload #5
    //   219: invokevirtual write : (I)V
    //   222: iload #4
    //   224: iconst_1
    //   225: iadd
    //   226: istore #4
    //   228: goto -> 83
    //   231: aload_0
    //   232: bipush #34
    //   234: invokevirtual write : (I)V
    //   237: iload_2
    //   238: ifeq -> 246
    //   241: aload_0
    //   242: iload_2
    //   243: invokevirtual write : (I)V
    //   246: return
    //   247: aload_0
    //   248: iload #4
    //   250: invokevirtual expandCapacity : (I)V
    //   253: aload_0
    //   254: getfield count : I
    //   257: istore #5
    //   259: iload #5
    //   261: iconst_1
    //   262: iadd
    //   263: istore #16
    //   265: iload #16
    //   267: iload #6
    //   269: iadd
    //   270: istore #18
    //   272: aload_0
    //   273: getfield buf : [C
    //   276: astore #19
    //   278: aload #19
    //   280: iload #5
    //   282: bipush #34
    //   284: castore
    //   285: aload_1
    //   286: iconst_0
    //   287: iload #6
    //   289: aload #19
    //   291: iload #16
    //   293: invokevirtual getChars : (II[CI)V
    //   296: aload_0
    //   297: iload #4
    //   299: putfield count : I
    //   302: iload #4
    //   304: istore #6
    //   306: iload #16
    //   308: istore #4
    //   310: iconst_0
    //   311: istore #10
    //   313: iconst_m1
    //   314: istore #5
    //   316: iconst_0
    //   317: istore #7
    //   319: iconst_m1
    //   320: istore #8
    //   322: iload #4
    //   324: iload #18
    //   326: if_icmpge -> 668
    //   329: aload_0
    //   330: getfield buf : [C
    //   333: iload #4
    //   335: caload
    //   336: istore #17
    //   338: iload #17
    //   340: bipush #93
    //   342: if_icmplt -> 513
    //   345: iload #17
    //   347: sipush #8232
    //   350: if_icmpne -> 425
    //   353: iload #10
    //   355: iconst_1
    //   356: iadd
    //   357: istore #8
    //   359: iload #6
    //   361: iconst_4
    //   362: iadd
    //   363: istore #10
    //   365: iload #8
    //   367: istore #6
    //   369: iload #10
    //   371: istore #7
    //   373: iload #5
    //   375: istore #9
    //   377: iload #5
    //   379: iconst_m1
    //   380: if_icmpne -> 398
    //   383: iload #10
    //   385: istore #7
    //   387: iload #8
    //   389: istore #6
    //   391: iload #4
    //   393: istore #5
    //   395: goto -> 402
    //   398: iload #9
    //   400: istore #5
    //   402: iload #4
    //   404: istore #14
    //   406: iload #17
    //   408: istore #13
    //   410: iload #6
    //   412: istore #9
    //   414: iload #7
    //   416: istore #11
    //   418: iload #5
    //   420: istore #12
    //   422: goto -> 639
    //   425: iload #10
    //   427: istore #9
    //   429: iload #6
    //   431: istore #11
    //   433: iload #5
    //   435: istore #12
    //   437: iload #7
    //   439: istore #13
    //   441: iload #8
    //   443: istore #14
    //   445: iload #17
    //   447: bipush #127
    //   449: if_icmplt -> 639
    //   452: iload #10
    //   454: istore #9
    //   456: iload #6
    //   458: istore #11
    //   460: iload #5
    //   462: istore #12
    //   464: iload #7
    //   466: istore #13
    //   468: iload #8
    //   470: istore #14
    //   472: iload #17
    //   474: sipush #160
    //   477: if_icmpgt -> 639
    //   480: iload #5
    //   482: istore #9
    //   484: iload #5
    //   486: iconst_m1
    //   487: if_icmpne -> 494
    //   490: iload #4
    //   492: istore #9
    //   494: iload #10
    //   496: iconst_1
    //   497: iadd
    //   498: istore #5
    //   500: iload #6
    //   502: iconst_4
    //   503: iadd
    //   504: istore #7
    //   506: iload #5
    //   508: istore #6
    //   510: goto -> 398
    //   513: iload #17
    //   515: bipush #31
    //   517: if_icmple -> 543
    //   520: iload #17
    //   522: bipush #92
    //   524: if_icmpeq -> 543
    //   527: iload #17
    //   529: bipush #34
    //   531: if_icmpne -> 537
    //   534: goto -> 543
    //   537: iconst_0
    //   538: istore #15
    //   540: goto -> 546
    //   543: iconst_1
    //   544: istore #15
    //   546: iload #10
    //   548: istore #9
    //   550: iload #6
    //   552: istore #11
    //   554: iload #5
    //   556: istore #12
    //   558: iload #7
    //   560: istore #13
    //   562: iload #8
    //   564: istore #14
    //   566: iload #15
    //   568: ifeq -> 639
    //   571: iload #10
    //   573: iconst_1
    //   574: iadd
    //   575: istore #10
    //   577: iload #6
    //   579: istore #8
    //   581: iload #17
    //   583: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   586: arraylength
    //   587: if_icmpge -> 610
    //   590: iload #6
    //   592: istore #8
    //   594: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   597: iload #17
    //   599: baload
    //   600: iconst_4
    //   601: if_icmpne -> 610
    //   604: iload #6
    //   606: iconst_4
    //   607: iadd
    //   608: istore #8
    //   610: iload #10
    //   612: istore #6
    //   614: iload #8
    //   616: istore #7
    //   618: iload #5
    //   620: istore #9
    //   622: iload #5
    //   624: iconst_m1
    //   625: if_icmpne -> 398
    //   628: iload #10
    //   630: istore #6
    //   632: iload #8
    //   634: istore #7
    //   636: goto -> 391
    //   639: iload #4
    //   641: iconst_1
    //   642: iadd
    //   643: istore #4
    //   645: iload #9
    //   647: istore #10
    //   649: iload #11
    //   651: istore #6
    //   653: iload #12
    //   655: istore #5
    //   657: iload #13
    //   659: istore #7
    //   661: iload #14
    //   663: istore #8
    //   665: goto -> 322
    //   668: iload #10
    //   670: ifle -> 1432
    //   673: iload #6
    //   675: iload #10
    //   677: iadd
    //   678: istore #4
    //   680: iload #4
    //   682: aload_0
    //   683: getfield buf : [C
    //   686: arraylength
    //   687: if_icmple -> 696
    //   690: aload_0
    //   691: iload #4
    //   693: invokevirtual expandCapacity : (I)V
    //   696: aload_0
    //   697: iload #4
    //   699: putfield count : I
    //   702: iload #10
    //   704: iconst_1
    //   705: if_icmpne -> 1023
    //   708: iload #7
    //   710: sipush #8232
    //   713: if_icmpne -> 810
    //   716: iload #8
    //   718: iconst_1
    //   719: iadd
    //   720: istore #4
    //   722: aload_0
    //   723: getfield buf : [C
    //   726: astore_1
    //   727: aload_1
    //   728: iload #4
    //   730: aload_1
    //   731: iload #8
    //   733: bipush #6
    //   735: iadd
    //   736: iload #18
    //   738: iload #8
    //   740: isub
    //   741: iconst_1
    //   742: isub
    //   743: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   746: aload_0
    //   747: getfield buf : [C
    //   750: astore_1
    //   751: aload_1
    //   752: iload #8
    //   754: bipush #92
    //   756: castore
    //   757: aload_1
    //   758: iload #4
    //   760: bipush #117
    //   762: castore
    //   763: iload #4
    //   765: iconst_1
    //   766: iadd
    //   767: istore #4
    //   769: aload_1
    //   770: iload #4
    //   772: bipush #50
    //   774: castore
    //   775: iload #4
    //   777: iconst_1
    //   778: iadd
    //   779: istore #4
    //   781: aload_1
    //   782: iload #4
    //   784: bipush #48
    //   786: castore
    //   787: iload #4
    //   789: iconst_1
    //   790: iadd
    //   791: istore #4
    //   793: aload_1
    //   794: iload #4
    //   796: bipush #50
    //   798: castore
    //   799: aload_1
    //   800: iload #4
    //   802: iconst_1
    //   803: iadd
    //   804: bipush #56
    //   806: castore
    //   807: goto -> 1432
    //   810: iload #7
    //   812: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   815: arraylength
    //   816: if_icmpge -> 970
    //   819: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   822: iload #7
    //   824: baload
    //   825: iconst_4
    //   826: if_icmpne -> 970
    //   829: iload #8
    //   831: iconst_1
    //   832: iadd
    //   833: istore #4
    //   835: aload_0
    //   836: getfield buf : [C
    //   839: astore_1
    //   840: aload_1
    //   841: iload #4
    //   843: aload_1
    //   844: iload #8
    //   846: bipush #6
    //   848: iadd
    //   849: iload #18
    //   851: iload #8
    //   853: isub
    //   854: iconst_1
    //   855: isub
    //   856: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   859: aload_0
    //   860: getfield buf : [C
    //   863: astore_1
    //   864: aload_1
    //   865: iload #8
    //   867: bipush #92
    //   869: castore
    //   870: iload #4
    //   872: iconst_1
    //   873: iadd
    //   874: istore #5
    //   876: aload_1
    //   877: iload #4
    //   879: bipush #117
    //   881: castore
    //   882: iload #5
    //   884: iconst_1
    //   885: iadd
    //   886: istore #4
    //   888: aload_1
    //   889: iload #5
    //   891: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   894: iload #7
    //   896: bipush #12
    //   898: iushr
    //   899: bipush #15
    //   901: iand
    //   902: caload
    //   903: castore
    //   904: aload_0
    //   905: getfield buf : [C
    //   908: astore_1
    //   909: iload #4
    //   911: iconst_1
    //   912: iadd
    //   913: istore #5
    //   915: aload_1
    //   916: iload #4
    //   918: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   921: iload #7
    //   923: bipush #8
    //   925: iushr
    //   926: bipush #15
    //   928: iand
    //   929: caload
    //   930: castore
    //   931: aload_0
    //   932: getfield buf : [C
    //   935: iload #5
    //   937: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   940: iload #7
    //   942: iconst_4
    //   943: iushr
    //   944: bipush #15
    //   946: iand
    //   947: caload
    //   948: castore
    //   949: aload_0
    //   950: getfield buf : [C
    //   953: iload #5
    //   955: iconst_1
    //   956: iadd
    //   957: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   960: iload #7
    //   962: bipush #15
    //   964: iand
    //   965: caload
    //   966: castore
    //   967: goto -> 1432
    //   970: iload #8
    //   972: iconst_1
    //   973: iadd
    //   974: istore #4
    //   976: aload_0
    //   977: getfield buf : [C
    //   980: astore_1
    //   981: aload_1
    //   982: iload #4
    //   984: aload_1
    //   985: iload #8
    //   987: iconst_2
    //   988: iadd
    //   989: iload #18
    //   991: iload #8
    //   993: isub
    //   994: iconst_1
    //   995: isub
    //   996: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   999: aload_0
    //   1000: getfield buf : [C
    //   1003: astore_1
    //   1004: aload_1
    //   1005: iload #8
    //   1007: bipush #92
    //   1009: castore
    //   1010: aload_1
    //   1011: iload #4
    //   1013: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   1016: iload #7
    //   1018: caload
    //   1019: castore
    //   1020: goto -> 1432
    //   1023: iload #10
    //   1025: iconst_1
    //   1026: if_icmple -> 1432
    //   1029: iload #5
    //   1031: iload #16
    //   1033: isub
    //   1034: istore #6
    //   1036: iload #5
    //   1038: istore #4
    //   1040: iload #6
    //   1042: istore #5
    //   1044: iload #5
    //   1046: aload_1
    //   1047: invokevirtual length : ()I
    //   1050: if_icmpge -> 1432
    //   1053: aload_1
    //   1054: iload #5
    //   1056: invokevirtual charAt : (I)C
    //   1059: istore_3
    //   1060: iload_3
    //   1061: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   1064: arraylength
    //   1065: if_icmpge -> 1076
    //   1068: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   1071: iload_3
    //   1072: baload
    //   1073: ifne -> 1092
    //   1076: iload_3
    //   1077: bipush #47
    //   1079: if_icmpne -> 1269
    //   1082: aload_0
    //   1083: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   1086: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   1089: ifeq -> 1269
    //   1092: aload_0
    //   1093: getfield buf : [C
    //   1096: astore #19
    //   1098: iload #4
    //   1100: iconst_1
    //   1101: iadd
    //   1102: istore #6
    //   1104: aload #19
    //   1106: iload #4
    //   1108: bipush #92
    //   1110: castore
    //   1111: getstatic com/alibaba/fastjson/util/IOUtils.specicalFlags_doubleQuotes : [B
    //   1114: iload_3
    //   1115: baload
    //   1116: iconst_4
    //   1117: if_icmpne -> 1244
    //   1120: aload_0
    //   1121: getfield buf : [C
    //   1124: astore #19
    //   1126: iload #6
    //   1128: iconst_1
    //   1129: iadd
    //   1130: istore #4
    //   1132: aload #19
    //   1134: iload #6
    //   1136: bipush #117
    //   1138: castore
    //   1139: iload #4
    //   1141: iconst_1
    //   1142: iadd
    //   1143: istore #6
    //   1145: aload #19
    //   1147: iload #4
    //   1149: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1152: iload_3
    //   1153: bipush #12
    //   1155: iushr
    //   1156: bipush #15
    //   1158: iand
    //   1159: caload
    //   1160: castore
    //   1161: aload_0
    //   1162: getfield buf : [C
    //   1165: astore #19
    //   1167: iload #6
    //   1169: iconst_1
    //   1170: iadd
    //   1171: istore #4
    //   1173: aload #19
    //   1175: iload #6
    //   1177: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1180: iload_3
    //   1181: bipush #8
    //   1183: iushr
    //   1184: bipush #15
    //   1186: iand
    //   1187: caload
    //   1188: castore
    //   1189: aload_0
    //   1190: getfield buf : [C
    //   1193: astore #19
    //   1195: iload #4
    //   1197: iconst_1
    //   1198: iadd
    //   1199: istore #6
    //   1201: aload #19
    //   1203: iload #4
    //   1205: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1208: iload_3
    //   1209: iconst_4
    //   1210: iushr
    //   1211: bipush #15
    //   1213: iand
    //   1214: caload
    //   1215: castore
    //   1216: aload_0
    //   1217: getfield buf : [C
    //   1220: astore #19
    //   1222: iload #6
    //   1224: iconst_1
    //   1225: iadd
    //   1226: istore #4
    //   1228: aload #19
    //   1230: iload #6
    //   1232: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1235: iload_3
    //   1236: bipush #15
    //   1238: iand
    //   1239: caload
    //   1240: castore
    //   1241: goto -> 1266
    //   1244: aload_0
    //   1245: getfield buf : [C
    //   1248: astore #19
    //   1250: iload #6
    //   1252: iconst_1
    //   1253: iadd
    //   1254: istore #4
    //   1256: aload #19
    //   1258: iload #6
    //   1260: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   1263: iload_3
    //   1264: caload
    //   1265: castore
    //   1266: goto -> 1423
    //   1269: iload_3
    //   1270: sipush #8232
    //   1273: if_icmpne -> 1409
    //   1276: aload_0
    //   1277: getfield buf : [C
    //   1280: astore #19
    //   1282: iload #4
    //   1284: iconst_1
    //   1285: iadd
    //   1286: istore #6
    //   1288: aload #19
    //   1290: iload #4
    //   1292: bipush #92
    //   1294: castore
    //   1295: iload #6
    //   1297: iconst_1
    //   1298: iadd
    //   1299: istore #4
    //   1301: aload #19
    //   1303: iload #6
    //   1305: bipush #117
    //   1307: castore
    //   1308: iload #4
    //   1310: iconst_1
    //   1311: iadd
    //   1312: istore #6
    //   1314: aload #19
    //   1316: iload #4
    //   1318: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1321: iload_3
    //   1322: bipush #12
    //   1324: iushr
    //   1325: bipush #15
    //   1327: iand
    //   1328: caload
    //   1329: castore
    //   1330: aload_0
    //   1331: getfield buf : [C
    //   1334: astore #19
    //   1336: iload #6
    //   1338: iconst_1
    //   1339: iadd
    //   1340: istore #4
    //   1342: aload #19
    //   1344: iload #6
    //   1346: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1349: iload_3
    //   1350: bipush #8
    //   1352: iushr
    //   1353: bipush #15
    //   1355: iand
    //   1356: caload
    //   1357: castore
    //   1358: aload_0
    //   1359: getfield buf : [C
    //   1362: astore #19
    //   1364: iload #4
    //   1366: iconst_1
    //   1367: iadd
    //   1368: istore #6
    //   1370: aload #19
    //   1372: iload #4
    //   1374: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1377: iload_3
    //   1378: iconst_4
    //   1379: iushr
    //   1380: bipush #15
    //   1382: iand
    //   1383: caload
    //   1384: castore
    //   1385: aload_0
    //   1386: getfield buf : [C
    //   1389: iload #6
    //   1391: getstatic com/alibaba/fastjson/util/IOUtils.DIGITS : [C
    //   1394: iload_3
    //   1395: bipush #15
    //   1397: iand
    //   1398: caload
    //   1399: castore
    //   1400: iload #6
    //   1402: iconst_1
    //   1403: iadd
    //   1404: istore #4
    //   1406: goto -> 1423
    //   1409: aload_0
    //   1410: getfield buf : [C
    //   1413: iload #4
    //   1415: iload_3
    //   1416: castore
    //   1417: iload #4
    //   1419: iconst_1
    //   1420: iadd
    //   1421: istore #4
    //   1423: iload #5
    //   1425: iconst_1
    //   1426: iadd
    //   1427: istore #5
    //   1429: goto -> 1044
    //   1432: iload_2
    //   1433: ifeq -> 1463
    //   1436: aload_0
    //   1437: getfield buf : [C
    //   1440: astore_1
    //   1441: aload_0
    //   1442: getfield count : I
    //   1445: istore #4
    //   1447: aload_1
    //   1448: iload #4
    //   1450: iconst_2
    //   1451: isub
    //   1452: bipush #34
    //   1454: castore
    //   1455: aload_1
    //   1456: iload #4
    //   1458: iconst_1
    //   1459: isub
    //   1460: iload_2
    //   1461: castore
    //   1462: return
    //   1463: aload_0
    //   1464: getfield buf : [C
    //   1467: aload_0
    //   1468: getfield count : I
    //   1471: iconst_1
    //   1472: isub
    //   1473: bipush #34
    //   1475: castore
    //   1476: return
  }
  
  protected void writeStringWithSingleQuote(String paramString) {
    // Byte code:
    //   0: iconst_0
    //   1: istore #6
    //   3: iconst_0
    //   4: istore_2
    //   5: aload_1
    //   6: ifnonnull -> 51
    //   9: aload_0
    //   10: getfield count : I
    //   13: iconst_4
    //   14: iadd
    //   15: istore_2
    //   16: iload_2
    //   17: aload_0
    //   18: getfield buf : [C
    //   21: arraylength
    //   22: if_icmple -> 30
    //   25: aload_0
    //   26: iload_2
    //   27: invokevirtual expandCapacity : (I)V
    //   30: ldc 'null'
    //   32: iconst_0
    //   33: iconst_4
    //   34: aload_0
    //   35: getfield buf : [C
    //   38: aload_0
    //   39: getfield count : I
    //   42: invokevirtual getChars : (II[CI)V
    //   45: aload_0
    //   46: iload_2
    //   47: putfield count : I
    //   50: return
    //   51: aload_1
    //   52: invokevirtual length : ()I
    //   55: istore_3
    //   56: aload_0
    //   57: getfield count : I
    //   60: iload_3
    //   61: iadd
    //   62: iconst_2
    //   63: iadd
    //   64: istore #12
    //   66: iload #12
    //   68: aload_0
    //   69: getfield buf : [C
    //   72: arraylength
    //   73: if_icmple -> 183
    //   76: aload_0
    //   77: getfield writer : Ljava/io/Writer;
    //   80: ifnull -> 177
    //   83: aload_0
    //   84: bipush #39
    //   86: invokevirtual write : (I)V
    //   89: iload_2
    //   90: aload_1
    //   91: invokevirtual length : ()I
    //   94: if_icmpge -> 170
    //   97: aload_1
    //   98: iload_2
    //   99: invokevirtual charAt : (I)C
    //   102: istore_3
    //   103: iload_3
    //   104: bipush #13
    //   106: if_icmple -> 148
    //   109: iload_3
    //   110: bipush #92
    //   112: if_icmpeq -> 148
    //   115: iload_3
    //   116: bipush #39
    //   118: if_icmpeq -> 148
    //   121: iload_3
    //   122: bipush #47
    //   124: if_icmpne -> 140
    //   127: aload_0
    //   128: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   131: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   134: ifeq -> 140
    //   137: goto -> 148
    //   140: aload_0
    //   141: iload_3
    //   142: invokevirtual write : (I)V
    //   145: goto -> 163
    //   148: aload_0
    //   149: bipush #92
    //   151: invokevirtual write : (I)V
    //   154: aload_0
    //   155: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   158: iload_3
    //   159: caload
    //   160: invokevirtual write : (I)V
    //   163: iload_2
    //   164: iconst_1
    //   165: iadd
    //   166: istore_2
    //   167: goto -> 89
    //   170: aload_0
    //   171: bipush #39
    //   173: invokevirtual write : (I)V
    //   176: return
    //   177: aload_0
    //   178: iload #12
    //   180: invokevirtual expandCapacity : (I)V
    //   183: aload_0
    //   184: getfield count : I
    //   187: istore_2
    //   188: iload_2
    //   189: iconst_1
    //   190: iadd
    //   191: istore #9
    //   193: iload #9
    //   195: iload_3
    //   196: iadd
    //   197: istore #11
    //   199: aload_0
    //   200: getfield buf : [C
    //   203: astore #13
    //   205: aload #13
    //   207: iload_2
    //   208: bipush #39
    //   210: castore
    //   211: aload_1
    //   212: iconst_0
    //   213: iload_3
    //   214: aload #13
    //   216: iload #9
    //   218: invokevirtual getChars : (II[CI)V
    //   221: aload_0
    //   222: iload #12
    //   224: putfield count : I
    //   227: iload #9
    //   229: istore_2
    //   230: iconst_m1
    //   231: istore #4
    //   233: iconst_0
    //   234: istore_3
    //   235: iload_2
    //   236: iload #11
    //   238: if_icmpge -> 340
    //   241: aload_0
    //   242: getfield buf : [C
    //   245: iload_2
    //   246: caload
    //   247: istore #10
    //   249: iload #10
    //   251: bipush #13
    //   253: if_icmple -> 309
    //   256: iload #10
    //   258: bipush #92
    //   260: if_icmpeq -> 309
    //   263: iload #10
    //   265: bipush #39
    //   267: if_icmpeq -> 309
    //   270: iload #6
    //   272: istore #8
    //   274: iload #4
    //   276: istore #7
    //   278: iload_3
    //   279: istore #5
    //   281: iload #10
    //   283: bipush #47
    //   285: if_icmpne -> 322
    //   288: iload #6
    //   290: istore #8
    //   292: iload #4
    //   294: istore #7
    //   296: iload_3
    //   297: istore #5
    //   299: aload_0
    //   300: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   303: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   306: ifeq -> 322
    //   309: iload #6
    //   311: iconst_1
    //   312: iadd
    //   313: istore #8
    //   315: iload_2
    //   316: istore #7
    //   318: iload #10
    //   320: istore #5
    //   322: iload_2
    //   323: iconst_1
    //   324: iadd
    //   325: istore_2
    //   326: iload #8
    //   328: istore #6
    //   330: iload #7
    //   332: istore #4
    //   334: iload #5
    //   336: istore_3
    //   337: goto -> 235
    //   340: iload #12
    //   342: iload #6
    //   344: iadd
    //   345: istore_2
    //   346: iload_2
    //   347: aload_0
    //   348: getfield buf : [C
    //   351: arraylength
    //   352: if_icmple -> 360
    //   355: aload_0
    //   356: iload_2
    //   357: invokevirtual expandCapacity : (I)V
    //   360: aload_0
    //   361: iload_2
    //   362: putfield count : I
    //   365: iload #6
    //   367: iconst_1
    //   368: if_icmpne -> 420
    //   371: aload_0
    //   372: getfield buf : [C
    //   375: astore_1
    //   376: iload #4
    //   378: iconst_1
    //   379: iadd
    //   380: istore_2
    //   381: aload_1
    //   382: iload_2
    //   383: aload_1
    //   384: iload #4
    //   386: iconst_2
    //   387: iadd
    //   388: iload #11
    //   390: iload #4
    //   392: isub
    //   393: iconst_1
    //   394: isub
    //   395: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   398: aload_0
    //   399: getfield buf : [C
    //   402: astore_1
    //   403: aload_1
    //   404: iload #4
    //   406: bipush #92
    //   408: castore
    //   409: aload_1
    //   410: iload_2
    //   411: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   414: iload_3
    //   415: caload
    //   416: castore
    //   417: goto -> 599
    //   420: iload #6
    //   422: iconst_1
    //   423: if_icmple -> 599
    //   426: aload_0
    //   427: getfield buf : [C
    //   430: astore_1
    //   431: iload #4
    //   433: iconst_1
    //   434: iadd
    //   435: istore_2
    //   436: aload_1
    //   437: iload_2
    //   438: aload_1
    //   439: iload #4
    //   441: iconst_2
    //   442: iadd
    //   443: iload #11
    //   445: iload #4
    //   447: isub
    //   448: iconst_1
    //   449: isub
    //   450: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   453: aload_0
    //   454: getfield buf : [C
    //   457: astore_1
    //   458: aload_1
    //   459: iload #4
    //   461: bipush #92
    //   463: castore
    //   464: aload_1
    //   465: iload_2
    //   466: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   469: iload_3
    //   470: caload
    //   471: castore
    //   472: iload #11
    //   474: iconst_1
    //   475: iadd
    //   476: istore_3
    //   477: iload_2
    //   478: iconst_2
    //   479: isub
    //   480: istore_2
    //   481: iload_2
    //   482: iload #9
    //   484: if_icmplt -> 599
    //   487: aload_0
    //   488: getfield buf : [C
    //   491: iload_2
    //   492: caload
    //   493: istore #5
    //   495: iload #5
    //   497: bipush #13
    //   499: if_icmple -> 539
    //   502: iload #5
    //   504: bipush #92
    //   506: if_icmpeq -> 539
    //   509: iload #5
    //   511: bipush #39
    //   513: if_icmpeq -> 539
    //   516: iload_3
    //   517: istore #4
    //   519: iload #5
    //   521: bipush #47
    //   523: if_icmpne -> 589
    //   526: iload_3
    //   527: istore #4
    //   529: aload_0
    //   530: getstatic com/alibaba/fastjson/serializer/SerializerFeature.WriteSlashAsSpecial : Lcom/alibaba/fastjson/serializer/SerializerFeature;
    //   533: invokevirtual isEnabled : (Lcom/alibaba/fastjson/serializer/SerializerFeature;)Z
    //   536: ifeq -> 589
    //   539: aload_0
    //   540: getfield buf : [C
    //   543: astore_1
    //   544: iload_2
    //   545: iconst_1
    //   546: iadd
    //   547: istore #4
    //   549: aload_1
    //   550: iload #4
    //   552: aload_1
    //   553: iload_2
    //   554: iconst_2
    //   555: iadd
    //   556: iload_3
    //   557: iload_2
    //   558: isub
    //   559: iconst_1
    //   560: isub
    //   561: invokestatic arraycopy : (Ljava/lang/Object;ILjava/lang/Object;II)V
    //   564: aload_0
    //   565: getfield buf : [C
    //   568: astore_1
    //   569: aload_1
    //   570: iload_2
    //   571: bipush #92
    //   573: castore
    //   574: aload_1
    //   575: iload #4
    //   577: getstatic com/alibaba/fastjson/util/IOUtils.replaceChars : [C
    //   580: iload #5
    //   582: caload
    //   583: castore
    //   584: iload_3
    //   585: iconst_1
    //   586: iadd
    //   587: istore #4
    //   589: iload_2
    //   590: iconst_1
    //   591: isub
    //   592: istore_2
    //   593: iload #4
    //   595: istore_3
    //   596: goto -> 481
    //   599: aload_0
    //   600: getfield buf : [C
    //   603: aload_0
    //   604: getfield count : I
    //   607: iconst_1
    //   608: isub
    //   609: bipush #39
    //   611: castore
    //   612: return
  }
  
  public void writeTo(OutputStream paramOutputStream, String paramString) throws IOException {
    writeTo(paramOutputStream, Charset.forName(paramString));
  }
  
  public void writeTo(OutputStream paramOutputStream, Charset paramCharset) throws IOException {
    if (this.writer == null) {
      paramOutputStream.write((new String(this.buf, 0, this.count)).getBytes(paramCharset));
      return;
    } 
    throw new UnsupportedOperationException("writer not null");
  }
  
  public void writeTo(Writer paramWriter) throws IOException {
    if (this.writer == null) {
      paramWriter.write(this.buf, 0, this.count);
      return;
    } 
    throw new UnsupportedOperationException("writer not null");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\serializer\SerializeWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */