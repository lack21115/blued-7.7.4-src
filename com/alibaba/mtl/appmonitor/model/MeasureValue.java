package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.c.b;

public class MeasureValue implements Parcelable, b {
  public static final Parcelable.Creator<MeasureValue> CREATOR = new Parcelable.Creator<MeasureValue>() {
      public MeasureValue[] a(int param1Int) {
        return new MeasureValue[param1Int];
      }
      
      public MeasureValue b(Parcel param1Parcel) {
        return MeasureValue.a(param1Parcel);
      }
    };
  
  private Double d;
  
  private double e;
  
  private boolean n;
  
  @Deprecated
  public MeasureValue() {}
  
  @Deprecated
  public MeasureValue(double paramDouble) {
    this.e = paramDouble;
  }
  
  @Deprecated
  public MeasureValue(double paramDouble1, double paramDouble2) {
    this.d = Double.valueOf(paramDouble2);
    this.e = paramDouble1;
    this.n = false;
  }
  
  static MeasureValue a(Parcel paramParcel) {
    MeasureValue measureValue1;
    MeasureValue measureValue2 = null;
  }
  
  public static MeasureValue create() {
    return (MeasureValue)a.a().a(MeasureValue.class, new Object[0]);
  }
  
  public static MeasureValue create(double paramDouble) {
    return (MeasureValue)a.a().a(MeasureValue.class, new Object[] { Double.valueOf(paramDouble) });
  }
  
  public static MeasureValue create(double paramDouble1, double paramDouble2) {
    return (MeasureValue)a.a().a(MeasureValue.class, new Object[] { Double.valueOf(paramDouble1), Double.valueOf(paramDouble2) });
  }
  
  public void clean() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: dconst_0
    //   4: putfield e : D
    //   7: aload_0
    //   8: aconst_null
    //   9: putfield d : Ljava/lang/Double;
    //   12: aload_0
    //   13: iconst_0
    //   14: putfield n : Z
    //   17: aload_0
    //   18: monitorexit
    //   19: return
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: athrow
    // Exception table:
    //   from	to	target	type
    //   2	17	20	finally
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void fill(Object... paramVarArgs) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnonnull -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_1
    //   10: arraylength
    //   11: ifle -> 27
    //   14: aload_0
    //   15: aload_1
    //   16: iconst_0
    //   17: aaload
    //   18: checkcast java/lang/Double
    //   21: invokevirtual doubleValue : ()D
    //   24: putfield e : D
    //   27: aload_1
    //   28: arraylength
    //   29: iconst_1
    //   30: if_icmple -> 48
    //   33: aload_0
    //   34: aload_1
    //   35: iconst_1
    //   36: aaload
    //   37: checkcast java/lang/Double
    //   40: putfield d : Ljava/lang/Double;
    //   43: aload_0
    //   44: iconst_0
    //   45: putfield n : Z
    //   48: aload_0
    //   49: monitorexit
    //   50: return
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Exception table:
    //   from	to	target	type
    //   9	27	51	finally
    //   27	48	51	finally
  }
  
  public Double getOffset() {
    return this.d;
  }
  
  public double getValue() {
    return this.e;
  }
  
  public boolean isFinish() {
    return this.n;
  }
  
  public void merge(MeasureValue paramMeasureValue) {
    /* monitor enter ThisExpression{ObjectType{com/alibaba/mtl/appmonitor/model/MeasureValue}} */
    if (paramMeasureValue == null) {
      /* monitor exit ThisExpression{ObjectType{com/alibaba/mtl/appmonitor/model/MeasureValue}} */
      return;
    } 
    try {
      this.e += paramMeasureValue.getValue();
      if (paramMeasureValue.getOffset() != null) {
        if (this.d == null)
          this.d = Double.valueOf(0.0D); 
        this.d = Double.valueOf(this.d.doubleValue() + paramMeasureValue.getOffset().doubleValue());
      } 
    } finally {}
    /* monitor exit ThisExpression{ObjectType{com/alibaba/mtl/appmonitor/model/MeasureValue}} */
  }
  
  public void setFinish(boolean paramBoolean) {
    this.n = paramBoolean;
  }
  
  public void setOffset(double paramDouble) {
    this.d = Double.valueOf(paramDouble);
  }
  
  public void setValue(double paramDouble) {
    this.e = paramDouble;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    try {
      double d;
      if (this.n) {
        paramInt = 1;
      } else {
        paramInt = 0;
      } 
      paramParcel.writeInt(paramInt);
      if (this.d == null) {
        d = 0.0D;
      } else {
        d = this.d.doubleValue();
      } 
      paramParcel.writeDouble(d);
      return;
    } finally {
      paramParcel = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\model\MeasureValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */