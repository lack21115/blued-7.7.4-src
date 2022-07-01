package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.IOUtils;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.lang.ref.SoftReference;

public final class JSONReaderScanner extends JSONLexerBase {
  public static int BUF_INIT_LEN = 8192;
  
  private static final ThreadLocal<SoftReference<char[]>> BUF_REF_LOCAL = new ThreadLocal<SoftReference<char[]>>();
  
  private char[] buf;
  
  private int bufLength;
  
  private Reader reader;
  
  public JSONReaderScanner(Reader paramReader) {
    this(paramReader, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONReaderScanner(Reader paramReader, int paramInt) {
    super(paramInt);
    this.reader = paramReader;
    SoftReference<char[]> softReference = BUF_REF_LOCAL.get();
    if (softReference != null) {
      this.buf = softReference.get();
      BUF_REF_LOCAL.set(null);
    } 
    if (this.buf == null)
      this.buf = new char[BUF_INIT_LEN]; 
    try {
      this.bufLength = paramReader.read(this.buf);
      this.bp = -1;
      next();
      if (this.ch == '﻿')
        next(); 
      return;
    } catch (IOException iOException) {
      throw new JSONException(iOException.getMessage(), iOException);
    } 
  }
  
  public JSONReaderScanner(String paramString) {
    this(paramString, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONReaderScanner(String paramString, int paramInt) {
    this(new StringReader(paramString), paramInt);
  }
  
  public JSONReaderScanner(char[] paramArrayOfchar, int paramInt) {
    this(paramArrayOfchar, paramInt, JSON.DEFAULT_PARSER_FEATURE);
  }
  
  public JSONReaderScanner(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
    this(new CharArrayReader(paramArrayOfchar, 0, paramInt1), paramInt2);
  }
  
  public final String addSymbol(int paramInt1, int paramInt2, int paramInt3, SymbolTable paramSymbolTable) {
    return paramSymbolTable.addSymbol(this.buf, paramInt1, paramInt2, paramInt3);
  }
  
  protected final void arrayCopy(int paramInt1, char[] paramArrayOfchar, int paramInt2, int paramInt3) {
    System.arraycopy(this.buf, paramInt1, paramArrayOfchar, paramInt2, paramInt3);
  }
  
  public byte[] bytesValue() {
    return IOUtils.decodeFast(this.buf, this.np + 1, this.sp);
  }
  
  public final boolean charArrayCompare(char[] paramArrayOfchar) {
    for (int i = 0; i < paramArrayOfchar.length; i++) {
      if (charAt(this.bp + i) != paramArrayOfchar[i])
        return false; 
    } 
    return true;
  }
  
  public final char charAt(int paramInt) {
    int j = this.bufLength;
    int i = paramInt;
    if (paramInt >= j) {
      if (j == -1)
        return (paramInt < this.sp) ? this.buf[paramInt] : '\032'; 
      if (this.bp == 0) {
        char[] arrayOfChar1 = this.buf;
        char[] arrayOfChar2 = new char[arrayOfChar1.length * 3 / 2];
        System.arraycopy(arrayOfChar1, this.bp, arrayOfChar2, 0, this.bufLength);
        i = arrayOfChar2.length;
        j = this.bufLength;
        try {
          i = this.reader.read(arrayOfChar2, j, i - j);
          this.bufLength += i;
          this.buf = arrayOfChar2;
          i = paramInt;
        } catch (IOException iOException) {
          throw new JSONException(iOException.getMessage(), iOException);
        } 
      } else {
        i = this.bufLength - this.bp;
        if (i > 0)
          System.arraycopy(this.buf, this.bp, this.buf, 0, i); 
        try {
          this.bufLength = this.reader.read(this.buf, i, this.buf.length - i);
          j = this.bufLength;
          if (j != 0) {
            if (j == -1)
              return '\032'; 
            this.bufLength = j + i;
            i = paramInt - this.bp;
            this.np -= this.bp;
            this.bp = 0;
          } else {
            throw new JSONException("illegal state, textLength is zero");
          } 
        } catch (IOException iOException) {
          throw new JSONException(iOException.getMessage(), iOException);
        } 
      } 
    } 
    return this.buf[i];
  }
  
  public void close() {
    super.close();
    BUF_REF_LOCAL.set((SoftReference)new SoftReference<char>(this.buf));
    this.buf = null;
    IOUtils.close(this.reader);
  }
  
  protected final void copyTo(int paramInt1, int paramInt2, char[] paramArrayOfchar) {
    System.arraycopy(this.buf, paramInt1, paramArrayOfchar, 0, paramInt2);
  }
  
  public final int indexOf(char paramChar, int paramInt) {
    for (paramInt -= this.bp;; paramInt++) {
      if (paramChar == charAt(this.bp + paramInt))
        return paramInt + this.bp; 
      if (paramChar == '\032')
        return -1; 
    } 
  }
  
  public boolean isEOF() {
    int i = this.bufLength;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != -1) {
      bool1 = bool2;
      if (this.bp != this.buf.length) {
        if (this.ch == '\032' && this.bp + 1 == this.buf.length)
          return true; 
        bool1 = false;
      } 
    } 
    return bool1;
  }
  
  public final char next() {
    int j = this.bp + 1;
    this.bp = j;
    int k = this.bufLength;
    int i = j;
    if (j >= k) {
      if (k == -1)
        return '\032'; 
      if (this.sp > 0) {
        j = this.bufLength - this.sp;
        i = j;
        if (this.ch == '"')
          i = j - 1; 
        char[] arrayOfChar = this.buf;
        System.arraycopy(arrayOfChar, i, arrayOfChar, 0, this.sp);
      } 
      this.np = -1;
      j = this.sp;
      this.bp = j;
      try {
        int m = this.bp;
        k = this.buf.length - m;
        i = k;
        if (k == 0) {
          char[] arrayOfChar = new char[this.buf.length * 2];
          System.arraycopy(this.buf, 0, arrayOfChar, 0, this.buf.length);
          this.buf = arrayOfChar;
          i = this.buf.length - m;
        } 
        this.bufLength = this.reader.read(this.buf, this.bp, i);
        i = this.bufLength;
        if (i != 0) {
          if (i == -1) {
            this.ch = '\032';
            return '\032';
          } 
          this.bufLength = i + this.bp;
          i = j;
        } else {
          throw new JSONException("illegal stat, textLength is zero");
        } 
      } catch (IOException iOException) {
        throw new JSONException(iOException.getMessage(), iOException);
      } 
    } 
    char c = this.buf[i];
    this.ch = c;
    return c;
  }
  
  public final String numberString() {
    int j = this.np;
    int i = j;
    if (j == -1)
      i = 0; 
    char c = charAt(this.sp + i - 1);
    int k = this.sp;
    if (c != 'L' && c != 'S' && c != 'B' && c != 'F') {
      j = k;
      if (c == 'D') {
        j = k - 1;
        return new String(this.buf, i, j);
      } 
      return new String(this.buf, i, j);
    } 
    j = k - 1;
    return new String(this.buf, i, j);
  }
  
  public final String stringVal() {
    if (!this.hasSpecial) {
      int i = this.np + 1;
      if (i >= 0) {
        if (i <= this.buf.length - this.sp)
          return new String(this.buf, i, this.sp); 
        throw new IllegalStateException();
      } 
      throw new IllegalStateException();
    } 
    return new String(this.sbuf, 0, this.sp);
  }
  
  public final String subString(int paramInt1, int paramInt2) {
    if (paramInt2 >= 0)
      return new String(this.buf, paramInt1, paramInt2); 
    throw new StringIndexOutOfBoundsException(paramInt2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\fastjson\parser\JSONReaderScanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */