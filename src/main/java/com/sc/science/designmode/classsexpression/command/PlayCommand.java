package com.sc.science.designmode.classsexpression.command;

/**
 * 具体命令角色 播放命令
 *
 * @author qiss
 */
public class PlayCommand implements Command {

    private AudioPlayer myAudio;

    public PlayCommand(AudioPlayer audioPlayer) {
        myAudio = audioPlayer;
    }

    /**
     * 执行方法
     */
    @Override
    public void execute() {
        myAudio.play();
    }

}