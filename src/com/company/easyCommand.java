package com.company;

import java.io.IOException;

public class easyCommand implements Command {
    Receiver receiver;

    public easyCommand(Receiver receiver) {
        this.receiver= receiver;
    }
    @Override
    public void execute() throws IOException {
      receiver.easy();
    }
}
