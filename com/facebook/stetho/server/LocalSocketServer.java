package com.facebook.stetho.server;

import android.net.LocalServerSocket;
import android.net.LocalSocket;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.SocketException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;

public class LocalSocketServer {
  private static final int MAX_BIND_RETRIES = 2;
  
  private static final int TIME_BETWEEN_BIND_RETRIES_MS = 1000;
  
  private static final String WORKER_THREAD_NAME_PREFIX = "StethoWorker";
  
  private final String mAddress;
  
  private final String mFriendlyName;
  
  private Thread mListenerThread;
  
  private LocalServerSocket mServerSocket;
  
  private final SocketHandler mSocketHandler;
  
  private boolean mStopped;
  
  private final AtomicInteger mThreadId = new AtomicInteger();
  
  public LocalSocketServer(String paramString1, String paramString2, SocketHandler paramSocketHandler) {
    this.mFriendlyName = (String)Util.throwIfNull(paramString1);
    this.mAddress = (String)Util.throwIfNull(paramString2);
    this.mSocketHandler = paramSocketHandler;
  }
  
  @Nonnull
  private static LocalServerSocket bindToSocket(String paramString) throws IOException {
    int i = 2;
    BindException bindException = null;
    while (true) {
      try {
        if (LogUtil.isLoggable(3)) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Trying to bind to @");
          stringBuilder.append(paramString);
          LogUtil.d(stringBuilder.toString());
        } 
        return new LocalServerSocket(paramString);
      } catch (BindException bindException2) {
        LogUtil.w(bindException2, "Binding error, sleep 1000 ms...");
        BindException bindException1 = bindException;
        if (bindException == null)
          bindException1 = bindException2; 
        Util.sleepUninterruptibly(1000L);
        if (i > 0) {
          i--;
          bindException = bindException1;
          continue;
        } 
        throw bindException1;
      } 
    } 
  }
  
  private void listenOnAddress(String paramString) throws IOException {
    this.mServerSocket = bindToSocket(paramString);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Listening on @");
    stringBuilder.append(paramString);
    LogUtil.i(stringBuilder.toString());
    while (true) {
      if (!Thread.interrupted())
        try {
          WorkerThread workerThread = new WorkerThread(this.mServerSocket.accept(), this.mSocketHandler);
          StringBuilder stringBuilder1 = new StringBuilder();
          stringBuilder1.append("StethoWorker-");
          stringBuilder1.append(this.mFriendlyName);
          stringBuilder1.append("-");
          stringBuilder1.append(this.mThreadId.incrementAndGet());
          workerThread.setName(stringBuilder1.toString());
          workerThread.setDaemon(true);
          workerThread.start();
          continue;
        } catch (SocketException socketException) {
          if (!Thread.interrupted()) {
            LogUtil.w(socketException, "I/O error");
            continue;
          } 
        } catch (InterruptedIOException interruptedIOException) {
        
        } catch (IOException iOException) {
          LogUtil.w(iOException, "I/O error initialising connection thread");
        }  
      stringBuilder = new StringBuilder();
      stringBuilder.append("Server shutdown on @");
      stringBuilder.append(paramString);
      LogUtil.i(stringBuilder.toString());
      return;
    } 
  }
  
  public String getName() {
    return this.mFriendlyName;
  }
  
  public void run() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield mStopped : Z
    //   6: ifeq -> 12
    //   9: aload_0
    //   10: monitorexit
    //   11: return
    //   12: aload_0
    //   13: invokestatic currentThread : ()Ljava/lang/Thread;
    //   16: putfield mListenerThread : Ljava/lang/Thread;
    //   19: aload_0
    //   20: monitorexit
    //   21: aload_0
    //   22: aload_0
    //   23: getfield mAddress : Ljava/lang/String;
    //   26: invokespecial listenOnAddress : (Ljava/lang/String;)V
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	30	finally
    //   12	21	30	finally
    //   31	33	30	finally
  }
  
  public void stop() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield mStopped : Z
    //   7: aload_0
    //   8: getfield mListenerThread : Ljava/lang/Thread;
    //   11: ifnonnull -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_0
    //   20: getfield mListenerThread : Ljava/lang/Thread;
    //   23: invokevirtual interrupt : ()V
    //   26: aload_0
    //   27: getfield mServerSocket : Landroid/net/LocalServerSocket;
    //   30: ifnull -> 40
    //   33: aload_0
    //   34: getfield mServerSocket : Landroid/net/LocalServerSocket;
    //   37: invokevirtual close : ()V
    //   40: return
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    //   46: astore_1
    //   47: return
    // Exception table:
    //   from	to	target	type
    //   2	16	41	finally
    //   17	19	41	finally
    //   26	40	46	java/io/IOException
    //   42	44	41	finally
  }
  
  static class WorkerThread extends Thread {
    private final LocalSocket mSocket;
    
    private final SocketHandler mSocketHandler;
    
    public WorkerThread(LocalSocket param1LocalSocket, SocketHandler param1SocketHandler) {
      this.mSocket = param1LocalSocket;
      this.mSocketHandler = param1SocketHandler;
    }
    
    public void run() {
      try {
        this.mSocketHandler.onAccepted(this.mSocket);
        try {
          this.mSocket.close();
          return;
        } catch (IOException iOException) {}
      } catch (IOException iOException) {
        LogUtil.w("I/O error: %s", new Object[] { iOException });
        try {
          this.mSocket.close();
          return;
        } catch (IOException iOException1) {}
      } finally {
        Exception exception;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\server\LocalSocketServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */