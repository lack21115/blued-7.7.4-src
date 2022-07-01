package com.blued.android.module.live.base.music.adapter;

import android.content.Context;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live.base.music.model.LiveMusicSongModel;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

public abstract class LiveMusicListAdapter<M extends LiveMusicSongModel> extends BaseMultiItemQuickAdapter<M, BaseViewHolder> {
  public LiveMusicEventCallBack a;
  
  private Context b;
  
  public LiveMusicListAdapter(Context paramContext) {
    super(new ArrayList());
    this.b = paramContext;
  }
  
  public int a() {
    return (n() != null) ? n().size() : 0;
  }
  
  public void a(LiveMusicEventCallBack paramLiveMusicEventCallBack) {
    this.a = paramLiveMusicEventCallBack;
  }
  
  public void a(List<M> paramList) {
    if (paramList != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("models.szie:");
      stringBuilder.append(paramList.size());
      Logger.b("==abc", new Object[] { stringBuilder.toString() });
    } 
    c(paramList);
    c(false);
  }
  
  public static interface LiveMusicEventCallBack {
    void a(LiveMusicSongModel param1LiveMusicSongModel);
    
    boolean a(String param1String);
    
    void b(LiveMusicSongModel param1LiveMusicSongModel);
    
    boolean b(String param1String);
    
    void c(LiveMusicSongModel param1LiveMusicSongModel);
    
    boolean c(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\music\adapter\LiveMusicListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */