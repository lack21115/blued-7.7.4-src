package cn.shuzilm.core;

final class u implements Runnable {
  u(DUListener paramDUListener) {}
  
  public void run() {
    Main.mLock.lock();
    try {
      IDUService iDUService = DUConnection.duService;
      if (iDUService != null && iDUService.asBinder().isBinderAlive())
        iDUService.getOpenAnmsIDAsyn(this.a); 
    } catch (Exception exception) {
    
    } finally {
      Exception exception;
    } 
    Main.mLock.unlock();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\cor\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */