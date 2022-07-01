package com.soft.blued.ui.home.manager;

import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.ui.welcome.model.SplashExtraEntity;
import com.soft.blued.ui.welcome.observer.ADDownloadObserver;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.io.File;

public class WelcomeADManager {
  private static final String a = WelcomeADManager.class.getSimpleName();
  
  private static WelcomeADManager b;
  
  private SplashEntity c;
  
  private SplashExtraEntity d;
  
  private int e = -1;
  
  private String f = "";
  
  private boolean g = false;
  
  private boolean h = false;
  
  private BluedUIHttpResponse i = new BluedUIHttpResponse<BluedEntity<SplashEntity, SplashExtraEntity>>(this) {
      public void onUIUpdate(BluedEntity<SplashEntity, SplashExtraEntity> param1BluedEntity) {
        if (param1BluedEntity != null) {
          try {
            if (param1BluedEntity.data != null && param1BluedEntity.data.size() > 0) {
              Logger.a("splash_data", param1BluedEntity);
              WelcomeADManager.a(this.a, param1BluedEntity.data.get(0));
              SplashEntity.ShowEntity showEntity2 = (WelcomeADManager.a(this.a)).today;
              SplashEntity.ShowEntity showEntity1 = (WelcomeADManager.a(this.a)).tomorrow;
              WelcomeADManager.a(this.a, (SplashExtraEntity)param1BluedEntity.extra);
              ADDownloadObserver.a().d();
              String str1 = (WelcomeADManager.b(this.a)).IMGURL;
              BluedPreferences.D((WelcomeADManager.b(this.a)).ID);
              BluedPreferences.a((WelcomeADManager.b(this.a)).RECALL);
              String str3 = "";
              if (showEntity2 != null) {
                if ("3".equalsIgnoreCase(showEntity2.adms_type) || "4".equalsIgnoreCase(showEntity2.adms_type)) {
                  WelcomeADManager.a(this.a, 1);
                  ADDownloadObserver.a().c();
                } else if (!StringUtils.e(showEntity2.image)) {
                  WelcomeADManager.a(this.a, 1);
                  WelcomeADManager welcomeADManager = this.a;
                  StringBuilder stringBuilder2 = new StringBuilder();
                  if (StringUtils.e(str1)) {
                    str = "";
                  } else {
                    str = str1;
                  } 
                  stringBuilder2.append(str);
                  stringBuilder2.append(showEntity2.image);
                  WelcomeADManager.a(welcomeADManager, stringBuilder2.toString());
                  String str = WelcomeADManager.j();
                  StringBuilder stringBuilder1 = new StringBuilder();
                  stringBuilder1.append("start download image : ");
                  stringBuilder1.append(WelcomeADManager.c(this.a));
                  Logger.c(str, new Object[] { "welcomeadljx manager", stringBuilder1.toString() });
                  ImageFileLoader.a(null).a(WelcomeADManager.c(this.a)).a(new ImageFileLoader.OnLoadFileListener(this) {
                        public void onUIFinish(File param2File, Exception param2Exception) {
                          if (param2File != null && param2File.exists()) {
                            Logger.c(WelcomeADManager.j(), new Object[] { "welcomeadljx manager", "download image complete" });
                            ADDownloadObserver.a().b();
                            return;
                          } 
                          Logger.c(WelcomeADManager.j(), new Object[] { "welcomeadljx manager", "download image failed" });
                          ADDownloadObserver.a().c();
                        }
                      }).a();
                } else {
                  Logger.c(WelcomeADManager.j(), new Object[] { "welcomeadljx manager http finish", "today.image==null" });
                  WelcomeADManager.a(this.a, 0);
                  ADDownloadObserver.a().c();
                } 
              } else {
                Logger.c(WelcomeADManager.j(), new Object[] { "welcomeadljx manager http finish", "today==null" });
                WelcomeADManager.a(this.a, 0);
                ADDownloadObserver.a().c();
              } 
              String str2 = str3;
              if (showEntity1 != null) {
                str2 = str3;
                if (!StringUtils.e(showEntity1.image)) {
                  StringBuilder stringBuilder = new StringBuilder();
                  str2 = str1;
                  if (StringUtils.e(str1))
                    str2 = ""; 
                  stringBuilder.append(str2);
                  stringBuilder.append(showEntity1.image);
                  str2 = stringBuilder.toString();
                } 
              } 
              if (!StringUtils.e(str2)) {
                ImageFileLoader.a(null).a(str2).a();
                return;
              } 
              return;
            } 
            Logger.c(WelcomeADManager.j(), new Object[] { "welcomeadljx manager http finish", "parseData==null" });
            WelcomeADManager.a(this.a, 0);
            ADDownloadObserver.a().c();
            return;
          } catch (Exception exception) {
            WelcomeADManager.a(this.a, 0);
            ADDownloadObserver.a().c();
          } 
          return;
        } 
        Logger.c(WelcomeADManager.j(), new Object[] { "welcomeadljx manager http finish", "parseData==null" });
        WelcomeADManager.a(this.a, 0);
        ADDownloadObserver.a().c();
      }
    };
  
  public static WelcomeADManager a() {
    if (b == null)
      b = new WelcomeADManager(); 
    return b;
  }
  
  public void a(boolean paramBoolean) {
    this.h = paramBoolean;
  }
  
  public boolean b() {
    return this.g;
  }
  
  public boolean c() {
    return this.h;
  }
  
  public void d() {
    this.c = null;
    this.d = null;
    this.e = -1;
    this.f = "";
    this.g = false;
  }
  
  public SplashEntity e() {
    SplashEntity splashEntity2 = this.c;
    SplashEntity splashEntity1 = splashEntity2;
    if (splashEntity2 == null)
      splashEntity1 = new SplashEntity(); 
    return splashEntity1;
  }
  
  public SplashExtraEntity f() {
    return this.d;
  }
  
  public String g() {
    return this.f;
  }
  
  public int h() {
    return this.e;
  }
  
  public void i() {
    if (!this.g) {
      this.g = true;
      String str = BluedPreferences.aU();
      if (UserInfo.a().j()) {
        if (str != null && !StringUtils.e(str)) {
          Logger.c(a, new Object[] { "welcomeadljx manager", "start http" });
          LoginRegisterHttpUtils.a(AppInfo.d(), str, this.i, null);
          return;
        } 
        Logger.c(a, new Object[] { "welcomeadljx manager", "start http" });
        LoginRegisterHttpUtils.a(AppInfo.d(), "", this.i, null);
      } 
    } 
  }
  
  public static interface HAS_AD_STATUS {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\home\manager\WelcomeADManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */