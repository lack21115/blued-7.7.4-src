package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.utils.LivePreferencesUtils;

public class LiveMakeLoverManageGuestView extends FrameLayout implements View.OnClickListener {
  public View a;
  
  LiveMakeLoverOnClickListener b;
  
  private Context c;
  
  private LayoutInflater d;
  
  private View e;
  
  private View f;
  
  private View g;
  
  private PlayingOnliveFragment h;
  
  public LiveMakeLoverManageGuestView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LiveMakeLoverManageGuestView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveMakeLoverManageGuestView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    c();
  }
  
  private void c() {
    this.d = LayoutInflater.from(this.c);
    this.e = this.d.inflate(R.layout.live_make_lover_manage_guest, (ViewGroup)this);
    this.f = this.e.findViewById(R.id.ll_make_lover_guest);
    this.g = this.e.findViewById(R.id.live_make_lover_wait_layout);
    this.a = this.e.findViewById(R.id.ll_live_make_enter);
    this.g.setOnClickListener(this);
    if (!LivePreferencesUtils.c()) {
      this.a.setVisibility(0);
      return;
    } 
    this.a.setVisibility(8);
  }
  
  public void a() {
    int j = DensityUtils.a(this.c, 55.0F);
    int i = j;
    if (this.h.bT.getVisibility() == 0)
      i = j + this.h.bT.getHeight(); 
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.f.getLayoutParams();
    marginLayoutParams.bottomMargin = i;
    this.f.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
  }
  
  public void a(PlayingOnliveFragment paramPlayingOnliveFragment, LiveMakeLoverOnClickListener paramLiveMakeLoverOnClickListener) {
    this.b = paramLiveMakeLoverOnClickListener;
    this.h = paramPlayingOnliveFragment;
  }
  
  public void b() {
    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)this.f.getLayoutParams();
    marginLayoutParams.bottomMargin = DensityUtils.a(this.c, 55.0F);
    this.f.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_make_lover_wait_layout) {
      if (!LivePreferencesUtils.c()) {
        LivePreferencesUtils.a(true);
        this.a.setVisibility(8);
      } 
      LiveMakeLoverOnClickListener liveMakeLoverOnClickListener = this.b;
      if (liveMakeLoverOnClickListener != null)
        liveMakeLoverOnClickListener.a(); 
    } 
  }
  
  public boolean performClick() {
    return this.g.performClick();
  }
  
  public static interface LiveMakeLoverOnClickListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMakeLoverManageGuestView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */