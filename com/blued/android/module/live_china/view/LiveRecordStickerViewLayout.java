package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.customview.widget.ViewDragHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRecordLevelStickerModel;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;

public class LiveRecordStickerViewLayout extends FrameLayout {
  private ViewDragHelper a;
  
  private ImageView b;
  
  private View c;
  
  private View d;
  
  private Context e;
  
  private int f;
  
  private int g;
  
  private View h;
  
  private View i;
  
  private ViewDragHelper.Callback j = new ViewDragHelper.Callback(this) {
      public int clampViewPositionHorizontal(View param1View, int param1Int1, int param1Int2) {
        param1Int2 = this.a.getPaddingLeft();
        int i = this.a.getWidth();
        int j = param1View.getWidth();
        return Math.min(Math.max(param1Int1, param1Int2), i - j - param1Int2);
      }
      
      public int clampViewPositionVertical(View param1View, int param1Int1, int param1Int2) {
        param1Int2 = this.a.getPaddingTop();
        int i = this.a.getHeight();
        int j = param1View.getHeight();
        return Math.min(Math.max(param1Int1, param1Int2), i - j - param1Int2);
      }
      
      public int getViewHorizontalDragRange(View param1View) {
        return this.a.getMeasuredWidth() - param1View.getMeasuredWidth();
      }
      
      public int getViewVerticalDragRange(View param1View) {
        return this.a.getMeasuredHeight() - param1View.getMeasuredHeight();
      }
      
      public void onViewCaptured(View param1View, int param1Int) {
        super.onViewCaptured(param1View, param1Int);
        LiveRecordStickerViewLayout.a(this.a, param1View.getLeft());
        LiveRecordStickerViewLayout.b(this.a, param1View.getTop());
      }
      
      public void onViewDragStateChanged(int param1Int) {
        super.onViewDragStateChanged(param1Int);
        if (param1Int != 0) {
          if (param1Int == 1) {
            LiveRecordStickerViewLayout.b(this.a).setVisibility(0);
            LiveRecordStickerViewLayout.g(this.a).setVisibility(0);
            LiveRecordStickerViewLayout.k(this.a).setVisibility(0);
            (LiveRecordStickerViewLayout.f(this.a)).ct.setBackgroundColor(LiveRecordStickerViewLayout.c(this.a).getResources().getColor(R.color.color_4c000000));
          } 
        } else {
          LiveRecordStickerViewLayout.b(this.a).setVisibility(4);
          LiveRecordStickerViewLayout.g(this.a).setVisibility(4);
          LiveRecordStickerViewLayout.k(this.a).setVisibility(4);
          (LiveRecordStickerViewLayout.f(this.a)).ct.setBackgroundColor(LiveRecordStickerViewLayout.c(this.a).getResources().getColor(R.color.transparent));
        } 
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onViewDragStateChanged state:");
        stringBuilder.append(param1Int);
        Log.v("pk", stringBuilder.toString());
      }
      
      public void onViewPositionChanged(View param1View, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
        super.onViewPositionChanged(param1View, param1Int1, param1Int2, param1Int3, param1Int4);
      }
      
      public void onViewReleased(View param1View, float param1Float1, float param1Float2) {
        super.onViewReleased(param1View, param1Float1, param1Float2);
        int i = param1View.getLeft();
        int j = param1View.getTop();
        int k = param1View.getRight();
        int m = param1View.getBottom();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onViewReleased stickerLeft:");
        stringBuilder.append(i);
        stringBuilder.append(" -- stickerTop:");
        stringBuilder.append(j);
        Log.v("drb", stringBuilder.toString());
        LiveRecordStickerViewLayout liveRecordStickerViewLayout = this.a;
        if (LiveRecordStickerViewLayout.a(liveRecordStickerViewLayout, LiveRecordStickerViewLayout.b(liveRecordStickerViewLayout), i, m)) {
          LiveRecordStickerViewLayout.b(this.a).setVisibility(4);
          LiveRecordStickerViewLayout.a(this.a).setVisibility(8);
          LiveRecordStickerViewLayout.a(this.a).startAnimation(AnimationUtils.loadAnimation(LiveRecordStickerViewLayout.c(this.a), R.anim.push_center_out));
          LiveRecordStickerViewLayout.d(this.a);
          LiveRecordStickerViewLayout.f(this.a).a(LiveRecordStickerViewLayout.e(this.a));
          return;
        } 
        liveRecordStickerViewLayout = this.a;
        if (LiveRecordStickerViewLayout.a(liveRecordStickerViewLayout, LiveRecordStickerViewLayout.g(liveRecordStickerViewLayout), i, j)) {
          LiveRecordStickerViewLayout.j(this.a).settleCapturedViewAt(LiveRecordStickerViewLayout.h(this.a), LiveRecordStickerViewLayout.i(this.a));
          this.a.invalidate();
          return;
        } 
        liveRecordStickerViewLayout = this.a;
        if (LiveRecordStickerViewLayout.a(liveRecordStickerViewLayout, LiveRecordStickerViewLayout.k(liveRecordStickerViewLayout), k, j)) {
          LiveRecordStickerViewLayout.j(this.a).settleCapturedViewAt(LiveRecordStickerViewLayout.h(this.a), LiveRecordStickerViewLayout.i(this.a));
          this.a.invalidate();
          return;
        } 
        liveRecordStickerViewLayout = this.a;
        liveRecordStickerViewLayout.a(i, j, LiveRecordStickerViewLayout.e(liveRecordStickerViewLayout));
      }
      
      public boolean tryCaptureView(View param1View, int param1Int) {
        return (param1View == LiveRecordStickerViewLayout.a(this.a));
      }
    };
  
  private RecordingOnliveFragment k;
  
  private LiveRecordLevelStickerModel l;
  
  public LiveRecordStickerViewLayout(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.e = paramContext;
    a();
  }
  
  private void a() {
    this.a = ViewDragHelper.create((ViewGroup)this, 1.0F, this.j);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2) {
    if (paramView == null)
      return false; 
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getMeasuredWidth();
    int m = paramView.getMeasuredHeight();
    return (paramInt2 >= j && paramInt2 <= m + j && paramInt1 >= i && paramInt1 <= k + i);
  }
  
  private void b() {
    this.k.S.u();
  }
  
  public void a(int paramInt1, int paramInt2, LiveRecordLevelStickerModel paramLiveRecordLevelStickerModel) {
    if (paramLiveRecordLevelStickerModel == null)
      return; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("viewX:");
    stringBuilder.append(paramInt1);
    Log.v("drb", stringBuilder.toString());
    float f1 = paramInt1 / AppInfo.l;
    float f2 = paramInt2 / AppInfo.m;
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append("_");
    stringBuilder.append(paramInt2);
    LiveRoomPreferences.z(stringBuilder.toString());
    RecordingOnliveFragment recordingOnliveFragment = this.k;
    if (recordingOnliveFragment != null && recordingOnliveFragment.S != null)
      this.k.S.a(f1, f2, paramLiveRecordLevelStickerModel.image); 
  }
  
  public void a(RecordingOnliveFragment paramRecordingOnliveFragment) {
    this.k = paramRecordingOnliveFragment;
  }
  
  public void a(LiveRecordLevelStickerModel paramLiveRecordLevelStickerModel) {
    Animation animation;
    this.l = paramLiveRecordLevelStickerModel;
    if (paramLiveRecordLevelStickerModel == null) {
      b();
      this.b.setVisibility(8);
      animation = AnimationUtils.loadAnimation(this.e, R.anim.push_center_out);
      this.b.startAnimation(animation);
      return;
    } 
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DensityUtils.a(this.e, 90.0F), DensityUtils.a(this.e, 45.0F));
    layoutParams.gravity = 17;
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    if (this.b.getVisibility() == 8) {
      this.b.setVisibility(0);
      ImageLoader.a(null, ((LiveRecordLevelStickerModel)animation).image).a(this.b);
    } else {
      this.b.setVisibility(8);
      Animation animation1 = AnimationUtils.loadAnimation(this.e, R.anim.push_center_out);
      this.b.startAnimation(animation1);
      animation1.setAnimationListener(new Animation.AnimationListener(this, (LiveRecordLevelStickerModel)animation) {
            public void onAnimationEnd(Animation param1Animation) {
              LiveRecordStickerViewLayout.a(this.b).setVisibility(0);
              ImageLoader.a(null, this.a.image).a(LiveRecordStickerViewLayout.a(this.b));
            }
            
            public void onAnimationRepeat(Animation param1Animation) {}
            
            public void onAnimationStart(Animation param1Animation) {}
          });
    } 
    AppInfo.n().postDelayed(new Runnable(this, (LiveRecordLevelStickerModel)animation) {
          public void run() {
            int[] arrayOfInt = new int[2];
            LiveRecordStickerViewLayout.a(this.b).getLocationOnScreen(arrayOfInt);
            int i = arrayOfInt[0];
            int j = arrayOfInt[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("changeSticker left:");
            stringBuilder.append(i);
            stringBuilder.append(" -- top:");
            stringBuilder.append(j);
            Log.v("drb", stringBuilder.toString());
            this.b.a(i, j, this.a);
          }
        }500L);
  }
  
  public void b(int paramInt1, int paramInt2, LiveRecordLevelStickerModel paramLiveRecordLevelStickerModel) {
    this.l = paramLiveRecordLevelStickerModel;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("changeLocation x:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" -- y:");
    stringBuilder.append(paramInt2);
    Log.v("drb", stringBuilder.toString());
    this.b.setVisibility(0);
    ImageLoader.a(null, paramLiveRecordLevelStickerModel.image).a(this.b);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.b.getLayoutParams();
    layoutParams.leftMargin = paramInt1;
    layoutParams.topMargin = paramInt2;
    layoutParams.gravity = 51;
    this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
  }
  
  public void computeScroll() {
    super.computeScroll();
    if (this.a.continueSettling(true))
      invalidate(); 
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    this.b = (ImageView)findViewById(R.id.live_record_sticker_image);
    this.c = findViewById(R.id.live_record_sticker_remove_layout);
    this.d = findViewById(R.id.live_record_sticker_remove_btn);
    this.h = findViewById(R.id.live_record_domain1);
    this.i = findViewById(R.id.live_record_domain2);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
    return this.a.shouldInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    int i = (int)paramMotionEvent.getRawX();
    int j = (int)paramMotionEvent.getRawY();
    this.a.processTouchEvent(paramMotionEvent);
    return a((View)this.b, i, j);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveRecordStickerViewLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */