package com.alipay.android.phone.mrpc.core;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

final class m extends FutureTask<u> {
  m(l paraml, Callable<u> paramCallable, q paramq) {
    super(paramCallable);
  }
  
  protected final void done() {
    HttpException httpException;
    o o = this.a.a();
    if (o.f() == null) {
      super.done();
      return;
    } 
    try {
      get();
      return;
    } catch (InterruptedException interruptedException) {
      return;
    } catch (ExecutionException executionException) {
      if (executionException.getCause() != null && executionException.getCause() instanceof HttpException) {
        httpException = (HttpException)executionException.getCause();
        httpException.getCode();
        return;
      } 
      return;
    } catch (CancellationException cancellationException) {
      return;
    } finally {
      httpException = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\android\phone\mrpc\core\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */