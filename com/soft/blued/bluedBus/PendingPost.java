package com.soft.blued.bluedBus;

import java.util.ArrayList;
import java.util.List;

final class PendingPost {
  private static final List<PendingPost> d = new ArrayList<PendingPost>();
  
  Object[] a;
  
  Subscription b;
  
  PendingPost c;
  
  static void a(PendingPost paramPendingPost) {
    paramPendingPost.a = null;
    paramPendingPost.b = null;
    paramPendingPost.c = null;
    synchronized (d) {
      if (d.size() < 10000)
        d.add(paramPendingPost); 
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\bluedBus\PendingPost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */