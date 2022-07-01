package com.soft.blued.ui.user.views;

import android.content.Context;
import android.view.View;
import com.soft.blued.customview.MoreOptionFromBtm;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.ShareEntity;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import com.soft.blued.ui.user.model.UserInfoEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserProfileBtmOptions extends MoreOptionFromBtm {
  private int g;
  
  private int h;
  
  private String i;
  
  public UserProfileBtmOptions(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener) {
    super(paramContext, paramBoolean1, paramBoolean2, paramOnClickListener);
  }
  
  public List<ShareOption> a() {
    ArrayList<ShareOption> arrayList = new ArrayList();
    if (this.d) {
      arrayList.add(new ShareOption(2131232657, 2131758499));
      return arrayList;
    } 
    arrayList.add(new ShareOption(2131232651, 2131755298));
    arrayList.add(new ShareOption(2131232661, 2131755239));
    arrayList.add(new ShareOption(2131232654, 2131756540));
    if (!this.e)
      arrayList.add(new ShareOption(2131232650, 2131755241)); 
    arrayList.add(new ShareOption(2131232660, 2131758584));
    return arrayList;
  }
  
  public void a(ShareEntity paramShareEntity, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener paramShareOptionsItemClickListener) {
    super.a(paramShareEntity, paramShareOptionsItemClickListener);
  }
  
  public void a(ShareEntity paramShareEntity, UserInfoEntity paramUserInfoEntity, ShareOptionRecyclerAdapter.ShareOptionsItemClickListener paramShareOptionsItemClickListener) {
    this.g = paramUserInfoEntity.access_private_photos;
    this.h = paramUserInfoEntity.secretly_followed_status;
    this.i = paramUserInfoEntity.relationship;
    a(paramShareEntity, paramShareOptionsItemClickListener);
  }
  
  public void a(List<ShareOption> paramList1, List<ShareOption> paramList2) {
    Iterator<ShareOption> iterator = paramList1.iterator();
    while (iterator.hasNext()) {
      if (((ShareOption)iterator.next()).iconResourceId == 2131232716)
        iterator.remove(); 
    } 
    if (!this.d) {
      iterator = paramList2.iterator();
      while (iterator.hasNext()) {
        ShareOption shareOption = iterator.next();
        if (shareOption.textResourceID == 2131758220 || shareOption.textResourceID == 2131755298) {
          int i = this.g;
          if (i == 1) {
            shareOption.iconResourceId = 2131232653;
            shareOption.textResourceID = 2131758220;
          } else if (i == 0) {
            shareOption.iconResourceId = 2131232651;
            shareOption.textResourceID = 2131755298;
          } else {
            iterator.remove();
          } 
        } 
        if (shareOption.iconResourceId == 2131232650 || shareOption.iconResourceId == 2131232659)
          if ("4".equals(this.i)) {
            shareOption.iconResourceId = 2131232659;
            shareOption.textResourceID = 2131758573;
          } else {
            shareOption.iconResourceId = 2131232650;
            shareOption.textResourceID = 2131755241;
          }  
        if (shareOption.iconResourceId == 2131232654 || shareOption.iconResourceId == 2131232655) {
          if (this.h == 1) {
            shareOption.iconResourceId = 2131232655;
            shareOption.textResourceID = 2131756545;
            continue;
          } 
          shareOption.iconResourceId = 2131232654;
          shareOption.textResourceID = 2131756540;
        } 
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\views\UserProfileBtmOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */