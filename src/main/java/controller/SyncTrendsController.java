package controller;

import adapter.MethodName;
import bean.AdapterResponseBean;
import bean.SyncMessageRequestBean;
import bean.SyncTrendsBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.entity.TrendsEntity;
import db.mysql.provider.TrendsSyncProviderBaseMapper;

import java.util.List;

public class SyncTrendsController extends AdapterI {

    private List<TrendsEntity> trendsEntities;

    private SyncTrendsBean resolveJson() {
        SyncTrendsBean syncTrendsBean = JSONObject.parseObject(json, SyncTrendsBean.class);
        return syncTrendsBean;
    }

    @Override
    public AdapterResponseBean getAdapterResponse() {
        String trendsEntitiesJson = JSONObject.toJSONString(trendsEntities);
        AdapterResponseBean adapterResponseBean = new AdapterResponseBean(null, trendsEntitiesJson);
        return adapterResponseBean;
    }

    /**
     * 下拉刷新
     */
    @MethodName(methodName = "getAllTrends")
    public void getAllTrends() {

        SyncTrendsBean syncTrendsBean = resolveJson();
        // 获取应用本地id
        String userId = syncTrendsBean.getUserId();

        TrendsSyncProviderBaseMapper trendsSyncProviderBaseMapper = new TrendsSyncProviderBaseMapper();

        if (userId == null || userId.equals("")) {
            trendsEntities = trendsSyncProviderBaseMapper.flushTrends();
        } else {
            trendsEntities = trendsSyncProviderBaseMapper.showUserAllTrends(userId);
        }

    }

    /**
     * 上拉加载
     */
    @MethodName(methodName = "getload")
    public void getload() {
        // 获取应用本地id
        SyncTrendsBean syncTrendsBean = resolveJson();
        String locatTrendsId = syncTrendsBean.getLocatTrendsId();
        String userId = syncTrendsBean.getUserId();

        TrendsSyncProviderBaseMapper trendsSyncProviderBaseMapper = new TrendsSyncProviderBaseMapper();

        if (userId == null || !userId.equals("")) {
            trendsEntities = trendsSyncProviderBaseMapper.showMoreTrends(locatTrendsId);
        } else {
            trendsEntities = trendsSyncProviderBaseMapper.showUserAllTrends(userId);
        }
    }

}
