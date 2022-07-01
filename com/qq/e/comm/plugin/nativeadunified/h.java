package com.qq.e.comm.plugin.nativeadunified;

import com.qq.e.comm.plugin.ad.e;
import com.qq.e.comm.plugin.s.a;
import com.qq.e.comm.plugin.util.d;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class h extends a {
  private int J;
  
  private List<String> K = new ArrayList<String>();
  
  private int L;
  
  private double M;
  
  private String N;
  
  private int O;
  
  private long P;
  
  private String Q;
  
  private int R;
  
  private int S;
  
  private int T;
  
  public h(String paramString1, String paramString2, String paramString3, e parame, JSONObject paramJSONObject) {
    super(paramString1, paramString2, paramString3, parame);
    a(paramJSONObject);
  }
  
  private void a(JSONObject paramJSONObject) {
    g(paramJSONObject);
    this.J = paramJSONObject.optInt("pattern_type");
    JSONArray jSONArray = paramJSONObject.optJSONArray("img_list");
    if (jSONArray != null)
      for (int i = 0; i < jSONArray.length(); i++)
        this.K.add(jSONArray.optString(i));  
    if (this.q != null) {
      this.L = this.q.g();
      this.M = this.q.e();
      this.N = this.q.d();
      this.O = this.q.h();
      this.P = this.q.c();
    } 
    this.Q = paramJSONObject.optString("template_id");
    this.R = paramJSONObject.optInt("pic_width");
    this.S = paramJSONObject.optInt("pic_height");
    this.T = paramJSONObject.optInt("video_duration") * 1000;
  }
  
  public String a() {
    String str;
    if (l() != null) {
      str = l().b();
    } else {
      str = "";
    } 
    if (StringUtil.isEmpty(str))
      GDTLogger.i("非营销组件广告"); 
    return str;
  }
  
  public int ak() {
    return this.S;
  }
  
  public String al() {
    return this.N;
  }
  
  public int c() {
    boolean bool = ah();
    byte b = 3;
    if (bool)
      return 2; 
    if (this.J != 27 || this.K.size() != 3) {
      if (this.J == 31)
        return 4; 
      b = 1;
    } 
    return b;
  }
  
  public List<String> d() {
    return this.K;
  }
  
  public int e() {
    return this.O;
  }
  
  public long f() {
    return this.P;
  }
  
  public int g() {
    return this.L;
  }
  
  public double h() {
    return this.M;
  }
  
  public void i(int paramInt) {
    this.O = paramInt;
  }
  
  public int j() {
    return this.T;
  }
  
  public int k() {
    return this.R;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("NativeUnifiedADDataImpl{super='");
    stringBuilder.append(super.toString());
    stringBuilder.append('\'');
    stringBuilder.append(", mPatternType=");
    stringBuilder.append(this.J);
    stringBuilder.append(", mImgList=");
    stringBuilder.append(this.K);
    stringBuilder.append(", mVideoUrl='");
    stringBuilder.append(G());
    stringBuilder.append('\'');
    stringBuilder.append(", mAppScore=");
    stringBuilder.append(this.L);
    stringBuilder.append(", mAppPrice=");
    stringBuilder.append(this.M);
    stringBuilder.append(", mPkgName='");
    stringBuilder.append(this.N);
    stringBuilder.append('\'');
    stringBuilder.append(", mAppStatus=");
    stringBuilder.append(this.O);
    stringBuilder.append(", mDownLoadCount=");
    stringBuilder.append(this.P);
    stringBuilder.append(", mTemplateId='");
    stringBuilder.append(this.Q);
    stringBuilder.append('\'');
    stringBuilder.append(", mAppInfo=");
    stringBuilder.append(this.q);
    stringBuilder.append(", mAdData=");
    stringBuilder.append(this.H);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
  
  public boolean w() {
    return d.b(this.H);
  }
  
  public String x() {
    return this.Q;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\nativeadunified\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */