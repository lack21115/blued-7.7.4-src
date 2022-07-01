package org.chromium.media;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

class AudioManagerAndroid {
  private static final String[] DEVICE_NAMES;
  
  private static final String[] SUPPORTED_AEC_MODELS = new String[] { "GT-I9300", "GT-I9500", "GT-N7105", "Nexus 4", "Nexus 5", "Nexus 7", "SM-N9005", "SM-T310" };
  
  private static final Integer[] VALID_DEVICES;
  
  private boolean[] mAudioDevices;
  
  private final AudioManager mAudioManager;
  
  private BroadcastReceiver mBluetoothHeadsetReceiver;
  
  private BroadcastReceiver mBluetoothScoReceiver;
  
  private int mBluetoothScoState = -1;
  
  private final ContentResolver mContentResolver;
  
  private boolean mHasBluetoothPermission;
  
  private boolean mHasModifyAudioSettingsPermission;
  
  private boolean mIsInitialized;
  
  private final Object mLock;
  
  private final long mNativeAudioManagerAndroid;
  
  private int mRequestedAudioDevice = -1;
  
  private boolean mSavedIsMicrophoneMute;
  
  private boolean mSavedIsSpeakerphoneOn;
  
  private ContentObserver mSettingsObserver;
  
  private HandlerThread mSettingsObserverThread;
  
  private BroadcastReceiver mUsbAudioReceiver;
  
  private final UsbManager mUsbManager;
  
  private BroadcastReceiver mWiredHeadsetReceiver;
  
  static {
    DEVICE_NAMES = new String[] { "Speakerphone", "Wired headset", "Headset earpiece", "Bluetooth headset", "USB audio" };
    VALID_DEVICES = new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4) };
    throw new VerifyError("bad dex opcode");
  }
  
  private AudioManagerAndroid(long paramLong) {
    new AudioManagerAndroid$NonThreadSafe();
    this.mLock = new Object();
    this.mAudioDevices = new boolean[5];
    this.mNativeAudioManagerAndroid = paramLong;
    this.mAudioManager = (AudioManager)ContextUtils.sApplicationContext.getSystemService("audio");
    this.mContentResolver = ContextUtils.sApplicationContext.getContentResolver();
    this.mUsbManager = (UsbManager)ContextUtils.sApplicationContext.getSystemService("usb");
  }
  
  @CalledByNative
  private void close() {
    if (!this.mIsInitialized)
      return; 
    stopObservingVolumeChanges();
    ContextUtils.sApplicationContext.unregisterReceiver(this.mWiredHeadsetReceiver);
    this.mWiredHeadsetReceiver = null;
    if (this.mHasBluetoothPermission) {
      this.mAudioManager.stopBluetoothSco();
      ContextUtils.sApplicationContext.unregisterReceiver(this.mBluetoothHeadsetReceiver);
      this.mBluetoothHeadsetReceiver = null;
      ContextUtils.sApplicationContext.unregisterReceiver(this.mBluetoothScoReceiver);
      this.mBluetoothScoReceiver = null;
    } 
    ContextUtils.sApplicationContext.unregisterReceiver(this.mUsbAudioReceiver);
    this.mUsbAudioReceiver = null;
    this.mIsInitialized = false;
  }
  
  @CalledByNative
  private static AudioManagerAndroid createAudioManagerAndroid(long paramLong) {
    return new AudioManagerAndroid(paramLong);
  }
  
  private boolean deviceHasBeenRequested() {
    synchronized (this.mLock) {
      if (this.mRequestedAudioDevice != -1)
        return true; 
    } 
    boolean bool = false;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_2} */
    return bool;
  }
  
  @CalledByNative
  private AudioManagerAndroid$AudioDeviceName[] getAudioInputDeviceNames() {
    if (!this.mIsInitialized)
      return null; 
    boolean bool = hasPermission("android.permission.RECORD_AUDIO");
    if (!this.mHasModifyAudioSettingsPermission || !bool) {
      Log.w("cr.media", "Requires MODIFY_AUDIO_SETTINGS and RECORD_AUDIO. No audio device will be available for recording", new Object[0]);
      return null;
    } 
    synchronized (this.mLock) {
      boolean[] arrayOfBoolean = (boolean[])this.mAudioDevices.clone();
      null = new ArrayList();
      AudioManagerAndroid$AudioDeviceName[] arrayOfAudioManagerAndroid$AudioDeviceName = new AudioManagerAndroid$AudioDeviceName[getNumOfAudioDevices(arrayOfBoolean)];
      int i = 0;
      for (int j = 0; i < 5; j = k) {
        int k = j;
        if (arrayOfBoolean[i]) {
          arrayOfAudioManagerAndroid$AudioDeviceName[j] = new AudioManagerAndroid$AudioDeviceName(i, DEVICE_NAMES[i], (byte)0);
          null.add(DEVICE_NAMES[i]);
          k = j + 1;
        } 
        i++;
      } 
      return arrayOfAudioManagerAndroid$AudioDeviceName;
    } 
  }
  
  @TargetApi(17)
  @CalledByNative
  private int getAudioLowLatencyOutputFrameSize() {
    if (Build.VERSION.SDK_INT < 17)
      return 256; 
    String str = this.mAudioManager.getProperty("android.media.property.OUTPUT_FRAMES_PER_BUFFER");
    return (str == null) ? 256 : Integer.parseInt(str);
  }
  
  @CalledByNative
  private static int getMinInputFrameSize(int paramInt1, int paramInt2) {
    byte b;
    if (paramInt2 == 1) {
      b = 16;
    } else {
      if (paramInt2 == 2) {
        b = 12;
        return AudioRecord.getMinBufferSize(paramInt1, b, 2) / 2 / paramInt2;
      } 
      return -1;
    } 
    return AudioRecord.getMinBufferSize(paramInt1, b, 2) / 2 / paramInt2;
  }
  
  @CalledByNative
  private static int getMinOutputFrameSize(int paramInt1, int paramInt2) {
    byte b;
    if (paramInt2 == 1) {
      b = 4;
    } else {
      if (paramInt2 == 2) {
        b = 12;
        return AudioTrack.getMinBufferSize(paramInt1, b, 2) / 2 / paramInt2;
      } 
      return -1;
    } 
    return AudioTrack.getMinBufferSize(paramInt1, b, 2) / 2 / paramInt2;
  }
  
  @TargetApi(17)
  @CalledByNative
  private int getNativeOutputSampleRate() {
    if (Build.VERSION.SDK_INT >= 17) {
      String str = this.mAudioManager.getProperty("android.media.property.OUTPUT_SAMPLE_RATE");
      return (str == null) ? 44100 : Integer.parseInt(str);
    } 
    return 44100;
  }
  
  private static int getNumOfAudioDevices(boolean[] paramArrayOfboolean) {
    int i = 0;
    int j;
    for (j = 0; i < 5; j = k) {
      int k = j;
      if (paramArrayOfboolean[i])
        k = j + 1; 
      i++;
    } 
    return j;
  }
  
  private static boolean hasEarpiece() {
    return ContextUtils.sApplicationContext.getPackageManager().hasSystemFeature("android.hardware.telephony");
  }
  
  private static boolean hasPermission(String paramString) {
    return (ContextUtils.sApplicationContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0);
  }
  
  private boolean hasUsbAudio() {
    if (Build.VERSION.SDK_INT < 21)
      return false; 
    try {
      HashMap hashMap = this.mUsbManager.getDeviceList();
      Iterator<UsbDevice> iterator = hashMap.values().iterator();
      while (iterator.hasNext()) {
        if (hasUsbAudioCommInterface(iterator.next()))
          return true; 
      } 
      return false;
    } catch (NullPointerException nullPointerException) {
      return false;
    } 
  }
  
  private static boolean hasUsbAudioCommInterface(UsbDevice paramUsbDevice) {
    for (int i = 0; i < paramUsbDevice.getInterfaceCount(); i++) {
      UsbInterface usbInterface = paramUsbDevice.getInterface(i);
      if (usbInterface.getInterfaceClass() == 1 && usbInterface.getInterfaceSubclass() == 2)
        return true; 
    } 
    return false;
  }
  
  @CalledByNative
  private void init() {
    if (this.mIsInitialized)
      return; 
    this.mHasModifyAudioSettingsPermission = hasPermission("android.permission.MODIFY_AUDIO_SETTINGS");
    this.mAudioDevices[2] = hasEarpiece();
    this.mAudioDevices[1] = this.mAudioManager.isWiredHeadsetOn();
    this.mAudioDevices[4] = hasUsbAudio();
    boolean[] arrayOfBoolean = this.mAudioDevices;
    boolean bool = false;
    arrayOfBoolean[0] = true;
    this.mHasBluetoothPermission = hasPermission("android.permission.BLUETOOTH");
    if (!this.mHasBluetoothPermission) {
      Log.w("cr.media", "Requires BLUETOOTH permission", new Object[0]);
    } else {
      boolean[] arrayOfBoolean1 = this.mAudioDevices;
      if (!this.mHasBluetoothPermission) {
        Log.w("cr.media", "hasBluetoothHeadset() requires BLUETOOTH permission", new Object[0]);
      } else {
        BluetoothAdapter bluetoothAdapter;
        if (Build.VERSION.SDK_INT >= 18) {
          bluetoothAdapter = ((BluetoothManager)ContextUtils.sApplicationContext.getSystemService("bluetooth")).getAdapter();
        } else {
          bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        } 
        if (bluetoothAdapter != null) {
          int i = bluetoothAdapter.getProfileConnectionState(1);
          if (bluetoothAdapter.isEnabled() && i == 2)
            bool = true; 
        } 
      } 
      arrayOfBoolean1[3] = bool;
      IntentFilter intentFilter1 = new IntentFilter("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
      this.mBluetoothHeadsetReceiver = new AudioManagerAndroid$2(this);
      ContextUtils.sApplicationContext.registerReceiver(this.mBluetoothHeadsetReceiver, intentFilter1);
      intentFilter1 = new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
      this.mBluetoothScoReceiver = new AudioManagerAndroid$3(this);
      ContextUtils.sApplicationContext.registerReceiver(this.mBluetoothScoReceiver, intentFilter1);
    } 
    IntentFilter intentFilter = new IntentFilter("android.intent.action.HEADSET_PLUG");
    this.mWiredHeadsetReceiver = new AudioManagerAndroid$1(this);
    ContextUtils.sApplicationContext.registerReceiver(this.mWiredHeadsetReceiver, intentFilter);
    this.mUsbAudioReceiver = new AudioManagerAndroid$5(this);
    intentFilter = new IntentFilter();
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_ATTACHED");
    intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
    ContextUtils.sApplicationContext.registerReceiver(this.mUsbAudioReceiver, intentFilter);
    this.mIsInitialized = true;
  }
  
  @CalledByNative
  private boolean isAudioLowLatencySupported() {
    return ContextUtils.sApplicationContext.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
  }
  
  private static void logDeviceInfo() {
    StringBuilder stringBuilder = new StringBuilder("Android SDK: ");
    stringBuilder.append(Build.VERSION.SDK_INT);
    stringBuilder.append(", Release: ");
    stringBuilder.append(Build.VERSION.RELEASE);
    stringBuilder.append(", Brand: ");
    stringBuilder.append(Build.BRAND);
    stringBuilder.append(", Device: ");
    stringBuilder.append(Build.DEVICE);
    stringBuilder.append(", Id: ");
    stringBuilder.append(Build.ID);
    stringBuilder.append(", Hardware: ");
    stringBuilder.append(Build.HARDWARE);
    stringBuilder.append(", Manufacturer: ");
    stringBuilder.append(Build.MANUFACTURER);
    stringBuilder.append(", Model: ");
    stringBuilder.append(Build.MODEL);
    stringBuilder.append(", Product: ");
    stringBuilder.append(Build.PRODUCT);
  }
  
  private static void loge(String paramString) {
    Log.e("cr.media", paramString, new Object[0]);
  }
  
  private native void nativeSetMute(long paramLong, boolean paramBoolean);
  
  private static int selectDefaultDevice(boolean[] paramArrayOfboolean) {
    return paramArrayOfboolean[1] ? 1 : (paramArrayOfboolean[4] ? 4 : (paramArrayOfboolean[3] ? 3 : 0));
  }
  
  private void setAudioDevice(int paramInt) {
    if (paramInt == 3) {
      if (this.mHasBluetoothPermission && this.mBluetoothScoState != 1 && this.mBluetoothScoState != 2)
        if (this.mAudioManager.isBluetoothScoOn()) {
          this.mBluetoothScoState = 1;
        } else {
          this.mBluetoothScoState = 2;
          this.mAudioManager.startBluetoothSco();
        }  
    } else {
      stopBluetoothSco();
    } 
    switch (paramInt) {
      default:
        loge("Invalid audio device selection");
        return;
      case 4:
        setSpeakerphoneOn(false);
        return;
      case 3:
        return;
      case 2:
        setSpeakerphoneOn(false);
        return;
      case 1:
        setSpeakerphoneOn(false);
        return;
      case 0:
        break;
    } 
    setSpeakerphoneOn(true);
  }
  
  @CalledByNative
  private void setCommunicationAudioModeOn(boolean paramBoolean) {
    if (!this.mIsInitialized)
      return; 
    if (!this.mHasModifyAudioSettingsPermission) {
      Log.w("cr.media", "MODIFY_AUDIO_SETTINGS is missing => client will run with reduced functionality", new Object[0]);
      return;
    } 
    if (paramBoolean) {
      this.mSavedIsSpeakerphoneOn = this.mAudioManager.isSpeakerphoneOn();
      this.mSavedIsMicrophoneMute = this.mAudioManager.isMicrophoneMute();
      if (this.mSettingsObserverThread == null) {
        this.mSettingsObserverThread = new HandlerThread("SettingsObserver");
        this.mSettingsObserverThread.start();
        this.mSettingsObserver = new AudioManagerAndroid$4(this, new Handler(this.mSettingsObserverThread.getLooper()));
        this.mContentResolver.registerContentObserver(Settings.System.CONTENT_URI, true, this.mSettingsObserver);
      } 
    } else {
      stopObservingVolumeChanges();
      stopBluetoothSco();
      synchronized (this.mLock) {
        this.mRequestedAudioDevice = -1;
        boolean bool = this.mSavedIsMicrophoneMute;
        if (this.mAudioManager.isMicrophoneMute() != bool)
          this.mAudioManager.setMicrophoneMute(bool); 
        setSpeakerphoneOn(this.mSavedIsSpeakerphoneOn);
        if (paramBoolean)
          try {
            this.mAudioManager.setMode(3);
            return;
          } catch (SecurityException securityException) {
            logDeviceInfo();
            throw securityException;
          }  
        try {
          this.mAudioManager.setMode(0);
          return;
        } catch (SecurityException null) {
          logDeviceInfo();
          throw null;
        } 
      } 
    } 
    if (paramBoolean)
      try {
        this.mAudioManager.setMode(3);
        return;
      } catch (SecurityException securityException) {
        logDeviceInfo();
        throw securityException;
      }  
    try {
      this.mAudioManager.setMode(0);
      return;
    } catch (SecurityException securityException) {
      logDeviceInfo();
      throw securityException;
    } 
  }
  
  @CalledByNative
  private boolean setDevice(String paramString) {
    int i;
    if (!this.mIsInitialized)
      return false; 
    boolean bool = hasPermission("android.permission.RECORD_AUDIO");
    if (!this.mHasModifyAudioSettingsPermission || !bool) {
      Log.w("cr.media", "Requires MODIFY_AUDIO_SETTINGS and RECORD_AUDIO. Selected device will not be available for recording", new Object[0]);
      return false;
    } 
    if (paramString.isEmpty()) {
      i = -2;
    } else {
      i = Integer.parseInt(paramString);
    } 
    if (i == -2)
      synchronized (this.mLock) {
        boolean[] arrayOfBoolean = (boolean[])this.mAudioDevices.clone();
        this.mRequestedAudioDevice = -2;
        setAudioDevice(selectDefaultDevice(arrayOfBoolean));
        return true;
      }  
    if (Arrays.<Integer>asList(VALID_DEVICES).contains(Integer.valueOf(i))) {
      if (!this.mAudioDevices[i])
        return false; 
      synchronized (this.mLock) {
        this.mRequestedAudioDevice = i;
        setAudioDevice(i);
        return true;
      } 
    } 
    return false;
  }
  
  private void setSpeakerphoneOn(boolean paramBoolean) {
    if (this.mAudioManager.isSpeakerphoneOn() == paramBoolean)
      return; 
    this.mAudioManager.setSpeakerphoneOn(paramBoolean);
  }
  
  @CalledByNative
  private static boolean shouldUseAcousticEchoCanceler() {
    return !Arrays.<String>asList(SUPPORTED_AEC_MODELS).contains(Build.MODEL) ? false : AcousticEchoCanceler.isAvailable();
  }
  
  private void stopBluetoothSco() {
    if (!this.mHasBluetoothPermission)
      return; 
    if (this.mBluetoothScoState != 1 && this.mBluetoothScoState != 2)
      return; 
    if (!this.mAudioManager.isBluetoothScoOn()) {
      loge("Unable to stop BT SCO since it is already disabled");
      this.mBluetoothScoState = 0;
      return;
    } 
    this.mBluetoothScoState = 3;
    this.mAudioManager.stopBluetoothSco();
  }
  
  private void stopObservingVolumeChanges() {
    if (this.mSettingsObserverThread == null)
      return; 
    this.mContentResolver.unregisterContentObserver(this.mSettingsObserver);
    this.mSettingsObserver = null;
    this.mSettingsObserverThread.quit();
    try {
      this.mSettingsObserverThread.join();
    } catch (InterruptedException interruptedException) {
      Log.e("cr.media", "Thread.join() exception: ", new Object[] { interruptedException });
    } 
    this.mSettingsObserverThread = null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\AudioManagerAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */