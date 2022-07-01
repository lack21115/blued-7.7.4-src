package com.loc;

public final class bh extends bk {
  private StringBuilder a = new StringBuilder();
  
  private boolean b = true;
  
  public bh() {}
  
  public bh(bk parambk) {
    super(parambk);
  }
  
  protected final byte[] a(byte[] paramArrayOfbyte) {
    paramArrayOfbyte = u.a(this.a.toString());
    this.d = paramArrayOfbyte;
    this.b = true;
    StringBuilder stringBuilder = this.a;
    stringBuilder.delete(0, stringBuilder.length());
    return paramArrayOfbyte;
  }
  
  public final void b(byte[] paramArrayOfbyte) {
    String str = u.a(paramArrayOfbyte);
    if (this.b) {
      this.b = false;
    } else {
      this.a.append(",");
    } 
    StringBuilder stringBuilder = this.a;
    stringBuilder.append("{\"log\":\"");
    stringBuilder.append(str);
    stringBuilder.append("\"}");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\loc\bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */