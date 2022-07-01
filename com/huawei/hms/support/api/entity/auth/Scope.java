package com.huawei.hms.support.api.entity.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.core.aidl.IMessageEntity;

public class Scope implements Parcelable, IMessageEntity {
  public static final Parcelable.Creator<Scope> CREATOR = new Parcelable.Creator<Scope>() {
      public Scope createFromParcel(Parcel param1Parcel) {
        return new Scope(param1Parcel);
      }
      
      public Scope[] newArray(int param1Int) {
        return new Scope[param1Int];
      }
    };
  
  private String mScopeUri = null;
  
  public Scope() {}
  
  protected Scope(Parcel paramParcel) {}
  
  public Scope(String paramString) {}
  
  public int describeContents() {
    return 0;
  }
  
  public boolean equals(Object paramObject) {
    if (this == paramObject)
      return true; 
    if (!(paramObject instanceof Scope))
      return false; 
    paramObject = paramObject;
    return Objects.equal(this.mScopeUri, ((Scope)paramObject).mScopeUri);
  }
  
  @Deprecated
  public boolean equeals(Object paramObject) {
    return equals(paramObject);
  }
  
  public String getScopeUri() {
    return this.mScopeUri;
  }
  
  public final int hashCode() {
    String str = this.mScopeUri;
    return (str == null) ? super.hashCode() : str.hashCode();
  }
  
  public final String toString() {
    return this.mScopeUri;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.mScopeUri);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\support\api\entity\auth\Scope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */