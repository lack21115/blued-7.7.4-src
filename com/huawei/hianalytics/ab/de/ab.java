package com.huawei.hianalytics.ab.de;

import android.util.Pair;
import com.huawei.hianalytics.ab.ab.bc;
import com.huawei.hianalytics.ab.ab.cd;
import com.huawei.hianalytics.ab.bc.cd.bc.bc;
import com.huawei.hianalytics.ab.bc.cd.bc.cd;
import com.huawei.hianalytics.ab.bc.cd.bc.de;
import com.huawei.hianalytics.ab.bc.cd.bc.ef;
import com.huawei.hianalytics.ab.bc.de.cd;
import com.huawei.hianalytics.ab.bc.de.fg;
import com.huawei.hianalytics.ab.cd.ab.bc;
import com.huawei.hianalytics.ab.ef.bc;
import com.huawei.hianalytics.ab.ef.cd;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

public class ab extends cd {
  public static ef ab(List<de> paramList, String paramString1, String paramString2, String paramString3, String paramString4) {
    com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "generate UploadData");
    ef ef = cd.ab();
    if (ef == null)
      return null; 
    ef.ab((bc)ab(fg.ef().ab(), paramString1, paramString2, paramString3));
    ef.ab(ab(paramString1, paramString2));
    ef.ab((cd)ab(paramString2, paramString1, paramString4));
    ef.ab(cd.de(paramString1, paramString2));
    ef.ab(paramList);
    return ef;
  }
  
  protected static com.huawei.hianalytics.ab.ef.ab ab(String paramString1, String paramString2) {
    com.huawei.hianalytics.ab.ef.ab ab1 = cd.ab(paramString1, paramString2);
    com.huawei.hianalytics.ab.cd.ab.ab ab2 = com.huawei.hianalytics.ab.cd.bc.ab.ab().cd(paramString1, paramString2);
    ab1.gh(com.huawei.hianalytics.ab.cd.bc.ab.ab().ab(cd.b(paramString1, paramString2)));
    ab1.fg(cd.lm(paramString1, paramString2));
    ab1.cd(com.huawei.hianalytics.ab.cd.bc.ab.ab().fg(paramString1, paramString2));
    bc bc = ab2.ab();
    int i = ab.ab[bc.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3)
          return ab1; 
        ab1.ef(ab2.bc());
        return ab1;
      } 
      ab1.bc(ab2.bc());
      return ab1;
    } 
    ab1.de(ab2.bc());
    return ab1;
  }
  
  protected static bc ab(String paramString1, String paramString2, String paramString3, String paramString4) {
    bc bc = cd.ab(paramString1, paramString2, paramString3, paramString4);
    paramString2 = com.huawei.hianalytics.ab.cd.bc.ab.ab().ab(cd.b(paramString2, paramString3));
    long l = System.currentTimeMillis();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(bc.cd());
    stringBuilder.append(paramString2);
    stringBuilder.append(l);
    paramString2 = SHA.a(stringBuilder.toString());
    bc.fg(String.valueOf(l));
    bc.gh(paramString2);
    return bc;
  }
  
  protected static cd ab(String paramString1, String paramString2, String paramString3) {
    cd cd1 = cd.ab(paramString1, paramString2, paramString3);
    Pair pair = com.huawei.hianalytics.ab.cd.bc.ab.ab().ef(paramString2, paramString1);
    cd1.fg((String)pair.first);
    cd1.gh((String)pair.second);
    cd1.hi(com.huawei.hianalytics.ab.bc.bc.ab.bc());
    cd1.de(com.huawei.hianalytics.ab.cd.bc.ab.ab().de(paramString2, paramString1));
    return cd1;
  }
  
  public static Map<String, String> bc(String paramString1, String paramString2, String paramString3) {
    Map<String, String> map1 = cd.bc(paramString1, paramString3);
    Map<? extends String, ? extends String> map = cd.fg(paramString1, paramString2);
    if (map == null)
      return map1; 
    map1.putAll(map);
    return map1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\de\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */