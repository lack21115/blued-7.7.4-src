package com.huawei.hianalytics.ab.bc.hi;

import java.util.Calendar;
import java.util.UUID;

public class bc {
  private long ab = 1800000L;
  
  private volatile boolean bc = false;
  
  private ab cd = null;
  
  public void ab() {
    this.cd = null;
    this.bc = false;
  }
  
  void ab(long paramLong) {
    ab ab1 = this.cd;
    if (ab1 == null) {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "Session is first flush");
      this.cd = new ab(this, paramLong);
      return;
    } 
    ab1.ab(paramLong);
  }
  
  public String bc() {
    ab ab1 = this.cd;
    if (ab1 == null) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
      return "";
    } 
    return ab1.ab;
  }
  
  public boolean cd() {
    ab ab1 = this.cd;
    if (ab1 == null) {
      com.huawei.hianalytics.ab.bc.ef.ab.fg("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
      return false;
    } 
    return ab1.bc;
  }
  
  class ab {
    String ab = UUID.randomUUID().toString().replace("-", "");
    
    boolean bc;
    
    private long cd;
    
    ab(bc this$0, long param1Long) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.ab);
      stringBuilder.append("_");
      stringBuilder.append(param1Long);
      this.ab = stringBuilder.toString();
      this.cd = param1Long;
      this.bc = true;
      bc.ab(this$0, false);
    }
    
    private boolean ab(long param1Long1, long param1Long2) {
      Calendar calendar1 = Calendar.getInstance();
      calendar1.setTimeInMillis(param1Long1);
      Calendar calendar2 = Calendar.getInstance();
      calendar2.setTimeInMillis(param1Long2);
      boolean bool = true;
      if (calendar1.get(1) == calendar2.get(1)) {
        if (calendar1.get(6) != calendar2.get(6))
          return true; 
        bool = false;
      } 
      return bool;
    }
    
    private void bc(long param1Long) {
      com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "getNewSession() session is flush!");
      this.ab = UUID.randomUUID().toString();
      this.ab = this.ab.replace("-", "");
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.ab);
      stringBuilder.append("_");
      stringBuilder.append(param1Long);
      this.ab = stringBuilder.toString();
      this.cd = param1Long;
      this.bc = true;
    }
    
    private boolean bc(long param1Long1, long param1Long2) {
      return (param1Long2 - param1Long1 >= bc.bc(this.de));
    }
    
    void ab(long param1Long) {
      if (bc.ab(this.de)) {
        bc.ab(this.de, false);
        bc(param1Long);
        return;
      } 
      if (bc(this.cd, param1Long) || ab(this.cd, param1Long)) {
        bc(param1Long);
        return;
      } 
      this.cd = param1Long;
      this.bc = false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\hi\bc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */