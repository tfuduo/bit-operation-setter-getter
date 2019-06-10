package com.github.hcsp.calculation;

public class Cat {
    private static int CUTE = 0x1;
    private static int FAT = 0x2;
    private static int WHITE = 0x4;
    private int properties = 0;

    // ↑ 请勿修改以上部分的代码
    // ↓ 请补全以下代码
    /**
     * 创建一只新的猫咪。
     *
     * @param cute 这只猫萌吗？萌为true，不萌为false
     * @param fat 这只猫胖吗？胖为true，不胖为false
     * @param white 这只猫白吗？白为true，不白为false
     */
    public Cat(boolean cute, boolean fat, boolean white) {
        // 请在此处根据cute/fat/white三个参数
        // 使用位运算对properties进行设值
        if (cute) {
            properties += CUTE;
        }
        if (fat) {
            properties += FAT;
        }
        if (white) {
            properties += WHITE;
        }
    }

    /**
     * 这只猫萌吗？
     *
     * @return 萌则返回true，否则返回false
     */
    public boolean isCute() {
        // 请在此处使用位运算读取properties，得到猫是否萌的结果
        return (properties >>  (int)getLog2(CUTE) & 1) != 0;
    }

    /**
     * 这只猫胖吗？
     *
     * @return 胖则返回true，否则返回false
     */
    public boolean isFat() {
        // 请在此处使用位运算读取properties，得到猫是否胖的结果
        return (properties >> (int)getLog2(FAT) & 1) != 0;
    }

    /**
     * 这只猫白吗？
     *
     * @return 白则返回true，否则返回false
     */
    public boolean isWhite() {
        // 请在此处使用位运算读取properties，得到猫是否白的结果
        return (properties >> (int)getLog2(WHITE) & 1) != 0;
    }

    public static void main(String[] args) {
        Cat cat = new Cat(true, false, true);
        System.out.println("这只猫萌吗：" + cat.isCute());
        System.out.println("这只猫胖吗：" + cat.isFat());
        System.out.println("这只猫白吗：" + cat.isWhite());
    }

    public double getLog2(double num) {
        return Math.log(num) / Math.log(2);
    }
}
