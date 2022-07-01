package com.amap.api.mapcore2d;

public class dd extends df {
  dd() {}
  
  public dd(df paramdf) {
    super(paramdf);
  }
  
  protected byte[] a(byte[] paramArrayOfbyte) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(db.a(paramArrayOfbyte));
    stringBuilder.append("||");
    stringBuilder.append(1);
    return db.a(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\dd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */