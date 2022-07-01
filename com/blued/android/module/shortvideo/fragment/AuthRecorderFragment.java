package com.blued.android.module.shortvideo.fragment;

import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IAuthRecorderView;
import com.blued.android.module.shortvideo.permission.PermissionHelper;
import com.blued.android.module.shortvideo.presenter.AuthRecorderPresenter;
import com.blued.android.module.shortvideo.presenter.ShortVideoBasePresent;
import com.blued.android.module.shortvideo.utils.StvGuideUtils;
import com.blued.android.module.shortvideo.utils.TimeDownUtils;
import com.blued.android.module.shortvideo.view.AuthProgressBar;

public class AuthRecorderFragment extends ShortVideoBaseFragment<IAuthRecorderView, AuthRecorderPresenter> implements View.OnClickListener, IAuthRecorderView, TimeDownUtils.ITimeDownCallBack {
  Runnable e = new Runnable(this) {
      public void run() {
        if (AuthRecorderFragment.c(this.a) != null && AuthRecorderFragment.c(this.a).getVisibility() == 0) {
          AuthRecorderFragment.c(this.a).setVisibility(8);
          this.a.u();
        } 
      }
    };
  
  private PowerManager.WakeLock f;
  
  private TextView s;
  
  private TextView t;
  
  private GLSurfaceView u;
  
  private LinearLayout v;
  
  private AuthProgressBar w;
  
  private View x;
  
  private View y;
  
  private TimeDownUtils z;
  
  private void a(int paramInt, boolean paramBoolean) {
    Intent intent = new Intent();
    intent.putExtra("auth_upload_state", paramBoolean);
    getActivity().setResult(paramInt, intent);
    getActivity().finish();
  }
  
  public static void a(Object paramObject, int paramInt1, int paramInt2) {
    if (paramObject instanceof Fragment) {
      ((Fragment)paramObject).getContext();
    } else {
      Context context = (Context)paramObject;
    } 
    if (!AppMethods.f()) {
      AppMethods.d(R.string.video_sdcard_not_exit);
      return;
    } 
    PermissionHelper.c(new PermissionCallbacks(paramInt1, paramObject, paramInt2) {
          public void a(String[] param1ArrayOfString) {}
          
          public void aa_() {
            Bundle bundle = new Bundle();
            bundle.putInt("from", this.a);
            TerminalActivity.a(bundle);
            TerminalActivity.b(bundle);
            Object object = this.b;
            if (object instanceof android.app.Activity) {
              TerminalActivity.a((Context)object, AuthRecorderFragment.class, bundle, this.c);
              return;
            } 
            if (object instanceof Fragment) {
              TerminalActivity.a((Fragment)object, AuthRecorderFragment.class, bundle, this.c);
              return;
            } 
            TerminalActivity.a((Context)object, AuthRecorderFragment.class, bundle, this.c);
          }
        });
  }
  
  public GLSurfaceView a() {
    return this.u;
  }
  
  protected AuthRecorderPresenter a(Bundle paramBundle) {
    return new AuthRecorderPresenter(paramBundle);
  }
  
  public void a(float paramFloat) {}
  
  public void a(boolean paramBoolean) {
    a(-1, paramBoolean);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4)
      c(); 
    return super.a(paramInt, paramKeyEvent);
  }
  
  public void a_(Runnable paramRunnable) {
    a(paramRunnable);
  }
  
  public void ac_() {
    b(true);
    AuthProgressBar authProgressBar = this.w;
    if (authProgressBar != null) {
      authProgressBar.b();
      this.w.setVisibility(4);
    } 
  }
  
  public BaseFragment b() {
    return (BaseFragment)this;
  }
  
  protected void b(Bundle paramBundle) {
    this.u = (GLSurfaceView)this.r.findViewById(R.id.svCameraNoFilter);
    this.v = (LinearLayout)this.r.findViewById(R.id.count_down_layout);
    this.s = (TextView)this.r.findViewById(R.id.count_down_text);
    this.w = (AuthProgressBar)this.r.findViewById(R.id.video_progressbar);
    this.t = (TextView)this.r.findViewById(R.id.cancel_btn);
    this.x = this.r.findViewById(R.id.fl_cover);
    this.y = this.r.findViewById(R.id.iv_close);
    this.x.setOnClickListener(this);
    this.y.setOnClickListener(this);
    if (StvGuideUtils.c()) {
      this.x.setVisibility(0);
      StvGuideUtils.d();
      this.x.postDelayed(this.e, 10000L);
      return;
    } 
    this.x.setVisibility(8);
  }
  
  public void c() {
    a(0, false);
  }
  
  public void c(boolean paramBoolean) {}
  
  public void d() {
    View view = this.x;
    if (view != null && view.getVisibility() != 0)
      u(); 
  }
  
  public void e() {
    AuthProgressBar authProgressBar = this.w;
    if (authProgressBar != null) {
      authProgressBar.setVisibility(0);
      this.w.a();
    } 
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.cancel_btn) {
      c();
      return;
    } 
    if (paramView.getId() == R.id.iv_close) {
      this.x.setVisibility(8);
      u();
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    this.f = ((PowerManager)getActivity().getSystemService("power")).newWakeLock(536870938, "RecorderActivity");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    a(paramLayoutInflater, R.layout.auth_recorder_v, paramViewGroup, paramBundle);
    return (View)this.r;
  }
  
  public void onDestroy() {
    super.onDestroy();
    View view = this.x;
    if (view != null)
      view.removeCallbacks(this.e); 
  }
  
  public void onPause() {
    super.onPause();
    TimeDownUtils timeDownUtils = this.z;
    if (timeDownUtils != null)
      timeDownUtils.b(); 
    AuthProgressBar authProgressBar = this.w;
    if (authProgressBar != null)
      authProgressBar.b(); 
  }
  
  public void onResume() {
    super.onResume();
    AuthProgressBar authProgressBar = this.w;
    if (authProgressBar != null)
      authProgressBar.setVisibility(4); 
    try {
      this.f.acquire();
      return;
    } catch (Exception exception) {
      Log.e("RecorderActivity", "wake lock acquire fail", exception);
      return;
    } 
  }
  
  public void onStop() {
    super.onStop();
    try {
      this.f.release();
      return;
    } catch (Exception exception) {
      Log.e("RecorderActivity", "wake lock release fail", exception);
      return;
    } 
  }
  
  protected void t() {
    this.t.setOnClickListener(this);
    this.z = new TimeDownUtils(this.s, 3, this);
  }
  
  public void u() {
    View view = this.x;
    if (view != null)
      view.removeCallbacks(this.e); 
    LinearLayout linearLayout = this.v;
    if (linearLayout != null)
      linearLayout.setVisibility(0); 
    TimeDownUtils timeDownUtils = this.z;
    if (timeDownUtils != null)
      timeDownUtils.a(); 
  }
  
  public void v() {
    a(new Runnable(this) {
          public void run() {
            if (AuthRecorderFragment.a(this.a) != null)
              AuthRecorderFragment.a(this.a).setText(this.a.getString(R.string.auth_start)); 
          }
        });
    a(new Runnable(this) {
          public void run() {
            if (AuthRecorderFragment.b(this.a) != null)
              AuthRecorderFragment.b(this.a).setVisibility(8); 
            if (this.a.p != null)
              this.a.p.h(); 
          }
        },  800L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\fragment\AuthRecorderFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */