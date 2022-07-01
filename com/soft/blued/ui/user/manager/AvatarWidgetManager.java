package com.soft.blued.ui.user.manager;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.user.model.AvatarWidgetList;
import com.soft.blued.ui.user.model.AvatarWidgetModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AvatarWidgetManager {
  private static final AvatarWidgetManager c = new AvatarWidgetManager();
  
  public List<AvatarWidgetModel> a = new ArrayList<AvatarWidgetModel>();
  
  private boolean b;
  
  private AvatarWidgetManager() {
    if (this.a.size() == 0)
      this.a = b().getModelList(); 
  }
  
  public static AvatarWidgetManager a() {
    return c;
  }
  
  private void a(AvatarWidgetModel paramAvatarWidgetModel) {
    AvatarWidgetList avatarWidgetList = b();
    if (avatarWidgetList == null)
      return; 
    AvatarWidgetModel avatarWidgetModel = avatarWidgetList.findModel(paramAvatarWidgetModel.id);
    if (avatarWidgetModel == null) {
      avatarWidgetList.addItem(paramAvatarWidgetModel);
    } else {
      avatarWidgetModel.update(paramAvatarWidgetModel);
    } 
    BluedPreferences.an(AppInfo.f().toJson(avatarWidgetList));
  }
  
  private AvatarWidgetList b() {
    String str = BluedPreferences.dF();
    return TextUtils.isEmpty(str) ? new AvatarWidgetList() : (AvatarWidgetList)AppInfo.f().fromJson(str, AvatarWidgetList.class);
  }
  
  private void c() {
    MineHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<AvatarWidgetModel>>(this) {
          protected void a(BluedEntityA<AvatarWidgetModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              for (AvatarWidgetModel avatarWidgetModel : param1BluedEntityA.data)
                AvatarWidgetManager.a(this.a, avatarWidgetModel); 
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
        }"pendant");
  }
  
  public String a(int paramInt) {
    if (!this.b) {
      c();
      this.b = true;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("getWidgetRes id:");
    stringBuilder.append(paramInt);
    Log.v("drb", stringBuilder.toString());
    Iterator<AvatarWidgetModel> iterator = this.a.iterator();
    while (iterator.hasNext()) {
      AvatarWidgetModel avatarWidgetModel = iterator.next();
      if (avatarWidgetModel.id == paramInt) {
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append("getWidgetRes AvatarWidgetModel.theme:");
        stringBuilder1.append(avatarWidgetModel.theme);
        Log.v("drb", stringBuilder1.toString());
        return avatarWidgetModel.theme;
      } 
    } 
    return "";
  }
  
  public void b(int paramInt) {
    LiveEventBus.get("feed_avatar_widget").post(Integer.valueOf(paramInt));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\manager\AvatarWidgetManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */