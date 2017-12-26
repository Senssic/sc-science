package com.sc.science.designmode.classsexpression.command;

/**
 * 具体命令角色 停止播放
 *
 * @author qiss
 */
public class StopCommand implements Command {
    private AudioPlayer myAudio;

    public StopCommand(AudioPlayer audioPlayer) {
        myAudio = audioPlayer;
    }

    @Override
    public void execute() {
        myAudio.stop();
    }

}