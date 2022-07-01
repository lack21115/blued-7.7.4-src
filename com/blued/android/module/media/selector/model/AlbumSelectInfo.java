package com.blued.android.module.media.selector.model;

import com.blued.android.module.player.media.model.MediaInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AlbumSelectInfo implements Serializable {
  private List<MediaInfo> a = new ArrayList<MediaInfo>();
  
  private int b;
  
  public int a(String paramString) {
    List<MediaInfo> list = this.a;
    if (list != null) {
      Iterator<MediaInfo> iterator = list.iterator();
      while (iterator.hasNext()) {
        if (((MediaInfo)iterator.next()).imagePath.equals(paramString))
          iterator.remove(); 
      } 
      return this.a.size();
    } 
    return 0;
  }
  
  public void a() {
    b();
    this.b = 0;
  }
  
  public void a(int paramInt) {
    this.b = paramInt;
  }
  
  public void a(AlbumSelectInfo paramAlbumSelectInfo) {
    if (paramAlbumSelectInfo != null) {
      this.b = paramAlbumSelectInfo.b;
      this.a.addAll(paramAlbumSelectInfo.a);
    } 
  }
  
  public void a(List<MediaInfo> paramList) {
    this.a.clear();
    this.a.addAll(paramList);
  }
  
  public boolean a(MediaInfo paramMediaInfo) {
    List<MediaInfo> list = this.a;
    return (list != null && list.contains(paramMediaInfo));
  }
  
  public int b(MediaInfo paramMediaInfo) {
    if (!a(paramMediaInfo)) {
      List<MediaInfo> list = this.a;
      if (list != null) {
        list.add(paramMediaInfo);
        return this.a.size();
      } 
    } 
    return 0;
  }
  
  public void b() {
    List<MediaInfo> list = this.a;
    if (list != null)
      list.clear(); 
  }
  
  public List<MediaInfo> c() {
    return this.a;
  }
  
  public int d() {
    List<MediaInfo> list = this.a;
    return (list != null) ? list.size() : 0;
  }
  
  public int e() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selector\model\AlbumSelectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */