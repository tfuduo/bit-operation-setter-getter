package com.github.hcsp.calculation;

public class Cat {
    private static int CUTE = 0x1;
    private static int FAT = 0x2;
    private static int WHITE = 0x4;
    private int properties = 0;

    // ↑ 请勿修改以上部分的代码，请勿添加新的成员变量
    // ↓ 请补全以下代码

    /**
     * 思路：
     * 成员变量 CUTE/FAT/WHITE 应保持不变，是用来参与位运算的“砝码”
     * 设置时如果是 true，则 | 对应砝码；如果是 false，则先 & 自己，然后再 | 来修正其他两个值
     * 查询时则 & 相应砝码即可确认对应位的状态
     */

    /**
     * 使用位运算设置猫咪萌的属性
     *
     * @param cute true为萌，false为不萌
     */
    public void setCute(boolean cute) {
        // 只有 true 改为 false 或 false 改为 true 才有比较进行修改，其余两种情况当然是保持不变了（其他位同理）
        if(isCute() && !cute) {
            properties ^= Cat.CUTE; // 不影响其他位
        }
        if (!isCute() && cute) {
            properties |= Cat.CUTE; // 同样不会影响其他位
        }
    }

    /**
     * 这只猫萌吗？请在此处使用位运算读取properties，得到猫是否萌的结果
     *
     * @return 萌则返回true，否则返回false
     */
    public boolean isCute() {
        return (properties & Cat.CUTE) != 0;
    }

    /**
     * 使用位运算设置猫咪胖的属性
     *
     * @param fat true为胖，false为不胖
     */
    public void setFat(boolean fat) {
        if(isFat() && !fat) {
            properties ^= Cat.FAT;
        }
        if (!isFat() && fat) {
            properties |= Cat.FAT;
        }
    }

    /**
     * 这只猫胖吗？请在此处使用位运算读取properties，得到猫是否胖的结果
     *
     * @return 胖则返回true，否则返回false
     */
    public boolean isFat() {
        return (properties & Cat.FAT) != 0;
    }

    /**
     * 使用位运算设置猫咪白的属性
     *
     * @param white true为白，false为不白
     */
    public void setWhite(boolean white) {
        if(isWhite() && !white) {
            properties ^= Cat.WHITE;
        }
        if (!isWhite() && white) {
            properties |= Cat.WHITE;
        }
        System.out.println(properties + "finally");
    }

    /**
     * 这只猫白吗？请在此处使用位运算读取properties，得到猫是否白的结果
     *
     * @return 白则返回true，否则返回false
     */
    public boolean isWhite() {
        return (properties & Cat.WHITE) != 0;
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setCute(true);
        cat.setFat(true);
        cat.setWhite(false);
        System.out.println("这只猫萌吗：" + cat.isCute());
        System.out.println("这只猫胖吗：" + cat.isFat());
        System.out.println("这只猫白吗：" + cat.isWhite());
    }
}
