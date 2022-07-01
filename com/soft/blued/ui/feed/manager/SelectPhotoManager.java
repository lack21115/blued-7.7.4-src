package com.soft.blued.ui.feed.manager;

import com.soft.blued.ui.feed.model.ChildImageInfo;
import java.util.ArrayList;
import java.util.List;

public class SelectPhotoManager {
  private static SelectPhotoManager a = new SelectPhotoManager();
  
  private List<ChildImageInfo> b = new ArrayList<ChildImageInfo>();
  
  public static SelectPhotoManager a() {
    return a;
  }
  
  public ChildImageInfo a(int paramInt) {
    return (paramInt >= 0 && paramInt < this.b.size()) ? this.b.get(paramInt) : new ChildImageInfo();
  }
  
  public void a(ChildImageInfo paramChildImageInfo) {
    this.b.add(paramChildImageInfo);
  }
  
  public void a(String paramString) {
    for (int i = 0; i < this.b.size(); i++) {
      if (paramString.equals(((ChildImageInfo)this.b.get(i)).mImagePath)) {
        this.b.remove(i);
        return;
      } 
    } 
  }
  
  public int b() {
    return this.b.size();
  }
  
  public void b(ChildImageInfo paramChildImageInfo) {
    if (!this.b.remove(paramChildImageInfo))
      for (int i = 0; i < this.b.size(); i++) {
        if (paramChildImageInfo.mImagePath.equals(((ChildImageInfo)this.b.get(i)).mImagePath)) {
          this.b.remove(i);
          return;
        } 
      }  
  }
  
  public List<ChildImageInfo> c() {
    return this.b;
  }
  
  public void d() {
    if (this.b.size() > 0)
      this.b.clear(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\manager\SelectPhotoManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */