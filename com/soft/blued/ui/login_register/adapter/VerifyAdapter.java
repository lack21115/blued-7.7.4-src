package com.soft.blued.ui.login_register.adapter;

import android.content.Context;
import android.view.View;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.login_register.model.AccountNumberVerifyModel;
import java.util.ArrayList;
import java.util.List;

public class VerifyAdapter extends BaseQuickAdapter<AccountNumberVerifyModel, BaseViewHolder> {
  private ShapeTextView a;
  
  private Context b;
  
  public VerifyAdapter(Context paramContext) {
    super(2131493941, new ArrayList());
    this.b = paramContext;
  }
  
  private void a(ShapeTextView paramShapeTextView) {
    ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131100838);
    ShapeHelper.d((ShapeHelper.ShapeView)paramShapeTextView, 2131100838);
    ShapeHelper.b((ShapeHelper.ShapeView)paramShapeTextView, 2131100897);
    ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, DensityUtils.a(this.b, 1.0F), 0.0F, 0.0F);
  }
  
  private void b(ShapeTextView paramShapeTextView) {
    ShapeHelper.a((ShapeHelper.ShapeView)paramShapeTextView, 2131100728);
    ShapeHelper.b((ShapeHelper.ShapeView)paramShapeTextView, 2131100716);
    ShapeHelper.d((ShapeHelper.ShapeView)paramShapeTextView, 2131100716);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, AccountNumberVerifyModel paramAccountNumberVerifyModel) {
    if (paramBaseViewHolder != null) {
      this.a = (ShapeTextView)paramBaseViewHolder.d(2131301584);
      this.a.setText(paramAccountNumberVerifyModel.number);
      if (paramAccountNumberVerifyModel.isSelect) {
        b(this.a);
      } else {
        a(this.a);
      } 
      paramBaseViewHolder.a(2131301585, new View.OnClickListener(this, paramAccountNumberVerifyModel) {
            public void onClick(View param1View) {
              if (!this.a.isSelect) {
                for (int i = 0; i < VerifyAdapter.a(this.b).size(); i++)
                  ((AccountNumberVerifyModel)VerifyAdapter.b(this.b).get(i)).isSelect = false; 
                this.a.isSelect = true;
              } 
              this.b.notifyDataSetChanged();
            }
          });
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\adapter\VerifyAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */