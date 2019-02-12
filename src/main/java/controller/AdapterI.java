package controller;

import bean.AdapterResponseBean;
import conf.ProjectResource;

/**
 * 适配器接口
 */
abstract public class AdapterI {

    String json;
    public static final String SUCCESS_SIGN="{\"stat\":1}";
    public static final String FAIL_SIGN="{\"stat\":0}";

    public void setAdapterResponseBean(String json) {
        this.json = json;
    }

    abstract public AdapterResponseBean getAdapterResponse();

}
