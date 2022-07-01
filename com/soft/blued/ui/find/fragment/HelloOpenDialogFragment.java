package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blued.android.core.ui.TransparentActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.guy.GuyProtos;
import com.soft.blued.log.trackUtils.EventTrackGuy;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.presenter.HelloOpenDialogPresenter;
import com.soft.blued.ui.home.HomeActivity;

public class HelloOpenDialogFragment extends MvpFragment<HelloOpenDialogPresenter> {
  @BindView(2131296621)
  ShapeTextView callOpen;
  
  @BindView(2131296659)
  CardView cardView;
  
  @BindView(2131297710)
  ImageView ivBuySuccess;
  
  @BindView(2131297715)
  ImageView ivCallLeft;
  
  @BindView(2131297716)
  ImageView ivCallRight;
  
  @BindView(2131297729)
  ImageView ivClose;
  
  @BindView(2131299973)
  ShapeLinearLayout sllCallLeft;
  
  @BindView(2131299974)
  ShapeLinearLayout sllCallRight;
  
  @BindView(2131300605)
  TextView tvCallLeft;
  
  @BindView(2131300607)
  TextView tvCallRight;
  
  @BindView(2131300609)
  TextView tvCallTitleLeft;
  
  @BindView(2131300610)
  TextView tvCallTitleRight;
  
  @BindView(2131300663)
  TextView tvContent;
  
  @BindView(2131300670)
  TextView tvCount;
  
  @BindView(2131301409)
  TextView tvTitle;
  
  public static void a(Context paramContext, int paramInt) {
    a(paramContext, false, 0, paramInt);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2) {
    a(paramContext, false, paramInt1, paramInt2);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, int paramInt) {
    a(paramContext, paramBoolean, 0, paramInt);
  }
  
  public static void a(Context paramContext, boolean paramBoolean, int paramInt1, int paramInt2) {
    Bundle bundle = new Bundle();
    bundle.putBoolean("hello_open_is_buy", paramBoolean);
    bundle.putInt("hello_open_count", paramInt1);
    bundle.putInt("hello_open_from", paramInt2);
    TransparentActivity.a(bundle);
    TransparentActivity.b(paramContext, HelloOpenDialogFragment.class, bundle);
  }
  
  private void k() {
    ShapeHelper.b((ShapeHelper.ShapeView)this.sllCallLeft, 2131100728);
    ShapeHelper.d((ShapeHelper.ShapeView)this.sllCallLeft, 2131100716);
    this.ivCallLeft.setImageDrawable(BluedSkinUtils.b(getContext(), 2131231190));
    this.tvCallTitleLeft.setTextColor(BluedSkinUtils.a(getContext(), 2131100716));
    this.tvCallLeft.setTextColor(BluedSkinUtils.a(getContext(), 2131100716));
    ShapeHelper.b((ShapeHelper.ShapeView)this.sllCallRight, 2131100881);
    ShapeHelper.d((ShapeHelper.ShapeView)this.sllCallRight, 2131100728);
    this.ivCallRight.setImageDrawable(BluedSkinUtils.b(getContext(), 2131231187));
    this.tvCallTitleRight.setTextColor(BluedSkinUtils.a(getContext(), 2131100844));
    this.tvCallRight.setTextColor(BluedSkinUtils.a(getContext(), 2131100844));
  }
  
  private void l() {
    ShapeHelper.b((ShapeHelper.ShapeView)this.sllCallLeft, 2131100881);
    ShapeHelper.d((ShapeHelper.ShapeView)this.sllCallLeft, 2131100728);
    this.ivCallLeft.setImageDrawable(BluedSkinUtils.b(getContext(), 2131231189));
    this.tvCallTitleLeft.setTextColor(BluedSkinUtils.a(getContext(), 2131100844));
    this.tvCallLeft.setTextColor(BluedSkinUtils.a(getContext(), 2131100844));
    ShapeHelper.b((ShapeHelper.ShapeView)this.sllCallRight, 2131100728);
    ShapeHelper.d((ShapeHelper.ShapeView)this.sllCallRight, 2131100716);
    this.ivCallRight.setImageDrawable(BluedSkinUtils.b(getContext(), 2131231188));
    this.tvCallTitleRight.setTextColor(BluedSkinUtils.a(getContext(), 2131100716));
    this.tvCallRight.setTextColor(BluedSkinUtils.a(getContext(), 2131100716));
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    if (((HelloOpenDialogPresenter)s()).m()) {
      this.tvTitle.setText(2131756888);
      this.tvTitle.setVisibility(0);
      this.tvCount.setVisibility(8);
      this.tvContent.setText(2131756889);
      this.ivBuySuccess.setVisibility(0);
      return;
    } 
    this.tvCount.setText(String.valueOf(((HelloOpenDialogPresenter)s()).n()));
    this.tvCount.setVisibility(0);
    this.tvTitle.setVisibility(8);
    this.tvContent.setText(2131756890);
    this.ivBuySuccess.setVisibility(8);
  }
  
  @OnClick({2131299973, 2131299974, 2131296621, 2131297729})
  public void onViewClicked(View paramView) {
    switch (paramView.getId()) {
      default:
        return;
      case 2131299974:
        ((HelloOpenDialogPresenter)s()).a(true);
        l();
        return;
      case 2131299973:
        ((HelloOpenDialogPresenter)s()).a(false);
        k();
        return;
      case 2131297729:
        getActivity().finish();
        return;
      case 2131296621:
        break;
    } 
    if (((HelloOpenDialogPresenter)s()).m()) {
      GuyProtos.VocativeType vocativeType;
      GuyProtos.Event event = GuyProtos.Event.VOCATIVE_BUY_SUCCESS_POP_OPEN_BTN_CLICK;
      if (((HelloOpenDialogPresenter)s()).p()) {
        vocativeType = GuyProtos.VocativeType.VOCATIVE_QUIET;
      } else {
        vocativeType = GuyProtos.VocativeType.VOCATIVE_COMMON;
      } 
      EventTrackGuy.a(event, vocativeType);
    } else {
      GuyProtos.VocativeType vocativeType;
      GuyProtos.Event event = GuyProtos.Event.VOCATIVE_OPEN_POP_OPEN_BTN_CLICK;
      if (((HelloOpenDialogPresenter)s()).p()) {
        vocativeType = GuyProtos.VocativeType.VOCATIVE_QUIET;
      } else {
        vocativeType = GuyProtos.VocativeType.VOCATIVE_COMMON;
      } 
      EventTrackGuy.a(event, vocativeType);
    } 
    boolean bool = ((HelloOpenDialogPresenter)s()).p();
    CallHelloManager.a().a(getContext(), new CallHelloManager.ToOpenListener(this, bool) {
          public void a(boolean param1Boolean) {
            if (param1Boolean && HomeActivity.c != null)
              CallHelloManager.a().a((Context)HomeActivity.c, null, this.a, ((HelloOpenDialogPresenter)this.b.s()).o()); 
            this.b.getActivity().finish();
          }
        });
  }
  
  public int p() {
    return 2131492997;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\HelloOpenDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */