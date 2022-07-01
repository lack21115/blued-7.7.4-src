package com.soft.blued.ui.notify.model;

public class ViewpointNoticeCount {
  public int circle;
  
  public int followers;
  
  public int groups;
  
  public boolean isHttp = false;
  
  public int liked;
  
  public int getSum() {
    return this.followers + this.liked + this.groups + this.circle;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\model\ViewpointNoticeCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */