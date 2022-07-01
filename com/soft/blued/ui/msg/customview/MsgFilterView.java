package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.das.message.MessageProtos;
import com.soft.blued.log.trackUtils.EventTrackMessage;
import com.soft.blued.ui.msg.contract.IMsgFilterCallback;

public class MsgFilterView extends FrameLayout implements View.OnClickListener {
  private IMsgFilterCallback a;
  
  private View b;
  
  private View c;
  
  private View d;
  
  private View e;
  
  private View f;
  
  private TextView g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private TextView k;
  
  public MsgFilterView(Context paramContext) {
    this(paramContext, null);
  }
  
  public MsgFilterView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MsgFilterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet) {
    View view = a(paramContext);
    this.b = view.findViewById(2131299255);
    this.b.setOnClickListener(this);
    this.c = view.findViewById(2131299256);
    this.d = view.findViewById(2131299254);
    this.f = view.findViewById(2131299246);
    this.f.setOnClickListener(this);
    this.e = view.findViewById(2131299248);
    this.g = (TextView)view.findViewById(2131299257);
    this.h = (TextView)view.findViewById(2131299253);
    this.h.setOnClickListener(this);
    this.i = (TextView)view.findViewById(2131299251);
    this.i.setOnClickListener(this);
    this.j = (TextView)view.findViewById(2131299249);
    this.j.setOnClickListener(this);
    this.k = (TextView)view.findViewById(2131299252);
    this.k.setOnClickListener(this);
  }
  
  private void a(boolean paramBoolean) {
    this.a.e(paramBoolean);
    setFilterSwitch(false);
    this.i.setSelected(false);
    this.j.setSelected(false);
    this.k.setSelected(false);
  }
  
  private void c() {
    setFilterSwitch(this.a.L());
  }
  
  private void d() {
    TextView textView = this.i;
    if (textView != null) {
      MessageProtos.MsgScreenClickType msgScreenClickType;
      int i = textView.isSelected() ^ true;
      setNewMessageStatus(false);
      setSwitchInitiatorButton(i);
      MessageProtos.Event event = MessageProtos.Event.MSG_SCREEN_STARTED_BTN_CLICK;
      if (i != 0) {
        msgScreenClickType = MessageProtos.MsgScreenClickType.MSG_SCREEN_CLICK_TYPE_OPEN;
      } else {
        msgScreenClickType = MessageProtos.MsgScreenClickType.MSG_SCREEN_CLICK_TYPE_CLOSE;
      } 
      EventTrackMessage.a(event, msgScreenClickType);
    } 
  }
  
  private void e() {
    TextView textView = this.j;
    if (textView != null) {
      MessageProtos.MsgScreenClickType msgScreenClickType;
      int i = textView.isSelected() ^ true;
      setNewMessageStatus(false);
      setSwitchFollowerButton(i);
      MessageProtos.Event event = MessageProtos.Event.MSG_SCREEN_FOLLOWED_BTN_CLICK;
      if (i != 0) {
        msgScreenClickType = MessageProtos.MsgScreenClickType.MSG_SCREEN_CLICK_TYPE_OPEN;
      } else {
        msgScreenClickType = MessageProtos.MsgScreenClickType.MSG_SCREEN_CLICK_TYPE_CLOSE;
      } 
      EventTrackMessage.a(event, msgScreenClickType);
    } 
  }
  
  private void f() {
    TextView textView = this.k;
    if (textView != null) {
      MessageProtos.MsgScreenClickType msgScreenClickType;
      int i = textView.isSelected() ^ true;
      setNewMessageStatus(false);
      setSwitchNearbyButton(i);
      MessageProtos.Event event = MessageProtos.Event.MSG_SCREEN_NEARBY_BTN_CLICK;
      if (i != 0) {
        msgScreenClickType = MessageProtos.MsgScreenClickType.MSG_SCREEN_CLICK_TYPE_OPEN;
      } else {
        msgScreenClickType = MessageProtos.MsgScreenClickType.MSG_SCREEN_CLICK_TYPE_CLOSE;
      } 
      EventTrackMessage.a(event, msgScreenClickType);
    } 
  }
  
  private void setFilterSwitch(boolean paramBoolean) {
    TextView textView2 = this.g;
    if (textView2 != null) {
      int i;
      if (paramBoolean) {
        i = 2131757976;
      } else {
        i = 2131757971;
      } 
      textView2.setText(i);
    } 
    View view = this.b;
    if (view != null) {
      view.setSelected(paramBoolean);
      if (this.e.getVisibility() == 0) {
        this.c.setSelected(true);
      } else {
        this.c.setSelected(false);
      } 
    } 
    view = this.d;
    if (view != null)
      view.setSelected(paramBoolean); 
    TextView textView1 = this.h;
    if (textView1 != null)
      textView1.setSelected(paramBoolean); 
    if (!paramBoolean) {
      View view1 = this.f;
      if (view1 != null && view1.getVisibility() == 0)
        this.f.setVisibility(8); 
    } 
  }
  
  private void setSwitchFollowerButton(boolean paramBoolean) {
    this.j.setSelected(paramBoolean);
    this.a.c(paramBoolean);
    c();
  }
  
  private void setSwitchInitiatorButton(boolean paramBoolean) {
    this.i.setSelected(paramBoolean);
    this.a.b(paramBoolean);
    c();
  }
  
  private void setSwitchNearbyButton(boolean paramBoolean) {
    this.k.setSelected(paramBoolean);
    this.a.d(paramBoolean);
    c();
  }
  
  protected View a(Context paramContext) {
    return View.inflate(paramContext, 2131494248, (ViewGroup)this);
  }
  
  public void a() {
    if (this.e.getVisibility() == 0) {
      this.e.setVisibility(8);
      this.c.setSelected(false);
      EventTrackMessage.a(MessageProtos.Event.MSG_SCREEN_FOLD);
    } 
  }
  
  public void b() {
    if (this.e.getVisibility() == 8) {
      this.e.setVisibility(0);
      this.c.setSelected(true);
    } 
    EventTrackMessage.a(MessageProtos.Event.MSG_SCREEN_UNFOLD);
  }
  
  public void onClick(View paramView) {
    if (this.a != null) {
      switch (paramView.getId()) {
        default:
          return;
        case 2131299255:
          if (this.e.getVisibility() == 0) {
            a();
            this.a.H();
            return;
          } 
          b();
          this.a.G();
          return;
        case 2131299253:
          if (this.a.L()) {
            a(false);
            EventTrackMessage.a(MessageProtos.Event.MSG_SCREEN_UNFOLD_RESET_BTN_CLICK);
            return;
          } 
          return;
        case 2131299252:
          f();
          return;
        case 2131299251:
          d();
          return;
        case 2131299249:
          e();
          return;
        case 2131299246:
          break;
      } 
      a(true);
      EventTrackMessage.a(MessageProtos.Event.MSG_SCREEN_FOLD_CLOSE_BTN_CLICK);
    } 
  }
  
  public void setCallback(IMsgFilterCallback paramIMsgFilterCallback) {
    this.a = paramIMsgFilterCallback;
    paramIMsgFilterCallback = this.a;
    if (paramIMsgFilterCallback != null) {
      this.i.setSelected(paramIMsgFilterCallback.I());
      this.j.setSelected(this.a.J());
      this.k.setSelected(this.a.K());
    } 
    c();
  }
  
  public void setNewMessageStatus(boolean paramBoolean) {
    View view = this.f;
    if (view != null) {
      if (paramBoolean) {
        view.setVisibility(0);
        return;
      } 
      view.setVisibility(8);
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\customview\MsgFilterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */