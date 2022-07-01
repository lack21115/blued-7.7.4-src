package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;

public class LiveLiangExpirePop extends CenterPopupView {
  public Context c;
  
  private ImageView d;
  
  private TextView e;
  
  private TextView f;
  
  private String g;
  
  private void d() {
    this.d = (ImageView)findViewById(R.id.iv_close);
    this.e = (TextView)findViewById(R.id.tv_id);
    this.e.setText(this.g);
    this.f = (TextView)findViewById(R.id.tv_ok);
    this.d.setOnClickListener(new -$$Lambda$LiveLiangExpirePop$xHAeer-0OmXYsocmxD6o4ryi460(this));
    this.f.setOnClickListener(new -$$Lambda$LiveLiangExpirePop$0N1thHsjvTOcc818Sxh6NCCRnuU(this));
  }
  
  public void b() {
    super.b();
    d();
  }
  
  public void c() {
    LiveRoomInfo.a().b(this.c, LiveRoomInfo.a().E());
  }
  
  public int getImplLayoutId() {
    return R.layout.live_pop_expire_liang_id;
  }
  
  public int getMaxWidth() {
    return XPopupUtils.a(getContext());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\pop\LiveLiangExpirePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */