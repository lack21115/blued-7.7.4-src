package com.tencent.liteav.audio;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.audio.impl.b;
import com.tencent.liteav.audio.impl.earmonitor.HuaweiAudioKit;
import com.tencent.liteav.audio.impl.earmonitor.TXSystemAudioKit;
import com.tencent.liteav.audio.impl.earmonitor.a;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.liteav.basic.structs.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

public class TXCAudioEngine implements b, a {
  private static final int EVT_AUDIO_DEVICE_RESTART_WHEN_USING_STABLE_SAMPLERATE = 10056;
  
  private static final int EVT_AUDIO_DEVICE_ROLLBACK_TO_STABLE_SAMPLERATE = 10055;
  
  private static final long SYSTEM_AUDIO_KIT_RESTART_INTERVAL = TimeUnit.SECONDS.toMillis(2L);
  
  private static final String TAG = "AudioEngine :TXCAudioEngine_java";
  
  private static volatile boolean has_init;
  
  private static boolean has_trae;
  
  private static WeakReference<f> mAudioCoreDataListener;
  
  protected static Context mContext;
  
  protected static final HashMap<String, WeakReference<f>> mJitterDataListenerMap;
  
  private static final Object mJitterDataListenerMapLock;
  
  protected static final HashMap<String, WeakReference<d>> mJitterEventListenerMap;
  
  private static final Object mJitterEventListenerMapLock;
  
  static TXCAudioEngine sInstance = new TXCAudioEngine();
  
  private TXSystemAudioKit mAudioKit;
  
  private final ArrayList<WeakReference<a>> mCallbackList = new ArrayList<WeakReference<a>>();
  
  protected boolean mDeviceIsRecording = false;
  
  protected boolean mIsCallComed = false;
  
  protected boolean mIsCustomRecord = false;
  
  static {
    mContext = null;
    has_trae = false;
    mAudioCoreDataListener = null;
    mJitterDataListenerMap = new HashMap<String, WeakReference<f>>();
    mJitterDataListenerMapLock = new Object();
    mJitterEventListenerMap = new HashMap<String, WeakReference<d>>();
    mJitterEventListenerMapLock = new Object();
    has_init = false;
  }
  
  public static void CreateInstance(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/tencent/liteav/audio/TXCAudioEngine
    //   2: monitorenter
    //   3: aload_0
    //   4: aload_1
    //   5: invokestatic CreateInstanceWithoutInitDevice : (Landroid/content/Context;Ljava/lang/String;)V
    //   8: invokestatic nativeInitAudioDevice : ()V
    //   11: ldc com/tencent/liteav/audio/TXCAudioEngine
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/tencent/liteav/audio/TXCAudioEngine
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static void CreateInstanceWithoutInitDevice(Context paramContext, String paramString) {
    // Byte code:
    //   0: ldc com/tencent/liteav/audio/TXCAudioEngine
    //   2: monitorenter
    //   3: ldc 'AudioEngine :TXCAudioEngine_java'
    //   5: ldc 'CreateInstance: '
    //   7: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   14: putstatic com/tencent/liteav/audio/TXCAudioEngine.mContext : Landroid/content/Context;
    //   17: getstatic com/tencent/liteav/audio/TXCAudioEngine.has_init : Z
    //   20: ifeq -> 34
    //   23: ldc 'AudioEngine :TXCAudioEngine_java'
    //   25: ldc 'CreateInstance already created~ '
    //   27: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)V
    //   30: ldc com/tencent/liteav/audio/TXCAudioEngine
    //   32: monitorexit
    //   33: return
    //   34: aload_0
    //   35: invokestatic nativeCheckTraeEngine : (Landroid/content/Context;)Z
    //   38: ifeq -> 45
    //   41: iconst_1
    //   42: putstatic com/tencent/liteav/audio/TXCAudioEngine.has_trae : Z
    //   45: getstatic com/tencent/liteav/audio/TXCAudioEngine.has_trae : Z
    //   48: ifne -> 128
    //   51: iconst_1
    //   52: istore_2
    //   53: goto -> 56
    //   56: iload_2
    //   57: invokestatic nativeUseSysAudioDevice : (Z)V
    //   60: getstatic com/tencent/liteav/audio/TXCAudioEngine.has_trae : Z
    //   63: ifeq -> 106
    //   66: aload_0
    //   67: invokestatic InitTraeEngineLibrary : (Landroid/content/Context;)V
    //   70: aload_1
    //   71: invokestatic nativeSetTRAEConfig : (Ljava/lang/String;)V
    //   74: aload_0
    //   75: invokestatic nativeInitBeforeEngineCreate : (Landroid/content/Context;)V
    //   78: invokestatic a : ()Lcom/tencent/liteav/audio/impl/a;
    //   81: aload_0
    //   82: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   85: invokevirtual a : (Landroid/content/Context;)V
    //   88: invokestatic a : ()Lcom/tencent/liteav/audio/impl/a;
    //   91: getstatic com/tencent/liteav/audio/TXCAudioEngine.sInstance : Lcom/tencent/liteav/audio/TXCAudioEngine;
    //   94: invokevirtual a : (Lcom/tencent/liteav/audio/impl/b;)V
    //   97: getstatic com/tencent/liteav/audio/TXCAudioEngine.mContext : Landroid/content/Context;
    //   100: invokestatic nativeNewAudioSessionDuplicate : (Landroid/content/Context;)V
    //   103: goto -> 114
    //   106: invokestatic getInstance : ()Lcom/tencent/liteav/audio/impl/Play/TXCMultAudioTrackPlayer;
    //   109: pop
    //   110: invokestatic getInstance : ()Lcom/tencent/liteav/audio/impl/Record/TXCAudioSysRecord;
    //   113: pop
    //   114: iconst_1
    //   115: putstatic com/tencent/liteav/audio/TXCAudioEngine.has_init : Z
    //   118: ldc com/tencent/liteav/audio/TXCAudioEngine
    //   120: monitorexit
    //   121: return
    //   122: astore_0
    //   123: ldc com/tencent/liteav/audio/TXCAudioEngine
    //   125: monitorexit
    //   126: aload_0
    //   127: athrow
    //   128: iconst_0
    //   129: istore_2
    //   130: goto -> 56
    // Exception table:
    //   from	to	target	type
    //   3	30	122	finally
    //   34	45	122	finally
    //   45	51	122	finally
    //   56	103	122	finally
    //   106	114	122	finally
    //   114	118	122	finally
  }
  
  public static String buildTRAEConfig(Context paramContext, Boolean paramBoolean, boolean paramBoolean1, long paramLong) {
    boolean bool;
    StringBuilder stringBuilder3 = new StringBuilder();
    stringBuilder3.append("");
    stringBuilder3.append("sharp {\n");
    String str3 = stringBuilder3.toString();
    StringBuilder stringBuilder4 = new StringBuilder();
    stringBuilder4.append(str3);
    stringBuilder4.append("  os android\n");
    str3 = stringBuilder4.toString();
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append(str3);
    stringBuilder4.append("  trae {\n");
    str3 = stringBuilder4.toString();
    stringBuilder4 = new StringBuilder();
    stringBuilder4.append(str3);
    stringBuilder4.append("    dev {\n");
    String str4 = stringBuilder4.toString();
    str3 = str4;
    if (paramBoolean != null) {
      String str;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str4);
      stringBuilder.append("  closeOpensl ");
      if (paramBoolean.booleanValue()) {
        str = "n";
      } else {
        str = "y";
      } 
      stringBuilder.append(str);
      stringBuilder.append("\n");
      str3 = stringBuilder.toString();
    } 
    long l = b.a().b("timestamp_rollback_to_stable_samplerate", 0L);
    if (System.currentTimeMillis() - l < paramLong) {
      bool = true;
    } else {
      bool = false;
    } 
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "low latency samplerate, enable: %b, isBlocked: %b, blockTime: %d", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(bool), Long.valueOf(paramLong) });
    String str2 = str3;
    if (!bool) {
      str2 = str3;
      if (paramBoolean1) {
        str2 = str3;
        if (getLowLatencySampleRate(paramContext) == 48000) {
          StringBuilder stringBuilder5 = new StringBuilder();
          stringBuilder5.append(str3);
          stringBuilder5.append("  component 1\n");
          String str = stringBuilder5.toString();
          StringBuilder stringBuilder6 = new StringBuilder();
          stringBuilder6.append(str);
          stringBuilder6.append("  cap {\n");
          str = stringBuilder6.toString();
          stringBuilder6 = new StringBuilder();
          stringBuilder6.append(str);
          stringBuilder6.append("    hw_sr 48000\n");
          str = stringBuilder6.toString();
          stringBuilder6 = new StringBuilder();
          stringBuilder6.append(str);
          stringBuilder6.append("  }\n");
          str = stringBuilder6.toString();
          stringBuilder6 = new StringBuilder();
          stringBuilder6.append(str);
          stringBuilder6.append("  play {\n");
          str = stringBuilder6.toString();
          stringBuilder6 = new StringBuilder();
          stringBuilder6.append(str);
          stringBuilder6.append("    hw_sr 48000\n");
          str = stringBuilder6.toString();
          stringBuilder6 = new StringBuilder();
          stringBuilder6.append(str);
          stringBuilder6.append("  }");
          str2 = stringBuilder6.toString();
        } 
      } 
    } 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str2);
    stringBuilder1.append("    }\n");
    String str1 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append("  }\n");
    str1 = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append(str1);
    stringBuilder2.append("}");
    return stringBuilder2.toString();
  }
  
  private TXSystemAudioKit createManufacturerAudioKit(Context paramContext) {
    return (TXSystemAudioKit)(Build.MANUFACTURER.equalsIgnoreCase("huawei") ? new HuaweiAudioKit() : null);
  }
  
  public static void enableAudioEarMonitoring(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableAudioEarMonitoring: ");
    stringBuilder.append(paramBoolean);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeEnableAudioEarMonitoring(paramBoolean);
  }
  
  public static boolean enableAudioVolumeEvaluation(boolean paramBoolean, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableAudioVolumeEvaluation : ");
    stringBuilder.append(paramBoolean);
    stringBuilder.append("interval:");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeEnableAudioVolumeEvaluation(paramBoolean, paramInt);
    return true;
  }
  
  public static TXCAudioEngine getInstance() {
    return sInstance;
  }
  
  private static int getLowLatencySampleRate(Context paramContext) {
    if (Build.VERSION.SDK_INT >= 17) {
      AudioManager audioManager = (AudioManager)paramContext.getSystemService("audio");
      if (audioManager != null)
        try {
          return Integer.parseInt(audioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE"));
        } catch (NumberFormatException numberFormatException) {
          TXCLog.e("AudioEngine :TXCAudioEngine_java", "can't parse low latency samplerate", numberFormatException);
        }  
    } 
    return -1;
  }
  
  public static int getMixingPlayoutVolumeLevel() {
    return TXCAudioEngineJNI.nativeGetMixingPlayoutVolumeLevel();
  }
  
  private void handleAudioEvent(String paramString1, int paramInt, String paramString2, String paramString3) {
    if (paramInt == 10055) {
      b.a().a("timestamp_rollback_to_stable_samplerate", System.currentTimeMillis());
      return;
    } 
    if (paramInt == 10056) {
      b.a().a("timestamp_rollback_to_stable_samplerate", 0L);
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "audio device restart when using stable samplerate");
    } 
  }
  
  public static boolean hasTrae() {
    return has_trae;
  }
  
  public static void onAudioJitterBufferNotify(String paramString1, int paramInt, String paramString2) {
    synchronized (mJitterEventListenerMapLock) {
      d d;
      if (mJitterEventListenerMap.get(paramString1) != null) {
        d = ((WeakReference<d>)mJitterEventListenerMap.get(paramString1)).get();
      } else {
        d = null;
      } 
      if (d != null) {
        null = new StringBuilder();
        null.append("onAudioJitterBufferNotify  cur state ");
        null.append(paramInt);
        TXCLog.i("AudioEngine :TXCAudioEngine_java", null.toString());
        d.onAudioJitterBufferNotify(paramString1, paramInt, paramString2);
      } 
      return;
    } 
  }
  
  public static void onAudioPlayPcmData(String paramString, byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2) {
    synchronized (mJitterDataListenerMapLock) {
      f f;
      if (mJitterDataListenerMap.get(paramString) != null) {
        f = ((WeakReference<f>)mJitterDataListenerMap.get(paramString)).get();
      } else {
        f = null;
      } 
      if (f != null)
        f.onAudioPlayPcmData(paramString, paramArrayOfbyte, paramLong, paramInt1, paramInt2); 
      return;
    } 
  }
  
  public static void onCorePlayPcmData(byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2) {
    WeakReference<f> weakReference = mAudioCoreDataListener;
    if (weakReference != null) {
      f f = weakReference.get();
      if (f != null)
        f.onAudioPlayPcmData(null, paramArrayOfbyte, paramLong, paramInt1, paramInt2); 
    } 
  }
  
  public static void setAudioEarMonitoringVolume(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAudioEarMonitoringVolume: ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeSetAudioEarMonitoringVolume(paramInt);
  }
  
  public static void setAudioRoute(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setAudioRoute: ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeSetAudioRoute(paramInt);
  }
  
  public static void setPlayoutDataListener(f paramf) {
    boolean bool;
    mAudioCoreDataListener = new WeakReference<f>(paramf);
    if (paramf == null) {
      bool = false;
    } else {
      bool = true;
    } 
    TXCAudioEngineJNI.nativeSetPlayoutDataListener(bool);
  }
  
  public static void setSystemVolumeType(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setSystemVolumeType: ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeSetSystemVolumeType(paramInt);
  }
  
  private void startSystemAudioKit() {
    if (this.mAudioKit == null) {
      Context context = mContext;
      if (context == null)
        return; 
      this.mAudioKit = createManufacturerAudioKit(context);
      if (this.mAudioKit != null) {
        TXCAudioEngineJNI.nativeNotifySystemEarMonitoringInitializing();
        this.mAudioKit.initialize(mContext, this);
        return;
      } 
      TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null);
    } 
  }
  
  public void EnableMixMode(boolean paramBoolean) {
    TXCAudioEngineJNI.nativeEnableMixMode(paramBoolean);
  }
  
  public boolean IsDataCallbackFormatInvalid(int paramInt1, int paramInt2, int paramInt3) {
    return TXCAudioEngineJNI.nativeIsDataCallbackFormatInvalid(paramInt1, paramInt2, paramInt3);
  }
  
  public void addEventCallback(WeakReference<a> paramWeakReference) {
    if (paramWeakReference == null)
      return; 
    synchronized (this.mCallbackList) {
      this.mCallbackList.add(paramWeakReference);
      TXCAudioEngineJNI.nativeSetEventCallbackEnabled(true);
      return;
    } 
  }
  
  public void clean() {
    TXCAudioEngineJNI.nativeClean();
  }
  
  public void enableAutoRestartDevice(boolean paramBoolean) {
    TXCAudioEngineJNI.nativeEnableAutoRestartDevice(paramBoolean);
  }
  
  public boolean enableCaptureEOSMode(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableEosMode ");
    stringBuilder.append(paramBoolean);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeEnableCaptureEOSMode(paramBoolean);
    return true;
  }
  
  public void enableEncodedDataCallback(boolean paramBoolean) {
    TXCAudioEngineJNI.nativeEnableEncodedDataCallback(paramBoolean);
  }
  
  public void enableEncodedDataPackWithTRAEHeaderCallback(boolean paramBoolean) {
    TXCAudioEngineJNI.nativeEnableEncodedDataPackWithTRAEHeaderCallback(paramBoolean);
  }
  
  public void enableInbandFEC(boolean paramBoolean) {
    TXCAudioEngineJNI.nativeEnableInbandFEC(paramBoolean);
  }
  
  public void enableSoftAEC(boolean paramBoolean, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableSoftAEC: enable = ");
    stringBuilder.append(paramBoolean);
    stringBuilder.append(" level = ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    if (!paramBoolean)
      paramInt = 0; 
    TXCAudioEngineJNI.nativeSetSoftAEC(paramInt);
  }
  
  public void enableSoftAGC(boolean paramBoolean, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableSoftAGC: enable = ");
    stringBuilder.append(paramBoolean);
    stringBuilder.append(" level = ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    if (!paramBoolean)
      paramInt = 0; 
    TXCAudioEngineJNI.nativeSetSoftAGC(paramInt);
  }
  
  public void enableSoftANS(boolean paramBoolean, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("enableSoftANS: enable = ");
    stringBuilder.append(paramBoolean);
    stringBuilder.append(" level = ");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    if (!paramBoolean)
      paramInt = 0; 
    TXCAudioEngineJNI.nativeSetSoftANS(paramInt);
  }
  
  public void forceCallbackMixedPlayAudioFrame(boolean paramBoolean) {
    TXCAudioEngineJNI.nativeForceCallbackMixedPlayAudioFrame(paramBoolean);
  }
  
  public int getAECType() {
    return 2;
  }
  
  public Context getAppContext() {
    return mContext;
  }
  
  public TXCAudioEncoderConfig getAudioEncoderConfig() {
    return TXCAudioEngineJNI.nativeGetEncoderConfig();
  }
  
  public int getEncoderChannels() {
    return TXCAudioEngineJNI.nativeGetEncoderChannels();
  }
  
  public int getEncoderSampleRate() {
    return TXCAudioEngineJNI.nativeGetEncoderSampleRate();
  }
  
  public int getPlayAECType() {
    return has_trae ? 2 : 0;
  }
  
  public int getPlayChannels() {
    return 2;
  }
  
  public int getPlaySampleRate() {
    return 48000;
  }
  
  public int getRemotePlayoutVolumeLevel(String paramString) {
    return (paramString == null) ? 0 : TXCAudioEngineJNI.nativeGetRemotePlayoutVolumeLevel(paramString);
  }
  
  public int getSoftwareCaptureVolumeLevel() {
    return TXCAudioEngineJNI.nativeGetSoftwareCaptureVolumeLevel();
  }
  
  public StatusBucket getStatus(int paramInt) {
    return TXCAudioEngineJNI.getStatus(paramInt);
  }
  
  public boolean isAudioDeviceCapturing() {
    boolean bool = TXCAudioEngineJNI.nativeIsAudioDeviceCapturing();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("isRecording: ");
    stringBuilder.append(bool);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    return bool;
  }
  
  public boolean isRemoteAudioPlaying(String paramString) {
    return (paramString == null) ? false : TXCAudioEngineJNI.nativeIsRemoteAudioPlaying(paramString);
  }
  
  public boolean muteLocalAudio(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setRecordMute: ");
    stringBuilder.append(paramBoolean);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeMuteLocalAudio(paramBoolean);
    return true;
  }
  
  public void muteRemoteAudio(String paramString, boolean paramBoolean) {
    if (paramString == null)
      return; 
    TXCAudioEngineJNI.nativeMuteRemoteAudio(paramString, paramBoolean);
  }
  
  public void muteRemoteAudioInSpeaker(String paramString, boolean paramBoolean) {
    if (paramString == null)
      return; 
    TXCAudioEngineJNI.nativeMuteRemoteAudioInSpeaker(paramString, paramBoolean);
  }
  
  public void onAudioKitError(TXSystemAudioKit paramTXSystemAudioKit) {
    if (this.mAudioKit != paramTXSystemAudioKit)
      return; 
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "onAudioKitError");
    paramTXSystemAudioKit = this.mAudioKit;
    if (paramTXSystemAudioKit != null) {
      paramTXSystemAudioKit.stopSystemEarMonitoring();
      this.mAudioKit.uninitialize();
      this.mAudioKit = null;
    } 
    (new Handler(Looper.getMainLooper())).postDelayed(new Runnable() {
          public void run() {
            TXCAudioEngine.this.startSystemAudioKit();
          }
        },  SYSTEM_AUDIO_KIT_RESTART_INTERVAL);
  }
  
  public void onAudioKitInitFinished(TXSystemAudioKit paramTXSystemAudioKit, boolean paramBoolean) {
    if (this.mAudioKit != paramTXSystemAudioKit)
      return; 
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "system audio kit init finished, ret: %b.", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
      TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null); 
  }
  
  public void onCallStateChanged(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2)
          return; 
        TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_OFFHOOK!");
        TXCAudioEngineJNI.pauseAudioCapture(true);
        TXAudioEffectManagerImpl.getInstance().interruptAllMusics();
        TXAudioEffectManagerImpl.getCacheInstance().interruptAllMusics();
        TXAudioEffectManagerImpl.getAutoCacheHolder().interruptAllMusics();
        this.mIsCallComed = true;
        return;
      } 
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_RINGING!");
      return;
    } 
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "TelephonyManager.CALL_STATE_IDLE!");
    if (this.mIsCallComed) {
      this.mIsCallComed = false;
      TXCAudioEngineJNI.resumeAudioCapture();
      TXAudioEffectManagerImpl.getInstance().recoverAllMusics();
      TXAudioEffectManagerImpl.getCacheInstance().recoverAllMusics();
      TXAudioEffectManagerImpl.getAutoCacheHolder().recoverAllMusics();
    } 
  }
  
  public void onEarMonitoringInitialized(TXSystemAudioKit paramTXSystemAudioKit, boolean paramBoolean) {
    if (this.mAudioKit != paramTXSystemAudioKit)
      return; 
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "onEarMonitoringInitialized result: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      TXCAudioEngineJNI.nativeSetSystemEarMonitoring(this.mAudioKit);
      return;
    } 
    TXCAudioEngineJNI.nativeSetSystemEarMonitoring(null);
  }
  
  public void onError(String paramString1, int paramInt, String paramString2, String paramString3) {
    ArrayList<WeakReference<a>> arrayList;
    Iterator<a> iterator;
    ArrayList<a> arrayList1 = new ArrayList();
    synchronized (this.mCallbackList) {
      if (this.mCallbackList.size() <= 0)
        return; 
      Iterator<WeakReference<a>> iterator1 = this.mCallbackList.iterator();
      while (iterator1.hasNext()) {
        a a1 = ((WeakReference<a>)iterator1.next()).get();
        if (a1 != null) {
          arrayList1.add(a1);
          continue;
        } 
        iterator1.remove();
      } 
      if (this.mCallbackList.size() <= 0)
        TXCAudioEngineJNI.nativeSetEventCallbackEnabled(false); 
      iterator = arrayList1.iterator();
      while (iterator.hasNext())
        ((a)iterator.next()).onError(paramString1, paramInt, paramString2, paramString3); 
      return;
    } 
  }
  
  public void onEvent(String paramString1, int paramInt, String paramString2, String paramString3) {
    ArrayList<WeakReference<a>> arrayList;
    Iterator<a> iterator;
    handleAudioEvent(paramString1, paramInt, paramString2, paramString3);
    ArrayList<a> arrayList1 = new ArrayList();
    synchronized (this.mCallbackList) {
      if (this.mCallbackList.size() <= 0)
        return; 
      Iterator<WeakReference<a>> iterator1 = this.mCallbackList.iterator();
      while (iterator1.hasNext()) {
        a a1 = ((WeakReference<a>)iterator1.next()).get();
        if (a1 != null) {
          arrayList1.add(a1);
          continue;
        } 
        iterator1.remove();
      } 
      if (this.mCallbackList.size() <= 0)
        TXCAudioEngineJNI.nativeSetEventCallbackEnabled(false); 
      iterator = arrayList1.iterator();
      while (iterator.hasNext())
        ((a)iterator.next()).onEvent(paramString1, paramInt, paramString2, paramString3); 
      return;
    } 
  }
  
  public void onWarning(String paramString1, int paramInt, String paramString2, String paramString3) {
    ArrayList<WeakReference<a>> arrayList;
    Iterator<a> iterator;
    handleAudioEvent(paramString1, paramInt, paramString2, paramString3);
    ArrayList<a> arrayList1 = new ArrayList();
    synchronized (this.mCallbackList) {
      if (this.mCallbackList.size() <= 0)
        return; 
      Iterator<WeakReference<a>> iterator1 = this.mCallbackList.iterator();
      while (iterator1.hasNext()) {
        a a1 = ((WeakReference<a>)iterator1.next()).get();
        if (a1 != null) {
          arrayList1.add(a1);
          continue;
        } 
        iterator1.remove();
      } 
      if (this.mCallbackList.size() <= 0)
        TXCAudioEngineJNI.nativeSetEventCallbackEnabled(false); 
      iterator = arrayList1.iterator();
      while (iterator.hasNext())
        ((a)iterator.next()).onWarning(paramString1, paramInt, paramString2, paramString3); 
      return;
    } 
  }
  
  public int pauseAudioCapture(boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("pauseAudioCapture: ");
    stringBuilder.append(paramBoolean);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.pauseAudioCapture(paramBoolean);
    return 0;
  }
  
  public void pauseLocalAudio() {
    TXCAudioEngineJNI.nativePauseLocalAudio();
  }
  
  public int resumeAudioCapture() {
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "resumeRecord");
    TXCAudioEngineJNI.resumeAudioCapture();
    return 0;
  }
  
  public void resumeLocalAudio() {
    TXCAudioEngineJNI.nativeResumeLocalAudio();
  }
  
  public void sendCustomPCMData(a parama) {
    TXCAudioEngineJNI.sendCustomPCMData(parama);
  }
  
  public void sendCustomPCMData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    TXCAudioEngineJNI.sendCustomPCMData(paramArrayOfbyte, paramInt1, paramInt2);
  }
  
  public boolean setAudioCaptureDataListener(g paramg) {
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "setRecordListener ");
    if (paramg == null) {
      TXCAudioEngineJNI.setAudioCaptureDataListener(null);
    } else {
      TXCAudioEngineJNI.setAudioCaptureDataListener(new WeakReference<g>(paramg));
    } 
    return true;
  }
  
  public void setAudioDumpingListener(TXCAudioEngineJNI.a parama) {
    TXCAudioEngineJNI.SetAudioDumpingListener(parama);
  }
  
  public boolean setAudioEncoderParam(int paramInt1, int paramInt2) {
    TXCAudioEngineJNI.nativeSetAudioEncoderParam(paramInt1, paramInt2);
    return true;
  }
  
  public void setAudioQuality(int paramInt1, int paramInt2) {
    TXCAudioEngineJNI.nativeSetAudioQuality(paramInt1, paramInt2);
  }
  
  public void setCaptureDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setCaptureDataCallbackFormat: sampleRate-");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" channels-");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" length-");
    stringBuilder.append(paramInt3);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeSetCaptureDataCallbackFormat(paramInt1, paramInt2, paramInt3);
  }
  
  public void setEncoderChannels(int paramInt) {
    TXCAudioEngineJNI.nativeSetEncoderChannels(paramInt);
  }
  
  public boolean setEncoderFECPercent(float paramFloat) {
    TXCAudioEngineJNI.nativeSetEncoderFECPercent(paramFloat);
    return true;
  }
  
  public void setEncoderSampleRate(int paramInt) {
    TXCAudioEngineJNI.nativeSetEncoderSampleRate(paramInt);
  }
  
  public void setLocalProcessedDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setLocalProcessedDataCallbackFormat: sampleRate-");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" channels-");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" length-");
    stringBuilder.append(paramInt3);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeSetLocalProcessedDataCallbackFormat(paramInt1, paramInt2, paramInt3);
  }
  
  public void setMaxSelectedPlayStreams(int paramInt) {
    TXCAudioEngineJNI.nativeSetMaxSelectedPlayStreams(paramInt);
  }
  
  public void setMixedAllDataListener(e parame) {
    TXCAudioEngineJNI.setMixedAllDataListener(parame);
  }
  
  public boolean setMixingPlayoutVolume(float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setPlayoutVolume: ");
    stringBuilder.append(paramFloat);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeSetMixingPlayoutVolume(paramFloat);
    return true;
  }
  
  public void setPlayoutDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setPlayoutDataCallbackFormat: sampleRate-");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" channels-");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" length-");
    stringBuilder.append(paramInt3);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeSetPlayoutDataCallbackFormat(paramInt1, paramInt2, paramInt3);
  }
  
  public void setRemoteAudioCacheParams(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3) {
    TXCAudioEngineJNI.nativeSetRemoteAudioCacheParams(paramString, paramBoolean, paramInt1, paramInt2, paramInt3);
  }
  
  public void setRemoteAudioStreamEventListener(String paramString, d paramd) {
    if (paramString == null)
      return; 
    synchronized (mJitterEventListenerMapLock) {
      mJitterEventListenerMap.put(paramString, new WeakReference<d>(paramd));
      return;
    } 
  }
  
  public void setRemotePlayoutVolume(String paramString, int paramInt) {
    if (paramString == null)
      return; 
    TXCAudioEngineJNI.nativeSetRemotePlayoutVolume(paramString, paramInt);
  }
  
  public void setRemoteStreamDataCallbackFormat(String paramString, int paramInt1, int paramInt2, int paramInt3) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setRemoteStreamDataCallbackFormat: id-");
    stringBuilder.append(paramString);
    stringBuilder.append(" sampleRate-");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" channels-");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" length-");
    stringBuilder.append(paramInt3);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeSetRemoteStreamDataCallbackFormat(paramString, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean setReverbType(TXAudioEffectManager.TXVoiceReverbType paramTXVoiceReverbType) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setReverbType: ");
    stringBuilder.append(paramTXVoiceReverbType.getNativeValue());
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeSetRecordReverb(paramTXVoiceReverbType.getNativeValue());
    return true;
  }
  
  public void setSetAudioEngineRemoteStreamDataListener(String paramString, f paramf) {
    if (paramString == null)
      return; 
    synchronized (mJitterDataListenerMapLock) {
      boolean bool;
      mJitterDataListenerMap.put(paramString, new WeakReference<f>(paramf));
      if (paramf == null) {
        bool = false;
      } else {
        bool = true;
      } 
      TXCAudioEngineJNI.nativeSetAudioEngineRemoteStreamDataListener(paramString, bool);
      return;
    } 
  }
  
  public boolean setSoftwareCaptureVolume(float paramFloat) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setRecordVolume: ");
    stringBuilder.append(paramFloat);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeSetSoftwareCaptureVolume(paramFloat);
    return true;
  }
  
  public void setSystemAudioKitEnabled() {
    startSystemAudioKit();
  }
  
  public boolean setVoiceChangerType(TXAudioEffectManager.TXVoiceChangerType paramTXVoiceChangerType) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setVoiceChangerType ");
    stringBuilder.append(paramTXVoiceChangerType.getNativeValue());
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    TXCAudioEngineJNI.nativeSetCaptureVoiceChanger(paramTXVoiceChangerType.getNativeValue());
    return true;
  }
  
  public int startLocalAudio(int paramInt, boolean paramBoolean) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startLocalAudio audioFormat:");
    stringBuilder.append(paramInt);
    TXCLog.i("AudioEngine :TXCAudioEngine_java", stringBuilder.toString());
    Context context = mContext;
    if (context == null) {
      TXCLog.i("AudioEngine :TXCAudioEngine_java", "Please call CreateInstance fisrt!!!");
      return -901;
    } 
    TXCAudioEngineJNI.InitTraeEngineLibrary(context);
    TXCAudioEngineJNI.nativeStartLocalAudio(paramInt, paramBoolean);
    this.mDeviceIsRecording = true;
    return 0;
  }
  
  public int startLocalAudioDumping(int paramInt1, int paramInt2, String paramString) {
    return TXCAudioEngineJNI.nativeStartLocalAudioDumping(paramInt1, paramInt2, paramString);
  }
  
  public void startRemoteAudio(String paramString, boolean paramBoolean) {
    TXCAudioEngineJNI.nativeStartRemoteAudio(sInstance, paramBoolean, paramString);
    TXCAudioEngineJNI.nativeSetRemoteAudioJitterCycle(paramString, c.a().a("Audio", "LIVE_JitterCycle"));
    TXCAudioEngineJNI.nativeSetRemoteAudioBlockThreshold(paramString, c.a().a("Audio", "LoadingThreshold"));
  }
  
  public int stopLocalAudio() {
    TXCLog.i("AudioEngine :TXCAudioEngine_java", "stopLocalAudio");
    TXCAudioEngineJNI.nativeStopLocalAudio();
    this.mDeviceIsRecording = false;
    return 0;
  }
  
  public void stopLocalAudioDumping() {
    TXCAudioEngineJNI.nativeStopLocalAudioDumping();
  }
  
  public void stopRemoteAudio(String paramString) {
    if (paramString == null)
      return; 
    TXCAudioEngineJNI.nativeStopRemoteAudio(paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\liteav\audio\TXCAudioEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */