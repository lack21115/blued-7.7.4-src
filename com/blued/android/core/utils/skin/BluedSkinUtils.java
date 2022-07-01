package com.blued.android.core.utils.skin;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatDelegate;
import com.blued.android.core.utils.skin.listener.BluedSkinLoaderListener;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import skin.support.SkinCompatManager;
import skin.support.app.SkinAppCompatViewInflater;
import skin.support.app.SkinCardViewInflater;
import skin.support.app.SkinLayoutInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.content.res.SkinCompatResources;
import skin.support.content.res.SkinCompatUserThemeManager;
import skin.support.design.app.SkinMaterialViewInflater;
import skin.support.observe.SkinObserver;

public class BluedSkinUtils {
  public static int a(Context paramContext, int paramInt) {
    return a() ? SkinCompatResources.c(paramContext, paramInt) : paramContext.getResources().getColor(paramInt);
  }
  
  public static void a(Application paramApplication) {
    SkinCompatManager.a(paramApplication).a((SkinLayoutInflater)new SkinAppCompatViewInflater()).a((SkinLayoutInflater)new SkinMaterialViewInflater()).a((SkinLayoutInflater)new SkinConstraintViewInflater()).a((SkinLayoutInflater)new SkinCardViewInflater()).b(true).c(true).a(true).j();
    AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
  }
  
  public static void a(BluedSkinObserver paramBluedSkinObserver) {
    SkinCompatManager.a().a((SkinObserver)paramBluedSkinObserver);
  }
  
  public static void a(String paramString, BluedSkinLoaderListener paramBluedSkinLoaderListener) {
    SkinCompatManager.a().a(paramString, new SkinCompatManager.SkinLoaderListener(paramBluedSkinLoaderListener) {
          public void a() {
            BluedSkinLoaderListener bluedSkinLoaderListener = this.a;
            if (bluedSkinLoaderListener != null)
              bluedSkinLoaderListener.a(); 
          }
          
          public void a(String param1String) {
            BluedSkinLoaderListener bluedSkinLoaderListener = this.a;
            if (bluedSkinLoaderListener != null)
              bluedSkinLoaderListener.a(param1String); 
          }
          
          public void b() {
            BluedSkinLoaderListener bluedSkinLoaderListener = this.a;
            if (bluedSkinLoaderListener != null)
              bluedSkinLoaderListener.b(); 
          }
        },  0);
  }
  
  public static boolean a() {
    return !(SkinCompatManager.a() == null);
  }
  
  public static boolean a(Activity paramActivity) {
    return (((paramActivity.getResources().getConfiguration()).uiMode & 0x30) == 32);
  }
  
  public static Drawable b(Context paramContext, int paramInt) {
    return a() ? SkinCompatResources.e(paramContext, paramInt) : paramContext.getResources().getDrawable(paramInt);
  }
  
  public static void b() {
    SkinCompatResources.a().b();
    SkinCompatManager.a().g();
    SkinCompatUserThemeManager.b().c();
    SkinCompatUserThemeManager.b().d();
  }
  
  public static void b(BluedSkinObserver paramBluedSkinObserver) {
    SkinCompatManager.a().b((SkinObserver)paramBluedSkinObserver);
  }
  
  public static boolean c() {
    return SkinCompatResources.a().d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\cor\\utils\skin\BluedSkinUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */