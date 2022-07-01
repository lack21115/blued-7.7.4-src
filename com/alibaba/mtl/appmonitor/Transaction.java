package com.alibaba.mtl.appmonitor;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.mtl.appmonitor.c.a;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import java.util.UUID;

public class Transaction implements Parcelable {
  public static final Parcelable.Creator<Transaction> CREATOR = new Parcelable.Creator<Transaction>() {
      public Transaction[] a(int param1Int) {
        return new Transaction[param1Int];
      }
      
      public Transaction b(Parcel param1Parcel) {
        return Transaction.a(param1Parcel);
      }
    };
  
  protected Integer a;
  
  protected DimensionValueSet b;
  
  private Object lock;
  
  protected String o;
  
  protected String p;
  
  protected String r;
  
  public Transaction() {}
  
  Transaction(Integer paramInteger, String paramString1, String paramString2, DimensionValueSet paramDimensionValueSet) {
    this.a = paramInteger;
    this.o = paramString1;
    this.p = paramString2;
    this.r = UUID.randomUUID().toString();
    this.b = paramDimensionValueSet;
    this.lock = new Object();
  }
  
  static Transaction a(Parcel paramParcel) {
    Transaction transaction = new Transaction();
    try {
      transaction.b = (DimensionValueSet)paramParcel.readParcelable(Transaction.class.getClassLoader());
      transaction.a = Integer.valueOf(paramParcel.readInt());
      transaction.o = paramParcel.readString();
      return transaction;
    } finally {
      paramParcel = null;
      paramParcel.printStackTrace();
    } 
  }
  
  public void addDimensionValues(DimensionValueSet paramDimensionValueSet) {
    synchronized (this.lock) {
      if (this.b == null) {
        this.b = paramDimensionValueSet;
      } else {
        this.b.addValues(paramDimensionValueSet);
      } 
      return;
    } 
  }
  
  public void addDimensionValues(String paramString1, String paramString2) {
    synchronized (this.lock) {
      if (this.b == null)
        this.b = (DimensionValueSet)a.a().a(DimensionValueSet.class, new Object[0]); 
      this.b.setValue(paramString1, paramString2);
      return;
    } 
  }
  
  public void begin(String paramString) {
    // Byte code:
    //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
    //   3: ifnonnull -> 7
    //   6: return
    //   7: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
    //   10: aload_0
    //   11: aload_1
    //   12: invokeinterface transaction_begin : (Lcom/alibaba/mtl/appmonitor/Transaction;Ljava/lang/String;)V
    //   17: return
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual printStackTrace : ()V
    //   23: return
    // Exception table:
    //   from	to	target	type
    //   7	17	18	android/os/RemoteException
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void end(String paramString) {
    // Byte code:
    //   0: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
    //   3: ifnonnull -> 7
    //   6: return
    //   7: getstatic com/alibaba/mtl/appmonitor/AppMonitor.a : Lcom/alibaba/mtl/appmonitor/IMonitor;
    //   10: aload_0
    //   11: aload_1
    //   12: invokeinterface transaction_end : (Lcom/alibaba/mtl/appmonitor/Transaction;Ljava/lang/String;)V
    //   17: return
    //   18: astore_1
    //   19: aload_1
    //   20: invokevirtual printStackTrace : ()V
    //   23: return
    // Exception table:
    //   from	to	target	type
    //   7	17	18	android/os/RemoteException
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeParcelable((Parcelable)this.b, paramInt);
    paramParcel.writeInt(this.a.intValue());
    paramParcel.writeString(this.o);
    paramParcel.writeString(this.p);
    paramParcel.writeString(this.r);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\Transaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */