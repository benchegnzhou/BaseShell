package com.ztsc.china.network.api;

import com.ztsc.china.BuildConfig;
import com.ztsc.china.application.MApplication;
import com.ztsc.china.utils.DeviceMessageUtils;

import java.util.HashMap;



/**
 * Created by zbc on 2017/3/15.
 */

public class API {

    //服务主机
    public static final String SERVICE_HOST = BuildConfig.HOST_SERVICE;


    //用户密码登录登录
    public static final String USER_LOGIN_BYPASTWORD = SERVICE_HOST;

    //用户验证码登录
    public static final String USER_LOGIN_BYCODE = SERVICE_HOST;

    //用户token登录
    public static final String USER_LOGIN_BYTOKEN = SERVICE_HOST;


    //用户登录获取验证码
    public static final String GETCODE_FOR_LOGIN = SERVICE_HOST;


    //用户注册获取验证码
    public static final String GETCODE_FOR_REGISTER = SERVICE_HOST;

    //用户注册校验验证码
    public static final String CHECKCODE_FOR_REGISTER = SERVICE_HOST;
    //用户修改密码
    public static final String PASSWORD_CHANGE = SERVICE_HOST;


    //用户身份验证获取验证码
    public static final String GETCODE_FOR_OTHERS = SERVICE_HOST;


    //用户注册
    public static final String USER_REGISTER = SERVICE_HOST;


    /**
     * 获取用户注册获取验证码的url
     *
     * @return
     */
    public static String getGetcodeForRegisterUrl() {
        return GETCODE_FOR_REGISTER + "?service=user&function=getCodeForRegister";
    }

    /**
     * 获取用户注册验证码校验的url
     *
     * @return
     */
    public static String getCheckcodeForRegisterUrl() {
        return CHECKCODE_FOR_REGISTER + "?service=user&function=checkZCCode";
    }

    /**
     * 获取用户密码登录的url
     *
     * @return
     */
    public static String getUserLoginByPasswordUrl() {
        return SERVICE_HOST + "?service=user&function=phoneNumLogin";
    }

    /**
     * 获取用户验证码登录获取验证码的url
     *
     * @return
     */
    public static String getUserLoginByCodeUrl() {

        return SERVICE_HOST + "?service=user&function=checkLoginCode";
    }

    public static String getUserLoginByTokenUrl() {

        return SERVICE_HOST + "?service=user&function=tokenLogin";
    }

    /**
     * 获取用户验证码登录的url
     *
     * @return
     */
    public static String getGetCodeForLoginUrl() {
        return SERVICE_HOST + "?service=user&function=getCodeForLogin";
    }

    /**
     * 获取用户密码修改的url
     *
     * @return
     */
    public static String getChangePasswordUrl() {
        return SERVICE_HOST + "?service=user&function=updatePassWord";
    }

    /**
     * 获取用户头像修改的url
     *
     * @return
     */
    public static String getChangeUserIconUrl() {
        return SERVICE_HOST + "?service=user&function=updateHeadImage";
    }
    /**
     * 获取用户需要交费的所有信息的url
     *
     * @return
     */
    public static String getGetLifePayAllMessageUrl() {
        return SERVICE_HOST + "?service=lifeCostService&function=costBaseList";
    }
    /**
     * 获取用户缴费单位
     *
     * @return
     */
    public static String getLifePayCompanyUrl() {
        return SERVICE_HOST + "?service=lifeCostService&function=companyList";
    }

    /**
     * 获取用户已购买服务订单列表的url
     *
     * @return
     */
    public static String getUserBuyServiceUrl() {
        return SERVICE_HOST + "?service=userOrderForm&function=lookBuyOrderForm";
    }

    /**
     * 获取用户已出售服务订单的url
     *
     * @return
     */
    public static String getUserSellServiceUrl() {
        return SERVICE_HOST + "?service=userOrderForm&function=lookSaleOrderForm";
    }

    /**
     * 获取行政区县的url
     *
     * @return
     */
    public static String getSecondHandAdUrl() {
        return "http://192.168.1.57/adcodejson.json";
    }

    /**
     * 获取用户帮助的订单的url
     *
     * @return
     */
    public static String getUserHelpUrl() {
        return "http://192.168.1.80:9090/house/SeekHelpOrderHelper.json";
    }

    /**
     * 获取用户求助的订单的url
     *
     * @return
     */
    public static String getUserNeedHelpUrl() {
        return "http://192.168.1.80:9090/house/SeekHelpOrderLaunch.json";
    }

    /**
     * 获取用户房屋列表的url
     *
     * @return
     */
    public static String getMyHouseListUrl() {
        return SERVICE_HOST + "?service=userHouse&function=lookAllHouseWithMe";
    }

    /**
     * 用户添加房屋关注的url
     *
     * @return
     */
    public static String getMyHouseAttendUrl() {
        return SERVICE_HOST + "?service=userHouse&function=addLikeHouse";
    }
    /**
     * 查看二手物品url
     *
     * @return
     */
    public static String getSecondHandBeanUrl() {
        return SERVICE_HOST + "?service=secondHand&function=query";
    }

    /**
     * 用户取消房屋关注的url
     *
     * @return
     */
    public static String getCancelMyHouseAttendUrl() {
        return SERVICE_HOST + "?service=userHouse&function=unHouse";
    }

    /**
     * 用户添加房屋绑定的url
     *
     * @return
     */
    public static String getAddMyHouseBindUrl() {
        return SERVICE_HOST + "?service=userHouse&function=addBindHouse";
    }
    /**
     * 用户生活缴费添加账号绑定的url
     *
     * @return
     */
    public static String getLifePayBindAccountUrl() {
        return SERVICE_HOST + "?service=lifeCostService&function=bindAccount";
    }
    /**
     * 用户生活缴费交钱的url
     *
     * @return
     */
    public static String getLifePayUrl() {
        return SERVICE_HOST + "?service=lifeCostService&function=costing";
    }

    /**
     * 用户取消房屋绑定的url
     *
     * @return
     */
    public static String getCancelMyHouseBindUrl() {
        return SERVICE_HOST + "?service=userHouse&function=unHouse";
    }

    /**
     * 用户获取生活缴费历史的url
     *
     * @return
     */
    public static String getLifePayHistoryUrl() {
        return SERVICE_HOST + "?service=lifeCostService&function=costRecordList";
    }

    /**
     *删除生活缴费的账号url
     *
     * @return
     */
    public static String getCommunityDelCostAccountUrl() {
        return SERVICE_HOST + "?service=lifeCostService&function=delCostAccount";
    }

    /**
     *修改生活缴费的账号url
     *
     * @return
     */
    public static String getCommunityUpdateAccountUrl() {
        return SERVICE_HOST + "?service=lifeCostService&function=updateCostAccount";
    }


    /**
     * 用户添加小区关注的url
     *
     * @return
     */
    public static String getMyCommunitiesAttendUrl() {
        return SERVICE_HOST + "?service=userVillage&function=addConcernVillage";
    }

    /**
     * 用户取消小区关注的url
     *
     * @return
     */
    public static String getCancelMyCommunitiesAttendUrl() {
        return SERVICE_HOST + "?service=userVillage&function=unConcernVillage";
    }


    /**
     * 用户搜索小区的url
     *
     * @return
     */
    public static String getSearchCommunitiesUrl() {
        return SERVICE_HOST + "?service=common&function=searchVillagesByKeyWords";
    }

    /**
     * 用户搜索楼栋的url
     *
     * @return
     */
    public static String getSearchFloorsUrl() {
        return SERVICE_HOST + "?service=common&function=searchBuildingByVillage";
    }

    /**
     * 用户搜索房屋绑定的url
     *
     * @return
     */
    public static String getSearchHousesUrl() {
        return SERVICE_HOST + "?service=common&function=searchHouses";
    }

    /**
     * 用户获取好友列表url
     *
     * @return
     */
    public static String getSearchFriendsUrl() {
        return SERVICE_HOST + "?service=friendService&function=myFriends";
    }

    /**
     * 用户获取好友列表url
     *
     * @return
     */
    public static String getGetFriendsListUrl() {
        return SERVICE_HOST + "?service=friendService&function=myFriends";
    }

    /**
     * 用户获取同小区好友url
     *
     * @return
     */
    public static String getGetSameTownFriendsUrl() {
        return SERVICE_HOST + "?service=friendService&function=lookPepoleByVillage";
    }
    /**
     * 根据手机号搜索好友url
     *
     * @return
     */
    public static String getSearchFriendsByPhoneUrl() {
        return SERVICE_HOST + "?service=user&function=findUserInfoByPhone";
    }
    /**
     * 根据userid搜索好友url
     *
     * @return
     */
    public static String getUserInformationUrl() {
        return SERVICE_HOST + "?service=friendService&function=lookUserAll";
    }

    /**
     * 用户获取活跃的好友url
     *
     * @return
     */
    public static String getGetActivFriendsUrl() {
        return SERVICE_HOST + "?service=friendService&function=lookRecentLoginUser";
    }

    /**
     * 用户添加好友url
     *
     * @return
     */
    public static String getAddFriendsUrl() {
        return SERVICE_HOST + "?service=friendService&function=addFriend";
    }

    /**
     * 用户删除好友url
     *
     * @return
     */
    public static String getDeleteFriendsUrl() {
        return SERVICE_HOST + "?service=friendService&function=deleteFriend";
    }

    /**
     * 用户获取我的小区url
     *
     * @return
     */
    public static String getMyCommunityUrl() {
        return SERVICE_HOST + "?service=userVillage&function=lookAllVillageWithMe";
    }


    /**
     * 获取社区便民信息的url
     *
     * @return
     */
    public static String getCommunityConvenienceUrl() {
        return SERVICE_HOST + "?service=propertyService&function=convenience";
    }

    /**
     * 获取社区上门服务的url
     *
     * @return
     */
    public static String getCommunityServiceReportUrl() {
        return SERVICE_HOST + "?service=propertyService&function=visitService";
    }

    /**
     * 获取社区上门服务类型的url
     *
     * @return
     */
    public static String getCommunityServiceTypeUrl() {
        return SERVICE_HOST + "?service=propertyService&function=serviceList";
    }

    /**
     * 获取物业切换小区与我相关小区列表的url
     *
     * @return
     */
    public static String getCommunityVillageListUrl() {
        return SERVICE_HOST + "?service=userVillage&function=lookAllVillageWithMe";
    }
    /**
     * 获取物业上报小区设施的url
     *
     * @return
     */
    public static String getCommunityFeatureReportUrl() {
        return SERVICE_HOST+"?service=propertyService&function=sendVillagePanorama";
    }

    /**
     * 获取社区公共报事服务类型的url
     *
     * @return
     */
    public static String getCommunityServicePublicTypeUrl() {
        return SERVICE_HOST + "?service=propertyService&function=affairCategoryList";
    }

    /**
     * 获取社区公共报事服务类型的url
     *
     * @return
     */
    public static String getCommunityPublicMessageListUrl() {
        return SERVICE_HOST + "?service=propertyService&function=bulletinList";
    }

    /**
     * 获取小区全景的url
     *
     * @return
     */
    public static String getCommunityAllLookUrl() {
        return SERVICE_HOST + "?service=propertyService&function=lookVillagePanorama";
    }

    /**
     * 获取社区物业代缴费列表的url
     *
     * @return
     */
    public static String getCommunityGetVillagePayBillListUrl() {
        return SERVICE_HOST + "?service=propertyService&function=billList";
    }

    /**
     * 获取社区物业缴费订单信息的url
     *
     * @return
     */
    public static String getCommunityPayBillsOrderUrl() {
        return SERVICE_HOST + "?service=propertyService&function=getCostParam";
    }


    /**
     * 获取通知服务端缴费物业缴费成功的url
     *
     * @return
     */
    public static String getCommunityPaySuccessUrl() {
        return SERVICE_HOST + "?service=propertyService&function=costSuccess";
    }
    /**
     * 获取社区物业缴费提交的url
     *
     * @return
     */
    public static String getCommunityPayUrl() {
        return SERVICE_HOST + "?service=propertyService&function=pay";
    }

    /**
     * 获取社区物业缴费历史列表的url
     *
     * @return
     */
    public static String getCommunityGetVillagePayBillHistoryListUrl() {
        return SERVICE_HOST + "?service=propertyService&function=paymentList";
    }

    /**
     * 获取社区公共报事的url
     *
     * @return
     */
    public static String getPublicCommunityServiceReportUrl() {
        return SERVICE_HOST + "?service=propertyService&function=publicAffair";
    }

    /**
     * 获取社区物业投诉的url
     *
     * @return
     */
    public static String getCommunityComplainReportUrl() {
        return SERVICE_HOST + "?service=propertyService&function=complain";
    }

    /**
     * 获取社区物业表扬的url
     *
     * @return
     */
    public static String getCommunityPariseReportUrl() {
        return SERVICE_HOST + "?service=propertyService&function=praise";
    }
    /**
     * 获取我上报的公共报事
     *
     * @return
     */
    public static String getMyReportPublicThingUrl() {
        return SERVICE_HOST + "?service=propertyService&function=publicAffairList";
    }
    /**
     * 获取我上报的上门服务
     *
     * @return
     */
    public static String getMyLookVisitEventUrl() {
        return SERVICE_HOST + "?service=propertyService&function=lookvisitService";
    }
    /**
     * 获取我的表扬
     *
     * @return
     */
    public static String getMeMyCommendUrl() {
        return SERVICE_HOST + "?service=propertyService&function=praiseList";
    }
    /**
     * 获取我的投诉
     *
     * @return
     */
    public static String getMeMyComplainUrl() {
        return SERVICE_HOST + "?service=propertyService&function=complainList";
    }

    /**
     * 获取邻里圈发帖子的url
     *
     * @return
     */
    public static String getPublishTopicUrl() {
        return SERVICE_HOST + "?service=topic&function=newTopic";
    }

    /**
     * 点赞的url
     *
     * @return
     */
    public static String getPressLikeUrl() {
        return SERVICE_HOST + "?service=topic&function=thumbsUp";
    }

    /**
     * 评论的url
     *
     * @return
     */
    public static String commentUrl() {
        return SERVICE_HOST + "?service=topic&function=reply";
    }

    /**
     * 获取邻里圈帖子的url
     *
     * @return
     */
    public static String getNeighborTopicUrl() {
        return SERVICE_HOST + "?service=topic&function=loadTopic";
    }

    /**
     * 获取用户修改信息的url
     *
     * @return
     */
    public static String getUserMessageChangeUrl() {
        return SERVICE_HOST + "?service=user&function=updateUser";
    }

    /**
     * 获取用户修改头像的url
     *
     * @return
     */
    public static String getUserIconChangeUrl() {
        return SERVICE_HOST + "?service=user&function=updateHeadImage";
    }

    /**
     * 获取我发布的帖子的url
     *
     * @return
     */
    public static String getMyNeignbourTopicUrl() {
        //      return "http://192.168.1.80:9090/house/MyTopicList.json";
        return SERVICE_HOST + "?service=topic&function=topicHis";

    }

    /**
     * 删除我发布的评论
     *
     * @return
     */
    public static String getNeighborsDeleteCommentUrl() {
        return SERVICE_HOST + "?service=topic&function=deleteReply";

    }

    /**
     * 删除我发布的帖子
     *
     * @return
     */
    public static String getNeighborsDeleteTopicUrl() {
        return SERVICE_HOST + "?service=topic&function=deleteTopic";

    }

    /**
     * 获取二手物品列表
     *
     * @return
     */
    public static String getSecondHandThingsUrl() {
        return SERVICE_HOST + "?service=secondHand&function=catalog";
    }

    /**
     * 获取用户消息
     *
     * @return
     */
    public static String getMyMessageUrl() {
        return SERVICE_HOST + "?service=userMessageService&function=getUnreadMessage";
    }

    /**
     * 二手物品发布
     *
     * @return
     */
    public static String getSecondHandReleaseUrl() {
        return SERVICE_HOST + "?service=secondHand&function=publish";
    }

    /**
     * 二手物品搜索
     *
     * @return
     */
    public static String getSecondHandSearchUrl() {
        return SERVICE_HOST + "?service=secondHand&function=query";
    }

    /**
     * 二手物品下架
     *
     * @return
     */
    public static String getSecondHandOffShelvesUrl() {
        return SERVICE_HOST + "?service=secondHand&function=stopPublish";
    }
    /**
     * 房屋停止出租
     *
     * @return
     */
    public static String getMyHouseStopRentUrl() {
        return SERVICE_HOST + "?service=house&function=stopRent";
    }

    /**
     * 二手物品评论
     *
     * @return
     */
    public static String getSecondHandCommitUrl() {
        return SERVICE_HOST + "?service=secondHand&function=reply";
    }

    /**
     * 二手物品对评论的评论
     *
     * @return
     */
    public static String getSecondHandCommitCommitUrl() {
        return SERVICE_HOST + "?service=secondHand&function=replyComment";
    }

    /**
     * 二手物品删除我发的评论
     *
     * @return
     */
    public static String getSecondHandDeleteMyCommentUrl() {
        return SERVICE_HOST + "?service=secondHand&function=deleteReply";
    }

    /**
     * 获取周边服务:服务类型,求助类型列表和服务单位获取
     *
     * @return
     */
    public static String getSurroundingCatoryListUrl() {
        return SERVICE_HOST + "?service=serviceService&function=serviceOrAppealCategory";
    }
    /**
     * 出租房屋
     *
     * @return
     */
    public static String getMyHouseRentReleaseResultUrl() {
        return SERVICE_HOST + "?service=house&function=rent";
    }
    /**
     * 搜索出租房屋
     *
     * @return
     */
    public static String getSearchRentHouseResultUrl() {
        return SERVICE_HOST + "?service=house&function=queryRent";
    }

    /**
     * 获取我发布的服务
     *
     * @return
     */
    public static String getMyReleaseServiceUrl() {
        return SERVICE_HOST + "?service=serviceService&function=searchService";
    }

    /**
     * 获取我发布的求助
     *
     * @return
     */
    public static String getMyReleaseHelpUrl() {
        return SERVICE_HOST + "?service=serviceService&function=searchAppeal";
    }

    /**
     * 获取周边服务:服务列表获取
     *
     * @return
     */
    public static String getSurroundingServiceSeachListUrl() {
        return SERVICE_HOST + "?service=serviceService&function=searchService";
    }

    /**
     * 下架我发布的服务
     *
     * @return
     */
    public static String getMyReleaseServiceCancleUrl() {
        return SERVICE_HOST + "?service=serviceService&function=cancelReleaseService";
    }

    /**
     * 下架我发布的求助
     *
     * @return
     */
    public static String getMyReleaseHelpCancleUrl() {
        return SERVICE_HOST + "?service=serviceService&function=cancelReleaseAppeal";
    }

    /**
     * 获取周边服务:求助列表获取
     *
     * @return
     */
    public static String getSurroundingDoHelpListUrl() {
        return SERVICE_HOST + "?service=serviceService&function=searchAppeal";
    }

    /**
     * 二手物品收藏
     *
     * @return
     */
    public static String getSecondHandDoLikeUrl() {
        return SERVICE_HOST + "?service=secondHand&function=keep";
    }

    /**
     * 二手物品的评论点赞
     *
     * @return
     */
    public static String getSecondHandcommentLikeUrl() {
        return SERVICE_HOST + "?service=secondHand&function=commentThumbsUp";
    }


    /**
     * 获取周边服务  -  服务下单
     *
     * @return
     */
    public static String getSurroundingServiceBuyUrl() {
        return SERVICE_HOST + "?service=serviceService&function=buyServiceOrderForm";
    }


    /**
     * 获取周边服务:求助信息发布
     *
     * @return
     */
    public static String getSurroundingGetHelpPublishUrl() {
        return SERVICE_HOST + "?service=serviceService&function=releaseAppeal";
    }


    /**
     * 获取周边服务:服务信息发布
     *
     * @return
     */
    public static String getSurroundingProviderServicePublishUrl() {
        return SERVICE_HOST + "?service=serviceService&function=releaseService";
    }

    /**
     * 获取周边服务:卖家接单前卖家取消
     *
     * @return
     */
    public static String getBuyServiceCancleBeforeOrderUrl() {

        return SERVICE_HOST + "?service=serviceService&function=buyServiceCancelOrderAgo";
    }


    /**
     * 我的服务订单:卖家接单或拒单通用接口
     *
     * @return
     */
    public static String getBuyServiceAcceptRefuseOrderUrl() {
        return SERVICE_HOST + "?service=serviceService&function=dealServiceOrderForm";
    }

    /**
     * 我的服务订单:卖家、买家确认、取消订单通用接口
     *
     * @return
     */
    public static String getServiceOrderDealUrl() {
        return SERVICE_HOST + "?service=orderService&function=orderDeal";
    }

    /**
     * 我的服务订单:卖家、买家应答同意，不同意单通用接口
     *
     * @return
     */
    public static String getServiceOrderResponseDealUrl() {
        return SERVICE_HOST + "?service=orderService&function=order";
    }


    /**
     * 我的订单，订单取消选择原因
     *
     * @return
     */
    public static String getServiceOrderCancleReasonUrl() {
        return SERVICE_HOST + "?service=orderService&function=reasonList";
    }

    /**
     * 获取小区的可上报设施的列表
     *
     * @return
     */
    public static String getHomeZoneMapFeatureReportClassifyUrl() {
        return SERVICE_HOST + "?service=propertyService&function=villageFeatureTypeList";
    }


    /**
     * 地理定位，通过地理x,y坐标获取对应的POI
     *
     * @return
     */
    public static String getLoacatonPOIByXYUrl() {
        return "http://192.168.1.57:8080/MapServer/Service?server=RGeocode&distance=5000&page_num=10";
    }
    /**
     * 根据房屋的id获取房屋的详细信息
     *
     * @return
     */
    public static String getMyHouseMsgUrl() {
        return SERVICE_HOST + "?service=house&function=houseInfo";
    }

    /**
     * 获取首页将GPS坐标转换物流坐标的url
     *
     * @return
     */
    public static String getGps2LoacatonUrl() {
        return "http://192.168.1.57:8080/MapServer/Service?server=Offset";
    }

    /**
     * 获取首页广告轮播广告信息的url
     * @return
     */
    public static String getHomeCityPictureAdvertimentUrl() {
        return SERVICE_HOST + "?service=adPhotoService&function=cityAdList";
    }

    /**
     * 获取物业广告轮播广告信息的url
     * @return
     */
    public static String getCommunityZonePictureAdvertimentUrl() {
        return SERVICE_HOST + "?service=adPhotoService&function=propertyAdList";
    }


    /**
     * 获取周边服务去帮忙帮助者下单的url
     * @return
     */
    public static String getSurroundingDoHelpMakeOrderUrl() {
        return SERVICE_HOST + "?service=serviceService&function=buyAppealOrderForm";
    }

    /**
     * 获取我的求助订单  我帮助的url
     * @return
     */
    public static String getAppealOrderDohelpListUrl() {
        return SERVICE_HOST + "?service=userOrderForm&function=lookHelpOrderForm";
    }

    /**
     * 获取我的求助订单  我求助的url
     * @return
     */
    public static String getAppealOrderGethelpListUrl() {
        return SERVICE_HOST + "?service=userOrderForm&function=lookMyAppealOrderForm";
    }
    /**
     * 获取帮助者在接单前取消订单的url
     * @return
     */
    public static String getAppealOrderHelperCancleBeforeAcceptUrl() {
        return SERVICE_HOST + "?service=serviceService&function=appealCancelOrderAgo";
    }



    /**
     * 我的服务订单:求助者接单或拒单通用接口
     *
     * @return
     */
    public static String getAppealerAcceptRefuseOrderUrl() {
        return SERVICE_HOST + "?service=serviceService&function=dealAppealOrderForm";
    }




    /**
     * 我的求助订单:卖家、求助者确认、取消订单通用接口
     *
     * @return
     */
    public static String getAppealOrderDealCommonUrl() {
        return SERVICE_HOST + "?service=appealOrderService&function=appealOrderDeal";
    }

    /**
     * 我的求助订单:求助者，帮助者应答同意，不同意单通用接口
     *
     * @return
     */
    public static String getAppealOrderResponseDealUrl() {
        return SERVICE_HOST + "?service=appealOrderService&function=order";
    }

    /**
     * 心跳
     *
     * @return
     */
    public static String getUploadHeartbeatUrl() {
        return SERVICE_HOST + "service=adPhotoService&function=upUserOnline";
    }

    /**
     * GPS位置
     *
     * @return
     */
    public static String getUploadGPSLocationUrl() {
        return SERVICE_HOST + "?service=adPhotoService&function=upUserXY";
    }


    /**
     *
     * 周边服务获取区域内(省，市，县)服务数量
     *
     * @return
     */
    public static String getSurroundingSeachServiceGetAmountUrl() {
        return SERVICE_HOST + "?service=adPhotoService&function=lookServiceNumByArea";
    }
    /**
     *
     * 周边查找求助区域内(省，市，县)数量
     *
     * @return
     */
    public static String getSurroundingGetAppealGetAmountUrl() {
        return SERVICE_HOST + "?service=adPhotoService&function=lookAppealNumByArea";
    }



    /**
     * 拼接公共的请求参数
     * 所有的公共参数都放在这里
     *
     * @return
     */
    public static HashMap<String, String> getCommonParams() {
        HashMap<String, String> objectHashMap = new HashMap<>();
        objectHashMap.put("machineId", DeviceMessageUtils.getIMEI(MApplication.sAppContext));
        objectHashMap.put("machineName", DeviceMessageUtils.getMobileInfo(MApplication.sAppContext));
        objectHashMap.put("clientType", "1");

        return objectHashMap;
    }


}
