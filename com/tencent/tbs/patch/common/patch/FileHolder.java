package com.tencent.tbs.patch.common.patch;

import com.tencent.tbs.patch.common.util.DigestProcessor;
import java.io.File;

public final class FileHolder implements Comparable<FileHolder> {
  private String a;
  
  private DeltaFormat b;
  
  private String c;
  
  private String d;
  
  public long length;
  
  public FileHolder(String paramString1, String paramString2) {
    this(paramString1, paramString2, DeltaFormat.typeOf(paramString2));
  }
  
  public FileHolder(String paramString1, String paramString2, DeltaFormat paramDeltaFormat) {
    this.c = paramString1;
    this.d = paramString2;
    this.length = (new File(this.d)).length();
    this.a = DigestProcessor.getInstance().calcDigest(new File(paramString2));
    this.b = paramDeltaFormat;
  }
  
  public int compareTo(FileHolder paramFileHolder) {
    if (paramFileHolder == null)
      return 1; 
    String str = paramFileHolder.a;
    return (str == null) ? 1 : this.a.compareTo(str);
  }
  
  public String getDigest() {
    return this.a;
  }
  
  public DeltaFormat getFormat() {
    return this.b;
  }
  
  public long getLength() {
    return this.length;
  }
  
  public String getName() {
    return this.c;
  }
  
  public String getPath() {
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\patch\FileHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */