package com.baidu.mobads.utils;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobads.openad.e.e;

class x extends e.b {
  x(t paramt, TelephonyManager paramTelephonyManager) {}
  
  public Object a() {
    try {
      h h = XAdSDKFoundationFacade.getInstance().getCommonUtils();
      String str = this.a.getSimOperatorName();
      StringBuilder stringBuilder = new StringBuilder();
      if (!TextUtils.isEmpty(str)) {
        stringBuilder.append(str);
      } else {
        str = this.a.getNetworkOperatorName();
        if (!TextUtils.isEmpty(str)) {
          stringBuilder.append(str);
        } else {
          return t.e();
        } 
      } 
      stringBuilder.append("_");
      str = this.a.getSimOperator();
      if (!TextUtils.isEmpty(str))
        stringBuilder.append(str); 
    } finally {
      Exception exception = null;
    } 
    return t.e();
  }
  
  public void a(Object paramObject) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobad\\utils\x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */