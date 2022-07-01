package com.soft.blued.ui.live.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.log.trackUtils.EventTrackLive;
import com.soft.blued.ui.live.LiveRoomInfoChannel;
import com.soft.blued.ui.live.model.LiveTwoFloorModel;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.StringUtils;
import java.io.Serializable;

public class LiveTwoLevelFragment extends BaseFragment {
  private View d;
  
  private ImageView e;
  
  private LiveTwoFloorModel f;
  
  private String g = "two_floor_live";
  
  private LoadOptions h = null;
  
  private Observer<String> i = new Observer<String>(this) {
      public void a(String param1String) {
        Log.i("xpm", "LiveTwoLevelFragment  KEY_EVENT_BACK_TWO_LEVEL ... ");
        this.a.a(new Runnable(this) {
              public void run() {
                LiveTwoLevelFragment.a(this.a.a);
              }
            },  300L);
      }
    };
  
  public static void a(Context paramContext, String paramString, LiveTwoFloorModel paramLiveTwoFloorModel) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("liveTwoFloorModel", (Serializable)paramLiveTwoFloorModel);
    bundle.putString("from_page", paramString);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    TerminalActivity.d(paramContext, LiveTwoLevelFragment.class, bundle);
  }
  
  private void k() {
    getActivity().finish();
  }
  
  public void a() {
    LiveTwoFloorModel liveTwoFloorModel = this.f;
    if (liveTwoFloorModel != null && StringUtils.a(liveTwoFloorModel.lid, 0) > 0) {
      boolean bool;
      String str1;
      String str2;
      EventTrackLive.b(LiveProtos.Event.LIVE_HOME_REFRESH_LIVE_ENTER, this.f.lid, this.f.uid, this.f.id);
      long l = StringUtils.a(this.f.lid, 0L);
      if (this.f.anchor != null) {
        str1 = this.f.anchor.name;
        str2 = this.f.anchor.avatar;
        bool = this.f.anchor.vbadge;
      } else {
        str1 = "";
        str2 = str1;
        bool = false;
      } 
      LiveRoomData liveRoomData = new LiveRoomData(l, this.f.screen_pattern, this.g, this.f.uid, str1, str2, bool);
      liveRoomData.live_url = this.f.live_play;
      LiveRoomInfoChannel.a(getContext(), liveRoomData);
      return;
    } 
    k();
  }
  
  public void onCreate(Bundle paramBundle) {
    ActivityChangeAnimationUtils.b((Activity)getActivity());
    this.h = new LoadOptions();
    LoadOptions loadOptions = this.h;
    loadOptions.d = 2131234356;
    loadOptions.b = 2131234356;
    if (getArguments() != null) {
      this.f = (LiveTwoFloorModel)getArguments().getSerializable("liveTwoFloorModel");
      this.g = getArguments().getString("from_page", "two_floor_live");
    } 
    if (this.f == null)
      k(); 
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    View view = this.d;
    if (view == null) {
      LiveEventBus.get("live_back_to_two_level", String.class).observeForever(this.i);
      this.d = paramLayoutInflater.inflate(2131493274, paramViewGroup, false);
      this.e = (ImageView)this.d.findViewById(2131297491);
      if (this.f.anchor != null && !TextUtils.isEmpty(this.f.anchor.avatar)) {
        ImageLoader.a((IRequestHost)w_(), this.f.anchor.avatar).a(2131233856).e().d().a(new ImageLoadResult(this, (IRequestHost)w_()) {
              public void a() {
                super.a();
                this.a.a(new Runnable(this) {
                      public void run() {
                        this.a.a.a();
                      }
                    },  300L);
              }
              
              public void a(int param1Int, Exception param1Exception) {
                this.a.a();
              }
            }).a(this.e);
      } else {
        a();
      } 
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
  
  public void onDestroy() {
    super.onDestroy();
    LiveEventBus.get("live_back_to_two_level", String.class).removeObserver(this.i);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveTwoLevelFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */