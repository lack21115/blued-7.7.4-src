package com.qq.e.comm.plugin.c;

import com.qq.e.comm.plugin.c.a.a;
import com.qq.e.comm.plugin.s.b;
import com.qq.e.comm.plugin.t.b.f;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import yaq.gdtadv;

class r implements k {
  private b a(f paramf, f paramf1) {
    return (b)gdtadv.getobjresult(258, 0, new Object[] { this, paramf, paramf1 });
  }
  
  private void a(f paramf, Future<b> paramFuture) {
    gdtadv.getVresult(259, 0, new Object[] { this, paramf, paramFuture });
  }
  
  private String b(f paramf) {
    return (String)gdtadv.getobjresult(260, 0, new Object[] { this, paramf });
  }
  
  private String b(f paramf, String paramString) {
    return (String)gdtadv.getobjresult(261, 0, new Object[] { this, paramf, paramString });
  }
  
  private String c(f paramf, String paramString) {
    return (String)gdtadv.getobjresult(262, 0, new Object[] { this, paramf, paramString });
  }
  
  private Future<b> d(f paramf, String paramString) {
    return (Future<b>)gdtadv.getobjresult(263, 0, new Object[] { this, paramf, paramString });
  }
  
  protected String a(f paramf, String paramString) {
    return (String)gdtadv.getobjresult(264, 0, new Object[] { this, paramf, paramString });
  }
  
  public boolean a(f paramf) {
    return gdtadv.getZresult(265, 0, new Object[] { this, paramf });
  }
  
  public boolean a(f paramf, a parama) {
    return gdtadv.getZresult(266, 0, new Object[] { this, paramf, parama });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\c\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */