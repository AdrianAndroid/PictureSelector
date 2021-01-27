package com.luck.picture.lib.config;

import android.content.pm.ActivityInfo;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.ColorInt;
import androidx.annotation.StyleRes;

import com.luck.picture.lib.R;
import com.luck.picture.lib.camera.CustomCameraView;
import com.luck.picture.lib.engine.CacheResourcesEngine;
import com.luck.picture.lib.engine.ImageEngine;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.listener.OnCustomCameraInterfaceListener;
import com.luck.picture.lib.listener.OnCustomImagePreviewCallback;
import com.luck.picture.lib.listener.OnResultCallbackListener;
import com.luck.picture.lib.listener.OnVideoSelectedPlayCallback;
import com.luck.picture.lib.style.PictureCropParameterStyle;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureSelectorUIStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：luck
 * @date：2017-05-24 17:02
 * @describe：PictureSelector Config
 */

public final class PictureSelectionConfig implements Parcelable {
    public int chooseMode; //全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
    public boolean camera;
    public boolean isSingleDirectReturn;// 单选模式下是否直接返回，PictureConfig.SINGLE模式下有效
    public static PictureSelectorUIStyle uiStyle;
    public static PictureParameterStyle style; // 动态自定义相册主题
    public static PictureCropParameterStyle cropStyle; // 动态自定义裁剪主题
    public static PictureWindowAnimationStyle windowAnimationStyle = PictureWindowAnimationStyle.ofDefaultWindowAnimationStyle();// 自定义相册启动退出动画
    public String compressSavePath;//压缩图片保存地址
    public String suffixType;// 拍照保存图片格式后缀,默认jpeg
    public boolean focusAlpha;
    public String renameCompressFileName;// 重命名压缩文件名、 注意这个不要重复，只适用于单张图压缩使用
    public String renameCropFileName;// 重命名裁剪文件名、 注意这个不要重复，只适用于单张图裁剪使用
    public String specifiedFormat;// 查询指定后缀格式资源
    public int requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;// 设置相册Activity方向，不设置默认使用系统
    public int buttonFeatures = CustomCameraView.BUTTON_STATE_BOTH;
    public boolean isCameraAroundState;
    public boolean isAndroidQTransform;// 是否需要处理Android Q 拷贝至应用沙盒的操作，只针对.isCompress(false); && .isEnableCrop(false);有效,默认处理
    @StyleRes
    public int themeStyleId; // 主题样式
    public int selectionMode;// 多选 or 单选
    public int maxSelectNum;// 最大图片选择数量
    public int minSelectNum;// 最小图片选择数量
    public int maxVideoSelectNum = 1; // 视频最大选择数量，如果没有单独设置的需求则可以不设置，同用maxSelectNum字段
    public int minVideoSelectNum; // 视频最小选择数量，如果没有单独设置的需求则可以不设置
    public int videoQuality;// 视频录制质量 0 or 1
    public int cropCompressQuality;// 裁剪输出质量 默认100
    public int videoMaxSecond;
    public int videoMinSecond;
    public int recordVideoSecond;//录制视频秒数 默认60s
    public int recordVideoMinSecond;
    public int minimumCompressSize = PictureConfig.MAX_COMPRESS_SIZE;// 小于100kb的图片不压缩
    public int imageSpanCount = PictureConfig.DEFAULT_SPAN_COUNT;// 每行显示个数
    public int aspect_ratio_x;// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
    public int aspect_ratio_y;// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
    public int cropWidth;
    public int cropHeight;
    public int compressQuality;// 图片压缩后输出质量 0~ 100
    public float filterFileSize;// 只查多少M以内的图片、视频、音频  单位M
    public int language; // 设置语言
    public boolean isMultipleRecyclerAnimation;
    public boolean isMultipleSkipCrop;// 多图裁剪时是否支持跳过，默认支持
    public boolean isWeChatStyle; // 是否是微信风格
    public boolean isUseCustomCamera; //是否使用自定义相机
    public boolean zoomAnim;// 图片列表点击 缩放效果 默认true
    public boolean isCompress;// 是否压缩
    public boolean isOriginalControl;// 是否显示原图控制按钮，如果设置为true则用户可以自由选择是否使用原图，压缩、裁剪功能将会失效
    public boolean isCamera;// 是否显示拍照按钮
    public boolean isGif;// 是否显示gif图片
    public boolean isWebp;
    public boolean isBmp;
    public boolean enablePreview;// 是否可预览图片
    public boolean enPreviewVideo;// 是否可预览视频
    public boolean enablePreviewAudio;// 是否可播放音频
    public boolean checkNumMode;
    public boolean openClickSound;// 是否开启点击声音
    public boolean enableCrop;// 是否裁剪
    public boolean freeStyleCropEnabled;// 裁剪框是否可拖拽
    public boolean circleDimmedLayer;// 是否圆形裁剪
    @ColorInt
    public int circleDimmedColor;// 设置圆形裁剪背景色值
    @ColorInt
    public int circleDimmedBorderColor;// 设置圆形裁剪边框色值
    public int circleStrokeWidth;// 设置圆形裁剪边框粗细
    public boolean showCropFrame;// 是否显示裁剪矩形边框 圆形裁剪时建议设为false
    public boolean showCropGrid;// 是否显示裁剪矩形网格 圆形裁剪时建议设为false
    public boolean hideBottomControls;// 是否显示uCrop工具栏，默认不显示
    public boolean rotateEnabled;// 裁剪是否可旋转图片
    public boolean scaleEnabled;// 裁剪是否可放大缩小图片
    public boolean previewEggs;// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
    public boolean synOrAsy;//同步false或异步true 压缩 默认同步
    public boolean returnEmpty;// 未选择数据时点击按钮是否可以返回
    public boolean isDragFrame;// 是否可拖动裁剪框(固定
    public boolean isNotPreviewDownload;
    public boolean isWithVideoImage;// 图片和视频是否可以同选
    public UCropOptions uCropOptions;
    public static ImageEngine imageEngine; // 加载图片的引擎
    public static CacheResourcesEngine cacheResourcesEngine;// 获取图片资源缓存，主要是解决华为10部分机型在拷贝文件过多时会出现卡的问题，这里可以判断只在会出现一直转圈问题机型上使用
    public static OnResultCallbackListener listener;
    public static OnVideoSelectedPlayCallback customVideoPlayCallback;
    public static OnCustomImagePreviewCallback onCustomImagePreviewCallback;
    public static OnCustomCameraInterfaceListener onCustomCameraInterfaceListener;
    public List<LocalMedia> selectionMedias;
    public String cameraFileName;// 重命名拍照文件名、注意这个只在使用相机时可以使用，如果使用相机又开启了压缩或裁剪 需要配合压缩和裁剪文件名api
    public boolean isCheckOriginalImage;
    @Deprecated
    public int overrideWidth;// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度 注：已废弃
    @Deprecated
    public int overrideHeight;// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度 注：已废弃
    @Deprecated
    public float sizeMultiplier;// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效 注：已废弃
    @Deprecated
    public boolean isChangeStatusBarFontColor;
    @Deprecated
    public boolean isOpenStyleNumComplete;
    @Deprecated
    public boolean isOpenStyleCheckNumMode;
    @Deprecated
    public int titleBarBackgroundColor;
    @Deprecated
    public int pictureStatusBarColor;
    @Deprecated
    public int cropTitleBarBackgroundColor;
    @Deprecated
    public int cropStatusBarColorPrimaryDark;
    @Deprecated
    public int cropTitleColor;
    @Deprecated
    public int upResId;
    @Deprecated
    public int downResId;
    public String outPutCameraPath;

    public String originalPath;
    public String cameraPath;
    public int cameraMimeType;
    public int pageSize = PictureConfig.MAX_PAGE_SIZE;
    public boolean isPageStrategy;
    public boolean isFilterInvalidFile;
    public boolean isMaxSelectEnabledMask;
    public int animationMode;
    public boolean isAutomaticTitleRecyclerTop;
    public boolean isCallbackMode; // callback模式
    public boolean isAndroidQChangeWH;
    public boolean isAndroidQChangeVideoWH;
    public boolean isQuickCapture;
    /**
     * 内测专用###########
     */
    public boolean isFallbackVersion;
    public boolean isFallbackVersion2;
    public boolean isFallbackVersion3;

    protected void initDefaultValue() {
        chooseMode = PictureMimeType.ofImage();
        camera = false;
        themeStyleId = R.style.picture_default_style;
        selectionMode = PictureConfig.MULTIPLE;
        uiStyle = null;
        style = null;
        cropStyle = null;
        maxSelectNum = 9;
        minSelectNum = 0;
        maxVideoSelectNum = 1;
        minVideoSelectNum = 0;
        videoQuality = 1;
        language = -1;
        cropCompressQuality = 90;
        videoMaxSecond = 0;
        videoMinSecond = 0;
        filterFileSize = -1;
        recordVideoSecond = 60;
        recordVideoMinSecond = 0;
        compressQuality = 80;
        imageSpanCount = PictureConfig.DEFAULT_SPAN_COUNT;
        isCompress = false;
        isOriginalControl = false;
        aspect_ratio_x = 0;
        aspect_ratio_y = 0;
        cropWidth = 0;
        cropHeight = 0;
        isCameraAroundState = false;
        isWithVideoImage = false;
        isAndroidQTransform = false;
        isCamera = true;
        isGif = false;
        isWebp = true;
        isBmp = true;
        focusAlpha = false;
        isCheckOriginalImage = false;
        isSingleDirectReturn = false;
        enablePreview = true;
        enPreviewVideo = true;
        enablePreviewAudio = true;
        checkNumMode = false;
        isNotPreviewDownload = false;
        openClickSound = false;
        isFallbackVersion = false;
        isFallbackVersion2 = true;
        isFallbackVersion3 = true;
        enableCrop = false;
        isWeChatStyle = false;
        isUseCustomCamera = false;
        isMultipleSkipCrop = true;
        isMultipleRecyclerAnimation = true;
        freeStyleCropEnabled = false;
        circleDimmedLayer = false;
        showCropFrame = true;
        showCropGrid = true;
        hideBottomControls = true;
        rotateEnabled = true;
        scaleEnabled = true;
        previewEggs = false;
        returnEmpty = false;
        synOrAsy = true;
        zoomAnim = true;
        circleDimmedColor = 0;
        circleDimmedBorderColor = 0;
        circleStrokeWidth = 1;
        isDragFrame = true;
        compressSavePath = "";
        suffixType = "";
        cameraFileName = "";
        specifiedFormat = "";
        renameCompressFileName = "";
        renameCropFileName = "";
        selectionMedias = new ArrayList<>();
        uCropOptions = null;
        titleBarBackgroundColor = 0;
        pictureStatusBarColor = 0;
        cropTitleBarBackgroundColor = 0;
        cropStatusBarColorPrimaryDark = 0;
        cropTitleColor = 0;
        upResId = 0;
        downResId = 0;
        isChangeStatusBarFontColor = false;
        isOpenStyleNumComplete = false;
        isOpenStyleCheckNumMode = false;
        outPutCameraPath = "";
        sizeMultiplier = 0.5f;
        overrideWidth = 0;
        overrideHeight = 0;
        originalPath = "";
        cameraPath = "";
        cameraMimeType = -1;
        pageSize = PictureConfig.MAX_PAGE_SIZE;
        isPageStrategy = true;
        isFilterInvalidFile = false;
        isMaxSelectEnabledMask = false;
        animationMode = -1;
        isAutomaticTitleRecyclerTop = true;
        isCallbackMode = false;
        isAndroidQChangeWH = true;
        isAndroidQChangeVideoWH = false;
        isQuickCapture = true;
    }

    public static PictureSelectionConfig getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public static PictureSelectionConfig getCleanInstance() {
        PictureSelectionConfig selectionSpec = getInstance();
        selectionSpec.initDefaultValue();
        return selectionSpec;
    }

    private static final class InstanceHolder {
        private static final PictureSelectionConfig INSTANCE = new PictureSelectionConfig();
    }

    public PictureSelectionConfig() {
    }

    /**
     * 释放监听器
     */
    public static void destroy() {
        PictureSelectionConfig.listener = null;
        PictureSelectionConfig.customVideoPlayCallback = null;
        PictureSelectionConfig.onCustomImagePreviewCallback = null;
        PictureSelectionConfig.onCustomCameraInterfaceListener = null;
        PictureSelectionConfig.cacheResourcesEngine = null;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.chooseMode);
        dest.writeByte(this.camera ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isSingleDirectReturn ? (byte) 1 : (byte) 0);
        dest.writeString(this.compressSavePath);
        dest.writeString(this.suffixType);
        dest.writeByte(this.focusAlpha ? (byte) 1 : (byte) 0);
        dest.writeString(this.renameCompressFileName);
        dest.writeString(this.renameCropFileName);
        dest.writeString(this.specifiedFormat);
        dest.writeInt(this.requestedOrientation);
        dest.writeInt(this.buttonFeatures);
        dest.writeByte(this.isCameraAroundState ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isAndroidQTransform ? (byte) 1 : (byte) 0);
        dest.writeInt(this.themeStyleId);
        dest.writeInt(this.selectionMode);
        dest.writeInt(this.maxSelectNum);
        dest.writeInt(this.minSelectNum);
        dest.writeInt(this.maxVideoSelectNum);
        dest.writeInt(this.minVideoSelectNum);
        dest.writeInt(this.videoQuality);
        dest.writeInt(this.cropCompressQuality);
        dest.writeInt(this.videoMaxSecond);
        dest.writeInt(this.videoMinSecond);
        dest.writeInt(this.recordVideoSecond);
        dest.writeInt(this.recordVideoMinSecond);
        dest.writeInt(this.minimumCompressSize);
        dest.writeInt(this.imageSpanCount);
        dest.writeInt(this.aspect_ratio_x);
        dest.writeInt(this.aspect_ratio_y);
        dest.writeInt(this.cropWidth);
        dest.writeInt(this.cropHeight);
        dest.writeInt(this.compressQuality);
        dest.writeFloat(this.filterFileSize);
        dest.writeInt(this.language);
        dest.writeByte(this.isMultipleRecyclerAnimation ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isMultipleSkipCrop ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isWeChatStyle ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isUseCustomCamera ? (byte) 1 : (byte) 0);
        dest.writeByte(this.zoomAnim ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isCompress ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isOriginalControl ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isCamera ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isGif ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isWebp ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isBmp ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enablePreview ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enPreviewVideo ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enablePreviewAudio ? (byte) 1 : (byte) 0);
        dest.writeByte(this.checkNumMode ? (byte) 1 : (byte) 0);
        dest.writeByte(this.openClickSound ? (byte) 1 : (byte) 0);
        dest.writeByte(this.enableCrop ? (byte) 1 : (byte) 0);
        dest.writeByte(this.freeStyleCropEnabled ? (byte) 1 : (byte) 0);
        dest.writeByte(this.circleDimmedLayer ? (byte) 1 : (byte) 0);
        dest.writeInt(this.circleDimmedColor);
        dest.writeInt(this.circleDimmedBorderColor);
        dest.writeInt(this.circleStrokeWidth);
        dest.writeByte(this.showCropFrame ? (byte) 1 : (byte) 0);
        dest.writeByte(this.showCropGrid ? (byte) 1 : (byte) 0);
        dest.writeByte(this.hideBottomControls ? (byte) 1 : (byte) 0);
        dest.writeByte(this.rotateEnabled ? (byte) 1 : (byte) 0);
        dest.writeByte(this.scaleEnabled ? (byte) 1 : (byte) 0);
        dest.writeByte(this.previewEggs ? (byte) 1 : (byte) 0);
        dest.writeByte(this.synOrAsy ? (byte) 1 : (byte) 0);
        dest.writeByte(this.returnEmpty ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isDragFrame ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isNotPreviewDownload ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isWithVideoImage ? (byte) 1 : (byte) 0);
        dest.writeParcelable(this.uCropOptions, flags);
        dest.writeTypedList(this.selectionMedias);
        dest.writeString(this.cameraFileName);
        dest.writeByte(this.isCheckOriginalImage ? (byte) 1 : (byte) 0);
        dest.writeInt(this.overrideWidth);
        dest.writeInt(this.overrideHeight);
        dest.writeFloat(this.sizeMultiplier);
        dest.writeByte(this.isChangeStatusBarFontColor ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isOpenStyleNumComplete ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isOpenStyleCheckNumMode ? (byte) 1 : (byte) 0);
        dest.writeInt(this.titleBarBackgroundColor);
        dest.writeInt(this.pictureStatusBarColor);
        dest.writeInt(this.cropTitleBarBackgroundColor);
        dest.writeInt(this.cropStatusBarColorPrimaryDark);
        dest.writeInt(this.cropTitleColor);
        dest.writeInt(this.upResId);
        dest.writeInt(this.downResId);
        dest.writeString(this.outPutCameraPath);
        dest.writeString(this.originalPath);
        dest.writeString(this.cameraPath);
        dest.writeInt(this.cameraMimeType);
        dest.writeInt(this.pageSize);
        dest.writeByte(this.isPageStrategy ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isFilterInvalidFile ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isMaxSelectEnabledMask ? (byte) 1 : (byte) 0);
        dest.writeInt(this.animationMode);
        dest.writeByte(this.isAutomaticTitleRecyclerTop ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isCallbackMode ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isAndroidQChangeWH ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isAndroidQChangeVideoWH ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isQuickCapture ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isFallbackVersion ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isFallbackVersion2 ? (byte) 1 : (byte) 0);
        dest.writeByte(this.isFallbackVersion3 ? (byte) 1 : (byte) 0);
    }

    protected PictureSelectionConfig(Parcel in) {
        this.chooseMode = in.readInt();
        this.camera = in.readByte() != 0;
        this.isSingleDirectReturn = in.readByte() != 0;
        this.compressSavePath = in.readString();
        this.suffixType = in.readString();
        this.focusAlpha = in.readByte() != 0;
        this.renameCompressFileName = in.readString();
        this.renameCropFileName = in.readString();
        this.specifiedFormat = in.readString();
        this.requestedOrientation = in.readInt();
        this.buttonFeatures = in.readInt();
        this.isCameraAroundState = in.readByte() != 0;
        this.isAndroidQTransform = in.readByte() != 0;
        this.themeStyleId = in.readInt();
        this.selectionMode = in.readInt();
        this.maxSelectNum = in.readInt();
        this.minSelectNum = in.readInt();
        this.maxVideoSelectNum = in.readInt();
        this.minVideoSelectNum = in.readInt();
        this.videoQuality = in.readInt();
        this.cropCompressQuality = in.readInt();
        this.videoMaxSecond = in.readInt();
        this.videoMinSecond = in.readInt();
        this.recordVideoSecond = in.readInt();
        this.recordVideoMinSecond = in.readInt();
        this.minimumCompressSize = in.readInt();
        this.imageSpanCount = in.readInt();
        this.aspect_ratio_x = in.readInt();
        this.aspect_ratio_y = in.readInt();
        this.cropWidth = in.readInt();
        this.cropHeight = in.readInt();
        this.compressQuality = in.readInt();
        this.filterFileSize = in.readFloat();
        this.language = in.readInt();
        this.isMultipleRecyclerAnimation = in.readByte() != 0;
        this.isMultipleSkipCrop = in.readByte() != 0;
        this.isWeChatStyle = in.readByte() != 0;
        this.isUseCustomCamera = in.readByte() != 0;
        this.zoomAnim = in.readByte() != 0;
        this.isCompress = in.readByte() != 0;
        this.isOriginalControl = in.readByte() != 0;
        this.isCamera = in.readByte() != 0;
        this.isGif = in.readByte() != 0;
        this.isWebp = in.readByte() != 0;
        this.isBmp = in.readByte() != 0;
        this.enablePreview = in.readByte() != 0;
        this.enPreviewVideo = in.readByte() != 0;
        this.enablePreviewAudio = in.readByte() != 0;
        this.checkNumMode = in.readByte() != 0;
        this.openClickSound = in.readByte() != 0;
        this.enableCrop = in.readByte() != 0;
        this.freeStyleCropEnabled = in.readByte() != 0;
        this.circleDimmedLayer = in.readByte() != 0;
        this.circleDimmedColor = in.readInt();
        this.circleDimmedBorderColor = in.readInt();
        this.circleStrokeWidth = in.readInt();
        this.showCropFrame = in.readByte() != 0;
        this.showCropGrid = in.readByte() != 0;
        this.hideBottomControls = in.readByte() != 0;
        this.rotateEnabled = in.readByte() != 0;
        this.scaleEnabled = in.readByte() != 0;
        this.previewEggs = in.readByte() != 0;
        this.synOrAsy = in.readByte() != 0;
        this.returnEmpty = in.readByte() != 0;
        this.isDragFrame = in.readByte() != 0;
        this.isNotPreviewDownload = in.readByte() != 0;
        this.isWithVideoImage = in.readByte() != 0;
        this.uCropOptions = in.readParcelable(UCropOptions.class.getClassLoader());
        this.selectionMedias = in.createTypedArrayList(LocalMedia.CREATOR);
        this.cameraFileName = in.readString();
        this.isCheckOriginalImage = in.readByte() != 0;
        this.overrideWidth = in.readInt();
        this.overrideHeight = in.readInt();
        this.sizeMultiplier = in.readFloat();
        this.isChangeStatusBarFontColor = in.readByte() != 0;
        this.isOpenStyleNumComplete = in.readByte() != 0;
        this.isOpenStyleCheckNumMode = in.readByte() != 0;
        this.titleBarBackgroundColor = in.readInt();
        this.pictureStatusBarColor = in.readInt();
        this.cropTitleBarBackgroundColor = in.readInt();
        this.cropStatusBarColorPrimaryDark = in.readInt();
        this.cropTitleColor = in.readInt();
        this.upResId = in.readInt();
        this.downResId = in.readInt();
        this.outPutCameraPath = in.readString();
        this.originalPath = in.readString();
        this.cameraPath = in.readString();
        this.cameraMimeType = in.readInt();
        this.pageSize = in.readInt();
        this.isPageStrategy = in.readByte() != 0;
        this.isFilterInvalidFile = in.readByte() != 0;
        this.isMaxSelectEnabledMask = in.readByte() != 0;
        this.animationMode = in.readInt();
        this.isAutomaticTitleRecyclerTop = in.readByte() != 0;
        this.isCallbackMode = in.readByte() != 0;
        this.isAndroidQChangeWH = in.readByte() != 0;
        this.isAndroidQChangeVideoWH = in.readByte() != 0;
        this.isQuickCapture = in.readByte() != 0;
        this.isFallbackVersion = in.readByte() != 0;
        this.isFallbackVersion2 = in.readByte() != 0;
        this.isFallbackVersion3 = in.readByte() != 0;
    }

    public static final Creator<PictureSelectionConfig> CREATOR = new Creator<PictureSelectionConfig>() {
        @Override
        public PictureSelectionConfig createFromParcel(Parcel source) {
            return new PictureSelectionConfig(source);
        }

        @Override
        public PictureSelectionConfig[] newArray(int size) {
            return new PictureSelectionConfig[size];
        }
    };
}
