package com.blued.android.module.live_china.model;

public class LiveMusicTabModel {
  public String id;
  
  public String name;
  
  public boolean selected;
  
  public LiveMusicTabModel() {}
  
  public LiveMusicTabModel(String paramString1, String paramString2) {
    this.id = paramString1;
    this.name = paramString2;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("LiveMusicTabModel{id='");
    stringBuilder.append(this.id);
    stringBuilder.append('\'');
    stringBuilder.append(", name='");
    stringBuilder.append(this.name);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveMusicTabModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */