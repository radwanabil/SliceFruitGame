package com.company;

import java.io.IOException;

public class MenuOptions {
    Command easyCommand;
    Command mediumCommand;
    Command hardCommand;
    public MenuOptions(Command easyCommand,Command mediumCommand,Command hardCommand ) {
        this.easyCommand=easyCommand;
        this.mediumCommand=mediumCommand;
        this.hardCommand=hardCommand;
    }
    public void clickEasy() throws IOException {
        easyCommand.execute();
    }
    public void clickMedium() throws IOException {
        mediumCommand.execute();
    }
    public void clickHard() throws IOException {
        hardCommand.execute();
    }
}
