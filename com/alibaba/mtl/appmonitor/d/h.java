package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.appmonitor.f.b;
import com.alibaba.mtl.appmonitor.model.ConfigMetric;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class h extends a<JSONObject> {
  private String o;
  
  protected Map<String, i> p;
  
  public h(String paramString, int paramInt) {
    super(paramInt);
    this.o = paramString;
    this.p = new HashMap<String, i>();
  }
  
  public boolean a(int paramInt, String paramString, Map<String, String> paramMap) {
    Map<String, i> map = this.p;
    if (map != null) {
      i i = map.get(paramString);
      if (i != null)
        return i.a(paramInt, paramMap); 
    } 
    return a(paramInt);
  }
  
  public void b(JSONObject paramJSONObject) {
    a(paramJSONObject);
    try {
      JSONArray jSONArray = paramJSONObject.optJSONArray("monitorPoints");
      if (jSONArray != null) {
        int i = 0;
        label40: while (true) {
          if (i < jSONArray.length()) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            String str1 = jSONObject.optString("monitorPoint");
            String str2 = jSONObject.optString("metric_comment_detail");
            if (b.c(str1)) {
              i i2 = this.p.get(str1);
              i i1 = i2;
              if (i2 == null) {
                i1 = new i(str1, this.n);
                this.p.put(str1, i1);
              } 
              i1.b(jSONObject);
              Metric metric = MetricRepo.getRepo().getMetric(this.o, str1);
              if (metric != null)
                metric.setCommitDetailFromConfig(str2); 
              Object object = jSONObject.opt("measures");
              if (object instanceof JSONArray) {
                JSONArray jSONArray1 = (JSONArray)object;
                object = MeasureSet.create();
                int k = jSONArray1.length();
                for (int j = 0;; j++) {
                  if (j < k) {
                    JSONObject jSONObject1 = jSONArray1.getJSONObject(j);
                    if (jSONObject1 != null) {
                      String str = jSONObject1.optString("name");
                      Double double_1 = Double.valueOf(jSONObject1.optDouble("min"));
                      Double double_2 = Double.valueOf(jSONObject1.optDouble("max"));
                      if (str != null && double_1 != null && double_2 != null)
                        object.addMeasure(new Measure(str, Double.valueOf(0.0D), double_1, double_2)); 
                    } 
                  } else {
                    MetricRepo metricRepo = MetricRepo.getRepo();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("config_prefix");
                    stringBuilder3.append(this.o);
                    String str4 = stringBuilder3.toString();
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("config_prefix");
                    stringBuilder4.append(str1);
                    Metric metric1 = metricRepo.getMetric(str4, stringBuilder4.toString());
                    if (metric1 != null)
                      MetricRepo.getRepo().remove(metric1); 
                    StringBuilder stringBuilder1 = new StringBuilder();
                    stringBuilder1.append("config_prefix");
                    stringBuilder1.append(this.o);
                    String str3 = stringBuilder1.toString();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("config_prefix");
                    stringBuilder2.append(str1);
                    object = new ConfigMetric(str3, stringBuilder2.toString(), (MeasureSet)object);
                    MetricRepo.getRepo().add((Metric)object);
                    i++;
                    continue label40;
                  } 
                } 
                break;
              } 
              continue;
            } 
            continue;
          } 
          return;
        } 
      } 
      return;
    } catch (Exception exception) {
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\appmonitor\d\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */