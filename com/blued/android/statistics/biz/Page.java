package com.blued.android.statistics.biz;

import com.blued.android.statistics.grpc.connect.PageManager;
import com.blued.android.statistics.util.Utils;
import com.blued.das.page.PageDurationProtos;

public class Page {
  private Page() {}
  
  public static Page a() {
    return InstanceHolder.a();
  }
  
  private void a(PageDurationProtos.Request.Builder paramBuilder) {
    paramBuilder.setClientTime(System.currentTimeMillis());
    PageManager.a().a(paramBuilder.build());
  }
  
  public void a(String paramString1, String paramString2, long paramLong) {
    a(PageDurationProtos.Request.newBuilder().setType(PageDurationProtos.Type.DURATION).setName(Utils.b(paramString1)).setPageCode(Utils.b(paramString2)).setTakes((int)paramLong));
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {
    a(PageDurationProtos.Request.newBuilder().setType(PageDurationProtos.Type.PATH).setName(Utils.b(paramString1)).setPageCode(Utils.b(paramString2)).setPath(Utils.b(paramString3)));
  }
  
  static class InstanceHolder {
    private static final Page a = new Page();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\statistics\biz\Page.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */