package com.soft.blued.customview.emoji.manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Emoji implements Serializable {
  private final String a;
  
  private int b;
  
  private List<Emoji> c;
  
  private Emoji d;
  
  public Emoji(int paramInt1, int paramInt2) {
    this(paramInt1, paramInt2, new Emoji[0]);
  }
  
  public Emoji(int paramInt1, int paramInt2, Emoji... paramVarArgs) {
    this(new int[] { paramInt1 }, paramInt2, paramVarArgs);
  }
  
  public Emoji(int[] paramArrayOfint, int paramInt) {
    this(paramArrayOfint, paramInt, new Emoji[0]);
  }
  
  public Emoji(int[] paramArrayOfint, int paramInt, Emoji... paramVarArgs) {
    int i = paramArrayOfint.length;
    boolean bool = false;
    this.a = new String(paramArrayOfint, 0, i);
    this.b = paramInt;
    this.c = Arrays.asList(paramVarArgs);
    i = paramVarArgs.length;
    for (paramInt = bool; paramInt < i; paramInt++)
      (paramVarArgs[paramInt]).d = this; 
  }
  
  public String a() {
    return this.a;
  }
  
  public int b() {
    return this.b;
  }
  
  public List<Emoji> c() {
    return new ArrayList<Emoji>(this.c);
  }
  
  public int d() {
    return this.a.length();
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (paramObject != null) {
      if (getClass() != paramObject.getClass())
        return false; 
      paramObject = paramObject;
      return (this.b == ((Emoji)paramObject).b && this.a.equals(((Emoji)paramObject).a) && this.c.equals(((Emoji)paramObject).c));
    } 
    return false;
  }
  
  public int hashCode() {
    return (this.a.hashCode() * 31 + this.b) * 31 + this.c.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\manager\Emoji.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */