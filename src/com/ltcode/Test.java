package com.ltcode;

import javax.swing.tree.TreeNode;

public class Test {

    public static void main(String[] args) {
        final int x = 3;
        final int i = x;
        char ch = i;

        System.out.println(x);
        System.out.println(ch);
    }
}


class Bird {
    public void canFly() {
        System.out.println("Can fly");
    }
}

class AnotherBird extends Bird {

}

class NoFlyableBird extends AnotherBird {
    public static void main(String[] args) {
        Bird bird = new NoFlyableBird();
        bird.canFly();

    }

    @Override
    public void canFly() {
        System.out.print("My superclass respond: ");
        super.canFly();
        System.out.println("Can not fly");
    }
}

