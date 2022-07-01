package com.blued.android.module.yy_china.view;

import android.app.Activity;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomDescModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.EnglishCharFilter;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;

public class YYBroadcastView extends FrameLayout {
  private BaseYYStudioFragment a;
  
  private YYRoomModel b;
  
  private EditText c;
  
  private ShapeTextView d;
  
  private FrameLayout e;
  
  private LinearLayout f;
  
  private ImageView g;
  
  public YYBroadcastView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYBroadcastView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYBroadcastView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_broadcast_layout, (ViewGroup)this, true);
    this.f = (LinearLayout)findViewById(R.id.ll_root);
    this.g = (ImageView)findViewById(R.id.iv_close);
    this.e = (FrameLayout)findViewById(R.id.fl_loading_view);
    this.c = (EditText)findViewById(R.id.et_broadcast_view);
    this.d = (ShapeTextView)findViewById(R.id.btn_save);
    this.c.setFilters(new InputFilter[] { (InputFilter)new EnglishCharFilter(500) });
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            String str2 = YYBroadcastView.a(this.a).getText().toString().trim();
            String str1 = str2;
            if (TextUtils.isEmpty(str2))
              str1 = this.a.getResources().getString(R.string.yy_live_notice); 
            YYBroadcastView.a(this.a, str1);
          }
        });
    this.g.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYBroadcastView.b(this.a).H();
          }
        });
  }
  
  private void a(String paramString) {
    if (this.b == null)
      return; 
    EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_NOTICE_SAVE_CLICK, this.b.room_id, this.b.uid);
    YYRoomHttpUtils.a(this.b.room_id, "", paramString, this.b.type_id, new BluedUIHttpResponse(this, (IRequestHost)this.a.w_(), paramString) {
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            YYBroadcastView.c(this.b).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            YYBroadcastView.c(this.b).setVisibility(0);
          }
          
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            ToastUtils.a("保存成功", 0);
            (YYBroadcastView.d(this.b)).room_desc = this.a;
            if (YYBroadcastView.b(this.b) != null) {
              YYBroadcastView.a(this.b).setText("");
              KeyboardUtils.a((Activity)YYBroadcastView.b(this.b).getActivity());
            } 
          }
        }(IRequestHost)this.a.w_());
  }
  
  public void a(int paramInt) {
    this.f.setBackgroundResource(paramInt);
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.a = paramBaseYYStudioFragment;
    this.b = YYRoomInfoManager.d().b();
    YYRoomModel yYRoomModel = this.b;
    if (yYRoomModel == null)
      return; 
    if (TextUtils.isEmpty(yYRoomModel.room_desc)) {
      this.c.setHint(getResources().getString(R.string.yy_live_notice));
    } else {
      this.c.setText(this.b.room_desc);
    } 
    if (paramBaseYYStudioFragment != null) {
      if (!this.c.isEnabled())
        return; 
      paramBaseYYStudioFragment.a(new Runnable(this) {
            public void run() {
              YYBroadcastView.a(this.a).setFocusableInTouchMode(true);
              YYBroadcastView.a(this.a).setFocusable(true);
              YYBroadcastView.a(this.a).requestFocus();
              ((InputMethodManager)this.a.getContext().getSystemService("input_method")).showSoftInput((View)YYBroadcastView.a(this.a), 0);
              YYBroadcastView.a(this.a).setSelection(YYBroadcastView.a(this.a).getText().length());
            }
          }200L);
    } 
  }
  
  public void a(boolean paramBoolean) {
    byte b;
    ShapeTextView shapeTextView = this.d;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    shapeTextView.setVisibility(b);
  }
  
  public void b(boolean paramBoolean) {
    byte b;
    ImageView imageView = this.g;
    if (paramBoolean) {
      b = 0;
    } else {
      b = 8;
    } 
    imageView.setVisibility(b);
  }
  
  public void getBroadcastContent() {
    YYRoomModel yYRoomModel = this.b;
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.g(yYRoomModel.room_id, new BluedUIHttpResponse<BluedEntityA<YYRoomDescModel>>(this, (IRequestHost)this.a.w_()) {
          protected void a(BluedEntityA<YYRoomDescModel> param1BluedEntityA) {
            if (param1BluedEntityA != null) {
              if (!param1BluedEntityA.hasData())
                return; 
              YYBroadcastView.a(this.a).setText(((YYRoomDescModel)param1BluedEntityA.getSingleData()).room_desc);
            } 
          }
          
          public void onUIFinish(boolean param1Boolean) {
            super.onUIFinish(param1Boolean);
            YYBroadcastView.c(this.a).setVisibility(8);
          }
          
          public void onUIStart() {
            super.onUIStart();
            YYBroadcastView.c(this.a).setVisibility(0);
          }
        }(IRequestHost)this.a.w_());
  }
  
  public void setContentMinHeight(int paramInt) {
    this.c.setMinHeight(paramInt);
  }
  
  public void setEditable(boolean paramBoolean) {
    this.c.setEnabled(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYBroadcastView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */