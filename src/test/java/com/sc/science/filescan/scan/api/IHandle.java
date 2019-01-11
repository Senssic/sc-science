package com.sc.science.filescan.scan.api;

import java.io.File;
import java.io.IOException;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IHandle {
/**
     * 处理方式
     */
    public void doHandle(File file) throws IOException;



}
