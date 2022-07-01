package com.google.common.io;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class BaseEncoding {
  private static final BaseEncoding a;
  
  private static final BaseEncoding b;
  
  private static final BaseEncoding c;
  
  private static final BaseEncoding d;
  
  private static final BaseEncoding e = new Base16Encoding("base16()", "0123456789ABCDEF");
  
  static Reader a(Reader paramReader, String paramString) {
    Preconditions.a(paramReader);
    Preconditions.a(paramString);
    return new Reader(paramReader, paramString) {
        public void close() throws IOException {
          this.a.close();
        }
        
        public int read() throws IOException {
          int i;
          do {
            i = this.a.read();
          } while (i != -1 && this.b.indexOf((char)i) >= 0);
          return i;
        }
        
        public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
          throw new UnsupportedOperationException();
        }
      };
  }
  
  static Appendable a(Appendable paramAppendable, String paramString, int paramInt) {
    boolean bool;
    Preconditions.a(paramAppendable);
    Preconditions.a(paramString);
    if (paramInt > 0) {
      bool = true;
    } else {
      bool = false;
    } 
    Preconditions.a(bool);
    return new Appendable(paramInt, paramAppendable, paramString) {
        int a = this.b;
        
        public Appendable append(char param1Char) throws IOException {
          if (this.a == 0) {
            this.c.append(this.d);
            this.a = this.b;
          } 
          this.c.append(param1Char);
          this.a--;
          return this;
        }
        
        public Appendable append(@NullableDecl CharSequence param1CharSequence) throws IOException {
          throw new UnsupportedOperationException();
        }
        
        public Appendable append(@NullableDecl CharSequence param1CharSequence, int param1Int1, int param1Int2) throws IOException {
          throw new UnsupportedOperationException();
        }
      };
  }
  
  private static byte[] a(byte[] paramArrayOfbyte, int paramInt) {
    if (paramInt == paramArrayOfbyte.length)
      return paramArrayOfbyte; 
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  public static BaseEncoding b() {
    return a;
  }
  
  public static BaseEncoding c() {
    return b;
  }
  
  public static BaseEncoding d() {
    return e;
  }
  
  abstract int a(int paramInt);
  
  abstract int a(byte[] paramArrayOfbyte, CharSequence paramCharSequence) throws DecodingException;
  
  public abstract BaseEncoding a();
  
  public abstract BaseEncoding a(String paramString, int paramInt);
  
  public abstract InputStream a(Reader paramReader);
  
  public String a(byte[] paramArrayOfbyte) {
    return a(paramArrayOfbyte, 0, paramArrayOfbyte.length);
  }
  
  public final String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    Preconditions.a(paramInt1, paramInt1 + paramInt2, paramArrayOfbyte.length);
    StringBuilder stringBuilder = new StringBuilder(a(paramInt2));
    try {
      a(stringBuilder, paramArrayOfbyte, paramInt1, paramInt2);
      return stringBuilder.toString();
    } catch (IOException iOException) {
      throw new AssertionError(iOException);
    } 
  }
  
  abstract void a(Appendable paramAppendable, byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException;
  
  public final byte[] a(CharSequence paramCharSequence) {
    try {
      return b(paramCharSequence);
    } catch (DecodingException decodingException) {
      throw new IllegalArgumentException(decodingException);
    } 
  }
  
  abstract int b(int paramInt);
  
  final byte[] b(CharSequence paramCharSequence) throws DecodingException {
    paramCharSequence = c(paramCharSequence);
    byte[] arrayOfByte = new byte[b(paramCharSequence.length())];
    return a(arrayOfByte, a(arrayOfByte, paramCharSequence));
  }
  
  CharSequence c(CharSequence paramCharSequence) {
    return (CharSequence)Preconditions.a(paramCharSequence);
  }
  
  static {
    Character character = Character.valueOf('=');
    a = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", character);
    b = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", character);
    c = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", character);
    d = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", character);
  }
  
  static final class Alphabet {
    final int a;
    
    final int b;
    
    final int c;
    
    final int d;
    
    private final String e;
    
    private final char[] f;
    
    private final byte[] g;
    
    private final boolean[] h;
    
    Alphabet(String param1String, char[] param1ArrayOfchar) {
      this.e = (String)Preconditions.a(param1String);
      this.f = (char[])Preconditions.a(param1ArrayOfchar);
      try {
        this.b = IntMath.a(param1ArrayOfchar.length, RoundingMode.UNNECESSARY);
        int i = Math.min(8, Integer.lowestOneBit(this.b));
        try {
          this.c = 8 / i;
          this.d = this.b / i;
          this.a = param1ArrayOfchar.length - 1;
          byte[] arrayOfByte = new byte[128];
          Arrays.fill(arrayOfByte, (byte)-1);
          boolean bool = false;
          for (i = 0; i < param1ArrayOfchar.length; i++) {
            boolean bool1;
            char c = param1ArrayOfchar[i];
            if (c < arrayOfByte.length) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            Preconditions.a(bool1, "Non-ASCII character: %s", c);
            if (arrayOfByte[c] == -1) {
              bool1 = true;
            } else {
              bool1 = false;
            } 
            Preconditions.a(bool1, "Duplicate character: %s", c);
            arrayOfByte[c] = (byte)i;
          } 
          this.g = arrayOfByte;
          boolean[] arrayOfBoolean = new boolean[this.c];
          for (i = bool; i < this.d; i++)
            arrayOfBoolean[IntMath.a(i * 8, this.b, RoundingMode.CEILING)] = true; 
          this.h = arrayOfBoolean;
          return;
        } catch (ArithmeticException arithmeticException) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Illegal alphabet ");
          stringBuilder.append(new String(param1ArrayOfchar));
          throw new IllegalArgumentException(stringBuilder.toString(), arithmeticException);
        } 
      } catch (ArithmeticException arithmeticException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal alphabet length ");
        stringBuilder.append(param1ArrayOfchar.length);
        throw new IllegalArgumentException(stringBuilder.toString(), arithmeticException);
      } 
    }
    
    char a(int param1Int) {
      return this.f[param1Int];
    }
    
    int a(char param1Char) throws BaseEncoding.DecodingException {
      if (param1Char <= '') {
        byte b = this.g[param1Char];
        if (b == -1) {
          if (param1Char <= ' ' || param1Char == '') {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unrecognized character: 0x");
            stringBuilder2.append(Integer.toHexString(param1Char));
            throw new BaseEncoding.DecodingException(stringBuilder2.toString());
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Unrecognized character: ");
          stringBuilder1.append(param1Char);
          throw new BaseEncoding.DecodingException(stringBuilder1.toString());
        } 
        return b;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unrecognized character: 0x");
      stringBuilder.append(Integer.toHexString(param1Char));
      throw new BaseEncoding.DecodingException(stringBuilder.toString());
    }
    
    public boolean b(char param1Char) {
      byte[] arrayOfByte = this.g;
      return (param1Char < arrayOfByte.length && arrayOfByte[param1Char] != -1);
    }
    
    boolean b(int param1Int) {
      return this.h[param1Int % this.c];
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      if (param1Object instanceof Alphabet) {
        param1Object = param1Object;
        return Arrays.equals(this.f, ((Alphabet)param1Object).f);
      } 
      return false;
    }
    
    public int hashCode() {
      return Arrays.hashCode(this.f);
    }
    
    public String toString() {
      return this.e;
    }
  }
  
  static final class Base16Encoding extends StandardBaseEncoding {
    final char[] a;
    
    private Base16Encoding(BaseEncoding.Alphabet param1Alphabet) {
      super(param1Alphabet, null);
      boolean bool;
      this.a = new char[512];
      int j = (BaseEncoding.Alphabet.a(param1Alphabet)).length;
      int i = 0;
      if (j == 16) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool);
      while (i < 256) {
        this.a[i] = param1Alphabet.a(i >>> 4);
        this.a[i | 0x100] = param1Alphabet.a(i & 0xF);
        i++;
      } 
    }
    
    Base16Encoding(String param1String1, String param1String2) {
      this(new BaseEncoding.Alphabet(param1String1, param1String2.toCharArray()));
    }
    
    int a(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws BaseEncoding.DecodingException {
      Preconditions.a(param1ArrayOfbyte);
      if (param1CharSequence.length() % 2 != 1) {
        int j = 0;
        int i;
        for (i = 0; j < param1CharSequence.length(); i++) {
          param1ArrayOfbyte[i] = (byte)(this.b.a(param1CharSequence.charAt(j)) << 4 | this.b.a(param1CharSequence.charAt(j + 1)));
          j += 2;
        } 
        return i;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid input length ");
      stringBuilder.append(param1CharSequence.length());
      throw new BaseEncoding.DecodingException(stringBuilder.toString());
    }
    
    BaseEncoding a(BaseEncoding.Alphabet param1Alphabet, @NullableDecl Character param1Character) {
      return new Base16Encoding(param1Alphabet);
    }
    
    void a(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      Preconditions.a(param1Appendable);
      Preconditions.a(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length);
      int i;
      for (i = 0; i < param1Int2; i++) {
        int j = param1ArrayOfbyte[param1Int1 + i] & 0xFF;
        param1Appendable.append(this.a[j]);
        param1Appendable.append(this.a[j | 0x100]);
      } 
    }
  }
  
  static final class Base64Encoding extends StandardBaseEncoding {
    private Base64Encoding(BaseEncoding.Alphabet param1Alphabet, @NullableDecl Character param1Character) {
      super(param1Alphabet, param1Character);
      boolean bool;
      if ((BaseEncoding.Alphabet.a(param1Alphabet)).length == 64) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool);
    }
    
    Base64Encoding(String param1String1, String param1String2, @NullableDecl Character param1Character) {
      this(new BaseEncoding.Alphabet(param1String1, param1String2.toCharArray()), param1Character);
    }
    
    int a(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws BaseEncoding.DecodingException {
      Preconditions.a(param1ArrayOfbyte);
      param1CharSequence = c(param1CharSequence);
      if (this.b.b(param1CharSequence.length())) {
        int j = 0;
        int i = 0;
        while (j < param1CharSequence.length()) {
          BaseEncoding.Alphabet alphabet = this.b;
          int m = j + 1;
          j = alphabet.a(param1CharSequence.charAt(j));
          alphabet = this.b;
          int k = m + 1;
          int n = j << 18 | alphabet.a(param1CharSequence.charAt(m)) << 12;
          m = i + 1;
          param1ArrayOfbyte[i] = (byte)(n >>> 16);
          i = m;
          j = k;
          if (k < param1CharSequence.length()) {
            alphabet = this.b;
            j = k + 1;
            n |= alphabet.a(param1CharSequence.charAt(k)) << 6;
            i = m + 1;
            param1ArrayOfbyte[m] = (byte)(n >>> 8 & 0xFF);
            if (j < param1CharSequence.length()) {
              alphabet = this.b;
              k = j + 1;
              m = alphabet.a(param1CharSequence.charAt(j));
              j = i + 1;
              param1ArrayOfbyte[i] = (byte)((n | m) & 0xFF);
              i = j;
              j = k;
            } 
          } 
        } 
        return i;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid input length ");
      stringBuilder.append(param1CharSequence.length());
      throw new BaseEncoding.DecodingException(stringBuilder.toString());
    }
    
    BaseEncoding a(BaseEncoding.Alphabet param1Alphabet, @NullableDecl Character param1Character) {
      return new Base64Encoding(param1Alphabet, param1Character);
    }
    
    void a(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      Preconditions.a(param1Appendable);
      int i = param1Int1 + param1Int2;
      Preconditions.a(param1Int1, i, param1ArrayOfbyte.length);
      while (param1Int2 >= 3) {
        int j = param1Int1 + 1;
        byte b = param1ArrayOfbyte[param1Int1];
        param1Int1 = j + 1;
        j = (b & 0xFF) << 16 | (param1ArrayOfbyte[j] & 0xFF) << 8 | param1ArrayOfbyte[param1Int1] & 0xFF;
        param1Appendable.append(this.b.a(j >>> 18));
        param1Appendable.append(this.b.a(j >>> 12 & 0x3F));
        param1Appendable.append(this.b.a(j >>> 6 & 0x3F));
        param1Appendable.append(this.b.a(j & 0x3F));
        param1Int2 -= 3;
        param1Int1++;
      } 
      if (param1Int1 < i)
        b(param1Appendable, param1ArrayOfbyte, param1Int1, i - param1Int1); 
    }
  }
  
  public static final class DecodingException extends IOException {
    DecodingException(String param1String) {
      super(param1String);
    }
  }
  
  static final class SeparatedBaseEncoding extends BaseEncoding {
    private final BaseEncoding a;
    
    private final String b;
    
    private final int c;
    
    SeparatedBaseEncoding(BaseEncoding param1BaseEncoding, String param1String, int param1Int) {
      boolean bool;
      this.a = (BaseEncoding)Preconditions.a(param1BaseEncoding);
      this.b = (String)Preconditions.a(param1String);
      this.c = param1Int;
      if (param1Int > 0) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool, "Cannot add a separator after every %s chars", param1Int);
    }
    
    int a(int param1Int) {
      param1Int = this.a.a(param1Int);
      return param1Int + this.b.length() * IntMath.a(Math.max(0, param1Int - 1), this.c, RoundingMode.FLOOR);
    }
    
    int a(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws BaseEncoding.DecodingException {
      StringBuilder stringBuilder = new StringBuilder(param1CharSequence.length());
      int i;
      for (i = 0; i < param1CharSequence.length(); i++) {
        char c = param1CharSequence.charAt(i);
        if (this.b.indexOf(c) < 0)
          stringBuilder.append(c); 
      } 
      return this.a.a(param1ArrayOfbyte, stringBuilder);
    }
    
    public BaseEncoding a() {
      return this.a.a().a(this.b, this.c);
    }
    
    public BaseEncoding a(String param1String, int param1Int) {
      throw new UnsupportedOperationException("Already have a separator");
    }
    
    public InputStream a(Reader param1Reader) {
      return this.a.a(a(param1Reader, this.b));
    }
    
    void a(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      this.a.a(a(param1Appendable, this.b, this.c), param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    int b(int param1Int) {
      return this.a.b(param1Int);
    }
    
    CharSequence c(CharSequence param1CharSequence) {
      return this.a.c(param1CharSequence);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a);
      stringBuilder.append(".withSeparator(\"");
      stringBuilder.append(this.b);
      stringBuilder.append("\", ");
      stringBuilder.append(this.c);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class StandardBaseEncoding extends BaseEncoding {
    final BaseEncoding.Alphabet b;
    
    @NullableDecl
    final Character c;
    
    StandardBaseEncoding(BaseEncoding.Alphabet param1Alphabet, @NullableDecl Character param1Character) {
      boolean bool;
      this.b = (BaseEncoding.Alphabet)Preconditions.a(param1Alphabet);
      if (param1Character == null || !param1Alphabet.b(param1Character.charValue())) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool, "Padding character %s was already in alphabet", param1Character);
      this.c = param1Character;
    }
    
    StandardBaseEncoding(String param1String1, String param1String2, @NullableDecl Character param1Character) {
      this(new BaseEncoding.Alphabet(param1String1, param1String2.toCharArray()), param1Character);
    }
    
    int a(int param1Int) {
      return this.b.c * IntMath.a(param1Int, this.b.d, RoundingMode.CEILING);
    }
    
    int a(byte[] param1ArrayOfbyte, CharSequence param1CharSequence) throws BaseEncoding.DecodingException {
      Preconditions.a(param1ArrayOfbyte);
      param1CharSequence = c(param1CharSequence);
      if (this.b.b(param1CharSequence.length())) {
        int i = 0;
        int j = 0;
        while (i < param1CharSequence.length()) {
          long l = 0L;
          int m = 0;
          int k;
          for (k = 0; m < this.b.c; k = i2) {
            long l1 = l << this.b.b;
            int i2 = k;
            l = l1;
            if (i + m < param1CharSequence.length()) {
              l = l1 | this.b.a(param1CharSequence.charAt(k + i));
              i2 = k + 1;
            } 
            m++;
          } 
          int n = this.b.d;
          int i1 = this.b.b;
          m = (this.b.d - 1) * 8;
          while (m >= n * 8 - k * i1) {
            param1ArrayOfbyte[j] = (byte)(int)(l >>> m & 0xFFL);
            m -= 8;
            j++;
          } 
          i += this.b.c;
        } 
        return j;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid input length ");
      stringBuilder.append(param1CharSequence.length());
      throw new BaseEncoding.DecodingException(stringBuilder.toString());
    }
    
    public BaseEncoding a() {
      return (this.c == null) ? this : a(this.b, (Character)null);
    }
    
    BaseEncoding a(BaseEncoding.Alphabet param1Alphabet, @NullableDecl Character param1Character) {
      return new StandardBaseEncoding(param1Alphabet, param1Character);
    }
    
    public BaseEncoding a(String param1String, int param1Int) {
      boolean bool = false;
      for (int i = 0; i < param1String.length(); i++)
        Preconditions.a(this.b.b(param1String.charAt(i)) ^ true, "Separator (%s) cannot contain alphabet characters", param1String); 
      Character character = this.c;
      if (character != null) {
        if (param1String.indexOf(character.charValue()) < 0)
          bool = true; 
        Preconditions.a(bool, "Separator (%s) cannot contain padding character", param1String);
      } 
      return new BaseEncoding.SeparatedBaseEncoding(this, param1String, param1Int);
    }
    
    public InputStream a(Reader param1Reader) {
      Preconditions.a(param1Reader);
      return new InputStream(this, param1Reader) {
          int a = 0;
          
          int b = 0;
          
          int c = 0;
          
          boolean d = false;
          
          public void close() throws IOException {
            this.e.close();
          }
          
          public int read() throws IOException {
            while (true) {
              int i = this.e.read();
              if (i == -1) {
                if (!this.d) {
                  if (this.f.b.b(this.c))
                    return -1; 
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("Invalid input length ");
                  stringBuilder1.append(this.c);
                  throw new BaseEncoding.DecodingException(stringBuilder1.toString());
                } 
                return -1;
              } 
              this.c++;
              char c = (char)i;
              if (this.f.c != null && this.f.c.charValue() == c) {
                if (this.d || (this.c != 1 && this.f.b.b(this.c - 1))) {
                  this.d = true;
                  continue;
                } 
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Padding cannot start at index ");
                stringBuilder1.append(this.c);
                throw new BaseEncoding.DecodingException(stringBuilder1.toString());
              } 
              if (!this.d) {
                this.a <<= this.f.b.b;
                i = this.a;
                this.a = this.f.b.a(c) | i;
                this.b += this.f.b.b;
                i = this.b;
                if (i >= 8) {
                  this.b = i - 8;
                  return this.a >> this.b & 0xFF;
                } 
                continue;
              } 
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("Expected padding character but found '");
              stringBuilder.append(c);
              stringBuilder.append("' at index ");
              stringBuilder.append(this.c);
              throw new BaseEncoding.DecodingException(stringBuilder.toString());
            } 
          }
          
          public int read(byte[] param2ArrayOfbyte, int param2Int1, int param2Int2) throws IOException {
            int i = param2Int2 + param2Int1;
            Preconditions.a(param2Int1, i, param2ArrayOfbyte.length);
            for (param2Int2 = param2Int1; param2Int2 < i; param2Int2++) {
              int j = read();
              if (j == -1) {
                param2Int2 -= param2Int1;
                param2Int1 = param2Int2;
                if (param2Int2 == 0)
                  param2Int1 = -1; 
                return param2Int1;
              } 
              param2ArrayOfbyte[param2Int2] = (byte)j;
            } 
            return param2Int2 - param2Int1;
          }
        };
    }
    
    void a(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      Preconditions.a(param1Appendable);
      Preconditions.a(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length);
      int i;
      for (i = 0; i < param1Int2; i += this.b.d)
        b(param1Appendable, param1ArrayOfbyte, param1Int1 + i, Math.min(this.b.d, param1Int2 - i)); 
    }
    
    int b(int param1Int) {
      return (int)((this.b.b * param1Int + 7L) / 8L);
    }
    
    void b(Appendable param1Appendable, byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      boolean bool;
      Preconditions.a(param1Appendable);
      Preconditions.a(param1Int1, param1Int1 + param1Int2, param1ArrayOfbyte.length);
      int i = this.b.d;
      int j = 0;
      if (param1Int2 <= i) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool);
      long l = 0L;
      for (i = 0; i < param1Int2; i++)
        l = (l | (param1ArrayOfbyte[param1Int1 + i] & 0xFF)) << 8L; 
      i = this.b.b;
      for (param1Int1 = j; param1Int1 < param1Int2 * 8; param1Int1 += this.b.b) {
        j = (int)(l >>> (param1Int2 + 1) * 8 - i - param1Int1);
        int k = this.b.a;
        param1Appendable.append(this.b.a(j & k));
      } 
      if (this.c != null)
        while (param1Int1 < this.b.d * 8) {
          param1Appendable.append(this.c.charValue());
          param1Int1 += this.b.b;
        }  
    }
    
    CharSequence c(CharSequence param1CharSequence) {
      Preconditions.a(param1CharSequence);
      Character character = this.c;
      if (character == null)
        return param1CharSequence; 
      char c = character.charValue();
      int i;
      for (i = param1CharSequence.length() - 1; i >= 0 && param1CharSequence.charAt(i) == c; i--);
      return param1CharSequence.subSequence(0, i + 1);
    }
    
    public boolean equals(@NullableDecl Object param1Object) {
      boolean bool = param1Object instanceof StandardBaseEncoding;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (bool) {
        param1Object = param1Object;
        bool1 = bool2;
        if (this.b.equals(((StandardBaseEncoding)param1Object).b)) {
          bool1 = bool2;
          if (Objects.a(this.c, ((StandardBaseEncoding)param1Object).c))
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public int hashCode() {
      return this.b.hashCode() ^ Objects.a(new Object[] { this.c });
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("BaseEncoding.");
      stringBuilder.append(this.b.toString());
      if (8 % this.b.b != 0)
        if (this.c == null) {
          stringBuilder.append(".omitPadding()");
        } else {
          stringBuilder.append(".withPadChar('");
          stringBuilder.append(this.c);
          stringBuilder.append("')");
        }  
      return stringBuilder.toString();
    }
  }
  
  class null extends OutputStream {
    int a;
    
    int b;
    
    int c;
    
    public void close() throws IOException {
      if (this.b > 0) {
        int i = this.a;
        int j = this.e.b.b;
        int k = this.b;
        int m = this.e.b.a;
        this.d.write(this.e.b.a(i << j - k & m));
        this.c++;
        if (this.e.c != null)
          while (this.c % this.e.b.c != 0) {
            this.d.write(this.e.c.charValue());
            this.c++;
          }  
      } 
      this.d.close();
    }
    
    public void flush() throws IOException {
      this.d.flush();
    }
    
    public void write(int param1Int) throws IOException {
      this.a <<= 8;
      this.a = param1Int & 0xFF | this.a;
      this.b += 8;
      while (this.b >= this.e.b.b) {
        param1Int = this.a;
        int i = this.b;
        int j = this.e.b.b;
        int k = this.e.b.a;
        this.d.write(this.e.b.a(param1Int >> i - j & k));
        this.c++;
        this.b -= this.e.b.b;
      } 
    }
  }
  
  class null extends InputStream {
    int a = 0;
    
    int b = 0;
    
    int c = 0;
    
    boolean d = false;
    
    null(BaseEncoding this$0, Reader param1Reader) {}
    
    public void close() throws IOException {
      this.e.close();
    }
    
    public int read() throws IOException {
      while (true) {
        int i = this.e.read();
        if (i == -1) {
          if (!this.d) {
            if (this.f.b.b(this.c))
              return -1; 
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("Invalid input length ");
            stringBuilder1.append(this.c);
            throw new BaseEncoding.DecodingException(stringBuilder1.toString());
          } 
          return -1;
        } 
        this.c++;
        char c = (char)i;
        if (this.f.c != null && this.f.c.charValue() == c) {
          if (this.d || (this.c != 1 && this.f.b.b(this.c - 1))) {
            this.d = true;
            continue;
          } 
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Padding cannot start at index ");
          stringBuilder1.append(this.c);
          throw new BaseEncoding.DecodingException(stringBuilder1.toString());
        } 
        if (!this.d) {
          this.a <<= this.f.b.b;
          i = this.a;
          this.a = this.f.b.a(c) | i;
          this.b += this.f.b.b;
          i = this.b;
          if (i >= 8) {
            this.b = i - 8;
            return this.a >> this.b & 0xFF;
          } 
          continue;
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected padding character but found '");
        stringBuilder.append(c);
        stringBuilder.append("' at index ");
        stringBuilder.append(this.c);
        throw new BaseEncoding.DecodingException(stringBuilder.toString());
      } 
    }
    
    public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
      int i = param1Int2 + param1Int1;
      Preconditions.a(param1Int1, i, param1ArrayOfbyte.length);
      for (param1Int2 = param1Int1; param1Int2 < i; param1Int2++) {
        int j = read();
        if (j == -1) {
          param1Int2 -= param1Int1;
          param1Int1 = param1Int2;
          if (param1Int2 == 0)
            param1Int1 = -1; 
          return param1Int1;
        } 
        param1ArrayOfbyte[param1Int2] = (byte)j;
      } 
      return param1Int2 - param1Int1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\io\BaseEncoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */