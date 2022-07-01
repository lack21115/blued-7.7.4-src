package com.bytedance.sdk.openadsdk.h.a;

import android.content.Context;
import com.bytedance.sdk.openadsdk.h.b.c;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.h.e;
import com.bytedance.sdk.openadsdk.h.g.d;
import java.io.File;

public class b extends a {
  public final File a;
  
  public void a() {
    d.a(new Runnable(this) {
          public void run() {
            this.a.b();
          }
        });
  }
  
  public void b() {
    d.c().d();
    Context context = e.a();
    if (context != null)
      c.a(context).a(1); 
    File[] arrayOfFile = this.a.listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    while (true) {
      if (i < j) {
        File file = arrayOfFile[i];
        try {
          file.delete();
        } finally {}
        i++;
        continue;
      } 
      return;
    } 
  }
  
  public File c(String paramString) {
    return e(paramString);
  }
  
  public File d(String paramString) {
    return e(paramString);
  }
  
  File e(String paramString) {
    return new File(this.a, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\h\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */