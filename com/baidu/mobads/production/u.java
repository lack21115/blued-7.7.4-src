package com.baidu.mobads.production;

import com.baidu.mobads.openad.c.d;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.d.b;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;

public class u extends a {
  public void a(b paramb, String paramString) {
    dispatchEvent((IOAdEvent)new d("URLLoader.Load.Complete", paramString, paramb.a()));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\productio\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */