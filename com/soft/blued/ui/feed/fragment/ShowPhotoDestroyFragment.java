package com.soft.blued.ui.feed.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.MemoryBitmapCache;

public class ShowPhotoDestroyFragment extends BaseFragment {
  private View d;
  
  private String e;
  
  private int f;
  
  private ProgressBar g;
  
  private LinearLayout h;
  
  private TextView i;
  
  private TextView j;
  
  private FrameLayout k;
  
  private TextView l;
  
  private ImageView m;
  
  private boolean n;
  
  private CountDownTimer o;
  
  private void a() {
    this.m = (ImageView)this.d.findViewById(2131299472);
    this.g = (ProgressBar)this.d.findViewById(2131299159);
    this.h = (LinearLayout)this.d.findViewById(2131299752);
    this.i = (TextView)this.d.findViewById(2131297067);
    this.j = (TextView)this.d.findViewById(2131299877);
    this.k = (FrameLayout)this.d.findViewById(2131299463);
    this.l = (TextView)this.d.findViewById(2131299464);
    this.l.setText(String.valueOf(5L));
  }
  
  public static void a(BaseFragment paramBaseFragment, String paramString, int paramInt1, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putString("photo_path", paramString);
    bundle.putInt("msg_burn_after_reading_position", paramInt1);
    TerminalActivity.a((Fragment)paramBaseFragment, ShowPhotoDestroyFragment.class, bundle, paramInt2);
    ActivityChangeAnimationUtils.g((Activity)paramBaseFragment.getActivity());
  }
  
  private void k() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("mImagePath===");
    stringBuilder.append(this.e);
    Logger.c("ShowPhotoDestroyFragment", new Object[] { stringBuilder.toString() });
    MemoryBitmapCache.BitmapWrapper bitmapWrapper = MemoryBitmapCache.a().b(this.e);
    if (bitmapWrapper != null && bitmapWrapper.a != null && !bitmapWrapper.a.isRecycled()) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("缓存存在===");
      stringBuilder1.append(this.e);
      Logger.c("ShowPhotoDestroyFragment", new Object[] { stringBuilder1.toString() });
      this.m.setImageBitmap(bitmapWrapper.a);
      l();
      return;
    } 
    this.g.setVisibility(0);
    ImageLoader.a((IRequestHost)w_(), this.e).a(new ImageLoadResult(this, (IRequestHost)w_()) {
          public void a() {
            ShowPhotoDestroyFragment.b(this.a);
          }
          
          public void a(int param1Int, Exception param1Exception) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Exception===");
            stringBuilder2.append(param1Exception.getMessage());
            Logger.e("loadImage", new Object[] { stringBuilder2.toString() });
            ShowPhotoDestroyFragment.a(this.a).setVisibility(8);
            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append(AppInfo.d().getResources().getString(2131758203));
            stringBuilder1.append("(");
            stringBuilder1.append(param1Int);
            stringBuilder1.append(")");
            AppMethods.a(stringBuilder1.toString());
            this.a.a(new Runnable(this) {
                  public void run() {
                    this.a.a.a(false);
                  }
                },  1000L);
          }
        }).e().b().a(this.m);
  }
  
  private void l() {
    this.g.setVisibility(8);
    this.i.setVisibility(0);
    this.j.setVisibility(0);
    this.h.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            int i = param1MotionEvent.getAction();
            if (i != 0) {
              if (i != 1) {
                if (i != 2) {
                  if (i != 3)
                    return true; 
                  this.a.a(true);
                  return true;
                } 
              } else {
                this.a.a(true);
                return true;
              } 
            } else {
              ShowPhotoDestroyFragment.c(this.a).setVisibility(0);
              ShowPhotoDestroyFragment.d(this.a);
              ShowPhotoDestroyFragment.a(this.a, true);
            } 
            return true;
          }
        });
  }
  
  private void m() {
    if (this.o == null) {
      this.o = new CountDownTimer(this, 5500L, 1000L) {
          public void onFinish() {}
          
          public void onTick(long param1Long) {
            param1Long /= 1000L;
            if (param1Long == 0L) {
              this.a.a(true);
              return;
            } 
            ShowPhotoDestroyFragment.e(this.a).setText(String.valueOf(param1Long));
          }
        };
      this.o.start();
    } 
  }
  
  private void n() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.e = bundle.getString("photo_path");
      this.f = bundle.getInt("msg_burn_after_reading_position", -1);
    } 
    this.n = false;
  }
  
  public boolean V_() {
    a(this.n);
    return super.V_();
  }
  
  public void a(boolean paramBoolean) {
    if (getActivity() != null) {
      if (paramBoolean) {
        Intent intent = new Intent();
        intent.putExtra("msg_burn_after_reading_position", this.f);
        getActivity().setResult(-1, intent);
      } 
      getActivity().finish();
      ActivityChangeAnimationUtils.h((Activity)getActivity());
    } 
  }
  
  public boolean j() {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getActivity().getWindow().addFlags(8192);
    View view = this.d;
    if (view == null) {
      this.d = paramLayoutInflater.inflate(2131493321, paramViewGroup, false);
      n();
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.d.getParent()).removeView(this.d);
    } 
    return this.d;
  }
  
  public void onDestroy() {
    super.onDestroy();
    CountDownTimer countDownTimer = this.o;
    if (countDownTimer != null) {
      countDownTimer.cancel();
      this.o = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\ShowPhotoDestroyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */