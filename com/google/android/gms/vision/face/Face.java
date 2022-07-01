package com.google.android.gms.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

public final class Face {
  int mId;
  
  public PointF zzlgr;
  
  public float zzlgs;
  
  public float zzlgt;
  
  public float zzlgv;
  
  public List zzlgw;
  
  public Face(int paramInt, PointF paramPointF, float paramFloat1, float paramFloat2, float paramFloat3, Landmark[] paramArrayOfLandmark, float paramFloat4) {
    this.mId = paramInt;
    this.zzlgr = paramPointF;
    this.zzlgs = paramFloat1;
    this.zzlgt = paramFloat2;
    this.zzlgv = paramFloat3;
    this.zzlgw = Arrays.asList(paramArrayOfLandmark);
    if (paramFloat4 < 0.0F || paramFloat4 <= 1.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\face\Face.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */