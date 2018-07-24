package com.sc.science.designmode.classsexpression.command;

/**
 * 具体命令角色 倒带
 * @author qiss
 */
public class RewindCommand implements Command {

    private AudioPlayer myAudio;
    
    public RewindCommand(AudioPlayer audioPlayer){
        myAudio = audioPlayer;
    }
    @Override
    public void execute() {
        myAudio.rewind();
    }

}