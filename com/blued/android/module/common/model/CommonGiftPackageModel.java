package com.blued.android.module.common.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CommonGiftPackageModel<T extends BaseGiftModel> implements Serializable {
  public boolean deleteItemIfZeroCount = false;
  
  public boolean deletePackageIfEmpty = false;
  
  public final List<T> goods = new ArrayList<T>();
  
  public int horizontalSpacing;
  
  public String index;
  
  private int line = 2;
  
  public String name;
  
  private int row = 4;
  
  public int tabIndex;
  
  public int type;
  
  public int verticalSpacing;
  
  public int getLine() {
    return this.line;
  }
  
  public int getRow() {
    return this.row;
  }
  
  public void setLine(int paramInt) {
    if (paramInt > 0)
      this.line = paramInt; 
  }
  
  public void setRow(int paramInt) {
    if (paramInt > 0)
      this.row = paramInt; 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\model\CommonGiftPackageModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */