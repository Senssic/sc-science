package com.sc.science.scan;

import com.sc.science.scan.api.IHandle;
import com.sc.science.scan.api.IOutPut;
import com.sc.science.scan.dto.AbsAppation;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RegHandle implements IHandle {

    private static final Pattern patternIP = Pattern.compile("(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)");
    private static final Pattern patternDate = Pattern.compile("\\d{2}\\/.*\\/\\d{4}:\\d{2}:\\d{2}:\\d{2}");
    private static final Pattern patternContent = Pattern.compile("POST (.*) HTTP");

    private IOutPut outPut;

    RegHandle(IOutPut outPut) {
        this.outPut = outPut;
    }


    public Boolean checkData(String content) {
        return true;
    }

    /**
     * 处理方式
     */
    @Override
    public void doHandle(File file) throws IOException {
        String string = FileUtils.readFileToString(file, "utf-8");
        Scanner scanner = new Scanner(string);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String nextstr = scanner.next();
            if (checkData(nextstr)) {
                AbsAppation logInfo = new AbsAppation();
                Matcher matcherstr = patternContent.matcher(nextstr);
                while (matcherstr.find()) {
                    logInfo.setServiceUrl(matcherstr.group(1));
                }
                Matcher calssm = patternDate.matcher(nextstr);
                while (calssm.find()) {
                    String scalssm = calssm.group(0);
                    logInfo.setPostDate(scalssm);
                }
                Matcher ipmatcher = patternIP.matcher(nextstr);
                while (ipmatcher.find()) {
                    String sipatcher = ipmatcher.group(0);
                    logInfo.setIp(sipatcher);
                }
                outPut.writeOut(logInfo);
            }
        }

    }
}
