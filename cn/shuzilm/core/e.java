package cn.shuzilm.core;

import android.content.Context;

final class e implements Runnable {
  e(Context paramContext, DUListener paramDUListener) {}
  
  public void run() {
    try {
      DUHelper.b().lock();
      if (DUHelper.c() == null) {
        DUHelper.a(new AIClient(this.a));
        DUHelper.c().asynAI();
      } 
      if (!(DUHelper.c()).isf)
        DUHelper.c().asynAI(); 
    } finally {
      null = null;
    } 
    Object object = SYNTHETIC_LOCAL_VARIABLE_1;
    if (SYNTHETIC_LOCAL_VARIABLE_1 == null)
      object = "NA"; 
    this.b.handle((String)object);
    DUHelper.b().unlock();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\cn\shuzilm\core\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */