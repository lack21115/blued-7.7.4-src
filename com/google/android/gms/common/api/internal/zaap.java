package com.google.android.gms.common.api.internal;

abstract class zaap implements Runnable {
  private zaap(zaaf paramzaaf) {}
  
  public void run() {
    Exception exception;
    zaaf.zac(this.zaa).lock();
    try {
      boolean bool = Thread.interrupted();
      if (bool) {
        zaaf.zac(this.zaa).unlock();
        return;
      } 
      zaa();
      zaaf.zac(this.zaa).unlock();
      return;
    } catch (RuntimeException null) {
      zaaf.zad(this.zaa).zaa((RuntimeException)exception);
      zaaf.zac(this.zaa).unlock();
      return;
    } finally {}
    zaaf.zac(this.zaa).unlock();
    throw exception;
  }
  
  protected abstract void zaa();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\api\internal\zaap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */