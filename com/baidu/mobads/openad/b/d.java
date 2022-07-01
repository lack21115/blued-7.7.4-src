package com.baidu.mobads.openad.b;

import android.content.Context;
import com.baidu.mobads.c.e;
import com.baidu.mobads.command.a;
import com.baidu.mobads.interfaces.download.IXAdStaticImgDownloader;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.a.c;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class d implements IOAdDownloaderManager {
  private static d b;
  
  protected Context a;
  
  private HashMap<String, IOAdDownloader> c = new HashMap<String, IOAdDownloader>();
  
  private c d;
  
  private AtomicBoolean e = new AtomicBoolean(false);
  
  protected d(Context paramContext) {
    this.a = paramContext;
  }
  
  public static d a(Context paramContext) {
    if (b == null)
      b = new d(paramContext); 
    return b;
  }
  
  public void a(String paramString, IOAdDownloader paramIOAdDownloader) {
    synchronized (this.c) {
      this.c.put(paramString, paramIOAdDownloader);
      return;
    } 
  }
  
  public IOAdDownloader createAdsApkDownloader(URL paramURL, String paramString1, String paramString2, int paramInt, String paramString3, String paramString4) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new com/baidu/mobads/openad/b/a
    //   5: dup
    //   6: aload_0
    //   7: getfield a : Landroid/content/Context;
    //   10: aload_1
    //   11: aload_2
    //   12: aload_3
    //   13: iload #4
    //   15: aload #5
    //   17: aload #6
    //   19: invokespecial <init> : (Landroid/content/Context;Ljava/net/URL;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_0
    //   24: aload #6
    //   26: aload_1
    //   27: invokevirtual a : (Ljava/lang/String;Lcom/baidu/mobads/openad/interfaces/download/IOAdDownloader;)V
    //   30: aload_0
    //   31: getfield d : Lcom/baidu/mobads/openad/a/c;
    //   34: ifnonnull -> 115
    //   37: aload_0
    //   38: new com/baidu/mobads/openad/a/c
    //   41: dup
    //   42: aload_0
    //   43: getfield a : Landroid/content/Context;
    //   46: invokespecial <init> : (Landroid/content/Context;)V
    //   49: putfield d : Lcom/baidu/mobads/openad/a/c;
    //   52: new com/baidu/mobads/openad/a/b
    //   55: dup
    //   56: aload_0
    //   57: getfield d : Lcom/baidu/mobads/openad/a/c;
    //   60: invokespecial <init> : (Lcom/baidu/mobads/openad/a/c;)V
    //   63: astore_2
    //   64: aload_0
    //   65: getfield d : Lcom/baidu/mobads/openad/a/c;
    //   68: aload_2
    //   69: invokevirtual a : (Landroid/content/BroadcastReceiver;)V
    //   72: aload_0
    //   73: getfield d : Lcom/baidu/mobads/openad/a/c;
    //   76: ldc 'network_changed'
    //   78: new com/baidu/mobads/openad/b/e
    //   81: dup
    //   82: aload_0
    //   83: invokespecial <init> : (Lcom/baidu/mobads/openad/b/d;)V
    //   86: invokevirtual addEventListener : (Ljava/lang/String;Lcom/baidu/mobads/openad/interfaces/event/IOAdEventListener;)V
    //   89: aload_0
    //   90: getfield d : Lcom/baidu/mobads/openad/a/c;
    //   93: invokevirtual a : ()V
    //   96: goto -> 115
    //   99: astore_2
    //   100: invokestatic getInstance : ()Lcom/baidu/mobads/utils/XAdSDKFoundationFacade;
    //   103: invokevirtual getAdLogger : ()Lcom/baidu/mobads/interfaces/utils/IXAdLogger;
    //   106: ldc 'OAdDownloadManager'
    //   108: aload_2
    //   109: invokeinterface d : (Ljava/lang/String;Ljava/lang/Throwable;)I
    //   114: pop
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_1
    //   118: areturn
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Exception table:
    //   from	to	target	type
    //   2	30	119	finally
    //   30	96	99	java/lang/Exception
    //   30	96	119	finally
    //   100	115	119	finally
  }
  
  public IXAdStaticImgDownloader createImgHttpDownloader(URL paramURL, String paramString1, String paramString2) {
    return (IXAdStaticImgDownloader)new e(this.a, paramURL, paramString1, paramString2);
  }
  
  public IOAdDownloader createSimpleFileDownloader(URL paramURL, String paramString1, String paramString2, boolean paramBoolean) {
    return new f(this.a, paramURL, paramString1, paramString2, paramBoolean);
  }
  
  public IOAdDownloader getAdsApkDownloader(String paramString) {
    synchronized (this.c) {
      return this.c.get(paramString);
    } 
  }
  
  public ArrayList<IOAdDownloader> getAllAdsApkDownloaderes() {
    synchronized (this.c) {
      Collection<IOAdDownloader> collection = this.c.values();
      if (collection.size() > 0) {
        ArrayList<IOAdDownloader> arrayList1 = new ArrayList();
        Iterator<IOAdDownloader> iterator = collection.iterator();
        while (true) {
          collection = arrayList1;
          if (iterator.hasNext()) {
            arrayList1.add(iterator.next());
            continue;
          } 
          break;
        } 
        return (ArrayList<IOAdDownloader>)collection;
      } 
    } 
    ArrayList arrayList = null;
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_3} */
    return arrayList;
  }
  
  public Boolean removeAdsApkDownloader(String paramString) {
    synchronized (this.c) {
      this.c.remove(paramString);
      return Boolean.valueOf(true);
    } 
  }
  
  public void removeAllAdsApkDownloaderes() {
    synchronized (this.c) {
      this.c.clear();
      return;
    } 
  }
  
  public void resumeUndownloadedAfterRestartApp(long paramLong) {
    if (this.e.getAndSet(true))
      return; 
    List<String> list = a.a(this.a, paramLong);
    if (list != null && list.size() > 0) {
      int i = 0;
      try {
        while (i < list.size()) {
          String str = list.get(i);
          b b = b.a(str);
          if (b != null || getAdsApkDownloader(str) != null) {
            IXAdLogger iXAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("pack[");
            stringBuilder.append(str);
            stringBuilder.append("] has been stated before, continue");
            iXAdLogger.d("OAdDownloadManager", stringBuilder.toString());
          } else {
            IXAdLogger iXAdLogger;
            a a = a.a(this.a, str);
            if (a == null) {
              iXAdLogger = XAdSDKFoundationFacade.getInstance().getAdLogger();
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("pack[");
              stringBuilder.append(str);
              stringBuilder.append("] has no local data, continue");
              iXAdLogger.d("OAdDownloadManager", stringBuilder.toString());
            } else {
              IOAdDownloader iOAdDownloader = createAdsApkDownloader(new URL(((a)iXAdLogger).j), ((a)iXAdLogger).c, ((a)iXAdLogger).b, 1, ((a)iXAdLogger).a, ((a)iXAdLogger).i);
              iOAdDownloader.addObserver(new b(this.a, (a)iXAdLogger));
              iOAdDownloader.start();
            } 
          } 
          i++;
        } 
      } catch (Exception exception) {
        XAdSDKFoundationFacade.getInstance().getAdLogger().d("OAdDownloadManager", exception);
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\openad\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */