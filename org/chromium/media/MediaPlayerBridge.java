package org.chromium.media;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.view.Surface;
import java.io.IOException;
import java.util.HashMap;
import org.chromium.base.AsyncTask;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

public class MediaPlayerBridge {
  private MediaPlayerBridge$LoadDataUriTask mLoadDataUriTask;
  
  private long mNativeMediaPlayerBridge;
  
  private MediaPlayer mPlayer;
  
  protected MediaPlayerBridge() {}
  
  private MediaPlayerBridge(long paramLong) {
    this.mNativeMediaPlayerBridge = paramLong;
  }
  
  private void cancelLoadDataUriTask() {
    if (this.mLoadDataUriTask != null) {
      this.mLoadDataUriTask.cancel(true);
      this.mLoadDataUriTask = null;
    } 
  }
  
  @CalledByNative
  private static MediaPlayerBridge create(long paramLong) {
    return new MediaPlayerBridge(paramLong);
  }
  
  private boolean hasTrack(int paramInt) {
    try {
      MediaPlayer.TrackInfo[] arrayOfTrackInfo = getLocalPlayer().getTrackInfo();
      if (arrayOfTrackInfo.length == 0)
        return true; 
      int j = arrayOfTrackInfo.length;
      for (int i = 0; i < j; i++) {
        MediaPlayer.TrackInfo trackInfo = arrayOfTrackInfo[i];
        if (paramInt == trackInfo.getTrackType())
          return true; 
        int k = trackInfo.getTrackType();
        if (k == 0)
          return true; 
      } 
      return false;
    } catch (RuntimeException runtimeException) {
      return true;
    } 
  }
  
  private native void nativeOnDidSetDataUriDataSource(long paramLong, boolean paramBoolean);
  
  @CalledByNative
  protected void destroy() {
    cancelLoadDataUriTask();
    this.mNativeMediaPlayerBridge = 0L;
  }
  
  @CalledByNative
  protected MediaPlayerBridge$AllowedOperations getAllowedOperations() {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getLocalPlayer : ()Landroid/media/MediaPlayer;
    //   4: astore #9
    //   6: iconst_1
    //   7: istore #5
    //   9: iconst_1
    //   10: istore #6
    //   12: iconst_1
    //   13: istore #7
    //   15: aload #9
    //   17: invokevirtual getClass : ()Ljava/lang/Class;
    //   20: ldc 'getMetadata'
    //   22: iconst_2
    //   23: anewarray java/lang/Class
    //   26: dup
    //   27: iconst_0
    //   28: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: getstatic java/lang/Boolean.TYPE : Ljava/lang/Class;
    //   37: aastore
    //   38: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   41: astore #10
    //   43: aload #10
    //   45: iconst_1
    //   46: invokevirtual setAccessible : (Z)V
    //   49: aload #10
    //   51: aload #9
    //   53: iconst_2
    //   54: anewarray java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: iconst_0
    //   60: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   63: aastore
    //   64: dup
    //   65: iconst_1
    //   66: iconst_0
    //   67: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   70: aastore
    //   71: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   74: astore #9
    //   76: aload #9
    //   78: ifnull -> 458
    //   81: aload #9
    //   83: invokevirtual getClass : ()Ljava/lang/Class;
    //   86: astore #10
    //   88: aload #10
    //   90: ldc 'has'
    //   92: iconst_1
    //   93: anewarray java/lang/Class
    //   96: dup
    //   97: iconst_0
    //   98: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   101: aastore
    //   102: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   105: astore #11
    //   107: aload #10
    //   109: ldc 'getBoolean'
    //   111: iconst_1
    //   112: anewarray java/lang/Class
    //   115: dup
    //   116: iconst_0
    //   117: getstatic java/lang/Integer.TYPE : Ljava/lang/Class;
    //   120: aastore
    //   121: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   124: astore #12
    //   126: aload #10
    //   128: ldc 'PAUSE_AVAILABLE'
    //   130: invokevirtual getField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   133: aconst_null
    //   134: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   137: checkcast java/lang/Integer
    //   140: invokevirtual intValue : ()I
    //   143: istore_1
    //   144: aload #10
    //   146: ldc 'SEEK_FORWARD_AVAILABLE'
    //   148: invokevirtual getField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   151: aconst_null
    //   152: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   155: checkcast java/lang/Integer
    //   158: invokevirtual intValue : ()I
    //   161: istore_2
    //   162: aload #10
    //   164: ldc 'SEEK_BACKWARD_AVAILABLE'
    //   166: invokevirtual getField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   169: aconst_null
    //   170: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   173: checkcast java/lang/Integer
    //   176: invokevirtual intValue : ()I
    //   179: istore_3
    //   180: aload #11
    //   182: iconst_1
    //   183: invokevirtual setAccessible : (Z)V
    //   186: aload #12
    //   188: iconst_1
    //   189: invokevirtual setAccessible : (Z)V
    //   192: aload #11
    //   194: aload #9
    //   196: iconst_1
    //   197: anewarray java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: iload_1
    //   203: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   206: aastore
    //   207: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast java/lang/Boolean
    //   213: invokevirtual booleanValue : ()Z
    //   216: ifeq -> 259
    //   219: aload #12
    //   221: aload #9
    //   223: iconst_1
    //   224: anewarray java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: iload_1
    //   230: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   233: aastore
    //   234: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   237: checkcast java/lang/Boolean
    //   240: invokevirtual booleanValue : ()Z
    //   243: istore #4
    //   245: iload #4
    //   247: ifeq -> 253
    //   250: goto -> 259
    //   253: iconst_0
    //   254: istore #4
    //   256: goto -> 262
    //   259: iconst_1
    //   260: istore #4
    //   262: aload #11
    //   264: aload #9
    //   266: iconst_1
    //   267: anewarray java/lang/Object
    //   270: dup
    //   271: iconst_0
    //   272: iload_2
    //   273: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   276: aastore
    //   277: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   280: checkcast java/lang/Boolean
    //   283: invokevirtual booleanValue : ()Z
    //   286: ifeq -> 329
    //   289: aload #12
    //   291: aload #9
    //   293: iconst_1
    //   294: anewarray java/lang/Object
    //   297: dup
    //   298: iconst_0
    //   299: iload_2
    //   300: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   303: aastore
    //   304: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   307: checkcast java/lang/Boolean
    //   310: invokevirtual booleanValue : ()Z
    //   313: istore #5
    //   315: iload #5
    //   317: ifeq -> 323
    //   320: goto -> 329
    //   323: iconst_0
    //   324: istore #5
    //   326: goto -> 332
    //   329: iconst_1
    //   330: istore #5
    //   332: aload #11
    //   334: aload #9
    //   336: iconst_1
    //   337: anewarray java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: iload_3
    //   343: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   346: aastore
    //   347: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   350: checkcast java/lang/Boolean
    //   353: invokevirtual booleanValue : ()Z
    //   356: ifeq -> 399
    //   359: aload #12
    //   361: aload #9
    //   363: iconst_1
    //   364: anewarray java/lang/Object
    //   367: dup
    //   368: iconst_0
    //   369: iload_3
    //   370: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   373: aastore
    //   374: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   377: checkcast java/lang/Boolean
    //   380: invokevirtual booleanValue : ()Z
    //   383: istore #8
    //   385: iload #8
    //   387: ifeq -> 393
    //   390: goto -> 399
    //   393: iconst_0
    //   394: istore #6
    //   396: goto -> 403
    //   399: iload #7
    //   401: istore #6
    //   403: iload #5
    //   405: istore #7
    //   407: iload #6
    //   409: istore #5
    //   411: iload #7
    //   413: istore #6
    //   415: goto -> 472
    //   418: astore #9
    //   420: goto -> 495
    //   423: astore #9
    //   425: goto -> 539
    //   428: astore #9
    //   430: goto -> 583
    //   433: astore #9
    //   435: goto -> 627
    //   438: astore #9
    //   440: goto -> 492
    //   443: astore #9
    //   445: goto -> 536
    //   448: astore #9
    //   450: goto -> 580
    //   453: astore #9
    //   455: goto -> 624
    //   458: iconst_1
    //   459: istore #7
    //   461: iconst_1
    //   462: istore #4
    //   464: iload #5
    //   466: istore #6
    //   468: iload #7
    //   470: istore #5
    //   472: iload #6
    //   474: istore #7
    //   476: iload #5
    //   478: istore #6
    //   480: iload #7
    //   482: istore #5
    //   484: goto -> 660
    //   487: astore #9
    //   489: iconst_1
    //   490: istore #4
    //   492: iconst_1
    //   493: istore #5
    //   495: new java/lang/StringBuilder
    //   498: dup
    //   499: ldc 'Cannot find matching fields in Metadata class: '
    //   501: invokespecial <init> : (Ljava/lang/String;)V
    //   504: astore #10
    //   506: aload #10
    //   508: aload #9
    //   510: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: ldc 'cr.media'
    //   516: aload #10
    //   518: invokevirtual toString : ()Ljava/lang/String;
    //   521: iconst_0
    //   522: anewarray java/lang/Object
    //   525: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   528: goto -> 660
    //   531: astore #9
    //   533: iconst_1
    //   534: istore #4
    //   536: iconst_1
    //   537: istore #5
    //   539: new java/lang/StringBuilder
    //   542: dup
    //   543: ldc 'Cannot access metadata: '
    //   545: invokespecial <init> : (Ljava/lang/String;)V
    //   548: astore #10
    //   550: aload #10
    //   552: aload #9
    //   554: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: ldc 'cr.media'
    //   560: aload #10
    //   562: invokevirtual toString : ()Ljava/lang/String;
    //   565: iconst_0
    //   566: anewarray java/lang/Object
    //   569: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   572: goto -> 660
    //   575: astore #9
    //   577: iconst_1
    //   578: istore #4
    //   580: iconst_1
    //   581: istore #5
    //   583: new java/lang/StringBuilder
    //   586: dup
    //   587: ldc 'Cannot invoke MediaPlayer.getMetadata() method: '
    //   589: invokespecial <init> : (Ljava/lang/String;)V
    //   592: astore #10
    //   594: aload #10
    //   596: aload #9
    //   598: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: ldc 'cr.media'
    //   604: aload #10
    //   606: invokevirtual toString : ()Ljava/lang/String;
    //   609: iconst_0
    //   610: anewarray java/lang/Object
    //   613: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   616: goto -> 660
    //   619: astore #9
    //   621: iconst_1
    //   622: istore #4
    //   624: iconst_1
    //   625: istore #5
    //   627: new java/lang/StringBuilder
    //   630: dup
    //   631: ldc 'Cannot find getMetadata() method: '
    //   633: invokespecial <init> : (Ljava/lang/String;)V
    //   636: astore #10
    //   638: aload #10
    //   640: aload #9
    //   642: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   645: pop
    //   646: ldc 'cr.media'
    //   648: aload #10
    //   650: invokevirtual toString : ()Ljava/lang/String;
    //   653: iconst_0
    //   654: anewarray java/lang/Object
    //   657: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   660: new org/chromium/media/MediaPlayerBridge$AllowedOperations
    //   663: dup
    //   664: iload #4
    //   666: iload #5
    //   668: iload #6
    //   670: invokespecial <init> : (ZZZ)V
    //   673: areturn
    // Exception table:
    //   from	to	target	type
    //   15	76	619	java/lang/NoSuchMethodException
    //   15	76	575	java/lang/reflect/InvocationTargetException
    //   15	76	531	java/lang/IllegalAccessException
    //   15	76	487	java/lang/NoSuchFieldException
    //   81	245	619	java/lang/NoSuchMethodException
    //   81	245	575	java/lang/reflect/InvocationTargetException
    //   81	245	531	java/lang/IllegalAccessException
    //   81	245	487	java/lang/NoSuchFieldException
    //   262	315	453	java/lang/NoSuchMethodException
    //   262	315	448	java/lang/reflect/InvocationTargetException
    //   262	315	443	java/lang/IllegalAccessException
    //   262	315	438	java/lang/NoSuchFieldException
    //   332	385	433	java/lang/NoSuchMethodException
    //   332	385	428	java/lang/reflect/InvocationTargetException
    //   332	385	423	java/lang/IllegalAccessException
    //   332	385	418	java/lang/NoSuchFieldException
  }
  
  @CalledByNative
  protected int getCurrentPosition() {
    return getLocalPlayer().getCurrentPosition();
  }
  
  @CalledByNative
  protected int getDuration() {
    return getLocalPlayer().getDuration();
  }
  
  protected final MediaPlayer getLocalPlayer() {
    if (this.mPlayer == null)
      this.mPlayer = new MediaPlayer(); 
    return this.mPlayer;
  }
  
  @CalledByNative
  protected int getVideoHeight() {
    return getLocalPlayer().getVideoHeight();
  }
  
  @CalledByNative
  protected int getVideoWidth() {
    return getLocalPlayer().getVideoWidth();
  }
  
  @CalledByNative
  protected boolean hasAudio() {
    return hasTrack(2);
  }
  
  @CalledByNative
  protected boolean hasVideo() {
    return hasTrack(1);
  }
  
  @CalledByNative
  protected boolean isPlaying() {
    return getLocalPlayer().isPlaying();
  }
  
  @CalledByNative
  protected void pause() {
    getLocalPlayer().pause();
  }
  
  @CalledByNative
  protected boolean prepareAsync() {
    try {
      getLocalPlayer().prepareAsync();
      return true;
    } catch (IllegalStateException illegalStateException) {
      Log.e("cr.media", "Unable to prepare MediaPlayer.", new Object[] { illegalStateException });
      return false;
    } catch (Exception exception) {
      Log.e("cr.media", "Unable to prepare MediaPlayer.", new Object[] { exception });
      return false;
    } 
  }
  
  @CalledByNative
  protected void release() {
    cancelLoadDataUriTask();
    getLocalPlayer().release();
  }
  
  @CalledByNative
  protected void seekTo(int paramInt) {
    getLocalPlayer().seekTo(paramInt);
  }
  
  @CalledByNative
  protected boolean setDataSource(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
    Uri uri = Uri.parse(paramString1);
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    if (paramBoolean)
      hashMap.put("x-hide-urls-from-log", "true"); 
    if (!TextUtils.isEmpty(paramString2))
      hashMap.put("Cookie", paramString2); 
    if (!TextUtils.isEmpty(paramString3))
      hashMap.put("User-Agent", paramString3); 
    if (Build.VERSION.SDK_INT > 19)
      hashMap.put("allow-cross-domain-redirect", "false"); 
    try {
      getLocalPlayer().setDataSource(ContextUtils.sApplicationContext, uri, hashMap);
      return true;
    } catch (Exception exception) {
      return false;
    } 
  }
  
  @CalledByNative
  protected boolean setDataSourceFromFd(int paramInt, long paramLong1, long paramLong2) {
    try {
      ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.adoptFd(paramInt);
      getLocalPlayer().setDataSource(parcelFileDescriptor.getFileDescriptor(), paramLong1, paramLong2);
      parcelFileDescriptor.close();
      return true;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder("Failed to set data source from file descriptor: ");
      stringBuilder.append(iOException);
      Log.e("cr.media", stringBuilder.toString(), new Object[0]);
      return false;
    } 
  }
  
  @CalledByNative
  protected boolean setDataUriDataSource(String paramString) {
    cancelLoadDataUriTask();
    if (!paramString.startsWith("data:"))
      return false; 
    int i = paramString.indexOf(',');
    if (i == -1)
      return false; 
    String str = paramString.substring(0, i);
    paramString = paramString.substring(i + 1);
    String[] arrayOfString = str.substring(5).split(";");
    if (arrayOfString.length != 2)
      return false; 
    if (!"base64".equals(arrayOfString[1]))
      return false; 
    this.mLoadDataUriTask = new MediaPlayerBridge$LoadDataUriTask(this, paramString);
    this.mLoadDataUriTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
    return true;
  }
  
  protected final void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener paramOnBufferingUpdateListener) {
    getLocalPlayer().setOnBufferingUpdateListener(paramOnBufferingUpdateListener);
  }
  
  protected final void setOnCompletionListener(MediaPlayer.OnCompletionListener paramOnCompletionListener) {
    getLocalPlayer().setOnCompletionListener(paramOnCompletionListener);
  }
  
  protected final void setOnErrorListener(MediaPlayer.OnErrorListener paramOnErrorListener) {
    getLocalPlayer().setOnErrorListener(paramOnErrorListener);
  }
  
  protected final void setOnPreparedListener(MediaPlayer.OnPreparedListener paramOnPreparedListener) {
    getLocalPlayer().setOnPreparedListener(paramOnPreparedListener);
  }
  
  protected final void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {
    getLocalPlayer().setOnSeekCompleteListener(paramOnSeekCompleteListener);
  }
  
  protected final void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener paramOnVideoSizeChangedListener) {
    getLocalPlayer().setOnVideoSizeChangedListener(paramOnVideoSizeChangedListener);
  }
  
  @CalledByNative
  protected void setSurface(Surface paramSurface) {
    getLocalPlayer().setSurface(paramSurface);
  }
  
  @CalledByNative
  protected void setVolume(double paramDouble) {
    MediaPlayer mediaPlayer = getLocalPlayer();
    float f = (float)paramDouble;
    mediaPlayer.setVolume(f, f);
  }
  
  @CalledByNative
  protected void start() {
    getLocalPlayer().start();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaPlayerBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */