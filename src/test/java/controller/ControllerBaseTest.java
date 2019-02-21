package controller;

import adapter.Distribute;
import bean.SendTrendsBean;
import com.alibaba.fastjson.JSONObject;
import db.mysql.MysqlBase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ControllerBaseTest {

    protected Distribute distribute = new Distribute();
    protected SendTrendsController sendTrendsController = new SendTrendsController();;

    @BeforeEach
    public void init() {
        MysqlBase.init();
        System.out.println("==================== init is over ===================");
    }
}
