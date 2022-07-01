package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.l;
import com.ss.android.socialbase.downloader.m.f;

public class i implements l {
  public int a(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString1)) {
      if (TextUtils.isEmpty(paramString2))
        return 0; 
      paramString1 = f.d(String.format("%s_%s", new Object[] { paramString1, paramString2 }));
      return TextUtils.isEmpty(paramString1) ? 0 : paramString1.hashCode();
    } 
    return 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\impls\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */