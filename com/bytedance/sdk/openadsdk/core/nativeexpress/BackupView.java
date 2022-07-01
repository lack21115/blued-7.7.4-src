package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.core.a.a;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.i;
import com.bytedance.sdk.openadsdk.core.d.k;
import com.bytedance.sdk.openadsdk.dislike.b;
import com.bytedance.sdk.openadsdk.utils.ah;
import com.bytedance.sdk.openadsdk.utils.ai;

public abstract class BackupView extends FrameLayout {
  protected Context a;
  
  protected k b;
  
  protected b c;
  
  protected TTDislikeDialogAbstract d;
  
  protected String e = "embeded_ad";
  
  protected int f;
  
  protected int g;
  
  public BackupView(Context paramContext) {
    super(paramContext);
    setTag("tt_express_backup_fl_tag_26");
  }
  
  public void a() {
    TTDislikeDialogAbstract tTDislikeDialogAbstract = this.d;
    if (tTDislikeDialogAbstract != null) {
      tTDislikeDialogAbstract.show();
      return;
    } 
    b b1 = this.c;
    if (b1 != null)
      b1.showDislikeDialog(); 
  }
  
  protected abstract void a(int paramInt, i parami);
  
  protected void a(View paramView, boolean paramBoolean) {
    b b1;
    if (paramView == null)
      return; 
    if (paramBoolean) {
      Context context = this.a;
      k k1 = this.b;
      String str = this.e;
      a a = new a(context, k1, str, ah.a(str));
    } else {
      Context context = this.a;
      k k1 = this.b;
      String str = this.e;
      b1 = new b(context, k1, str, ah.a(str));
    } 
    paramView.setOnTouchListener((View.OnTouchListener)b1);
    paramView.setOnClickListener((View.OnClickListener)b1);
    b1.a(new a(this) {
          public void a(int param1Int, i param1i) {
            this.a.a(param1Int, param1i);
          }
        });
  }
  
  protected String getDescription() {
    return !TextUtils.isEmpty(this.b.J()) ? this.b.J() : (!TextUtils.isEmpty(this.b.K()) ? this.b.K() : "");
  }
  
  protected String getNameOrSource() {
    k k1 = this.b;
    return (k1 == null) ? "" : ((k1.N() != null && !TextUtils.isEmpty(this.b.N().c())) ? this.b.N().c() : (!TextUtils.isEmpty(this.b.A()) ? this.b.A() : ""));
  }
  
  public float getRealHeight() {
    return ai.b(this.a, this.g);
  }
  
  public float getRealWidth() {
    return ai.b(this.a, this.f);
  }
  
  public Object getTag() {
    return "tt_express_backup_fl_tag_26";
  }
  
  protected String getTitle() {
    return (this.b.N() != null && !TextUtils.isEmpty(this.b.N().c())) ? this.b.N().c() : (!TextUtils.isEmpty(this.b.A()) ? this.b.A() : (!TextUtils.isEmpty(this.b.J()) ? this.b.J() : ""));
  }
  
  public void setDislikeInner(TTAdDislike paramTTAdDislike) {
    if (paramTTAdDislike instanceof b) {
      k k1 = this.b;
      if (k1 != null)
        ((b)paramTTAdDislike).a(k1); 
      this.c = (b)paramTTAdDislike;
    } 
  }
  
  public void setDislikeOuter(TTDislikeDialogAbstract paramTTDislikeDialogAbstract) {
    if (paramTTDislikeDialogAbstract != null) {
      k k1 = this.b;
      if (k1 != null)
        paramTTDislikeDialogAbstract.setMaterialMeta(k1); 
    } 
    this.d = paramTTDislikeDialogAbstract;
  }
  
  public void setTag(Object paramObject) {
    super.setTag("tt_express_backup_fl_tag_26");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bytedance\sdk\openadsdk\core\nativeexpress\BackupView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */