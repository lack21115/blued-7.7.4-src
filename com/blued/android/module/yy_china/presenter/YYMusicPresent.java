package com.blued.android.module.yy_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.live.base.music.LiveMusicPresent;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live.base.music.model.LiveMusicSheetModel;
import com.blued.android.module.live.base.music.model.LiveMusicSheetModelExtra;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.ArrayList;

public class YYMusicPresent extends LiveMusicPresent {
  private String h = "";
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5) {
    YYRoomHttpUtils.k(paramString2, new BluedUIHttpResponse<BluedEntityA<LiveMusicModel>>(this, g(), paramString1, paramString3, paramString4, paramLong, paramString5) {
          protected void a(BluedEntityA<LiveMusicModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (!param1BluedEntityA.hasData())
                return; 
              LiveMusicModel liveMusicModel = (LiveMusicModel)param1BluedEntityA.getSingleData();
              if (liveMusicModel == null)
                return; 
              liveMusicModel.sheet_id = this.a;
              liveMusicModel.name = this.b;
              liveMusicModel.artist = this.c;
              liveMusicModel.duration = this.d;
              liveMusicModel.cover = this.e;
              this.f.a("yy_music_info", liveMusicModel, false);
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
        }g());
  }
  
  public void m() {
    YYRoomHttpUtils.d(new BluedUIHttpResponse<BluedEntity<LiveMusicSheetModel, LiveMusicSheetModelExtra>>(this, g()) {
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a.a("LIVE_MUSIC_SHEET", new ArrayList());
            AppMethods.a(param1String);
            this.a.b("LIVE_MUSIC_SHEET", false);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.e_("LIVE_MUSIC_SHEET");
          }
          
          public void onUIUpdate(BluedEntity<LiveMusicSheetModel, LiveMusicSheetModelExtra> param1BluedEntity) {
            if (param1BluedEntity != null) {
              if (param1BluedEntity.extra != null)
                YYMusicPresent.a(this.a, ((LiveMusicSheetModelExtra)param1BluedEntity.extra).collect_sheet_id); 
              this.a.a("LIVE_MUSIC_SHEET", param1BluedEntity.data);
            } else {
              this.a.a("LIVE_MUSIC_SHEET", new ArrayList());
            } 
            this.a.b("LIVE_MUSIC_SHEET", true);
          }
        }g());
  }
  
  public String n() {
    return this.h;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\presenter\YYMusicPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */