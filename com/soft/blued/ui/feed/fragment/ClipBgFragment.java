package com.soft.blued.ui.feed.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.das.profile.PersonalProfileProtos;
import com.soft.blued.customview.ClipZoomImageView;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.ui.feed.activity.ClipBgActivity;
import com.soft.blued.ui.feed.manager.IDispatchTouchEvent;
import com.soft.blued.utils.BitmapUtils;
import com.soft.blued.utils.ImageUtils;
import com.soft.blued.view.tip.CommonAlertDialog;

public class ClipBgFragment extends BaseFragment implements View.OnTouchListener, IDispatchTouchEvent {
  private Context d;
  
  private View e;
  
  private TextView f;
  
  private TextView g;
  
  private View h;
  
  private View i;
  
  private View j;
  
  private ImageView k;
  
  private TextView l;
  
  private TextView m;
  
  private ClipZoomImageView n;
  
  private ShapeLinearLayout o;
  
  private ImageView p;
  
  private String q;
  
  private int r;
  
  private int s;
  
  private int t;
  
  private ReviewModel u = new ReviewModel(this);
  
  private int v;
  
  private void a() {
    Bundle bundle = getArguments();
    if (bundle != null) {
      this.q = bundle.getString("photo_path");
      this.r = bundle.getInt("select_photo");
      if (TextUtils.isEmpty(this.q))
        getActivity().finish(); 
    } 
    ((ClipBgActivity)getActivity()).a(this);
  }
  
  public static void a(BaseFragment paramBaseFragment, int paramInt1, String paramString, int paramInt2) {
    MemoryRequest.a().b();
    Bundle bundle = new Bundle();
    bundle.putString("photo_path", paramString);
    bundle.putInt("select_photo", paramInt1);
    ClipBgActivity.b((Fragment)paramBaseFragment, ClipBgFragment.class, bundle, paramInt2);
  }
  
  private void k() {
    int[] arrayOfInt;
    this.f = (TextView)this.e.findViewById(2131299413);
    this.g = (TextView)this.e.findViewById(2131296639);
    this.n = (ClipZoomImageView)this.e.findViewById(2131296785);
    this.o = (ShapeLinearLayout)this.e.findViewById(2131296777);
    this.p = (ImageView)this.e.findViewById(2131296780);
    this.h = this.e.findViewById(2131296783);
    this.i = this.e.findViewById(2131296778);
    this.k = (ImageView)this.e.findViewById(2131296781);
    this.l = (TextView)this.e.findViewById(2131296782);
    this.m = (TextView)this.e.findViewById(2131296779);
    this.j = this.e.findViewById(2131296784);
    this.j.setOnTouchListener(this);
    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.o.getLayoutParams();
    layoutParams.height = AppInfo.l;
    this.o.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    int i = ImageUtils.c(this.q);
    String[] arrayOfString = ImageUtils.a(this.q);
    if (this.r == 8) {
      arrayOfInt = ImageUtils.a(Integer.valueOf(arrayOfString[0]).intValue(), Integer.valueOf(arrayOfString[1]).intValue(), DensityUtils.a(this.d, 198.0F) - DensityUtils.a((Activity)getActivity()));
    } else {
      arrayOfInt = ImageUtils.a(Integer.valueOf(arrayOfInt[0]).intValue(), Integer.valueOf(arrayOfInt[1]).intValue());
    } 
    if (arrayOfInt[0] > arrayOfInt[1]) {
      int j = arrayOfInt[0];
    } else {
      int j = arrayOfInt[1];
    } 
    Bitmap bitmap = BitmapUtils.a(this.q, 1080);
    if (bitmap != null) {
      Bitmap bitmap1 = bitmap;
      try {
        this.s = bitmap.getWidth();
        bitmap1 = bitmap;
        this.t = bitmap.getHeight();
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
      this.n.setImageBitmap(BitmapUtils.a(bitmap));
    } else {
      AppMethods.d(2131757052);
      MemoryRequest.a().b();
    } 
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.f.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_EDIT_BACKGROUND_CUT_DONE_CLICK);
            try {
              float f1 = ClipBgFragment.a(this.a);
              float f2 = ClipBgFragment.b(this.a);
              if (f1 < 300.0F || f2 < 300.0F) {
                CommonAlertDialog.a(ClipBgFragment.c(this.a), null, ClipBgFragment.c(this.a).getResources().getString(2131756139), ClipBgFragment.c(this.a).getResources().getString(2131756086), new DialogInterface.OnClickListener(this) {
                      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        Intent intent = new Intent();
                        intent.putExtra("finish", false);
                        this.a.a.getActivity().setResult(0, intent);
                        this.a.a.getActivity().finish();
                      }
                    }ClipBgFragment.c(this.a).getResources().getString(2131755726), new DialogInterface.OnClickListener(this) {
                      public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                        Intent intent = new Intent();
                        intent.putExtra("finish", true);
                        this.a.a.getActivity().setResult(0, intent);
                        this.a.a.getActivity().finish();
                      }
                    }null);
                return;
              } 
              Bitmap bitmap = ClipBgFragment.d(this.a).a();
              if (bitmap == null) {
                AppMethods.d(2131757052);
                MemoryRequest.a().b();
                return;
              } 
              String str = RecyclingUtils.e("photo");
              BitmapUtils.a(bitmap, str, 100);
              if (bitmap != null && !bitmap.isRecycled())
                bitmap.recycle(); 
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
    AppInfo.n().postDelayed(this.u, 1000L);
  }
  
  private void l() {
    this.v = 1;
    this.h.setBackgroundResource(2131099781);
    this.i.setBackgroundResource(2131099781);
    this.k.setVisibility(0);
    this.l.setText(2131758463);
    this.m.setVisibility(8);
    ShapeHelper.d((ShapeHelper.ShapeView)this.o, 2131100897);
    this.p.setVisibility(4);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.6F, 1.0F);
    alphaAnimation.setFillAfter(false);
    alphaAnimation.setDuration(500L);
    this.h.setAnimation((Animation)alphaAnimation);
    this.i.setAnimation((Animation)alphaAnimation);
    this.k.setAnimation((Animation)alphaAnimation);
  }
  
  private void m() {
    this.v = 0;
    this.h.setBackgroundResource(2131100898);
    this.i.setBackgroundResource(2131100898);
    this.k.setVisibility(8);
    this.l.setText(2131758465);
    this.m.setText(2131758465);
    this.m.setVisibility(0);
    ShapeHelper.d((ShapeHelper.ShapeView)this.o, 2131100981);
    this.p.setVisibility(0);
  }
  
  public void a(MotionEvent paramMotionEvent) {
    AppInfo.n().removeCallbacks(this.u);
    AppInfo.n().postDelayed(this.u, 1000L);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493104, paramViewGroup, false);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public void onDestroy() {
    super.onDestroy();
    ((ClipBgActivity)getActivity()).b(this);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent) {
    if (paramMotionEvent.getAction() == 0 && this.v == 1)
      m(); 
    return false;
  }
  
  public class ReviewModel implements Runnable {
    public ReviewModel(ClipBgFragment this$0) {}
    
    public void run() {
      if (ClipBgFragment.e(this.a) == 0)
        ClipBgFragment.f(this.a); 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\ClipBgFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */