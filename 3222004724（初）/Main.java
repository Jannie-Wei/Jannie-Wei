// Main.java
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("请输入论文原文的文件的绝对路径：");
        String str1 = scan.nextLine();

        System.out.print("请输入抄袭版论文的文件的绝对路径：");
        String str2 = scan.nextLine();

        System.out.print("请输入要保存相似度结果的文件的绝对路径：");
        String outputFile = scan.nextLine();

        if (str1.length() == 0 || str2.length() == 0 || outputFile.length() == 0) {
            System.out.println("输入文件路径不能为空！");
            return;
        }

        DecimalFormat df = new DecimalFormat("0.00");
        SimilarityMain similar = new SimilarityMain(str1, str2);
        double similarity = similar.similarity();

        System.out.println("文章相似度为：" + df.format(similarity));

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("文章相似度为：" + df.format(similarity));
            System.out.println("相似度结果已保存至文件：" + outputFile);
        } catch (IOException e) {
            System.out.println("无法写入文件：" + e.getMessage());
        }
    }
}
