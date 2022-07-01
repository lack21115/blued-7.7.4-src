package com.soft.blued.ui.photo.fragment;

import android.app.Activity;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.media.selector.fragment.PhotoDetailFragment;
import com.blued.android.module.player.media.observer.EventCallBackListener;
import com.blued.android.module.player.media.observer.EventCallbackObserver;

public class BizPhotoDetailFragment extends PhotoDetailFragment implements EventCallBackListener {
  private int l;
  
  private float m;
  
  private String n;
  
  private String o;
  
  public static BizPhotoDetailFragment a(String paramString, int paramInt, LoadOptions paramLoadOptions) {
    return a(paramString, paramInt, paramLoadOptions, true, true);
  }
  
  public static BizPhotoDetailFragment a(String paramString1, int paramInt, LoadOptions paramLoadOptions, String paramString2, String paramString3) {
    BizPhotoDetailFragment bizPhotoDetailFragment = new BizPhotoDetailFragment();
    Bundle bundle = a(paramString1, paramLoadOptions, true, true);
    bundle.putInt("come_code", paramInt);
    bundle.putString("key_feed_id", paramString2);
    bundle.putString("target_uid", paramString3);
    bizPhotoDetailFragment.setArguments(bundle);
    return bizPhotoDetailFragment;
  }
  
  public static BizPhotoDetailFragment a(String paramString, int paramInt, LoadOptions paramLoadOptions, boolean paramBoolean1, boolean paramBoolean2) {
    BizPhotoDetailFragment bizPhotoDetailFragment = new BizPhotoDetailFragment();
    Bundle bundle = a(paramString, paramLoadOptions, paramBoolean1, paramBoolean2);
    bundle.putInt("come_code", paramInt);
    bizPhotoDetailFragment.setArguments(bundle);
    return bizPhotoDetailFragment;
  }
  
  private boolean q() {
    if (r() == null)
      return false; 
    float f = r().width();
    return (r().height() > f * 3.0F);
  }
  
  private RectF r() {
    return this.g.getAttacher().a();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void a(View paramView) {}
  
  public void a(Object... paramVarArgs) {}
  
  public void aR_() {}
  
  public void aS_() {}
  
  public void aT_() {
    if (getActivity() != null)
      getActivity().finish(); 
  }
  
  public void b(View paramView) {}
  
  public void b(Object... paramVarArgs) {}
  
  public void d() {}
  
  public void f_(int paramInt) {
    if (q())
      this.d.setScrollDisable(false); 
  }
  
  public boolean j() {
    return false;
  }
  
  public String k() {
    int i = this.l;
    return (i == 5) ? "!o.png" : ((i == 8) ? "" : "!original.png");
  }
  
  public void l() {
    boolean bool;
    if (getArguments() != null) {
      bool = getArguments().getInt("come_code");
    } else {
      bool = false;
    } 
    this.l = bool;
    Bundle bundle = getArguments();
    String str2 = "";
    if (bundle != null) {
      str1 = getArguments().getString("key_feed_id");
    } else {
      str1 = "";
    } 
    this.n = str1;
    String str1 = str2;
    if (getArguments() != null)
      str1 = getArguments().getString("target_uid"); 
    this.o = str1;
    StatusBarHelper.a((Activity)getActivity(), false);
    super.l();
  }
  
  public void m() {
    if (q()) {
      this.m = AppInfo.l / r().width();
      float f = this.m;
      if (f != 0.0F && f > this.g.getMediumScale()) {
        if (this.m > this.g.getMaximumScale())
          this.g.setMaximumScale(this.m * 1.5F); 
        this.g.a(this.m, 0.0F, 0.0F, false);
        if (o()) {
          this.d.setScrollDisable(false);
          return;
        } 
      } 
    } else {
      super.m();
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    EventCallbackObserver.a().a(this);
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy() {
    EventCallbackObserver.a().b(this);
    super.onDestroy();
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent) {
    if (q())
      try {
        float f1 = this.g.getScale();
        float f2 = paramMotionEvent.getX();
        float f3 = paramMotionEvent.getY();
        if (f1 != this.m) {
          if (this.m >= this.g.getMinimumScale() && this.m <= this.g.getMaximumScale()) {
            this.g.a(this.m, f2, f3, true);
            return true;
          } 
        } else {
          this.g.a(this.g.getMaximumScale(), f2, f3, true);
        } 
        return true;
      } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
        return super.onDoubleTap(paramMotionEvent);
      }  
    return super.onDoubleTap(paramMotionEvent);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\fragment\BizPhotoDetailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */