package com.baidu.mobads.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.openad.b.d;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import java.io.File;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class m {
  private static long a = 30000000L;
  
  private Context b;
  
  public m(Context paramContext) {
    this.b = paramContext;
  }
  
  public static String a(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getFilesDir().getPath());
    stringBuilder.append(File.separator);
    stringBuilder.append("__bidu_cache_dir");
    stringBuilder.append(File.separator);
    return stringBuilder.toString();
  }
  
  public static String a(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("ad_360_unzip");
    File file = new File(b(paramContext, stringBuilder.toString()));
    if (!file.exists())
      file.mkdirs(); 
    if (file.listFiles() != null && (file.listFiles()).length > 0) {
      File[] arrayOfFile = file.listFiles();
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++)
        arrayOfFile[i].delete(); 
    } 
    return file.getAbsolutePath();
  }
  
  public static void a(int paramInt) {
    a = (paramInt * 1000 * 1000);
  }
  
  private void a(Handler paramHandler, long paramLong) {
    a(paramHandler, Boolean.valueOf(false), (String)null, paramLong);
  }
  
  private void a(Handler paramHandler, Boolean paramBoolean, String paramString, long paramLong) {
    try {
      Message message = paramHandler.obtainMessage();
      message.what = 0;
      Bundle bundle = new Bundle();
      bundle.putBoolean("caching_result", paramBoolean.booleanValue());
      bundle.putLong("caching_time_consume", paramLong);
      bundle.putString("local_creative_url", paramString);
      message.setData(bundle);
      paramHandler.sendMessage(message);
      return;
    } catch (Exception exception) {
      q.a().d(exception);
      return;
    } 
  }
  
  private void a(Handler paramHandler, String paramString, long paramLong) {
    a(paramHandler, Boolean.valueOf(true), paramString, paramLong);
  }
  
  private void a(Handler paramHandler, boolean paramBoolean) {
    try {
      Message message = paramHandler.obtainMessage();
      message.what = 1;
      Bundle bundle = new Bundle();
      bundle.putBoolean("caching_file_exist", paramBoolean);
      message.setData(bundle);
      paramHandler.sendMessage(message);
      return;
    } catch (Exception exception) {
      q.a().d(exception);
      return;
    } 
  }
  
  public static String b(Context paramContext, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a(paramContext));
    stringBuilder.append(b(paramString));
    return stringBuilder.toString();
  }
  
  public static String b(String paramString) {
    return XAdSDKFoundationFacade.getInstance().getCommonUtils().md5(paramString);
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, String paramString3, Handler paramHandler) {
    try {
      IOAdDownloader iOAdDownloader;
      File file = new File(b(paramContext, paramString1));
      if (!file.exists()) {
        a(paramHandler, false);
        URL uRL = new URL(paramString1);
        iOAdDownloader = d.a(this.b).createSimpleFileDownloader(uRL, paramString2, paramString3, false);
        iOAdDownloader.addObserver(new a(this, paramHandler, paramString2));
        iOAdDownloader.start();
        return;
      } 
      a(paramHandler, true);
      a(paramHandler, iOAdDownloader.getAbsolutePath(), -1L);
      iOAdDownloader.setLastModified(System.currentTimeMillis());
      return;
    } catch (Exception exception) {
      a(paramHandler, -1L);
      return;
    } 
  }
  
  public void a(String paramString) {
    (new Thread(new n(this, paramString))).start();
  }
  
  public void c(String paramString) {
    try {
      File file = new File(paramString);
      if (file.exists())
        file.setLastModified(System.currentTimeMillis()); 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
  
  class a implements Observer {
    private final Handler b;
    
    private final String c;
    
    private long d = System.currentTimeMillis();
    
    public a(m this$0, Handler param1Handler, String param1String) {
      this.b = param1Handler;
      this.c = param1String;
    }
    
    public void update(Observable param1Observable, Object param1Object) {
      IOAdDownloader iOAdDownloader = (IOAdDownloader)param1Observable;
      long l = System.currentTimeMillis() - this.d;
      if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.COMPLETED) {
        param1Object = iOAdDownloader.getOutputPath();
        this.a.c((String)param1Object);
        m.a(this.a, this.b, iOAdDownloader.getOutputPath(), l);
        this.a.a(this.c);
      } 
      if (iOAdDownloader.getState() == IOAdDownloader.DownloadStatus.ERROR) {
        m.a(this.a, this.b, Boolean.valueOf(false), (String)null, l);
        m.a(this.a, this.b, l);
        this.a.a(this.c);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */