package com.company;

import java.io.IOException;

public class hardCommand implements Command {
    Receiver receiver;

    public hardCommand(Receiver receiver) {
        this.receiver= receiver;
    }
    @Override
    public void execute() throws IOException {
      receiver.hard();
    }
}
