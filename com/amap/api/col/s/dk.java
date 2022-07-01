package com.amap.api.col.s;

public final class dk extends dn {
  private StringBuilder a = new StringBuilder();
  
  private boolean b = true;
  
  public dk() {}
  
  public dk(dn paramdn) {
    super(paramdn);
  }
  
  protected final byte[] a(byte[] paramArrayOfbyte) {
    paramArrayOfbyte = bs.a(this.a.toString());
    this.d = paramArrayOfbyte;
    this.b = true;
    StringBuilder stringBuilder = this.a;
    stringBuilder.delete(0, stringBuilder.length());
    return paramArrayOfbyte;
  }
  
  public final void b(byte[] paramArrayOfbyte) {
    String str = bs.a(paramArrayOfbyte);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\col\s\dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */