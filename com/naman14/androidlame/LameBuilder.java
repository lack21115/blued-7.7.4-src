package com.naman14.androidlame;

public class LameBuilder {
  public int a = 44100;
  
  public int b = 0;
  
  public int c = 128;
  
  public int d = 2;
  
  public int e = 5;
  
  public int f = 5;
  
  public int g = 128;
  
  public int h = 0;
  
  public int i = 0;
  
  public float j = 1.0F;
  
  public Mode k = Mode.d;
  
  public VbrMode l = VbrMode.a;
  
  public String m = null;
  
  public String n = null;
  
  public String o = null;
  
  public String p = null;
  
  public String q = null;
  
  public AndroidLame a() {
    return new AndroidLame(this);
  }
  
  public LameBuilder a(int paramInt) {
    this.a = paramInt;
    return this;
  }
  
  public LameBuilder b(int paramInt) {
    this.b = paramInt;
    return this;
  }
  
  public LameBuilder c(int paramInt) {
    this.c = paramInt;
    return this;
  }
  
  public LameBuilder d(int paramInt) {
    this.d = paramInt;
    return this;
  }
  
  public enum Mode {
    a, b, c, d;
  }
  
  public enum VbrMode {
    a, b, c, d, e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\naman14\androidlame\LameBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */