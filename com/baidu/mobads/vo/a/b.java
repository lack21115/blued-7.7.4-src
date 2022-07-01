package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;

public class b extends a {
  public boolean o = true;
  
  private Context p;
  
  private IXAppInfo q;
  
  public b(Context paramContext, IXAppInfo paramIXAppInfo) {
    super(paramIXAppInfo.getAdId(), paramIXAppInfo.getQk(), paramIXAppInfo.getProd());
    this.p = paramContext;
    this.q = paramIXAppInfo;
  }
  
  protected HashMap<String, String> b() {
    String str2 = "1";
    IXAdSystemUtils iXAdSystemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(iXAdSystemUtils.getCurrentProcessId(this.p));
    String str3 = stringBuilder.toString();
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    try {
      String str;
      if (this.o) {
        str = "true";
      } else {
        str = "false";
      } 
      hashMap.put("autoOpen", str);
      hashMap.put("pk", this.q.getPackageName());
      hashMap.put("c", "0");
      hashMap.put("clickProcId", str3);
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(this.q.getClickTime());
      stringBuilder1.append("");
      hashMap.put("clickTime", stringBuilder1.toString());
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("");
      stringBuilder1.append(this.q.getAppSize());
      hashMap.put("contentLength", stringBuilder1.toString());
      hashMap.put("dlCnt", "1");
      hashMap.put("dlTime", String.valueOf(System.currentTimeMillis() - this.q.getClickTime()));
      hashMap.put("dlTunnel", "3");
      if (this.q.isTooLarge()) {
        String str4 = str2;
        hashMap.put("dlWay", str4);
        hashMap.put("exp_id", "");
        hashMap.put("exp2", "");
        hashMap.put("pkg", this.q.getPackageName());
        hashMap.put("typeProcId", str3);
        hashMap.put("url2", "");
        hashMap.put("sn", iXAdSystemUtils.getEncodedSN(this.p));
        return (HashMap)hashMap;
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
      return (HashMap)hashMap;
    } 
    String str1 = "0";
    hashMap.put("dlWay", str1);
    hashMap.put("exp_id", "");
    hashMap.put("exp2", "");
    hashMap.put("pkg", this.q.getPackageName());
    hashMap.put("typeProcId", str3);
    hashMap.put("url2", "");
    hashMap.put("sn", iXAdSystemUtils.getEncodedSN(this.p));
    return (HashMap)hashMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\vo\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */