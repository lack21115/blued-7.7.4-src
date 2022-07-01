package com.bytedance.sdk.openadsdk.downloadnew.core;

import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class c implements TTAppDownloadListener {
  private final List<TTAppDownloadListener> a = Collections.synchronizedList(new LinkedList<TTAppDownloadListener>());
  
  public void a() {
    if (!this.a.isEmpty())
      this.a.clear(); 
  }
  
  public void a(TTAppDownloadListener paramTTAppDownloadListener) {
    if (paramTTAppDownloadListener != null) {
      for (TTAppDownloadListener tTAppDownloadListener : this.a) {
        if (tTAppDownloadListener != null && tTAppDownloadListener == paramTTAppDownloadListener)
          return; 
      } 
      this.a.add(paramTTAppDownloadListener);
    } 
  }
  
  public void onDownloadActive(long paramLong1, long paramLong2, String paramString1, String paramString2) {
    Iterator<TTAppDownloadListener> iterator = this.a.iterator();
    while (iterator.hasNext()) {
      TTAppDownloadListener tTAppDownloadListener = iterator.next();
      if (tTAppDownloadListener == null) {
        iterator.remove();
        continue;
      } 
      tTAppDownloadListener.onDownloadActive(paramLong1, paramLong2, paramString1, paramString2);
    } 
  }
  
  public void onDownloadFailed(long paramLong1, long paramLong2, String paramString1, String paramString2) {
    Iterator<TTAppDownloadListener> iterator = this.a.iterator();
    while (iterator.hasNext()) {
      TTAppDownloadListener tTAppDownloadListener = iterator.next();
      if (tTAppDownloadListener == null) {
        iterator.remove();
        continue;
      } 
      tTAppDownloadListener.onDownloadFailed(paramLong1, paramLong2, paramString1, paramString2);
    } 
  }
  
  public void onDownloadFinished(long paramLong, String paramString1, String paramString2) {
    Iterator<TTAppDownloadListener> iterator = this.a.iterator();
    while (iterator.hasNext()) {
      TTAppDownloadListener tTAppDownloadListener = iterator.next();
      if (tTAppDownloadListener == null) {
        iterator.remove();
        continue;
      } 
      tTAppDownloadListener.onDownloadFinished(paramLong, paramString1, paramString2);
    } 
  }
  
  public void onDownloadPaused(long paramLong1, long paramLong2, String paramString1, String paramString2) {
    Iterator<TTAppDownloadListener> iterator = this.a.iterator();
    while (iterator.hasNext()) {
      TTAppDownloadListener tTAppDownloadListener = iterator.next();
      if (tTAppDownloadListener == null) {
        iterator.remove();
        continue;
      } 
      tTAppDownloadListener.onDownloadPaused(paramLong1, paramLong2, paramString1, paramString2);
    } 
  }
  
  public void onIdle() {
    Iterator<TTAppDownloadListener> iterator = this.a.iterator();
    while (iterator.hasNext()) {
      TTAppDownloadListener tTAppDownloadListener = iterator.next();
      if (tTAppDownloadListener == null) {
        iterator.remove();
        continue;
      } 
      tTAppDownloadListener.onIdle();
    } 
  }
  
  public void onInstalled(String paramString1, String paramString2) {
    Iterator<TTAppDownloadListener> iterator = this.a.iterator();
    while (iterator.hasNext()) {
      TTAppDownloadListener tTAppDownloadListener = iterator.next();
      if (tTAppDownloadListener == null) {
        iterator.remove();
        continue;
      } 
      tTAppDownloadListener.onInstalled(paramString1, paramString2);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\downloadnew\core\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */