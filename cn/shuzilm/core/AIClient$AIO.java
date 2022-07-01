package cn.shuzilm.core;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

final class AIClient$AIO implements IInterface {
  private IBinder b;
  
  private String c;
  
  public AIClient$AIO(AIClient paramAIClient, IBinder paramIBinder, String paramString) {
    this.b = paramIBinder;
    this.c = paramString;
  }
  
  public IBinder asBinder() {
    return this.b;
  }
  
  public String getId(String paramString1, String paramString2, String paramString3) {
    Parcel parcel1 = Parcel.obtain();
    Parcel parcel2 = Parcel.obtain();
    String str = null;
    try {
      if (this.c == null)
        return null; 
      parcel1.writeInterfaceToken(this.c);
      parcel1.writeString(paramString1);
      parcel1.writeString(paramString2);
      parcel1.writeString(paramString3);
    } finally {
      paramString1 = null;
      parcel2.recycle();
      parcel1.recycle();
    } 
    parcel2.recycle();
    parcel1.recycle();
    return paramString1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\AIClient$AIO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */