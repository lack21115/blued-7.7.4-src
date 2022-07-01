package com.blued.android.module.live_china.view;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveMusicModel;

public class LiveMusicFloatView extends LinearLayout {
  private Context a;
  
  private LayoutInflater b;
  
  private View c;
  
  private View d;
  
  private View e;
  
  private TextView f;
  
  private TextView g;
  
  private View h;
  
  private ImageView i;
  
  private ObjectAnimator j;
  
  private LiveMusicModel k = new LiveMusicModel();
  
  public LiveMusicFloatView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    e();
  }
  
  public LiveMusicFloatView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    e();
  }
  
  private void e() {
    this.b = LayoutInflater.from(this.a);
    this.c = this.b.inflate(R.layout.live_music_float_view, (ViewGroup)this, true);
    this.d = this.c.findViewById(R.id.ll_playing);
    this.e = this.c.findViewById(R.id.ll_play_complete);
    this.f = (TextView)this.c.findViewById(R.id.tv_music_name);
    this.f.setSingleLine(true);
    this.f.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    this.f.setHorizontallyScrolling(true);
    this.f.setMarqueeRepeatLimit(-1);
    this.f.requestFocus();
    this.f.setSelected(true);
    this.g = (TextView)this.c.findViewById(R.id.tv_music_owner);
    this.h = this.c.findViewById(R.id.fl_music_avatar);
    this.i = (ImageView)this.c.findViewById(R.id.iv_music_avatar);
  }
  
  private void f() {
    if (this.j == null) {
      this.j = ObjectAnimator.ofFloat(this.h, "rotation", new float[] { 0.0F, 360.0F });
      this.j.setDuration(10000L);
      this.j.setInterpolator((TimeInterpolator)new LinearInterpolator());
      this.j.setRepeatCount(-1);
      this.j.setRepeatMode(1);
      this.j.start();
    } 
  }
  
  public void a() {
    d();
    setVisibility(8);
  }
  
  public void b() {
    d();
    this.d.setVisibility(8);
    this.e.setVisibility(0);
  }
  
  public void c() {
    setData(this.k);
  }
  
  public void d() {
    ObjectAnimator objectAnimator = this.j;
    if (objectAnimator != null) {
      objectAnimator.cancel();
      this.j = null;
    } 
    this.h.animate().rotation(0.0F).setDuration(60L).start();
  }
  
  public void setData(LiveMusicModel paramLiveMusicModel) {
    if (this.k == null)
      return; 
    this.k = paramLiveMusicModel;
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    if (TextUtils.isEmpty(this.k.name)) {
      this.f.setText(getResources().getString(R.string.live_music_no_name));
    } else {
      this.f.setText(this.k.name);
    } 
    if (TextUtils.isEmpty(this.k.artist)) {
      this.g.setText(getResources().getString(R.string.live_music_no_owner));
    } else {
      this.g.setText(this.k.artist);
    } 
    ImageLoader.a(null, this.k.cover).c().a(this.i);
    setPlaying(true);
  }
  
  public void setPlaying(boolean paramBoolean) {
    f();
    if (paramBoolean) {
      if (Build.VERSION.SDK_INT >= 19) {
        this.j.resume();
        return;
      } 
      this.j.start();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      this.j.pause();
      return;
    } 
    this.j.cancel();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMusicFloatView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */