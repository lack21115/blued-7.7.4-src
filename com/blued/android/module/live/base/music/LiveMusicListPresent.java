package com.blued.android.module.live.base.music;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live.base.music.model.LiveMusicSongModel;
import java.util.ArrayList;

public abstract class LiveMusicListPresent extends MvpPresenter {
  private String h;
  
  private int i;
  
  private String j;
  
  private boolean k;
  
  public abstract void a(int paramInt);
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onFetchData :  sheetId:");
    stringBuilder.append(this.h);
    Log.i("==abcd", stringBuilder.toString());
    a(1);
    if (this.k && !TextUtils.isEmpty(this.j)) {
      d(paramIFetchDataListener);
      return;
    } 
    if (!TextUtils.isEmpty(this.h))
      c(paramIFetchDataListener); 
  }
  
  public abstract void a(LiveMusicSongModel paramLiveMusicSongModel, int paramInt);
  
  public void a(String paramString, int paramInt, boolean paramBoolean) {
    this.h = paramString;
    this.i = paramInt;
    this.k = paramBoolean;
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    if (this.k && !TextUtils.isEmpty(this.j)) {
      d(paramIFetchDataListener);
      return;
    } 
    if (!TextUtils.isEmpty(this.h))
      c(paramIFetchDataListener); 
  }
  
  public abstract void c(IFetchDataListener paramIFetchDataListener);
  
  public boolean c() {
    return false;
  }
  
  public abstract void d(IFetchDataListener paramIFetchDataListener);
  
  public void d(String paramString) {
    this.j = paramString;
    if (TextUtils.isEmpty(paramString)) {
      a("MUSIC_SHEET_SONGS", new ArrayList());
      return;
    } 
    e();
  }
  
  public String m() {
    return this.j;
  }
  
  public String n() {
    return this.h;
  }
  
  public int o() {
    return this.i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\music\LiveMusicListPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */