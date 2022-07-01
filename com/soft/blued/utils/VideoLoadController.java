package com.soft.blued.utils;

import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.FileHttpResponseHandler;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VideoLoadController {
  private static VideoLoadController b;
  
  protected final Set<String> a = new HashSet<String>();
  
  private Map<String, IVideoController> c = (Map<String, IVideoController>)new ArrayMap();
  
  public static VideoLoadController a() {
    // Byte code:
    //   0: ldc com/soft/blued/utils/VideoLoadController
    //   2: monitorenter
    //   3: getstatic com/soft/blued/utils/VideoLoadController.b : Lcom/soft/blued/utils/VideoLoadController;
    //   6: ifnonnull -> 19
    //   9: new com/soft/blued/utils/VideoLoadController
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: putstatic com/soft/blued/utils/VideoLoadController.b : Lcom/soft/blued/utils/VideoLoadController;
    //   19: getstatic com/soft/blued/utils/VideoLoadController.b : Lcom/soft/blued/utils/VideoLoadController;
    //   22: astore_0
    //   23: ldc com/soft/blued/utils/VideoLoadController
    //   25: monitorexit
    //   26: aload_0
    //   27: areturn
    //   28: astore_0
    //   29: ldc com/soft/blued/utils/VideoLoadController
    //   31: monitorexit
    //   32: aload_0
    //   33: athrow
    // Exception table:
    //   from	to	target	type
    //   3	19	28	finally
    //   19	23	28	finally
  }
  
  public static void a(String paramString) {
    Logger.a("VideoLoadController", new Object[] { "loadVideo(), videoUrl:", paramString });
    if ((a()).a.contains(paramString))
      return; 
    File file = FileUtils.c(paramString);
    if (file != null) {
      a().a(paramString, file.getAbsolutePath());
      return;
    } 
    (a()).a.add(paramString);
    FileUtils.a(paramString, new FileHttpResponseHandler(paramString) {
          public void a(File param1File) {
            VideoLoadController.a(VideoLoadController.a(), this.a, param1File.getAbsolutePath());
          }
          
          public void a(Throwable param1Throwable, int param1Int, File param1File) {
            super.onFailure(param1Throwable, param1Int, param1File);
            VideoLoadController.a(VideoLoadController.a(), this.a);
          }
          
          public void onProgress(int param1Int1, int param1Int2) {
            super.onProgress(param1Int1, param1Int2);
            VideoLoadController.a(VideoLoadController.a(), this.a, param1Int1);
          }
        });
  }
  
  private void a(String paramString, int paramInt) {
    AppInfo.n().post(new Runnable(this, paramInt, paramString) {
          public void run() {
            Logger.a("VideoLoadController", new Object[] { "notifyVideoDownloadProgress(), percent:", Integer.valueOf(this.a), ", videoUrl:", this.b });
            VideoLoadController.IVideoController iVideoController = (VideoLoadController.IVideoController)VideoLoadController.a(VideoLoadController.a()).get(this.b);
            if (iVideoController != null) {
              iVideoController.a(this.b, this.a);
              return;
            } 
            Logger.a("VideoLoadController", new Object[] { "notifyVideoDownloadProgress(), can't find controller" });
          }
        });
  }
  
  public static void a(String paramString, IVideoController paramIVideoController) {
    Logger.a("VideoLoadController", new Object[] { "registerVideoController(), videoUrl:", paramString });
    (a()).c.put(paramString, paramIVideoController);
  }
  
  private void a(String paramString1, String paramString2) {
    AppInfo.n().post(new Runnable(this, paramString1, paramString2) {
          public void run() {
            Logger.a("VideoLoadController", new Object[] { "notifyVideoDownloadFinished(), videoUrl:", this.a });
            VideoLoadController videoLoadController = VideoLoadController.a();
            videoLoadController.a.remove(this.a);
            VideoLoadController.IVideoController iVideoController = (VideoLoadController.IVideoController)VideoLoadController.a(videoLoadController).get(this.a);
            if (iVideoController != null) {
              iVideoController.a(this.a, this.b);
              return;
            } 
            Logger.a("VideoLoadController", new Object[] { "notifyVideoDownloadFinished(), can't find controller" });
          }
        });
  }
  
  public static void b(String paramString) {
    File file = FileUtils.c(paramString);
    if (file != null && file.exists())
      file.delete(); 
  }
  
  public static void b(String paramString, IVideoController paramIVideoController) {
    Logger.a("VideoLoadController", new Object[] { "unregisterVideoController(), videoUrl:", paramString });
    VideoLoadController videoLoadController = a();
    if ((IVideoController)videoLoadController.c.get(paramString) == paramIVideoController)
      videoLoadController.c.remove(paramString); 
  }
  
  private void c(String paramString) {
    AppInfo.n().post(new Runnable(this, paramString) {
          public void run() {
            Logger.a("VideoLoadController", new Object[] { "notifyVideoDownloadFailed(), videoUrl:", this.a });
            VideoLoadController videoLoadController = VideoLoadController.a();
            videoLoadController.a.remove(this.a);
            File file = FileUtils.c(this.a);
            if (file != null)
              file.delete(); 
            VideoLoadController.IVideoController iVideoController = (VideoLoadController.IVideoController)VideoLoadController.a(videoLoadController).get(this.a);
            if (iVideoController != null) {
              iVideoController.a(this.a);
              return;
            } 
            Logger.a("VideoLoadController", new Object[] { "notifyVideoDownloadFailed(), can't find controller" });
          }
        });
  }
  
  public static interface IVideoController {
    void a(String param1String);
    
    void a(String param1String, int param1Int);
    
    void a(String param1String1, String param1String2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\utils\VideoLoadController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */