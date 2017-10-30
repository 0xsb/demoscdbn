/**
 * @author ldy
 */
package com.cmcc.ms.service.system;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import com.cmcc.ms.entity.system.OperateLog;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;



/**
 * The Interface OperateLogService.
 */
public interface OperateLogService {

    /**
     * Fuzzy query by name.
     *
     * @param map the map
     * @param pb the pb
     * @return the list
     */
    // 模糊查询
    List<OperateLog> fuzzyQueryByName(Map<String, Object> map, PageBounds pb);

    /**
     * Gets the fuzzy query size.
     *
     * @param map the map
     * @return the fuzzy query size
     */
    // 模糊查询总记录数
    int getFuzzyQuerySize(Map<String, Object> map);

    /**
     * Save user operation.
     *
     * @param operateLog the operate log
     * @param request the request
     * @return the int
     */
    // 记录操作
    int saveUserOperation(OperateLog operateLog, HttpServletRequest request);
    //日志导出操作
    

	/**
     * Export.
     *
     * @param operateLoglist the operate loglist
     * @param out the out
     * @throws Exception the exception
     */
    void export(JSONArray operateLoglist, OutputStream out) throws Exception;
}
