package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

enum DirectExecutor implements Executor {
  a;
  
  public void execute(Runnable paramRunnable) {
    paramRunnable.run();
  }
  
  public String toString() {
    return "MoreExecutors.directExecutor()";
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\commo\\util\concurrent\DirectExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */