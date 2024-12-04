package greedyalgorithm;

import java.util.Arrays;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是满足尽可能多的孩子，并输出这个最大数值。
 */
public class Question455 {
    /**
     * 优先让胃口最小的孩子吃到能满足他胃口的最小饼干
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); //nlog(n)
        Arrays.sort(s); //nlog(n)
        int count = 0;
        outLoop:
        for (int k : g) {
            for (int j = 0; j < s.length; j++) {
                if (s[j] >= k) {
                    //找到第一个大于g[i]饼干，就是当前小孩能满足他胃口的最小饼干
                    count++;
                    s[j] = 0; //认为这个饼干吃掉了
                    continue outLoop;
                }
            }
        }
        return count;
    }

    //仅需一次遍历
    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g); //nlog(n)
        Arrays.sort(s); //nlog(n)
        int child = 0, cookie = 0;
        while (child < g.length && cookie < s.length) {  //n
            if (g[child] <= s[cookie]) {
                ++child;
            }
            cookie++;
        }
        return child;
    }
}
