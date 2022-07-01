package org.chromium.media;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;

class MediaCodecBridgeBuilder {
  @CalledByNative
  static MediaCodecBridge createAudioDecoder(String paramString, MediaCrypto paramMediaCrypto, int paramInt1, int paramInt2, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, byte[] paramArrayOfbyte3, boolean paramBoolean) {
    MediaCodecUtil$CodecCreationInfo mediaCodecUtil$CodecCreationInfo = new MediaCodecUtil$CodecCreationInfo();
    try {
      Log.i("cr_MediaCodecBridge", "create MediaCodec audio decoder, mime %s", new Object[] { paramString });
      MediaCodecUtil$CodecCreationInfo mediaCodecUtil$CodecCreationInfo1 = MediaCodecUtil.createDecoder(paramString, 0, paramMediaCrypto);
      mediaCodecUtil$CodecCreationInfo = mediaCodecUtil$CodecCreationInfo1;
    } catch (Exception exception) {
      Log.e("cr_MediaCodecBridge", "Failed to create MediaCodec audio decoder: %s", new Object[] { paramString, exception });
    } 
    if (mediaCodecUtil$CodecCreationInfo.mediaCodec == null)
      return null; 
    MediaCodecBridge mediaCodecBridge = new MediaCodecBridge(mediaCodecUtil$CodecCreationInfo.mediaCodec, mediaCodecUtil$CodecCreationInfo.bitrateAdjuster);
    MediaFormat mediaFormat = MediaFormat.createAudioFormat(paramString, paramInt1, paramInt2);
    MediaFormatBuilder.setCodecSpecificData(mediaFormat, new byte[][] { paramArrayOfbyte1, paramArrayOfbyte2, paramArrayOfbyte3 });
    if (paramBoolean)
      mediaFormat.setInteger("is-adts", 1); 
    if (!mediaCodecBridge.configureAudio(mediaFormat, paramMediaCrypto, 0))
      return null; 
    if (!mediaCodecBridge.start()) {
      mediaCodecBridge.release();
      return null;
    } 
    return mediaCodecBridge;
  }
  
  @CalledByNative
  static MediaCodecBridge createVideoDecoder(String paramString, int paramInt1, MediaCrypto paramMediaCrypto, int paramInt2, int paramInt3, Surface paramSurface, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2, HdrMetadata paramHdrMetadata, boolean paramBoolean) {
    MediaCodecUtil$CodecCreationInfo mediaCodecUtil$CodecCreationInfo = new MediaCodecUtil$CodecCreationInfo();
    byte b = 3;
    boolean bool = true;
    try {
      Log.i("cr_MediaCodecBridge", "create MediaCodec video decoder, mime %s", new Object[] { paramString });
      MediaCodecUtil$CodecCreationInfo mediaCodecUtil$CodecCreationInfo1 = MediaCodecUtil.createDecoder(paramString, paramInt1, paramMediaCrypto);
      mediaCodecUtil$CodecCreationInfo = mediaCodecUtil$CodecCreationInfo1;
    } catch (Exception exception) {
      Log.e("cr_MediaCodecBridge", "Failed to create MediaCodec video decoder: %s, codecType: %d", new Object[] { paramString, Integer.valueOf(paramInt1), exception });
    } 
    if (mediaCodecUtil$CodecCreationInfo.mediaCodec == null)
      return null; 
    MediaCodecBridge mediaCodecBridge = new MediaCodecBridge(mediaCodecUtil$CodecCreationInfo.mediaCodec, mediaCodecUtil$CodecCreationInfo.bitrateAdjuster);
    if (mediaCodecUtil$CodecCreationInfo.supportsAdaptivePlayback && paramBoolean) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    } 
    MediaFormat mediaFormat = MediaFormat.createVideoFormat(paramString, paramInt2, paramInt3);
    if (mediaFormat == null) {
      mediaFormat = null;
    } else {
      MediaFormatBuilder.setCodecSpecificData(mediaFormat, new byte[][] { paramArrayOfbyte1, paramArrayOfbyte2 });
      if (paramHdrMetadata != null)
        synchronized (paramHdrMetadata.mLock) {
          if (HdrMetadata.$assertionsDisabled || paramHdrMetadata.mNativeJniHdrMetadata != 0L) {
            if (Build.VERSION.SDK_INT < 24) {
              Log.e("HdrMetadata", "HDR not supported before Android N", new Object[0]);
            } else {
              paramInt1 = paramHdrMetadata.nativePrimaries(paramHdrMetadata.mNativeJniHdrMetadata);
              if (paramInt1 != 1) {
                if (paramInt1 != 9) {
                  switch (paramInt1) {
                    default:
                      paramInt1 = -1;
                      if (paramInt1 != -1)
                        mediaFormat.setInteger("color-standard", paramInt1); 
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                      paramInt1 = 4;
                      if (paramInt1 != -1)
                        mediaFormat.setInteger("color-standard", paramInt1); 
                  } 
                } else {
                  paramInt1 = 6;
                  if (paramInt1 != -1)
                    mediaFormat.setInteger("color-standard", paramInt1); 
                } 
              } else {
                paramInt1 = 1;
                if (paramInt1 != -1)
                  mediaFormat.setInteger("color-standard", paramInt1); 
              } 
              paramInt1 = b;
              if (paramInt1 != -1)
                mediaFormat.setInteger("color-transfer", paramInt1); 
            } 
          } else {
            throw new AssertionError();
          } 
        }  
      MediaFormatBuilder.addInputSizeInfoToFormat(mediaFormat, paramBoolean);
    } 
    if (!mediaCodecBridge.configureVideo(mediaFormat, paramSurface, paramMediaCrypto, 0))
      return null; 
    if (!mediaCodecBridge.start()) {
      mediaCodecBridge.release();
      return null;
    } 
    return mediaCodecBridge;
  }
  
  @CalledByNative
  static MediaCodecBridge createVideoEncoder(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) {
    MediaCodecBridge mediaCodecBridge;
    MediaCodecUtil$CodecCreationInfo mediaCodecUtil$CodecCreationInfo = new MediaCodecUtil$CodecCreationInfo();
    try {
      Log.i("cr_MediaCodecBridge", "create MediaCodec video encoder, mime %s", new Object[] { paramString });
      MediaCodecUtil$CodecCreationInfo mediaCodecUtil$CodecCreationInfo1 = MediaCodecUtil.createEncoder(paramString);
      mediaCodecUtil$CodecCreationInfo = mediaCodecUtil$CodecCreationInfo1;
    } catch (Exception exception) {
      Log.e("cr_MediaCodecBridge", "Failed to create MediaCodec video encoder: %s", new Object[] { paramString, exception });
    } 
    if (mediaCodecUtil$CodecCreationInfo.mediaCodec == null)
      return null; 
    if (paramString.equals("video/avc")) {
      mediaCodecBridge = new MediaCodecEncoder(mediaCodecUtil$CodecCreationInfo.mediaCodec, mediaCodecUtil$CodecCreationInfo.bitrateAdjuster);
    } else {
      mediaCodecBridge = new MediaCodecBridge(mediaCodecUtil$CodecCreationInfo.mediaCodec, mediaCodecUtil$CodecCreationInfo.bitrateAdjuster);
    } 
    paramInt4 = mediaCodecUtil$CodecCreationInfo.bitrateAdjuster.getInitialFrameRate(paramInt4);
    boolean bool = mediaCodecUtil$CodecCreationInfo.supportsAdaptivePlayback;
    MediaFormat mediaFormat = MediaFormat.createVideoFormat(paramString, paramInt1, paramInt2);
    mediaFormat.setInteger("bitrate", paramInt3);
    mediaFormat.setInteger("frame-rate", paramInt4);
    mediaFormat.setInteger("i-frame-interval", paramInt5);
    mediaFormat.setInteger("color-format", paramInt6);
    MediaFormatBuilder.addInputSizeInfoToFormat(mediaFormat, bool);
    if (!mediaCodecBridge.configureVideo(mediaFormat, null, null, 1))
      return null; 
    if (!mediaCodecBridge.start()) {
      mediaCodecBridge.release();
      return null;
    } 
    return mediaCodecBridge;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\MediaCodecBridgeBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */