package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.q;
import java.util.HashMap;

public class c extends a {
  private String o = "";
  
  private HashMap<String, String> p = null;
  
  public c(String paramString, IXAdInstanceInfo paramIXAdInstanceInfo, IXAdProdInfo paramIXAdProdInfo, HashMap<String, String> paramHashMap) {
    super(new a.a(paramIXAdInstanceInfo, paramIXAdProdInfo));
    this.o = paramString;
    this.p = paramHashMap;
  }
  
  public String a(Context paramContext) {
    HashMap<String, String> hashMap = c();
    try {
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append("type=");
      stringBuilder2.append(this.o);
      stringBuilder2.append("&");
      stringBuilder2 = new StringBuilder(stringBuilder2.toString());
      StringBuilder stringBuilder3 = new StringBuilder();
      h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
      for (String str2 : hashMap.keySet()) {
        String str1 = hashMap.get(str2);
        if (str2 != null && str1 != null) {
          str2 = h.encodeURIComponent(str2);
          str1 = h.encodeURIComponent(str1);
          stringBuilder2.append(str2);
          stringBuilder2.append("=");
          stringBuilder2.append(str1);
          stringBuilder2.append("&");
          stringBuilder3.append(str1);
          stringBuilder3.append(",");
        } 
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("https://mobads-logs.baidu.com/dz.zb");
      stringBuilder1.append("?");
      stringBuilder1.append(stringBuilder2.toString());
      return stringBuilder1.toString();
    } catch (Exception exception) {
      q.a().d(exception);
      return "";
    } 
  }
  
  protected HashMap<String, String> b() {
    if (this.p == null)
      this.p = new HashMap<String, String>(); 
    return this.p;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\vo\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */