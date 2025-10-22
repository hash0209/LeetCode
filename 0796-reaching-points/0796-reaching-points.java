class Solution {
public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    if (sx > tx || sy > ty) return false;   // target smaller than start → impossible
    if (sx == tx && sy == ty) return true;  // reached start

    if (tx > ty) {
        if (ty == sy) {
            return (tx - sx) % ty == 0;     // last row can only decrease by multiples of ty
        }
        return reachingPoints(sx, sy, tx % ty, ty);
    } else {
        if (tx == sx) {
            return (ty - sy) % tx == 0;     // last column can only decrease by multiples of tx
        }
        return reachingPoints(sx, sy, tx, ty % tx);
    }
}


}