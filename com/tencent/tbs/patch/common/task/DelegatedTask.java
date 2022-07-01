package com.tencent.tbs.patch.common.task;

public abstract class DelegatedTask extends Task {
  public void run() {
    run(this);
  }
  
  public abstract void run(Task paramTask);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\task\DelegatedTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */