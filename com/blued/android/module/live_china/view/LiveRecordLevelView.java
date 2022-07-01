package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.LiveUtils;

public class LiveRecordLevelView extends LinearLayout implements View.OnClickListener {
  public int a;
  
  Runnable b = new Runnable(this) {
      public void run() {
        this.a.a();
      }
    };
  
  Runnable c = new Runnable(this) {
      public void run() {
        this.a.b();
      }
    };
  
  private Context d;
  
  private LayoutInflater e;
  
  private ImageView f;
  
  private ProgressBar g;
  
  private View h;
  
  private MarqueeTextView i;
  
  private boolean j = false;
  
  private boolean k = false;
  
  private Runnable l = new Runnable(this) {
      public void run() {
        try {
          LiveRecordLevelView.a(this.a).setVisibility(8);
          LiveRecordLevelView.b(this.a).setVisibility(0);
          LiveRecordLevelView.b(this.a).setWidth(LiveRecordLevelView.b(this.a).getWidth());
          if (this.a.a == -1) {
            this.a.removeCallbacks(this.a.c);
            this.a.postDelayed(this.a.c, 3000L);
            return;
          } 
          LiveRecordLevelView.b(this.a).setListener(new MarqueeTextView.callbackListener(this) {
                public void a(int param2Int) {
                  if (param2Int >= 1) {
                    LiveRecordLevelView.b(this.a.a).b();
                    this.a.a.b();
                  } 
                }
              });
          LiveRecordLevelView.b(this.a).a();
          return;
        } catch (Exception exception) {
          exception.printStackTrace();
          return;
        } 
      }
    };
  
  public LiveRecordLevelView(Context paramContext) {
    super(paramContext);
    this.d = paramContext;
    d();
  }
  
  public LiveRecordLevelView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    d();
  }
  
  private void d() {
    this.e = LayoutInflater.from(this.d);
    View view = this.e.inflate(R.layout.live_record_progress_view, (ViewGroup)this, true);
    this.f = (ImageView)view.findViewById(R.id.live_anchor_level);
    this.g = (ProgressBar)view.findViewById(R.id.live_anchor_level_progress);
    this.i = (MarqueeTextView)view.findViewById(R.id.live_anchor_level_exp);
    this.h = view.findViewById(R.id.fl_level_progress);
  }
  
  public void a() {
    if (this.j)
      return; 
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    translateAnimation.setDuration(800L);
    translateAnimation.setFillAfter(true);
    this.i.setAnimation((Animation)translateAnimation);
    translateAnimation.start();
    this.i.setVisibility(0);
    this.i.setSingleLine(true);
    this.i.setEllipsize(TextUtils.TruncateAt.MARQUEE);
    this.i.setHorizontallyScrolling(true);
    this.i.setMarqueeRepeatLimit(-1);
    this.i.requestFocus();
    this.i.setSelected(true);
    translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    translateAnimation.setDuration(800L);
    translateAnimation.setFillAfter(true);
    translateAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            if (LiveRecordLevelView.c(this.a))
              return; 
            LiveRecordLevelView liveRecordLevelView = this.a;
            liveRecordLevelView.removeCallbacks(LiveRecordLevelView.d(liveRecordLevelView));
            liveRecordLevelView = this.a;
            liveRecordLevelView.post(LiveRecordLevelView.d(liveRecordLevelView));
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    this.h.setAnimation((Animation)translateAnimation);
    translateAnimation.start();
    this.h.setVisibility(8);
    if (LiveRoomManager.a().h() != null) {
      if ((LiveRoomManager.a().h()).next_level == -1) {
        this.i.setText(this.d.getResources().getString(R.string.live_record_exp_top));
        return;
      } 
      if (!TextUtils.isEmpty((LiveRoomManager.a().h()).gap_exp)) {
        String str1 = this.d.getResources().getString(R.string.live_record_exp_start);
        String str2 = String.valueOf((LiveRoomManager.a().h()).gap_exp);
        String str3 = this.d.getResources().getString(R.string.live_record_exp_end);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(str1);
        stringBuilder1.append(str2);
        stringBuilder1.append(str3);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder1.toString());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.d.getResources().getColor(R.color.nafio_f));
        int i = str1.length();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str1);
        stringBuilder2.append(str2);
        spannableStringBuilder.setSpan(foregroundColorSpan, i, stringBuilder2.toString().length(), 33);
        this.i.setText((CharSequence)spannableStringBuilder);
      } 
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, float paramFloat) {
    this.a = paramInt2;
    if (LiveRoomManager.a().h() != null) {
      if ((LiveRoomManager.a().h()).level > paramInt1)
        return; 
      (LiveRoomManager.a().h()).level = paramInt1;
      (LiveRoomManager.a().h()).percent = paramInt3;
      (LiveRoomManager.a().h()).gap_exp = String.valueOf(paramFloat);
      (LiveRoomManager.a().h()).next_level = paramInt2;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("refreshRecordLevel level:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" -- percent:");
    stringBuilder.append(paramInt3);
    Log.v("pk", stringBuilder.toString());
    LiveUtils.a(this.d, this.f, paramInt1, false);
    this.g.setProgress(paramInt3);
    if (paramInt2 == -1) {
      this.i.setText(this.d.getResources().getString(R.string.live_record_exp_top));
    } else {
      String str1 = this.d.getResources().getString(R.string.live_record_exp_start);
      String str2 = String.valueOf(paramFloat);
      String str3 = this.d.getResources().getString(R.string.live_record_exp_end);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str1);
      stringBuilder1.append(str2);
      stringBuilder1.append(str3);
      SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuilder1.toString());
      ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(this.d.getResources().getColor(R.color.nafio_f));
      paramInt1 = str1.length();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(str1);
      stringBuilder2.append(str2);
      spannableStringBuilder.setSpan(foregroundColorSpan, paramInt1, stringBuilder2.toString().length(), 33);
      this.i.setText((CharSequence)spannableStringBuilder);
    } 
    MarqueeTextView marqueeTextView = this.i;
    if (marqueeTextView != null) {
      if (this.j)
        return; 
      if (!this.k) {
        this.k = true;
        marqueeTextView.b();
        this.i.setVisibility(8);
        removeCallbacks(this.b);
        postDelayed(this.b, 3000L);
      } 
    } 
  }
  
  public void b() {
    if (this.j)
      return; 
    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    translateAnimation.setDuration(800L);
    translateAnimation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            LiveRecordLevelView liveRecordLevelView = this.a;
            liveRecordLevelView.removeCallbacks(liveRecordLevelView.b);
            liveRecordLevelView = this.a;
            liveRecordLevelView.postDelayed(liveRecordLevelView.b, 3000L);
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {}
        });
    translateAnimation.setFillAfter(true);
    this.i.setAnimation((Animation)translateAnimation);
    translateAnimation.start();
    this.i.setVisibility(8);
    translateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    translateAnimation.setDuration(800L);
    translateAnimation.setFillAfter(true);
    this.h.setAnimation((Animation)translateAnimation);
    translateAnimation.start();
    this.h.setVisibility(0);
  }
  
  public void c() {
    try {
      removeCallbacks(this.l);
      this.i.b();
      this.j = true;
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  public void onClick(View paramView) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveRecordLevelView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */