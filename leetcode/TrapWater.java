package leetcode;

public class TrapWater {
    public static void main(String[] args) {
        System.out.println(new TrapWater().trap(new int []{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
    public int trap(int[] height) {
        int left = 0;
        int n = height.length;
        int lmax[] = new int[n];
        lmax[0] = height[0];
        for (int i = 1; i <= n - 1; i++) {
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }
        int rmax[] = new int[n];
        rmax[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            rmax[j] = Math.max(rmax[j + 1], height[j]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = ans + Math.min(rmax[i], lmax[i]) - height[i];
        }
        return ans;
    }
}
