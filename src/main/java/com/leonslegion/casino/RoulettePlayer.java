package com.leonslegion.casino;

import java.util.ArrayList;
import org.apache.commons.lang3.*;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by markbrown on 5/9/17.
 */


public class RoulettePlayer extends Player {



    private ArrayList<RouletteBet> betList = new ArrayList<RouletteBet>();



    public RoulettePlayer (double balance, long accountId, ArrayList<RouletteBet> betList) {
        super(balance, accountId);
        this.betList = betList;
    }



    public ArrayList<RouletteBet> getBetList() {return betList;}



    public double placeBet (double bet) {
        if (super.getBalance() - bet < 0) {
            System.out.println("Bet greater than current Balance!");
        }
        setBalance(getBalance() - bet);
        return bet;
    }


    public String placeBet (String bet) {
        InputHandler inputHandler = new InputHandler();
        if (!NumberUtils.isParsable(bet)) {
            String newBet = inputHandler.getStringInput("That's not a valid bet.");
            return placeBet(newBet);
        }
        else if (super.getBalance() - Double.parseDouble(bet) < 0) {
            String newBet = inputHandler.getStringInput("Your bet is greater than your balance!");
            return placeBet(newBet);
        }
        super.setBalance(super.getBalance() - Double.parseDouble(bet));
        return bet;
    }



    public void makeRouletteBet (String betType, double betValue) {
        betList.add(new RouletteBet(betType, betValue));
    }



}
