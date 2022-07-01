package com.soft.blued.ui.feed.model;

import com.soft.blued.utils.StringUtils;

public class MusicCategory {
  public int classify_id = -1;
  
  public String keyword;
  
  public String name = "";
  
  public MusicCategory(String paramString) {
    if (StringUtils.e(paramString)) {
      this.keyword = "";
      return;
    } 
    this.keyword = paramString;
  }
  
  public MusicCategory(String paramString, int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\model\MusicCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */