package com.sc.science.scan;

import com.sc.science.scan.api.IOutPut;
import com.sc.science.scan.dto.AbsAppation;

import org.apache.commons.io.FileUtils;

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
public class FileOutPut implements IOutPut {
    private File outFile;

    FileOutPut(File outFile, StringBuilder stringBuilder) {
        this.outFile = outFile;
    }

    @Override
    public void writeOut(AbsAppation absAppation) throws IOException {
        FileUtils.writeByteArrayToFile(outFile, absAppation.toString().getBytes());
    }
}
