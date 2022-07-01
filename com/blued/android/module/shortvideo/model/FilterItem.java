package com.blued.android.module.shortvideo.model;

import com.blued.android.module.external_sense_library.config.BluedFilterType;
import java.io.Serializable;

public class FilterItem implements Serializable {
  public BluedFilterType.FILER a;
  
  public int b = -1;
  
  public int c = -1;
  
  public FilterItem(BluedFilterType.FILER paramFILER, int paramInt1, int paramInt2) {
    this.a = paramFILER;
    this.c = paramInt1;
    this.b = paramInt2;
  }
  
  public int a() {
    return this.b;
  }
  
  public BluedFilterType.FILER b() {
    return this.a;
  }
  
  public int c() {
    return this.c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\model\FilterItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */