import java.util.Arrays;
import java.util.Objects;

public class CccMar23 {
    static FileHandler file;

    public static void main(String[] args) {
        level2();
    }

    private static void level3() {
        file = new FileHandler("level3_5");
        int rowFile = 0;
        int counts = Integer.parseInt(file.getList().get(rowFile));
        rowFile += 2;
        int tempRow = rowFile;
        int columnCount = file.getList().get(tempRow).length();
        int rowCount = 0;
        while (!Objects.equals(file.getList().get(rowFile), "")) {
            rowFile++;
            rowCount++;
        }
        rowFile = 2;
        for (int i = 0; i < counts; i++) {
            char[][] matrix = new char[rowCount][columnCount];
            Bee bee = new Bee();
            for (int row = 0; row < rowCount; row++) {
                String rowString = file.getList().get(rowFile);
                for (int col = 0; col < columnCount; col++) {
                    matrix[row][col] = rowString.charAt(col);
                    if (matrix[row][col] == 'W') {
                        bee.row = row;
                        bee.col = col;
                    }
                }
                rowFile++;
            }
            rowFile++;
            boolean result = isFree(bee, matrix);
            if (result) {
                file.append("FREE\n");
            } else {
                file.append("TRAPPED\n");
            }
        }
        file.write();
    }

    private static boolean isFree(Bee bee, char[][] matrix) {
        String rowS = Arrays.toString(matrix[bee.row]);
        String[] w = rowS.split("W");
        String left = w[0];
        String right = w[1];
        StringBuilder leftUp = new StringBuilder();
        StringBuilder rightUp = new StringBuilder();
        StringBuilder leftDown = new StringBuilder();
        StringBuilder rightDown = new StringBuilder();
        //
        if (bee.row == 0) {
            return true;
        }
        if (bee.row == matrix.length - 1) {
            return true;
        }
        if (bee.col == 0) {
            return true;
        }
        if (bee.col == 1) {
            return true;
        }
        if (bee.col == matrix[0].length - 1) {
            return true;
        }
        if (bee.col == matrix[0].length - 2) {
            return true;
        }
        if (!(left.contains("X"))) {
            return true;
        }
        if (!(right.contains("X"))) {
            return true;
        }
        ///
        int col = bee.col - 1;
        try {
            for (int row = bee.row - 1; row >= 0; row--) {
                leftUp.append(matrix[row][col]);
                col--;
            }
        } catch (Exception ignored) {
        }
        col = bee.col + 1;
        try {
            for (int row = bee.row - 1; row >= 0; row--) {
                rightUp.append(matrix[row][col]);
                col++;
            }
        } catch (Exception ignored) {
        }
        col = bee.col - 1;
        try {
            for (int row = bee.row + 1; row < matrix.length; row++) {
                leftDown.append(matrix[row][col]);
                col--;
            }
        } catch (Exception ignored) {
        }
        col = bee.col + 1;
        try {
            for (int row = bee.row + 1; row < matrix.length; row++) {
                rightDown.append(matrix[row][col]);
                col++;
            }
        } catch (Exception ignored) {
        }
        ///
        if (!(leftUp.toString().contains("X"))) {
            return true;
        }
        if (!(rightUp.toString().contains("X"))) {
            return true;
        }
        if (!(leftDown.toString().contains("X"))) {
            return true;
        }
        if (!(rightDown.toString().contains("X"))) {
            return true;
        }
        char[][] matrixNew = matrix.clone();
        matrixNew[bee.col][bee.row] = 'O';
        isFree(bee, matrix);
        return false;
    }

    private static void level2() {
        file = new FileHandler("level2_5");
        int rowFile = 0;
        int counts = Integer.parseInt(file.getList().get(rowFile));
        rowFile += 2;
        int tempRow = rowFile;
        int columnCount = file.getList().get(tempRow).length();
        int rowCount = 0;
        while (!Objects.equals(file.getList().get(rowFile), "")) {
            rowFile++;
            rowCount++;
        }
        rowFile = 2;
        int countEmpty;
        for (int i = 0; i < counts; i++) {
            countEmpty = 0;
            char[][] matrix = new char[rowCount][columnCount];
            Bee bee = new Bee();
            for (int row = 0; row < rowCount; row++) {
                String rowString = file.getList().get(rowFile);
                for (int col = 0; col < columnCount; col++) {
                    matrix[row][col] = rowString.charAt(col);
                    if (matrix[row][col] == 'W') {
                        bee.row = row;
                        bee.col = col;
                    }
                }
                rowFile++;
            }
            System.out.println(bee.row + " " + bee.col);
            rowFile++;
            try {
                if (matrix[bee.row][bee.col - 2] == 'O') {
                    countEmpty++;
                }
            } catch (Exception ignored) {
            }
            try {
                if (matrix[bee.row][bee.col + 2] == 'O') {
                    countEmpty++;
                }
            } catch (Exception ignored) {
            }
            try {
                if (matrix[bee.row - 1][bee.col + 1] == 'O') {
                    countEmpty++;
                }
            } catch (Exception ignored) {
            }
            try {
                if (matrix[bee.row - 1][bee.col - 1] == 'O') {
                    countEmpty++;
                }
            } catch (Exception ignored) {
            }
            try {
                if (matrix[bee.row + 1][bee.col + 1] == 'O') {
                    countEmpty++;
                }
            } catch (Exception ignored) {
            }
            try {
                if (matrix[bee.row + 1][bee.col - 1] == 'O') {
                    countEmpty++;
                }
            } catch (Exception ignored) {
            }
            file.append(String.valueOf(countEmpty) + "\n");
        }
        file.write();
    }

    private static void level1() {
        file = new FileHandler("level1_1");
        int count = 0;
        for (String line : file.getList()) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'O') {
                    count++;
                }
            }
        }
        file.append(String.valueOf(count));
        file.write();
    }
}

class Bee {
    public int row;
    public int col;

    public Bee() {
    }
}
