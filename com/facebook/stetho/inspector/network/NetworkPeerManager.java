package com.facebook.stetho.inspector.network;

import android.content.Context;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeerRegistrationListener;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import javax.annotation.Nullable;

public class NetworkPeerManager extends ChromePeerManager {
  private static NetworkPeerManager sInstance;
  
  private AsyncPrettyPrinterRegistry mAsyncPrettyPrinterRegistry;
  
  private AsyncPrettyPrinterInitializer mPrettyPrinterInitializer;
  
  private final ResponseBodyFileManager mResponseBodyFileManager;
  
  private final PeersRegisteredListener mTempFileCleanup = new PeersRegisteredListener() {
      public void onFirstPeerRegistered() {
        AsyncPrettyPrinterExecutorHolder.ensureInitialized();
        if (NetworkPeerManager.this.mAsyncPrettyPrinterRegistry == null && NetworkPeerManager.this.mPrettyPrinterInitializer != null) {
          NetworkPeerManager.access$002(NetworkPeerManager.this, new AsyncPrettyPrinterRegistry());
          NetworkPeerManager.this.mPrettyPrinterInitializer.populatePrettyPrinters(NetworkPeerManager.this.mAsyncPrettyPrinterRegistry);
        } 
        NetworkPeerManager.this.mResponseBodyFileManager.cleanupFiles();
      }
      
      public void onLastPeerUnregistered() {
        NetworkPeerManager.this.mResponseBodyFileManager.cleanupFiles();
        AsyncPrettyPrinterExecutorHolder.shutdown();
      }
    };
  
  public NetworkPeerManager(ResponseBodyFileManager paramResponseBodyFileManager) {
    this.mResponseBodyFileManager = paramResponseBodyFileManager;
    setListener((PeerRegistrationListener)this.mTempFileCleanup);
  }
  
  @Nullable
  public static NetworkPeerManager getInstanceOrNull() {
    // Byte code:
    //   0: ldc com/facebook/stetho/inspector/network/NetworkPeerManager
    //   2: monitorenter
    //   3: getstatic com/facebook/stetho/inspector/network/NetworkPeerManager.sInstance : Lcom/facebook/stetho/inspector/network/NetworkPeerManager;
    //   6: astore_0
    //   7: ldc com/facebook/stetho/inspector/network/NetworkPeerManager
    //   9: monitorexit
    //   10: aload_0
    //   11: areturn
    //   12: astore_0
    //   13: ldc com/facebook/stetho/inspector/network/NetworkPeerManager
    //   15: monitorexit
    //   16: aload_0
    //   17: athrow
    // Exception table:
    //   from	to	target	type
    //   3	7	12	finally
  }
  
  public static NetworkPeerManager getOrCreateInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/facebook/stetho/inspector/network/NetworkPeerManager
    //   2: monitorenter
    //   3: getstatic com/facebook/stetho/inspector/network/NetworkPeerManager.sInstance : Lcom/facebook/stetho/inspector/network/NetworkPeerManager;
    //   6: ifnonnull -> 30
    //   9: new com/facebook/stetho/inspector/network/NetworkPeerManager
    //   12: dup
    //   13: new com/facebook/stetho/inspector/network/ResponseBodyFileManager
    //   16: dup
    //   17: aload_0
    //   18: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   21: invokespecial <init> : (Landroid/content/Context;)V
    //   24: invokespecial <init> : (Lcom/facebook/stetho/inspector/network/ResponseBodyFileManager;)V
    //   27: putstatic com/facebook/stetho/inspector/network/NetworkPeerManager.sInstance : Lcom/facebook/stetho/inspector/network/NetworkPeerManager;
    //   30: getstatic com/facebook/stetho/inspector/network/NetworkPeerManager.sInstance : Lcom/facebook/stetho/inspector/network/NetworkPeerManager;
    //   33: astore_0
    //   34: ldc com/facebook/stetho/inspector/network/NetworkPeerManager
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: astore_0
    //   40: ldc com/facebook/stetho/inspector/network/NetworkPeerManager
    //   42: monitorexit
    //   43: aload_0
    //   44: athrow
    // Exception table:
    //   from	to	target	type
    //   3	30	39	finally
    //   30	34	39	finally
  }
  
  @Nullable
  public AsyncPrettyPrinterRegistry getAsyncPrettyPrinterRegistry() {
    return this.mAsyncPrettyPrinterRegistry;
  }
  
  public ResponseBodyFileManager getResponseBodyFileManager() {
    return this.mResponseBodyFileManager;
  }
  
  public void setPrettyPrinterInitializer(AsyncPrettyPrinterInitializer paramAsyncPrettyPrinterInitializer) {
    Util.throwIfNotNull(this.mPrettyPrinterInitializer);
    this.mPrettyPrinterInitializer = (AsyncPrettyPrinterInitializer)Util.throwIfNull(paramAsyncPrettyPrinterInitializer);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\facebook\stetho\inspector\network\NetworkPeerManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */