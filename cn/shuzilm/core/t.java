package cn.shuzilm.core;

final class t implements Runnable {
  t(String paramString1, String paramString2, String paramString3, DUListener paramDUListener) {}
  
  public void run() {
    Main.mLock.lock();
    try {
      IDUService iDUService = DUConnection.duService;
      if (iDUService != null && iDUService.asBinder().isBinderAlive())
        iDUService.onEventAsyn(this.a, this.b, this.c, this.d); 
    } catch (Exception exception) {
    
    } finally {
      Exception exception;
    } 
    Main.mLock.unlock();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */