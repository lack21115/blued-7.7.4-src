package com.tencent.avroom;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.avprotocol.TXCAVProtocol;
import com.tencent.liteav.basic.b.c;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.d;
import com.tencent.liteav.i;
import com.tencent.liteav.j;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.liteav.qos.a;
import com.tencent.liteav.renderer.a;
import com.tencent.liteav.renderer.d;
import com.tencent.liteav.renderer.f;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TXCAVRoom {
  private static final int AVROOM_ENTERED = 2;
  
  private static final int AVROOM_ENTERING = 1;
  
  private static final int AVROOM_EXITING = 3;
  
  private static final int AVROOM_IDLE = 0;
  
  private static final String TAG = TXCAVRoom.class.getSimpleName();
  
  private static int videoMemNum = 0;
  
  private boolean allowedPush = false;
  
  private int appid;
  
  private TXCAVRoomCallback enterRoomCB;
  
  private TXCloudVideoView localView;
  
  private TXCAVRoomLisenter mAvRoomLisenter;
  
  private b mCaptureDataCollection;
  
  private Context mContext;
  
  private i mLivePushConfig;
  
  private d mPusher;
  
  private TXCQoS mQos;
  
  private TXCAVRoomConfig mRoomConfig;
  
  private TXCAVProtocol mTXCAVProtocol;
  
  private Handler mainHandler;
  
  private int maxReconnectCount;
  
  private long myid;
  
  private HashMap<Long, c> playerList = new HashMap<Long, c>();
  
  private TXCAVProtocol.TXCAVProtoParam protoparam;
  
  private int reconnectCount;
  
  private int roomStatus;
  
  private int sdkVersion;
  
  private ArrayList<Long> videoMemList = new ArrayList<Long>();
  
  private c videoResolution;
  
  public TXCAVRoom(Context paramContext, TXCAVRoomConfig paramTXCAVRoomConfig, long paramLong, int paramInt) {
    TXCAVProtocol tXCAVProtocol = new TXCAVProtocol();
    tXCAVProtocol.getClass();
    this.protoparam = new TXCAVProtocol.TXCAVProtoParam(tXCAVProtocol);
    this.mQos = null;
    this.maxReconnectCount = 10;
    this.reconnectCount = 0;
    this.myid = -1L;
    this.appid = -1;
    this.sdkVersion = 26215104;
    this.mainHandler = new Handler(Looper.getMainLooper());
    this.roomStatus = 0;
    this.videoResolution = c.c;
    this.mContext = paramContext;
    this.mRoomConfig = paramTXCAVRoomConfig;
    this.myid = paramLong;
    this.appid = paramInt;
    this.mPusher = new d(paramContext);
    this.mPusher.a(new d.a() {
          public void onBackgroudPushStop() {}
          
          public void onEncVideo(TXSNALPacket param1TXSNALPacket) {
            if (TXCAVRoom.this.allowedPush)
              TXCAVRoom.this.mTXCAVProtocol.pushNAL(param1TXSNALPacket); 
          }
          
          public void onEncVideoFormat(MediaFormat param1MediaFormat) {}
        });
    d d1 = this.mPusher;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("");
    stringBuilder.append(this.myid);
    d1.setID(stringBuilder.toString());
    this.mPusher.a(new b() {
          public void onNotifyEvent(int param1Int, Bundle param1Bundle) {
            TXCAVRoom.this.onBothNotifyEvent(param1Int, param1Bundle);
          }
        });
    applyCaptureConfig();
    this.mTXCAVProtocol = new TXCAVProtocol();
    this.mTXCAVProtocol.setListener(new TXCAVProtocol.TXIAVListener() {
          public void onMemberChange(final long userid, final boolean isEnter) {
            String str = TXCAVRoom.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onMemberChange: ");
            stringBuilder.append(userid);
            stringBuilder.append(" flag:");
            stringBuilder.append(isEnter);
            TXCLog.i(str, stringBuilder.toString());
            TXCAVRoom.this.mainHandler.post(new Runnable() {
                  public void run() {
                    if (isEnter) {
                      TXCAVRoom.this.addRender(userid);
                    } else {
                      TXCAVRoom.this.removeRender(Long.valueOf(userid));
                    } 
                    TXCAVRoom.this.mAvRoomLisenter.onMemberChange(userid, isEnter);
                  }
                });
          }
          
          public void onPullAudio(TXCAVProtocol.TXSAVProtoAudioPacket param1TXSAVProtoAudioPacket) {
            synchronized (TXCAVRoom.this) {
              synchronized (TXCAVRoom.this.playerList) {
                if (TXCAVRoom.this.playerList.get(Long.valueOf(param1TXSAVProtoAudioPacket.tinyID)) != null) {
                  if (TXCAudioEngine.getInstance().isRemoteAudioPlaying(String.valueOf(TXCAVRoom.this.myid))) {
                    param1TXSAVProtoAudioPacket.audioData = new byte[2];
                    param1TXSAVProtoAudioPacket.packetType = 2;
                    TXCAVRoomConstants.makeAACCodecSpecificData(param1TXSAVProtoAudioPacket.audioData, 2, param1TXSAVProtoAudioPacket.sampleRate, param1TXSAVProtoAudioPacket.channelsPerSample);
                    String str = TXCAVRoom.TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("audioKey: makeAACCodecSpecificData id ");
                    stringBuilder.append(param1TXSAVProtoAudioPacket.tinyID);
                    TXCLog.i(str, stringBuilder.toString());
                  } 
                  if (TXCAVRoom.this.playerList.get(Long.valueOf(param1TXSAVProtoAudioPacket.tinyID)) != null && ((c)TXCAVRoom.this.playerList.get(Long.valueOf(param1TXSAVProtoAudioPacket.tinyID))).a() != null && param1TXSAVProtoAudioPacket.audioData != null)
                    ((c)TXCAVRoom.this.playerList.get(Long.valueOf(param1TXSAVProtoAudioPacket.tinyID))).a().b(param1TXSAVProtoAudioPacket.audioData.length); 
                } 
                return;
              } 
            } 
          }
          
          public void onPullNAL(TXCAVProtocol.TXSAVProtoNALPacket param1TXSAVProtoNALPacket) {
            synchronized (TXCAVRoom.this.playerList) {
              if (TXCAVRoom.this.playerList.get(Long.valueOf(param1TXSAVProtoNALPacket.tinyID)) != null) {
                if (((c)TXCAVRoom.this.playerList.get(Long.valueOf(param1TXSAVProtoNALPacket.tinyID))).a() != null)
                  ((c)TXCAVRoom.this.playerList.get(Long.valueOf(param1TXSAVProtoNALPacket.tinyID))).a().a(param1TXSAVProtoNALPacket.nalData.length); 
                ((c)TXCAVRoom.this.playerList.get(Long.valueOf(param1TXSAVProtoNALPacket.tinyID))).decVideo((TXSNALPacket)param1TXSAVProtoNALPacket);
              } 
              return;
            } 
          }
          
          public void onVideoStateChange(final long userid, final boolean flag) {
            String str = TXCAVRoom.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onVideoStateChange: ");
            stringBuilder.append(userid);
            stringBuilder.append(" flag:");
            stringBuilder.append(flag);
            TXCLog.i(str, stringBuilder.toString());
            TXCAVRoom.this.mainHandler.post(new Runnable() {
                  public void run() {
                    TXCAVRoom.this.mAvRoomLisenter.onVideoStateChange(userid, flag);
                  }
                });
          }
          
          public void sendNotifyEvent(final int fevent, String param1String) {
            if (fevent != -3301) {
              if (fevent != 1018) {
                if (fevent != 1019) {
                  switch (fevent) {
                    default:
                      switch (fevent) {
                        default:
                          break;
                        case 8003:
                          fevent = TXCAVRoomConstants.AVROOM_EVT_REQUEST_AVSEAT_SUCC;
                          break;
                        case 8002:
                          fevent = TXCAVRoomConstants.AVROOM_EVT_CONNECT_SUCC;
                          break;
                        case 8001:
                          break;
                      } 
                      fevent = TXCAVRoomConstants.AVROOM_EVT_REQUEST_IP_SUCC;
                      break;
                    case -3303:
                      fevent = TXCAVRoomConstants.AVROOM_ERR_REQUEST_IP_FAIL;
                      break;
                    case -3304:
                      fevent = TXCAVRoomConstants.AVROOM_ERR_CONNECT_FAILE;
                      break;
                    case -3305:
                      fevent = TXCAVRoomConstants.AVROOM_ERR_REQUEST_AVSEAT_FAIL;
                      break;
                  } 
                } else {
                  fevent = TXCAVRoomConstants.AVROOM_EVT_EXIT_ROOM_SUCC;
                } 
              } else {
                fevent = TXCAVRoomConstants.AVROOM_EVT_ENTER_ROOM_SUCC;
              } 
            } else {
              fevent = TXCAVRoomConstants.AVROOM_ERR_ENTER_ROOM_FAIL;
            } 
            final Bundle bundle = new Bundle();
            bundle.putInt("EVT_ID", fevent);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            bundle.putString("EVT_MSG", param1String);
            ((Activity)TXCAVRoom.this.mContext).runOnUiThread(new Runnable() {
                  public void run() {
                    TXCAVRoom.this.mAvRoomLisenter.onAVRoomEvent(TXCAVRoom.this.myid, fevent, bundle);
                  }
                });
            if (fevent == -3302)
              TXCAVRoom.this.reconnectRoom(); 
          }
        });
  }
  
  private void addRender(long paramLong) {
    synchronized (this.playerList) {
      if (this.playerList.get(Long.valueOf(paramLong)) == null) {
        c c1 = new c(this.mContext);
        c1.setID(String.valueOf(paramLong));
        c1.setNotifyListener(new b() {
              public void onNotifyEvent(int param1Int, Bundle param1Bundle) {
                TXCAVRoom.this.onBothNotifyEvent(param1Int, param1Bundle);
              }
            });
        j j = getRenderConfig();
        c1.setConfig(j);
        c1.setRenderMode(this.mRoomConfig.getRemoteRenderMode());
        c1.setRenderRotation(TXCAVRoomConstants.AVROOM_HOME_ORIENTATION_RIGHT);
        if (j.h) {
          c1.setVideoRender((f)new d());
        } else {
          c1.setVideoRender((f)new a());
        } 
        this.playerList.put(Long.valueOf(paramLong), c1);
      } 
      ((c)this.playerList.get(Long.valueOf(paramLong))).start(true);
      return;
    } 
  }
  
  private void applyCaptureConfig() {
    throw new RuntimeException("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private j getRenderConfig() {
    j j = new j();
    j.a(true);
    j.a(TXCAVRoomConstants.AVROOM_CACHETIME);
    j.b(TXCAVRoomConstants.AVROOM_MAX_ADJUSTCACHETIME);
    j.h = this.mRoomConfig.isEnableVideoHWAcceleration();
    return j;
  }
  
  private void onBothNotifyEvent(final int fevent, Bundle paramBundle) {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("AVROOM onNotifyEvent: ");
    stringBuilder.append(paramBundle.getString("EVT_MSG"));
    TXCLog.i(str, stringBuilder.toString());
    if (this.mAvRoomLisenter != null) {
      final Long userID = Long.valueOf(paramBundle.getLong("EVT_USERID"));
      if (fevent != 1003) {
        if (fevent != 1103) {
          if (fevent != 2101) {
            if (fevent != 2003) {
              if (fevent != 2004) {
                if (fevent != 2007) {
                  if (fevent != 2008) {
                    if (fevent != 2105) {
                      if (fevent != 2106) {
                        switch (fevent) {
                          default:
                            switch (fevent) {
                              default:
                                return;
                              case 1008:
                                fevent = TXCAVRoomConstants.AVROOM_EVT_START_VIDEO_ENCODER;
                                break;
                              case 1007:
                                fevent = TXCAVRoomConstants.AVROOM_EVT_FIRST_FRAME_AVAILABLE;
                                break;
                              case 1005:
                                fevent = TXCAVRoomConstants.AVROOM_EVT_UP_CHANGE_RESOLUTION;
                                break;
                              case 1006:
                                break;
                            } 
                            fevent = TXCAVRoomConstants.AVROOM_EVT_UP_CHANGE_BITRATE;
                            break;
                          case -1301:
                            fevent = TXCAVRoomConstants.AVROOM_ERR_OPEN_CAMERA_FAIL;
                            break;
                          case -1302:
                            fevent = TXCAVRoomConstants.AVROOM_ERR_OPEN_MIC_FAIL;
                            break;
                          case -1303:
                            fevent = TXCAVRoomConstants.AVROOM_ERR_VIDEO_ENCODE_FAIL;
                            break;
                        } 
                      } else {
                        fevent = TXCAVRoomConstants.AVROOM_WARNING_HW_ACCELERATION_DECODE_FAIL;
                      } 
                    } else {
                      fevent = TXCAVRoomConstants.AVROOM_WARNING_VIDEO_PLAY_LAG;
                    } 
                  } else {
                    fevent = TXCAVRoomConstants.AVROOM_EVT_START_VIDEO_DECODER;
                  } 
                } else {
                  fevent = TXCAVRoomConstants.AVROOM_EVT_PLAY_LOADING;
                } 
              } else {
                fevent = TXCAVRoomConstants.AVROOM_EVT_PLAY_BEGIN;
              } 
            } else {
              fevent = TXCAVRoomConstants.AVROOM_EVT_RCV_FIRST_I_FRAME;
            } 
          } else {
            fevent = TXCAVRoomConstants.AVROOM_WARNING_VIDEO_DECODE_FAIL;
          } 
        } else {
          fevent = TXCAVRoomConstants.AVROOM_WARNING_HW_ACCELERATION_ENCODE_FAIL;
        } 
      } else {
        fevent = TXCAVRoomConstants.AVROOM_EVT_OPEN_CAMERA_SUCC;
      } 
      final Bundle bundle = new Bundle();
      bundle.putLong("EVT_USERID", long_.longValue());
      bundle.putInt("EVT_ID", paramBundle.getInt("EVT_ID", 0));
      bundle.putLong("EVT_TIME", paramBundle.getLong("EVT_TIME", 0L));
      bundle.putString("EVT_MSG", paramBundle.getString("EVT_MSG", ""));
      if (this.mPusher != null)
        ((Activity)this.mContext).runOnUiThread(new Runnable() {
              public void run() {
                String str = TXCAVRoom.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("NotifyEvent sendNotifyEvent userID: ");
                stringBuilder.append(userID);
                stringBuilder.append("  msg ");
                stringBuilder.append(bundle.getString("EVT_MSG"));
                TXCLog.i(str, stringBuilder.toString());
                TXCAVRoom.this.mAvRoomLisenter.onAVRoomEvent(userID.longValue(), fevent, bundle);
              }
            }); 
    } 
  }
  
  private void postToUiThread(final TXCAVRoomCallback callback, final int result) {
    Context context = this.mContext;
    if (context != null)
      ((Activity)context).runOnUiThread(new Runnable() {
            public void run() {
              callback.onComplete(result);
            }
          }); 
  }
  
  private void reconnectRoom() {
    int j = this.roomStatus;
    byte b1 = 2;
    if (j != 2)
      return; 
    TXCLog.i(TAG, "reconnectRoom");
    j = this.reconnectCount;
    if (j > this.maxReconnectCount) {
      if (this.mAvRoomLisenter != null) {
        final Bundle bundle = new Bundle();
        bundle.putLong("EVT_USERID", this.myid);
        bundle.putInt("EVT_ID", TXCAVRoomConstants.AVROOM_WARNING_DISCONNECT);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        bundle.putString("EVT_MSG", "Failed to reconnect many times. Abondon reconnect");
        ((Activity)this.mContext).runOnUiThread(new Runnable() {
              public void run() {
                TXCAVRoom.this.mAvRoomLisenter.onAVRoomEvent(TXCAVRoom.this.myid, TXCAVRoomConstants.AVROOM_WARNING_DISCONNECT, bundle);
              }
            });
      } 
      return;
    } 
    if (j < 3)
      b1 = 0; 
    this.mainHandler.postDelayed(new Runnable() {
          public void run() {
            TXCAVRoom.this.mTXCAVProtocol.enterRoom(TXCAVRoom.this.protoparam, new TXCAVProtocol.TXIAVCompletionCallback() {
                  public void onComplete(int param2Int) {
                    if (param2Int == 0) {
                      TXCAVRoom.access$1202(TXCAVRoom.this, 0);
                      if (TXCAVRoom.this.mRoomConfig.isHasVideo()) {
                        TXCAVRoom.this.mTXCAVProtocol.changeAVState(TXCAVProtocol.AV_STATE_ENTER_VIDEO, new TXCAVProtocol.TXIAVCompletionCallback() {
                              public void onComplete(int param3Int) {
                                String str = TXCAVRoom.TAG;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("keyway changeAVState onComplete: ");
                                stringBuilder.append(param3Int);
                                TXCLog.i(str, stringBuilder.toString());
                              }
                            });
                        return;
                      } 
                    } else {
                      TXCAVRoom.this.reconnectRoom();
                    } 
                  }
                });
            TXCAVRoom.access$1208(TXCAVRoom.this);
          }
        }(b1 * 1000));
  }
  
  private void removeAllRender() {
    HashMap<Long, c> hashMap = this.playerList;
    if (hashMap != null) {
      if (hashMap.size() == 0)
        return; 
      for (Long long_ : this.playerList.keySet()) {
        if (this.playerList.get(long_) != null) {
          stopRemoteView(long_.longValue());
          ((c)this.playerList.get(long_)).stop();
          if (this.playerList.get(long_) != null && ((c)this.playerList.get(long_)).a() != null) {
            ((c)this.playerList.get(long_)).a().b();
            ((c)this.playerList.get(long_)).a((a)null);
          } 
        } 
      } 
      this.playerList.clear();
    } 
  }
  
  private void removeRender(Long paramLong) {
    synchronized (this.playerList) {
      c c1 = this.playerList.get(paramLong);
      if (c1 == null)
        return; 
      c1.stop();
      c1.setVideoRender(null);
      c1.setDecListener(null);
      if (c1.a() != null) {
        c1.a().b();
        c1.a((a)null);
      } 
      this.playerList.remove(paramLong);
      return;
    } 
  }
  
  private void requestView(ArrayList<Long> paramArrayList) {
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("requestView: ");
    stringBuilder.append(paramArrayList.size());
    TXCLog.i(str, stringBuilder.toString());
    ArrayList<TXCAVProtocol.TXSAVRoomView> arrayList = new ArrayList();
    Iterator<Long> iterator = paramArrayList.iterator();
    while (iterator.hasNext()) {
      long l = ((Long)iterator.next()).longValue();
      TXCAVProtocol tXCAVProtocol = new TXCAVProtocol();
      tXCAVProtocol.getClass();
      TXCAVProtocol.TXSAVRoomView tXSAVRoomView = new TXCAVProtocol.TXSAVRoomView(tXCAVProtocol);
      tXSAVRoomView.tinyID = l;
      tXSAVRoomView.height = 240;
      tXSAVRoomView.width = 320;
      arrayList.add(tXSAVRoomView);
    } 
    requestViewList(arrayList, new TXCAVRoomCallback() {
          public void onComplete(int param1Int) {
            String str = TXCAVRoom.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("keyway requestViewList onComplete: ");
            stringBuilder.append(param1Int);
            TXCLog.i(str, stringBuilder.toString());
          }
        });
  }
  
  private void requestViewList(ArrayList<TXCAVProtocol.TXSAVRoomView> paramArrayList, final TXCAVRoomCallback callback) {
    this.mTXCAVProtocol.requestViews(paramArrayList, new TXCAVProtocol.TXIAVCompletionCallback() {
          public void onComplete(int param1Int) {
            TXCAVRoom.this.postToUiThread(callback, param1Int);
          }
        });
  }
  
  private void startPush() {
    TXCLog.i(TAG, "keyway startPush: ");
    this.allowedPush = true;
    this.mPusher.f();
  }
  
  private void stopPush() {
    TXCLog.i(TAG, "keyway stopPush: ");
    this.allowedPush = false;
    this.mPusher.g();
  }
  
  public void destory() {
    TXCQoS tXCQoS = this.mQos;
    if (tXCQoS != null)
      tXCQoS.stop(); 
    stopLocalPreview();
    removeAllRender();
    this.mPusher.g();
    this.mPusher = null;
    this.mContext = null;
    this.mTXCAVProtocol.destory();
  }
  
  public void enterRoom(TXCAVRoomParam paramTXCAVRoomParam, final TXCAVRoomCallback callback) {
    if (this.roomStatus != 0) {
      postToUiThread(callback, -4);
      return;
    } 
    this.roomStatus = 1;
    TXCDRApi.initCrashReport(this.mContext);
    TXCDRApi.txReportDAU(this.mContext, a.bw);
    this.protoparam.roomID = paramTXCAVRoomParam.getRoomID();
    this.protoparam.authBits = paramTXCAVRoomParam.getAuthBits();
    this.protoparam.authBuffer = paramTXCAVRoomParam.getAuthBuffer();
    this.enterRoomCB = callback;
    TXCAVProtocol.TXCAVProtoParam tXCAVProtoParam = this.protoparam;
    tXCAVProtoParam.userID = this.myid;
    tXCAVProtoParam.sdkAppid = this.appid;
    tXCAVProtoParam.sdkVersion = this.sdkVersion;
    applyCaptureConfig();
    this.mTXCAVProtocol.enterRoom(this.protoparam, new TXCAVProtocol.TXIAVCompletionCallback() {
          public void onComplete(int param1Int) {
            if (param1Int == 0) {
              TXCAVRoom.access$1202(TXCAVRoom.this, 0);
              TXCAVRoom.this.startPush();
              TXCAVRoom.access$1402(TXCAVRoom.this, 2);
              TXCAVRoom.access$1502(1);
              TXCAVRoom.this.postToUiThread(callback, param1Int);
              if (TXCAVRoom.this.mRoomConfig.isHasVideo()) {
                TXCAVRoom.this.mTXCAVProtocol.changeAVState(TXCAVProtocol.AV_STATE_ENTER_VIDEO, new TXCAVProtocol.TXIAVCompletionCallback() {
                      public void onComplete(int param2Int) {
                        String str = TXCAVRoom.TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("keyway change to Video  onComplete: ");
                        stringBuilder.append(param2Int);
                        TXCLog.i(str, stringBuilder.toString());
                      }
                    });
                return;
              } 
            } else {
              TXCAVRoom.access$1402(TXCAVRoom.this, 0);
              TXCAVRoom.this.postToUiThread(callback, param1Int);
            } 
          }
        });
    this.mQos = new TXCQoS(true);
    this.mQos.setUserID(String.valueOf(this.myid));
    this.mQos.setListener(new a() {
          public void onEnableDropStatusChanged(boolean param1Boolean) {}
          
          public void onEncoderParamsChanged(int param1Int1, int param1Int2, int param1Int3) {
            if (param1Int1 != 0) {
              if (TXCAVRoom.this.mPusher != null)
                TXCAVRoom.this.mPusher.a(param1Int1, param1Int2, param1Int3); 
              String str = TXCAVRoom.TAG;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onEncoderParamsChanged:");
              stringBuilder.append(param1Int1);
              TXCLog.i(str, stringBuilder.toString());
            } 
          }
          
          public int onGetBandwidthEst() {
            return 0;
          }
          
          public int onGetEncoderRealBitrate() {
            long l;
            if (TXCAVRoom.this.mCaptureDataCollection != null) {
              l = TXCAVRoom.this.mCaptureDataCollection.getLongValue(4002);
            } else {
              l = 0L;
            } 
            return (int)l;
          }
          
          public int onGetQueueInputSize() {
            long l1;
            b b = TXCAVRoom.this.mCaptureDataCollection;
            long l2 = 0L;
            if (b != null) {
              l1 = TXCAVRoom.this.mCaptureDataCollection.getLongValue(7002);
            } else {
              l1 = 0L;
            } 
            if (TXCAVRoom.this.mCaptureDataCollection != null)
              l2 = TXCAVRoom.this.mCaptureDataCollection.getLongValue(7001); 
            return (int)(l1 + l2);
          }
          
          public int onGetQueueOutputSize() {
            return (TXCAVRoom.this.mCaptureDataCollection == null) ? 0 : (int)(TXCAVRoom.this.mCaptureDataCollection.getLongValue(7004) + TXCAVRoom.this.mCaptureDataCollection.getLongValue(7003));
          }
          
          public int onGetVideoDropCount() {
            return (TXCAVRoom.this.mCaptureDataCollection == null) ? 0 : (int)TXCAVRoom.this.mCaptureDataCollection.getLongValue(7007);
          }
          
          public int onGetVideoQueueCurrentCount() {
            return (TXCAVRoom.this.mCaptureDataCollection == null) ? 0 : (int)TXCAVRoom.this.mCaptureDataCollection.getLongValue(7005);
          }
          
          public int onGetVideoQueueMaxCount() {
            return 5;
          }
        });
    this.mQos.setNotifyListener(new b() {
          public void onNotifyEvent(int param1Int, Bundle param1Bundle) {
            TXCAVRoom.this.onBothNotifyEvent(param1Int, param1Bundle);
          }
        });
    this.mQos.setAutoAdjustBitrate(true);
    this.mQos.setAutoAdjustStrategy(5);
    this.mQos.setDefaultVideoResolution(c.b);
    this.mQos.setDefaultVideoResolution(this.videoResolution);
    this.mQos.setVideoEncBitrate(100, this.mRoomConfig.getVideoBitrate(), this.mRoomConfig.getVideoBitrate());
    this.mQos.start(TXCAVRoomConstants.AVROOM_QOS_INTERVAL);
  }
  
  public void exitRoom(final TXCAVRoomCallback callback) {
    int j = this.roomStatus;
    if (j == 3 || j == 1) {
      postToUiThread(callback, -4);
      return;
    } 
    this.roomStatus = 3;
    TXCQoS tXCQoS = this.mQos;
    if (tXCQoS != null) {
      tXCQoS.stop();
      this.mQos.setListener(null);
      this.mQos.setNotifyListener(null);
      this.mQos = null;
    } 
    removeAllRender();
    stopLocalPreview();
    stopPush();
    HashMap<Long, c> hashMap = this.playerList;
    if (hashMap != null)
      hashMap.clear(); 
    this.mTXCAVProtocol.exitRoom(new TXCAVProtocol.TXIAVCompletionCallback() {
          public void onComplete(int param1Int) {
            TXCAVRoom.access$1402(TXCAVRoom.this, 0);
            TXCAVRoom.this.postToUiThread(callback, param1Int);
            if (param1Int == 0) {
              TXCAVRoom.access$1502(0);
              if (TXCAVRoom.this.mCaptureDataCollection != null) {
                TXCAVRoom.this.mCaptureDataCollection.b();
                TXCAVRoom.access$1802(TXCAVRoom.this, null);
              } 
            } 
          }
        });
  }
  
  public TXCAVRoomConfig getRoomConfig() {
    return this.mRoomConfig;
  }
  
  public long[] getRoomMemberList() {
    return this.mTXCAVProtocol.getRoomMemberList();
  }
  
  public long[] getRoomVideoList() {
    return this.mTXCAVProtocol.getRoomVideoList();
  }
  
  public boolean isInRoom() {
    return (this.roomStatus == 2);
  }
  
  public boolean isPushing() {
    return this.mPusher.k();
  }
  
  public String nat64Compatable(String paramString, short paramShort) {
    return this.mTXCAVProtocol.nativeNAT64Compatable(paramString, paramShort);
  }
  
  public void onPause() {
    TXCLog.i(TAG, "keyway onPause : ");
    this.mPusher.h();
  }
  
  public void onResume() {
    TXCLog.i(TAG, "keyway onResume: ");
    this.mPusher.i();
  }
  
  public void setAudioMode(int paramInt) {}
  
  public void setAvRoomLisenter(TXCAVRoomLisenter paramTXCAVRoomLisenter) {
    this.mAvRoomLisenter = paramTXCAVRoomLisenter;
  }
  
  public void setBeautyFilter(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    d d1 = this.mPusher;
    if (d1 != null) {
      d1.b().setBeautyStyle(paramInt1);
      TXBeautyManager tXBeautyManager = this.mPusher.b();
      float f = paramInt2;
      tXBeautyManager.setBeautyLevel(f);
      this.mPusher.b().setWhitenessLevel(f);
      this.mPusher.b().setRuddyLevel(f);
    } 
  }
  
  public void setChinLevel(int paramInt) {
    d d1 = this.mPusher;
    if (d1 != null)
      d1.b().setChinLevel(paramInt); 
  }
  
  public void setExposureCompensation(float paramFloat) {
    this.mPusher.a(paramFloat);
  }
  
  public void setEyeScaleLevel(int paramInt) {
    this.mPusher.b().setEyeScaleLevel(paramInt);
  }
  
  public void setFaceShortLevel(int paramInt) {
    d d1 = this.mPusher;
    if (d1 != null)
      d1.b().setFaceShortLevel(paramInt); 
  }
  
  public void setFaceSlimLevel(int paramInt) {
    this.mPusher.b().setFaceSlimLevel(paramInt);
  }
  
  public void setFaceVLevel(int paramInt) {
    d d1 = this.mPusher;
    if (d1 != null)
      d1.b().setFaceVLevel(paramInt); 
  }
  
  public void setFilter(Bitmap paramBitmap) {
    this.mPusher.b().setFilter(paramBitmap);
  }
  
  public void setGreenScreenFile(String paramString) {
    this.mPusher.b().setGreenScreenFile(paramString);
  }
  
  public void setLocalMute(boolean paramBoolean) {
    d d1 = this.mPusher;
  }
  
  public void setMirror(boolean paramBoolean) {
    d d1 = this.mPusher;
    if (d1 != null)
      d1.g(paramBoolean); 
  }
  
  public void setMotionTmpl(String paramString) {
    this.mPusher.b().setMotionTmpl(paramString);
  }
  
  public void setNoseSlimLevel(int paramInt) {
    d d1 = this.mPusher;
    if (d1 != null)
      d1.b().setNoseSlimLevel(paramInt); 
  }
  
  public void setRemoteMute(boolean paramBoolean, long paramLong) {
    null = this.playerList;
    if (null == null)
      return; 
    if (paramLong == 0L)
      for (Long long_ : null.keySet())
        TXCRenderAndDec tXCRenderAndDec = this.playerList.get(long_);  
    synchronized (this.playerList) {
      this.playerList.get(Long.valueOf(paramLong));
      return;
    } 
  }
  
  public void setRenderMode(int paramInt) {
    for (Map.Entry<Long, c> entry : this.playerList.entrySet()) {
      String str = TAG;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Key = ");
      stringBuilder.append(entry.getKey());
      stringBuilder.append(", Value = ");
      stringBuilder.append(entry.getValue());
      TXCLog.i(str, stringBuilder.toString());
      ((c)entry.getValue()).setRenderMode(paramInt);
    } 
  }
  
  public void setRoomConfig(TXCAVRoomConfig paramTXCAVRoomConfig) {
    this.mRoomConfig = paramTXCAVRoomConfig;
    applyCaptureConfig();
  }
  
  public void setSpecialRatio(float paramFloat) {
    d d1 = this.mPusher;
    if (d1 != null)
      d1.b().setFilterStrength(paramFloat); 
  }
  
  public void setVideoBitrateAndvideoAspect(int paramInt1, int paramInt2) {
    this.videoResolution = TXCQoS.getProperResolutionByVideoBitrate(true, paramInt1, paramInt2);
    if (this.videoResolution == null)
      if (paramInt2 == 1) {
        this.videoResolution = c.b;
      } else if (paramInt2 == 2) {
        this.videoResolution = c.n;
      } else if (paramInt2 == 3) {
        this.videoResolution = c.s;
      } else {
        this.videoResolution = c.b;
      }  
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setVideoBitrateAndvideoAspect videoBitrate: ");
    stringBuilder.append(paramInt1);
    stringBuilder.append(" videoAspect:");
    stringBuilder.append(paramInt2);
    stringBuilder.append(" videoResolution:");
    stringBuilder.append(this.videoResolution);
    TXCLog.i(str, stringBuilder.toString());
    this.mRoomConfig.videoBitrate(paramInt1);
    applyCaptureConfig();
  }
  
  public void startLocalPreview(TXCloudVideoView paramTXCloudVideoView) {
    this.localView = paramTXCloudVideoView;
    paramTXCloudVideoView.setVisibility(0);
    String str = TAG;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("startLocalPreview: ");
    stringBuilder.append(paramTXCloudVideoView.getTag());
    TXCLog.i(str, stringBuilder.toString());
    applyCaptureConfig();
    this.mPusher.a(paramTXCloudVideoView);
    if (this.mCaptureDataCollection == null) {
      this.mCaptureDataCollection = new b(this.appid, this.myid, this.mContext, this.mLivePushConfig);
      this.mCaptureDataCollection.a(this.mTXCAVProtocol);
      this.mCaptureDataCollection.a(this.mAvRoomLisenter);
      this.mCaptureDataCollection.a();
      this.mCaptureDataCollection.a(this.mPusher);
    } 
    this.mRoomConfig.setHasVideo(true);
    if (this.roomStatus != 2)
      return; 
    this.mTXCAVProtocol.changeAVState(TXCAVProtocol.AV_STATE_ENTER_VIDEO, new TXCAVProtocol.TXIAVCompletionCallback() {
          public void onComplete(int param1Int) {
            String str = TXCAVRoom.TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("keyway change to Video onComplete: ");
            stringBuilder.append(param1Int);
            Log.i(str, stringBuilder.toString());
          }
        });
  }
  
  public void startRemoteView(TXCloudVideoView paramTXCloudVideoView, long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield playerList : Ljava/util/HashMap;
    //   6: astore #4
    //   8: aload #4
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield playerList : Ljava/util/HashMap;
    //   15: lload_2
    //   16: invokestatic valueOf : (J)Ljava/lang/Long;
    //   19: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   22: checkcast com/tencent/avroom/c
    //   25: astore #5
    //   27: aload #5
    //   29: ifnonnull -> 38
    //   32: aload #4
    //   34: monitorexit
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_1
    //   39: ifnull -> 74
    //   42: aload #5
    //   44: aload_1
    //   45: invokevirtual a : (Lcom/tencent/rtmp/ui/TXCloudVideoView;)V
    //   48: aload_0
    //   49: getfield videoMemList : Ljava/util/ArrayList;
    //   52: lload_2
    //   53: invokestatic valueOf : (J)Ljava/lang/Long;
    //   56: invokevirtual add : (Ljava/lang/Object;)Z
    //   59: pop
    //   60: aload #5
    //   62: iconst_0
    //   63: invokevirtual setRenderMode : (I)V
    //   66: aload_0
    //   67: aload_0
    //   68: getfield videoMemList : Ljava/util/ArrayList;
    //   71: invokespecial requestView : (Ljava/util/ArrayList;)V
    //   74: new com/tencent/avroom/a
    //   77: dup
    //   78: lload_2
    //   79: invokespecial <init> : (J)V
    //   82: astore_1
    //   83: aload_1
    //   84: aload_0
    //   85: getfield mAvRoomLisenter : Lcom/tencent/avroom/TXCAVRoomLisenter;
    //   88: invokevirtual a : (Lcom/tencent/avroom/TXCAVRoomLisenter;)V
    //   91: aload_1
    //   92: aload_0
    //   93: getfield mTXCAVProtocol : Lcom/tencent/liteav/avprotocol/TXCAVProtocol;
    //   96: invokevirtual a : (Lcom/tencent/liteav/avprotocol/TXCAVProtocol;)V
    //   99: aload_1
    //   100: aload_0
    //   101: getfield playerList : Ljava/util/HashMap;
    //   104: lload_2
    //   105: invokestatic valueOf : (J)Ljava/lang/Long;
    //   108: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   111: checkcast com/tencent/liteav/TXCRenderAndDec
    //   114: invokevirtual a : (Lcom/tencent/liteav/TXCRenderAndDec;)V
    //   117: aload_1
    //   118: aload_0
    //   119: getfield playerList : Ljava/util/HashMap;
    //   122: lload_2
    //   123: invokestatic valueOf : (J)Ljava/lang/Long;
    //   126: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   129: checkcast com/tencent/avroom/c
    //   132: invokevirtual getVideoRender : ()Lcom/tencent/liteav/renderer/f;
    //   135: invokevirtual a : (Lcom/tencent/liteav/renderer/f;)V
    //   138: aload_0
    //   139: getfield playerList : Ljava/util/HashMap;
    //   142: lload_2
    //   143: invokestatic valueOf : (J)Ljava/lang/Long;
    //   146: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   149: checkcast com/tencent/avroom/c
    //   152: aload_1
    //   153: invokevirtual a : (Lcom/tencent/avroom/a;)V
    //   156: aload_1
    //   157: invokevirtual a : ()V
    //   160: aload_0
    //   161: aload_0
    //   162: getfield mRoomConfig : Lcom/tencent/avroom/TXCAVRoomConfig;
    //   165: invokevirtual getRemoteRenderMode : ()I
    //   168: invokevirtual setRenderMode : (I)V
    //   171: aload #4
    //   173: monitorexit
    //   174: aload_0
    //   175: monitorexit
    //   176: return
    //   177: astore_1
    //   178: aload #4
    //   180: monitorexit
    //   181: aload_1
    //   182: athrow
    //   183: astore_1
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_1
    //   187: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	183	finally
    //   11	27	177	finally
    //   32	35	177	finally
    //   42	74	177	finally
    //   74	174	177	finally
    //   178	181	177	finally
    //   181	183	183	finally
  }
  
  public void stopLocalPreview() {
    b b1 = this.mCaptureDataCollection;
    if (b1 != null) {
      b1.b();
      this.mCaptureDataCollection = null;
    } 
    TXCloudVideoView tXCloudVideoView = this.localView;
    if (tXCloudVideoView != null) {
      tXCloudVideoView.setVisibility(4);
      this.localView = null;
    } 
    d d1 = this.mPusher;
    if (d1 != null)
      d1.d(true); 
    this.mRoomConfig.setHasVideo(false);
    if (this.roomStatus == 2)
      this.mTXCAVProtocol.changeAVState(TXCAVProtocol.AV_STATE_ENTER_AUDIO, new TXCAVProtocol.TXIAVCompletionCallback() {
            public void onComplete(int param1Int) {
              String str = TXCAVRoom.TAG;
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("keyway change to audio onComplete: ");
              stringBuilder.append(param1Int);
              Log.i(str, stringBuilder.toString());
            }
          }); 
  }
  
  public void stopRemoteView(long paramLong) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield videoMemList : Ljava/util/ArrayList;
    //   6: lload_1
    //   7: invokestatic valueOf : (J)Ljava/lang/Long;
    //   10: invokevirtual remove : (Ljava/lang/Object;)Z
    //   13: pop
    //   14: aload_0
    //   15: aload_0
    //   16: getfield videoMemList : Ljava/util/ArrayList;
    //   19: invokespecial requestView : (Ljava/util/ArrayList;)V
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: astore_3
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_3
    //   29: athrow
    // Exception table:
    //   from	to	target	type
    //   2	22	25	finally
  }
  
  public void switchCamera() {
    d d1 = this.mPusher;
    if (d1 != null)
      d1.l(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\avroom\TXCAVRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */