package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ReflectionUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveFansReNameModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

public class LiveFansReNameDialogFragment extends BaseDialogFragment implements View.OnClickListener {
  public Context a;
  
  public String b;
  
  public long c;
  
  public ILiveFansEditDialog d;
  
  private EditText e;
  
  private TextView f;
  
  private View g;
  
  private View h;
  
  private final int i = 3;
  
  private boolean j = false;
  
  private boolean k = false;
  
  private TextWatcher l = new TextWatcher(this) {
      private int b;
      
      private int c;
      
      public void afterTextChanged(Editable param1Editable) {
        this.b = LiveFansReNameDialogFragment.a(this.a).getSelectionStart();
        this.c = LiveFansReNameDialogFragment.a(this.a).getSelectionEnd();
        LiveFansReNameDialogFragment.a(this.a).removeTextChangedListener(LiveFansReNameDialogFragment.b(this.a));
        while (param1Editable.length() > 3) {
          param1Editable.delete(this.b - 1, this.c);
          this.b--;
          this.c--;
        } 
        LiveFansReNameDialogFragment.a(this.a).setSelection(this.b);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        stringBuffer.append(param1Editable.length());
        stringBuffer.append("/");
        stringBuffer.append(3);
        stringBuffer.append(")");
        LiveFansReNameDialogFragment.c(this.a).setText(stringBuffer.toString());
        LiveFansReNameDialogFragment.a(this.a).addTextChangedListener(LiveFansReNameDialogFragment.b(this.a));
      }
      
      public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
      
      public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
    };
  
  private void g() {
    if (getArguments() != null) {
      this.b = getArguments().getString("name");
      this.c = getArguments().getLong("lid");
    } 
  }
  
  public void a(ILiveFansEditDialog paramILiveFansEditDialog) {
    this.d = paramILiveFansEditDialog;
  }
  
  public void f() {
    LiveRoomHttpUtils.d(this.e.getText().toString(), new BluedUIHttpResponse<BluedEntityA<LiveFansReNameModel>>(this, (IRequestHost)a()) {
          protected void a(BluedEntityA<LiveFansReNameModel> param1BluedEntityA) {
            LiveFansReNameDialogFragment.a(this.a, true);
            AppMethods.d(R.string.live_fans_change_success);
            (LiveRoomManager.a().i()).apply = 1;
            if (LiveFansReNameDialogFragment.d(this.a))
              this.a.dismiss(); 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            AppMethods.a(param1String);
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
          }
          
          public void onUIStart() {
            super.onUIStart();
          }
        }(IRequestHost)a());
  }
  
  public void onClick(View paramView) {
    paramView.getId();
  }
  
  public Dialog onCreateDialog(Bundle paramBundle) {
    this.a = (Context)getActivity();
    g();
    View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_live_fans_edit, null);
    DensityUtils.a((Context)getActivity(), 300.0F);
    DensityUtils.a((Context)getActivity(), 216.0F);
    Dialog dialog = new Dialog((Context)getActivity(), R.style.transparentFrameWindowStyleLive);
    dialog.requestWindowFeature(1);
    dialog.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    dialog.setContentView(view, new ViewGroup.LayoutParams(-1, -1));
    Window window = dialog.getWindow();
    window.setWindowAnimations(0);
    WindowManager.LayoutParams layoutParams = window.getAttributes();
    layoutParams.width = -1;
    layoutParams.height = -1;
    dialog.onWindowAttributesChanged(layoutParams);
    return dialog;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    getDialog().getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
    View view = paramLayoutInflater.inflate(R.layout.dialog_live_fans_edit, paramViewGroup);
    this.e = (EditText)view.findViewById(R.id.et_fans_name);
    this.f = (TextView)view.findViewById(R.id.tv_fans_num);
    this.g = view.findViewById(R.id.tv_cancel);
    this.h = view.findViewById(R.id.tv_confirm);
    this.e.addTextChangedListener(this.l);
    this.h.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_EDIT_NAME_CONFIRM_CLICK, String.valueOf(this.a.c));
            if (!TextUtils.isEmpty(LiveFansReNameDialogFragment.a(this.a).getText().toString())) {
              this.a.f();
              return;
            } 
            AppMethods.d(R.string.live_fans_name_empty);
          }
        });
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.dismiss();
          }
        });
    ILiveFansEditDialog iLiveFansEditDialog = this.d;
    if (iLiveFansEditDialog != null)
      iLiveFansEditDialog.v_(); 
    this.e.setText(this.b);
    this.j = true;
    return view;
  }
  
  public void onDestroy() {
    super.onDestroy();
    this.j = false;
    ILiveFansEditDialog iLiveFansEditDialog = this.d;
    if (iLiveFansEditDialog != null)
      iLiveFansEditDialog.a(this.k, this.e.getText().toString()); 
  }
  
  public void show(FragmentManager paramFragmentManager, String paramString) {
    try {
      ReflectionUtils.a(this, "mDismissed", Boolean.valueOf(false));
      ReflectionUtils.a(this, "mShownByMe", Boolean.valueOf(true));
      FragmentTransaction fragmentTransaction = paramFragmentManager.beginTransaction();
      fragmentTransaction.add((Fragment)this, paramString);
      fragmentTransaction.commitAllowingStateLoss();
      return;
    } catch (Exception exception) {
      super.show(paramFragmentManager, paramString);
      return;
    } 
  }
  
  public static interface ILiveFansEditDialog {
    void a(boolean param1Boolean, String param1String);
    
    void v_();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveFansReNameDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */