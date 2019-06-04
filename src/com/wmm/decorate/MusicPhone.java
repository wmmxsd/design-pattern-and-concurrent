package com.wmm.decorate;

public class MusicPhone extends PhoneDecorate{

    public MusicPhone(Phone phone) {
        super(phone);
    }

    // 定义想要扩展的功能
    public void listenMusic() {
        System.out.println("继续跑 带着赤子的骄傲，生命的闪耀不坚持到底怎能看到，与其苟延残喘不如纵情燃烧");
    }

    @Override
    public void call() {
        // 在打电话之前听音乐
        listenMusic();
        super.call();
    }
}
