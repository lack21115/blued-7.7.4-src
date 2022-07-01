package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYReportModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import java.util.ArrayList;
import java.util.List;

public class YYReportView extends LinearLayout {
  BaseYYStudioFragment a;
  
  EditText b;
  
  ShapeTextView c;
  
  private YYReportModel d;
  
  private int e;
  
  private boolean f;
  
  public YYReportView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYReportView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYReportView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_report_layout, (ViewGroup)this, true);
    this.c = (ShapeTextView)findViewById(R.id.btn_report);
    this.b = (EditText)findViewById(R.id.et_report_view);
    this.b.setFilters(new InputFilter[] { (InputFilter)new EnglishCharFilter(280) });
    this.c.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (YYReportView.a(this.a))
              return; 
            YYReportView.a(this.a, true);
            String str = this.a.b.getText().toString().trim();
            YYReportView.a(this.a, str);
          }
        });
  }
  
  private void a(YYRoomModel paramYYRoomModel) {
    List list = paramYYRoomModel.mics;
    if (list == null)
      return; 
    if (this.d.members == null)
      this.d.members = new ArrayList(); 
    this.d.members.clear();
    for (YYSeatMemberModel yYSeatMemberModel : list) {
      if (TextUtils.isEmpty(yYSeatMemberModel.getUid()) || TextUtils.equals("0", yYSeatMemberModel.getUid()))
        continue; 
      this.d.members.add(yYSeatMemberModel.getUid());
    } 
  }
  
  private void a(String paramString) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    if (this.d == null)
      return; 
    a(yYRoomModel);
    this.d.room_id = yYRoomModel.room_id;
    this.d.anchor = yYRoomModel.uid;
    this.d.reason = paramString;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("report model: ");
    stringBuilder.append(this.d.toString());
    Logger.e("onMessge", new Object[] { stringBuilder.toString() });
    int i = this.e;
    if (i != 1) {
      if (i != 2) {
        b();
        return;
      } 
      d();
      return;
    } 
    c();
  }
  
  private void b() {
    YYRoomHttpUtils.a(this.d.room_id, this.d.anchor, this.d.uid, this.d.reason, this.d.members, getCallback(), (IRequestHost)this.a.w_());
  }
  
  private void c() {
    YYRoomHttpUtils.a(this.d.room_id, this.d.anchor, this.d.reason, this.d.members, getCallback(), (IRequestHost)this.a.w_());
  }
  
  private void d() {
    YYRoomHttpUtils.a(this.d.room_id, this.d.anchor, this.d.uid, this.d.reason, this.d.members, this.d.msg, getCallback(), (IRequestHost)this.a.w_());
  }
  
  private BluedUIHttpResponse getCallback() {
    return new BluedUIHttpResponse(this, (IRequestHost)this.a.w_()) {
        public boolean onUIFailure(int param1Int, String param1String) {
          YYReportView.a(this.a, false);
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIUpdate(BluedEntity param1BluedEntity) {
          ToastUtils.a("平台将尽快处理你的反馈", 0);
          YYReportView.a(this.a, false);
          if (this.a.a != null)
            this.a.a.H(); 
        }
      };
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment, YYReportModel paramYYReportModel, int paramInt) {
    this.a = paramBaseYYStudioFragment;
    this.d = paramYYReportModel;
    this.e = paramInt;
    paramBaseYYStudioFragment.a(new Runnable(this) {
          public void run() {
            this.a.b.setFocusableInTouchMode(true);
            this.a.b.setFocusable(true);
            this.a.b.requestFocus();
            ((InputMethodManager)this.a.getContext().getSystemService("input_method")).showSoftInput((View)this.a.b, 0);
          }
        }300L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYReportView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */