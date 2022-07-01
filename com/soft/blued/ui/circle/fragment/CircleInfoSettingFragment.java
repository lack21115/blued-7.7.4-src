package com.soft.blued.ui.circle.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.customview.EditInputNumView;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.presenter.CircleInfoSettingPresenter;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.msg.pop.BottomMenuPop;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.view.tip.CommonShowBottomWindow;
import java.io.Serializable;
import java.util.ArrayList;

public class CircleInfoSettingFragment extends MvpKeyBoardFragment<CircleInfoSettingPresenter> {
  @BindView(2131296975)
  EditText edtInfo;
  
  @BindView(2131297111)
  FrameLayout flHeaderBottom;
  
  @BindView(2131297597)
  EditInputNumView invWordCount;
  
  @BindView(2131297797)
  ImageView ivHeader;
  
  @BindView(2131297982)
  KeyboardListenLinearLayout keyboardLayout;
  
  @BindView(2131298870)
  LinearLayout llHeader;
  
  private Dialog n;
  
  private boolean o = false;
  
  private TextWatcher p = new TextWatcher(this) {
      public void afterTextChanged(Editable param1Editable) {
        if (!TextUtils.equals(param1Editable.toString(), ((CircleInfoSettingPresenter)this.a.s()).p()))
          CircleInfoSettingFragment.a(this.a, true); 
        CircleInfoSettingFragment.c(this.a);
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  @BindView(2131300728)
  TextView tvEdit;
  
  private void E() {
    ArrayList<BottomMenuPop.MenuItemInfo> arrayList = new ArrayList();
    BasePopupView basePopupView = CommonShowBottomWindow.a(getContext(), arrayList);
    BottomMenuPop.MenuItemInfo menuItemInfo1 = new BottomMenuPop.MenuItemInfo();
    menuItemInfo1.a = getContext().getString(2131756853);
    menuItemInfo1.c = new View.OnClickListener(this, basePopupView) {
        public void onClick(View param1View) {
          PhotoSelectFragment.a((BaseFragment)this.b, 13, 177);
          BasePopupView basePopupView = this.a;
          if (basePopupView != null)
            basePopupView.p(); 
        }
      };
    BottomMenuPop.MenuItemInfo menuItemInfo2 = new BottomMenuPop.MenuItemInfo();
    menuItemInfo2.a = getContext().getString(2131756854);
    menuItemInfo2.c = new View.OnClickListener(this, basePopupView) {
        public void onClick(View param1View) {
          String str = ((CircleInfoSettingPresenter)this.b.s()).o();
          BasePhotoFragment.a(this.b.getContext(), new String[] { str }, 0, 3, null);
          BasePopupView basePopupView = this.a;
          if (basePopupView != null)
            basePopupView.p(); 
        }
      };
    arrayList.add(menuItemInfo1);
    arrayList.add(menuItemInfo2);
    basePopupView.h();
  }
  
  private void F() {
    if (G()) {
      this.title.getRightTextView().setAlpha(1.0F);
      this.title.getRightTextView().setEnabled(true);
      return;
    } 
    this.title.getRightTextView().setAlpha(0.3F);
    this.title.getRightTextView().setEnabled(false);
  }
  
  private boolean G() {
    return (this.o || ((CircleInfoSettingPresenter)s()).q());
  }
  
  public static void a(Context paramContext, MyCircleModel paramMyCircleModel) {
    Bundle bundle = new Bundle();
    bundle.putSerializable("circle_data", (Serializable)paramMyCircleModel);
    TerminalActivity.d(paramContext, CircleInfoSettingFragment.class, bundle);
  }
  
  public boolean V_() {
    KeyboardUtils.a((Activity)getActivity());
    return super.V_();
  }
  
  public void a(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      this.invWordCount.setVisibility(8);
      return;
    } 
    this.invWordCount.setVisibility(0);
    this.edtInfo.setFocusable(true);
    this.edtInfo.setFocusableInTouchMode(true);
    this.edtInfo.requestFocus();
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    a(this.keyboardLayout);
    this.n = DialogUtils.a(getContext());
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.C();
          }
        });
    this.title.setRightTextColor(2131100716);
    this.title.getRightTextView().setAlpha(0.3F);
    this.title.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackFeed.f(FeedProtos.Event.CIRCLE_SETTINGS_PAGE_INFO_SAVE_CLICK, ((CircleInfoSettingPresenter)this.a.s()).n());
            if (CircleInfoSettingFragment.a(this.a)) {
              String str = this.a.edtInfo.getText().toString();
              if (str.length() >= 15) {
                ((CircleInfoSettingPresenter)this.a.s()).d(str);
                return;
              } 
              AppMethods.d(2131755867);
            } 
          }
        });
    this.llHeader.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackFeed.f(FeedProtos.Event.CIRCLE_SETTINGS_PAGE_PHOTO_UPLOAD_CLICK, ((CircleInfoSettingPresenter)this.a.s()).n());
            KeyboardUtils.a((Activity)this.a.getActivity());
            CircleInfoSettingFragment.b(this.a);
          }
        });
    this.edtInfo.setFilters(new InputFilter[] { (InputFilter)new InputFilter.LengthFilter(512) });
    this.edtInfo.addTextChangedListener(this.p);
    this.edtInfo.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackFeed.f(FeedProtos.Event.CIRCLE_SETTINGS_PAGE_SUMMARY_CLICK, ((CircleInfoSettingPresenter)this.a.s()).n());
          }
        });
    this.invWordCount.a(this.edtInfo, 512);
  }
  
  protected void a(MyCircleModel paramMyCircleModel) {
    ImageLoader.a((IRequestHost)w_(), AvatarUtils.a(0, paramMyCircleModel.cover)).a(2131231281).a(6.0F).a(this.ivHeader);
    this.edtInfo.setText(paramMyCircleModel.description);
    EditText editText = this.edtInfo;
    editText.setSelection(editText.length());
    if (paramMyCircleModel.cover_is_auditing == 1) {
      this.tvEdit.setText(2131755854);
      return;
    } 
    this.tvEdit.setText(2131757910);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    super.a(paramString, paramBoolean);
    if ("upload_photo".equals(paramString))
      DialogUtils.b(this.n); 
  }
  
  public void aL_() {
    this.edtInfo.removeTextChangedListener(this.p);
    super.aL_();
  }
  
  public void b(String paramString) {
    super.b(paramString);
    if ("upload_photo".equals(paramString))
      DialogUtils.a(this.n); 
  }
  
  public void o() {
    super.o();
    getActivity().getWindow().setSoftInputMode(19);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    if (paramInt2 == -1 && paramInt1 == 177 && paramIntent != null) {
      String str = paramIntent.getStringExtra("photo_path");
      if (!TextUtils.isEmpty(str)) {
        ImageLoader.d((IRequestHost)w_(), str).a(this.ivHeader);
        ((CircleInfoSettingPresenter)s()).f(str);
        ((CircleInfoSettingPresenter)s()).a(true);
        F();
      } 
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public int p() {
    return 2131493093;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleInfoSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */