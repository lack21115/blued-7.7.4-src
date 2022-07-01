package com.baidu.mobads.vo;

import android.view.View;
import com.baidu.mobads.AdSettings;
import com.baidu.mobads.interfaces.IXAdConstants4PDK;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import org.json.JSONObject;

public class b implements IXAdProdInfo {
  private d a;
  
  private IXAdConstants4PDK.SlotType b;
  
  private JSONObject c;
  
  private View d;
  
  private boolean e = false;
  
  public b(d paramd, IXAdConstants4PDK.SlotType paramSlotType) {
    this.a = paramd;
    this.b = paramSlotType;
  }
  
  public void a(JSONObject paramJSONObject) {
    this.c = paramJSONObject;
  }
  
  public void a(boolean paramBoolean) {
    this.e = paramBoolean;
  }
  
  public String getAdPlacementId() {
    return this.a.getApid();
  }
  
  public String getAdRequestURL() {
    return this.a.b();
  }
  
  public int getApt() {
    return this.a.getApt();
  }
  
  public JSONObject getAttribute() {
    JSONObject jSONObject = this.c;
    return (jSONObject != null) ? jSONObject : AdSettings.getAttr();
  }
  
  public View getClickView() {
    return this.d;
  }
  
  public int getInstanceCount() {
    return 0;
  }
  
  public String getProdType() {
    return this.a.getProd();
  }
  
  public int getRequestAdHeight() {
    return this.a.getH();
  }
  
  public int getRequestAdWidth() {
    return this.a.getW();
  }
  
  public IXAdConstants4PDK.SlotType getType() {
    return this.b;
  }
  
  public boolean isAutoPlay() {
    return this.e;
  }
  
  public boolean isMsspTagAvailable() {
    return false;
  }
  
  public void setClickView(View paramView) {
    this.d = paramView;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\vo\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */