package com.blued.android.module.live_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;

public class LiveActivityItemModel implements MultiItemEntity, Serializable {
  public String icon;
  
  public String id;
  
  public int page;
  
  public long rank;
  
  public String url;
  
  public int getItemType() {
    return 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveActivityItemModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */