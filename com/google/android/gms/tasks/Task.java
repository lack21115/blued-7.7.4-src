package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

public abstract class Task {
  public Task addOnCompleteListener(Executor paramExecutor, OnCompleteListener paramOnCompleteListener) {
    throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
  }
  
  public abstract Exception getException();
  
  public abstract boolean isSuccessful();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\tasks\Task.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */