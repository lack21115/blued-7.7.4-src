package com.tencent.tbs.patch.common.task;

public abstract class TaskRunner {
  private Listener a;
  
  void a() {
    Listener listener = this.a;
    if (listener != null)
      listener.onFinished(); 
  }
  
  void a(Task paramTask, int paramInt, String paramString, Throwable paramThrowable) {
    Listener listener = this.a;
    if (listener != null)
      listener.onError(paramInt, paramString, paramThrowable); 
  }
  
  public abstract void onTaskEvaluated(Task paramTask);
  
  public abstract void onTaskFinished(Task paramTask);
  
  public abstract void onTaskPrepared(Task paramTask);
  
  public abstract void run(Task paramTask);
  
  public void setListener(Listener paramListener) {
    this.a = paramListener;
  }
  
  public static interface Listener {
    void onError(int param1Int, String param1String, Throwable param1Throwable);
    
    void onFinished();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\task\TaskRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */