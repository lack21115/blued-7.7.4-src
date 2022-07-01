package com.tencent.bugly.proguard;

public final class am extends k implements Cloneable {
  private static byte[] d;
  
  private byte a = 0;
  
  private String b = "";
  
  private byte[] c = null;
  
  public am() {}
  
  public am(byte paramByte, String paramString, byte[] paramArrayOfbyte) {
    this.a = paramByte;
    this.b = paramString;
    this.c = paramArrayOfbyte;
  }
  
  public final void a(i parami) {
    this.a = parami.a(this.a, 0, true);
    this.b = parami.b(1, true);
    if (d == null) {
      byte[] arrayOfByte1 = new byte[1];
      d = arrayOfByte1;
      arrayOfByte1[0] = 0;
    } 
    byte[] arrayOfByte = d;
    this.c = parami.c(2, false);
  }
  
  public final void a(j paramj) {
    paramj.a(this.a, 0);
    paramj.a(this.b, 1);
    byte[] arrayOfByte = this.c;
    if (arrayOfByte != null)
      paramj.a(arrayOfByte, 2); 
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\bugly\proguard\am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */