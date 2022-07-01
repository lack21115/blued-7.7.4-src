package com.blued.android.module.player.media.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.blued.android.module.player.media.R;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MediaControllerINT extends RelativeLayout {
  public long a = 0L;
  
  public long b = 0L;
  
  private final SimpleDateFormat c = new SimpleDateFormat("mm:ss");
  
  private SeekBar d;
  
  private TextView e;
  
  private TextView f;
  
  private long g;
  
  private ImageView h;
  
  private AbBaseVideoView i;
  
  private View.OnClickListener j = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        MediaControllerINT.a(this.a);
      }
    };
  
  private SeekBar.OnSeekBarChangeListener k = new SeekBar.OnSeekBarChangeListener(this) {
      public void onProgressChanged(SeekBar param1SeekBar, int param1Int, boolean param1Boolean) {
        if (param1Boolean)
          this.a.a(param1SeekBar.getProgress()); 
      }
      
      public void onStartTrackingTouch(SeekBar param1SeekBar) {}
      
      public void onStopTrackingTouch(SeekBar param1SeekBar) {
        this.a.b(param1SeekBar.getProgress());
      }
    };
  
  public MediaControllerINT(Context paramContext) {
    super(paramContext);
    a(paramContext);
  }
  
  public MediaControllerINT(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public MediaControllerINT(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public MediaControllerINT(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2) {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private void a() {
    AbBaseVideoView abBaseVideoView = this.i;
    if (abBaseVideoView == null)
      return; 
    if (abBaseVideoView.e()) {
      this.i.d();
    } else {
      this.i.b();
    } 
    b();
  }
  
  private void a(Context paramContext) {
    LayoutInflater.from(paramContext).inflate(R.layout.media_controller_int, (ViewGroup)this);
    this.d = (SeekBar)findViewById(R.id.seek_bar_view);
    this.e = (TextView)findViewById(R.id.tv_seek_cur);
    this.f = (TextView)findViewById(R.id.tv_seek_total);
    this.h = (ImageView)findViewById(R.id.player);
    ImageView imageView = this.h;
    if (imageView != null) {
      imageView.requestFocus();
      this.h.setOnClickListener(this.j);
    } 
    this.d.setMax(1000);
    this.d.setOnSeekBarChangeListener(this.k);
  }
  
  private void b() {
    if (this.h != null) {
      AbBaseVideoView abBaseVideoView = this.i;
      if (abBaseVideoView == null)
        return; 
      if (abBaseVideoView.e()) {
        this.h.setImageResource(R.drawable.video_international_controller_pause_icon);
        return;
      } 
      this.h.setImageResource(R.drawable.video_international_controller_play_icon);
    } 
  }
  
  public void a(int paramInt) {
    long l = this.b;
    b((long)((float)l * paramInt / 1000.0F), l, paramInt);
  }
  
  public void a(long paramLong1, long paramLong2) {
    this.a = paramLong1;
    this.b = paramLong2;
    SeekBar seekBar = this.d;
    if (seekBar != null && seekBar.getVisibility() == 0 && paramLong2 > 0L) {
      paramLong2 = (long)((float)paramLong1 / (float)paramLong2 * 1000.0F);
      long l = this.g;
      paramLong1 = paramLong2;
      if (l > paramLong2) {
        paramLong1 = paramLong2;
        if (l != 1000L) {
          paramLong1 = paramLong2;
          if (l > 900L)
            paramLong1 = 1000L; 
        } 
      } 
      this.d.setProgress((int)paramLong1);
      String str = this.c.format(new Date(this.a));
      this.e.setText(str);
      str = this.c.format(new Date(this.b));
      this.f.setText(str);
      this.g = paramLong1;
    } 
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt) {
    String str = this.c.format(new Date(paramLong1));
    this.e.setText(str);
    str = this.c.format(new Date(paramLong2));
    this.f.setText(str);
    AbBaseVideoView abBaseVideoView = this.i;
    if (abBaseVideoView != null)
      abBaseVideoView.a(paramLong1); 
  }
  
  public void b(int paramInt) {
    long l = this.b;
    a((long)((float)l * paramInt / 1000.0F), l, paramInt);
  }
  
  public void b(long paramLong1, long paramLong2, int paramInt) {
    String str = this.c.format(new Date(paramLong1));
    this.e.setText(str);
    str = this.c.format(new Date(paramLong2));
    this.f.setText(str);
    if (this.e.getVisibility() != 0)
      this.e.setVisibility(0); 
    if (this.f.getVisibility() != 0)
      this.f.setVisibility(0); 
    this.d.setProgress(paramInt);
  }
  
  public void setAncherView(AbBaseVideoView paramAbBaseVideoView) {
    this.i = paramAbBaseVideoView;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\media\view\MediaControllerINT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */