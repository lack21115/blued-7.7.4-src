package com.soft.blued.ui.group.model;

import java.util.List;

public class BluedGroupTypeTags {
  private List<GroupsClassify> classify;
  
  private GroupsRecommend recommend;
  
  public List<GroupsClassify> getClassify() {
    return this.classify;
  }
  
  public GroupsRecommend getRecommend() {
    return this.recommend;
  }
  
  public void setClassify(List<GroupsClassify> paramList) {
    this.classify = paramList;
  }
  
  public void setRecommend(GroupsRecommend paramGroupsRecommend) {
    this.recommend = paramGroupsRecommend;
  }
  
  public static class GroupsClassify {
    private List<String> item;
    
    private String name;
    
    private int type;
    
    public List<String> getItem() {
      return this.item;
    }
    
    public String getName() {
      return this.name;
    }
    
    public int getType() {
      return this.type;
    }
    
    public void setItem(List<String> param1List) {
      this.item = param1List;
    }
    
    public void setName(String param1String) {
      this.name = param1String;
    }
    
    public void setType(int param1Int) {
      this.type = param1Int;
    }
  }
  
  public static class GroupsRecommend extends GroupsClassify {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\group\model\BluedGroupTypeTags.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */