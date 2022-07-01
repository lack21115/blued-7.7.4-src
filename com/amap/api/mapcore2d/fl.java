package com.amap.api.mapcore2d;

public class fl extends fo {
  private StringBuilder a = new StringBuilder();
  
  private boolean b = true;
  
  public fl() {}
  
  public fl(fo paramfo) {
    super(paramfo);
  }
  
  protected byte[] a(byte[] paramArrayOfbyte) {
    paramArrayOfbyte = db.a(this.a.toString());
    c(paramArrayOfbyte);
    this.b = true;
    StringBuilder stringBuilder = this.a;
    stringBuilder.delete(0, stringBuilder.length());
    return paramArrayOfbyte;
  }
  
  public void b(byte[] paramArrayOfbyte) {
    String str = db.a(paramArrayOfbyte);
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\fl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */