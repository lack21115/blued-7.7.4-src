package com.huawei.hianalytics.ab.bc.ik.bc;

import android.content.Context;
import android.util.Pair;
import com.huawei.hianalytics.ab.ab.bc;
import com.huawei.hianalytics.ab.bc.cd.bc.de;
import com.huawei.hianalytics.ab.bc.de.ab;
import com.huawei.hianalytics.ab.bc.de.de;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.gh.bc;
import com.huawei.hianalytics.ab.bc.ij.ab;
import com.huawei.hianalytics.ab.bc.ik.cd.ab;
import com.huawei.hianalytics.ab.bc.kl.bc;
import com.huawei.hianalytics.ab.bc.kl.ef;
import java.util.List;
import java.util.Map;

public class cd implements ab {
  private Context ab = bc.fg();
  
  private String bc;
  
  private String cd;
  
  private String de;
  
  public cd(String paramString1, String paramString2, String paramString3) {
    this.bc = paramString1;
    this.cd = paramString2;
    this.de = paramString3;
  }
  
  private void ab(String paramString, List<de> paramList) {
    Pair pair = ef.ab(paramString);
    (new ab(paramList, (String)pair.first, (String)pair.second, this.de)).ab();
  }
  
  public void run() {
    ab.cd("hmsSdk", "eventReportTask is running");
    boolean bool = bc.ab(this.ab);
    if (bool) {
      ab.cd("hmsSdk", "workKey is refresh,begin report all data");
      this.cd = "alltype";
    } 
    try {
      String str;
      Map map = de.ab(this.ab, this.bc, this.cd);
      int i = map.size();
      if (i == 0) {
        ab.bc("hmsSdk", "no have events to report: tag:%s : type:%s", new Object[] { this.bc, this.cd });
        if ("alltype".equals(this.cd)) {
          ab.ab(this.ab, "stat_v2_1", new String[0]);
          ab.ab(this.ab, "cached_v2_1", new String[0]);
          return;
        } 
        str = ef.ab(this.bc, this.cd);
        ab.ab(this.ab, "stat_v2_1", new String[] { str });
        ab.ab(this.ab, "cached_v2_1", new String[] { str });
        return;
      } 
      for (Map.Entry entry : str.entrySet())
        ab((String)entry.getKey(), (List<de>)entry.getValue()); 
      if ("alltype".equals(this.cd)) {
        ab.ab(this.ab, "stat_v2_1", new String[0]);
        ab.ab(this.ab, "cached_v2_1", new String[0]);
      } else {
        str = ef.ab(this.bc, this.cd);
        ab.ab(this.ab, "stat_v2_1", new String[] { str });
        ab.ab(this.ab, "cached_v2_1", new String[] { str });
      } 
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("readEventRecords handData IllegalArgumentException:");
      stringBuilder.append(illegalArgumentException.getMessage());
      ab.ef("hmsSdk", stringBuilder.toString());
      if ("alltype".equals(this.cd)) {
        ab.ab(this.ab, "stat_v2_1", new String[0]);
        ab.ab(this.ab, "cached_v2_1", new String[0]);
      } else {
        String str = ef.ab(this.bc, this.cd);
        ab.ab(this.ab, "stat_v2_1", new String[] { str });
        ab.ab(this.ab, "cached_v2_1", new String[] { str });
      } 
    } catch (Exception exception) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("readEventRecords handData Exception:");
      stringBuilder.append(exception.getMessage());
      ab.ef("hmsSdk", stringBuilder.toString());
      if ("alltype".equals(this.cd)) {
        ab.ab(this.ab, "stat_v2_1", new String[0]);
        ab.ab(this.ab, "cached_v2_1", new String[0]);
      } else {
        String str = ef.ab(this.bc, this.cd);
        ab.ab(this.ab, "stat_v2_1", new String[] { str });
        ab.ab(this.ab, "cached_v2_1", new String[] { str });
      } 
    } finally {
      Exception exception;
    } 
    if (bool) {
      ab.cd("hmsSdk", "refresh local key");
      bc.de().bc();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\ik\bc\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */