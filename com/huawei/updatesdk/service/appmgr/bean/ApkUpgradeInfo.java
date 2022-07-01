package com.huawei.updatesdk.service.appmgr.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.updatesdk.a.b.d.c.b;
import java.io.Serializable;

public class ApkUpgradeInfo extends b implements Parcelable, Serializable {
  public static final int APP_MUST_UPDATE = 1;
  
  public static final Parcelable.Creator<ApkUpgradeInfo> CREATOR = new a();
  
  public static final int HUAWEI_OFFICIAL_APP = 1;
  
  public static final int NOT_AUTOUPDATE = 0;
  
  private static final String TAG = "ApkUpgradeInfo";
  
  public static final int UPGRADE_SAME_SIGNATURE = 0;
  
  private static final long serialVersionUID = 136275377334431721L;
  
  private long bundleSize_;
  
  private String detailId_;
  
  private int devType_ = 0;
  
  private String diffDownUrl;
  
  private String diffSha2_;
  
  private int diffSize_;
  
  private String downurl_;
  
  private String fullDownUrl_;
  
  private String icon_;
  
  private String id_;
  
  private int isAutoUpdate_ = 0;
  
  private int isCompulsoryUpdate_ = 0;
  
  private int maple_;
  
  private String name_;
  
  private String newFeatures_;
  
  private String notRcmReason_;
  
  private long obbSize_;
  
  private int oldVersionCode_;
  
  private String oldVersionName_;
  
  private String package_;
  
  private int packingType_;
  
  private String releaseDateDesc_;
  
  private String releaseDate_;
  
  private int sameS_ = 0;
  
  private String sha256_;
  
  private long size_;
  
  private int state_ = 2;
  
  private int versionCode_;
  
  private String version_;
  
  public ApkUpgradeInfo() {}
  
  protected ApkUpgradeInfo(Parcel paramParcel) {
    this.id_ = paramParcel.readString();
    this.name_ = paramParcel.readString();
    this.package_ = paramParcel.readString();
    this.oldVersionName_ = paramParcel.readString();
    this.version_ = paramParcel.readString();
    this.diffSize_ = paramParcel.readInt();
    this.diffDownUrl = paramParcel.readString();
    this.diffSha2_ = paramParcel.readString();
    this.sameS_ = paramParcel.readInt();
    this.size_ = paramParcel.readLong();
    this.obbSize_ = paramParcel.readLong();
    this.releaseDate_ = paramParcel.readString();
    this.icon_ = paramParcel.readString();
    this.oldVersionCode_ = paramParcel.readInt();
    this.versionCode_ = paramParcel.readInt();
    this.downurl_ = paramParcel.readString();
    this.sha256_ = paramParcel.readString();
    this.newFeatures_ = paramParcel.readString();
    this.releaseDateDesc_ = paramParcel.readString();
    this.state_ = paramParcel.readInt();
    this.detailId_ = paramParcel.readString();
    this.isAutoUpdate_ = paramParcel.readInt();
    this.isCompulsoryUpdate_ = paramParcel.readInt();
    this.notRcmReason_ = paramParcel.readString();
    this.devType_ = paramParcel.readInt();
    this.fullDownUrl_ = paramParcel.readString();
    this.maple_ = paramParcel.readInt();
    this.packingType_ = paramParcel.readInt();
    this.bundleSize_ = paramParcel.readLong();
  }
  
  public int describeContents() {
    return 0;
  }
  
  public long getBundleSize_() {
    return this.bundleSize_;
  }
  
  public String getDetailId_() {
    return this.detailId_;
  }
  
  public int getDevType_() {
    return this.devType_;
  }
  
  public String getDiffDownUrl_() {
    return this.diffDownUrl;
  }
  
  public String getDiffSha2_() {
    return this.diffSha2_;
  }
  
  public int getDiffSize_() {
    return this.diffSize_;
  }
  
  public String getDownurl_() {
    return this.downurl_;
  }
  
  public String getFullDownUrl_() {
    return this.fullDownUrl_;
  }
  
  public String getIcon_() {
    return this.icon_;
  }
  
  public String getId_() {
    return this.id_;
  }
  
  public int getIsAutoUpdate_() {
    return this.isAutoUpdate_;
  }
  
  public int getIsCompulsoryUpdate_() {
    return this.isCompulsoryUpdate_;
  }
  
  public long getLongSize_() {
    return this.size_;
  }
  
  public int getMaple_() {
    return this.maple_;
  }
  
  public String getName_() {
    return this.name_;
  }
  
  public String getNewFeatures_() {
    return this.newFeatures_;
  }
  
  public String getNotRcmReason_() {
    return this.notRcmReason_;
  }
  
  public long getObbSize_() {
    return this.obbSize_;
  }
  
  public int getOldVersionCode_() {
    return this.oldVersionCode_;
  }
  
  public String getOldVersionName_() {
    return this.oldVersionName_;
  }
  
  public String getPackage_() {
    return this.package_;
  }
  
  public int getPackingType_() {
    return this.packingType_;
  }
  
  public String getReleaseDateDesc_() {
    return this.releaseDateDesc_;
  }
  
  public String getReleaseDate_() {
    return this.releaseDate_;
  }
  
  public int getSameS_() {
    return this.sameS_;
  }
  
  public String getSha256_() {
    return this.sha256_;
  }
  
  @Deprecated
  public int getSize_() {
    return (int)this.size_;
  }
  
  public int getState_() {
    return this.state_;
  }
  
  public int getVersionCode_() {
    return this.versionCode_;
  }
  
  public String getVersion_() {
    return this.version_;
  }
  
  public void setBundleSize_(long paramLong) {
    this.bundleSize_ = paramLong;
  }
  
  public void setDetailId_(String paramString) {
    this.detailId_ = paramString;
  }
  
  public void setDevType_(int paramInt) {
    this.devType_ = paramInt;
  }
  
  public void setDiffDownUrl_(String paramString) {
    this.diffDownUrl = paramString;
  }
  
  public void setDiffSha2_(String paramString) {
    this.diffSha2_ = paramString;
  }
  
  public void setDiffSize_(int paramInt) {
    this.diffSize_ = paramInt;
  }
  
  public void setDownurl_(String paramString) {
    this.downurl_ = paramString;
  }
  
  public void setFullDownUrl_(String paramString) {
    this.fullDownUrl_ = paramString;
  }
  
  public void setIcon_(String paramString) {
    this.icon_ = paramString;
  }
  
  public void setId_(String paramString) {
    this.id_ = paramString;
  }
  
  public void setIsAutoUpdate_(int paramInt) {
    this.isAutoUpdate_ = paramInt;
  }
  
  public void setIsCompulsoryUpdate_(int paramInt) {
    this.isCompulsoryUpdate_ = paramInt;
  }
  
  public void setMaple_(int paramInt) {
    this.maple_ = paramInt;
  }
  
  public void setName_(String paramString) {
    this.name_ = paramString;
  }
  
  public void setNewFeatures_(String paramString) {
    this.newFeatures_ = paramString;
  }
  
  public void setNotRcmReason_(String paramString) {
    this.notRcmReason_ = paramString;
  }
  
  public void setObbSize_(long paramLong) {
    this.obbSize_ = paramLong;
  }
  
  public void setOldVersionCode_(int paramInt) {
    this.oldVersionCode_ = paramInt;
  }
  
  public void setOldVersionName_(String paramString) {
    this.oldVersionName_ = paramString;
  }
  
  public void setPackage_(String paramString) {
    this.package_ = paramString;
  }
  
  public void setPackingType_(int paramInt) {
    this.packingType_ = paramInt;
  }
  
  public void setReleaseDateDesc_(String paramString) {
    this.releaseDateDesc_ = paramString;
  }
  
  public void setReleaseDate_(String paramString) {
    this.releaseDate_ = paramString;
  }
  
  public void setSameS_(int paramInt) {
    this.sameS_ = paramInt;
  }
  
  public void setSha256_(String paramString) {
    this.sha256_ = paramString;
  }
  
  public void setSize_(long paramLong) {
    this.size_ = paramLong;
  }
  
  public void setState_(int paramInt) {
    this.state_ = paramInt;
  }
  
  public void setVersionCode_(int paramInt) {
    this.versionCode_ = paramInt;
  }
  
  public void setVersion_(String paramString) {
    this.version_ = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" {\n\tid_: ");
    stringBuilder.append(getId_());
    stringBuilder.append("\n\tname_: ");
    stringBuilder.append(getName_());
    stringBuilder.append("\n\tpackage_: ");
    stringBuilder.append(getPackage_());
    stringBuilder.append("\n\tversion_: ");
    stringBuilder.append(getVersion_());
    stringBuilder.append("\n\tdiffSize_: ");
    stringBuilder.append(getDiffSize_());
    stringBuilder.append("\n\tdiffDownUrl_: ");
    stringBuilder.append(getDiffDownUrl_());
    stringBuilder.append("\n\tdiffSha2_: ");
    stringBuilder.append(getDiffSha2_());
    stringBuilder.append("\n\tsameS_: ");
    stringBuilder.append(getSameS_());
    stringBuilder.append("\n\tsize_: ");
    stringBuilder.append(getLongSize_());
    stringBuilder.append("\n\treleaseDate_: ");
    stringBuilder.append(getReleaseDate_());
    stringBuilder.append("\n\ticon_: ");
    stringBuilder.append(getIcon_());
    stringBuilder.append("\n\toldVersionCode_: ");
    stringBuilder.append(getOldVersionCode_());
    stringBuilder.append("\n\tversionCode_: ");
    stringBuilder.append(getVersionCode_());
    stringBuilder.append("\n\tdownurl_: ");
    stringBuilder.append(getDownurl_());
    stringBuilder.append("\n\tnewFeatures_: ");
    stringBuilder.append(getNewFeatures_());
    stringBuilder.append("\n\treleaseDateDesc_: ");
    stringBuilder.append(getReleaseDateDesc_());
    stringBuilder.append("\n\tstate_: ");
    stringBuilder.append(getState_());
    stringBuilder.append("\n\tdetailId_: ");
    stringBuilder.append(getDetailId_());
    stringBuilder.append("\n\tfullDownUrl_: ");
    stringBuilder.append(getFullDownUrl_());
    stringBuilder.append("\n\tisCompulsoryUpdate_: ");
    stringBuilder.append(getIsCompulsoryUpdate_());
    stringBuilder.append("\n\tnotRcmReason_: ");
    stringBuilder.append(getNotRcmReason_());
    stringBuilder.append("\n\tdevType_: ");
    stringBuilder.append(getDevType_());
    stringBuilder.append("\n}");
    return stringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {
    paramParcel.writeString(this.id_);
    paramParcel.writeString(this.name_);
    paramParcel.writeString(this.package_);
    paramParcel.writeString(this.oldVersionName_);
    paramParcel.writeString(this.version_);
    paramParcel.writeInt(this.diffSize_);
    paramParcel.writeString(this.diffDownUrl);
    paramParcel.writeString(this.diffSha2_);
    paramParcel.writeInt(this.sameS_);
    paramParcel.writeLong(this.size_);
    paramParcel.writeLong(this.obbSize_);
    paramParcel.writeString(this.releaseDate_);
    paramParcel.writeString(this.icon_);
    paramParcel.writeInt(this.oldVersionCode_);
    paramParcel.writeInt(this.versionCode_);
    paramParcel.writeString(this.downurl_);
    paramParcel.writeString(this.sha256_);
    paramParcel.writeString(this.newFeatures_);
    paramParcel.writeString(this.releaseDateDesc_);
    paramParcel.writeInt(this.state_);
    paramParcel.writeString(this.detailId_);
    paramParcel.writeInt(this.isAutoUpdate_);
    paramParcel.writeInt(this.isCompulsoryUpdate_);
    paramParcel.writeString(this.notRcmReason_);
    paramParcel.writeInt(this.devType_);
    paramParcel.writeString(this.fullDownUrl_);
    paramParcel.writeInt(this.maple_);
    paramParcel.writeInt(this.packingType_);
    paramParcel.writeLong(this.bundleSize_);
  }
  
  static final class a implements Parcelable.Creator<ApkUpgradeInfo> {
    public ApkUpgradeInfo createFromParcel(Parcel param1Parcel) {
      return new ApkUpgradeInfo(param1Parcel);
    }
    
    public ApkUpgradeInfo[] newArray(int param1Int) {
      return new ApkUpgradeInfo[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawe\\updatesdk\service\appmgr\bean\ApkUpgradeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */