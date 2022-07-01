package com.blued.android.core.net.http;

import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.pool.DefaultThreadFactory;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class QueueFileDownloader {
  static ExecutorService a = Executors.newSingleThreadExecutor((ThreadFactory)new DefaultThreadFactory("queuefiledownload"));
  
  public static void a(String[] paramArrayOfString1, String[] paramArrayOfString2, QueueFileListener paramQueueFileListener, IRequestHost paramIRequestHost, boolean paramBoolean) {
    if (paramArrayOfString1 == null || paramArrayOfString2 == null || paramArrayOfString1.length != paramArrayOfString2.length) {
      if (paramQueueFileListener != null)
        paramQueueFileListener.a(-1, -1, null, null); 
      return;
    } 
    a.submit(new Runnable(paramArrayOfString1, paramIRequestHost, paramArrayOfString2, paramBoolean, paramQueueFileListener) {
          public void run() {
            for (int i = 0; i < this.a.length; i++) {
              IRequestHost iRequestHost = this.b;
              if (iRequestHost != null && !iRequestHost.isActive())
                return; 
              String str1 = this.a[i];
              String str2 = this.c[i];
              if (this.d && (new File(str2)).exists()) {
                QueueFileDownloader.QueueFileListener queueFileListener = this.e;
                if (queueFileListener != null)
                  queueFileListener.a(0, i, str1, str2); 
                return;
              } 
              String str3 = RecyclingUtils.e(str1);
              FileDownloader.b(str1, str3, new FileHttpResponseHandler(this, i, str1, str2, str3) {
                    private long f = 0L;
                    
                    public void a(File param2File) {
                      byte b = -1;
                      if (param2File == null || param2File.length() != this.f) {
                        if (this.e.e != null)
                          this.e.e.a(-1, this.a, this.b, this.c); 
                        return;
                      } 
                      boolean bool = AppMethods.a(this.d, this.c);
                      if (this.e.e != null) {
                        QueueFileDownloader.QueueFileListener queueFileListener = this.e.e;
                        if (bool)
                          b = 0; 
                        queueFileListener.a(b, this.a, this.b, this.c);
                      } 
                    }
                    
                    public void a(Throwable param2Throwable, int param2Int, File param2File) {
                      super.onFailure(param2Throwable, param2Int, param2File);
                      if (this.e.e != null)
                        this.e.e.a(-1, this.a, this.b, this.c); 
                    }
                    
                    public boolean onAccept(int param2Int, long param2Long) {
                      this.f = param2Long;
                      return super.onAccept(param2Int, param2Long);
                    }
                    
                    public void onFinish() {
                      super.onFinish();
                      File file = new File(this.d);
                      if (file.exists())
                        file.delete(); 
                    }
                  }this.b);
            } 
          }
        });
  }
  
  public static interface QueueFileListener {
    void a(int param1Int1, int param1Int2, String param1String1, String param1String2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\net\http\QueueFileDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */