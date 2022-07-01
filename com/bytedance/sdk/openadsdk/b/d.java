package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class d extends b {
  protected long a = 83886080L;
  
  public File a(String paramString, File paramFile) throws IOException {
    return null;
  }
  
  public void a(List<File> paramList) {
    long l = b(paramList);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("当前缓存文件的总size：");
    stringBuilder.append(l / 1024L / 1024L);
    stringBuilder.append("MB");
    t.c("TotalSizeLruDiskUsage", stringBuilder.toString());
    int i = paramList.size();
    boolean bool = a(l, i);
    if (bool) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("不满足删除条件，不执行删除操作(true)");
      stringBuilder.append(bool);
      t.c("TotalSizeLruDiskUsage", stringBuilder.toString());
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("满足删除条件，开始执行删除操作(false)");
      stringBuilder.append(bool);
      t.c("TotalSizeLruDiskUsage", stringBuilder.toString());
    } 
    Iterator<File> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      File file = iterator.next();
      if (!bool) {
        t.c("TotalSizeLruDiskUsage", "满足删除条件开始删除文件......................");
        long l1 = file.length();
        if (file.delete()) {
          i--;
          l1 = l - l1;
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("删除 一个 Cache file 当前总大小totalSize：");
          stringBuilder1.append(l1 / 1024L / 1024L);
          stringBuilder1.append("MB");
          t.c("TotalSizeLruDiskUsage", stringBuilder1.toString());
        } else {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("Error deleting file ");
          stringBuilder1.append(file);
          stringBuilder1.append(" for trimming cache");
          t.e("TotalSizeLruDiskUsage", stringBuilder1.toString());
          l1 = l;
        } 
        boolean bool1 = a(file, l1, i);
        l = l1;
        if (bool1) {
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("当前总大小totalSize：");
          stringBuilder1.append(l1 / 1024L / 1024L);
          stringBuilder1.append("MB，最大值存储上限maxSize=");
          stringBuilder1.append(this.a / 1024L / 1024L);
          stringBuilder1.append("MB，当前文件的总大小totalSize已小于等于maxSize一半，停止删除操作：minStopDeleteCondition=");
          stringBuilder1.append(bool1);
          t.c("TotalSizeLruDiskUsage", stringBuilder1.toString());
          break;
        } 
      } 
    } 
  }
  
  protected boolean a(long paramLong, int paramInt) {
    return (paramLong < this.a);
  }
  
  protected boolean a(File paramFile, long paramLong, int paramInt) {
    return (paramLong < this.a / 2L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */