package com.blued.android.module.shortvideo.presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.module.shortvideo.R;
import com.blued.android.module.shortvideo.contract.IAuthRecorderView;
import com.blued.android.module.shortvideo.fragment.AuthPreviewFragment;
import com.blued.android.module.shortvideo.utils.StvCameraUtils;
import com.blued.android.module.shortvideo.utils.StvConfig;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.blued.android.module.shortvideo.utils.VideoConfigData;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLFocusListener;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordStateListener;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEnv;
import com.qiniu.pili.droid.shortvideo.PLShortVideoRecorder;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;

public class AuthRecorderPresenter extends ShortVideoBasePresent<IAuthRecorderView> implements PLFocusListener, PLRecordStateListener, PLVideoSaveListener {
  private static final String a = AuthPreviewPresenter.class.getSimpleName();
  
  private PLShortVideoRecorder b;
  
  private PLRecordSetting c;
  
  private PLCameraSetting d;
  
  private Bundle g;
  
  private int h;
  
  public AuthRecorderPresenter(Bundle paramBundle) {
    this.g = paramBundle;
  }
  
  private void a(String paramString) {
    StvLogUtils.a(paramString);
  }
  
  private void m() {
    this.b = new PLShortVideoRecorder();
    this.b.setRecordStateListener(this);
    this.b.setFocusListener(this);
    this.d = new PLCameraSetting();
    PLCameraSetting.CAMERA_FACING_ID cAMERA_FACING_ID = StvCameraUtils.a();
    this.d.setCameraId(cAMERA_FACING_ID);
    this.d.setCameraPreviewSizeRatio(VideoConfigData.a());
    PLMicrophoneSetting pLMicrophoneSetting = new PLMicrophoneSetting();
    PLVideoEncodeSetting pLVideoEncodeSetting = new PLVideoEncodeSetting(D().getContext());
    pLVideoEncodeSetting.setPreferredEncodingSize(720, 1280);
    pLVideoEncodeSetting.setEncodingFps(30);
    pLVideoEncodeSetting.setEncodingBitrate(VideoConfigData.c());
    pLVideoEncodeSetting.setHWCodecEnabled(VideoConfigData.a.booleanValue());
    PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
    pLAudioEncodeSetting.setHWCodecEnabled(false);
    this.c = new PLRecordSetting();
    this.c.setVideoCacheDir(StvConfig.b());
    this.c.setVideoFilepath(StvTools.a());
    this.c.setDisplayMode(PLDisplayMode.FULL);
    this.c.setMaxRecordDuration(5000L);
    this.b.prepare(D().a(), this.d, pLMicrophoneSetting, pLVideoEncodeSetting, pLAudioEncodeSetting, null, this.c);
    this.b.setRecordSpeed(1.0D);
  }
  
  public void a() {
    Bundle bundle2 = this.g;
    Bundle bundle1 = bundle2;
    if (bundle2 == null)
      bundle1 = D().getArguments(); 
    if (bundle1 != null)
      this.h = bundle1.getInt("from", 0); 
    if (StvCameraUtils.b() <= 0) {
      StvLogUtils.a("不支持摄像头");
      D().c();
      return;
    } 
    if (!AppInfo.m())
      PLShortVideoEnv.setLogLevel(7); 
    m();
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == 0)
      return; 
    paramActivity.setResult(paramInt1, paramIntent);
    if (paramInt1 != 9) {
      paramActivity.finish();
      return;
    } 
    paramActivity.finish();
  }
  
  public void a(Bundle paramBundle) {}
  
  public void b() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("destroy()");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    PLShortVideoRecorder pLShortVideoRecorder = this.b;
    if (pLShortVideoRecorder != null)
      pLShortVideoRecorder.destroy(); 
  }
  
  public void c() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("resume()");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    this.b.resume();
  }
  
  public void d() {}
  
  public void e() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("pause()");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    this.b.pause();
    i();
  }
  
  public void f() {}
  
  public boolean g() {
    k();
    return false;
  }
  
  public boolean h() {
    boolean bool = this.b.beginSection();
    if (bool && D() != null)
      D().e(); 
    return bool;
  }
  
  public boolean i() {
    return this.b.deleteLastSection();
  }
  
  public void j() {
    this.b.concatSections(this);
  }
  
  public void k() {
    this.b.cancelConcat();
  }
  
  public void onAutoFocusStart() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("auto focus start");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public void onAutoFocusStop() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("auto focus stop");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public void onDurationTooShort() {
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this) {
          public void run() {
            this.a.i();
            this.a.D().b(false);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(AuthRecorderPresenter.l());
            stringBuilder.append(" 录制视频太短！！！");
            StvLogUtils.a(stringBuilder.toString(), new Object[0]);
            AuthRecorderPresenter.a(this.a, "时间过短，无法完成录制");
          }
        });
  }
  
  public void onError(int paramInt) {
    CharSequence charSequence;
    if (paramInt == 4) {
      charSequence = "摄像头配置错误";
    } else if (paramInt == 5) {
      charSequence = "麦克风配置错误";
    } else {
      charSequence = null;
    } 
    if (!TextUtils.isEmpty(charSequence))
      StvLogUtils.a((String)charSequence, new Object[0]); 
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      charSequence = new StringBuilder();
      charSequence.append(a);
      charSequence.append(" getView() == null!!!");
      StvLogUtils.a(charSequence.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this) {
          public void run() {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a.D().getContext());
            builder.setMessage("相机没有正常启动，请重新开始");
            builder.setPositiveButton("确认", new DialogInterface.OnClickListener(this) {
                  public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                    this.a.a.D().a(false);
                  }
                });
            builder.create().show();
          }
        });
  }
  
  public void onManualFocusCancel() {}
  
  public void onManualFocusStart(boolean paramBoolean) {}
  
  public void onManualFocusStop(boolean paramBoolean) {}
  
  public void onProgressUpdate(float paramFloat) {
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
  }
  
  public void onReady() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("onReady()");
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this) {
          public void run() {
            this.a.D().d();
          }
        });
  }
  
  public void onRecordCompleted() {
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this) {
          public void run() {
            this.a.j();
            this.a.D().ac_();
          }
        });
  }
  
  public void onRecordStarted() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("record start time: ");
    stringBuilder.append(System.currentTimeMillis());
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
  }
  
  public void onRecordStopped() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("record stop time: ");
    stringBuilder.append(System.currentTimeMillis());
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
  }
  
  public void onSaveVideoCanceled() {
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this) {
          public void run() {
            this.a.i();
            this.a.D().b(false);
          }
        });
  }
  
  public void onSaveVideoFailed(int paramInt) {
    if (D() == null || D().getActivity() == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(a);
      stringBuilder.append(" getView() == null");
      StvLogUtils.a(stringBuilder.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this, paramInt) {
          public void run() {
            this.b.i();
            this.b.D().b(false);
            String str = this.b.D().getContext().getString(R.string.stv_video_progress_error);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" :");
            stringBuilder.append(this.a);
            StvLogUtils.a(stringBuilder.toString(), new Object[0]);
            AuthRecorderPresenter.a(this.b, str);
          }
        });
  }
  
  public void onSaveVideoSuccess(String paramString) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(a);
    stringBuilder2.append("concat sections success filePath: ");
    stringBuilder2.append(paramString);
    StvLogUtils.a(stringBuilder2.toString(), new Object[0]);
    if (D() == null || D().getActivity() == null || D().getActivity().isFinishing()) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(a);
      stringBuilder1.append(" getView() == null!!!");
      StvLogUtils.a(stringBuilder1.toString(), new Object[0]);
      return;
    } 
    D().a_(new Runnable(this, (String)stringBuilder1) {
          public void run() {
            this.b.D().ab_();
            this.b.D().b(false);
            this.b.i();
            AuthPreviewFragment.a(this.b.D().b(), this.a, AuthRecorderPresenter.a(this.b), 9);
          }
        });
  }
  
  public void onSectionDecreased(long paramLong1, long paramLong2, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("section decreased decDuration: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append(" totalDuration: ");
    stringBuilder.append(paramLong2);
    stringBuilder.append(" sectionCount: ");
    stringBuilder.append(paramInt);
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public void onSectionIncreased(long paramLong1, long paramLong2, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a);
    stringBuilder.append("section increased incDuration: ");
    stringBuilder.append(paramLong1);
    stringBuilder.append(" totalDuration: ");
    stringBuilder.append(paramLong2);
    stringBuilder.append(" sectionCount: ");
    stringBuilder.append(paramInt);
    StvLogUtils.a(stringBuilder.toString(), new Object[0]);
  }
  
  public void onSectionRecording(long paramLong1, long paramLong2, int paramInt) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\presenter\AuthRecorderPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */