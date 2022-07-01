package cn.shuzilm.core;

final class p implements Runnable {
  p(String paramString1, String paramString2, DUListener paramDUListener) {}
  
  public void run() {
    try {
      Main.mLock.lock();
      try {
        IDUService iDUService = DUConnection.duService;
        if (iDUService != null && iDUService.asBinder().isBinderAlive())
          iDUService.getQueryIDAsyn(this.a, this.b, this.c); 
        return;
      } finally {
        Main.mLock.unlock();
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */