package com.github.mikephil.charting.utils;

import android.os.Parcel;
import android.os.Parcelable;

public class MPPointF extends ObjectPool.Poolable {
  public static final Parcelable.Creator<MPPointF> c;
  
  private static ObjectPool<MPPointF> d = ObjectPool.a(32, new MPPointF(0.0F, 0.0F));
  
  public float a;
  
  public float b;
  
  static {
    d.a(0.5F);
    c = new Parcelable.Creator<MPPointF>() {
        public MPPointF a(Parcel param1Parcel) {
          MPPointF mPPointF = new MPPointF(0.0F, 0.0F);
          mPPointF.a(param1Parcel);
          return mPPointF;
        }
        
        public MPPointF[] a(int param1Int) {
          return new MPPointF[param1Int];
        }
      };
  }
  
  public MPPointF() {}
  
  public MPPointF(float paramFloat1, float paramFloat2) {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public static MPPointF a() {
    return d.a();
  }
  
  public static MPPointF a(float paramFloat1, float paramFloat2) {
    MPPointF mPPointF = d.a();
    mPPointF.a = paramFloat1;
    mPPointF.b = paramFloat2;
    return mPPointF;
  }
  
  public static MPPointF a(MPPointF paramMPPointF) {
    MPPointF mPPointF = d.a();
    mPPointF.a = paramMPPointF.a;
    mPPointF.b = paramMPPointF.b;
    return mPPointF;
  }
  
  public static void b(MPPointF paramMPPointF) {
    d.a(paramMPPointF);
  }
  
  public void a(Parcel paramParcel) {
    this.a = paramParcel.readFloat();
    this.b = paramParcel.readFloat();
  }
  
  protected ObjectPool.Poolable b() {
    return new MPPointF(0.0F, 0.0F);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\github\mikephil\chartin\\utils\MPPointF.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */