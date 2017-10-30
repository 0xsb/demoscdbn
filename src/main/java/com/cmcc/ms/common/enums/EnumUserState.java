package com.cmcc.ms.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户状态
 * @author ldy
 *
 */
public enum EnumUserState {
    DISABLE(0, "已禁用"),
    ABLE(1, "已启用");

    private Integer code;
    private String name;

    EnumUserState(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getKey() {
        return this.code;
    }

    public String getValue() {
        return this.name;
    }

    /**
     * 
     * @return
     */
    public static Map<Integer, String> toReportMap() {
        Map<Integer, String> enumDataMap = new HashMap<Integer, String>();
        enumDataMap.put(EnumUserState.DISABLE.getKey(), EnumUserState.DISABLE.getValue());
        enumDataMap.put(EnumUserState.ABLE.getKey(), EnumUserState.ABLE.getValue());
        return enumDataMap;
    }

    /**
     * 根据code索引枚举
     * Default ABLE
     * @param code
     * @return
     */
    public static EnumUserState indexByCode(Integer code) {
        for (EnumUserState item : EnumUserState.values()) {
            if (code.equals(item.getKey())) {
                return item;
            }
        }
        return EnumUserState.ABLE;
    }
}
