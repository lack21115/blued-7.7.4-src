package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

public class ResultReceiver implements Parcelable {
  public static final Parcelable.Creator CREATOR = new ResultReceiver$1();
  
  final Handler mHandler = null;
  
  private IResultReceiver mReceiver;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  ResultReceiver(Parcel paramParcel) {
    this.mReceiver = IResultReceiver$Stub.asInterface(paramParcel.readStrongBinder());
  }
  
  public int describeContents() {
    return 0;
  }
  
  public void onReceiveResult(int paramInt, Bundle paramBundle) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mReceiver : Landroid/support/v4/os/IResultReceiver;
    //   6: ifnonnull -> 21
    //   9: aload_0
    //   10: new android/support/v4/os/ResultReceiver$MyResultReceiver
    //   13: dup
    //   14: aload_0
    //   15: invokespecial <init> : (Landroid/support/v4/os/ResultReceiver;)V
    //   18: putfield mReceiver : Landroid/support/v4/os/IResultReceiver;
    //   21: aload_1
    //   22: aload_0
    //   23: getfield mReceiver : Landroid/support/v4/os/IResultReceiver;
    //   26: invokeinterface asBinder : ()Landroid/os/IBinder;
    //   31: invokevirtual writeStrongBinder : (Landroid/os/IBinder;)V
    //   34: aload_0
    //   35: monitorexit
    //   36: return
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	21	37	finally
    //   21	36	37	finally
    //   38	40	37	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\os\ResultReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */