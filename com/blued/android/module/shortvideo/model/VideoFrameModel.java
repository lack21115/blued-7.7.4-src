package com.blued.android.module.shortvideo.model;

import android.graphics.Bitmap;
import com.blued.android.module.shortvideo.contract.IGetFrameCallback;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameCallback;
import com.blued.android.module.shortvideo.contract.IStvVideoFrameForTimeCallback;
import com.blued.android.module.shortvideo.utils.StvLogUtils;
import com.blued.android.module.shortvideo.utils.StvThreadPoolHelper;
import com.blued.android.module.shortvideo.utils.StvTools;
import com.blued.android.module.shortvideo.utils.VideoExtractFrameAsyncUtils;
import com.qiniu.pili.droid.shortvideo.PLVideoFrame;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class VideoFrameModel extends IModel {
  private static final String Tag = VideoFrameModel.class.getSimpleName();
  
  public static VideoFrameModel instance;
  
  private volatile Map<String, StvThreadPoolHelper.StvThread> mOngoingTasks;
  
  private VideoFrameModel() {
    if (this.mOngoingTasks == null)
      this.mOngoingTasks = new Hashtable<String, StvThreadPoolHelper.StvThread>(); 
  }
  
  private void addLoadFrameTask(String paramString, StvThreadPoolHelper.StvThread paramStvThread) {
    if (this.mOngoingTasks != null)
      this.mOngoingTasks.put(paramString, paramStvThread); 
  }
  
  public static VideoFrameModel getInstance() {
    // Byte code:
    //   0: getstatic com/blued/android/module/shortvideo/model/VideoFrameModel.instance : Lcom/blued/android/module/shortvideo/model/VideoFrameModel;
    //   3: ifnonnull -> 37
    //   6: ldc com/blued/android/module/shortvideo/model/VideoFrameModel
    //   8: monitorenter
    //   9: getstatic com/blued/android/module/shortvideo/model/VideoFrameModel.instance : Lcom/blued/android/module/shortvideo/model/VideoFrameModel;
    //   12: ifnonnull -> 25
    //   15: new com/blued/android/module/shortvideo/model/VideoFrameModel
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/blued/android/module/shortvideo/model/VideoFrameModel.instance : Lcom/blued/android/module/shortvideo/model/VideoFrameModel;
    //   25: ldc com/blued/android/module/shortvideo/model/VideoFrameModel
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/blued/android/module/shortvideo/model/VideoFrameModel
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/blued/android/module/shortvideo/model/VideoFrameModel.instance : Lcom/blued/android/module/shortvideo/model/VideoFrameModel;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private StvThreadPoolHelper.StvThread getLoadFrameTask(String paramString) {
    return (this.mOngoingTasks != null) ? this.mOngoingTasks.get(paramString) : null;
  }
  
  private String getVideoFrameKey(Object paramObject, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramObject);
    stringBuilder.append("-");
    stringBuilder.append(paramInt1);
    stringBuilder.append("-");
    stringBuilder.append(paramInt2);
    stringBuilder.append("-");
    stringBuilder.append(System.currentTimeMillis());
    return stringBuilder.toString();
  }
  
  private String getVideoFrameKey(String paramString, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("-");
    stringBuilder.append(paramInt1);
    stringBuilder.append("-");
    stringBuilder.append(paramInt2);
    return stringBuilder.toString();
  }
  
  private String getVideoFrameKey(String paramString, Object paramObject, int paramInt1, int paramInt2) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append("-");
    stringBuilder.append(paramObject);
    stringBuilder.append("-");
    stringBuilder.append(paramInt1);
    stringBuilder.append("-");
    stringBuilder.append(paramInt2);
    return stringBuilder.toString();
  }
  
  private void removeLoadFrameTask(String paramString) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mOngoingTasks : Ljava/util/Map;
    //   6: ifnull -> 20
    //   9: aload_0
    //   10: getfield mOngoingTasks : Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	23	finally
  }
  
  public void clear() {
    if (this.mOngoingTasks != null) {
      Iterator<Map.Entry> iterator = this.mOngoingTasks.entrySet().iterator();
      while (iterator.hasNext()) {
        StvThreadPoolHelper.StvThread stvThread = (StvThreadPoolHelper.StvThread)((Map.Entry)iterator.next()).getValue();
        if (stvThread != null) {
          stvThread.a();
          stvThread.interrupt();
        } 
      } 
      this.mOngoingTasks.clear();
    } 
    instance = null;
  }
  
  public String getFrameDirectory() {
    return StvTools.a("frame");
  }
  
  public String getTakePhotoFrameImgPath(Object paramObject, int paramInt1, int paramInt2) {
    getVideoFrameKey(paramObject, paramInt1, paramInt2);
    return StvTools.b("frame");
  }
  
  public void getVideoFrame(String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3, IGetFrameCallback paramIGetFrameCallback) {
    String str = getVideoFrameKey(paramString, paramInt2, paramInt3);
    MyLoadVideoFrameTask myLoadVideoFrameTask = (MyLoadVideoFrameTask)getLoadFrameTask(str);
    if (myLoadVideoFrameTask == null || !myLoadVideoFrameTask.b()) {
      MyLoadVideoFrameTask myLoadVideoFrameTask1 = new MyLoadVideoFrameTask(this, str, paramString, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3, paramIGetFrameCallback);
      addLoadFrameTask(str, myLoadVideoFrameTask1);
      StvThreadPoolHelper.a().b((Runnable)myLoadVideoFrameTask1);
    } 
  }
  
  public void saveVideoFrameByTime(String paramString, long paramLong, IStvVideoFrameForTimeCallback paramIStvVideoFrameForTimeCallback) {
    MyLoadVideoFrameForTimeTask myLoadVideoFrameForTimeTask = new MyLoadVideoFrameForTimeTask(this, paramString, paramLong, paramIStvVideoFrameForTimeCallback);
    StvThreadPoolHelper.a().b((Runnable)myLoadVideoFrameForTimeTask);
  }
  
  public void saveVideoFrameToPicture(PLVideoFrame paramPLVideoFrame, IStvVideoFrameCallback paramIStvVideoFrameCallback) {
    MySaveVideoFrameTask mySaveVideoFrameTask = new MySaveVideoFrameTask(this, paramPLVideoFrame, paramIStvVideoFrameCallback);
    StvThreadPoolHelper.a().a((Runnable)mySaveVideoFrameTask);
  }
  
  class MyLoadVideoFrameForTimeTask extends StvThreadPoolHelper.StvThread {
    private String d;
    
    private long e;
    
    private VideoExtractFrameAsyncUtils f;
    
    private IStvVideoFrameForTimeCallback g;
    
    public MyLoadVideoFrameForTimeTask(VideoFrameModel this$0, String param1String, long param1Long, IStvVideoFrameForTimeCallback param1IStvVideoFrameForTimeCallback) {
      this.d = param1String;
      this.e = param1Long;
      this.g = param1IStvVideoFrameForTimeCallback;
      this.f = new VideoExtractFrameAsyncUtils();
    }
    
    public void run() {
      this.f.a(this.d, this.a.getFrameDirectory(), this.e, this.g);
    }
  }
  
  class MyLoadVideoFrameTask extends StvThreadPoolHelper.StvThread {
    private String d;
    
    private String e;
    
    private long f;
    
    private long g;
    
    private int h;
    
    private int i;
    
    private int j;
    
    private VideoExtractFrameAsyncUtils k;
    
    private IGetFrameCallback l;
    
    public MyLoadVideoFrameTask(VideoFrameModel this$0, String param1String1, String param1String2, long param1Long1, long param1Long2, int param1Int1, int param1Int2, int param1Int3, IGetFrameCallback param1IGetFrameCallback) {
      this.d = param1String1;
      this.e = param1String2;
      this.f = param1Long1;
      this.g = param1Long2;
      this.h = param1Int1;
      this.i = param1Int2;
      this.j = param1Int3;
      this.l = param1IGetFrameCallback;
      this.k = new VideoExtractFrameAsyncUtils(param1Int2, param1Int3);
    }
    
    public void run() {
      this.k.a(this.e, this.a.getFrameDirectory(), this.f, this.g, this.h, this.l);
      this.a.removeLoadFrameTask(this.d);
    }
  }
  
  class MySaveVideoFrameTask extends StvThreadPoolHelper.StvThread {
    private PLVideoFrame d = null;
    
    private IStvVideoFrameCallback e;
    
    public MySaveVideoFrameTask(VideoFrameModel this$0, PLVideoFrame param1PLVideoFrame, IStvVideoFrameCallback param1IStvVideoFrameCallback) {
      this.d = param1PLVideoFrame;
      this.e = param1IStvVideoFrameCallback;
    }
    
    public void a() {
      super.a();
      this.e = null;
    }
    
    public void run() {
      if (this.b) {
        this.c = false;
        if (this.d != null && this.b) {
          Bitmap bitmap = this.d.toBitmap();
          String str = this.a.getTakePhotoFrameImgPath(Long.valueOf(this.d.getTimestampMs()), this.d.getWidth(), this.d.getHeight());
          if (!(new File(str)).exists()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(VideoFrameModel.Tag);
            stringBuilder.append(" 保存帧到本地");
            StvLogUtils.a(stringBuilder.toString(), new Object[0]);
            StvTools.a(bitmap, str, 100);
          } 
          if (this.e != null && this.b)
            this.e.a(Long.valueOf(this.d.getTimestampMs()), this.d, bitmap, str); 
        } else {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(VideoFrameModel.Tag);
          stringBuilder.append(" videoFrame == null !!!");
          StvLogUtils.a(stringBuilder.toString(), new Object[0]);
        } 
      } 
      this.c = true;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\shortvideo\model\VideoFrameModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */