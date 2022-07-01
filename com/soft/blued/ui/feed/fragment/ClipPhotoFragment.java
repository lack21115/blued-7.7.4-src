package com.soft.blued.ui.feed.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.soft.blued.customview.ClipImageLayout;
import com.soft.blued.utils.BitmapUtils;
import com.soft.blued.utils.ImageUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class ClipPhotoFragment extends BaseFragment {
  private Context d;
  
  private View e;
  
  private TextView f;
  
  private View g;
  
  private TextView h;
  
  private ImageView i;
  
  private ImageView j;
  
  private ClipImageLayout k;
  
  private String l;
  
  private String m;
  
  private int n;
  
  private int o;
  
  private int p;
  
  private void a() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.m = bundle.getString("select_http_url");
      this.l = bundle.getString("photo_path");
      this.n = bundle.getInt("select_photo");
      if (TextUtils.isEmpty(this.l))
        getActivity().finish(); 
    } 
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, String paramString, int paramInt2) {
    MemoryRequest.a().b();
    Bundle bundle = new Bundle();
    bundle.putString("photo_path", paramString);
    bundle.putInt("select_photo", paramInt1);
    TerminalActivity.a((Fragment)paramBaseFragment, ClipPhotoFragment.class, bundle, paramInt2);
  }
  
  private void k() {
    int[] arrayOfInt;
    this.g = this.e.findViewById(2131300273);
    this.i = (ImageView)this.g.findViewById(2131296863);
    this.h = (TextView)this.g.findViewById(2131296857);
    this.j = (ImageView)this.g.findViewById(2131296867);
    this.f = (TextView)this.e.findViewById(2131296955);
    this.j.setVisibility(8);
    this.f.setVisibility(0);
    this.k = (ClipImageLayout)this.e.findViewById(2131297406);
    if (this.n == 8) {
      int j = (AppInfo.m - DensityUtils.a(this.d, 198.0F)) / 2;
      this.k.setVerticalPadding(j);
    } 
    if (this.n == 9) {
      int j = (AppInfo.m - AppInfo.l) / 2;
      this.k.setVerticalPadding(j);
    } 
    int i = ImageUtils.c(this.l);
    String[] arrayOfString = ImageUtils.a(this.l);
    if (this.n == 8) {
      arrayOfInt = ImageUtils.a(Integer.valueOf(arrayOfString[0]).intValue(), Integer.valueOf(arrayOfString[1]).intValue(), DensityUtils.a(this.d, 198.0F) - DensityUtils.a((Activity)getActivity()));
    } else {
      arrayOfInt = ImageUtils.a(Integer.valueOf(arrayOfInt[0]).intValue(), Integer.valueOf(arrayOfInt[1]).intValue());
    } 
    if (arrayOfInt[0] > arrayOfInt[1]) {
      int j = arrayOfInt[0];
    } else {
      int j = arrayOfInt[1];
    } 
    Bitmap bitmap = BitmapUtils.a(this.l, 1080);
    if (bitmap != null) {
      Bitmap bitmap1 = bitmap;
      try {
        this.o = bitmap.getWidth();
        bitmap1 = bitmap;
        this.p = bitmap.getHeight();
        bitmap1 = bitmap;
        Bitmap bitmap3 = Bitmap.createScaledBitmap(bitmap, arrayOfInt[0], arrayOfInt[1], true);
        Bitmap bitmap2 = bitmap;
        if (bitmap3 != bitmap) {
          bitmap2 = bitmap;
          if (bitmap3 != null) {
            bitmap1 = bitmap;
            bitmap.recycle();
            bitmap2 = bitmap3;
          } 
        } 
        if (i != 0) {
          bitmap1 = bitmap2;
          bitmap = BitmapUtils.a(i, bitmap2);
        } else {
          bitmap = bitmap2;
        } 
        if (bitmap != bitmap2 && bitmap != null) {
          bitmap1 = bitmap2;
          bitmap2.recycle();
        } else {
          bitmap = bitmap2;
        } 
      } catch (OutOfMemoryError outOfMemoryError) {
        MemoryRequest.a().b();
        bitmap = bitmap1;
      } 
      this.k.setImageBitmap(bitmap);
    } else {
      AppMethods.d(2131757052);
      MemoryRequest.a().b();
    } 
    this.i.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (this.a.getParentFragment() != null && this.a.getParentFragment() instanceof LiveBaseDialogFragment) {
              ((LiveBaseDialogFragment)this.a.getParentFragment()).a(null);
              return;
            } 
            this.a.getActivity().finish();
          }
        });
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            try {
              float f1 = ClipPhotoFragment.a(this.a);
              float f2 = ClipPhotoFragment.b(this.a);
              if (f1 < 300.0F || f2 < 300.0F) {
                CommonAlertDialog.a(ClipPhotoFragment.c(this.a), null, ClipPhotoFragment.c(this.a).getResources().getString(2131756139), ClipPhotoFragment.c(this.a).getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        if (this.a.a.getParentFragment() != null && this.a.a.getParentFragment() instanceof LiveBaseDialogFragment) {
                          ((LiveBaseDialogFragment)this.a.a.getParentFragment()).a(null);
                          return;
                        } 
                        Intent intent = new Intent();
                        intent.putExtra("finish", false);
                        this.a.a.getActivity().setResult(0, intent);
                        this.a.a.getActivity().finish();
                      }
                    }ClipPhotoFragment.c(this.a).getResources().getString(2131755726), new DialogInterface.OnClickListener(this) {
                      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        if (this.a.a.getParentFragment() != null && this.a.a.getParentFragment() instanceof LiveBaseDialogFragment) {
                          ((LiveBaseDialogFragment)this.a.a.getParentFragment()).a(null);
                          return;
                        } 
                        Intent intent = new Intent();
                        intent.putExtra("finish", true);
                        this.a.a.getActivity().setResult(0, intent);
                        this.a.a.getActivity().finish();
                      }
                    }null);
                return;
              } 
              Bitmap bitmap = ClipPhotoFragment.d(this.a).a();
              if (bitmap == null) {
                AppMethods.d(2131757052);
                MemoryRequest.a().b();
                return;
              } 
              String str = RecyclingUtils.e("photo");
              BitmapUtils.a(bitmap, str, 100);
              if (bitmap != null && !bitmap.isRecycled())
                bitmap.recycle(); 
              if (this.a.getParentFragment() != null && this.a.getParentFragment() instanceof LiveBaseDialogFragment) {
                LiveMakeLoverFansModel liveMakeLoverFansModel = new LiveMakeLoverFansModel();
                liveMakeLoverFansModel.avatar = ClipPhotoFragment.e(this.a);
                liveMakeLoverFansModel.pic = str;
                ((LiveBaseDialogFragment)this.a.getParentFragment()).a(liveMakeLoverFansModel);
                return;
              } 
              Intent intent = new Intent();
              intent.putExtra("photo_path", str);
              this.a.getActivity().setResult(-1, intent);
              this.a.getActivity().finish();
              return;
            } catch (Exception exception) {
              return;
            } 
          }
        });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493105, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\ClipPhotoFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */