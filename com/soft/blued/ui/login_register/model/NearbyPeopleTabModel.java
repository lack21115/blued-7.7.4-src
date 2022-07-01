package com.soft.blued.ui.login_register.model;

import android.text.TextUtils;
import com.blued.android.core.BlueAppLocal;

public class NearbyPeopleTabModel {
  public String sort_by;
  
  private String title;
  
  private String title_en;
  
  private String title_zhcn;
  
  private String title_zhtw;
  
  public NearbyPeopleTabModel(String paramString1, String paramString2) {
    this.title = paramString1;
    this.sort_by = paramString2;
  }
  
  public String getTitle() {
    if (BlueAppLocal.d()) {
      if ("CN".equals(BlueAppLocal.c().getCountry().toUpperCase())) {
        String str;
        if (TextUtils.isEmpty(this.title_zhcn)) {
          str = this.title;
        } else {
          str = this.title_zhcn;
        } 
        this.title = str;
      } else {
        String str;
        if (TextUtils.isEmpty(this.title_zhtw)) {
          str = this.title;
        } else {
          str = this.title_zhtw;
        } 
        this.title = str;
      } 
    } else {
      String str;
      if (TextUtils.isEmpty(this.title_en)) {
        str = this.title;
      } else {
        str = this.title_en;
      } 
      this.title = str;
    } 
    return this.title;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\model\NearbyPeopleTabModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */