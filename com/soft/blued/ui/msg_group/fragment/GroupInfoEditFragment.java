package com.soft.blued.ui.msg_group.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.fragment.CommonWriteTextFragment;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.msg_group.model.GroupInfoModel;
import com.soft.blued.utils.third.QiniuUploadUtils;
import java.util.HashMap;
import java.util.Map;

public class GroupInfoEditFragment extends MvpFragment<MvpPresenter> {
  private GroupInfoModel d;
  
  private boolean e;
  
  private Map<String, String> f = new HashMap<String, String>();
  
  @BindView(2131297804)
  ImageView iv_icon;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  @BindView(2131300705)
  TextView tv_description;
  
  @BindView(2131300851)
  TextView tv_group_name;
  
  private void a(String paramString, BluedAlbum paramBluedAlbum) {
    QiniuUploadUtils.a(paramString, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this) {
          public void a(String param1String) {
            this.a.w();
            AppMethods.d(2131755404);
          }
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            GroupInfoEditFragment.b(this.a).put("group_cover", param1String1);
            GroupInfoEditFragment.c(this.a);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void k() {
    boolean bool2;
    GroupInfoModel groupInfoModel = this.d;
    if (groupInfoModel == null)
      return; 
    boolean bool1 = TextUtils.isEmpty(groupInfoModel.group_desc);
    boolean bool4 = true;
    if (!bool1) {
      bool1 = this.d.group_desc.equals(this.tv_description.getText().toString());
    } else {
      bool1 = TextUtils.isEmpty(this.tv_description.getText().toString());
    } 
    if (!TextUtils.isEmpty(this.d.group_title)) {
      bool2 = this.d.group_title.equals(this.tv_group_name.getText().toString());
    } else {
      bool2 = TextUtils.isEmpty(this.tv_group_name.getText().toString());
    } 
    boolean bool3 = bool4;
    if (this.iv_icon.getTag() == null) {
      bool3 = bool4;
      if ((bool1 ^ true) == 0)
        if ((bool2 ^ true) != 0) {
          bool3 = bool4;
        } else {
          bool3 = false;
        }  
    } 
    this.e = bool3;
    this.title.getRightTextView().setEnabled(this.e);
    if (this.e) {
      this.title.getRightTextView().setTextColor(getResources().getColor(2131100838));
      return;
    } 
    this.title.getRightTextView().setTextColor(getResources().getColor(2131100845));
  }
  
  private void l() {
    if (this.d == null)
      return; 
    this.f.clear();
    if (!this.tv_description.getText().toString().equals(this.d.group_desc))
      this.f.put("group_desc", this.tv_description.getText().toString()); 
    if (!this.tv_group_name.getText().toString().equals(this.d.group_title))
      this.f.put("group_title", this.tv_group_name.getText().toString()); 
    if (this.iv_icon.getTag() != null) {
      m();
      return;
    } 
    n();
  }
  
  private void m() {
    FeedHttpUtils.a(null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this, (IRequestHost)w_()) {
          protected BluedEntityA<BluedAlbum> a(String param1String) {
            BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA)super.parseData(param1String);
            if (bluedEntityA != null)
              try {
                if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                  BluedAlbum bluedAlbum = bluedEntityA.data.get(0);
                  GroupInfoEditFragment.a(this.a, (String)this.a.iv_icon.getTag(), bluedAlbum);
                  return bluedEntityA;
                } 
              } catch (Exception exception) {
                exception.printStackTrace();
              }  
            return bluedEntityA;
          }
          
          public void a(BluedEntityA<BluedAlbum> param1BluedEntityA) {}
          
          public void onFailure(Throwable param1Throwable, int param1Int, String param1String) {
            super.onFailure(param1Throwable, param1Int, param1String);
            AppMethods.d(2131755404);
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            this.a.w();
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIStart() {
            super.onUIStart();
            this.a.v();
          }
        });
  }
  
  private void n() {
    if (this.d == null)
      return; 
    ActivityFragmentActive activityFragmentActive = w_();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.d.group_id);
    stringBuilder.append("");
    MsgGroupHttpUtils.a((IRequestHost)activityFragmentActive, stringBuilder.toString(), this.f, new BluedUIHttpResponse<BluedEntityA>(this, (IRequestHost)w_()) {
          protected void a(BluedEntityA param1BluedEntityA) {}
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            if (param1Boolean) {
              AppMethods.a(this.a.getString(2131756789));
              LiveEventBus.get("modify_group_info").post(null);
              this.a.C();
            } 
          }
        });
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    if (getArguments() != null)
      this.d = (GroupInfoModel)getArguments().getSerializable("group_info"); 
    this.title.setCenterText(getString(2131756664));
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.title.setRightText(getString(2131757224));
    this.title.getRightTextView().setTextColor(getResources().getColor(2131100845));
    this.title.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            GroupInfoEditFragment.a(this.a);
          }
        });
    GroupInfoModel groupInfoModel = this.d;
    if (groupInfoModel != null) {
      this.tv_description.setText(groupInfoModel.group_desc);
      this.tv_group_name.setText(this.d.group_title);
      ImageLoader.a((IRequestHost)w_(), this.d.group_cover).c().a(this.iv_icon);
    } 
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1) {
      String str;
      if (paramInt1 == 1) {
        str = paramIntent.getStringExtra("string_edit");
        if (!TextUtils.isEmpty(str))
          this.tv_description.setText(str); 
      } else if (paramInt1 == 0) {
        str = str.getStringExtra("string_edit");
        if (!TextUtils.isEmpty(str))
          this.tv_group_name.setText(str); 
      } else if (paramInt1 == 2) {
        str = str.getStringExtra("photo_path");
        ImageLoader.d((IRequestHost)w_(), str).c().a(this.iv_icon);
        this.iv_icon.setTag(str);
      } 
      k();
    } 
  }
  
  @OnClick({2131296758, 2131296760, 2131296762})
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296758) {
      if (i != 2131296760) {
        if (i != 2131296762)
          return; 
        PhotoSelectFragment.a((BaseFragment)this, 3, 2);
        return;
      } 
      CommonWriteTextFragment.a((Fragment)this, "20", this.tv_group_name.getText().toString(), null, getString(2131756665), 0);
      return;
    } 
    CommonWriteTextFragment.a((Fragment)this, "256", this.tv_description.getText().toString(), null, getString(2131756677), 1);
  }
  
  public int p() {
    return 2131493059;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\fragment\GroupInfoEditFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */