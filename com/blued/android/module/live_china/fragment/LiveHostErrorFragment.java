package com.blued.android.module.live_china.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.module.live.base.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.blued.android.module.live_china.utils.log.model.InstantLogBody;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.Map;

public class LiveHostErrorFragment extends LiveBaseDialogFragment {
  public Button i;
  
  public ImageView j;
  
  private void k() {
    EventTrackLive.a(LiveProtos.Event.ANCHOR_END_PAGE_CONFIRM_CLICK, LiveRoomManager.a().c());
    getActivity().finish();
    if (LiveRoomManager.a().B())
      LiveRoomInfo.a().a(getContext()); 
  }
  
  public boolean V_() {
    k();
    return true;
  }
  
  public int f() {
    return R.layout.fragment_live_host_error;
  }
  
  public void g() {
    this.b.setOnClickListener(-$$Lambda$LiveHostErrorFragment$SedKWM_jME2nYzzlJv9HTm4unoQ.INSTANCE);
    this.i = (Button)this.b.findViewById(R.id.live_exit_des_error_sure_btn);
    this.i.setOnClickListener(new -$$Lambda$LiveHostErrorFragment$2AlPKEbq6M70raFsBgdFleZh8_E(this));
    this.j = (ImageView)this.b.findViewById(R.id.background_header);
  }
  
  public void h() {}
  
  public void i() {
    super.i();
    ImageLoader.a((IRequestHost)a(), LiveRoomInfo.a().d()).d().a(this.j);
    j();
  }
  
  public void j() {
    if (LiveRoomManager.a().h() != null)
      EventTrackLive.a(LiveProtos.Event.LIVE_INTERRUPT, LiveRoomManager.a().c(), LiveRoomManager.a().e()); 
    Map<String, String> map = BluedHttpTools.a();
    map.put("session_id", LiveRoomManager.a().c());
    InstantLogBody instantLogBody = new InstantLogBody();
    instantLogBody.service = "live_interrupt";
    instantLogBody.event = 20001;
    InstantLog.a(instantLogBody, map);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveHostErrorFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */