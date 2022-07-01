package com.soft.blued.ui.photo.fragment;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.activity.keyboardpage.KeyBoardFragment;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.module.live_china.view.ViewDragHelperLayout;
import com.blued.android.module.player.media.observer.EventCallBackListener;
import com.blued.android.module.player.media.observer.EventCallbackObserver;
import com.soft.blued.ui.feed.fragment.ShowAlbumActivity;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.user.model.AlbumForDataTrans;
import com.soft.blued.utils.ActivityChangeAnimationUtils;
import com.soft.blued.utils.BitmapUtils;
import com.soft.blued.utils.TypefaceUtils;
import java.io.File;
import java.io.Serializable;

public class BasePhotoFragment extends BaseFragment implements EventCallBackListener {
  public boolean d = true;
  
  public boolean e;
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, LoadOptions paramLoadOptions) {
    Bundle bundle = new Bundle();
    bundle.putInt("photo_index", paramInt1);
    bundle.putInt("show_photo", paramInt2);
    bundle.putSerializable("photo_options", (Serializable)paramLoadOptions);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    ShowAlbumActivity.b(paramContext, ShowPhotoRemoveFragment.class, bundle);
    ActivityChangeAnimationUtils.g((Activity)paramContext);
  }
  
  public static void a(Context paramContext, AlbumForDataTrans paramAlbumForDataTrans, int paramInt1, LoadOptions paramLoadOptions, int paramInt2, String paramString1, String paramString2) {
    Bundle bundle = new Bundle();
    bundle.putInt("photo_index", paramInt1);
    ShowAlbumFragment.f = paramAlbumForDataTrans;
    bundle.putSerializable("photo_options", (Serializable)paramLoadOptions);
    bundle.putInt("show_photo", paramInt2);
    bundle.putString("WATER_MASK_NAME", paramString1);
    bundle.putString("TARGET_UID", paramString2);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    ShowAlbumActivity.b(paramContext, ShowAlbumFragment.class, bundle);
    ActivityChangeAnimationUtils.g((Activity)paramContext);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, long paramLong) {
    Bundle bundle = new Bundle();
    bundle.putString("video_preview_url", paramString1);
    bundle.putString("video_url", paramString2);
    bundle.putInt("video_width", paramInt2);
    bundle.putInt("video_height", paramInt3);
    bundle.putLong("video_size", paramLong);
    bundle.putInt("show_photo", paramInt1);
    bundle.putString("key_feed_id", paramString3);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    ShowAlbumActivity.b(paramContext, ShowVideoFragment.class, bundle);
    ActivityChangeAnimationUtils.g((Activity)paramContext);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean, String paramString4) {
    Bundle bundle = new Bundle();
    bundle.putString("video_preview_url", paramString1);
    bundle.putString("video_url", paramString2);
    bundle.putInt("video_width", paramInt2);
    bundle.putInt("video_height", paramInt3);
    bundle.putLong("video_size", paramLong);
    bundle.putInt("show_photo", paramInt1);
    bundle.putString("key_feed_id", paramString3);
    bundle.putBoolean("support_save", paramBoolean);
    bundle.putString("target_uid", paramString4);
    TerminalActivity.a(bundle);
    TerminalActivity.b(bundle);
    ShowAlbumActivity.b(paramContext, ShowVideoFragment.class, bundle);
    ActivityChangeAnimationUtils.g((Activity)paramContext);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong) {
    a(paramContext, paramString1, paramString2, paramString3, paramInt, 0, 0, paramLong);
  }
  
  public static void a(Context paramContext, String[] paramArrayOfString, int paramInt1, int paramInt2, LoadOptions paramLoadOptions) {
    if (paramArrayOfString != null) {
      if (paramArrayOfString.length <= 0)
        return; 
      Bundle bundle = new Bundle();
      bundle.putInt("photo_index", paramInt1);
      bundle.putStringArray("photo_datas", paramArrayOfString);
      bundle.putInt("show_photo", paramInt2);
      bundle.putSerializable("photo_options", (Serializable)paramLoadOptions);
      TerminalActivity.a(bundle);
      TerminalActivity.b(bundle);
      ShowAlbumActivity.b(paramContext, ShowPhotoFragment.class, bundle);
      ActivityChangeAnimationUtils.g((Activity)paramContext);
    } 
  }
  
  public static void a(Context paramContext, String[] paramArrayOfString, int paramInt1, int paramInt2, LoadOptions paramLoadOptions, String paramString1, View paramView, String paramString2) {
    if (paramArrayOfString != null) {
      if (paramArrayOfString.length <= 0)
        return; 
      if (KeyBoardFragment.aP_())
        return; 
      Bundle bundle = new Bundle();
      bundle.putInt("photo_index", paramInt1);
      bundle.putStringArray("photo_datas", paramArrayOfString);
      bundle.putInt("show_photo", paramInt2);
      bundle.putSerializable("photo_options", (Serializable)paramLoadOptions);
      bundle.putString("WATER_MASK_NAME", paramString1);
      TerminalActivity.a(bundle);
      TerminalActivity.b(bundle);
      ShowAlbumActivity.b(paramContext, ShowPhotoFragment.class, bundle);
      ActivityChangeAnimationUtils.g((Activity)paramContext);
    } 
  }
  
  public static void a(Context paramContext, String[] paramArrayOfString, int paramInt1, int paramInt2, String paramString, int paramInt3) {
    if (paramArrayOfString != null) {
      if (paramArrayOfString.length <= 0)
        return; 
      Bundle bundle = new Bundle();
      bundle.putInt("photo_index", paramInt1);
      bundle.putStringArray("photo_datas", paramArrayOfString);
      bundle.putInt("show_photo", paramInt2);
      bundle.putString("UID", paramString);
      bundle.putInt("avatar_widget", paramInt3);
      TerminalActivity.a(bundle);
      TerminalActivity.b(bundle);
      ShowAlbumActivity.b(paramContext, ShowPhotoFragment.class, bundle);
      ActivityChangeAnimationUtils.g((Activity)paramContext);
    } 
  }
  
  public static void a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt1, int paramInt2, String paramString, LoadOptions paramLoadOptions) {
    if (paramArrayOfString1 != null) {
      if (paramArrayOfString1.length <= 0)
        return; 
      Bundle bundle = new Bundle();
      bundle.putInt("photo_index", paramInt1);
      bundle.putStringArray("photo_datas", paramArrayOfString1);
      bundle.putStringArray("photo_pids", paramArrayOfString2);
      bundle.putInt("show_photo", paramInt2);
      bundle.putString("WATER_MASK_NAME", paramString);
      bundle.putSerializable("photo_options", (Serializable)paramLoadOptions);
      TerminalActivity.a(bundle);
      TerminalActivity.b(bundle);
      ShowAlbumActivity.b(paramContext, ShowPhotoFragment.class, bundle);
      ActivityChangeAnimationUtils.g((Activity)paramContext);
    } 
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3) {}
  
  public void a(View paramView) {}
  
  public void a(View paramView1, View paramView2, boolean paramBoolean) {
    if (this.e)
      return; 
    paramView1.setVisibility(8);
    paramView2.setVisibility(8);
    Animation animation = AnimationUtils.loadAnimation((Context)getActivity(), 2130772062);
    animation.setDuration(200L);
    paramView1.startAnimation(animation);
    if (paramBoolean) {
      Animation animation1 = AnimationUtils.loadAnimation((Context)getActivity(), 2130772062);
      animation1.setDuration(200L);
      paramView2.startAnimation(animation1);
    } 
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            BasePhotoFragment basePhotoFragment = this.a;
            basePhotoFragment.e = false;
            basePhotoFragment.d = false;
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            this.a.e = true;
          }
        });
  }
  
  protected void a(File paramFile, String paramString) {
    Bitmap bitmap;
    if (!ChatHelperV4.a(paramFile)) {
      double d;
      OutOfMemoryError outOfMemoryError2 = null;
      try {
        bitmap = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
      } catch (OutOfMemoryError outOfMemoryError1) {
        MemoryRequest.a().b();
        outOfMemoryError1 = outOfMemoryError2;
      } 
      if (outOfMemoryError1 == null)
        return; 
      int i = Math.min(outOfMemoryError1.getWidth(), outOfMemoryError1.getHeight());
      if (i > 540) {
        d = (i / 540);
      } else {
        d = 1.0D;
      } 
      View view = TypefaceUtils.a((Context)getActivity(), paramString, d);
      Bitmap bitmap1 = BitmapUtils.a((Context)getActivity(), view);
      if (bitmap1 != null)
        bitmap = BitmapUtils.a((Context)getActivity(), (Bitmap)outOfMemoryError1, bitmap1, (int)(Math.max(d, 1.0D) * 10.0D), (int)(Math.max(d, 1.0D) * 10.0D)); 
      if (bitmap == null)
        return; 
      ImageUtils.a(bitmap);
      return;
    } 
    if ("mounted".equals(Environment.getExternalStorageState()))
      ThreadManager.a().a(new ThreadExecutor(this, "saveGif", (File)bitmap) {
            public void execute() {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES));
              stringBuilder.append(File.separator);
              stringBuilder.append("blued/");
              stringBuilder.append(System.currentTimeMillis());
              stringBuilder.append(".gif");
              String str = stringBuilder.toString();
              FileUtils.a(this.a.getAbsolutePath(), str);
              this.b.a(new Runnable(this, str) {
                    public void run() {
                      AppUtils.a(AppInfo.d(), this.a, true);
                    }
                  });
            }
          }); 
  }
  
  public void a(Object... paramVarArgs) {}
  
  public void aR_() {}
  
  public void aS_() {}
  
  public void aT_() {
    l();
  }
  
  public void b(View paramView) {}
  
  public void b(View paramView1, View paramView2, boolean paramBoolean) {
    if (this.e)
      return; 
    paramView1.setVisibility(0);
    Animation animation = AnimationUtils.loadAnimation((Context)getActivity(), 2130772061);
    animation.setDuration(200L);
    paramView1.startAnimation(animation);
    if (paramBoolean) {
      paramView2.setVisibility(0);
      paramView2.startAnimation(animation);
    } 
    animation.setAnimationListener(new Animation.AnimationListener(this) {
          public void onAnimationEnd(Animation param1Animation) {
            BasePhotoFragment basePhotoFragment = this.a;
            basePhotoFragment.e = false;
            basePhotoFragment.d = true;
          }
          
          public void onAnimationRepeat(Animation param1Animation) {}
          
          public void onAnimationStart(Animation param1Animation) {
            this.a.e = true;
          }
        });
  }
  
  public void b(Object... paramVarArgs) {}
  
  public void d() {}
  
  public void f_(int paramInt) {}
  
  public void k() {
    l();
  }
  
  public void l() {
    getActivity().finish();
    ActivityChangeAnimationUtils.h((Activity)getActivity());
  }
  
  public void m() {
    getActivity().finish();
    ActivityChangeAnimationUtils.e((Activity)getActivity());
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    EventCallbackObserver.a().a(this);
  }
  
  public void onDestroy() {
    super.onDestroy();
    EventCallbackObserver.a().b(this);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\photo\fragment\BasePhotoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */