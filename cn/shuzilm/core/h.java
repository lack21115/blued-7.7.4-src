package cn.shuzilm.core;

final class h implements Runnable {
  public void run() {
    if (!DUHelper.b().tryLock())
      return; 
    try {
      DUHelper.a(new AIClient(DUHelper.mContext));
      DUHelper.c().asynAI();
    } catch (Exception exception) {
    
    } finally {
      DUHelper.b().unlock();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */