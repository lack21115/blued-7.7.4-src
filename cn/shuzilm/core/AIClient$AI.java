package cn.shuzilm.core;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

final class AIClient$AI implements IInterface {
  private IBinder b;
  
  private String c;
  
  private int d;
  
  public AIClient$AI(AIClient paramAIClient, IBinder paramIBinder, String paramString, int paramInt) {
    this.b = paramIBinder;
    this.c = paramString;
    this.d = paramInt;
  }
  
  public IBinder asBinder() {
    return this.b;
  }
  
  public String getId() {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    String str = null;
    try {
    
    } finally {
      Exception exception = null;
      parcel2.recycle();
    } 
    parcel2.recycle();
    parcel1.recycle();
    return str;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\AIClient$AI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */