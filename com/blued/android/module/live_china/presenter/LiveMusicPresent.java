package com.blued.android.module.live_china.presenter;

import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.model.LiveMusicSheetModel;
import com.blued.android.module.live_china.model.LiveMusicSheetModelExtra;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;

public class LiveMusicPresent extends MvpPresenter {
  private String h;
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    n();
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {}
  
  public String m() {
    return this.h;
  }
  
  public void n() {
    LiveRoomHttpUtils.q(new BluedUIHttpResponse<BluedEntity<LiveMusicSheetModel, LiveMusicSheetModelExtra>>(this, g()) {
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
                LiveMusicPresent.a(this.a, ((LiveMusicSheetModelExtra)param1BluedEntity.extra).collect_sheet_id); 
              this.a.a("LIVE_MUSIC_SHEET", param1BluedEntity.data);
            } else {
              this.a.a("LIVE_MUSIC_SHEET", new ArrayList());
            } 
            this.a.b("LIVE_MUSIC_SHEET", true);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveMusicPresent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */