package com.soft.blued.ui.feed.model;

import com.blued.android.core.BlueAppLocal;
import java.io.Serializable;

public class TopicCategory implements Serializable {
  public String cid;
  
  public String name;
  
  public String name_en_us;
  
  public String name_zh_tw;
  
  public String timestamp;
  
  public String getCategoryName() {
    return BlueAppLocal.d() ? ("CN".equals(BlueAppLocal.c().getCountry().toUpperCase()) ? this.name : this.name_zh_tw) : this.name_en_us;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\model\TopicCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */