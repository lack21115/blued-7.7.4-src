package com.tencent.ijk.media.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.basic.util.g;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;

public final class IjkDownloadCenter {
  private static final int DC_PROP_LONG_DOWNLOAD_SIZE = 1003;
  
  private static final int DC_PROP_LONG_SIZE = 1002;
  
  private static final int DC_PROP_LONG_SPEED = 1004;
  
  private static final int DC_PROP_STRING_URL = 1001;
  
  private static final int MSG_ERROR = 500;
  
  private static final int MSG_FINISH = 600;
  
  private static final int MSG_PROGRESS = 900;
  
  private static final int MSG_RESUME = 100;
  
  private static final int MSG_STOP = 300;
  
  private static final String TAG = "IjkDownloadCenter";
  
  private static IjkDownloadCenter instance;
  
  private static volatile boolean mIsLibLoaded = false;
  
  private static final IjkLibLoader sLocalLibLoader = new IjkLibLoader() {
      public void loadLibrary(String param1String) throws UnsatisfiedLinkError, SecurityException {
        g.a(param1String);
      }
    };
  
  private EventHandler mEventHandler;
  
  protected Map<String, String> mHeaders;
  
  private OnDownloadListener mListener;
  
  public IjkDownloadCenter() {
    this(sLocalLibLoader);
  }
  
  public IjkDownloadCenter(IjkLibLoader paramIjkLibLoader) {
    loadLibrariesOnce(paramIjkLibLoader);
    Looper looper = Looper.getMainLooper();
    if (looper != null) {
      this.mEventHandler = new EventHandler(this, looper);
    } else {
      this.mEventHandler = null;
    } 
    native_download_setup(new WeakReference<IjkDownloadCenter>(this));
  }
  
  private native int download_get_task_prop_long(int paramInt1, int paramInt2);
  
  private native String download_get_task_prop_string(int paramInt1, int paramInt2);
  
  public static IjkDownloadCenter getInstance() {
    if (instance == null)
      instance = new IjkDownloadCenter(); 
    return instance;
  }
  
  private static int hlsVerifyForNative(Object paramObject, int paramInt, String paramString, byte[] paramArrayOfbyte) {
    if (paramObject == null)
      return 0; 
    paramObject = ((WeakReference<IjkDownloadCenter>)paramObject).get();
    if (paramObject == null)
      return 0; 
    IjkDownloadMedia ijkDownloadMedia = paramObject.convertMedia(paramInt);
    return ((IjkDownloadCenter)paramObject).mListener.hlsKeyVerify((IjkDownloadCenter)paramObject, ijkDownloadMedia, paramString, paramArrayOfbyte);
  }
  
  public static void loadLibrariesOnce(IjkLibLoader paramIjkLibLoader) {
    // Byte code:
    //   0: ldc com/tencent/ijk/media/player/IjkMediaPlayer
    //   2: monitorenter
    //   3: getstatic com/tencent/ijk/media/player/IjkDownloadCenter.mIsLibLoaded : Z
    //   6: ifne -> 47
    //   9: aload_0
    //   10: astore_1
    //   11: aload_0
    //   12: ifnonnull -> 19
    //   15: getstatic com/tencent/ijk/media/player/IjkDownloadCenter.sLocalLibLoader : Lcom/tencent/ijk/media/player/IjkLibLoader;
    //   18: astore_1
    //   19: aload_1
    //   20: ldc 'txffmpeg'
    //   22: invokeinterface loadLibrary : (Ljava/lang/String;)V
    //   27: aload_1
    //   28: ldc 'txsdl'
    //   30: invokeinterface loadLibrary : (Ljava/lang/String;)V
    //   35: aload_1
    //   36: ldc 'txplayer'
    //   38: invokeinterface loadLibrary : (Ljava/lang/String;)V
    //   43: iconst_1
    //   44: putstatic com/tencent/ijk/media/player/IjkDownloadCenter.mIsLibLoaded : Z
    //   47: ldc com/tencent/ijk/media/player/IjkMediaPlayer
    //   49: monitorexit
    //   50: return
    //   51: astore_0
    //   52: ldc com/tencent/ijk/media/player/IjkMediaPlayer
    //   54: monitorexit
    //   55: aload_0
    //   56: athrow
    // Exception table:
    //   from	to	target	type
    //   3	9	51	finally
    //   15	19	51	finally
    //   19	47	51	finally
    //   47	50	51	finally
    //   52	55	51	finally
  }
  
  private native void native_download_free();
  
  private native int native_download_hls_start(String paramString1, String paramString2, String paramString3);
  
  private native void native_download_setup(Object paramObject);
  
  private native void native_download_stop(int paramInt);
  
  private static void postEventFromNative(Object paramObject1, int paramInt1, int paramInt2, int paramInt3, Object paramObject2) {
    if (paramObject1 == null)
      return; 
    paramObject1 = ((WeakReference<IjkDownloadCenter>)paramObject1).get();
    if (paramObject1 == null)
      return; 
    if (((IjkDownloadCenter)paramObject1).mEventHandler != null) {
      NativeEvent nativeEvent = new NativeEvent();
      nativeEvent.media = paramObject1.convertMedia(paramInt2);
      nativeEvent.error = paramInt3;
      if (paramObject2 != null)
        nativeEvent.reason = (String)paramObject2; 
      paramObject2 = ((IjkDownloadCenter)paramObject1).mEventHandler.obtainMessage(paramInt1, paramInt2, paramInt3, nativeEvent);
      ((IjkDownloadCenter)paramObject1).mEventHandler.sendMessage((Message)paramObject2);
    } 
  }
  
  IjkDownloadMedia convertMedia(int paramInt) {
    String str = download_get_task_prop_string(1001, paramInt);
    if (str == null)
      return null; 
    IjkDownloadMedia ijkDownloadMedia = new IjkDownloadMedia();
    ijkDownloadMedia.size = download_get_task_prop_long(1002, paramInt);
    ijkDownloadMedia.downloadSize = download_get_task_prop_long(1003, paramInt);
    ijkDownloadMedia.speed = download_get_task_prop_long(1004, paramInt);
    ijkDownloadMedia.url = str;
    ijkDownloadMedia.tid = paramInt;
    return ijkDownloadMedia;
  }
  
  public int downloadHls(String paramString1, String paramString2) {
    Map<String, String> map = this.mHeaders;
    String str1 = "";
    String str2 = str1;
    if (map != null) {
      Iterator<String> iterator = map.keySet().iterator();
      while (true) {
        str2 = str1;
        if (iterator.hasNext()) {
          str2 = iterator.next();
          if (str1 == null) {
            str1 = String.format("%s: %s", new Object[] { str2, this.mHeaders.get(str2) });
            continue;
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append(str1);
          stringBuilder.append("\r\n");
          stringBuilder.append(String.format("%s: %s", new Object[] { str2, this.mHeaders.get(str2) }));
          str1 = stringBuilder.toString();
          continue;
        } 
        break;
      } 
    } 
    return native_download_hls_start(paramString1, paramString2, str2);
  }
  
  protected void finalize() throws Throwable {
    try {
      native_download_free();
      return;
    } finally {
      super.finalize();
    } 
  }
  
  public void setHeaders(Map<String, String> paramMap) {
    this.mHeaders = paramMap;
  }
  
  public IjkDownloadCenter setListener(OnDownloadListener paramOnDownloadListener) {
    this.mListener = paramOnDownloadListener;
    return this;
  }
  
  public void stop(int paramInt) {
    native_download_stop(paramInt);
  }
  
  static class EventHandler extends Handler {
    private final WeakReference<IjkDownloadCenter> mWeakCenter;
    
    public EventHandler(IjkDownloadCenter param1IjkDownloadCenter, Looper param1Looper) {
      super(param1Looper);
      this.mWeakCenter = new WeakReference<IjkDownloadCenter>(param1IjkDownloadCenter);
    }
    
    public void handleMessage(Message param1Message) {
      IjkDownloadCenter ijkDownloadCenter = this.mWeakCenter.get();
      if (ijkDownloadCenter != null) {
        if (ijkDownloadCenter.mListener == null)
          return; 
        IjkDownloadCenter.NativeEvent nativeEvent = (IjkDownloadCenter.NativeEvent)param1Message.obj;
        IjkDownloadMedia ijkDownloadMedia = nativeEvent.media;
        if (ijkDownloadMedia == null)
          return; 
        int i = param1Message.what;
        if (i != 100) {
          if (i != 300) {
            if (i != 500) {
              if (i != 600) {
                if (i != 900)
                  return; 
                ijkDownloadCenter.mListener.downloadProgress(ijkDownloadCenter, ijkDownloadMedia);
                return;
              } 
              ijkDownloadCenter.mListener.downloadFinish(ijkDownloadCenter, ijkDownloadMedia);
              return;
            } 
            ijkDownloadCenter.mListener.downloadError(ijkDownloadCenter, ijkDownloadMedia, nativeEvent.error, nativeEvent.reason);
            return;
          } 
          ijkDownloadCenter.mListener.downloadEnd(ijkDownloadCenter, ijkDownloadMedia);
          return;
        } 
        ijkDownloadCenter.mListener.downloadBegin(ijkDownloadCenter, ijkDownloadMedia);
      } 
    }
  }
  
  static class NativeEvent {
    int error;
    
    IjkDownloadMedia media;
    
    String reason;
    
    private NativeEvent() {}
  }
  
  public static interface OnDownloadListener {
    void downloadBegin(IjkDownloadCenter param1IjkDownloadCenter, IjkDownloadMedia param1IjkDownloadMedia);
    
    void downloadEnd(IjkDownloadCenter param1IjkDownloadCenter, IjkDownloadMedia param1IjkDownloadMedia);
    
    void downloadError(IjkDownloadCenter param1IjkDownloadCenter, IjkDownloadMedia param1IjkDownloadMedia, int param1Int, String param1String);
    
    void downloadFinish(IjkDownloadCenter param1IjkDownloadCenter, IjkDownloadMedia param1IjkDownloadMedia);
    
    void downloadProgress(IjkDownloadCenter param1IjkDownloadCenter, IjkDownloadMedia param1IjkDownloadMedia);
    
    int hlsKeyVerify(IjkDownloadCenter param1IjkDownloadCenter, IjkDownloadMedia param1IjkDownloadMedia, String param1String, byte[] param1ArrayOfbyte);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\ijk\media\player\IjkDownloadCenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */