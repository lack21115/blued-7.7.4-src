package com.google.android.gms.tasks;

public abstract class CancellationToken {
  public abstract boolean isCancellationRequested();
  
  public abstract CancellationToken onCanceledRequested(OnTokenCanceledListener paramOnTokenCanceledListener);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\CancellationToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */