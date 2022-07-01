package com.baidu.mobads.production;

import com.baidu.mobads.b.a;
import com.baidu.mobads.e.a;
import com.baidu.mobads.f.g;
import com.baidu.mobads.openad.interfaces.event.IOAdEvent;
import com.baidu.mobads.utils.q;
import java.util.HashMap;

class i implements g.c {
  i(b paramb) {}
  
  public void a(boolean paramBoolean) {
    if (paramBoolean)
      try {
        if (BaiduXAdSDKContext.mApkLoader != null) {
          b.a = BaiduXAdSDKContext.mApkLoader.h();
          if (b.a != null) {
            b.a(this.a);
            return;
          } 
        } 
        BaiduXAdSDKContext.mApkLoader = null;
        HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("回调onLoad,succcess=");
        stringBuilder1.append(paramBoolean);
        hashMap1.put("error_message", stringBuilder1.toString());
        this.a.dispatchEvent((IOAdEvent)new a("AdError", hashMap1));
        return;
      } catch (Exception exception) {
        HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("async apk on load exception: ");
        stringBuilder1.append(exception.toString());
        hashMap1.put("error_message", stringBuilder1.toString());
        this.a.dispatchEvent((IOAdEvent)new a("AdError", hashMap1));
        q.a().e(exception);
        a a = a.a();
        stringBuilder1 = new StringBuilder();
        stringBuilder1.append("async apk on load exception: ");
        stringBuilder1.append(exception.toString());
        a.a(stringBuilder1.toString());
        return;
      }  
    BaiduXAdSDKContext.mApkLoader = null;
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("回调onLoad,succcess=");
    stringBuilder.append(paramBoolean);
    hashMap.put("error_message", stringBuilder.toString());
    this.a.dispatchEvent((IOAdEvent)new a("AdError", hashMap));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\production\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */