package com.soft.blued.ui.user.manager;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.GlideApp;
import com.blued.android.core.image.GlideRequest;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageFileWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.DensityUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.user.model.VipBubbleModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.BitmapUtils;
import com.soft.blued.utils.NinePatchBitmapFactory;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class VipBubbleManager {
  private static volatile VipBubbleManager k;
  
  private List<VipBubbleModel> a = new ArrayList<VipBubbleModel>();
  
  private VipBubbleModel b;
  
  private Bitmap c;
  
  private Bitmap d;
  
  private Bitmap e;
  
  private Bitmap f;
  
  private Bitmap g;
  
  private Bitmap h;
  
  private VipBubbleModel i = new VipBubbleModel();
  
  private VipBubbleModel j = new VipBubbleModel();
  
  private VipBubbleManager() {
    b();
  }
  
  private Drawable a(Bitmap paramBitmap) {
    int i = paramBitmap.getWidth() / 2;
    int j = paramBitmap.getHeight() / 2;
    return (Drawable)NinePatchBitmapFactory.a(AppInfo.d().getResources(), paramBitmap, c(i), c(j), null);
  }
  
  private Drawable a(Bitmap paramBitmap1, Bitmap paramBitmap2) {
    int i = paramBitmap1.getWidth() / 2;
    int j = paramBitmap1.getHeight() / 2;
    NinePatchDrawable ninePatchDrawable1 = NinePatchBitmapFactory.a(AppInfo.d().getResources(), paramBitmap1, c(i), c(j), null);
    i = paramBitmap2.getWidth() / 2;
    j = paramBitmap2.getHeight() / 2;
    NinePatchDrawable ninePatchDrawable2 = NinePatchBitmapFactory.a(AppInfo.d().getResources(), paramBitmap2, c(i), c(j), null);
    StateListDrawable stateListDrawable = new StateListDrawable();
    stateListDrawable.addState(new int[] { 16842919 }, (Drawable)ninePatchDrawable2);
    stateListDrawable.addState(new int[] { 16842910 }, (Drawable)ninePatchDrawable1);
    return (Drawable)stateListDrawable;
  }
  
  public static VipBubbleManager a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/user/manager/VipBubbleManager.k : Lcom/soft/blued/ui/user/manager/VipBubbleManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/user/manager/VipBubbleManager
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/user/manager/VipBubbleManager.k : Lcom/soft/blued/ui/user/manager/VipBubbleManager;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/user/manager/VipBubbleManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/user/manager/VipBubbleManager.k : Lcom/soft/blued/ui/user/manager/VipBubbleManager;
    //   25: ldc com/soft/blued/ui/user/manager/VipBubbleManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/user/manager/VipBubbleManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/user/manager/VipBubbleManager.k : Lcom/soft/blued/ui/user/manager/VipBubbleManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private List<NinePatchBitmapFactory.Range> c(int paramInt) {
    ArrayList<NinePatchBitmapFactory.Range> arrayList = new ArrayList();
    NinePatchBitmapFactory.Range range = new NinePatchBitmapFactory.Range();
    range.a = paramInt - 1;
    range.b = paramInt + 1;
    arrayList.add(range);
    return arrayList;
  }
  
  private void c(VipBubbleModel paramVipBubbleModel, int paramInt, View... paramVarArgs) {
    if (paramVarArgs != null) {
      if (paramVarArgs.length == 0)
        return; 
      int k = (int)(DensityUtils.a(AppInfo.d(), 12.0F) * (AppInfo.d().getResources().getDisplayMetrics()).density / 2.0F);
      int j = 0;
      int i = 0;
      if (paramInt == 0 && paramVipBubbleModel != null && paramVipBubbleModel.mPressBitmap != null && paramVipBubbleModel.mNormalBitmap != null && paramVipBubbleModel.mPressBitmap.get() != null && paramVipBubbleModel.mNormalBitmap.get() != null) {
        j = paramVarArgs.length;
        for (paramInt = i; paramInt < j; paramInt++) {
          View view = paramVarArgs[paramInt];
          if (view == null)
            return; 
          view.setPadding(DensityUtils.a(view.getContext(), 25.0F), k, DensityUtils.a(view.getContext(), 25.0F), k);
          view.setBackground(a(paramVipBubbleModel.mNormalBitmap.get(), paramVipBubbleModel.mPressBitmap.get()));
        } 
      } else if (paramInt == 1 && paramVipBubbleModel.mVoiceBitmap != null && paramVipBubbleModel.mVoiceBitmap.get() != null) {
        i = paramVarArgs.length;
        for (paramInt = j; paramInt < i; paramInt++) {
          View view = paramVarArgs[paramInt];
          if (view == null)
            return; 
          view.setPadding(DensityUtils.a(view.getContext(), 20.0F), k, DensityUtils.a(view.getContext(), 10.0F), k);
          view.setBackground(a(paramVipBubbleModel.mVoiceBitmap.get()));
        } 
      } 
    } 
  }
  
  private void f() {
    VipBubbleModel vipBubbleModel = this.b;
    if (vipBubbleModel == null)
      return; 
    b(vipBubbleModel, 1, new View[0]);
    a(this.b, 1, new View[0]);
    AppInfo.n().postDelayed(new Runnable(this) {
          public void run() {
            LiveEventBus.get("refresh_im_bubble").post(null);
          }
        },  300L);
  }
  
  public void a(int paramInt) {
    if (paramInt == 0) {
      this.b = null;
      LiveEventBus.get("refresh_im_bubble").post(null);
      return;
    } 
    for (VipBubbleModel vipBubbleModel : this.a) {
      if (vipBubbleModel.id == paramInt) {
        this.b = vipBubbleModel.copy();
        f();
        break;
      } 
    } 
  }
  
  public void a(int paramInt1, int paramInt2, View... paramVarArgs) {
    if (paramInt1 == 0) {
      if (paramInt2 == 0) {
        if (this.c != null) {
          if (this.d == null)
            return; 
          if (this.i.mNormalBitmap == null || this.i.mNormalBitmap.get() == null)
            this.i.mNormalBitmap = new SoftReference<Bitmap>(this.c); 
          if (this.i.mPressBitmap == null || this.i.mPressBitmap.get() == null)
            this.i.mPressBitmap = new SoftReference<Bitmap>(this.d); 
          c(this.i, paramInt1, paramVarArgs);
          return;
        } 
        return;
      } 
      if (this.e != null) {
        if (this.f == null)
          return; 
        if (this.j.mNormalBitmap == null || this.j.mNormalBitmap.get() == null)
          this.j.mNormalBitmap = new SoftReference<Bitmap>(this.e); 
        if (this.j.mPressBitmap == null || this.j.mPressBitmap.get() == null)
          this.j.mPressBitmap = new SoftReference<Bitmap>(this.f); 
        c(this.j, paramInt1, paramVarArgs);
        return;
      } 
      return;
    } 
    if (paramInt1 == 1) {
      if (paramInt2 == 0) {
        if (this.g == null)
          return; 
        if (this.i.mVoiceBitmap == null || this.i.mVoiceBitmap.get() == null)
          this.i.mVoiceBitmap = new SoftReference<Bitmap>(this.g); 
        c(this.i, 1, paramVarArgs);
        return;
      } 
      if (this.h == null)
        return; 
      if (this.j.mVoiceBitmap == null || this.j.mVoiceBitmap.get() == null)
        this.j.mVoiceBitmap = new SoftReference<Bitmap>(this.h); 
      c(this.j, 1, paramVarArgs);
    } 
  }
  
  public void a(RefreshListener paramRefreshListener, IRequestHost paramIRequestHost) {
    UserHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<VipBubbleModel>>(this, paramIRequestHost, paramRefreshListener) {
          protected void a(BluedEntityA<VipBubbleModel> param1BluedEntityA) {
            if (param1BluedEntityA.hasData()) {
              VipBubbleManager.d(this.b).clear();
              VipBubbleManager.d(this.b).addAll(param1BluedEntityA.data);
              for (VipBubbleModel vipBubbleModel : VipBubbleManager.d(this.b)) {
                if (vipBubbleModel.selected == 1) {
                  VipBubbleManager.a(this.b, vipBubbleModel.copy());
                  VipBubbleManager.e(this.b);
                } 
              } 
            } 
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (param1Boolean) {
              VipBubbleManager.RefreshListener refreshListener = this.a;
              if (refreshListener != null)
                refreshListener.a(); 
            } 
          }
        }"message", paramIRequestHost);
  }
  
  public void a(VipBubbleModel paramVipBubbleModel, int paramInt, View... paramVarArgs) {
    if (paramVipBubbleModel == null)
      return; 
    if (paramVipBubbleModel.mVoiceBitmap == null || paramVipBubbleModel.mVoiceBitmap.get() == null) {
      String str;
      ImageFileWrapper imageFileWrapper = ImageFileLoader.a(null);
      if (paramInt == 0) {
        str = paramVipBubbleModel.voice_left;
      } else {
        str = paramVipBubbleModel.voice_right;
      } 
      imageFileWrapper.a(str).a(new ImageFileLoader.OnLoadFileListener(this, paramVipBubbleModel, paramVarArgs) {
            public void onUIFinish(File param1File, Exception param1Exception) {
              if (param1File == null)
                return; 
              this.a.mVoiceBitmap = new SoftReference<Bitmap>(BitmapFactory.decodeFile(param1File.getAbsolutePath()));
              if (this.a.mVoiceBitmap != null && this.a.mVoiceBitmap.get() != null)
                VipBubbleManager.a(this.c, this.a, 1, this.b); 
            }
          }).a();
      return;
    } 
    c(paramVipBubbleModel, 1, paramVarArgs);
  }
  
  public VipBubbleModel b(int paramInt) {
    if (this.a.size() == 0) {
      a((RefreshListener)null, (IRequestHost)null);
      return null;
    } 
    for (VipBubbleModel vipBubbleModel : this.a) {
      if (vipBubbleModel.id == paramInt)
        return vipBubbleModel; 
    } 
    return null;
  }
  
  public void b() {
    VipBubbleModel vipBubbleModel = this.i;
    vipBubbleModel.mNormalBitmap = null;
    vipBubbleModel.mPressBitmap = null;
    vipBubbleModel.mVoiceBitmap = null;
    ThreadManager.a().a(new ThreadExecutor(this, "loadDefaultBubble") {
          public void execute() {
            if (VipBubbleManager.a(this.a) == null)
              VipBubbleManager.a(this.a, BitmapFactory.decodeResource(AppInfo.d().getResources(), 2131234472)); 
            if (VipBubbleManager.b(this.a) == null)
              VipBubbleManager.b(this.a, BitmapFactory.decodeResource(AppInfo.d().getResources(), 2131231183)); 
            if (VipBubbleManager.c(this.a) == null)
              VipBubbleManager.c(this.a, BitmapFactory.decodeResource(AppInfo.d().getResources(), 2131231184)); 
            VipBubbleManager.d(this.a, BitmapUtils.a(BluedSkinUtils.b(AppInfo.d(), 2131231181)));
            VipBubbleManager.e(this.a, BitmapUtils.a(BluedSkinUtils.b(AppInfo.d(), 2131231182)));
            VipBubbleManager.f(this.a, BitmapUtils.a(BluedSkinUtils.b(AppInfo.d(), 2131234468)));
          }
        });
  }
  
  public void b(VipBubbleModel paramVipBubbleModel, int paramInt, View... paramVarArgs) {
    if (paramVipBubbleModel == null)
      return; 
    if (paramVipBubbleModel.mNormalBitmap == null || paramVipBubbleModel.mNormalBitmap.get() == null || paramVipBubbleModel.mPressBitmap == null || paramVipBubbleModel.mPressBitmap.get() == null) {
      ThreadManager.a().a(new ThreadExecutor(this, "loadBubble", paramVipBubbleModel, paramInt, paramVarArgs) {
            public void execute() {
              try {
                String str;
                VipBubbleModel vipBubbleModel = this.a;
                GlideRequest glideRequest = GlideApp.b(AppInfo.d()).a();
                if (this.b == 0) {
                  str = this.a.bubble_left;
                } else {
                  str = this.a.bubble_right;
                } 
                vipBubbleModel.mNormalBitmap = new SoftReference(glideRequest.a(str).f().get());
                vipBubbleModel = this.a;
                glideRequest = GlideApp.b(AppInfo.d()).a();
                if (this.b == 0) {
                  str = this.a.bubble_left_click;
                } else {
                  str = this.a.bubble_right_click;
                } 
                vipBubbleModel.mPressBitmap = new SoftReference(glideRequest.a(str).f().get());
                if (this.a.mNormalBitmap != null && this.a.mPressBitmap != null && this.a.mNormalBitmap.get() != null && this.a.mPressBitmap.get() != null) {
                  AppInfo.n().post(new Runnable(this) {
                        public void run() {
                          VipBubbleManager.a(this.a.d, this.a.a, 0, this.a.c);
                        }
                      });
                  return;
                } 
              } catch (ExecutionException executionException) {
                executionException.printStackTrace();
              } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
                return;
              } 
            }
          });
      return;
    } 
    c(paramVipBubbleModel, 0, paramVarArgs);
  }
  
  public VipBubbleModel c() {
    VipBubbleModel vipBubbleModel = this.b;
    return (vipBubbleModel != null && vipBubbleModel.vip_status > (UserInfo.a().i()).vip_grade) ? null : this.b;
  }
  
  public List<VipBubbleModel> d() {
    return this.a;
  }
  
  public void e() {
    this.b = null;
    this.a.clear();
  }
  
  public static interface RefreshListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\manager\VipBubbleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */