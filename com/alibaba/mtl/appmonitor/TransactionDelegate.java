package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.b.b;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;

public class TransactionDelegate {
  private static void a(Transaction paramTransaction) {
    if (paramTransaction == null)
      return; 
    if (paramTransaction.b != null)
      e.a().a(paramTransaction.r, paramTransaction.a, paramTransaction.o, paramTransaction.p, DimensionValueSet.create().addValues(paramTransaction.b)); 
  }
  
  public static void begin(Transaction paramTransaction, String paramString) {
    try {
      if (!AppMonitorDelegate.i)
        return; 
    } finally {
      paramTransaction = null;
      b.a((Throwable)paramTransaction);
    } 
    if (f.d.isOpen() && (AppMonitorDelegate.IS_DEBUG || j.a(f.d, paramTransaction.o, paramTransaction.p))) {
      e.a().a(paramTransaction.r, paramTransaction.a, paramTransaction.o, paramTransaction.p, paramString);
      a(paramTransaction);
      return;
    } 
  }
  
  public static void end(Transaction paramTransaction, String paramString) {
    try {
      if (!AppMonitorDelegate.i)
        return; 
    } finally {
      paramTransaction = null;
      b.a((Throwable)paramTransaction);
    } 
    if (f.d.isOpen() && (AppMonitorDelegate.IS_DEBUG || j.a(f.d, paramTransaction.o, paramTransaction.p))) {
      a(paramTransaction);
      e.a().a(paramTransaction.r, paramString, false);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\TransactionDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */