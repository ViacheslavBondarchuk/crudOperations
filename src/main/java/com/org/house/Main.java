package com.org.house;

import com.org.house.UI.Impl.WindowImpl;
import io.datakernel.launcher.Launcher;

public class Main extends Launcher {

    public static void main(String[] args) throws Exception {
        Launcher launcher = new Main();
        launcher.launch(args);
    }

    @Override
    protected void run() throws Exception {
        new WindowImpl("Crud operations", 400, 300).repaint(500);
    }
}
