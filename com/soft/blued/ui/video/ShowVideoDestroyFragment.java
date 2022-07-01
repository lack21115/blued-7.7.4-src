package com.soft.blued.ui.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.customview.CircleProgressView;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.VideoLoadController;

public class ShowVideoDestroyFragment extends BaseFragment {
  final Handler d = new Handler();
  
  Runnable e = new Runnable(this) {
      public void run() {
        try {
          MediaPlayer mediaPlayer = ShowVideoDestroyFragment.g(this.a).getMediaPlayer();
          if (mediaPlayer.isPlaying()) {
            int i = mediaPlayer.getCurrentPosition();
            ShowVideoDestroyFragment.k(this.a).setProgress(i);
            this.a.d.postDelayed(this, 100L);
            return;
          } 
          ShowVideoDestroyFragment.k(this.a).setProgress(mediaPlayer.getDuration());
          this.a.a(true);
          return;
        } catch (IllegalStateException illegalStateException) {
          return;
        } 
      }
    };
  
  private Context f;
  
  private View g;
  
  private LayoutInflater h;
  
  private SurfaceVideoView i;
  
  private ImageView j;
  
  private CircleProgressView k;
  
  private String l;
  
  private VideoLoadController.IVideoController m;
  
  private LinearLayout n;
  
  private TextView o;
  
  private TextView p;
  
  private LinearLayout q;
  
  private ProgressBar r;
  
  private ProgressBar s;
  
  private int t;
  
  private boolean u;
  
  public static void a(BaseFragment paramBaseFragment, String paramString, int paramInt1, int paramInt2) {
    LiveFloatManager.a().l();
    Bundle bundle = new Bundle();
    bundle.putInt("msg_burn_after_reading_position", paramInt1);
    bundle.putString("video_path", paramString);
    TerminalActivity.a((Fragment)paramBaseFragment, ShowVideoDestroyFragment.class, bundle, paramInt2);
    ActivityChangeAnimationUtils.g((Activity)paramBaseFragment.getActivity());
  }
  
  private void k() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.l = bundle.getString("video_path");
      this.t = bundle.getInt("msg_burn_after_reading_position", -1);
    } 
    this.u = false;
  }
  
  private void l() {
    this.h = LayoutInflater.from(this.f);
    View view = this.g.findViewById(2131300142);
    this.i = (SurfaceVideoView)view.findViewById(2131300236);
    this.j = (ImageView)view.findViewById(2131301605);
    this.k = (CircleProgressView)view.findViewById(2131299530);
    this.n = (LinearLayout)this.g.findViewById(2131299752);
    this.o = (TextView)this.g.findViewById(2131297067);
    this.p = (TextView)this.g.findViewById(2131299877);
    this.q = (LinearLayout)this.g.findViewById(2131301597);
    this.r = (ProgressBar)this.g.findViewById(2131301600);
    this.s = (ProgressBar)this.g.findViewById(2131299159);
    this.k.setVisibility(8);
    a(new Runnable(this) {
          public void run() {
            ShowVideoDestroyFragment.a(this.a).setVisibility(0);
            this.a.a();
          }
        },  500L);
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            LiveFloatManager.a().k();
            this.a.getActivity().finish();
          }
        });
  }
  
  public boolean V_() {
    LiveFloatManager.a().k();
    a(this.u);
    return super.V_();
  }
  
  public void a() {
    VideoLoadController.a(this.l);
    this.k.setVisibility(0);
    this.j.setVisibility(8);
    VideoLoadController.IVideoController iVideoController = new VideoLoadController.IVideoController(this) {
        public void a(String param1String) {
          ShowVideoDestroyFragment.c(this.a).setImageResource(2131234393);
          ShowVideoDestroyFragment.c(this.a).setVisibility(0);
          ShowVideoDestroyFragment.a(this.a).setVisibility(8);
          ShowVideoDestroyFragment.b(this.a).setVisibility(8);
          AppMethods.a(AppInfo.d().getResources().getString(2131758203));
          this.a.a(new Runnable(this) {
                public void run() {
                  this.a.a.a(false);
                }
              },  1000L);
        }
        
        public void a(String param1String, int param1Int) {
          ShowVideoDestroyFragment.a(this.a).setVisibility(0);
          ShowVideoDestroyFragment.b(this.a).setVisibility(0);
          ShowVideoDestroyFragment.c(this.a).setVisibility(8);
          ShowVideoDestroyFragment.a(this.a).c();
          ShowVideoDestroyFragment.a(this.a).a(param1Int, 100L);
          Logger.a("ddrb", new Object[] { "onDownloading = ", Integer.valueOf(param1Int) });
        }
        
        public void a(String param1String1, String param1String2) {
          ShowVideoDestroyFragment.a(this.a).d();
          ShowVideoDestroyFragment.d(this.a).setVisibility(0);
          ShowVideoDestroyFragment.e(this.a).setVisibility(0);
          ShowVideoDestroyFragment.b(this.a).setVisibility(8);
          ShowVideoDestroyFragment.h(this.a).setOnTouchListener(new View.OnTouchListener(this, param1String2) {
                public boolean onTouch(View param2View, MotionEvent param2MotionEvent) {
                  int i = param2MotionEvent.getAction();
                  if (i != 0) {
                    if (i != 1) {
                      if (i != 2) {
                        if (i != 3)
                          return true; 
                        this.b.a.a(true);
                        return true;
                      } 
                    } else {
                      this.b.a.a(true);
                      return true;
                    } 
                  } else {
                    ShowVideoDestroyFragment.f(this.b.a).setVisibility(0);
                    ShowVideoDestroyFragment.g(this.b.a).a(this.a, false);
                    ShowVideoDestroyFragment.a(this.b.a, true);
                  } 
                  return true;
                }
              });
        }
      };
    VideoLoadController.a(this.l, iVideoController);
    this.i.setOnStateChangeListener(new SurfaceVideoView.OnStateChangeListener(this) {
          public void a() {
            Logger.a("ddrb", new Object[] { "onSurfaceTextureDestroyed" });
            ShowVideoDestroyFragment.g(this.a).b();
            ShowVideoDestroyFragment.a(this.a).setVisibility(0);
            ShowVideoDestroyFragment.c(this.a).setVisibility(8);
            VideoLoadController.b(ShowVideoDestroyFragment.i(this.a), ShowVideoDestroyFragment.j(this.a));
          }
          
          public void a(int param1Int1, int param1Int2) {
            Logger.a("ddrb", new Object[] { "max = ", Integer.valueOf(param1Int1), "--", "progress = ", Integer.valueOf(param1Int2) });
          }
          
          public void b() {
            ShowVideoDestroyFragment.a(this.a).setVisibility(8);
            ShowVideoDestroyFragment.c(this.a).setVisibility(8);
            ShowVideoDestroyFragment.k(this.a).setMax(ShowVideoDestroyFragment.g(this.a).getMediaPlayer().getDuration());
            this.a.d.post(this.a.e);
          }
          
          public void c() {
            ShowVideoDestroyFragment.a(this.a).d();
            ShowVideoDestroyFragment.c(this.a).setVisibility(8);
            Logger.a("ddrb", new Object[] { "onBuffering" });
          }
          
          public void d() {
            this.a.a(new Runnable(this) {
                  public void run() {
                    ShowVideoDestroyFragment.a(this.a.a).setVisibility(8);
                    ShowVideoDestroyFragment.c(this.a.a).setVisibility(0);
                  }
                });
          }
          
          public void e() {
            Logger.a("ddrb", new Object[] { "onError---" });
            ShowVideoDestroyFragment.c(this.a).setImageResource(2131234393);
            ShowVideoDestroyFragment.c(this.a).setVisibility(0);
            ShowVideoDestroyFragment.a(this.a).setVisibility(8);
          }
        });
  }
  
  public void a(boolean paramBoolean) {
    if (getActivity() != null) {
      ActivityChangeAnimationUtils.h((Activity)getActivity());
      if (paramBoolean) {
        Intent intent = new Intent();
        intent.putExtra("msg_burn_after_reading_position", this.t);
        getActivity().setResult(-1, intent);
      } 
      getActivity().finish();
    } 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.f = (Context)getActivity();
    getActivity().getWindow().addFlags(8192);
    View view = this.g;
    if (view == null) {
      this.g = paramLayoutInflater.inflate(2131493323, paramViewGroup, false);
      k();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.g.getParent()).removeView(this.g);
    } 
    return this.g;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\ShowVideoDestroyFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */