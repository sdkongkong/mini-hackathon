public class MinimumSum {

    public static int minimumSum(Range[] ranges) {
        if (ranges == null || ranges.length < 2) return 0;
        int total = 0;
        int smallestTo = ranges[0].to;
        int largetFrom = ranges[0].from;

        for (Range range : ranges) {
            smallestTo = Math.min(smallestTo, range.to);
            largetFrom = Math.max(largetFrom, range.from);
        }
        total = largetFrom - smallestTo;
        if (total < 0)
            return 0;
        else
            return total;
    }


    public static void main(String[] args) {
        // one example:
        Range range1 = new Range(1, 3);
        Range range2 = new Range(1, 4);
        Range range3 = new Range(4, 7);

        System.out.printf("The minimum total is: %d", minimumSum(new Range[]{range1, range2, range3}));

    }

    public static class Range {
        private int from;
        private int to;

        public Range(int from, int to) {
            this.from = from;
            this.to = to;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public void setTo(int to) {
            this.to = to;
        }
    }

}
