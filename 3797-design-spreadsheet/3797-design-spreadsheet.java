class Spreadsheet {

    int[][] grid;

    public Spreadsheet(int rows) {

        grid = new int[rows][26];

    }

    public void setCell(String cell, int value) {
        Character cols = cell.charAt(0);

        String rows = cell.substring(1, cell.length());

        int col = cols - 'A';
        int row = Integer.valueOf(rows);

        grid[row - 1][col] = value;

    }

    public void resetCell(String cell) {

        Character cols = cell.charAt(0);

        String rows = cell.substring(1, cell.length());

        int col = cols - 'A';
        int row = Integer.valueOf(rows);

        grid[row - 1][col] = 0;

    }

    public int getValue(String formula) {
        System.out.println(formula);
        String sub = formula.substring(1, formula.length());
        System.out.println(sub);

        String[] arr = sub.split("\\+");

        Character X = arr[0].charAt(0);
        Character Y = arr[1].charAt(0);

        if (Character.isDigit(X) && Character.isDigit(Y)) {
            return Integer.valueOf(arr[0]) + Integer.valueOf(arr[1]);
        } else if (Character.isLetter(X) && Character.isLetter(Y)) {
            Character cols1 = arr[0].charAt(0);

            String rows1 = arr[0].substring(1, arr[0].length());

            int col1 = cols1 - 'A';
            int row1 = Integer.valueOf(rows1);
          

            Character cols2 = arr[1].charAt(0);

            String rows2 = arr[1].substring(1, arr[1].length());

            int col2 = cols2 - 'A';
            int row2 = Integer.valueOf(rows2);

            return grid[row1 - 1][col1] + grid[row2 - 1][col2];

        } else if (Character.isLetter(X) && Character.isDigit(Y)) {
            Character cols1 = arr[0].charAt(0);

            String rows1 = arr[0].substring(1, arr[0].length());

            int col1 = cols1 - 'A';
            int row1 = Integer.valueOf(rows1);

            return grid[row1 - 1][col1] +Integer.valueOf(arr[1]);

        } else {

            Character cols2 = arr[1].charAt(0);

            String rows2 = arr[1].substring(1, arr[1].length());

            int col2 = cols2 - 'A';
            int row2 = Integer.valueOf(rows2);

            return grid[row2 - 1][col2] +  Integer.valueOf(arr[0]) ;

        }

    }

}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */