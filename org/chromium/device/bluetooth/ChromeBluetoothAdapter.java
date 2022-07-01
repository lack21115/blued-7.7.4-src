package org.chromium.device.bluetooth;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

@TargetApi(23)
final class ChromeBluetoothAdapter extends BroadcastReceiver {
  private final Wrappers$BluetoothAdapterWrapper mAdapter;
  
  private long mNativeBluetoothAdapterAndroid;
  
  private ChromeBluetoothAdapter$ScanCallback mScanCallback;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private ChromeBluetoothAdapter(long paramLong, Wrappers$BluetoothAdapterWrapper paramWrappers$BluetoothAdapterWrapper) {
    this.mNativeBluetoothAdapterAndroid = paramLong;
    this.mAdapter = paramWrappers$BluetoothAdapterWrapper;
    if (this.mAdapter != null)
      this.mAdapter.mContext.registerReceiver(this, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED")); 
    if (paramWrappers$BluetoothAdapterWrapper == null) {
      Log.i("Bluetooth", "ChromeBluetoothAdapter created with no adapterWrapper.", new Object[0]);
      return;
    } 
    Log.i("Bluetooth", "ChromeBluetoothAdapter created with provided adapterWrapper.", new Object[0]);
  }
  
  @CalledByNative
  private static ChromeBluetoothAdapter create(long paramLong, Wrappers$BluetoothAdapterWrapper paramWrappers$BluetoothAdapterWrapper) {
    return new ChromeBluetoothAdapter(paramLong, paramWrappers$BluetoothAdapterWrapper);
  }
  
  @CalledByNative
  private String getAddress() {
    return isPresent() ? this.mAdapter.mAdapter.getAddress() : "";
  }
  
  @CalledByNative
  private String getName() {
    return isPresent() ? this.mAdapter.mAdapter.getName() : "";
  }
  
  @CalledByNative
  private boolean isDiscoverable() {
    return (isPresent() && this.mAdapter.mAdapter.getScanMode() == 23);
  }
  
  @CalledByNative
  private boolean isDiscovering() {
    return (isPresent() && (this.mAdapter.mAdapter.isDiscovering() || this.mScanCallback != null));
  }
  
  @CalledByNative
  private boolean isPowered() {
    return (isPresent() && this.mAdapter.mAdapter.isEnabled());
  }
  
  @CalledByNative
  private boolean isPresent() {
    return (this.mAdapter != null);
  }
  
  private native void nativeCreateOrUpdateDeviceOnScan(long paramLong, String paramString, Wrappers$BluetoothDeviceWrapper paramWrappers$BluetoothDeviceWrapper, int paramInt1, String[] paramArrayOfString1, int paramInt2, String[] paramArrayOfString2, Object[] paramArrayOfObject1, int[] paramArrayOfint, Object[] paramArrayOfObject2);
  
  private native void nativeOnAdapterStateChanged(long paramLong, boolean paramBoolean);
  
  private native void nativeOnScanFailed(long paramLong);
  
  @CalledByNative
  private void onBluetoothAdapterAndroidDestruction() {
    stopScan();
    this.mNativeBluetoothAdapterAndroid = 0L;
    if (this.mAdapter != null)
      this.mAdapter.mContext.unregisterReceiver(this); 
  }
  
  @CalledByNative
  private boolean setPowered(boolean paramBoolean) {
    return paramBoolean ? ((isPresent() && this.mAdapter.mAdapter.enable())) : ((isPresent() && this.mAdapter.mAdapter.disable()));
  }
  
  @CalledByNative
  private boolean startScan() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mAdapter : Lorg/chromium/device/bluetooth/Wrappers$BluetoothAdapterWrapper;
    //   4: invokevirtual getBluetoothLeScanner : ()Lorg/chromium/device/bluetooth/Wrappers$BluetoothLeScannerWrapper;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnonnull -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: invokestatic getInstance : ()Lorg/chromium/components/location/LocationUtils;
    //   17: pop
    //   18: ldc 'android.permission.ACCESS_COARSE_LOCATION'
    //   20: invokestatic hasPermission : (Ljava/lang/String;)Z
    //   23: ifne -> 42
    //   26: ldc 'android.permission.ACCESS_FINE_LOCATION'
    //   28: invokestatic hasPermission : (Ljava/lang/String;)Z
    //   31: ifeq -> 37
    //   34: goto -> 42
    //   37: iconst_0
    //   38: istore_1
    //   39: goto -> 44
    //   42: iconst_1
    //   43: istore_1
    //   44: iload_1
    //   45: ifeq -> 113
    //   48: getstatic org/chromium/base/ContextUtils.sApplicationContext : Landroid/content/Context;
    //   51: astore_3
    //   52: getstatic android/os/Build$VERSION.SDK_INT : I
    //   55: bipush #19
    //   57: if_icmplt -> 83
    //   60: aload_3
    //   61: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   64: ldc 'location_mode'
    //   66: iconst_0
    //   67: invokestatic getInt : (Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   70: ifeq -> 78
    //   73: iconst_1
    //   74: istore_1
    //   75: goto -> 104
    //   78: iconst_0
    //   79: istore_1
    //   80: goto -> 104
    //   83: aload_3
    //   84: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   87: ldc 'location_providers_allowed'
    //   89: invokestatic getString : (Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   92: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   95: ifne -> 101
    //   98: goto -> 73
    //   101: goto -> 78
    //   104: iload_1
    //   105: ifeq -> 113
    //   108: iconst_1
    //   109: istore_1
    //   110: goto -> 115
    //   113: iconst_0
    //   114: istore_1
    //   115: iload_1
    //   116: ifne -> 121
    //   119: iconst_0
    //   120: ireturn
    //   121: getstatic org/chromium/device/bluetooth/ChromeBluetoothAdapter.$assertionsDisabled : Z
    //   124: ifne -> 145
    //   127: aload_0
    //   128: getfield mScanCallback : Lorg/chromium/device/bluetooth/ChromeBluetoothAdapter$ScanCallback;
    //   131: ifnonnull -> 137
    //   134: goto -> 145
    //   137: new java/lang/AssertionError
    //   140: dup
    //   141: invokespecial <init> : ()V
    //   144: athrow
    //   145: aload_0
    //   146: new org/chromium/device/bluetooth/ChromeBluetoothAdapter$ScanCallback
    //   149: dup
    //   150: aload_0
    //   151: iconst_0
    //   152: invokespecial <init> : (Lorg/chromium/device/bluetooth/ChromeBluetoothAdapter;B)V
    //   155: putfield mScanCallback : Lorg/chromium/device/bluetooth/ChromeBluetoothAdapter$ScanCallback;
    //   158: aload_0
    //   159: getfield mScanCallback : Lorg/chromium/device/bluetooth/ChromeBluetoothAdapter$ScanCallback;
    //   162: astore_3
    //   163: new android/bluetooth/le/ScanSettings$Builder
    //   166: dup
    //   167: invokespecial <init> : ()V
    //   170: iconst_2
    //   171: invokevirtual setScanMode : (I)Landroid/bluetooth/le/ScanSettings$Builder;
    //   174: invokevirtual build : ()Landroid/bluetooth/le/ScanSettings;
    //   177: astore #4
    //   179: new org/chromium/device/bluetooth/Wrappers$ForwardScanCallbackToWrapper
    //   182: dup
    //   183: aload_3
    //   184: invokespecial <init> : (Lorg/chromium/device/bluetooth/Wrappers$ScanCallbackWrapper;)V
    //   187: astore #5
    //   189: aload_2
    //   190: getfield mCallbacks : Ljava/util/HashMap;
    //   193: aload_3
    //   194: aload #5
    //   196: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   199: pop
    //   200: aload_2
    //   201: getfield mScanner : Landroid/bluetooth/le/BluetoothLeScanner;
    //   204: aconst_null
    //   205: aload #4
    //   207: aload #5
    //   209: invokevirtual startScan : (Ljava/util/List;Landroid/bluetooth/le/ScanSettings;Landroid/bluetooth/le/ScanCallback;)V
    //   212: iconst_1
    //   213: ireturn
    //   214: astore_2
    //   215: new java/lang/StringBuilder
    //   218: dup
    //   219: ldc 'Adapter is off. Cannot start scan: '
    //   221: invokespecial <init> : (Ljava/lang/String;)V
    //   224: astore_3
    //   225: aload_3
    //   226: aload_2
    //   227: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: ldc 'Bluetooth'
    //   233: aload_3
    //   234: invokevirtual toString : ()Ljava/lang/String;
    //   237: iconst_0
    //   238: anewarray java/lang/Object
    //   241: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload_0
    //   245: aconst_null
    //   246: putfield mScanCallback : Lorg/chromium/device/bluetooth/ChromeBluetoothAdapter$ScanCallback;
    //   249: iconst_0
    //   250: ireturn
    //   251: astore_2
    //   252: new java/lang/StringBuilder
    //   255: dup
    //   256: ldc_w 'Cannot start scan: '
    //   259: invokespecial <init> : (Ljava/lang/String;)V
    //   262: astore_3
    //   263: aload_3
    //   264: aload_2
    //   265: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: ldc 'Bluetooth'
    //   271: aload_3
    //   272: invokevirtual toString : ()Ljava/lang/String;
    //   275: iconst_0
    //   276: anewarray java/lang/Object
    //   279: invokestatic e : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   282: aload_0
    //   283: aconst_null
    //   284: putfield mScanCallback : Lorg/chromium/device/bluetooth/ChromeBluetoothAdapter$ScanCallback;
    //   287: iconst_0
    //   288: ireturn
    // Exception table:
    //   from	to	target	type
    //   158	212	251	java/lang/IllegalArgumentException
    //   158	212	214	java/lang/IllegalStateException
  }
  
  @CalledByNative
  private boolean stopScan() {
    if (this.mScanCallback == null)
      return false; 
    try {
      Wrappers$BluetoothLeScannerWrapper wrappers$BluetoothLeScannerWrapper = this.mAdapter.getBluetoothLeScanner();
      if (wrappers$BluetoothLeScannerWrapper != null) {
        ChromeBluetoothAdapter$ScanCallback chromeBluetoothAdapter$ScanCallback = this.mScanCallback;
        Wrappers$ForwardScanCallbackToWrapper wrappers$ForwardScanCallbackToWrapper = (Wrappers$ForwardScanCallbackToWrapper)wrappers$BluetoothLeScannerWrapper.mCallbacks.remove(chromeBluetoothAdapter$ScanCallback);
        wrappers$BluetoothLeScannerWrapper.mScanner.stopScan(wrappers$ForwardScanCallbackToWrapper);
      } 
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder("Cannot stop scan: ");
      stringBuilder.append(illegalArgumentException);
      Log.e("Bluetooth", stringBuilder.toString(), new Object[0]);
    } catch (IllegalStateException illegalStateException) {
      StringBuilder stringBuilder = new StringBuilder("Adapter is off. Cannot stop scan: ");
      stringBuilder.append(illegalStateException);
      Log.e("Bluetooth", stringBuilder.toString(), new Object[0]);
    } 
    this.mScanCallback = null;
    return true;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent) {
    String str = paramIntent.getAction();
    if (isPresent() && "android.bluetooth.adapter.action.STATE_CHANGED".equals(str)) {
      int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -2147483648);
      switch (i) {
        default:
          assert false;
          throw new AssertionError();
        case 13:
          str = "STATE_TURNING_OFF";
          break;
        case 12:
          str = "STATE_ON";
          break;
        case 11:
          str = "STATE_TURNING_ON";
          break;
        case 10:
          str = "STATE_OFF";
          break;
      } 
      Log.w("Bluetooth", "onReceive: BluetoothAdapter.ACTION_STATE_CHANGED: %s", new Object[] { str });
      if (i != 10) {
        if (i != 12)
          return; 
        nativeOnAdapterStateChanged(this.mNativeBluetoothAdapterAndroid, true);
        return;
      } 
      nativeOnAdapterStateChanged(this.mNativeBluetoothAdapterAndroid, false);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\ChromeBluetoothAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */