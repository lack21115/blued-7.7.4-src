package com.qiniu.pili.droid.shortvideo.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.qiniu.pili.droid.shortvideo.PLComposeItem;
import com.qiniu.pili.droid.shortvideo.PLDisplayMode;
import com.qiniu.pili.droid.shortvideo.PLVideoEncodeSetting;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import com.qiniu.pili.droid.shortvideo.PLVideoRange;
import com.qiniu.pili.droid.shortvideo.PLVideoSaveListener;
import com.qiniu.pili.droid.shortvideo.encode.b;
import com.qiniu.pili.droid.shortvideo.f.e;
import com.qiniu.pili.droid.shortvideo.f.f;
import com.qiniu.pili.droid.shortvideo.process.a.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class k {
  private Context a;
  
  private a b;
  
  private b c;
  
  private com.qiniu.pili.droid.shortvideo.transcoder.a d;
  
  private com.qiniu.pili.droid.shortvideo.process.a.a e;
  
  private f f;
  
  public k(Context paramContext) {
    e.t.c("ShortVideoComposerCore", "init +");
    this.a = paramContext.getApplicationContext();
    l.a(this.a);
    e.t.c("ShortVideoComposerCore", "init -");
  }
  
  private JSONObject a(String paramString, int paramInt) {
    JSONObject jSONObject = new JSONObject();
    try {
      jSONObject.put(paramString, paramInt);
      jSONObject.put("data_type", QosManager.a.c);
      return jSONObject;
    } catch (JSONException jSONException) {
      return null;
    } 
  }
  
  public void a() {
    a a1 = this.b;
    if (a1 != null) {
      a1.a();
      this.b = null;
      return;
    } 
    e.t.d("ShortVideoComposerCore", "No working gif thread to cancel");
  }
  
  public void a(QosManager.KeyPoint paramKeyPoint, String paramString, int paramInt) {
    QosManager.a().a(a(paramString, paramInt));
    QosManager.a().a(paramKeyPoint);
  }
  
  public void a(String paramString1, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString2, PLVideoSaveListener paramPLVideoSaveListener) {
    if (!u.a().a(b.a.T, paramPLVideoSaveListener))
      return; 
    if (paramString1 == null) {
      e.t.e("ShortVideoComposerCore", "Input media file path empty! A valid file path required!");
      return;
    } 
    if (paramInt1 <= 0) {
      e.t.e("ShortVideoComposerCore", "Illegal parameter:pictureCount. A positive integer required!");
      return;
    } 
    if (paramLong1 > paramLong2 || paramLong1 < 0L || paramLong2 < 0L) {
      e.t.e("ShortVideoComposerCore", "Illegal parameter:startTimeMs & endTimeMs. endTimeMs should be greater than startTimeMs as positive integer!");
      return;
    } 
    if (paramInt4 < 0 || paramInt4 > 120) {
      e.t.e("ShortVideoComposerCore", "Illegal parameter:gifFps. Gif frame rate should be an positive number that does not exceed 120!");
      return;
    } 
    e.t.c("ShortVideoComposerCore", "extractVideoToGIF + ");
    this.f = new f(paramString1);
    paramLong2 = (paramLong2 - paramLong1) / paramInt1;
    long l = (1000 / paramInt4);
    e e = e.t;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Gif picture count:");
    stringBuilder.append(paramInt1);
    stringBuilder.append(", picture duration:");
    stringBuilder.append(paramLong2);
    e.c("ShortVideoComposerCore", stringBuilder.toString());
    (new Thread(new Runnable(this, paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, l, paramBoolean, paramString2, paramPLVideoSaveListener) {
          public void run() {
            ArrayList<Bitmap> arrayList = new ArrayList();
            int i = 0;
            while (i < this.a) {
              long l = this.b + i * this.c;
              if (l < k.a(this.j).g()) {
                PLVideoFrame pLVideoFrame = k.a(this.j).a(l, false, this.d, this.e);
                if (pLVideoFrame != null) {
                  e e1 = e.t;
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("adding picture timestamp:");
                  stringBuilder1.append(l);
                  stringBuilder1.append(", width:");
                  stringBuilder1.append(this.d);
                  stringBuilder1.append(", height:");
                  stringBuilder1.append(this.e);
                  e1.b("ShortVideoComposerCore", stringBuilder1.toString());
                  arrayList.add(pLVideoFrame.toBitmap());
                } else {
                  e e1 = e.t;
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("cannot find picture at timestamp:");
                  stringBuilder1.append(l);
                  e1.d("ShortVideoComposerCore", stringBuilder1.toString());
                } 
                i++;
                continue;
              } 
              e e = e.t;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("targetTimestampMs ");
              stringBuilder.append(l);
              stringBuilder.append(" has exceeded video end, exit.");
              e.d("ShortVideoComposerCore", stringBuilder.toString());
            } 
            e.t.c("ShortVideoComposerCore", "composing bitmaps to gif...");
            this.j.a(arrayList, (int)this.f, this.g, this.h, this.i);
            k.a(this.j).a();
          }
        })).start();
    e.t.c("ShortVideoComposerCore", "extractVideoToGIF - ");
  }
  
  public void a(List<Bitmap> paramList, int paramInt, boolean paramBoolean, String paramString, PLVideoSaveListener paramPLVideoSaveListener) {
    if (!u.a().a(b.a.T, paramPLVideoSaveListener))
      return; 
    this.b = new a(this, paramList, paramInt, paramBoolean, paramString, paramPLVideoSaveListener);
    this.b.run();
  }
  
  public boolean a(List<String> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    if (!u.a().a(b.a.R, paramPLVideoSaveListener))
      return false; 
    if (this.c == null)
      this.c = new b(); 
    return this.c.a(paramList, paramString, paramPLVideoEncodeSetting, paramPLVideoSaveListener);
  }
  
  public boolean a(List<PLComposeItem> paramList, String paramString1, PLVideoEncodeSetting paramPLVideoEncodeSetting, String paramString2, float paramFloat1, float paramFloat2, PLVideoSaveListener paramPLVideoSaveListener) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/core/u;
    //   5: getstatic com/qiniu/pili/droid/shortvideo/core/b$a.V : Lcom/qiniu/pili/droid/shortvideo/core/b$a;
    //   8: aload #7
    //   10: invokevirtual a : (Lcom/qiniu/pili/droid/shortvideo/core/b$a;Lcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;)Z
    //   13: istore #8
    //   15: iload #8
    //   17: ifne -> 24
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: getfield e : Lcom/qiniu/pili/droid/shortvideo/process/a/a;
    //   28: ifnonnull -> 42
    //   31: aload_0
    //   32: new com/qiniu/pili/droid/shortvideo/process/a/a
    //   35: dup
    //   36: invokespecial <init> : ()V
    //   39: putfield e : Lcom/qiniu/pili/droid/shortvideo/process/a/a;
    //   42: aload_0
    //   43: getfield e : Lcom/qiniu/pili/droid/shortvideo/process/a/a;
    //   46: aload_1
    //   47: aload_2
    //   48: aload_3
    //   49: aload #4
    //   51: fload #5
    //   53: fload #6
    //   55: aload #7
    //   57: invokevirtual a : (Ljava/util/List;Ljava/lang/String;Lcom/qiniu/pili/droid/shortvideo/PLVideoEncodeSetting;Ljava/lang/String;FFLcom/qiniu/pili/droid/shortvideo/PLVideoSaveListener;)Z
    //   60: istore #8
    //   62: aload_0
    //   63: monitorexit
    //   64: iload #8
    //   66: ireturn
    //   67: astore_1
    //   68: aload_0
    //   69: monitorexit
    //   70: aload_1
    //   71: athrow
    // Exception table:
    //   from	to	target	type
    //   2	15	67	finally
    //   24	42	67	finally
    //   42	62	67	finally
  }
  
  public boolean a(List<PLComposeItem> paramList, String paramString1, boolean paramBoolean, String paramString2, PLDisplayMode paramPLDisplayMode, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    if (!u.a().a(b.a.U, paramPLVideoSaveListener))
      return false; 
    if (this.d == null)
      this.d = new com.qiniu.pili.droid.shortvideo.transcoder.a(); 
    return this.d.a(paramList, paramString1, paramBoolean, paramString2, paramPLDisplayMode, paramPLVideoEncodeSetting, paramPLVideoSaveListener);
  }
  
  public void b() {
    b b1 = this.c;
    if (b1 != null)
      b1.a(); 
  }
  
  public boolean b(List<PLVideoRange> paramList, String paramString, PLVideoEncodeSetting paramPLVideoEncodeSetting, PLVideoSaveListener paramPLVideoSaveListener) {
    if (!u.a().a(b.a.S, paramPLVideoSaveListener))
      return false; 
    if (this.c == null)
      this.c = new b(); 
    return this.c.b(paramList, paramString, paramPLVideoEncodeSetting, paramPLVideoSaveListener);
  }
  
  public void c() {
    com.qiniu.pili.droid.shortvideo.process.a.a a1 = this.e;
    if (a1 != null)
      a1.a(); 
  }
  
  public void d() {
    com.qiniu.pili.droid.shortvideo.transcoder.a a1 = this.d;
    if (a1 != null)
      a1.a(); 
  }
  
  class a extends Thread {
    private List<Bitmap> b;
    
    private int c;
    
    private boolean d;
    
    private String e;
    
    private PLVideoSaveListener f;
    
    private volatile boolean g = false;
    
    public a(k this$0, List<Bitmap> param1List, int param1Int, boolean param1Boolean, String param1String, PLVideoSaveListener param1PLVideoSaveListener) {
      this.b = param1List;
      this.c = param1Int;
      this.d = param1Boolean;
      this.e = param1String;
      this.f = param1PLVideoSaveListener;
    }
    
    void a() {
      this.g = true;
    }
    
    boolean b() {
      if (this.g && this.f != null)
        (new Handler(Looper.getMainLooper())).post(new Runnable(this) {
              public void run() {
                k.a.b(this.a).onSaveVideoCanceled();
              }
            }); 
      return this.g;
    }
    
    public void run() {
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      b b = new b();
      b.a(this.c);
      b.a(this.d);
      b.a(byteArrayOutputStream);
      Handler handler = new Handler(Looper.getMainLooper());
      for (int i = 0; i < this.b.size(); i++) {
        if (b())
          return; 
        b.a(this.b.get(i));
        if (this.f != null)
          handler.post(new Runnable(this, i) {
                public void run() {
                  k.a.b(this.b).onProgressUpdate(this.a / k.a.a(this.b).size());
                }
              }); 
      } 
      b.a();
      try {
        if (b())
          return; 
        (new FileOutputStream(new File(this.e))).write(byteArrayOutputStream.toByteArray());
        if (this.f != null) {
          if (b()) {
            (new File(this.e)).delete();
            return;
          } 
          handler.post(new Runnable(this) {
                public void run() {
                  k.a.b(this.a).onSaveVideoSuccess(k.a.c(this.a));
                }
              });
        } 
        return;
      } catch (IOException iOException) {
        e.t.e("ShortVideoComposerCore", "Error when saving gif file.");
        if (this.f != null)
          handler.post(new Runnable(this) {
                public void run() {
                  k.a.b(this.a).onSaveVideoFailed(0);
                }
              }); 
        return;
      } 
    }
  }
  
  class null implements Runnable {
    null(k this$0, int param1Int) {}
    
    public void run() {
      k.a.b(this.b).onProgressUpdate(this.a / k.a.a(this.b).size());
    }
  }
  
  class null implements Runnable {
    null(k this$0) {}
    
    public void run() {
      k.a.b(this.a).onSaveVideoFailed(0);
    }
  }
  
  class null implements Runnable {
    null(k this$0) {}
    
    public void run() {
      k.a.b(this.a).onSaveVideoSuccess(k.a.c(this.a));
    }
  }
  
  class null implements Runnable {
    null(k this$0) {}
    
    public void run() {
      k.a.b(this.a).onSaveVideoCanceled();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\core\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */