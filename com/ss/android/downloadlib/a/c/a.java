package com.ss.android.downloadlib.a.c;

import android.os.Environment;
import com.ss.android.a.a.a.d;
import com.ss.android.downloadlib.a.j;
import com.ss.android.downloadlib.e.f;
import com.ss.android.socialbase.downloader.d.o;
import com.ss.android.socialbase.downloader.d.p;
import com.ss.android.socialbase.downloader.downloader.f;
import com.ss.android.socialbase.downloader.g.c;
import com.ss.android.socialbase.downloader.m.f;
import java.io.File;

public class a implements p {
  private int a;
  
  private long a(String paramString) {
    try {
      return f.c(paramString);
    } catch (Exception exception) {
      exception.printStackTrace();
      return 0L;
    } 
  }
  
  private void a() {
    d d = j.o();
    if (d != null)
      d.a(); 
    c.a();
    c.b();
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5) {
    boolean bool;
    c c = f.a(j.a()).h(this.a);
    if (c == null)
      return; 
    if (paramLong2 > paramLong3) {
      bool = true;
    } else {
      bool = false;
    } 
    try {
      com.ss.android.downloadlib.a.a().a(c, paramLong1, paramLong2, paramLong3, paramLong4, paramLong5, bool);
      return;
    } catch (Exception exception) {
      exception.printStackTrace();
      return;
    } 
  }
  
  private boolean a(com.ss.android.socialbase.downloader.k.a parama) {
    if (parama.a("clear_space_use_disk_handler", 0) != 1)
      return false; 
    long l = parama.a("clear_space_min_time_interval", 600000L);
    return !(System.currentTimeMillis() - d.a().c() < l);
  }
  
  private long b(com.ss.android.socialbase.downloader.k.a parama) {
    long l1 = parama.a("clear_space_sleep_time", 0L);
    if (l1 <= 0L)
      return 0L; 
    long l2 = 5000L;
    if (l1 > 5000L)
      l1 = l2; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("waiting for space clear, sleepTime = ");
    stringBuilder.append(l1);
    f.b("AppDownloadDiskSpaceHandler", stringBuilder.toString(), null);
    try {
      Thread.sleep(l1);
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } 
    f.b("AppDownloadDiskSpaceHandler", "waiting end!", null);
    return l1;
  }
  
  public void a(int paramInt) {
    this.a = paramInt;
  }
  
  public boolean a(long paramLong1, long paramLong2, o paramo) {
    com.ss.android.socialbase.downloader.k.a a1 = com.ss.android.socialbase.downloader.k.a.a(this.a);
    if (!a(a1))
      return false; 
    long l2 = System.currentTimeMillis();
    d.a().d();
    File file = Environment.getExternalStorageDirectory();
    long l3 = a(file.toString());
    a();
    long l1 = a(file.toString());
    long l4 = System.currentTimeMillis();
    if (l1 < paramLong2) {
      long l = b(a1);
      paramLong1 = l;
      if (l > 0L) {
        l1 = a(file.toString());
        paramLong1 = l;
      } 
    } else {
      paramLong1 = 0L;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("cleanUpDisk, byteRequired = ");
    stringBuilder.append(paramLong2);
    stringBuilder.append(", byteAvailableAfter = ");
    stringBuilder.append(l1);
    stringBuilder.append(", cleaned = ");
    stringBuilder.append(l1 - l3);
    f.b("AppDownloadDiskSpaceHandler", stringBuilder.toString(), null);
    a(l3, l1, paramLong2, l4 - l2, paramLong1);
    if (l1 < paramLong2)
      return false; 
    if (paramo != null)
      paramo.a(); 
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\downloadlib\a\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */