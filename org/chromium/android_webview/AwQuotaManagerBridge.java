package org.chromium.android_webview;

import android.util.SparseArray;
import org.chromium.base.Callback;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;

public class AwQuotaManagerBridge {
  private static AwQuotaManagerBridge sInstance;
  
  private long mNativeAwQuotaManagerBridge;
  
  private int mNextId;
  
  private SparseArray mPendingGetOriginCallbacks;
  
  private SparseArray mPendingGetQuotaForOriginCallbacks;
  
  private SparseArray mPendingGetUsageForOriginCallbacks;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private AwQuotaManagerBridge(long paramLong) {
    this.mNativeAwQuotaManagerBridge = paramLong;
    this.mPendingGetOriginCallbacks = new SparseArray();
    this.mPendingGetQuotaForOriginCallbacks = new SparseArray();
    this.mPendingGetUsageForOriginCallbacks = new SparseArray();
    nativeInit(this.mNativeAwQuotaManagerBridge);
  }
  
  public static AwQuotaManagerBridge getInstance() {
    ThreadUtils.assertOnUiThread();
    if (sInstance == null)
      sInstance = new AwQuotaManagerBridge(nativeGetDefaultNativeAwQuotaManagerBridge()); 
    return sInstance;
  }
  
  private int getNextId() {
    ThreadUtils.assertOnUiThread();
    int i = this.mNextId + 1;
    this.mNextId = i;
    return i;
  }
  
  private native void nativeDeleteAllData(long paramLong);
  
  private native void nativeDeleteOrigin(long paramLong, String paramString);
  
  private static native long nativeGetDefaultNativeAwQuotaManagerBridge();
  
  private native void nativeGetOrigins(long paramLong, int paramInt);
  
  private native void nativeGetUsageAndQuotaForOrigin(long paramLong, String paramString, int paramInt, boolean paramBoolean);
  
  private native void nativeInit(long paramLong);
  
  @CalledByNative
  private void onGetOriginsCallback(int paramInt, String[] paramArrayOfString, long[] paramArrayOflong1, long[] paramArrayOflong2) {
    assert false;
    throw new AssertionError();
  }
  
  @CalledByNative
  private void onGetUsageAndQuotaForOriginCallback(int paramInt, boolean paramBoolean, long paramLong1, long paramLong2) {
    if (paramBoolean) {
      assert false;
      throw new AssertionError();
    } 
    assert false;
    throw new AssertionError();
  }
  
  public final void deleteAllData() {
    nativeDeleteAllData(this.mNativeAwQuotaManagerBridge);
  }
  
  public final void deleteOrigin(String paramString) {
    nativeDeleteOrigin(this.mNativeAwQuotaManagerBridge, paramString);
  }
  
  public final void getOrigins(Callback paramCallback) {
    int i = getNextId();
    assert false;
    throw new AssertionError();
  }
  
  public final void getQuotaForOrigin(String paramString, Callback paramCallback) {
    int i = getNextId();
    assert false;
    throw new AssertionError();
  }
  
  public final void getUsageForOrigin(String paramString, Callback paramCallback) {
    int i = getNextId();
    assert false;
    throw new AssertionError();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwQuotaManagerBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */