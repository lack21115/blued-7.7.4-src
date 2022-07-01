package com.soft.blued.ui.photo.manager;

import com.soft.blued.ui.feed.observer.AlbumViewObserver;
import com.soft.blued.ui.user.model.AlbumFlow;
import java.util.List;

public class AlbumViewDataManager {
  private static AlbumViewDataManager a = new AlbumViewDataManager();
  
  private IAlbumDataListener b;
  
  private boolean c;
  
  public static AlbumViewDataManager a() {
    return a;
  }
  
  public void a(IAlbumDataListener paramIAlbumDataListener) {
    this.b = paramIAlbumDataListener;
  }
  
  public void a(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public void a(boolean paramBoolean, List<AlbumFlow> paramList) {
    this.c = paramBoolean;
    IAlbumDataListener iAlbumDataListener = this.b;
    if (iAlbumDataListener != null)
      iAlbumDataListener.a(paramBoolean, paramList); 
  }
  
  public void b() {
    this.b = null;
  }
  
  public void c() {
    IAlbumDataListener iAlbumDataListener = this.b;
    if (iAlbumDataListener != null)
      iAlbumDataListener.a(); 
  }
  
  public boolean d() {
    return this.c;
  }
  
  public void e() {
    AlbumViewObserver.a().b();
  }
  
  public static interface IAlbumDataListener {
    void a();
    
    void a(boolean param1Boolean, List<AlbumFlow> param1List);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\manager\AlbumViewDataManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */