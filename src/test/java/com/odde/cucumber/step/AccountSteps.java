package com.odde.cucumber.step;

import com.odde.cucumber.api.Api;
import com.odde.cucumber.api.dto.Account;
import com.odde.cucumber.page.Ui;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountSteps {

    @Autowired
    private Api api;

    @Autowired
    private Ui ui;

    @When("list accounts")
    public void findAccountWithNameAndBalance() {
        ui.open("http://localhost:8100/#/accounts");
        ui.maximize();
//        try {
//            Thread.sleep(3000);
//        } catch (Exception e) {
//
//        }
    }

    @Given("create account with name {string} and balance {int}")
    public void createAccountWithNameAndBalance(String name, int balance) {
        api.addAccount(new Account(name, balance));
    }

    @Then("verify account success with name {string} and balance {int}")
    public void verify_success(String name, int balance) {
        ui.assertHaveText(name);
        ui.assertHaveText(String.valueOf(balance));
    }

}
