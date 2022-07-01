package com.ss.android.socialbase.downloader.d;

import java.util.List;

public abstract class a implements t {
  private boolean a = false;
  
  public void a(List<String> paramList) {
    if (paramList != null) {
      if (paramList.isEmpty())
        return; 
      this.a = true;
    } 
  }
  
  public boolean a() {
    return this.a;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */