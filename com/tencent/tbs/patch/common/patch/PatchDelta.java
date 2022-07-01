package com.tencent.tbs.patch.common.patch;

public class PatchDelta {
  private long a;
  
  private long b;
  
  private String c;
  
  private String d;
  
  private PatchStatus e;
  
  private DeltaFormat f;
  
  public String getDataDigest() {
    return this.c;
  }
  
  public long getDeltaLength() {
    return this.b;
  }
  
  public DeltaFormat getFormat() {
    return this.f;
  }
  
  public long getLastModified() {
    return this.a;
  }
  
  public String getName() {
    return this.d;
  }
  
  public PatchStatus getStatus() {
    return this.e;
  }
  
  public void setDataDigest(String paramString) {
    this.c = paramString;
  }
  
  public void setDeltaLength(long paramLong) {
    this.b = paramLong;
  }
  
  public void setFormat(DeltaFormat paramDeltaFormat) {
    this.f = paramDeltaFormat;
  }
  
  public void setLastModified(long paramLong) {
    this.a = paramLong;
  }
  
  public void setName(String paramString) {
    this.d = paramString;
  }
  
  public void setStatus(PatchStatus paramPatchStatus) {
    this.e = paramPatchStatus;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\patch\PatchDelta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */