package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

public class LiveLiangIDReceivedPop extends CenterPopupView {
  public Context c;
  
  private ImageView d;
  
  private TextView e;
  
  private TextView f;
  
  private TextView g;
  
  private String h;
  
  private IRequestHost i;
  
  private void e() {
    this.d = (ImageView)findViewById(R.id.iv_close);
    this.e = (TextView)findViewById(R.id.tv_id);
    this.e.setText(this.h);
    this.f = (TextView)findViewById(R.id.tv_select_id);
    this.g = (TextView)findViewById(R.id.tv_see_id);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackLive.c(LiveProtos.Event.BETTER_ID_POP_CLOSE_CLICK, LiveLiangIDReceivedPop.a(this.a));
            this.a.p();
          }
        });
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackLive.c(LiveProtos.Event.BETTER_ID_POP_CHOOSE_CLICK, LiveLiangIDReceivedPop.a(this.a));
            this.a.c();
          }
        });
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackLive.c(LiveProtos.Event.BETTER_ID_POP_LOOK_CLICK, LiveLiangIDReceivedPop.a(this.a));
            this.a.d();
          }
        });
    EventTrackLive.a(LiveProtos.Event.BETTER_ID_POP_SHOW, this.h);
  }
  
  public void b() {
    super.b();
    e();
  }
  
  public void c() {
    LiveRoomInfo.a().b(this.c, LiveRoomInfo.a().E());
  }
  
  public void d() {
    LiveUserCardPop.a(this.c, this.i, LiveRoomInfo.a().f());
  }
  
  public int getImplLayoutId() {
    return R.layout.live_pop_receive_id;
  }
  
  public int getMaxWidth() {
    return XPopupUtils.a(getContext());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\pop\LiveLiangIDReceivedPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */