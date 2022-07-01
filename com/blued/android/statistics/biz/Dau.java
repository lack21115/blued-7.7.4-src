package com.blued.android.statistics.biz;

import com.blued.android.statistics.grpc.connect.DauManager;
import com.blued.das.dau.DayActiveUserProtos;

public class Dau {
  private boolean a = false;
  
  private Dau() {}
  
  public static Dau a() {
    return InstanceHolder.a();
  }
  
  private void a(DayActiveUserProtos.Request.Builder paramBuilder) {
    paramBuilder.setClientTime(System.currentTimeMillis());
    DauManager.a().a(paramBuilder);
  }
  
  private void b(DayActiveUserProtos.Request.Builder paramBuilder) {
    paramBuilder.setClientTime(System.currentTimeMillis());
    DauManager.a().b(paramBuilder);
  }
  
  public void b() {
    this.a = true;
    b(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.LOGIN));
  }
  
  public void c() {
    if (this.a)
      b(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.SWITCH_TO_FRONT)); 
  }
  
  public void d() {
    if (this.a)
      a(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.SWITCH_TO_BACK)); 
  }
  
  public void e() {
    this.a = false;
    a(DayActiveUserProtos.Request.newBuilder().setName(DayActiveUserProtos.NAME.LOGOUT));
  }
  
  static class InstanceHolder {
    private static final Dau a = new Dau();
  }
  
  public static interface OnDauListener {
    void a(DayActiveUserProtos.NAME param1NAME);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\biz\Dau.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */