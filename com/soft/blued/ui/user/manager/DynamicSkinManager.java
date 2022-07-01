package com.soft.blued.ui.user.manager;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.user.model.DynamicSkinList;
import com.soft.blued.ui.user.model.DynamicSkinModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DynamicSkinManager {
  private static final DynamicSkinManager c = new DynamicSkinManager();
  
  public List<DynamicSkinModel> a = new ArrayList<DynamicSkinModel>();
  
  private boolean b;
  
  private DynamicSkinManager() {
    if (this.a.size() == 0)
      this.a = b().getModelList(); 
  }
  
  public static DynamicSkinManager a() {
    return c;
  }
  
  private void a(DynamicSkinModel paramDynamicSkinModel) {
    DynamicSkinList dynamicSkinList = b();
    if (dynamicSkinList == null)
      return; 
    DynamicSkinModel dynamicSkinModel = dynamicSkinList.findModel(paramDynamicSkinModel.id);
    if (dynamicSkinModel == null) {
      dynamicSkinList.addItem(paramDynamicSkinModel);
    } else {
      dynamicSkinModel.update(paramDynamicSkinModel);
    } 
    BluedPreferences.am(AppInfo.f().toJson(dynamicSkinList));
  }
  
  private DynamicSkinList b() {
    String str = BluedPreferences.dE();
    return TextUtils.isEmpty(str) ? new DynamicSkinList() : (DynamicSkinList)AppInfo.f().fromJson(str, DynamicSkinList.class);
  }
  
  private void c() {
    MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<DynamicSkinModel>>(this) {
          protected void a(BluedEntityA<DynamicSkinModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              for (DynamicSkinModel dynamicSkinModel : param1BluedEntityA.data)
                DynamicSkinManager.a(this.a, dynamicSkinModel); 
              if (this.a.a.size() == 0) {
                this.a.a.addAll(param1BluedEntityA.data);
                this.a.b(-1);
              } 
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return true;
          }
          
          public void onUIFinish() {}
        }"ticktocks");
  }
  
  public String a(int paramInt) {
    if (!this.b) {
      c();
      this.b = true;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getDynamicRes id:");
    stringBuilder.append(paramInt);
    Log.v("drb", stringBuilder.toString());
    Iterator<DynamicSkinModel> iterator = this.a.iterator();
    while (iterator.hasNext()) {
      DynamicSkinModel dynamicSkinModel = iterator.next();
      if (dynamicSkinModel.id == paramInt) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("getDynamicRes dynamicSkinModel.theme:");
        stringBuilder1.append(dynamicSkinModel.theme);
        Log.v("drb", stringBuilder1.toString());
        return dynamicSkinModel.theme;
      } 
    } 
    return "";
  }
  
  public void b(int paramInt) {
    LiveEventBus.get("feed_dynamic_skin").post(Integer.valueOf(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\manager\DynamicSkinManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */