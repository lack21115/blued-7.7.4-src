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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;

public class YYRenameView extends LinearLayout {
  private BaseYYStudioFragment a;
  
  private EditText b;
  
  private FrameLayout c;
  
  public YYRenameView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYRenameView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYRenameView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_modify_room_name, (ViewGroup)this, true);
    TextView textView = (TextView)findViewById(R.id.tv_modify);
    this.b = (EditText)findViewById(R.id.et_room_name);
    this.b.setFilters(new InputFilter[] { (InputFilter)new EnglishCharFilter(32) });
    this.c = (FrameLayout)findViewById(R.id.fl_loading_view);
    textView.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            String str = YYRenameView.a(this.a).getText().toString().trim();
            if (TextUtils.isEmpty(str)) {
              ToastUtils.a("房间名不能为空", 0);
              return;
            } 
            YYRenameView.a(this.a, str);
          }
        });
  }
  
  private void a(String paramString) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.a(yYRoomModel.room_id, paramString, "", yYRoomModel.type_id, new BluedUIHttpResponse(this, (IRequestHost)this.a.w_(), yYRoomModel, paramString) {
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            YYRenameView.b(this.c).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            YYRenameView.b(this.c).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.room_name = this.b;
            LiveEventBus.get("notify_room_rename").post(this.b);
            if (YYRenameView.c(this.c) != null)
              YYRenameView.c(this.c).H(); 
          }
        }(IRequestHost)this.a.w_());
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    if (paramBaseYYStudioFragment == null)
      return; 
    this.a = paramBaseYYStudioFragment;
    paramBaseYYStudioFragment.a(new Runnable(this) {
          public void run() {
            YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
            if (yYRoomModel == null)
              return; 
            YYRenameView.a(this.a).setText(yYRoomModel.room_name);
            YYRenameView.a(this.a).setFocusableInTouchMode(true);
            YYRenameView.a(this.a).setFocusable(true);
            YYRenameView.a(this.a).requestFocus();
            ((InputMethodManager)this.a.getContext().getSystemService("input_method")).showSoftInput((View)YYRenameView.a(this.a), 0);
            YYRenameView.a(this.a).setSelection(yYRoomModel.room_name.length());
          }
        }300L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYRenameView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */