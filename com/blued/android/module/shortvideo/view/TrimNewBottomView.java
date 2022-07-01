package com.blued.android.module.shortvideo.view;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.ITrimBottomCallback;
import com.blued.android.module.shortvideo.model.TrimDataModel;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.TrimViewUtils;

public class TrimNewBottomView extends RelativeLayout implements View.OnClickListener {
  private static final String b;
  
  SeekBar.OnSeekBarChangeListener a = new SeekBar.OnSeekBarChangeListener(this) {
      public void onProgressChanged(SeekBar param1SeekBar, int param1Int, boolean param1Boolean) {
        if (param1Boolean) {
          param1Int = (int)((int)((float)(long)(TrimNewBottomView.b(this.a).getRightProgress() - TrimNewBottomView.b(this.a).getLeftProgress()) * param1Int / 1000.0F) + TrimNewBottomView.b(this.a).getLeftProgress());
          double d = param1Int;
          if (d < TrimNewBottomView.b(this.a).getLeftProgress()) {
            TrimNewBottomView.c(this.a).b((int)TrimNewBottomView.b(this.a).getLeftProgress());
            return;
          } 
          if (d > TrimNewBottomView.b(this.a).getRightProgress()) {
            TrimNewBottomView.c(this.a).b((int)TrimNewBottomView.b(this.a).getRightProgress());
            return;
          } 
          TrimNewBottomView.c(this.a).b(param1Int);
        } 
      }
      
      public void onStartTrackingTouch(SeekBar param1SeekBar) {}
      
      public void onStopTrackingTouch(SeekBar param1SeekBar) {
        int j = (int)((int)((float)(long)(TrimNewBottomView.b(this.a).getRightProgress() - TrimNewBottomView.b(this.a).getLeftProgress()) * param1SeekBar.getProgress() / 1000.0F) + TrimNewBottomView.b(this.a).getLeftProgress());
        int i = j;
        if (j > TrimNewBottomView.b(this.a).getRightProgress())
          i = (int)TrimNewBottomView.b(this.a).getLeftProgress(); 
        TrimNewBottomView.c(this.a).d_(i);
      }
    };
  
  private TrimSeekBar c;
  
  private TextView d;
  
  private TextView e;
  
  private LinearLayout f;
  
  private RangeSeekBar g;
  
  private VideoFrameView h;
  
  private ValueAnimator i;
  
  private TrimDataModel j;
  
  private ITrimBottomCallback k;
  
  static {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(TrimNewBottomView.class.getSimpleName());
    stringBuilder.append(" ");
    b = stringBuilder.toString();
  }
  
  public TrimNewBottomView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public TrimNewBottomView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TrimNewBottomView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    f();
  }
  
  private void b(int paramInt) {
    this.c.clearAnimation();
    ValueAnimator valueAnimator = this.i;
    if (valueAnimator != null && valueAnimator.isRunning())
      this.i.cancel(); 
    if (this.c.getVisibility() == 8)
      this.c.setVisibility(0); 
    int j = (int)this.j.getLeftProgress();
    int k = (int)this.j.getRightProgress();
    int i = paramInt;
    if (paramInt == 0)
      i = j; 
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.c.getLayoutParams();
    layoutParams.leftMargin = TrimViewUtils.a(this.j);
    layoutParams.width = TrimViewUtils.b(this.j);
    this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    if (j != k) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b);
      stringBuilder.append("IconStart:");
      stringBuilder.append(j);
      stringBuilder.append(" | IconEnd:");
      stringBuilder.append(k);
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder();
      stringBuilder.append(b);
      stringBuilder.append("PlayDuration:");
      stringBuilder.append(TrimViewUtils.c(this.j));
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      this.i = ValueAnimator.ofFloat(new float[] { (i - j), (k - j) }).setDuration((k - i));
      this.i.setInterpolator((TimeInterpolator)new LinearInterpolator());
      this.i.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, k, j) {
            public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
              float f = ((Float)param1ValueAnimator.getAnimatedValue()).floatValue();
              int i = (int)(f / (this.a - this.b) * 1000.0F);
              TrimNewBottomView.a(this.c).setProgress(i);
              if (f >= (this.a - this.b))
                TrimNewBottomView.c(this.c).d_((int)TrimNewBottomView.b(this.c).getLeftProgress()); 
            }
          });
      this.i.start();
    } 
  }
  
  private void f() {
    View view = LayoutInflater.from(getContext()).inflate(R.layout.trim_new_bottom_v, null);
    this.h = (VideoFrameView)view.findViewById(R.id.stv_video_frame_view);
    this.d = (TextView)view.findViewById(R.id.stv_editor_bottom_title);
    this.e = (TextView)view.findViewById(R.id.stv_bottom_save);
    this.f = (LinearLayout)view.findViewById(R.id.stv_video_trim_seek_layout);
    this.e.setOnClickListener(this);
    addView(view);
  }
  
  public void a() {}
  
  public void a(double paramDouble) {
    long l;
    if (paramDouble != 0.0D) {
      l = Math.round(paramDouble / 1000.0D);
    } else {
      l = 0L;
    } 
    TextView textView = this.d;
    if (textView != null)
      textView.setText(String.format(getResources().getString(R.string.stv_trim_video_time_title), new Object[] { Long.valueOf(l) })); 
  }
  
  public void a(int paramInt) {
    ValueAnimator valueAnimator = this.i;
    if (valueAnimator != null && valueAnimator.isRunning()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b);
      stringBuilder.append("animator.cancel():");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      this.i.cancel();
    } 
    b(paramInt);
  }
  
  public void a(RecyclerView.OnScrollListener paramOnScrollListener) {
    VideoFrameView videoFrameView = this.h;
    if (videoFrameView != null)
      videoFrameView.a(paramOnScrollListener); 
  }
  
  public void a(ITrimBottomCallback paramITrimBottomCallback, TrimDataModel paramTrimDataModel) {
    this.k = paramITrimBottomCallback;
    this.j = paramTrimDataModel;
    long l = Math.min(this.j.getDurationMs(), this.j.getMaxVideoDuration());
    this.g = new RangeSeekBar(getContext(), 0L, l);
    this.f.addView(this.g);
    this.g.setSelectedMinValue(0L);
    this.g.setSelectedMaxValue(l);
    this.g.setMin_cut_time(this.j.getMinVideoDuration());
    this.g.setNotifyWhileDragging(true);
    a(this.j.getRightProgress() - this.j.getLeftProgress());
    this.c = (TrimSeekBar)findViewById(R.id.seekbar_position_icon);
    this.c.setMax(1000);
    this.c.setOnSeekBarChangeListener(this.a);
    this.h.a(this.j.getVideoPath(), this.j.getDurationMs(), this.j.getSingleRangeWidth(), DensityUtils.a(getContext(), 54.0F), this.j.getMarginSize(), this.j.getThumbnailsCount());
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {
    VideoFrameView videoFrameView = this.h;
    if (videoFrameView != null)
      videoFrameView.a(); 
    ValueAnimator valueAnimator = this.i;
    if (valueAnimator != null && valueAnimator.isRunning())
      this.i.cancel(); 
  }
  
  public void e() {
    ValueAnimator valueAnimator = this.i;
    if (valueAnimator != null && valueAnimator.isRunning()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(b);
      stringBuilder.append("animator.cancel():");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      this.i.cancel();
    } 
  }
  
  public long getSelectedMaxValue() {
    RangeSeekBar rangeSeekBar = this.g;
    return (rangeSeekBar != null) ? rangeSeekBar.getSelectedMaxValue() : 0L;
  }
  
  public long getSelectedMinValue() {
    RangeSeekBar rangeSeekBar = this.g;
    return (rangeSeekBar != null) ? rangeSeekBar.getSelectedMinValue() : 0L;
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.stv_bottom_save) {
      ITrimBottomCallback iTrimBottomCallback = this.k;
      if (iTrimBottomCallback != null)
        iTrimBottomCallback.a(paramView); 
    } 
  }
  
  public void setOnRangeSeekBarChangeListener(RangeSeekBar.OnRangeSeekBarChangeListener paramOnRangeSeekBarChangeListener) {
    RangeSeekBar rangeSeekBar = this.g;
    if (rangeSeekBar != null)
      rangeSeekBar.setOnRangeSeekBarChangeListener(paramOnRangeSeekBarChangeListener); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\TrimNewBottomView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */