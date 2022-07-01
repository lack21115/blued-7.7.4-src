package com.soft.blued.ui.live.model;

import com.soft.blued.ui.feed.model.BluedADExtra;

public class LiveHotListDiversion extends BluedADExtra {
  public String description;
  
  public long id;
  
  public int index;
  
  public String link;
  
  public String pic;
  
  public String title;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LiveHotListDiversion{id=");
    stringBuilder.append(this.id);
    stringBuilder.append(", pic='");
    stringBuilder.append(this.pic);
    stringBuilder.append('\'');
    stringBuilder.append(", title='");
    stringBuilder.append(this.title);
    stringBuilder.append('\'');
    stringBuilder.append(", description='");
    stringBuilder.append(this.description);
    stringBuilder.append('\'');
    stringBuilder.append(", link='");
    stringBuilder.append(this.link);
    stringBuilder.append('\'');
    stringBuilder.append(", index=");
    stringBuilder.append(this.index);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\model\LiveHotListDiversion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */