package com.google.common.base;

import java.util.Arrays;
import java.util.BitSet;

public abstract class CharMatcher implements Predicate<Character> {
  public static CharMatcher a() {
    return Any.a;
  }
  
  public static CharMatcher a(char paramChar) {
    return new Is(paramChar);
  }
  
  public static CharMatcher a(char paramChar1, char paramChar2) {
    return new InRange(paramChar1, paramChar2);
  }
  
  public static CharMatcher a(CharSequence paramCharSequence) {
    int i = paramCharSequence.length();
    return (CharMatcher)((i != 0) ? ((i != 1) ? ((i != 2) ? new AnyOf(paramCharSequence) : b(paramCharSequence.charAt(0), paramCharSequence.charAt(1))) : a(paramCharSequence.charAt(0))) : b());
  }
  
  private static IsEither b(char paramChar1, char paramChar2) {
    return new IsEither(paramChar1, paramChar2);
  }
  
  public static CharMatcher b() {
    return None.a;
  }
  
  public static CharMatcher b(char paramChar) {
    return new IsNot(paramChar);
  }
  
  public static CharMatcher b(CharSequence paramCharSequence) {
    return a(paramCharSequence).f();
  }
  
  public static CharMatcher c() {
    return Whitespace.b;
  }
  
  public static CharMatcher d() {
    return Ascii.a;
  }
  
  public static CharMatcher e() {
    return JavaIsoControl.a;
  }
  
  private static String e(char paramChar) {
    char[] arrayOfChar = new char[6];
    arrayOfChar[0] = '\\';
    arrayOfChar[1] = 'u';
    arrayOfChar[2] = Character.MIN_VALUE;
    arrayOfChar[3] = Character.MIN_VALUE;
    arrayOfChar[4] = Character.MIN_VALUE;
    arrayOfChar[5] = Character.MIN_VALUE;
    boolean bool = false;
    char c = paramChar;
    paramChar = bool;
    while (paramChar < '\004') {
      arrayOfChar[5 - paramChar] = "0123456789ABCDEF".charAt(c & 0xF);
      c = (char)(c >> 4);
      int i = paramChar + 1;
    } 
    return String.copyValueOf(arrayOfChar);
  }
  
  public int a(CharSequence paramCharSequence, int paramInt) {
    int i = paramCharSequence.length();
    Preconditions.b(paramInt, i);
    while (paramInt < i) {
      if (c(paramCharSequence.charAt(paramInt)))
        return paramInt; 
      paramInt++;
    } 
    return -1;
  }
  
  public CharMatcher a(CharMatcher paramCharMatcher) {
    return new And(this, paramCharMatcher);
  }
  
  @Deprecated
  public boolean a(Character paramCharacter) {
    return c(paramCharacter.charValue());
  }
  
  public CharMatcher b(CharMatcher paramCharMatcher) {
    return new Or(this, paramCharMatcher);
  }
  
  public abstract boolean c(char paramChar);
  
  public boolean c(CharSequence paramCharSequence) {
    for (int i = paramCharSequence.length() - 1; i >= 0; i--) {
      if (!c(paramCharSequence.charAt(i)))
        return false; 
    } 
    return true;
  }
  
  public boolean d(CharSequence paramCharSequence) {
    return (e(paramCharSequence) == -1);
  }
  
  public int e(CharSequence paramCharSequence) {
    return a(paramCharSequence, 0);
  }
  
  public CharMatcher f() {
    return new Negated(this);
  }
  
  public String toString() {
    return super.toString();
  }
  
  static final class And extends CharMatcher {
    final CharMatcher a;
    
    final CharMatcher b;
    
    And(CharMatcher param1CharMatcher1, CharMatcher param1CharMatcher2) {
      this.a = Preconditions.<CharMatcher>a(param1CharMatcher1);
      this.b = Preconditions.<CharMatcher>a(param1CharMatcher2);
    }
    
    public boolean c(char param1Char) {
      return (this.a.c(param1Char) && this.b.c(param1Char));
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.and(");
      stringBuilder.append(this.a);
      stringBuilder.append(", ");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class Any extends NamedFastMatcher {
    static final Any a = new Any();
    
    private Any() {
      super("CharMatcher.any()");
    }
    
    public int a(CharSequence param1CharSequence, int param1Int) {
      int j = param1CharSequence.length();
      Preconditions.b(param1Int, j);
      int i = param1Int;
      if (param1Int == j)
        i = -1; 
      return i;
    }
    
    public CharMatcher a(CharMatcher param1CharMatcher) {
      return Preconditions.<CharMatcher>a(param1CharMatcher);
    }
    
    public CharMatcher b(CharMatcher param1CharMatcher) {
      Preconditions.a(param1CharMatcher);
      return this;
    }
    
    public boolean c(char param1Char) {
      return true;
    }
    
    public boolean c(CharSequence param1CharSequence) {
      Preconditions.a(param1CharSequence);
      return true;
    }
    
    public boolean d(CharSequence param1CharSequence) {
      return (param1CharSequence.length() == 0);
    }
    
    public int e(CharSequence param1CharSequence) {
      return (param1CharSequence.length() == 0) ? -1 : 0;
    }
    
    public CharMatcher f() {
      return b();
    }
  }
  
  static final class AnyOf extends CharMatcher {
    private final char[] a;
    
    public AnyOf(CharSequence param1CharSequence) {
      this.a = param1CharSequence.toString().toCharArray();
      Arrays.sort(this.a);
    }
    
    public boolean c(char param1Char) {
      return (Arrays.binarySearch(this.a, param1Char) >= 0);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("CharMatcher.anyOf(\"");
      char[] arrayOfChar = this.a;
      int j = arrayOfChar.length;
      for (int i = 0; i < j; i++)
        stringBuilder.append(CharMatcher.d(arrayOfChar[i])); 
      stringBuilder.append("\")");
      return stringBuilder.toString();
    }
  }
  
  static final class Ascii extends NamedFastMatcher {
    static final Ascii a = new Ascii();
    
    Ascii() {
      super("CharMatcher.ascii()");
    }
    
    public boolean c(char param1Char) {
      return (param1Char <= '');
    }
  }
  
  static final class BitSetMatcher extends NamedFastMatcher {
    private final BitSet a;
    
    public boolean c(char param1Char) {
      return this.a.get(param1Char);
    }
  }
  
  static final class BreakingWhitespace extends CharMatcher {
    static final CharMatcher a = new BreakingWhitespace();
    
    public boolean c(char param1Char) {
      if (param1Char != ' ' && param1Char != '' && param1Char != ' ')
        if (param1Char != ' ') {
          if (param1Char != ' ' && param1Char != '　' && param1Char != ' ' && param1Char != ' ')
            switch (param1Char) {
              default:
                return (param1Char >= ' ' && param1Char <= ' ');
              case '\t':
              case '\n':
              case '\013':
              case '\f':
              case '\r':
                break;
            }  
        } else {
          return false;
        }  
      return true;
    }
    
    public String toString() {
      return "CharMatcher.breakingWhitespace()";
    }
  }
  
  static final class Digit extends RangesMatcher {
    static final Digit a = new Digit();
    
    private Digit() {
      super("CharMatcher.digit()", g(), h());
    }
    
    private static char[] g() {
      return "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
    }
    
    private static char[] h() {
      char[] arrayOfChar = new char[37];
      for (int i = 0; i < 37; i++)
        arrayOfChar[i] = (char)("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(i) + 9); 
      return arrayOfChar;
    }
  }
  
  static abstract class FastMatcher extends CharMatcher {
    public CharMatcher f() {
      return new CharMatcher.NegatedFastMatcher(this);
    }
  }
  
  static final class ForPredicate extends CharMatcher {
    private final Predicate<? super Character> a;
    
    public boolean a(Character param1Character) {
      return this.a.a(Preconditions.a(param1Character));
    }
    
    public boolean c(char param1Char) {
      return this.a.a(Character.valueOf(param1Char));
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.forPredicate(");
      stringBuilder.append(this.a);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static final class InRange extends FastMatcher {
    private final char a;
    
    private final char b;
    
    InRange(char param1Char1, char param1Char2) {
      boolean bool;
      if (param1Char2 >= param1Char1) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool);
      this.a = param1Char1;
      this.b = param1Char2;
    }
    
    public boolean c(char param1Char) {
      return (this.a <= param1Char && param1Char <= this.b);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.inRange('");
      stringBuilder.append(CharMatcher.d(this.a));
      stringBuilder.append("', '");
      stringBuilder.append(CharMatcher.d(this.b));
      stringBuilder.append("')");
      return stringBuilder.toString();
    }
  }
  
  static final class Invisible extends RangesMatcher {
    static final Invisible a = new Invisible();
    
    private Invisible() {
      super("CharMatcher.invisible()", "\000­؀؜۝܏࣢ ᠎   ⁦　?﻿￹".toCharArray(), "  ­؅؜۝܏࣢ ᠎‏ ⁤⁯　﻿￻".toCharArray());
    }
  }
  
  static final class Is extends FastMatcher {
    private final char a;
    
    Is(char param1Char) {
      this.a = param1Char;
    }
    
    public CharMatcher a(CharMatcher param1CharMatcher) {
      return param1CharMatcher.c(this.a) ? this : b();
    }
    
    public CharMatcher b(CharMatcher param1CharMatcher) {
      return param1CharMatcher.c(this.a) ? param1CharMatcher : super.b(param1CharMatcher);
    }
    
    public boolean c(char param1Char) {
      return (param1Char == this.a);
    }
    
    public CharMatcher f() {
      return b(this.a);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.is('");
      stringBuilder.append(CharMatcher.d(this.a));
      stringBuilder.append("')");
      return stringBuilder.toString();
    }
  }
  
  static final class IsEither extends FastMatcher {
    private final char a;
    
    private final char b;
    
    IsEither(char param1Char1, char param1Char2) {
      this.a = param1Char1;
      this.b = param1Char2;
    }
    
    public boolean c(char param1Char) {
      return (param1Char == this.a || param1Char == this.b);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.anyOf(\"");
      stringBuilder.append(CharMatcher.d(this.a));
      stringBuilder.append(CharMatcher.d(this.b));
      stringBuilder.append("\")");
      return stringBuilder.toString();
    }
  }
  
  static final class IsNot extends FastMatcher {
    private final char a;
    
    IsNot(char param1Char) {
      this.a = param1Char;
    }
    
    public CharMatcher a(CharMatcher param1CharMatcher) {
      CharMatcher charMatcher = param1CharMatcher;
      if (param1CharMatcher.c(this.a))
        charMatcher = super.a(param1CharMatcher); 
      return charMatcher;
    }
    
    public CharMatcher b(CharMatcher param1CharMatcher) {
      return param1CharMatcher.c(this.a) ? a() : this;
    }
    
    public boolean c(char param1Char) {
      return (param1Char != this.a);
    }
    
    public CharMatcher f() {
      return a(this.a);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.isNot('");
      stringBuilder.append(CharMatcher.d(this.a));
      stringBuilder.append("')");
      return stringBuilder.toString();
    }
  }
  
  static final class JavaDigit extends CharMatcher {
    static final JavaDigit a = new JavaDigit();
    
    public boolean c(char param1Char) {
      return Character.isDigit(param1Char);
    }
    
    public String toString() {
      return "CharMatcher.javaDigit()";
    }
  }
  
  static final class JavaIsoControl extends NamedFastMatcher {
    static final JavaIsoControl a = new JavaIsoControl();
    
    private JavaIsoControl() {
      super("CharMatcher.javaIsoControl()");
    }
    
    public boolean c(char param1Char) {
      return (param1Char <= '\037' || (param1Char >= '' && param1Char <= ''));
    }
  }
  
  static final class JavaLetter extends CharMatcher {
    static final JavaLetter a = new JavaLetter();
    
    public boolean c(char param1Char) {
      return Character.isLetter(param1Char);
    }
    
    public String toString() {
      return "CharMatcher.javaLetter()";
    }
  }
  
  static final class JavaLetterOrDigit extends CharMatcher {
    static final JavaLetterOrDigit a = new JavaLetterOrDigit();
    
    public boolean c(char param1Char) {
      return Character.isLetterOrDigit(param1Char);
    }
    
    public String toString() {
      return "CharMatcher.javaLetterOrDigit()";
    }
  }
  
  static final class JavaLowerCase extends CharMatcher {
    static final JavaLowerCase a = new JavaLowerCase();
    
    public boolean c(char param1Char) {
      return Character.isLowerCase(param1Char);
    }
    
    public String toString() {
      return "CharMatcher.javaLowerCase()";
    }
  }
  
  static final class JavaUpperCase extends CharMatcher {
    static final JavaUpperCase a = new JavaUpperCase();
    
    public boolean c(char param1Char) {
      return Character.isUpperCase(param1Char);
    }
    
    public String toString() {
      return "CharMatcher.javaUpperCase()";
    }
  }
  
  static abstract class NamedFastMatcher extends FastMatcher {
    private final String a;
    
    NamedFastMatcher(String param1String) {
      this.a = Preconditions.<String>a(param1String);
    }
    
    public final String toString() {
      return this.a;
    }
  }
  
  static class Negated extends CharMatcher {
    final CharMatcher b;
    
    Negated(CharMatcher param1CharMatcher) {
      this.b = Preconditions.<CharMatcher>a(param1CharMatcher);
    }
    
    public boolean c(char param1Char) {
      return this.b.c(param1Char) ^ true;
    }
    
    public boolean c(CharSequence param1CharSequence) {
      return this.b.d(param1CharSequence);
    }
    
    public boolean d(CharSequence param1CharSequence) {
      return this.b.c(param1CharSequence);
    }
    
    public CharMatcher f() {
      return this.b;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.b);
      stringBuilder.append(".negate()");
      return stringBuilder.toString();
    }
  }
  
  static class NegatedFastMatcher extends Negated {
    NegatedFastMatcher(CharMatcher param1CharMatcher) {
      super(param1CharMatcher);
    }
  }
  
  static final class None extends NamedFastMatcher {
    static final None a = new None();
    
    private None() {
      super("CharMatcher.none()");
    }
    
    public int a(CharSequence param1CharSequence, int param1Int) {
      Preconditions.b(param1Int, param1CharSequence.length());
      return -1;
    }
    
    public CharMatcher a(CharMatcher param1CharMatcher) {
      Preconditions.a(param1CharMatcher);
      return this;
    }
    
    public CharMatcher b(CharMatcher param1CharMatcher) {
      return Preconditions.<CharMatcher>a(param1CharMatcher);
    }
    
    public boolean c(char param1Char) {
      return false;
    }
    
    public boolean c(CharSequence param1CharSequence) {
      return (param1CharSequence.length() == 0);
    }
    
    public boolean d(CharSequence param1CharSequence) {
      Preconditions.a(param1CharSequence);
      return true;
    }
    
    public int e(CharSequence param1CharSequence) {
      Preconditions.a(param1CharSequence);
      return -1;
    }
    
    public CharMatcher f() {
      return a();
    }
  }
  
  static final class Or extends CharMatcher {
    final CharMatcher a;
    
    final CharMatcher b;
    
    Or(CharMatcher param1CharMatcher1, CharMatcher param1CharMatcher2) {
      this.a = Preconditions.<CharMatcher>a(param1CharMatcher1);
      this.b = Preconditions.<CharMatcher>a(param1CharMatcher2);
    }
    
    public boolean c(char param1Char) {
      return (this.a.c(param1Char) || this.b.c(param1Char));
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CharMatcher.or(");
      stringBuilder.append(this.a);
      stringBuilder.append(", ");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  static class RangesMatcher extends CharMatcher {
    private final String a;
    
    private final char[] b;
    
    private final char[] c;
    
    RangesMatcher(String param1String, char[] param1ArrayOfchar1, char[] param1ArrayOfchar2) {
      boolean bool;
      this.a = param1String;
      this.b = param1ArrayOfchar1;
      this.c = param1ArrayOfchar2;
      if (param1ArrayOfchar1.length == param1ArrayOfchar2.length) {
        bool = true;
      } else {
        bool = false;
      } 
      Preconditions.a(bool);
      int i;
      for (i = 0; i < param1ArrayOfchar1.length; i = j) {
        if (param1ArrayOfchar1[i] <= param1ArrayOfchar2[i]) {
          bool = true;
        } else {
          bool = false;
        } 
        Preconditions.a(bool);
        int j = i + 1;
        if (j < param1ArrayOfchar1.length) {
          if (param1ArrayOfchar2[i] < param1ArrayOfchar1[j]) {
            bool = true;
          } else {
            bool = false;
          } 
          Preconditions.a(bool);
        } 
      } 
    }
    
    public boolean c(char param1Char) {
      int i = Arrays.binarySearch(this.b, param1Char);
      return (i >= 0) ? true : ((--i >= 0 && param1Char <= this.c[i]));
    }
    
    public String toString() {
      return this.a;
    }
  }
  
  static final class SingleWidth extends RangesMatcher {
    static final SingleWidth a = new SingleWidth();
    
    private SingleWidth() {
      super("CharMatcher.singleWidth()", "\000־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
    }
  }
  
  static final class Whitespace extends NamedFastMatcher {
    static final int a = Integer.numberOfLeadingZeros(31);
    
    static final Whitespace b = new Whitespace();
    
    Whitespace() {
      super("CharMatcher.whitespace()");
    }
    
    public boolean c(char param1Char) {
      return (" 　\r   　 \013　   　 \t     \f 　 　　 \n 　".charAt(1682554634 * param1Char >>> a) == param1Char);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\base\CharMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */