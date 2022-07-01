package com.soft.blued.ui.video.manager;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.util.Log;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.player.audio.IAudioPlayer;
import com.blued.android.module.shortvideo.utils.DialogUtils;
import java.io.File;
import java.net.URLEncoder;

public class MusicManager {
  public static String a = "";
  
  public static String a() {
    return AppMethods.b("ShortVideoMusic");
  }
  
  public static String a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(URLEncoder.encode(paramString.toLowerCase().trim()));
    stringBuilder.append(".mp3");
    return stringBuilder.toString();
  }
  
  public static void a(IAudioPlayer paramIAudioPlayer) {
    paramIAudioPlayer.b();
  }
  
  public static void a(IAudioPlayer paramIAudioPlayer, String paramString1, String paramString2) {
    String str;
    File file = new File(a(), a(paramString2));
    if (file.exists()) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("file:/");
      stringBuilder.append(file.getAbsolutePath());
      str = stringBuilder.toString();
    } 
    paramIAudioPlayer.a(str).a(true).a();
  }
  
  public static boolean a(ProgressDialog paramProgressDialog, BaseFragment paramBaseFragment, String paramString1, String paramString2, ICallBack paramICallBack) {
    StringBuilder stringBuilder1;
    String str = a();
    paramString2 = a(paramString2);
    File file = new File(str, paramString2);
    a = "";
    if (file.exists()) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("/");
      stringBuilder1.append(paramString2);
      paramICallBack.a(stringBuilder1.toString());
      return false;
    } 
    stringBuilder1.setOnDismissListener(new DialogInterface.OnDismissListener(str, paramString2) {
          public void onDismiss(DialogInterface param1DialogInterface) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("/");
            stringBuilder.append(this.b);
            MusicManager.a = stringBuilder.toString();
          }
        });
    paramBaseFragment.a(new Runnable((ProgressDialog)stringBuilder1) {
          public void run() {
            DialogUtils.a((Dialog)this.a);
          }
        });
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str);
    stringBuilder2.append("/");
    stringBuilder2.append(paramString2);
    FileDownloader.a(paramString1, stringBuilder2.toString(), new FileHttpResponseHandler(paramBaseFragment, (ProgressDialog)stringBuilder1, str, paramString2, paramICallBack) {
          boolean a = false;
          
          boolean b = false;
          
          public void a(File param1File) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onSuccess file");
            stringBuilder.append(param1File.getName());
            Log.d("chenjiemei", stringBuilder.toString());
          }
          
          public void a(Throwable param1Throwable, int param1Int, File param1File) {
            this.a = true;
            super.onFailure(param1Throwable, param1Int, param1File);
          }
          
          public void onFinish() {
            super.onFinish();
            this.b = true;
            this.c.a(new Runnable(this) {
                  public void run() {
                    if (!this.a.a) {
                      String str = MusicManager.a;
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append(this.a.e);
                      stringBuilder.append("/");
                      stringBuilder.append(this.a.f);
                      if (!str.equalsIgnoreCase(stringBuilder.toString())) {
                        MusicManager.a = "";
                        MusicManager.ICallBack iCallBack = this.a.g;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(this.a.e);
                        stringBuilder.append("/");
                        stringBuilder.append(this.a.f);
                        iCallBack.a(stringBuilder.toString());
                      } 
                    } 
                    DialogUtils.b((Dialog)this.a.d);
                  }
                });
          }
          
          public void onProgress(int param1Int1, int param1Int2) {
            this.c.a(new Runnable(this, param1Int1) {
                  public void run() {
                    this.b.d.setProgress(this.a);
                    if (this.a == 100)
                      this.b.c.a(new Runnable(this) {
                            public void run() {
                              if (!this.a.b.b && !this.a.b.a) {
                                String str = MusicManager.a;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(this.a.b.e);
                                stringBuilder.append("/");
                                stringBuilder.append(this.a.b.f);
                                if (!str.equalsIgnoreCase(stringBuilder.toString())) {
                                  MusicManager.a = "";
                                  DialogUtils.b((Dialog)this.a.b.d);
                                  MusicManager.ICallBack iCallBack = this.a.b.g;
                                  stringBuilder = new StringBuilder();
                                  stringBuilder.append(this.a.b.e);
                                  stringBuilder.append("/");
                                  stringBuilder.append(this.a.b.f);
                                  iCallBack.a(stringBuilder.toString());
                                } 
                              } 
                            }
                          },  3000L); 
                  }
                });
            super.onProgress(param1Int1, param1Int2);
          }
          
          public void onStart() {
            this.a = false;
            this.b = false;
            this.c.a(new Runnable(this) {
                  public void run() {
                    DialogUtils.a((Dialog)this.a.d);
                  }
                });
            super.onStart();
          }
        }null);
    return true;
  }
  
  public static interface ICallBack {
    void a(String param1String);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\video\manager\MusicManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */