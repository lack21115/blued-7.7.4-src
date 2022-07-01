package com.soft.blued.ui.circle.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.ui.custom.KeyboardListenLinearLayout;
import com.blued.android.framework.ui.custom.MvpKeyBoardFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.circle.adapter.CircleTextVoteEditAdapter;
import com.soft.blued.ui.circle.presenter.CircleTextVoteEditPresenter;
import com.soft.blued.ui.feed.model.CircleTextVote;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

public class CircleTextVoteEditFragment extends MvpKeyBoardFragment<CircleTextVoteEditPresenter> {
  @BindView(2131296974)
  EditText edtContent;
  
  @BindView(2131297981)
  KeyboardListenLinearLayout keyboardRelativeLayout;
  
  private CircleTextVoteEditAdapter n;
  
  @BindView(2131299605)
  RecyclerView recyclerView;
  
  @BindView(2131300045)
  ShapeTextView stvAddOption;
  
  @BindView(2131300273)
  CommonTopTitleNoTrans title;
  
  private void E() {
    this.recyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this, getContext()) {
          public boolean canScrollVertically() {
            return false;
          }
        });
    this.n = new CircleTextVoteEditAdapter();
    this.recyclerView.setAdapter((RecyclerView.Adapter)this.n);
    this.n.a(new CircleTextVoteEditAdapter.OnEditChangeListener(this) {
          public void a() {
            CircleTextVoteEditFragment.a(this.a);
          }
        });
  }
  
  private void F() {
    this.edtContent.addTextChangedListener(new TextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {
            CircleTextVoteEditFragment.a(this.a);
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
  }
  
  private void G() {
    ShapeTextView shapeTextView = this.title.getRightTextView();
    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)shapeTextView.getLayoutParams();
    layoutParams.rightMargin = DensityUtils.a(getContext(), 10.0F);
    layoutParams.height = DensityUtils.a(getContext(), 26.0F);
    shapeTextView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    ShapeHelper.b((ShapeHelper.ShapeView)shapeTextView, 2131100716);
    ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, DensityUtils.a(getContext(), 10.0F));
    shapeTextView.setTextColor(getContext().getResources().getColor(2131100728));
    H();
    this.title.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.V_();
          }
        });
    shapeTextView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (CircleTextVoteEditFragment.b(this.a)) {
              Intent intent = new Intent();
              intent.putExtra("circle_vote_title", this.a.edtContent.getText().toString());
              intent.putExtra("circle_vote_content", (Serializable)CircleTextVoteEditFragment.c(this.a).n());
              this.a.getActivity().setResult(-1, intent);
              this.a.getActivity().finish();
            } 
          }
        });
  }
  
  private void H() {
    ShapeTextView shapeTextView = this.title.getRightTextView();
    if (I()) {
      shapeTextView.setAlpha(1.0F);
      return;
    } 
    shapeTextView.setAlpha(0.3F);
  }
  
  private boolean I() {
    if (TextUtils.isEmpty(this.edtContent.getText().toString()))
      return false; 
    Iterator iterator = this.n.n().iterator();
    while (iterator.hasNext()) {
      if (TextUtils.isEmpty(((CircleTextVote)iterator.next()).option))
        return false; 
    } 
    return true;
  }
  
  private boolean J() {
    return (this.n.n().size() < 10);
  }
  
  private void K() {
    a(new Runnable(this) {
          public void run() {
            if (!this.a.edtContent.isFocusable())
              this.a.edtContent.requestFocus(); 
            this.a.edtContent.setSelection(this.a.edtContent.getText().toString().length());
            KeyboardUtils.c((Activity)this.a.getActivity());
          }
        },  300L);
  }
  
  public static void a(Fragment paramFragment, int paramInt, String paramString, List<CircleTextVote> paramList) {
    Bundle bundle = new Bundle();
    bundle.putString("circle_vote_title", paramString);
    bundle.putSerializable("circle_vote_content", (Serializable)paramList);
    TerminalActivity.a(paramFragment, CircleTextVoteEditFragment.class, bundle, paramInt);
  }
  
  public boolean V_() {
    CommonAlertDialog.a(getContext(), getContext().getString(2131756094), getContext().getString(2131755947), getContext().getString(2131755609), new DialogInterface.OnClickListener(this) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            this.a.getActivity().finish();
          }
        },  getContext().getString(2131755577), null, null);
    return true;
  }
  
  public void a(Bundle paramBundle) {
    super.a(paramBundle);
    a(this.keyboardRelativeLayout);
    G();
    F();
    E();
    K();
  }
  
  protected void a(List<CircleTextVote> paramList) {
    this.n.c(paramList);
    H();
  }
  
  protected void c(String paramString) {
    this.edtContent.setText(paramString);
    H();
  }
  
  public void o() {
    super.o();
    getActivity().getWindow().setSoftInputMode(18);
  }
  
  @OnClick({2131300045})
  public void onViewClicked(View paramView) {
    if (paramView.getId() != 2131300045)
      return; 
    if (J()) {
      this.n.a(new CircleTextVote());
      H();
      return;
    } 
    AppMethods.a("最多选择10个选项");
  }
  
  public int p() {
    return 2131493101;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleTextVoteEditFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */