package com.blued.android.statistics.biz;

import com.blued.android.statistics.grpc.connect.EventManager;
import com.blued.android.statistics.util.Utils;
import com.blued.das.event.CustomEventProtos;

public class Event {
  private Event() {}
  
  public static Event a() {
    return InstanceHolder.a();
  }
  
  private void a(CustomEventProtos.Request.Builder paramBuilder) {
    paramBuilder.setClientTime(System.currentTimeMillis());
    EventManager.a().a(paramBuilder.build());
  }
  
  public void a(String paramString1, long paramLong, int paramInt, String paramString2) {
    b(paramString1, paramLong, paramInt, paramString2);
  }
  
  public void b(String paramString1, long paramLong, int paramInt, String paramString2) {
    a(CustomEventProtos.Request.newBuilder().setTakes((int)paramLong).setName(Utils.b(paramString1)).setCode(paramInt).setDescription(Utils.b(paramString2)));
  }
  
  static class InstanceHolder {
    private static final Event a = new Event();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\biz\Event.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */