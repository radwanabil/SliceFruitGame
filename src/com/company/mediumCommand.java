package com.company;

import java.io.IOException;

public class mediumCommand implements  Command {
    Receiver receiver;

    public mediumCommand(Receiver receiver) {
        this.receiver= receiver;
    }
    @Override
    public void execute() throws IOException {
     receiver.medium();
    }
}
