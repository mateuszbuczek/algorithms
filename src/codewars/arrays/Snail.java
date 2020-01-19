package codewars.arrays;

import codewars.Assert;

import java.awt.*;
import java.util.Arrays;

public class Snail {

    public static void main(String[] args) {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};

        Assert.assertEquals(true, Arrays.equals(r, snail(array)));
        Assert.assertEquals(true, Arrays.equals(new int[0], snail(new int[0][0])));
    }

    public static int[] snail(int[][] array) {
        int[] res = new int[array.length * array.length];

        Data data = new Data();
        for (int i = 0; i < res.length; i++) {
            res[i] = array[data.point.y][data.point.x];
            data = getNext(array, data);
        }

        return res;
    }

    private static Data getNext(int[][] array, Data data) {
        Data result = null;

        switch (data.direction) {
            case RIGHT:
                result = data.point.x + 1 < array.length - data.shell
                        ? new Data(new Point(data.point.x + 1, data.point.y), Direction.RIGHT, data.shell)
                        : new Data(new Point(data.point.x, data.point.y + 1), Direction.DOWN, data.shell);
                break;
            case DOWN:
                result = data.point.y + 1 < array.length - data.shell
                        ? new Data(new Point(data.point.x, data.point.y + 1), Direction.DOWN, data.shell)
                        : new Data(new Point(data.point.x - 1, data.point.y), Direction.LEFT, data.shell);
                break;
            case LEFT:
                result = data.point.x - 1 >= data.shell
                        ? new Data(new Point(data.point.x - 1, data.point.y), Direction.LEFT, data.shell)
                        : new Data(new Point(data.point.x, data.point.y - 1), Direction.UP, data.shell);
                break;
            case UP:
                result = data.point.y - 1 > data.shell
                        ? new Data(new Point(data.point.x, data.point.y - 1), Direction.UP, data.shell)
                        : new Data(new Point(data.point.x + 1, data.point.y), Direction.RIGHT, data.shell + 1);
                break;
            default:
                throw new IllegalArgumentException("illegal state");
        }

        return result;
    }

    /*
    * Helper class that keeps information about current direction, point and shell (level of deepness)
    * */
    private static class Data {
        private Point point;
        private Direction direction;
        private int shell;

        public Data() {
            this.point = new Point(0, 0);
            this.direction = Direction.RIGHT;
            this.shell = 0;
        }

        public Data(Point point, Direction direction, int shell) {
            this.point = point;
            this.direction = direction;
            this.shell = shell;
        }
    }

    private enum Direction {
        RIGHT,
        DOWN,
        LEFT,
        UP
    }
}

//  https://www.codewars.com/kata/521c2db8ddc89b9b7a0000c1/train/java