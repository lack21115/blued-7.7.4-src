package com.soft.blued.ui.live.model;

public class LiveListCommonModel {
  private boolean hasData;
  
  private boolean hasFollowData;
  
  private boolean isCanReCommend;
  
  private boolean isFooterShowing;
  
  private boolean isHeaderShowing;
  
  private boolean isRecommendShow;
  
  private boolean isTipShow;
  
  public String lastUid;
  
  private int page = 1;
  
  private int recommendPage = 0;
  
  public boolean getHasData() {
    return this.hasData;
  }
  
  public boolean getHasFollowData() {
    return this.hasFollowData;
  }
  
  public boolean getIfFooterShowing() {
    return this.isFooterShowing;
  }
  
  public boolean getIfHeaderShowing() {
    return this.isHeaderShowing;
  }
  
  public boolean getIfRecommendShow() {
    return this.isRecommendShow;
  }
  
  public boolean getIfTipShow() {
    return this.isTipShow;
  }
  
  public int getPage() {
    return this.page;
  }
  
  public int getRecommendPage() {
    return this.recommendPage;
  }
  
  public boolean isCanReCommend() {
    return this.isCanReCommend;
  }
  
  public void setCanReCommend(boolean paramBoolean) {
    this.isCanReCommend = paramBoolean;
  }
  
  public void setFooterShowing(boolean paramBoolean) {
    this.isFooterShowing = paramBoolean;
  }
  
  public void setHasData(boolean paramBoolean) {
    this.hasData = paramBoolean;
  }
  
  public void setHasFollowData(boolean paramBoolean) {
    this.hasFollowData = paramBoolean;
  }
  
  public void setHeaderShowing(boolean paramBoolean) {
    this.isHeaderShowing = paramBoolean;
  }
  
  public void setPage(int paramInt) {
    this.page = paramInt;
  }
  
  public void setRecommendPage(int paramInt) {
    this.recommendPage = paramInt;
  }
  
  public void setRecommendShow(boolean paramBoolean) {
    this.isRecommendShow = paramBoolean;
  }
  
  public void setTipShow(boolean paramBoolean) {
    this.isTipShow = paramBoolean;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\model\LiveListCommonModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */