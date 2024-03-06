package com.wang.p5_writer;

import java.io.*;

/**
 * @Author:wsz
 * @Date: 2023/2/8 21:31
 * @Description:Buffered拷贝文件
 */
public class Demo03BufferedCopy {
    public static void main(String[] args) {
        String source = "e:\\a.txt";
        String target = "e:\\t.txt";
        String line;
        //BufferedReader,BufferedWriter操作的字符文件，如果读取二进制文件，可能会损坏文件
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(source)); BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(target))) {
            while ((line = bufferedReader.readLine()) != null) {
                //readLine读取一行 没有换行符
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                //BufferedWriter 类在 Java 中用于处理字符输出流，它提供了缓冲机制以提高写入数据的效率。
                // 当通过 BufferedWriter 将文本内容写入文件或输出流时，默认情况下这些内容并不会立即被物理写入到目标设备，而是先存储在内部缓冲区中，等到缓冲区满或者手动调用 flush() 方法时，才会将缓冲区的内容一次性刷新到底层的输出流。
                //因此，如果你希望确保缓冲区中的内容立即被写出，例如在写入关键数据后需要确保数据持久化，或者在程序结束前必须强制完成所有写入操作，这
                //时就需要调用 BufferedWriter 的 flush() 方法。在 Java 的 BufferedWriter 类中，当你调用 close() 方法时，它会确保缓冲区中的所有数据都被刷新并写入到目标输出流中，
                // 然后再关闭底层资源。这意味着在关闭 BufferedWriter 之前，即使你没有显式调用 flush() 方法，系统也会自动进行 flush 操作。
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
