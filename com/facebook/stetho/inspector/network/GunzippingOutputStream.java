package com.facebook.stetho.inspector.network;

import com.facebook.stetho.common.ExceptionUtil;
import com.facebook.stetho.common.Util;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;

class GunzippingOutputStream extends FilterOutputStream {
  private static final ExecutorService sExecutor = Executors.newCachedThreadPool();
  
  private final Future<Void> mCopyFuture;
  
  private GunzippingOutputStream(OutputStream paramOutputStream, Future<Void> paramFuture) throws IOException {
    super(paramOutputStream);
    this.mCopyFuture = paramFuture;
  }
  
  public static GunzippingOutputStream create(OutputStream paramOutputStream) throws IOException {
    PipedInputStream pipedInputStream = new PipedInputStream();
    return new GunzippingOutputStream(new PipedOutputStream(pipedInputStream), sExecutor.submit(new GunzippingCallable(pipedInputStream, paramOutputStream)));
  }
  
  private static <T> T getAndRethrow(Future<T> paramFuture) throws IOException {
    while (true) {
      try {
        return paramFuture.get();
      } catch (InterruptedException interruptedException) {
      
      } catch (ExecutionException executionException) {
        Throwable throwable = executionException.getCause();
        ExceptionUtil.propagateIfInstanceOf(throwable, IOException.class);
        ExceptionUtil.propagate(throwable);
      } 
    } 
  }
  
  public void close() throws IOException {
    try {
      super.close();
    } finally {
      try {
        getAndRethrow(this.mCopyFuture);
      } catch (IOException iOException) {}
    } 
  }
  
  static class GunzippingCallable implements Callable<Void> {
    private final InputStream mIn;
    
    private final OutputStream mOut;
    
    public GunzippingCallable(InputStream param1InputStream, OutputStream param1OutputStream) {
      this.mIn = param1InputStream;
      this.mOut = param1OutputStream;
    }
    
    public Void call() throws IOException {
      GZIPInputStream gZIPInputStream = new GZIPInputStream(this.mIn);
      try {
        Util.copy(gZIPInputStream, this.mOut, new byte[1024]);
        return null;
      } finally {
        gZIPInputStream.close();
        this.mOut.close();
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\GunzippingOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */