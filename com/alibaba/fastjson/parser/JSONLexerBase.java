package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.Closeable;
import java.lang.ref.SoftReference;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

public abstract class JSONLexerBase implements JSONLexer, Closeable {
  protected static final int INT_MULTMIN_RADIX_TEN = -214748364;
  
  protected static final long MULTMIN_RADIX_TEN = -922337203685477580L;
  
  private static final ThreadLocal<SoftReference<char[]>> SBUF_REF_LOCAL = new ThreadLocal<SoftReference<char[]>>();
  
  protected static final int[] digits;
  
  protected static final char[] typeFieldName;
  
  protected int bp;
  
  protected Calendar calendar = null;
  
  protected char ch;
  
  protected int eofPos;
  
  protected int features;
  
  protected boolean hasSpecial;
  
  protected Locale locale = JSON.defaultLocale;
  
  public int matchStat = 0;
  
  protected int np;
  
  protected int pos;
  
  protected char[] sbuf;
  
  private final SoftReference<char[]> sbufRef;
  
  protected int sp;
  
  protected String stringDefaultValue = null;
  
  protected TimeZone timeZone = JSON.defaultTimeZone;
  
  protected int token;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("\"");
    stringBuilder.append(JSON.DEFAULT_TYPE_KEY);
    stringBuilder.append("\":\"");
    typeFieldName = stringBuilder.toString().toCharArray();
    digits = new int[103];
    int i;
    for (i = 48; i <= 57; i++)
      digits[i] = i - 48; 
    for (i = 97; i <= 102; i++)
      digits[i] = i - 97 + 10; 
    for (i = 65; i <= 70; i++)
      digits[i] = i - 65 + 10; 
  }
  
  public JSONLexerBase(int paramInt) {
    this.features = paramInt;
    if ((paramInt & Feature.InitStringFieldAsEmpty.mask) != 0)
      this.stringDefaultValue = ""; 
    this.sbufRef = SBUF_REF_LOCAL.get();
    SoftReference<char[]> softReference = this.sbufRef;
    if (softReference != null) {
      this.sbuf = softReference.get();
      SBUF_REF_LOCAL.set(null);
    } 
    if (this.sbuf == null)
      this.sbuf = new char[256]; 
  }
  
  public static boolean isWhitespace(char paramChar) {
    return (paramChar <= ' ' && (paramChar == ' ' || paramChar == '\n' || paramChar == '\r' || paramChar == '\t' || paramChar == '\f' || paramChar == '\b'));
  }
  
  private void scanStringSingleQuote() {
    this.np = this.bp;
    this.hasSpecial = false;
    while (true) {
      char c = next();
      if (c == '\'') {
        this.token = 4;
        next();
        return;
      } 
      if (c == '\032') {
        if (!isEOF()) {
          putChar('\032');
          continue;
        } 
        throw new JSONException("unclosed single-quote string");
      } 
      if (c == '\\') {
        if (!this.hasSpecial) {
          this.hasSpecial = true;
          int j = this.sp;
          char[] arrayOfChar1 = this.sbuf;
          if (j > arrayOfChar1.length) {
            char[] arrayOfChar2 = new char[j * 2];
            System.arraycopy(arrayOfChar1, 0, arrayOfChar2, 0, arrayOfChar1.length);
            this.sbuf = arrayOfChar2;
          } 
          copyTo(this.np + 1, this.sp, this.sbuf);
        } 
        c = next();
        if (c != '"') {
          if (c != '\'') {
            if (c != 'F')
              if (c != '\\') {
                if (c != 'b') {
                  if (c != 'f') {
                    if (c != 'n') {
                      if (c != 'r') {
                        if (c != 'x') {
                          switch (c) {
                            default:
                              switch (c) {
                                default:
                                  this.ch = c;
                                  throw new JSONException("unclosed single-quote string");
                                case 'v':
                                  putChar('\013');
                                  continue;
                                case 'u':
                                  putChar((char)Integer.parseInt(new String(new char[] { next(), next(), next(), next() }, ), 16));
                                  continue;
                                case 't':
                                  break;
                              } 
                              putChar('\t');
                              continue;
                            case '7':
                              putChar('\007');
                              continue;
                            case '6':
                              putChar('\006');
                              continue;
                            case '5':
                              putChar('\005');
                              continue;
                            case '4':
                              putChar('\004');
                              continue;
                            case '3':
                              putChar('\003');
                              continue;
                            case '2':
                              putChar('\002');
                              continue;
                            case '1':
                              putChar('\001');
                              continue;
                            case '0':
                              putChar(false);
                              continue;
                            case '/':
                              break;
                          } 
                          putChar('/');
                          continue;
                        } 
                        putChar((char)(digits[next()] * 16 + digits[next()]));
                        continue;
                      } 
                      putChar('\r');
                      continue;
                    } 
                    putChar('\n');
                    continue;
                  } 
                } else {
                  putChar('\b');
                  continue;
                } 
              } else {
                putChar('\\');
                continue;
              }  
            putChar('\f');
            continue;
          } 
          putChar('\'');
          continue;
        } 
        putChar('"');
        continue;
      } 
      if (!this.hasSpecial) {
        this.sp++;
        continue;
      } 
      int i = this.sp;
      char[] arrayOfChar = this.sbuf;
      if (i == arrayOfChar.length) {
        putChar(c);
        continue;
      } 
      this.sp = i + 1;
      arrayOfChar[i] = c;
    } 
  }
  
  public abstract String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable);
  
  protected abstract void arrayCopy(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3);
  
  public abstract byte[] bytesValue();
  
  protected abstract boolean charArrayCompare(char[] paramArrayOfchar);
  
  public abstract char charAt(int paramInt);
  
  public void close() {
    if (this.sbuf.length <= 8192) {
      SoftReference<char[]> softReference = this.sbufRef;
      if (softReference == null || softReference.get() != this.sbuf) {
        softReference = (SoftReference)new SoftReference<char>(this.sbuf);
      } else {
        softReference = this.sbufRef;
      } 
      SBUF_REF_LOCAL.set(softReference);
    } 
    this.sbuf = null;
  }
  
  public void config(Feature paramFeature, boolean paramBoolean) {
    this.features = Feature.config(this.features, paramFeature, paramBoolean);
    if ((this.features & Feature.InitStringFieldAsEmpty.mask) != 0)
      this.stringDefaultValue = ""; 
  }
  
  protected abstract void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfchar);
  
  public final Number decimalValue(boolean paramBoolean) {
    char c = charAt(this.np + this.sp - 1);
    return (Number)((c == 'F') ? Float.valueOf(Float.parseFloat(numberString())) : ((c == 'D') ? Double.valueOf(Double.parseDouble(numberString())) : (paramBoolean ? decimalValue() : Double.valueOf(doubleValue()))));
  }
  
  public final BigDecimal decimalValue() {
    return new BigDecimal(numberString());
  }
  
  public double doubleValue() {
    return Double.parseDouble(numberString());
  }
  
  public float floatValue() {
    return Float.parseFloat(numberString());
  }
  
  public final int getBufferPosition() {
    return this.bp;
  }
  
  public Calendar getCalendar() {
    return this.calendar;
  }
  
  public final char getCurrent() {
    return this.ch;
  }
  
  public Locale getLocale() {
    return this.locale;
  }
  
  public TimeZone getTimeZone() {
    return this.timeZone;
  }
  
  public abstract int indexOf(char paramChar, int paramInt);
  
  public String info() {
    return "";
  }
  
  public final int intValue() {
    // Byte code:
    //   0: aload_0
    //   1: getfield np : I
    //   4: istore_1
    //   5: iconst_0
    //   6: istore #7
    //   8: iload_1
    //   9: iconst_m1
    //   10: if_icmpne -> 18
    //   13: aload_0
    //   14: iconst_0
    //   15: putfield np : I
    //   18: aload_0
    //   19: getfield np : I
    //   22: istore_3
    //   23: aload_0
    //   24: getfield sp : I
    //   27: iload_3
    //   28: iadd
    //   29: istore #8
    //   31: aload_0
    //   32: iload_3
    //   33: invokevirtual charAt : (I)C
    //   36: bipush #45
    //   38: if_icmpne -> 54
    //   41: iload_3
    //   42: iconst_1
    //   43: iadd
    //   44: istore_3
    //   45: iconst_1
    //   46: istore_1
    //   47: ldc_w -2147483648
    //   50: istore_2
    //   51: goto -> 60
    //   54: iconst_0
    //   55: istore_1
    //   56: ldc_w -2147483647
    //   59: istore_2
    //   60: iload_3
    //   61: istore #4
    //   63: iload_1
    //   64: istore #5
    //   66: iload_2
    //   67: istore #6
    //   69: iload_3
    //   70: iload #8
    //   72: if_icmpge -> 114
    //   75: getstatic com/alibaba/fastjson/parser/JSONLexerBase.digits : [I
    //   78: astore #9
    //   80: iload_3
    //   81: iconst_1
    //   82: iadd
    //   83: istore #5
    //   85: aload #9
    //   87: aload_0
    //   88: iload_3
    //   89: invokevirtual charAt : (I)C
    //   92: iaload
    //   93: ineg
    //   94: istore #4
    //   96: iload #5
    //   98: istore_3
    //   99: iload_1
    //   100: istore #5
    //   102: iload #4
    //   104: istore_1
    //   105: iload_2
    //   106: istore #6
    //   108: iload_1
    //   109: istore #7
    //   111: iload_3
    //   112: istore #4
    //   114: iload #4
    //   116: istore_1
    //   117: iload #4
    //   119: iload #8
    //   121: if_icmpge -> 223
    //   124: iload #4
    //   126: iconst_1
    //   127: iadd
    //   128: istore_3
    //   129: aload_0
    //   130: iload #4
    //   132: invokevirtual charAt : (I)C
    //   135: istore_1
    //   136: iload_1
    //   137: bipush #76
    //   139: if_icmpeq -> 221
    //   142: iload_1
    //   143: bipush #83
    //   145: if_icmpeq -> 221
    //   148: iload_1
    //   149: bipush #66
    //   151: if_icmpne -> 157
    //   154: goto -> 221
    //   157: getstatic com/alibaba/fastjson/parser/JSONLexerBase.digits : [I
    //   160: iload_1
    //   161: iaload
    //   162: istore_1
    //   163: iload #7
    //   165: i2l
    //   166: ldc2_w -214748364
    //   169: lcmp
    //   170: iflt -> 209
    //   173: iload #7
    //   175: bipush #10
    //   177: imul
    //   178: istore_2
    //   179: iload_2
    //   180: iload #6
    //   182: iload_1
    //   183: iadd
    //   184: if_icmplt -> 197
    //   187: iload_2
    //   188: iload_1
    //   189: isub
    //   190: istore_1
    //   191: iload #6
    //   193: istore_2
    //   194: goto -> 105
    //   197: new java/lang/NumberFormatException
    //   200: dup
    //   201: aload_0
    //   202: invokevirtual numberString : ()Ljava/lang/String;
    //   205: invokespecial <init> : (Ljava/lang/String;)V
    //   208: athrow
    //   209: new java/lang/NumberFormatException
    //   212: dup
    //   213: aload_0
    //   214: invokevirtual numberString : ()Ljava/lang/String;
    //   217: invokespecial <init> : (Ljava/lang/String;)V
    //   220: athrow
    //   221: iload_3
    //   222: istore_1
    //   223: iload #5
    //   225: ifeq -> 253
    //   228: iload_1
    //   229: aload_0
    //   230: getfield np : I
    //   233: iconst_1
    //   234: iadd
    //   235: if_icmple -> 241
    //   238: iload #7
    //   240: ireturn
    //   241: new java/lang/NumberFormatException
    //   244: dup
    //   245: aload_0
    //   246: invokevirtual numberString : ()Ljava/lang/String;
    //   249: invokespecial <init> : (Ljava/lang/String;)V
    //   252: athrow
    //   253: iload #7
    //   255: ineg
    //   256: ireturn
  }
  
  public final Number integerValue() throws NumberFormatException {
    long l2;
    int i = this.np;
    boolean bool = false;
    if (i == -1)
      this.np = 0; 
    int j = this.np;
    i = this.sp + j;
    byte b = 32;
    char c = charAt(i - 1);
    if (c != 'B') {
      if (c != 'L') {
        if (c == 'S') {
          i--;
          b = 83;
        } 
      } else {
        i--;
        b = 76;
      } 
    } else {
      i--;
      b = 66;
    } 
    if (charAt(this.np) == '-') {
      l2 = Long.MIN_VALUE;
      j++;
      bool = true;
    } else {
      l2 = -9223372036854775807L;
    } 
    if (j < i) {
      int k = -digits[charAt(j)];
      j++;
      l1 = k;
    } else {
      l1 = 0L;
    } 
    while (j < i) {
      int k = digits[charAt(j)];
      if (l1 < -922337203685477580L)
        return new BigInteger(numberString()); 
      l1 *= 10L;
      long l = k;
      if (l1 < l2 + l)
        return new BigInteger(numberString()); 
      l1 -= l;
      j++;
    } 
    if (bool) {
      if (j > this.np + 1)
        return (Number)((l1 >= -2147483648L && b != 76) ? ((b == 83) ? Short.valueOf((short)(int)l1) : ((b == 66) ? Byte.valueOf((byte)(int)l1) : Integer.valueOf((int)l1))) : Long.valueOf(l1)); 
      throw new NumberFormatException(numberString());
    } 
    long l1 = -l1;
    return (Number)((l1 <= 2147483647L && b != 76) ? ((b == 83) ? Short.valueOf((short)(int)l1) : ((b == 66) ? Byte.valueOf((byte)(int)l1) : Integer.valueOf((int)l1))) : Long.valueOf(l1));
  }
  
  public final boolean isBlankInput() {
    for (int i = 0;; i++) {
      char c = charAt(i);
      if (c == '\032')
        return true; 
      if (!isWhitespace(c))
        return false; 
    } 
  }
  
  public abstract boolean isEOF();
  
  public final boolean isEnabled(Feature paramFeature) {
    int i = this.features;
    return ((paramFeature.mask & i) != 0);
  }
  
  public final boolean isRef() {
    int i = this.sp;
    boolean bool2 = false;
    if (i != 4)
      return false; 
    boolean bool1 = bool2;
    if (charAt(this.np + 1) == '$') {
      bool1 = bool2;
      if (charAt(this.np + 2) == 'r') {
        bool1 = bool2;
        if (charAt(this.np + 3) == 'e') {
          bool1 = bool2;
          if (charAt(this.np + 4) == 'f')
            bool1 = true; 
        } 
      } 
    } 
    return bool1;
  }
  
  protected void lexError(String paramString, Object... paramVarArgs) {
    this.token = 1;
  }
  
  public final long longValue() throws NumberFormatException {
    int j;
    long l1;
    long l2;
    int i = this.np;
    boolean bool = false;
    if (i == -1)
      this.np = 0; 
    i = this.np;
    int k = this.sp + i;
    if (charAt(i) == '-') {
      l2 = Long.MIN_VALUE;
      i++;
      bool = true;
    } else {
      l2 = -9223372036854775807L;
    } 
    if (i < k) {
      l1 = -digits[charAt(i)];
      i++;
    } else {
      l1 = 0L;
    } 
    while (true) {
      j = i;
      if (i < k) {
        j = i + 1;
        i = charAt(i);
        if (i == 76 || i == 83 || i == 66)
          break; 
        i = digits[i];
        if (l1 >= -922337203685477580L) {
          l1 *= 10L;
          long l = i;
          if (l1 >= l2 + l) {
            l1 -= l;
            i = j;
            continue;
          } 
          throw new NumberFormatException(numberString());
        } 
        throw new NumberFormatException(numberString());
      } 
      break;
    } 
    if (bool) {
      if (j > this.np + 1)
        return l1; 
      throw new NumberFormatException(numberString());
    } 
    return -l1;
  }
  
  public final boolean matchField(char[] paramArrayOfchar) {
    if (!charArrayCompare(paramArrayOfchar))
      return false; 
    this.bp += paramArrayOfchar.length;
    this.ch = charAt(this.bp);
    char c = this.ch;
    if (c == '{') {
      next();
      this.token = 12;
      return true;
    } 
    if (c == '[') {
      next();
      this.token = 14;
      return true;
    } 
    if (c == 'S' && charAt(this.bp + 1) == 'e' && charAt(this.bp + 2) == 't' && charAt(this.bp + 3) == '[') {
      this.bp += 3;
      this.ch = charAt(this.bp);
      this.token = 21;
      return true;
    } 
    nextToken();
    return true;
  }
  
  public final int matchStat() {
    return this.matchStat;
  }
  
  public abstract char next();
  
  public final void nextIdent() {
    while (isWhitespace(this.ch))
      next(); 
    char c = this.ch;
    if (c == '_' || Character.isLetter(c)) {
      scanIdent();
      return;
    } 
    nextToken();
  }
  
  public final void nextToken() {
    this.sp = 0;
    while (true) {
      this.pos = this.bp;
      char c = this.ch;
      if (c == '/') {
        skipComment();
        continue;
      } 
      if (c == '"') {
        scanString();
        return;
      } 
      if (c == ',') {
        next();
        this.token = 16;
        return;
      } 
      if (c >= '0' && c <= '9') {
        scanNumber();
        return;
      } 
      c = this.ch;
      if (c == '-') {
        scanNumber();
        return;
      } 
      if (c != '\f' && c != '\r' && c != ' ')
        if (c != ':') {
          if (c != 'N') {
            if (c != '[') {
              if (c != ']') {
                if (c != 'f') {
                  if (c != 'n') {
                    if (c != '{') {
                      if (c != '}') {
                        if (c != 'S') {
                          if (c != 'T') {
                            if (c != 't') {
                              if (c != 'u') {
                                switch (c) {
                                  default:
                                    switch (c) {
                                      default:
                                        if (isEOF()) {
                                          if (this.token != 20) {
                                            this.token = 20;
                                            int i = this.eofPos;
                                            this.bp = i;
                                            this.pos = i;
                                            return;
                                          } 
                                          throw new JSONException("EOF error");
                                        } 
                                        c = this.ch;
                                        if (c <= '\037' || c == '') {
                                          next();
                                          continue;
                                        } 
                                        lexError("illegal.char", new Object[] { String.valueOf(c) });
                                        next();
                                        return;
                                      case ')':
                                        next();
                                        this.token = 11;
                                        return;
                                      case '(':
                                        next();
                                        this.token = 10;
                                        return;
                                      case '\'':
                                        break;
                                    } 
                                    if (isEnabled(Feature.AllowSingleQuotes)) {
                                      scanStringSingleQuote();
                                      return;
                                    } 
                                    throw new JSONException("Feature.AllowSingleQuotes is false");
                                  case '\b':
                                  case '\t':
                                  case '\n':
                                    break;
                                } 
                              } else {
                                scanUndefined();
                                return;
                              } 
                            } else {
                              scanTrue();
                              return;
                            } 
                          } else {
                            scanTreeSet();
                            return;
                          } 
                        } else {
                          scanSet();
                          return;
                        } 
                      } else {
                        next();
                        this.token = 13;
                        return;
                      } 
                    } else {
                      next();
                      this.token = 12;
                      return;
                    } 
                  } else {
                    scanNullOrNew();
                    return;
                  } 
                } else {
                  scanFalse();
                  return;
                } 
              } else {
                next();
                this.token = 15;
                return;
              } 
            } else {
              next();
              this.token = 14;
              return;
            } 
          } else {
            scanNULL();
            return;
          } 
        } else {
          next();
          this.token = 17;
          return;
        }  
      next();
    } 
  }
  
  public final void nextToken(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield sp : I
    //   5: iload_1
    //   6: iconst_2
    //   7: if_icmpeq -> 349
    //   10: iload_1
    //   11: iconst_4
    //   12: if_icmpeq -> 259
    //   15: iload_1
    //   16: bipush #12
    //   18: if_icmpeq -> 218
    //   21: iload_1
    //   22: bipush #18
    //   24: if_icmpeq -> 213
    //   27: iload_1
    //   28: bipush #20
    //   30: if_icmpeq -> 197
    //   33: iload_1
    //   34: tableswitch default -> 60, 14 -> 156, 15 -> 135, 16 -> 63
    //   60: goto -> 439
    //   63: aload_0
    //   64: getfield ch : C
    //   67: istore_2
    //   68: iload_2
    //   69: bipush #44
    //   71: if_icmpne -> 86
    //   74: aload_0
    //   75: bipush #16
    //   77: putfield token : I
    //   80: aload_0
    //   81: invokevirtual next : ()C
    //   84: pop
    //   85: return
    //   86: iload_2
    //   87: bipush #125
    //   89: if_icmpne -> 104
    //   92: aload_0
    //   93: bipush #13
    //   95: putfield token : I
    //   98: aload_0
    //   99: invokevirtual next : ()C
    //   102: pop
    //   103: return
    //   104: iload_2
    //   105: bipush #93
    //   107: if_icmpne -> 122
    //   110: aload_0
    //   111: bipush #15
    //   113: putfield token : I
    //   116: aload_0
    //   117: invokevirtual next : ()C
    //   120: pop
    //   121: return
    //   122: iload_2
    //   123: bipush #26
    //   125: if_icmpne -> 439
    //   128: aload_0
    //   129: bipush #20
    //   131: putfield token : I
    //   134: return
    //   135: aload_0
    //   136: getfield ch : C
    //   139: bipush #93
    //   141: if_icmpne -> 197
    //   144: aload_0
    //   145: bipush #15
    //   147: putfield token : I
    //   150: aload_0
    //   151: invokevirtual next : ()C
    //   154: pop
    //   155: return
    //   156: aload_0
    //   157: getfield ch : C
    //   160: istore_2
    //   161: iload_2
    //   162: bipush #91
    //   164: if_icmpne -> 179
    //   167: aload_0
    //   168: bipush #14
    //   170: putfield token : I
    //   173: aload_0
    //   174: invokevirtual next : ()C
    //   177: pop
    //   178: return
    //   179: iload_2
    //   180: bipush #123
    //   182: if_icmpne -> 439
    //   185: aload_0
    //   186: bipush #12
    //   188: putfield token : I
    //   191: aload_0
    //   192: invokevirtual next : ()C
    //   195: pop
    //   196: return
    //   197: aload_0
    //   198: getfield ch : C
    //   201: bipush #26
    //   203: if_icmpne -> 439
    //   206: aload_0
    //   207: bipush #20
    //   209: putfield token : I
    //   212: return
    //   213: aload_0
    //   214: invokevirtual nextIdent : ()V
    //   217: return
    //   218: aload_0
    //   219: getfield ch : C
    //   222: istore_2
    //   223: iload_2
    //   224: bipush #123
    //   226: if_icmpne -> 241
    //   229: aload_0
    //   230: bipush #12
    //   232: putfield token : I
    //   235: aload_0
    //   236: invokevirtual next : ()C
    //   239: pop
    //   240: return
    //   241: iload_2
    //   242: bipush #91
    //   244: if_icmpne -> 439
    //   247: aload_0
    //   248: bipush #14
    //   250: putfield token : I
    //   253: aload_0
    //   254: invokevirtual next : ()C
    //   257: pop
    //   258: return
    //   259: aload_0
    //   260: getfield ch : C
    //   263: istore_2
    //   264: iload_2
    //   265: bipush #34
    //   267: if_icmpne -> 283
    //   270: aload_0
    //   271: aload_0
    //   272: getfield bp : I
    //   275: putfield pos : I
    //   278: aload_0
    //   279: invokevirtual scanString : ()V
    //   282: return
    //   283: iload_2
    //   284: bipush #48
    //   286: if_icmplt -> 308
    //   289: iload_2
    //   290: bipush #57
    //   292: if_icmpgt -> 308
    //   295: aload_0
    //   296: aload_0
    //   297: getfield bp : I
    //   300: putfield pos : I
    //   303: aload_0
    //   304: invokevirtual scanNumber : ()V
    //   307: return
    //   308: aload_0
    //   309: getfield ch : C
    //   312: istore_2
    //   313: iload_2
    //   314: bipush #91
    //   316: if_icmpne -> 331
    //   319: aload_0
    //   320: bipush #14
    //   322: putfield token : I
    //   325: aload_0
    //   326: invokevirtual next : ()C
    //   329: pop
    //   330: return
    //   331: iload_2
    //   332: bipush #123
    //   334: if_icmpne -> 439
    //   337: aload_0
    //   338: bipush #12
    //   340: putfield token : I
    //   343: aload_0
    //   344: invokevirtual next : ()C
    //   347: pop
    //   348: return
    //   349: aload_0
    //   350: getfield ch : C
    //   353: istore_2
    //   354: iload_2
    //   355: bipush #48
    //   357: if_icmplt -> 379
    //   360: iload_2
    //   361: bipush #57
    //   363: if_icmpgt -> 379
    //   366: aload_0
    //   367: aload_0
    //   368: getfield bp : I
    //   371: putfield pos : I
    //   374: aload_0
    //   375: invokevirtual scanNumber : ()V
    //   378: return
    //   379: aload_0
    //   380: getfield ch : C
    //   383: istore_2
    //   384: iload_2
    //   385: bipush #34
    //   387: if_icmpne -> 403
    //   390: aload_0
    //   391: aload_0
    //   392: getfield bp : I
    //   395: putfield pos : I
    //   398: aload_0
    //   399: invokevirtual scanString : ()V
    //   402: return
    //   403: iload_2
    //   404: bipush #91
    //   406: if_icmpne -> 421
    //   409: aload_0
    //   410: bipush #14
    //   412: putfield token : I
    //   415: aload_0
    //   416: invokevirtual next : ()C
    //   419: pop
    //   420: return
    //   421: iload_2
    //   422: bipush #123
    //   424: if_icmpne -> 439
    //   427: aload_0
    //   428: bipush #12
    //   430: putfield token : I
    //   433: aload_0
    //   434: invokevirtual next : ()C
    //   437: pop
    //   438: return
    //   439: aload_0
    //   440: getfield ch : C
    //   443: istore_2
    //   444: iload_2
    //   445: bipush #32
    //   447: if_icmpeq -> 488
    //   450: iload_2
    //   451: bipush #10
    //   453: if_icmpeq -> 488
    //   456: iload_2
    //   457: bipush #13
    //   459: if_icmpeq -> 488
    //   462: iload_2
    //   463: bipush #9
    //   465: if_icmpeq -> 488
    //   468: iload_2
    //   469: bipush #12
    //   471: if_icmpeq -> 488
    //   474: iload_2
    //   475: bipush #8
    //   477: if_icmpne -> 483
    //   480: goto -> 488
    //   483: aload_0
    //   484: invokevirtual nextToken : ()V
    //   487: return
    //   488: aload_0
    //   489: invokevirtual next : ()C
    //   492: pop
    //   493: goto -> 5
  }
  
  public final void nextTokenWithChar(char paramChar) {
    this.sp = 0;
    while (true) {
      char c = this.ch;
      if (c == paramChar) {
        next();
        nextToken();
        return;
      } 
      if (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b') {
        next();
        continue;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("not match ");
      stringBuilder.append(paramChar);
      stringBuilder.append(" - ");
      stringBuilder.append(this.ch);
      throw new JSONException(stringBuilder.toString());
    } 
  }
  
  public final void nextTokenWithColon() {
    nextTokenWithChar(':');
  }
  
  public final void nextTokenWithColon(int paramInt) {
    nextTokenWithChar(':');
  }
  
  public final void nextTokenWithComma(int paramInt) {
    nextTokenWithChar(',');
  }
  
  public abstract String numberString();
  
  public final int pos() {
    return this.pos;
  }
  
  protected final void putChar(char paramChar) {
    int i = this.sp;
    char[] arrayOfChar = this.sbuf;
    if (i == arrayOfChar.length) {
      char[] arrayOfChar1 = new char[arrayOfChar.length * 2];
      System.arraycopy(arrayOfChar, 0, arrayOfChar1, 0, arrayOfChar.length);
      this.sbuf = arrayOfChar1;
    } 
    arrayOfChar = this.sbuf;
    i = this.sp;
    this.sp = i + 1;
    arrayOfChar[i] = paramChar;
  }
  
  public final void resetStringPosition() {
    this.sp = 0;
  }
  
  public boolean scanBoolean(char paramChar) {
    boolean bool = false;
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    byte b = 5;
    if (c == 't') {
      if (charAt(this.bp + 1) == 'r' && charAt(this.bp + 1 + 1) == 'u' && charAt(this.bp + 1 + 2) == 'e') {
        c = charAt(this.bp + 4);
        bool = true;
      } else {
        this.matchStat = -1;
        return false;
      } 
    } else if (c == 'f') {
      if (charAt(this.bp + 1) == 'a' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 's' && charAt(this.bp + 1 + 3) == 'e') {
        c = charAt(this.bp + 5);
        b = 6;
      } else {
        this.matchStat = -1;
        return false;
      } 
    } else {
      b = 1;
    } 
    if (c == paramChar) {
      this.bp += b - 1;
      next();
      this.matchStat = 3;
      return bool;
    } 
    this.matchStat = -1;
    return bool;
  }
  
  public Enum<?> scanEnum(Class<?> paramClass, SymbolTable paramSymbolTable, char paramChar) {
    String str = scanSymbolWithSeperator(paramSymbolTable, paramChar);
    return (Enum<?>)((str == null) ? null : Enum.valueOf(paramClass, str));
  }
  
  public final void scanFalse() {
    if (this.ch == 'f') {
      next();
      if (this.ch == 'a') {
        next();
        if (this.ch == 'l') {
          next();
          if (this.ch == 's') {
            next();
            if (this.ch == 'e') {
              next();
              char c = this.ch;
              if (c == ' ' || c == ',' || c == '}' || c == ']' || c == '\n' || c == '\r' || c == '\t' || c == '\032' || c == '\f' || c == '\b' || c == ':') {
                this.token = 7;
                return;
              } 
              throw new JSONException("scan false error");
            } 
            throw new JSONException("error parse false");
          } 
          throw new JSONException("error parse false");
        } 
        throw new JSONException("error parse false");
      } 
      throw new JSONException("error parse false");
    } 
    throw new JSONException("error parse false");
  }
  
  public boolean scanFieldBoolean(char[] paramArrayOfchar) {
    boolean bool;
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return false;
    } 
    int j = paramArrayOfchar.length;
    int k = this.bp;
    int i = j + 1;
    j = charAt(k + j);
    if (j == 116) {
      k = this.bp;
      j = i + 1;
      if (charAt(k + i) != 'r') {
        this.matchStat = -1;
        return false;
      } 
      i = this.bp;
      k = j + 1;
      if (charAt(i + j) != 'u') {
        this.matchStat = -1;
        return false;
      } 
      j = this.bp;
      i = k + 1;
      if (charAt(j + k) != 'e') {
        this.matchStat = -1;
        return false;
      } 
      bool = true;
    } else if (j == 102) {
      k = this.bp;
      j = i + 1;
      if (charAt(k + i) != 'a') {
        this.matchStat = -1;
        return false;
      } 
      k = this.bp;
      i = j + 1;
      if (charAt(k + j) != 'l') {
        this.matchStat = -1;
        return false;
      } 
      j = this.bp;
      k = i + 1;
      if (charAt(j + i) != 's') {
        this.matchStat = -1;
        return false;
      } 
      if (charAt(this.bp + k) != 'e') {
        this.matchStat = -1;
        return false;
      } 
      i = k + 1;
      bool = false;
    } else {
      this.matchStat = -1;
      return false;
    } 
    k = this.bp;
    j = i + 1;
    i = charAt(k + i);
    if (i == 44) {
      this.bp += j - 1;
      next();
      this.matchStat = 3;
      this.token = 16;
      return bool;
    } 
    if (i == 125) {
      k = this.bp;
      i = j + 1;
      j = charAt(k + j);
      if (j == 44) {
        this.token = 16;
        this.bp += i - 1;
        next();
      } else if (j == 93) {
        this.token = 15;
        this.bp += i - 1;
        next();
      } else if (j == 125) {
        this.token = 13;
        this.bp += i - 1;
        next();
      } else {
        if (j == 26) {
          this.token = 20;
          this.bp += i - 1;
          this.ch = '\032';
          this.matchStat = 4;
          return bool;
        } 
        this.matchStat = -1;
        return false;
      } 
      this.matchStat = 4;
      return bool;
    } 
    this.matchStat = -1;
    return false;
  }
  
  public final double scanFieldDouble(char paramChar) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield matchStat : I
    //   5: aload_0
    //   6: aload_0
    //   7: getfield bp : I
    //   10: iconst_0
    //   11: iadd
    //   12: invokevirtual charAt : (I)C
    //   15: istore #4
    //   17: iload #4
    //   19: bipush #48
    //   21: if_icmplt -> 427
    //   24: iload #4
    //   26: bipush #57
    //   28: if_icmpgt -> 427
    //   31: iconst_1
    //   32: istore #5
    //   34: aload_0
    //   35: getfield bp : I
    //   38: istore #6
    //   40: iload #5
    //   42: iconst_1
    //   43: iadd
    //   44: istore #4
    //   46: aload_0
    //   47: iload #6
    //   49: iload #5
    //   51: iadd
    //   52: invokevirtual charAt : (I)C
    //   55: istore #5
    //   57: iload #5
    //   59: bipush #48
    //   61: if_icmplt -> 78
    //   64: iload #5
    //   66: bipush #57
    //   68: if_icmpgt -> 78
    //   71: iload #4
    //   73: istore #5
    //   75: goto -> 34
    //   78: iload #5
    //   80: bipush #46
    //   82: if_icmpne -> 193
    //   85: aload_0
    //   86: getfield bp : I
    //   89: istore #6
    //   91: iload #4
    //   93: iconst_1
    //   94: iadd
    //   95: istore #5
    //   97: aload_0
    //   98: iload #6
    //   100: iload #4
    //   102: iadd
    //   103: invokevirtual charAt : (I)C
    //   106: istore #4
    //   108: iload #4
    //   110: bipush #48
    //   112: if_icmplt -> 186
    //   115: iload #4
    //   117: bipush #57
    //   119: if_icmpgt -> 186
    //   122: iload #5
    //   124: istore #4
    //   126: aload_0
    //   127: getfield bp : I
    //   130: istore #5
    //   132: iload #4
    //   134: iconst_1
    //   135: iadd
    //   136: istore #6
    //   138: aload_0
    //   139: iload #5
    //   141: iload #4
    //   143: iadd
    //   144: invokevirtual charAt : (I)C
    //   147: istore #7
    //   149: iload #6
    //   151: istore #4
    //   153: iload #7
    //   155: istore #5
    //   157: iload #7
    //   159: bipush #48
    //   161: if_icmplt -> 193
    //   164: iload #6
    //   166: istore #4
    //   168: iload #7
    //   170: istore #5
    //   172: iload #7
    //   174: bipush #57
    //   176: if_icmpgt -> 193
    //   179: iload #6
    //   181: istore #4
    //   183: goto -> 126
    //   186: aload_0
    //   187: iconst_m1
    //   188: putfield matchStat : I
    //   191: dconst_0
    //   192: dreturn
    //   193: iload #5
    //   195: bipush #101
    //   197: if_icmpeq -> 215
    //   200: iload #4
    //   202: istore #6
    //   204: iload #5
    //   206: istore #7
    //   208: iload #5
    //   210: bipush #69
    //   212: if_icmpne -> 357
    //   215: aload_0
    //   216: getfield bp : I
    //   219: istore #5
    //   221: iload #4
    //   223: iconst_1
    //   224: iadd
    //   225: istore #6
    //   227: aload_0
    //   228: iload #5
    //   230: iload #4
    //   232: iadd
    //   233: invokevirtual charAt : (I)C
    //   236: istore #7
    //   238: iload #7
    //   240: bipush #43
    //   242: if_icmpeq -> 278
    //   245: iload #7
    //   247: istore #4
    //   249: iload #6
    //   251: istore #5
    //   253: iload #7
    //   255: bipush #45
    //   257: if_icmpne -> 263
    //   260: goto -> 278
    //   263: iload #5
    //   265: istore #6
    //   267: iload #4
    //   269: istore #5
    //   271: iload #6
    //   273: istore #4
    //   275: goto -> 301
    //   278: aload_0
    //   279: getfield bp : I
    //   282: istore #5
    //   284: iload #6
    //   286: iconst_1
    //   287: iadd
    //   288: istore #4
    //   290: aload_0
    //   291: iload #5
    //   293: iload #6
    //   295: iadd
    //   296: invokevirtual charAt : (I)C
    //   299: istore #5
    //   301: iload #4
    //   303: istore #6
    //   305: iload #5
    //   307: istore #7
    //   309: iload #5
    //   311: bipush #48
    //   313: if_icmplt -> 357
    //   316: iload #4
    //   318: istore #6
    //   320: iload #5
    //   322: istore #7
    //   324: iload #5
    //   326: bipush #57
    //   328: if_icmpgt -> 357
    //   331: aload_0
    //   332: getfield bp : I
    //   335: istore #6
    //   337: iload #4
    //   339: iconst_1
    //   340: iadd
    //   341: istore #5
    //   343: aload_0
    //   344: iload #6
    //   346: iload #4
    //   348: iadd
    //   349: invokevirtual charAt : (I)C
    //   352: istore #4
    //   354: goto -> 263
    //   357: aload_0
    //   358: getfield bp : I
    //   361: istore #4
    //   363: aload_0
    //   364: iload #4
    //   366: iload #4
    //   368: iload #6
    //   370: iadd
    //   371: iload #4
    //   373: isub
    //   374: iconst_1
    //   375: isub
    //   376: invokevirtual subString : (II)Ljava/lang/String;
    //   379: invokestatic parseDouble : (Ljava/lang/String;)D
    //   382: dstore_2
    //   383: iload #7
    //   385: iload_1
    //   386: if_icmpne -> 420
    //   389: aload_0
    //   390: aload_0
    //   391: getfield bp : I
    //   394: iload #6
    //   396: iconst_1
    //   397: isub
    //   398: iadd
    //   399: putfield bp : I
    //   402: aload_0
    //   403: invokevirtual next : ()C
    //   406: pop
    //   407: aload_0
    //   408: iconst_3
    //   409: putfield matchStat : I
    //   412: aload_0
    //   413: bipush #16
    //   415: putfield token : I
    //   418: dload_2
    //   419: dreturn
    //   420: aload_0
    //   421: iconst_m1
    //   422: putfield matchStat : I
    //   425: dload_2
    //   426: dreturn
    //   427: aload_0
    //   428: iconst_m1
    //   429: putfield matchStat : I
    //   432: dconst_0
    //   433: dreturn
  }
  
  public final double scanFieldDouble(char[] paramArrayOfchar) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield matchStat : I
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual charArrayCompare : ([C)Z
    //   10: ifne -> 21
    //   13: aload_0
    //   14: bipush #-2
    //   16: putfield matchStat : I
    //   19: dconst_0
    //   20: dreturn
    //   21: aload_1
    //   22: arraylength
    //   23: istore #5
    //   25: aload_0
    //   26: getfield bp : I
    //   29: istore #6
    //   31: iload #5
    //   33: iconst_1
    //   34: iadd
    //   35: istore #4
    //   37: aload_0
    //   38: iload #6
    //   40: iload #5
    //   42: iadd
    //   43: invokevirtual charAt : (I)C
    //   46: istore #5
    //   48: iload #5
    //   50: bipush #48
    //   52: if_icmplt -> 645
    //   55: iload #5
    //   57: bipush #57
    //   59: if_icmpgt -> 645
    //   62: aload_0
    //   63: getfield bp : I
    //   66: istore #5
    //   68: iload #4
    //   70: iconst_1
    //   71: iadd
    //   72: istore #6
    //   74: aload_0
    //   75: iload #5
    //   77: iload #4
    //   79: iadd
    //   80: invokevirtual charAt : (I)C
    //   83: istore #7
    //   85: iload #7
    //   87: bipush #48
    //   89: if_icmplt -> 106
    //   92: iload #7
    //   94: bipush #57
    //   96: if_icmpgt -> 106
    //   99: iload #6
    //   101: istore #4
    //   103: goto -> 62
    //   106: iload #7
    //   108: istore #5
    //   110: iload #6
    //   112: istore #4
    //   114: iload #7
    //   116: bipush #46
    //   118: if_icmpne -> 225
    //   121: aload_0
    //   122: getfield bp : I
    //   125: istore #5
    //   127: iload #6
    //   129: iconst_1
    //   130: iadd
    //   131: istore #4
    //   133: aload_0
    //   134: iload #5
    //   136: iload #6
    //   138: iadd
    //   139: invokevirtual charAt : (I)C
    //   142: istore #5
    //   144: iload #5
    //   146: bipush #48
    //   148: if_icmplt -> 218
    //   151: iload #5
    //   153: bipush #57
    //   155: if_icmpgt -> 218
    //   158: aload_0
    //   159: getfield bp : I
    //   162: istore #5
    //   164: iload #4
    //   166: iconst_1
    //   167: iadd
    //   168: istore #6
    //   170: aload_0
    //   171: iload #5
    //   173: iload #4
    //   175: iadd
    //   176: invokevirtual charAt : (I)C
    //   179: istore #7
    //   181: iload #7
    //   183: istore #5
    //   185: iload #6
    //   187: istore #4
    //   189: iload #7
    //   191: bipush #48
    //   193: if_icmplt -> 225
    //   196: iload #7
    //   198: istore #5
    //   200: iload #6
    //   202: istore #4
    //   204: iload #7
    //   206: bipush #57
    //   208: if_icmpgt -> 225
    //   211: iload #6
    //   213: istore #4
    //   215: goto -> 158
    //   218: aload_0
    //   219: iconst_m1
    //   220: putfield matchStat : I
    //   223: dconst_0
    //   224: dreturn
    //   225: iload #5
    //   227: bipush #101
    //   229: if_icmpeq -> 247
    //   232: iload #5
    //   234: istore #7
    //   236: iload #4
    //   238: istore #6
    //   240: iload #5
    //   242: bipush #69
    //   244: if_icmpne -> 389
    //   247: aload_0
    //   248: getfield bp : I
    //   251: istore #5
    //   253: iload #4
    //   255: iconst_1
    //   256: iadd
    //   257: istore #6
    //   259: aload_0
    //   260: iload #5
    //   262: iload #4
    //   264: iadd
    //   265: invokevirtual charAt : (I)C
    //   268: istore #7
    //   270: iload #7
    //   272: bipush #43
    //   274: if_icmpeq -> 310
    //   277: iload #7
    //   279: istore #4
    //   281: iload #6
    //   283: istore #5
    //   285: iload #7
    //   287: bipush #45
    //   289: if_icmpne -> 295
    //   292: goto -> 310
    //   295: iload #5
    //   297: istore #6
    //   299: iload #4
    //   301: istore #5
    //   303: iload #6
    //   305: istore #4
    //   307: goto -> 333
    //   310: aload_0
    //   311: getfield bp : I
    //   314: istore #5
    //   316: iload #6
    //   318: iconst_1
    //   319: iadd
    //   320: istore #4
    //   322: aload_0
    //   323: iload #5
    //   325: iload #6
    //   327: iadd
    //   328: invokevirtual charAt : (I)C
    //   331: istore #5
    //   333: iload #5
    //   335: istore #7
    //   337: iload #4
    //   339: istore #6
    //   341: iload #5
    //   343: bipush #48
    //   345: if_icmplt -> 389
    //   348: iload #5
    //   350: istore #7
    //   352: iload #4
    //   354: istore #6
    //   356: iload #5
    //   358: bipush #57
    //   360: if_icmpgt -> 389
    //   363: aload_0
    //   364: getfield bp : I
    //   367: istore #6
    //   369: iload #4
    //   371: iconst_1
    //   372: iadd
    //   373: istore #5
    //   375: aload_0
    //   376: iload #6
    //   378: iload #4
    //   380: iadd
    //   381: invokevirtual charAt : (I)C
    //   384: istore #4
    //   386: goto -> 295
    //   389: aload_0
    //   390: getfield bp : I
    //   393: istore #4
    //   395: aload_1
    //   396: arraylength
    //   397: iload #4
    //   399: iadd
    //   400: istore #5
    //   402: aload_0
    //   403: iload #5
    //   405: iload #4
    //   407: iload #6
    //   409: iadd
    //   410: iload #5
    //   412: isub
    //   413: iconst_1
    //   414: isub
    //   415: invokevirtual subString : (II)Ljava/lang/String;
    //   418: invokestatic parseDouble : (Ljava/lang/String;)D
    //   421: dstore_2
    //   422: iload #7
    //   424: bipush #44
    //   426: if_icmpne -> 460
    //   429: aload_0
    //   430: aload_0
    //   431: getfield bp : I
    //   434: iload #6
    //   436: iconst_1
    //   437: isub
    //   438: iadd
    //   439: putfield bp : I
    //   442: aload_0
    //   443: invokevirtual next : ()C
    //   446: pop
    //   447: aload_0
    //   448: iconst_3
    //   449: putfield matchStat : I
    //   452: aload_0
    //   453: bipush #16
    //   455: putfield token : I
    //   458: dload_2
    //   459: dreturn
    //   460: iload #7
    //   462: bipush #125
    //   464: if_icmpne -> 638
    //   467: aload_0
    //   468: getfield bp : I
    //   471: istore #5
    //   473: iload #6
    //   475: iconst_1
    //   476: iadd
    //   477: istore #4
    //   479: aload_0
    //   480: iload #5
    //   482: iload #6
    //   484: iadd
    //   485: invokevirtual charAt : (I)C
    //   488: istore #5
    //   490: iload #5
    //   492: bipush #44
    //   494: if_icmpne -> 524
    //   497: aload_0
    //   498: bipush #16
    //   500: putfield token : I
    //   503: aload_0
    //   504: aload_0
    //   505: getfield bp : I
    //   508: iload #4
    //   510: iconst_1
    //   511: isub
    //   512: iadd
    //   513: putfield bp : I
    //   516: aload_0
    //   517: invokevirtual next : ()C
    //   520: pop
    //   521: goto -> 624
    //   524: iload #5
    //   526: bipush #93
    //   528: if_icmpne -> 558
    //   531: aload_0
    //   532: bipush #15
    //   534: putfield token : I
    //   537: aload_0
    //   538: aload_0
    //   539: getfield bp : I
    //   542: iload #4
    //   544: iconst_1
    //   545: isub
    //   546: iadd
    //   547: putfield bp : I
    //   550: aload_0
    //   551: invokevirtual next : ()C
    //   554: pop
    //   555: goto -> 624
    //   558: iload #5
    //   560: bipush #125
    //   562: if_icmpne -> 592
    //   565: aload_0
    //   566: bipush #13
    //   568: putfield token : I
    //   571: aload_0
    //   572: aload_0
    //   573: getfield bp : I
    //   576: iload #4
    //   578: iconst_1
    //   579: isub
    //   580: iadd
    //   581: putfield bp : I
    //   584: aload_0
    //   585: invokevirtual next : ()C
    //   588: pop
    //   589: goto -> 624
    //   592: iload #5
    //   594: bipush #26
    //   596: if_icmpne -> 631
    //   599: aload_0
    //   600: bipush #20
    //   602: putfield token : I
    //   605: aload_0
    //   606: aload_0
    //   607: getfield bp : I
    //   610: iload #4
    //   612: iconst_1
    //   613: isub
    //   614: iadd
    //   615: putfield bp : I
    //   618: aload_0
    //   619: bipush #26
    //   621: putfield ch : C
    //   624: aload_0
    //   625: iconst_4
    //   626: putfield matchStat : I
    //   629: dload_2
    //   630: dreturn
    //   631: aload_0
    //   632: iconst_m1
    //   633: putfield matchStat : I
    //   636: dconst_0
    //   637: dreturn
    //   638: aload_0
    //   639: iconst_m1
    //   640: putfield matchStat : I
    //   643: dconst_0
    //   644: dreturn
    //   645: aload_0
    //   646: iconst_m1
    //   647: putfield matchStat : I
    //   650: dconst_0
    //   651: dreturn
  }
  
  public final float scanFieldFloat(char[] paramArrayOfchar) {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return 0.0F;
    } 
    int j = paramArrayOfchar.length;
    int k = this.bp;
    int i = j + 1;
    j = charAt(k + j);
    if (j >= 48 && j <= 57) {
      char c;
      while (true) {
        k = this.bp;
        j = i + 1;
        c = charAt(k + i);
        if (c >= '0' && c <= '9') {
          i = j;
          continue;
        } 
        break;
      } 
      k = c;
      i = j;
      if (c == '.') {
        k = this.bp;
        i = j + 1;
        j = charAt(k + j);
        if (j >= 48 && j <= 57) {
          while (true) {
            k = this.bp;
            j = i + 1;
            c = charAt(k + i);
            k = c;
            i = j;
            if (c >= '0') {
              k = c;
              i = j;
              if (c <= '9') {
                i = j;
                continue;
              } 
            } 
            break;
          } 
        } else {
          this.matchStat = -1;
          return 0.0F;
        } 
      } 
      j = this.bp;
      int m = paramArrayOfchar.length + j;
      float f = Float.parseFloat(subString(m, j + i - m - 1));
      if (k == 44) {
        this.bp += i - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return f;
      } 
      if (k == 125) {
        k = this.bp;
        j = i + 1;
        i = charAt(k + i);
        if (i == 44) {
          this.token = 16;
          this.bp += j - 1;
          next();
        } else if (i == 93) {
          this.token = 15;
          this.bp += j - 1;
          next();
        } else if (i == 125) {
          this.token = 13;
          this.bp += j - 1;
          next();
        } else {
          if (i == 26) {
            this.bp += j - 1;
            this.token = 20;
            this.ch = '\032';
            this.matchStat = 4;
            return f;
          } 
          this.matchStat = -1;
          return 0.0F;
        } 
        this.matchStat = 4;
        return f;
      } 
      this.matchStat = -1;
      return 0.0F;
    } 
    this.matchStat = -1;
    return 0.0F;
  }
  
  public int scanFieldInt(char[] paramArrayOfchar) {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return 0;
    } 
    int i = paramArrayOfchar.length;
    int k = this.bp;
    int j = i + 1;
    i = charAt(k + i);
    if (i >= 48 && i <= 57) {
      i = digits[i];
      while (true) {
        int m = this.bp;
        k = j + 1;
        j = charAt(m + j);
        if (j >= 48 && j <= 57) {
          i = i * 10 + digits[j];
          j = k;
          continue;
        } 
        break;
      } 
      if (j == 46) {
        this.matchStat = -1;
        return 0;
      } 
      if (i < 0) {
        this.matchStat = -1;
        return 0;
      } 
      if (j == 44) {
        this.bp += k - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return i;
      } 
      if (j == 125) {
        int m = this.bp;
        j = k + 1;
        k = charAt(m + k);
        if (k == 44) {
          this.token = 16;
          this.bp += j - 1;
          next();
        } else if (k == 93) {
          this.token = 15;
          this.bp += j - 1;
          next();
        } else if (k == 125) {
          this.token = 13;
          this.bp += j - 1;
          next();
        } else {
          if (k == 26) {
            this.token = 20;
            this.bp += j - 1;
            this.ch = '\032';
            this.matchStat = 4;
            return i;
          } 
          this.matchStat = -1;
          return 0;
        } 
        this.matchStat = 4;
        return i;
      } 
      this.matchStat = -1;
      return 0;
    } 
    this.matchStat = -1;
    return 0;
  }
  
  public long scanFieldLong(char[] paramArrayOfchar) {
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return 0L;
    } 
    int j = paramArrayOfchar.length;
    int k = this.bp;
    int i = j + 1;
    j = charAt(k + j);
    if (j >= 48 && j <= 57) {
      long l = digits[j];
      while (true) {
        k = this.bp;
        j = i + 1;
        i = charAt(k + i);
        if (i >= 48 && i <= 57) {
          l = l * 10L + digits[i];
          i = j;
          continue;
        } 
        break;
      } 
      if (i == 46) {
        this.matchStat = -1;
        return 0L;
      } 
      if (l < 0L) {
        this.matchStat = -1;
        return 0L;
      } 
      if (i == 44) {
        this.bp += j - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return l;
      } 
      if (i == 125) {
        k = this.bp;
        i = j + 1;
        j = charAt(k + j);
        if (j == 44) {
          this.token = 16;
          this.bp += i - 1;
          next();
        } else if (j == 93) {
          this.token = 15;
          this.bp += i - 1;
          next();
        } else if (j == 125) {
          this.token = 13;
          this.bp += i - 1;
          next();
        } else {
          if (j == 26) {
            this.token = 20;
            this.bp += i - 1;
            this.ch = '\032';
            this.matchStat = 4;
            return l;
          } 
          this.matchStat = -1;
          return 0L;
        } 
        this.matchStat = 4;
        return l;
      } 
      this.matchStat = -1;
      return 0L;
    } 
    this.matchStat = -1;
    return 0L;
  }
  
  public String scanFieldString(char[] paramArrayOfchar) {
    int i = 0;
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return stringDefaultValue();
    } 
    int j = paramArrayOfchar.length;
    if (charAt(this.bp + j) != '"') {
      this.matchStat = -1;
      return stringDefaultValue();
    } 
    int k = indexOf('"', this.bp + paramArrayOfchar.length + 1);
    if (k != -1) {
      int m = this.bp + paramArrayOfchar.length + 1;
      String str = subString(m, k - m);
      m = this.bp + paramArrayOfchar.length + 1;
      while (true) {
        n = i;
        if (m < k) {
          if (charAt(m) == '\\') {
            n = 1;
            break;
          } 
          m++;
          continue;
        } 
        break;
      } 
      if (n) {
        this.matchStat = -1;
        return stringDefaultValue();
      } 
      int n = this.bp;
      i = j + 1 + k - paramArrayOfchar.length + n + 1 + 1;
      m = i + 1;
      n = charAt(n + i);
      if (n == 44) {
        this.bp += m - 1;
        next();
        this.matchStat = 3;
        return str;
      } 
      if (n == 125) {
        i = this.bp;
        n = m + 1;
        m = charAt(i + m);
        if (m == 44) {
          this.token = 16;
          this.bp += n - 1;
          next();
        } else if (m == 93) {
          this.token = 15;
          this.bp += n - 1;
          next();
        } else if (m == 125) {
          this.token = 13;
          this.bp += n - 1;
          next();
        } else {
          if (m == 26) {
            this.token = 20;
            this.bp += n - 1;
            this.ch = '\032';
            this.matchStat = 4;
            return str;
          } 
          this.matchStat = -1;
          return stringDefaultValue();
        } 
        this.matchStat = 4;
        return str;
      } 
      this.matchStat = -1;
      return stringDefaultValue();
    } 
    throw new JSONException("unclosed str");
  }
  
  public Collection<String> scanFieldStringArray(char[] paramArrayOfchar, Class<?> paramClass) {
    // Byte code:
    //   0: aload_0
    //   1: iconst_0
    //   2: putfield matchStat : I
    //   5: aload_0
    //   6: aload_1
    //   7: invokevirtual charArrayCompare : ([C)Z
    //   10: ifne -> 21
    //   13: aload_0
    //   14: bipush #-2
    //   16: putfield matchStat : I
    //   19: aconst_null
    //   20: areturn
    //   21: aload_2
    //   22: ldc_w java/util/HashSet
    //   25: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   28: ifeq -> 42
    //   31: new java/util/HashSet
    //   34: dup
    //   35: invokespecial <init> : ()V
    //   38: astore_2
    //   39: goto -> 71
    //   42: aload_2
    //   43: ldc_w java/util/ArrayList
    //   46: invokevirtual isAssignableFrom : (Ljava/lang/Class;)Z
    //   49: ifeq -> 63
    //   52: new java/util/ArrayList
    //   55: dup
    //   56: invokespecial <init> : ()V
    //   59: astore_2
    //   60: goto -> 71
    //   63: aload_2
    //   64: invokevirtual newInstance : ()Ljava/lang/Object;
    //   67: checkcast java/util/Collection
    //   70: astore_2
    //   71: aload_1
    //   72: arraylength
    //   73: istore_3
    //   74: aload_0
    //   75: getfield bp : I
    //   78: istore #5
    //   80: iload_3
    //   81: iconst_1
    //   82: iadd
    //   83: istore #4
    //   85: aload_0
    //   86: iload #5
    //   88: iload_3
    //   89: iadd
    //   90: invokevirtual charAt : (I)C
    //   93: bipush #91
    //   95: if_icmpeq -> 105
    //   98: aload_0
    //   99: iconst_m1
    //   100: putfield matchStat : I
    //   103: aconst_null
    //   104: areturn
    //   105: aload_0
    //   106: getfield bp : I
    //   109: istore #5
    //   111: iload #4
    //   113: iconst_1
    //   114: iadd
    //   115: istore_3
    //   116: aload_0
    //   117: iload #5
    //   119: iload #4
    //   121: iadd
    //   122: invokevirtual charAt : (I)C
    //   125: istore #4
    //   127: iload #4
    //   129: bipush #34
    //   131: if_icmpeq -> 141
    //   134: aload_0
    //   135: iconst_m1
    //   136: putfield matchStat : I
    //   139: aconst_null
    //   140: areturn
    //   141: iload_3
    //   142: istore #4
    //   144: aload_0
    //   145: getfield bp : I
    //   148: istore #6
    //   150: iload #4
    //   152: iconst_1
    //   153: iadd
    //   154: istore #5
    //   156: aload_0
    //   157: iload #6
    //   159: iload #4
    //   161: iadd
    //   162: invokevirtual charAt : (I)C
    //   165: istore #4
    //   167: iload #4
    //   169: bipush #34
    //   171: if_icmpne -> 498
    //   174: aload_0
    //   175: getfield bp : I
    //   178: istore #4
    //   180: iload_3
    //   181: iload #4
    //   183: iadd
    //   184: istore_3
    //   185: aload_2
    //   186: aload_0
    //   187: iload_3
    //   188: iload #4
    //   190: iload #5
    //   192: iadd
    //   193: iload_3
    //   194: isub
    //   195: iconst_1
    //   196: isub
    //   197: invokevirtual subString : (II)Ljava/lang/String;
    //   200: invokeinterface add : (Ljava/lang/Object;)Z
    //   205: pop
    //   206: aload_0
    //   207: getfield bp : I
    //   210: istore #4
    //   212: iload #5
    //   214: iconst_1
    //   215: iadd
    //   216: istore_3
    //   217: aload_0
    //   218: iload #4
    //   220: iload #5
    //   222: iadd
    //   223: invokevirtual charAt : (I)C
    //   226: istore #4
    //   228: iload #4
    //   230: bipush #44
    //   232: if_icmpne -> 254
    //   235: aload_0
    //   236: aload_0
    //   237: getfield bp : I
    //   240: iload_3
    //   241: iadd
    //   242: invokevirtual charAt : (I)C
    //   245: istore #4
    //   247: iload_3
    //   248: iconst_1
    //   249: iadd
    //   250: istore_3
    //   251: goto -> 127
    //   254: iload #4
    //   256: bipush #93
    //   258: if_icmpne -> 491
    //   261: aload_0
    //   262: getfield bp : I
    //   265: istore #5
    //   267: iload_3
    //   268: iconst_1
    //   269: iadd
    //   270: istore #4
    //   272: aload_0
    //   273: iload #5
    //   275: iload_3
    //   276: iadd
    //   277: invokevirtual charAt : (I)C
    //   280: istore_3
    //   281: iload_3
    //   282: bipush #44
    //   284: if_icmpne -> 312
    //   287: aload_0
    //   288: aload_0
    //   289: getfield bp : I
    //   292: iload #4
    //   294: iconst_1
    //   295: isub
    //   296: iadd
    //   297: putfield bp : I
    //   300: aload_0
    //   301: invokevirtual next : ()C
    //   304: pop
    //   305: aload_0
    //   306: iconst_3
    //   307: putfield matchStat : I
    //   310: aload_2
    //   311: areturn
    //   312: iload_3
    //   313: bipush #125
    //   315: if_icmpne -> 484
    //   318: aload_0
    //   319: getfield bp : I
    //   322: istore #5
    //   324: iload #4
    //   326: iconst_1
    //   327: iadd
    //   328: istore_3
    //   329: aload_0
    //   330: iload #5
    //   332: iload #4
    //   334: iadd
    //   335: invokevirtual charAt : (I)C
    //   338: istore #4
    //   340: iload #4
    //   342: bipush #44
    //   344: if_icmpne -> 373
    //   347: aload_0
    //   348: bipush #16
    //   350: putfield token : I
    //   353: aload_0
    //   354: aload_0
    //   355: getfield bp : I
    //   358: iload_3
    //   359: iconst_1
    //   360: isub
    //   361: iadd
    //   362: putfield bp : I
    //   365: aload_0
    //   366: invokevirtual next : ()C
    //   369: pop
    //   370: goto -> 470
    //   373: iload #4
    //   375: bipush #93
    //   377: if_icmpne -> 406
    //   380: aload_0
    //   381: bipush #15
    //   383: putfield token : I
    //   386: aload_0
    //   387: aload_0
    //   388: getfield bp : I
    //   391: iload_3
    //   392: iconst_1
    //   393: isub
    //   394: iadd
    //   395: putfield bp : I
    //   398: aload_0
    //   399: invokevirtual next : ()C
    //   402: pop
    //   403: goto -> 470
    //   406: iload #4
    //   408: bipush #125
    //   410: if_icmpne -> 439
    //   413: aload_0
    //   414: bipush #13
    //   416: putfield token : I
    //   419: aload_0
    //   420: aload_0
    //   421: getfield bp : I
    //   424: iload_3
    //   425: iconst_1
    //   426: isub
    //   427: iadd
    //   428: putfield bp : I
    //   431: aload_0
    //   432: invokevirtual next : ()C
    //   435: pop
    //   436: goto -> 470
    //   439: iload #4
    //   441: bipush #26
    //   443: if_icmpne -> 477
    //   446: aload_0
    //   447: aload_0
    //   448: getfield bp : I
    //   451: iload_3
    //   452: iconst_1
    //   453: isub
    //   454: iadd
    //   455: putfield bp : I
    //   458: aload_0
    //   459: bipush #20
    //   461: putfield token : I
    //   464: aload_0
    //   465: bipush #26
    //   467: putfield ch : C
    //   470: aload_0
    //   471: iconst_4
    //   472: putfield matchStat : I
    //   475: aload_2
    //   476: areturn
    //   477: aload_0
    //   478: iconst_m1
    //   479: putfield matchStat : I
    //   482: aconst_null
    //   483: areturn
    //   484: aload_0
    //   485: iconst_m1
    //   486: putfield matchStat : I
    //   489: aconst_null
    //   490: areturn
    //   491: aload_0
    //   492: iconst_m1
    //   493: putfield matchStat : I
    //   496: aconst_null
    //   497: areturn
    //   498: iload #4
    //   500: bipush #92
    //   502: if_icmpne -> 512
    //   505: aload_0
    //   506: iconst_m1
    //   507: putfield matchStat : I
    //   510: aconst_null
    //   511: areturn
    //   512: iload #5
    //   514: istore #4
    //   516: goto -> 144
    //   519: astore_1
    //   520: new com/alibaba/fastjson/JSONException
    //   523: dup
    //   524: aload_1
    //   525: invokevirtual getMessage : ()Ljava/lang/String;
    //   528: aload_1
    //   529: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   532: athrow
    // Exception table:
    //   from	to	target	type
    //   63	71	519	java/lang/Exception
  }
  
  public String scanFieldSymbol(char[] paramArrayOfchar, SymbolTable paramSymbolTable) {
    int i = 0;
    this.matchStat = 0;
    if (!charArrayCompare(paramArrayOfchar)) {
      this.matchStat = -2;
      return null;
    } 
    int k = paramArrayOfchar.length;
    int m = this.bp;
    int j = k + 1;
    if (charAt(m + k) != '"') {
      this.matchStat = -1;
      return null;
    } 
    while (true) {
      m = this.bp;
      k = j + 1;
      j = charAt(m + j);
      if (j == 34) {
        j = this.bp;
        m = paramArrayOfchar.length + j + 1;
        String str = addSymbol(m, j + k - m - 1, i, paramSymbolTable);
        j = this.bp;
        i = k + 1;
        j = charAt(j + k);
        if (j == 44) {
          this.bp += i - 1;
          next();
          this.matchStat = 3;
          return str;
        } 
        if (j == 125) {
          k = this.bp;
          j = i + 1;
          i = charAt(k + i);
          if (i == 44) {
            this.token = 16;
            this.bp += j - 1;
            next();
          } else if (i == 93) {
            this.token = 15;
            this.bp += j - 1;
            next();
          } else if (i == 125) {
            this.token = 13;
            this.bp += j - 1;
            next();
          } else {
            if (i == 26) {
              this.token = 20;
              this.bp += j - 1;
              this.ch = '\032';
              this.matchStat = 4;
              return str;
            } 
            this.matchStat = -1;
            return null;
          } 
          this.matchStat = 4;
          return str;
        } 
        this.matchStat = -1;
        return null;
      } 
      i = i * 31 + j;
      if (j == 92) {
        this.matchStat = -1;
        return null;
      } 
      j = k;
    } 
  }
  
  public final float scanFloat(char paramChar) {
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    if (c >= '0' && c <= '9') {
      int k;
      int j = 1;
      while (true) {
        k = this.bp;
        i = j + 1;
        k = charAt(k + j);
        if (k >= 48 && k <= 57) {
          j = i;
          continue;
        } 
        break;
      } 
      if (k == 46) {
        k = this.bp;
        j = i + 1;
        i = charAt(k + i);
        if (i >= 48 && i <= 57) {
          while (true) {
            k = this.bp;
            i = j + 1;
            char c1 = charAt(k + j);
            k = c1;
            j = i;
            if (c1 >= '0') {
              k = c1;
              j = i;
              if (c1 <= '9') {
                j = i;
                continue;
              } 
            } 
            break;
          } 
        } else {
          this.matchStat = -1;
          return 0.0F;
        } 
      } else {
        j = i;
      } 
      int i = this.bp;
      float f = Float.parseFloat(subString(i, i + j - i - 1));
      if (k == paramChar) {
        this.bp += j - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return f;
      } 
      this.matchStat = -1;
      return f;
    } 
    this.matchStat = -1;
    return 0.0F;
  }
  
  public final void scanIdent() {
    this.np = this.bp - 1;
    this.hasSpecial = false;
    while (true) {
      this.sp++;
      next();
      if (Character.isLetterOrDigit(this.ch))
        continue; 
      String str = stringVal();
      if ("null".equals(str)) {
        this.token = 8;
        return;
      } 
      if ("new".equals(str)) {
        this.token = 9;
        return;
      } 
      if ("true".equals(str)) {
        this.token = 6;
        return;
      } 
      if ("false".equals(str)) {
        this.token = 7;
        return;
      } 
      if ("undefined".equals(str)) {
        this.token = 23;
        return;
      } 
      this.token = 18;
      return;
    } 
  }
  
  public int scanInt(char paramChar) {
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    if (c >= '0' && c <= '9') {
      int k;
      int i = digits[c];
      int j = 1;
      while (true) {
        int m = this.bp;
        k = j + 1;
        j = charAt(m + j);
        if (j >= 48 && j <= 57) {
          i = i * 10 + digits[j];
          j = k;
          continue;
        } 
        break;
      } 
      if (j == 46) {
        this.matchStat = -1;
        return 0;
      } 
      if (i < 0) {
        this.matchStat = -1;
        return 0;
      } 
      if (j == paramChar) {
        this.bp += k - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return i;
      } 
      this.matchStat = -1;
      return i;
    } 
    this.matchStat = -1;
    return 0;
  }
  
  public long scanLong(char paramChar) {
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    if (c >= '0' && c <= '9') {
      int i;
      int j;
      long l = digits[c];
      c = '\001';
      while (true) {
        int k = this.bp;
        j = c + 1;
        c = charAt(k + c);
        if (c >= '0' && c <= '9') {
          l = l * 10L + digits[c];
          i = j;
          continue;
        } 
        break;
      } 
      if (i == 46) {
        this.matchStat = -1;
        return 0L;
      } 
      if (l < 0L) {
        this.matchStat = -1;
        return 0L;
      } 
      if (i == paramChar) {
        this.bp += j - 1;
        next();
        this.matchStat = 3;
        this.token = 16;
        return l;
      } 
      this.matchStat = -1;
      return l;
    } 
    this.matchStat = -1;
    return 0L;
  }
  
  public final void scanNULL() {
    if (this.ch == 'N') {
      next();
      if (this.ch == 'U') {
        next();
        if (this.ch == 'L') {
          next();
          if (this.ch == 'L') {
            next();
            char c = this.ch;
            if (c == ' ' || c == ',' || c == '}' || c == ']' || c == '\n' || c == '\r' || c == '\t' || c == '\032' || c == '\f' || c == '\b') {
              this.token = 8;
              return;
            } 
            throw new JSONException("scan NULL error");
          } 
          throw new JSONException("error parse NULL");
        } 
        throw new JSONException("error parse NULL");
      } 
      throw new JSONException("error parse NULL");
    } 
    throw new JSONException("error parse NULL");
  }
  
  public final void scanNullOrNew() {
    if (this.ch == 'n') {
      next();
      char c = this.ch;
      if (c == 'u') {
        next();
        if (this.ch == 'l') {
          next();
          if (this.ch == 'l') {
            next();
            c = this.ch;
            if (c == ' ' || c == ',' || c == '}' || c == ']' || c == '\n' || c == '\r' || c == '\t' || c == '\032' || c == '\f' || c == '\b') {
              this.token = 8;
              return;
            } 
            throw new JSONException("scan null error");
          } 
          throw new JSONException("error parse null");
        } 
        throw new JSONException("error parse null");
      } 
      if (c == 'e') {
        next();
        if (this.ch == 'w') {
          next();
          c = this.ch;
          if (c == ' ' || c == ',' || c == '}' || c == ']' || c == '\n' || c == '\r' || c == '\t' || c == '\032' || c == '\f' || c == '\b') {
            this.token = 9;
            return;
          } 
          throw new JSONException("scan new error");
        } 
        throw new JSONException("error parse new");
      } 
      throw new JSONException("error parse new");
    } 
    throw new JSONException("error parse null or new");
  }
  
  public final void scanNumber() {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield bp : I
    //   5: putfield np : I
    //   8: aload_0
    //   9: getfield ch : C
    //   12: istore_1
    //   13: iconst_1
    //   14: istore_2
    //   15: iload_1
    //   16: bipush #45
    //   18: if_icmpne -> 36
    //   21: aload_0
    //   22: aload_0
    //   23: getfield sp : I
    //   26: iconst_1
    //   27: iadd
    //   28: putfield sp : I
    //   31: aload_0
    //   32: invokevirtual next : ()C
    //   35: pop
    //   36: aload_0
    //   37: getfield ch : C
    //   40: istore_1
    //   41: iload_1
    //   42: bipush #48
    //   44: if_icmplt -> 71
    //   47: iload_1
    //   48: bipush #57
    //   50: if_icmpgt -> 71
    //   53: aload_0
    //   54: aload_0
    //   55: getfield sp : I
    //   58: iconst_1
    //   59: iadd
    //   60: putfield sp : I
    //   63: aload_0
    //   64: invokevirtual next : ()C
    //   67: pop
    //   68: goto -> 36
    //   71: iconst_0
    //   72: istore_1
    //   73: aload_0
    //   74: getfield ch : C
    //   77: bipush #46
    //   79: if_icmpne -> 134
    //   82: aload_0
    //   83: aload_0
    //   84: getfield sp : I
    //   87: iconst_1
    //   88: iadd
    //   89: putfield sp : I
    //   92: aload_0
    //   93: invokevirtual next : ()C
    //   96: pop
    //   97: aload_0
    //   98: getfield ch : C
    //   101: istore_1
    //   102: iload_1
    //   103: bipush #48
    //   105: if_icmplt -> 132
    //   108: iload_1
    //   109: bipush #57
    //   111: if_icmpgt -> 132
    //   114: aload_0
    //   115: aload_0
    //   116: getfield sp : I
    //   119: iconst_1
    //   120: iadd
    //   121: putfield sp : I
    //   124: aload_0
    //   125: invokevirtual next : ()C
    //   128: pop
    //   129: goto -> 97
    //   132: iconst_1
    //   133: istore_1
    //   134: aload_0
    //   135: getfield ch : C
    //   138: istore_3
    //   139: iload_3
    //   140: bipush #76
    //   142: if_icmpne -> 163
    //   145: aload_0
    //   146: aload_0
    //   147: getfield sp : I
    //   150: iconst_1
    //   151: iadd
    //   152: putfield sp : I
    //   155: aload_0
    //   156: invokevirtual next : ()C
    //   159: pop
    //   160: goto -> 278
    //   163: iload_3
    //   164: bipush #83
    //   166: if_icmpne -> 187
    //   169: aload_0
    //   170: aload_0
    //   171: getfield sp : I
    //   174: iconst_1
    //   175: iadd
    //   176: putfield sp : I
    //   179: aload_0
    //   180: invokevirtual next : ()C
    //   183: pop
    //   184: goto -> 278
    //   187: iload_3
    //   188: bipush #66
    //   190: if_icmpne -> 211
    //   193: aload_0
    //   194: aload_0
    //   195: getfield sp : I
    //   198: iconst_1
    //   199: iadd
    //   200: putfield sp : I
    //   203: aload_0
    //   204: invokevirtual next : ()C
    //   207: pop
    //   208: goto -> 278
    //   211: iload_3
    //   212: bipush #70
    //   214: if_icmpne -> 237
    //   217: aload_0
    //   218: aload_0
    //   219: getfield sp : I
    //   222: iconst_1
    //   223: iadd
    //   224: putfield sp : I
    //   227: aload_0
    //   228: invokevirtual next : ()C
    //   231: pop
    //   232: iload_2
    //   233: istore_1
    //   234: goto -> 399
    //   237: iload_3
    //   238: bipush #68
    //   240: if_icmpne -> 263
    //   243: aload_0
    //   244: aload_0
    //   245: getfield sp : I
    //   248: iconst_1
    //   249: iadd
    //   250: putfield sp : I
    //   253: aload_0
    //   254: invokevirtual next : ()C
    //   257: pop
    //   258: iload_2
    //   259: istore_1
    //   260: goto -> 399
    //   263: iload_3
    //   264: bipush #101
    //   266: if_icmpeq -> 281
    //   269: iload_3
    //   270: bipush #69
    //   272: if_icmpne -> 278
    //   275: goto -> 281
    //   278: goto -> 399
    //   281: aload_0
    //   282: aload_0
    //   283: getfield sp : I
    //   286: iconst_1
    //   287: iadd
    //   288: putfield sp : I
    //   291: aload_0
    //   292: invokevirtual next : ()C
    //   295: pop
    //   296: aload_0
    //   297: getfield ch : C
    //   300: istore_1
    //   301: iload_1
    //   302: bipush #43
    //   304: if_icmpeq -> 313
    //   307: iload_1
    //   308: bipush #45
    //   310: if_icmpne -> 328
    //   313: aload_0
    //   314: aload_0
    //   315: getfield sp : I
    //   318: iconst_1
    //   319: iadd
    //   320: putfield sp : I
    //   323: aload_0
    //   324: invokevirtual next : ()C
    //   327: pop
    //   328: aload_0
    //   329: getfield ch : C
    //   332: istore_1
    //   333: iload_1
    //   334: bipush #48
    //   336: if_icmplt -> 363
    //   339: iload_1
    //   340: bipush #57
    //   342: if_icmpgt -> 363
    //   345: aload_0
    //   346: aload_0
    //   347: getfield sp : I
    //   350: iconst_1
    //   351: iadd
    //   352: putfield sp : I
    //   355: aload_0
    //   356: invokevirtual next : ()C
    //   359: pop
    //   360: goto -> 328
    //   363: aload_0
    //   364: getfield ch : C
    //   367: istore_3
    //   368: iload_3
    //   369: bipush #68
    //   371: if_icmpeq -> 382
    //   374: iload_2
    //   375: istore_1
    //   376: iload_3
    //   377: bipush #70
    //   379: if_icmpne -> 399
    //   382: aload_0
    //   383: aload_0
    //   384: getfield sp : I
    //   387: iconst_1
    //   388: iadd
    //   389: putfield sp : I
    //   392: aload_0
    //   393: invokevirtual next : ()C
    //   396: pop
    //   397: iload_2
    //   398: istore_1
    //   399: iload_1
    //   400: ifeq -> 409
    //   403: aload_0
    //   404: iconst_3
    //   405: putfield token : I
    //   408: return
    //   409: aload_0
    //   410: iconst_2
    //   411: putfield token : I
    //   414: return
  }
  
  public final void scanSet() {
    if (this.ch == 'S') {
      next();
      if (this.ch == 'e') {
        next();
        if (this.ch == 't') {
          next();
          char c = this.ch;
          if (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b' || c == '[' || c == '(') {
            this.token = 21;
            return;
          } 
          throw new JSONException("scan set error");
        } 
        throw new JSONException("error parse set");
      } 
      throw new JSONException("error parse set");
    } 
    throw new JSONException("error parse set");
  }
  
  public String scanString(char paramChar) {
    byte b = 0;
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    if (c == 'n') {
      if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
        if (charAt(this.bp + 4) == paramChar) {
          this.bp += 4;
          next();
          this.matchStat = 3;
          return null;
        } 
        this.matchStat = -1;
        return null;
      } 
      this.matchStat = -1;
      return null;
    } 
    if (c != '"') {
      this.matchStat = -1;
      return stringDefaultValue();
    } 
    int i = this.bp + 1;
    int j = indexOf('"', i);
    if (j != -1) {
      String str = subString(this.bp + 1, j - i);
      i = this.bp + 1;
      while (true) {
        k = b;
        if (i < j) {
          if (charAt(i) == '\\') {
            k = 1;
            break;
          } 
          i++;
          continue;
        } 
        break;
      } 
      if (k) {
        this.matchStat = -1;
        return stringDefaultValue();
      } 
      i = this.bp;
      int k = j - i + 1 + 1 + 1;
      if (charAt(i + k) == paramChar) {
        this.bp += k + 1 - 1;
        next();
        this.matchStat = 3;
        return str;
      } 
      this.matchStat = -1;
      return str;
    } 
    throw new JSONException("unclosed str");
  }
  
  public final void scanString() {
    this.np = this.bp;
    this.hasSpecial = false;
    while (true) {
      char c = next();
      if (c == '"') {
        this.token = 4;
        this.ch = next();
        return;
      } 
      if (c == '\032') {
        if (!isEOF()) {
          putChar('\032');
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unclosed string : ");
        stringBuilder.append(c);
        throw new JSONException(stringBuilder.toString());
      } 
      if (c == '\\') {
        if (!this.hasSpecial) {
          this.hasSpecial = true;
          int j = this.sp;
          char[] arrayOfChar1 = this.sbuf;
          if (j >= arrayOfChar1.length) {
            int k = arrayOfChar1.length * 2;
            if (j <= k)
              j = k; 
            arrayOfChar1 = new char[j];
            char[] arrayOfChar2 = this.sbuf;
            System.arraycopy(arrayOfChar2, 0, arrayOfChar1, 0, arrayOfChar2.length);
            this.sbuf = arrayOfChar1;
          } 
          copyTo(this.np + 1, this.sp, this.sbuf);
        } 
        c = next();
        if (c != '"') {
          if (c != '\'') {
            if (c != 'F')
              if (c != '\\') {
                if (c != 'b') {
                  if (c != 'f') {
                    if (c != 'n') {
                      if (c != 'r') {
                        if (c != 'x') {
                          StringBuilder stringBuilder;
                          switch (c) {
                            default:
                              switch (c) {
                                default:
                                  this.ch = c;
                                  stringBuilder = new StringBuilder();
                                  stringBuilder.append("unclosed string : ");
                                  stringBuilder.append(c);
                                  throw new JSONException(stringBuilder.toString());
                                case 'v':
                                  putChar('\013');
                                  continue;
                                case 'u':
                                  putChar((char)Integer.parseInt(new String(new char[] { next(), next(), next(), next() }, ), 16));
                                  continue;
                                case 't':
                                  break;
                              } 
                              putChar('\t');
                              continue;
                            case '7':
                              putChar('\007');
                              continue;
                            case '6':
                              putChar('\006');
                              continue;
                            case '5':
                              putChar('\005');
                              continue;
                            case '4':
                              putChar('\004');
                              continue;
                            case '3':
                              putChar('\003');
                              continue;
                            case '2':
                              putChar('\002');
                              continue;
                            case '1':
                              putChar('\001');
                              continue;
                            case '0':
                              putChar(false);
                              continue;
                            case '/':
                              break;
                          } 
                          putChar('/');
                          continue;
                        } 
                        char c1 = next();
                        char c2 = next();
                        int[] arrayOfInt = digits;
                        putChar((char)(arrayOfInt[c1] * 16 + arrayOfInt[c2]));
                        continue;
                      } 
                      putChar('\r');
                      continue;
                    } 
                    putChar('\n');
                    continue;
                  } 
                } else {
                  putChar('\b');
                  continue;
                } 
              } else {
                putChar('\\');
                continue;
              }  
            putChar('\f');
            continue;
          } 
          putChar('\'');
          continue;
        } 
        putChar('"');
        continue;
      } 
      if (!this.hasSpecial) {
        this.sp++;
        continue;
      } 
      int i = this.sp;
      char[] arrayOfChar = this.sbuf;
      if (i == arrayOfChar.length) {
        putChar(c);
        continue;
      } 
      this.sp = i + 1;
      arrayOfChar[i] = c;
    } 
  }
  
  public Collection<String> scanStringArray(Class<?> paramClass, char paramChar) {
    Collection<String> collection = TypeUtils.createCollection(paramClass);
    this.matchStat = 0;
    char c1 = charAt(this.bp + 0);
    if (c1 == 'n') {
      if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
        if (charAt(this.bp + 4) == paramChar) {
          this.bp += 4;
          next();
          this.matchStat = 3;
          return null;
        } 
        this.matchStat = -1;
        return null;
      } 
      this.matchStat = -1;
      return null;
    } 
    if (c1 != '[') {
      this.matchStat = -1;
      return null;
    } 
    char c2 = charAt(this.bp + 1);
    c1 = '\002';
    label39: while (true) {
      int i;
      if (c2 == 'n' && charAt(this.bp + c1) == 'u' && charAt(this.bp + c1 + 1) == 'l' && charAt(this.bp + c1 + 2) == 'l') {
        j = c1 + 3;
        int k = this.bp;
        i = j + 1;
        j = charAt(k + j);
        continue;
      } 
      if (j != 34) {
        this.matchStat = -1;
        return null;
      } 
      int j;
      for (j = i;; j = k) {
        int m = this.bp;
        int k = j + 1;
        j = charAt(m + j);
        if (j == 34) {
          j = this.bp;
          i += j;
          collection.add(subString(i, j + k - i - 1));
          j = this.bp;
          i = k + 1;
          j = charAt(j + k);
          if (j == 44) {
            j = this.bp;
            k = i + 1;
            j = charAt(j + i);
            i = k;
            continue label39;
          } 
          if (j == 93) {
            if (charAt(this.bp + i) == paramChar) {
              this.bp += i + 1 - 1;
              next();
              this.matchStat = 3;
              return collection;
            } 
            this.matchStat = -1;
            return collection;
          } 
          this.matchStat = -1;
          return null;
        } 
        if (j == 92) {
          this.matchStat = -1;
          return null;
        } 
      } 
      break;
    } 
  }
  
  public final String scanSymbol(SymbolTable paramSymbolTable) {
    skipWhitespace();
    char c = this.ch;
    if (c == '"')
      return scanSymbol(paramSymbolTable, '"'); 
    if (c == '\'') {
      if (isEnabled(Feature.AllowSingleQuotes))
        return scanSymbol(paramSymbolTable, '\''); 
      throw new JSONException("syntax error");
    } 
    if (c == '}') {
      next();
      this.token = 13;
      return null;
    } 
    if (c == ',') {
      next();
      this.token = 16;
      return null;
    } 
    if (c == '\032') {
      this.token = 20;
      return null;
    } 
    if (isEnabled(Feature.AllowUnQuotedFieldNames))
      return scanSymbolUnQuoted(paramSymbolTable); 
    throw new JSONException("syntax error");
  }
  
  public final String scanSymbol(SymbolTable paramSymbolTable, char paramChar) {
    this.np = this.bp;
    this.sp = 0;
    int j = 0;
    int i = 0;
    while (true) {
      char c = next();
      if (c == paramChar) {
        String str;
        this.token = 4;
        if (!j) {
          int k = this.np;
          if (k == -1) {
            k = 0;
          } else {
            k++;
          } 
          str = addSymbol(k, this.sp, i, paramSymbolTable);
        } else {
          str = str.addSymbol(this.sbuf, 0, this.sp, i);
        } 
        this.sp = 0;
        next();
        return str;
      } 
      if (c != '\032') {
        if (c == '\\') {
          int m = j;
          if (!j) {
            j = this.sp;
            char[] arrayOfChar1 = this.sbuf;
            if (j >= arrayOfChar1.length) {
              m = arrayOfChar1.length * 2;
              if (j <= m)
                j = m; 
              arrayOfChar1 = new char[j];
              char[] arrayOfChar2 = this.sbuf;
              System.arraycopy(arrayOfChar2, 0, arrayOfChar1, 0, arrayOfChar2.length);
              this.sbuf = arrayOfChar1;
            } 
            arrayCopy(this.np + 1, this.sbuf, 0, this.sp);
            m = 1;
          } 
          c = next();
          if (c != '"') {
            if (c != '\'') {
              if (c != 'F')
                if (c != '\\') {
                  if (c != 'b') {
                    if (c != 'f') {
                      if (c != 'n') {
                        if (c != 'r') {
                          if (c != 'x') {
                            switch (c) {
                              default:
                                switch (c) {
                                  default:
                                    this.ch = c;
                                    throw new JSONException("unclosed.str.lit");
                                  case 'v':
                                    i = i * 31 + 11;
                                    putChar('\013');
                                    j = m;
                                    continue;
                                  case 'u':
                                    j = Integer.parseInt(new String(new char[] { next(), next(), next(), next() }, ), 16);
                                    i = i * 31 + j;
                                    putChar((char)j);
                                    j = m;
                                    continue;
                                  case 't':
                                    break;
                                } 
                                i = i * 31 + 9;
                                putChar('\t');
                                j = m;
                                continue;
                              case '7':
                                i = i * 31 + c;
                                putChar('\007');
                                j = m;
                                continue;
                              case '6':
                                i = i * 31 + c;
                                putChar('\006');
                                j = m;
                                continue;
                              case '5':
                                i = i * 31 + c;
                                putChar('\005');
                                j = m;
                                continue;
                              case '4':
                                i = i * 31 + c;
                                putChar('\004');
                                j = m;
                                continue;
                              case '3':
                                i = i * 31 + c;
                                putChar('\003');
                                j = m;
                                continue;
                              case '2':
                                i = i * 31 + c;
                                putChar('\002');
                                j = m;
                                continue;
                              case '1':
                                i = i * 31 + c;
                                putChar('\001');
                                j = m;
                                continue;
                              case '0':
                                i = i * 31 + c;
                                putChar(false);
                                j = m;
                                continue;
                              case '/':
                                break;
                            } 
                            i = i * 31 + 47;
                            putChar('/');
                            j = m;
                            continue;
                          } 
                          c = next();
                          this.ch = c;
                          char c1 = next();
                          this.ch = c1;
                          int[] arrayOfInt = digits;
                          c = (char)(arrayOfInt[c] * 16 + arrayOfInt[c1]);
                          i = i * 31 + c;
                          putChar(c);
                          j = m;
                          continue;
                        } 
                        i = i * 31 + 13;
                        putChar('\r');
                        j = m;
                        continue;
                      } 
                      i = i * 31 + 10;
                      putChar('\n');
                      j = m;
                      continue;
                    } 
                  } else {
                    i = i * 31 + 8;
                    putChar('\b');
                    j = m;
                    continue;
                  } 
                } else {
                  i = i * 31 + 92;
                  putChar('\\');
                  j = m;
                  continue;
                }  
              i = i * 31 + 12;
              putChar('\f');
              j = m;
              continue;
            } 
            i = i * 31 + 39;
            putChar('\'');
            j = m;
            continue;
          } 
          i = i * 31 + 34;
          putChar('"');
          j = m;
          continue;
        } 
        i = i * 31 + c;
        if (j == 0) {
          this.sp++;
          continue;
        } 
        int k = this.sp;
        char[] arrayOfChar = this.sbuf;
        if (k == arrayOfChar.length) {
          putChar(c);
          continue;
        } 
        this.sp = k + 1;
        arrayOfChar[k] = c;
        continue;
      } 
      throw new JSONException("unclosed.str");
    } 
  }
  
  public final String scanSymbolUnQuoted(SymbolTable paramSymbolTable) {
    int i;
    boolean[] arrayOfBoolean = IOUtils.firstIdentifierFlags;
    char c = this.ch;
    if (c >= arrayOfBoolean.length || arrayOfBoolean[c]) {
      i = 1;
    } else {
      i = 0;
    } 
    if (i) {
      arrayOfBoolean = IOUtils.identifierFlags;
      this.np = this.bp;
      this.sp = 1;
      i = c;
      while (true) {
        c = next();
        if (c < arrayOfBoolean.length && !arrayOfBoolean[c]) {
          this.ch = charAt(this.bp);
          this.token = 18;
          return (this.sp == 4 && i == 3392903 && charAt(this.np) == 'n' && charAt(this.np + 1) == 'u' && charAt(this.np + 2) == 'l' && charAt(this.np + 3) == 'l') ? null : addSymbol(this.np, this.sp, i, paramSymbolTable);
        } 
        i = i * 31 + c;
        this.sp++;
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("illegal identifier : ");
    stringBuilder.append(this.ch);
    stringBuilder.append(info());
    throw new JSONException(stringBuilder.toString());
  }
  
  public String scanSymbolWithSeperator(SymbolTable paramSymbolTable, char paramChar) {
    this.matchStat = 0;
    char c = charAt(this.bp + 0);
    if (c == 'n') {
      if (charAt(this.bp + 1) == 'u' && charAt(this.bp + 1 + 1) == 'l' && charAt(this.bp + 1 + 2) == 'l') {
        if (charAt(this.bp + 4) == paramChar) {
          this.bp += 4;
          next();
          this.matchStat = 3;
          return null;
        } 
        this.matchStat = -1;
        return null;
      } 
      this.matchStat = -1;
      return null;
    } 
    if (c != '"') {
      this.matchStat = -1;
      return null;
    } 
    int i = 1;
    c = Character.MIN_VALUE;
    while (true) {
      int m = this.bp;
      int k = i + 1;
      i = charAt(m + i);
      if (i == 34) {
        i = this.bp;
        m = i + 0 + 1;
        String str = addSymbol(m, i + k - m - 1, c, paramSymbolTable);
        if (charAt(this.bp + k) == paramChar) {
          this.bp += k + 1 - 1;
          next();
          this.matchStat = 3;
          return str;
        } 
        this.matchStat = -1;
        return str;
      } 
      int j = c * 31 + i;
      if (i == 92) {
        this.matchStat = -1;
        return null;
      } 
      i = k;
    } 
  }
  
  public final void scanTreeSet() {
    if (this.ch == 'T') {
      next();
      if (this.ch == 'r') {
        next();
        if (this.ch == 'e') {
          next();
          if (this.ch == 'e') {
            next();
            if (this.ch == 'S') {
              next();
              if (this.ch == 'e') {
                next();
                if (this.ch == 't') {
                  next();
                  char c = this.ch;
                  if (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b' || c == '[' || c == '(') {
                    this.token = 22;
                    return;
                  } 
                  throw new JSONException("scan treeSet error");
                } 
                throw new JSONException("error parse treeSet");
              } 
              throw new JSONException("error parse treeSet");
            } 
            throw new JSONException("error parse treeSet");
          } 
          throw new JSONException("error parse treeSet");
        } 
        throw new JSONException("error parse treeSet");
      } 
      throw new JSONException("error parse treeSet");
    } 
    throw new JSONException("error parse treeSet");
  }
  
  public final void scanTrue() {
    if (this.ch == 't') {
      next();
      if (this.ch == 'r') {
        next();
        if (this.ch == 'u') {
          next();
          if (this.ch == 'e') {
            next();
            char c = this.ch;
            if (c == ' ' || c == ',' || c == '}' || c == ']' || c == '\n' || c == '\r' || c == '\t' || c == '\032' || c == '\f' || c == '\b' || c == ':') {
              this.token = 6;
              return;
            } 
            throw new JSONException("scan true error");
          } 
          throw new JSONException("error parse true");
        } 
        throw new JSONException("error parse true");
      } 
      throw new JSONException("error parse true");
    } 
    throw new JSONException("error parse true");
  }
  
  public final int scanType(String paramString) {
    int i = 0;
    this.matchStat = 0;
    if (!charArrayCompare(typeFieldName))
      return -2; 
    int j = this.bp + typeFieldName.length;
    int k = paramString.length();
    while (i < k) {
      if (paramString.charAt(i) != charAt(j + i))
        return -1; 
      i++;
    } 
    i = j + k;
    if (charAt(i) != '"')
      return -1; 
    j = i + 1;
    this.ch = charAt(j);
    k = this.ch;
    if (k == 44) {
      i = j + 1;
      this.ch = charAt(i);
      this.bp = i;
      this.token = 16;
      return 3;
    } 
    i = j;
    if (k == 125) {
      i = j + 1;
      this.ch = charAt(i);
      j = this.ch;
      if (j == 44) {
        this.token = 16;
        this.ch = charAt(++i);
      } else if (j == 93) {
        this.token = 15;
        this.ch = charAt(++i);
      } else if (j == 125) {
        this.token = 13;
        this.ch = charAt(++i);
      } else if (j == 26) {
        this.token = 20;
      } else {
        return -1;
      } 
      this.matchStat = 4;
    } 
    this.bp = i;
    return this.matchStat;
  }
  
  public final void scanUndefined() {
    if (this.ch == 'u') {
      next();
      if (this.ch == 'n') {
        next();
        if (this.ch == 'd') {
          next();
          if (this.ch == 'e') {
            next();
            if (this.ch == 'f') {
              next();
              if (this.ch == 'i') {
                next();
                if (this.ch == 'n') {
                  next();
                  if (this.ch == 'e') {
                    next();
                    if (this.ch == 'd') {
                      next();
                      char c = this.ch;
                      if (c == ' ' || c == ',' || c == '}' || c == ']' || c == '\n' || c == '\r' || c == '\t' || c == '\032' || c == '\f' || c == '\b') {
                        this.token = 23;
                        return;
                      } 
                      throw new JSONException("scan undefined error");
                    } 
                    throw new JSONException("error parse undefined");
                  } 
                  throw new JSONException("error parse undefined");
                } 
                throw new JSONException("error parse undefined");
              } 
              throw new JSONException("error parse undefined");
            } 
            throw new JSONException("error parse undefined");
          } 
          throw new JSONException("error parse undefined");
        } 
        throw new JSONException("error parse undefined");
      } 
      throw new JSONException("error parse undefined");
    } 
    throw new JSONException("error parse undefined");
  }
  
  public void setLocale(Locale paramLocale) {
    this.locale = paramLocale;
  }
  
  public void setTimeZone(TimeZone paramTimeZone) {
    this.timeZone = paramTimeZone;
  }
  
  protected void skipComment() {
    next();
    char c = this.ch;
    if (c == '/')
      while (true) {
        next();
        if (this.ch == '\n') {
          next();
          return;
        } 
      }  
    if (c == '*')
      while (true) {
        next();
        if (this.ch == '*') {
          next();
          if (this.ch == '/') {
            next();
            return;
          } 
        } 
      }  
    throw new JSONException("invalid comment");
  }
  
  public final void skipWhitespace() {
    while (true) {
      char c = this.ch;
      if (c <= '/') {
        if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
          next();
          continue;
        } 
        if (c == '/') {
          skipComment();
          continue;
        } 
      } 
      break;
    } 
  }
  
  public final String stringDefaultValue() {
    return this.stringDefaultValue;
  }
  
  public abstract String stringVal();
  
  public abstract String subString(int paramInt1, int paramInt2);
  
  public final int token() {
    return this.token;
  }
  
  public final String tokenName() {
    return JSONToken.name(this.token);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\JSONLexerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */