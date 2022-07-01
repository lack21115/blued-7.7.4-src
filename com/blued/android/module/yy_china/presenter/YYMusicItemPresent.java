package com.blued.android.module.yy_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live.base.music.LiveMusicListPresent;
import com.blued.android.module.live.base.music.model.LiveMusicSongModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;

public class YYMusicItemPresent extends LiveMusicListPresent {
  BluedUIHttpResponse h = new BluedUIHttpResponse<BluedEntityA<LiveMusicSongModel>>(this, g()) {
      protected void a(BluedEntityA<LiveMusicSongModel> param1BluedEntityA) {
        if (param1BluedEntityA == null || !param1BluedEntityA.hasData()) {
          this.a.a("no_data_view", false);
          return;
        } 
        if (YYMusicItemPresent.a(this.a) == 1) {
          this.a.a("MUSIC_SHEET_SONGS", param1BluedEntityA.data, false);
        } else {
          this.a.a("MUSIC_SHEET_SONGS_ADD", param1BluedEntityA.data, false);
        } 
        if (param1BluedEntityA.hasMore()) {
          YYMusicItemPresent.b(this.a);
          this.a.a("has_more_data", false);
        } else {
          this.a.a("no_more_data", false);
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("response page = ");
        stringBuilder.append(YYMusicItemPresent.a(this.a));
        stringBuilder.append("; sheetid = ");
        stringBuilder.append(this.a.n());
        Logger.e("music", new Object[] { stringBuilder.toString() });
        this.a.a("dismiss_loading_data", false);
      }
      
      public boolean onUIFailure(int param1Int, String param1String) {
        AppMethods.a(param1String);
        this.a.a("load_data_failed", false);
        return true;
      }
      
      public void onUIStart() {
        super.onUIStart();
        this.a.a("show_loading_data", false);
      }
    };
  
  private int i = 1;
  
  public void a(int paramInt) {
    this.i = 1;
  }
  
  public void a(LiveMusicSongModel paramLiveMusicSongModel, int paramInt) {
    YYRoomHttpUtils.i(paramLiveMusicSongModel.music_id, paramInt, new BluedUIHttpResponse(this, g(), paramLiveMusicSongModel, paramInt) {
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.is_collect = this.b;
            this.c.a("MUSIC_NOTIFY_MUSIC", false);
          }
        }g());
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getSheetSong page = ");
    stringBuilder.append(this.i);
    stringBuilder.append("; sheetid = ");
    stringBuilder.append(n());
    Logger.e("music", new Object[] { stringBuilder.toString() });
    YYRoomHttpUtils.a(n(), o(), this.i, this.h);
  }
  
  public void d(IFetchDataListener paramIFetchDataListener) {
    YYRoomHttpUtils.a(m(), this.i, this.h);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\presenter\YYMusicItemPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */