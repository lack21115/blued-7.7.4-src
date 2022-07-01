package com.huawei.hianalytics.ab.bc.ik.bc;

import com.huawei.hianalytics.ab.bc.cd.bc.de;
import com.huawei.hianalytics.ab.bc.fg.bc;
import com.huawei.hianalytics.ab.bc.ik.cd.ab;
import com.huawei.hianalytics.ab.bc.ik.cd.bc;
import java.util.List;
import java.util.Map;

public class ab implements ab {
  private byte[] ab;
  
  private String bc;
  
  private String cd;
  
  private String de;
  
  private String ef;
  
  private List<de> fg;
  
  public ab(byte[] paramArrayOfbyte, String paramString1, String paramString2, String paramString3, String paramString4, List<de> paramList) {
    this.ab = (byte[])paramArrayOfbyte.clone();
    this.bc = paramString1;
    this.cd = paramString2;
    this.ef = paramString3;
    this.de = paramString4;
    this.fg = paramList;
  }
  
  private bc ab(Map<String, String> paramMap) {
    return com.huawei.hianalytics.ab.bc.fg.ab.ab(this.bc, this.ab, paramMap);
  }
  
  private Map<String, String> ab() {
    return com.huawei.hianalytics.ab.de.ab.bc(this.cd, this.ef, this.de);
  }
  
  private void bc() {
    de de = new de(this.fg, this.cd, this.de, this.ef);
    bc.bc().ab(de);
  }
  
  public void run() {
    com.huawei.hianalytics.ab.bc.ef.ab.cd("hmsSdk", "send data running");
    int i = ab(ab()).ab();
    if (i != 200) {
      bc();
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:");
    stringBuilder.append(this.de);
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", stringBuilder.toString(), new Object[] { this.ef, this.cd, Integer.valueOf(i) });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\ik\bc\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */