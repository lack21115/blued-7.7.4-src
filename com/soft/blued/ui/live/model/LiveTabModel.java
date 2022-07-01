package com.soft.blued.ui.live.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;

public class LiveTabModel extends BluedEntityBaseExtra {
  public String default_cate;
  
  public String default_cate_id;
  
  public String icon;
  
  public String id;
  
  public String less_cate_icon;
  
  public String more_cate_icon;
  
  public String name;
  
  public boolean showNew;
  
  public int type;
  
  public int vcode;
  
  public LiveTabModel(String paramString) {
    this.name = paramString;
  }
  
  public LiveTabModel(String paramString1, String paramString2, int paramInt1, int paramInt2) {
    this.id = paramString1;
    this.name = paramString2;
    this.vcode = paramInt1;
    this.type = paramInt2;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LiveTabModel{id='");
    stringBuilder.append(this.id);
    stringBuilder.append('\'');
    stringBuilder.append(", name='");
    stringBuilder.append(this.name);
    stringBuilder.append('\'');
    stringBuilder.append(", vcode=");
    stringBuilder.append(this.vcode);
    stringBuilder.append(", type=");
    stringBuilder.append(this.type);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public void update(LiveTabModel paramLiveTabModel) {
    this.id = paramLiveTabModel.id;
    this.name = paramLiveTabModel.name;
    this.vcode = paramLiveTabModel.vcode;
    this.type = paramLiveTabModel.type;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\model\LiveTabModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */