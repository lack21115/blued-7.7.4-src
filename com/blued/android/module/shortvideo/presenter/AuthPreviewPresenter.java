package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.blued.android.module.base.http.PublishProxy;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IAuthPreviewView;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.qiniu.pili.droid.shortvideo.PLMediaFile;
import java.io.File;

public class AuthPreviewPresenter extends ShortVideoBasePresent<IAuthPreviewView> {
  private static final String a = AuthPreviewPresenter.class.getSimpleName();
  
  private GestureDetector b;
  
  private File c;
  
  private String d;
  
  private int g;
  
  private boolean h = false;
  
  private Bundle i;
  
  private GestureDetector.OnGestureListener j = new GestureDetector.OnGestureListener(this) {
      public boolean onDown(MotionEvent param1MotionEvent) {
        return false;
      }
      
      public boolean onFling(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
        return false;
      }
      
      public void onLongPress(MotionEvent param1MotionEvent) {}
      
      public boolean onScroll(MotionEvent param1MotionEvent1, MotionEvent param1MotionEvent2, float param1Float1, float param1Float2) {
        return false;
      }
      
      public void onShowPress(MotionEvent param1MotionEvent) {}
      
      public boolean onSingleTapUp(MotionEvent param1MotionEvent) {
        if (AuthPreviewPresenter.a(this.a)) {
          this.a.m();
        } else {
          this.a.l();
          this.a.k();
        } 
        return true;
      }
    };
  
  public AuthPreviewPresenter(Bundle paramBundle) {
    this.i = paramBundle;
  }
  
  private void b(int paramInt) {
    StvLogUtils.a(paramInt);
  }
  
  public void a() {
    StringBuilder stringBuilder;
    Bundle bundle2 = this.i;
    Bundle bundle1 = bundle2;
    if (bundle2 == null)
      bundle1 = D().getArguments(); 
    if (bundle1 == null) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append("EditPresenter bundle == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      b(R.string.common_net_error);
      D().b();
      return;
    } 
    String str = stringBuilder.getString("video_path");
    this.g = stringBuilder.getInt("from", 0);
    if (TextUtils.isEmpty(str)) {
      b(R.string.common_net_error);
      D().b();
      return;
    } 
    this.c = new File(str);
    if (!this.c.exists()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append("EditPresenter commonModel 视频文件不存在！！！");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      b(R.string.common_net_error);
      D().b();
      return;
    } 
    this.d = str;
    PLMediaFile pLMediaFile = new PLMediaFile(str);
    int j = pLMediaFile.getVideoWidth();
    int k = pLMediaFile.getVideoHeight();
    int i = (D().getContext().getResources().getDisplayMetrics()).widthPixels;
    j = (int)(i * 1.0F / j * k);
    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)D().a().getLayoutParams();
    layoutParams.width = i;
    layoutParams.height = j;
    layoutParams.gravity = 17;
    D().a().setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    D().a().setVideoPath(this.d);
    D().a().setOnPreparedListener(new MediaPlayer.OnPreparedListener(this) {
          public void onPrepared(MediaPlayer param1MediaPlayer) {
            param1MediaPlayer.setVolume(0.0F, 0.0F);
            param1MediaPlayer.setLooping(true);
            if (!AuthPreviewPresenter.a(this.a) && this.a.D() != null && this.a.D().getActivity() != null && !this.a.D().getActivity().isFinishing())
              this.a.D().a_(new Runnable(this) {
                    public void run() {
                      this.a.a.a(0);
                      this.a.a.m();
                    }
                  },  300L); 
          }
        });
    this.b = new GestureDetector(D().getContext(), this.j);
    D().a().setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            AuthPreviewPresenter.b(this.a).onTouchEvent(param1MotionEvent);
            return true;
          }
        });
  }
  
  public void a(int paramInt) {
    if (D() != null)
      D().a().seekTo(paramInt); 
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Bundle paramBundle) {}
  
  public void b() {}
  
  public void c() {
    l();
    if (D() != null)
      D().a().start(); 
  }
  
  public void d() {}
  
  public void e() {
    m();
  }
  
  public void f() {}
  
  public boolean g() {
    n();
    return false;
  }
  
  public void h() {
    File file = this.c;
    if (file != null)
      file.delete(); 
  }
  
  public void i() {
    PublishProxy.a().a(D().getContext(), this.d, this.g, new PublishProxy.IUploadAuthVideoListener(this) {
          public void a(int param1Int, String param1String) {
            if (a())
              return; 
            this.a.D().a(param1String);
          }
          
          public void a(String param1String, double param1Double) {
            if (a())
              return; 
            if (param1Double <= 1.0D) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(AuthPreviewPresenter.o());
              stringBuilder.append("percent = ");
              stringBuilder.append(param1Double);
              StvLogUtils.a(stringBuilder.toString(), new Object[0]);
              int i = (int)(100.0D * param1Double);
              if (i == 100 || i > 99) {
                this.a.D().a(99.0F);
                return;
              } 
              if (param1Double > 30.0D) {
                this.a.D().a(i);
                return;
              } 
            } 
          }
          
          public boolean a() {
            if (this.a.D() == null || this.a.D().getActivity() == null || this.a.D().getActivity().isFinishing()) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(AuthPreviewPresenter.o());
              stringBuilder.append(" getView() == null!!!");
              StvLogUtils.a(stringBuilder.toString(), new Object[0]);
              return true;
            } 
            return false;
          }
          
          public void b() {
            if (a())
              return; 
            if (AuthPreviewPresenter.c(this.a) == 1) {
              this.a.j();
              return;
            } 
            this.a.D().Y_();
          }
        });
  }
  
  public void j() {
    PublishProxy.a().a(D().getContext(), this.g, new PublishProxy.ILiveApplyListener(this) {
          public void a() {
            this.a.D().Y_();
          }
          
          public void a(int param1Int, String param1String) {
            this.a.D().Z_();
          }
        });
  }
  
  public void k() {
    if (D() != null) {
      D().a().start();
      D().e();
      this.h = true;
    } 
  }
  
  public void l() {
    D().a().resume();
  }
  
  public void m() {
    if (D() != null) {
      D().a().pause();
      D().d();
      this.h = false;
    } 
  }
  
  public void n() {
    if (D() != null) {
      D().a().stopPlayback();
      this.h = false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\presenter\AuthPreviewPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */