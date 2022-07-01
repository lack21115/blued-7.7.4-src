package com.squareup.okhttp;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MediaType {
  private static final Pattern PARAMETER;
  
  private static final String QUOTED = "\"([^\"]*)\"";
  
  private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
  
  private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
  
  private final String charset;
  
  private final String mediaType;
  
  private final String subtype;
  
  private final String type;
  
  static {
    PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
  }
  
  private MediaType(String paramString1, String paramString2, String paramString3, String paramString4) {
    this.mediaType = paramString1;
    this.type = paramString2;
    this.subtype = paramString3;
    this.charset = paramString4;
  }
  
  public static MediaType parse(String paramString) {
    StringBuilder stringBuilder;
    Matcher matcher1 = TYPE_SUBTYPE.matcher(paramString);
    if (!matcher1.lookingAt())
      return null; 
    String str1 = matcher1.group(1).toLowerCase(Locale.US);
    String str2 = matcher1.group(2).toLowerCase(Locale.US);
    Matcher matcher3 = PARAMETER.matcher(paramString);
    int i = matcher1.end();
    Matcher matcher2 = null;
    while (i < paramString.length()) {
      StringBuilder stringBuilder1;
      matcher3.region(i, paramString.length());
      if (!matcher3.lookingAt())
        return null; 
      String str = matcher3.group(1);
      matcher1 = matcher2;
      if (str != null)
        if (!str.equalsIgnoreCase("charset")) {
          matcher1 = matcher2;
        } else {
          String str3;
          if (matcher3.group(2) != null) {
            str3 = matcher3.group(2);
          } else {
            str3 = matcher3.group(3);
          } 
          if (matcher2 != null && !str3.equalsIgnoreCase((String)matcher2)) {
            stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Multiple different charsets: ");
            stringBuilder1.append(paramString);
            throw new IllegalArgumentException(stringBuilder1.toString());
          } 
        }  
      i = matcher3.end();
      stringBuilder = stringBuilder1;
    } 
    return new MediaType(paramString, str1, str2, (String)stringBuilder);
  }
  
  public Charset charset() {
    String str = this.charset;
    return (str != null) ? Charset.forName(str) : null;
  }
  
  public Charset charset(Charset paramCharset) {
    String str = this.charset;
    if (str != null)
      paramCharset = Charset.forName(str); 
    return paramCharset;
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof MediaType && ((MediaType)paramObject).mediaType.equals(this.mediaType));
  }
  
  public int hashCode() {
    return this.mediaType.hashCode();
  }
  
  public String subtype() {
    return this.subtype;
  }
  
  public String toString() {
    return this.mediaType;
  }
  
  public String type() {
    return this.type;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\squareup\okhttp\MediaType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */