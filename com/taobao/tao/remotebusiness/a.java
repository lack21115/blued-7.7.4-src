package com.taobao.tao.remotebusiness;

import com.taobao.tao.remotebusiness.a.a;
import com.taobao.tao.remotebusiness.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.domain.MtopResponse;

public final class a {
  private static List a = new ArrayList();
  
  private static Lock b = new ReentrantLock();
  
  public static void a() {
    b.lock();
    try {
      if (TBSdkLog.a(TBSdkLog.LogEnable.c)) {
        StringBuilder stringBuilder = new StringBuilder("retry all request, current size=");
        stringBuilder.append(a.size());
        TBSdkLog.b("mtop.rb-RequestPool", stringBuilder.toString());
      } 
      Iterator<?> iterator = (new ArrayList(a)).iterator();
      while (iterator.hasNext())
        ((MtopBusiness)iterator.next()).retryRequest(); 
      return;
    } finally {
      b.unlock();
    } 
  }
  
  public static void a(MtopBusiness paramMtopBusiness) {
    b.lock();
    try {
      a.add(paramMtopBusiness);
      TBSdkLog.b("mtop.rb-RequestPool", paramMtopBusiness.getSeqNo(), "request add to request pool");
      return;
    } finally {
      b.unlock();
    } 
  }
  
  public static void a(String paramString1, String paramString2) {
    b.lock();
    try {
      TBSdkLog.b("mtop.rb-RequestPool", "session fail  all request");
      for (MtopBusiness mtopBusiness : a) {
        MtopResponse mtopResponse;
        if (mtopBusiness.request != null) {
          mtopResponse = new MtopResponse(mtopBusiness.request.a(), mtopBusiness.request.b(), paramString1, paramString2);
        } else {
          mtopResponse = new MtopResponse(paramString1, paramString2);
        } 
        b b = a.a(null, null, mtopBusiness);
        b.e = mtopResponse;
        a.a().obtainMessage(3, b).sendToTarget();
      } 
      a.clear();
      return;
    } finally {
      b.unlock();
    } 
  }
  
  public static void b(MtopBusiness paramMtopBusiness) {
    b.lock();
    try {
      TBSdkLog.b("mtop.rb-RequestPool", paramMtopBusiness.getSeqNo(), "request remove from request pool");
    } catch (Exception exception) {
    
    } finally {
      b.unlock();
    } 
    b.unlock();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\taobao\tao\remotebusiness\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */