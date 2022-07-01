package com.baidu.mobads.f;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class c extends Thread {
  private static volatile c f;
  
  o.a a = new d(this);
  
  private volatile String b;
  
  private String c = null;
  
  private double d;
  
  private Handler e;
  
  private final Context g;
  
  private o h = null;
  
  private final e i;
  
  private IXAdLogger j = XAdSDKFoundationFacade.getInstance().getAdLogger();
  
  private c(Context paramContext, e parame, String paramString, Handler paramHandler) {
    this.g = paramContext;
    this.i = parame;
    a(parame.c());
    this.e = paramHandler;
    this.c = paramString;
  }
  
  public static c a(Context paramContext, e parame, String paramString, Handler paramHandler) {
    if (f == null)
      f = new c(paramContext, parame, paramString, paramHandler); 
    return f;
  }
  
  private String a() {
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append("__xadsdk__remote__final__");
    stringBuilder1.append(UUID.randomUUID().toString());
    stringBuilder1.append(".jar");
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.c);
    stringBuilder2.append(str1);
    String str2 = stringBuilder2.toString();
    File file = new File(str2);
    try {
      file.createNewFile();
      this.h.a(this.c, str1);
      return str2;
    } catch (IOException iOException) {
      file.delete();
      throw iOException;
    } 
  }
  
  private void a(String paramString1, e parame, String paramString2) {
    if (paramString1.equals("OK") || paramString1.equals("ERROR")) {
      Message message = this.e.obtainMessage();
      Bundle bundle = new Bundle();
      bundle.putParcelable("APK_INFO", parame);
      bundle.putString("CODE", paramString1);
      message.setData(bundle);
      this.e.sendMessage(message);
    } 
  }
  
  private boolean b() {
    double d;
    try {
      URL uRL = new URL(this.b);
      this.h = new o(this.g, uRL, this.i, this.a);
    } catch (MalformedURLException malformedURLException) {
      this.h = new o(this.g, this.b, this.i, this.a);
    } catch (Exception exception) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("parse apk failed, error:");
      stringBuilder1.append(exception.toString());
      String str = stringBuilder1.toString();
      this.j.d("XAdApkDownloadThread", str);
      throw new g.a(str);
    } 
    if (g.c != null) {
      d = g.c.a;
    } else if (g.b != null) {
      if (g.b.a > 0.0D) {
        d = g.b.a;
      } else {
        d = g.b.a;
      } 
    } else {
      d = 0.0D;
    } 
    IXAdLogger iXAdLogger = this.j;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isNewApkAvailable: local apk version is: ");
    stringBuilder.append(d);
    stringBuilder.append(", remote apk version: ");
    stringBuilder.append(this.i.b());
    iXAdLogger.d("XAdApkDownloadThread", stringBuilder.toString());
    if (d > 0.0D) {
      if (this.i.b() > 0.0D) {
        this.j.d("XAdApkDownloadThread", "remote not null, local apk version is null, force upgrade");
        this.d = this.i.b();
        return true;
      } 
      this.j.d("XAdApkDownloadThread", "remote is null, local apk version is null, do not upgrade");
      return false;
    } 
    if (this.i.b() <= 0.0D) {
      iXAdLogger = this.j;
      stringBuilder = new StringBuilder();
      stringBuilder.append("remote apk version is: null, local apk version is: ");
      stringBuilder.append(d);
      stringBuilder.append(", do not upgrade");
      iXAdLogger.d("XAdApkDownloadThread", stringBuilder.toString());
      return false;
    } 
    if (this.i.b() > d) {
      this.d = this.i.b();
      return true;
    } 
    return false;
  }
  
  public void a(String paramString) {
    this.b = paramString;
    interrupt();
  }
  
  public void run() {
    try {
      boolean bool = b();
      if (!bool)
        return; 
      try {
        a();
        this.j.d("XAdApkDownloadThread", "download apk successfully, downloader exit");
        f = null;
      } catch (IOException iOException) {
        IXAdLogger iXAdLogger = this.j;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create File or HTTP Get failed, exception: ");
        stringBuilder.append(iOException.getMessage());
        iXAdLogger.d("XAdApkDownloadThread", stringBuilder.toString());
      } 
      this.j.d("XAdApkDownloadThread", "no newer apk, downloader exit");
      return;
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\f\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */