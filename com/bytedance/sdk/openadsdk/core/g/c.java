package com.bytedance.sdk.openadsdk.core.g;

import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.utils.k;
import java.io.File;
import java.util.List;

public class c extends c {
  public c(int paramInt1, int paramInt2) {
    super(paramInt1, paramInt2);
  }
  
  public void a(List<File> paramList) {
    int i = paramList.size();
    if (!a(0L, i))
      for (File file : paramList) {
        k.c(file);
        int j = i - 1;
        i = j;
        if (a(file, 0L, j))
          break; 
      }  
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\g\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */