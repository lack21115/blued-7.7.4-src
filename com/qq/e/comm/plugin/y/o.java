package com.qq.e.comm.plugin.y;

class o implements n {
  private int a;
  
  private long b;
  
  private String c;
  
  o(int paramInt, String paramString) {
    this.a = paramInt;
    this.c = paramString;
    this.b = -1L;
  }
  
  o(String paramString, long paramLong) {
    this.a = -1;
    this.b = paramLong;
    this.c = paramString;
  }
  
  public int a() {
    return this.a;
  }
  
  public String b() {
    return this.c;
  }
  
  public long c() {
    return this.b;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName());
    stringBuilder.append("{");
    stringBuilder.append("id=");
    stringBuilder.append(this.a);
    stringBuilder.append(", time=");
    stringBuilder.append(this.b);
    stringBuilder.append(", content='");
    stringBuilder.append(this.c);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\y\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */