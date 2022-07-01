package com.google.android.gms.tasks;

public final class DuplicateTaskCompletionException extends IllegalStateException {
  private DuplicateTaskCompletionException(String paramString, Throwable paramThrowable) {
    super(paramString, paramThrowable);
  }
  
  public static IllegalStateException of(Task<?> paramTask) {
    if (!paramTask.isComplete())
      return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task."); 
    Exception exception = paramTask.getException();
    if (exception != null) {
      str = "failure";
    } else if (str.isSuccessful()) {
      str = String.valueOf(str.getResult());
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(str).length() + 7);
      stringBuilder.append("result ");
      stringBuilder.append(str);
      str = stringBuilder.toString();
    } else if (str.isCanceled()) {
      str = "cancellation";
    } else {
      str = "unknown issue";
    } 
    String str = String.valueOf(str);
    if (str.length() != 0) {
      str = "Complete with: ".concat(str);
    } else {
      str = new String("Complete with: ");
    } 
    return new DuplicateTaskCompletionException(str, exception);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\tasks\DuplicateTaskCompletionException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */