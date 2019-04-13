package controller;

import bean.AdapterResponseBean;
import conf.ProjectResource;

/**
 * 适配器接口
 */
abstract public class AdapterI {

    public String json;
    public String userId;
    public static final String SUCCESS_SIGN="{\"state\":1}";
    public static final String FAIL_SIGN="{\"state\":0}";

    public void setAdapterResponseBean(String json) {
        this.json = json;
    }

    abstract public AdapterResponseBean getAdapterResponse();

}
