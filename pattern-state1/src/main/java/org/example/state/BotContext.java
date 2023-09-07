package org.example.state;

public class BotContext {
    private State corruentState = new DisconnectedState();

    public String chat(String input) {
        if ("hello".equalsIgnoreCase(input)) {
            // 收到hello切换到在线状态:
            corruentState = new ConnectedState();
            return corruentState.init();
        } else if ("bye".equalsIgnoreCase(input)) {
            //  收到bye切换到离线状态:
            corruentState = new DisconnectedState();
            return corruentState.init();
        }
        return corruentState.reply(input);
    }
}
