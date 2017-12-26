package com.sc.science.designmode.classsexpression.command;

/**
 * 接受角色 负责具体实施和执行命令的角色
 *
 * @author qiss
 */
public class AudioPlayer {

    public void play() {
        System.out.println("播放...");
    }

    public void rewind() {
        System.out.println("倒带...");
    }

    public void stop() {
        System.out.println("停止...");
    }
}