package com.bytedance.sdk.openadsdk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class FilterWord {
  private String a;
  
  private String b;
  
  private boolean c;
  
  private List<FilterWord> d;
  
  public void addOption(FilterWord paramFilterWord) {
    if (paramFilterWord == null)
      return; 
    if (this.d == null)
      this.d = new ArrayList<FilterWord>(); 
    this.d.add(paramFilterWord);
  }
  
  public String getId() {
    return this.a;
  }
  
  public boolean getIsSelected() {
    return this.c;
  }
  
  public String getName() {
    return this.b;
  }
  
  public List<FilterWord> getOptions() {
    return this.d;
  }
  
  public boolean hasSecondOptions() {
    List<FilterWord> list = this.d;
    return (list != null && !list.isEmpty());
  }
  
  public boolean isValid() {
    return (!TextUtils.isEmpty(this.a) && !TextUtils.isEmpty(this.b));
  }
  
  public void setId(String paramString) {
    this.a = paramString;
  }
  
  public void setIsSelected(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public void setName(String paramString) {
    this.b = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\FilterWord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */