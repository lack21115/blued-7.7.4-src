package com.google.android.gms.vision.barcode;

import com.google.android.gms.internal.zzdkx;
import com.google.android.gms.vision.Detector;

public final class BarcodeDetector extends Detector {
  public final zzdkx zzlgo;
  
  private BarcodeDetector() {
    throw new IllegalStateException("Default constructor called");
  }
  
  private BarcodeDetector(zzdkx paramzzdkx) {
    this.zzlgo = paramzzdkx;
  }
  
  public final void release() {
    super.release();
    this.zzlgo.zzbln();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\barcode\BarcodeDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */