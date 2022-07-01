package com.soft.blued.ui.feed.model;

import java.io.Serializable;
import java.util.List;

public class BluedTopic implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public String avatar;
  
  public List<BluedTopic> bluedTopicList;
  
  public String color;
  
  public String creator;
  
  public String creator_name;
  
  public String description;
  
  public boolean invalid;
  
  public boolean isShowUrlVisited = false;
  
  public int is_audited;
  
  public int is_hot;
  
  public int is_new;
  
  public String join_total;
  
  public String name;
  
  public String ranking;
  
  public String super_did;
  
  public String super_ranking;
  
  public String ticktocks_total;
  
  public String timestamp;
  
  public List<BluedIngSelfFeed> tt;
  
  public String visited_total;
  
  public BluedTopic() {}
  
  public BluedTopic(String paramString1, String paramString2) {
    this.super_did = paramString1;
    this.name = paramString2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\model\BluedTopic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */