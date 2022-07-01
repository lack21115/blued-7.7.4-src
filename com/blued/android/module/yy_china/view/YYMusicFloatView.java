package com.blued.android.module.yy_china.view;

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
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.yy_china.R;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class YYMusicFloatView extends LinearLayout {
  private Context a;
  
  private LayoutInflater b;
  
  private View c;
  
  private View d;
  
  private View e;
  
  private TextView f;
  
  private TextView g;
  
  private View h;
  
  private ImageView i;
  
  private LinearLayout j;
  
  private ObjectAnimator k;
  
  private LiveMusicModel l = new LiveMusicModel();
  
  public YYMusicFloatView(Context paramContext) {
    super(paramContext);
    this.a = paramContext;
    c();
  }
  
  public YYMusicFloatView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    c();
  }
  
  private void c() {
    this.b = LayoutInflater.from(this.a);
    this.c = this.b.inflate(R.layout.view_yy_music_float, (ViewGroup)this, true);
    this.d = this.c.findViewById(R.id.ll_playing);
    this.e = this.c.findViewById(R.id.ll_play_complete);
    this.f = (TextView)this.c.findViewById(R.id.tv_music_name);
    this.j = (LinearLayout)this.c.findViewById(R.id.ll_music);
    this.f.setSingleLine(true);
    this.f.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    this.f.setHorizontallyScrolling(true);
    this.f.setMarqueeRepeatLimit(-1);
    this.f.requestFocus();
    this.f.setSelected(true);
    this.g = (TextView)this.c.findViewById(R.id.tv_music_owner);
    this.h = this.c.findViewById(R.id.fl_music_avatar);
    this.i = (ImageView)this.c.findViewById(R.id.iv_music_avatar);
    setVisibility(8);
    this.j.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveEventBus.get("show_music").post("");
          }
        });
  }
  
  private void d() {
    if (this.k == null) {
      this.k = ObjectAnimator.ofFloat(this.h, "rotation", new float[] { 0.0F, 360.0F });
      this.k.setDuration(10000L);
      this.k.setInterpolator((TimeInterpolator)new LinearInterpolator());
      this.k.setRepeatCount(-1);
      this.k.setRepeatMode(1);
      this.k.start();
    } 
  }
  
  public void a() {
    b();
    this.i.setVisibility(8);
    this.d.setVisibility(8);
    this.e.setVisibility(0);
  }
  
  public void b() {
    ObjectAnimator objectAnimator = this.k;
    if (objectAnimator != null) {
      objectAnimator.cancel();
      this.k = null;
    } 
    this.h.animate().rotation(0.0F).setDuration(60L).start();
  }
  
  public void setData(LiveMusicModel paramLiveMusicModel) {
    if (this.l == null)
      return; 
    this.l = paramLiveMusicModel;
    this.i.setVisibility(0);
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    if (TextUtils.isEmpty(this.l.name)) {
      this.f.setText(getResources().getString(R.string.live_music_no_name));
    } else {
      this.f.setText(this.l.name);
    } 
    if (TextUtils.isEmpty(this.l.artist)) {
      this.g.setText(getResources().getString(R.string.live_music_no_owner));
    } else {
      this.g.setText(this.l.artist);
    } 
    ImageLoader.a(null, this.l.cover).c().a(this.i);
    setPlaying(true);
  }
  
  public void setPlaying(boolean paramBoolean) {
    d();
    if (paramBoolean) {
      if (Build.VERSION.SDK_INT >= 19) {
        this.k.resume();
        return;
      } 
      this.k.start();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 19) {
      this.k.pause();
      return;
    } 
    this.k.cancel();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYMusicFloatView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */