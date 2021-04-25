import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=874 lang=java
 *
 * [874] 模拟行走机器人
 */

// @lc code=start
class Solution {
    // 遍历搜索障碍物肯定会超时
    // 大多数解法都是走一步看一步，写起来简单
    public int searchnext(ArrayList<Integer> list, int num) {
        int hi = list.size(), lo = 0;
        while (lo < hi) {
            int mi = (lo + hi) >> 1;
            if (num < list.get(mi)) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return lo;
    }

    public int searchprev(ArrayList<Integer> list, int num) {
        int hi = list.size(), lo = 0;
        while (lo < hi) {
            int mi = (lo + hi) >> 1;
            if (num > list.get(mi)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo - 1;
    }

    public int robotSim(int[] commands, int[][] obstacles) {
        int max = 0, x = 0, y = 0, dir = 0;
        HashMap<Integer, ArrayList<Integer>> xmap = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> ymap = new HashMap<>();
        int obs = obstacles.length;
        for (int i = 0; i < obs; ++i) {
            if (!xmap.containsKey(obstacles[i][0])) {
                xmap.put(obstacles[i][0], new ArrayList<>());
            }
            xmap.get(obstacles[i][0]).add(obstacles[i][1]);
            if (!ymap.containsKey(obstacles[i][1])) {
                ymap.put(obstacles[i][1], new ArrayList<>());
            }
            ymap.get(obstacles[i][1]).add(obstacles[i][0]);
        }
        for (ArrayList<Integer> list : xmap.values()) {
            list.sort(null);
        }
        for (ArrayList<Integer> list : ymap.values()) {
            list.sort(null);
        }
        int n = commands.length;
        for (int i = 0; i < n; ++i) {
            if (commands[i] == -1) {
                dir = (dir + 1) % 4;
            } else if (commands[i] == -2) {
                dir = (dir + 3) % 4;
            } else {
                switch (dir) {
                    case 0:
                    y += commands[i];
                    if (xmap.containsKey(x)) {
                        ArrayList<Integer> obsList = xmap.get(x);
                        int post = searchnext(obsList, y - commands[i]);
                        if (post < obsList.size() && obsList.get(post) <= y) {
                            y = obsList.get(post) - 1;
                        }
                    }
                    break;
                    case 1:
                    x += commands[i];
                    if (ymap.containsKey(y)) {
                        ArrayList<Integer> obsList = ymap.get(y);
                        int post = searchnext(obsList, x - commands[i]);
                        if (post < obsList.size() && obsList.get(post) <= x) {
                            x = obsList.get(post) - 1;
                        }
                    }
                    break;
                    case 2:
                    y -= commands[i];
                    if (xmap.containsKey(x)) {
                        ArrayList<Integer> obsList = xmap.get(x);
                        int post = searchprev(obsList, y + commands[i]);
                        if (post >= 0 && obsList.get(post) >= y) {
                            y = obsList.get(post) + 1;
                        }
                    }
                    break;
                    case 3:
                    x -= commands[i];
                    if (ymap.containsKey(y)) {
                        ArrayList<Integer> obsList = ymap.get(y);
                        int post = searchprev(obsList, x + commands[i]);
                        if (post >= 0 && obsList.get(post) >= x) {
                            x = obsList.get(post) + 1;
                        }
                    }
                    break;
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }
}
// @lc code=end

