package com.blued.android.framework.download;

import android.util.Log;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.download.model.DownloadBaseInfo;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DownloadManager {
  private static DownloadManager a;
  
  private List<DownloadTask> b = null;
  
  private ExecutorService c = null;
  
  private DownloadManager() {
    this.c = Executors.newSingleThreadExecutor();
    this.b = Collections.synchronizedList(new ArrayList<DownloadTask>());
  }
  
  public static DownloadManager a() {
    if (a == null)
      a = new DownloadManager(); 
    return a;
  }
  
  public void a(DownloadTask paramDownloadTask) {
    this.b.remove(paramDownloadTask);
  }
  
  public boolean a(DownloadBaseInfo paramDownloadBaseInfo, String paramString, OnFileDownloadListener paramOnFileDownloadListener, boolean paramBoolean) throws NullPointerException {
    if (paramDownloadBaseInfo != null && paramString != null) {
      Iterator<DownloadTask> iterator = this.b.iterator();
      while (iterator.hasNext()) {
        if (DownloadTask.a(iterator.next()).equals(paramString)) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("Downloading task exists. ");
          stringBuilder.append(paramString);
          Log.i("DownloadManager", stringBuilder.toString());
          return false;
        } 
      } 
      DownloadTask downloadTask = new DownloadTask((DownloadBaseInfo)stringBuilder, paramString, paramOnFileDownloadListener, paramBoolean);
      this.b.add(downloadTask);
      this.c.execute(downloadTask);
      paramOnFileDownloadListener.a((DownloadBaseInfo)stringBuilder);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("adding Downloading-task success ");
      stringBuilder.append(paramString);
      Log.i("DownloadManager", stringBuilder.toString());
      return true;
    } 
    throw new NullPointerException("Input parameter should not be null");
  }
  
  public static class DownloadTask implements Runnable {
    public DownloadBaseInfo a;
    
    public boolean b = true;
    
    private DownloadTask c = this;
    
    private String d = "";
    
    private OnFileDownloadListener e;
    
    private FileHttpResponseHandler f;
    
    private IRequestHost g;
    
    private boolean h;
    
    public DownloadTask(DownloadBaseInfo param1DownloadBaseInfo, String param1String, OnFileDownloadListener param1OnFileDownloadListener, boolean param1Boolean) {
      this.a = param1DownloadBaseInfo;
      this.d = param1String;
      this.e = param1OnFileDownloadListener;
      this.h = param1Boolean;
      a();
    }
    
    private void a() {
      this.f = new FileHttpResponseHandler(this) {
          public void a(File param2File) {
            if (param2File == null) {
              DownloadManager.a().a(DownloadManager.DownloadTask.c(this.a));
              return;
            } 
            try {
              if (!DownloadManager.DownloadTask.d(this.a)) {
                if (DownloadManager.DownloadTask.b(this.a) != null)
                  DownloadManager.DownloadTask.b(this.a).a(this.a.a, DownloadManager.DownloadTask.a(this.a)); 
              } else {
                String str = Md5.a(param2File);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("mGameInfo.gameMD5 =");
                stringBuilder.append(this.a.a.md5);
                stringBuilder.append("; md5=");
                stringBuilder.append(str);
                Log.d("yaojingwa", stringBuilder.toString());
                if (this.a.a.md5 != null && this.a.a.md5.equals(str)) {
                  if (DownloadManager.DownloadTask.b(this.a) != null)
                    DownloadManager.DownloadTask.b(this.a).a(this.a.a, DownloadManager.DownloadTask.a(this.a)); 
                } else {
                  param2File.delete();
                  if (DownloadManager.DownloadTask.b(this.a) != null)
                    DownloadManager.DownloadTask.b(this.a).b(this.a.a); 
                } 
              } 
            } catch (IOException iOException) {
              iOException.printStackTrace();
            } 
            DownloadManager.a().a(DownloadManager.DownloadTask.c(this.a));
          }
          
          public void a(Throwable param2Throwable, int param2Int, File param2File) {
            super.onFailure(param2Throwable, param2Int, param2File);
            if (DownloadManager.DownloadTask.b(this.a) != null)
              DownloadManager.DownloadTask.b(this.a).b(this.a.a); 
            DownloadManager.a().a(DownloadManager.DownloadTask.c(this.a));
          }
          
          public void onProgress(int param2Int1, int param2Int2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("percent = ");
            stringBuilder.append(param2Int1);
            stringBuilder.append(",byteCount = ");
            stringBuilder.append(param2Int2);
            Log.d("yaojingwa", stringBuilder.toString());
            if (DownloadManager.DownloadTask.b(this.a) != null)
              DownloadManager.DownloadTask.b(this.a).a(this.a.a, param2Int1, param2Int2); 
          }
          
          public void onStart() {
            super.onStart();
            Log.d("yaojingwa", this.a.a.download_url);
          }
        };
      this.g = new IRequestHost(this) {
          public boolean isActive() {
            return this.a.b;
          }
        };
    }
    
    public void run() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Start download for: ");
      stringBuilder.append(this.d);
      Log.i("DownloadManager", stringBuilder.toString());
      FileDownloader.b(this.a.download_url, this.d, this.f, this.g);
    }
  }
  
  class null extends FileHttpResponseHandler {
    null(DownloadManager this$0) {}
    
    public void a(File param1File) {
      if (param1File == null) {
        DownloadManager.a().a(DownloadManager.DownloadTask.c(this.a));
        return;
      } 
      try {
        if (!DownloadManager.DownloadTask.d(this.a)) {
          if (DownloadManager.DownloadTask.b(this.a) != null)
            DownloadManager.DownloadTask.b(this.a).a(this.a.a, DownloadManager.DownloadTask.a(this.a)); 
        } else {
          String str = Md5.a(param1File);
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("mGameInfo.gameMD5 =");
          stringBuilder.append(this.a.a.md5);
          stringBuilder.append("; md5=");
          stringBuilder.append(str);
          Log.d("yaojingwa", stringBuilder.toString());
          if (this.a.a.md5 != null && this.a.a.md5.equals(str)) {
            if (DownloadManager.DownloadTask.b(this.a) != null)
              DownloadManager.DownloadTask.b(this.a).a(this.a.a, DownloadManager.DownloadTask.a(this.a)); 
          } else {
            param1File.delete();
            if (DownloadManager.DownloadTask.b(this.a) != null)
              DownloadManager.DownloadTask.b(this.a).b(this.a.a); 
          } 
        } 
      } catch (IOException iOException) {
        iOException.printStackTrace();
      } 
      DownloadManager.a().a(DownloadManager.DownloadTask.c(this.a));
    }
    
    public void a(Throwable param1Throwable, int param1Int, File param1File) {
      super.onFailure(param1Throwable, param1Int, param1File);
      if (DownloadManager.DownloadTask.b(this.a) != null)
        DownloadManager.DownloadTask.b(this.a).b(this.a.a); 
      DownloadManager.a().a(DownloadManager.DownloadTask.c(this.a));
    }
    
    public void onProgress(int param1Int1, int param1Int2) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("percent = ");
      stringBuilder.append(param1Int1);
      stringBuilder.append(",byteCount = ");
      stringBuilder.append(param1Int2);
      Log.d("yaojingwa", stringBuilder.toString());
      if (DownloadManager.DownloadTask.b(this.a) != null)
        DownloadManager.DownloadTask.b(this.a).a(this.a.a, param1Int1, param1Int2); 
    }
    
    public void onStart() {
      super.onStart();
      Log.d("yaojingwa", this.a.a.download_url);
    }
  }
  
  class null implements IRequestHost {
    null(DownloadManager this$0) {}
    
    public boolean isActive() {
      return this.a.b;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\download\DownloadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */