package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.presenter.LiveMakeLoverOkPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

public class LiveMakeLoverOkFragment extends MvpFragment<LiveMakeLoverOkPresent> implements View.OnClickListener {
  View d;
  
  ImageView e;
  
  ImageView f;
  
  View g;
  
  View h;
  
  TextView i;
  
  TextView j;
  
  private long n;
  
  private LiveMakeLoverFansModel o;
  
  private LiveMakeLoverFansModel p;
  
  private void l() {
    if (getArguments() != null) {
      this.n = getArguments().getLong("lid");
      this.o = (LiveMakeLoverFansModel)getArguments().getSerializable("chosen");
      this.p = (LiveMakeLoverFansModel)getArguments().getSerializable("chooser");
    } 
  }
  
  private void m() {
    this.d = this.l.findViewById(R.id.fl_make_lover_dialog);
    this.e = (ImageView)this.l.findViewById(R.id.iv_avatar_left);
    this.f = (ImageView)this.l.findViewById(R.id.iv_avatar_right);
    this.g = this.l.findViewById(R.id.tv_make_lover_cancel);
    this.h = this.l.findViewById(R.id.tv_make_lover_confirm);
    this.i = (TextView)this.l.findViewById(R.id.iv_avatar_index_left);
    this.j = (TextView)this.l.findViewById(R.id.iv_avatar_index_right);
    this.i.setText(String.valueOf(this.o.index));
    this.j.setText(String.valueOf(this.p.index));
    if (TextUtils.isEmpty(this.o.avatar) && !TextUtils.isEmpty(this.o.pic)) {
      LiveMakeLoverFansModel liveMakeLoverFansModel = this.o;
      liveMakeLoverFansModel.avatar = liveMakeLoverFansModel.pic;
    } 
    if (TextUtils.isEmpty(this.p.avatar) && !TextUtils.isEmpty(this.p.pic)) {
      LiveMakeLoverFansModel liveMakeLoverFansModel = this.p;
      liveMakeLoverFansModel.avatar = liveMakeLoverFansModel.pic;
    } 
    ImageLoader.a((IRequestHost)w_(), this.o.avatar).a(R.drawable.user_bg_round).c().a(this.e);
    ImageLoader.a((IRequestHost)w_(), this.p.avatar).a(R.drawable.user_bg_round).c().a(this.f);
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    m();
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if (paramString == "MAKE_LOVER_OK" && paramBoolean && k() != null)
      k().dismiss(); 
  }
  
  public void aL_() {
    super.aL_();
  }
  
  public void b(String paramString) {
    super.b(paramString);
  }
  
  public LiveMakeLoverOkDialogFragment k() {
    return (getParentFragment() instanceof LiveMakeLoverOkDialogFragment) ? (LiveMakeLoverOkDialogFragment)getParentFragment() : null;
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i == R.id.tv_make_lover_confirm) {
      EventTrackLive.a(LiveProtos.Event.ANCHOR_MATCH_SUCCESS_POP_TRUE_CLICK, String.valueOf(this.n));
      ((LiveMakeLoverOkPresent)s()).a(this.o.uid, this.p.uid);
      return;
    } 
    if (i == R.id.tv_make_lover_cancel && k() != null)
      k().dismiss(); 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    l();
  }
  
  public void onDestroy() {
    super.onDestroy();
  }
  
  public int p() {
    return R.layout.fragment_live_make_lover_ok;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMakeLoverOkFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */