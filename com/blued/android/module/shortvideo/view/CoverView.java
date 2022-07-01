package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.base.data_statistics.StatisticsProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.ICoverSlideListener;
import com.blued.android.module.shortvideo.manager.ObserverMgr;
import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.presenter.EditPresenter;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvViewUtils;
import com.blued.android.module.shortvideo.widget.CoverSlideView;

public class CoverView extends EditBottomBaseView implements View.OnTouchListener, ICoverSlideListener, EventObserver {
  private static final String d = CoverView.class.getSimpleName();
  
  private View e;
  
  private VideoFrameView f;
  
  private CoverSlideView g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private int k;
  
  private int l;
  
  private ICoverSlideListener m;
  
  public CoverView(Context paramContext) {
    super(paramContext);
  }
  
  public CoverView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
  }
  
  public CoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a() {
    this.e = LayoutInflater.from(getContext()).inflate(R.layout.cover_v, null);
    this.f = (VideoFrameView)this.e.findViewById(R.id.stv_video_frame_list);
    this.g = (CoverSlideView)this.e.findViewById(R.id.stv_cover_slide_v);
    this.h = (getResources().getDisplayMetrics()).widthPixels;
    this.i = this.h / 7;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3) {
    this.k = paramInt1;
    this.l = paramInt2;
    if (this.k != 2) {
      ICoverSlideListener iCoverSlideListener = this.m;
      if (iCoverSlideListener != null) {
        if (iCoverSlideListener.getPresenter() == null)
          return; 
        EditPresenter editPresenter = this.m.getPresenter();
        paramInt1 = (this.i + DensityUtils.a(getContext(), 6.0F)) / 2;
        paramInt2 = this.h - (this.i + DensityUtils.a(getContext(), 6.0F)) / 2;
        editPresenter.e(paramInt1);
        editPresenter.f(paramInt2);
        editPresenter.d(paramInt2 - paramInt1);
        VideoFrameView videoFrameView = this.f;
        String str = editPresenter.z();
        long l = editPresenter.A();
        paramInt1 = this.i;
        videoFrameView.a(str, l, paramInt1, paramInt1, 0, 7);
        this.j = this.i + DensityUtils.a(getContext(), 6.0F);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.g.getLayoutParams();
        paramInt1 = this.j;
        layoutParams.width = paramInt1;
        layoutParams.height = paramInt1;
        this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.g.setLeft(this.m.getPresenter().y());
        this.e.setOnTouchListener(this);
        this.g.a(this.h, this);
      } 
    } 
  }
  
  public void a(ICoverSlideListener paramICoverSlideListener) {
    this.m = paramICoverSlideListener;
  }
  
  public void a(EventType.VALUE paramVALUE) {
    if (paramVALUE == EventType.VALUE.d)
      c(); 
  }
  
  protected void b() {
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.c.getLayoutParams();
    layoutParams.height = this.i + DensityUtils.a(getContext(), 6.0F);
    this.c.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    StvViewUtils.a((View)this.c, 0, 40, 0, 60);
  }
  
  public void b(int paramInt) {
    ICoverSlideListener iCoverSlideListener = this.m;
    if (iCoverSlideListener != null)
      iCoverSlideListener.b(paramInt); 
  }
  
  public void c() {
    super.c();
    this.m.getPresenter().h(3);
    if (this.k < 60)
      StatisticsProxy.a().a("sv_page", "cover"); 
  }
  
  public void d() {
    super.d();
    this.m.getPresenter().h(0);
    ObserverMgr.a().a(EventType.VALUE.q);
  }
  
  protected void e() {
    d();
  }
  
  protected void f() {}
  
  protected boolean g() {
    return true;
  }
  
  protected View getContentV() {
    return this.e;
  }
  
  public EditPresenter getPresenter() {
    ICoverSlideListener iCoverSlideListener = this.m;
    return (iCoverSlideListener != null) ? iCoverSlideListener.getPresenter() : null;
  }
  
  protected int getTitleId() {
    return R.string.stv_select_cover_title;
  }
  
  public void h() {
    this.g.c();
    ObserverMgr.a().a(this);
  }
  
  public void i() {
    this.g.b();
  }
  
  public void j() {
    ObserverMgr.a().b(this);
  }
  
  public void k() {
    this.g.a();
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    int i = (int)paramMotionEvent.getRawX();
    if (paramMotionEvent.getAction() != 0)
      return false; 
    if (i <= this.h) {
      int i1 = this.g.getTop();
      int i2 = this.g.getBottom();
      int k = i - this.j / 2;
      int j = k;
      if (k < 0)
        j = 0; 
      int i3 = this.j;
      int n = j + i3;
      int m = this.h;
      k = j;
      j = n;
      if (n > m) {
        k = m - i3;
        j = m;
      } 
      this.m.getPresenter().c(i);
      this.m.getPresenter().g(k);
      b((int)this.m.getPresenter().v());
      this.g.layout(k, i1, j, i2);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(d);
      stringBuilder.append("cover slidev down rawx:");
      stringBuilder.append(i);
      stringBuilder.append(" | left:");
      stringBuilder.append(k);
      stringBuilder.append(" | currentCoverTime:");
      stringBuilder.append(this.m.getPresenter().v());
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    } 
    return false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\view\CoverView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */