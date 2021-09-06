public class Main {

        public static int summa(String[][] table) throws MyArraySizeException, MyArrayDataException {
            table = new String[][]{{"0", "1", "2", "3"}, {"4", "5", "6", "7"}, {"8", "9", "0", "1"}, {"2", "3", "4", "5"}};

            if (table.length != 4) {
                throw new MyArraySizeException("Превышена длина массива");
            }

            int sum = 0;
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table[i].length; j++) {
                    try {
                        sum += Integer.parseInt(table[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Не число в элементе:" + i  + "," + j);
                    }
                }
            }
            return sum;
        }

        public static void main(String[] args) {

            String[][] strTable = {{"1", "2", "3", "4"}, {"5", "6", "7"}, {"9", "a0", "1", "2", "3", "4"}, {"5", "6", "7", "8", "9", "a0", "1"}};

            Integer[][] table = new Integer[4][];
            table[0] = new Integer[3];
            table[0] = new Integer[6];
            table[0] = new Integer[7];

            try {
                System.out.println(summa(strTable));
            } catch (MyArraySizeException | MyArrayDataException e) {
                e.printStackTrace();
            }
    }
}

