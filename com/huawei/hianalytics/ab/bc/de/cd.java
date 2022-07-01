package com.huawei.hianalytics.ab.bc.de;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.ab.bc;
import com.huawei.hianalytics.ab.bc.cd.bc.ef;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.cd.bc.ab;
import com.huawei.hianalytics.ab.ef.ab;
import com.huawei.hianalytics.ab.ef.bc;
import java.util.HashMap;
import java.util.Map;

public class cd {
  public static ef ab() {
    ab.cd("hmsSdk", "generate UploadData EventModelHandlerBase");
    fg.ef().de();
    if (TextUtils.isEmpty(fg.ef().ab())) {
      ab.fg("hmsSdk", "event chifer is empty");
      return null;
    } 
    return new ef(fg.ef().cd());
  }
  
  public static ab ab(String paramString1, String paramString2) {
    ab ab = new ab();
    ab.ab(ab.ab().ab(paramString1, paramString2));
    return ab;
  }
  
  public static bc ab(String paramString1, String paramString2, String paramString3, String paramString4) {
    bc bc = new bc();
    bc.ab(paramString1);
    bc.bc(bc.cd());
    bc.ef(paramString2);
    bc.cd(paramString4);
    StringBuffer stringBuffer = new StringBuffer("hmshi");
    stringBuffer.append(paramString3);
    stringBuffer.append("qrt");
    bc.de(stringBuffer.toString());
    return bc;
  }
  
  public static com.huawei.hianalytics.ab.ef.cd ab(String paramString1, String paramString2, String paramString3) {
    com.huawei.hianalytics.ab.ef.cd cd1 = new com.huawei.hianalytics.ab.ef.cd();
    cd1.cd(bc.gh());
    cd1.ef(bc.ij());
    cd1.ab(paramString3);
    cd1.bc(ab.ab().bc(paramString2, paramString1));
    return cd1;
  }
  
  public static Map<String, String> bc(String paramString1, String paramString2) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("App-Id", bc.cd());
    hashMap.put("App-Ver", bc.de());
    hashMap.put("Sdk-Name", "hianalytics");
    hashMap.put("Sdk-Ver", "2.2.0.308");
    hashMap.put("Device-Type", Build.MODEL);
    hashMap.put("servicetag", paramString1);
    ab.ab("hmsSdk", "sendData RequestId : %s", new Object[] { paramString2 });
    hashMap.put("Request-Id", paramString2);
    return (Map)hashMap;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\de\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */