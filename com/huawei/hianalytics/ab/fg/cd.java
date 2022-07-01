package com.huawei.hianalytics.ab.fg;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.cd.ab.ab;
import com.huawei.hianalytics.ab.bc.cd.ab.ef;
import com.huawei.hianalytics.ab.bc.ef.ab;
import com.huawei.hianalytics.ab.bc.hi.ab;
import java.util.LinkedHashMap;

public class cd {
  private String ab;
  
  public ef bc;
  
  public cd(String paramString) {
    this.ab = paramString;
    this.bc = new ef(paramString);
    ab.cd().ab(this.ab, this.bc);
  }
  
  private com.huawei.hianalytics.ab.bc.cd.ab.cd bc(int paramInt) {
    return (paramInt != 0) ? ((paramInt != 1) ? ((paramInt != 2) ? ((paramInt != 3) ? null : this.bc.ab()) : this.bc.de()) : this.bc.bc()) : this.bc.cd();
  }
  
  private boolean cd(int paramInt) {
    if (paramInt == 2) {
      if (!"_default_config_tag".equals(this.ab)) {
        String str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        ab.ef("hmsSdk", str);
        return false;
      } 
      return true;
    } 
    com.huawei.hianalytics.ab.bc.cd.ab.cd cd1 = bc(paramInt);
    if (cd1 == null || TextUtils.isEmpty(cd1.de())) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("verifyURL(): URL check failed. type: ");
      stringBuilder.append(paramInt);
      String str = stringBuilder.toString();
      ab.ef("hmsSdk", str);
      return false;
    } 
    return true;
  }
  
  public void ab(int paramInt) {
    ab.ab("hmsSdk", "HiAnalyticsInstance.onReport() is execute.TAG: %s,TYPE: %d", new Object[] { this.ab, Integer.valueOf(paramInt) });
    bc.ab().ab(this.ab, paramInt);
  }
  
  public void ab(int paramInt, com.huawei.hianalytics.ab.bc.cd.ab.cd paramcd) {
    if (paramcd == null) {
      ab.bc("hmsSdk", "HiAnalyticsInstanceImpl.refresh(). Parameter config is null.TAG : %s , TYPE : %d", new Object[] { this.ab, Integer.valueOf(paramInt) });
      paramcd = null;
    } else {
      paramcd = new com.huawei.hianalytics.ab.bc.cd.ab.cd(paramcd);
    } 
    ab.ab("hmsSdk", "HiAnalyticsInstanceImpl.refresh() is executed.TAG : %s , TYPE : %d", new Object[] { this.ab, Integer.valueOf(paramInt) });
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            ab.fg("hmsSdk", "refresh(): HiAnalyticsType can only be OPERATION ,MAINTAIN or DIFF_PRIVACY.");
            return;
          } 
          ab(paramcd);
          return;
        } 
        de(paramcd);
        return;
      } 
      bc(paramcd);
      return;
    } 
    cd(paramcd);
    ab.ab().ab(this.ab);
  }
  
  public void ab(int paramInt, String paramString) {
    StringBuilder stringBuilder1;
    String str;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("HiAnalyticsInstanceImpl.setStrOAID() is executed.TAG : ");
    stringBuilder2.append(this.ab);
    ab.cd("hmsSdk", stringBuilder2.toString());
    com.huawei.hianalytics.ab.bc.cd.ab.cd cd1 = bc(paramInt);
    if (cd1 == null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("setOAID(): No related config found.type : ");
      stringBuilder1.append(paramInt);
      ab.ef("hmsSdk", stringBuilder1.toString());
      return;
    } 
    stringBuilder2 = stringBuilder1;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab("oaid", (String)stringBuilder1, 4096))
      str = ""; 
    cd1.ef(str);
  }
  
  public void ab(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap) {
    StringBuilder stringBuilder;
    ab.ab("hmsSdk", "HiAnalyticsInstance.onEvent(int type, String eventId, Map<String, String> mapValue) is execute.TAG: %s,TYPE: %d", new Object[] { this.ab, Integer.valueOf(paramInt) });
    if (com.huawei.hianalytics.ab.bc.kl.cd.ab(paramString) || !cd(paramInt)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("onEvent() parameters check fail. Nothing will be recorded.TAG: ");
      stringBuilder.append(this.ab);
      stringBuilder.append(", TYPE: ");
      stringBuilder.append(paramInt);
      ab.ef("hmsSdk", stringBuilder.toString());
      return;
    } 
    LinkedHashMap<String, String> linkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onEvent() parameter mapValue will be cleared.TAG: ");
      stringBuilder1.append(this.ab);
      stringBuilder1.append(", TYPE: ");
      stringBuilder1.append(paramInt);
      ab.ef("hmsSdk", stringBuilder1.toString());
      linkedHashMap = null;
    } 
    bc.ab().ab(this.ab, paramInt, (String)stringBuilder, linkedHashMap);
  }
  
  public void ab(int paramInt, boolean paramBoolean) {
    String str;
    ab.ab("hmsSdk", "HiAnalyticsInstanceImpl.setOAIDTrackingFlag() is executed.TAG : %s , TYPE : %d", new Object[] { this.ab, Integer.valueOf(paramInt) });
    com.huawei.hianalytics.ab.bc.cd.ab.cd cd1 = bc(paramInt);
    if (cd1 == null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("setOAIDTrackingFlag(): No related config found.type : ");
      stringBuilder.append(paramInt);
      ab.ef("hmsSdk", stringBuilder.toString());
      return;
    } 
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    } 
    cd1.gh(str);
  }
  
  public void ab(Context paramContext) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("HiAnalyticsInstance.onPause() is execute.TAG: ");
    stringBuilder2.append(this.ab);
    ab.cd("hmsSdk", stringBuilder2.toString());
    if (paramContext == null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("context is null in onPause! Nothing will be recorded.TAG: ");
      stringBuilder1.append(this.ab);
      ab.fg("hmsSdk", stringBuilder1.toString());
      return;
    } 
    if (!cd(0)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onResume() URL check fail. Nothing will be recorded.TAG: ");
      stringBuilder1.append(this.ab);
      ab.fg("hmsSdk", stringBuilder1.toString());
      return;
    } 
    bc.ab().ab(this.ab, (Context)stringBuilder1);
  }
  
  public void ab(Context paramContext, int paramInt) {
    ab.ab("hmsSdk", "HiAnalyticsInstance.onReport(Context context) is execute.TAG: %s,TYPE: %d", new Object[] { this.ab, Integer.valueOf(paramInt) });
    if (paramContext == null) {
      ab.ef("hmsSdk", "context is null in onReport!");
      return;
    } 
    bc.ab().ab(this.ab, paramInt);
  }
  
  public void ab(Context paramContext, String paramString1, String paramString2) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("HiAnalyticsInstance.onEvent(eventId, mapValue) is execute.TAG : ");
    stringBuilder2.append(this.ab);
    ab.cd("hmsSdk", stringBuilder2.toString());
    if (paramContext == null) {
      ab.ef("hmsSdk", "context is null in onevent ");
      return;
    } 
    if (com.huawei.hianalytics.ab.bc.kl.cd.ab(paramString1) || !cd(0)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onEvent() parameters check fail. Nothing will be recorded.TAG: ");
      stringBuilder1.append(this.ab);
      ab.ef("hmsSdk", stringBuilder1.toString());
      return;
    } 
    String str = paramString2;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab("value", paramString2, 65536)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onEvent() parameter VALUE is overlong, content will be cleared.TAG: ");
      stringBuilder.append(this.ab);
      ab.ef("hmsSdk", stringBuilder.toString());
      str = "";
    } 
    bc.ab().ab(this.ab, (Context)stringBuilder1, paramString1, str);
  }
  
  public void ab(Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("HiAnalyticsInstance.onPause(context,map) is execute.TAG: ");
    stringBuilder2.append(this.ab);
    ab.cd("hmsSdk", stringBuilder2.toString());
    if (paramContext == null) {
      ab.fg("hmsSdk", "context is null in onPause! Nothing will be recorded.");
      return;
    } 
    if (!cd(0)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onResume() URL check fail. Nothing will be recorded.TAG: ");
      stringBuilder1.append(this.ab);
      ab.fg("hmsSdk", stringBuilder1.toString());
      return;
    } 
    LinkedHashMap<String, String> linkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onPause() parameter mapValue will be cleared.TAG: ");
      stringBuilder.append(this.ab);
      ab.fg("hmsSdk", stringBuilder.toString());
      linkedHashMap = null;
    } 
    bc.ab().ab(this.ab, (Context)stringBuilder1, linkedHashMap);
  }
  
  public void ab(com.huawei.hianalytics.ab.bc.cd.ab.cd paramcd) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HiAnalyticsInstanceImpl.setDiffConf() is executed.TAG : ");
    stringBuilder.append(this.ab);
    ab.cd("hmsSdk", stringBuilder.toString());
    if (paramcd == null) {
      ab.ef("hmsSdk", "HiAnalyticsInstanceImpl.setDiffConf(): config for diffPrivacy is null!");
      this.bc.ab(null);
      return;
    } 
    this.bc.ab(paramcd);
  }
  
  public void ab(String paramString, LinkedHashMap<String, String> paramLinkedHashMap) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("HiAnalyticsInstance.onPause(viewName,map) is execute.TAG: ");
    stringBuilder2.append(this.ab);
    ab.cd("hmsSdk", stringBuilder2.toString());
    if (!cd(0)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onPause() URL check fail. Nothing will be recorded.TAG: ");
      stringBuilder1.append(this.ab);
      ab.fg("hmsSdk", stringBuilder1.toString());
      return;
    } 
    if (TextUtils.isEmpty(stringBuilder1) || !com.huawei.hianalytics.ab.bc.kl.cd.ab("viewName", (String)stringBuilder1, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}")) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onPause() parameter viewName verify failed. Nothing will be recorded.TAG: ");
      stringBuilder1.append(this.ab);
      ab.fg("hmsSdk", stringBuilder1.toString());
      return;
    } 
    LinkedHashMap<String, String> linkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onPause() parameter mapValue will be cleared.TAG: ");
      stringBuilder.append(this.ab);
      ab.fg("hmsSdk", stringBuilder.toString());
      linkedHashMap = null;
    } 
    bc.ab().ab(this.ab, (String)stringBuilder1, linkedHashMap);
  }
  
  public void bc(int paramInt, String paramString) {
    StringBuilder stringBuilder1;
    String str;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("HiAnalyticsInstanceImpl.setUpid() is executed.TAG : ");
    stringBuilder2.append(this.ab);
    ab.cd("hmsSdk", stringBuilder2.toString());
    com.huawei.hianalytics.ab.bc.cd.ab.cd cd1 = bc(paramInt);
    if (cd1 == null) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("setUpid(): No related config found.type : ");
      stringBuilder1.append(paramInt);
      ab.ef("hmsSdk", stringBuilder1.toString());
      return;
    } 
    stringBuilder2 = stringBuilder1;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab("upid", (String)stringBuilder1, 4096))
      str = ""; 
    cd1.fg(str);
  }
  
  public void bc(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap) {
    StringBuilder stringBuilder;
    ab.ab("hmsSdk", "HiAnalyticsInstance.onStreamEvent() is execute.TAG: %s,TYPE: %d", new Object[] { this.ab, Integer.valueOf(paramInt) });
    if (com.huawei.hianalytics.ab.bc.kl.cd.ab(paramString) || !cd(paramInt)) {
      stringBuilder = new StringBuilder();
      stringBuilder.append("onStreamEvent() parameters check fail. Nothing will be recorded.TAG: ");
      stringBuilder.append(this.ab);
      stringBuilder.append(", TYPE: ");
      stringBuilder.append(paramInt);
      ab.ef("hmsSdk", stringBuilder.toString());
      return;
    } 
    LinkedHashMap<String, String> linkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap)) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onStreamEvent() parameter mapValue will be cleared.TAG: ");
      stringBuilder1.append(this.ab);
      stringBuilder1.append(", TYPE: ");
      stringBuilder1.append(paramInt);
      ab.ef("hmsSdk", stringBuilder1.toString());
      linkedHashMap = null;
    } 
    bc.ab().bc(this.ab, paramInt, (String)stringBuilder, linkedHashMap);
  }
  
  public void bc(Context paramContext) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("HiAnalyticsInstance.onResume() is execute.TAG: ");
    stringBuilder2.append(this.ab);
    ab.cd("hmsSdk", stringBuilder2.toString());
    if (paramContext == null) {
      ab.fg("hmsSdk", "context is null in onResume! Nothing will be recorded.");
      return;
    } 
    if (!cd(0)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onResume() URL check fail. Nothing will be recorded.TAG: ");
      stringBuilder1.append(this.ab);
      ab.fg("hmsSdk", stringBuilder1.toString());
      return;
    } 
    bc.ab().bc(this.ab, (Context)stringBuilder1);
  }
  
  public void bc(Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("HiAnalyticsInstance.onResume(context,map) is execute.TAG: ");
    stringBuilder2.append(this.ab);
    ab.cd("hmsSdk", stringBuilder2.toString());
    if (paramContext == null) {
      ab.fg("hmsSdk", "context is null in onResume! Nothing will be recorded.");
      return;
    } 
    if (!cd(0)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onResume() URL check fail. Nothing will be recorded.TAG: ");
      stringBuilder1.append(this.ab);
      ab.fg("hmsSdk", stringBuilder1.toString());
      return;
    } 
    LinkedHashMap<String, String> linkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onResume() parameter mapValue will be cleared.TAG: ");
      stringBuilder.append(this.ab);
      ab.fg("hmsSdk", stringBuilder.toString());
      linkedHashMap = null;
    } 
    bc.ab().bc(this.ab, (Context)stringBuilder1, linkedHashMap);
  }
  
  public void bc(com.huawei.hianalytics.ab.bc.cd.ab.cd paramcd) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : ");
    stringBuilder.append(this.ab);
    ab.cd("hmsSdk", stringBuilder.toString());
    if (paramcd == null) {
      ab.ef("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
      this.bc.bc(null);
      return;
    } 
    this.bc.bc(paramcd);
  }
  
  public void bc(String paramString, LinkedHashMap<String, String> paramLinkedHashMap) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append("HiAnalyticsInstance.onResume(viewname,map) is execute.TAG: ");
    stringBuilder2.append(this.ab);
    ab.cd("hmsSdk", stringBuilder2.toString());
    if (!cd(0)) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onResume() URL check fail. Nothing will be recorded.TAG: ");
      stringBuilder1.append(this.ab);
      ab.fg("hmsSdk", stringBuilder1.toString());
      return;
    } 
    if (TextUtils.isEmpty(stringBuilder1) || !com.huawei.hianalytics.ab.bc.kl.cd.ab("viewName", (String)stringBuilder1, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}")) {
      stringBuilder1 = new StringBuilder();
      stringBuilder1.append("onResume() parameter viewName verify failed. Nothing will be recorded.TAG: ");
      stringBuilder1.append(this.ab);
      ab.fg("hmsSdk", stringBuilder1.toString());
      return;
    } 
    LinkedHashMap<String, String> linkedHashMap = paramLinkedHashMap;
    if (!com.huawei.hianalytics.ab.bc.kl.cd.ab(paramLinkedHashMap)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("onResume() parameter mapValue will be cleared.TAG: ");
      stringBuilder.append(this.ab);
      ab.fg("hmsSdk", stringBuilder.toString());
      linkedHashMap = null;
    } 
    bc.ab().bc(this.ab, (String)stringBuilder1, linkedHashMap);
  }
  
  public void cd(com.huawei.hianalytics.ab.bc.cd.ab.cd paramcd) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: ");
    stringBuilder.append(this.ab);
    ab.cd("hmsSdk", stringBuilder.toString());
    if (paramcd == null) {
      this.bc.cd(null);
      ab.ef("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
      return;
    } 
    this.bc.cd(paramcd);
  }
  
  public void de(com.huawei.hianalytics.ab.bc.cd.ab.cd paramcd) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("HiAnalyticsInstanceImpl.setPreInstallConf() is executed.TAG: ");
    stringBuilder.append(this.ab);
    ab.cd("hmsSdk", stringBuilder.toString());
    if (paramcd == null) {
      ab.fg("hmsSdk", "HiAnalyticsInstanceImpl.setPreInstallConf(): config for PRE-INSTALL is null!");
      this.bc.de(null);
      return;
    } 
    this.bc.de(paramcd);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\fg\cd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */