package com.soft.blued.ui.qr_scan;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.qrcode.ImageReader;
import com.blued.android.framework.qrcode.camera.CameraManager;
import com.blued.android.framework.qrcode.decoding.CaptureActivityHandler;
import com.blued.android.framework.qrcode.decoding.InactivityTimer;
import com.blued.android.framework.qrcode.decoding.OnCaptureHandlerListener;
import com.blued.android.framework.urlroute.BluedUrlUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.google.common.base.Charsets;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.soft.blued.app.permission.PermissionHelper;
import com.soft.blued.http.BluedHttpUrl;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.UserQrFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Vector;

public class CaptureActivity extends BaseActivity implements SurfaceHolder.Callback, OnCaptureHandlerListener {
  boolean e = true;
  
  private CaptureActivityHandler f;
  
  private ImageView g;
  
  private boolean h;
  
  private Vector<BarcodeFormat> i;
  
  private String j;
  
  private InactivityTimer k;
  
  private MediaPlayer l;
  
  private boolean m;
  
  private boolean n;
  
  private String o;
  
  private RelativeLayout p;
  
  private Rect q = null;
  
  private ImageView r;
  
  private final MediaPlayer.OnCompletionListener s = new MediaPlayer.OnCompletionListener(this) {
      public void onCompletion(MediaPlayer param1MediaPlayer) {
        param1MediaPlayer.seekTo(0);
      }
    };
  
  private void a(SurfaceHolder paramSurfaceHolder) {
    try {
      CameraManager.a().a(paramSurfaceHolder);
      f();
      if (this.f == null)
        this.f = new CaptureActivityHandler(this, this.i, this.j); 
      return;
    } catch (IOException|RuntimeException iOException) {
      return;
    } 
  }
  
  private void a(String paramString) {
    if (StringUtils.i(paramString)) {
      if (paramString.contains(BluedHttpUrl.a())) {
        Bundle bundle1 = new Bundle();
        bundle1.putString(ScanLoginFragment.d, paramString);
        TerminalActivity.d((Context)this, ScanLoginFragment.class, bundle1);
        return;
      } 
      if (paramString.contains("https://app.blued.cn/user") || paramString.contains("https://common.blued.com/user")) {
        Map map = BluedUrlUtils.a(paramString);
        String str1 = null;
        if (map != null)
          str1 = (String)map.get("id"); 
        String str2 = str1;
        if (!TextUtils.isEmpty(str1))
          str2 = EncryptTool.a(str1); 
        if (!TextUtils.isEmpty(str2)) {
          UserInfoFragmentNew.a((Context)this, str2, "");
          return;
        } 
      } 
      WebViewShowInfoFragment.show((Context)this, paramString, 7);
      return;
    } 
    Bundle bundle = new Bundle();
    bundle.putString(ScanResultFragment.d, paramString);
    TerminalActivity.d((Context)this, ScanResultFragment.class, bundle);
  }
  
  private String b(String paramString) {
    String str = "";
    try {
      if (Charset.forName("ISO-8859-1").newEncoder().canEncode(paramString)) {
        paramString = new String(paramString.getBytes(Charsets.b), "GB2312");
        try {
          Logger.b("1234      ISO8859-1", new Object[] { paramString });
          return paramString;
        } catch (UnsupportedEncodingException null) {}
      } else {
        try {
          Logger.b("1234      stringExtra", new Object[] { paramString });
          return paramString;
        } catch (UnsupportedEncodingException null) {}
      } 
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      paramString = str;
    } 
    unsupportedEncodingException.printStackTrace();
    return paramString;
  }
  
  private void e() {
    findViewById(2131299220).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.finish();
          }
        });
    findViewById(2131299222).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            CaptureActivity.a(this.a);
          }
        });
    this.g = (ImageView)findViewById(2131299221);
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.d();
          }
        });
    findViewById(2131299352).setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            TerminalActivity.d((Context)this.a, UserQrFragment.class, null);
          }
        });
    this.p = (RelativeLayout)findViewById(2131296640);
    this.r = (ImageView)findViewById(2131296641);
  }
  
  private void f() {
    int i = (CameraManager.a().c()).y;
    int j = (CameraManager.a().c()).x;
    int[] arrayOfInt = new int[2];
    this.p.getLocationInWindow(arrayOfInt);
    int i3 = arrayOfInt[0];
    int i2 = arrayOfInt[1];
    int k = this.p.getWidth();
    int m = this.p.getHeight();
    Display display = ((WindowManager)getSystemService("window")).getDefaultDisplay();
    int n = display.getWidth();
    int i1 = display.getHeight();
    i3 = i3 * i / n;
    i2 = i2 * j / i1;
    this.q = new Rect(i3, i2, k * i / n + i3, m * j / i1 + i2);
  }
  
  private void g() {
    PhotoSelectFragment.a((Context)this, 6, 6, false);
  }
  
  private void h() {
    if (this.m && this.l == null) {
      setVolumeControlStream(3);
      this.l = new MediaPlayer();
      this.l.setAudioStreamType(3);
      this.l.setOnCompletionListener(this.s);
      AssetFileDescriptor assetFileDescriptor = getResources().openRawResourceFd(2131689474);
      try {
        this.l.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        assetFileDescriptor.close();
        this.l.setVolume(0.1F, 0.1F);
        this.l.prepare();
        return;
      } catch (IOException iOException) {
        this.l = null;
      } 
    } 
  }
  
  private void i() {
    if (this.m) {
      MediaPlayer mediaPlayer = this.l;
      if (mediaPlayer != null)
        mediaPlayer.start(); 
    } 
    if (this.n)
      ((Vibrator)getSystemService("vibrator")).vibrate(200L); 
  }
  
  public void a(int paramInt, Intent paramIntent) {
    setResult(paramInt, paramIntent);
    finish();
  }
  
  public void a(Intent paramIntent) {
    startActivity(paramIntent);
  }
  
  public void a(Result paramResult, Bitmap paramBitmap) {
    this.k.a();
    i();
    a(b(paramResult.toString()));
    finish();
  }
  
  public Handler aZ_() {
    return (Handler)this.f;
  }
  
  public Rect b() {
    return this.q;
  }
  
  protected void d() {
    if (this.e == true) {
      this.e = false;
      CameraManager.a().f();
      this.g.setImageResource(2131232697);
      return;
    } 
    this.e = true;
    CameraManager.a().g();
    this.g.setImageResource(2131232696);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      if (paramInt1 != 6)
        return; 
      if (paramIntent == null)
        return; 
      this.o = paramIntent.getStringExtra("photo_path");
      if (!TextUtils.isEmpty(this.o))
        (new ImageReader()).a(this.o, new ImageReader.OnReadFinishListener(this) {
              public void a(String param1String1, String param1String2) {
                if (TextUtils.isEmpty(param1String2)) {
                  AppMethods.d(2131758645);
                  return;
                } 
                CaptureActivity.a(this.a, param1String2);
                this.a.finish();
              }
            }); 
    } 
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    StatusBarHelper.a((Activity)this, false);
    setContentView(2131493946);
    CameraManager.a((Context)getApplication());
    e();
    this.h = false;
    this.k = new InactivityTimer((Activity)this);
    TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0F, 2, 0.0F, 2, -1.0F, 2, 0.2F);
    translateAnimation.setDuration(1800L);
    translateAnimation.setRepeatCount(-1);
    translateAnimation.setRepeatMode(1);
    this.r.startAnimation((Animation)translateAnimation);
    PermissionHelper.b(null);
  }
  
  public void onDestroy() {
    this.k.b();
    super.onDestroy();
  }
  
  public void onPause() {
    super.onPause();
    CaptureActivityHandler captureActivityHandler = this.f;
    if (captureActivityHandler != null) {
      captureActivityHandler.a();
      this.f = null;
    } 
    CameraManager.a().b();
  }
  
  public void onResume() {
    super.onResume();
    SurfaceHolder surfaceHolder = ((SurfaceView)findViewById(2131299223)).getHolder();
    if (this.h) {
      a(surfaceHolder);
    } else {
      surfaceHolder.addCallback(this);
      surfaceHolder.setType(3);
    } 
    this.i = null;
    this.j = null;
    this.m = true;
    if (((AudioManager)getSystemService("audio")).getRingerMode() != 2)
      this.m = false; 
    h();
    this.n = true;
  }
  
  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder) {
    if (!this.h) {
      this.h = true;
      a(paramSurfaceHolder);
    } 
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder) {
    this.h = false;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\qr_scan\CaptureActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */