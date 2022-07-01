package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.soft.blued.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\000,\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\007\n\002\020\b\n\000\n\002\020\002\n\002\b\002\030\0002\0020\001:\001\022B\037\022\006\020\002\032\0020\003\022\b\b\002\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\b\020\016\032\0020\017H\024J\b\020\020\032\0020\021H\024R\032\020\004\032\0020\005X\016¢\006\016\n\000\032\004\b\004\020\t\"\004\b\n\020\013R\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\f\020\r¨\006\023"}, d2 = {"Lcom/soft/blued/ui/msg/pop/PicPinPop;", "Lcom/blued/android/framework/ui/xpop/core/AttachPopupView;", "context", "Landroid/content/Context;", "isSelect", "", "listener", "Lcom/soft/blued/ui/msg/pop/PicPinPop$OperateListener;", "(Landroid/content/Context;ZLcom/soft/blued/ui/msg/pop/PicPinPop$OperateListener;)V", "()Z", "setSelect", "(Z)V", "getListener", "()Lcom/soft/blued/ui/msg/pop/PicPinPop$OperateListener;", "getImplLayoutId", "", "initPopupContent", "", "OperateListener", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
public final class PicPinPop extends AttachPopupView {
  private boolean t;
  
  private final OperateListener u;
  
  private HashMap v;
  
  public PicPinPop(Context paramContext, boolean paramBoolean, OperateListener paramOperateListener) {
    super(paramContext);
    this.t = paramBoolean;
    this.u = paramOperateListener;
  }
  
  public View a(int paramInt) {
    if (this.v == null)
      this.v = new HashMap<Object, Object>(); 
    View view2 = (View)this.v.get(Integer.valueOf(paramInt));
    View view1 = view2;
    if (view2 == null) {
      view1 = findViewById(paramInt);
      this.v.put(Integer.valueOf(paramInt), view1);
    } 
    return view1;
  }
  
  public void b() {
    int i;
    super.b();
    TextView textView = (TextView)a(R.id.tv_pin);
    Intrinsics.a(textView, "tv_pin");
    Context context = getContext();
    if (this.t) {
      i = 2131758060;
    } else {
      i = 2131758056;
    } 
    textView.setText(context.getString(i));
    ((TextView)a(R.id.tv_pin)).setOnClickListener(new PicPinPop$initPopupContent$1(this));
    ((TextView)a(R.id.tv_remove)).setOnClickListener(new PicPinPop$initPopupContent$2(this));
  }
  
  public int getImplLayoutId() {
    return 2131494052;
  }
  
  public final OperateListener getListener() {
    return this.u;
  }
  
  public final void setSelect(boolean paramBoolean) {
    this.t = paramBoolean;
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\002\b\002\bf\030\0002\0020\001J\b\020\002\032\0020\003H&J\b\020\004\032\0020\003H&¨\006\005"}, d2 = {"Lcom/soft/blued/ui/msg/pop/PicPinPop$OperateListener;", "", "OnRemove", "", "onPin", "blued_app_a9999aRelease"}, k = 1, mv = {1, 1, 16})
  public static interface OperateListener {
    void a();
    
    void b();
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class PicPinPop$initPopupContent$1 implements View.OnClickListener {
    PicPinPop$initPopupContent$1(PicPinPop param1PicPinPop) {}
    
    public final void onClick(View param1View) {
      this.a.getListener().b();
      this.a.p();
    }
  }
  
  @Metadata(bv = {1, 0, 3}, d1 = {"\000\020\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\016\020\002\032\n \004*\004\030\0010\0030\003H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 1, 16})
  static final class PicPinPop$initPopupContent$2 implements View.OnClickListener {
    PicPinPop$initPopupContent$2(PicPinPop param1PicPinPop) {}
    
    public final void onClick(View param1View) {
      this.a.getListener().a();
      this.a.p();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\PicPinPop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */