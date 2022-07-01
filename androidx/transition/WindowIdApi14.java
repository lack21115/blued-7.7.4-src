package androidx.transition;

import android.os.IBinder;

class WindowIdApi14 implements WindowIdImpl {
  private final IBinder a;
  
  WindowIdApi14(IBinder paramIBinder) {
    this.a = paramIBinder;
  }
  
  public boolean equals(Object paramObject) {
    return (paramObject instanceof WindowIdApi14 && ((WindowIdApi14)paramObject).a.equals(this.a));
  }
  
  public int hashCode() {
    return this.a.hashCode();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\WindowIdApi14.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */