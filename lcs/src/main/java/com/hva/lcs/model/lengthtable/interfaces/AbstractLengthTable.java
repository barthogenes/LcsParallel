package com.hva.lcs.model.lengthtable.interfaces;

import com.hva.lcs.model.Slice;
import com.hva.lcs.model.TablePoint;

import java.util.ArrayList;

public abstract class AbstractLengthTable implements ILengthTable {

    protected String a;
    protected String b;

    public AbstractLengthTable() {

    }

    public void setStrings(String a, String b) {
        this.a = a;
        this.b = b;
        initTable();
        clearTable();
    }

    protected abstract void initTable();

    public void clearTable() {
        // Fill everything except the first row and column with -1
        for (int column = 1; column < getColumnCount(); column++) {
            for (int row = 1; row < getRowCount(); row++) {
                set(column, row, -1);
            }
        }
    }

    public ArrayList<Slice>  getDiagonalPoints() {
       ArrayList<Slice> diag = new ArrayList<Slice>();

        int rows = getRowCount();
        int columns = getColumnCount();

        for (int slice = 0; slice < rows + columns - 1; ++slice) {
            diag.add(new Slice());
            //System.out.printf("Slice %d: ", slice);
            int z1 = slice < columns ? 0 : slice - columns+ 1;
            int z2 = slice < rows ? 0 : slice - rows + 1;
            for (int j = slice - z2; j >= z1; --j) {
                if ( get(slice - j, j) != 0) {
                    diag.get(slice).add(new TablePoint(slice - j, j));
                }
                //System.out.printf("%d ", get(slice - j, j));
            }
            //System.out.printf("\n");
        }
        //System.out.println();
        return diag;
    }

    public abstract void set(int x, int y, int value);

    public abstract int get(int x, int y);

    public char[] getCharacters(int column, int row) {
        return new char[] { a.charAt(column-1), b.charAt(row-1) };
    }

    public int getRowCount() {
        return b.length()+1;
    }

    public int getColumnCount() {
        return a.length()+1;
    }

    public String getStringA() {
        return this.a;
    }

    public String getStringB() {
        return this.b;
    }

    public abstract void setTable(int[][] table);

    @Override
    public String toString() {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();

        String hSeperator = "----";
        for (int i = 0; i < a.length() + 1; i++) {
            hSeperator += "----";
        }
        hSeperator += "\n";

        String table = "  | ";
        table += "  | ";
        for (char letter : arrayA) {
            table += letter + " | ";
        }

        table += "\n";
        table += hSeperator;
        table += "  | ";

        for (int i = 0; i < arrayA.length + 1; i++) {
            table += get(i, 0) + " | ";
        }
        table += "\n";


        for (int i = 0; i < arrayB.length; i++) {
            table += hSeperator;
            table += arrayB[i] + " | ";
            for (int j = 0; j < arrayA.length + 1; j++) {
                if (get(j, i + 1) == -1) {
                    table += +get(j, i + 1) + "| ";
                } else {
                    table += +get(j, i + 1) + " | ";
                }
            }
            table += "\n";
        }

        return table;
    }

    public String readLcsLeftUp(boolean upLeft) {
        StringBuffer sb = new StringBuffer();
        for (int x = a.length(), y = b.length();
             x != 0 && y != 0; ) {
            if (upLeft) {
                if (get(x, y) == get(x, y - 1))
                    y--;
                else if (get(x, y) == get(x - 1, y))
                    x--;
                else {
                    assert a.charAt(x - 1) == b.charAt(y - 1);
                    sb.append(a.charAt(x - 1));
                    x--;
                    y--;
                }
            } else {
                if (get(x, y) == get(x - 1, y))
                    x--;
                else if (get(x, y) == get(x, y - 1))
                    y--;
                else {
                    assert a.charAt(x - 1) == b.charAt(y - 1);
                    sb.append(a.charAt(x - 1));
                    x--;
                    y--;
                }
            }

        }
        return sb.reverse().toString();
    }

}
