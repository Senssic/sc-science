package com.sc.science.filescan.poi;


import org.jsoup.helper.StringUtil;

import java.util.HashMap;
import java.util.Map;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class IpMapper {
    @Excel(name = "servicename")
    private String servicename;
    @Excel(name = "fat-apt")
    private String fatapt;
    @Excel(name = "fat-op")
    private String fatop;
    @Excel(name = "fat-pms")
    private String fatpms;
    @Excel(name = "pre")
    private String pre;
    @Excel(name = "prd01")
    private String prd01;
    @Excel(name = "prd02")
    private String prd02;
    @Excel(name = "prd03")
    private String prd03;
    @Excel(name = "prd04")
    private String prd04;
    @Excel(name = "prd05")
    private String prd05;

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getFatapt() {
        return fatapt;
    }

    public void setFatapt(String fatapt) {
        this.fatapt = fatapt;
    }

    public String getFatop() {
        return fatop;
    }

    public void setFatop(String fatop) {
        this.fatop = fatop;
    }

    public String getFatpms() {
        return fatpms;
    }

    public void setFatpms(String fatpms) {
        this.fatpms = fatpms;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getPrd01() {
        return prd01;
    }

    public void setPrd01(String prd01) {
        this.prd01 = prd01;
    }

    public String getPrd02() {
        return prd02;
    }

    public void setPrd02(String prd02) {
        this.prd02 = prd02;
    }

    public String getPrd03() {
        return prd03;
    }

    public void setPrd03(String prd03) {
        this.prd03 = prd03;
    }

    public String getPrd04() {
        return prd04;
    }

    public void setPrd04(String prd04) {
        this.prd04 = prd04;
    }

    public String getPrd05() {
        return prd05;
    }

    public void setPrd05(String prd05) {
        this.prd05 = prd05;
    }

    public Map<String, String> featchEnv() {
        Map envs = new HashMap();
        if (!StringUtil.isBlank(fatapt)) {
            envs.put(fatapt, "fatapt");
        }
        if (!StringUtil.isBlank(fatop)) {
            envs.put(fatop, "fatop");
        }
        if (!StringUtil.isBlank(fatpms)) {
            envs.put(fatpms, "fatpms");
        }
        if (!StringUtil.isBlank(pre)) {
            envs.put(pre, "pre");
        }
        if (!StringUtil.isBlank(prd01)) {
            envs.put(prd01, "prd01");
        }
        if (!StringUtil.isBlank(prd02)) {
            envs.put(prd02, "prd02");
        }
        if (!StringUtil.isBlank(prd03)) {
            envs.put(prd03, "prd03");
        }
        if (!StringUtil.isBlank(prd04)) {
            envs.put(prd04, "prd04");
        }
        if (!StringUtil.isBlank(prd05)) {
            envs.put(prd05, "prd05");
        }
        return envs;
    }
}
