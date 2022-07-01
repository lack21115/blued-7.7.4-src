package com.google.android.gms.vision.face;

import android.util.SparseArray;
import com.google.android.gms.internal.zzdld;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.zza;
import com.google.android.gms.vision.zzc;
import java.nio.ByteBuffer;
import java.util.HashSet;

public final class FaceDetector extends Detector {
  private boolean mIsActive = true;
  
  private final Object mLock = new Object();
  
  private final zzc zzlha = new zzc();
  
  public final zza zzlhb;
  
  private FaceDetector() {
    throw new IllegalStateException("Default constructor called");
  }
  
  private FaceDetector(zza paramzza) {
    this.zzlhb = paramzza;
  }
  
  public final SparseArray detect(Frame paramFrame) {
    if (paramFrame != null) {
      ByteBuffer byteBuffer = paramFrame.getGrayscaleImageData();
      synchronized (this.mLock) {
        if (this.mIsActive) {
          Face[] arrayOfFace = this.zzlhb.zzb(byteBuffer, zzdld.zzc(paramFrame));
          null = new HashSet();
          SparseArray sparseArray = new SparseArray(arrayOfFace.length);
          int k = arrayOfFace.length;
          int j = 0;
          int i = 0;
          while (j < k) {
            Face face = arrayOfFace[j];
            int n = face.mId;
            int i1 = Math.max(i, n);
            i = i1;
            int m = n;
            if (null.contains(Integer.valueOf(n))) {
              m = i1 + 1;
              i = m;
            } 
            null.add(Integer.valueOf(m));
            sparseArray.append(this.zzlha.zzfm(m), face);
            j++;
          } 
          return sparseArray;
        } 
        throw new RuntimeException("Cannot use detector after release()");
      } 
    } 
    throw new IllegalArgumentException("No frame supplied.");
  }
  
  protected final void finalize() {
    try {
    
    } finally {
      super.finalize();
    } 
  }
  
  public final void release() {
    super.release();
    synchronized (this.mLock) {
      if (!this.mIsActive)
        return; 
      this.zzlhb.zzbln();
      this.mIsActive = false;
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\face\FaceDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */