package com.blued.android.module.live_china.presenter;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveMusicSongModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;

public class LiveMusicListPresent extends MvpPresenter {
  BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntityA<LiveMusicSongModel>>(this, g()) {
      protected void a(BluedEntityA<LiveMusicSongModel> param1BluedEntityA) {
        if (param1BluedEntityA == null)
          return; 
        if (param1BluedEntityA.data != null && LiveMusicListPresent.a(this.a) != null)
          LiveMusicListPresent.a(this.a).a("MUSIC_SHEET_SONGS", param1BluedEntityA.data); 
        if (!param1BluedEntityA.hasMore() && LiveMusicListPresent.a(this.a) != null)
          LiveMusicListPresent.a(this.a).b(); 
        if (LiveMusicListPresent.a(this.a) != null)
          LiveMusicListPresent.a(this.a).a(true); 
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        AppMethods.a(param1String);
        if (LiveMusicListPresent.b(this.a) > 1)
          LiveMusicListPresent.c(this.a); 
        if (LiveMusicListPresent.a(this.a) != null)
          LiveMusicListPresent.a(this.a).a(false); 
        return true;
      }
      
      public void onUIStart() {
        super.onUIStart();
        if (LiveMusicListPresent.a(this.a) != null)
          LiveMusicListPresent.a(this.a).a(); 
      }
    };
  
  private int i = 1;
  
  private IFetchDataListener j;
  
  private String k;
  
  private int l;
  
  private String m;
  
  private boolean n;
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onFetchData :  sheetId:");
    stringBuilder.append(this.k);
    Log.i("==abcd", stringBuilder.toString());
    this.i = 1;
    if (this.n && !TextUtils.isEmpty(this.m)) {
      d(paramIFetchDataListener);
      return;
    } 
    if (!TextUtils.isEmpty(this.k))
      c(paramIFetchDataListener); 
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean) {
    this.k = paramString;
    this.l = paramInt;
    this.n = paramBoolean;
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.i++;
    if (this.n && !TextUtils.isEmpty(this.m)) {
      d(paramIFetchDataListener);
      return;
    } 
    if (!TextUtils.isEmpty(this.k))
      c(paramIFetchDataListener); 
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    this.j = paramIFetchDataListener;
    LiveRoomHttpUtils.a(this.k, this.l, this.i, this.h);
  }
  
  public boolean c() {
    return false;
  }
  
  public void d(IFetchDataListener paramIFetchDataListener) {
    this.j = paramIFetchDataListener;
    LiveRoomHttpUtils.b(this.m, this.i, this.h);
  }
  
  public void d(String paramString) {
    this.m = paramString;
    if (TextUtils.isEmpty(paramString)) {
      a("MUSIC_SHEET_SONGS", new ArrayList());
      return;
    } 
    e();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveMusicListPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */