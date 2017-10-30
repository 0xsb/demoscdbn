/*
 * 
 */
package com.cmcc.ms.common.utils;

import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 常用数据列名 datasCNUtils _datasColumnNameUtils.
 *
 * @author 
 */
@Component
public class DatasCNUtils {

    /** The datas CN utils. */
    @Autowired
    private static DatasCNUtils datasCNUtils;

    /**
     * Gets the datas CN utils.
     *
     * @return the datas CN utils
     */
    public static DatasCNUtils getDatasCNUtils() {
        return datasCNUtils;
    }

    /**
     * Sets the datas CN utils.
     *
     * @param datasCNUtils the new datas CN utils
     */
    public static void setDatasCNUtils(DatasCNUtils datasCNUtils) {
        DatasCNUtils.datasCNUtils = datasCNUtils;
    }

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        setDatasCNUtils(this);
    }

    /** The publish datas column name. */
    public static LinkedHashMap<String, String> publishDatasColumnName = new LinkedHashMap<>();

    static {

        publishDatasColumnName.put("ID", "id");
        publishDatasColumnName.put("分类", "classify");
        publishDatasColumnName.put("发布者", "publisher");
        publishDatasColumnName.put("发布状态", "publishStatus");
        publishDatasColumnName.put("发布时间", "publishTime");
        publishDatasColumnName.put("编辑时间", "editTime");
        publishDatasColumnName.put("操作", "operation");
    }
}
