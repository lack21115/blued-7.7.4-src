package com.soft.blued.ui.feed.manager;

import com.soft.blued.ui.feed.model.ChildImageInfo;
import java.util.ArrayList;
import java.util.List;

public class ChildPhotoManager {
  private static ChildPhotoManager a = new ChildPhotoManager();
  
  private List<ChildImageInfo> b = new ArrayList<ChildImageInfo>();
  
  public static ChildPhotoManager a() {
    return a;
  }
  
  public ChildImageInfo a(int paramInt) {
    try {
      return this.b.get(paramInt);
    } catch (Exception exception) {
      return new ChildImageInfo();
    } 
  }
  
  public void a(int paramInt, ChildImageInfo paramChildImageInfo) {
    this.b.add(paramInt, paramChildImageInfo);
  }
  
  public void a(List<ChildImageInfo> paramList) {
    if (paramList == null)
      return; 
    this.b.clear();
    this.b.addAll(paramList);
  }
  
  public int b() {
    return this.b.size();
  }
  
  public List<ChildImageInfo> c() {
    return this.b;
  }
  
  public void d() {
    if (this.b.size() > 0)
      this.b.clear(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\manager\ChildPhotoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */