package com.blued.android.module.live_china.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.same.Logger;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.io.File;
import java.util.ArrayList;

public class LiveShowPhotoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
  private BaseFragment a;
  
  private int b;
  
  private int c;
  
  private int d = 0;
  
  public LiveShowPhotoAdapter(BaseFragment paramBaseFragment) {
    super(R.layout.item_live_show_photo_layout, new ArrayList());
    this.a = paramBaseFragment;
    this.c = DisplayUtil.a(AppInfo.d(), 3.0F);
    this.b = (AppInfo.l - this.c * 2) / 3;
  }
  
  private Bitmap a(String paramString, int paramInt) {
    BitmapFactory.Options options = new BitmapFactory.Options();
    options.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, options);
    int i = options.outWidth / paramInt;
    paramInt = options.outHeight / paramInt;
    if (i > 1 || paramInt > 1)
      if (i > paramInt) {
        options.inSampleSize = i;
      } else {
        options.inSampleSize = paramInt;
      }  
    options.inJustDecodeBounds = false;
    try {
      return BitmapFactory.decodeFile(paramString, options);
    } catch (OutOfMemoryError outOfMemoryError) {
      MemoryRequest.a().b();
      return null;
    } 
  }
  
  public void a() {
    n().clear();
    notifyDataSetChanged();
  }
  
  public void a(int paramInt) {
    this.d = paramInt;
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, String paramString) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(R.id.iv_photo);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)imageView.getLayoutParams();
    int i = this.b;
    layoutParams.weight = i;
    layoutParams.height = i;
    imageView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ImageLoader.a((IRequestHost)this.a.w_(), paramString).a(R.drawable.icon_live_show_photo_def).a(imageView);
    imageView.setOnClickListener(new View.OnClickListener(this, paramString) {
          public void onClick(View param1View) {
            ImageFileLoader.a((IRequestHost)LiveShowPhotoAdapter.b(this.b).w_()).b(this.a).a(new ImageFileLoader.OnLoadFileListener(this) {
                  public void onUIFinish(File param2File, Exception param2Exception) {
                    if (param2File != null) {
                      if (!param2File.exists())
                        return; 
                      String str = LiveShowPhotoAdapter.b();
                      StringBuilder stringBuilder = new StringBuilder();
                      stringBuilder.append("file size = ");
                      stringBuilder.append(param2File.length());
                      Logger.d(str, new Object[] { stringBuilder.toString() });
                      Bitmap bitmap = LiveShowPhotoAdapter.a(this.a.b, param2File.getPath(), 1080);
                      int i = bitmap.getWidth();
                      int j = bitmap.getHeight();
                      if (LiveShowPhotoAdapter.a(this.a.b) == 0 || i < 300 || j < 300) {
                        Logger.d(LiveShowPhotoAdapter.c(), new Object[] { "photoType = SHOW_ALBUM ... " });
                        if (LiveShowPhotoAdapter.b(this.a.b) != null && LiveShowPhotoAdapter.b(this.a.b).getParentFragment() != null && LiveShowPhotoAdapter.b(this.a.b).getParentFragment() instanceof LiveBaseDialogFragment) {
                          LiveMakeLoverFansModel liveMakeLoverFansModel = new LiveMakeLoverFansModel();
                          liveMakeLoverFansModel.avatar = this.a.a;
                          liveMakeLoverFansModel.pic = param2File.getPath();
                          ((LiveBaseDialogFragment)LiveShowPhotoAdapter.b(this.a.b).getParentFragment()).a(liveMakeLoverFansModel);
                        } 
                        return;
                      } 
                      Logger.d(LiveShowPhotoAdapter.d(), new Object[] { "photoType = SHOW_FEED ... " });
                      LiveRoomInfo.a().a(LiveShowPhotoAdapter.b(this.a.b), this.a.a, param2File.getPath(), 100);
                      return;
                    } 
                  }
                }).a();
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\adapter\LiveShowPhotoAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */