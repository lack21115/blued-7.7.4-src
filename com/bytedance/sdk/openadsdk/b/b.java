package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.i.c;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.t;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public abstract class b implements a {
  private File b(String paramString, File paramFile) {
    List list = k.a(paramFile);
    if (list != null && list.size() > 0)
      for (File file : list) {
        if (file != null && paramString.equals(file.getName())) {
          t.e("TTFullScreenVideoAdImpl", "datastoreGet .........get cache video....");
          return file;
        } 
      }  
    return null;
  }
  
  private void b(File paramFile) throws IOException {
    try {
      k.b(paramFile);
    } finally {
      Exception exception = null;
    } 
  }
  
  public File a(String paramString, File paramFile) throws IOException {
    return b(paramString, paramFile);
  }
  
  public void a(File paramFile) throws IOException {
    com.bytedance.sdk.openadsdk.i.b b1 = new com.bytedance.sdk.openadsdk.i.b(new a(paramFile), 1, 2);
    com.bytedance.sdk.openadsdk.i.a.a().b(new c(this, b1.a(), b1) {
          public void run() {
            this.a.run();
          }
        });
  }
  
  protected abstract void a(List<File> paramList);
  
  protected abstract boolean a(long paramLong, int paramInt);
  
  protected abstract boolean a(File paramFile, long paramLong, int paramInt);
  
  long b(List<File> paramList) {
    Iterator<File> iterator = paramList.iterator();
    long l;
    for (l = 0L; iterator.hasNext(); l += ((File)iterator.next()).length());
    return l;
  }
  
  class a implements Callable<Void> {
    private final File b;
    
    private a(b this$0, File param1File) {
      this.b = param1File;
    }
    
    public Void a() throws Exception {
      b.a(this.a, this.b);
      return null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */