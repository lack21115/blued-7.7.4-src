package com.amap.api.services.help;

import android.content.Context;
import com.amap.api.col.s.ba;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.List;

public final class Inputtips {
  private IInputtipsSearch a = null;
  
  public Inputtips(Context paramContext, InputtipsListener paramInputtipsListener) {
    if (this.a == null)
      try {
        this.a = (IInputtipsSearch)new ba(paramContext, paramInputtipsListener);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public Inputtips(Context paramContext, InputtipsQuery paramInputtipsQuery) {
    if (this.a == null)
      try {
        this.a = (IInputtipsSearch)new ba(paramContext, paramInputtipsQuery);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
  }
  
  public final InputtipsQuery getQuery() {
    IInputtipsSearch iInputtipsSearch = this.a;
    return (iInputtipsSearch != null) ? iInputtipsSearch.getQuery() : null;
  }
  
  public final List<Tip> requestInputtips() throws AMapException {
    IInputtipsSearch iInputtipsSearch = this.a;
    return (iInputtipsSearch != null) ? iInputtipsSearch.requestInputtips() : null;
  }
  
  public final void requestInputtips(String paramString1, String paramString2) throws AMapException {
    IInputtipsSearch iInputtipsSearch = this.a;
    if (iInputtipsSearch != null)
      iInputtipsSearch.requestInputtips(paramString1, paramString2); 
  }
  
  public final void requestInputtips(String paramString1, String paramString2, String paramString3) throws AMapException {
    IInputtipsSearch iInputtipsSearch = this.a;
    if (iInputtipsSearch != null)
      iInputtipsSearch.requestInputtips(paramString1, paramString2, paramString3); 
  }
  
  public final void requestInputtipsAsyn() {
    IInputtipsSearch iInputtipsSearch = this.a;
    if (iInputtipsSearch != null)
      iInputtipsSearch.requestInputtipsAsyn(); 
  }
  
  public final void setInputtipsListener(InputtipsListener paramInputtipsListener) {
    IInputtipsSearch iInputtipsSearch = this.a;
    if (iInputtipsSearch != null)
      iInputtipsSearch.setInputtipsListener(paramInputtipsListener); 
  }
  
  public final void setQuery(InputtipsQuery paramInputtipsQuery) {
    IInputtipsSearch iInputtipsSearch = this.a;
    if (iInputtipsSearch != null)
      iInputtipsSearch.setQuery(paramInputtipsQuery); 
  }
  
  public static interface InputtipsListener {
    void onGetInputtips(List<Tip> param1List, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\services\help\Inputtips.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */