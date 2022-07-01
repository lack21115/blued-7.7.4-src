package com.blued.android.module.common.model;

import java.io.Serializable;

public class BaseGiftModel implements Serializable {
  public int count = 1;
  
  public String index;
  
  public boolean isSelected;
  
  public String name;
  
  public String packageIndex;
  
  public int packageTabIndex;
  
  public int pageIndex;
  
  public String pic;
  
  public String pic_apng;
  
  public String pic_dynamic;
  
  public int positionInPage;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("BaseGiftModel:[index:");
    stringBuilder.append(this.index);
    stringBuilder.append(", packageIndex:");
    stringBuilder.append(this.packageIndex);
    stringBuilder.append(", isSelected:");
    stringBuilder.append(this.isSelected);
    stringBuilder.append(", name:");
    stringBuilder.append(this.name);
    stringBuilder.append(", count:");
    stringBuilder.append(this.count);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\model\BaseGiftModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */