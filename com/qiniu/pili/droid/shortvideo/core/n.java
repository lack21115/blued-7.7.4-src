package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import com.qiniu.pili.droid.shortvideo.PLAudioEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLAudioMixMode;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLFaceBeautySetting;
import com.qiniu.pili.droid.shortvideo.PLMediaFile;
import com.qiniu.pili.droid.shortvideo.PLMicrophoneSetting;
import com.qiniu.pili.droid.shortvideo.PLRecordSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoMixSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.e.b;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.process.a.f;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.a;
import com.qiniu.pili.droid.shortvideo.transcoder.audio.c;
import java.util.Stack;
import org.json.JSONObject;

public class n extends p {
  private boolean A = true;
  
  private boolean B = false;
  
  private boolean C = true;
  
  private Stack<Integer> D = new Stack<Integer>();
  
  private String E;
  
  private PLAudioMixMode F = PLAudioMixMode.SPEAKERPHONE_MODE;
  
  private float G = 1.0F;
  
  private float H = 1.0F;
  
  private PLVideoSaveListener I = new PLVideoSaveListener(this) {
      public void onProgressUpdate(float param1Float) {
        n.a(this.a).onProgressUpdate(param1Float * 0.0F);
      }
      
      public void onSaveVideoCanceled() {
        n.a(this.a).onSaveVideoCanceled();
      }
      
      public void onSaveVideoFailed(int param1Int) {
        n.a(this.a).onSaveVideoFailed(param1Int);
      }
      
      public void onSaveVideoSuccess(String param1String) {
        e e = e.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoSuccess : concat save success , the camera video path is ");
        stringBuilder.append(param1String);
        e.c("ShortVideoMixRecorderCore", stringBuilder.toString());
        n.a(this.a, param1String);
      }
    };
  
  private PLVideoSaveListener J = new PLVideoSaveListener(this) {
      public void onProgressUpdate(float param1Float) {
        n.a(this.a).onProgressUpdate(param1Float * 1.0F + 0.0F);
      }
      
      public void onSaveVideoCanceled() {
        n.a(this.a).onSaveVideoCanceled();
      }
      
      public void onSaveVideoFailed(int param1Int) {
        n.a(this.a).onSaveVideoFailed(param1Int);
      }
      
      public void onSaveVideoSuccess(String param1String) {
        e e = e.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSaveVideoSuccess : mix save success , the camera video path is ");
        stringBuilder.append(param1String);
        e.c("ShortVideoMixRecorderCore", stringBuilder.toString());
        n.a(this.a).onSaveVideoSuccess(param1String);
      }
    };
  
  private Context a;
  
  private PLVideoMixSetting b;
  
  private PLVideoEncodeSetting c;
  
  private PLCameraSetting d;
  
  private b e;
  
  private f f;
  
  private PLVideoSaveListener z;
  
  public n(Context paramContext) {
    this.a = paramContext;
  }
  
  private void C() {
    if (this.B) {
      this.e.a(0.0F);
      b((String)null);
    } else {
      this.e.a(1.0F);
      PLMediaFile pLMediaFile = new PLMediaFile(this.b.getSampleVideoPath());
      if (pLMediaFile.hasAudio())
        a(this.b.getSampleVideoPath(), true); 
      pLMediaFile.release();
    } 
    a(this.A);
  }
  
  private boolean D() {
    return (!this.B && !this.A && this.F == PLAudioMixMode.EARPHONE_MODE);
  }
  
  private void d(String paramString) {
    a a;
    e.d.c("ShortVideoMixRecorderCore", "mixVideo +");
    if (this.f == null)
      this.f = new f(this.a, this.b, this.c, paramString, this.E); 
    paramString = null;
    if (D()) {
      a = new a();
      a.a(this.b.getSampleVideoPath());
      a.a(new c(this.G, this.H));
    } 
    this.f.a(a);
    this.f.a(this.J);
    e.d.c("ShortVideoMixRecorderCore", "mixVideo -");
  }
  
  public PLAudioMixMode a() {
    return this.F;
  }
  
  public void a(float paramFloat1, float paramFloat2) {
    this.G = paramFloat1;
    this.H = paramFloat2;
  }
  
  public void a(GLSurfaceView paramGLSurfaceView1, GLSurfaceView paramGLSurfaceView2, PLVideoMixSetting paramPLVideoMixSetting, PLCameraSetting paramPLCameraSetting, PLMicrophoneSetting paramPLMicrophoneSetting, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLAudioEncodeSetting paramPLAudioEncodeSetting, PLFaceBeautySetting paramPLFaceBeautySetting, PLRecordSetting paramPLRecordSetting) {
    this.d = paramPLCameraSetting;
    this.b = paramPLVideoMixSetting;
    this.c = paramPLVideoEncodeSetting;
    this.E = paramPLRecordSetting.getVideoFilepath();
    paramPLVideoEncodeSetting = PLVideoEncodeSetting.fromSetting(paramPLVideoEncodeSetting);
    Rect rect = this.b.getCameraVideoRect();
    paramPLVideoEncodeSetting.setPreferredEncodingSize(rect.width(), rect.height());
    if (rect.width() != paramPLVideoEncodeSetting.getVideoEncodingWidth() || rect.height() != paramPLVideoEncodeSetting.getVideoEncodingHeight()) {
      double d = PLCameraSetting.calcCameraPreviewSizeRatio(this.d.getCameraPreviewSizeRatio());
      int j = paramPLVideoEncodeSetting.getVideoEncodingWidth();
      int i = paramPLVideoEncodeSetting.getVideoEncodingHeight();
      if (paramPLRecordSetting.getDisplayMode() == PLDisplayMode.FIT)
        i = (int)(j * d); 
      paramPLVideoEncodeSetting.setPreferredEncodingSize(j, i);
    } 
    paramPLRecordSetting = PLRecordSetting.fromSetting(paramPLRecordSetting);
    paramPLRecordSetting.setVideoFilepath(paramPLVideoMixSetting.getCameraRecodingCachePath());
    a(paramGLSurfaceView1, paramPLCameraSetting, paramPLMicrophoneSetting, paramPLVideoEncodeSetting, paramPLAudioEncodeSetting, paramPLFaceBeautySetting, paramPLRecordSetting);
    this.e = new b(paramGLSurfaceView2);
    this.e.a(this.b.getSampleVideoPath());
    this.e.b(false);
    this.e.a(this.b.getSampleDisplayMode());
    this.e.a(0.0F);
    this.e.a();
    C();
  }
  
  public void a(PLAudioMixMode paramPLAudioMixMode) {
    e e = e.d;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAudioMixMode : ");
    stringBuilder.append(paramPLAudioMixMode);
    e.c("ShortVideoMixRecorderCore", stringBuilder.toString());
    this.F = paramPLAudioMixMode;
  }
  
  public boolean a(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getstatic com/qiniu/pili/droid/shortvideo/core/b$a.v : Lcom/qiniu/pili/droid/shortvideo/core/b$a;
    //   6: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/core/b$a;)Z
    //   9: istore_2
    //   10: iload_2
    //   11: ifne -> 18
    //   14: aload_0
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: getfield e : Lcom/qiniu/pili/droid/shortvideo/e/b;
    //   22: invokevirtual c : ()V
    //   25: aload_0
    //   26: getfield D : Ljava/util/Stack;
    //   29: aload_0
    //   30: getfield e : Lcom/qiniu/pili/droid/shortvideo/e/b;
    //   33: invokevirtual i : ()I
    //   36: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   39: invokevirtual push : (Ljava/lang/Object;)Ljava/lang/Object;
    //   42: pop
    //   43: aload_0
    //   44: aload_1
    //   45: invokespecial a : (Ljava/lang/String;)Z
    //   48: istore_2
    //   49: aload_0
    //   50: monitorexit
    //   51: iload_2
    //   52: ireturn
    //   53: astore_1
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_1
    //   57: athrow
    // Exception table:
    //   from	to	target	type
    //   2	10	53	finally
    //   18	49	53	finally
  }
  
  public void b() {
    e.d.c("ShortVideoMixRecorderCore", "cancel +");
    f f1 = this.f;
    if (f1 != null) {
      f1.a();
    } else {
      o();
    } 
    e.d.c("ShortVideoMixRecorderCore", "cancel -");
  }
  
  public void b(PLVideoSaveListener paramPLVideoSaveListener) {
    e.d.c("ShortVideoMixRecorderCore", "save +");
    this.z = paramPLVideoSaveListener;
    a(this.I);
    e.d.c("ShortVideoMixRecorderCore", "save -");
  }
  
  public void c(boolean paramBoolean) {
    e.d.c("ShortVideoMixRecorderCore", "muteMicrophone");
    this.A = paramBoolean;
    C();
  }
  
  public void d(boolean paramBoolean) {
    e.d.c("ShortVideoMixRecorderCore", "muteSampleVideo");
    this.B = paramBoolean;
    C();
  }
  
  public JSONObject h() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public boolean m() {
    int i = ((Integer)this.D.pop()).intValue();
    this.e.b(i);
    return super.m();
  }
  
  public void onSurfaceCreated() {
    super.onSurfaceCreated();
    if (this.C) {
      if (!this.B)
        this.e.a(1.0F); 
      this.e.b(1);
      this.C = false;
    } 
    this.e.b();
  }
  
  protected void s() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial s : ()V
    //   6: aload_0
    //   7: getfield e : Lcom/qiniu/pili/droid/shortvideo/e/b;
    //   10: invokevirtual b : ()V
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */