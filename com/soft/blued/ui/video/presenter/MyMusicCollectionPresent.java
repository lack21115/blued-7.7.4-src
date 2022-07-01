package com.soft.blued.ui.video.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.ui.video.model.VideoScanMusic;
import com.soft.blued.user.UserInfo;

public class MyMusicCollectionPresent extends MvpPresenter {
  private int h = 1;
  
  private int i = 30;
  
  private boolean j;
  
  private String k;
  
  private void c(IFetchDataListener paramIFetchDataListener) {
    if (this.h == 1)
      this.j = true; 
    if (!this.j)
      return; 
    FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<VideoScanMusic>>(this, g(), paramIFetchDataListener) {
          protected void a(BluedEntityA<VideoScanMusic> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              this.a.a("collection_list", param1BluedEntityA.data);
              MyMusicCollectionPresent.a(this.b, param1BluedEntityA.hasMore());
              return;
            } 
            MyMusicCollectionPresent.a(this.b, false);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            if (!param1Boolean && MyMusicCollectionPresent.a(this.b) != 1)
              MyMusicCollectionPresent.b(this.b); 
            if (!MyMusicCollectionPresent.c(this.b))
              this.a.b(); 
            this.a.a(param1Boolean);
          }
        }UserInfo.a().i().getUid(), this.k, this.h, this.i, g());
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.h = 1;
    c(paramIFetchDataListener);
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.h++;
    c(paramIFetchDataListener);
  }
  
  public void d(String paramString) {
    FeedHttpUtils.f(new BluedUIHttpResponse(this, g()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }paramString, g());
  }
  
  public void e(String paramString) {
    this.k = paramString;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\presenter\MyMusicCollectionPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */