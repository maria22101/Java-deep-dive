package concurrency.async;


import concurrency.async.utils.FileUtils;

public class StatsFromFilesGeneratorConsequent {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        FileUtils.getStatistic("src/main/resources/file1.csv", "src/main/resources/result1.csv");
        FileUtils.getStatistic("src/main/resources/file2.csv", "src/main/resources/result2.csv");
        FileUtils.getStatistic("src/main/resources/file3.csv", "src/main/resources/result3.csv");

        System.out.println("Time required to generate statistics: " +
                (System.currentTimeMillis() - start));

        // Time required to generate statistics in consequent execution is 8-9 ms
    }
}
