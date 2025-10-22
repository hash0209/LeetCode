class Solution {
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {

        while (sx < tx && sy < ty) {
            if (tx < ty){
                ty %= tx;
            }
            else{
                tx %= ty;
            }
        }

        if (sx == tx && sy == ty) {
            return true;
        }

        if (sx == tx && ty > sy && (ty - sy) % tx == 0)
            return true;

        return (sy == ty && tx > sx && (tx - sx) % ty == 0);
    }

}