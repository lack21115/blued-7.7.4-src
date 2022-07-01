package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

public final class Result {
  private final String a;
  
  private final byte[] b;
  
  private final int c;
  
  private ResultPoint[] d;
  
  private final BarcodeFormat e;
  
  private Map<ResultMetadataType, Object> f;
  
  private final long g;
  
  public Result(String paramString, byte[] paramArrayOfbyte, int paramInt, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat, long paramLong) {
    this.a = paramString;
    this.b = paramArrayOfbyte;
    this.c = paramInt;
    this.d = paramArrayOfResultPoint;
    this.e = paramBarcodeFormat;
    this.f = null;
    this.g = paramLong;
  }
  
  public Result(String paramString, byte[] paramArrayOfbyte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat) {
    this(paramString, paramArrayOfbyte, paramArrayOfResultPoint, paramBarcodeFormat, System.currentTimeMillis());
  }
  
  public Result(String paramString, byte[] paramArrayOfbyte, ResultPoint[] paramArrayOfResultPoint, BarcodeFormat paramBarcodeFormat, long paramLong) {
    this(paramString, paramArrayOfbyte, i, paramArrayOfResultPoint, paramBarcodeFormat, paramLong);
  }
  
  public String a() {
    return this.a;
  }
  
  public void a(ResultMetadataType paramResultMetadataType, Object paramObject) {
    if (this.f == null)
      this.f = new EnumMap<ResultMetadataType, Object>(ResultMetadataType.class); 
    this.f.put(paramResultMetadataType, paramObject);
  }
  
  public void a(Map<ResultMetadataType, Object> paramMap) {
    if (paramMap != null) {
      Map<ResultMetadataType, Object> map = this.f;
      if (map == null) {
        this.f = paramMap;
        return;
      } 
      map.putAll(paramMap);
    } 
  }
  
  public void a(ResultPoint[] paramArrayOfResultPoint) {
    ResultPoint[] arrayOfResultPoint = this.d;
    if (arrayOfResultPoint == null) {
      this.d = paramArrayOfResultPoint;
      return;
    } 
    if (paramArrayOfResultPoint != null && paramArrayOfResultPoint.length > 0) {
      ResultPoint[] arrayOfResultPoint1 = new ResultPoint[arrayOfResultPoint.length + paramArrayOfResultPoint.length];
      System.arraycopy(arrayOfResultPoint, 0, arrayOfResultPoint1, 0, arrayOfResultPoint.length);
      System.arraycopy(paramArrayOfResultPoint, 0, arrayOfResultPoint1, arrayOfResultPoint.length, paramArrayOfResultPoint.length);
      this.d = arrayOfResultPoint1;
    } 
  }
  
  public byte[] b() {
    return this.b;
  }
  
  public ResultPoint[] c() {
    return this.d;
  }
  
  public BarcodeFormat d() {
    return this.e;
  }
  
  public Map<ResultMetadataType, Object> e() {
    return this.f;
  }
  
  public String toString() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\zxing\Result.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */