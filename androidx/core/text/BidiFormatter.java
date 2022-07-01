package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

public final class BidiFormatter {
  static final TextDirectionHeuristicCompat a = TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
  
  static final BidiFormatter b;
  
  static final BidiFormatter c;
  
  private static final String d = Character.toString('‎');
  
  private static final String e = Character.toString('‏');
  
  private final boolean f;
  
  private final int g;
  
  private final TextDirectionHeuristicCompat h;
  
  static {
    b = new BidiFormatter(false, 2, a);
    c = new BidiFormatter(true, 2, a);
  }
  
  BidiFormatter(boolean paramBoolean, int paramInt, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat) {
    this.f = paramBoolean;
    this.g = paramInt;
    this.h = paramTextDirectionHeuristicCompat;
  }
  
  private static int a(CharSequence paramCharSequence) {
    return (new DirectionalityEstimator(paramCharSequence, false)).b();
  }
  
  private String a(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat) {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    return (!this.f && (bool || a(paramCharSequence) == 1)) ? d : ((this.f && (!bool || a(paramCharSequence) == -1)) ? e : "");
  }
  
  static boolean a(Locale paramLocale) {
    return (TextUtilsCompat.getLayoutDirectionFromLocale(paramLocale) == 1);
  }
  
  private static int b(CharSequence paramCharSequence) {
    return (new DirectionalityEstimator(paramCharSequence, false)).a();
  }
  
  private String b(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat) {
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    return (!this.f && (bool || b(paramCharSequence) == 1)) ? d : ((this.f && (!bool || b(paramCharSequence) == -1)) ? e : "");
  }
  
  public static BidiFormatter getInstance() {
    return (new Builder()).build();
  }
  
  public static BidiFormatter getInstance(Locale paramLocale) {
    return (new Builder(paramLocale)).build();
  }
  
  public static BidiFormatter getInstance(boolean paramBoolean) {
    return (new Builder(paramBoolean)).build();
  }
  
  public boolean getStereoReset() {
    return ((this.g & 0x2) != 0);
  }
  
  public boolean isRtl(CharSequence paramCharSequence) {
    return this.h.isRtl(paramCharSequence, 0, paramCharSequence.length());
  }
  
  public boolean isRtl(String paramString) {
    return isRtl(paramString);
  }
  
  public boolean isRtlContext() {
    return this.f;
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence) {
    return unicodeWrap(paramCharSequence, this.h, true);
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat) {
    return unicodeWrap(paramCharSequence, paramTextDirectionHeuristicCompat, true);
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean) {
    if (paramCharSequence == null)
      return null; 
    boolean bool = paramTextDirectionHeuristicCompat.isRtl(paramCharSequence, 0, paramCharSequence.length());
    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
    if (getStereoReset() && paramBoolean) {
      if (bool) {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;
      } else {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
      } 
      spannableStringBuilder.append(b(paramCharSequence, paramTextDirectionHeuristicCompat));
    } 
    if (bool != this.f) {
      char c;
      if (bool) {
        c = '‫';
      } else {
        c = '‪';
      } 
      spannableStringBuilder.append(c);
      spannableStringBuilder.append(paramCharSequence);
      spannableStringBuilder.append('‬');
    } else {
      spannableStringBuilder.append(paramCharSequence);
    } 
    if (paramBoolean) {
      if (bool) {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.RTL;
      } else {
        paramTextDirectionHeuristicCompat = TextDirectionHeuristicsCompat.LTR;
      } 
      spannableStringBuilder.append(a(paramCharSequence, paramTextDirectionHeuristicCompat));
    } 
    return (CharSequence)spannableStringBuilder;
  }
  
  public CharSequence unicodeWrap(CharSequence paramCharSequence, boolean paramBoolean) {
    return unicodeWrap(paramCharSequence, this.h, paramBoolean);
  }
  
  public String unicodeWrap(String paramString) {
    return unicodeWrap(paramString, this.h, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat) {
    return unicodeWrap(paramString, paramTextDirectionHeuristicCompat, true);
  }
  
  public String unicodeWrap(String paramString, TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat, boolean paramBoolean) {
    return (paramString == null) ? null : unicodeWrap(paramString, paramTextDirectionHeuristicCompat, paramBoolean).toString();
  }
  
  public String unicodeWrap(String paramString, boolean paramBoolean) {
    return unicodeWrap(paramString, this.h, paramBoolean);
  }
  
  public static final class Builder {
    private boolean a;
    
    private int b;
    
    private TextDirectionHeuristicCompat c;
    
    public Builder() {
      a(BidiFormatter.a(Locale.getDefault()));
    }
    
    public Builder(Locale param1Locale) {
      a(BidiFormatter.a(param1Locale));
    }
    
    public Builder(boolean param1Boolean) {
      a(param1Boolean);
    }
    
    private void a(boolean param1Boolean) {
      this.a = param1Boolean;
      this.c = BidiFormatter.a;
      this.b = 2;
    }
    
    private static BidiFormatter b(boolean param1Boolean) {
      return param1Boolean ? BidiFormatter.c : BidiFormatter.b;
    }
    
    public BidiFormatter build() {
      return (this.b == 2 && this.c == BidiFormatter.a) ? b(this.a) : new BidiFormatter(this.a, this.b, this.c);
    }
    
    public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat param1TextDirectionHeuristicCompat) {
      this.c = param1TextDirectionHeuristicCompat;
      return this;
    }
    
    public Builder stereoReset(boolean param1Boolean) {
      if (param1Boolean) {
        this.b |= 0x2;
        return this;
      } 
      this.b &= 0xFFFFFFFD;
      return this;
    }
  }
  
  static class DirectionalityEstimator {
    private static final byte[] a = new byte[1792];
    
    private final CharSequence b;
    
    private final boolean c;
    
    private final int d;
    
    private int e;
    
    private char f;
    
    static {
      for (int i = 0; i < 1792; i++)
        a[i] = Character.getDirectionality(i); 
    }
    
    DirectionalityEstimator(CharSequence param1CharSequence, boolean param1Boolean) {
      this.b = param1CharSequence;
      this.c = param1Boolean;
      this.d = param1CharSequence.length();
    }
    
    private static byte a(char param1Char) {
      return (param1Char < '܀') ? a[param1Char] : Character.getDirectionality(param1Char);
    }
    
    private byte e() {
      int i = this.e;
      label19: while (true) {
        int j = this.e;
        if (j < this.d) {
          CharSequence charSequence = this.b;
          this.e = j + 1;
          this.f = charSequence.charAt(j);
          j = this.f;
          if (j == 62)
            return 12; 
          if (j == 34 || j == 39) {
            j = this.f;
            while (true) {
              int k = this.e;
              if (k < this.d) {
                charSequence = this.b;
                this.e = k + 1;
                char c = charSequence.charAt(k);
                this.f = c;
                if (c != j)
                  continue; 
                continue label19;
              } 
              continue label19;
            } 
            break;
          } 
          continue;
        } 
        this.e = i;
        this.f = '<';
        return 13;
      } 
    }
    
    private byte f() {
      int i = this.e;
      label21: while (true) {
        int j = this.e;
        if (j > 0) {
          CharSequence charSequence = this.b;
          this.e = --j;
          this.f = charSequence.charAt(j);
          j = this.f;
          if (j == 60)
            return 12; 
          if (j == 62)
            break; 
          if (j == 34 || j == 39) {
            j = this.f;
            while (true) {
              int k = this.e;
              if (k > 0) {
                charSequence = this.b;
                this.e = --k;
                char c = charSequence.charAt(k);
                this.f = c;
                if (c != j)
                  continue; 
                continue label21;
              } 
              continue label21;
            } 
          } 
          continue;
        } 
        break;
      } 
      this.e = i;
      this.f = '>';
      return 13;
    }
    
    private byte g() {
      while (true) {
        int i = this.e;
        if (i < this.d) {
          CharSequence charSequence = this.b;
          this.e = i + 1;
          char c = charSequence.charAt(i);
          this.f = c;
          if (c != ';')
            continue; 
        } 
        break;
      } 
      return 12;
    }
    
    private byte h() {
      int i = this.e;
      while (true) {
        int j = this.e;
        if (j > 0) {
          CharSequence charSequence = this.b;
          this.e = --j;
          this.f = charSequence.charAt(j);
          j = this.f;
          if (j == 38)
            return 12; 
          if (j == 59)
            break; 
          continue;
        } 
        break;
      } 
      this.e = i;
      this.f = ';';
      return 13;
    }
    
    int a() {
      this.e = 0;
      int j = 0;
      byte b = 0;
      int i = 0;
      while (this.e < this.d && !j) {
        byte b1 = c();
        if (b1 != 0) {
          if (b1 != 1 && b1 != 2) {
            if (b1 != 9) {
              switch (b1) {
                case 18:
                  i--;
                  b = 0;
                  continue;
                case 16:
                case 17:
                  i++;
                  b = 1;
                  continue;
                case 14:
                case 15:
                  i++;
                  b = -1;
                  continue;
              } 
            } else {
              continue;
            } 
          } else if (i == 0) {
            return 1;
          } 
        } else if (i == 0) {
          return -1;
        } 
        j = i;
      } 
      if (j == 0)
        return 0; 
      if (b != 0)
        return b; 
      while (this.e > 0) {
        switch (d()) {
          default:
            continue;
          case 18:
            i++;
            continue;
          case 16:
          case 17:
            if (j == i)
              return 1; 
            break;
          case 14:
          case 15:
            if (j == i)
              return -1; 
            break;
        } 
        i--;
      } 
      return 0;
    }
    
    int b() {
      this.e = this.d;
      int j = 0;
      int i = 0;
      while (this.e > 0) {
        byte b = d();
        if (b != 0) {
          if (b != 1 && b != 2) {
            if (b != 9) {
              switch (b) {
                default:
                  if (!j)
                    break; 
                  continue;
                case 18:
                  i++;
                  continue;
                case 16:
                case 17:
                  if (j == i)
                    return 1; 
                  i--;
                  continue;
                case 14:
                case 15:
                  if (j == i)
                    return -1; 
                  i--;
                  continue;
              } 
            } else {
              continue;
            } 
            continue;
          } 
          if (i == 0)
            return 1; 
          if (j == 0)
            continue; 
          continue;
        } 
        if (i == 0)
          return -1; 
        if (j == 0)
          continue; 
        continue;
        j = i;
      } 
      return 0;
    }
    
    byte c() {
      this.f = this.b.charAt(this.e);
      if (Character.isHighSurrogate(this.f)) {
        int i = Character.codePointAt(this.b, this.e);
        this.e += Character.charCount(i);
        return Character.getDirectionality(i);
      } 
      this.e++;
      byte b1 = a(this.f);
      byte b = b1;
      if (this.c) {
        char c = this.f;
        if (c == '<')
          return e(); 
        b = b1;
        if (c == '&')
          b = g(); 
      } 
      return b;
    }
    
    byte d() {
      this.f = this.b.charAt(this.e - 1);
      if (Character.isLowSurrogate(this.f)) {
        int i = Character.codePointBefore(this.b, this.e);
        this.e -= Character.charCount(i);
        return Character.getDirectionality(i);
      } 
      this.e--;
      byte b1 = a(this.f);
      byte b = b1;
      if (this.c) {
        char c = this.f;
        if (c == '>')
          return f(); 
        b = b1;
        if (c == ';')
          b = h(); 
      } 
      return b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\text\BidiFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */