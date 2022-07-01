package com.soft.blued.ui.group.model;

public class BluedGroupTypeGridItem extends BluedGroupTypeTags {
  private String name;
  
  private String tags;
  
  private int type;
  
  public BluedGroupTypeGridItem(int paramInt, String paramString1, String paramString2) {
    this.type = paramInt;
    this.tags = paramString1;
    this.name = paramString2;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getTags() {
    return this.tags;
  }
  
  public int getType() {
    return this.type;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public void setTags(String paramString) {
    this.tags = paramString;
  }
  
  public void setType(int paramInt) {
    this.type = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\model\BluedGroupTypeGridItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */