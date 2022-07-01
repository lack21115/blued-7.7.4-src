package com.squareup.okhttp;

import java.net.IDN;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import okio.Buffer;

public final class HttpUrl {
  static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
  
  static final String FRAGMENT_ENCODE_SET = "";
  
  static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
  
  private static final char[] HEX_DIGITS = new char[] { 
      '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
      'A', 'B', 'C', 'D', 'E', 'F' };
  
  static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  
  static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
  
  static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
  
  static final String QUERY_COMPONENT_ENCODE_SET = " \"'<>#&=";
  
  static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
  
  static final String QUERY_ENCODE_SET = " \"'<>#";
  
  static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
  
  private final String fragment;
  
  private final String host;
  
  private final String password;
  
  private final List<String> pathSegments;
  
  private final int port;
  
  private final List<String> queryNamesAndValues;
  
  private final String scheme;
  
  private final String url;
  
  private final String username;
  
  private HttpUrl(Builder paramBuilder) {
    String str;
    this.scheme = paramBuilder.scheme;
    this.username = percentDecode(paramBuilder.encodedUsername, false);
    this.password = percentDecode(paramBuilder.encodedPassword, false);
    this.host = paramBuilder.host;
    this.port = paramBuilder.effectivePort();
    this.pathSegments = percentDecode(paramBuilder.encodedPathSegments, false);
    List<String> list = paramBuilder.encodedQueryNamesAndValues;
    List list1 = null;
    if (list != null) {
      list = percentDecode(paramBuilder.encodedQueryNamesAndValues, true);
    } else {
      list = null;
    } 
    this.queryNamesAndValues = list;
    list = list1;
    if (paramBuilder.encodedFragment != null)
      str = percentDecode(paramBuilder.encodedFragment, false); 
    this.fragment = str;
    this.url = paramBuilder.toString();
  }
  
  static String canonicalize(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    for (int i = paramInt1; i < paramInt2; i += Character.charCount(j)) {
      int j = paramString1.codePointAt(i);
      if (j < 32 || j == 127 || (j >= 128 && paramBoolean3) || paramString2.indexOf(j) != -1 || (j == 37 && !paramBoolean1) || (j == 43 && paramBoolean2)) {
        Buffer buffer = new Buffer();
        buffer.writeUtf8(paramString1, paramInt1, i);
        canonicalize(buffer, paramString1, i, paramInt2, paramString2, paramBoolean1, paramBoolean2, paramBoolean3);
        return buffer.readUtf8();
      } 
    } 
    return paramString1.substring(paramInt1, paramInt2);
  }
  
  static String canonicalize(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    return canonicalize(paramString1, 0, paramString1.length(), paramString2, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  static void canonicalize(Buffer paramBuffer, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    for (Object object = null; paramInt1 < paramInt2; object = SYNTHETIC_LOCAL_VARIABLE_12) {
      int i = paramString1.codePointAt(paramInt1);
      if (paramBoolean1) {
        Object object1 = object;
        if (i != 9) {
          object1 = object;
          if (i != 10) {
            object1 = object;
            if (i != 12) {
              if (i == 13) {
                object1 = object;
                continue;
              } 
            } else {
              continue;
            } 
          } else {
            continue;
          } 
        } else {
          continue;
        } 
      } 
      if (i == 43 && paramBoolean2) {
        String str;
        if (paramBoolean1) {
          str = "+";
        } else {
          str = "%2B";
        } 
        paramBuffer.writeUtf8(str);
        Object object1 = object;
      } else if (i < 32 || i == 127 || (i >= 128 && paramBoolean3) || paramString2.indexOf(i) != -1 || (i == 37 && !paramBoolean1)) {
        Object object1 = object;
        if (object == null)
          object1 = new Buffer(); 
        object1.writeUtf8CodePoint(i);
        while (true) {
          Object object2 = object1;
          if (!object1.exhausted()) {
            int j = object1.readByte() & 0xFF;
            paramBuffer.writeByte(37);
            paramBuffer.writeByte(HEX_DIGITS[j >> 4 & 0xF]);
            paramBuffer.writeByte(HEX_DIGITS[j & 0xF]);
            continue;
          } 
          break;
        } 
      } else {
        paramBuffer.writeUtf8CodePoint(i);
        Object object1 = object;
      } 
      continue;
      paramInt1 += Character.charCount(SYNTHETIC_LOCAL_VARIABLE_8);
    } 
  }
  
  static int decodeHexDigit(char paramChar) {
    if (paramChar >= '0' && paramChar <= '9')
      return paramChar - 48; 
    byte b = 97;
    if (paramChar < 'a' || paramChar > 'f') {
      b = 65;
      if (paramChar < 'A' || paramChar > 'F')
        return -1; 
    } 
    return paramChar - b + 10;
  }
  
  public static int defaultPort(String paramString) {
    return paramString.equals("http") ? 80 : (paramString.equals("https") ? 443 : -1);
  }
  
  private static int delimiterOffset(String paramString1, int paramInt1, int paramInt2, String paramString2) {
    while (paramInt1 < paramInt2) {
      if (paramString2.indexOf(paramString1.charAt(paramInt1)) != -1)
        return paramInt1; 
      paramInt1++;
    } 
    return paramInt2;
  }
  
  public static HttpUrl get(URI paramURI) {
    return parse(paramURI.toString());
  }
  
  public static HttpUrl get(URL paramURL) {
    return parse(paramURL.toString());
  }
  
  static HttpUrl getChecked(String paramString) throws MalformedURLException, UnknownHostException {
    StringBuilder stringBuilder;
    Builder builder = new Builder();
    Builder.ParseResult parseResult = builder.parse(null, paramString);
    int i = null.$SwitchMap$com$squareup$okhttp$HttpUrl$Builder$ParseResult[parseResult.ordinal()];
    if (i != 1) {
      if (i != 2) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid URL: ");
        stringBuilder.append(parseResult);
        stringBuilder.append(" for ");
        stringBuilder.append(paramString);
        throw new MalformedURLException(stringBuilder.toString());
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Invalid host: ");
      stringBuilder1.append(paramString);
      throw new UnknownHostException(stringBuilder1.toString());
    } 
    return stringBuilder.build();
  }
  
  static void namesAndValuesToQueryString(StringBuilder paramStringBuilder, List<String> paramList) {
    int j = paramList.size();
    for (int i = 0; i < j; i += 2) {
      String str1 = paramList.get(i);
      String str2 = paramList.get(i + 1);
      if (i > 0)
        paramStringBuilder.append('&'); 
      paramStringBuilder.append(str1);
      if (str2 != null) {
        paramStringBuilder.append('=');
        paramStringBuilder.append(str2);
      } 
    } 
  }
  
  public static HttpUrl parse(String paramString) {
    Builder builder = new Builder();
    HttpUrl httpUrl = null;
    if (builder.parse(null, paramString) == Builder.ParseResult.SUCCESS)
      httpUrl = builder.build(); 
    return httpUrl;
  }
  
  static void pathSegmentsToString(StringBuilder paramStringBuilder, List<String> paramList) {
    int j = paramList.size();
    for (int i = 0; i < j; i++) {
      paramStringBuilder.append('/');
      paramStringBuilder.append(paramList.get(i));
    } 
  }
  
  static String percentDecode(String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
    for (int i = paramInt1; i < paramInt2; i++) {
      char c = paramString.charAt(i);
      if (c == '%' || (c == '+' && paramBoolean)) {
        Buffer buffer = new Buffer();
        buffer.writeUtf8(paramString, paramInt1, i);
        percentDecode(buffer, paramString, i, paramInt2, paramBoolean);
        return buffer.readUtf8();
      } 
    } 
    return paramString.substring(paramInt1, paramInt2);
  }
  
  static String percentDecode(String paramString, boolean paramBoolean) {
    return percentDecode(paramString, 0, paramString.length(), paramBoolean);
  }
  
  private List<String> percentDecode(List<String> paramList, boolean paramBoolean) {
    ArrayList<String> arrayList = new ArrayList(paramList.size());
    for (String str : paramList) {
      if (str != null) {
        str = percentDecode(str, paramBoolean);
      } else {
        str = null;
      } 
      arrayList.add(str);
    } 
    return Collections.unmodifiableList(arrayList);
  }
  
  static void percentDecode(Buffer paramBuffer, String paramString, int paramInt1, int paramInt2, boolean paramBoolean) {
    // Byte code:
    //   0: iload_2
    //   1: iload_3
    //   2: if_icmpge -> 123
    //   5: aload_1
    //   6: iload_2
    //   7: invokevirtual codePointAt : (I)I
    //   10: istore #6
    //   12: iload #6
    //   14: bipush #37
    //   16: if_icmpne -> 83
    //   19: iload_2
    //   20: iconst_2
    //   21: iadd
    //   22: istore #5
    //   24: iload #5
    //   26: iload_3
    //   27: if_icmpge -> 83
    //   30: aload_1
    //   31: iload_2
    //   32: iconst_1
    //   33: iadd
    //   34: invokevirtual charAt : (I)C
    //   37: invokestatic decodeHexDigit : (C)I
    //   40: istore #7
    //   42: aload_1
    //   43: iload #5
    //   45: invokevirtual charAt : (I)C
    //   48: invokestatic decodeHexDigit : (C)I
    //   51: istore #8
    //   53: iload #7
    //   55: iconst_m1
    //   56: if_icmpeq -> 105
    //   59: iload #8
    //   61: iconst_m1
    //   62: if_icmpeq -> 105
    //   65: aload_0
    //   66: iload #7
    //   68: iconst_4
    //   69: ishl
    //   70: iload #8
    //   72: iadd
    //   73: invokevirtual writeByte : (I)Lokio/Buffer;
    //   76: pop
    //   77: iload #5
    //   79: istore_2
    //   80: goto -> 112
    //   83: iload #6
    //   85: bipush #43
    //   87: if_icmpne -> 105
    //   90: iload #4
    //   92: ifeq -> 105
    //   95: aload_0
    //   96: bipush #32
    //   98: invokevirtual writeByte : (I)Lokio/Buffer;
    //   101: pop
    //   102: goto -> 112
    //   105: aload_0
    //   106: iload #6
    //   108: invokevirtual writeUtf8CodePoint : (I)Lokio/Buffer;
    //   111: pop
    //   112: iload_2
    //   113: iload #6
    //   115: invokestatic charCount : (I)I
    //   118: iadd
    //   119: istore_2
    //   120: goto -> 0
    //   123: return
  }
  
  static List<String> queryStringToNamesAndValues(String paramString) {
    ArrayList<String> arrayList = new ArrayList();
    for (int i = 0; i <= paramString.length(); i = j + 1) {
      int k = paramString.indexOf('&', i);
      int j = k;
      if (k == -1)
        j = paramString.length(); 
      k = paramString.indexOf('=', i);
      if (k == -1 || k > j) {
        arrayList.add(paramString.substring(i, j));
        arrayList.add(null);
      } else {
        arrayList.add(paramString.substring(i, k));
        arrayList.add(paramString.substring(k + 1, j));
      } 
    } 
    return arrayList;
  }
  
  public String encodedFragment() {
    if (this.fragment == null)
      return null; 
    int i = this.url.indexOf('#');
    return this.url.substring(i + 1);
  }
  
  public String encodedPassword() {
    if (this.password.isEmpty())
      return ""; 
    int i = this.url.indexOf(':', this.scheme.length() + 3);
    int j = this.url.indexOf('@');
    return this.url.substring(i + 1, j);
  }
  
  public String encodedPath() {
    int i = this.url.indexOf('/', this.scheme.length() + 3);
    String str = this.url;
    int j = delimiterOffset(str, i, str.length(), "?#");
    return this.url.substring(i, j);
  }
  
  public List<String> encodedPathSegments() {
    int i = this.url.indexOf('/', this.scheme.length() + 3);
    String str = this.url;
    int j = delimiterOffset(str, i, str.length(), "?#");
    ArrayList<String> arrayList = new ArrayList();
    while (i < j) {
      int k = i + 1;
      i = delimiterOffset(this.url, k, j, "/");
      arrayList.add(this.url.substring(k, i));
    } 
    return arrayList;
  }
  
  public String encodedQuery() {
    if (this.queryNamesAndValues == null)
      return null; 
    int i = this.url.indexOf('?') + 1;
    String str = this.url;
    int j = delimiterOffset(str, i + 1, str.length(), "#");
    return this.url.substring(i, j);
  }
  
  public String encodedUsername() {
    if (this.username.isEmpty())
      return ""; 
    int i = this.scheme.length() + 3;
    String str = this.url;
    int j = delimiterOffset(str, i, str.length(), ":@");
    return this.url.substring(i, j);
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof HttpUrl && ((HttpUrl)paramObject).url.equals(this.url));
  }
  
  public String fragment() {
    return this.fragment;
  }
  
  public int hashCode() {
    return this.url.hashCode();
  }
  
  public String host() {
    return this.host;
  }
  
  public boolean isHttps() {
    return this.scheme.equals("https");
  }
  
  public Builder newBuilder() {
    byte b;
    Builder builder = new Builder();
    builder.scheme = this.scheme;
    builder.encodedUsername = encodedUsername();
    builder.encodedPassword = encodedPassword();
    builder.host = this.host;
    if (this.port != defaultPort(this.scheme)) {
      b = this.port;
    } else {
      b = -1;
    } 
    builder.port = b;
    builder.encodedPathSegments.clear();
    builder.encodedPathSegments.addAll(encodedPathSegments());
    builder.encodedQuery(encodedQuery());
    builder.encodedFragment = encodedFragment();
    return builder;
  }
  
  public String password() {
    return this.password;
  }
  
  public List<String> pathSegments() {
    return this.pathSegments;
  }
  
  public int pathSize() {
    return this.pathSegments.size();
  }
  
  public int port() {
    return this.port;
  }
  
  public String query() {
    if (this.queryNamesAndValues == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder();
    namesAndValuesToQueryString(stringBuilder, this.queryNamesAndValues);
    return stringBuilder.toString();
  }
  
  public String queryParameter(String paramString) {
    List<String> list = this.queryNamesAndValues;
    if (list == null)
      return null; 
    int i = 0;
    int j = list.size();
    while (i < j) {
      if (paramString.equals(this.queryNamesAndValues.get(i)))
        return this.queryNamesAndValues.get(i + 1); 
      i += 2;
    } 
    return null;
  }
  
  public String queryParameterName(int paramInt) {
    return this.queryNamesAndValues.get(paramInt * 2);
  }
  
  public Set<String> queryParameterNames() {
    if (this.queryNamesAndValues == null)
      return Collections.emptySet(); 
    LinkedHashSet<? extends String> linkedHashSet = new LinkedHashSet();
    int i = 0;
    int j = this.queryNamesAndValues.size();
    while (i < j) {
      linkedHashSet.add(this.queryNamesAndValues.get(i));
      i += 2;
    } 
    return Collections.unmodifiableSet(linkedHashSet);
  }
  
  public String queryParameterValue(int paramInt) {
    return this.queryNamesAndValues.get(paramInt * 2 + 1);
  }
  
  public List<String> queryParameterValues(String paramString) {
    if (this.queryNamesAndValues == null)
      return Collections.emptyList(); 
    ArrayList<? extends String> arrayList = new ArrayList();
    int i = 0;
    int j = this.queryNamesAndValues.size();
    while (i < j) {
      if (paramString.equals(this.queryNamesAndValues.get(i)))
        arrayList.add(this.queryNamesAndValues.get(i + 1)); 
      i += 2;
    } 
    return Collections.unmodifiableList(arrayList);
  }
  
  public int querySize() {
    List<String> list = this.queryNamesAndValues;
    return (list != null) ? (list.size() / 2) : 0;
  }
  
  public HttpUrl resolve(String paramString) {
    Builder builder = new Builder();
    return (builder.parse(this, paramString) == Builder.ParseResult.SUCCESS) ? builder.build() : null;
  }
  
  public String scheme() {
    return this.scheme;
  }
  
  public String toString() {
    return this.url;
  }
  
  public URI uri() {
    try {
      return new URI(newBuilder().reencodeForUri().toString());
    } catch (URISyntaxException uRISyntaxException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("not valid as a java.net.URI: ");
      stringBuilder.append(this.url);
      throw new IllegalStateException(stringBuilder.toString());
    } 
  }
  
  public URL url() {
    try {
      return new URL(this.url);
    } catch (MalformedURLException malformedURLException) {
      throw new RuntimeException(malformedURLException);
    } 
  }
  
  public String username() {
    return this.username;
  }
  
  public static final class Builder {
    String encodedFragment;
    
    String encodedPassword = "";
    
    final List<String> encodedPathSegments = new ArrayList<String>();
    
    List<String> encodedQueryNamesAndValues;
    
    String encodedUsername = "";
    
    String host;
    
    int port = -1;
    
    String scheme;
    
    public Builder() {
      this.encodedPathSegments.add("");
    }
    
    private static String canonicalizeHost(String param1String, int param1Int1, int param1Int2) {
      byte[] arrayOfByte;
      param1String = HttpUrl.percentDecode(param1String, param1Int1, param1Int2, false);
      if (param1String.startsWith("[") && param1String.endsWith("]")) {
        InetAddress inetAddress = decodeIpv6(param1String, 1, param1String.length() - 1);
        if (inetAddress == null)
          return null; 
        arrayOfByte = inetAddress.getAddress();
        if (arrayOfByte.length == 16)
          return inet6AddressToAscii(arrayOfByte); 
        throw new AssertionError();
      } 
      return domainToAscii((String)arrayOfByte);
    }
    
    private static boolean containsInvalidHostnameAsciiCodes(String param1String) {
      int i = 0;
      while (i < param1String.length()) {
        char c = param1String.charAt(i);
        if (c > '\037') {
          if (c >= '')
            return true; 
          if (" #%/:?@[\\]".indexOf(c) != -1)
            return true; 
          i++;
          continue;
        } 
        return true;
      } 
      return false;
    }
    
    private static boolean decodeIpv4Suffix(String param1String, int param1Int1, int param1Int2, byte[] param1ArrayOfbyte, int param1Int3) {
      int j = param1Int3;
      int i = param1Int1;
      while (i < param1Int2) {
        if (j == param1ArrayOfbyte.length)
          return false; 
        param1Int1 = i;
        if (j != param1Int3) {
          if (param1String.charAt(i) != '.')
            return false; 
          param1Int1 = i + 1;
        } 
        i = param1Int1;
        int k = 0;
        while (i < param1Int2) {
          char c = param1String.charAt(i);
          if (c < '0' || c > '9')
            break; 
          if (!k && param1Int1 != i)
            return false; 
          k = k * 10 + c - 48;
          if (k > 255)
            return false; 
          i++;
        } 
        if (i - param1Int1 == 0)
          return false; 
        param1ArrayOfbyte[j] = (byte)k;
        j++;
      } 
      return !(j != param1Int3 + 4);
    }
    
    private static InetAddress decodeIpv6(String param1String, int param1Int1, int param1Int2) {
      int k;
      int n;
      byte[] arrayOfByte = new byte[16];
      int i = 0;
      int j = -1;
      int m = -1;
      while (true) {
        k = i;
        n = j;
        if (param1Int1 < param1Int2) {
          if (i == arrayOfByte.length)
            return null; 
          n = param1Int1 + 2;
          if (n <= param1Int2 && param1String.regionMatches(param1Int1, "::", 0, 2)) {
            if (j != -1)
              return null; 
            k = i + 2;
            param1Int1 = k;
            if (n == param1Int2) {
              n = param1Int1;
              break;
            } 
            m = n;
            i = k;
            j = param1Int1;
            param1Int1 = m;
          } else {
            k = param1Int1;
            if (i != 0)
              if (param1String.regionMatches(param1Int1, ":", 0, 1)) {
                k = param1Int1 + 1;
              } else {
                if (param1String.regionMatches(param1Int1, ".", 0, 1)) {
                  if (!decodeIpv4Suffix(param1String, m, param1Int2, arrayOfByte, i - 2))
                    return null; 
                  k = i + 2;
                  n = j;
                  break;
                } 
                return null;
              }  
            param1Int1 = k;
          } 
          k = param1Int1;
          m = 0;
          while (k < param1Int2) {
            n = HttpUrl.decodeHexDigit(param1String.charAt(k));
            if (n == -1)
              break; 
            m = (m << 4) + n;
            k++;
          } 
          n = k - param1Int1;
          if (n != 0) {
            if (n > 4)
              return null; 
            n = i + 1;
            arrayOfByte[i] = (byte)(m >>> 8 & 0xFF);
            i = n + 1;
            arrayOfByte[n] = (byte)(m & 0xFF);
            m = param1Int1;
            param1Int1 = k;
            continue;
          } 
          return null;
        } 
        break;
      } 
      if (k != arrayOfByte.length) {
        if (n == -1)
          return null; 
        param1Int1 = arrayOfByte.length;
        param1Int2 = k - n;
        System.arraycopy(arrayOfByte, n, arrayOfByte, param1Int1 - param1Int2, param1Int2);
        Arrays.fill(arrayOfByte, n, arrayOfByte.length - k + n, (byte)0);
      } 
      try {
        return InetAddress.getByAddress(arrayOfByte);
      } catch (UnknownHostException unknownHostException) {
        throw new AssertionError();
      } 
    }
    
    private static String domainToAscii(String param1String) {
      try {
        param1String = IDN.toASCII(param1String).toLowerCase(Locale.US);
        if (param1String.isEmpty())
          return null; 
        boolean bool = containsInvalidHostnameAsciiCodes(param1String);
        return bool ? null : param1String;
      } catch (IllegalArgumentException illegalArgumentException) {
        return null;
      } 
    }
    
    private static String inet6AddressToAscii(byte[] param1ArrayOfbyte) {
      boolean bool = false;
      int i = 0;
      int k = -1;
      int j;
      for (j = 0; i < param1ArrayOfbyte.length; j = n) {
        int m;
        for (m = i; m < 16 && param1ArrayOfbyte[m] == 0 && param1ArrayOfbyte[m + 1] == 0; m += 2);
        int i1 = m - i;
        int n = j;
        if (i1 > j) {
          n = i1;
          k = i;
        } 
        i = m + 2;
      } 
      Buffer buffer = new Buffer();
      for (i = bool; i < param1ArrayOfbyte.length; i += 2) {
        if (i == k) {
          buffer.writeByte(58);
          int m = i + j;
          i = m;
          if (m == 16) {
            buffer.writeByte(58);
            i = m;
          } 
          continue;
        } 
        if (i > 0)
          buffer.writeByte(58); 
        buffer.writeHexadecimalUnsignedLong(((param1ArrayOfbyte[i] & 0xFF) << 8 | param1ArrayOfbyte[i + 1] & 0xFF));
      } 
      return buffer.readUtf8();
    }
    
    private boolean isDot(String param1String) {
      return (param1String.equals(".") || param1String.equalsIgnoreCase("%2e"));
    }
    
    private boolean isDotDot(String param1String) {
      return (param1String.equals("..") || param1String.equalsIgnoreCase("%2e.") || param1String.equalsIgnoreCase(".%2e") || param1String.equalsIgnoreCase("%2e%2e"));
    }
    
    private static int parsePort(String param1String, int param1Int1, int param1Int2) {
      try {
        param1Int1 = Integer.parseInt(HttpUrl.canonicalize(param1String, param1Int1, param1Int2, "", false, false, true));
        return (param1Int1 > 0 && param1Int1 <= 65535) ? param1Int1 : -1;
      } catch (NumberFormatException numberFormatException) {
        return -1;
      } 
    }
    
    private void pop() {
      List<String> list = this.encodedPathSegments;
      if (((String)list.remove(list.size() - 1)).isEmpty() && !this.encodedPathSegments.isEmpty()) {
        list = this.encodedPathSegments;
        list.set(list.size() - 1, "");
        return;
      } 
      this.encodedPathSegments.add("");
    }
    
    private static int portColonOffset(String param1String, int param1Int1, int param1Int2) {
      while (param1Int1 < param1Int2) {
        char c = param1String.charAt(param1Int1);
        if (c != ':') {
          int i = param1Int1;
          if (c != '[') {
            i = param1Int1;
          } else {
            while (true) {
              param1Int1 = i + 1;
              i = param1Int1;
              if (param1Int1 < param1Int2) {
                i = param1Int1;
                if (param1String.charAt(param1Int1) == ']') {
                  i = param1Int1;
                  break;
                } 
                continue;
              } 
              break;
            } 
          } 
          param1Int1 = i + 1;
          continue;
        } 
        return param1Int1;
      } 
      return param1Int2;
    }
    
    private void push(String param1String, int param1Int1, int param1Int2, boolean param1Boolean1, boolean param1Boolean2) {
      param1String = HttpUrl.canonicalize(param1String, param1Int1, param1Int2, " \"<>^`{}|/\\?#", param1Boolean2, false, true);
      if (isDot(param1String))
        return; 
      if (isDotDot(param1String)) {
        pop();
        return;
      } 
      List<String> list = this.encodedPathSegments;
      if (((String)list.get(list.size() - 1)).isEmpty()) {
        list = this.encodedPathSegments;
        list.set(list.size() - 1, param1String);
      } else {
        this.encodedPathSegments.add(param1String);
      } 
      if (param1Boolean1)
        this.encodedPathSegments.add(""); 
    }
    
    private void removeAllCanonicalQueryParameters(String param1String) {
      for (int i = this.encodedQueryNamesAndValues.size() - 2; i >= 0; i -= 2) {
        if (param1String.equals(this.encodedQueryNamesAndValues.get(i))) {
          this.encodedQueryNamesAndValues.remove(i + 1);
          this.encodedQueryNamesAndValues.remove(i);
          if (this.encodedQueryNamesAndValues.isEmpty()) {
            this.encodedQueryNamesAndValues = null;
            return;
          } 
        } 
      } 
    }
    
    private void resolvePath(String param1String, int param1Int1, int param1Int2) {
      if (param1Int1 == param1Int2)
        return; 
      char c = param1String.charAt(param1Int1);
      if (c == '/' || c == '\\') {
        this.encodedPathSegments.clear();
        this.encodedPathSegments.add("");
      } else {
        List<String> list = this.encodedPathSegments;
        list.set(list.size() - 1, "");
        while (true) {
          if (param1Int1 < param1Int2) {
            boolean bool;
            int i = HttpUrl.delimiterOffset(param1String, param1Int1, param1Int2, "/\\");
            if (i < param1Int2) {
              bool = true;
            } else {
              bool = false;
            } 
            push(param1String, param1Int1, i, bool, true);
            param1Int1 = i;
            if (bool) {
              param1Int1 = i;
            } else {
              continue;
            } 
          } else {
            break;
          } 
          param1Int1++;
        } 
        return;
      } 
      param1Int1++;
      continue;
    }
    
    private static int schemeDelimiterOffset(String param1String, int param1Int1, int param1Int2) {
      // Byte code:
      //   0: iload_2
      //   1: iload_1
      //   2: isub
      //   3: iconst_2
      //   4: if_icmpge -> 9
      //   7: iconst_m1
      //   8: ireturn
      //   9: aload_0
      //   10: iload_1
      //   11: invokevirtual charAt : (I)C
      //   14: istore #4
      //   16: iload #4
      //   18: bipush #97
      //   20: if_icmplt -> 32
      //   23: iload_1
      //   24: istore_3
      //   25: iload #4
      //   27: bipush #122
      //   29: if_icmple -> 50
      //   32: iload #4
      //   34: bipush #65
      //   36: if_icmplt -> 153
      //   39: iload_1
      //   40: istore_3
      //   41: iload #4
      //   43: bipush #90
      //   45: if_icmple -> 50
      //   48: iconst_m1
      //   49: ireturn
      //   50: iload_3
      //   51: iconst_1
      //   52: iadd
      //   53: istore_1
      //   54: iload_1
      //   55: iload_2
      //   56: if_icmpge -> 153
      //   59: aload_0
      //   60: iload_1
      //   61: invokevirtual charAt : (I)C
      //   64: istore #4
      //   66: iload #4
      //   68: bipush #97
      //   70: if_icmplt -> 82
      //   73: iload_1
      //   74: istore_3
      //   75: iload #4
      //   77: bipush #122
      //   79: if_icmple -> 50
      //   82: iload #4
      //   84: bipush #65
      //   86: if_icmplt -> 98
      //   89: iload_1
      //   90: istore_3
      //   91: iload #4
      //   93: bipush #90
      //   95: if_icmple -> 50
      //   98: iload #4
      //   100: bipush #48
      //   102: if_icmplt -> 114
      //   105: iload_1
      //   106: istore_3
      //   107: iload #4
      //   109: bipush #57
      //   111: if_icmple -> 50
      //   114: iload_1
      //   115: istore_3
      //   116: iload #4
      //   118: bipush #43
      //   120: if_icmpeq -> 50
      //   123: iload_1
      //   124: istore_3
      //   125: iload #4
      //   127: bipush #45
      //   129: if_icmpeq -> 50
      //   132: iload #4
      //   134: bipush #46
      //   136: if_icmpne -> 144
      //   139: iload_1
      //   140: istore_3
      //   141: goto -> 50
      //   144: iload #4
      //   146: bipush #58
      //   148: if_icmpne -> 153
      //   151: iload_1
      //   152: ireturn
      //   153: iconst_m1
      //   154: ireturn
    }
    
    private int skipLeadingAsciiWhitespace(String param1String, int param1Int1, int param1Int2) {
      while (param1Int1 < param1Int2) {
        char c = param1String.charAt(param1Int1);
        if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ')
          return param1Int1; 
        param1Int1++;
      } 
      return param1Int2;
    }
    
    private int skipTrailingAsciiWhitespace(String param1String, int param1Int1, int param1Int2) {
      while (--param1Int2 >= param1Int1) {
        char c = param1String.charAt(param1Int2);
        if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ')
          return param1Int2 + 1; 
        param1Int2--;
      } 
      return param1Int1;
    }
    
    private static int slashCount(String param1String, int param1Int1, int param1Int2) {
      int i = 0;
      while (param1Int1 < param1Int2) {
        char c = param1String.charAt(param1Int1);
        if (c == '\\' || c == '/') {
          i++;
          param1Int1++;
        } 
      } 
      return i;
    }
    
    public Builder addEncodedPathSegment(String param1String) {
      if (param1String != null) {
        push(param1String, 0, param1String.length(), false, true);
        return this;
      } 
      throw new IllegalArgumentException("encodedPathSegment == null");
    }
    
    public Builder addEncodedQueryParameter(String param1String1, String param1String2) {
      if (param1String1 != null) {
        if (this.encodedQueryNamesAndValues == null)
          this.encodedQueryNamesAndValues = new ArrayList<String>(); 
        this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(param1String1, " \"'<>#&=", true, true, true));
        List<String> list = this.encodedQueryNamesAndValues;
        if (param1String2 != null) {
          param1String1 = HttpUrl.canonicalize(param1String2, " \"'<>#&=", true, true, true);
        } else {
          param1String1 = null;
        } 
        list.add(param1String1);
        return this;
      } 
      throw new IllegalArgumentException("encodedName == null");
    }
    
    public Builder addPathSegment(String param1String) {
      if (param1String != null) {
        push(param1String, 0, param1String.length(), false, false);
        return this;
      } 
      throw new IllegalArgumentException("pathSegment == null");
    }
    
    public Builder addQueryParameter(String param1String1, String param1String2) {
      if (param1String1 != null) {
        if (this.encodedQueryNamesAndValues == null)
          this.encodedQueryNamesAndValues = new ArrayList<String>(); 
        this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(param1String1, " \"'<>#&=", false, true, true));
        List<String> list = this.encodedQueryNamesAndValues;
        if (param1String2 != null) {
          param1String1 = HttpUrl.canonicalize(param1String2, " \"'<>#&=", false, true, true);
        } else {
          param1String1 = null;
        } 
        list.add(param1String1);
        return this;
      } 
      throw new IllegalArgumentException("name == null");
    }
    
    public HttpUrl build() {
      if (this.scheme != null) {
        if (this.host != null)
          return new HttpUrl(this); 
        throw new IllegalStateException("host == null");
      } 
      throw new IllegalStateException("scheme == null");
    }
    
    int effectivePort() {
      int i = this.port;
      return (i != -1) ? i : HttpUrl.defaultPort(this.scheme);
    }
    
    public Builder encodedFragment(String param1String) {
      if (param1String != null) {
        param1String = HttpUrl.canonicalize(param1String, "", true, false, false);
      } else {
        param1String = null;
      } 
      this.encodedFragment = param1String;
      return this;
    }
    
    public Builder encodedPassword(String param1String) {
      if (param1String != null) {
        this.encodedPassword = HttpUrl.canonicalize(param1String, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
        return this;
      } 
      throw new IllegalArgumentException("encodedPassword == null");
    }
    
    public Builder encodedPath(String param1String) {
      if (param1String != null) {
        if (param1String.startsWith("/")) {
          resolvePath(param1String, 0, param1String.length());
          return this;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected encodedPath: ");
        stringBuilder.append(param1String);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("encodedPath == null");
    }
    
    public Builder encodedQuery(String param1String) {
      if (param1String != null) {
        List<String> list = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(param1String, " \"'<>#", true, true, true));
      } else {
        param1String = null;
      } 
      this.encodedQueryNamesAndValues = (List<String>)param1String;
      return this;
    }
    
    public Builder encodedUsername(String param1String) {
      if (param1String != null) {
        this.encodedUsername = HttpUrl.canonicalize(param1String, " \"':;<=>@[]^`{}|/\\?#", true, false, true);
        return this;
      } 
      throw new IllegalArgumentException("encodedUsername == null");
    }
    
    public Builder fragment(String param1String) {
      if (param1String != null) {
        param1String = HttpUrl.canonicalize(param1String, "", false, false, false);
      } else {
        param1String = null;
      } 
      this.encodedFragment = param1String;
      return this;
    }
    
    public Builder host(String param1String) {
      if (param1String != null) {
        String str = canonicalizeHost(param1String, 0, param1String.length());
        if (str != null) {
          this.host = str;
          return this;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected host: ");
        stringBuilder.append(param1String);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("host == null");
    }
    
    ParseResult parse(HttpUrl param1HttpUrl, String param1String) {
      // Byte code:
      //   0: aload_0
      //   1: aload_2
      //   2: iconst_0
      //   3: aload_2
      //   4: invokevirtual length : ()I
      //   7: invokespecial skipLeadingAsciiWhitespace : (Ljava/lang/String;II)I
      //   10: istore_3
      //   11: aload_0
      //   12: aload_2
      //   13: iload_3
      //   14: aload_2
      //   15: invokevirtual length : ()I
      //   18: invokespecial skipTrailingAsciiWhitespace : (Ljava/lang/String;II)I
      //   21: istore #8
      //   23: aload_2
      //   24: iload_3
      //   25: iload #8
      //   27: invokestatic schemeDelimiterOffset : (Ljava/lang/String;II)I
      //   30: iconst_m1
      //   31: if_icmpeq -> 96
      //   34: aload_2
      //   35: iconst_1
      //   36: iload_3
      //   37: ldc_w 'https:'
      //   40: iconst_0
      //   41: bipush #6
      //   43: invokevirtual regionMatches : (ZILjava/lang/String;II)Z
      //   46: ifeq -> 64
      //   49: aload_0
      //   50: ldc_w 'https'
      //   53: putfield scheme : Ljava/lang/String;
      //   56: iload_3
      //   57: bipush #6
      //   59: iadd
      //   60: istore_3
      //   61: goto -> 108
      //   64: aload_2
      //   65: iconst_1
      //   66: iload_3
      //   67: ldc_w 'http:'
      //   70: iconst_0
      //   71: iconst_5
      //   72: invokevirtual regionMatches : (ZILjava/lang/String;II)Z
      //   75: ifeq -> 92
      //   78: aload_0
      //   79: ldc_w 'http'
      //   82: putfield scheme : Ljava/lang/String;
      //   85: iload_3
      //   86: iconst_5
      //   87: iadd
      //   88: istore_3
      //   89: goto -> 108
      //   92: getstatic com/squareup/okhttp/HttpUrl$Builder$ParseResult.UNSUPPORTED_SCHEME : Lcom/squareup/okhttp/HttpUrl$Builder$ParseResult;
      //   95: areturn
      //   96: aload_1
      //   97: ifnull -> 715
      //   100: aload_0
      //   101: aload_1
      //   102: invokestatic access$100 : (Lcom/squareup/okhttp/HttpUrl;)Ljava/lang/String;
      //   105: putfield scheme : Ljava/lang/String;
      //   108: aload_2
      //   109: iload_3
      //   110: iload #8
      //   112: invokestatic slashCount : (Ljava/lang/String;II)I
      //   115: istore #4
      //   117: iload #4
      //   119: iconst_2
      //   120: if_icmpge -> 233
      //   123: aload_1
      //   124: ifnull -> 233
      //   127: aload_1
      //   128: invokestatic access$100 : (Lcom/squareup/okhttp/HttpUrl;)Ljava/lang/String;
      //   131: aload_0
      //   132: getfield scheme : Ljava/lang/String;
      //   135: invokevirtual equals : (Ljava/lang/Object;)Z
      //   138: ifne -> 144
      //   141: goto -> 233
      //   144: aload_0
      //   145: aload_1
      //   146: invokevirtual encodedUsername : ()Ljava/lang/String;
      //   149: putfield encodedUsername : Ljava/lang/String;
      //   152: aload_0
      //   153: aload_1
      //   154: invokevirtual encodedPassword : ()Ljava/lang/String;
      //   157: putfield encodedPassword : Ljava/lang/String;
      //   160: aload_0
      //   161: aload_1
      //   162: invokestatic access$300 : (Lcom/squareup/okhttp/HttpUrl;)Ljava/lang/String;
      //   165: putfield host : Ljava/lang/String;
      //   168: aload_0
      //   169: aload_1
      //   170: invokestatic access$400 : (Lcom/squareup/okhttp/HttpUrl;)I
      //   173: putfield port : I
      //   176: aload_0
      //   177: getfield encodedPathSegments : Ljava/util/List;
      //   180: invokeinterface clear : ()V
      //   185: aload_0
      //   186: getfield encodedPathSegments : Ljava/util/List;
      //   189: aload_1
      //   190: invokevirtual encodedPathSegments : ()Ljava/util/List;
      //   193: invokeinterface addAll : (Ljava/util/Collection;)Z
      //   198: pop
      //   199: iload_3
      //   200: iload #8
      //   202: if_icmpeq -> 218
      //   205: iload_3
      //   206: istore #4
      //   208: aload_2
      //   209: iload_3
      //   210: invokevirtual charAt : (I)C
      //   213: bipush #35
      //   215: if_icmpne -> 597
      //   218: aload_0
      //   219: aload_1
      //   220: invokevirtual encodedQuery : ()Ljava/lang/String;
      //   223: invokevirtual encodedQuery : (Ljava/lang/String;)Lcom/squareup/okhttp/HttpUrl$Builder;
      //   226: pop
      //   227: iload_3
      //   228: istore #4
      //   230: goto -> 597
      //   233: iload_3
      //   234: iload #4
      //   236: iadd
      //   237: istore #6
      //   239: iconst_0
      //   240: istore_3
      //   241: iconst_0
      //   242: istore #4
      //   244: aload_2
      //   245: iload #6
      //   247: iload #8
      //   249: ldc_w '@/\?#'
      //   252: invokestatic access$200 : (Ljava/lang/String;IILjava/lang/String;)I
      //   255: istore #5
      //   257: iload #5
      //   259: iload #8
      //   261: if_icmpeq -> 275
      //   264: aload_2
      //   265: iload #5
      //   267: invokevirtual charAt : (I)C
      //   270: istore #7
      //   272: goto -> 278
      //   275: iconst_m1
      //   276: istore #7
      //   278: iload #7
      //   280: iconst_m1
      //   281: if_icmpeq -> 504
      //   284: iload #7
      //   286: bipush #35
      //   288: if_icmpeq -> 504
      //   291: iload #7
      //   293: bipush #47
      //   295: if_icmpeq -> 504
      //   298: iload #7
      //   300: bipush #92
      //   302: if_icmpeq -> 504
      //   305: iload #7
      //   307: bipush #63
      //   309: if_icmpeq -> 504
      //   312: iload #7
      //   314: bipush #64
      //   316: if_icmpeq -> 322
      //   319: goto -> 501
      //   322: iload_3
      //   323: ifne -> 443
      //   326: aload_2
      //   327: iload #6
      //   329: iload #5
      //   331: ldc ':'
      //   333: invokestatic access$200 : (Ljava/lang/String;IILjava/lang/String;)I
      //   336: istore #9
      //   338: iload #5
      //   340: istore #7
      //   342: aload_2
      //   343: iload #6
      //   345: iload #9
      //   347: ldc_w ' "':;<=>@[]^`{}|/\?#'
      //   350: iconst_1
      //   351: iconst_0
      //   352: iconst_1
      //   353: invokestatic canonicalize : (Ljava/lang/String;IILjava/lang/String;ZZZ)Ljava/lang/String;
      //   356: astore #10
      //   358: aload #10
      //   360: astore_1
      //   361: iload #4
      //   363: ifeq -> 403
      //   366: new java/lang/StringBuilder
      //   369: dup
      //   370: invokespecial <init> : ()V
      //   373: astore_1
      //   374: aload_1
      //   375: aload_0
      //   376: getfield encodedUsername : Ljava/lang/String;
      //   379: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   382: pop
      //   383: aload_1
      //   384: ldc_w '%40'
      //   387: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   390: pop
      //   391: aload_1
      //   392: aload #10
      //   394: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   397: pop
      //   398: aload_1
      //   399: invokevirtual toString : ()Ljava/lang/String;
      //   402: astore_1
      //   403: aload_0
      //   404: aload_1
      //   405: putfield encodedUsername : Ljava/lang/String;
      //   408: iload #9
      //   410: iload #7
      //   412: if_icmpeq -> 437
      //   415: aload_0
      //   416: aload_2
      //   417: iload #9
      //   419: iconst_1
      //   420: iadd
      //   421: iload #7
      //   423: ldc_w ' "':;<=>@[]^`{}|/\?#'
      //   426: iconst_1
      //   427: iconst_0
      //   428: iconst_1
      //   429: invokestatic canonicalize : (Ljava/lang/String;IILjava/lang/String;ZZZ)Ljava/lang/String;
      //   432: putfield encodedPassword : Ljava/lang/String;
      //   435: iconst_1
      //   436: istore_3
      //   437: iconst_1
      //   438: istore #4
      //   440: goto -> 495
      //   443: new java/lang/StringBuilder
      //   446: dup
      //   447: invokespecial <init> : ()V
      //   450: astore_1
      //   451: aload_1
      //   452: aload_0
      //   453: getfield encodedPassword : Ljava/lang/String;
      //   456: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   459: pop
      //   460: aload_1
      //   461: ldc_w '%40'
      //   464: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   467: pop
      //   468: aload_1
      //   469: aload_2
      //   470: iload #6
      //   472: iload #5
      //   474: ldc_w ' "':;<=>@[]^`{}|/\?#'
      //   477: iconst_1
      //   478: iconst_0
      //   479: iconst_1
      //   480: invokestatic canonicalize : (Ljava/lang/String;IILjava/lang/String;ZZZ)Ljava/lang/String;
      //   483: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   486: pop
      //   487: aload_0
      //   488: aload_1
      //   489: invokevirtual toString : ()Ljava/lang/String;
      //   492: putfield encodedPassword : Ljava/lang/String;
      //   495: iload #5
      //   497: iconst_1
      //   498: iadd
      //   499: istore #6
      //   501: goto -> 244
      //   504: aload_2
      //   505: iload #6
      //   507: iload #5
      //   509: invokestatic portColonOffset : (Ljava/lang/String;II)I
      //   512: istore_3
      //   513: iload_3
      //   514: iconst_1
      //   515: iadd
      //   516: istore #4
      //   518: iload #4
      //   520: iload #5
      //   522: if_icmpge -> 560
      //   525: aload_0
      //   526: aload_2
      //   527: iload #6
      //   529: iload_3
      //   530: invokestatic canonicalizeHost : (Ljava/lang/String;II)Ljava/lang/String;
      //   533: putfield host : Ljava/lang/String;
      //   536: aload_0
      //   537: aload_2
      //   538: iload #4
      //   540: iload #5
      //   542: invokestatic parsePort : (Ljava/lang/String;II)I
      //   545: putfield port : I
      //   548: aload_0
      //   549: getfield port : I
      //   552: iconst_m1
      //   553: if_icmpne -> 582
      //   556: getstatic com/squareup/okhttp/HttpUrl$Builder$ParseResult.INVALID_PORT : Lcom/squareup/okhttp/HttpUrl$Builder$ParseResult;
      //   559: areturn
      //   560: aload_0
      //   561: aload_2
      //   562: iload #6
      //   564: iload_3
      //   565: invokestatic canonicalizeHost : (Ljava/lang/String;II)Ljava/lang/String;
      //   568: putfield host : Ljava/lang/String;
      //   571: aload_0
      //   572: aload_0
      //   573: getfield scheme : Ljava/lang/String;
      //   576: invokestatic defaultPort : (Ljava/lang/String;)I
      //   579: putfield port : I
      //   582: aload_0
      //   583: getfield host : Ljava/lang/String;
      //   586: ifnonnull -> 593
      //   589: getstatic com/squareup/okhttp/HttpUrl$Builder$ParseResult.INVALID_HOST : Lcom/squareup/okhttp/HttpUrl$Builder$ParseResult;
      //   592: areturn
      //   593: iload #5
      //   595: istore #4
      //   597: aload_2
      //   598: iload #4
      //   600: iload #8
      //   602: ldc_w '?#'
      //   605: invokestatic access$200 : (Ljava/lang/String;IILjava/lang/String;)I
      //   608: istore #5
      //   610: aload_0
      //   611: aload_2
      //   612: iload #4
      //   614: iload #5
      //   616: invokespecial resolvePath : (Ljava/lang/String;II)V
      //   619: iload #5
      //   621: istore_3
      //   622: iload #5
      //   624: iload #8
      //   626: if_icmpge -> 677
      //   629: iload #5
      //   631: istore_3
      //   632: aload_2
      //   633: iload #5
      //   635: invokevirtual charAt : (I)C
      //   638: bipush #63
      //   640: if_icmpne -> 677
      //   643: aload_2
      //   644: iload #5
      //   646: iload #8
      //   648: ldc_w '#'
      //   651: invokestatic access$200 : (Ljava/lang/String;IILjava/lang/String;)I
      //   654: istore_3
      //   655: aload_0
      //   656: aload_2
      //   657: iload #5
      //   659: iconst_1
      //   660: iadd
      //   661: iload_3
      //   662: ldc_w ' "'<>#'
      //   665: iconst_1
      //   666: iconst_1
      //   667: iconst_1
      //   668: invokestatic canonicalize : (Ljava/lang/String;IILjava/lang/String;ZZZ)Ljava/lang/String;
      //   671: invokestatic queryStringToNamesAndValues : (Ljava/lang/String;)Ljava/util/List;
      //   674: putfield encodedQueryNamesAndValues : Ljava/util/List;
      //   677: iload_3
      //   678: iload #8
      //   680: if_icmpge -> 711
      //   683: aload_2
      //   684: iload_3
      //   685: invokevirtual charAt : (I)C
      //   688: bipush #35
      //   690: if_icmpne -> 711
      //   693: aload_0
      //   694: aload_2
      //   695: iconst_1
      //   696: iload_3
      //   697: iadd
      //   698: iload #8
      //   700: ldc ''
      //   702: iconst_1
      //   703: iconst_0
      //   704: iconst_0
      //   705: invokestatic canonicalize : (Ljava/lang/String;IILjava/lang/String;ZZZ)Ljava/lang/String;
      //   708: putfield encodedFragment : Ljava/lang/String;
      //   711: getstatic com/squareup/okhttp/HttpUrl$Builder$ParseResult.SUCCESS : Lcom/squareup/okhttp/HttpUrl$Builder$ParseResult;
      //   714: areturn
      //   715: getstatic com/squareup/okhttp/HttpUrl$Builder$ParseResult.MISSING_SCHEME : Lcom/squareup/okhttp/HttpUrl$Builder$ParseResult;
      //   718: areturn
    }
    
    public Builder password(String param1String) {
      if (param1String != null) {
        this.encodedPassword = HttpUrl.canonicalize(param1String, " \"':;<=>@[]^`{}|/\\?#", false, false, true);
        return this;
      } 
      throw new IllegalArgumentException("password == null");
    }
    
    public Builder port(int param1Int) {
      if (param1Int > 0 && param1Int <= 65535) {
        this.port = param1Int;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("unexpected port: ");
      stringBuilder.append(param1Int);
      throw new IllegalArgumentException(stringBuilder.toString());
    }
    
    public Builder query(String param1String) {
      if (param1String != null) {
        List<String> list = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(param1String, " \"'<>#", false, true, true));
      } else {
        param1String = null;
      } 
      this.encodedQueryNamesAndValues = (List<String>)param1String;
      return this;
    }
    
    Builder reencodeForUri() {
      int j = this.encodedPathSegments.size();
      int i;
      for (i = 0; i < j; i++) {
        String str1 = this.encodedPathSegments.get(i);
        this.encodedPathSegments.set(i, HttpUrl.canonicalize(str1, "[]", true, false, true));
      } 
      List<String> list = this.encodedQueryNamesAndValues;
      if (list != null) {
        j = list.size();
        for (i = 0; i < j; i++) {
          String str1 = this.encodedQueryNamesAndValues.get(i);
          if (str1 != null)
            this.encodedQueryNamesAndValues.set(i, HttpUrl.canonicalize(str1, "\\^`{|}", true, true, true)); 
        } 
      } 
      String str = this.encodedFragment;
      if (str != null)
        this.encodedFragment = HttpUrl.canonicalize(str, " \"#<>\\^`{|}", true, false, false); 
      return this;
    }
    
    public Builder removeAllEncodedQueryParameters(String param1String) {
      if (param1String != null) {
        if (this.encodedQueryNamesAndValues == null)
          return this; 
        removeAllCanonicalQueryParameters(HttpUrl.canonicalize(param1String, " \"'<>#&=", true, true, true));
        return this;
      } 
      throw new IllegalArgumentException("encodedName == null");
    }
    
    public Builder removeAllQueryParameters(String param1String) {
      if (param1String != null) {
        if (this.encodedQueryNamesAndValues == null)
          return this; 
        removeAllCanonicalQueryParameters(HttpUrl.canonicalize(param1String, " \"'<>#&=", false, true, true));
        return this;
      } 
      throw new IllegalArgumentException("name == null");
    }
    
    public Builder removePathSegment(int param1Int) {
      this.encodedPathSegments.remove(param1Int);
      if (this.encodedPathSegments.isEmpty())
        this.encodedPathSegments.add(""); 
      return this;
    }
    
    public Builder scheme(String param1String) {
      if (param1String != null) {
        if (param1String.equalsIgnoreCase("http")) {
          this.scheme = "http";
          return this;
        } 
        if (param1String.equalsIgnoreCase("https")) {
          this.scheme = "https";
          return this;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected scheme: ");
        stringBuilder.append(param1String);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("scheme == null");
    }
    
    public Builder setEncodedPathSegment(int param1Int, String param1String) {
      if (param1String != null) {
        String str = HttpUrl.canonicalize(param1String, 0, param1String.length(), " \"<>^`{}|/\\?#", true, false, true);
        this.encodedPathSegments.set(param1Int, str);
        if (!isDot(str) && !isDotDot(str))
          return this; 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected path segment: ");
        stringBuilder.append(param1String);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("encodedPathSegment == null");
    }
    
    public Builder setEncodedQueryParameter(String param1String1, String param1String2) {
      removeAllEncodedQueryParameters(param1String1);
      addEncodedQueryParameter(param1String1, param1String2);
      return this;
    }
    
    public Builder setPathSegment(int param1Int, String param1String) {
      if (param1String != null) {
        String str = HttpUrl.canonicalize(param1String, 0, param1String.length(), " \"<>^`{}|/\\?#", false, false, true);
        if (!isDot(str) && !isDotDot(str)) {
          this.encodedPathSegments.set(param1Int, str);
          return this;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected path segment: ");
        stringBuilder.append(param1String);
        throw new IllegalArgumentException(stringBuilder.toString());
      } 
      throw new IllegalArgumentException("pathSegment == null");
    }
    
    public Builder setQueryParameter(String param1String1, String param1String2) {
      removeAllQueryParameters(param1String1);
      addQueryParameter(param1String1, param1String2);
      return this;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.scheme);
      stringBuilder.append("://");
      if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
        stringBuilder.append(this.encodedUsername);
        if (!this.encodedPassword.isEmpty()) {
          stringBuilder.append(':');
          stringBuilder.append(this.encodedPassword);
        } 
        stringBuilder.append('@');
      } 
      if (this.host.indexOf(':') != -1) {
        stringBuilder.append('[');
        stringBuilder.append(this.host);
        stringBuilder.append(']');
      } else {
        stringBuilder.append(this.host);
      } 
      int i = effectivePort();
      if (i != HttpUrl.defaultPort(this.scheme)) {
        stringBuilder.append(':');
        stringBuilder.append(i);
      } 
      HttpUrl.pathSegmentsToString(stringBuilder, this.encodedPathSegments);
      if (this.encodedQueryNamesAndValues != null) {
        stringBuilder.append('?');
        HttpUrl.namesAndValuesToQueryString(stringBuilder, this.encodedQueryNamesAndValues);
      } 
      if (this.encodedFragment != null) {
        stringBuilder.append('#');
        stringBuilder.append(this.encodedFragment);
      } 
      return stringBuilder.toString();
    }
    
    public Builder username(String param1String) {
      if (param1String != null) {
        this.encodedUsername = HttpUrl.canonicalize(param1String, " \"':;<=>@[]^`{}|/\\?#", false, false, true);
        return this;
      } 
      throw new IllegalArgumentException("username == null");
    }
    
    enum ParseResult {
      INVALID_HOST, INVALID_PORT, MISSING_SCHEME, SUCCESS, UNSUPPORTED_SCHEME;
      
      static {
        INVALID_HOST = new ParseResult("INVALID_HOST", 4);
        $VALUES = new ParseResult[] { SUCCESS, MISSING_SCHEME, UNSUPPORTED_SCHEME, INVALID_PORT, INVALID_HOST };
      }
    }
  }
  
  enum ParseResult {
    INVALID_HOST, INVALID_PORT, MISSING_SCHEME, SUCCESS, UNSUPPORTED_SCHEME;
    
    static {
      INVALID_PORT = new ParseResult("INVALID_PORT", 3);
      INVALID_HOST = new ParseResult("INVALID_HOST", 4);
      $VALUES = new ParseResult[] { SUCCESS, MISSING_SCHEME, UNSUPPORTED_SCHEME, INVALID_PORT, INVALID_HOST };
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\HttpUrl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */