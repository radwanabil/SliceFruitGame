package com.company;

public class User {
    private static User user;
    private User()
    {
    }
    public static User getUser()
    {
        if(user == null)
            user = new User();
        return user;
    }
    void newGame(StrategyInterface level)
    {}
}
