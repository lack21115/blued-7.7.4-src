package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Escapers {
  private static final Escaper a = new CharEscaper() {
      public String a(String param1String) {
        return (String)Preconditions.a(param1String);
      }
      
      protected char[] a(char param1Char) {
        return null;
      }
    };
  
  public static Builder a() {
    return new Builder();
  }
  
  public static final class Builder {
    private final Map<Character, String> a = new HashMap<Character, String>();
    
    private char b = Character.MIN_VALUE;
    
    private char c = Character.MAX_VALUE;
    
    private String d = null;
    
    private Builder() {}
    
    public Escaper a() {
      return new ArrayBasedCharEscaper(this, this.a, this.b, this.c) {
          private final char[] b;
          
          protected char[] b(char param2Char) {
            return this.b;
          }
        };
    }
    
    public Builder a(char param1Char1, char param1Char2) {
      this.b = param1Char1;
      this.c = param1Char2;
      return this;
    }
    
    public Builder a(char param1Char, String param1String) {
      Preconditions.a(param1String);
      this.a.put(Character.valueOf(param1Char), param1String);
      return this;
    }
    
    public Builder a(@NullableDecl String param1String) {
      this.d = param1String;
      return this;
    }
  }
  
  class null extends ArrayBasedCharEscaper {
    private final char[] b;
    
    null(Escapers this$0, Map<Character, String> param1Map, char param1Char1, char param1Char2) {
      super(param1Map, param1Char1, param1Char2);
      if (Escapers.Builder.a(this.a) != null) {
        char[] arrayOfChar = Escapers.Builder.a(this.a).toCharArray();
      } else {
        this$0 = null;
      } 
      this.b = (char[])this$0;
    }
    
    protected char[] b(char param1Char) {
      return this.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\common\escape\Escapers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */