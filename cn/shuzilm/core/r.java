package cn.shuzilm.core;

final class r implements Runnable {
  r(String paramString1, String paramString2) {}
  
  public void run() {
    try {
      Main.mLock.lock();
      try {
        IDUService iDUService = DUConnection.duService;
        if (iDUService != null && iDUService.asBinder().isBinderAlive())
          Main.a(iDUService.setConfig(this.a, this.b)); 
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */