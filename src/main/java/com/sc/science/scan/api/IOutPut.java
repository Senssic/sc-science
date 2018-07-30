package com.sc.science.scan.api;

import com.sc.science.scan.dto.AbsAppation;

import java.io.IOException;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface IOutPut {

    public void writeOut(AbsAppation absAppation) throws IOException;
}
