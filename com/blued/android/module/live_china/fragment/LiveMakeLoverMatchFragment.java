package com.blued.android.module.live_china.fragment;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.model.LiveMakeLoverReleationModel;
import com.blued.android.module.live_china.presenter.LiveMakeLoverMatchPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

public class LiveMakeLoverMatchFragment extends MvpFragment<LiveMakeLoverMatchPresent> implements View.OnClickListener {
  View d;
  
  View e;
  
  View f;
  
  ImageView g;
  
  ImageView h;
  
  ImageView i;
  
  TextView j;
  
  Runnable n = new Runnable(this) {
      public void run() {
        if (LiveMakeLoverMatchFragment.c(this.a) >= 5) {
          if (this.a.k() != null)
            this.a.k().dismiss(); 
          return;
        } 
        LiveMakeLoverMatchFragment.d(this.a);
        AppInfo.n().postDelayed(this.a.n, 1000L);
      }
    };
  
  private long o;
  
  private int p;
  
  private LiveMakeLoverFansModel q;
  
  private LiveMakeLoverFansModel r;
  
  private String s;
  
  private String t = "";
  
  private boolean u;
  
  private Dialog v;
  
  private int w = 0;
  
  private void c(String paramString) {
    if ("1".equals(paramString) || "3".equals(paramString)) {
      this.j.setText(getString(R.string.live_make_lover_attentioned));
      this.u = true;
      return;
    } 
    this.j.setText(getString(R.string.live_make_lover_attention));
    this.u = false;
  }
  
  private void l() {
    if (getArguments() != null) {
      this.o = getArguments().getLong("lid");
      this.p = getArguments().getInt("from");
      this.q = (LiveMakeLoverFansModel)getArguments().getSerializable("chosen");
      this.r = (LiveMakeLoverFansModel)getArguments().getSerializable("chooser");
      this.s = getArguments().getString("apngLocalUrl");
      if (TextUtils.equals(LiveRoomInfo.a().f(), this.q.uid) || TextUtils.equals(LiveRoomInfo.a().f(), this.r.uid)) {
        LiveMakeLoverFansModel liveMakeLoverFansModel;
        if (TextUtils.equals(LiveRoomInfo.a().f(), this.q.uid)) {
          liveMakeLoverFansModel = this.r;
        } else {
          liveMakeLoverFansModel = this.q;
        } 
        this.t = liveMakeLoverFansModel.uid;
      } 
    } 
  }
  
  private void m() {
    LiveProtos.Event event;
    this.d = this.l.findViewById(R.id.fl_make_lover_match);
    this.e = this.l.findViewById(R.id.fl_avatar_left);
    this.f = this.l.findViewById(R.id.fl_avatar_right);
    this.g = (ImageView)this.l.findViewById(R.id.iv_avatar_left);
    this.h = (ImageView)this.l.findViewById(R.id.iv_avatar_right);
    this.i = (ImageView)this.l.findViewById(R.id.iv_anim);
    this.j = (TextView)this.l.findViewById(R.id.tv_attention);
    this.v = DialogUtils.a(getContext());
    if (TextUtils.isEmpty(this.q.avatar) && !TextUtils.isEmpty(this.q.pic)) {
      LiveMakeLoverFansModel liveMakeLoverFansModel = this.q;
      liveMakeLoverFansModel.avatar = liveMakeLoverFansModel.pic;
    } 
    if (TextUtils.isEmpty(this.r.avatar) && !TextUtils.isEmpty(this.r.pic)) {
      LiveMakeLoverFansModel liveMakeLoverFansModel = this.r;
      liveMakeLoverFansModel.avatar = liveMakeLoverFansModel.pic;
    } 
    ImageLoader.a((IRequestHost)w_(), this.q.avatar).a(R.drawable.user_bg_round).c().a(this.g);
    ImageLoader.a((IRequestHost)w_(), this.r.avatar).a(R.drawable.user_bg_round).c().a(this.h);
    ImageLoader.d((IRequestHost)w_(), this.s).f().a(new ImageLoader.OnAnimationStateListener(this) {
          public void a() {}
          
          public void b() {}
        }).a(this.i);
    int i = AppInfo.l;
    int j = DensityUtils.a(getContext(), 75.0F);
    int k = DensityUtils.a(getContext(), 20.0F);
    int m = i / 2 - (j * 2 - k) / 2;
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    valueAnimator.setDuration(1000L);
    valueAnimator.setRepeatCount(0);
    valueAnimator.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, m, i, i - m + j - k - j, j) {
          public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
            float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
            if (this.e.e != null)
              this.e.e.setX(this.a * f); 
            if (this.e.f != null)
              this.e.f.setX(this.b - this.c * f - this.d); 
          }
        });
    valueAnimator.start();
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            AppInfo.n().removeCallbacks(this.a.n);
            if (this.a.k() != null)
              this.a.k().dismiss(); 
          }
        });
    if (TextUtils.isEmpty(this.t)) {
      AppInfo.n().post(this.n);
    } else {
      ((LiveMakeLoverMatchPresent)s()).a(this.t, this.o, (short)4);
    } 
    if (this.p == 0) {
      event = LiveProtos.Event.GUEST_MATCH_SUCCESS_POP_SHOW;
    } else {
      event = LiveProtos.Event.ANCHOR_MATCH_SUCCESS_POP_SHOW;
    } 
    EventTrackLive.b(event, LiveRoomManager.a().c(), LiveRoomManager.a().e(), this.t);
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    m();
  }
  
  public void a(LiveMakeLoverReleationModel paramLiveMakeLoverReleationModel) {
    if (paramLiveMakeLoverReleationModel != null) {
      c(paramLiveMakeLoverReleationModel.relation);
      this.j.setVisibility(0);
      this.j.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (!LiveMakeLoverMatchFragment.a(this.a)) {
                EventTrackLive.b(LiveProtos.Event.GUEST_MATCH_SUCCESS_POP_FOLLOW_CLICK, LiveRoomManager.a().c(), LiveRoomManager.a().e(), LiveMakeLoverMatchFragment.b(this.a));
                ((LiveMakeLoverMatchPresent)this.a.s()).a(LiveRoomManager.a().c(), LiveMakeLoverMatchFragment.b(this.a));
                return;
              } 
              AppInfo.n().removeCallbacks(this.a.n);
              if (this.a.k() != null)
                this.a.k().dismiss(); 
            }
          });
    } 
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    DialogUtils.b(this.v);
    if (paramString == "MAKE_LOVER_RELATION_ADD" && paramBoolean) {
      AppInfo.n().removeCallbacks(this.n);
      if (k() != null)
        k().dismiss(); 
    } 
  }
  
  public void aL_() {
    super.aL_();
  }
  
  public void b(String paramString) {
    super.b(paramString);
    DialogUtils.a(this.v);
  }
  
  public LiveMakeLoverOkDialogFragment k() {
    return (getParentFragment() instanceof LiveMakeLoverOkDialogFragment) ? (LiveMakeLoverOkDialogFragment)getParentFragment() : null;
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    l();
  }
  
  public void onDestroy() {
    super.onDestroy();
    DialogUtils.b(this.v);
    AppInfo.n().removeCallbacks(this.n);
  }
  
  public int p() {
    return R.layout.fragment_live_make_lover_match_success;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveMakeLoverMatchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */