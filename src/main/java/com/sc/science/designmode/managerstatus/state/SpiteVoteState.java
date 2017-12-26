package com.sc.science.designmode.managerstatus.state;

/**
 * 恶意投票状态
 *
 * @author qiss
 */
public class SpiteVoteState implements VoteState {

    @Override
    public void vote(String user, String voteItem, VoteManager voteManager) {
        // 恶意投票，取消用户的投票资格，并取消投票记录
        String str = voteManager.getMapVote().get(user);
        if (str != null) {
            voteManager.getMapVote().remove(user);//取消投票
        }
        System.out.println("你有恶意刷屏行为，取消投票资格");
    }

}