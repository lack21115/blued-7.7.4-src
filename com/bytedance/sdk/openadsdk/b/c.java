package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.util.List;

public class c extends b {
  private int a = 15;
  
  private int b = 3;
  
  public c(int paramInt1, int paramInt2) {
    if (paramInt1 > 0) {
      this.a = paramInt1;
      this.b = paramInt2;
      return;
    } 
    throw new IllegalArgumentException("Max count must be positive number!");
  }
  
  protected void a(List<File> paramList) {
    long l = b(paramList);
    int i = paramList.size();
    if (!a(l, i))
      for (File file : paramList) {
        int j;
        long l1 = file.length();
        if (file.delete()) {
          j = i - 1;
          l1 = l - l1;
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Cache file ");
          stringBuilder.append(file);
          stringBuilder.append(" is deleted because it exceeds cache limit");
          t.c("TotalCountLruDiskFile", stringBuilder.toString());
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Error deleting file ");
          stringBuilder.append(file);
          stringBuilder.append(" for trimming cache");
          t.c("TotalCountLruDiskFile", stringBuilder.toString());
          j = i;
          l1 = l;
        } 
        l = l1;
        i = j;
        if (a(file, l1, j))
          break; 
      }  
  }
  
  protected boolean a(long paramLong, int paramInt) {
    return (paramInt <= this.a);
  }
  
  protected boolean a(File paramFile, long paramLong, int paramInt) {
    return (paramInt <= this.b);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */