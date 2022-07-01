package com.soft.blued.ui.user.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

public class UserTag implements MultiItemEntity {
  public int checked;
  
  public boolean chooseable = true;
  
  public boolean enable;
  
  public String[] exclude_id;
  
  public String id;
  
  public String name;
  
  public boolean select;
  
  public List<UserTag> tagList;
  
  public int type;
  
  public UserTag() {
    this.chooseable = true;
  }
  
  public UserTag(String paramString) {
    this.name = paramString;
  }
  
  public UserTag(String paramString, int paramInt) {
    this.name = paramString;
    this.type = paramInt;
  }
  
  public UserTag(String paramString1, String paramString2) {
    this.id = paramString1;
    this.name = paramString2;
  }
  
  public UserTag(String paramString1, String paramString2, int paramInt) {
    this.id = paramString1;
    this.name = paramString2;
    this.checked = paramInt;
    this.chooseable = true;
  }
  
  public UserTag(List<UserTag> paramList) {
    this.tagList = paramList;
  }
  
  public int getItemType() {
    return this.type;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\UserTag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */