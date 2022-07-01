package com.soft.blued.ui.user.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.BinaryHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.soft.blued.customview.ActionSheet;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.AreaUtils;
import com.soft.blued.utils.BitmapUtils;
import com.soft.blued.utils.TypefaceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.io.File;

public class UserQrFragment extends BaseFragment {
  private Context d;
  
  private View e;
  
  private ImageView f;
  
  private ImageView g;
  
  private Dialog h;
  
  private RelativeLayout i;
  
  private Bitmap a(View paramView) {
    Bitmap bitmap = Bitmap.createBitmap(paramView.getWidth(), paramView.getHeight(), Bitmap.Config.ARGB_8888);
    paramView.draw(new Canvas(bitmap));
    return bitmap;
  }
  
  private void a() {
    this.h = DialogUtils.a(this.d);
    this.i = (RelativeLayout)this.e.findViewById(2131299808);
    this.f = (ImageView)this.e.findViewById(2131299350);
    this.g = (ImageView)this.e.findViewById(2131297581);
    this.f.setOnLongClickListener(new View.OnLongClickListener(this) {
          public boolean onLongClick(View param1View) {
            UserQrFragment.a(this.a);
            return false;
          }
        });
    CommonTopTitleNoTrans commonTopTitleNoTrans = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    commonTopTitleNoTrans.a();
    commonTopTitleNoTrans.setCenterText(getString(2131758498));
    commonTopTitleNoTrans.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    ImageView imageView = (ImageView)this.e.findViewById(2131297362);
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(0, UserInfo.a().i().getAvatar())).a(2131234356).c().a(imageView);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(getActivity().getFilesDir());
    stringBuilder.append("/");
    stringBuilder.append(UserInfo.a().i().getUid());
    stringBuilder.append(".bmp");
    String str = stringBuilder.toString();
    if ((new File(str)).exists())
      this.f.setImageBitmap(BitmapUtils.a(str)); 
    TextView textView = (TextView)this.e.findViewById(2131299554);
    textView.setText(UserInfo.a().i().getName());
    UserBasicModel userBasicModel = new UserBasicModel();
    userBasicModel.vip_grade = (UserInfo.a().i()).vip_grade;
    userBasicModel.is_vip_annual = (UserInfo.a().i()).is_vip_annual;
    userBasicModel.is_hide_vip_look = (BluedConfig.b().k()).is_hide_vip_look;
    UserRelationshipUtils.a(this.d, textView, userBasicModel);
    UserRelationshipUtils.a(this.g, userBasicModel);
    textView = (TextView)this.e.findViewById(2131299553);
    textView.setText(AreaUtils.a(UserInfo.a().i().getCity_settled(), BlueAppLocal.c()));
    userBasicModel.is_hide_city_settled = (UserInfo.a().i()).is_hide_city_settled;
    TypefaceUtils.b(this.d, textView, userBasicModel.is_hide_city_settled, 1);
  }
  
  private void k() {
    String str = getActivity().getString(2131758503);
    FragmentActivity fragmentActivity = getActivity();
    ActionSheet.ActionSheetListener actionSheetListener = new ActionSheet.ActionSheetListener(this) {
        public void a(ActionSheet param1ActionSheet, int param1Int) {
          if (param1Int != 0)
            return; 
          UserQrFragment userQrFragment = this.a;
          ImageUtils.a(UserQrFragment.a(userQrFragment, (View)UserQrFragment.b(userQrFragment)));
        }
        
        public void a(ActionSheet param1ActionSheet, boolean param1Boolean) {}
      };
    CommonShowBottomWindow.a(fragmentActivity, new String[] { str }, actionSheetListener);
  }
  
  private void l() {
    UserHttpUtils.a(this.d, new BinaryHttpResponseHandler(this, true) {
          public void a(Throwable param1Throwable, int param1Int, byte[] param1ArrayOfbyte) {
            super.onFailure(param1Throwable, param1Int, param1ArrayOfbyte);
          }
          
          public void a(byte[] param1ArrayOfbyte) {
            Bitmap bitmap2 = BitmapFactory.decodeByteArray(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
            Bitmap bitmap1 = BitmapFactory.decodeByteArray(param1ArrayOfbyte, 0, param1ArrayOfbyte.length);
            UserQrFragment.d(this.a).setImageBitmap(bitmap1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a.getActivity().getFilesDir());
            stringBuilder.append("/");
            stringBuilder.append(UserInfo.a().i().getUid());
            stringBuilder.append(".bmp");
            BitmapUtils.a(stringBuilder.toString(), bitmap2, 100, true);
          }
          
          public void onFinish() {
            super.onFinish();
            DialogUtils.b(UserQrFragment.c(this.a));
          }
          
          public void onStart() {
            super.onStart();
            DialogUtils.a(UserQrFragment.c(this.a));
          }
        }(IRequestHost)w_());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493246, paramViewGroup, false);
      FrameLayout frameLayout = (FrameLayout)this.e.findViewById(2131297224);
      a();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\UserQrFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */