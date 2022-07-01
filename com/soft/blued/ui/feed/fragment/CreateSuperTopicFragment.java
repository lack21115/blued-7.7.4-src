package com.soft.blued.ui.feed.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.utils.upload.QiniuUploadTools;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.http.FeedHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.model.BluedAlbum;
import com.soft.blued.utils.click.SingleClickProxy;
import com.soft.blued.utils.third.QiniuUploadUtils;
import java.util.regex.Pattern;

public class CreateSuperTopicFragment extends BaseFragment implements View.OnClickListener {
  InputFilter d = new InputFilter(this) {
      Pattern a = Pattern.compile("[^a-zA-Z0-9\\u4E00-\\u9FA5_]");
      
      public CharSequence filter(CharSequence param1CharSequence, int param1Int1, int param1Int2, Spanned param1Spanned, int param1Int3, int param1Int4) {
        return !this.a.matcher(param1CharSequence).find() ? null : "";
      }
    };
  
  private Context e;
  
  private View f;
  
  private CommonTopTitleNoTrans g;
  
  private RelativeLayout h;
  
  private ImageView i;
  
  private ImageView j;
  
  private EditText k;
  
  private Dialog l;
  
  private String m;
  
  private void a() {
    this.g = (CommonTopTitleNoTrans)this.f.findViewById(2131300273);
    this.g.setCenterText(2131756136);
    this.g.setRightText(2131758218);
    this.g.setRightTextColor(2131100845);
    this.g.setRightClickListener(this);
    this.g.setLeftClickListener(this);
  }
  
  public static void a(Context paramContext) {
    TerminalActivity.d(paramContext, CreateSuperTopicFragment.class, null);
  }
  
  private void a(String paramString, BluedAlbum paramBluedAlbum) {
    QiniuUploadUtils.a(paramString, paramBluedAlbum, new QiniuUploadTools.QiNiuListener(this) {
          public void a(String param1String) {
            CreateSuperTopicFragment.c(this.a).dismiss();
            AppMethods.d(2131755404);
          }
          
          public void a(String param1String, double param1Double) {}
          
          public void a(String param1String1, String param1String2) {
            CreateSuperTopicFragment.c(this.a).dismiss();
            CreateSuperTopicFragment createSuperTopicFragment = this.a;
            FeedPostFragment.a((Fragment)createSuperTopicFragment, param1String1, CreateSuperTopicFragment.e(createSuperTopicFragment).getText().toString(), 178);
          }
          
          public boolean a() {
            return false;
          }
        });
  }
  
  private void k() {
    this.h = (RelativeLayout)this.f.findViewById(2131298046);
    this.i = (ImageView)this.f.findViewById(2131297432);
    this.j = (ImageView)this.f.findViewById(2131297741);
    this.k = (EditText)this.f.findViewById(2131296976);
    ShapeHelper.b((ShapeHelper.ShapeView)this.f.findViewById(2131297079), 2131100881);
    this.f.findViewById(2131296764).setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.i.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.j.setOnClickListener((View.OnClickListener)new SingleClickProxy(this));
    this.k.setFilters(new InputFilter[] { this.d, (InputFilter)new InputFilter.LengthFilter(15) });
    this.k.addTextChangedListener(new TextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {
            CreateSuperTopicFragment.a(this.a);
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
  }
  
  private void l() {
    if (m()) {
      this.g.setRightTextColor(2131100838);
      return;
    } 
    this.g.setRightTextColor(2131100845);
  }
  
  private boolean m() {
    return (!TextUtils.isEmpty(this.m) && !TextUtils.isEmpty(this.k.getText().toString()));
  }
  
  private void n() {
    if (m())
      o(); 
  }
  
  private void o() {
    FeedHttpUtils.c(new BluedUIHttpResponse<BluedEntity>(this, (IRequestHost)w_()) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            CreateSuperTopicFragment.b(this.a);
          }
        }this.k.getText().toString(), (IRequestHost)w_());
  }
  
  private void p() {
    FeedHttpUtils.a(null, new BluedUIHttpResponse<BluedEntityA<BluedAlbum>>(this) {
          protected BluedEntityA<BluedAlbum> a(String param1String) {
            BluedEntityA<BluedAlbum> bluedEntityA = (BluedEntityA)super.parseData(param1String);
            if (bluedEntityA != null)
              try {
                if (bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
                  BluedAlbum bluedAlbum = bluedEntityA.data.get(0);
                  CreateSuperTopicFragment.a(this.a, CreateSuperTopicFragment.d(this.a), bluedAlbum);
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
            CreateSuperTopicFragment.c(this.a).dismiss();
            return super.onUIFailure(param1Int, param1String);
          }
          
          public void onUIStart() {
            super.onUIStart();
            CreateSuperTopicFragment.c(this.a).show();
          }
        });
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1)
      if (paramInt1 != 177) {
        if (paramInt1 == 178 && paramIntent != null && paramIntent.getBooleanExtra("close_page", false))
          getActivity().finish(); 
      } else if (paramIntent != null) {
        this.m = paramIntent.getStringExtra("photo_path");
        this.h.setVisibility(8);
        ImageLoader.d((IRequestHost)w_(), this.m).a(this.i);
        this.j.setVisibility(0);
        l();
      }  
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClick(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131297741:
        this.m = "";
        this.h.setVisibility(0);
        this.i.setImageDrawable(null);
        this.j.setVisibility(8);
        l();
        return;
      case 2131297432:
        PhotoSelectFragment.a(this, 13, 177);
        return;
      case 2131296867:
        EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_CREATE_RETURN_BTN_CLICK);
        n();
        return;
      case 2131296863:
        EventTrackFeed.a(FeedProtos.Event.SUPER_TOPIC_CREATE_NEXT_BTN_CLICK);
        getActivity().finish();
        return;
      case 2131296764:
        break;
    } 
    KeyboardUtils.a((Activity)getActivity());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.e = (Context)getActivity();
    View view = this.f;
    if (view == null) {
      this.f = paramLayoutInflater.inflate(2131493112, paramViewGroup, false);
      this.l = DialogUtils.a(this.e);
      a();
      k();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    } 
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\CreateSuperTopicFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */