package com.tencent.liteav.audio.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.media.AudioManager;
import com.tencent.liteav.audio.TXCAudioEncoderConfig;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.e;
import com.tencent.liteav.audio.g;
import com.tencent.liteav.audio.impl.earmonitor.TXSystemAudioKit;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.StatusBucket;
import com.tencent.liteav.basic.util.g;
import java.io.File;
import java.lang.ref.WeakReference;

public class TXCAudioEngineJNI {
  private static final String TAG = "TXCAudioEngineJNI";
  
  private static WeakReference<g> mAudioCaptureDataListener;
  
  private static a mAudioDumpingListener = null;
  
  private static WeakReference<e> mMixedAllDataListener;
  
  private static AudioManager sAudioManager;
  
  static {
    mAudioCaptureDataListener = null;
    mMixedAllDataListener = new WeakReference<e>(null);
  }
  
  public static void InitTraeEngineLibrary(Context paramContext) {
    if (paramContext == null) {
      TXCLog.e("TXCAudioEngineJNI", "InitTraeEngineLibrary failed, context is null!");
      return;
    } 
    try {
      ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
      String str3 = applicationInfo.nativeLibraryDir;
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(applicationInfo.dataDir);
      stringBuilder2.append("/lib");
      String str4 = stringBuilder2.toString();
      stringBuilder2 = new StringBuilder();
      stringBuilder2.append("/data/data/");
      stringBuilder2.append(applicationInfo.packageName);
      stringBuilder2.append("/lib");
      String str5 = stringBuilder2.toString();
      String str2 = g.g();
      String str1 = str2;
      if (str2 == null)
        str1 = ""; 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("add_libpath:");
      stringBuilder1.append(str3);
      nativeAppendLibraryPath(stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("add_libpath:");
      stringBuilder1.append(str4);
      nativeAppendLibraryPath(stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("add_libpath:");
      stringBuilder1.append(str5);
      nativeAppendLibraryPath(stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("add_libpath:");
      stringBuilder1.append(str1);
      nativeAppendLibraryPath(stringBuilder1.toString());
      return;
    } catch (UnsatisfiedLinkError unsatisfiedLinkError) {
      TXCLog.e("TXCAudioEngineJNI", "init trae engine library failed.", unsatisfiedLinkError);
      return;
    } 
  }
  
  public static void SetAudioDumpingListener(a parama) {
    mAudioDumpingListener = parama;
  }
  
  private static AudioManager getAudioManager() {
    if (sAudioManager == null)
      sAudioManager = (AudioManager)TXCAudioEngine.getInstance().getAppContext().getSystemService("audio"); 
    return sAudioManager;
  }
  
  public static int getAudioMode() {
    try {
      AudioManager audioManager = getAudioManager();
      if (audioManager != null)
        return audioManager.getMode(); 
    } catch (Exception exception) {}
    return -1;
  }
  
  public static StatusBucket getStatus(int paramInt) {
    return nativeGetStatus(paramInt);
  }
  
  public static int getSystemVolume() {
    try {
      int i;
      if (getAudioMode() == 0) {
        i = 3;
      } else {
        i = 0;
      } 
      AudioManager audioManager = getAudioManager();
      if (audioManager != null)
        return audioManager.getStreamVolume(i); 
    } catch (Exception exception) {}
    return -1;
  }
  
  public static boolean isAppInBackground() {
    return g.a(TXCAudioEngine.getInstance().getAppContext());
  }
  
  public static native void nativeAppendLibraryPath(String paramString);
  
  public static native void nativeCacheClassForNative();
  
  public static boolean nativeCheckTraeEngine(Context paramContext) {
    boolean bool;
    if (paramContext == null) {
      TXCLog.e("TXCAudioEngineJNI", "nativeCheckTraeEngine failed, context is null!");
      return false;
    } 
    if (g.a("traeimp-rtmp")) {
      TXCLog.e("TXCAudioEngineJNI", "link traeimp-rtmp success !");
      return true;
    } 
    ApplicationInfo applicationInfo = paramContext.getApplicationInfo();
    String str5 = applicationInfo.nativeLibraryDir;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(applicationInfo.dataDir);
    stringBuilder2.append("/lib");
    String str3 = stringBuilder2.toString();
    stringBuilder2 = new StringBuilder();
    stringBuilder2.append("/data/data/");
    stringBuilder2.append(applicationInfo.packageName);
    stringBuilder2.append("/lib");
    String str4 = stringBuilder2.toString();
    String str2 = g.g();
    String str1 = str2;
    if (str2 == null)
      str1 = ""; 
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str5);
    stringBuilder1.append("/libtraeimp-rtmp.so");
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("nativeCheckTraeEngine load so error ");
    stringBuilder1.append(str5);
    stringBuilder1.append("/libtraeimp-rtmp.so");
    TXCLog.w("TXCAudioEngineJNI", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str3);
    stringBuilder1.append("/libtraeimp-rtmp.so");
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("nativeCheckTraeEngine load so error ");
    stringBuilder1.append(str3);
    stringBuilder1.append("/libtraeimp-rtmp.so");
    TXCLog.w("TXCAudioEngineJNI", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str4);
    stringBuilder1.append("/libtraeimp-rtmp.so");
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append("nativeCheckTraeEngine load so error ");
    stringBuilder1.append(str4);
    stringBuilder1.append("/libtraeimp-rtmp.so");
    TXCLog.w("TXCAudioEngineJNI", stringBuilder1.toString());
    stringBuilder1 = new StringBuilder();
    stringBuilder1.append(str1);
    stringBuilder1.append("/libtraeimp-rtmp.so");
    if ((new File(stringBuilder1.toString())).exists() || (new File(stringBuilder1.toString())).exists() || (new File(stringBuilder1.toString())).exists() || (new File(stringBuilder1.toString())).exists()) {
      bool = true;
    } else {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("nativeCheckTraeEngine load so error ");
      stringBuilder1.append(str1);
      stringBuilder1.append("/libtraeimp-rtmp.so");
      TXCLog.w("TXCAudioEngineJNI", stringBuilder1.toString());
      bool = false;
    } 
    if (bool)
      return true; 
    TXCLog.e("TXCAudioEngineJNI", "nativeCheckTraeEngine failed, can not find trae libs !");
    return false;
  }
  
  public static native void nativeClean();
  
  public static native void nativeDeleteAudioSessionDuplicate();
  
  public static native void nativeEnableAudioEarMonitoring(boolean paramBoolean);
  
  public static native void nativeEnableAudioVolumeEvaluation(boolean paramBoolean, int paramInt);
  
  public static native void nativeEnableAutoRestartDevice(boolean paramBoolean);
  
  public static native void nativeEnableCaptureEOSMode(boolean paramBoolean);
  
  public static native void nativeEnableEncodedDataCallback(boolean paramBoolean);
  
  public static native void nativeEnableEncodedDataPackWithTRAEHeaderCallback(boolean paramBoolean);
  
  public static native void nativeEnableInbandFEC(boolean paramBoolean);
  
  public static native void nativeEnableMixMode(boolean paramBoolean);
  
  public static native void nativeForceCallbackMixedPlayAudioFrame(boolean paramBoolean);
  
  public static native int nativeGetEncoderChannels();
  
  public static native TXCAudioEncoderConfig nativeGetEncoderConfig();
  
  public static native int nativeGetEncoderSampleRate();
  
  public static native int nativeGetMixingPlayoutVolumeLevel();
  
  public static native int nativeGetRemotePlayoutVolumeLevel(String paramString);
  
  public static native int nativeGetSoftwareCaptureVolumeLevel();
  
  public static native StatusBucket nativeGetStatus(int paramInt);
  
  public static native void nativeInitAudioDevice();
  
  public static native void nativeInitBeforeEngineCreate(Context paramContext);
  
  public static native boolean nativeIsAudioDeviceCapturing();
  
  public static native boolean nativeIsAudioDevicePlaying();
  
  public static native boolean nativeIsDataCallbackFormatInvalid(int paramInt1, int paramInt2, int paramInt3);
  
  public static native boolean nativeIsRemoteAudioPlaying(String paramString);
  
  public static native void nativeMuteLocalAudio(boolean paramBoolean);
  
  public static native void nativeMuteRemoteAudio(String paramString, boolean paramBoolean);
  
  public static native void nativeMuteRemoteAudioInSpeaker(String paramString, boolean paramBoolean);
  
  public static native void nativeNewAudioSessionDuplicate(Context paramContext);
  
  public static native void nativeNotifySystemEarMonitoringInitializing();
  
  public static native void nativePauseAudioCapture(boolean paramBoolean);
  
  public static native void nativePauseLocalAudio();
  
  public static native void nativeResumeAudioCapture();
  
  public static native void nativeResumeLocalAudio();
  
  public static native void nativeSendCustomPCMData(byte[] paramArrayOfbyte, int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  public static native void nativeSetAudioEarMonitoringVolume(int paramInt);
  
  public static native void nativeSetAudioEncoderParam(int paramInt1, int paramInt2);
  
  public static native void nativeSetAudioEngineCaptureDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineCaptureRawDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineEncodedDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineMixedAllDataCallback(boolean paramBoolean);
  
  public static native void nativeSetAudioEngineRemoteStreamDataListener(String paramString, boolean paramBoolean);
  
  public static native void nativeSetAudioPlayoutTunnelEnabled(boolean paramBoolean);
  
  public static native void nativeSetAudioQuality(int paramInt1, int paramInt2);
  
  public static native void nativeSetAudioRoute(int paramInt);
  
  public static native void nativeSetCaptureDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetCaptureVoiceChanger(int paramInt);
  
  public static native void nativeSetEncoderChannels(int paramInt);
  
  public static native void nativeSetEncoderFECPercent(float paramFloat);
  
  public static native void nativeSetEncoderSampleRate(int paramInt);
  
  public static native void nativeSetEventCallbackEnabled(boolean paramBoolean);
  
  public static native void nativeSetLocalProcessedDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetMaxSelectedPlayStreams(int paramInt);
  
  public static native void nativeSetMixingPlayoutVolume(float paramFloat);
  
  public static native void nativeSetPlayoutDataCallbackFormat(int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetPlayoutDataListener(boolean paramBoolean);
  
  public static native void nativeSetPlayoutDevice(int paramInt);
  
  public static native void nativeSetRecordReverb(int paramInt);
  
  public static native void nativeSetRemoteAudioBlockThreshold(String paramString, long paramLong);
  
  public static native void nativeSetRemoteAudioCacheParams(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetRemoteAudioJitterCycle(String paramString, long paramLong);
  
  public static native void nativeSetRemotePlayoutVolume(String paramString, int paramInt);
  
  public static native void nativeSetRemoteStreamDataCallbackFormat(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public static native void nativeSetSoftAEC(int paramInt);
  
  public static native void nativeSetSoftAGC(int paramInt);
  
  public static native void nativeSetSoftANS(int paramInt);
  
  public static native void nativeSetSoftwareCaptureVolume(float paramFloat);
  
  public static native void nativeSetSystemEarMonitoring(TXSystemAudioKit paramTXSystemAudioKit);
  
  public static native void nativeSetSystemVolumeType(int paramInt);
  
  public static native void nativeSetTRAEConfig(String paramString);
  
  public static native void nativeStartLocalAudio(int paramInt, boolean paramBoolean);
  
  public static native int nativeStartLocalAudioDumping(int paramInt1, int paramInt2, String paramString);
  
  public static native String nativeStartRemoteAudio(TXCAudioEngine paramTXCAudioEngine, boolean paramBoolean, String paramString);
  
  public static native void nativeStopLocalAudio();
  
  public static native void nativeStopLocalAudioDumping();
  
  public static native void nativeStopRemoteAudio(String paramString);
  
  public static native void nativeUseSysAudioDevice(boolean paramBoolean);
  
  public static void onError(String paramString1, int paramInt, String paramString2, String paramString3) {
    TXCAudioEngine.getInstance().onError(paramString1, paramInt, paramString2, paramString3);
  }
  
  public static void onEvent(String paramString1, int paramInt, String paramString2, String paramString3) {
    TXCAudioEngine.getInstance().onEvent(paramString1, paramInt, paramString2, paramString3);
  }
  
  public static void onLocalAudioWriteFail() {
    a a1 = mAudioDumpingListener;
    if (a1 != null)
      a1.onLocalAudioWriteFailed(); 
  }
  
  public static void onMixedAllData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    e e = mMixedAllDataListener.get();
    if (e != null)
      e.onMixedAllData(paramArrayOfbyte, paramInt1, paramInt2); 
  }
  
  public static void onRecordEncData(byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2) {
    WeakReference<g> weakReference = mAudioCaptureDataListener;
    if (weakReference != null && weakReference.get() != null)
      ((g)mAudioCaptureDataListener.get()).onRecordEncData(paramArrayOfbyte, paramLong, paramInt1, paramInt2, 16); 
  }
  
  public static void onRecordError(int paramInt, String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("onRecordError: ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", ");
    stringBuilder.append(paramString);
    TXCLog.e("TXCAudioEngineJNI", stringBuilder.toString());
    WeakReference<g> weakReference = mAudioCaptureDataListener;
    if (weakReference != null && weakReference.get() != null)
      ((g)mAudioCaptureDataListener.get()).onRecordError(paramInt, paramString); 
  }
  
  public static void onRecordPcmData(byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2, int paramInt3) {
    WeakReference<g> weakReference = mAudioCaptureDataListener;
    if (weakReference != null && weakReference.get() != null)
      ((g)mAudioCaptureDataListener.get()).onRecordPcmData(paramArrayOfbyte, paramLong, paramInt1, paramInt2, paramInt3); 
  }
  
  public static void onRecordRawPcmData(byte[] paramArrayOfbyte, long paramLong, int paramInt1, int paramInt2, int paramInt3) {
    WeakReference<g> weakReference = mAudioCaptureDataListener;
    if (weakReference != null && weakReference.get() != null)
      ((g)mAudioCaptureDataListener.get()).onRecordRawPcmData(paramArrayOfbyte, paramLong, paramInt1, paramInt2, paramInt3, false); 
  }
  
  public static void onWarning(String paramString1, int paramInt, String paramString2, String paramString3) {
    TXCAudioEngine.getInstance().onWarning(paramString1, paramInt, paramString2, paramString3);
  }
  
  public static void pauseAudioCapture(boolean paramBoolean) {
    nativePauseAudioCapture(paramBoolean);
  }
  
  public static void resumeAudioCapture() {
    nativeResumeAudioCapture();
  }
  
  public static void sendCustomPCMData(com.tencent.liteav.basic.structs.a parama) {
    nativeSendCustomPCMData(parama.audioData, parama.audioData.length, parama.timestamp, parama.sampleRate, parama.channelsPerSample);
  }
  
  public static void sendCustomPCMData(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    nativeSendCustomPCMData(paramArrayOfbyte, paramArrayOfbyte.length, 0L, paramInt1, paramInt2);
  }
  
  public static void setAudioCaptureDataListener(WeakReference<g> paramWeakReference) {
    boolean bool1;
    mAudioCaptureDataListener = paramWeakReference;
    paramWeakReference = mAudioCaptureDataListener;
    boolean bool2 = false;
    if (paramWeakReference == null) {
      bool1 = false;
    } else {
      bool1 = true;
    } 
    nativeSetAudioEngineCaptureDataCallback(bool1);
    if (mAudioCaptureDataListener == null) {
      bool1 = false;
    } else {
      bool1 = true;
    } 
    nativeSetAudioEngineCaptureRawDataCallback(bool1);
    if (mAudioCaptureDataListener == null) {
      bool1 = bool2;
    } else {
      bool1 = true;
    } 
    nativeSetAudioEngineEncodedDataCallback(bool1);
  }
  
  public static void setMixedAllDataListener(e parame) {
    boolean bool;
    mMixedAllDataListener = new WeakReference<e>(parame);
    if (parame != null) {
      bool = true;
    } else {
      bool = false;
    } 
    nativeSetAudioEngineMixedAllDataCallback(bool);
  }
  
  static {
    g.f();
    nativeCacheClassForNative();
  }
  
  public static interface a {
    void onLocalAudioWriteFailed();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\tencent\liteav\audio\impl\TXCAudioEngineJNI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */