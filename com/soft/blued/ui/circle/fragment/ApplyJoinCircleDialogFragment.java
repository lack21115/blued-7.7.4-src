package com.soft.blued.ui.circle.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.client.feed.FeedProtos;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.view.tip.dialog.CommonDialogFragment;

public class ApplyJoinCircleDialogFragment extends CommonDialogFragment implements View.OnClickListener {
  private View a;
  
  private TextView b;
  
  private ImageView c;
  
  private TextView d;
  
  private ShapeFrameLayout e;
  
  private EditText f;
  
  private TextView g;
  
  private ShapeTextView h;
  
  private TextView i;
  
  private String j;
  
  private String k;
  
  private String l;
  
  private Dialog m;
  
  private ApplyJoinCircleListener n;
  
  public static ApplyJoinCircleDialogFragment a(FragmentManager paramFragmentManager, CircleJoinState paramCircleJoinState, ApplyJoinCircleListener paramApplyJoinCircleListener) {
    return a(paramFragmentManager, paramCircleJoinState.circle_id, paramCircleJoinState.title, paramCircleJoinState.cover, paramApplyJoinCircleListener);
  }
  
  public static ApplyJoinCircleDialogFragment a(FragmentManager paramFragmentManager, String paramString1, String paramString2, String paramString3, ApplyJoinCircleListener paramApplyJoinCircleListener) {
    if (TextUtils.isEmpty(paramString1) || TextUtils.isEmpty(paramString2))
      return null; 
    ApplyJoinCircleDialogFragment applyJoinCircleDialogFragment = new ApplyJoinCircleDialogFragment();
    applyJoinCircleDialogFragment.a(paramApplyJoinCircleListener);
    Bundle bundle = new Bundle();
    bundle.putString("circle_id", paramString1);
    bundle.putString("circle_name", paramString2);
    bundle.putString("circle_header", paramString3);
    applyJoinCircleDialogFragment.setArguments(bundle);
    applyJoinCircleDialogFragment.show(paramFragmentManager, "ApplyJoinCircleDialogFragment");
    return applyJoinCircleDialogFragment;
  }
  
  private void h() {
    CircleHttpUtils.a(this.j, this.f.getText().toString(), new BluedUIHttpResponse<BluedEntityA<MyCircleModel>>(this, (IRequestHost)a()) {
          protected void a(BluedEntityA<MyCircleModel> param1BluedEntityA) {
            if (ApplyJoinCircleDialogFragment.d(this.a) != null)
              ApplyJoinCircleDialogFragment.d(this.a).onApply(); 
            this.a.dismiss();
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            DialogUtils.b(ApplyJoinCircleDialogFragment.c(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(ApplyJoinCircleDialogFragment.c(this.a));
          }
        }(IRequestHost)a());
  }
  
  private void i() {
    if (j()) {
      this.h.setAlpha(1.0F);
      this.h.setEnabled(true);
      return;
    } 
    this.h.setAlpha(0.3F);
    this.h.setEnabled(false);
  }
  
  private boolean j() {
    EditText editText = this.f;
    return (editText != null && !TextUtils.isEmpty(editText.getText().toString().trim()));
  }
  
  public void a(View paramView) {
    if (getArguments() != null) {
      this.j = getArguments().getString("circle_id");
      this.k = getArguments().getString("circle_name");
      this.l = getArguments().getString("circle_header");
    } 
    this.m = DialogUtils.a(getContext());
    this.a = paramView.findViewById(2131299753);
    this.b = (TextView)paramView.findViewById(2131301409);
    this.c = (ImageView)paramView.findViewById(2131297797);
    this.d = (TextView)paramView.findViewById(2131301088);
    this.e = (ShapeFrameLayout)paramView.findViewById(2131299910);
    this.f = (EditText)paramView.findViewById(2131296973);
    this.g = (TextView)paramView.findViewById(2131301393);
    this.h = (ShapeTextView)paramView.findViewById(2131300052);
    this.i = (TextView)paramView.findViewById(2131300611);
    this.a.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    i();
    ImageLoader.a((IRequestHost)a(), AvatarUtils.a(0, this.l)).a(2131231280).c(2131231280).a(6.0F).a(this.c);
    this.d.setText(this.k);
    this.f.setImeOptions(6);
    this.f.setInputType(262144);
    this.f.setSingleLine(false);
    this.f.setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
          public boolean onEditorAction(TextView param1TextView, int param1Int, KeyEvent param1KeyEvent) {
            if (param1Int != 1) {
              if (param1Int != 6)
                return false; 
              ApplyJoinCircleDialogFragment.a(this.a).callOnClick();
            } 
            return true;
          }
        });
    this.f.addTextChangedListener(new TextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {
            ApplyJoinCircleDialogFragment.b(this.a);
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
  }
  
  public void a(ApplyJoinCircleListener paramApplyJoinCircleListener) {
    this.n = paramApplyJoinCircleListener;
  }
  
  public void dismiss() {
    KeyboardUtils.a((Activity)getActivity());
    super.dismiss();
  }
  
  public int f() {
    return 2131492977;
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131299753)
      if (i != 2131300052) {
        if (i != 2131300611)
          return; 
        dismiss();
      } else {
        EventTrackFeed.f(FeedProtos.Event.CIRCLE_JOIN_APPLY_POP_YES_BTN_CLICK, this.j);
        if (j()) {
          h();
          return;
        } 
        return;
      }  
    KeyboardUtils.a((Activity)getActivity());
  }
  
  public static interface ApplyJoinCircleListener {
    void onApply();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\ApplyJoinCircleDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */