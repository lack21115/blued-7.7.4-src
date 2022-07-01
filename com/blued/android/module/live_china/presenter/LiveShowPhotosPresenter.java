package com.blued.android.module.live_china.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveUserFeedPhotoExtra;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;

public class LiveShowPhotosPresenter extends MvpPresenter {
  private int h = 1;
  
  private int i = 1;
  
  private int j = 0;
  
  private boolean k = false;
  
  private boolean l = false;
  
  private List<String> m;
  
  private List<String> n;
  
  public void a(int paramInt) {
    this.j = paramInt;
  }
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    this.m = new ArrayList<String>();
    this.m.add(paramFragmentActivity.getResources().getString(R.string.live_album));
    this.m.add(paramFragmentActivity.getResources().getString(R.string.live_posts));
    this.n = new ArrayList<String>();
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    int i = this.j;
    if (i != 0) {
      if (i != 1)
        return; 
      this.i = 1;
      this.n.clear();
      d(paramIFetchDataListener);
      return;
    } 
    this.h = 1;
    c(paramIFetchDataListener);
  }
  
  public void b(int paramInt) {
    a(paramInt);
    paramInt = this.j;
    if (paramInt != 0) {
      if (paramInt != 1)
        return; 
      if (this.n.isEmpty()) {
        e();
        return;
      } 
      a("changed_folder_name", this.n, false);
      return;
    } 
    e();
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    int i = this.j;
    if (i != 0) {
      if (i != 1)
        return; 
      d(paramIFetchDataListener);
      return;
    } 
    c(paramIFetchDataListener);
  }
  
  public void c(IFetchDataListener paramIFetchDataListener) {
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<String>>(this, g(), paramIFetchDataListener) {
          protected void a(BluedEntityA<String> param1BluedEntityA) {
            if (param1BluedEntityA == null || param1BluedEntityA.data == null || param1BluedEntityA.data.isEmpty()) {
              LiveShowPhotosPresenter.a(this.b, false);
              return;
            } 
            this.a.a("album_data_list", param1BluedEntityA.data);
            LiveShowPhotosPresenter.a(this.b, param1BluedEntityA.hasMore());
            if (LiveShowPhotosPresenter.a(this.b))
              LiveShowPhotosPresenter.b(this.b); 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            LiveShowPhotosPresenter.a(this.b, false);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (!LiveShowPhotosPresenter.a(this.b))
              this.a.b(); 
            this.a.a(param1Boolean);
          }
        }this.h, g());
  }
  
  public void d(IFetchDataListener paramIFetchDataListener) {
    LiveRoomHttpUtils.b(new BluedUIHttpResponse<BluedEntity<String, LiveUserFeedPhotoExtra>>(this, g(), paramIFetchDataListener) {
          public boolean onUIFailure(int param1Int, String param1String) {
            LiveShowPhotosPresenter.b(this.b, false);
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (!LiveShowPhotosPresenter.d(this.b))
              this.a.b(); 
            this.a.a(param1Boolean);
          }
          
          public void onUIUpdate(BluedEntity<String, LiveUserFeedPhotoExtra> param1BluedEntity) {
            boolean bool = false;
            if (param1BluedEntity == null || param1BluedEntity.data == null || param1BluedEntity.data.isEmpty()) {
              LiveShowPhotosPresenter.b(this.b, false);
              return;
            } 
            LiveShowPhotosPresenter.c(this.b).addAll(param1BluedEntity.data);
            this.a.a("feed_data_list", param1BluedEntity.data);
            if (param1BluedEntity.extra == null) {
              LiveShowPhotosPresenter.b(this.b, false);
            } else {
              LiveShowPhotosPresenter liveShowPhotosPresenter = this.b;
              if (((LiveUserFeedPhotoExtra)param1BluedEntity.extra).has_more == 1)
                bool = true; 
              LiveShowPhotosPresenter.b(liveShowPhotosPresenter, bool);
            } 
            if (LiveShowPhotosPresenter.d(this.b))
              LiveShowPhotosPresenter.e(this.b); 
          }
        }this.i, g());
  }
  
  public List<String> m() {
    return this.m;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\presenter\LiveShowPhotosPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */