package com.ta.utdid2.b.a;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

class a implements XmlSerializer {
  private static String a;
  
  private static final String[] a = new String[] { 
      null, null, null, null, null, null, null, null, null, null, 
      null, null, null, null, null, null, null, null, null, null, 
      null, null, null, null, null, null, null, null, null, null, 
      null, null, null, null, "&quot;", null, null, null, "&amp;", null, 
      null, null, null, null, null, null, null, null, null, null, 
      null, null, null, null, null, null, null, null, null, null, 
      "&lt;", null, "&gt;", null };
  
  private OutputStream a;
  
  private Writer a;
  
  private ByteBuffer a;
  
  private CharsetEncoder a;
  
  private final char[] a = new char[8192];
  
  private boolean e;
  
  private int mPos;
  
  static {
    a = (char[])"xmlpull.org/v1/doc/features.html#indent-output";
  }
  
  a() {
    this.a = (char[])ByteBuffer.allocate(8192);
  }
  
  private void a() throws IOException {
    int i = this.a.position();
    if (i > 0) {
      this.a.flip();
      this.a.write(this.a.array(), 0, i);
      this.a.clear();
    } 
  }
  
  private void a(String paramString) throws IOException {
    int k = paramString.length();
    char[] arrayOfChar = a;
    char c = (char)arrayOfChar.length;
    int i = 0;
    int j = 0;
    while (i < k) {
      char c1 = paramString.charAt(i);
      if (c1 < c) {
        char c2 = arrayOfChar[c1];
        if (c2 != null) {
          if (j < i)
            a(paramString, j, i - j); 
          j = i + 1;
          append(c2);
        } 
      } 
      i++;
    } 
    if (j < i)
      a(paramString, j, i - j); 
  }
  
  private void a(String paramString, int paramInt1, int paramInt2) throws IOException {
    if (paramInt2 > 8192) {
      int k = paramInt2 + paramInt1;
      while (paramInt1 < k) {
        int m = paramInt1 + 8192;
        if (m < k) {
          paramInt2 = 8192;
        } else {
          paramInt2 = k - paramInt1;
        } 
        a(paramString, paramInt1, paramInt2);
        paramInt1 = m;
      } 
      return;
    } 
    int j = this.mPos;
    int i = j;
    if (j + paramInt2 > 8192) {
      flush();
      i = this.mPos;
    } 
    paramString.getChars(paramInt1, paramInt1 + paramInt2, this.a, i);
    this.mPos = i + paramInt2;
  }
  
  private void a(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
    char[] arrayOfChar = a;
    char c = (char)arrayOfChar.length;
    int j = paramInt1;
    int i;
    for (i = paramInt1; i < paramInt2 + paramInt1; i++) {
      char c1 = paramArrayOfchar[i];
      if (c1 < c) {
        char c2 = arrayOfChar[c1];
        if (c2 != null) {
          if (j < i)
            append(paramArrayOfchar, j, i - j); 
          j = i + 1;
          append(c2);
        } 
      } 
    } 
    if (j < i)
      append(paramArrayOfchar, j, i - j); 
  }
  
  private void append(char paramChar) throws IOException {
    int j = this.mPos;
    int i = j;
    if (j >= 8191) {
      flush();
      i = this.mPos;
    } 
    this.a[i] = paramChar;
    this.mPos = i + 1;
  }
  
  private void append(String paramString) throws IOException {
    a(paramString, 0, paramString.length());
  }
  
  private void append(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
    if (paramInt2 > 8192) {
      int k = paramInt2 + paramInt1;
      while (paramInt1 < k) {
        int m = paramInt1 + 8192;
        if (m < k) {
          paramInt2 = 8192;
        } else {
          paramInt2 = k - paramInt1;
        } 
        append(paramArrayOfchar, paramInt1, paramInt2);
        paramInt1 = m;
      } 
      return;
    } 
    int j = this.mPos;
    int i = j;
    if (j + paramInt2 > 8192) {
      flush();
      i = this.mPos;
    } 
    System.arraycopy(paramArrayOfchar, paramInt1, this.a, i, paramInt2);
    this.mPos = i + paramInt2;
  }
  
  static String d() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("http://");
    stringBuilder.append((String)a);
    return stringBuilder.toString();
  }
  
  public XmlSerializer attribute(String paramString1, String paramString2, String paramString3) throws IOException, IllegalArgumentException, IllegalStateException {
    append(' ');
    if (paramString1 != null) {
      append(paramString1);
      append(':');
    } 
    append(paramString2);
    append("=\"");
    a(paramString3);
    append('"');
    return this;
  }
  
  public void cdsect(String paramString) throws IOException, IllegalArgumentException, IllegalStateException {
    throw new UnsupportedOperationException();
  }
  
  public void comment(String paramString) throws IOException, IllegalArgumentException, IllegalStateException {
    throw new UnsupportedOperationException();
  }
  
  public void docdecl(String paramString) throws IOException, IllegalArgumentException, IllegalStateException {
    throw new UnsupportedOperationException();
  }
  
  public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
    flush();
  }
  
  public XmlSerializer endTag(String paramString1, String paramString2) throws IOException, IllegalArgumentException, IllegalStateException {
    if (this.e) {
      append(" />\n");
    } else {
      append("</");
      if (paramString1 != null) {
        append(paramString1);
        append(':');
      } 
      append(paramString2);
      append(">\n");
    } 
    this.e = false;
    return this;
  }
  
  public void entityRef(String paramString) throws IOException, IllegalArgumentException, IllegalStateException {
    throw new UnsupportedOperationException();
  }
  
  public void flush() throws IOException {
    int i = this.mPos;
    if (i > 0)
      if (this.a != null) {
        CharBuffer charBuffer = CharBuffer.wrap(this.a, 0, i);
        CoderResult coderResult = this.a.encode(charBuffer, (ByteBuffer)this.a, true);
        while (true) {
          if (!coderResult.isError()) {
            if (coderResult.isOverflow()) {
              a();
              coderResult = this.a.encode(charBuffer, (ByteBuffer)this.a, true);
              continue;
            } 
            a();
            this.a.flush();
          } else {
            throw new IOException(coderResult.toString());
          } 
          this.mPos = 0;
        } 
      } else {
        this.a.write(this.a, 0, i);
        this.a.flush();
        this.mPos = 0;
      }  
  }
  
  public int getDepth() {
    throw new UnsupportedOperationException();
  }
  
  public boolean getFeature(String paramString) {
    throw new UnsupportedOperationException();
  }
  
  public String getName() {
    throw new UnsupportedOperationException();
  }
  
  public String getNamespace() {
    throw new UnsupportedOperationException();
  }
  
  public String getPrefix(String paramString, boolean paramBoolean) throws IllegalArgumentException {
    throw new UnsupportedOperationException();
  }
  
  public Object getProperty(String paramString) {
    throw new UnsupportedOperationException();
  }
  
  public void ignorableWhitespace(String paramString) throws IOException, IllegalArgumentException, IllegalStateException {
    throw new UnsupportedOperationException();
  }
  
  public void processingInstruction(String paramString) throws IOException, IllegalArgumentException, IllegalStateException {
    throw new UnsupportedOperationException();
  }
  
  public void setFeature(String paramString, boolean paramBoolean) throws IllegalArgumentException, IllegalStateException {
    if (paramString.equals(d()))
      return; 
    throw new UnsupportedOperationException();
  }
  
  public void setOutput(OutputStream paramOutputStream, String paramString) throws IOException, IllegalArgumentException, IllegalStateException {
    if (paramOutputStream != null)
      try {
        this.a = (char[])Charset.forName(paramString).newEncoder();
        this.a = (char[])paramOutputStream;
        return;
      } catch (IllegalCharsetNameException illegalCharsetNameException) {
        throw (UnsupportedEncodingException)(new UnsupportedEncodingException(paramString)).initCause(illegalCharsetNameException);
      } catch (UnsupportedCharsetException unsupportedCharsetException) {
        throw (UnsupportedEncodingException)(new UnsupportedEncodingException(paramString)).initCause(unsupportedCharsetException);
      }  
    throw new IllegalArgumentException();
  }
  
  public void setOutput(Writer paramWriter) throws IOException, IllegalArgumentException, IllegalStateException {
    this.a = (char[])paramWriter;
  }
  
  public void setPrefix(String paramString1, String paramString2) throws IOException, IllegalArgumentException, IllegalStateException {
    throw new UnsupportedOperationException();
  }
  
  public void setProperty(String paramString, Object paramObject) throws IllegalArgumentException, IllegalStateException {
    throw new UnsupportedOperationException();
  }
  
  public void startDocument(String paramString, Boolean paramBoolean) throws IOException, IllegalArgumentException, IllegalStateException {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("<?xml version='1.0' encoding='utf-8' standalone='");
    if (paramBoolean.booleanValue()) {
      paramString = "yes";
    } else {
      paramString = "no";
    } 
    stringBuilder.append(paramString);
    stringBuilder.append("' ?>\n");
    append(stringBuilder.toString());
  }
  
  public XmlSerializer startTag(String paramString1, String paramString2) throws IOException, IllegalArgumentException, IllegalStateException {
    if (this.e)
      append(">\n"); 
    append('<');
    if (paramString1 != null) {
      append(paramString1);
      append(':');
    } 
    append(paramString2);
    this.e = true;
    return this;
  }
  
  public XmlSerializer text(String paramString) throws IOException, IllegalArgumentException, IllegalStateException {
    if (this.e) {
      append(">");
      this.e = false;
    } 
    a(paramString);
    return this;
  }
  
  public XmlSerializer text(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException, IllegalArgumentException, IllegalStateException {
    if (this.e) {
      append(">");
      this.e = false;
    } 
    a(paramArrayOfchar, paramInt1, paramInt2);
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\t\\utdid2\b\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */