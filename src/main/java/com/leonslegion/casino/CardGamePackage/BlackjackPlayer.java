package com.leonslegion.casino.CardGamePackage;

import com.leonslegion.casino.AccountPackage.Account;
import com.leonslegion.casino.InputHandler;
import org.apache.commons.lang3.math.NumberUtils;

public class BlackjackPlayer extends CardPlayer {

    public BlackjackPlayer(Account account) {
        super(account);
    }

    void hit(Card card) {
        hand.addCard(card);
    }

    void stay() {
        //nothing happens. not sure if this needs a method.
    }

    public String placeBet (String bet) {
        if (!NumberUtils.isParsable(bet)) {
            String newBet = InputHandler.getStringInput("That's not a valid bet.");
            return placeBet(newBet);
        }
        else if (Double.parseDouble(bet) < 0) {
            String newBet = InputHandler.getStringInput("You cannot make a negative bet!");
            return placeBet(newBet);
        }
        else if (getBalance() - Double.parseDouble(bet) < 0) {
            String newBet = InputHandler.getStringInput("Your bet is greater than your balance!");
            return placeBet(newBet);
        }
        else {
            return bet;
        }
    }
}