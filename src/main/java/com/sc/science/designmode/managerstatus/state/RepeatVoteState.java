package com.sc.science.designmode.managerstatus.state;

/**
 * 重复投票状态
 *
 * @author qiss
 */
public class RepeatVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        //重复投票，暂时不做处理
        System.out.println("请不要重复投票");
    }

}