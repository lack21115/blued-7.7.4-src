package org.chromium.device.bluetooth;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class Wrappers$ForwardScanCallbackToWrapper extends ScanCallback {
  private Wrappers$ScanCallbackWrapper mWrapperCallback;
  
  Wrappers$ForwardScanCallbackToWrapper(Wrappers$ScanCallbackWrapper paramWrappers$ScanCallbackWrapper) {
    this.mWrapperCallback = paramWrappers$ScanCallbackWrapper;
  }
  
  public final void onBatchScanResults(List paramList) {
    ArrayList<Wrappers$ScanResultWrapper> arrayList = new ArrayList(paramList.size());
    Iterator<ScanResult> iterator = paramList.iterator();
    while (iterator.hasNext())
      arrayList.add(new Wrappers$ScanResultWrapper(iterator.next())); 
  }
  
  public final void onScanFailed(int paramInt) {
    this.mWrapperCallback.onScanFailed(paramInt);
  }
  
  public final void onScanResult(int paramInt, ScanResult paramScanResult) {
    this.mWrapperCallback.onScanResult(paramInt, new Wrappers$ScanResultWrapper(paramScanResult));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\bluetooth\Wrappers$ForwardScanCallbackToWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */