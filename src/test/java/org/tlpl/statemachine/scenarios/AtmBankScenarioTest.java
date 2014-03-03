package org.tlpl.statemachine.scenarios;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.tlpl.statemachine.scenarios.statemachines.Atm;
import org.tlpl.statemachine.scenarios.statemachines.Bank;



public class AtmBankScenarioTest {

    private Atm atm;
    private Bank bank;

    @Before
    public void setUp() {

        bank = new Bank();
        atm = new Atm(bank);
        bank.setAtm(atm);

    }

    @Test
    public void atmTest() {
        bank.start();
        atm.start();
        Assert.assertTrue(bank.isInEndState());
        Assert.assertTrue(atm.isInEndState());
    }
}
