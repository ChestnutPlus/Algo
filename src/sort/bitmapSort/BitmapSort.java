package sort.bitmapSort;

/**
 * <pre>
 *     author: Chestnut
 *     blog  : http://www.jianshu.com/u/a0206b5f4526
 *     time  : 2018/6/27 15:30
 *     desc  : 位图排序示例
 *     thanks To:
 *     dependent on:
 *     update log:
 * </pre>
 */
public class BitmapSort {

    public static void main(String[] args) {
        int[] a = {4,7,2,5,0,14,3,8,12};
        int[] end = bitmapSort(a, 14);

        for (int x : end) {
            System.out.print(x+",");
        }
    }

    /**
     * 位图排序
     * @param arr 数组
     * @param theMax 最大值
     * @return 排序好的数组
     */
    public static int[] bitmapSort(int[] arr, int theMax) {
        if (arr==null || arr.length==0)
            return null;
        BitArr bitArr = new BitArr(theMax+1);
        for (int anArr : arr) {
            bitArr.mark(anArr);
        }
        int[] result = new int[arr.length];
        byte[] bytes = bitArr.getBytes();
        int index = 0;
        for (int i = 0; i < bytes.length; i++) {
            for (int j = 0; j < 7; j++) {
                byte temp = (byte) (1<<6-j);
                byte b = (byte) (bytes[i] & temp);
                if ( b == temp) {
                    result[index++] = i*7 + j;
                }
            }
        }
        return result;
    }

    /**
     * 这里，先实现一个位数组的数据结构
     */
    public static class BitArr {
        private int bitLength = 0;
        private byte[] bytes;

        public byte[] getBytes() {
            return bytes;
        }

        /**
         * 构建多少位的位数组
         * @param bitLength 位长
         */
        public BitArr(int bitLength) {
            this.bitLength = bitLength;
            bytes = new byte[(int) Math.ceil((double) bitLength/7)];
        }

        /**
         * 标记某一个位
         * 设置为1
         * @param position 位
         */
        public void mark(int position) {
            if (position>bitLength)
                return;
            int arrIndex = position/7;
            int bitIndex = position%7;
            bytes[arrIndex] |= (1 << (6-bitIndex));
        }

        public void cleanMark(int position) {
            if (position>bitLength)
                return;
            int arrIndex = position/7;
            int bitIndex = position%7;
            bytes[arrIndex] &= ~(1 << (6-bitIndex));
        }

        public void printAllBit() {
            for (byte aByte : bytes) {
                System.out.print(BitArr.Byte2String(aByte));
            }
            System.out.println();
        }

        /**
         * 打印除符号位的 byte
         * @param nByte
         * @return
         */
        private static String Byte2String(byte nByte){
            StringBuilder nStr=new StringBuilder();
            for(int i=6;i>=0;i--) {
                int j=(int)nByte & (int)(Math.pow(2, (double)i));
                if(j>0){
                    nStr.append("1");
                }else {
                    nStr.append("0");
                }
            }
            return nStr.toString();
        }
    }
}
