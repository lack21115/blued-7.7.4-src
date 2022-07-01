package com.baidu.mobads.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class o implements Observer {
  private Context a;
  
  private URL b = null;
  
  private String c = null;
  
  private final e d;
  
  private a e;
  
  private SharedPreferences f;
  
  private SharedPreferences.OnSharedPreferenceChangeListener g = new p(this);
  
  public o(Context paramContext, String paramString, e parame, a parama) {
    this.c = paramString;
    this.d = parame;
    a(paramContext, parama);
  }
  
  public o(Context paramContext, URL paramURL, e parame, a parama) {
    this.b = paramURL;
    this.d = parame;
    a(paramContext, parama);
  }
  
  private void a(Context paramContext, a parama) {
    this.a = paramContext;
    this.e = parama;
    this.f = this.a.getSharedPreferences("__xadsdk_downloaded__version__", 0);
    this.f.registerOnSharedPreferenceChangeListener(this.g);
  }
  
  public void a(String paramString1, String paramString2) {
    URL uRL;
    IOAdDownloaderManager iOAdDownloaderManager = XAdSDKFoundationFacade.getInstance().getDownloaderManager(this.a);
    String str = this.c;
    if (str != null) {
      uRL = new URL(str);
    } else {
      uRL = this.b;
    } 
    IOAdDownloader iOAdDownloader = iOAdDownloaderManager.createSimpleFileDownloader(uRL, paramString1, paramString2, false);
    iOAdDownloader.addObserver(this);
    iOAdDownloader.start();
    SharedPreferences.Editor editor = this.f.edit();
    editor.putString("version", this.d.toString());
    if (Build.VERSION.SDK_INT >= 9) {
      editor.apply();
      return;
    } 
    editor.commit();
  }
  
  public void update(Observable paramObservable, Object paramObject) {
    IOAdDownloader iOAdDownloader = (IOAdDownloader)paramObservable;
    if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED)
      this.e.a(new e(this.d, iOAdDownloader.getOutputPath(), Boolean.valueOf(true))); 
    if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR)
      this.e.b(new e(this.d, iOAdDownloader.getOutputPath(), Boolean.valueOf(false))); 
  }
  
  public static interface a {
    void a(e param1e);
    
    void b(e param1e);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */